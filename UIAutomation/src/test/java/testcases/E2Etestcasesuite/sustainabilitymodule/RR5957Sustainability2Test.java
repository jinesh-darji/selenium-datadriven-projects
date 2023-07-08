package testcases.E2Etestcasesuite.sustainabilitymodule;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Hashtable;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.SkipException;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import base.Helper;
import base.TestBase;
import utilities.TestUtil;

public class RR5957Sustainability2Test extends TestBase {

	@Test(dataProviderClass = TestUtil.class, dataProvider = "dp")
	public void rR5957Sustainability2Test(Hashtable<String, String> data) throws IOException, InterruptedException {

		execution(data, "rR5957Sustainability2Test");

		// PERFORMED CRUD OPERATION OF THE DOCUMENTS/REPORTS MODULE - AT BUILDING LEVEL

		System.out.println("PERFORMED CRUD OPERATION OF THE DOCUMENTS/REPORTS MODULE - AT BUILDING LEVEL");
		test.log(LogStatus.INFO, "PERFORMED CRUD OPERATION OF THE DOCUMENTS/REPORTS MODULE - AT BUILDING LEVEL");
		Reporter.log("PERFORMED CRUD OPERATION OF THE DOCUMENTS/REPORTS MODULE - AT BUILDING LEVEL");
		log.info("PERFORMED CRUD OPERATION OF THE DOCUMENTS/REPORTS MODULE - AT BUILDING LEVEL");

		Helper helper = new Helper();

		// refresh the page
		driver.navigate().refresh();
		explicitWait("sustainabilityicon_CSS");
		driver.navigate().refresh();

		System.out.println("Navigate to the Home Screen i.e. Property List Screen.");

		// CREATE NEW DOCUMENTS/REPORTS RECORD - AT PROPERTY LEVEL

		System.out
				.println("***************** CREATE NEW DOCUMENTS/REPORTS RECORD - AT PROPERTY LEVEL *****************");
		test.log(LogStatus.INFO,
				"***************** CREATE NEW DOCUMENTS/REPORTS RECORD - AT PROPERTY LEVEL *****************");
		Reporter.log("***************** CREATE NEW DOCUMENTS/REPORTS RECORD - AT PROPERTY LEVEL *****************");
		log.info("***************** CREATE NEW DOCUMENTS/REPORTS RECORD - AT PROPERTY LEVEL *****************");

		try {
			// click on the Sustainability icon
			click("sustainabilityicon_CSS");
			System.out.println("Clicked on the Sustainability icon.");
			ngDriver.waitForAngularRequestsToFinish();

			// wait for the element
			Thread.sleep(5000);

			// click on the side menu
			click("ssc_leftsidemenubtn_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the side menu.");

			// wait for the element
			Thread.sleep(5000);

			// click on the document/reports option
			click("sustainability_sidemenu_documentreportoption_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the document/reports option.");

			// click on the add button
			click("sustainability_addbtn_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the add button.");

			// enter the document/report title
			type("sustainability_add_documentreporttitletxt_XPATH", data.get("documentreport_title_property"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the document/report title.");

			// select the type from the dropdown
			select("sustainability_add_typedd_XPATH", data.get("type_property"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Selected the type from the dropdown.");

			// click on the date field
			click("sustainability_add_datetxt_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the date field.");

			// click on the today button
			click("sustainability_add_datetxt_todatbtn_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the today button.");

			// enter the description
			type("sustainability_add_descriptiontxt_XPATH", data.get("description_property"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the description.");

			// click on the save button
			click("sustainability_add_savebtn_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the save button.");

			// enter the newly created document/report record in the search field
			type("sustainability_searchtxt_XPATH", data.get("documentreport_title_property"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the newly created document/report record in the search field.");

			// verify the newly created document/report record displayed or not at property
			// level
			switchVerification("sustainability_searchedrecord_plevel_XPATH", "Test Document and Report Title Property",
					"The Test Document and Report Title Property record is not displayed.");

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

		// CREATE NEW DOCUMENTS/REPORTS RECORD - AT BUILDING LEVEL

		System.out
				.println("***************** CREATE NEW DOCUMENTS/REPORTS RECORD - AT BUILDING LEVEL *****************");
		test.log(LogStatus.INFO,
				"***************** CREATE NEW DOCUMENTS/REPORTS RECORD - AT BUILDING LEVEL *****************");
		Reporter.log("***************** CREATE NEW DOCUMENTS/REPORTS RECORD - AT BUILDING LEVEL *****************");
		log.info("***************** CREATE NEW DOCUMENTS/REPORTS RECORD - AT BUILDING LEVEL *****************");

		try {
			// click on the Sustainability icon
			click("sustainabilityicon_CSS");
			System.out.println("Clicked on the Sustainability icon.");
			ngDriver.waitForAngularRequestsToFinish();

			// wait for the element
			Thread.sleep(5000);

			// click on the side menu
			click("ssc_leftsidemenubtn_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the side menu.");

			// wait for the element
			Thread.sleep(5000);

			// click on the document/reports option
			click("sustainability_sidemenu_documentreportoption_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the document/reports option.");

			// wait for the element
			Thread.sleep(5000);

			// select the building from the top dropdown
			select("task_addedtask_propertybuildingdd_CSS", data.get("property_dd_building"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Selected the building from the top dropdown.");

			// click on the add button
			click("sustainability_addbtn_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the add button.");

			// enter the document/report title
			type("sustainability_add_documentreporttitletxt_XPATH", data.get("documentreport_title_building"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the document/report title.");

			// select the type from the dropdown
			select("sustainability_add_typedd_XPATH", data.get("type_building"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Selected the type from the dropdown.");

			// click on the date field
			click("sustainability_add_datetxt_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the date field.");

			// click on the today button
			click("sustainability_add_datetxt_todatbtn_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the today button.");

			// enter the description
			type("sustainability_add_descriptiontxt_XPATH", data.get("description_building"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the description.");

			// click on the save button
			click("sustainability_add_savebtn_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the save button.");

			// enter the newly created document/report record in the search field
			clear("sustainability_searchtxt_XPATH");
			type("sustainability_searchtxt_XPATH", data.get("documentreport_title_building"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the newly created document/report record in the search field.");

			// verify the newly created document/report record displayed or not at building
			// level
			switchVerification("sustainability_searchedrecord_blevel_XPATH", "Test Document and Report Title Building",
					"The Test Document and Report Title Building record is not displayed.");

			// enter the newly created document/report record in the search field
			clear("sustainability_searchtxt_XPATH");
			type("sustainability_searchtxt_XPATH", data.get("documentreport_title_property"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the newly created document/report record in the search field.");

			// verify the newly created document/report record displayed or not at property
			// level
			try {

				String deleteElement = driver
						.findElement(By.xpath(OR.getProperty("sustainability_searchedrecord_plevel_XPATH"))).getText();

				if (deleteElement.equals("Test Document and Report Title Property")) {

					Assert.assertTrue(
							isElementPresent(By.xpath(OR.getProperty("sustainability_searchedrecord_plevel_XPATH"))),
							"The Test Document and Report Title Property is displayed.");

					TestUtil.captureScreenshot();

					// ReportNG
					Reporter.log(
							"<br>" + "The  Test Document and Report Title Property is displayed at building level : "
									+ "<br>");
					Reporter.log("<a target=\"_blank\" href=" + TestUtil.screenshotName + "><img src="
							+ TestUtil.screenshotName + " height=200 width=200></img></a>");
					Reporter.log("<br>");
					Reporter.log("<br>");

					// Extent Report
					test.log(LogStatus.FAIL,
							" The Test Document and Report Title Property is displayed at building level : ");
					test.log(LogStatus.FAIL, test.addScreenCapture(TestUtil.screenshotName));

					System.out.println("The Test Document and Report Title Property is displayed at building level.");
					log.info("The Test Document and Report Title Property is displayed at building level.");

				}
			} catch (Throwable t) {
				System.out.println(
						"The Test Document and Report Title Property is not displayed at building level as expected.");
				test.log(LogStatus.INFO,
						"The Test Document and Report Title Property is not displayed at building level as expected.");
				Reporter.log(
						"The Test Document and Report Title Property is not displayed at building level as expected.");
				log.info("The Test Document and Report Title Property is not displayed at building level as expected.");
			}

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

		// UPDATE THE NEWLY CREATED DOCUMENT / REPORT RECORD - AT BUILDING LEVEL

		System.out.println(
				"***************** UPDATE THE NEWLY CREATED DOCUMENT / REPORT RECORD - AT BUILDING LEVEL *****************");
		test.log(LogStatus.INFO,
				"***************** UPDATE THE NEWLY CREATED DOCUMENT / REPORT RECORD - AT BUILDING LEVEL *****************");
		Reporter.log(
				"***************** UPDATE THE NEWLY CREATED DOCUMENT / REPORT RECORD - AT BUILDING LEVEL *****************");
		log.info(
				"***************** UPDATE THE NEWLY CREATED DOCUMENT / REPORT RECORD - AT BUILDING LEVEL *****************");

		try {

			// click on the Sustainability icon
			click("sustainabilityicon_CSS");
			System.out.println("Clicked on the Sustainability icon.");
			ngDriver.waitForAngularRequestsToFinish();

			// wait for the element
			Thread.sleep(5000);

			// click on the side menu
			click("ssc_leftsidemenubtn_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the side menu.");

			// wait for the element
			Thread.sleep(5000);

			// click on the document/reports option
			click("sustainability_sidemenu_documentreportoption_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the document/reports option.");

			// wait for the element
			Thread.sleep(5000);

			// select the building from the top dropdown
			select("task_addedtask_propertybuildingdd_CSS", data.get("property_dd_building"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Selected the building from the top dropdown.");

			// enter the newly created document/report record in the search field
			clear("sustainability_searchtxt_XPATH");
			type("sustainability_searchtxt_XPATH", data.get("documentreport_title_building"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the newly created document/report record in the search field.");

			// click on the newly created document / report record
			click("sustainability_searchedrecord_blevel_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the newly created document / report record.");

			// update the document/report title
			clear("sustainability_add_documentreporttitletxt_XPATH");
			type("sustainability_add_documentreporttitletxt_XPATH", data.get("update_documentreport_title_building"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the document/report title.");

			// select the type from the dropdown
			select("sustainability_add_typedd_XPATH", data.get("update_type_building"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Selected the type from the dropdown.");

			// enter the updated date field
			LocalDate currentDate = LocalDate.now();
			LocalDate pastDate = currentDate.minusDays(6);
			String pastDateString = pastDate.toString();
			type("sustainability_add_datetxt_XPATH", pastDateString);
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the date field.");

			// update the description
			type("sustainability_add_descriptiontxt_XPATH", data.get("update_description_building"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the description.");

			// click on the save button
			click("sustainability_add_savebtn_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the save button.");

			// enter the updated document/report record in the search field
			clear("sustainability_searchtxt_XPATH");
			type("sustainability_searchtxt_XPATH", data.get("update_documentreport_title_building"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the updated document/report record in the search field.");

			// verify the updated document/report record displayed or not
			switchVerification("sustainability_searchedrecord_updated_blevel_XPATH",
					"Update Test Document and Report Title Building",
					"The Update Test Document and Report Title Building record is not displayed.");

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

		// DELETE THE UPDATED DOCUMENTS / REPORTS RECORD - AT PROPERTY AND BUILDING
		// LEVEL

		System.out.println(
				"***************** DELETE THE UPDATED DOCUMENTS / REPORTS RECORD - AT PROPERTY AND BUILDING LEVEL *****************");
		test.log(LogStatus.INFO,
				"***************** DELETE THE UPDATED DOCUMENTS / REPORTS RECORD - AT PROPERTY AND BUILDING LEVEL *****************");
		Reporter.log(
				"***************** DELETE THE UPDATED DOCUMENTS / REPORTS RECORD - AT PROPERTY AND BUILDING LEVEL *****************");
		log.info(
				"***************** DELETE THE UPDATED DOCUMENTS / REPORTS RECORD - AT PROPERTY AND BUILDING LEVEL *****************");

		try {

			// click on the Sustainability icon
			click("sustainabilityicon_CSS");
			System.out.println("Clicked on the Sustainability icon.");
			ngDriver.waitForAngularRequestsToFinish();

			// wait for the element
			Thread.sleep(5000);

			// click on the side menu
			click("ssc_leftsidemenubtn_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the side menu.");

			// wait for the element
			Thread.sleep(5000);

			// click on the document/reports option
			click("sustainability_sidemenu_documentreportoption_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the document/reports option.");

			// select the building from the top dropdown
			select("task_addedtask_propertybuildingdd_CSS", data.get("property_dd_building"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Selected the building from the top dropdown.");

			// enter the newly created document/report record in the search field
			clear("sustainability_searchtxt_XPATH");
			type("sustainability_searchtxt_XPATH", data.get("update_documentreport_title_building"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the newly created document/report record in the search field.");

			// click on the updated documents/reports record
			click("sustainability_searchedrecord_updated_blevel_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the updated documents/reports record.");

			// wait for the element
			explicitWaitClickable("sustainability_deletebtn_XPATH");

			// click on the delete button
			click("sustainability_deletebtn_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the delete button.");

			// wait for the element
			explicitWaitClickable("sustainability_deletebtn_confirmation_XPATH");

			// click on the delete button of the confirmation popup
			click("sustainability_deletebtn_confirmation_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the delete button of the confirmation popup.");

			// wait for the element
			explicitWaitClickable("closetoastmsg_CSS");

			// click on the toaster close button
			click("closetoastmsg_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the toaster close button.");

			// enter the updated document/report record in the search field
			clear("sustainability_searchtxt_XPATH");
			type("sustainability_searchtxt_XPATH", data.get("update_documentreport_title_building"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the updated document/report record in the search field.");

			// verify the deleted document/report record displayed or not
			helper.deleteVerification("sustainability_searchedrecord_updated_blevel_XPATH",
					"Update Test Document and Report Title Building");

			// select the property from the top dropdown
			select("task_addedtask_propertybuildingdd_CSS", data.get("property_dd_property"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Selected the property from the top dropdown.");

			// enter the newly created document/report record in the search field
			clear("sustainability_searchtxt_XPATH");
			type("sustainability_searchtxt_XPATH", data.get("documentreport_title_property"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the newly created document/report record in the search field.");

			// click on the documents/reports record
			click("sustainability_searchedrecord_plevel_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the updated documents/reports record.");

			// wait for the element
			explicitWaitClickable("sustainability_deletebtn_XPATH");

			// click on the delete button
			click("sustainability_deletebtn_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the delete button.");

			// wait for the element
			explicitWaitClickable("sustainability_deletebtn_confirmation_XPATH");

			// click on the delete button of the confirmation popup
			click("sustainability_deletebtn_confirmation_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the delete button of the confirmation popup.");

			// wait for the element
			explicitWaitClickable("closetoastmsg_CSS");

			// click on the toaster close button
			click("closetoastmsg_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the toaster close button.");

			// enter the newly created document/report record in the search field
			clear("sustainability_searchtxt_XPATH");
			type("sustainability_searchtxt_XPATH", data.get("documentreport_title_property"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the newly created document/report record in the search field.");

			// verify deleted document/report record displayed or not
			helper.deleteVerification("sustainability_searchedrecord_plevel_XPATH",
					"Test Document and Report Title Property");

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

	}
}
