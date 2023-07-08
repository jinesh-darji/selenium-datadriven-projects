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

public class RR3682Environmental7Test extends TestBase {

	@Test(dataProviderClass = TestUtil.class, dataProvider = "dp")
	public void rR3682Environmental7Test(Hashtable<String, String> data) throws IOException, InterruptedException {

		execution(data, "rR3682Environmental7Test");

		// COPY ENVIRONMENTAL RECORD TO RECORD ON BUILDING AND FLOOR LEVEL

		title("COPY ENVIRONMENTAL RECORD TO RECORD ON BUILDING AND FLOOR LEVEL");

		Helper helper = new Helper();

		// refresh the page
		driver.navigate().refresh();
		Thread.sleep(5000);
		driver.navigate().refresh();

		System.out.println("Navigate to the Home Screen i.e. Property List Screen.");

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

			// select the building level from the dropdown
			select("survey_leveldropdown_CSS", data.get("building_leveldropdown"));

			// select the floor level from the dropdown
			select("survey_buildingleveldd_CSS", data.get("floor_leveldropdown"));

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

			// enter the newly created environmental report in the search field
			type("task_listofchecklist_filterfield_CSS", data.get("floor_locationcolumn"));

			// verify added Asbestos Materials record is correct or not
			switchVerification("envreports_asbestosmaterials_floorlocationcolumn_CSS",
					"[DND] Building one > [DND] Floor one",
					"The [DND] Building one > [DND] Floor one is not displayed successfully.");

		} catch (Throwable t) {
			verificationFailed();
		}

		try {

			// click on the checkbox of the newly created report
			click("envreports_copyreports_selectcheckbox_CSS");

			// click on the copy button
			click("envreports_copyreports_copybtn_CSS");

			// click on the property field
			click("envreports_copyreports_propertybtn_XPATH");

			// Select the property from the property list
			type("envreports_copyreports_findpropertytxt_CSS", data.get("findproperty"));

			// click on the selected property
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

			// verify the building and floor level report is copied successfully or not

			// enter the copied environmental record in the search field
			type("task_listofchecklist_filterfield_CSS", data.get("detailed_location"));

			// verify added Asbestos Materials record is correct or not
			switchVerification("envreports_asbestosmaterials_addedrecord7_1_XPATH", "Test Detailed Location 7",
					"The Test Details location 7 is not displayed successfully.");

		} catch (Throwable t) {
			verificationFailed();
		}

		try {
			// click on the asbestos material record
			click("envreports_asbestosmaterials_addedrecord7_1_XPATH");

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
			type("task_listofchecklist_filterfield_CSS", data.get("detailed_location"));

			helper.deleteVerification("envreports_asbestosmaterials_addedrecord7_1_XPATH", "Test Detailed Location 7");

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
			switchVerification("envreports_asbestosmaterials_addedrecord7_1_XPATH", "Test Detailed Location 7",
					"The Test Details location 7 is not displayed successfully.");

		} catch (Throwable t) {
			verificationFailed();
		}

		try {
			// click on the asbestos material record
			click("envreports_asbestosmaterials_addedrecord7_1_XPATH");

			// wait for the element
			explicitWaitClickable("envreports_asbestosmaterials_deletebtn_CSS");

			// click on the delete button
			click("envreports_asbestosmaterials_deletebtn_CSS");

			// wait for the element
			explicitWaitClickable("envreports_asbestosmaterials_modeldeletebtn_CSS");

			// click on the delete button of the confirmation model
			click("envreports_asbestosmaterials_modeldeletebtn_CSS");

			// wait for the element
			explicitWait("task_listofchecklist_filterfield_CSS");

			// verify the environmental report is deleted or not

			// enter the newly created environmental report in the search field
			type("task_listofchecklist_filterfield_CSS", data.get("detailed_location"));

			helper.deleteVerification("envreports_asbestosmaterials_addedrecord7_1_XPATH", "Test Detailed Location 7");

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
