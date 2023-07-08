package testcases.smokesuite;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Random;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;
import org.testng.SkipException;
import org.testng.annotations.Test;

import com.opencsv.CSVReader;
import com.paulhammant.ngwebdriver.ByAngularBinding.NgFindByBuilder;
import com.relevantcodes.extentreports.LogStatus;

import base.TestBase;
import utilities.TestUtil;

public class RR5595Morguard5Test extends TestBase {

	@Test(dataProviderClass = TestUtil.class, dataProvider = "dp")
	public void rR5595Morguard5Test(Hashtable<String, String> data) throws IOException, InterruptedException {

		execution(data, "rR5595Morguard5Test");

		// refresh the page
		driver.navigate().refresh();
		Thread.sleep(5000);
		driver.navigate().refresh();

		// LOGIN WITH ADMIN USER
		title("LOGIN WITH ADMIN USER");

		try {
			// wait for the element
			explicitWaitClickable("signinbtn_BTNTEXT");

			// Enter the username
			type("usernametxt_CSS", data.get("username_1"));

			// Enter the password
			type("passwordtxt_CSS", data.get("password_1"));

			// Clicking on the "Sign In" button
			click("signinbtn_BTNTEXT");

			// wait for the element
			explicitWait("propertylist_title_XPATH");

			// verify the property list
			switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

			// UPDATE THE SYSTEM COMPANY

			updateCompany(data);

		} catch (Throwable t) {
			verificationFailed();
		}

		// THE GENERATED REPORT SHOULD DISPLAY ALL THE SELECTED FIELDS INCLUDED IN THE
		// DISPLAYED FIELDS PANEL. EXPORT REPORT AS EXCEL OR PDF.
		title("THE GENERATED REPORT SHOULD DISPLAY ALL THE SELECTED FIELDS INCLUDED IN THE DISPLAYED FIELDS PANEL. EXPORT REPORT AS EXCEL OR PDF.");

		try {

			// wait for the element
			Thread.sleep(5000);

			// click on the side menu
			click("ssc_leftsidemenubtn_CSS");

			// wait for the element
			Thread.sleep(5000);

			// click on the report option
			click("sidemenu_reports_CSS");

			// click on the risk report builder option
			click("sidemenu_reports_riskreportbuilderoption_XPATH");

			// click on the add button
			click("sidemenu_reports_addbtn_XPATH");

			// enter the report name
			type("sidemenu_reports_reportnametxt_XPATH", data.get("report_name"));

			// select the base type
			select("sidemenu_reports_basetypedd_XPATH", data.get("base_type"));

			// wait for the element
			Thread.sleep(3000);

			// select the report type
			select("sidemenu_reports_reporttypedd_XPATH", data.get("report_type"));

			// click on the continue button
			click("sidemenu_reports_continuebtn_XPATH");

			// verify title of the screen
			switchVerification("sidemenu_reports_addreportscreentitle_XPATH", "Add Report Configuration",
					"The Add Report Configuration is not displayed.");

			// select the new source
			select("sidemenu_reports_addnewsourcedd_XPATH", data.get("new_resource"));

			// click on the add button
			click("sidemenu_reports_propertystatuslbl_addnewsourcebtn_XPATH");

			// scroll down the screen
			scrollTillElement("sidemenu_reports_propertystatuslbl_XPATH");
			scrollByPixel(-400);

			// select the filter
			select("sidemenu_reports_propertystatuslbl_filterdd_XPATH", data.get("filter"));

			// click on the select status field
			click("sidemenu_reports_propertystatuslbl_selectstatustxt_XPATH");

			// click on the none button
			click("task_tasktag_nonebtn_CSS");

			// enter the status
			type("sidemenu_reports_propertystatuslbl_selectstatus_searchtxt_XPATH", data.get("inactive_status"));

			// click on the searched inactive option
			click("sidemenu_reports_propertystatuslbl_selectstatus_seachedinactiveoption_XPATH");

			// click on the select status field
			click("sidemenu_reports_propertystatuslbl_selectstatustxt_XPATH");

			// click on the add field button
			click("sidemenu_reports_propertystatuslbl_selectstatus_addfieldbtn_XPATH");

			// click on the add address field button
			click("sidemenu_reports_propertystatuslbl_selectstatus_addfieldbtn_address_XPATH");

			// click on the add city field button
			click("sidemenu_reports_propertystatuslbl_selectstatus_addfieldbtn_city_XPATH");

			// click on the add province field button
			click("sidemenu_reports_propertystatuslbl_selectstatus_addfieldbtn_province_XPATH");

			// click on the add country field button
			click("sidemenu_reports_propertystatuslbl_selectstatus_addfieldbtn_country_XPATH");

			// scroll up the screen
			scrollTop();

			// click on the report button
			click("sidemenu_reports_propertystatuslbl_reportbtn_XPATH");

			// verify the number of records in the table

			int totalRecord = 0;
			int totalColumn = 0;

			try {
				boolean paginationAvaibility = driver
						.findElement(By.xpath(OR.getProperty("sidemenu_reports_paginationcount_XPATH"))).isDisplayed();

				if (paginationAvaibility == true) {

					String pagination = driver
							.findElement(By.xpath(OR.getProperty("sidemenu_reports_paginationcount_XPATH"))).getText();
					String[] count = pagination.split(" of ");
					int totalCount = Integer.parseInt(count[1]);

					for (int i = 0; i < totalCount; i++) {
						List<WebElement> numrows = driver
								.findElements(By.xpath(OR.getProperty("sidemenu_reports_numberofrowsreport_XPATH")));
						int singlePageCount = numrows.size();
						totalRecord = totalRecord + singlePageCount;

						click("sidemenu_reports_paginationnextbtn_XPATH");

					}

				} else {

					List<WebElement> numrows = driver
							.findElements(By.xpath(OR.getProperty("sidemenu_reports_numberofrowsreport_XPATH")));
					int singlePageCount = numrows.size();
					totalRecord = totalRecord + singlePageCount;
				}

				// display total number of row
				consoleMessage("THE TOTAL NUMBER OF ROWS ARE : " + totalRecord);

			} catch (Throwable t) {
				List<WebElement> numrows = driver
						.findElements(By.xpath(OR.getProperty("sidemenu_reports_numberofrowsreport_XPATH")));
				int singlePageCount = numrows.size();
				totalRecord = totalRecord + singlePageCount;

				// display total number of row
				consoleMessage("THE TOTAL NUMBER OF ROWS ARE : " + totalRecord);
			}

			try {
				// verify the number of columns in the table
				List<WebElement> numcolumns = driver
						.findElements(By.xpath(OR.getProperty("sidemenu_reports_numberofcolumnsreport_XPATH")));
				totalColumn = numcolumns.size();

				// display total number of row
				consoleMessage("THE TOTAL NUMBER OF COLUMNS ARE : " + totalColumn);

			} catch (Throwable t) {
				verificationFailed();
			}

			// click on the extract as csv button
			click("sidemenu_reports_propertystatuslbl_extractascsvbtn_XPATH");

			// wait for the 5 seconds
			Thread.sleep(5000);

			// read the download file

			File file = getLatestFilefromDir("C:\\Users\\Jinesh\\Downloads");
			String csvFileName = file.getName();
			consoleMessage("CSV File Downloaded is :- " + csvFileName);

			// Create an object of CSVReader
			CSVReader csvReader = new CSVReader(new FileReader("C:\\Users\\Jinesh\\Downloads\\" + csvFileName));

			// verify the number of rows in csv file
			List<String[]> rows = csvReader.readAll();
			int csvRowCount = rows.size();
			consoleMessage("Total rows which we have " + csvRowCount);
			consoleMessage("CSV ROWS::::::::::::::::::" + csvRowCount);

			// validate the rows count

			if (totalRecord == csvRowCount) {
				successMessage("NUMBER OF ROWS ARE DISPLAYED CORRECT IN EXTRACTED CSV REPORT");
			} else {

				verificationFailedMessage("NUMBER OF ROWS ARE NOT DISPLAYED CORRECT IN EXTRACTED CSV REPORT");
			}

//			// validate the columns count
//
//			if (totalColumn == csvColumnCount) {
//				successMessage(
//						"NUMBER OF COLUMNS ARE DISPLAYED CORRECT IN EXTRACTED CSV REPORT");
//			} else {
//
//				verificationFailedMessage("NUMBER OF COLUMNS ARE NOT DISPLAYED CORRECT IN EXTRACTED CSV REPORT");
//			}

			// click on the save button
			click("sidemenu_reports_savebtn_XPATH");

			// enter the newly created report in the search field
			type("sidemenu_reports_searchtxt_XPATH", data.get("report_name"));

			// verify the newly created report
			switchVerification("sidemenu_reports_searchedreport_XPATH", "Test Report Name",
					"The Test Report Name report is not displayed.");

			// click on the delete button
			click("sidemenu_reports_deletebtn_XPATH");

			// click on the delete button of the confirmation
			click("sidemenu_reports_confirmationdeletebtn_XPATH");

			// wait for the element
			explicitWaitClickable("closetoastmsg_CSS");

			// click on the toaster close button
			click("closetoastmsg_CSS");

			// verify the deleted report is displayed or not
			deleteVerification("sidemenu_reports_searchedreport_XPATH", "Test Report Name");

		} catch (Throwable t) {
			verificationFailed();
		}

		// click on the home icon from the top of the screen
		click("questionnaire_homeburgermenubtn_hide_CSS");

		// synchronization
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// SPOT CHECK TO SEE THAT THE COMPLIANCE DOCUMENT IS PRESENT FOR EACH CATEGORY
		// FOR EACH PROVINCE
		title("SPOT CHECK TO SEE THAT THE COMPLIANCE DOCUMENT IS PRESENT FOR EACH CATEGORY FOR EACH PROVINCE");

		try {

			// wait for the element
			Thread.sleep(5000);

			// click on the side menu
			click("ssc_leftsidemenubtn_CSS");

			// wait for the element
			Thread.sleep(5000);

			// click on the compliance option
			click("sidemenu_compliance_CSS");

			// click on the regulation details button
			click("sidemenu_compliance_regulationdetailsbtn_XPATH");

			// click on the module button
			click("sidemenu_compliance_moduledd_XPATH");

			// click on the environmental option
			click("sidemenu_compliance_moduledd_environmentaloption_XPATH");

			// get all the options of the country drop down
			Select countrydd = new Select(
					driver.findElement(By.xpath(OR.getProperty("sidemenu_compliance_countrymenudd_XPATH"))));
			List<WebElement> countryList = countrydd.getOptions();
			List<String> countryListStrings = new ArrayList<String>();
			for (WebElement dd1 : countryList) {

				String filterCountryListStrings = dd1.getText();

				if (!(filterCountryListStrings.equals(""))) {

					countryListStrings.add(dd1.getText());
				}

			}

			int countryCount = countryListStrings.size();
			consoleMessage("Total number of countries are: " + countryCount);

			for (int i = 0; i < countryCount; i++) {

				countrydd.selectByVisibleText(countryListStrings.get(i));

				// get all the options of the territory drop down
				Select territorydd = new Select(
						driver.findElement(By.xpath(OR.getProperty("sidemenu_compliance_territorymenudd_XPATH"))));
				List<WebElement> territoryList = territorydd.getOptions();
				List<String> territoryListStrings = new ArrayList<String>();

				for (WebElement dd2 : territoryList) {

					String filterTerritoryListStrings = dd2.getText();

					if (!(filterTerritoryListStrings.equals(""))) {

						territoryListStrings.add(dd2.getText());
					}

				}

				int territoryCount = territoryListStrings.size();

				for (int j = 0; j < territoryCount; j++) {

					territorydd.selectByVisibleText(territoryListStrings.get(j));

					// get all the options of the category drop down
					Select categorydd = new Select(
							driver.findElement(By.xpath(OR.getProperty("sidemenu_compliance_categorymenudd_XPATH"))));
					List<WebElement> categoryList = categorydd.getOptions();
					List<String> categoryListStrings = new ArrayList<String>();

					for (WebElement dd3 : categoryList) {

						String filterCategoryListStrings = dd3.getText();

						if (!(filterCategoryListStrings.equals(""))) {

							categoryListStrings.add(dd3.getText());
						}

					}

					int categoryCount = categoryListStrings.size();
					consoleMessage("The " + territoryListStrings.get(j) + " of the " + countryListStrings.get(i)
							+ " has " + categoryCount + " categories.");

					for (int k = 0; k < categoryCount; k++) {

						categorydd.selectByVisibleText(categoryListStrings.get(k));

						try {
							// verify selected quarter are displayed
							boolean selectedQuarter = driver
									.findElement(By.xpath(OR.getProperty("sidemenu_compliance_selectedqueter_XPATH")))
									.isDisplayed();

							if (selectedQuarter == true) {
								successMessage("THE DEFAULT QUARTER OF THE COUNTRY: " + countryListStrings.get(i)
										+ " , TERRITORY: " + territoryListStrings.get(j) + " , CATEGORY: "
										+ categoryListStrings.get(k) + " IS DISPLAYED SELECTED SUCCESSFULLY.");
							} else {

								verificationFailedMessage("THE DEFAULT QUARTER OF THE COUNTRY: "
										+ countryListStrings.get(i) + " , TERRITORY: " + territoryListStrings.get(j)
										+ " , CATEGORY: " + categoryListStrings.get(k) + " IS NOT DISPLAYED SELECTED.");
								break;
							}
						} catch (Throwable t) {
							verificationFailedMessage("THE DEFAULT QUARTER OF THE COUNTRY: " + countryListStrings.get(i)
									+ " , TERRITORY: " + territoryListStrings.get(j) + " , CATEGORY: "
									+ categoryListStrings.get(k) + " IS NOT DISPLAYED SELECTED.");

							break;
						}

						// scroll down the screen
						scrollByPixel(500);

						try {
							// verify respective document is displayed
							boolean documentLink = driver
									.findElement(By.xpath(OR.getProperty("sidemenu_compliance_documentlbl_XPATH")))
									.isDisplayed();

							if (documentLink == true) {
								successMessage("THE DOCUMENT LINK OF THE COUNTRY: " + countryListStrings.get(i)
										+ " , TERRITORY: " + territoryListStrings.get(j) + " , CATEGORY: "
										+ categoryListStrings.get(k) + " IS DISPLAYED SELECTED SUCCESSFULLY.");
							} else {

								verificationFailedMessage("THE DOCUMENT LINK OF THE COUNTRY: "
										+ countryListStrings.get(i) + " , TERRITORY: " + territoryListStrings.get(j)
										+ " , CATEGORY: " + categoryListStrings.get(k) + " IS NOT DISPLAYED SELECTED.");
								break;

							}
						} catch (Throwable t) {
							verificationFailedMessage("THE DOCUMENT LINK OF THE COUNTRY: " + countryListStrings.get(i)
									+ " , TERRITORY: " + territoryListStrings.get(j) + " , CATEGORY: "
									+ categoryListStrings.get(k) + " IS NOT DISPLAYED SELECTED.");
							break;
						}

						// scroll UP the screen
						scrollByPixel(-500);
					}
				}
			}
		} catch (Throwable t) {
			verificationFailed();
		}

		// click on the home icon from the top of the screen
		click("questionnaire_homeburgermenubtn_hide_CSS");

		// synchronization
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// RUN A REPORT LIST BASED ON PROPERTY OWNER
		title("RUN A REPORT LIST BASED ON PROPERTY OWNER");

		// DELETE PREVIOUSLY CREATED ENVIRONMENTAL REPORT
		title("DELETE PREVIOUSLY CREATED ENVIRONMENTAL REPORT");

		try {

			// enter the property name in the search field

			type("envreports_propertylist_filtertxt_CSS", data.get("property_4"));

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

			// collect all the report

			List<WebElement> reportList = driver.findElements(By.xpath(OR.getProperty("envreport_totalreports_XPATH")));
			int reportCount = reportList.size();

			consoleMessage("reportCount:::::::::::::::::::" + reportCount);

			for (int i = 1; i <= reportCount; i++) {

				List<WebElement> reportList1 = driver
						.findElements(By.xpath(OR.getProperty("envreport_totalreports_XPATH")));
				int maxProducts = reportList1.size();
				Random random = new Random();
				int randomProduct = random.nextInt(maxProducts);
				reportList1.get(randomProduct).click();

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

		// click on the home icon from the top of the screen
		click("questionnaire_homeburgermenubtn_hide_CSS");

		// synchronization
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// CREATE RANDOM ENVIRONMENTAL REPORTS IN THE PROPERTY 4
		title("CREATE RANDOM ENVIRONMENTAL REPORTS IN THE PROPERTY 4");

		Random random = new Random();
		int reportCount = random.nextInt(5 - 1) + 1;

		try {

			// enter the property name in the search field

			type("envreports_propertylist_filtertxt_CSS", data.get("property_4"));

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

			consoleMessage("reportCount:::::::::::" + reportCount);

			for (int i = 1; i <= reportCount; i++) {

				// click on the Add report button
				click("envreportaddbtn_CSS");

				// select the checklist from the type dropdown
				select("envreporttypedd_CSS", data.get("type"));

				// enter the title
				String s1 = RandomStringUtils.randomAlphabetic(8);

				type("envreporttitletxt_CSS", s1);

				// click on the date field
				click("envreportdatetxt_CSS");

				click("envreporttodaydate_BTNTEXT");

				// enter the company
				type("envreportcompanytxt_CSS", data.get("company"));

				// enter the author
				type("envreportauthortxt_CSS", data.get("author"));

				// scroll down the screen

				scrollByPixel(400);

				// enter the description
				type("envreportdescriptiontxt_CSS", data.get("description"));

				// click on the Add report button
				click("envreportsavebtn_CSS");

				// wait for the element
				explicitWaitClickable("closetoastmsg_CSS");

				// click on the toaster close button
				click("closetoastmsg_CSS");

				// enter the newly created environmental report in the search field

				type("task_listofchecklist_filterfield_CSS", s1);

				// verification of the environmental report is added or not
				String envReport = "//span[text()='" + s1 + "']";

				switchVerification(envReport, s1, "The newly created report is not displayed successfully.");

			}

		} catch (Throwable t) {
			verificationFailed();
		}

		// click on the home icon from the top of the screen
		click("questionnaire_homeburgermenubtn_hide_CSS");

		// synchronization
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// EXTRACT THE CSV FILE, THE REPORT WILL SHOW ALL REPORTS BASED ON THE PROPERTY
		title("EXTRACT THE CSV FILE, THE REPORT WILL SHOW ALL REPORTS BASED ON THE PROPERTY");

		try {

			// enter the property name in the search field

			type("envreports_propertylist_filtertxt_CSS", data.get("property_4"));

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

			// click on the extract excel button
			click("envreport_extractcsvbtn_XPATH");

			// click on the property field
			click("envreport_extractcsvbtn_propertytxt_XPATH");

			// enter property name in the search field
			type("envreport_extractcsvbtn_propertytxt_searchtxt_XPATH", data.get("property_4"));

			// click on the searched property
			click("envreport_extractcsvbtn_propertytxt_searchedproperty_XPATH");

			// enter the created from date
			type("envreport_extractcsvbtn_ownertxt_fromdatecreatetxt_XPATH", "2016-02-12");

			// click on the created to date
			click("envreport_extractcsvbtn_ownertxt_todatecreatetxt_XPATH");

			// click on the today button
			click("envreport_extractcsvbtn_ownertxt_todatecreatetxt_todaybtn_XPATH");

			// click on the extract button
			click("envreport_extractcsvbtn_ownertxt_extractbtn_XPATH");

			// wait for the 5 seconds
			Thread.sleep(5000);

			// read the download file
			File file = getLatestFilefromDir("C:\\Users\\Jinesh\\Downloads");
			String csvFileName = file.getName();
			consoleMessage("CSV File Downloaded is :- " + csvFileName);

			// Create an object of CSVReader
			CSVReader csvReader = new CSVReader(new FileReader("C:\\Users\\Jinesh\\Downloads\\" + csvFileName));

			// verify the number of rows in csv file
			List<String[]> rows = csvReader.readAll();
			int csvRowCount = rows.size();
			int finalcsvRowCount = csvRowCount - 1;
			consoleMessage("Total rows which we have " + finalcsvRowCount);

			consoleMessage("CSV ROWS::::::::::::::::::" + finalcsvRowCount);

			// validate the rows count

			if (reportCount == finalcsvRowCount) {
				successMessage("NUMBER OF ROWS ARE DISPLAYED CORRECT IN EXTRACTED CSV REPORT");
			} else {

				verificationFailedMessage("NUMBER OF ROWS ARE NOT DISPLAYED CORRECT IN EXTRACTED CSV REPORT");
			}

		} catch (Throwable t) {
			verificationFailed();
		}

		// click on the home icon from the top of the screen
		click("questionnaire_homeburgermenubtn_hide_CSS");

		// synchronization
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

	}
}