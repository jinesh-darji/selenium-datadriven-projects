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

		if (!(TestUtil.isTestRunnable("rR5595Morguard5Test", excel))) {

			throw new SkipException(
					"Skipping the test " + "rR5595Morguard5Test".toUpperCase() + "as the Run mode is NO");
		}

		if (!data.get("runmode").equals("Y")) {

			throw new SkipException("Skipping the test case as the Run Mode for data set is NO");
		}

		// refresh the page
		driver.navigate().refresh();
		Thread.sleep(5000);
		driver.navigate().refresh();

		// LOGIN WITH ADMIN USER

		System.out.println("******************** LOGIN WITH ADMIN USER ********************");
		test.log(LogStatus.INFO, "******************** LOGIN WITH ADMIN USER ********************");
		Reporter.log("******************** LOGIN WITH ADMIN USER ********************");
		log.info("******************** LOGIN WITH ADMIN USER ********************");

		try {
			// wait for the element
			explicitWaitClickable("signinbtn_BTNTEXT");

			// Enter the username
			type("usernametxt_CSS", data.get("username_1"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the username.");

			// Enter the password
			type("passwordtxt_CSS", data.get("password_1"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the password.");

			// Clicking on the "Sign In" button
			click("signinbtn_BTNTEXT");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the sign in button.");

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

		System.out.println(
				"******************** THE GENERATED REPORT SHOULD DISPLAY ALL THE SELECTED FIELDS INCLUDED IN THE DISPLAYED FIELDS PANEL. EXPORT REPORT AS EXCEL OR PDF. ********************");
		test.log(LogStatus.INFO,
				"******************** THE GENERATED REPORT SHOULD DISPLAY ALL THE SELECTED FIELDS INCLUDED IN THE DISPLAYED FIELDS PANEL. EXPORT REPORT AS EXCEL OR PDF. ********************");
		Reporter.log(
				"******************** THE GENERATED REPORT SHOULD DISPLAY ALL THE SELECTED FIELDS INCLUDED IN THE DISPLAYED FIELDS PANEL. EXPORT REPORT AS EXCEL OR PDF. ********************");
		log.info(
				"******************** THE GENERATED REPORT SHOULD DISPLAY ALL THE SELECTED FIELDS INCLUDED IN THE DISPLAYED FIELDS PANEL. EXPORT REPORT AS EXCEL OR PDF. ********************");

		try {

			// wait for the element
			Thread.sleep(5000);

			// click on the side menu
			click("ssc_leftsidemenubtn_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the side menu.");

			// wait for the element
			Thread.sleep(5000);

			// click on the report option
			click("sidemenu_reports_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the report option.");

			// click on the risk report builder option
			click("sidemenu_reports_riskreportbuilderoption_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the risk report builder option.");

			// click on the add button
			click("sidemenu_reports_addbtn_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the add button.");

			// enter the report name
			type("sidemenu_reports_reportnametxt_XPATH", data.get("report_name"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the report name.");

			// select the base type
			select("sidemenu_reports_basetypedd_XPATH", data.get("base_type"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Selected the base type.");

			// wait for the element
			Thread.sleep(3000);

			// select the report type
			select("sidemenu_reports_reporttypedd_XPATH", data.get("report_type"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Selected the report type.");

			// click on the continue button
			click("sidemenu_reports_continuebtn_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the continue button.");

			// verify title of the screen
			switchVerification("sidemenu_reports_addreportscreentitle_XPATH", "Add Report Configuration",
					"The Add Report Configuration is not displayed.");

			// select the new source
			select("sidemenu_reports_addnewsourcedd_XPATH", data.get("new_resource"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Selected the new source.");

			// click on the add button
			click("sidemenu_reports_propertystatuslbl_addnewsourcebtn_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the add button.");

			// scroll down the screen
			WebElement status = driver
					.findElement(By.xpath(OR.getProperty("sidemenu_reports_propertystatuslbl_XPATH")));
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView(true);", status);
			js.executeScript("window.scrollBy(0,-400)");

			// select the filter
			select("sidemenu_reports_propertystatuslbl_filterdd_XPATH", data.get("filter"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Selected the filter");

			// click on the select status field
			click("sidemenu_reports_propertystatuslbl_selectstatustxt_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the select status field.");

			// click on the none button
			click("task_tasktag_nonebtn_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the none button.");

			// enter the status
			type("sidemenu_reports_propertystatuslbl_selectstatus_searchtxt_XPATH", data.get("inactive_status"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the status.");

			// click on the searched inactive option
			click("sidemenu_reports_propertystatuslbl_selectstatus_seachedinactiveoption_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the searched inactive option.");

			// click on the select status field
			click("sidemenu_reports_propertystatuslbl_selectstatustxt_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the select status field.");

			// click on the add field button
			click("sidemenu_reports_propertystatuslbl_selectstatus_addfieldbtn_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the add field button.");

			// click on the add address field button
			click("sidemenu_reports_propertystatuslbl_selectstatus_addfieldbtn_address_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the add address field button.");

			// click on the add city field button
			click("sidemenu_reports_propertystatuslbl_selectstatus_addfieldbtn_city_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the add city field button.");

			// click on the add province field button
			click("sidemenu_reports_propertystatuslbl_selectstatus_addfieldbtn_province_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the add province field button.");

			// click on the add country field button
			click("sidemenu_reports_propertystatuslbl_selectstatus_addfieldbtn_country_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the add country field button.");

			// scroll up the screen
			js.executeScript("window.scrollTo(0,0)");

			// click on the report button
			click("sidemenu_reports_propertystatuslbl_reportbtn_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the report button.");

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
						ngDriver.waitForAngularRequestsToFinish();
						System.out.println("Click on the next button.");

					}

				} else {

					List<WebElement> numrows = driver
							.findElements(By.xpath(OR.getProperty("sidemenu_reports_numberofrowsreport_XPATH")));
					int singlePageCount = numrows.size();
					totalRecord = totalRecord + singlePageCount;
				}

				// display total number of row
				System.out.println("THE TOTAL NUMBER OF ROWS ARE : " + totalRecord);
				test.log(LogStatus.INFO, "THE TOTAL NUMBER OF ROWS ARE : " + totalRecord);
				Reporter.log("THE TOTAL NUMBER OF ROWS ARE : " + totalRecord);
				log.info("THE TOTAL NUMBER OF ROWS ARE : " + totalRecord);

			} catch (Throwable t) {
				List<WebElement> numrows = driver
						.findElements(By.xpath(OR.getProperty("sidemenu_reports_numberofrowsreport_XPATH")));
				int singlePageCount = numrows.size();
				totalRecord = totalRecord + singlePageCount;

				// display total number of row
				System.out.println("THE TOTAL NUMBER OF ROWS ARE : " + totalRecord);
				test.log(LogStatus.INFO, "THE TOTAL NUMBER OF ROWS ARE : " + totalRecord);
				Reporter.log("THE TOTAL NUMBER OF ROWS ARE : " + totalRecord);
				log.info("THE TOTAL NUMBER OF ROWS ARE : " + totalRecord);
			}

			try {
				// verify the number of columns in the table

				List<WebElement> numcolumns = driver
						.findElements(By.xpath(OR.getProperty("sidemenu_reports_numberofcolumnsreport_XPATH")));
				totalColumn = numcolumns.size();

				// display total number of row
				System.out.println("THE TOTAL NUMBER OF COLUMNS ARE : " + totalColumn);
				test.log(LogStatus.INFO, "THE TOTAL NUMBER OF COLUMNS ARE : " + totalColumn);
				Reporter.log("THE TOTAL NUMBER OF COLUMNS ARE : " + totalColumn);
				log.info("THE TOTAL NUMBER OF COLUMNS ARE : " + totalColumn);

			} catch (Throwable t) {
				verificationFailed();
			}

			// click on the extract as csv button
			click("sidemenu_reports_propertystatuslbl_extractascsvbtn_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the extract as csv button.");

			// wait for the 5 seconds
			Thread.sleep(5000);

			// read the download file

			File file = getLatestFilefromDir("C:\\Users\\Jinesh\\Downloads");
			String csvFileName = file.getName();
			System.out.println("CSV File Downloaded is :- " + csvFileName);

			// Create an object of CSVReader
			CSVReader csvReader = new CSVReader(new FileReader("C:\\Users\\Jinesh\\Downloads\\" + csvFileName));

			// verify the number of rows in csv file
			List<String[]> rows = csvReader.readAll();
			int csvRowCount = rows.size();
			System.out.println("Total rows which we have " + csvRowCount);

			System.out.println("CSV ROWS::::::::::::::::::" + csvRowCount);

			// validate the rows count

			if (totalRecord == csvRowCount) {
				System.out.println(
						"******************** NUMBER OF ROWS ARE DISPLAYED CORRECT IN EXTRACTED CSV REPORT ********************");
				test.log(LogStatus.INFO,
						"******************** NUMBER OF ROWS ARE DISPLAYED CORRECT IN EXTRACTED CSV REPORT ********************");
				Reporter.log(
						"******************** NUMBER OF ROWS ARE DISPLAYED CORRECT IN EXTRACTED CSV REPORT ********************");
				log.info(
						"******************** NUMBER OF ROWS ARE DISPLAYED CORRECT IN EXTRACTED CSV REPORT ********************");
			} else {

				verificationFailed();

				System.out.println(
						"******************** NUMBER OF ROWS ARE NOT DISPLAYED CORRECT IN EXTRACTED CSV REPORT ********************");
				test.log(LogStatus.INFO,
						"******************** NUMBER OF ROWS ARE NOT DISPLAYED CORRECT IN EXTRACTED CSV REPORT ********************");
				Reporter.log(
						"******************** NUMBER OF ROWS ARE NOT DISPLAYED CORRECT IN EXTRACTED CSV REPORT ********************");
				log.info(
						"******************** NUMBER OF ROWS ARE NOT DISPLAYED CORRECT IN EXTRACTED CSV REPORT ********************");
			}

//			// validate the columns count
//
//			if (totalColumn == csvColumnCount) {
//				System.out.println(
//						"******************** NUMBER OF COLUMNS ARE DISPLAYED CORRECT IN EXTRACTED CSV REPORT ********************");
//				test.log(LogStatus.INFO,
//						"******************** NUMBER OF COLUMNS ARE DISPLAYED CORRECT IN EXTRACTED CSV REPORT ********************");
//				Reporter.log(
//						"******************** NUMBER OF COLUMNS ARE DISPLAYED CORRECT IN EXTRACTED CSV REPORT ********************");
//				log.info(
//						"******************** NUMBER OF COLUMNS ARE DISPLAYED CORRECT IN EXTRACTED CSV REPORT ********************");
//			} else {
//
//				verificationFailed();
//
//				System.out.println(
//						"******************** NUMBER OF COLUMNS ARE NOT DISPLAYED CORRECT IN EXTRACTED CSV REPORT ********************");
//				test.log(LogStatus.INFO,
//						"******************** NUMBER OF COLUMNS ARE NOT DISPLAYED CORRECT IN EXTRACTED CSV REPORT ********************");
//				Reporter.log(
//						"******************** NUMBER OF COLUMNS ARE NOT DISPLAYED CORRECT IN EXTRACTED CSV REPORT ********************");
//				log.info(
//						"******************** NUMBER OF COLUMNS ARE NOT DISPLAYED CORRECT IN EXTRACTED CSV REPORT ********************");
//			}

			// click on the save button
			click("sidemenu_reports_savebtn_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the save button.");

			// enter the newly created report in the search field
			type("sidemenu_reports_searchtxt_XPATH", data.get("report_name"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the newly created report in the search field.");

			// verify the newly created report
			switchVerification("sidemenu_reports_searchedreport_XPATH", "Test Report Name",
					"The Test Report Name report is not displayed.");

			// click on the delete button
			click("sidemenu_reports_deletebtn_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the delete button.");

			// click on the delete button of the confirmation
			click("sidemenu_reports_confirmationdeletebtn_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the delete button of the confirmation.");

			// wait for the element
			explicitWaitClickable("closetoastmsg_CSS");

			// click on the toaster close button
			click("closetoastmsg_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the toaster close button.");

			// verify the deleted report is displayed or not
			deleteVerification("sidemenu_reports_searchedreport_XPATH", "Test Report Name");

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

		// SPOT CHECK TO SEE THAT THE COMPLIANCE DOCUMENT IS PRESENT FOR EACH CATEGORY
		// FOR EACH PROVINCE

		System.out.println(
				"******************** SPOT CHECK TO SEE THAT THE COMPLIANCE DOCUMENT IS PRESENT FOR EACH CATEGORY FOR EACH PROVINCE ********************");
		test.log(LogStatus.INFO,
				"******************** SPOT CHECK TO SEE THAT THE COMPLIANCE DOCUMENT IS PRESENT FOR EACH CATEGORY FOR EACH PROVINCE ********************");
		Reporter.log(
				"******************** SPOT CHECK TO SEE THAT THE COMPLIANCE DOCUMENT IS PRESENT FOR EACH CATEGORY FOR EACH PROVINCE ********************");
		log.info(
				"******************** SPOT CHECK TO SEE THAT THE COMPLIANCE DOCUMENT IS PRESENT FOR EACH CATEGORY FOR EACH PROVINCE ********************");

		try {

			// wait for the element
			Thread.sleep(5000);

			// click on the side menu
			click("ssc_leftsidemenubtn_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the side menu.");

			// wait for the element
			Thread.sleep(5000);

			// click on the compliance option
			click("sidemenu_compliance_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the compliance option.");

			// click on the regulation details button
			click("sidemenu_compliance_regulationdetailsbtn_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the regulation details button.");

			// click on the module button
			click("sidemenu_compliance_moduledd_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the module button.");

			// click on the environmental option
			click("sidemenu_compliance_moduledd_environmentaloption_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the environmental option.");

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
			System.out.println("Total number of countries are: " + countryCount);

			for (int i = 0; i < countryCount; i++) {

				countrydd.selectByVisibleText(countryListStrings.get(i));
				ngDriver.waitForAngularRequestsToFinish();

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
				System.out.println("The " + countryListStrings.get(i) + " has " + territoryCount + " territories.");

				for (int j = 0; j < territoryCount; j++) {

					territorydd.selectByVisibleText(territoryListStrings.get(j));
					ngDriver.waitForAngularRequestsToFinish();

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
					System.out.println("The " + territoryListStrings.get(j) + " of the " + countryListStrings.get(i)
							+ " has " + categoryCount + " categories.");

					for (int k = 0; k < categoryCount; k++) {

						categorydd.selectByVisibleText(categoryListStrings.get(k));
						ngDriver.waitForAngularRequestsToFinish();

						try {
							// verify selected quarter are displayed
							boolean selectedQuarter = driver
									.findElement(By.xpath(OR.getProperty("sidemenu_compliance_selectedqueter_XPATH")))
									.isDisplayed();

							if (selectedQuarter == true) {
								System.out.println("THE DEFAULT QUARTER OF THE COUNTRY: " + countryListStrings.get(i)
										+ " , TERRITORY: " + territoryListStrings.get(j) + " , CATEGORY: "
										+ categoryListStrings.get(k) + " IS DISPLAYED SELECTED SUCCESSFULLY.");
								test.log(LogStatus.INFO,
										"THE DEFAULT QUARTER OF THE COUNTRY: " + countryListStrings.get(i)
												+ " , TERRITORY: " + territoryListStrings.get(j) + " , CATEGORY: "
												+ categoryListStrings.get(k) + " IS DISPLAYED SELECTED SUCCESSFULLY.");
								Reporter.log("THE DEFAULT QUARTER OF THE COUNTRY: " + countryListStrings.get(i)
										+ " , TERRITORY: " + territoryListStrings.get(j) + " , CATEGORY: "
										+ categoryListStrings.get(k) + " IS DISPLAYED SELECTED SUCCESSFULLY.");
								log.info("THE DEFAULT QUARTER OF THE COUNTRY: " + countryListStrings.get(i)
										+ " , TERRITORY: " + territoryListStrings.get(j) + " , CATEGORY: "
										+ categoryListStrings.get(k) + " IS DISPLAYED SELECTED SUCCESSFULLY.");
							} else {

								verificationFailed();

								System.out.println("THE DEFAULT QUARTER OF THE COUNTRY: " + countryListStrings.get(i)
										+ " , TERRITORY: " + territoryListStrings.get(j) + " , CATEGORY: "
										+ categoryListStrings.get(k) + " IS NOT DISPLAYED SELECTED.");
								test.log(LogStatus.INFO,
										"THE DEFAULT QUARTER OF THE COUNTRY: " + countryListStrings.get(i)
												+ " , TERRITORY: " + territoryListStrings.get(j) + " , CATEGORY: "
												+ categoryListStrings.get(k) + " IS NOT DISPLAYED SELECTED.");
								Reporter.log("THE DEFAULT QUARTER OF THE COUNTRY: " + countryListStrings.get(i)
										+ " , TERRITORY: " + territoryListStrings.get(j) + " , CATEGORY: "
										+ categoryListStrings.get(k) + " IS NOT DISPLAYED SELECTED.");
								log.info("THE DEFAULT QUARTER OF THE COUNTRY: " + countryListStrings.get(i)
										+ " , TERRITORY: " + territoryListStrings.get(j) + " , CATEGORY: "
										+ categoryListStrings.get(k) + " IS NOT DISPLAYED SELECTED.");

								break;
							}
						} catch (Throwable t) {
							verificationFailed();

							System.out.println("THE DEFAULT QUARTER OF THE COUNTRY: " + countryListStrings.get(i)
									+ " , TERRITORY: " + territoryListStrings.get(j) + " , CATEGORY: "
									+ categoryListStrings.get(k) + " IS NOT DISPLAYED SELECTED.");
							test.log(LogStatus.INFO,
									"THE DEFAULT QUARTER OF THE COUNTRY: " + countryListStrings.get(i)
											+ " , TERRITORY: " + territoryListStrings.get(j) + " , CATEGORY: "
											+ categoryListStrings.get(k) + " IS NOT DISPLAYED SELECTED.");
							Reporter.log("THE DEFAULT QUARTER OF THE COUNTRY: " + countryListStrings.get(i)
									+ " , TERRITORY: " + territoryListStrings.get(j) + " , CATEGORY: "
									+ categoryListStrings.get(k) + " IS NOT DISPLAYED SELECTED.");
							log.info("THE DEFAULT QUARTER OF THE COUNTRY: " + countryListStrings.get(i)
									+ " , TERRITORY: " + territoryListStrings.get(j) + " , CATEGORY: "
									+ categoryListStrings.get(k) + " IS NOT DISPLAYED SELECTED.");

							break;
						}

						// scroll down the screen
						JavascriptExecutor js = (JavascriptExecutor) driver;
						js.executeScript("window.scrollBy(0,500)");

						try {
							// verify respective document is displayed
							boolean documentLink = driver
									.findElement(By.xpath(OR.getProperty("sidemenu_compliance_documentlbl_XPATH")))
									.isDisplayed();

							if (documentLink == true) {
								System.out.println("THE DOCUMENT LINK OF THE COUNTRY: " + countryListStrings.get(i)
										+ " , TERRITORY: " + territoryListStrings.get(j) + " , CATEGORY: "
										+ categoryListStrings.get(k) + " IS DISPLAYED SELECTED SUCCESSFULLY.");
								test.log(LogStatus.INFO,
										"THE DOCUMENT LINK OF THE COUNTRY: " + countryListStrings.get(i)
												+ " , TERRITORY: " + territoryListStrings.get(j) + " , CATEGORY: "
												+ categoryListStrings.get(k) + " IS DISPLAYED SELECTED SUCCESSFULLY.");
								Reporter.log("THE DOCUMENT LINK OF THE COUNTRY: " + countryListStrings.get(i)
										+ " , TERRITORY: " + territoryListStrings.get(j) + " , CATEGORY: "
										+ categoryListStrings.get(k) + " IS DISPLAYED SELECTED SUCCESSFULLY.");
								log.info("THE DOCUMENT LINK OF THE COUNTRY: " + countryListStrings.get(i)
										+ " , TERRITORY: " + territoryListStrings.get(j) + " , CATEGORY: "
										+ categoryListStrings.get(k) + " IS DISPLAYED SELECTED SUCCESSFULLY.");
							} else {

								verificationFailed();

								System.out.println("THE DOCUMENT LINK OF THE COUNTRY: " + countryListStrings.get(i)
										+ " , TERRITORY: " + territoryListStrings.get(j) + " , CATEGORY: "
										+ categoryListStrings.get(k) + " IS NOT DISPLAYED SELECTED.");
								test.log(LogStatus.INFO,
										"THE DOCUMENT LINK OF THE COUNTRY: " + countryListStrings.get(i)
												+ " , TERRITORY: " + territoryListStrings.get(j) + " , CATEGORY: "
												+ categoryListStrings.get(k) + " IS NOT DISPLAYED SELECTED.");
								Reporter.log("THE DOCUMENT LINK OF THE COUNTRY: " + countryListStrings.get(i)
										+ " , TERRITORY: " + territoryListStrings.get(j) + " , CATEGORY: "
										+ categoryListStrings.get(k) + " IS NOT DISPLAYED SELECTED.");
								log.info("THE DOCUMENT LINK OF THE COUNTRY: " + countryListStrings.get(i)
										+ " , TERRITORY: " + territoryListStrings.get(j) + " , CATEGORY: "
										+ categoryListStrings.get(k) + " IS NOT DISPLAYED SELECTED.");

								break;

							}
						} catch (Throwable t) {
							verificationFailed();

							System.out.println("THE DOCUMENT LINK OF THE COUNTRY: " + countryListStrings.get(i)
									+ " , TERRITORY: " + territoryListStrings.get(j) + " , CATEGORY: "
									+ categoryListStrings.get(k) + " IS NOT DISPLAYED SELECTED.");
							test.log(LogStatus.INFO,
									"THE DOCUMENT LINK OF THE COUNTRY: " + countryListStrings.get(i) + " , TERRITORY: "
											+ territoryListStrings.get(j) + " , CATEGORY: " + categoryListStrings.get(k)
											+ " IS NOT DISPLAYED SELECTED.");
							Reporter.log("THE DOCUMENT LINK OF THE COUNTRY: " + countryListStrings.get(i)
									+ " , TERRITORY: " + territoryListStrings.get(j) + " , CATEGORY: "
									+ categoryListStrings.get(k) + " IS NOT DISPLAYED SELECTED.");
							log.info("THE DOCUMENT LINK OF THE COUNTRY: " + countryListStrings.get(i) + " , TERRITORY: "
									+ territoryListStrings.get(j) + " , CATEGORY: " + categoryListStrings.get(k)
									+ " IS NOT DISPLAYED SELECTED.");

							break;
						}

						// scroll UP the screen
						js.executeScript("window.scrollBy(0,-500)");
					}
				}
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

		// RUN A REPORT LIST BASED ON PROPERTY OWNER

		System.out.println("******************** RUN A REPORT LIST BASED ON PROPERTY OWNER ********************");
		test.log(LogStatus.INFO, "******************** RUN A REPORT LIST BASED ON PROPERTY OWNER ********************");
		Reporter.log("******************** RUN A REPORT LIST BASED ON PROPERTY OWNER ********************");
		log.info("******************** RUN A REPORT LIST BASED ON PROPERTY OWNER ********************");

		// DELETE PREVIOUSLY CREATED ENVIRONMENTAL REPORT

		System.out.println("******************** DELETE PREVIOUSLY CREATED ENVIRONMENTAL REPORT ********************");
		test.log(LogStatus.INFO,
				"******************** DELETE PREVIOUSLY CREATED ENVIRONMENTAL REPORT ********************");
		Reporter.log("******************** DELETE PREVIOUSLY CREATED ENVIRONMENTAL REPORT ********************");
		log.info("******************** DELETE PREVIOUSLY CREATED ENVIRONMENTAL REPORT ********************");

		try {

			// enter the property name in the search field
			clear("envreports_propertylist_filtertxt_CSS");
			type("envreports_propertylist_filtertxt_CSS", data.get("property_4"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the property name in the search field.");

			// click on the environmental icon from the property list page
			click("environmentalicon_CSS");
			System.out.println("Clicked on the environmental icon of the Property.");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Navigate to the environmental screen of the perticular property.");

			// wait for the element
			Thread.sleep(5000);

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

			// collect all the report

			List<WebElement> reportList = driver.findElements(By.xpath(OR.getProperty("envreport_totalreports_XPATH")));
			int reportCount = reportList.size();

			System.out.println("reportCount:::::::::::::::::::" + reportCount);

			for (int i = 1; i <= reportCount; i++) {

				List<WebElement> reportList1 = driver
						.findElements(By.xpath(OR.getProperty("envreport_totalreports_XPATH")));
				int maxProducts = reportList1.size();
				Random random = new Random();
				int randomProduct = random.nextInt(maxProducts);
				reportList1.get(randomProduct).click();
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the environmental report.");

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

		// CREATE RANDOM ENVIRONMENTAL REPORTS IN THE PROPERTY 4

		System.out.println(
				"******************** CREATE RANDOM ENVIRONMENTAL REPORTS IN THE PROPERTY 4 ********************");
		test.log(LogStatus.INFO,
				"******************** CREATE RANDOM ENVIRONMENTAL REPORTS IN THE PROPERTY 4 ********************");
		Reporter.log("******************** CREATE RANDOM ENVIRONMENTAL REPORTS IN THE PROPERTY 4 ********************");
		log.info("******************** CREATE RANDOM ENVIRONMENTAL REPORTS IN THE PROPERTY 4 ********************");

		Random random = new Random();
		int reportCount = random.nextInt(5 - 1) + 1;

		try {

			// enter the property name in the search field
			clear("envreports_propertylist_filtertxt_CSS");
			type("envreports_propertylist_filtertxt_CSS", data.get("property_4"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the property name in the search field.");

			// click on the environmental icon from the property list page
			click("environmentalicon_CSS");
			System.out.println("Clicked on the environmental icon of the Property.");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Navigate to the environmental screen of the perticular property.");

			// wait for the element
			Thread.sleep(5000);

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

			System.out.println("reportCount:::::::::::" + reportCount);

			for (int i = 1; i <= reportCount; i++) {

				// click on the Add report button
				click("envreportaddbtn_CSS");
				System.out.println("Clicked on the Add report button");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Navigate to the Add Environmental Report Screen.");

				// select the checklist from the type dropdown
				select("envreporttypedd_CSS", data.get("type"));
				System.out.println("The option is selected from the Type dropdown.");
				ngDriver.waitForAngularRequestsToFinish();

				// enter the title
				String s1 = RandomStringUtils.randomAlphabetic(8);

				type("envreporttitletxt_CSS", s1);
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

				// scroll down the screen
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("window.scrollBy(0,400)");

				// enter the description
				type("envreportdescriptiontxt_CSS", data.get("description"));
				System.out.println("The data entered in the Description field.");

				// click on the Add report button
				click("envreportsavebtn_CSS");
				System.out.println("Clicked on the Save Button.");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Navigate to the Add Report Screen.");

				// wait for the element
				explicitWaitClickable("closetoastmsg_CSS");

				// click on the toaster close button
				click("closetoastmsg_CSS");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the toaster close button.");

				// enter the newly created environmental report in the search field
				clear("task_listofchecklist_filterfield_CSS");
				System.out.println("Cleared the search field.");
				ngDriver.waitForAngularRequestsToFinish();
				type("task_listofchecklist_filterfield_CSS", s1);
				System.out.println("Entered the newly created environmental report in the search field.");
				ngDriver.waitForAngularRequestsToFinish();

				// verification of the environmental report is added or not
				String envReport = "//span[text()='" + s1 + "']";

				switchVerification(envReport, s1, "The newly created report is not displayed successfully.");

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

		// EXTRACT THE CSV FILE, THE REPORT WILL SHOW ALL REPORTS BASED ON THE PROPERTY

		System.out.println(
				"******************** EXTRACT THE CSV FILE, THE REPORT WILL SHOW ALL REPORTS BASED ON THE PROPERTY ********************");
		test.log(LogStatus.INFO,
				"******************** EXTRACT THE CSV FILE, THE REPORT WILL SHOW ALL REPORTS BASED ON THE PROPERTY ********************");
		Reporter.log(
				"******************** EXTRACT THE CSV FILE, THE REPORT WILL SHOW ALL REPORTS BASED ON THE PROPERTY ********************");
		log.info(
				"******************** EXTRACT THE CSV FILE, THE REPORT WILL SHOW ALL REPORTS BASED ON THE PROPERTY ********************");

		try {

			// enter the property name in the search field
			clear("envreports_propertylist_filtertxt_CSS");
			type("envreports_propertylist_filtertxt_CSS", data.get("property_4"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the property name in the search field.");

			// click on the environmental icon from the property list page
			click("environmentalicon_CSS");
			System.out.println("Clicked on the environmental icon of the Property.");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Navigate to the environmental screen of the perticular property.");

			// wait for the element
			Thread.sleep(5000);

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

			// click on the extract excel button
			click("envreport_extractcsvbtn_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the extract excel button.");

			// click on the property field
			click("envreport_extractcsvbtn_propertytxt_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the property field.");

			// enter property name in the search field
			type("envreport_extractcsvbtn_propertytxt_searchtxt_XPATH", data.get("property_4"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered property name in the search field.");

			// click on the searched property
			click("envreport_extractcsvbtn_propertytxt_searchedproperty_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the searched property.");

			// enter the created from date
			type("envreport_extractcsvbtn_ownertxt_fromdatecreatetxt_XPATH", "2016-02-12");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the created from date.");

			// click on the created to date
			click("envreport_extractcsvbtn_ownertxt_todatecreatetxt_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the created to date.");

			// click on the today button
			click("envreport_extractcsvbtn_ownertxt_todatecreatetxt_todaybtn_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the today button.");

			// click on the extract button
			click("envreport_extractcsvbtn_ownertxt_extractbtn_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the extract button.");

			// wait for the 5 seconds
			Thread.sleep(5000);

			// read the download file
			File file = getLatestFilefromDir("C:\\Users\\Jinesh\\Downloads");
			String csvFileName = file.getName();
			System.out.println("CSV File Downloaded is :- " + csvFileName);

			// Create an object of CSVReader
			CSVReader csvReader = new CSVReader(new FileReader("C:\\Users\\Jinesh\\Downloads\\" + csvFileName));

			// verify the number of rows in csv file
			List<String[]> rows = csvReader.readAll();
			int csvRowCount = rows.size();
			int finalcsvRowCount = csvRowCount - 1;
			System.out.println("Total rows which we have " + finalcsvRowCount);

			System.out.println("CSV ROWS::::::::::::::::::" + finalcsvRowCount);

			// validate the rows count

			if (reportCount == finalcsvRowCount) {
				System.out.println(
						"******************** NUMBER OF ROWS ARE DISPLAYED CORRECT IN EXTRACTED CSV REPORT ********************");
				test.log(LogStatus.INFO,
						"******************** NUMBER OF ROWS ARE DISPLAYED CORRECT IN EXTRACTED CSV REPORT ********************");
				Reporter.log(
						"******************** NUMBER OF ROWS ARE DISPLAYED CORRECT IN EXTRACTED CSV REPORT ********************");
				log.info(
						"******************** NUMBER OF ROWS ARE DISPLAYED CORRECT IN EXTRACTED CSV REPORT ********************");
			} else {

				verificationFailed();

				System.out.println(
						"******************** NUMBER OF ROWS ARE NOT DISPLAYED CORRECT IN EXTRACTED CSV REPORT ********************");
				test.log(LogStatus.INFO,
						"******************** NUMBER OF ROWS ARE NOT DISPLAYED CORRECT IN EXTRACTED CSV REPORT ********************");
				Reporter.log(
						"******************** NUMBER OF ROWS ARE NOT DISPLAYED CORRECT IN EXTRACTED CSV REPORT ********************");
				log.info(
						"******************** NUMBER OF ROWS ARE NOT DISPLAYED CORRECT IN EXTRACTED CSV REPORT ********************");
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

	}
}
