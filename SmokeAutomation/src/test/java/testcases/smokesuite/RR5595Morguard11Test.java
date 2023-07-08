package testcases.smokesuite;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Hashtable;
import java.util.List;
import java.util.Random;

import org.apache.commons.text.CharacterPredicates;
import org.apache.commons.text.RandomStringGenerator;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;
import org.testng.SkipException;
import org.testng.annotations.Test;

import com.google.inject.Key;
import com.mysql.cj.jdbc.NonRegisteringDriver;
import com.paulhammant.ngwebdriver.ByAngularBinding.NgFindByBuilder;
import com.relevantcodes.extentreports.LogStatus;

import base.Helper;
import base.TestBase;
import utilities.TestUtil;

public class RR5595Morguard11Test extends TestBase {

	@Test(dataProviderClass = TestUtil.class, dataProvider = "dp")
	public void rR5595Morguard11Test(Hashtable<String, String> data) throws IOException, InterruptedException {

		execution(data, "rR5595Morguard11Test");

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

			// click on the burger menu
			click("menubtn_CSS");

			// wait for the element
			explicitWaitClickable("envreportoption_XPATH");

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
			switchVerification("propertyinfo_newbuilding_createdbuildinglevel_morguard11_XPATH",
					"Test Building Morguard 11", "The Test Building Morguard 11 is not displayed.");

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
			click("propertyinfo_newbuilding_createdbuildinglevel_morguard11_XPATH");

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
			switchVerification("propertyinfo_newfloor_createdfloorlevel_morguard11_XPATH", "Test Floor Morguard 11",
					"The Test Floor Morguard 11 is not displayed.");

			// ADD THE NEW ROOM IN THE FLOOR
			title("ADD THE NEW ROOM IN THE FLOOR");

			// click on the newly created floor
			click("propertyinfo_newfloor_createdfloorlevel_morguard11_XPATH");

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
			switchVerification("propertyinfo_newroom_createdroomlevel_morguard11_XPATH", "Test Room Morguard 11",
					"The Test Room Morguard 11 is not displayed.");

		} catch (Throwable t) {
			verificationFailed();
		}

		try {
			// click on the home icon from the top of the screen
			click("questionnaire_homeburgermenubtn_hide_CSS");

			// synchronization
			explicitWait("propertylist_title_XPATH");

			// verify the property list
			switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

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

			// LOGIN WITH ENVIRO CONSULTANT USER
			title("LOGIN WITH ENVIRO CONSULTANT USER");

			// Enter the username

			type("username_MODEL", data.get("username"));

			// Enter the password
			type("password_MODEL", data.get("password"));

			// Clicking on the "Sign In" button
			click("signinbtn_BTNTEXT");

			// wait for the element
			explicitWait("propertylist_title_XPATH");

			// verify the property list
			switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

			// UPDATE THE SYSTEM COMPANY
			updateCompany(data);

//			// VERIFY PROPERTY, SEARCH PROPERTY, ADMINISTRATION, TASKS, PROFILE, HELP,
//			// LOGOUT ARE VISIBLE.
//			title("VERIFY PROPERTY, SEARCH PROPERTY, ADMINISTRATION, TASKS, PROFILE, HELP, LOGOUT ARE VISIBLE");
//
//			// VERIFY THE PROPERTY IS VISIBLE OR NOT
//			title("VERIFY THE PROPERTY IS VISIBLE OR NOT");
//			 
//			try {
//
//				// enter the property name in the search field
//				 
//				type("envreports_propertylist_filtertxt_CSS", data.get("property_2"));
//				 
//				// verify the respective searched property is displayed or not
//				switchVerification("administration_security_groupproperty_addedproperty_XPATH", "CAPREIT - White Frost",
//						"The CAPREIT - White Frost property is not displayed.");
//				successMessage("THE PROPERTY IS VISIBLE SUCCESSFULLY");
//
//			} catch (Throwable t) {
//				verificationFailedMessage("THE PROPERTY IS NOT VISIBLE");
//			}
//
//			// VERIFY THE SEARCH PROPERTY ICON IS VISIBLE OR NOT
//			title("VERIFY THE SEARCH PROPERTY ICON IS VISIBLE OR NOT");
//
//			try {
//
//				boolean searchIcon = driver.findElement(By.xpath(OR.getProperty("property_searchicon_XPATH")))
//						.isDisplayed();
//
//				if (searchIcon == true) {
//					successMessage("THE SEARCH PROPERTY ICON IS VISIBLE SUCCESSFULLY");
//
//				} else {
//
//					verificationFailedMessage("THE SEARCH PROPERTY ICON IS NOT VISIBLE");
//				}
//
//			} catch (Throwable t) {
//				verificationFailedMessage("THE SEARCH PROPERTY ICON IS NOT VISIBLE");
//			}
//
//			// VERIFY THE ADMINISTRATION, TASKS, PROFILE, HELP, LOGOUT OPTIONS ARE VISIBLE
//			// IN SIDE MENU OR NOT
//			title("VERIFY THE ADMINISTRATION, TASKS, PROFILE, HELP, LOGOUT OPTIONS ARE VISIBLE IN SIDE MENU OR NOT");
//			try {
//
//				// wait for the element
//				explicitWaitClickable("questionnaire_settingicon_CSS");
//
//				// click on the settings icon from the top of the screen
//				click("questionnaire_settingicon_CSS");
//
//				// verify administration option is displayed or not
//				switchVerification("questionnaire_administrationoption_XPATH", "Administration",
//						"The Administration option is not displayed.");
//
//				// verify task option is displayed or not
//				switchVerification("questionnaire_tasksoption_XPATH", "Tasks", "The Tasks option is not displayed.");
//
//				// verify profile option is displayed or not
//				switchVerification("questionnaire_profileoption_XPATH", "Profile",
//						"The Profile option is not displayed.");
//
//				// verify help option is displayed or not
//				switchVerification("questionnaire_helpoption_XPATH", "Help", "The Help option is not displayed.");
//
//				// verify logout option is displayed or not
//				switchVerification("sidemenu_logout_CSS", "Logout", "The Logout option is not displayed.");
//
//				// click on the close side menu icon
//				click("sidemenu_closeicon_XPATH");
//
//				// refresh the screen
//				driver.navigate().refresh();
//
//			} catch (Throwable t) {
//				verificationFailed();
//
//				// refresh the screen
//				driver.navigate().refresh();
//
//			}
//
//			// VERIFY ENVIRONMENTAL SUMMARY IS VISIBLE
//			title("VERIFY ENVIRONMENTAL SUMMARY IS VISIBLE");
//
//			try {
//
//				// synchronization
//				explicitWait("propertylist_title_XPATH");
//
//				// verify the property list
//				switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");
//
//				// click on the side menu
//				click("ssc_leftsidemenubtn_CSS");
//
//				// wait for the element
//				explicitWaitClickable("sidemenu_environmental_CSS");
//
//				// click on the environmental option
//				click("sidemenu_environmental_CSS");
//
//				// select the environmental summary option from the dashboard drop down
//				select("dashboard_CSS", data.get("dashboard_dd"));
//
//				// verify environmental summary screen is displayed or not
//				switchVerification("environmentalsummary_title_XPATH", "Environmental Summary",
//						"The Environmental Summary screen is not displayed.");
//
//			} catch (Throwable t) {
//				verificationFailed();
//			}
//
//			// click on the home icon from the top of the screen
//			click("questionnaire_homeburgermenubtn_hide_CSS");
//
//			// synchronization
//			explicitWait("propertylist_title_XPATH");
//
//			// verify the property list
//			switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");
//
//			// COLOURED ICONS � ENVIRONMENTAL, PROPERTY REPORTS, COMPLIANCE, REPORTS ARE
//			// VISIBLE
//			title("COLOURED ICONS � ENVIRONMENTAL, PROPERTY REPORTS, COMPLIANCE, REPORTS ARE VISIBLE");
//
//			try {
//
//				// click on the side menu
//				click("ssc_leftsidemenubtn_CSS");
//				 
//				 
//
//				// wait for the element
//				Thread.sleep(5000);
//
//				// verify environmental option is displayed or not
//				switchVerification("sidemenu_environmental_CSS", "Environmental",
//						"The Environmental option is not displayed.");
//
//				// verify environmental option is displayed or not
//				switchVerification("sidemenu_propertyreport_CSS", "Property Reports",
//						"The Property Reports option is not displayed.");
//
//				// verify environmental option is displayed or not
//				switchVerification("sidemenu_compliance_CSS", "Compliance", "The Compliance option is not displayed.");
//
//				// verify environmental option is displayed or not
//				switchVerification("sidemenu_reports_CSS", "Reports", "The Reports option is not displayed.");
//
//				// refresh the screen
//				driver.navigate().refresh();
//
//			} catch (Throwable t) {
//				verificationFailed();
//			}
//
//			// click on the home icon from the top of the screen
//			click("questionnaire_homeburgermenubtn_hide_CSS");
//
//			// synchronization
//			explicitWait("propertylist_title_XPATH");
//
//			// verify the property list
//			switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");
//
//			// VERIFY ADVANCE SEARCH FEATURE FOR THE PROPERTY
//			title("VERIFY ADVANCE SEARCH FEATURE FOR THE PROPERTY");
//
//			try {
//
//				// double click on the search icon from the top
//				Actions action = new Actions(driver);
//				WebElement searchIcon = driver.findElement(By.xpath(OR.getProperty("property_searchicon_XPATH")));
//				action.doubleClick(searchIcon);
//
//				// verify advance search screen is displayed
//				switchVerification("property_searchscreen_validation1_XPATH", "Advanced Property Search",
//						"The Advanced Property Search title is not displayed.");
//
//				// enter the property number in the search field
//				type("property_searchscreen_searchtxt_XPATH", data.get("property_number_2"));
//
//				try {
//					// select the active checkbox
//					boolean activeckbx = driver
//							.findElement(By.xpath(OR.getProperty("property_searchscreen_validation8_XPATH")))
//							.isSelected();
//
//					if (!(activeckbx == true)) {
//
//						// click on the active checkbox
//						click("property_searchscreen_validation8_XPATH");
//						successMessage("THE ACTIVE CHECKBOX IS SELECTED SUCCESSFULLY.");
//					} else {
//						successMessage("THE ACTIVE CHECKBOX IS SELECTED SUCCESSFULLY.");
//					}
//
//				} catch (Throwable t) {
//					successMessage("THE ACTIVE CHECKBOX IS SELECTED SUCCESSFULLY.");
//				}
//
//				// scroll down the screen till find property button
//				WebElement findPropertyBTN = driver
//						.findElement(By.xpath(OR.getProperty("property_searchscreen_validation7_XPATH")));
//				 
//				js.executeScript("arguments[0].scrollIntoView(true);", findPropertyBTN);
//
//				// click on the find property button
//				click("property_searchscreen_validation7_XPATH");
//
//				// scroll up the screen
//				WebElement title = driver
//						.findElement(By.xpath(OR.getProperty("property_searchscreen_validation1_XPATH")));
//				js.executeScript("arguments[0].scrollIntoView(true);", title);
//
//				// verify searched result is displayed or not
//				switchVerification("property_searchscreen_searchedresult_XPATH", "Capreit - *Off-Site Incident Report",
//						"The Capreit - *Off-Site Incident Report is not displayed.");
//
//			} catch (Throwable t) {
//				verificationFailed();
//			}
//
//			// click on the home icon from the top of the screen
//			click("questionnaire_homeburgermenubtn_hide_CSS");
//
//			// synchronization
//			explicitWait("propertylist_title_XPATH");
//
//			// verify the property list
//			switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

			// CREATE THE ENVIRONMENTAL REPORT AT PROPERTY LEVEL
			title("CREATE THE ENVIRONMENTAL REPORT AT PROPERTY LEVEL");

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

				helper.createEnvironmentalReport(data, data.get("type"), data.get("title_property"));

				// enter the newly created environmental report in the search field

				type("task_listofchecklist_filterfield_CSS", data.get("title_property"));

				// verify the newly created environmental report is displayed or not
				switchVerification("environmental_searchedreport_morguard11_XPATH",
						"Test Environmental Report Morguard 11",
						"The Test Environmental Report Morguard 11 is not displayed.");

			} catch (Throwable t) {
				verificationFailed();
			}

			// click on the home icon from the top of the screen
			click("questionnaire_homeburgermenubtn_hide_CSS");

			// synchronization
			explicitWait("propertylist_title_XPATH");

			// verify the property list
			switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

			// UPDATE THE ENVIRONMENTAL REPORT AT PROPERTY LEVEL
			title("UPDATE THE ENVIRONMENTAL REPORT AT PROPERTY LEVEL");

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

				// click on the newly created environmental report
				click("environmental_searchedreport_morguard11_XPATH");

				// enter the title

				type("envreporttitletxt_CSS", data.get("update_title_property"));

				// scroll down the screen

				scrollByPixel(400);

				// click on the update report button
				click("envreportupdatebtn_CSS");

				// wait for the element
				explicitWaitClickable("closetoastmsg_CSS");

				// click on the toaster close button
				click("closetoastmsg_CSS");

				// enter the newly created environmental report in the search field

				type("task_listofchecklist_filterfield_CSS", data.get("update_title_property"));

				// verify the newly created environmental report is displayed or not
				switchVerification("environmental_searchedupdatedreport_morguard11_XPATH",
						"Update Test Environmental Report Morguard 11",
						"The Update Test Environmental Report Morguard 11 is not displayed.");

			} catch (Throwable t) {
				verificationFailed();
			}

			// click on the home icon from the top of the screen
			click("questionnaire_homeburgermenubtn_hide_CSS");

			// synchronization
			explicitWait("propertylist_title_XPATH");

			// verify the property list
			switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

			// ADD MOULD RECORD AT ROOM LEVEL
			title("ADD MOULD RECORD AT ROOM LEVEL");

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

				// click on the mould
				click("envreports_mould_XPATH");

				// select the building from the drop down
				select("propertyinfo_propertydd_XPATH", data.get("buildingName_dd"));

				// select the floor from the drop down
				select("propertyinfo_buildingdd_XPATH", data.get("floor_name"));

				// select the room from the drop down
				select("propertyinfo_roomdd_XPATH", data.get("room_name"));

				// click on the add button
				click("envreports_asbestosmaterials_addbtn_CSS");

				// select the status
				select("envreports_asbestosmaterials_statusdd_CSS", data.get("status"));

				// select the causes by
				select("propertyinfo_causesbydd_XPATH", data.get("caused_by"));

				// select the responsible party
				select("propertyinfo_responsiblepartydd_XPATH", data.get("responsible_party"));

				// scroll till bottom of the page
				scrollTillElement("envreports_asbestosmaterials_savebtn_CSS");

				// click on the save button
				click("envreports_asbestosmaterials_savebtn_CSS");

				// wait for the element
				explicitWaitClickable("closetoastmsg_CSS");

				// click on the toaster close button
				click("closetoastmsg_CSS");

				// VIEW NEWLY CREATED RECORD IS DISPLAYED WITH CORRECT DETAILS OR NOT - Asbestos
				// Material

				// enter the newly created environmental record in the search field

				type("task_listofchecklist_filterfield_CSS", data.get("location"));

				// verify added detailed location of the Mould record in room level
				// level is correct or not
				switchVerification("propertyinfo_locationlbl_morguard11_XPATH",
						"Test Building Morguard 11 > Test Floor Morguard 11 > Test Room Morguard 11",
						"The location is not displayed successfully.");

				// select the property option from the drop down
				select("propertyinfo_propertydd_XPATH", data.get("property"));

				// verify added detailed location of the Mould record in property
				// level is correct or not
				switchVerification("propertyinfo_locationlbl_morguard11_XPATH",
						"Test Building Morguard 11 > Test Floor Morguard 11 > Test Room Morguard 11",
						"The location is not displayed successfully.");

			} catch (Throwable t) {
				verificationFailed();
			}

			// click on the home icon from the top of the screen
			click("questionnaire_homeburgermenubtn_hide_CSS");

			// synchronization
			explicitWait("propertylist_title_XPATH");

			// verify the property list
			switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

			// UPDATE MOULD RECORD AT ROOM LEVEL AND LINK WITH THE ENVIRONMENTAL REPORT
			title("UPDATE MOULD RECORD AT ROOM LEVEL AND LINK WITH THE ENVIRONMENTAL REPORT");

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

				// click on the mould
				click("envreports_mould_XPATH");

				// wait for the element
				Thread.sleep(5000);

				// select the building from the drop down
				select("propertyinfo_propertydd_XPATH", data.get("buildingName_dd"));

				// select the floor from the drop down
				select("propertyinfo_buildingdd_XPATH", data.get("floor_name"));

				// select the room from the drop down
				select("propertyinfo_roomdd_XPATH", data.get("room_name"));

				// click on the newly added environmental record
				click("propertyinfo_locationlbl_morguard11_XPATH");

				// select the status
				select("envreports_asbestosmaterials_statusdd_CSS", data.get("update_status"));

				// select the causes by
				select("propertyinfo_causesbydd_XPATH", data.get("update_caused_by"));

				// select the responsible party
				select("propertyinfo_responsiblepartydd_XPATH", data.get("responsible_party"));

				// scroll till bottom of the page
				scrollTillElement("envreports_asbestosmaterials_updatebtn_CSS");

				// click on the update button
				click("envreports_asbestosmaterials_updatebtn_CSS");

				// wait for the element
				explicitWaitClickable("closetoastmsg_CSS");

				// click on the toaster close button
				click("closetoastmsg_CSS");

				// VIEW UPDATED RECORD IS DISPLAYED WITH CORRECT DETAILS OR NOT - Asbestos
				// Material

				// enter the updated environmental record in the search field

				type("task_listofchecklist_filterfield_CSS", data.get("update_status"));

				// verify added detailed of the Mould record in room level
				// level is correct or not
				switchVerification("propertyinfo_locationlbl_updatedstatus_morguard11_XPATH", "Removed",
						"The Removed is not displayed successfully.");

				// select the property option from the drop down
				select("propertyinfo_propertydd_XPATH", data.get("property"));

				// verify added detailed location of the Mould record in property
				// level is correct or not
				switchVerification("propertyinfo_locationlbl_updatedstatus_morguard11_XPATH", "Removed",
						"The Removed is not displayed successfully.");

				// click on the newly created Mould record
				click("propertyinfo_locationlbl_updatedstatus_morguard11_XPATH");

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
				click("envreports_asbestosmaterials_roomlevel_linkbtn_morguard11_XPATH");

				// click on the update button
				click("envreportupdatebtn_CSS");

				// enter the newly created environmental record in the search field

				type("task_listofchecklist_filterfield_CSS", data.get("update_status"));

				// verify added detailed of the Mould record in room level
				// level is correct or not
				switchVerification("propertyinfo_locationlbl_updatedstatus_morguard11_XPATH", "Removed",
						"The Removed is not displayed successfully.");

				// select the property option from the drop down
				select("propertyinfo_propertydd_XPATH", data.get("property"));

				// verify added detailed location of the Mould record in property
				// level is correct or not
				switchVerification("propertyinfo_locationlbl_updatedstatus_morguard11_XPATH", "Removed",
						"The Removed is not displayed successfully.");

			} catch (Throwable t) {
				verificationFailed();
			}

			// click on the home icon from the top of the screen
			click("questionnaire_homeburgermenubtn_hide_CSS");

			// synchronization
			explicitWait("propertylist_title_XPATH");

			// verify the property list
			switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

//			// MOVE THE MOULD RECORD FROM ROOM LEVEL TO PROPERTY LEVEL
//			title("MOVE THE MOULD RECORD FROM ROOM LEVEL TO PROPERTY LEVEL");
//			try {
//
//				// enter the property name in the search field
//
//				type("envreports_propertylist_filtertxt_CSS", data.get("property_2"));
//
//				// click on the environmental icon from the property list page
//				click("environmentalicon_CSS");
//
//				// click on the burger menu
//				click("menubtn_CSS");
//
//				// wait for the element
//				explicitWaitClickable("envrecords_XPATH");
//
//				// click on the environmental records
//				click("envrecords_XPATH");
//
//				// click on the Primary Hazardous Substance
//				click("envrecords_primaryhazardoussubstance_XPATH");
//
//				// click on the mould
//				click("envreports_mould_XPATH");
//
//				// select the building from the drop down
//				select("propertyinfo_propertydd_XPATH", data.get("buildingName_dd"));
//
//				// select the floor from the drop down
//				select("propertyinfo_buildingdd_XPATH", data.get("floor_name"));
//
//				// select the room from the drop down
//				select("propertyinfo_roomdd_XPATH", data.get("room_name"));
//
//				// enter respective location in the search field
//
//				type("sidemenu_reports_searchtxt_XPATH", data.get("location"));
//
//				// select the check box of the newly created environmental record
//				click("envreports_asbestosmaterials_roomlevel_moveckbx_morguard11_XPATH");
//
//				// click on the move button
//				click("envreports_asbestosmaterials_movebtn_CSS");
//
//				// click on the select to move button
//				click("envreports_movereports_selecttomovebtn_CSS");
//
//				// select where to move option from the dropdown
//				select("survey_buildingleveldd_CSS", data.get("property"));
//
//				// click on the save moved records
//				click("envreports_movereports_savemovedrecordsbtn_CSS");
//
//				// wait for the element
//				explicitWaitClickable("closetoastmsg_CSS");
//
//				// click on the toaster close button
//				click("closetoastmsg_CSS");
//
//				// enter the newly created environmental record in the search field
//
//				type("task_listofchecklist_filterfield_CSS", data.get("detailed_location_property"));
//
//				// verify added mould record is correct or not
//				switchVerification("propertyinfo_locationlbl_updatedstatus_propertylevel_morguard11_XPATH", "Removed",
//						"The Removed status is not displayed successfully.");
//
//				// select the building from the drop down
//				select("propertyinfo_propertydd_XPATH", data.get("buildingName_dd"));
//
//				// select the floor from the drop down
//				select("propertyinfo_buildingdd_XPATH", data.get("floor_name"));
//
//				// select the room from the drop down
//				select("propertyinfo_roomdd_XPATH", data.get("room_name"));
//
//				// verify moved record is displayed or not at unit level
//				deleteVerification("propertyinfo_locationlbl_updatedstatus_morguard11_XPATH", "Removed");
//
//			} catch (Throwable t) {
//				verificationFailed();
//			}
//
//			// click on the home icon from the top of the screen
//			click("questionnaire_homeburgermenubtn_hide_CSS");
//
//			// synchronization
//			explicitWait("propertylist_title_XPATH");
//
//			// verify the property list
//			switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

			// DELETE MOULD RECORD
			title("DELETE MOULD RECORD");

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

				// click on the mould
				click("envreports_mould_XPATH");

				// enter the newly created environmental record in the search field

				type("task_listofchecklist_filterfield_CSS", data.get("update_status"));

				// verify added mould record is correct or not
				switchVerification("propertyinfo_locationlbl_updatedstatus_unitlevel_morguard11_XPATH", "Removed",
						"The Removed status is not displayed successfully.");

				// click on the newly added environmental record
				click("propertyinfo_locationlbl_updatedstatus_unitlevel_morguard11_XPATH");

				// wait for the element
				explicitWaitClickable("propertyinfo_asbestosmaterial_deletebtn_XPATH");

				// click on the delete button
				click("propertyinfo_asbestosmaterial_deletebtn_XPATH");

				// wait for the element
				explicitWaitClickable("propertyinfo_asbestosmaterial_confirmationdeletebtn_XPATH");

				// click on the delete button of the confirmation popup
				click("propertyinfo_asbestosmaterial_confirmationdeletebtn_XPATH");

				// enter the newly created environmental record in the search field

				type("task_listofchecklist_filterfield_CSS", data.get("update_status"));

				// verify added mould record is correct or not
				deleteVerification("propertyinfo_locationlbl_updatedstatus_propertylevel_morguard11_XPATH", "Removed");

			} catch (Throwable t) {
				verificationFailed();
			}

			// click on the home icon from the top of the screen
			click("questionnaire_homeburgermenubtn_hide_CSS");

			// synchronization
			explicitWait("propertylist_title_XPATH");

			// verify the property list
			switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

			// DELETE THE ENVIRONMENTAL REPORT AT PROPERTY LEVEL
			title("DELETE THE ENVIRONMENTAL REPORT AT PROPERTY LEVEL");

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

				// click on the newly created environmental report
				click("environmental_searchedupdatedreport_morguard11_XPATH");

				// click on the delete button
				click("propertyinfo_asbestosmaterial_deletebtn_XPATH");

				// click on the delete button of confirmation message
				click("propertyinfo_asbestosmaterial_confirmationdeletebtn_XPATH");

				// wait for the element
				explicitWaitClickable("closetoastmsg_CSS");

				// click on the toaster close button
				click("closetoastmsg_CSS");

				// enter the newly created environmental report in the search field

				type("task_listofchecklist_filterfield_CSS", data.get("update_title_property"));

				// verify the deleted environmental report is displayed or not
				deleteVerification("environmental_searchedupdatedreport_morguard11_XPATH",
						"Update Test Environmental Report Morguard 11");

			} catch (Throwable t) {
				verificationFailed();
			}

			// click on the home icon from the top of the screen
			click("questionnaire_homeburgermenubtn_hide_CSS");

			// synchronization
			explicitWait("propertylist_title_XPATH");

			// verify the property list
			switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

			// wait for the element
			explicitWaitClickable("questionnaire_settingicon_userupdate_CSS");

			// click on the settings icon from the top of the screen
			click("questionnaire_settingicon_userupdate_CSS");

			// wait for the element
			explicitWaitClickable("sidemenu_logout_CSS");

			// click on the logout option from the side menu
			click("sidemenu_logout_CSS");

			// LOGIN WITH ADMIN USER
			title("LOGIN WITH ADMIN USER");

			// wait for the element
			explicitWaitClickable("signinbtn_BTNTEXT");

			// Enter the username

			type("username_MODEL", data.get("username_1"));

			// Enter the password
			type("password_MODEL", data.get("password_1"));

			// Clicking on the "Sign In" button
			click("signinbtn_BTNTEXT");

			// wait for the element
			explicitWait("propertylist_title_XPATH");

			// verify the property list
			switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

			// update the system company
			updateCompany(data);

		} catch (Throwable t) {
			helper.questionnaireNotDisplayLogout(data);
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
			click("propertyinfo_newbuilding_createdbuildinglevel_morguard11_XPATH");

			// scroll down the screen
			scrollTillElement("propertyinfo_menubtn_XPATH");

			// click on the delete building button
			click("propertyinfo_newbuilding_deletebtn_XPATH");

			// click on the delete building button of confirmation popup
			click("propertyinfo_newbuilding_confirmationdeletebtn_XPATH");

			// verify deleted building is displayed or not
			deleteVerification("propertyinfo_newbuilding_createdbuildinglevel_morguard11_XPATH",
					"Test Building Morguard 11");

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