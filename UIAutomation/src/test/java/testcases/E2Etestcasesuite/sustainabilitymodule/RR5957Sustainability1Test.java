package testcases.E2Etestcasesuite.sustainabilitymodule;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Hashtable;

import org.testng.Reporter;
import org.testng.SkipException;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import base.Helper;
import base.TestBase;
import utilities.TestUtil;

public class RR5957Sustainability1Test extends TestBase {

	@Test(dataProviderClass = TestUtil.class, dataProvider = "dp")
	public void rR5957Sustainability1Test(Hashtable<String, String> data) throws IOException, InterruptedException {

		execution(data, "rR5957Sustainability1Test");

		// PERFORMED CRUD OPERATION OF THE DOCUMENTS/REPORTS MODULE - AT PROPERTY LEVEL
		title("PERFORMED CRUD OPERATION OF THE DOCUMENTS/REPORTS MODULE - AT PROPERTY LEVEL.");

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
			type("sustainability_add_documentreporttitletxt_XPATH", data.get("documentreport_title"));

			// select the type from the dropdown
			select("sustainability_add_typedd_XPATH", data.get("type"));

			// click on the date field
			click("sustainability_add_datetxt_XPATH");

			// click on the today button
			click("sustainability_add_datetxt_todatbtn_XPATH");

			// enter the description
			type("sustainability_add_descriptiontxt_XPATH", data.get("description"));

			// click on the save button
			click("sustainability_add_savebtn_XPATH");

			// enter the newly created document/report record in the search field
			type("sustainability_searchtxt_XPATH", data.get("documentreport_title"));

			// verify the newly created document/report record displayed or not
			switchVerification("sustainability_searchedrecord_XPATH", "Test Document and Report Title",
					"The Test Document and Report Title record is not displayed.");

		} catch (Throwable t) {
			verificationFailed();
		}

		// UPDATE THE NEWLY CREATED DOCUMENT / REPORT RECORD
		title("UPDATE THE NEWLY CREATED DOCUMENT / REPORT RECORD");

		try {
			// click on the newly created document / report record
			click("sustainability_searchedrecord_XPATH");

			// update the document/report title

			type("sustainability_add_documentreporttitletxt_XPATH", data.get("update_documentreport_title"));

			// select the type from the dropdown
			select("sustainability_add_typedd_XPATH", data.get("update_type"));

			// enter the updated date field
			LocalDate currentDate = LocalDate.now();
			LocalDate pastDate = currentDate.minusDays(6);
			String pastDateString = pastDate.toString();
			type("sustainability_add_datetxt_XPATH", pastDateString);

			// update the description
			type("sustainability_add_descriptiontxt_XPATH", data.get("update_description"));

			// click on the save button
			click("sustainability_add_savebtn_XPATH");

			// enter the updated document/report record in the search field
			type("sustainability_searchtxt_XPATH", data.get("update_documentreport_title"));

			// verify the updated document/report record displayed or not
			switchVerification("sustainability_searchedrecord_updated_XPATH", "Update Test Document and Report Title",
					"The Update Test Document and Report Title record is not displayed.");

		} catch (Throwable t) {
			verificationFailed();
		}

		// click on the home icon from the top of the screen
		click("questionnaire_homeburgermenubtn_hide_CSS");

		// synchronization
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// DELETE THE UPDATED DOCUMENTS / REPORTS RECORD
		title("DELETE THE UPDATED DOCUMENTS / REPORTS RECORD");

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

			// click on the updated documents/reports record
			click("sustainability_searchedrecord_updated_XPATH");

			// click on the delete button
			click("sustainability_deletebtn_XPATH");

			// click on the delete button of the confirmation popup
			click("sustainability_deletebtn_confirmation_XPATH");

			// enter the updated document/report record in the search field
			type("sustainability_searchtxt_XPATH", data.get("update_documentreport_title"));

			// verify the deleted document/report record displayed or not
			helper.deleteVerification("sustainability_searchedrecord_updated_XPATH",
					"Update Test Document and Report Title");

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