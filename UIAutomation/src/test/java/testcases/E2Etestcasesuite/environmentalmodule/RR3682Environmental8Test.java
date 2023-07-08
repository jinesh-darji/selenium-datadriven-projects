package testcases.E2Etestcasesuite.environmentalmodule;

import java.io.IOException;
import java.util.Hashtable;

import org.testng.Reporter;
import org.testng.SkipException;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import base.Helper;
import base.TestBase;
import utilities.TestUtil;

public class RR3682Environmental8Test extends TestBase {

	@Test(dataProviderClass = TestUtil.class, dataProvider = "dp")
	public void rR3682Environmental8Test(Hashtable<String, String> data) throws IOException, InterruptedException {

		execution(data, "rR3682Environmental8Test");

		// COPY ENVIRONMENTAL REPORT TO REPORT ON BUILDING AND FLOOR LEVEL
		title("COPY ENVIRONMENTAL REPORT TO REPORT ON BUILDING AND FLOOR LEVEL");

		Helper helper = new Helper();

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
			explicitWaitClickable("envreportoption_XPATH");

			// click on the environmental report
			click("envreportoption_XPATH");

			// select the building level from the dropdown
			select("survey_leveldropdown_CSS", data.get("building_leveldropdown"));

			// select the floor level from the dropdown
			select("survey_buildingleveldd_CSS", data.get("floor_leveldropdown"));

			// click on the Add report button
			click("envreportaddbtn_CSS");

			// select the checklist from the type dropdown
			select("envreporttypedd_CSS", data.get("type"));

			// enter the title
			type("envreporttitletxt_CSS", data.get("title"));

			// click on the date field
			click("envreportdatetxt_CSS");

			// click on the today's button
			click("envreporttodaydate_BTNTEXT");

			// enter the company
			type("envreportcompanytxt_CSS", data.get("company"));

			// enter the author
			type("envreportauthortxt_CSS", data.get("author"));

			// scroll down to bottom
			scrollBottom();

			// enter the description
			type("envreportdescriptiontxt_CSS", data.get("description"));

			// add the details in the label update field
			type("envreport_labelupdatetxt_XPATH", data.get("label_update"));

			// click on the save report button
			click("envreportsavebtn_CSS");

			// wait for the element
			explicitWaitClickable("closetoastmsg_CSS");

			// click on the toaster close button
			click("closetoastmsg_CSS");

		} catch (Throwable t) {
			verificationFailed();
		}

		try {

			// enter the newly created environmental report in the search field
			type("task_listofchecklist_filterfield_CSS", data.get("floor_locationcolumn"));

			// verification of the environmental report is added or not
			switchVerification("envreports_report_floorlocationcolumn_CSS", "[DND] Building one > [DND] Floor one",
					"The [DND] Building one > [DND] Floor one is not displayed successfully.");

			// click on the checkbox of the newly created report
			click("envreports_copyreports_selectcheckbox_CSS");

			// click on the copy button
			click("envreports_copyreports_copybtn_CSS");

			// wait for the element
			explicitWaitClickable("envreports_copyreports_propertybtn_XPATH");

			// click on the property field
			click("envreports_copyreports_propertybtn_XPATH");

			// Select the property from the property list
			type("envreports_copyreports_findpropertytxt_CSS", data.get("findproperty"));

			// wait for the element
			Thread.sleep(3000);

			// click on the searched property
			click("envreports_copyreports_searchedproperty_XPATH");

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
			explicitWaitClickable("envreportoption_XPATH");

			// click on the environmental report
			click("envreportoption_XPATH");

			// VERIFY THE RECORD IS COPIED SUCCESSFULLY OR NOT
			title("VERIFY THE RECORD IS COPIED SUCCESSFULLY OR NOT");

			// enter the newly created environmental report in the search field
			type("task_listofchecklist_filterfield_CSS", data.get("title"));

			// verification of the environmental report is added or not
			switchVerification("envreportaddedrecord8_1_XPATH", "Test Title 8",
					"The Test Title is not displayed successfully.");

			// click on the environmental record
			click("envreportaddedrecord8_1_XPATH");

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

			// VERIFY THE ENVIRONMENTAL REPORT IS DELETE OR NOT
			title("VERIFY THE ENVIRONMENTAL REPORT IS DELETE OR NOT");

			// enter the newly created environmental report in the search field
			type("task_listofchecklist_filterfield_CSS", data.get("title"));

			helper.deleteVerification("envreportaddedrecord8_1_XPATH", "Test Title 8");

		} catch (Throwable t) {
			verificationFailed();
		}

		// click on the home icon from the top of the screen
		click("questionnaire_homeburgermenubtn_hide_CSS");

		// wait for the element
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// DELETE THE NEWLY CREATED REPORT
		title("DELETE THE NEWLY CREATED REPORT");

		try {
			// apply the filter 1 on the property list
			type("envreports_propertylist_filtertxt_CSS", data.get("property_filter1"));

			// wait for the element
			explicitWaitClickable("environmentalicon_CSS");

			// click on the environmental icon from the property list page
			click("environmentalicon_CSS");

			// click on the burger menu
			click("menubtn_CSS");

			// wait for the element
			explicitWaitClickable("envreportoption_XPATH");

			// click on the environmental report
			click("envreportoption_XPATH");

			// select the building level from the dropdown
			select("survey_leveldropdown_CSS", data.get("building_leveldropdown"));

			// select the floor level from the dropdown
			select("survey_buildingleveldd_CSS", data.get("floor_leveldropdown"));

			// enter the newly created environmental report in the search field
			type("task_listofchecklist_filterfield_CSS", data.get("floor_locationcolumn"));

			// verification of the environmental report is added or not
			switchVerification("envreports_report_floorlocationcolumn_CSS", "[DND] Building one > [DND] Floor one",
					"The [DND] Building one > [DND] Floor one is not displayed successfully.");

			// click on the updated environmental record
			click("envreports_report_floorlocationcolumn_CSS");

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

			// select the property level from the dropdown
			select("survey_leveldropdown_CSS", data.get("property_leveldropdown"));

			// enter the newly created environmental report in the search field
			type("task_listofchecklist_filterfield_CSS", data.get("title"));

			helper.deleteVerification("envreportaddedrecord8_1_XPATH", "Test Title 8");

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
