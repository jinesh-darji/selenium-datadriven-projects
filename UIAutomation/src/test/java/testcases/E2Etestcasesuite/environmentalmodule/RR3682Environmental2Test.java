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

public class RR3682Environmental2Test extends TestBase {

	@Test(dataProviderClass = TestUtil.class, dataProvider = "dp")
	public void rR3682Environmental2Test(Hashtable<String, String> data) throws InterruptedException, IOException {

		execution(data, "rR3682Environmental2Test");

		// CRUD OPERATION OF THE ENVIRONMENTAL RECORD - ASBESTOS MATERIAL
		title("CRUD OPERATION OF THE ENVIRONMENTAL RECORD - ASBESTOS MATERIAL");

		Helper helper = new Helper();

		// refresh the page
		driver.navigate().refresh();
		Thread.sleep(5000);
		driver.navigate().refresh();

		// CREATE NEW RECORD OF THE ENVIRONMENTAL RECORD
		title("CREATE NEW RECORD OF THE ENVIRONMENTAL RECORD");

		try {

			// wait for the element
			explicitWaitClickable("environmentalicon_CSS");

			// click on the environmental icon from the property list page
			click("environmentalicon_CSS");

			// click on the burger menu
			click("menubtn_CSS");

			// wait for the element
			explicitWaitClickable("envrecords_XPATH");

			// click on the environmental records
			click("envrecords_XPATH");

			// click on the Primary Hazardous Substance
			click("envrecords_primaryhazardoussubstance_XPATH");

			// click on the asbestos materials
			click("envreports_asbestosmaterials_XPATH");

			// ADD RECORD - ASBESTOS MATERIALS
			title("ADD RECORD - ASBESTOS MATERIALS");

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

			// scroll down the screen
			scrollByPixel(400);

			// select the estimated risk
			select("envreports_asbestosmaterials_estimatedriskdd_CSS", data.get("estimated_risk"));

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
			scrollByPixel(1000);

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

			// VIEW NEWLY CREATED RECORD IS DISPLAYED WITH CORRECT DETAILS OR NOT - Asbestos
			// Material
			title("VIEW NEWLY CREATED RECORD IS DISPLAYED WITH CORRECT DETAILS OR NOT - Asbestos Material");

			// enter the newly created environmental record in the search field
			type("task_listofchecklist_filterfield_CSS", data.get("detailed_location"));

			// verify added details of the Asbestos Materials record is correct or not
			switchVerification("envreports_asbestosmaterials_addedrecord2_1_XPATH", "Test Detailed Location 2",
					"The Test Details Location 2 is not displayed successfully.");

		} catch (Throwable t) {
			verificationFailed();
		}

		// UPDATED RECORD IS DISPLAYED CORRECTLY OR NOT - Asbestos Material
		title("UPDATED RECORD IS DISPLAYED CORRECTLY OR NOT - Asbestos Material");

		try {
			// click on the added asbestos material record
			click("envreports_asbestosmaterials_addedrecord2_1_XPATH");

			// update the material
			select("envreports_asbestosmaterials_materialdd_CSS", data.get("material_update"));

			// update the detailed description
			type("envreports_asbestosmaterials_detaileddescriptiontxt_CSS", data.get("detailed_description_update"));

//		// update the detailed description code
//		type("envreports_asbestosmaterials_detaileddescriptioncodetxt_CSS",
//				data.get("detailed_description_code_update"));

			// update the detailed location
			type("envreports_asbestosmaterials_detailedlocationtxt_CSS", data.get("detailed_location_update"));

//		// update the material analyzed
//		select("envreports_asbestosmaterials_materialanalyzeddd_CSS", data.get("material_analyzed_update"));

			// update the estimated risk
			select("envreports_asbestosmaterials_estimatedriskdd_CSS", data.get("estimated_risk_update"));

			// update the is material asbestos containing
			select("envreports_asbestosmaterials_ismaterialasbestoscontainingdd_CSS",
					data.get("is_material_asbestos_containing_update"));

			// scroll till bottom of the page
			scrollByPixel(2000);

			// update the asbestos type
			select("envreports_asbestosmaterials_asbestostypedd_CSS", data.get("asbestos_type_update"));

			// update the condition
			select("envreports_asbestosmaterials_conditiondd_CSS", data.get("condition_update"));

			// update the status
			select("envreports_asbestosmaterials_statusdd_CSS", data.get("status_update"));

			// update the details
			type("envreports_asbestosmaterials_detailstxt_CSS", data.get("details_update"));

			// click on the update button
			click("envreports_asbestosmaterials_updatebtn_CSS");

			// wait for the element
			explicitWaitClickable("closetoastmsg_CSS");

			// click on the toaster close button
			click("closetoastmsg_CSS");

			// verify the newly updated environmental record
			type("task_listofchecklist_filterfield_CSS", data.get("detailed_location_update"));

			switchVerification("envreports_asbestosmaterials_addedrecord2_2_XPATH", "Update Detailed Location 2",
					"The Update Detailed Location 2 is not displayed.");

		} catch (Throwable t) {
			verificationFailed();
		}

		// DELETE THE UPDATED RECORD DETAILS OF THE ENVIRONMENTAL RECORD
		title("DELETE THE UPDATED RECORD DETAILS OF THE ENVIRONMENTAL RECORD");

		try {
			// click on the updated asbestos material record
			click("envreports_asbestosmaterials_addedrecord2_2_XPATH");

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

			// verification of the environmental report is deleted or not

			// enter the newly created environmental report in the search field
			type("task_listofchecklist_filterfield_CSS", data.get("material_update"));

			helper.deleteVerification("envreports_asbestosmaterials_addedrecord2_2_XPATH",
					"Update Detailed Location 2");

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
