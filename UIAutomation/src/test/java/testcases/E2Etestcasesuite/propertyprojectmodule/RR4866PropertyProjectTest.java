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

		System.out.println("PREPARE THE CRUD OPERATION OF THE DOCUMENTS OF THE CAPEX PROJECTS MODULE.");
		test.log(LogStatus.INFO, "PREPARE THE CRUD OPERATION OF THE DOCUMENTS OF THE CAPEX PROJECTS MODULE.");
		Reporter.log("PREPARE THE CRUD OPERATION OF THE DOCUMENTS OF THE CAPEX PROJECTS MODULE.");
		log.info("PREPARE THE CRUD OPERATION OF THE DOCUMENTS OF THE CAPEX PROJECTS MODULE.");

		Helper helper = new Helper();

		// refresh the page
		driver.navigate().refresh();
		Thread.sleep(5000);
		driver.navigate().refresh();

		System.out.println("Navigate to the Home Screen i.e. Property List Screen.");

		// ADD ENVIRONMENTAL REPORT

		System.out.println("**************** ADD ENVIRONMENTAL REPORT ****************");
		test.log(LogStatus.INFO, "**************** ADD ENVIRONMENTAL REPORT ****************");
		Reporter.log("**************** ADD ENVIRONMENTAL REPORT ****************");
		log.info("**************** ADD ENVIRONMENTAL REPORT ****************");

		try {
			// click on the environmental icon from the property list page
			click("environmentalicon_CSS");
			System.out.println("Clicked on the environmental icon of the Property.");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Navigate to the environmental screen of the perticular property.");

			// wait for the element
			explicitWaitClickable("menubtn_CSS");

			// click on the burger menu
			click("menubtn_CSS");
			System.out.println("Clicked on the burger menu button successfully!!!");
			ngDriver.waitForAngularRequestsToFinish();

			// wait for the element
			Thread.sleep(5000);

			// click on the Environmental Reports option
			click("envreportoption_XPATH");
			System.out.println("Clicked on the Environmental Reports option.");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Navigate to the Environmental Report Screen.");

			// ADD REPORT 1

			// click on the Add report button
			click("envreportaddbtn_CSS");
			System.out.println("Clicked on the Add report button");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Navigate to the Add Environmental Report Screen.");

			// select the checklist from the type dropdown
			select("envreporttypedd_CSS", data.get("type"));
			System.out.println("The option is selected from the Type dropdown.");
			ngDriver.waitForAngularRequestsToFinish();

			// scroll down the screen
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,300)");

			// enter the title
			type("envreporttitletxt_CSS", data.get("title"));
			System.out.println("The data entered in the Title field.");

			// click on the date field
			click("envreportdatetxt_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			click("envreporttodaydate_BTNTEXT");
			System.out.println("Today's date selected in the Date Field.");

			// enter the company
			type("envreportcompanytxt_CSS", data.get("company"));
			System.out.println("The data entered in the Company field.");

			// enter the author
			type("envreportauthortxt_CSS", data.get("author"));
			System.out.println("The data entered in the Author field.");

			// enter the description
			type("envreportdescriptiontxt_CSS", data.get("description"));
			System.out.println("The data entered in the Description field.");

			// click on the Add report button
			click("envreportsavebtn_BTNTEXT");
			System.out.println("Clicked on the Save Button.");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Navigate to the Add Report Screen.");

			// enter the newly created environmental report in the search field
			clear("task_listofchecklist_filterfield_CSS");
			System.out.println("Cleared the search field.");
			ngDriver.waitForAngularRequestsToFinish();
			type("task_listofchecklist_filterfield_CSS", data.get("title"));
			System.out.println("Entered the newly created environmental report in the search field.");
			ngDriver.waitForAngularRequestsToFinish();

			// verification of the environmental report is added or not
			switchVerification("envreportaddedrecord_cp_linkeddocument_XPATH",
					"Test Linked Document CAPEX Projects Title",
					"The Test Linked Document CAPEX Projects Title is not displayed successfully.");

			// ADD REPORT 2

			// click on the Add report button
			click("envreportaddbtn_CSS");
			System.out.println("Clicked on the Add report button");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Navigate to the Add Environmental Report Screen.");

			// select the checklist from the type dropdown
			select("envreporttypedd_CSS", data.get("type_update"));
			System.out.println("The option is selected from the Type dropdown.");
			ngDriver.waitForAngularRequestsToFinish();

			// scroll down the screen
			js.executeScript("window.scrollBy(0,300)");

			// enter the title
			type("envreporttitletxt_CSS", data.get("title_update"));
			System.out.println("The data entered in the Title field.");

			// click on the date field
			click("envreportdatetxt_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			click("envreporttodaydate_BTNTEXT");
			System.out.println("Today's date selected in the Date Field.");

			// enter the company
			type("envreportcompanytxt_CSS", data.get("company"));
			System.out.println("The data entered in the Company field.");

			// enter the author
			type("envreportauthortxt_CSS", data.get("author"));
			System.out.println("The data entered in the Author field.");

			// enter the description
			type("envreportdescriptiontxt_CSS", data.get("description"));
			System.out.println("The data entered in the Description field.");

			// click on the Add report button
			click("envreportsavebtn_BTNTEXT");
			System.out.println("Clicked on the Save Button.");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Navigate to the Add Report Screen.");

			// enter the newly created environmental report in the search field
			clear("task_listofchecklist_filterfield_CSS");
			System.out.println("Cleared the search field.");
			ngDriver.waitForAngularRequestsToFinish();
			type("task_listofchecklist_filterfield_CSS", data.get("title"));
			System.out.println("Entered the newly created environmental report in the search field.");
			ngDriver.waitForAngularRequestsToFinish();

			// verification of the environmental report is added or not
			switchVerification("envreportaddedrecord_cp_linkeddocument1_XPATH",
					"Update Test Linked Document CAPEX Projects Title",
					"The Update Test Linked Document CAPEX Projects Title is not displayed successfully.");

		} catch (Throwable t) {
			verificationFailed();
		}

		// click on the home icon from the top of the screen
		click("questionnaire_homeburgermenubtn_hide_CSS");
		System.out.println("Clicked on the home icon from the top of the screen.");
		ngDriver.waitForAngularRequestsToFinish();

		// synchronization
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// ADD CAPEX PROJECTS

		System.out.println("**************** ADD CAPEX PROJECTS ****************");
		test.log(LogStatus.INFO, "**************** ADD CAPEX PROJECTS ****************");
		Reporter.log("**************** ADD CAPEX PROJECTS ****************");
		log.info("**************** ADD CAPEX PROJECTS ****************");

		try {
			// click on the property project icon from the property list page
			click("propertyproject_icon_CSS");
			System.out.println("Clicked on the property project icon of the Property.");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Navigate to the property project screen of the perticular property.");

			// wait for the element
			explicitWaitClickable("menubtn_CSS");

			// click on the burger menu
			click("menubtn_CSS");
			System.out.println("Clicked on the burger menu button successfully!!!");
			ngDriver.waitForAngularRequestsToFinish();

			// wait for the element
			Thread.sleep(5000);

			// click on the CAPEX Project
			click("propertyproject_capexprojectsoption_XPATH");
			System.out.println("Clicked on the CAPEX Project option.");
			ngDriver.waitForAngularRequestsToFinish();

			// ADD DETAILS IN DOCUMENT TAB

			// click on the add button
			click("propertyproject_mu_addbtn_CSS");
			System.out.println("Clicked on the Add button.");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Navigate to the Add CAPEX Project Screen");

			// enter the project number
			type("propertyproject_cp_projectnumbertxt_CSS", data.get("project_number"));
			System.out.println("Entered the undertaking number.");
			ngDriver.waitForAngularRequestsToFinish();

			// select the engineering company
			select("propertyproject_cp_engineeringcompanydd_CSS", data.get("engineering_company"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Selected the engineering company.");

			// click on the data received field
			click("propertyproject_cp_datereceived_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the data received field.");

			// click on the today button
			click("propertyproject_cp_datereceived_todaybtn_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the today button.");

			// click on the save button
			click("propertyproject_cp_savebtn_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the save button.");

			// wait for the element
			explicitWaitClickable("");

			// scroll down the screen
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,400)");

			// wait for the element
			explicitWaitClickable("propertyproject_mu_documenttab_CSS");

			// click on the document tab
			click("propertyproject_mu_documenttab_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the document tab.");

			// NEW DOCUMENT

			// click on the new document button
			click("propertyproject_cp_newdocumentbtn_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the new document button.");

			// scrolldown the screen
			js.executeScript("window.scrollBy(0,500)");

			// enter the document title
			type("propertyproject_mu_document_documenttitletxt_CSS", data.get("document_title"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the document title.");

			// select the type
			select("propertyproject_mu_document_typetxt_CSS", data.get("document_type"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Selected the type.");

			// enter the company name
			type("propertyproject_mu_document_companytxt_CSS", data.get("document_company"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the company name.");

			// enter the consultant name
			type("propertyproject_mu_document_consultanttxt_CSS", data.get("document_consultant"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the consultant name.");

			// click on the date field
			click("propertyproject_mu_document_datetxt_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the date field.");

			// click on the today button
			click("propertyproject_mu_document_datetodaybtn_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the today button.");

			// enter the description
			type("propertyproject_mu_document_descriptiontxt_CSS", data.get("short_description"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the description.");

			// click on the save button
			click("propertyproject_mu_document_savebtn_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the save button.");

			// verify newly created document is displayed or not
			switchVerification("propertyproject_cp_document_addeddocument_XPATH", "Test Document CAPEX Projects Title",
					"The Test Document CAPEX Projects Title is not displayed.");

			// LINK DOCUMENT

			// click on the link document button
			click("propertyproject_cp_document_linkeddocumentbtn_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the link document button.");

			// select the environmental option from the module drop down
			select("propertyproject_mu_document_moduledd_CSS", data.get("document_module"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Selected the environmental option from the module drop down.");

			// enter the environmental report name
			type("propertyproject_mu_document_searchtxt_CSS", data.get("title"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the environmental report name.");

			// verify environmental report is displayed or not
			switchVerification("propertyproject_cp_document_envreport_XPATH",
					"Test Linked Document CAPEX Projects Title",
					"The Test Linked Document CAPEX Projects Title is not displayed.");

			// click on the link button
			click("propertyproject_mu_document_linkbtn_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the link button.");

			// scroll down the screen
			js.executeScript("window.scrollBy(0,300)");

			// verify linked document displayed on document list
			switchVerification("propertyproject_cp_document_envreport_XPATH",
					"Test Linked Document CAPEX Projects Title",
					"The Test Linked Document CAPEX Projects Title is displayed.");

			// click on the update button
			click("propertyproject_cp_updatebtn_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the update button.");

			// verification of the CAPEX Projects is added or not
			switchVerification("propertyproject_cp_addedcapexprojectsdocument1_XPATH", "PROJECTNAMEDOCUMENT2021",
					"The PROJECTNAMEDOCUMENT2021 is not displayed successfully.");

			// UPDATE THE CAPEX Projects

			System.out.println("**************** UPDATE CAPEX Projects ****************");
			test.log(LogStatus.INFO, "**************** UPDATE CAPEX Projects ****************");
			Reporter.log("**************** UPDATE CAPEX Projects ****************");
			log.info("**************** UPDATE CAPEX Projects ****************");

			// UPDATE THE DETAILS OF THE REPAIR

			// click on the newly created CAPEX Projects
			click("propertyproject_cp_addedcapexprojectsdocument1_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the newly created CAPEX Projects.");

			// update the title of the undertaking number
			clear("propertyproject_cp_projectnumbertxt_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clear the title field.");
			type("propertyproject_cp_projectnumbertxt_CSS", data.get("update_project_number"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("update the title of the undertaking number.");

			// scroll down the screen
			js.executeScript("window.scrollBy(0,400)");

			// LINKED THE DOCUMENT

			// click on the document tab
			click("propertyproject_mu_documenttab_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the document tab.");

			// click on the link document button
			click("propertyproject_cp_document_linkeddocumentbtn_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the link document button.");

			// select the environmental option from the module drop down
			select("propertyproject_mu_document_moduledd_CSS", data.get("document_module"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Selected the environmental option from the module drop down.");

			// enter the environmental report name
			type("propertyproject_mu_document_searchtxt_CSS", data.get("title_update"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the environmental report name.");

			// verify environmental report is displayed or not
			switchVerification("propertyproject_cp_document_envreport1_XPATH",
					"Update Test Linked Document CAPEX Projects Title",
					"The Test Linked Document Title is not displayed.");

			// click on the link button
			click("propertyproject_mu_document_linkbtn_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the link button.");

			// scroll down the screen
			js.executeScript("window.scrollBy(0,300)");

			// verify environmental report is displayed or not
			switchVerification("propertyproject_cp_document_envreport1_XPATH",
					"Update Test Linked Document CAPEX Projects Title",
					"The Update Test Linked Document CAPEX Projects Title is not displayed.");

			// click on the update button
			click("propertyproject_cp_repair_updatebtn_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the update button.");

			// verification of the CAPEX Projects is added or not
			switchVerification("propertyproject_cp_updatedcapexprojectsdocument1_XPATH",
					"UPDATEPROJECTNAMEDOCUMENT2021",
					"The UPDATEPROJECTNAMEDOCUMENT2021 is not displayed successfully.");

		} catch (Throwable t) {
			verificationFailed();
		}

		// click on the home icon from the top of the screen
		click("questionnaire_homeburgermenubtn_hide_CSS");
		System.out.println("Clicked on the home icon from the top of the screen.");
		ngDriver.waitForAngularRequestsToFinish();

		// synchronization
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// DELETE THE ENVIRONMENTAL RECORD

		System.out.println("***************** DELETE THE ENVIRONMENTAL RECORD *****************");
		test.log(LogStatus.INFO, "***************** DELETE THE ENVIRONMENTAL RECORD *****************");
		Reporter.log("***************** DELETE THE ENVIRONMENTAL RECORD *****************");
		log.info("***************** DELETE THE ENVIRONMENTAL RECORD *****************");

		try {
			// click on the environmental icon from the property list page
			click("environmentalicon_CSS");
			System.out.println("Clicked on the environmental icon of the Property.");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Navigate to the environmental screen of the perticular property.");

			// wait for the element
			explicitWaitClickable("menubtn_CSS");

			// click on the burger menu
			click("menubtn_CSS");
			System.out.println("Clicked on the burger menu button successfully!!!");
			ngDriver.waitForAngularRequestsToFinish();

			// wait for the element
			Thread.sleep(5000);

			// click on the Environmental Reports option
			click("envreportoption_XPATH");
			System.out.println("Clicked on the Environmental Reports option.");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Navigate to the Environmental Report Screen.");

			// enter the newly created environmental report in the search field
			clear("task_listofchecklist_filterfield_CSS");
			System.out.println("Cleared the search field.");
			ngDriver.waitForAngularRequestsToFinish();
			type("task_listofchecklist_filterfield_CSS", data.get("title"));
			System.out.println("Entered the newly created environmental report in the search field.");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the environmental record
			click("envreportaddedrecord_cp_linkeddocument_XPATH");
			System.out.println("Clicked on the record for delete the records.");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Naviagte to the Update Environmental Report Screen.");

			// wait for the element
			explicitWaitClickable("envreportdeletebtn_CSS");

			// click on the delete button
			click("envreportdeletebtn_CSS");
			System.out.println("Clicked on the Delete Button.");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("The confirmation pop up model is displayed.");

			// wait for the element
			explicitWaitClickable("envreportmodeldeletebtn_CSS");

			// click on the delete button of the confirmation model
			click("envreportmodeldeletebtn_CSS");
			System.out.println("Clicked on the Delete Button of the confirmation popup model.");
			ngDriver.waitForAngularRequestsToFinish();

			// wait for the element
			explicitWaitClickable("closetoastmsg_CSS");

			// click on the toaster close button
			click("closetoastmsg_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the toaster close button.");

			// verification of the environmental report is deleted or not

			// enter the newly created environmental report in the search field
			clear("task_listofchecklist_filterfield_CSS");
			System.out.println("Cleared the search field.");
			ngDriver.waitForAngularRequestsToFinish();
			type("task_listofchecklist_filterfield_CSS", data.get("title"));
			System.out.println("Entered the newly created environmental report in the search field.");
			ngDriver.waitForAngularRequestsToFinish();

			helper.deleteVerification("envreportaddedrecord_cp_linkeddocument_XPATH",
					"Test Linked Document CAPEX Projects Title");

			// enter the newly created environmental report in the search field
			clear("task_listofchecklist_filterfield_CSS");
			System.out.println("Cleared the search field.");
			ngDriver.waitForAngularRequestsToFinish();
			type("task_listofchecklist_filterfield_CSS", data.get("title_update"));
			System.out.println("Entered the newly created environmental report in the search field.");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the environmental record
			click("envreportaddedrecord_cp_linkeddocument1_XPATH");
			System.out.println("Clicked on the record for delete the records.");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Naviagte to the Update Environmental Report Screen.");

			// wait for the element
			explicitWaitClickable("envreportdeletebtn_CSS");

			// click on the delete button
			click("envreportdeletebtn_CSS");
			System.out.println("Clicked on the Delete Button.");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("The confirmation pop up model is displayed.");

			// wait for the element
			explicitWaitClickable("envreportmodeldeletebtn_CSS");

			// click on the delete button of the confirmation model
			click("envreportmodeldeletebtn_CSS");
			System.out.println("Clicked on the Delete Button of the confirmation popup model.");
			ngDriver.waitForAngularRequestsToFinish();

			// wait for the element
			explicitWaitClickable("closetoastmsg_CSS");

			// click on the toaster close button
			click("closetoastmsg_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the toaster close button.");

			// verification of the environmental report is deleted or not

			// enter the newly created environmental report in the search field
			clear("task_listofchecklist_filterfield_CSS");
			System.out.println("Cleared the search field.");
			ngDriver.waitForAngularRequestsToFinish();
			type("task_listofchecklist_filterfield_CSS", data.get("title_update"));
			System.out.println("Entered the newly created environmental report in the search field.");
			ngDriver.waitForAngularRequestsToFinish();

			helper.deleteVerification("envreportaddedrecord_cp_linkeddocument1_XPATH",
					"Update Test Linked Document CAPEX Projects Title");

		} catch (Throwable t) {
			verificationFailed();
		}

		// click on the home icon from the top of the screen
		click("questionnaire_homeburgermenubtn_hide_CSS");
		System.out.println("Clicked on the home icon from the top of the screen.");
		ngDriver.waitForAngularRequestsToFinish();

		// synchronization
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// DELETE THE CAPEX Projects

		System.out.println("**************** DELETE CAPEX Projects ****************");
		test.log(LogStatus.INFO, "**************** DELETE CAPEX Projects ****************");
		Reporter.log("**************** DELETE CAPEX Projects ****************");
		log.info("**************** DELETE CAPEX Projects ****************");

		try {
			// click on the property project icon from the property list page
			click("propertyproject_icon_CSS");
			System.out.println("Clicked on the property project icon of the Property.");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Navigate to the property project screen of the perticular property.");

			// wait for the element
			explicitWaitClickable("menubtn_CSS");

			// click on the burger menu
			click("menubtn_CSS");
			System.out.println("Clicked on the burger menu button successfully!!!");
			ngDriver.waitForAngularRequestsToFinish();

			// wait for the element
			Thread.sleep(5000);

			// click on the CAPEX Projects
			click("propertyproject_capexprojectsoption_XPATH");
			System.out.println("Clicked on the CAPEX Projects option.");
			ngDriver.waitForAngularRequestsToFinish();

			// DELETE THE DOCUMENTS

			// click on the updated CAPEX Project
			click("propertyproject_cp_updatedcapexprojectsdocument1_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the updated CAPEX Project.");

			// click on the document tab
			click("propertyproject_mu_documenttab_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the document tab.");

			// scroll down the sceen
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,400)");

			// click on the delete button of the document/s
			List<WebElement> links1 = driver.findElements(By.xpath("//td//i"));
			int count1 = links1.size();
			System.out.println("Number of links are:" + count1);

			for (int i = 0; i < count1; i++) {

				// wait for the element
				explicitWaitClickable("propertyproject_cp_documentdeletebtn_CSS");

				// delete the all the documents of the CAPEX Projects
				click("propertyproject_cp_documentdeletebtn_CSS");
				System.out.println("Deleted the all the documents of the CAPEX Projects");
				ngDriver.waitForAngularRequestsToFinish();

				// wait for the element
				explicitWaitClickable("propertyproject_cp_documentunlinkbtn_CSS");

				// click on the unlink button
				click("propertyproject_cp_documentunlinkbtn_CSS");
				System.out.println("Clicked on the unlink button.");
				ngDriver.waitForAngularRequestsToFinish();

				// wait for the element
				explicitWaitClickable("closetoastmsg_CSS");

				// click on the toaster close button
				click("closetoastmsg_CSS");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the toaster close button.");

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
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the update button.");

			// click on the delete button of the newly created CAPEX Projects
			List<WebElement> links = driver.findElements(By.xpath("//tr"));
			int count = links.size();
			System.out.println("Number of links are:" + count);

			for (int i = 0; i < count - 1; i++) {

				// wait for the element
				explicitWaitClickable("propertyproject_cp_deletebtn_CSS");

				// delete the all the CAPEX Projects
				click("propertyproject_cp_deletebtn_CSS");
				System.out.println("Deleted the all the CAPEX Projects");
				ngDriver.waitForAngularRequestsToFinish();

				// wait for the element
				explicitWaitClickable("propertyproject_cp_confirmationdeletebtn_CSS");

				// click on the delete button of confirmation
				click("propertyproject_cp_confirmationdeletebtn_CSS");
				System.out.println("Clicked on the delete button of confirmation.");
				ngDriver.waitForAngularRequestsToFinish();

				// wait for the element
				explicitWaitClickable("closetoastmsg_CSS");

				// click on the toaster close button
				click("closetoastmsg_CSS");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the toaster close button.");

			}

			// verify newly created CAPEX Projects is deleted or not

			helper.deleteVerification("propertyproject_cp_updatedcapexprojectsdocument1_XPATH",
					"UPDATEPROJECTNAMEDOCUMENT2021");

		} catch (Throwable t) {
			verificationFailed();
		}

		// click on the home icon from the top of the screen
		click("questionnaire_homeburgermenubtn_hide_CSS");
		System.out.println("Clicked on the home icon from the top of the screen.");
		ngDriver.waitForAngularRequestsToFinish();

		// wait for the element
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

	}

}