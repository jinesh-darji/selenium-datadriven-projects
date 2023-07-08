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

public class RR6212DashboardSceen3Test extends TestBase {

	@Test(dataProviderClass = TestUtil.class, dataProvider = "dp")
	public void rR6212DashboardSceen3Test(Hashtable<String, String> data) throws IOException, InterruptedException {

		execution(data, "rR6212DashboardSceen3Test");
		
		// FOR ENVIRONMENTAL, VALIDATE THE DATE AND INDICATION OF THE DOCUMENT TYPE WITH
		// VARIOUS SCENARIOS. AFTER PERFORMING THE DRAG AND DROP FEATURE FOR THE "RECENT
		// DOCUMENTS" CARD OF THE PROPERTY SUMMARY DASHBOARD.

		title("FOR ENVIRONMENTAL, VALIDATE THE DATE AND INDICATION OF THE DOCUMENT TYPE WITH VARIOUS SCENARIOS. AFTER PERFORMING THE DRAG AND DROP FEATURE FOR THE \"RECENT DOCUMENTS\" CARD OF THE PROPERTY SUMMARY DASHBOARD.");

		Helper helper = new Helper();

		// refresh the page
		driver.navigate().refresh();
		Thread.sleep(5000);
		driver.navigate().refresh();

		 

		// DELETE ALL THE PREVIOUSLY CREATED ENVIRONMENTAL REPORTS

		title("DELETE ALL THE PREVIOUSLY CREATED ENVIRONMENTAL REPORTS.");

		try {

			// click on the environmental icon from the property list page
			click("environmentalicon_CSS");
			 
			 
			 

			// wait for the element
			Thread.sleep(5000);

			// click on the burger menu
			click("menubtn_CSS");
			 
			 

			// wait for the element
			Thread.sleep(5000);

			// click on the Environmental Reports option
			click("envreportoption_XPATH");
			 
			 
			 

			// delete the previously created environmental reports
			List<WebElement> reportList = driver.findElements(
					By.xpath("//table[@id='environmentalDocumentListTable']//tbody[@class='drop-task']//tr"));
			int reportCount = reportList.size();

			for (int i = 0; i < reportCount; i++) {

				// click on the first environmental report
				driver.findElement(By.xpath(
						"//table[@id='environmentalDocumentListTable']//tbody[@class='drop-task']//tr[1]//td[3]"))
						.click();
				 
				 

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

			// select the respective option from the category dropdown
			select("propertysummary_recentdocument_categorydd_XPATH", data.get("category_1"));
			 
			 

			// click on the choose button
			click("propertysummary_recentdocument_choosebtn_XPATH");
			 
			 

			// wait for the element
			explicitWait("propertysummary_recentdocument_propertynametitle_XPATH");

			// validate the user navigate on the environmental report
			switchVerification("propertysummary_recentdocument_propertynametitle_XPATH",
					"[DND] AAAA Risk Test Prop 01 - 01", "The [DND] AAAA Risk Test Prop 01 - 01 is not displayed.");

			// click on the attachment tab
			click("propertysummary_recentdocument_environmental_attachmenttab_XPATH");
			 
			 

			// validate the count of the attachment
			switchVerification("propertysummary_recentdocument_environmental_attachmentcount_XPATH", "1",
					"The count of the document is not displayed correctly.");

			// click on the details tab
			click("propertysummary_recentdocument_environmental_detailstab_XPATH");
			 
			 

			// select the checklist from the type dropdown
			select("envreporttypedd_CSS", data.get("type"));
			 
			 

			// enter the title
			 
			type("envreporttitletxt_CSS", data.get("title"));
			 
			 

			// enter current date in the date field
			LocalDate currentDate = LocalDate.now();
			String currentDate_string = currentDate.toString();
			 
			type("envreportdatetxt_CSS", currentDate_string);
			 
			 

			// enter the company
			 
			type("envreportcompanytxt_CSS", data.get("company"));
			 
			 

			// enter the author
			 
			type("envreportauthortxt_CSS", data.get("author"));
			 
			 

			// scroll down the screen
			 
			scrollByPixel(400);

			// enter the description
			 
			type("envreportdescriptiontxt_CSS", data.get("description"));
			 
			 

			// click on the save report button
			click("propertysummary_recentdocument_environmental_savebtn_XPATH");
			 
			 

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

		// VALIDATE THE DATE AND COLOR INDICATION OF THE DOCUMENT TYPE WITH CURRENT
		// DATE.

		title("VALIDATE THE DATE AND COLOR INDICATION OF THE DOCUMENT TYPE WITH CURRENT DATE.");

		try {

			// click on the property one
			click("propertysummary_property1_XPATH");
			 
			 

			// wait for the element
			Thread.sleep(5000);

			try {
				// validate the newly created environmental report from the recent document card
				List<WebElement> documentList = driver
						.findElements(By.xpath(OR.getProperty("propertysummary_recentdocument_list_XPATH")));
				int documentCount = documentList.size();

				for (int i = 0; i < documentCount; i++) {

					String documentName = (documentList.get(i).getText()).trim();

					if (documentName.equals(data.get("type"))) {
						successMessage("The correct document type is displayed successfully.");

						// validate the color of the document type
						try {
							boolean greenColor = driver
									.findElement(By.xpath(
											OR.getProperty("propertysummary_recentdocument_list_greencolor_XPATH")))
									.isDisplayed();

							if (greenColor == true) {

								successMessage("The document type is displayed with the green color successfully.");

							} else {
								verificationFailedMessage("The document type is not displayed with the green color.");
							}

						} catch (Throwable t) {
							verificationFailedMessage("The document type is not displayed with the green color.");
						}

						// validate the date of the document type
						try {
							LocalDate currentDate1 = LocalDate.now();
							String currentDate1_string = currentDate1.toString();

							String currentDate1_actual = (driver
									.findElement(
											By.xpath(OR.getProperty("propertysummary_recentdocument_list_date_XPATH")))
									.getText()).trim();

							if (currentDate1_string.equals(currentDate1_actual)) {

								successMessage("The date of the document type is displayed correctly.");

							} else {
								verificationFailedMessage("The date of the document type is not displayed correctly.");
							}

						} catch (Throwable t) {
							verificationFailedMessage("The date of the document type is not displayed correctly.");
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

		// UPDATE THE DATE OF THE ENVIRONMENTAL REPORT WITH PAST DATE FROM THE
		// ENVIRONMENTAL MODULE

		title("UPDATE THE DATE OF THE ENVIRONMENTAL REPORT WITH PAST DATE FROM THE ENVIRONMENTAL MODULE");

		try {

			// click on the environmental icon from the property list page
			click("environmentalicon_CSS");
			 
			 
			 

			// wait for the element
			Thread.sleep(5000);

			// click on the burger menu
			click("menubtn_CSS");
			 
			 

			// wait for the element
			Thread.sleep(5000);

			// click on the Environmental Reports option
			click("envreportoption_XPATH");
			 
			 
			 

			// enter the newly created environmental report in the search field
			 
			type("task_listofchecklist_filterfield_CSS", data.get("title"));
			 
			 

			// click on the searched report
			click("propertysummary_recentdocument_environmental_addedreport2_XPATH");
			 
			 

			// enter past date in the date field
			LocalDate pastDate = LocalDate.now().minusDays(10);
			String pastDate_string = pastDate.toString();
			 
			type("envreportdatetxt_CSS", pastDate_string);
			 
			 

			// click on the update button
			click("propertysummary_recentdocument_environmental_updatebtn_XPATH");
			 
			 

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

		// VALIDATE THE DATE AND COLOR INDICATION OF THE DOCUMENT TYPE WITH PAST
		// DATE.

		title("VALIDATE THE DATE AND COLOR INDICATION OF THE DOCUMENT TYPE WITH PAST DATE.");

		try {

			// click on the property one
			click("propertysummary_property1_XPATH");
			 
			 

			// wait for the element
			Thread.sleep(5000);

			try {
				// validate the newly created environmental report from the recent document card
				List<WebElement> documentList = driver
						.findElements(By.xpath(OR.getProperty("propertysummary_recentdocument_list_XPATH")));
				int documentCount = documentList.size();

				for (int i = 0; i < documentCount; i++) {

					String documentName = (documentList.get(i).getText()).trim();

					if (documentName.equals(data.get("type"))) {
						successMessage("The correct document type is displayed successfully.");

						// validate the color of the document type
						try {

							boolean greenColor = driver
									.findElement(By.xpath(
											OR.getProperty("propertysummary_recentdocument_list_greencolor_XPATH")))
									.isDisplayed();

							if (greenColor == true) {

								successMessage("The document type is displayed with the green color successfully.");

							} else {
								verificationFailedMessage("The document type is not displayed with the green color.");
							}

						} catch (Throwable t) {
							verificationFailedMessage("The document type is not displayed with the green color.");
						}

						// validate the date of the document type

						try {
							LocalDate pastDate1 = LocalDate.now().minusDays(10);
							String pastDate1_string = pastDate1.toString();

							String pastDate1_actual = (driver
									.findElement(
											By.xpath(OR.getProperty("propertysummary_recentdocument_list_date_XPATH")))
									.getText()).trim();

							if (pastDate1_string.equals(pastDate1_actual)) {

								successMessage("The date of the document type is displayed correctly.");

							} else {
								verificationFailedMessage("The date of the document type is not displayed correctly.");
							}

						} catch (Throwable t) {
							verificationFailedMessage("The date of the document type is not displayed correctly.");
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

		// UPDATE THE DATE OF THE ENVIRONMENTAL REPORT WITH FUTURE DATE FROM THE
		// PROPERTY SUMMARY DASHBOARD SCREEN

		title("UPDATE THE DATE OF THE ENVIRONMENTAL REPORT WITH PAST DATE FROM THE PROPERTY SUMMARY DASHBOARD SCREEN");

		try {

			// click on the property one
			click("propertysummary_property1_XPATH");
			 
			 

			// wait for the element
			Thread.sleep(5000);

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
						 
						 

						// enter future date in the date field
						LocalDate futureDate = LocalDate.now().plusDays(10);
						String futureDate_string = futureDate.toString();
						 
						type("envreportdatetxt_CSS", futureDate_string);
						 
						 

						// click on the update button
						click("propertysummary_recentdocument_environmental_updatebtn_XPATH");
						 
						 

						// wait for the element
						explicitWaitClickable("closetoastmsg_CSS");

						// click on the toaster close button
						click("closetoastmsg_CSS");
						 
						 

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

		// VALIDATE THE DATE AND COLOR INDICATION OF THE DOCUMENT TYPE WITH FUTURE
		// DATE.

		title("VALIDATE THE DATE AND COLOR INDICATION OF THE DOCUMENT TYPE WITH FUTURE DATE.");

		try {

			// click on the property one
			click("propertysummary_property1_XPATH");
			 
			 

			// wait for the element
			Thread.sleep(5000);

			try {
				// validate the newly created environmental report from the recent document card
				List<WebElement> documentList = driver
						.findElements(By.xpath(OR.getProperty("propertysummary_recentdocument_list_XPATH")));
				int documentCount = documentList.size();

				for (int i = 0; i < documentCount; i++) {

					String documentName = (documentList.get(i).getText()).trim();

					if (documentName.equals(data.get("type"))) {
						successMessage("The correct document type is displayed successfully.");

						// validate the color of the document type
						try {

							boolean redColor = driver
									.findElement(By.xpath(
											OR.getProperty("propertysummary_recentdocument_list_redcolor_XPATH")))
									.isDisplayed();

							if (redColor == true) {

								successMessage("The document type is displayed with the red color successfully.");

							} else {
								verificationFailedMessage("The document type is not displayed with the red color.");
							}

						} catch (Throwable t) {
							verificationFailedMessage("The document type is not displayed with the red color.");
						}

						// validate the date of the document type

						try {

							String futureDate1_actual = (driver
									.findElement(
											By.xpath(OR.getProperty("propertysummary_recentdocument_list_date_XPATH")))
									.getText()).trim();

							if (futureDate1_actual.equals("-")) {

								successMessage("The date of the document type is not displayed as expected.");

							} else {
								verificationFailedMessage("The date of the document type is displayed.");
							}

						} catch (Throwable t) {
							verificationFailedMessage("The date of the document type is displayed.");
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

		// DELETE THE NEWLY CREATED ENVIRONMETAL REPORT

		title("DELETE THE NEWLY CREATED ENVIRONMETAL REPORT");

		try {

			// click on the environmental icon from the property list page
			click("environmentalicon_CSS");
			 
			 
			 

			// wait for the element
			Thread.sleep(5000);

			// click on the burger menu
			click("menubtn_CSS");
			 
			 

			// wait for the element
			Thread.sleep(5000);

			// click on the Environmental Reports option
			click("envreportoption_XPATH");
			 
			 
			 

			// enter the newly created environmental report in the search field
			 
			type("task_listofchecklist_filterfield_CSS", data.get("title"));
			 
			 

			// click on the searched report
			click("propertysummary_recentdocument_environmental_addedreport2_XPATH");
			 
			 

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
			helper.deleteVerification("propertysummary_recentdocument_environmental_addedreport2_XPATH",
					data.get("title"));

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
