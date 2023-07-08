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

public class RR4865PropertyProjectTest extends TestBase {

	@Test(dataProviderClass = TestUtil.class, dataProvider = "dp")
	public void rR4865PropertyProjectTest(Hashtable<String, String> data) throws IOException, InterruptedException {

		execution(data, "rR4865PropertyProjectTest");

		// PREPARE THE CRUD OPERATION OF THE DOCUMENTS OF THE MORTGAGE UNDERTAKINGS
		// MODULE
		title("PREPARE THE CRUD OPERATION OF THE DOCUMENTS OF THE MORTGAGE UNDERTAKINGS MODULE.");

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
			click("envreportsavebtn_BTNTEXT");

			// enter the newly created environmental report in the search field
			type("task_listofchecklist_filterfield_CSS", data.get("title"));

			// verification of the environmental report is added or not
			switchVerification("envreportaddedrecord_linkeddocument_XPATH", "Test Linked Document Title",
					"The Test Linked Document Title is not displayed successfully.");

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

			// click on the today button
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
			switchVerification("envreportaddedrecord_linkeddocument1_XPATH", "Update Test Linked Document Title",
					"The Update Test Linked Document Title is not displayed successfully.");

		} catch (Throwable t) {
			verificationFailed();
		}

		// wait for the element
		explicitWaitClickable("questionnaire_homeburgermenubtn_hide_CSS");

		// click on the home icon from the top of the screen
		click("questionnaire_homeburgermenubtn_hide_CSS");

		// synchronization
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// ADD MORTGAGE UNDERTAKINGS
		title("ADD MORTGAGE UNDERTAKINGS");

		try {
			// click on the property project icon from the property list page
			click("propertyproject_icon_CSS");

			// wait for the element
			explicitWaitClickable("menubtn_CSS");

			// click on the burger menu
			click("menubtn_CSS");

			// wait for the element
			Thread.sleep(5000);

			// click on the Mortgage Undertakings
			click("propertyproject_mortgageundertakingsoption_XPATH");

			// ADD RECORD - MORTGAGE UNDERTAKINGS
			title("ADD RECORD - MORTGAGE UNDERTAKINGS");

			// click on the add button
			click("propertyproject_mu_addbtn_CSS");

			// enter the undertaking number
			type("propertyproject_mu_undertakingnumbertxt_CSS", data.get("undertaking_number"));

			// select the lender
			select("propertyproject_mu_lenderdd_CSS", data.get("lender"));

			// click on the save button
			click("propertyproject_mu_savebtn_CSS");

			// ADD DETAILS IN DOCUMENT TAB
			title("ADD DETAILS IN DOCUMENT TAB");

			// wait for the element
			explicitWaitClickable("propertyproject_mu_documenttab_CSS");

			// click on the document tab
			click("propertyproject_mu_documenttab_CSS");

			// NEW DOCUMENT
			title("NEW DOCUMENT");

			// click on the new document button
			click("propertyproject_mu_newdocumentbtn_CSS");

			// scroll down the screen
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
			switchVerification("propertyproject_mu_document_addeddocument_XPATH", "Test Document Title",
					"The Test Document Title is not displayed.");

			// LINK DOCUMENT
			title("LINK DOCUMENT");

			// click on the link document button
			click("propertyproject_mu_document_linkeddocumentbtn_CSS");

			// select the environmental option from the module drop down
			select("propertyproject_mu_document_moduledd_CSS", data.get("document_module"));

			// enter the environmental report name
			type("propertyproject_mu_document_searchtxt_CSS", data.get("title"));

			// verify environmental report is displayed or not
			switchVerification("propertyproject_mu_document_envreport_XPATH", "Test Linked Document Title",
					"The Test Linked Document Title is not displayed.");

			// click on the link button
			click("propertyproject_mu_document_linkbtn_CSS");

			// scroll down the screen
			scrollByPixel(300);

			// verify linked document displayed on document list
			switchVerification("propertyproject_mu_document_envreport_XPATH", "Test Linked Document Title",
					"The Test Linked Document Title is displayed.");

			// click on the update button
			click("propertyproject_mu_updatebtn_CSS");

			// verification of the Mortgage Undertakings is added or not
			switchVerification("propertyproject_mu_addedmortgageundertakingsdocument1_XPATH", "UNDERTAKINGDOCUMENT2021",
					"Mortgage Undertakings is not displayed successfully.");

			// UPDATE THE DETAILS OF THE REPAIR
			title("UPDATE THE DETAILS OF THE REPAIR");

			// click on the newly created Mortgage Undertakings
			click("propertyproject_mu_addedmortgageundertakingsdocument1_XPATH");

			// update the title of the undertaking number
			type("propertyproject_cp_projectnumbertxt_CSS", data.get("update_undertaking_number"));

			// scroll down the screen
			scrollByPixel(400);

			// LINKED THE DOCUMENT
			title("LINKED THE DOCUMENT");

			// click on the document tab
			click("propertyproject_mu_documenttab_CSS");

			// click on the link document button
			click("propertyproject_mu_document_linkeddocumentbtn_CSS");

			// select the environmental option from the module drop down
			select("propertyproject_mu_document_moduledd_CSS", data.get("document_module"));

			// enter the environmental report name
			type("propertyproject_mu_document_searchtxt_CSS", data.get("title_update"));

			// verify environmental report is displayed or not
			switchVerification("propertyproject_mu_document_envreport1_XPATH", "Update Test Linked Document Title",
					"The Test Linked Document Title is not displayed.");

			// click on the link button
			click("propertyproject_mu_document_linkbtn_CSS");

			// scroll down the screen
			scrollByPixel(300);

			// verify environmental report is displayed or not
			switchVerification("propertyproject_mu_document_envreport1_XPATH", "Update Test Linked Document Title",
					"The Test Linked Document Title is not displayed.");

			// click on the update button
			click("propertyproject_mu_updatebtn_CSS");

			// verify MORTGAGE UNDERTAKINGS is updated successfully or not
			switchVerification("propertyproject_mu_updatedmortgageundertakingsdocument1_XPATH",
					"UPDATEUNDERTAKINGDOCUMENT2021", "The UPDATEUNDERTAKING2021 is not displayed.");

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
			click("envreportaddedrecord_linkeddocument_XPATH");

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

			helper.deleteVerification("envreportaddedrecord_linkeddocument_XPATH", "Test Linked Document Title");

			// enter the newly created environmental report in the search field
			type("task_listofchecklist_filterfield_CSS", data.get("title_update"));

			// click on the environmental record
			click("envreportaddedrecord_linkeddocument1_XPATH");

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
			helper.deleteVerification("envreportaddedrecord_linkeddocument1_XPATH",
					"Update Test Linked Document Title");

		} catch (Throwable t) {
			verificationFailed();
		}

		// click on the home icon from the top of the screen
		click("questionnaire_homeburgermenubtn_hide_CSS");

		// synchronization
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// DELETE THE MORTGAGE UNDERTAKINGS
		title("DELETE THE MORTGAGE UNDERTAKINGS");

		try {
			// click on the property project icon from the property list page
			click("propertyproject_icon_CSS");

			// wait for the element
			explicitWaitClickable("menubtn_CSS");

			// click on the burger menu
			click("menubtn_CSS");

			// wait for the element
			Thread.sleep(5000);

			// click on the Mortgage Undertakings
			click("propertyproject_mortgageundertakingsoption_XPATH");

			// DELETE THE DOCUMENTS
			title("DELETE THE DOCUMENTS");

			// click on the updated Mortgage Undertakings
			click("propertyproject_mu_updatedmortgageundertakingsdocument1_XPATH");

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
				explicitWaitClickable("propertyproject_mu_documentdeletebtn_CSS");

				// delete the all the documents of the Mortgage Undertakings
				click("propertyproject_mu_documentdeletebtn_CSS");

				// wait for the element
				explicitWaitClickable("propertyproject_mu_documentunlinkbtn_CSS");

				// click on the unlink button
				click("propertyproject_mu_documentunlinkbtn_CSS");

				// wait for the element
				explicitWaitClickable("closetoastmsg_CSS");

				// click on the toaster close button
				click("closetoastmsg_CSS");

			}

			// verify created documents of the MORTGAGE UNDERTAKINGS is unlinked or not
			helper.deleteVerification("propertyproject_mu_document_addeddocument_XPATH", "Test Document Title");

			helper.deleteVerification("propertyproject_mu_document_envreport_XPATH", "Test Linked Document Title");

			helper.deleteVerification("propertyproject_mu_document_envreport1_XPATH",
					"Update Test Linked Document Title");

			// click on the update button
			click("propertyproject_mu_updatebtn_CSS");

			// click on the delete button of the newly created Mortgage Undertakings
			List<WebElement> links = driver.findElements(By.xpath("//tr"));
			int count = links.size();
			consoleMessage("Number of links are:" + count);

			for (int i = 0; i < count - 1; i++) {

				// wait for the element
				explicitWaitClickable("propertyproject_mu_deletebtn_CSS");

				// delete the all the Mortgage Undertakings
				click("propertyproject_mu_deletebtn_CSS");

				// wait for the element
				explicitWaitClickable("propertyproject_mu_confirmationdeletebtn_CSS");

				// click on the delete button of confirmation
				click("propertyproject_mu_confirmationdeletebtn_CSS");

				// wait for the element
				explicitWaitClickable("closetoastmsg_CSS");

				// click on the toaster close button
				click("closetoastmsg_CSS");

			}

			// verify newly created MORTGAGE UNDERTAKINGS is deleted or not
			helper.deleteVerification("propertyproject_mu_updatedmortgageundertakingsdocument1_XPATH",
					"UPDATEUNDERTAKINGDOCUMENT2021");

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