package testcases.E2Etestcasesuite.dashboardmodule;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Hashtable;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.SkipException;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import base.Helper;
import base.TestBase;
import utilities.TestUtil;

public class RR6212DashboardSceen2Test extends TestBase {

	@Test(dataProviderClass = TestUtil.class, dataProvider = "dp")
	public void rR6212DashboardSceen2Test(Hashtable<String, String> data) throws IOException, InterruptedException {

		execution(data, "rR6212DashboardSceen2Test");

		// FOR OHS, PERFORM THE DRAG AND DROP FEATURE FOR THE "RECENT
		// DOCUMENTS" CARD OF THE PROPERTY SUMMARY DASHBOARD.
		title("FOR OHS, PERFORM THE DRAG AND DROP FEATURE FOR THE \"RECENT DOCUMENTS\" CARD OF THE PROPERTY SUMMARY DASHBOARD.");

		Helper helper = new Helper();

		// refresh the page
		driver.navigate().refresh();
		Thread.sleep(5000);
		driver.navigate().refresh();

		// DELETE ALL THE PREVIOUSLY CREATED OHS REPORT
		title("DELETE ALL THE PREVIOUSLY CREATED OHS REPORT");

		try {

			// click on the ohs icon from the property list page
			click("ohsicon_CSS");
			 
			 
			 

			// wait for the element
			Thread.sleep(5000);

			// click on the burger menu
			click("menubtn_CSS");
			 
			 

			// wait for the element
			Thread.sleep(5000);

			// click on the Document/Reports option
			click("sustainability_sidemenu_documentreportoption_XPATH");
			 
			 
			 

			// delete the previously created environmental reports
			List<WebElement> reportList = driver
					.findElements(By.xpath("//table[@class='table table-striped table-hover']//tbody//tr"));
			int reportCount = reportList.size();

			for (int i = 0; i < reportCount; i++) {

				// click on the first ohs report
				driver.findElement(By.xpath("//table[@class='table table-striped table-hover']//tbody//tr[1]//td[3]"))
						.click();
				 
				 

				// wait for the element
				explicitWaitClickable("propertysummary_recentdocument_ohs_deletebtn_XPATH");

				// click on the delete button
				click("propertysummary_recentdocument_ohs_deletebtn_XPATH");
				 
				 
				 

				// wait for the element
				explicitWaitClickable("propertysummary_recentdocument_ohs_confirmationdeletebtn_XPATH");

				// click on the delete button of the confirmation model
				click("propertysummary_recentdocument_ohs_confirmationdeletebtn_XPATH");
				 
				 

				// wait for the element
				explicitWaitClickable("closetoastmsg_CSS");

				// click on the toaster close button
				click("closetoastmsg_CSS");
				 
				 

			}

		} catch (Throwable t) {
			verificationFailed();
		}

		// click on the home icon
		click("questionnaire_homeburgermenubtn_hide_CSS");
		 
		 

		// wait for the element
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// PERFORM THE DRAG AND DROP FEATURE FOR THE \"RECENT DOCUMENTS\" CARD OF THE
		// PROPERTY SUMMARY DASHBOARD
		title("PERFORM THE DRAG AND DROP FEATURE FOR THE RECENT DOCUMENTS CARD OF THE PROPERTY SUMMARY DASHBOARD.");

		try {

			// click on the property one
			click("propertysummary_property1_XPATH");
			 
			 

			// wait for the element
			Thread.sleep(5000);

			// locate the drop area
			WebElement droparea = driver
					.findElement(By.xpath(OR.getProperty("propertysummary_recentdocumentsection_XPATH")));

			// drop the file
			dropFile(new File(System.getProperty("user.dir") + "\\src\\test\\resources\\logs\\sample.pdf"), droparea, 0,
					0);
			 
			 

			successMessage("Drag and drop the file successfully.");

			// wait for the element
			Thread.sleep(5000);

			// select the respective option from the category dropdown
			select("propertysummary_recentdocument_categorydd_XPATH", data.get("category_2"));
			 
			 

			// wait for the element
			Thread.sleep(3000);

			// click on the choose button
			click("propertysummary_recentdocument_choosebtn_XPATH");
			 
			 

			// wait for the element
			Thread.sleep(30000);

			// validate the user navigate on the ohs report
			switchVerification("propertysummary_recentdocument_propertynametitle_XPATH",
					"[DND] AAAA Risk Test Prop 01 - 01", "The [DND] AAAA Risk Test Prop 01 - 01 is not displayed.");

			// click on the attachment tab
			click("propertysummary_recentdocument_ohs_attachmentcount_XPATH");
			 
			 

			// validate the count of the attachment
			switchVerification("propertysummary_recentdocument_ohs_attachmentcount_XPATH", "1",
					"The count of the document is not displayed correctly.");

			// click on the details tab
			click("propertysummary_recentdocument_environmental_detailstab_XPATH");
			 
			 

			// select the checklist from the type dropdown
			select("propertysummary_recentdocument_ohs_typedd_XPATH", data.get("type"));
			 
			 

			// enter the title
			 
			type("propertysummary_recentdocument_ohs_titletxt_XPATH", data.get("title"));
			 
			 

//			// click on the date field
//			click("envreportdatetxt_CSS");
//			 
//			 
//
//			// enter future date in the date field
//			LocalDate futureDate = LocalDate.now().plusDays(10);
//			String futureDate_string = futureDate.toString();
//			type("envreportdatetxt_CSS", futureDate_string);
//			 
//			 

			// enter the description
			 
			type("propertysummary_recentdocument_ohs_descriptiontxt_XPATH", data.get("description"));
			 
			 

			// click on the save report button
			click("propertysummary_recentdocument_ohs_savebtn_XPATH");
			 
			 

			// wait for the element
			Thread.sleep(5000);

		} catch (Throwable t) {
			verificationFailed();
		}

		// click on the home icon
		click("questionnaire_homeburgermenubtn_hide_CSS");
		 
		 

		// wait for the element
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// VALIDATE THE NEWLY CREATED OHS REPORT DISPLAYED IN PROPERTY SUMMARY
		// DASHBOARD SCREEEN

		title("VALIDATE THE NEWLY CREATED OHS REPORT DISPLAYED IN PROPERTY SUMMARY DASHBOARD SCREEEN");

		try {

			// click on the property one
			click("propertysummary_property1_XPATH");
			 
			 

			// wait for the element
			Thread.sleep(10000);

			try {
				// validate the newly created environmental report from the recent document card
				List<WebElement> documentList = driver
						.findElements(By.xpath(OR.getProperty("propertysummary_recentdocument_list_XPATH")));
				int documentCount = documentList.size();

				for (int i = 0; i < documentCount; i++) {

					String documentName = (documentList.get(i).getText()).trim();

					if (documentName.equals(data.get("type"))) {
						successMessage("The correct document type is displayed successfully.");

						// click on the correct document type
						documentList.get(i).click();
						 
						 

						// collect title of the newly created environmental report
						String reportTitle1 = driver
								.findElement(
										By.xpath(OR.getProperty("propertysummary_recentdocument_ohs_titletxt_XPATH")))
								.getAttribute("value");
						 
						 

						// verification of the OHS report is added or not
						if (reportTitle1.equals(data.get("title"))) {
							successMessage("The newly created OHS record is displayed successfully.");
						} else {
							verificationFailedMessage("The newly created OHS record is not displayed.");
						}

						break;

					}
				}

			} catch (Throwable t) {
				verificationFailedMessage("The correct document not found in the list.");
			}

		} catch (Throwable t) {
			verificationFailed();
		}

		// click on the home icon from the top of the screen
		click("questionnaire_homeburgermenubtn_hide_CSS");
		 
		 

		// wait for the element
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// DELETE THE NEWLY CREATED OHS REPORT

		title("DELETE THE NEWLY CREATED OHS REPORT");

		try {

			// click on the ohs icon from the property list page
			click("ohsicon_CSS");
			 
			 
			 

			// wait for the element
			Thread.sleep(5000);

			// click on the burger menu
			click("menubtn_CSS");
			 
			 

			// wait for the element
			Thread.sleep(5000);

			// click on the Document/Reports option
			click("sustainability_sidemenu_documentreportoption_XPATH");
			 
			 
			 

			// enter the newly created ohs report in the search field
			 
			type("task_listofchecklist_filterfield_CSS", data.get("title"));
			 
			 

			// verification of the ohs report is added or not
			switchVerification("propertysummary_recentdocument_ohs_addedreport_XPATH", data.get("title"),
					"The newly created ohs record is not displayed successfully.");

			// click on the searched report
			click("propertysummary_recentdocument_ohs_addedreport_XPATH");
			 
			 

			// wait for the element
			explicitWaitClickable("propertysummary_recentdocument_ohs_deletebtn_XPATH");

			// click on the delete button
			click("propertysummary_recentdocument_ohs_deletebtn_XPATH");
			 
			 
			 

			// wait for the element
			explicitWaitClickable("propertysummary_recentdocument_ohs_confirmationdeletebtn_XPATH");

			// click on the delete button of the confirmation model
			click("propertysummary_recentdocument_ohs_confirmationdeletebtn_XPATH");
			 
			 

			// wait for the element
			explicitWaitClickable("closetoastmsg_CSS");

			// click on the toaster close button
			click("closetoastmsg_CSS");
			 
			 

			// enter the newly created ohs report in the search field
			 
			type("task_listofchecklist_filterfield_CSS", data.get("title"));
			 
			 

			// verification of the ohs report is deleted or not
			helper.deleteVerification("propertysummary_recentdocument_ohs_addedreport_XPATH", data.get("title"));

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
