package testcases.smokesuite;

import java.io.IOException;
import java.util.Hashtable;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Reporter;
import org.testng.SkipException;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import base.TestBase;
import utilities.TestUtil;

public class RR5595Morguard3Test extends TestBase {

	@Test(dataProviderClass = TestUtil.class, dataProvider = "dp")
	public void rR5595Morguard3Test(Hashtable<String, String> data) throws IOException, InterruptedException {

		execution(data, "rR5595Morguard3Test");

		// ADD FLOOR AND ROOMS/UNITS TO BUILDING, AND CHECK TO MAKE SURE THE ROOM OR
		// UNIT IS VISIBLE UNDER THE ASBESTOS AND MOULD SECTION.
		title("ADD FLOOR AND ROOMS/UNITS TO BUILDING, AND CHECK TO MAKE SURE THE ROOM OR UNIT IS VISIBLE UNDER THE ASBESTOS AND MOULD SECTION.");

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

		try {

			// enter the property name in the search field

			type("envreports_propertylist_filtertxt_CSS", data.get("property_1"));

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

			type("propertyinfo_newbuilding_buildingnumbertxt_XPATH", "778899");

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
			switchVerification("propertyinfo_newbuilding_createdbuilding_XPATH", "Test Building Name",
					"The Test Building Name is not displayed.");

			// ADD THE NEW FLOOR IN THE BUILDING
			title("ADD THE NEW FLOOR IN THE BUILDING");

			// click on the newly created building
			click("propertyinfo_newbuilding_createdbuilding_XPATH");

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
			switchVerification("propertyinfo_newfloor_createdfloor_XPATH", "Test Floor Name",
					"The Test Floor Name is not displayed.");

			// ADD THE NEW ROOM IN THE FLOOR
			title("ADD THE NEW ROOM IN THE FLOOR");

			// click on the newly created floor
			click("propertyinfo_newfloor_createdfloor_XPATH");

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
			switchVerification("propertyinfo_newroom_createdroom_XPATH", "Test Room Name",
					"The Test Room Name is not displayed.");

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

		// ADD ASBESTOS MATERIALS RECORD AT ROOM LEVEL
		title("ADD ASBESTOS MATERIALS RECORD AT ROOM LEVEL");

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

			// wait for the element
			Thread.sleep(5000);

			// click on the Primary Hazardous Substance
			click("envrecords_primaryhazardoussubstance_XPATH");

			// wait for the element
			Thread.sleep(5000);

			// click on the asbestos materials
			click("envreports_asbestosmaterials_XPATH");

			// select the building from the drop down
			select("propertyinfo_propertydd_XPATH", data.get("buildingName_dd"));

			// select the floor from the drop down
			select("propertyinfo_buildingdd_XPATH", data.get("floor_name"));

			// select the room from the drop down
			select("propertyinfo_roomdd_XPATH", data.get("room_name"));

			// click on the add button
			click("envreports_asbestosmaterials_addbtn_CSS");

			// select the material
			select("envreports_asbestosmaterials_materialdd_CSS", data.get("material"));

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

			// VIEW NEWLY CREATED RECORD IS DISPLAYED WITH CORRECT DETAILS OR NOT - Asbestos
			// Material

			// enter the newly created environmental record in the search field

			type("task_listofchecklist_filterfield_CSS", data.get("location"));

			// verify added detailed location of the Asbestos Materials record in room level
			// level is correct or not
			switchVerification("propertyinfo_locationlbl_XPATH",
					"Test Building Name > Test Floor Name > Test Room Name",
					"The Test Building Name > Test Floor Name > Test Room Name is not displayed successfully.");

			// select the property option from the drop down
			select("propertyinfo_propertydd_XPATH", data.get("property"));

			// verify added detailed location of the Asbestos Materials record in property
			// level is correct or not
			switchVerification("propertyinfo_locationlbl_XPATH",
					"Test Building Name > Test Floor Name > Test Room Name",
					"The Test Building Name > Test Floor Name > Test Room Name is not displayed successfully.");

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
			switchVerification("propertyinfo_locationlbl_XPATH",
					"Test Building Name > Test Floor Name > Test Room Name",
					"The Test Building Name > Test Floor Name > Test Room Name is not displayed successfully.");

			// select the property option from the drop down
			select("propertyinfo_propertydd_XPATH", data.get("property"));

			// verify added detailed location of the Mould record in property
			// level is correct or not
			switchVerification("propertyinfo_locationlbl_XPATH",
					"Test Building Name > Test Floor Name > Test Room Name",
					"The Test Building Name > Test Floor Name > Test Room Name is not displayed successfully.");

		} catch (Throwable t) {
			verificationFailed();
		}

		// click on the home icon from the top of the screen
		click("questionnaire_homeburgermenubtn_hide_CSS");

		// synchronization
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// DELETE NEWLY CREATED ASBESTOS MATERIAL RECORD
		title("DELETE NEWLY CREATED ASBESTOS MATERIAL RECORD");

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

			// wait for the element
			Thread.sleep(5000);

			// click on the Primary Hazardous Substance
			click("envrecords_primaryhazardoussubstance_XPATH");

			// wait for the element
			Thread.sleep(5000);

			// click on the asbestos materials
			click("envreports_asbestosmaterials_XPATH");

			// select the building from the drop down
			select("propertyinfo_propertydd_XPATH", data.get("buildingName_dd"));

			// select the floor from the drop down
			select("propertyinfo_buildingdd_XPATH", data.get("floor_name"));

			// select the room from the drop down
			select("propertyinfo_roomdd_XPATH", data.get("room_name"));

			// click on the newly created asbestos material record
			click("propertyinfo_locationlbl_XPATH");

			// click on the delete button
			click("propertyinfo_asbestosmaterial_deletebtn_XPATH");

			// click on the delete button of confirmation
			click("propertyinfo_asbestosmaterial_confirmationdeletebtn_XPATH");

			// wait for the element
			explicitWaitClickable("closetoastmsg_CSS");

			// click on the toaster close button
			click("closetoastmsg_CSS");

			// enter the newly created environmental record in the search field

			type("task_listofchecklist_filterfield_CSS", data.get("location"));

			// verify deleted record is displayed or not
			deleteVerification("propertyinfo_locationlbl_XPATH",
					"Test Building Name > Test Floor Name > Test Room Name");

			// select the property option from the drop down
			select("propertyinfo_propertydd_XPATH", data.get("property"));

			// verify deleted record is displayed or not
			deleteVerification("propertyinfo_locationlbl_XPATH",
					"Test Building Name > Test Floor Name > Test Room Name");

		} catch (Throwable t) {
			verificationFailed();
		}

		// click on the home icon from the top of the screen
		click("questionnaire_homeburgermenubtn_hide_CSS");

		// synchronization
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// DELETE NEWLY CREATED MOULD RECORD
		title("DELETE NEWLY CREATED MOULD RECORD");

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

			// click on the newly created mould record
			click("propertyinfo_locationlbl_XPATH");

			// click on the delete button
			click("propertyinfo_asbestosmaterial_deletebtn_XPATH");

			// click on the delete button of confirmation
			click("propertyinfo_asbestosmaterial_confirmationdeletebtn_XPATH");

			// wait for the element
			explicitWaitClickable("closetoastmsg_CSS");

			// click on the toaster close button
			click("closetoastmsg_CSS");

			// enter the newly created environmental record in the search field

			type("task_listofchecklist_filterfield_CSS", data.get("location"));

			// verify deleted record is displayed or not
			deleteVerification("propertyinfo_locationlbl_XPATH",
					"Test Building Name > Test Floor Name > Test Room Name");

			// select the property option from the drop down
			select("propertyinfo_propertydd_XPATH", data.get("property"));

			// verify deleted record is displayed or not
			deleteVerification("propertyinfo_locationlbl_XPATH",
					"Test Building Name > Test Floor Name > Test Room Name");

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

			type("envreports_propertylist_filtertxt_CSS", data.get("property_1"));

			// click on the property information
			click("propertyinformationicon_CSS");

			// verify name of the property
			switchVerification("propertyinfo_propertynamelbl_XPATH", "CAPREIT - White Frost",
					"The CAPREIT - White Frost property name is not displayed.");

			// click on the menu button
			click("propertyinfo_menubtn_XPATH");

			// click on the building option
			click("propertyinfo_menubtn_buildingoption_XPATH");

			// click on the newly created building
			click("propertyinfo_newbuilding_createdbuilding_XPATH");

			// click on the delete button
			click("propertyinfo_newbuilding_deletebtn_XPATH");

			// click on the delete button of the confirmation
			click("propertyinfo_newbuilding_confirmationdeletebtn_XPATH");

			// wait for the element
			explicitWaitClickable("closetoastmsg_CSS");

			// click on the toaster close button
			click("closetoastmsg_CSS");

			// verify deleted building is displayed or not

			deleteVerification("propertyinfo_newbuilding_createdbuilding_XPATH", "Test Building Name");

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

		//////////////////////

//		// CREATE NEW OWNER IN THE PROPERTY ONE
//		title("CREATE NEW OWNER IN THE PROPERTY ONE");
//
//		String s = RandomStringUtils.randomAlphabetic(8);
//
//		try {
//
//			// enter the property name in the search field//
//			type("envreports_propertylist_filtertxt_CSS", data.get("property_1"));
//
//			// click on the property information
//			click("propertyinformationicon_CSS");
//
//			// click on the menu button
//			click("propertyinfo_menubtn_XPATH");
//
//			// click on the Owners/Investors option
//			click("propertyinfo_menubtn_owneroption_XPATH");
//
//			// click on the add owner button
//			click("propertyinfo_owner_addownerbtn_CSS");
//
//			// enter the owner name
//
//			type("propertyinfo_owner_ownernametxt_XPATH", s);
//
//			// enter the owner percentage
//
//			type("propertyinfo_owner_ownerpercentagetxt_XPATH", "100");
//
//			// enter the investor
//
//			type("propertyinfo_owner_investortxt_XPATH", data.get("investor"));
//
//			// wait for the element
//			Thread.sleep(10000);
//
//			// click on the save button
//			WebElement savebtn = driver.findElement(By.xpath(OR.getProperty("propertyinfo_owner_savebrn_XPATH")));
//
//			js.executeScript("arguments[0].click();", savebtn);
//
//			// verify newly created owner is displayed in the owner list or not
//			String owner = "//td[text()='" + s + "']";
//			switchVerification(owner, s, "The " + s + " is not displayed.");
//
//			// click on the menu button
//			click("propertyinfo_menubtn_XPATH");
//
//			// click on the property details option
//			click("propertyinfo_menubtn_propertydetailsoption_XPATH");
//
//		} catch (Throwable t) {
//			verificationFailed();
//		}
//
//		// click on the home icon from the top of the screen
//		click("questionnaire_homeburgermenubtn_hide_CSS");
//
//		// synchronization
//		explicitWait("propertylist_title_XPATH");
//
//		// verify the property list
//		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");
//
//		// VERIFY NEWLY CREATED OWNER IS DISPLAYED IN THE PROPERTY TWO
//		title("VERIFY NEWLY CREATED OWNER IS DISPLAYED IN THE PROPERTY TWO");
//
//		try {
//
//			// enter the property name in the search field
//
//			type("envreports_propertylist_filtertxt_CSS", data.get("property_3"));
//
//			// click on the property information
//			click("propertyinformationicon_CSS");
//
//			// click on the menu button
//			click("propertyinfo_menubtn_XPATH");
//
//			// click on the Owners/Investors option
//			click("propertyinfo_menubtn_owneroption_XPATH");
//
//			// verify newly created owner is displayed in the owner list of the another
//			// property
//			String owner = "//td[text()='" + s + "']";
//			deleteVerification(owner, s);
//
//			// click on the menu button
//			click("propertyinfo_menubtn_XPATH");
//
//			// click on the property details option
//			click("propertyinfo_menubtn_propertydetailsoption_XPATH");
//
//		} catch (Throwable t) {
//			verificationFailed();
//		}
//
//		// click on the home icon from the top of the screen
//		click("questionnaire_homeburgermenubtn_hide_CSS");
//
//		// synchronization
//		explicitWait("propertylist_title_XPATH");
//
//		// verify the property list
//		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");
//
//		// DELETE THE NEWLY CREATED OWNER
//		title("DELETE THE NEWLY CREATED OWNER");
//		try {
//
//			// enter the property name in the search field
//
//			type("envreports_propertylist_filtertxt_CSS", data.get("property_1"));
//
//			// click on the property information
//			click("propertyinformationicon_CSS");
//
//			// click on the menu button
//			click("propertyinfo_menubtn_XPATH");
//
//			// click on the Owners/Investors option
//			click("propertyinfo_menubtn_owneroption_XPATH");
//
//			// verify newly created owner is displayed in the owner list or not
//			String owner = "//td[text()='" + s + "']";
//			switchVerification(owner, s, "The " + s + " is not displayed.");
//
//			// click on the delete button of the respective owner
//			String deletebtn = "//td[text()='" + s
//					+ "']//following-sibling::td[@ng-show='propertyOwnerEditAccess']//span[@data-target='#removeOwnerModal']";
//
//			driver.findElement(By.xpath(deletebtn)).click();
//
//			// click on the remove button
//			click("propertyinfo_owner_removebtn_XPATH");
//
//			// verify newly created owner is displayed in the owner list of the another
//			// property
//			owner = "//td[text()='" + s + "']";
//			deleteVerification(owner, s);
//
//			// click on the menu button
//			click("propertyinfo_menubtn_XPATH");
//
//			// click on the property details option
//			click("propertyinfo_menubtn_propertydetailsoption_XPATH");
//
//		} catch (Throwable t) {
//			verificationFailed();
//		}
//
//		// click on the home icon from the top of the screen
//		click("questionnaire_homeburgermenubtn_hide_CSS");
//
//		// synchronization
//		explicitWait("propertylist_title_XPATH");
//
//		// verify the property list
//		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

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