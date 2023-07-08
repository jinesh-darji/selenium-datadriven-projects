package testcases.E2Etestcasesuite.propertyprojectmodule;

import java.io.IOException;
import java.util.Hashtable;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;
import org.testng.SkipException;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import base.Helper;
import base.TestBase;
import utilities.TestUtil;

public class RR4866PropertyProjectTest extends TestBase {

	@Test(dataProviderClass = TestUtil.class, dataProvider = "dp")
	public void rR4866PropertyProjectTest(Hashtable<String, String> data) throws IOException, InterruptedException {

		execution(data, "rR4866PropertyProjectTest");

		// PREPARE THE CRUD OPERATION OF THE DOCUMENTS OF THE CAPEX PROJECTS MODULE.
		title("PREPARE THE CRUD OPERATION OF THE DOCUMENTS OF THE CAPEX PROJECTS MODULE.");

		Helper helper = new Helper();

		// refresh the page
		driver.navigate().refresh();
		Thread.sleep(5000);
		driver.navigate().refresh();

		// ADD ENVIRONMENTAL REPORT
		title("ADD ENVIRONMENTAL REPORT");

		try {
			// click on the environmental icon from the property list page
			click("environmentalicon_CSS");

			// wait for the element
			explicitWaitClickable("menubtn_CSS");

			// click on the burger menu
			click("menubtn_CSS");

			// wait for the element
			Thread.sleep(5000);

			// click on the Environmental Reports option
			click("envreportoption_XPATH");

			// ADD REPORT 1
			title("ADD REPORT 1");

			// click on the Add report button
			click("envreportaddbtn_CSS");

			// select the checklist from the type dropdown
			select("envreporttypedd_CSS", data.get("type"));

			// scroll down the screen
			scrollByPixel(300);

			// enter the title
			type("envreporttitletxt_CSS", data.get("title"));

			// click on the date field
			click("envreportdatetxt_CSS");
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
			click("envreportsavebtn_BTNTEXT");

			// enter the newly created environmental report in the search field
			type("task_listofchecklist_filterfield_CSS", data.get("title"));

			// verification of the environmental report is added or not
			switchVerification("envreportaddedrecord_cp_linkeddocument_XPATH",
					"Test Linked Document CAPEX Projects Title",
					"The Test Linked Document CAPEX Projects Title is not displayed successfully.");

			// ADD REPORT 2
			title("ADD REPORT 2");

			// click on the Add report button
			click("envreportaddbtn_CSS");

			// select the checklist from the type dropdown
			select("envreporttypedd_CSS", data.get("type_update"));

			// scroll down the screen
			scrollByPixel(300);

			// enter the title
			type("envreporttitletxt_CSS", data.get("title_update"));

			// click on the date field
			click("envreportdatetxt_CSS");
			click("envreporttodaydate_BTNTEXT");

			// enter the company
			type("envreportcompanytxt_CSS", data.get("company"));

			// enter the author
			type("envreportauthortxt_CSS", data.get("author"));

			// enter the description
			type("envreportdescriptiontxt_CSS", data.get("description"));

			// click on the Add report button
			click("envreportsavebtn_BTNTEXT");

			// enter the newly created environmental report in the search field
			type("task_listofchecklist_filterfield_CSS", data.get("title"));

			// verification of the environmental report is added or not
			switchVerification("envreportaddedrecord_cp_linkeddocument1_XPATH",
					"Update Test Linked Document CAPEX Projects Title",
					"The Update Test Linked Document CAPEX Projects Title is not displayed successfully.");

		} catch (Throwable t) {
			verificationFailed();
		}

		// click on the home icon from the top of the screen
		click("questionnaire_homeburgermenubtn_hide_CSS");

		// synchronization
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// ADD CAPEX PROJECTS
		title("ADD CAPEX PROJECTS");

		try {
			// click on the property project icon from the property list page
			click("propertyproject_icon_CSS");

			// wait for the element
			explicitWaitClickable("menubtn_CSS");

			// click on the burger menu
			click("menubtn_CSS");

			// wait for the element
			Thread.sleep(5000);

			// click on the CAPEX Project
			click("propertyproject_capexprojectsoption_XPATH");

			// ADD DETAILS IN DOCUMENT TAB
			title("ADD DETAILS IN DOCUMENT TAB");

			// click on the add button
			click("propertyproject_mu_addbtn_CSS");

			// enter the project number
			type("propertyproject_cp_projectnumbertxt_CSS", data.get("project_number"));

			// select the engineering company
			select("propertyproject_cp_engineeringcompanydd_CSS", data.get("engineering_company"));

			// click on the data received field
			click("propertyproject_cp_datereceived_CSS");

			// click on the today button
			click("propertyproject_cp_datereceived_todaybtn_XPATH");

			// click on the save button
			click("propertyproject_cp_savebtn_CSS");

			// wait for the element
			explicitWaitClickable("");

			// scroll down the screen
			scrollByPixel(400);

			// wait for the element
			explicitWaitClickable("propertyproject_mu_documenttab_CSS");

			// click on the document tab
			click("propertyproject_mu_documenttab_CSS");

			// NEW DOCUMENT
			title("NEW DOCUMENT");

			// click on the new document button
			click("propertyproject_cp_newdocumentbtn_CSS");

			// scrolldown the screen
			scrollByPixel(500);

			// enter the document title
			type("propertyproject_mu_document_documenttitletxt_CSS", data.get("document_title"));

			// select the type
			select("propertyproject_mu_document_typetxt_CSS", data.get("document_type"));

			// enter the company name
			type("propertyproject_mu_document_companytxt_CSS", data.get("document_company"));

			// enter the consultant name
			type("propertyproject_mu_document_consultanttxt_CSS", data.get("document_consultant"));

			// click on the date field
			click("propertyproject_mu_document_datetxt_CSS");

			// click on the today button
			click("propertyproject_mu_document_datetodaybtn_XPATH");

			// enter the description
			type("propertyproject_mu_document_descriptiontxt_CSS", data.get("short_description"));

			// click on the save button
			click("propertyproject_mu_document_savebtn_CSS");

			// verify newly created document is displayed or not
			switchVerification("propertyproject_cp_document_addeddocument_XPATH", "Test Document CAPEX Projects Title",
					"The Test Document CAPEX Projects Title is not displayed.");

			// LINK DOCUMENT
			title("LINK DOCUMENT");

			// click on the link document button
			click("propertyproject_cp_document_linkeddocumentbtn_CSS");

			// select the environmental option from the module drop down
			select("propertyproject_mu_document_moduledd_CSS", data.get("document_module"));

			// enter the environmental report name
			type("propertyproject_mu_document_searchtxt_CSS", data.get("title"));

			// verify environmental report is displayed or not
			switchVerification("propertyproject_cp_document_envreport_XPATH",
					"Test Linked Document CAPEX Projects Title",
					"The Test Linked Document CAPEX Projects Title is not displayed.");

			// click on the link button
			click("propertyproject_mu_document_linkbtn_CSS");

			// scroll down the screen
			scrollByPixel(300);

			// verify linked document displayed on document list
			switchVerification("propertyproject_cp_document_envreport_XPATH",
					"Test Linked Document CAPEX Projects Title",
					"The Test Linked Document CAPEX Projects Title is displayed.");

			// click on the update button
			click("propertyproject_cp_updatebtn_CSS");

			// verification of the CAPEX Projects is added or not
			switchVerification("propertyproject_cp_addedcapexprojectsdocument1_XPATH", "PROJECTNAMEDOCUMENT2021",
					"The PROJECTNAMEDOCUMENT2021 is not displayed successfully.");

			// UPDATE THE CAPEX Projects
			title("UPDATE THE CAPEX Projects");

			// UPDATE THE DETAILS OF THE REPAIR
			title("UPDATE THE DETAILS OF THE REPAIR");

			// click on the newly created CAPEX Projects
			click("propertyproject_cp_addedcapexprojectsdocument1_XPATH");

			// update the title of the undertaking number
			type("propertyproject_cp_projectnumbertxt_CSS", data.get("update_project_number"));

			// scroll down the screen
			scrollByPixel(400);

			// LINKED THE DOCUMENT
			title("LINKED THE DOCUMENT");

			// click on the document tab
			click("propertyproject_mu_documenttab_CSS");

			// click on the link document button
			click("propertyproject_cp_document_linkeddocumentbtn_CSS");

			// select the environmental option from the module drop down
			select("propertyproject_mu_document_moduledd_CSS", data.get("document_module"));

			// enter the environmental report name
			type("propertyproject_mu_document_searchtxt_CSS", data.get("title_update"));

			// verify environmental report is displayed or not
			switchVerification("propertyproject_cp_document_envreport1_XPATH",
					"Update Test Linked Document CAPEX Projects Title",
					"The Test Linked Document Title is not displayed.");

			// click on the link button
			click("propertyproject_mu_document_linkbtn_CSS");

			// scroll down the screen
			scrollByPixel(300);

			// verify environmental report is displayed or not
			switchVerification("propertyproject_cp_document_envreport1_XPATH",
					"Update Test Linked Document CAPEX Projects Title",
					"The Update Test Linked Document CAPEX Projects Title is not displayed.");

			// click on the update button
			click("propertyproject_cp_repair_updatebtn_CSS");

			// verification of the CAPEX Projects is added or not
			switchVerification("propertyproject_cp_updatedcapexprojectsdocument1_XPATH",
					"UPDATEPROJECTNAMEDOCUMENT2021",
					"The UPDATEPROJECTNAMEDOCUMENT2021 is not displayed successfully.");

		} catch (Throwable t) {
			verificationFailed();
		}

		// click on the home icon from the top of the screen
		click("questionnaire_homeburgermenubtn_hide_CSS");

		// synchronization
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// DELETE THE ENVIRONMENTAL RECORD
		title("DELETE THE ENVIRONMENTAL RECORD");

		try {
			// click on the environmental icon from the property list page
			click("environmentalicon_CSS");

			// wait for the element
			explicitWaitClickable("menubtn_CSS");

			// click on the burger menu
			click("menubtn_CSS");

			// wait for the element
			Thread.sleep(5000);

			// click on the Environmental Reports option
			click("envreportoption_XPATH");

			// enter the newly created environmental report in the search field
			type("task_listofchecklist_filterfield_CSS", data.get("title"));

			// click on the environmental record
			click("envreportaddedrecord_cp_linkeddocument_XPATH");

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
			helper.deleteVerification("envreportaddedrecord_cp_linkeddocument_XPATH",
					"Test Linked Document CAPEX Projects Title");

			// enter the newly created environmental report in the search field
			type("task_listofchecklist_filterfield_CSS", data.get("title_update"));

			// click on the environmental record
			click("envreportaddedrecord_cp_linkeddocument1_XPATH");

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
			type("task_listofchecklist_filterfield_CSS", data.get("title_update"));

			// verification of the environmental report is deleted or not
			helper.deleteVerification("envreportaddedrecord_cp_linkeddocument1_XPATH",
					"Update Test Linked Document CAPEX Projects Title");

		} catch (Throwable t) {
			verificationFailed();
		}

		// click on the home icon from the top of the screen
		click("questionnaire_homeburgermenubtn_hide_CSS");

		// synchronization
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// DELETE THE CAPEX Projects
		title("DELETE THE CAPEX Projects");

		try {
			// click on the property project icon from the property list page
			click("propertyproject_icon_CSS");

			// wait for the element
			explicitWaitClickable("menubtn_CSS");

			// click on the burger menu
			click("menubtn_CSS");

			// wait for the element
			Thread.sleep(5000);

			// click on the CAPEX Projects
			click("propertyproject_capexprojectsoption_XPATH");

			// DELETE THE DOCUMENTS
			title("DELETE THE DOCUMENTS");

			// click on the updated CAPEX Project
			click("propertyproject_cp_updatedcapexprojectsdocument1_XPATH");

			// click on the document tab
			click("propertyproject_mu_documenttab_CSS");

			// scroll down the sceen
			scrollByPixel(400);

			// click on the delete button of the document/s
			List<WebElement> links1 = driver.findElements(By.xpath("//td//i"));
			int count1 = links1.size();
			consoleMessage("Number of links are:" + count1);

			for (int i = 0; i < count1; i++) {

				// wait for the element
				explicitWaitClickable("propertyproject_cp_documentdeletebtn_CSS");

				// delete the all the documents of the CAPEX Projects
				click("propertyproject_cp_documentdeletebtn_CSS");

				// wait for the element
				explicitWaitClickable("propertyproject_cp_documentunlinkbtn_CSS");

				// click on the unlink button
				click("propertyproject_cp_documentunlinkbtn_CSS");

				// wait for the element
				explicitWaitClickable("closetoastmsg_CSS");

				// click on the toaster close button
				click("closetoastmsg_CSS");

			}

			// verify created documents of the CAPEX Projects is unlinked or not
			helper.deleteVerification("propertyproject_cp_document_addeddocument_XPATH",
					"Test Document CAPEX Projects Title");

			helper.deleteVerification("propertyproject_cp_document_envreport_XPATH",
					"Test Linked Document CAPEX Projects Title");

			helper.deleteVerification("propertyproject_cp_document_envreport1_XPATH",
					"Update Test Linked Document CAPEX Projects Title");

			// click on the update button
			click("propertyproject_cp_updatebtn_CSS");

			// click on the delete button of the newly created CAPEX Projects
			List<WebElement> links = driver.findElements(By.xpath("//tr"));
			int count = links.size();
			consoleMessage("Number of links are:" + count);

			for (int i = 0; i < count - 1; i++) {

				// wait for the element
				explicitWaitClickable("propertyproject_cp_deletebtn_CSS");

				// delete the all the CAPEX Projects
				click("propertyproject_cp_deletebtn_CSS");

				// wait for the element
				explicitWaitClickable("propertyproject_cp_confirmationdeletebtn_CSS");

				// click on the delete button of confirmation
				click("propertyproject_cp_confirmationdeletebtn_CSS");

				// wait for the element
				explicitWaitClickable("closetoastmsg_CSS");

				// click on the toaster close button
				click("closetoastmsg_CSS");

			}

			// verify newly created CAPEX Projects is deleted or not
			helper.deleteVerification("propertyproject_cp_updatedcapexprojectsdocument1_XPATH",
					"UPDATEPROJECTNAMEDOCUMENT2021");

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