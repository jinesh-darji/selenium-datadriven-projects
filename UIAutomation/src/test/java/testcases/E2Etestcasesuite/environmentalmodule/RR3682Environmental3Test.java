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

public class RR3682Environmental3Test extends TestBase {

	@Test(dataProviderClass = TestUtil.class, dataProvider = "dp")
	public void rR3682Environmental3Test(Hashtable<String, String> data) throws IOException, InterruptedException {

		execution(data, "rR3682Environmental3Test");

		// REPORTS TO RECORDS WORKFLOW - LINK FUNCTIONALITY
		title("REPORTS TO RECORDS WORKFLOW - LINK FUNCTIONALITY");

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

			// verification of the environmental report is added or not
			switchVerification("envreporttitlecolumn3_XPATH", "Test Title 3",
					"The Test Title is not displayed successfully.");

			// CREATE NEW RECORD OF THE ENVIRONMENTAL RECORD
			title("CREATE NEW RECORD OF THE ENVIRONMENTAL RECORD");

			// Click on the side menu
			click("menubtn_CSS");

			// wait for the element
			explicitWaitClickable("envrecords_XPATH");

			// click on the environmental records
			click("envrecords_XPATH");

			// click on the Primary Hazardous Substance
			click("envrecords_primaryhazardoussubstance_XPATH");

			// click on the asbestos materials
			click("envreports_asbestosmaterials_XPATH");

			// click on the add button
			click("envreports_asbestosmaterials_addbtn_CSS");

			// select the material
			select("envreports_asbestosmaterials_materialdd_CSS", data.get("material"));

			// enter the detailed description
			type("envreports_asbestosmaterials_detaileddescriptiontxt_CSS", data.get("detailed_description"));

//		// enter the detailed description code
//		type("envreports_asbestosmaterials_detaileddescriptioncodetxt_CSS", data.get("detailed_description_code"));

			// enter the detailed location
			type("envreports_asbestosmaterials_detailedlocationtxt_CSS", data.get("detailed_location"));

//		// select the material analyzed
//		select("envreports_asbestosmaterials_materialanalyzeddd_CSS", data.get("material_analyzed"));

			// select the estimated risk
			select("envreports_asbestosmaterials_estimatedriskdd_CSS", data.get("estimated_risk"));

			// scroll down the screen
			scrollByPixel(400);

//		// select the tested date
//		click("envreports_asbestosmaterials_datetested_CSS");
//
//		// click on the today button
//		click("envreports_asbestosmaterials_datetested_todaybtn_XPATH");
//
//		// enter the data in the result(%ACM) field
//		type("envreports_asbestosmaterials_resulttxt_CSS", "90");

			// select the is material asbestos containing
			select("envreports_asbestosmaterials_ismaterialasbestoscontainingdd_CSS",
					data.get("is_material_asbestos_containing"));

			// select the asbestos type
			select("envreports_asbestosmaterials_asbestostypedd_CSS", data.get("asbestos_type"));

			// select the condition
			select("envreports_asbestosmaterials_conditiondd_CSS", data.get("condition"));

			// select the status
			select("envreports_asbestosmaterials_statusdd_CSS", data.get("status"));

			// scroll till bottom of the page
			scrollByPixel(2000);

			// enter the details
			type("envreports_asbestosmaterials_detailstxt_CSS", data.get("details"));

//		// select the remediation status
//		select("envreports_asbestosmaterials_remediationstatusdd_CSS", data.get("remediation_status"));
//
//		// select remediation completed date
//		click("envreports_asbestosmaterials_remediationcompleteddate_CSS");

//		// click on the today button	
//		click("envreports_asbestosmaterials_todaybtn_BTNTEXT");

			// click on the save button
			click("envreports_asbestosmaterials_savebtn_CSS");

			// wait for the element
			explicitWaitClickable("closetoastmsg_CSS");

			// click on the toaster close button
			click("closetoastmsg_CSS");

			// enter the newly created environmental record in the search field
			type("task_listofchecklist_filterfield_CSS", data.get("detailed_location"));

			// verification of the environmental record is added or not
			switchVerification("envreports_asbestosmaterials_addedrecord3_1_XPATH", "Test Detailed Location 3",
					"The Test Detailed Location 3 is not displayed successfully.");

		} catch (Throwable t) {
			verificationFailed();
		}

		// LINK THE REPORT
		title("LINK THE REPORT");

		try {
			// click on the added asbestos material record
			click("envreports_asbestosmaterials_addedrecord3_1_XPATH");

			// click on the Linked Reports tab
			click("envreports_asbestosmaterials_linkedreport_CSS");

			// click on the new link button
			click("envreports_asbestosmaterials_newlink_BTNTEXT");

			// enter the newly created report
			type("envreports_availablereportrecords_searchtxt_CSS", data.get("title"));

			// click on the link button of the existing record
			click("envreports_asbestosmaterials_modellink_BTNTEXT");

			// wait for the element
			explicitWait("envreports_asbestosmaterials_linkedreports_1_XPATH");

			// verify the report is linked to the record or not
			switchVerification("envreports_asbestosmaterials_linkedreports_1_XPATH", "1",
					"The report is not linked to the record.");

		} catch (Throwable t) {
			verificationFailed();
		}

		// DELETE THE REPORT AND VERIFY IN ASBESTOS MATERIAL RECORD MODULE
		title("DELETE THE REPORT AND VERIFY IN ASBESTOS MATERIAL RECORD MODULE");

		try {

			// wait for the element
			explicitWaitClickable("menubtn_CSS");

			// click on the burger menu toggle button
			click("menubtn_CSS");

			// wait for the element
			Thread.sleep(5000);

			// click on the Environmental Reports option
			click("envreportoption_XPATH");

			// enter the newly created environmental record in the search field
			type("task_listofchecklist_filterfield_CSS", data.get("title"));

			// verification of the environmental record is added or not
			switchVerification("envreporttitlecolumn3_XPATH", "Test Title 3",
					"The Test Title 3 is not displayed successfully.");

			// clicked on the created report for delete the reports.
			click("envreporttitlecolumn3_XPATH");

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

			// enter the newly created environmental report in the search field
			type("task_listofchecklist_filterfield_CSS", data.get("title"));

			helper.deleteVerification("envreporttitlecolumn3_XPATH", "Test Title 3");

		} catch (Throwable t) {
			verificationFailed();
		}

		try {

			// wait for the element
			explicitWaitClickable("menubtn_CSS");

			// click on the burger menu toggle button
			click("menubtn_CSS");

			// wait for the 5 seconds
			Thread.sleep(5000);

			// click on the asbestos materials
			click("envreports_asbestosmaterials_XPATH");

			// enter the newly created environmental record in the search field
			type("task_listofchecklist_filterfield_CSS", data.get("detailed_location"));

			// verification of the environmental record is added or not
			switchVerification("envreports_asbestosmaterials_detailedlocationcolumn3_XPATH", "Test Detailed Location 3",
					"The Test Detailed Location is not displayed successfully.");

			// click on the added asbestos material record
			click("envreports_asbestosmaterials_addedrecord3_1_XPATH");

			// verify the linked report is deleted or not
			switchVerification("envreports_asbestosmaterials_linkedreports_2_XPATH", "0",
					"The report is not deleted yet.");

			// wait for the element
			explicitWaitClickable("envreports_asbestosmaterials_deletebtn_CSS");

			// click on the delete button
			click("envreports_asbestosmaterials_deletebtn_CSS");

			// wait for the element
			explicitWaitClickable("envreports_asbestosmaterials_modeldeletebtn_CSS");

			// click on the delete button of the confirmation model
			click("envreports_asbestosmaterials_modeldeletebtn_CSS");

			// wait for the element
			explicitWaitClickable("closetoastmsg_CSS");

			// click on the toaster close button
			click("closetoastmsg_CSS");

			// enter the newly created environmental report in the search field
			type("task_listofchecklist_filterfield_CSS", data.get("detailed_location"));

			// verification of the environmental report is deleted or not
			helper.deleteVerification("envreports_asbestosmaterials_addedrecord3_1_XPATH", "Test Detailed Location 3");

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
