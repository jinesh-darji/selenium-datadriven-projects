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

		if (!(TestUtil.isTestRunnable("rR5753ClientIssue6Test", excel))) {

			throw new SkipException(
					"Skipping the test " + "rR5753ClientIssue6Test".toUpperCase() + "as the Run mode is NO");
		}

		if (!data.get("runmode").equals("Y")) {

			throw new SkipException("Skipping the test case as the Run Mode for data set is NO");
		}

		// refresh the page
		driver.navigate().refresh();
		Thread.sleep(5000);
		driver.navigate().refresh();

		// COPY RECORDS/REPORTS NOT WORKING CONSISTENTLY

		System.out.println("******************** COPY RECORDS/REPORTS NOT WORKING CONSISTENTLY ********************");
		test.log(LogStatus.INFO,
				"******************** COPY RECORDS/REPORTS NOT WORKING CONSISTENTLY ********************");
		Reporter.log("******************** COPY RECORDS/REPORTS NOT WORKING CONSISTENTLY ********************");
		log.info("******************** COPY RECORDS/REPORTS NOT WORKING CONSISTENTLY ********************");

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

		// ADD THE NEW BUILDING IN THE PROPERTY

		System.out.println("******************** ADD THE NEW BUILDING IN THE PROPERTY ********************");
		test.log(LogStatus.INFO, "******************** ADD THE NEW BUILDING IN THE PROPERTY ********************");
		Reporter.log("******************** ADD THE NEW BUILDING IN THE PROPERTY ********************");
		log.info("******************** ADD THE NEW BUILDING IN THE PROPERTY ********************");

		try {

			// enter the property name in the search field
			clear("envreports_propertylist_filtertxt_CSS");
			type("envreports_propertylist_filtertxt_CSS", data.get("property_3"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the property name in the search field.");

			// click on the property information
			click("propertyinformationicon_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the property information.");

			// verify name of the property
			switchVerification("propertyinfo_propertynamelbl3_XPATH", "SmartCentres Brockville",
					"The SmartCentres Brockville property name is not displayed.");

			// click on the menu button
			click("propertyinfo_menubtn_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the menu button.");

			// click on the building option
			click("propertyinfo_menubtn_buildingoption_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the building option.");

			// click on the new building button
			click("propertyinfo_newbuildingbtn_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the new building button.");

			// enter the building number
			clear("propertyinfo_newbuilding_buildingnumbertxt_XPATH");
			type("propertyinfo_newbuilding_buildingnumbertxt_XPATH", "100");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the building number.");

			// enter the building name
			clear("propertyinfo_newbuilding_buildingnametxt_XPATH");
			type("propertyinfo_newbuilding_buildingnametxt_XPATH", data.get("building_name"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the building name.");

			// enter the building address
			clear("propertyinfo_newbuilding_buildingaddresstxt_XPATH");
			type("propertyinfo_newbuilding_buildingaddresstxt_XPATH", data.get("building_address"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the building address.");

			// enter the building type
			clear("propertyinfo_newbuilding_buildingtypetxt_XPATH");
			type("propertyinfo_newbuilding_buildingtypetxt_XPATH", data.get("building_type"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the building type.");

			// scroll down till save button
			WebElement savebtn = driver.findElement(By.xpath(OR.getProperty("propertyinfo_newbuilding_savebtn_XPATH")));
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView(true);", savebtn);

			// click on the save button
			click("propertyinfo_newbuilding_savebtn_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the save button.");

			// wait for the element
			explicitWaitClickable("closetoastmsg_CSS");

			// click on the toaster close button
			click("closetoastmsg_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the toaster close button.");

			// verify newly created building is displayed or not
			switchVerification("propertyinfo_newbuilding_createdbuilding_ci6_XPATH", "Test Building Name CI6",
					"The Test Building Name CI6 is not displayed.");

			// click on the menu button
			click("propertyinfo_menubtn_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the menu button.");

			// click on the property details option
			click("propertyinfo_menubtn_propertydetailsoption_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the property details option.");

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

		// CREATE NEW ENVIRONMENTAL REPORT AT PROPERTY LEVEL

		System.out
				.println("******************** CREATE NEW ENVIRONMENTAL REPORT AT PROPERTY LEVEL ********************");
		test.log(LogStatus.INFO,
				"******************** CREATE NEW ENVIRONMENTAL REPORT AT PROPERTY LEVEL ********************");
		Reporter.log("******************** CREATE NEW ENVIRONMENTAL REPORT AT PROPERTY LEVEL ********************");
		log.info("******************** CREATE NEW ENVIRONMENTAL REPORT AT PROPERTY LEVEL ********************");

		try {
			// apply the filter 1 on the property list
			clear("envreports_propertylist_filtertxt_CSS");
			type("envreports_propertylist_filtertxt_CSS", data.get("property_2"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Applied the filter 1 on the property list.");

			// click on the environmental icon from the property list page
			click("environmentalicon_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the environmental icon of the Property.");

			// wait for the element
			Thread.sleep(5000);

			// click on the burger menu
			click("menubtn_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the burger menu button successfully!!!");

			// wait for the element
			Thread.sleep(5000);

			// click on the environmental report
			click("envreportoption_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the Environmental Report option.");

			// click on the Add report button
			click("envreportaddbtn_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the Add report button");

			// select the checklist from the type dropdown
			select("envreporttypedd_CSS", data.get("type"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("The option is selected from the Type dropdown.");

			// enter the title
			type("envreporttitletxt_CSS", data.get("title_property"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("The data entered in the Title field.");

			// click on the date field
			click("envreportdatetxt_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the date field.");

			// click on the today button
			click("envreporttodaydate_BTNTEXT");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Today's date selected in the Date Field.");

			// enter the company
			type("envreportcompanytxt_CSS", data.get("company"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("The data entered in the Company field.");

			// enter the author
			type("envreportauthortxt_CSS", data.get("author"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("The data entered in the Author field.");

			// enter the description
			type("envreportdescriptiontxt_CSS", data.get("description"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("The data entered in the Description field.");

			// click on the Add report button
			click("envreportsavebtn_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the Save Button.");

			// enter the newly created environmental report in the search field
			clear("task_listofchecklist_filterfield_CSS");
			type("task_listofchecklist_filterfield_CSS", data.get("title_property"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the newly created environmental report in the search field.");

			// verification of the environmental report is added or not
			switchVerification("envreportaddedrecord_property_ci6_XPATH", "Test Title Copy Report CI6",
					"The Test Title Copy Report CI6 is not displayed successfully.");

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

		// COPY NEWLY CREATED REPORT TO ANOTHER PROPERTY AT PROPERTY LEVEL

		System.out.println(
				"******************** COPY NEWLY CREATED REPORT TO ANOTHER PROPERTY AT PROPERTY LEVEL ********************");
		test.log(LogStatus.INFO,
				"******************** COPY NEWLY CREATED REPORT TO ANOTHER PROPERTY AT PROPERTY LEVEL ********************");
		Reporter.log(
				"******************** COPY NEWLY CREATED REPORT TO ANOTHER PROPERTY AT PROPERTY LEVEL ********************");
		log.info(
				"******************** COPY NEWLY CREATED REPORT TO ANOTHER PROPERTY AT PROPERTY LEVEL ********************");

		try {
			// apply the filter 1 on the property list
			clear("envreports_propertylist_filtertxt_CSS");
			type("envreports_propertylist_filtertxt_CSS", data.get("property_2"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Applied the filter 1 on the property list.");

			// click on the environmental icon from the property list page
			click("environmentalicon_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the environmental icon of the Property.");

			// wait for the element
			Thread.sleep(5000);

			// click on the burger menu
			click("menubtn_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the burger menu button successfully!!!");

			// wait for the element
			Thread.sleep(5000);

			// click on the environmental report
			click("envreportoption_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the Environmental Report option.");

			// enter the newly created environmental report in the search field
			clear("task_listofchecklist_filterfield_CSS");
			type("task_listofchecklist_filterfield_CSS", data.get("title_property"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the newly created environmental report in the search field.");

			// click on the checkbox of the newly created environmental report
			String environmentalReportCheckbox = "//span[text()='" + data.get("title_property")
					+ "']//parent::td[@ng-click='editRecord(document)']//preceding-sibling::td//input[@ng-click='selectRecord(document)']";
			driver.findElement(By.xpath(environmentalReportCheckbox)).click();
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the checkbox of the newly created environmental report.");

			// click on the copy button
			click("envreportaddedrecord_copybtn_ci6_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the copy button.");

			// wait for the element
			Thread.sleep(5000);

			// click on the property field
			click("envreports_copyreports_propertybtn_XPATH");
			System.out.println("Clicked on the property field");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the none button
			click("task_tasktag_nonebtn_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the none button.");

			// enter the property name in the search field
			type("envreports_copyreports_findpropertytxt_CSS", data.get("property_3"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the property name in the search field.");

			// click on the searched result
			click("envreports_copyreports_selectproperty_property3_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Property is selected from the list of property for copy the records");

			// click on the property field
			click("envreports_copyreports_propertybtn_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the property field");

			// click on the copy button of the model
			click("envreports_copyreports_modelcopybtn_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("The report is copied to the respective property successfully.");

			// wait for the element
			explicitWaitClickable("closetoastmsg_CSS");

			// click on the toaster close button
			click("closetoastmsg_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the toaster close button.");

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

		// VERIFY COPIED ENVIRONMENTAL REPORT IS DISPLAYED OR NOT IN RESPECTIVE PROPERTY
		// AT PROPERTY LEVEL

		System.out.println(
				"******************** VERIFY COPIED ENVIRONMENTAL REPORT IS DISPLAYED OR NOT IN RESPECTIVE PROPERTY AT PROPERTY LEVEL ********************");
		test.log(LogStatus.INFO,
				"******************** VERIFY COPIED ENVIRONMENTAL REPORT IS DISPLAYED OR NOT IN RESPECTIVE PROPERTY AT PROPERTY LEVEL ********************");
		Reporter.log(
				"******************** VERIFY COPIED ENVIRONMENTAL REPORT IS DISPLAYED OR NOT IN RESPECTIVE PROPERTY AT PROPERTY LEVEL ********************");
		log.info(
				"******************** VERIFY COPIED ENVIRONMENTAL REPORT IS DISPLAYED OR NOT IN RESPECTIVE PROPERTY AT PROPERTY LEVEL ********************");

		try {
			// apply the filter 1 on the property list
			clear("envreports_propertylist_filtertxt_CSS");
			type("envreports_propertylist_filtertxt_CSS", data.get("property_3"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Applied the filter 1 on the property list.");

			// click on the environmental icon from the property list page
			click("environmentalicon_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the environmental icon of the Property.");

			// wait for the element
			Thread.sleep(5000);

			// click on the burger menu
			click("menubtn_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the burger menu button successfully!!!");

			// wait for the element
			Thread.sleep(5000);

			// click on the environmental report
			click("envreportoption_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the Environmental Report option.");

			// enter the newly created environmental report in the search field
			clear("task_listofchecklist_filterfield_CSS");
			type("task_listofchecklist_filterfield_CSS", data.get("title_property"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the newly created environmental report in the search field.");

			// verify copied environmental report is displayed or not
			switchVerification("envreports_copiedreport_XPATH", "Test Title Copy Report CI6",
					"The Test Title Copy Report CI6 is not displayed.");

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

		// CREATE NEW ENVIRONMENTAL REPORT AT BUILDING LEVEL (DESTINY PROPERTY HAVE
		// BUILDING)

		System.out.println(
				"******************** CREATE NEW ENVIRONMENTAL REPORT AT BUILDING LEVEL (DESTINY PROPERTY HAVE BUILDING) ********************");
		test.log(LogStatus.INFO,
				"******************** CREATE NEW ENVIRONMENTAL REPORT AT BUILDING LEVEL (DESTINY PROPERTY HAVE BUILDING) ********************");
		Reporter.log(
				"******************** CREATE NEW ENVIRONMENTAL REPORT AT BUILDING LEVEL (DESTINY PROPERTY HAVE BUILDING) ********************");
		log.info(
				"******************** CREATE NEW ENVIRONMENTAL REPORT AT BUILDING LEVEL (DESTINY PROPERTY HAVE BUILDING) ********************");

		try {
			// apply the filter 1 on the property list
			clear("envreports_propertylist_filtertxt_CSS");
			type("envreports_propertylist_filtertxt_CSS", data.get("property_2"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Applied the filter 1 on the property list.");

			// click on the environmental icon from the property list page
			click("environmentalicon_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the environmental icon of the Property.");

			// wait for the element
			Thread.sleep(5000);

			// click on the burger menu
			click("menubtn_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the burger menu button successfully!!!");

			// wait for the element
			Thread.sleep(5000);

			// click on the environmental report
			click("envreportoption_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the Environmental Report option.");

			// select the building from the drop down
			select("propertyinfo_propertydd_XPATH", data.get("buildingName_dd"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Selected the building from the drop down.");

			// click on the Add report button
			click("envreportaddbtn_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the Add report button");

			// select the checklist from the type dropdown
			select("envreporttypedd_CSS", data.get("type"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("The option is selected from the Type dropdown.");

			// enter the title
			type("envreporttitletxt_CSS", data.get("title_building"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("The data entered in the Title field.");

			// click on the date field
			click("envreportdatetxt_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the date field.");

			// click on the today button
			click("envreporttodaydate_BTNTEXT");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Today's date selected in the Date Field.");

			// enter the company
			type("envreportcompanytxt_CSS", data.get("company"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("The data entered in the Company field.");

			// enter the author
			type("envreportauthortxt_CSS", data.get("author"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("The data entered in the Author field.");

			// enter the description
			type("envreportdescriptiontxt_CSS", data.get("description"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("The data entered in the Description field.");

			// click on the Add report button
			click("envreportsavebtn_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the Save Button.");

			// enter the newly created environmental report in the search field
			clear("task_listofchecklist_filterfield_CSS");
			type("task_listofchecklist_filterfield_CSS", data.get("title_building"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the newly created environmental report in the search field.");

			// verification of the environmental report is added or not
			switchVerification("envreportaddedrecord_building_ci6_XPATH", "Test Title Copy Report Building Level CI6",
					"The Test Title Copy Report Building Level CI6 is not displayed successfully.");

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

		// COPY NEWLY CREATED REPORT TO ANOTHER PROPERTY AT BUILLDING LEVEL (DESTINY
		// PROPERTY HAVE BUILDING)

		System.out.println(
				"******************** COPY NEWLY CREATED REPORT TO ANOTHER PROPERTY AT BUILLDING LEVEL (DESTINY PROPERTY HAVE BUILDING) ********************");
		test.log(LogStatus.INFO,
				"******************** COPY NEWLY CREATED REPORT TO ANOTHER PROPERTY AT BUILLDING LEVEL (DESTINY PROPERTY HAVE BUILDING) ********************");
		Reporter.log(
				"******************** COPY NEWLY CREATED REPORT TO ANOTHER PROPERTY AT BUILLDING LEVEL (DESTINY PROPERTY HAVE BUILDING) ********************");
		log.info(
				"******************** COPY NEWLY CREATED REPORT TO ANOTHER PROPERTY AT BUILLDING LEVEL (DESTINY PROPERTY HAVE BUILDING) ********************");

		try {
			// apply the filter 1 on the property list
			clear("envreports_propertylist_filtertxt_CSS");
			type("envreports_propertylist_filtertxt_CSS", data.get("property_2"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Applied the filter 1 on the property list.");

			// click on the environmental icon from the property list page
			click("environmentalicon_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the environmental icon of the Property.");

			// wait for the element
			Thread.sleep(5000);

			// click on the burger menu
			click("menubtn_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the burger menu button successfully!!!");

			// wait for the element
			Thread.sleep(5000);

			// click on the environmental report
			click("envreportoption_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the Environmental Report option.");

			// select the building from the drop down
			select("propertyinfo_propertydd_XPATH", data.get("buildingName_dd"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Selected the building from the drop down.");

			// enter the newly created environmental report in the search field
			clear("task_listofchecklist_filterfield_CSS");
			type("task_listofchecklist_filterfield_CSS", data.get("title_building"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the newly created environmental report in the search field.");

			// click on the checkbox of the newly created environmental report
			String environmentalReportCheckbox = "//span[text()='" + data.get("title_building")
					+ "']//parent::td[@ng-click='editRecord(document)']//preceding-sibling::td//input[@ng-click='selectRecord(document)']";
			driver.findElement(By.xpath(environmentalReportCheckbox)).click();
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the checkbox of the newly created environmental report.");

			// click on the copy button
			click("envreportaddedrecord_copybtn_ci6_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the copy button.");

			// wait for the element
			Thread.sleep(5000);

			// click on the property field
			click("envreports_copyreports_propertybtn_XPATH");
			System.out.println("Clicked on the property field");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the none button
			click("task_tasktag_nonebtn_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the none button.");

			// enter the property name in the search field
			type("envreports_copyreports_findpropertytxt_CSS", data.get("property_3"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the property name in the search field.");

			// click on the searched result
			click("envreports_copyreports_selectproperty_property3_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Property is selected from the list of property for copy the records");

			// click on the property field
			click("envreports_copyreports_propertybtn_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the property field");

			// click on the copy button of the model
			click("envreports_copyreports_modelcopybtn_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("The report is copied to the respective property successfully.");

			// wait for the element
			explicitWaitClickable("closetoastmsg_CSS");

			// click on the toaster close button
			click("closetoastmsg_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the toaster close button.");

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

		// VERIFY COPIED ENVIRONMENTAL REPORT IS DISPLAYED OR NOT IN RESPECTIVE PROPERTY
		// AT BUILDING LEVEL (DESTINY PROPERTY HAVE BUILDING)

		System.out.println(
				"******************** VERIFY COPIED ENVIRONMENTAL REPORT IS DISPLAYED OR NOT IN RESPECTIVE PROPERTY AT BUILDING LEVEL (DESTINY PROPERTY HAVE BUILDING) ********************");
		test.log(LogStatus.INFO,
				"******************** VERIFY COPIED ENVIRONMENTAL REPORT IS DISPLAYED OR NOT IN RESPECTIVE PROPERTY AT BUILDING LEVEL (DESTINY PROPERTY HAVE BUILDING) ********************");
		Reporter.log(
				"******************** VERIFY COPIED ENVIRONMENTAL REPORT IS DISPLAYED OR NOT IN RESPECTIVE PROPERTY AT BUILDING LEVEL (DESTINY PROPERTY HAVE BUILDING) ********************");
		log.info(
				"******************** VERIFY COPIED ENVIRONMENTAL REPORT IS DISPLAYED OR NOT IN RESPECTIVE PROPERTY AT BUILDING LEVEL (DESTINY PROPERTY HAVE BUILDING) ********************");

		try {
			// apply the filter 1 on the property list
			clear("envreports_propertylist_filtertxt_CSS");
			type("envreports_propertylist_filtertxt_CSS", data.get("property_3"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Applied the filter 1 on the property list.");

			// click on the environmental icon from the property list page
			click("environmentalicon_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the environmental icon of the Property.");

			// wait for the element
			Thread.sleep(5000);

			// click on the burger menu
			click("menubtn_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the burger menu button successfully!!!");

			// wait for the element
			Thread.sleep(5000);

			// click on the environmental report
			click("envreportoption_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the Environmental Report option.");

//			// select the building from the drop down
//			select("propertyinfo_propertydd_XPATH", data.get("buildingName_dd1"));
//			ngDriver.waitForAngularRequestsToFinish();
//			System.out.println("Selected the building from the drop down.");

			// enter the newly created environmental report in the search field
			clear("task_listofchecklist_filterfield_CSS");
			type("task_listofchecklist_filterfield_CSS", data.get("title_building"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the newly created environmental report in the search field.");

			// verify copied environmental report is displayed or not
			switchVerification("envreports_copiedreport_building_XPATH", "Test Title Copy Report Building Level CI6",
					"The Test Title Copy Report Building Level CI6 is not displayed.");

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

		// CREATE NEW ENVIRONMENTAL REPORT AT BUILDING LEVEL (DESTINY PROPERTY DOESN'T
		// HAVE BUILDING)

		System.out.println(
				"******************** CREATE NEW ENVIRONMENTAL REPORT AT BUILDING LEVEL (DESTINY PROPERTY DOESN'T HAVE BUILDING) ********************");
		test.log(LogStatus.INFO,
				"******************** CREATE NEW ENVIRONMENTAL REPORT AT BUILDING LEVEL (DESTINY PROPERTY DOESN'T HAVE BUILDING) ********************");
		Reporter.log(
				"******************** CREATE NEW ENVIRONMENTAL REPORT AT BUILDING LEVEL (DESTINY PROPERTY DOESN'T HAVE BUILDING) ********************");
		log.info(
				"******************** CREATE NEW ENVIRONMENTAL REPORT AT BUILDING LEVEL (DESTINY PROPERTY DOESN'T HAVE BUILDING) ********************");

		try {
			// apply the filter 1 on the property list
			clear("envreports_propertylist_filtertxt_CSS");
			type("envreports_propertylist_filtertxt_CSS", data.get("property_2"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Applied the filter 1 on the property list.");

			// click on the environmental icon from the property list page
			click("environmentalicon_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the environmental icon of the Property.");

			// wait for the element
			Thread.sleep(5000);

			// click on the burger menu
			click("menubtn_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the burger menu button successfully!!!");

			// wait for the element
			Thread.sleep(5000);

			// click on the environmental report
			click("envreportoption_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the Environmental Report option.");

			// select the building from the drop down
			select("propertyinfo_propertydd_XPATH", data.get("buildingName_dd"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Selected the building from the drop down.");

			// click on the Add report button
			click("envreportaddbtn_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the Add report button");

			// select the checklist from the type dropdown
			select("envreporttypedd_CSS", data.get("type"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("The option is selected from the Type dropdown.");

			// enter the title
			type("envreporttitletxt_CSS", data.get("title_building1"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("The data entered in the Title field.");

			// click on the date field
			click("envreportdatetxt_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the date field.");

			// click on the today button
			click("envreporttodaydate_BTNTEXT");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Today's date selected in the Date Field.");

			// enter the company
			type("envreportcompanytxt_CSS", data.get("company"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("The data entered in the Company field.");

			// enter the author
			type("envreportauthortxt_CSS", data.get("author"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("The data entered in the Author field.");

			// enter the description
			type("envreportdescriptiontxt_CSS", data.get("description"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("The data entered in the Description field.");

			// click on the Add report button
			click("envreportsavebtn_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the Save Button.");

			// enter the newly created environmental report in the search field
			clear("task_listofchecklist_filterfield_CSS");
			type("task_listofchecklist_filterfield_CSS", data.get("title_building1"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the newly created environmental report in the search field.");

			// verification of the environmental report is added or not
			switchVerification("envreportaddedrecord_building1_ci6_XPATH",
					"Test Title Copy Report Building Level One CI6",
					"The Test Title Copy Report Building Level One CI6 is not displayed successfully.");

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

		// COPY NEWLY CREATED REPORT TO ANOTHER PROPERTY AT BUILLDING LEVEL (DESTINY
		// PROPERTY DON'T HAVE BUILDING)

		System.out.println(
				"******************** COPY NEWLY CREATED REPORT TO ANOTHER PROPERTY AT BUILLDING LEVEL (DESTINY PROPERTY DON'T HAVE BUILDING) ********************");
		test.log(LogStatus.INFO,
				"******************** COPY NEWLY CREATED REPORT TO ANOTHER PROPERTY AT BUILLDING LEVEL (DESTINY PROPERTY DON'T HAVE BUILDING) ********************");
		Reporter.log(
				"******************** COPY NEWLY CREATED REPORT TO ANOTHER PROPERTY AT BUILLDING LEVEL (DESTINY PROPERTY DON'T HAVE BUILDING) ********************");
		log.info(
				"******************** COPY NEWLY CREATED REPORT TO ANOTHER PROPERTY AT BUILLDING LEVEL (DESTINY PROPERTY DON'T HAVE BUILDING) ********************");

		try {
			// apply the filter 1 on the property list
			clear("envreports_propertylist_filtertxt_CSS");
			type("envreports_propertylist_filtertxt_CSS", data.get("property_2"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Applied the filter 1 on the property list.");

			// click on the environmental icon from the property list page
			click("environmentalicon_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the environmental icon of the Property.");

			// wait for the element
			Thread.sleep(5000);

			// click on the burger menu
			click("menubtn_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the burger menu button successfully!!!");

			// wait for the element
			Thread.sleep(5000);

			// click on the environmental report
			click("envreportoption_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the Environmental Report option.");

			// select the building from the drop down
			select("propertyinfo_propertydd_XPATH", data.get("buildingName_dd"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Selected the building from the drop down.");

			// enter the newly created environmental report in the search field
			clear("task_listofchecklist_filterfield_CSS");
			type("task_listofchecklist_filterfield_CSS", data.get("title_building1"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the newly created environmental report in the search field.");

			// click on the checkbox of the newly created environmental report
			String environmentalReportCheckbox = "//span[text()='" + data.get("title_building1")
					+ "']//parent::td[@ng-click='editRecord(document)']//preceding-sibling::td//input[@ng-click='selectRecord(document)']";
			driver.findElement(By.xpath(environmentalReportCheckbox)).click();
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the checkbox of the newly created environmental report.");

			// click on the copy button
			click("envreportaddedrecord_copybtn_ci6_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the copy button.");

			// wait for the element
			Thread.sleep(5000);

			// click on the property field
			click("envreports_copyreports_propertybtn_XPATH");
			System.out.println("Clicked on the property field");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the none button
			click("task_tasktag_nonebtn_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the none button.");

			// enter the property name in the search field
			type("envreports_copyreports_findpropertytxt_CSS", data.get("property_1"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the property name in the search field.");

			// click on the searched result
			click("envreports_copyreports_selectproperty_property1_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Property is selected from the list of property for copy the records");

			// click on the property field
			click("envreports_copyreports_propertybtn_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the property field");

			// click on the copy button of the model
			click("envreports_copyreports_modelcopybtn_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("The report is copied to the respective property successfully.");

			// wait for the element
			explicitWaitClickable("closetoastmsg_CSS");

			// click on the toaster close button
			click("closetoastmsg_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the toaster close button.");

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

		// VERIFY COPIED ENVIRONMENTAL REPORT IS DISPLAYED OR NOT IN RESPECTIVE PROPERTY
		// AT BUILDING LEVEL (DESTINY PROPERTY DON'T HAVE BUILDING)

		System.out.println(
				"******************** VERIFY COPIED ENVIRONMENTAL REPORT IS DISPLAYED OR NOT IN RESPECTIVE PROPERTY AT BUILDING LEVEL (DESTINY PROPERTY DON'T HAVE BUILDING) ********************");
		test.log(LogStatus.INFO,
				"******************** VERIFY COPIED ENVIRONMENTAL REPORT IS DISPLAYED OR NOT IN RESPECTIVE PROPERTY AT BUILDING LEVEL (DESTINY PROPERTY DON'T HAVE BUILDING) ********************");
		Reporter.log(
				"******************** VERIFY COPIED ENVIRONMENTAL REPORT IS DISPLAYED OR NOT IN RESPECTIVE PROPERTY AT BUILDING LEVEL (DESTINY PROPERTY DON'T HAVE BUILDING) ********************");
		log.info(
				"******************** VERIFY COPIED ENVIRONMENTAL REPORT IS DISPLAYED OR NOT IN RESPECTIVE PROPERTY AT BUILDING LEVEL (DESTINY PROPERTY DON'T HAVE BUILDING) ********************");

		try {
			// apply the filter 1 on the property list
			clear("envreports_propertylist_filtertxt_CSS");
			type("envreports_propertylist_filtertxt_CSS", data.get("property_1"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Applied the filter 1 on the property list.");

			// click on the environmental icon from the property list page
			click("environmentalicon_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the environmental icon of the Property.");

			// wait for the element
			Thread.sleep(5000);

			// click on the burger menu
			click("menubtn_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the burger menu button successfully!!!");

			// wait for the element
			Thread.sleep(5000);

			// click on the environmental report
			click("envreportoption_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the Environmental Report option.");

			// enter the newly created environmental report in the search field
			clear("task_listofchecklist_filterfield_CSS");
			type("task_listofchecklist_filterfield_CSS", data.get("title_building1"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the newly created environmental report in the search field.");

			// verify copied environmental report is displayed or not
			switchVerification("envreports_copiedreport_building1_XPATH",
					"Test Title Copy Report Building Level One CI6",
					"The Test Title Copy Report Building Level One CI6 is not displayed.");

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

		// DELETE THE NEWLY CREATED ENVIRONMENTAL REPORT IN PROPERTY ONE

		System.out.println(
				"******************** DELETE THE NEWLY CREATED ENVIRONMENTAL REPORT IN PROPERTY ONE ********************");
		test.log(LogStatus.INFO,
				"******************** DELETE THE NEWLY CREATED ENVIRONMENTAL REPORT IN PROPERTY ONE ********************");
		Reporter.log(
				"******************** DELETE THE NEWLY CREATED ENVIRONMENTAL REPORT IN PROPERTY ONE ********************");
		log.info(
				"******************** DELETE THE NEWLY CREATED ENVIRONMENTAL REPORT IN PROPERTY ONE ********************");

		try {

			// enter the property name in the search field
			clear("envreports_propertylist_filtertxt_CSS");
			type("envreports_propertylist_filtertxt_CSS", data.get("property_1"));
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

		// DELETE THE NEWLY CREATED ENVIRONMENTAL REPORT IN PROPERTY TWO

		System.out.println(
				"******************** DELETE THE NEWLY CREATED ENVIRONMENTAL REPORT IN PROPERTY TWO ********************");
		test.log(LogStatus.INFO,
				"******************** DELETE THE NEWLY CREATED ENVIRONMENTAL REPORT IN PROPERTY TWO ********************");
		Reporter.log(
				"******************** DELETE THE NEWLY CREATED ENVIRONMENTAL REPORT IN PROPERTY TWO ********************");
		log.info(
				"******************** DELETE THE NEWLY CREATED ENVIRONMENTAL REPORT IN PROPERTY TWO ********************");

		try {

			// enter the property name in the search field
			clear("envreports_propertylist_filtertxt_CSS");
			type("envreports_propertylist_filtertxt_CSS", data.get("property_2"));
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

			}

			// wait for the element
			Thread.sleep(7000);

//			// select the building from the drop down
//			select("propertyinfo_propertydd_XPATH", data.get("buildingName_dd"));
//			ngDriver.waitForAngularRequestsToFinish();
//			System.out.println("Selected the building from the drop down.");
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
//				ngDriver.waitForAngularRequestsToFinish();
//				System.out.println("Clicked on the environmental report.");
//
//				// wait for the element
//				explicitWaitClickable("envreportdeletebtn_CSS");
//
//				// click on the delete button
//				click("envreportdeletebtn_CSS");
//				System.out.println("Clicked on the Delete Button.");
//				ngDriver.waitForAngularRequestsToFinish();
//				System.out.println("The confirmation pop up model is displayed.");
//
//				// wait for the element
//				explicitWaitClickable("envreportmodeldeletebtn_CSS");
//
//				// click on the delete button of the confirmation model
//				click("envreportmodeldeletebtn_CSS");
//				System.out.println("Clicked on the Delete Button of the confirmation popup model.");
//				ngDriver.waitForAngularRequestsToFinish();
//
//				// wait for the element
//				explicitWaitClickable("closetoastmsg_CSS");
//
//				// click on the toaster close button
//				click("closetoastmsg_CSS");
//				ngDriver.waitForAngularRequestsToFinish();
//				System.out.println("Clicked on the toaster close button.");
//
//			}

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

		// DELETE THE NEWLY CREATED ENVIRONMENTAL REPORT IN PROPERTY THREE

		System.out.println(
				"******************** DELETE THE NEWLY CREATED ENVIRONMENTAL REPORT IN PROPERTY THREE ********************");
		test.log(LogStatus.INFO,
				"******************** DELETE THE NEWLY CREATED ENVIRONMENTAL REPORT IN PROPERTY THREE ********************");
		Reporter.log(
				"******************** DELETE THE NEWLY CREATED ENVIRONMENTAL REPORT IN PROPERTY THREE ********************");
		log.info(
				"******************** DELETE THE NEWLY CREATED ENVIRONMENTAL REPORT IN PROPERTY THREE ********************");

		try {

			// enter the property name in the search field
			clear("envreports_propertylist_filtertxt_CSS");
			type("envreports_propertylist_filtertxt_CSS", data.get("property_3"));
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

//			// select the building from the drop down
//			select("propertyinfo_propertydd_XPATH", data.get("buildingName_dd1"));
//			ngDriver.waitForAngularRequestsToFinish();
//			System.out.println("Selected the building from the drop down.");
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
//				ngDriver.waitForAngularRequestsToFinish();
//				System.out.println("Clicked on the environmental report.");
//
//				// wait for the element
//				explicitWaitClickable("envreportdeletebtn_CSS");
//
//				// click on the delete button
//				click("envreportdeletebtn_CSS");
//				System.out.println("Clicked on the Delete Button.");
//				ngDriver.waitForAngularRequestsToFinish();
//				System.out.println("The confirmation pop up model is displayed.");
//
//				// wait for the element
//				explicitWaitClickable("envreportmodeldeletebtn_CSS");
//
//				// click on the delete button of the confirmation model
//				click("envreportmodeldeletebtn_CSS");
//				System.out.println("Clicked on the Delete Button of the confirmation popup model.");
//				ngDriver.waitForAngularRequestsToFinish();
//
//				// wait for the element
//				explicitWaitClickable("closetoastmsg_CSS");
//
//				// click on the toaster close button
//				click("closetoastmsg_CSS");
//				ngDriver.waitForAngularRequestsToFinish();
//				System.out.println("Clicked on the toaster close button.");
//
//			}

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

		// CREATE NEW ENVIRONMENTAL RECORD AT PROPERTY LEVEL

		System.out
				.println("******************** CREATE NEW ENVIRONMENTAL RECORD AT PROPERTY LEVEL ********************");
		test.log(LogStatus.INFO,
				"******************** CREATE NEW ENVIRONMENTAL RECORD AT PROPERTY LEVEL ********************");
		Reporter.log("******************** CREATE NEW ENVIRONMENTAL RECORD AT PROPERTY LEVEL ********************");
		log.info("******************** CREATE NEW ENVIRONMENTAL RECORD AT PROPERTY LEVEL ********************");

		try {

			// enter the property name in the search field
			clear("envreports_propertylist_filtertxt_CSS");
			type("envreports_propertylist_filtertxt_CSS", data.get("property_2"));
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
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the burger menu button successfully!!!");

			// wait for the element
			Thread.sleep(5000);

			// click on the environmental records
			click("envrecords_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the Environmental Records option.");

			// click on the Primary Hazardous Substance
			click("envrecords_primaryhazardoussubstance_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the Primary Hazardous Substance option");

			// click on the asbestos materials
			click("envreports_asbestosmaterials_XPATH");
			System.out.println("Clicked on the Asbestos Materials option.");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Navigate to the Asbestos Meteria Records Screen.");

			// click on the add button
			click("envreports_asbestosmaterials_addbtn_CSS");
			System.out.println("Clicked on the Add button.");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Navigate to the Add Asbestos Material Screen");

			// select the material
			select("envreports_asbestosmaterials_materialdd_CSS", data.get("material"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("The option is selected from the Material dropdown.");

			// enter the detailed location details in the field
			type("envreports_asbestosmaterials_detailedlocationtxt_CSS", data.get("detailed_location_property"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the detailed location details in the field.");

			// scroll down the screen
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,400)");

			// select the is material asbestos containing
			select("envreports_asbestosmaterials_ismaterialasbestoscontainingdd_CSS",
					data.get("is_material_asbestos_containing"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("The option is selected from the Material Analyzed dropdown.");

			// select the asbestos type
			select("envreports_asbestosmaterials_asbestostypedd_CSS", data.get("asbestos_type"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("The option is selected from the Asbestos Type dropdown.");

			// select the condition
			select("envreports_asbestosmaterials_conditiondd_CSS", data.get("condition"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("The option is selected from the Condition dropdown.");

			// select the status
			select("envreports_asbestosmaterials_statusdd_CSS", data.get("status"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("The option is selected from the Status dropdown.");

			// scroll till bottom of the page
			WebElement savebtn = driver
					.findElement(By.cssSelector(OR.getProperty("envreports_asbestosmaterials_savebtn_CSS")));
			js.executeScript("arguments[0].scrollIntoView(true);", savebtn);

			// click on the save button
			click("envreports_asbestosmaterials_savebtn_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("The save button clicked successfully");

			// wait for the element
			explicitWaitClickable("closetoastmsg_CSS");

			// click on the toaster close button
			click("closetoastmsg_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the toaster close button.");

			// enter the newly created environmental record in the search field
			clear("task_listofchecklist_filterfield_CSS");
			type("task_listofchecklist_filterfield_CSS", data.get("detailed_location_property"));
			System.out.println("Entered the newly created environmental record in the search field.");
			ngDriver.waitForAngularRequestsToFinish();

			// verify the newly created Asbestos Materials record
			switchVerification("envreports_asbestosmaterials_propertylevel_XPATH",
					"Test Detailed Location Property Level CI6",
					"The Test Detailed Location Property Level CI6 is not displayed successfully.");

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

		// COPY NEWLY CREATED RECORD TO ANOTHER PROPERTY AT PROPERTY LEVEL

		System.out.println(
				"******************** COPY NEWLY CREATED RECORD TO ANOTHER PROPERTY AT PROPERTY LEVEL ********************");
		test.log(LogStatus.INFO,
				"******************** COPY NEWLY CREATED RECORD TO ANOTHER PROPERTY AT PROPERTY LEVEL ********************");
		Reporter.log(
				"******************** COPY NEWLY CREATED RECORD TO ANOTHER PROPERTY AT PROPERTY LEVEL ********************");
		log.info(
				"******************** COPY NEWLY CREATED RECORD TO ANOTHER PROPERTY AT PROPERTY LEVEL ********************");

		try {
			// enter the property name in the search field
			clear("envreports_propertylist_filtertxt_CSS");
			type("envreports_propertylist_filtertxt_CSS", data.get("property_2"));
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
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the burger menu button successfully!!!");

			// wait for the element
			Thread.sleep(5000);

			// click on the environmental records
			click("envrecords_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the Environmental Records option.");

			// click on the Primary Hazardous Substance
			click("envrecords_primaryhazardoussubstance_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the Primary Hazardous Substance option");

			// click on the asbestos materials
			click("envreports_asbestosmaterials_XPATH");
			System.out.println("Clicked on the Asbestos Materials option.");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Navigate to the Asbestos Meteria Records Screen.");

			// enter the newly created environmental record in the search field
			clear("task_listofchecklist_filterfield_CSS");
			type("task_listofchecklist_filterfield_CSS", data.get("detailed_location_property"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the newly created environmental record in the search field.");

			// click on the checkbox of the newly created environmental record
			String environmentalRecordCheckbox = "//span[text()='" + data.get("detailed_location_property")
					+ "']//parent::td[@id='detailedLocation']//preceding-sibling::td//input[@ng-click='selectRecord(document)']";
			driver.findElement(By.xpath(environmentalRecordCheckbox)).click();
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the checkbox of the newly created environmental record.");

			// click on the copy button
			click("envreportaddedrecord_copybtn_ci6_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the copy button.");

			// wait for the element
			Thread.sleep(5000);

			// click on the property field
			click("envreports_copyreports_propertybtn_XPATH");
			System.out.println("Clicked on the property field");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the none button
			click("task_tasktag_nonebtn_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the none button.");

			// enter the property name in the search field
			type("envreports_copyreports_findpropertytxt_CSS", data.get("property_3"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the property name in the search field.");

			// click on the searched result
			click("envreports_copyreports_selectproperty_property3_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Property is selected from the list of property for copy the records");

			// click on the property field
			click("envreports_copyreports_propertybtn_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the property field");

			// click on the copy button of the model
			click("envreports_copyreports_modelcopybtn_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("The report is copied to the respective property successfully.");

			// wait for the element
			explicitWaitClickable("closetoastmsg_CSS");

			// click on the toaster close button
			click("closetoastmsg_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the toaster close button.");

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

		// VERIFY COPIED ENVIRONMENTAL RECORD IS DISPLAYED OR NOT IN RESPECTIVE PROPERTY
		// AT PROPERTY LEVEL

		System.out.println(
				"******************** VERIFY COPIED ENVIRONMENTAL RECORD IS DISPLAYED OR NOT IN RESPECTIVE PROPERTY AT PROPERTY LEVEL ********************");
		test.log(LogStatus.INFO,
				"******************** VERIFY COPIED ENVIRONMENTAL RECORD IS DISPLAYED OR NOT IN RESPECTIVE PROPERTY AT PROPERTY LEVEL ********************");
		Reporter.log(
				"******************** VERIFY COPIED ENVIRONMENTAL RECORD IS DISPLAYED OR NOT IN RESPECTIVE PROPERTY AT PROPERTY LEVEL ********************");
		log.info(
				"******************** VERIFY COPIED ENVIRONMENTAL RECORD IS DISPLAYED OR NOT IN RESPECTIVE PROPERTY AT PROPERTY LEVEL ********************");

		try {
			// enter the property name in the search field
			clear("envreports_propertylist_filtertxt_CSS");
			type("envreports_propertylist_filtertxt_CSS", data.get("property_3"));
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
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the burger menu button successfully!!!");

			// wait for the element
			Thread.sleep(5000);

			// click on the environmental records
			click("envrecords_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the Environmental Records option.");

			// click on the Primary Hazardous Substance
			click("envrecords_primaryhazardoussubstance_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the Primary Hazardous Substance option");

			// click on the asbestos materials
			click("envreports_asbestosmaterials_XPATH");
			System.out.println("Clicked on the Asbestos Materials option.");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Navigate to the Asbestos Meteria Records Screen.");

			// enter the newly created environmental record in the search field
			clear("task_listofchecklist_filterfield_CSS");
			type("task_listofchecklist_filterfield_CSS", data.get("detailed_location_property"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the newly created environmental record in the search field.");

			// verify the newly created Asbestos Materials record
			switchVerification("envreports_asbestosmaterials_propertylevel_XPATH",
					"Test Detailed Location Property Level CI6",
					"The Test Detailed Location Property Level CI6 is not displayed successfully.");

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

		// CREATE NEW ENVIRONMENTAL REPORT AT BUILDING LEVEL (DESTINY PROPERTY HAVE
		// BUILDING)

		System.out.println(
				"******************** CREATE NEW ENVIRONMENTAL REPORT AT BUILDING LEVEL (DESTINY PROPERTY HAVE BUILDING) ********************");
		test.log(LogStatus.INFO,
				"******************** CREATE NEW ENVIRONMENTAL REPORT AT BUILDING LEVEL (DESTINY PROPERTY HAVE BUILDING) ********************");
		Reporter.log(
				"******************** CREATE NEW ENVIRONMENTAL REPORT AT BUILDING LEVEL (DESTINY PROPERTY HAVE BUILDING) ********************");
		log.info(
				"******************** CREATE NEW ENVIRONMENTAL REPORT AT BUILDING LEVEL (DESTINY PROPERTY HAVE BUILDING) ********************");

		try {
			// enter the property name in the search field
			clear("envreports_propertylist_filtertxt_CSS");
			type("envreports_propertylist_filtertxt_CSS", data.get("property_2"));
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
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the burger menu button successfully!!!");

			// wait for the element
			Thread.sleep(5000);

			// click on the environmental records
			click("envrecords_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the Environmental Records option.");

			// click on the Primary Hazardous Substance
			click("envrecords_primaryhazardoussubstance_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the Primary Hazardous Substance option");

			// click on the asbestos materials
			click("envreports_asbestosmaterials_XPATH");
			System.out.println("Clicked on the Asbestos Materials option.");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Navigate to the Asbestos Meteria Records Screen.");

			// select the building from the drop down
			select("propertyinfo_propertydd_XPATH", data.get("buildingName_dd"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Selected the building from the drop down.");

			// click on the add button
			click("envreports_asbestosmaterials_addbtn_CSS");
			System.out.println("Clicked on the Add button.");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Navigate to the Add Asbestos Material Screen");

			// select the material
			select("envreports_asbestosmaterials_materialdd_CSS", data.get("material"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("The option is selected from the Material dropdown.");

			// enter the detailed location details in the field
			type("envreports_asbestosmaterials_detailedlocationtxt_CSS", data.get("detailed_location_building"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the detailed location details in the field.");

			// scroll down the screen
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,400)");

			// select the is material asbestos containing
			select("envreports_asbestosmaterials_ismaterialasbestoscontainingdd_CSS",
					data.get("is_material_asbestos_containing"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("The option is selected from the Material Analyzed dropdown.");

			// select the asbestos type
			select("envreports_asbestosmaterials_asbestostypedd_CSS", data.get("asbestos_type"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("The option is selected from the Asbestos Type dropdown.");

			// select the condition
			select("envreports_asbestosmaterials_conditiondd_CSS", data.get("condition"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("The option is selected from the Condition dropdown.");

			// select the status
			select("envreports_asbestosmaterials_statusdd_CSS", data.get("status"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("The option is selected from the Status dropdown.");

			// scroll till bottom of the page
			WebElement savebtn = driver
					.findElement(By.cssSelector(OR.getProperty("envreports_asbestosmaterials_savebtn_CSS")));
			js.executeScript("arguments[0].scrollIntoView(true);", savebtn);

			// click on the save button
			click("envreports_asbestosmaterials_savebtn_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("The save button clicked successfully");

			// wait for the element
			explicitWaitClickable("closetoastmsg_CSS");

			// click on the toaster close button
			click("closetoastmsg_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the toaster close button.");

			// enter the newly created environmental record in the search field
			clear("task_listofchecklist_filterfield_CSS");
			type("task_listofchecklist_filterfield_CSS", data.get("detailed_location_building"));
			System.out.println("Entered the newly created environmental record in the search field.");
			ngDriver.waitForAngularRequestsToFinish();

			// verify the newly created Asbestos Materials record
			switchVerification("envreports_asbestosmaterials_buildinglevel_XPATH",
					"Test Detailed Location Building Level CI6",
					"The Test Detailed Location Building Level CI6 is not displayed successfully.");

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

		// COPY NEWLY CREATED REPORT TO ANOTHER PROPERTY AT BUILLDING LEVEL (DESTINY
		// PROPERTY HAVE BUILDING)

		System.out.println(
				"******************** COPY NEWLY CREATED REPORT TO ANOTHER PROPERTY AT BUILLDING LEVEL (DESTINY PROPERTY HAVE BUILDING) ********************");
		test.log(LogStatus.INFO,
				"******************** COPY NEWLY CREATED REPORT TO ANOTHER PROPERTY AT BUILLDING LEVEL (DESTINY PROPERTY HAVE BUILDING) ********************");
		Reporter.log(
				"******************** COPY NEWLY CREATED REPORT TO ANOTHER PROPERTY AT BUILLDING LEVEL (DESTINY PROPERTY HAVE BUILDING) ********************");
		log.info(
				"******************** COPY NEWLY CREATED REPORT TO ANOTHER PROPERTY AT BUILLDING LEVEL (DESTINY PROPERTY HAVE BUILDING) ********************");

		try {
			// enter the property name in the search field
			clear("envreports_propertylist_filtertxt_CSS");
			type("envreports_propertylist_filtertxt_CSS", data.get("property_2"));
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
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the burger menu button successfully!!!");

			// wait for the element
			Thread.sleep(5000);

			// click on the environmental records
			click("envrecords_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the Environmental Records option.");

			// click on the Primary Hazardous Substance
			click("envrecords_primaryhazardoussubstance_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the Primary Hazardous Substance option");

			// click on the asbestos materials
			click("envreports_asbestosmaterials_XPATH");
			System.out.println("Clicked on the Asbestos Materials option.");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Navigate to the Asbestos Meteria Records Screen.");

			// select the building from the drop down
			select("propertyinfo_propertydd_XPATH", data.get("buildingName_dd"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Selected the building from the drop down.");

			// enter the newly created environmental record in the search field
			clear("task_listofchecklist_filterfield_CSS");
			type("task_listofchecklist_filterfield_CSS", data.get("detailed_location_building"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the newly created environmental record in the search field.");

			// click on the checkbox of the newly created environmental record
			String environmentalRecordCheckbox = "//span[text()='" + data.get("detailed_location_building")
					+ "']//parent::td[@id='detailedLocation']//preceding-sibling::td//input[@ng-click='selectRecord(document)']";
			driver.findElement(By.xpath(environmentalRecordCheckbox)).click();
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the checkbox of the newly created environmental record.");

			// click on the copy button
			click("envreportaddedrecord_copybtn_ci6_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the copy button.");

			// wait for the element
			Thread.sleep(5000);

			// click on the property field
			click("envreports_copyreports_propertybtn_XPATH");
			System.out.println("Clicked on the property field");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the none button
			click("task_tasktag_nonebtn_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the none button.");

			// enter the property name in the search field
			type("envreports_copyreports_findpropertytxt_CSS", data.get("property_3"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the property name in the search field.");

			// click on the searched result
			click("envreports_copyreports_selectproperty_property3_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Property is selected from the list of property for copy the records");

			// click on the property field
			click("envreports_copyreports_propertybtn_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the property field");

			// click on the copy button of the model
			click("envreports_copyreports_modelcopybtn_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("The report is copied to the respective property successfully.");

			// wait for the element
			explicitWaitClickable("closetoastmsg_CSS");

			// click on the toaster close button
			click("closetoastmsg_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the toaster close button.");

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

		// VERIFY COPIED ENVIRONMENTAL REPORT IS DISPLAYED OR NOT IN RESPECTIVE PROPERTY
		// AT BUILDING LEVEL (DESTINY PROPERTY HAVE BUILDING)

		System.out.println(
				"******************** VERIFY COPIED ENVIRONMENTAL REPORT IS DISPLAYED OR NOT IN RESPECTIVE PROPERTY AT BUILDING LEVEL (DESTINY PROPERTY HAVE BUILDING) ********************");
		test.log(LogStatus.INFO,
				"******************** VERIFY COPIED ENVIRONMENTAL REPORT IS DISPLAYED OR NOT IN RESPECTIVE PROPERTY AT BUILDING LEVEL (DESTINY PROPERTY HAVE BUILDING) ********************");
		Reporter.log(
				"******************** VERIFY COPIED ENVIRONMENTAL REPORT IS DISPLAYED OR NOT IN RESPECTIVE PROPERTY AT BUILDING LEVEL (DESTINY PROPERTY HAVE BUILDING) ********************");
		log.info(
				"******************** VERIFY COPIED ENVIRONMENTAL REPORT IS DISPLAYED OR NOT IN RESPECTIVE PROPERTY AT BUILDING LEVEL (DESTINY PROPERTY HAVE BUILDING) ********************");

		try {
			// enter the property name in the search field
			clear("envreports_propertylist_filtertxt_CSS");
			type("envreports_propertylist_filtertxt_CSS", data.get("property_3"));
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
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the burger menu button successfully!!!");

			// wait for the element
			Thread.sleep(5000);

			// click on the environmental records
			click("envrecords_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the Environmental Records option.");

			// click on the Primary Hazardous Substance
			click("envrecords_primaryhazardoussubstance_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the Primary Hazardous Substance option");

			// click on the asbestos materials
			click("envreports_asbestosmaterials_XPATH");
			System.out.println("Clicked on the Asbestos Materials option.");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Navigate to the Asbestos Meteria Records Screen.");

//			// select the building from the drop down
//			select("propertyinfo_propertydd_XPATH", data.get("buildingName_dd1"));
//			ngDriver.waitForAngularRequestsToFinish();
//			System.out.println("Selected the building from the drop down.");

			// enter the newly created environmental record in the search field
			clear("task_listofchecklist_filterfield_CSS");
			type("task_listofchecklist_filterfield_CSS", data.get("detailed_location_building"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the newly created environmental record in the search field.");

			// verify the newly created Asbestos Materials record
			switchVerification("envreports_asbestosmaterials_buildinglevel_XPATH",
					"Test Detailed Location Building Level CI6",
					"The Test Detailed Location Building Level CI6 is not displayed successfully.");

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

		// CREATE NEW ENVIRONMENTAL RECORD AT BUILDING LEVEL (DESTINY PROPERTY DOESN'T
		// HAVE BUILDING)

		System.out.println(
				"******************** CREATE NEW ENVIRONMENTAL RECORD AT BUILDING LEVEL (DESTINY PROPERTY DOESN'T HAVE BUILDING) ********************");
		test.log(LogStatus.INFO,
				"******************** CREATE NEW ENVIRONMENTAL RECORD AT BUILDING LEVEL (DESTINY PROPERTY DOESN'T HAVE BUILDING) ********************");
		Reporter.log(
				"******************** CREATE NEW ENVIRONMENTAL RECORD AT BUILDING LEVEL (DESTINY PROPERTY DOESN'T HAVE BUILDING) ********************");
		log.info(
				"******************** CREATE NEW ENVIRONMENTAL RECORD AT BUILDING LEVEL (DESTINY PROPERTY DOESN'T HAVE BUILDING) ********************");

		try {
			// enter the property name in the search field
			clear("envreports_propertylist_filtertxt_CSS");
			type("envreports_propertylist_filtertxt_CSS", data.get("property_2"));
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
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the burger menu button successfully!!!");

			// wait for the element
			Thread.sleep(5000);

			// click on the environmental records
			click("envrecords_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the Environmental Records option.");

			// click on the Primary Hazardous Substance
			click("envrecords_primaryhazardoussubstance_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the Primary Hazardous Substance option");

			// click on the asbestos materials
			click("envreports_asbestosmaterials_XPATH");
			System.out.println("Clicked on the Asbestos Materials option.");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Navigate to the Asbestos Meteria Records Screen.");

			// select the building from the drop down
			select("propertyinfo_propertydd_XPATH", data.get("buildingName_dd"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Selected the building from the drop down.");

			// click on the add button
			click("envreports_asbestosmaterials_addbtn_CSS");
			System.out.println("Clicked on the Add button.");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Navigate to the Add Asbestos Material Screen");

			// select the material
			select("envreports_asbestosmaterials_materialdd_CSS", data.get("material"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("The option is selected from the Material dropdown.");

			// enter the detailed location details in the field
			type("envreports_asbestosmaterials_detailedlocationtxt_CSS", data.get("detailed_location_building1"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the detailed location details in the field.");

			// scroll down the screen
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,400)");

			// select the is material asbestos containing
			select("envreports_asbestosmaterials_ismaterialasbestoscontainingdd_CSS",
					data.get("is_material_asbestos_containing"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("The option is selected from the Material Analyzed dropdown.");

			// select the asbestos type
			select("envreports_asbestosmaterials_asbestostypedd_CSS", data.get("asbestos_type"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("The option is selected from the Asbestos Type dropdown.");

			// select the condition
			select("envreports_asbestosmaterials_conditiondd_CSS", data.get("condition"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("The option is selected from the Condition dropdown.");

			// select the status
			select("envreports_asbestosmaterials_statusdd_CSS", data.get("status"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("The option is selected from the Status dropdown.");

			// scroll till bottom of the page
			WebElement savebtn = driver
					.findElement(By.cssSelector(OR.getProperty("envreports_asbestosmaterials_savebtn_CSS")));
			js.executeScript("arguments[0].scrollIntoView(true);", savebtn);

			// click on the save button
			click("envreports_asbestosmaterials_savebtn_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("The save button clicked successfully");

			// wait for the element
			explicitWaitClickable("closetoastmsg_CSS");

			// click on the toaster close button
			click("closetoastmsg_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the toaster close button.");

			// enter the newly created environmental record in the search field
			clear("task_listofchecklist_filterfield_CSS");
			type("task_listofchecklist_filterfield_CSS", data.get("detailed_location_building1"));
			System.out.println("Entered the newly created environmental record in the search field.");
			ngDriver.waitForAngularRequestsToFinish();

			// verify the newly created Asbestos Materials record
			switchVerification("envreports_asbestosmaterials_buildinglevel1_XPATH",
					"Test Detailed Location Building Level One CI6",
					"The Test Detailed Location Building Level One CI6 is not displayed successfully.");

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

		// COPY NEWLY CREATED REPORT TO ANOTHER PROPERTY AT BUILLDING LEVEL (DESTINY
		// PROPERTY DON'T HAVE BUILDING)

		System.out.println(
				"******************** COPY NEWLY CREATED REPORT TO ANOTHER PROPERTY AT BUILLDING LEVEL (DESTINY PROPERTY DON'T HAVE BUILDING) ********************");
		test.log(LogStatus.INFO,
				"******************** COPY NEWLY CREATED REPORT TO ANOTHER PROPERTY AT BUILLDING LEVEL (DESTINY PROPERTY DON'T HAVE BUILDING) ********************");
		Reporter.log(
				"******************** COPY NEWLY CREATED REPORT TO ANOTHER PROPERTY AT BUILLDING LEVEL (DESTINY PROPERTY DON'T HAVE BUILDING) ********************");
		log.info(
				"******************** COPY NEWLY CREATED REPORT TO ANOTHER PROPERTY AT BUILLDING LEVEL (DESTINY PROPERTY DON'T HAVE BUILDING) ********************");

		try {
			// enter the property name in the search field
			clear("envreports_propertylist_filtertxt_CSS");
			type("envreports_propertylist_filtertxt_CSS", data.get("property_2"));
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
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the burger menu button successfully!!!");

			// wait for the element
			Thread.sleep(5000);

			// click on the environmental records
			click("envrecords_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the Environmental Records option.");

			// click on the Primary Hazardous Substance
			click("envrecords_primaryhazardoussubstance_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the Primary Hazardous Substance option");

			// click on the asbestos materials
			click("envreports_asbestosmaterials_XPATH");
			System.out.println("Clicked on the Asbestos Materials option.");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Navigate to the Asbestos Meteria Records Screen.");

			// select the building from the drop down
			select("propertyinfo_propertydd_XPATH", data.get("buildingName_dd"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Selected the building from the drop down.");

			// enter the newly created environmental record in the search field
			clear("task_listofchecklist_filterfield_CSS");
			type("task_listofchecklist_filterfield_CSS", data.get("detailed_location_building1"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the newly created environmental record in the search field.");

			// click on the checkbox of the newly created environmental record
			String environmentalRecordCheckbox = "//span[text()='" + data.get("detailed_location_building1")
					+ "']//parent::td[@id='detailedLocation']//preceding-sibling::td//input[@ng-click='selectRecord(document)']";
			driver.findElement(By.xpath(environmentalRecordCheckbox)).click();
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the checkbox of the newly created environmental record.");

			// click on the copy button
			click("envreportaddedrecord_copybtn_ci6_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the copy button.");

			// wait for the element
			Thread.sleep(5000);

			// click on the property field
			click("envreports_copyreports_propertybtn_XPATH");
			System.out.println("Clicked on the property field");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the none button
			click("task_tasktag_nonebtn_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the none button.");

			// enter the property name in the search field
			type("envreports_copyreports_findpropertytxt_CSS", data.get("property_1"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the property name in the search field.");

			// click on the searched result
			click("envreports_copyreports_selectproperty_property1_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Property is selected from the list of property for copy the records");

			// click on the property field
			click("envreports_copyreports_propertybtn_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the property field");

			// click on the copy button of the model
			click("envreports_copyreports_modelcopybtn_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("The report is copied to the respective property successfully.");

			// wait for the element
			explicitWaitClickable("closetoastmsg_CSS");

			// click on the toaster close button
			click("closetoastmsg_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the toaster close button.");

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

		// VERIFY COPIED ENVIRONMENTAL REPORT IS DISPLAYED OR NOT IN RESPECTIVE PROPERTY
		// AT BUILDING LEVEL (DESTINY PROPERTY DON'T HAVE BUILDING)

		System.out.println(
				"******************** VERIFY COPIED ENVIRONMENTAL REPORT IS DISPLAYED OR NOT IN RESPECTIVE PROPERTY AT BUILDING LEVEL (DESTINY PROPERTY DON'T HAVE BUILDING) ********************");
		test.log(LogStatus.INFO,
				"******************** VERIFY COPIED ENVIRONMENTAL REPORT IS DISPLAYED OR NOT IN RESPECTIVE PROPERTY AT BUILDING LEVEL (DESTINY PROPERTY DON'T HAVE BUILDING) ********************");
		Reporter.log(
				"******************** VERIFY COPIED ENVIRONMENTAL REPORT IS DISPLAYED OR NOT IN RESPECTIVE PROPERTY AT BUILDING LEVEL (DESTINY PROPERTY DON'T HAVE BUILDING) ********************");
		log.info(
				"******************** VERIFY COPIED ENVIRONMENTAL REPORT IS DISPLAYED OR NOT IN RESPECTIVE PROPERTY AT BUILDING LEVEL (DESTINY PROPERTY DON'T HAVE BUILDING) ********************");

		try {
			// enter the property name in the search field
			clear("envreports_propertylist_filtertxt_CSS");
			type("envreports_propertylist_filtertxt_CSS", data.get("property_1"));
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
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the burger menu button successfully!!!");

			// wait for the element
			Thread.sleep(5000);

			// click on the environmental records
			click("envrecords_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the Environmental Records option.");

			// click on the Primary Hazardous Substance
			click("envrecords_primaryhazardoussubstance_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the Primary Hazardous Substance option");

			// click on the asbestos materials
			click("envreports_asbestosmaterials_XPATH");
			System.out.println("Clicked on the Asbestos Materials option.");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Navigate to the Asbestos Meteria Records Screen.");

			// enter the newly created environmental record in the search field
			clear("task_listofchecklist_filterfield_CSS");
			type("task_listofchecklist_filterfield_CSS", data.get("detailed_location_building1"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the newly created environmental record in the search field.");

			// verify the newly created Asbestos Materials record
			switchVerification("envreports_asbestosmaterials_buildinglevel1_XPATH",
					"Test Detailed Location Building Level One CI6",
					"The Test Detailed Location Building Level One CI6 is not displayed successfully.");

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

		// DELETE THE NEWLY CREATED BUILDING FROM THE RESPECTIVE PROPERTY

		System.out.println(
				"******************** DELETE THE NEWLY CREATED BUILDING FROM THE RESPECTIVE PROPERTY ********************");
		test.log(LogStatus.INFO,
				"******************** DELETE THE NEWLY CREATED BUILDING FROM THE RESPECTIVE PROPERTY ********************");
		Reporter.log(
				"******************** DELETE THE NEWLY CREATED BUILDING FROM THE RESPECTIVE PROPERTY ********************");
		log.info(
				"******************** DELETE THE NEWLY CREATED BUILDING FROM THE RESPECTIVE PROPERTY ********************");

		try {

			// enter the property name in the search field
			clear("envreports_propertylist_filtertxt_CSS");
			type("envreports_propertylist_filtertxt_CSS", data.get("property_3"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the property name in the search field.");

			// click on the property information
			click("propertyinformationicon_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the property information.");

			// verify name of the property
			switchVerification("propertyinfo_propertynamelbl3_XPATH", "SmartCentres Brockville",
					"The SmartCentres Brockville property name is not displayed.");

			// click on the menu button
			click("propertyinfo_menubtn_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the menu button.");

			// click on the building option
			click("propertyinfo_menubtn_buildingoption_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the building option.");

			// click on the newly created building
			click("propertyinfo_newbuilding_createdbuilding_ci6_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the newly created building.");

			// wait for the element
			explicitWaitClickable("propertyinfo_newbuilding_deletebtn_XPATH");

			// click on the delete button
			click("propertyinfo_newbuilding_deletebtn_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the delete button.");

			// wait for the element
			explicitWaitClickable("propertyinfo_newbuilding_confirmationdeletebtn_XPATH");

			// click on the delete button of the confirmation
			click("propertyinfo_newbuilding_confirmationdeletebtn_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the delete button of the confirmation.");

			// wait for the element
			explicitWaitClickable("closetoastmsg_CSS");

			// click on the toaster close button
			click("closetoastmsg_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the toaster close button.");

			// verify deleted building is displayed or not

			deleteVerification("propertyinfo_newbuilding_createdbuilding_ci6_XPATH", "Test Building Name CI6");

			// click on the menu button
			click("propertyinfo_menubtn_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the menu button.");

			// click on the property details option
			click("propertyinfo_menubtn_propertydetailsoption_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the property details option.");

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

		// DELETE THE NEWLY CREATED ENVIRONMENTAL RECORD IN PROPERTY ONE

		System.out.println(
				"******************** DELETE THE NEWLY CREATED ENVIRONMENTAL RECORD IN PROPERTY ONE ********************");
		test.log(LogStatus.INFO,
				"******************** DELETE THE NEWLY CREATED ENVIRONMENTAL RECORD IN PROPERTY ONE ********************");
		Reporter.log(
				"******************** DELETE THE NEWLY CREATED ENVIRONMENTAL RECORD IN PROPERTY ONE ********************");
		log.info(
				"******************** DELETE THE NEWLY CREATED ENVIRONMENTAL RECORD IN PROPERTY ONE ********************");

		try {

			// enter the property name in the search field
			clear("envreports_propertylist_filtertxt_CSS");
			type("envreports_propertylist_filtertxt_CSS", data.get("property_1"));
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
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the burger menu button successfully!!!");

			// wait for the element
			Thread.sleep(5000);

			// click on the environmental records
			click("envrecords_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the Environmental Records option.");

			// click on the Primary Hazardous Substance
			click("envrecords_primaryhazardoussubstance_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the Primary Hazardous Substance option");

			// click on the asbestos materials
			click("envreports_asbestosmaterials_XPATH");
			System.out.println("Clicked on the Asbestos Materials option.");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Navigate to the Asbestos Meteria Records Screen.");

			// collect all the report

			List<WebElement> reportList = driver.findElements(By.xpath(OR.getProperty("envreport_totalreports_XPATH")));
			int reportCount = reportList.size();

			System.out.println("property 1 list :::::::::::::::::" + reportCount);

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

		// DELETE THE NEWLY CREATED ENVIRONMENTAL REPORT IN PROPERTY TWO

		System.out.println(
				"******************** DELETE THE NEWLY CREATED ENVIRONMENTAL RECORD IN PROPERTY TWO ********************");
		test.log(LogStatus.INFO,
				"******************** DELETE THE NEWLY CREATED ENVIRONMENTAL RECORD IN PROPERTY TWO ********************");
		Reporter.log(
				"******************** DELETE THE NEWLY CREATED ENVIRONMENTAL RECORD IN PROPERTY TWO ********************");
		log.info(
				"******************** DELETE THE NEWLY CREATED ENVIRONMENTAL RECORD IN PROPERTY TWO ********************");

		try {

			// enter the property name in the search field
			clear("envreports_propertylist_filtertxt_CSS");
			type("envreports_propertylist_filtertxt_CSS", data.get("property_2"));
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

			// click on the environmental records
			click("envrecords_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the Environmental Records option.");

			// click on the Primary Hazardous Substance
			click("envrecords_primaryhazardoussubstance_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the Primary Hazardous Substance option");

			// click on the asbestos materials
			click("envreports_asbestosmaterials_XPATH");
			System.out.println("Clicked on the Asbestos Materials option.");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Navigate to the Asbestos Meteria Records Screen.");

			// collect all the report

			List<WebElement> reportList = driver.findElements(By.xpath(OR.getProperty("envreport_totalreports_XPATH")));
			int reportCount = reportList.size();

			System.out.println("property 2 list :::::::::::::::::" + reportCount);

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

		// DELETE THE NEWLY CREATED ENVIRONMENTAL REPORT IN PROPERTY THREE

		System.out.println(
				"******************** DELETE THE NEWLY CREATED ENVIRONMENTAL REPORT IN PROPERTY THREE ********************");
		test.log(LogStatus.INFO,
				"******************** DELETE THE NEWLY CREATED ENVIRONMENTAL REPORT IN PROPERTY THREE ********************");
		Reporter.log(
				"******************** DELETE THE NEWLY CREATED ENVIRONMENTAL REPORT IN PROPERTY THREE ********************");
		log.info(
				"******************** DELETE THE NEWLY CREATED ENVIRONMENTAL REPORT IN PROPERTY THREE ********************");

		try {

			// enter the property name in the search field
			clear("envreports_propertylist_filtertxt_CSS");
			type("envreports_propertylist_filtertxt_CSS", data.get("property_3"));
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

			// click on the environmental records
			click("envrecords_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the Environmental Records option.");

			// click on the Primary Hazardous Substance
			click("envrecords_primaryhazardoussubstance_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the Primary Hazardous Substance option");

			// click on the asbestos materials
			click("envreports_asbestosmaterials_XPATH");
			System.out.println("Clicked on the Asbestos Materials option.");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Navigate to the Asbestos Meteria Records Screen.");

			// collect all the report

			List<WebElement> reportList = driver.findElements(By.xpath(OR.getProperty("envreport_totalreports_XPATH")));
			int reportCount = reportList.size();

			System.out.println("property 3 list :::::::::::::::::" + reportCount);

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

		try {
			// wait for the element
			explicitWaitClickable("questionnaire_settingicon_CSS");

			// click on the settings icon from the top of the screen
			click("questionnaire_settingicon_CSS");
			System.out.println("Clicked on the settings icon.");
			ngDriver.waitForAngularRequestsToFinish();

			// wait for the element
			explicitWaitClickable("sidemenu_logout_CSS");

			// click on the logout option from the side menu
			click("sidemenu_logout_CSS");
			System.out.println("Clicked on the logout option from the side menu.");
			ngDriver.waitForAngularRequestsToFinish();

			// wait for the element
			explicitWaitClickable("signinbtn_BTNTEXT");

		} catch (Throwable t) {
			verificationFailed();
		}

	}
}
