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
		title("PREPARE THE CRUD OPERATION OF THE ENGINEERING COMPANIES MODULE.");

		Helper helper = new Helper();

		// refresh the page
		driver.navigate().refresh();
		Thread.sleep(5000);
		driver.navigate().refresh();

		// ADD ENGINEERING COMPANIES
		title("ADD ENGINEERING COMPANIES");

		try {
			// click on the property project icon from the property list page
			click("propertyproject_icon_CSS");

			// wait for the element
			explicitWaitClickable("menubtn_CSS");

			// click on the burger menu
			click("menubtn_CSS");

			// wait for the element
			Thread.sleep(5000);

			// click on the ENGINEERING COMPANIES
			click("propertyproject_engineeringcompaniesoption_XPATH");

			// ADD RECORD - ENGINEERING COMPANIES
			title("ADD RECORD - ENGINEERING COMPANIES");

			// click on the add button
			click("propertyproject_ec_addengineeringcompaniesbtn_CSS");

			/// enter the company name
			type("propertyproject_ec_companynametxt_CSS", data.get("company_name"));

			// enter the address 1
			type("propertyproject_ec_addressLine1txt_CSS", data.get("address1"));

			// enter the address 2
			type("propertyproject_ec_addressLine2txt_CSS", data.get("address2"));

			// enter the city
			type("propertyproject_ec_citytxt_CSS", data.get("city"));

			// enter the province
			type("propertyproject_ec_provincetxt_CSS", data.get("province"));

			// enter the country
			type("propertyproject_ec_countrytxt_CSS", data.get("country"));

			// enter the postal code
			type("propertyproject_ec_postalcodetxt_CSS", "92879");

			// click on the save button
			click("propertyproject_ec_savebtn_CSS");

			// wait for the element
			explicitWait("propertyproject_ec_filtertxt_CSS");

			// enter the company name
			type("propertyproject_ec_filtertxt_CSS", data.get("company_name"));

			// verification of the is added or not
			switchVerification("propertyproject_ec_addedcompany_XPATH", "Company Testing Name",
					"The Company Testing Name is not displayed successfully.");

			// click on the home icon from the top of the screen
			click("questionnaire_homeburgermenubtn_hide_CSS");

			// wait for the element
			explicitWait("propertylist_title_XPATH");

			// verify the property list
			switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

			// VERIFY NEWLY CREATED COMPANY IS DISPLAYED OR NOT IN THE CAPEX PROJECTS
			title("VERIFY NEWLY CREATED COMPANY IS DISPLAYED OR NOT IN THE CAPEX PROJECTS");

			// click on the property project icon from the property list page
			click("propertyproject_icon_CSS");

			// wait for the element
			explicitWaitClickable("menubtn_CSS");

			// click on the burger menu
			click("menubtn_CSS");

			// wait for the element
			Thread.sleep(5000);

			// click on the CAPEX Project
			click("propertyproject_capexprojectsoption_XPATH");

			// click on the add button
			click("propertyproject_mu_addbtn_CSS");

			try {

				// select the engineering company
				select("propertyproject_cp_engineeringcompanydd_CSS", data.get("company_name"));

				successMessage(
						"New created engineering companies is displayed successfully while creating the CAPEX Projects.");
			} catch (Throwable t) {

				verificationFailedMessage(
						"New created engineering companies is not displayed while creating the CAPEX Projects.");
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

		// UPDATE THE DETAILS OF THE ENGINEERING COMPANIES
		title("UPDATE THE DETAILS OF THE ENGINEERING COMPANIES");

		try {

			// click on the property project icon from the property list page
			click("propertyproject_icon_CSS");

			// wait for the element
			explicitWaitClickable("menubtn_CSS");

			// click on the burger menu
			click("menubtn_CSS");

			// wait for the element
			Thread.sleep(5000);

			// click on the ENGINEERING COMPANIES
			click("propertyproject_engineeringcompaniesoption_XPATH");

			// enter the company name
			type("propertyproject_ec_filtertxt_CSS", data.get("company_name"));

			// click on the newly created company
			click("propertyproject_ec_addedcompany_XPATH");

			// enter the company name
			type("propertyproject_ec_companynametxt_CSS", data.get("update_company_name"));

			// wait for the element
			explicitWaitClickable("propertyproject_ec_updatebtn_CSS");

			// click on the update button
			click("propertyproject_ec_updatebtn_CSS");

			// wait for the element
			explicitWaitClickable("propertyproject_ec_filtertxt_CSS");

			// enter the company name
			type("propertyproject_ec_filtertxt_CSS", data.get("update_company_name"));

			// verification of the company is updated or not
			switchVerification("propertyproject_ec_updatedcompany_XPATH", "Update Company Testing Name",
					"The Update Company Testing Name is not displayed successfully.");

			// click on the home icon from the top of the screen
			click("questionnaire_homeburgermenubtn_hide_CSS");

			// wait for the element
			explicitWait("propertylist_title_XPATH");

			// verify the property list
			switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

			// VERIFY UPDATED COMPANY IS DISPLAYED OR NOT IN THE CAPEX PROJECTS
			title("VERIFY UPDATED COMPANY IS DISPLAYED OR NOT IN THE CAPEX PROJECTS");

			// click on the property project icon from the property list page
			click("propertyproject_icon_CSS");

			// wait for the element
			explicitWaitClickable("menubtn_CSS");

			// click on the burger menu
			click("menubtn_CSS");

			// wait for the element
			Thread.sleep(5000);

			// click on the CAPEX Project
			click("propertyproject_capexprojectsoption_XPATH");

			// click on the add button
			click("propertyproject_mu_addbtn_CSS");

			try {

				// select the engineering company
				select("propertyproject_cp_engineeringcompanydd_CSS", data.get("update_company_name"));

				successMessage(
						"Updated engineering companies is displayed successfully while creating the CAPEX Projects.");

			} catch (Throwable t) {

				verificationFailedMessage(
						"Updated engineering companies is not displayed while creating the CAPEX Projects.");
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

		// DELETE THE ENGINEERING COMPANIES
		title("DELETE THE ENGINEERING COMPANIES");

		try {

			// click on the property project icon from the property list page
			click("propertyproject_icon_CSS");

			// wait for the element
			explicitWaitClickable("menubtn_CSS");

			// click on the burger menu
			click("menubtn_CSS");

			// wait for the element
			Thread.sleep(5000);

			// click on the engineering companies
			click("propertyproject_engineeringcompaniesoption_XPATH");

			// wait for the element
			explicitWait("propertyproject_ec_filtertxt_CSS");

			// enter the updated company in the filter field
			type("propertyproject_ec_filtertxt_CSS", data.get("update_company_name"));

			// wait for the element
			explicitWaitClickable("propertyproject_ec_deletebtn_CSS");

			// click on the delete button
			click("propertyproject_ec_deletebtn_CSS");

			// wait for the element
			explicitWaitClickable("propertyproject_ec_confirmationdeletebtn_CSS");

			// click on the delete button of the confirmation popup
			click("propertyproject_ec_confirmationdeletebtn_CSS");

			// wait for the element
			explicitWaitClickable("closetoastmsg_CSS");

			// click on the toaster close button
			click("closetoastmsg_CSS");

			// wait for the element
			explicitWaitClickable("propertyproject_ec_filtertxt_CSS");

			// enter the deleted company in the filter field
			type("propertyproject_ec_filtertxt_CSS", data.get("update_company_name"));

			// verify company is deleted or not
			helper.deleteVerification("propertyproject_ec_updatedcompany_XPATH", "Update Company Testing Name");

		} catch (Throwable t) {
			verificationFailed();
		}

		// click on the home icon from the top of the screen
		click("questionnaire_homeburgermenubtn_hide_CSS");

		// wait for the element
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// VERIFY DELETED COMPANY IS DISPLAYED OR NOT IN THE CAPEX PROJECTS
		title("VERIFY DELETED COMPANY IS DISPLAYED OR NOT IN THE CAPEX PROJECTS");

		try {

			// click on the property project icon from the property list page
			click("propertyproject_icon_CSS");

			// wait for the element
			explicitWaitClickable("menubtn_CSS");

			// click on the burger menu
			click("menubtn_CSS");

			// wait for the element
			Thread.sleep(5000);

			// click on the CAPEX Project
			click("propertyproject_capexprojectsoption_XPATH");

			// click on the add button
			click("propertyproject_mu_addbtn_CSS");

			try {

				// select the engineering company
				select("propertyproject_cp_engineeringcompanydd_CSS", data.get("update_company_name"));

				verificationFailedMessage("Deleted company is displayed while creating the engineering companies.");

			} catch (Throwable t) {

				successMessage(
						"Deleted company is not displayed while creating the engineering companies as expected.");

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