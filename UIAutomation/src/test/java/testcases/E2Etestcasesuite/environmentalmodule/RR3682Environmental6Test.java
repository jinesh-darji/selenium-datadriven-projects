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

public class RR3682Environmental6Test extends TestBase {

	@Test(dataProviderClass = TestUtil.class, dataProvider = "dp")
	public void rR3682Environmental6Test(Hashtable<String, String> data) throws IOException, InterruptedException {

		execution(data, "rR3682Environmental6Test");

		// COPY ENVIRONMENTAL RECORD TO RECORD AND REPORT TO REPORT
		title("COPY ENVIRONMENTAL RECORD TO RECORD AND REPORT TO REPORT");

		Helper helper = new Helper();

		// COPY ENVIRONMENTAL RECORD TO RECORD
		title("COPY ENVIRONMENTAL RECORD TO RECORD");

		// refresh the page
		driver.navigate().refresh();
		Thread.sleep(5000);
		driver.navigate().refresh();

		try {
			// apply the filter 1 on the property list
			type("envreports_propertylist_filtertxt_CSS", data.get("property_filter1"));

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

			// click on the save button
			click("envreports_asbestosmaterials_savebtn_CSS");

			// wait for the element
			explicitWaitClickable("closetoastmsg_CSS");

			// click on the toaster close button
			click("closetoastmsg_CSS");

			// enter the newly created environmental record in the search field
			type("task_listofchecklist_filterfield_CSS", data.get("detailed_location"));

			// verify added Asbestos Materials record is correct or not
			switchVerification("envreports_asbestosmaterials_addedrecord6_1_XPATH", "Test Detailed Location 6",
					"The Test Details Location 6 is not displayed successfully.");

		} catch (Throwable t) {
			verificationFailed();
		}

		try {

			// click on the newly created report
			click("envreports_asbestosmaterials_addedrecord6_1_XPATH");

			// click on the copy button
			click("envreports_copyreports_copyicon_CSS");

			// click on the property field
			click("envreports_copyreports_propertybtn_XPATH");

			// Select the property from the property list
			type("envreports_copyreports_findpropertytxt_CSS", data.get("findproperty"));

			// click on the property
			click("envreports_copyreports_selectproperty_CSS");

			// click on the property field
			click("envreports_copyreports_propertybtn_XPATH");

			// click on the copy button of the model
			click("envreports_copyreports_modelcopybtn_CSS");

			// wait for the element
			explicitWaitClickable("closetoastmsg_CSS");

			// click on the toaster close button
			click("closetoastmsg_CSS");

		} catch (Throwable t) {
			verificationFailed();
		}

		// click on the home icon from the top of the screen
		click("questionnaire_homeburgermenubtn_hide_CSS");

		// wait for the element
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		try {
			// apply the filter 2 on the property list
			type("envreports_propertylist_filtertxt_CSS", data.get("property_filter2"));

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

			// enter the copied environmental record in the search field
			type("task_listofchecklist_filterfield_CSS", data.get("detailed_location"));

			// verify added Asbestos Materials record is correct or not
			switchVerification("envreports_asbestosmaterials_addedrecord6_1_XPATH", "Test Detailed Location 6",
					"The Test Details Location 6 is not displayed successfully.");

			// click on the asbestos material record
			click("envreports_asbestosmaterials_addedrecord6_1_XPATH");

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
			helper.deleteVerification("envreports_asbestosmaterials_addedrecord6_1_XPATH", "Test Detailed Location 6");

		} catch (Throwable t) {
			verificationFailed();
		}

		// click on the home icon from the top of the screen
		click("questionnaire_homeburgermenubtn_hide_CSS");

		// wait for the element
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		try {
			// apply the filter 1 on the property list
			type("envreports_propertylist_filtertxt_CSS", data.get("property_filter1"));

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

			// enter the copied environmental record in the search field
			type("task_listofchecklist_filterfield_CSS", data.get("detailed_location"));

			// verify added Asbestos Materials record is correct or not
			switchVerification("envreports_asbestosmaterials_addedrecord6_1_XPATH", "Test Detailed Location 6",
					"The Test Details Description is not displayed successfully.");

			// click on the asbestos material record
			click("envreports_asbestosmaterials_addedrecord6_1_XPATH");

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
			helper.deleteVerification("envreports_asbestosmaterials_addedrecord6_1_XPATH", "Test Detailed Location 6");

		} catch (Throwable t) {
			verificationFailed();
		}

		// click on the home icon from the top of the screen
		click("questionnaire_homeburgermenubtn_hide_CSS");

		// wait for the element
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// COPY ENVIRONMENTAL REPORT TO REPORT
		title("COPY ENVIRONMENTAL REPORT TO REPORT");

		try {
			// apply the filter 1 on the property list
			type("envreports_propertylist_filtertxt_CSS", data.get("property_filter1"));

			// click on the environmental icon from the property list page
			click("environmentalicon_CSS");

			// click on the burger menu
			click("menubtn_CSS");

			// wait for the element
			explicitWaitClickable("envreportoption_XPATH");

			// click on the environmental report
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

			// scroll down to bottom of the screen
			scrollBottom();

			// enter the description
			type("envreportdescriptiontxt_CSS", data.get("description"));

			// add the details in the label update field
			type("envreport_labelupdatetxt_XPATH", data.get("label_update"));

			// click on the Add report button
			click("envreportsavebtn_CSS");

			// enter the newly created environmental report in the search field
			type("task_listofchecklist_filterfield_CSS", data.get("title"));

			// verification of the environmental report is added or not
			switchVerification("envreportaddedrecord6_1_XPATH", "Test Title 6",
					"The Test Title 6 is not displayed successfully.");

			// click on the newly created report
			click("envreportaddedrecord6_1_XPATH");

			// click on the copy button
			click("envreports_copyreports_copyicon_CSS");

			// click on the property field
			click("envreports_copyreports_propertybtn_XPATH");

			// Select the property from the property list
			type("envreports_copyreports_findpropertytxt_CSS", data.get("findproperty"));

			// click on the seleted property
			click("envreports_copyreports_selectproperty_CSS");

			// click on the property field
			click("envreports_copyreports_propertybtn_XPATH");

			// click on the copy button of the model
			click("envreports_copyreports_modelcopybtn_CSS");

			// wait for the element
			explicitWaitClickable("closetoastmsg_CSS");

			// click on the toaster close button
			click("closetoastmsg_CSS");

		} catch (Throwable t) {
			verificationFailed();
		}

		// click on the home icon from the top of the screen
		click("questionnaire_homeburgermenubtn_hide_CSS");

		// wait for the element
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		try {

			// apply the filter 2 on the property list
			type("envreports_propertylist_filtertxt_CSS", data.get("property_filter2"));

			// click on the environmental icon from the property list page
			click("environmentalicon_CSS");

			// wait for the element
			explicitWaitClickable("menubtn_CSS");

			// click on the burger menu
			click("menubtn_CSS");

			// wait for the element
			Thread.sleep(5000);

			// click on the environmental report
			click("envreportoption_XPATH");

			// wait for the element
			explicitWait("task_listofchecklist_filterfield_CSS");

			// enter the newly created environmental report in the search field
			type("task_listofchecklist_filterfield_CSS", data.get("title"));

			// verification of the environmental report is added or not
			switchVerification("envreportaddedrecord6_1_XPATH", "Test Title 6",
					"The Test Title 6 is not displayed successfully.");

			// click on the environmental record
			click("envreportaddedrecord6_1_XPATH");

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

			// verification of the environmental report is deleted or not
			helper.deleteVerification("envreportaddedrecord6_1_XPATH", "Test Title 6");

		} catch (Throwable t) {
			verificationFailed();
		}

		// click on the home icon from the top of the screen
		click("questionnaire_homeburgermenubtn_hide_CSS");

		// wait for the element
		explicitWaitClickable("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// DELETE THE NEWLY CREATED REPORT
		title("DELETE THE NEWLY CREATED REPORT");

		try {
			// apply the filter 1 on the property list
			type("envreports_propertylist_filtertxt_CSS", data.get("property_filter1"));

			// click on the environmental icon from the property list page
			click("environmentalicon_CSS");

			// click on the burger menu
			click("menubtn_CSS");

			// wait for the element
			Thread.sleep(10000);

			// click on the environmental report
			click("envreportoption_XPATH");

			// enter the newly created environmental report in the search field
			type("task_listofchecklist_filterfield_CSS", data.get("title"));

			// verification of the environmental report is added or not
			switchVerification("envreportaddedrecord6_1_XPATH", "Test Title 6",
					"The Test Title is not displayed successfully.");

			// click on the updated environmental record
			click("envreportaddedrecord6_1_XPATH");

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

			// verification of the environmental report is deleted or not
			helper.deleteVerification("envreportaddedrecord6_1_XPATH", "Test Title 6");

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
