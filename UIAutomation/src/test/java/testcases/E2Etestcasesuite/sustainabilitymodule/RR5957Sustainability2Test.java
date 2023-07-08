package testcases.E2Etestcasesuite.sustainabilitymodule;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Hashtable;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.SkipException;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import base.Helper;
import base.TestBase;
import utilities.TestUtil;

public class RR5957Sustainability2Test extends TestBase {

	@Test(dataProviderClass = TestUtil.class, dataProvider = "dp")
	public void rR5957Sustainability2Test(Hashtable<String, String> data) throws IOException, InterruptedException {

		execution(data, "rR5957Sustainability2Test");

		// PERFORMED CRUD OPERATION OF THE DOCUMENTS/REPORTS MODULE - AT BUILDING LEVEL
		title("PERFORMED CRUD OPERATION OF THE DOCUMENTS/REPORTS MODULE - AT BUILDING LEVEL");

		Helper helper = new Helper();

		// refresh the page
		driver.navigate().refresh();
		explicitWait("sustainabilityicon_CSS");
		driver.navigate().refresh();

		// CREATE NEW DOCUMENTS/REPORTS RECORD - AT PROPERTY LEVEL
		title("CREATE NEW DOCUMENTS/REPORTS RECORD - AT PROPERTY LEVEL");

		try {
			// click on the Sustainability icon
			click("sustainabilityicon_CSS");

			// wait for the element
			Thread.sleep(5000);

			// click on the side menu
			click("ssc_leftsidemenubtn_CSS");

			// wait for the element
			Thread.sleep(5000);

			// click on the document/reports option
			click("sustainability_sidemenu_documentreportoption_XPATH");

			// click on the add button
			click("sustainability_addbtn_XPATH");

			// enter the document/report title
			type("sustainability_add_documentreporttitletxt_XPATH", data.get("documentreport_title_property"));

			// select the type from the dropdown
			select("sustainability_add_typedd_XPATH", data.get("type_property"));

			// click on the date field
			click("sustainability_add_datetxt_XPATH");

			// click on the today button
			click("sustainability_add_datetxt_todatbtn_XPATH");

			// enter the description
			type("sustainability_add_descriptiontxt_XPATH", data.get("description_property"));

			// click on the save button
			click("sustainability_add_savebtn_XPATH");

			// enter the newly created document/report record in the search field
			type("sustainability_searchtxt_XPATH", data.get("documentreport_title_property"));

			// verify the newly created document/report record displayed or not at property
			// level
			switchVerification("sustainability_searchedrecord_plevel_XPATH", "Test Document and Report Title Property",
					"The Test Document and Report Title Property record is not displayed.");

		} catch (Throwable t) {
			verificationFailed();
		}

		// click on the home icon from the top of the screen
		click("questionnaire_homeburgermenubtn_hide_CSS");

		// synchronization
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// CREATE NEW DOCUMENTS/REPORTS RECORD - AT BUILDING LEVEL
		title("CREATE NEW DOCUMENTS/REPORTS RECORD - AT BUILDING LEVEL");

		try {
			// click on the Sustainability icon
			click("sustainabilityicon_CSS");

			// wait for the element
			Thread.sleep(5000);

			// click on the side menu
			click("ssc_leftsidemenubtn_CSS");

			// wait for the element
			Thread.sleep(5000);

			// click on the document/reports option
			click("sustainability_sidemenu_documentreportoption_XPATH");

			// wait for the element
			Thread.sleep(5000);

			// select the building from the top dropdown
			select("task_addedtask_propertybuildingdd_CSS", data.get("property_dd_building"));

			// click on the add button
			click("sustainability_addbtn_XPATH");

			// enter the document/report title
			type("sustainability_add_documentreporttitletxt_XPATH", data.get("documentreport_title_building"));

			// select the type from the dropdown
			select("sustainability_add_typedd_XPATH", data.get("type_building"));

			// click on the date field
			click("sustainability_add_datetxt_XPATH");

			// click on the today button
			click("sustainability_add_datetxt_todatbtn_XPATH");

			// enter the description
			type("sustainability_add_descriptiontxt_XPATH", data.get("description_building"));

			// click on the save button
			click("sustainability_add_savebtn_XPATH");

			// enter the newly created document/report record in the search field
			type("sustainability_searchtxt_XPATH", data.get("documentreport_title_building"));

			// verify the newly created document/report record displayed or not at building
			// level
			switchVerification("sustainability_searchedrecord_blevel_XPATH", "Test Document and Report Title Building",
					"The Test Document and Report Title Building record is not displayed.");

			// enter the newly created document/report record in the search field
			type("sustainability_searchtxt_XPATH", data.get("documentreport_title_property"));

			// verify the newly created document/report record displayed or not at property
			// level
			try {

				String deleteElement = driver
						.findElement(By.xpath(OR.getProperty("sustainability_searchedrecord_plevel_XPATH"))).getText();

				if (deleteElement.equals("Test Document and Report Title Property")) {

					verificationFailedMessage(
							"The Test Document and Report Title Property is displayed at building level.");
				}
			} catch (Throwable t) {
				successMessage(
						"The Test Document and Report Title Property is not displayed at building level as expected.");
			}

		} catch (Throwable t) {
			verificationFailed();
		}

		// click on the home icon from the top of the screen
		click("questionnaire_homeburgermenubtn_hide_CSS");

		// synchronization
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// UPDATE THE NEWLY CREATED DOCUMENT / REPORT RECORD - AT BUILDING LEVEL
		title("UPDATE THE NEWLY CREATED DOCUMENT / REPORT RECORD - AT BUILDING LEVEL");

		try {

			// click on the Sustainability icon
			click("sustainabilityicon_CSS");

			// wait for the element
			Thread.sleep(5000);

			// click on the side menu
			click("ssc_leftsidemenubtn_CSS");

			// wait for the element
			Thread.sleep(5000);

			// click on the document/reports option
			click("sustainability_sidemenu_documentreportoption_XPATH");

			// wait for the element
			Thread.sleep(5000);

			// select the building from the top dropdown
			select("task_addedtask_propertybuildingdd_CSS", data.get("property_dd_building"));

			// enter the newly created document/report record in the search field
			type("sustainability_searchtxt_XPATH", data.get("documentreport_title_building"));

			// click on the newly created document / report record
			click("sustainability_searchedrecord_blevel_XPATH");

			// update the document/report title
			type("sustainability_add_documentreporttitletxt_XPATH", data.get("update_documentreport_title_building"));

			// select the type from the dropdown
			select("sustainability_add_typedd_XPATH", data.get("update_type_building"));

			// enter the updated date field
			LocalDate currentDate = LocalDate.now();
			LocalDate pastDate = currentDate.minusDays(6);
			String pastDateString = pastDate.toString();
			type("sustainability_add_datetxt_XPATH", pastDateString);

			// update the description
			type("sustainability_add_descriptiontxt_XPATH", data.get("update_description_building"));

			// click on the save button
			click("sustainability_add_savebtn_XPATH");

			// enter the updated document/report record in the search field
			type("sustainability_searchtxt_XPATH", data.get("update_documentreport_title_building"));

			// verify the updated document/report record displayed or not
			switchVerification("sustainability_searchedrecord_updated_blevel_XPATH",
					"Update Test Document and Report Title Building",
					"The Update Test Document and Report Title Building record is not displayed.");

		} catch (Throwable t) {
			verificationFailed();
		}

		// click on the home icon from the top of the screen
		click("questionnaire_homeburgermenubtn_hide_CSS");

		// synchronization
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// DELETE THE UPDATED DOCUMENTS / REPORTS RECORD - AT PROPERTY AND BUILDING
		// LEVEL
		title("DELETE THE UPDATED DOCUMENTS / REPORTS RECORD - AT PROPERTY AND BUILDING LEVEL");

		try {

			// click on the Sustainability icon
			click("sustainabilityicon_CSS");

			// wait for the element
			Thread.sleep(5000);

			// click on the side menu
			click("ssc_leftsidemenubtn_CSS");

			// wait for the element
			Thread.sleep(5000);

			// click on the document/reports option
			click("sustainability_sidemenu_documentreportoption_XPATH");

			// select the building from the top dropdown
			select("task_addedtask_propertybuildingdd_CSS", data.get("property_dd_building"));

			// enter the newly created document/report record in the search field
			type("sustainability_searchtxt_XPATH", data.get("update_documentreport_title_building"));

			// click on the updated documents/reports record
			click("sustainability_searchedrecord_updated_blevel_XPATH");

			// wait for the element
			explicitWaitClickable("sustainability_deletebtn_XPATH");

			// click on the delete button
			click("sustainability_deletebtn_XPATH");

			// wait for the element
			explicitWaitClickable("sustainability_deletebtn_confirmation_XPATH");

			// click on the delete button of the confirmation popup
			click("sustainability_deletebtn_confirmation_XPATH");

			// wait for the element
			explicitWaitClickable("closetoastmsg_CSS");

			// click on the toaster close button
			click("closetoastmsg_CSS");

			// enter the updated document/report record in the search field
			type("sustainability_searchtxt_XPATH", data.get("update_documentreport_title_building"));

			// verify the deleted document/report record displayed or not
			helper.deleteVerification("sustainability_searchedrecord_updated_blevel_XPATH",
					"Update Test Document and Report Title Building");

			// select the property from the top dropdown
			select("task_addedtask_propertybuildingdd_CSS", data.get("property_dd_property"));

			// enter the newly created document/report record in the search field
			type("sustainability_searchtxt_XPATH", data.get("documentreport_title_property"));

			// click on the documents/reports record
			click("sustainability_searchedrecord_plevel_XPATH");

			// wait for the element
			explicitWaitClickable("sustainability_deletebtn_XPATH");

			// click on the delete button
			click("sustainability_deletebtn_XPATH");

			// wait for the element
			explicitWaitClickable("sustainability_deletebtn_confirmation_XPATH");

			// click on the delete button of the confirmation popup
			click("sustainability_deletebtn_confirmation_XPATH");

			// wait for the element
			explicitWaitClickable("closetoastmsg_CSS");

			// click on the toaster close button
			click("closetoastmsg_CSS");

			// enter the newly created document/report record in the search field
			type("sustainability_searchtxt_XPATH", data.get("documentreport_title_property"));

			// verify deleted document/report record displayed or not
			helper.deleteVerification("sustainability_searchedrecord_plevel_XPATH",
					"Test Document and Report Title Property");

		} catch (Throwable t) {
			verificationFailed();
		}

		// click on the home icon from the top of the screen
		click("questionnaire_homeburgermenubtn_hide_CSS");

		// synchronization
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");
	}
}