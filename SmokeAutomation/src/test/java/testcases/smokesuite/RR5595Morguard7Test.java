package testcases.smokesuite;

import java.io.IOException;
import java.util.Hashtable;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;
import org.testng.SkipException;
import org.testng.annotations.Test;

import com.google.inject.Key;
import com.relevantcodes.extentreports.LogStatus;

import base.Helper;
import base.TestBase;
import utilities.TestUtil;

public class RR5595Morguard7Test extends TestBase {

	@Test(dataProviderClass = TestUtil.class, dataProvider = "dp")
	public void rR5595Morguard7Test(Hashtable<String, String> data) throws IOException, InterruptedException {

		execution(data, "rR5595Morguard7Test");

		Helper helper = new Helper();

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

		// DELETE PREVIOUSLY CREATED ENVIRONMENTAL REPORT
		title("DELETE PREVIOUSLY CREATED ENVIRONMENTAL REPORT");

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

		// DELETE ALL THE NEWLY CREATED ASBESTOS MATERIAL RECORDS
		title("DELETE ALL THE NEWLY CREATED ASBESTOS MATERIAL RECORDS");

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

			// wait for the element
			Thread.sleep(5000);

			// click on the Primary Hazardous Substance
			click("envrecords_primaryhazardoussubstance_XPATH");

			// wait for the element
			Thread.sleep(5000);

			// click on the asbestos materials
			click("envreports_asbestosmaterials_XPATH");

			// collect all the report

			List<WebElement> recordList11 = driver
					.findElements(By.xpath(OR.getProperty("envreport_totalreports_XPATH")));
			int recordCount11 = recordList11.size();

			consoleMessage("reportCount11:::::::::::::::::::" + recordCount11);

			for (int i = 1; i <= recordCount11; i++) {

				List<WebElement> recordList1 = driver
						.findElements(By.xpath(OR.getProperty("envreport_totalreports_XPATH")));
				int maxProducts = recordList1.size();
				Random random = new Random();
				int randomProduct = random.nextInt(maxProducts);
				recordList1.get(randomProduct).click();

				// wait for the element
				explicitWaitClickable("envreports_asbestosmaterials_deletebtn_CSS");

				// click on the delete button
				click("envreports_asbestosmaterials_deletebtn_CSS");

				// wait for the element
				explicitWaitClickable("envreports_asbestosmaterials_modeldeletebtn_CSS");

				// click on the delete button of the confirmation model
				click("envreports_asbestosmaterials_modeldeletebtn_CSS");

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

		// CREATE BUILDING, FLOOR, AND ROOM IN THE PROPERTY
		title("CREATE BUILDING, FLOOR, AND ROOM IN THE PROPERTY");

		try {

			// enter the property name in the search field

			type("envreports_propertylist_filtertxt_CSS", data.get("property_2"));

			// click on the property information
			click("propertyinformationicon_CSS");

			// verify name of the property
			switchVerification("propertyinfo_propertynamelbl_XPATH", "CAPREIT - White Frost",
					"The CAPREIT - White Frost property name is not displayed.");

			// ADD THE NEW BUILDING IN THE PROPERTY
			title("ADD THE NEW BUILDING IN THE PROPERTY");

			// click on the menu button
			click("propertyinfo_menubtn_XPATH");

			// click on the building option
			click("propertyinfo_menubtn_buildingoption_XPATH");

			// click on the new building button
			click("propertyinfo_newbuildingbtn_XPATH");

			// enter the building number

			type("propertyinfo_newbuilding_buildingnumbertxt_XPATH", "001");

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
			switchVerification("propertyinfo_newbuilding_createdbuildinglevel_XPATH", "Test Building Level Name",
					"The Test Building Level Name is not displayed.");

			// click on the menu button
			click("propertyinfo_menubtn_XPATH");

			// click on the property details option
			click("propertyinfo_menubtn_propertydetailsoption_XPATH");

			// ADD THE NEW FLOOR IN THE BUILDING
			title("ADD THE NEW FLOOR IN THE BUILDING");

			// click on the menu button
			click("propertyinfo_menubtn_XPATH");

			// click on the building option
			click("propertyinfo_menubtn_buildingoption_XPATH");

			// click on the newly created building
			click("propertyinfo_newbuilding_createdbuildinglevel_XPATH");

			// scroll down till new floor button
			scrollTillElement("propertyinfo_newfloorbtn_XPATH");

			// click on the new floor button
			click("propertyinfo_newfloorbtn_XPATH");

			// enter the floor name

			type("propertyinfo_newfloor_floornametxt_XPATH", data.get("floor_name"));

			// click on the save button
			click("propertyinfo_newfloor_savebtn_XPATH");

			// wait for the element
			explicitWaitClickable("closetoastmsg_CSS");

			// click on the toaster close button
			click("closetoastmsg_CSS");

			// scroll down till new floor button
			scrollTillElement("propertyinfo_newfloorbtn_XPATH");

			// verify newly created floor is displayed or not
			switchVerification("propertyinfo_newfloor_createdfloorlevel_XPATH", "Test Floor Level Name",
					"The Test Floor Level Name is not displayed.");

			// ADD THE NEW ROOM IN THE FLOOR
			title("ADD THE NEW ROOM IN THE FLOOR");

			// click on the newly created floor
			click("propertyinfo_newfloor_createdfloorlevel_XPATH");

			// scroll down till new room button
			scrollTillElement("propertyinfo_newfloorbtn_XPATH");

			// click on the new room button
			click("propertyinfo_newroombtn_XPATH");

			// enter the room name
			type("propertyinfo_newroom_roomnametxt_XPATH", data.get("room_name"));

			// click on the save button
			click("propertyinfo_newroom_savebtn_XPATH");

			// wait for the element
			explicitWaitClickable("closetoastmsg_CSS");

			// click on the toaster close button
			click("closetoastmsg_CSS");

			// scroll down till new room button
			scrollTillElement("propertyinfo_newfloorbtn_XPATH");

			// verify newly created room is displayed or not
			switchVerification("propertyinfo_newroom_createdroomlevel_XPATH", "Test Room Level Name",
					"The Test Room Level Name is not displayed.");

		} catch (Throwable t) {
			verificationFailed();
		}

		// click on the home icon from the top of the screen
		click("questionnaire_homeburgermenubtn_hide_CSS");

		// synchronization
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// CREAT THE ENVIRONMENTAL REPORT AT PROPERTY LEVEL
		title("CREAT THE ENVIRONMENTAL REPORT AT PROPERTY LEVEL");

		try {

			// enter the property name in the search field
			type("envreports_propertylist_filtertxt_CSS", data.get("property_2"));

			// click on the environmental icon
			click("environmentalicon_CSS");

			// wait for the element
			Thread.sleep(5000);

			// click on the side menu
			click("ssc_leftsidemenubtn_CSS");

			// wait for the element
			Thread.sleep(5000);

			// click on the environmental report
			click("envreportoption_XPATH");

			// select property option from the drop down
			select("propertyinfo_propertydd_XPATH", data.get("property_level"));

			helper.createEnvironmentalReport(data, data.get("type"), data.get("title_property"));

			// enter the newly created environmental report in the search field

			type("task_listofchecklist_filterfield_CSS", data.get("title_property"));

			// verify the newly created environmental report is displayed or not
			switchVerification("environmental_searchedreport_propertylevel_XPATH",
					"Test Environmental Report Property Level",
					"The Test Environmental Report Property Level is not displayed.");

		} catch (Throwable t) {
			verificationFailed();
		}

		// click on the home icon from the top of the screen
		click("questionnaire_homeburgermenubtn_hide_CSS");

		// synchronization
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// CREAT THE ENVIRONMENTAL REPORT AT BUILDING LEVEL
		title("CREAT THE ENVIRONMENTAL REPORT AT BUILDING LEVEL");

		try {

			// enter the property name in the search field
			type("envreports_propertylist_filtertxt_CSS", data.get("property_2"));

			// click on the environmental icon
			click("environmentalicon_CSS");

			// wait for the element
			Thread.sleep(5000);

			// click on the side menu
			click("ssc_leftsidemenubtn_CSS");

			// wait for the element
			Thread.sleep(5000);

			// click on the environmental report
			click("envreportoption_XPATH");

			// select building option from the drop down
			select("propertyinfo_propertydd_XPATH", data.get("buildingName_dd"));

			// wait for 3 seconds
			Thread.sleep(3000);

			helper.createEnvironmentalReport(data, data.get("type"), data.get("title_building"));

			// enter the newly created environmental report in the search field

			type("task_listofchecklist_filterfield_CSS", data.get("title_building"));

			// verify the newly created environmental report is displayed or not
			switchVerification("environmental_searchedreport_buildinglevel_XPATH",
					"Test Environmental Report Building Level",
					"The Test Environmental Report Building Level is not displayed.");

			// select property option from the drop down
			select("propertyinfo_propertydd_XPATH", data.get("property_level"));

			// enter the newly created environmental report in the search field

			type("task_listofchecklist_filterfield_CSS", data.get("title_building"));

			// verify the newly created environmental report is displayed or not
			switchVerification("environmental_searchedreport_buildinglevel_XPATH",
					"Test Environmental Report Building Level",
					"The Test Environmental Report Building Level is not displayed.");

		} catch (Throwable t) {
			verificationFailed();
		}

		// click on the home icon from the top of the screen
		click("questionnaire_homeburgermenubtn_hide_CSS");

		// synchronization
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// CREAT THE ENVIRONMENTAL REPORT AT FLOOR LEVEL
		title("CREAT THE ENVIRONMENTAL REPORT AT FLOOR LEVEL");

		try {

			// enter the property name in the search field
			type("envreports_propertylist_filtertxt_CSS", data.get("property_2"));

			// click on the environmental icon
			click("environmentalicon_CSS");

			// wait for the element
			Thread.sleep(5000);

			// click on the side menu
			click("ssc_leftsidemenubtn_CSS");

			// wait for the element
			Thread.sleep(5000);

			// click on the environmental report
			click("envreportoption_XPATH");

			// select building option from the drop down
			select("propertyinfo_propertydd_XPATH", data.get("buildingName_dd"));

			// select floor option from the drop down
			select("propertyinfo_buildingdd_XPATH", data.get("floor_name"));

			// wait for 3 seconds
			Thread.sleep(3000);

			helper.createEnvironmentalReport(data, data.get("type"), data.get("title_floor"));

			// enter the newly created environmental report in the search field

			type("task_listofchecklist_filterfield_CSS", data.get("title_floor"));

			// verify the newly created environmental report is displayed or not
			switchVerification("environmental_searchedreport_floorlevel_XPATH", "Test Environmental Report Floor Level",
					"The Test Environmental Report Floor Level is not displayed.");

			// select property option from the drop down
			select("propertyinfo_propertydd_XPATH", data.get("property_level"));

			// enter the newly created environmental report in the search field

			type("task_listofchecklist_filterfield_CSS", data.get("title_floor"));

			// verify the newly created environmental report is displayed or not
			switchVerification("environmental_searchedreport_floorlevel_XPATH", "Test Environmental Report Floor Level",
					"The Test Environmental Report Floor Level is not displayed.");

		} catch (Throwable t) {
			verificationFailed();
		}

		// click on the home icon from the top of the screen
		click("questionnaire_homeburgermenubtn_hide_CSS");

		// synchronization
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// CREAT THE ENVIRONMENTAL REPORT AT ROOM LEVEL
		title("CREAT THE ENVIRONMENTAL REPORT AT ROOM LEVEL");

		try {

			// enter the property name in the search field
			type("envreports_propertylist_filtertxt_CSS", data.get("property_2"));

			// click on the environmental icon
			click("environmentalicon_CSS");

			// wait for the element
			Thread.sleep(5000);

			// click on the side menu
			click("ssc_leftsidemenubtn_CSS");

			// wait for the element
			Thread.sleep(5000);

			// click on the environmental report
			click("envreportoption_XPATH");

			// select building option from the drop down
			select("propertyinfo_propertydd_XPATH", data.get("buildingName_dd"));

			// select floor option from the drop down
			select("propertyinfo_buildingdd_XPATH", data.get("floor_name"));

			// select room option from the drop down
			select("propertyinfo_roomdd_XPATH", data.get("room_name"));

			// wait for 3 seconds
			Thread.sleep(3000);

			helper.createEnvironmentalReport(data, data.get("type"), data.get("title_room"));

			// enter the newly created environmental report in the search field

			type("task_listofchecklist_filterfield_CSS", data.get("title_room"));

			// verify the newly created environmental report is displayed or not
			switchVerification("environmental_searchedreport_roomlevel_XPATH", "Test Environmental Report Room Level",
					"The Test Environmental Report Room Level is not displayed.");

			// select property option from the drop down
			select("propertyinfo_propertydd_XPATH", data.get("property_level"));

			// enter the newly created environmental report in the search field

			type("task_listofchecklist_filterfield_CSS", data.get("title_room"));

			// verify the newly created environmental report is displayed or not
			switchVerification("environmental_searchedreport_roomlevel_XPATH", "Test Environmental Report Room Level",
					"The Test Environmental Report Room Level is not displayed.");

		} catch (Throwable t) {
			verificationFailed();
		}

		// click on the home icon from the top of the screen
		click("questionnaire_homeburgermenubtn_hide_CSS");

		// synchronization
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// CREATE THE NEW ASBESTOS MATERIAL RECORD AT PROPERTY LEVEL AND LINK WITH
		// ENVIRONMENTAL REPORT
		title("CREATE THE NEW ASBESTOS MATERIAL RECORD AT PROPERTY LEVEL AND LINK WITH ENVIRONMENTAL REPORT");

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

			// wait for the element
			Thread.sleep(3000);

			// click on the Primary Hazardous Substance
			click("envrecords_primaryhazardoussubstance_XPATH");

			// wait for the element
			Thread.sleep(3000);

			// click on the asbestos materials
			click("envreports_asbestosmaterials_XPATH");

			// select property option from the drop down
			select("propertyinfo_propertydd_XPATH", data.get("property_level"));

			helper.createAsbestosMaterialRecord(data, data.get("material"), data.get("detailed_location_property"),
					data.get("is_material_asbestos_containing"), data.get("asbestos_type"), data.get("condition"),
					data.get("status"));

			// enter the newly created environmental record in the search field

			type("task_listofchecklist_filterfield_CSS", data.get("detailed_location_property"));

			// verify added detailed location of the Asbestos Materials record
			switchVerification("envreports_asbestosmaterials_detailedlocationpropertylevel_XPATH",
					"Detailed Location Property Level",
					"The Detailed Location Property Level is not displayed successfully.");

			// click on the newly created asbestos material record
			click("envreports_asbestosmaterials_detailedlocationpropertylevel_XPATH");

			// click on the linked reports tab
			click("envreports_asbestosmaterials_linkedrecordtab_XPATH");

			// click on the new link button
			click("envreports_asbestosmaterials_newlinkbtn_XPATH");

			// get the count of the reports

			try {
				List<WebElement> reportListPL = driver.findElements(
						By.xpath(OR.getProperty("envreports_asbestosmaterials_linkedreport_linklist_XPATH")));
				int reportCountPL = reportListPL.size();

				if (reportCountPL == 1) {
					successMessage("THE COUNT OF THE ENVIRONMENTAL REPORT IS DISPLAYED CORRECT.");
				} else {
					verificationFailedMessage("THE COUNT OF THE ENVIRONMENTAL REPORT IS DISPLAYED INCORRECT.");

				}
			} catch (Throwable t) {
				verificationFailedMessage("THE ENVIRONMENTAL REPORT IS NOT DISPLAYED.");
			}

			// click on the link button
			click("envreports_asbestosmaterials_propertylevel_linkbtn_XPATH");

			// click on the update button
			click("envreportupdatebtn_CSS");

			// enter the newly created environmental record in the search field

			type("task_listofchecklist_filterfield_CSS", data.get("detailed_location_property"));

			// verify added detailed location of the Asbestos Materials record
			switchVerification("envreports_asbestosmaterials_detailedlocationpropertylevel_XPATH",
					"Detailed Location Property Level",
					"The Detailed Location Property Level is not displayed successfully.");

		} catch (Throwable t) {

			verificationFailed();
		}

		// click on the home icon from the top of the screen
		click("questionnaire_homeburgermenubtn_hide_CSS");

		// synchronization
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// CREATE THE NEW ASBESTOS MATERIAL RECORD AT BUILDING LEVEL AND LINK WITH
		// ENVIRONMENTAL REPORT
		title("CREATE THE NEW ASBESTOS MATERIAL RECORD AT BUILDING LEVEL AND LINK WITH ENVIRONMENTAL REPORT");

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

			// wait for the element
			Thread.sleep(5000);

			// click on the Primary Hazardous Substance
			click("envrecords_primaryhazardoussubstance_XPATH");

			// wait for the element
			Thread.sleep(5000);

			// click on the asbestos materials
			click("envreports_asbestosmaterials_XPATH");

			// select building option from the drop down
			select("propertyinfo_propertydd_XPATH", data.get("buildingName_dd"));

			helper.createAsbestosMaterialRecord(data, data.get("material"), data.get("detailed_location_building"),
					data.get("is_material_asbestos_containing"), data.get("asbestos_type"), data.get("condition"),
					data.get("status"));

			// enter the newly created environmental record in the search field

			type("task_listofchecklist_filterfield_CSS", data.get("detailed_location_building"));

			// verify added detailed location of the Asbestos Materials record
			switchVerification("envreports_asbestosmaterials_detailedlocationbuildinglevel_XPATH",
					"Detailed Location Building Level",
					"The Detailed Location Building Level is not displayed successfully.");

			// click on the newly created asbestos material record
			click("envreports_asbestosmaterials_detailedlocationbuildinglevel_XPATH");

			// click on the linked reports tab
			click("envreports_asbestosmaterials_linkedrecordtab_XPATH");

			// click on the new link button
			click("envreports_asbestosmaterials_newlinkbtn_XPATH");

			// get the count of the reports

			try {
				List<WebElement> reportListPL = driver.findElements(
						By.xpath(OR.getProperty("envreports_asbestosmaterials_linkedreport_linklist_XPATH")));
				int reportCountPL = reportListPL.size();

				if (reportCountPL == 2) {
					successMessage("THE COUNT OF THE ENVIRONMENTAL REPORT IS DISPLAYED CORRECT.");
				} else {
					verificationFailedMessage("THE COUNT OF THE ENVIRONMENTAL REPORT IS DISPLAYED INCORRECT.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("THE ENVIRONMENTAL REPORT IS NOT DISPLAYED.");
			}

			// click on the link button
			click("envreports_asbestosmaterials_buildinglevel_linkbtn_XPATH");

			// click on the update button
			click("envreportupdatebtn_CSS");

			// enter the newly created environmental record in the search field

			type("task_listofchecklist_filterfield_CSS", data.get("detailed_location_building"));

			// verify added detailed location of the Asbestos Materials record
			switchVerification("envreports_asbestosmaterials_detailedlocationbuildinglevel_XPATH",
					"Detailed Location Building Level",
					"The Detailed Location Building Level is not displayed successfully.");

			// select property option from the drop down
			select("propertyinfo_propertydd_XPATH", data.get("property_level"));

			// enter the newly created environmental record in the search field

			type("task_listofchecklist_filterfield_CSS", data.get("detailed_location_building"));

			// verify added detailed location of the Asbestos Materials record
			switchVerification("envreports_asbestosmaterials_detailedlocationbuildinglevel_XPATH",
					"Detailed Location Building Level",
					"The Detailed Location Building Level is not displayed successfully.");

		} catch (Throwable t) {

			verificationFailed();
		}

		// click on the home icon from the top of the screen
		click("questionnaire_homeburgermenubtn_hide_CSS");

		// synchronization
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// CREATE THE NEW ASBESTOS MATERIAL RECORD AT FLOOR LEVEL AND LINK WITH
		// ENVIRONMENTAL REPORT
		title("CREATE THE NEW ASBESTOS MATERIAL RECORD AT FLOOR LEVEL AND LINK WITH ENVIRONMENTAL REPORT");

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

			// select building option from the drop down
			select("propertyinfo_propertydd_XPATH", data.get("buildingName_dd"));

			// select floor option from the drop down
			select("propertyinfo_buildingdd_XPATH", data.get("floor_name"));

			helper.createAsbestosMaterialRecord(data, data.get("material"), data.get("detailed_location_floor"),
					data.get("is_material_asbestos_containing"), data.get("asbestos_type"), data.get("condition"),
					data.get("status"));

			// enter the newly created environmental record in the search field

			type("task_listofchecklist_filterfield_CSS", data.get("detailed_location_floor"));

			// verify added detailed location of the Asbestos Materials record
			switchVerification("envreports_asbestosmaterials_detailedlocationfloorlevel_XPATH",
					"Detailed Location Floor Level",
					"The Detailed Location Floor Level is not displayed successfully.");

			// click on the newly created asbestos material record
			click("envreports_asbestosmaterials_detailedlocationfloorlevel_XPATH");

			// click on the linked reports tab
			click("envreports_asbestosmaterials_linkedrecordtab_XPATH");

			// click on the new link button
			click("envreports_asbestosmaterials_newlinkbtn_XPATH");

			// get the count of the reports

			try {
				List<WebElement> reportListPL = driver.findElements(
						By.xpath(OR.getProperty("envreports_asbestosmaterials_linkedreport_linklist_XPATH")));
				int reportCountPL = reportListPL.size();

				if (reportCountPL == 4) {
					successMessage("THE COUNT OF THE ENVIRONMENTAL REPORT IS DISPLAYED CORRECT.");
				} else {
					verificationFailedMessage("THE COUNT OF THE ENVIRONMENTAL REPORT IS DISPLAYED INCORRECT.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("THE ENVIRONMENTAL REPORT IS NOT DISPLAYED.");
			}

			// click on the link button
			click("envreports_asbestosmaterials_floorlevel_linkbtn_XPATH");

			// click on the update button
			click("envreportupdatebtn_CSS");

			// enter the newly created environmental record in the search field

			type("task_listofchecklist_filterfield_CSS", data.get("detailed_location_floor"));

			// verify added detailed location of the Asbestos Materials record
			switchVerification("envreports_asbestosmaterials_detailedlocationfloorlevel_XPATH",
					"Detailed Location Floor Level",
					"The Detailed Location Floor Level is not displayed successfully.");

			// select property option from the drop down
			select("propertyinfo_propertydd_XPATH", data.get("property_level"));

			// enter the newly created environmental record in the search field

			type("task_listofchecklist_filterfield_CSS", data.get("detailed_location_floor"));

			// verify added detailed location of the Asbestos Materials record
			switchVerification("envreports_asbestosmaterials_detailedlocationfloorlevel_XPATH",
					"Detailed Location Floor Level",
					"The Detailed Location Floor Level is not displayed successfully.");

		} catch (Throwable t) {

			verificationFailed();
		}

		// click on the home icon from the top of the screen
		click("questionnaire_homeburgermenubtn_hide_CSS");

		// synchronization
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// CREATE THE NEW ASBESTOS MATERIAL RECORD AT ROOM LEVEL AND LINK WITH
		// ENVIRONMENTAL REPORT
		title("CREATE THE NEW ASBESTOS MATERIAL RECORD AT ROOM LEVEL AND LINK WITH ENVIRONMENTAL REPORT");

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

			// select building option from the drop down
			select("propertyinfo_propertydd_XPATH", data.get("buildingName_dd"));

			// select floor option from the drop down
			select("propertyinfo_buildingdd_XPATH", data.get("floor_name"));

			// select room option from the drop down
			select("propertyinfo_roomdd_XPATH", data.get("room_name"));

			helper.createAsbestosMaterialRecord(data, data.get("material"), data.get("detailed_location_room"),
					data.get("is_material_asbestos_containing"), data.get("asbestos_type"), data.get("condition"),
					data.get("status"));

			// enter the newly created environmental record in the search field

			type("task_listofchecklist_filterfield_CSS", data.get("detailed_location_room"));

			// verify added detailed location of the Asbestos Materials record
			switchVerification("envreports_asbestosmaterials_detailedlocationroomlevel_XPATH",
					"Detailed Location Room Level", "The Detailed Location Room Level is not displayed successfully.");

			// click on the newly created asbestos material record
			click("envreports_asbestosmaterials_detailedlocationroomlevel_XPATH");

			// click on the linked reports tab
			click("envreports_asbestosmaterials_linkedrecordtab_XPATH");

			// click on the new link button
			click("envreports_asbestosmaterials_newlinkbtn_XPATH");

			// get the count of the reports

			try {
				List<WebElement> reportListPL = driver.findElements(
						By.xpath(OR.getProperty("envreports_asbestosmaterials_linkedreport_linklist_XPATH")));
				int reportCountPL = reportListPL.size();

				if (reportCountPL == 4) {
					successMessage("THE COUNT OF THE ENVIRONMENTAL REPORT IS DISPLAYED CORRECT.");
				} else {
					verificationFailedMessage("THE COUNT OF THE ENVIRONMENTAL REPORT IS DISPLAYED INCORRECT.");

				}
			} catch (Throwable t) {
				verificationFailedMessage("THE ENVIRONMENTAL REPORT IS NOT DISPLAYED.");
			}

			// click on the link button
			click("envreports_asbestosmaterials_roomlevel_linkbtn_XPATH");

			// click on the update button
			click("envreportupdatebtn_CSS");

			// enter the newly created environmental record in the search field

			type("task_listofchecklist_filterfield_CSS", data.get("detailed_location_room"));

			// verify added detailed location of the Asbestos Materials record
			switchVerification("envreports_asbestosmaterials_detailedlocationroomlevel_XPATH",
					"Detailed Location Room Level", "The Detailed Location Room Level is not displayed successfully.");

			// select property option from the drop down
			select("propertyinfo_propertydd_XPATH", data.get("property_level"));

			// enter the newly created environmental record in the search field

			type("task_listofchecklist_filterfield_CSS", data.get("detailed_location_room"));

			// verify added detailed location of the Asbestos Materials record
			switchVerification("envreports_asbestosmaterials_detailedlocationroomlevel_XPATH",
					"Detailed Location Room Level", "The Detailed Location Room Level is not displayed successfully.");

		} catch (Throwable t) {

			verificationFailed();
		}

		// click on the home icon from the top of the screen
		click("questionnaire_homeburgermenubtn_hide_CSS");

		// synchronization
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// DELETE ALL THE NEWLY CREATED ENVIRONMENTAL REPORTS
		title("DELETE ALL THE NEWLY CREATED ENVIRONMENTAL REPORTS");

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

			List<WebElement> reportList33 = driver
					.findElements(By.xpath(OR.getProperty("envreport_totalreports_XPATH")));
			int reportCount33 = reportList33.size();

			if (reportCount33 == 4) {
				successMessage("THE COUNT OF THE ENVIRONMENTAL REPORTS ARE CORRECT.");
			} else {

				verificationFailedMessage("THE COUNT OF THE ENVIRONMENTAL REPORTS ARE INCORRECT.");
			}

			consoleMessage("reportCount33:::::::::::::::::::" + reportCount33);

			for (int i = 1; i <= reportCount33; i++) {

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

		// DELETE ALL THE NEWLY CREATED ASBESTOS MATERIAL RECORDS
		title("DELETE ALL THE NEWLY CREATED ASBESTOS MATERIAL RECORDS");

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

			List<WebElement> recordList11 = driver
					.findElements(By.xpath(OR.getProperty("envreport_totalreports_XPATH")));
			int recordCount11 = recordList11.size();

			if (recordCount11 == 4) {
				successMessage("THE COUNT OF THE ENVIRONMENTAL RECORDS ARE CORRECT.");
			} else {

				verificationFailedMessage("THE COUNT OF THE ENVIRONMENTAL RECORDS ARE INCORRECT.");
			}

			consoleMessage("reportCount11:::::::::::::::::::" + recordCount11);

			for (int i = 1; i <= recordCount11; i++) {

				List<WebElement> recordList1 = driver
						.findElements(By.xpath(OR.getProperty("envreport_totalreports_XPATH")));
				int maxProducts = recordList1.size();
				Random random = new Random();
				int randomProduct = random.nextInt(maxProducts);
				recordList1.get(randomProduct).click();

				// wait for the element
				explicitWaitClickable("envreports_asbestosmaterials_deletebtn_CSS");

				// click on the delete button
				click("envreports_asbestosmaterials_deletebtn_CSS");

				// wait for the element
				explicitWaitClickable("envreports_asbestosmaterials_modeldeletebtn_CSS");

				// click on the delete button of the confirmation model
				click("envreports_asbestosmaterials_modeldeletebtn_CSS");

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

		// DELETE BUILDING, FLOOR, AND ROOM IN THE PROPERTY
		title("DELETE BUILDING, FLOOR, AND ROOM IN THE PROPERTY");

		try {

			// enter the property name in the search field

			type("envreports_propertylist_filtertxt_CSS", data.get("property_2"));

			// click on the property information
			click("propertyinformationicon_CSS");

			// DELETE THE NEW BUILDING IN THE PROPERTY
			title("DELETE THE NEW BUILDING IN THE PROPERTY");

			// click on the menu button
			click("propertyinfo_menubtn_XPATH");

			// click on the building option
			click("propertyinfo_menubtn_buildingoption_XPATH");

			// scroll down the screen
			scrollTillElement("propertyinfo_menubtn_XPATH");

			// click on the newly created building
			click("propertyinfo_newbuilding_createdbuildinglevel_XPATH");

			// scroll down the screen
			scrollTillElement("propertyinfo_menubtn_XPATH");

			// click on the delete building button
			click("propertyinfo_newbuilding_deletebtn_XPATH");

			// wait for the element
			Thread.sleep(3000);

			// click on the delete building button of confirmation popup
			click("propertyinfo_newbuilding_confirmationdeletebtn_XPATH");

			// verify deleted building is displayed or not
			deleteVerification("propertyinfo_newbuilding_createdbuildinglevel_XPATH", "Test Building Level Name");

		} catch (Throwable t) {
			verificationFailed();

			driver.navigate().refresh();
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