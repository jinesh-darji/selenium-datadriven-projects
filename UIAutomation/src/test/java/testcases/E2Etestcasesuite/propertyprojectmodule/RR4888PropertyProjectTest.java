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
		title("PREPARE THE CRUD OPERATION OF THE MUNICIPALITY MODULE.");

		Helper helper = new Helper();

		// refresh the page
		driver.navigate().refresh();
		Thread.sleep(5000);
		driver.navigate().refresh();

		// ADD MUNICIPALITY
		title("ADD MUNICIPALITY");

		try {
			// click on the property project icon from the property list page
			click("propertyproject_icon_CSS");

			// wait for the element
			explicitWaitClickable("menubtn_CSS");

			// click on the burger menu
			click("menubtn_CSS");

			// wait for the element
			Thread.sleep(5000);

			// click on the municipality
			click("propertyproject_municipalityoption_XPATH");

			// ADD RECORD - MUNICIPALITY
			title("ADD RECORD - MUNICIPALITY");

			// click on the add button
			click("propertyproject_mn_addmunicipalitybtn_CSS");

			/// enter the municipality name
			type("propertyproject_mn_municipalitynametxt_CSS", data.get("municipality_name"));

			// enter the city
			type("propertyproject_mn_citytxt_CSS", data.get("city"));

			// enter the province
			type("propertyproject_mn_provincetxt_CSS", data.get("province"));

			// enter the country
			type("propertyproject_mn_countrytxt_CSS", data.get("country"));

			// click on the save button
			click("propertyproject_mn_savebtn_CSS");

			// wait for the element
			explicitWait("propertyproject_mn_filtertxt_CSS");

			// enter the municipality name
			type("propertyproject_mn_filtertxt_CSS", data.get("municipality_name"));

			// verification of the is added or not
			switchVerification("propertyproject_mn_addedmunicipality_XPATH", "Municipality Testing Name",
					"The Municipality Testing Name is not displayed successfully.");

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

			// click on the Municipal Orders
			click("propertyproject_municipalordersoption_XPATH");

			// click on the add button
			click("propertyproject_mu_addbtn_CSS");

			try {

				// select the Municipality
				select("propertyproject_mo_municipalitydd_CSS", data.get("municipality_name"));

				successMessage("New created municipality is displayed successfully while creating the CAPEX Projects.");

			} catch (Throwable t) {

				verificationFailedMessage(
						"New created municipality is not displayed while creating the CAPEX Projects.");
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

		// UPDATE THE MUNICIPALITY
		title("UPDATE THE MUNICIPALITY");

		// UPDATE THE DETAILS OF THE MUNICIPALITY
		title("UPDATE THE DETAILS OF THE MUNICIPALITY");

		try {

			// click on the property project icon from the property list page
			click("propertyproject_icon_CSS");

			// wait for the element
			explicitWaitClickable("menubtn_CSS");

			// click on the burger menu
			click("menubtn_CSS");

			// wait for the element
			Thread.sleep(5000);

			// click on the MUNICIPALITY
			click("propertyproject_municipalityoption_XPATH");

			// enter the municipality name
			type("propertyproject_mn_filtertxt_CSS", data.get("municipality_name"));

			// click on the newly created municipality
			click("propertyproject_mn_addedmunicipality_XPATH");

			// enter the municipality name
			type("propertyproject_mn_municipalitynametxt_CSS", data.get("update_municipality_name"));

			// wait for the element
			explicitWaitClickable("propertyproject_mn_updatebtn_CSS");

			// click on the update button
			click("propertyproject_mn_updatebtn_CSS");

			// wait for the element
			explicitWait("propertyproject_mn_filtertxt_CSS");

			// enter the municipality name
			type("propertyproject_mn_filtertxt_CSS", data.get("update_municipality_name"));

			// verification of the municipality is updated or not
			switchVerification("propertyproject_mn_updatedmunicipality_XPATH", "Update Municipality Testing Name",
					"The Update Municipality Testing Name is not displayed successfully.");

			// click on the home icon from the top of the screen
			click("questionnaire_homeburgermenubtn_hide_CSS");

			// wait for the element
			explicitWait("propertylist_title_XPATH");

			// verify the property list
			switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

			// VERIFY UPDATED MUNICIPALITY IS DISPLAYED OR NOT IN THE MUNICIPAL ORDERS
			title("VERIFY UPDATED MUNICIPALITY IS DISPLAYED OR NOT IN THE MUNICIPAL ORDERS");

			// click on the property project icon from the property list page
			click("propertyproject_icon_CSS");

			// wait for the element
			explicitWaitClickable("menubtn_CSS");

			// click on the burger menu
			click("menubtn_CSS");

			// wait for the element
			Thread.sleep(5000);

			// click on the municipal orders
			click("propertyproject_municipalordersoption_XPATH");

			// click on the add button
			click("propertyproject_mu_addbtn_CSS");

			try {

				// select the engineering company
				select("propertyproject_mo_municipalitydd_CSS", data.get("update_municipality_name"));

				successMessage("Updated municipality is displayed successfully while creating the Municipal Orders.");

			} catch (Throwable t) {
				verificationFailedMessage("Updated municipality is not displayed while creating the Municipal Orders.");
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

		// DELETE THE MUNICIPALITY
		title("DELETE THE MUNICIPALITY");

		try {

			// click on the property project icon from the property list page
			click("propertyproject_icon_CSS");

			// wait for the element
			explicitWaitClickable("menubtn_CSS");

			// click on the burger menu
			click("menubtn_CSS");

			// wait for the element
			Thread.sleep(5000);

			// click on the municipality
			click("propertyproject_municipalityoption_XPATH");

			// wait for the element
			explicitWait("propertyproject_mn_filtertxt_CSS");

			// enter the updated municipality in the filter field

			// wait for the element
			explicitWait("propertyproject_mn_filtertxt_CSS");

			type("propertyproject_mn_filtertxt_CSS", data.get("update_municipality_name"));

			// wait for the element
			explicitWaitClickable("propertyproject_mn_deletebtn_CSS");

			// click on the delete button
			click("propertyproject_mn_deletebtn_CSS");

			// wait for the element
			explicitWaitClickable("propertyproject_mn_confirmationdeletebtn_CSS");

			// click on the delete button of the confirmation popup
			click("propertyproject_mn_confirmationdeletebtn_CSS");

			// wait for the element
			explicitWaitClickable("closetoastmsg_CSS");

			// click on the toaster close button
			click("closetoastmsg_CSS");

			// wait for the element
			explicitWaitClickable("propertyproject_mn_filtertxt_CSS");

			// enter the deleted municipality in the filter field
			type("propertyproject_mn_filtertxt_CSS", data.get("update_municipality_name"));

			// verify municipality is deleted or not
			helper.deleteVerification("propertyproject_mn_updatedmunicipality_XPATH",
					"Update Municipality Testing Name");

		} catch (Throwable t) {
			verificationFailed();
		}

		// click on the home icon from the top of the screen
		click("questionnaire_homeburgermenubtn_hide_CSS");

		// wait for the element
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// VERIFY DELETED MUNICIPALITY IS DISPLAYED OR NOT IN THE MUNICIPAL ORDERS
		title("VERIFY DELETED MUNICIPALITY IS DISPLAYED OR NOT IN THE MUNICIPAL ORDERS");

		try {

			// click on the property project icon from the property list page
			click("propertyproject_icon_CSS");

			// wait for the element
			explicitWaitClickable("menubtn_CSS");

			// click on the burger menu
			click("menubtn_CSS");

			// wait for the element
			Thread.sleep(5000);

			// click on the municipal order
			click("propertyproject_municipalordersoption_XPATH");

			// wait for the element
			explicitWaitClickable("propertyproject_mu_addbtn_CSS");

			// click on the add button
			click("propertyproject_mu_addbtn_CSS");

			try {

				// select the municipality
				select("propertyproject_mo_municipalitydd_CSS", data.get("update_municipality_name"));

				verificationFailedMessage("Deleted municipality is displayed while creating the municipal order.");

			} catch (Throwable t) {
				successMessage("Deleted municipality is not displayed while creating the municipal order as expected.");
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