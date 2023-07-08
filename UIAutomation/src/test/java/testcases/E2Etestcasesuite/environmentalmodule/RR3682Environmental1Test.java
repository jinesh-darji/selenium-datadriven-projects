package testcases.E2Etestcasesuite.environmentalmodule;

import java.io.IOException;
import java.util.Hashtable;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Reporter;
import org.testng.SkipException;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import base.Helper;
import base.TestBase;
import utilities.TestUtil;

public class RR3682Environmental1Test extends TestBase {

	@Test(dataProviderClass = TestUtil.class, dataProvider = "dp")
	public void rR3682Environmental1Test(Hashtable<String, String> data) throws InterruptedException, IOException {

		execution(data, "rR3682Environmental1Test");

		// CRUD OPERATION OF THE ENVIRONMENTAL REPORT
		title("CRUD OPERATION OF THE ENVIRONMENTAL REPORT");

		Helper helper = new Helper();

		// refresh the page
		driver.navigate().refresh();
		Thread.sleep(5000);
		driver.navigate().refresh();

		// CREATE NEW RECORD OF THE ENVIRONMENTAL REPORT
		title("CREATE NEW RECORD OF THE ENVIRONMENTAL REPORT");

		try {
			// click on the environmental icon from the property list page
			click("environmentalicon_CSS");

			// click on the burger menu
			click("menubtn_CSS");

			// wait for the element
			explicitWaitClickable("envreportoption_XPATH");

			// click on the Environmental Reports option
			click("envreportoption_XPATH");

			// ADD THE REPORT WITH VALID DETAILS
			title("ADD THE REPORT WITH VALID DETAILS");

			// click on the Add report button
			click("envreportaddbtn_CSS");

			// select the checklist from the type dropdown
			select("envreporttypedd_CSS", data.get("type"));

			// enter the title
			type("envreporttitletxt_CSS", data.get("title"));

			// click on the date field
			click("envreportdatetxt_CSS");

			// click on the today button
			click("envreporttodaydate_BTNTEXT");

			// enter the company
			type("envreportcompanytxt_CSS", data.get("company"));

			// enter the author
			type("envreportauthortxt_CSS", data.get("author"));

			// scroll down the screen
			scrollBottom();

			// enter the description
			type("envreportdescriptiontxt_CSS", data.get("description"));

			// add the details in the label update field
			type("envreport_labelupdatetxt_XPATH", data.get("label_update"));

			// click on the Add report button
			click("envreportsavebtn_CSS");

			// wait for the element
			explicitWaitClickable("closetoastmsg_CSS");

			// click on the toaster close button
			click("closetoastmsg_CSS");

			// enter the newly created environmental report in the search field
			type("task_listofchecklist_filterfield_CSS", data.get("title"));

			// VIEW THE NEWLY CREATED RECORD DETAILS OF THE ENVIRONMENTAL REPORT
			title("VIEW THE NEWLY CREATED RECORD DETAILS OF THE ENVIRONMENTAL REPORT");

			// verification of the environmental report is added or not
			switchVerification("envreportaddedrecord1_1_XPATH", "Test Title 1",
					"The Test Title 1 is not displayed successfully.");

			// VIEW NEWLY CREATED RECORD IS DISPLAYED WITH CORRECT DETAILS OR NOT
			title("VIEW NEWLY CREATED RECORD IS DISPLAYED WITH CORRECT DETAILS OR NOT");

			// verify added title of environmental report is correct or not
			switchVerification("envreporttitlecolumn1_XPATH", "Test Title 1", "The Test Title 1 is not displayed.");

			// verify added company of environmental report is correct or not
			switchVerification("envreportcompanycolumn1_XPATH", "Test Company 1",
					"The Test Company 1 is not displayed.");

		} catch (Throwable t) {
			verificationFailed();
		}

		// UPDATE THE NEWLY CREATED RECORD DETAILS OF THE ENVIRONMENTAL REPORT
		title("UPDATE THE NEWLY CREATED RECORD DETAILS OF THE ENVIRONMENTAL REPORT");

		try {
			// click on the added environmental record
			click("envreportaddedrecord1_1_XPATH");

			// update the type dropdown
			select("envreporttypedd_CSS", data.get("type_update"));

			// update the title field
			type("envreporttitletxt_CSS", data.get("title_update"));

			// update the company field
			type("envreportcompanytxt_CSS", data.get("company_update"));

			// update the author
			type("envreportauthortxt_CSS", data.get("author_update"));

			// update the description
			type("envreportdescriptiontxt_CSS", data.get("description_update"));

			// click on the update record button
			click("envreportupdatebtn_CSS");

			// wait for the element
			explicitWaitClickable("closetoastmsg_CSS");

			// click on the toaster close button
			click("closetoastmsg_CSS");

			// verification of the environmental report is updated or not

			// enter the newly created environmental report in the search field
			type("task_listofchecklist_filterfield_CSS", data.get("title_update"));

			// verification of the environmental report is added or not
			switchVerification("envreportaddedrecord1_2_XPATH", "Updated Title 1",
					"The Updated Title 1 is not displayed successfully.");

		} catch (Throwable t) {
			verificationFailed();
		}

		// DELETE THE UPDATED RECORD DETAILS OF THE ENVIRONMENTAL REPORT
		title("DELETE THE UPDATED RECORD DETAILS OF THE ENVIRONMENTAL REPORT");

		try {
			// click on the updated environmental record
			click("envreportaddedrecord1_2_XPATH");

			// wait for the element
			explicitWaitClickable("envreportdeletebtn_CSS");

			// click on the delete button
			click("envreportdeletebtn_CSS");

			// wait for the element
			explicitWaitClickable("envreportmodeldeletebtn_CSS");

			// click on the delete button of the confirmation model
			click("envreportmodeldeletebtn_CSS");

			// wait for the element
			explicitWaitClickable("closetoastmsg_CSS");

			// click on the toaster close button
			click("closetoastmsg_CSS");

			// verification of the environmental report is deleted or not

			// enter the newly created environmental report in the search field
			type("task_listofchecklist_filterfield_CSS", data.get("title_update"));

			helper.deleteVerification("envreportaddedrecord1_2_XPATH", "Updated Title 1");

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
