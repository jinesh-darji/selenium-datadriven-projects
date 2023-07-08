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
			System.out.println("Clicked on the ohs icon of the Property.");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Navigate to the ohs screen of the perticular property.");

			// wait for the element
			Thread.sleep(5000);

			// click on the burger menu
			click("menubtn_CSS");
			System.out.println("Clicked on the burger menu button successfully!!!");
			ngDriver.waitForAngularRequestsToFinish();

			// wait for the element
			Thread.sleep(5000);

			// click on the Document/Reports option
			click("sustainability_sidemenu_documentreportoption_XPATH");
			System.out.println("Clicked on the Document/Reports option.");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Navigate to the Document/Reports Screen.");

			// delete the previously created environmental reports
			List<WebElement> reportList = driver
					.findElements(By.xpath("//table[@class='table table-striped table-hover']//tbody//tr"));
			int reportCount = reportList.size();

			for (int i = 0; i < reportCount; i++) {

				// click on the first ohs report
				driver.findElement(By.xpath("//table[@class='table table-striped table-hover']//tbody//tr[1]//td[3]"))
						.click();
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the first ohs report.");

				// wait for the element
				explicitWaitClickable("propertysummary_recentdocument_ohs_deletebtn_XPATH");

				// click on the delete button
				click("propertysummary_recentdocument_ohs_deletebtn_XPATH");
				System.out.println("Clicked on the Delete Button.");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("The confirmation pop up model is displayed.");

				// wait for the element
				explicitWaitClickable("propertysummary_recentdocument_ohs_confirmationdeletebtn_XPATH");

				// click on the delete button of the confirmation model
				click("propertysummary_recentdocument_ohs_confirmationdeletebtn_XPATH");
				System.out.println("Clicked on the Delete Button of the confirmation popup model.");
				ngDriver.waitForAngularRequestsToFinish();

				// wait for the element
				explicitWaitClickable("closetoastmsg_CSS");

				// click on the toaster close button
				click("closetoastmsg_CSS");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the toaster close button.");

			}

		} catch (Throwable t) {
			verificationFailed();
		}

		// click on the home icon
		click("questionnaire_homeburgermenubtn_hide_CSS");
		ngDriver.waitForAngularRequestsToFinish();
		System.out.println("Clicked on the home icon.");

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
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the property one.");

			// wait for the element
			Thread.sleep(5000);

			// locate the drop area
			WebElement droparea = driver
					.findElement(By.xpath(OR.getProperty("propertysummary_recentdocumentsection_XPATH")));

			// drop the file
			dropFile(new File(System.getProperty("user.dir") + "\\src\\test\\resources\\logs\\sample.pdf"), droparea, 0,
					0);
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Drag and drop the file successfully.");

			successMessage("Drag and drop the file successfully.");

			// wait for the element
			Thread.sleep(5000);

			// select the respective option from the category dropdown
			select("propertysummary_recentdocument_categorydd_XPATH", data.get("category_2"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Selected the respective option from the category dropdown.");

			// wait for the element
			Thread.sleep(3000);

			// click on the choose button
			click("propertysummary_recentdocument_choosebtn_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the choose button.");

			// wait for the element
			Thread.sleep(30000);

			// validate the user navigate on the ohs report
			switchVerification("propertysummary_recentdocument_propertynametitle_XPATH",
					"[DND] AAAA Risk Test Prop 01 - 01", "The [DND] AAAA Risk Test Prop 01 - 01 is not displayed.");

			// click on the attachment tab
			click("propertysummary_recentdocument_ohs_attachmentcount_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the attachment tab.");

			// validate the count of the attachment
			switchVerification("propertysummary_recentdocument_ohs_attachmentcount_XPATH", "1",
					"The count of the document is not displayed correctly.");

			// click on the details tab
			click("propertysummary_recentdocument_environmental_detailstab_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the details tab.");

			// select the checklist from the type dropdown
			select("propertysummary_recentdocument_ohs_typedd_XPATH", data.get("type"));
			System.out.println("The option is selected from the Type dropdown.");
			ngDriver.waitForAngularRequestsToFinish();

			// enter the title
			clear("propertysummary_recentdocument_ohs_titletxt_XPATH");
			type("propertysummary_recentdocument_ohs_titletxt_XPATH", data.get("title"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("The data entered in the Title field.");

//			// click on the date field
//			click("envreportdatetxt_CSS");
//			ngDriver.waitForAngularRequestsToFinish();
//			System.out.println("Clicked on the date field.");
//
//			// enter future date in the date field
//			LocalDate futureDate = LocalDate.now().plusDays(10);
//			String futureDate_string = futureDate.toString();
//			type("envreportdatetxt_CSS", futureDate_string);
//			ngDriver.waitForAngularRequestsToFinish();
//			System.out.println("Entered future date in the date field.");

			// enter the description
			clear("propertysummary_recentdocument_ohs_descriptiontxt_XPATH");
			type("propertysummary_recentdocument_ohs_descriptiontxt_XPATH", data.get("description"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("The data entered in the Description field.");

			// click on the save report button
			click("propertysummary_recentdocument_ohs_savebtn_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the Save Button.");

			// wait for the element
			Thread.sleep(5000);

		} catch (Throwable t) {
			verificationFailed();
		}

		// click on the home icon
		click("questionnaire_homeburgermenubtn_hide_CSS");
		ngDriver.waitForAngularRequestsToFinish();
		System.out.println("Clicked on the home icon.");

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
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the property one.");

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
						ngDriver.waitForAngularRequestsToFinish();
						System.out.println("Clicked on the correct document type.");

						// collect title of the newly created environmental report
						String reportTitle1 = driver
								.findElement(
										By.xpath(OR.getProperty("propertysummary_recentdocument_ohs_titletxt_XPATH")))
								.getAttribute("value");
						ngDriver.waitForAngularRequestsToFinish();
						System.out.println("Collected title of the newly created environmental report.");

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
		System.out.println("Clicked on the home icon from the top of the screen.");
		ngDriver.waitForAngularRequestsToFinish();

		// wait for the element
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// DELETE THE NEWLY CREATED OHS REPORT

		title("DELETE THE NEWLY CREATED OHS REPORT");

		try {

			// click on the ohs icon from the property list page
			click("ohsicon_CSS");
			System.out.println("Clicked on the ohs icon of the Property.");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Navigate to the ohs screen of the perticular property.");

			// wait for the element
			Thread.sleep(5000);

			// click on the burger menu
			click("menubtn_CSS");
			System.out.println("Clicked on the burger menu button successfully!!!");
			ngDriver.waitForAngularRequestsToFinish();

			// wait for the element
			Thread.sleep(5000);

			// click on the Document/Reports option
			click("sustainability_sidemenu_documentreportoption_XPATH");
			System.out.println("Clicked on the Document/Reports option.");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Navigate to the Document/Reports Screen.");

			// enter the newly created ohs report in the search field
			clear("task_listofchecklist_filterfield_CSS");
			type("task_listofchecklist_filterfield_CSS", data.get("title"));
			System.out.println("Entered the newly created ohs report in the search field.");
			ngDriver.waitForAngularRequestsToFinish();

			// verification of the ohs report is added or not
			switchVerification("propertysummary_recentdocument_ohs_addedreport_XPATH", data.get("title"),
					"The newly created ohs record is not displayed successfully.");

			// click on the searched report
			click("propertysummary_recentdocument_ohs_addedreport_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the searched report.");

			// wait for the element
			explicitWaitClickable("propertysummary_recentdocument_ohs_deletebtn_XPATH");

			// click on the delete button
			click("propertysummary_recentdocument_ohs_deletebtn_XPATH");
			System.out.println("Clicked on the Delete Button.");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("The confirmation pop up model is displayed.");

			// wait for the element
			explicitWaitClickable("propertysummary_recentdocument_ohs_confirmationdeletebtn_XPATH");

			// click on the delete button of the confirmation model
			click("propertysummary_recentdocument_ohs_confirmationdeletebtn_XPATH");
			System.out.println("Clicked on the Delete Button of the confirmation popup model.");
			ngDriver.waitForAngularRequestsToFinish();

			// wait for the element
			explicitWaitClickable("closetoastmsg_CSS");

			// click on the toaster close button
			click("closetoastmsg_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the toaster close button.");

			// enter the newly created ohs report in the search field
			clear("task_listofchecklist_filterfield_CSS");
			type("task_listofchecklist_filterfield_CSS", data.get("title"));
			System.out.println("Entered the newly created environmental report in the search field.");
			ngDriver.waitForAngularRequestsToFinish();

			// verification of the ohs report is deleted or not
			helper.deleteVerification("propertysummary_recentdocument_ohs_addedreport_XPATH", data.get("title"));

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
