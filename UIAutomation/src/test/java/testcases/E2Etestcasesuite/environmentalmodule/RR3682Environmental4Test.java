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

public class RR3682Environmental4Test extends TestBase {

	@Test(dataProviderClass = TestUtil.class, dataProvider = "dp")
	public void rR3682Environmental4Test(Hashtable<String, String> data) throws InterruptedException, IOException {

		execution(data, "rR3682Environmental4Test");

		// MOVE ENVIRONMENTAL RECORD FROM PROPERTY LEVEL TO BUILDING LEVEL

		title("MOVE ENVIRONMENTAL RECORD FROM PROPERTY LEVEL TO BUILDING LEVEL");

		Helper helper = new Helper();

		// refresh the page
		driver.navigate().refresh();
		Thread.sleep(5000);
		driver.navigate().refresh();

		System.out.println("Navigate to the Home Screen i.e. Property List Screen.");

		// CREATE NEW RECORD OF THE ENVIRONMENTAL RECORD
		title("CREATE NEW RECORD OF THE ENVIRONMENTAL RECORD");

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

			// enter the detailed location
			type("envreports_asbestosmaterials_detailedlocationtxt_CSS", data.get("detailed_location"));

			// select the estimated risk
			select("envreports_asbestosmaterials_estimatedriskdd_CSS", data.get("estimated_risk"));

			// scroll down the screen
			scrollByPixel(400);

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

			// click on the save button
			click("envreports_asbestosmaterials_savebtn_CSS");

			// wait for the element
			explicitWaitClickable("closetoastmsg_CSS");

			// click on the toaster close button
			click("closetoastmsg_CSS");

			// enter the newly created environmental record in the search field
			type("task_listofchecklist_filterfield_CSS", data.get("detailed_location"));

			// verify added Asbestos Materials record is correct or not
			switchVerification("envreports_asbestosmaterials_addedrecord4_1_XPATH", "Test Detailed Location 4",
					"The Test Details location 4 is not displayed successfully.");

		} catch (Throwable t) {
			verificationFailed();
		}

		// MOVE NEWLY CREATED ENVIRONMENTAL RECORD
		title("MOVE NEWLY CREATED ENVIRONMENTAL RECORD");

		try {

			// click on the asbestos material record
			click("envreports_asbestosmaterials_addedrecord4_1_XPATH");

			// click on the move button
			click("envreports_asbestosmaterials_movebtn_CSS");

			// click on the select to move button
			click("envreports_movereports_selecttomovebtn_CSS");

			// select where to move option from the dropdown
			select("envreports_movereports_propertydd_CSS", data.get("propertydd"));

			// click on the save moved records
			click("envreports_movereports_savemovedrecordsbtn_CSS");

			// enter the newly created environmental record in the search field
			type("task_listofchecklist_filterfield_CSS", data.get("detailed_location"));

			// verify added Asbestos Materials record is correct or not
			switchVerification("envreports_asbestosmaterials_addedrecord4_1_XPATH", "Test Detailed Location 4",
					"The Test Details location 4 is not displayed successfully.");

			// VERIFY MOVED RECORD IS DISPLAYED OR NOT ON PREVIOUS LOCATION
			title("VERIFY MOVED RECORD IS DISPLAYED OR NOT ON PREVIOUS LOCATION");

			// select property option from the dropdown
			select("envreports_movereports_propertydd_CSS", data.get("propertydd1"));

			// verify added material of the Asbestos Materials record is correct or not

			// enter the newly created environmental record in the search field
			type("task_listofchecklist_filterfield_CSS", data.get("detailed_location"));

			// verify added Asbestos Materials record is correct or not
			switchVerification("envreports_asbestosmaterials_addedrecord4_1_XPATH", "Test Detailed Location 4",
					"The Test Detailed Location 4 record is not displayed.");

		} catch (Throwable t) {
			verificationFailed();
		}

		// VERIFICATION OF THE ENVIRONMENTAL RECORD IS REMOVED (MOVED) OR NOT
		title("VERIFICATION OF THE ENVIRONMENTAL RECORD IS REMOVED (MOVED) OR NOT");

		try {
			// select where to move option from the dropdown
			select("envreports_movereports_propertydd_CSS", data.get("propertydd"));

			// enter the newly created environmental record in the search field
			type("task_listofchecklist_filterfield_CSS", data.get("detailed_location"));

			// click on the asbestos material record
			click("envreports_asbestosmaterials_addedrecord4_1_XPATH");

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

			helper.deleteVerification("envreports_asbestosmaterials_addedrecord4_1_XPATH", "Test Detailed Location 4");

			// select property option from the dropdown
			select("envreports_movereports_propertydd_CSS", data.get("propertydd1"));

			// verify added material of the Asbestos Materials record is correct or not

			// enter the newly created environmental record in the search field
			type("task_listofchecklist_filterfield_CSS", data.get("detailed_location"));

			// verify added Asbestos Materials record is correct or not
			helper.deleteVerification("envreports_asbestosmaterials_addedrecord4_1_XPATH", "Test Detailed Location 4");

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
