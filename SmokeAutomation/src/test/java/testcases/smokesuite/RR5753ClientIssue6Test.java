package testcases.smokesuite;

import java.io.IOException;
import java.util.Hashtable;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;
import org.testng.SkipException;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import base.TestBase;
import utilities.TestUtil;

public class RR5753ClientIssue6Test extends TestBase {

	@Test(dataProviderClass = TestUtil.class, dataProvider = "dp")
	public void rR5753ClientIssue6Test(Hashtable<String, String> data) throws IOException, InterruptedException {

		execution(data, "rR5753ClientIssue6Test");

		// refresh the page
		driver.navigate().refresh();
		Thread.sleep(5000);
		driver.navigate().refresh();

		// COPY RECORDS/REPORTS NOT WORKING CONSISTENTLY
		title("COPY RECORDS/REPORTS NOT WORKING CONSISTENTLY");

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

		// ADD THE NEW BUILDING IN THE PROPERTY
		title("ADD THE NEW BUILDING IN THE PROPERTY");

		try {

			// enter the property name in the search field

			type("envreports_propertylist_filtertxt_CSS", data.get("property_3"));

			// click on the property information
			click("propertyinformationicon_CSS");

			// verify name of the property
			switchVerification("propertyinfo_propertynamelbl3_XPATH", "SmartCentres Brockville",
					"The SmartCentres Brockville property name is not displayed.");

			// click on the menu button
			click("propertyinfo_menubtn_XPATH");

			// click on the building option
			click("propertyinfo_menubtn_buildingoption_XPATH");

			// click on the new building button
			click("propertyinfo_newbuildingbtn_XPATH");

			// enter the building number

			type("propertyinfo_newbuilding_buildingnumbertxt_XPATH", "100");

			// enter the building name

			type("propertyinfo_newbuilding_buildingnametxt_XPATH", data.get("building_name"));

			// enter the building address

			type("propertyinfo_newbuilding_buildingaddresstxt_XPATH", data.get("building_address"));

			// enter the building type

			type("propertyinfo_newbuilding_buildingtypetxt_XPATH", data.get("building_type"));

			// scroll down till save button
			scrollTillElement("propertyinfo_newbuilding_savebtn_XPATH");

			// click on the save button
			click("propertyinfo_newbuilding_savebtn_XPATH");

			// wait for the element
			explicitWaitClickable("closetoastmsg_CSS");

			// click on the toaster close button
			click("closetoastmsg_CSS");

			// verify newly created building is displayed or not
			switchVerification("propertyinfo_newbuilding_createdbuilding_ci6_XPATH", "Test Building Name CI6",
					"The Test Building Name CI6 is not displayed.");

			// click on the menu button
			click("propertyinfo_menubtn_XPATH");

			// click on the property details option
			click("propertyinfo_menubtn_propertydetailsoption_XPATH");

		} catch (Throwable t) {
			verificationFailed();
		}

		// click on the home icon from the top of the screen
		click("questionnaire_homeburgermenubtn_hide_CSS");

		// synchronization
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// CREATE NEW ENVIRONMENTAL REPORT AT PROPERTY LEVEL
		title("CREATE NEW ENVIRONMENTAL REPORT AT PROPERTY LEVEL");

		try {
			// apply the filter 1 on the property list

			type("envreports_propertylist_filtertxt_CSS", data.get("property_2"));

			// click on the environmental icon from the property list page
			click("environmentalicon_CSS");

			// wait for the element
			Thread.sleep(5000);

			// click on the burger menu
			click("menubtn_CSS");

			// wait for the element
			Thread.sleep(5000);

			// click on the environmental report
			click("envreportoption_XPATH");

			// click on the Add report button
			click("envreportaddbtn_CSS");

			// select the checklist from the type dropdown
			select("envreporttypedd_CSS", data.get("type"));

			// enter the title
			type("envreporttitletxt_CSS", data.get("title_property"));

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
			click("envreportsavebtn_CSS");

			// enter the newly created environmental report in the search field

			type("task_listofchecklist_filterfield_CSS", data.get("title_property"));

			// verification of the environmental report is added or not
			switchVerification("envreportaddedrecord_property_ci6_XPATH", "Test Title Copy Report CI6",
					"The Test Title Copy Report CI6 is not displayed successfully.");

		} catch (Throwable t) {
			verificationFailed();
		}

		// click on the home icon from the top of the screen
		click("questionnaire_homeburgermenubtn_hide_CSS");

		// synchronization
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// COPY NEWLY CREATED REPORT TO ANOTHER PROPERTY AT PROPERTY LEVEL
		title("COPY NEWLY CREATED REPORT TO ANOTHER PROPERTY AT PROPERTY LEVEL");

		try {
			// apply the filter 1 on the property list

			type("envreports_propertylist_filtertxt_CSS", data.get("property_2"));

			// click on the environmental icon from the property list page
			click("environmentalicon_CSS");

			// wait for the element
			Thread.sleep(5000);

			// click on the burger menu
			click("menubtn_CSS");

			// wait for the element
			Thread.sleep(5000);

			// click on the environmental report
			click("envreportoption_XPATH");

			// enter the newly created environmental report in the search field

			type("task_listofchecklist_filterfield_CSS", data.get("title_property"));

			// click on the checkbox of the newly created environmental report
			String environmentalReportCheckbox = "//span[text()='" + data.get("title_property")
					+ "']//parent::td[@ng-click='editRecord(document)']//preceding-sibling::td//input[@ng-click='selectRecord(document)']";
			driver.findElement(By.xpath(environmentalReportCheckbox)).click();

			// click on the copy button
			click("envreportaddedrecord_copybtn_ci6_XPATH");

			// wait for the element
			Thread.sleep(5000);

			// click on the property field
			click("envreports_copyreports_propertybtn_XPATH");

			// click on the none button
			click("task_tasktag_nonebtn_CSS");

			// enter the property name in the search field
			type("envreports_copyreports_findpropertytxt_CSS", data.get("property_3"));

			// click on the searched result
			click("envreports_copyreports_selectproperty_property3_XPATH");

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

		// VERIFY COPIED ENVIRONMENTAL REPORT IS DISPLAYED OR NOT IN RESPECTIVE PROPERTY
		// AT PROPERTY LEVEL
		title("VERIFY COPIED ENVIRONMENTAL REPORT IS DISPLAYED OR NOT IN RESPECTIVE PROPERTY AT PROPERTY LEVEL");

		try {
			// apply the filter 1 on the property list

			type("envreports_propertylist_filtertxt_CSS", data.get("property_3"));

			// click on the environmental icon from the property list page
			click("environmentalicon_CSS");

			// wait for the element
			Thread.sleep(5000);

			// click on the burger menu
			click("menubtn_CSS");

			// wait for the element
			Thread.sleep(5000);

			// click on the environmental report
			click("envreportoption_XPATH");

			// enter the newly created environmental report in the search field

			type("task_listofchecklist_filterfield_CSS", data.get("title_property"));

			// verify copied environmental report is displayed or not
			switchVerification("envreports_copiedreport_XPATH", "Test Title Copy Report CI6",
					"The Test Title Copy Report CI6 is not displayed.");

		} catch (Throwable t) {
			verificationFailed();
		}

		// click on the home icon from the top of the screen
		click("questionnaire_homeburgermenubtn_hide_CSS");

		// synchronization
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// CREATE NEW ENVIRONMENTAL REPORT AT BUILDING LEVEL (DESTINY PROPERTY HAVE
		// BUILDING)
		title("CREATE NEW ENVIRONMENTAL REPORT AT BUILDING LEVEL (DESTINY PROPERTY HAVE BUILDING)");

		try {
			// apply the filter 1 on the property list

			type("envreports_propertylist_filtertxt_CSS", data.get("property_2"));

			// click on the environmental icon from the property list page
			click("environmentalicon_CSS");

			// wait for the element
			Thread.sleep(5000);

			// click on the burger menu
			click("menubtn_CSS");

			// wait for the element
			Thread.sleep(5000);

			// click on the environmental report
			click("envreportoption_XPATH");

			// select the building from the drop down
			select("propertyinfo_propertydd_XPATH", data.get("buildingName_dd"));

			// click on the Add report button
			click("envreportaddbtn_CSS");

			// select the checklist from the type dropdown
			select("envreporttypedd_CSS", data.get("type"));

			// enter the title
			type("envreporttitletxt_CSS", data.get("title_building"));

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
			click("envreportsavebtn_CSS");

			// enter the newly created environmental report in the search field

			type("task_listofchecklist_filterfield_CSS", data.get("title_building"));

			// verification of the environmental report is added or not
			switchVerification("envreportaddedrecord_building_ci6_XPATH", "Test Title Copy Report Building Level CI6",
					"The Test Title Copy Report Building Level CI6 is not displayed successfully.");

		} catch (Throwable t) {
			verificationFailed();
		}

		// click on the home icon from the top of the screen
		click("questionnaire_homeburgermenubtn_hide_CSS");

		// synchronization
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// COPY NEWLY CREATED REPORT TO ANOTHER PROPERTY AT BUILLDING LEVEL (DESTINY
		// PROPERTY HAVE BUILDING)
		title("COPY NEWLY CREATED REPORT TO ANOTHER PROPERTY AT BUILLDING LEVEL (DESTINY PROPERTY HAVE BUILDING)");

		try {
			// apply the filter 1 on the property list

			type("envreports_propertylist_filtertxt_CSS", data.get("property_2"));

			// click on the environmental icon from the property list page
			click("environmentalicon_CSS");

			// wait for the element
			Thread.sleep(5000);

			// click on the burger menu
			click("menubtn_CSS");

			// wait for the element
			Thread.sleep(5000);

			// click on the environmental report
			click("envreportoption_XPATH");

			// select the building from the drop down
			select("propertyinfo_propertydd_XPATH", data.get("buildingName_dd"));

			// enter the newly created environmental report in the search field

			type("task_listofchecklist_filterfield_CSS", data.get("title_building"));

			// click on the checkbox of the newly created environmental report
			String environmentalReportCheckbox = "//span[text()='" + data.get("title_building")
					+ "']//parent::td[@ng-click='editRecord(document)']//preceding-sibling::td//input[@ng-click='selectRecord(document)']";
			driver.findElement(By.xpath(environmentalReportCheckbox)).click();

			// click on the copy button
			click("envreportaddedrecord_copybtn_ci6_XPATH");

			// wait for the element
			Thread.sleep(5000);

			// click on the property field
			click("envreports_copyreports_propertybtn_XPATH");

			// click on the none button
			click("task_tasktag_nonebtn_CSS");

			// enter the property name in the search field
			type("envreports_copyreports_findpropertytxt_CSS", data.get("property_3"));

			// click on the searched result
			click("envreports_copyreports_selectproperty_property3_XPATH");

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

		// VERIFY COPIED ENVIRONMENTAL REPORT IS DISPLAYED OR NOT IN RESPECTIVE PROPERTY
		// AT BUILDING LEVEL (DESTINY PROPERTY HAVE BUILDING)
		title("VERIFY COPIED ENVIRONMENTAL REPORT IS DISPLAYED OR NOT IN RESPECTIVE PROPERTY AT BUILDING LEVEL (DESTINY PROPERTY HAVE BUILDING)");

		try {
			// apply the filter 1 on the property list

			type("envreports_propertylist_filtertxt_CSS", data.get("property_3"));

			// click on the environmental icon from the property list page
			click("environmentalicon_CSS");

			// wait for the element
			Thread.sleep(5000);

			// click on the burger menu
			click("menubtn_CSS");

			// wait for the element
			Thread.sleep(5000);

			// click on the environmental report
			click("envreportoption_XPATH");

			// enter the newly created environmental report in the search field

			type("task_listofchecklist_filterfield_CSS", data.get("title_building"));

			// verify copied environmental report is displayed or not
			switchVerification("envreports_copiedreport_building_XPATH", "Test Title Copy Report Building Level CI6",
					"The Test Title Copy Report Building Level CI6 is not displayed.");

		} catch (Throwable t) {
			verificationFailed();
		}

		// click on the home icon from the top of the screen
		click("questionnaire_homeburgermenubtn_hide_CSS");

		// synchronization
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// CREATE NEW ENVIRONMENTAL REPORT AT BUILDING LEVEL (DESTINY PROPERTY DOESN'T
		// HAVE BUILDING)
		title("CREATE NEW ENVIRONMENTAL REPORT AT BUILDING LEVEL (DESTINY PROPERTY DOESN'T HAVE BUILDING)");

		try {
			// apply the filter 1 on the property list

			type("envreports_propertylist_filtertxt_CSS", data.get("property_2"));

			// click on the environmental icon from the property list page
			click("environmentalicon_CSS");

			// wait for the element
			Thread.sleep(5000);

			// click on the burger menu
			click("menubtn_CSS");

			// wait for the element
			Thread.sleep(5000);

			// click on the environmental report
			click("envreportoption_XPATH");

			// select the building from the drop down
			select("propertyinfo_propertydd_XPATH", data.get("buildingName_dd"));

			// click on the Add report button
			click("envreportaddbtn_CSS");

			// select the checklist from the type dropdown
			select("envreporttypedd_CSS", data.get("type"));

			// enter the title
			type("envreporttitletxt_CSS", data.get("title_building1"));

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
			click("envreportsavebtn_CSS");

			// enter the newly created environmental report in the search field

			type("task_listofchecklist_filterfield_CSS", data.get("title_building1"));

			// verification of the environmental report is added or not
			switchVerification("envreportaddedrecord_building1_ci6_XPATH",
					"Test Title Copy Report Building Level One CI6",
					"The Test Title Copy Report Building Level One CI6 is not displayed successfully.");

		} catch (Throwable t) {
			verificationFailed();
		}

		// click on the home icon from the top of the screen
		click("questionnaire_homeburgermenubtn_hide_CSS");

		// synchronization
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// COPY NEWLY CREATED REPORT TO ANOTHER PROPERTY AT BUILLDING LEVEL (DESTINY
		// PROPERTY DON'T HAVE BUILDING)
		title("COPY NEWLY CREATED REPORT TO ANOTHER PROPERTY AT BUILLDING LEVEL (DESTINY PROPERTY DON'T HAVE BUILDING)");

		try {
			// apply the filter 1 on the property list

			type("envreports_propertylist_filtertxt_CSS", data.get("property_2"));

			// click on the environmental icon from the property list page
			click("environmentalicon_CSS");

			// wait for the element
			Thread.sleep(5000);

			// click on the burger menu
			click("menubtn_CSS");

			// wait for the element
			Thread.sleep(5000);

			// click on the environmental report
			click("envreportoption_XPATH");

			// select the building from the drop down
			select("propertyinfo_propertydd_XPATH", data.get("buildingName_dd"));

			// enter the newly created environmental report in the search field

			type("task_listofchecklist_filterfield_CSS", data.get("title_building1"));

			// click on the checkbox of the newly created environmental report
			String environmentalReportCheckbox = "//span[text()='" + data.get("title_building1")
					+ "']//parent::td[@ng-click='editRecord(document)']//preceding-sibling::td//input[@ng-click='selectRecord(document)']";
			driver.findElement(By.xpath(environmentalReportCheckbox)).click();

			// click on the copy button
			click("envreportaddedrecord_copybtn_ci6_XPATH");

			// wait for the element
			Thread.sleep(5000);

			// click on the property field
			click("envreports_copyreports_propertybtn_XPATH");

			// click on the none button
			click("task_tasktag_nonebtn_CSS");

			// enter the property name in the search field
			type("envreports_copyreports_findpropertytxt_CSS", data.get("property_1"));

			// click on the searched result
			click("envreports_copyreports_selectproperty_property1_XPATH");

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

		// VERIFY COPIED ENVIRONMENTAL REPORT IS DISPLAYED OR NOT IN RESPECTIVE PROPERTY
		// AT BUILDING LEVEL (DESTINY PROPERTY DON'T HAVE BUILDING)
		title("VERIFY COPIED ENVIRONMENTAL REPORT IS DISPLAYED OR NOT IN RESPECTIVE PROPERTY AT BUILDING LEVEL (DESTINY PROPERTY DON'T HAVE BUILDING)");

		try {
			// apply the filter 1 on the property list

			type("envreports_propertylist_filtertxt_CSS", data.get("property_1"));

			// click on the environmental icon from the property list page
			click("environmentalicon_CSS");

			// wait for the element
			Thread.sleep(5000);

			// click on the burger menu
			click("menubtn_CSS");

			// wait for the element
			Thread.sleep(5000);

			// click on the environmental report
			click("envreportoption_XPATH");

			// enter the newly created environmental report in the search field

			type("task_listofchecklist_filterfield_CSS", data.get("title_building1"));

			// verify copied environmental report is displayed or not
			switchVerification("envreports_copiedreport_building1_XPATH",
					"Test Title Copy Report Building Level One CI6",
					"The Test Title Copy Report Building Level One CI6 is not displayed.");

		} catch (Throwable t) {
			verificationFailed();
		}

		// click on the home icon from the top of the screen
		click("questionnaire_homeburgermenubtn_hide_CSS");

		// synchronization
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// DELETE THE NEWLY CREATED ENVIRONMENTAL REPORT IN PROPERTY ONE
		title("DELETE THE NEWLY CREATED ENVIRONMENTAL REPORT IN PROPERTY ONE");

		try {

			// enter the property name in the search field

			type("envreports_propertylist_filtertxt_CSS", data.get("property_1"));

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

		// DELETE THE NEWLY CREATED ENVIRONMENTAL REPORT IN PROPERTY TWO
		title("DELETE THE NEWLY CREATED ENVIRONMENTAL REPORT IN PROPERTY TWO");

		try {

			// enter the property name in the search field

			type("envreports_propertylist_filtertxt_CSS", data.get("property_2"));

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

			}

			// wait for the element
			Thread.sleep(7000);

//			// select the building from the drop down
//			select("propertyinfo_propertydd_XPATH", data.get("buildingName_dd"));
//
//			// collect all the report
//
//			List<WebElement> reportList1 = driver
//					.findElements(By.xpath(OR.getProperty("envreport_totalreports_XPATH")));
//			int reportCount1 = reportList1.size();
//
//			for (int i = 1; i <= reportCount1; i++) {
//
//				List<WebElement> reportList11 = driver
//						.findElements(By.xpath(OR.getProperty("envreport_totalreports_XPATH")));
//				int maxProducts1 = reportList11.size();
//				Random random = new Random();
//				int randomProduct1 = random.nextInt(maxProducts1);
//				reportList11.get(randomProduct1).click();
//
//				// wait for the element
//				explicitWaitClickable("envreportdeletebtn_CSS");
//
//				// click on the delete button
//				click("envreportdeletebtn_CSS");
//
//				// wait for the element
//				explicitWaitClickable("envreportmodeldeletebtn_CSS");
//
//				// click on the delete button of the confirmation model
//				click("envreportmodeldeletebtn_CSS");
//
//				// wait for the element
//				explicitWaitClickable("closetoastmsg_CSS");
//
//				// click on the toaster close button
//				click("closetoastmsg_CSS");
//
//			}

		} catch (Throwable t) {
			verificationFailed();
		}

		// click on the home icon from the top of the screen
		click("questionnaire_homeburgermenubtn_hide_CSS");

		// synchronization
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// DELETE THE NEWLY CREATED ENVIRONMENTAL REPORT IN PROPERTY THREE
		title("DELETE THE NEWLY CREATED ENVIRONMENTAL REPORT IN PROPERTY THREE");

		try {

			// enter the property name in the search field

			type("envreports_propertylist_filtertxt_CSS", data.get("property_3"));

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

//			// select the building from the drop down
//			select("propertyinfo_propertydd_XPATH", data.get("buildingName_dd1"));
//
//			// collect all the report
//
//			List<WebElement> reportList1 = driver
//					.findElements(By.xpath(OR.getProperty("envreport_totalreports_XPATH")));
//			int reportCount1 = reportList1.size();
//
//			for (int i = 1; i <= reportCount1; i++) {
//
//				List<WebElement> reportList11 = driver
//						.findElements(By.xpath(OR.getProperty("envreport_totalreports_XPATH")));
//				int maxProducts1 = reportList11.size();
//				Random random = new Random();
//				int randomProduct1 = random.nextInt(maxProducts1);
//				reportList11.get(randomProduct1).click();
//
//				// wait for the element
//				explicitWaitClickable("envreportdeletebtn_CSS");
//
//				// click on the delete button
//				click("envreportdeletebtn_CSS");
//
//				// wait for the element
//				explicitWaitClickable("envreportmodeldeletebtn_CSS");
//
//				// click on the delete button of the confirmation model
//				click("envreportmodeldeletebtn_CSS");
//
//				// wait for the element
//				explicitWaitClickable("closetoastmsg_CSS");
//
//				// click on the toaster close button
//				click("closetoastmsg_CSS");
//
//			}

		} catch (Throwable t) {
			verificationFailed();
		}

		// click on the home icon from the top of the screen
		click("questionnaire_homeburgermenubtn_hide_CSS");

		// synchronization
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// CREATE NEW ENVIRONMENTAL RECORD AT PROPERTY LEVEL
		title("CREATE NEW ENVIRONMENTAL RECORD AT PROPERTY LEVEL");

		try {

			// enter the property name in the search field

			type("envreports_propertylist_filtertxt_CSS", data.get("property_2"));

			// click on the environmental icon from the property list page
			click("environmentalicon_CSS");

			// wait for the element
			Thread.sleep(5000);

			// click on the burger menu
			click("menubtn_CSS");

			// wait for the element
			Thread.sleep(5000);

			// click on the environmental records
			click("envrecords_XPATH");

			// click on the Primary Hazardous Substance
			click("envrecords_primaryhazardoussubstance_XPATH");

			// click on the asbestos materials
			click("envreports_asbestosmaterials_XPATH");

			// click on the add button
			click("envreports_asbestosmaterials_addbtn_CSS");

			// select the material
			select("envreports_asbestosmaterials_materialdd_CSS", data.get("material"));

			// enter the detailed location details in the field
			type("envreports_asbestosmaterials_detailedlocationtxt_CSS", data.get("detailed_location_property"));

			// scroll down the screen

			scrollByPixel(400);

			// select the is material asbestos containing
			select("envreports_asbestosmaterials_ismaterialasbestoscontainingdd_CSS",
					data.get("is_material_asbestos_containing"));

			// select the asbestos type
			select("envreports_asbestosmaterials_asbestostypedd_CSS", data.get("asbestos_type"));

			// select the condition
			select("envreports_asbestosmaterials_conditiondd_CSS", data.get("condition"));

			// select the status
			select("envreports_asbestosmaterials_statusdd_CSS", data.get("status"));

			// scroll till bottom of the page
			scrollTillElement("envreports_asbestosmaterials_savebtn_CSS");

			// click on the save button
			click("envreports_asbestosmaterials_savebtn_CSS");

			// wait for the element
			explicitWaitClickable("closetoastmsg_CSS");

			// click on the toaster close button
			click("closetoastmsg_CSS");

			// enter the newly created environmental record in the search field

			type("task_listofchecklist_filterfield_CSS", data.get("detailed_location_property"));

			// verify the newly created Asbestos Materials record
			switchVerification("envreports_asbestosmaterials_propertylevel_XPATH",
					"Test Detailed Location Property Level CI6",
					"The Test Detailed Location Property Level CI6 is not displayed successfully.");

		} catch (Throwable t) {
			verificationFailed();
		}

		// click on the home icon from the top of the screen
		click("questionnaire_homeburgermenubtn_hide_CSS");

		// synchronization
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// COPY NEWLY CREATED RECORD TO ANOTHER PROPERTY AT PROPERTY LEVEL
		title("COPY NEWLY CREATED RECORD TO ANOTHER PROPERTY AT PROPERTY LEVEL");

		try {
			// enter the property name in the search field

			type("envreports_propertylist_filtertxt_CSS", data.get("property_2"));

			// click on the environmental icon from the property list page
			click("environmentalicon_CSS");

			// wait for the element
			Thread.sleep(5000);

			// click on the burger menu
			click("menubtn_CSS");

			// wait for the element
			Thread.sleep(5000);

			// click on the environmental records
			click("envrecords_XPATH");

			// click on the Primary Hazardous Substance
			click("envrecords_primaryhazardoussubstance_XPATH");

			// click on the asbestos materials
			click("envreports_asbestosmaterials_XPATH");

			// enter the newly created environmental record in the search field

			type("task_listofchecklist_filterfield_CSS", data.get("detailed_location_property"));

			// click on the checkbox of the newly created environmental record
			String environmentalRecordCheckbox = "//span[text()='" + data.get("detailed_location_property")
					+ "']//parent::td[@id='detailedLocation']//preceding-sibling::td//input[@ng-click='selectRecord(document)']";
			driver.findElement(By.xpath(environmentalRecordCheckbox)).click();

			// click on the copy button
			click("envreportaddedrecord_copybtn_ci6_XPATH");

			// wait for the element
			Thread.sleep(5000);

			// click on the property field
			click("envreports_copyreports_propertybtn_XPATH");

			// click on the none button
			click("task_tasktag_nonebtn_CSS");

			// enter the property name in the search field
			type("envreports_copyreports_findpropertytxt_CSS", data.get("property_3"));

			// click on the searched result
			click("envreports_copyreports_selectproperty_property3_XPATH");

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

		// VERIFY COPIED ENVIRONMENTAL RECORD IS DISPLAYED OR NOT IN RESPECTIVE PROPERTY
		// AT PROPERTY LEVEL
		title("VERIFY COPIED ENVIRONMENTAL RECORD IS DISPLAYED OR NOT IN RESPECTIVE PROPERTY AT PROPERTY LEVEL");

		try {
			// enter the property name in the search field

			type("envreports_propertylist_filtertxt_CSS", data.get("property_3"));

			// click on the environmental icon from the property list page
			click("environmentalicon_CSS");

			// wait for the element
			Thread.sleep(5000);

			// click on the burger menu
			click("menubtn_CSS");

			// wait for the element
			Thread.sleep(5000);

			// click on the environmental records
			click("envrecords_XPATH");

			// click on the Primary Hazardous Substance
			click("envrecords_primaryhazardoussubstance_XPATH");

			// click on the asbestos materials
			click("envreports_asbestosmaterials_XPATH");

			// enter the newly created environmental record in the search field

			type("task_listofchecklist_filterfield_CSS", data.get("detailed_location_property"));

			// verify the newly created Asbestos Materials record
			switchVerification("envreports_asbestosmaterials_propertylevel_XPATH",
					"Test Detailed Location Property Level CI6",
					"The Test Detailed Location Property Level CI6 is not displayed successfully.");

		} catch (Throwable t) {
			verificationFailed();
		}

		// click on the home icon from the top of the screen
		click("questionnaire_homeburgermenubtn_hide_CSS");

		// synchronization
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// CREATE NEW ENVIRONMENTAL REPORT AT BUILDING LEVEL (DESTINY PROPERTY HAVE
		// BUILDING)
		title("CREATE NEW ENVIRONMENTAL REPORT AT BUILDING LEVEL (DESTINY PROPERTY HAVE BUILDING)");

		try {
			// enter the property name in the search field

			type("envreports_propertylist_filtertxt_CSS", data.get("property_2"));

			// click on the environmental icon from the property list page
			click("environmentalicon_CSS");

			// wait for the element
			Thread.sleep(5000);

			// click on the burger menu
			click("menubtn_CSS");

			// wait for the element
			Thread.sleep(5000);

			// click on the environmental records
			click("envrecords_XPATH");

			// click on the Primary Hazardous Substance
			click("envrecords_primaryhazardoussubstance_XPATH");

			// click on the asbestos materials
			click("envreports_asbestosmaterials_XPATH");

			// select the building from the drop down
			select("propertyinfo_propertydd_XPATH", data.get("buildingName_dd"));

			// click on the add button
			click("envreports_asbestosmaterials_addbtn_CSS");

			// select the material
			select("envreports_asbestosmaterials_materialdd_CSS", data.get("material"));

			// enter the detailed location details in the field
			type("envreports_asbestosmaterials_detailedlocationtxt_CSS", data.get("detailed_location_building"));

			// scroll down the screen

			scrollByPixel(400);

			// select the is material asbestos containing
			select("envreports_asbestosmaterials_ismaterialasbestoscontainingdd_CSS",
					data.get("is_material_asbestos_containing"));

			// select the asbestos type
			select("envreports_asbestosmaterials_asbestostypedd_CSS", data.get("asbestos_type"));

			// select the condition
			select("envreports_asbestosmaterials_conditiondd_CSS", data.get("condition"));

			// select the status
			select("envreports_asbestosmaterials_statusdd_CSS", data.get("status"));

			// scroll till bottom of the page
			scrollTillElement("envreports_asbestosmaterials_savebtn_CSS");

			// click on the save button
			click("envreports_asbestosmaterials_savebtn_CSS");

			// wait for the element
			explicitWaitClickable("closetoastmsg_CSS");

			// click on the toaster close button
			click("closetoastmsg_CSS");

			// enter the newly created environmental record in the search field

			type("task_listofchecklist_filterfield_CSS", data.get("detailed_location_building"));

			// verify the newly created Asbestos Materials record
			switchVerification("envreports_asbestosmaterials_buildinglevel_XPATH",
					"Test Detailed Location Building Level CI6",
					"The Test Detailed Location Building Level CI6 is not displayed successfully.");

		} catch (Throwable t) {
			verificationFailed();
		}

		// click on the home icon from the top of the screen
		click("questionnaire_homeburgermenubtn_hide_CSS");

		// synchronization
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// COPY NEWLY CREATED REPORT TO ANOTHER PROPERTY AT BUILLDING LEVEL (DESTINY
		// PROPERTY HAVE BUILDING)
		title("COPY NEWLY CREATED REPORT TO ANOTHER PROPERTY AT BUILLDING LEVEL (DESTINY PROPERTY HAVE BUILDING)");

		try {
			// enter the property name in the search field

			type("envreports_propertylist_filtertxt_CSS", data.get("property_2"));

			// click on the environmental icon from the property list page
			click("environmentalicon_CSS");

			// wait for the element
			Thread.sleep(5000);

			// click on the burger menu
			click("menubtn_CSS");

			// wait for the element
			Thread.sleep(5000);

			// click on the environmental records
			click("envrecords_XPATH");

			// click on the Primary Hazardous Substance
			click("envrecords_primaryhazardoussubstance_XPATH");

			// click on the asbestos materials
			click("envreports_asbestosmaterials_XPATH");

			// select the building from the drop down
			select("propertyinfo_propertydd_XPATH", data.get("buildingName_dd"));

			// enter the newly created environmental record in the search field

			type("task_listofchecklist_filterfield_CSS", data.get("detailed_location_building"));

			// click on the checkbox of the newly created environmental record
			String environmentalRecordCheckbox = "//span[text()='" + data.get("detailed_location_building")
					+ "']//parent::td[@id='detailedLocation']//preceding-sibling::td//input[@ng-click='selectRecord(document)']";
			driver.findElement(By.xpath(environmentalRecordCheckbox)).click();

			// click on the copy button
			click("envreportaddedrecord_copybtn_ci6_XPATH");

			// wait for the element
			Thread.sleep(5000);

			// click on the property field
			click("envreports_copyreports_propertybtn_XPATH");

			// click on the none button
			click("task_tasktag_nonebtn_CSS");

			// enter the property name in the search field
			type("envreports_copyreports_findpropertytxt_CSS", data.get("property_3"));

			// click on the searched result
			click("envreports_copyreports_selectproperty_property3_XPATH");

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

		// VERIFY COPIED ENVIRONMENTAL REPORT IS DISPLAYED OR NOT IN RESPECTIVE PROPERTY
		// AT BUILDING LEVEL (DESTINY PROPERTY HAVE BUILDING)
		title("VERIFY COPIED ENVIRONMENTAL REPORT IS DISPLAYED OR NOT IN RESPECTIVE PROPERTY AT BUILDING LEVEL (DESTINY PROPERTY HAVE BUILDING)");

		try {
			// enter the property name in the search field

			type("envreports_propertylist_filtertxt_CSS", data.get("property_3"));

			// click on the environmental icon from the property list page
			click("environmentalicon_CSS");

			// wait for the element
			Thread.sleep(5000);

			// click on the burger menu
			click("menubtn_CSS");

			// wait for the element
			Thread.sleep(5000);

			// click on the environmental records
			click("envrecords_XPATH");

			// click on the Primary Hazardous Substance
			click("envrecords_primaryhazardoussubstance_XPATH");

			// click on the asbestos materials
			click("envreports_asbestosmaterials_XPATH");

			// enter the newly created environmental record in the search field

			type("task_listofchecklist_filterfield_CSS", data.get("detailed_location_building"));

			// verify the newly created Asbestos Materials record
			switchVerification("envreports_asbestosmaterials_buildinglevel_XPATH",
					"Test Detailed Location Building Level CI6",
					"The Test Detailed Location Building Level CI6 is not displayed successfully.");

		} catch (Throwable t) {
			verificationFailed();
		}

		// click on the home icon from the top of the screen
		click("questionnaire_homeburgermenubtn_hide_CSS");

		// synchronization
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// CREATE NEW ENVIRONMENTAL RECORD AT BUILDING LEVEL (DESTINY PROPERTY DOESN'T
		// HAVE BUILDING)
		title("CREATE NEW ENVIRONMENTAL RECORD AT BUILDING LEVEL (DESTINY PROPERTY DOESN'T HAVE BUILDING)");

		try {
			// enter the property name in the search field

			type("envreports_propertylist_filtertxt_CSS", data.get("property_2"));

			// click on the environmental icon from the property list page
			click("environmentalicon_CSS");

			// wait for the element
			Thread.sleep(5000);

			// click on the burger menu
			click("menubtn_CSS");

			// wait for the element
			Thread.sleep(5000);

			// click on the environmental records
			click("envrecords_XPATH");

			// click on the Primary Hazardous Substance
			click("envrecords_primaryhazardoussubstance_XPATH");

			// click on the asbestos materials
			click("envreports_asbestosmaterials_XPATH");

			// select the building from the drop down
			select("propertyinfo_propertydd_XPATH", data.get("buildingName_dd"));

			// click on the add button
			click("envreports_asbestosmaterials_addbtn_CSS");

			// select the material
			select("envreports_asbestosmaterials_materialdd_CSS", data.get("material"));

			// enter the detailed location details in the field
			type("envreports_asbestosmaterials_detailedlocationtxt_CSS", data.get("detailed_location_building1"));

			// scroll down the screen

			scrollByPixel(400);

			// select the is material asbestos containing
			select("envreports_asbestosmaterials_ismaterialasbestoscontainingdd_CSS",
					data.get("is_material_asbestos_containing"));

			// select the asbestos type
			select("envreports_asbestosmaterials_asbestostypedd_CSS", data.get("asbestos_type"));

			// select the condition
			select("envreports_asbestosmaterials_conditiondd_CSS", data.get("condition"));

			// select the status
			select("envreports_asbestosmaterials_statusdd_CSS", data.get("status"));

			// scroll till bottom of the page
			scrollTillElement("envreports_asbestosmaterials_savebtn_CSS");

			// click on the save button
			click("envreports_asbestosmaterials_savebtn_CSS");

			// wait for the element
			explicitWaitClickable("closetoastmsg_CSS");

			// click on the toaster close button
			click("closetoastmsg_CSS");

			// enter the newly created environmental record in the search field

			type("task_listofchecklist_filterfield_CSS", data.get("detailed_location_building1"));

			// verify the newly created Asbestos Materials record
			switchVerification("envreports_asbestosmaterials_buildinglevel1_XPATH",
					"Test Detailed Location Building Level One CI6",
					"The Test Detailed Location Building Level One CI6 is not displayed successfully.");

		} catch (Throwable t) {
			verificationFailed();
		}

		// click on the home icon from the top of the screen
		click("questionnaire_homeburgermenubtn_hide_CSS");

		// synchronization
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// COPY NEWLY CREATED REPORT TO ANOTHER PROPERTY AT BUILLDING LEVEL (DESTINY
		// PROPERTY DON'T HAVE BUILDING)
		title("COPY NEWLY CREATED REPORT TO ANOTHER PROPERTY AT BUILLDING LEVEL (DESTINY PROPERTY DON'T HAVE BUILDING)");

		try {
			// enter the property name in the search field

			type("envreports_propertylist_filtertxt_CSS", data.get("property_2"));

			// click on the environmental icon from the property list page
			click("environmentalicon_CSS");

			// wait for the element
			Thread.sleep(5000);

			// click on the burger menu
			click("menubtn_CSS");

			// wait for the element
			Thread.sleep(5000);

			// click on the environmental records
			click("envrecords_XPATH");

			// click on the Primary Hazardous Substance
			click("envrecords_primaryhazardoussubstance_XPATH");

			// click on the asbestos materials
			click("envreports_asbestosmaterials_XPATH");

			// select the building from the drop down
			select("propertyinfo_propertydd_XPATH", data.get("buildingName_dd"));

			// enter the newly created environmental record in the search field

			type("task_listofchecklist_filterfield_CSS", data.get("detailed_location_building1"));

			// click on the checkbox of the newly created environmental record
			String environmentalRecordCheckbox = "//span[text()='" + data.get("detailed_location_building1")
					+ "']//parent::td[@id='detailedLocation']//preceding-sibling::td//input[@ng-click='selectRecord(document)']";
			driver.findElement(By.xpath(environmentalRecordCheckbox)).click();

			// click on the copy button
			click("envreportaddedrecord_copybtn_ci6_XPATH");

			// wait for the element
			Thread.sleep(5000);

			// click on the property field
			click("envreports_copyreports_propertybtn_XPATH");

			// click on the none button
			click("task_tasktag_nonebtn_CSS");

			// enter the property name in the search field
			type("envreports_copyreports_findpropertytxt_CSS", data.get("property_1"));

			// click on the searched result
			click("envreports_copyreports_selectproperty_property1_XPATH");

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

		// VERIFY COPIED ENVIRONMENTAL REPORT IS DISPLAYED OR NOT IN RESPECTIVE PROPERTY
		// AT BUILDING LEVEL (DESTINY PROPERTY DON'T HAVE BUILDING)
		title("VERIFY COPIED ENVIRONMENTAL REPORT IS DISPLAYED OR NOT IN RESPECTIVE PROPERTY AT BUILDING LEVEL (DESTINY PROPERTY DON'T HAVE BUILDING)");

		try {
			// enter the property name in the search field

			type("envreports_propertylist_filtertxt_CSS", data.get("property_1"));

			// click on the environmental icon from the property list page
			click("environmentalicon_CSS");

			// wait for the element
			Thread.sleep(5000);

			// click on the burger menu
			click("menubtn_CSS");

			// wait for the element
			Thread.sleep(5000);

			// click on the environmental records
			click("envrecords_XPATH");

			// click on the Primary Hazardous Substance
			click("envrecords_primaryhazardoussubstance_XPATH");

			// click on the asbestos materials
			click("envreports_asbestosmaterials_XPATH");

			// enter the newly created environmental record in the search field

			type("task_listofchecklist_filterfield_CSS", data.get("detailed_location_building1"));

			// verify the newly created Asbestos Materials record
			switchVerification("envreports_asbestosmaterials_buildinglevel1_XPATH",
					"Test Detailed Location Building Level One CI6",
					"The Test Detailed Location Building Level One CI6 is not displayed successfully.");

		} catch (Throwable t) {
			verificationFailed();
		}

		// click on the home icon from the top of the screen
		click("questionnaire_homeburgermenubtn_hide_CSS");

		// synchronization
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// DELETE THE NEWLY CREATED BUILDING FROM THE RESPECTIVE PROPERTY
		title("DELETE THE NEWLY CREATED BUILDING FROM THE RESPECTIVE PROPERTY");

		try {

			// enter the property name in the search field

			type("envreports_propertylist_filtertxt_CSS", data.get("property_3"));

			// click on the property information
			click("propertyinformationicon_CSS");

			// verify name of the property
			switchVerification("propertyinfo_propertynamelbl3_XPATH", "SmartCentres Brockville",
					"The SmartCentres Brockville property name is not displayed.");

			// click on the menu button
			click("propertyinfo_menubtn_XPATH");

			// click on the building option
			click("propertyinfo_menubtn_buildingoption_XPATH");

			// click on the newly created building
			click("propertyinfo_newbuilding_createdbuilding_ci6_XPATH");

			// wait for the element
			explicitWaitClickable("propertyinfo_newbuilding_deletebtn_XPATH");

			// click on the delete button
			click("propertyinfo_newbuilding_deletebtn_XPATH");

			// wait for the element
			explicitWaitClickable("propertyinfo_newbuilding_confirmationdeletebtn_XPATH");

			// click on the delete button of the confirmation
			click("propertyinfo_newbuilding_confirmationdeletebtn_XPATH");

			// wait for the element
			explicitWaitClickable("closetoastmsg_CSS");

			// click on the toaster close button
			click("closetoastmsg_CSS");

			// verify deleted building is displayed or not

			deleteVerification("propertyinfo_newbuilding_createdbuilding_ci6_XPATH", "Test Building Name CI6");

			// click on the menu button
			click("propertyinfo_menubtn_XPATH");

			// click on the property details option
			click("propertyinfo_menubtn_propertydetailsoption_XPATH");

		} catch (Throwable t) {
			verificationFailed();
		}

		// click on the home icon from the top of the screen
		click("questionnaire_homeburgermenubtn_hide_CSS");

		// synchronization
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// DELETE THE NEWLY CREATED ENVIRONMENTAL RECORD IN PROPERTY ONE
		title("DELETE THE NEWLY CREATED ENVIRONMENTAL RECORD IN PROPERTY ONE");

		try {

			// enter the property name in the search field

			type("envreports_propertylist_filtertxt_CSS", data.get("property_1"));

			// click on the environmental icon from the property list page
			click("environmentalicon_CSS");

			// wait for the element
			Thread.sleep(5000);

			// click on the burger menu
			click("menubtn_CSS");

			// wait for the element
			Thread.sleep(5000);

			// click on the environmental records
			click("envrecords_XPATH");

			// click on the Primary Hazardous Substance
			click("envrecords_primaryhazardoussubstance_XPATH");

			// click on the asbestos materials
			click("envreports_asbestosmaterials_XPATH");

			// collect all the report

			List<WebElement> reportList = driver.findElements(By.xpath(OR.getProperty("envreport_totalreports_XPATH")));
			int reportCount = reportList.size();

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

		// DELETE THE NEWLY CREATED ENVIRONMENTAL REPORT IN PROPERTY TWO
		title("DELETE THE NEWLY CREATED ENVIRONMENTAL REPORT IN PROPERTY TWO");

		try {

			// enter the property name in the search field

			type("envreports_propertylist_filtertxt_CSS", data.get("property_2"));

			// click on the environmental icon from the property list page
			click("environmentalicon_CSS");

			// wait for the element
			Thread.sleep(5000);

			// click on the burger menu
			click("menubtn_CSS");

			// wait for the element
			Thread.sleep(5000);

			// click on the environmental records
			click("envrecords_XPATH");

			// click on the Primary Hazardous Substance
			click("envrecords_primaryhazardoussubstance_XPATH");

			// click on the asbestos materials
			click("envreports_asbestosmaterials_XPATH");

			// collect all the report

			List<WebElement> reportList = driver.findElements(By.xpath(OR.getProperty("envreport_totalreports_XPATH")));
			int reportCount = reportList.size();

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

		// DELETE THE NEWLY CREATED ENVIRONMENTAL REPORT IN PROPERTY THREE
		title("DELETE THE NEWLY CREATED ENVIRONMENTAL REPORT IN PROPERTY THREE");

		try {

			// enter the property name in the search field

			type("envreports_propertylist_filtertxt_CSS", data.get("property_3"));

			// click on the environmental icon from the property list page
			click("environmentalicon_CSS");

			// wait for the element
			Thread.sleep(5000);

			// click on the burger menu
			click("menubtn_CSS");

			// wait for the element
			Thread.sleep(5000);

			// click on the environmental records
			click("envrecords_XPATH");

			// click on the Primary Hazardous Substance
			click("envrecords_primaryhazardoussubstance_XPATH");

			// click on the asbestos materials
			click("envreports_asbestosmaterials_XPATH");

			// collect all the report

			List<WebElement> reportList = driver.findElements(By.xpath(OR.getProperty("envreport_totalreports_XPATH")));
			int reportCount = reportList.size();

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

		try {
			// wait for the element
			explicitWaitClickable("questionnaire_settingicon_CSS");

			// click on the settings icon from the top of the screen
			click("questionnaire_settingicon_CSS");

			// wait for the element
			explicitWaitClickable("sidemenu_logout_CSS");

			// click on the logout option from the side menu
			click("sidemenu_logout_CSS");

			// wait for the element
			explicitWaitClickable("signinbtn_BTNTEXT");

		} catch (Throwable t) {
			verificationFailed();
		}

	}
}