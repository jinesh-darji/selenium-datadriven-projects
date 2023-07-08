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
		title("PREPARE THE CRUD OPERATION OF THE LENDERS MODULE");

		Helper helper = new Helper();

		// refresh the page
		driver.navigate().refresh();
		Thread.sleep(5000);
		driver.navigate().refresh();

		// ADD LENDERS
		title("ADD LENDERS");

		try {
			// click on the property project icon from the property list page
			click("propertyproject_icon_CSS");

			// wait for the element
			explicitWaitClickable("menubtn_CSS");

			// click on the burger menu
			click("menubtn_CSS");

			// wait for the element
			Thread.sleep(5000);

			// click on the LENDERS
			click("propertyproject_lendersoption_XPATH");

			// ADD RECORD - LENDERS
			title("ADD RECORD - LENDERS");

			// click on the add button
			click("propertyproject_le_addlendersbtn_CSS");

			// enter the lender name
			type("propertyproject_le_lendersnametxt_CSS", data.get("lender_name"));

			// enter the address 1
			type("propertyproject_le_addressLine1txt_CSS", data.get("address1"));

			// enter the address 2
			type("propertyproject_le_addressLine2txt_CSS", data.get("address2"));

			// enter the city
			type("propertyproject_le_citytxt_CSS", data.get("city"));

			// enter the province
			type("propertyproject_le_provincetxt_CSS", data.get("province"));

			// enter the country
			type("propertyproject_le_countrytxt_CSS", data.get("country"));

			// enter the postal code
			type("propertyproject_le_postalcodetxt_CSS", data.get("postal_code"));

			// click on the save button
			click("propertyproject_le_savebtn_CSS");

			// wait for the element
			explicitWait("propertyproject_le_filtertxt_CSS");

			// enter the lender name
			type("propertyproject_co_filtertxt_CSS", data.get("lender_name"));

			// verification of the lender is added or not
			switchVerification("propertyproject_le_addedlender_XPATH", "Lender Testing Name",
					"The Lender Testing Name is not displayed successfully.");

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

			// VERIFY NEWLY CREATED LENDER IS DISPLAYED OR NOT IN THE MORTGAGE UNDERTAKINGS
			title("VERIFY NEWLY CREATED LENDER IS DISPLAYED OR NOT IN THE MORTGAGE UNDERTAKINGS");

			// click on the add button
			click("propertyproject_mu_addbtn_CSS");

			try {
				select("propertyproject_mu_lenderdd_CSS", data.get("lender_name"));

				successMessage(
						"New created lender is displayed successfully while creating the MORTGAGE UNDERTAKINGS.");

			} catch (Throwable t) {

				verificationFailedMessage(
						"New created lender is not displayed while creating the MORTGAGE UNDERTAKINGS.");
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

		// UPDATE THE LENDER
		title("UPDATE THE LENDER");

		try {

			// click on the property project icon from the property list page
			click("propertyproject_icon_CSS");

			// wait for the element
			explicitWaitClickable("menubtn_CSS");

			// click on the burger menu
			click("menubtn_CSS");

			// wait for the element
			Thread.sleep(5000);

			// click on the LENDERS
			click("propertyproject_lendersoption_XPATH");

			// click on the newly created lender
			click("propertyproject_le_addedlender_XPATH");

			// enter the lender name
			type("propertyproject_le_lendersnametxt_CSS", data.get("update_lender_name"));

			// wait for the element
			explicitWaitClickable("propertyproject_le_updatebtn_CSS");

			// click on the update button
			click("propertyproject_le_updatebtn_CSS");

			// wait for the element
			explicitWaitClickable("propertyproject_le_filtertxt_CSS");

			// enter the lender name
			type("propertyproject_co_filtertxt_CSS", data.get("update_lender_name"));

			// verification of the lender is updated or not
			switchVerification("propertyproject_le_updatedlender_XPATH", "Update Lender Testing Name",
					"The Update Lender Testing Name is not displayed successfully.");

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

			// VERIFY UPDATED LENDER IS DISPLAYED OR NOT IN THE MORTGAGE UNDERTAKINGS
			title("VERIFY UPDATED LENDER IS DISPLAYED OR NOT IN THE MORTGAGE UNDERTAKINGS");

			// click on the add button
			click("propertyproject_mu_addbtn_CSS");

			try {
				select("propertyproject_mu_lenderdd_CSS", data.get("update_lender_name"));

				successMessage("Updated lender is displayed successfully while creating the MORTGAGE UNDERTAKINGS.");

			} catch (Throwable t) {
				verificationFailedMessage("Updated lender is not displayed while creating the MORTGAGE UNDERTAKINGS.");
			}

			// click on the home icon from the top of the screen
			click("questionnaire_homeburgermenubtn_hide_CSS");

			// wait for the element
			explicitWait("propertylist_title_XPATH");

			// verify the property list
			switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		} catch (Throwable t) {
			verificationFailed();
		}

		// DELETE THE LENDER
		title("DELETE THE LENDER");

		try {

			// click on the property project icon from the property list page
			click("propertyproject_icon_CSS");

			// wait for the element
			explicitWaitClickable("menubtn_CSS");

			// click on the burger menu
			click("menubtn_CSS");

			// wait for the element
			Thread.sleep(5000);

			// click on the LENDERS
			click("propertyproject_lendersoption_XPATH");

			// enter the updated lender in the filter field
			type("propertyproject_le_filtertxt_CSS", data.get("update_lender_name"));

			// wait for the element
			explicitWaitClickable("propertyproject_le_deletebtn_CSS");

			// click on the delete button
			click("propertyproject_le_deletebtn_CSS");

			// wait for the element
			explicitWaitClickable("propertyproject_le_confirmationdeletebtn_CSS");

			// click on the delete button of the confirmation popup
			click("propertyproject_le_confirmationdeletebtn_CSS");

			// wait for the element
			explicitWaitClickable("closetoastmsg_CSS");

			// click on the toaster close button
			click("closetoastmsg_CSS");

			// enter the updated lender in the filter field
			type("propertyproject_le_filtertxt_CSS", data.get("update_lender_name"));

			// verify lender is deleted or not
			helper.deleteVerification("propertyproject_le_updatedlender_XPATH", "Update Lender Testing Name");

		} catch (Throwable t) {
			verificationFailed();
		}

		// click on the home icon from the top of the screen
		click("questionnaire_homeburgermenubtn_hide_CSS");

		// wait for the element
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// VERIFY DELETED LENDER IS DISPLAYED OR NOT IN THE MORTGAGE UNDERTAKINGS
		title("VERIFY DELETED LENDER IS DISPLAYED OR NOT IN THE MORTGAGE UNDERTAKINGS");

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

			try {
				select("propertyproject_mu_lenderdd_CSS", data.get("update_lender_name"));

				verificationFailedMessage(
						"Deleted lender is not displayed while creating the MORTGAGE UNDERTAKINGS as expected.");

			} catch (Throwable t) {
				successMessage("Deleted lender is displayed successfully while creating the MORTGAGE UNDERTAKINGS.");

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

	}

}