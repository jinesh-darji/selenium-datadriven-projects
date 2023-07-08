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

		if (!(TestUtil.isTestRunnable("rR5595Morguard3Test", excel))) {

			throw new SkipException(
					"Skipping the test " + "rR5595Morguard3Test".toUpperCase() + "as the Run mode is NO");
		}

		if (!data.get("runmode").equals("Y")) {

			throw new SkipException("Skipping the test case as the Run Mode for data set is NO");
		}

		// ADD FLOOR AND ROOMS/UNITS TO BUILDING, AND CHECK TO MAKE SURE THE ROOM OR
		// UNIT IS VISIBLE UNDER THE ASBESTOS AND MOULD SECTION.

		System.out.println(
				"******************** ADD FLOOR AND ROOMS/UNITS TO BUILDING, AND CHECK TO MAKE SURE THE ROOM OR UNIT IS VISIBLE UNDER THE ASBESTOS AND MOULD SECTION. ********************");
		test.log(LogStatus.INFO,
				"******************** ADD FLOOR AND ROOMS/UNITS TO BUILDING, AND CHECK TO MAKE SURE THE ROOM OR UNIT IS VISIBLE UNDER THE ASBESTOS AND MOULD SECTION. ********************");
		Reporter.log(
				"******************** ADD FLOOR AND ROOMS/UNITS TO BUILDING, AND CHECK TO MAKE SURE THE ROOM OR UNIT IS VISIBLE UNDER THE ASBESTOS AND MOULD SECTION. ********************");
		log.info(
				"******************** ADD FLOOR AND ROOMS/UNITS TO BUILDING, AND CHECK TO MAKE SURE THE ROOM OR UNIT IS VISIBLE UNDER THE ASBESTOS AND MOULD SECTION. ********************");

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

		try {

			// enter the property name in the search field
			clear("envreports_propertylist_filtertxt_CSS");
			type("envreports_propertylist_filtertxt_CSS", data.get("property_1"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the property name in the search field.");

			// click on the property information
			click("propertyinformationicon_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the property information.");

			// verify name of the property
			switchVerification("propertyinfo_propertynamelbl_XPATH", "CAPREIT - White Frost",
					"The CAPREIT - White Frost property name is not displayed.");

			// ADD THE NEW BUILDING IN THE PROPERTY

			System.out.println("******************** ADD THE NEW BUILDING IN THE PROPERTY ********************");
			test.log(LogStatus.INFO, "******************** ADD THE NEW BUILDING IN THE PROPERTY ********************");
			Reporter.log("******************** ADD THE NEW BUILDING IN THE PROPERTY ********************");
			log.info("******************** ADD THE NEW BUILDING IN THE PROPERTY ********************");

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
			type("propertyinfo_newbuilding_buildingnumbertxt_XPATH", "778899");
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
			switchVerification("propertyinfo_newbuilding_createdbuilding_XPATH", "Test Building Name",
					"The Test Building Name is not displayed.");

			// ADD THE NEW FLOOR IN THE BUILDING

			System.out.println("******************** ADD THE NEW FLOOR IN THE BUILDING ********************");
			test.log(LogStatus.INFO, "******************** ADD THE NEW FLOOR IN THE BUILDING ********************");
			Reporter.log("******************** ADD THE NEW FLOOR IN THE BUILDING ********************");
			log.info("******************** ADD THE NEW FLOOR IN THE BUILDING ********************");

			// click on the newly created building
			click("propertyinfo_newbuilding_createdbuilding_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the newly created building.");

			// scroll down till new floor button
			WebElement newfloorbtn = driver.findElement(By.xpath(OR.getProperty("propertyinfo_newfloorbtn_XPATH")));
			js.executeScript("arguments[0].scrollIntoView(true);", newfloorbtn);

			// click on the new floor button
			click("propertyinfo_newfloorbtn_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the new floor button.");

			// enter the floor name
			clear("propertyinfo_newfloor_floornametxt_XPATH");
			type("propertyinfo_newfloor_floornametxt_XPATH", data.get("floor_name"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the floor name.");

			// click on the save button
			click("propertyinfo_newfloor_savebtn_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the save button.");

			// wait for the element
			explicitWaitClickable("closetoastmsg_CSS");

			// click on the toaster close button
			click("closetoastmsg_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the toaster close button.");

			// scroll down till new floor button
			newfloorbtn = driver.findElement(By.xpath(OR.getProperty("propertyinfo_newfloorbtn_XPATH")));
			js.executeScript("arguments[0].scrollIntoView(true);", newfloorbtn);

			// verify newly created floor is displayed or not
			switchVerification("propertyinfo_newfloor_createdfloor_XPATH", "Test Floor Name",
					"The Test Floor Name is not displayed.");

			// ADD THE NEW ROOM IN THE FLOOR

			System.out.println("******************** ADD THE NEW ROOM IN THE FLOOR ********************");
			test.log(LogStatus.INFO, "******************** ADD THE NEW ROOM IN THE FLOOR ********************");
			Reporter.log("******************** ADD THE NEW ROOM IN THE FLOOR ********************");
			log.info("******************** ADD THE NEW ROOM IN THE FLOOR ********************");

			// click on the newly created floor
			click("propertyinfo_newfloor_createdfloor_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the newly created floor.");

			// scroll down till new room button
			WebElement newroombtn = driver.findElement(By.xpath(OR.getProperty("propertyinfo_newroombtn_XPATH")));
			js.executeScript("arguments[0].scrollIntoView(true);", newroombtn);

			// click on the new room button
			click("propertyinfo_newroombtn_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the new room button.");

			// enter the room name
			type("propertyinfo_newroom_roomnametxt_XPATH", data.get("room_name"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the room name.");

			// click on the save button
			click("propertyinfo_newroom_savebtn_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the save button.");

			// wait for the element
			explicitWaitClickable("closetoastmsg_CSS");

			// click on the toaster close button
			click("closetoastmsg_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the toaster close button.");

			// scroll down till new room button
			newroombtn = driver.findElement(By.xpath(OR.getProperty("propertyinfo_newroombtn_XPATH")));
			js.executeScript("arguments[0].scrollIntoView(true);", newroombtn);

			// verify newly created room is displayed or not
			switchVerification("propertyinfo_newroom_createdroom_XPATH", "Test Room Name",
					"The Test Room Name is not displayed.");

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

		// ADD ASBESTOS MATERIALS RECORD AT ROOM LEVEL

		System.out.println("******************** ADD ASBESTOS MATERIALS RECORD AT ROOM LEVEL ********************");
		test.log(LogStatus.INFO,
				"******************** ADD ASBESTOS MATERIALS RECORD AT ROOM LEVEL ********************");
		Reporter.log("******************** ADD ASBESTOS MATERIALS RECORD AT ROOM LEVEL ********************");
		log.info("******************** ADD ASBESTOS MATERIALS RECORD AT ROOM LEVEL ********************");

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

			// wait for the element
			Thread.sleep(5000);

			// click on the Primary Hazardous Substance
			click("envrecords_primaryhazardoussubstance_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the Primary Hazardous Substance option");

			// wait for the element
			Thread.sleep(5000);

			// click on the asbestos materials
			click("envreports_asbestosmaterials_XPATH");
			System.out.println("Clicked on the Asbestos Materials option.");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Navigate to the Asbestos Meteria Records Screen.");

			// select the building from the drop down
			select("propertyinfo_propertydd_XPATH", data.get("buildingName_dd"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Selected the building from the drop down.");

			// select the floor from the drop down
			select("propertyinfo_buildingdd_XPATH", data.get("floor_name"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Selected the floor from the drop down.");

			// select the room from the drop down
			select("propertyinfo_roomdd_XPATH", data.get("room_name"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Selected the room from the drop down.");

			// click on the add button
			click("envreports_asbestosmaterials_addbtn_CSS");
			System.out.println("Clicked on the Add button.");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Navigate to the Add Asbestos Material Screen");

			// select the material
			select("envreports_asbestosmaterials_materialdd_CSS", data.get("material"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("The option is selected from the Material dropdown.");

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

			// VIEW NEWLY CREATED RECORD IS DISPLAYED WITH CORRECT DETAILS OR NOT - Asbestos
			// Material

			// enter the newly created environmental record in the search field
			clear("task_listofchecklist_filterfield_CSS");
			System.out.println("Cleared the search field.");
			ngDriver.waitForAngularRequestsToFinish();
			type("task_listofchecklist_filterfield_CSS", data.get("location"));
			System.out.println("Entered the newly created environmental record in the search field.");
			ngDriver.waitForAngularRequestsToFinish();

			// verify added detailed location of the Asbestos Materials record in room level
			// level is correct or not
			switchVerification("propertyinfo_locationlbl_XPATH",
					"Test Building Name > Test Floor Name > Test Room Name",
					"The Test Building Name > Test Floor Name > Test Room Name is not displayed successfully.");

			// select the property option from the drop down
			select("propertyinfo_propertydd_XPATH", data.get("property"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Selected the property from the drop down.");

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
		System.out.println("Clicked on the home icon from the top of the screen.");
		ngDriver.waitForAngularRequestsToFinish();

		// synchronization
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// ADD MOULD RECORD AT ROOM LEVEL

		System.out.println("******************** ADD MOULD RECORD AT ROOM LEVEL ********************");
		test.log(LogStatus.INFO, "******************** ADD MOULD RECORD AT ROOM LEVEL ********************");
		Reporter.log("******************** ADD MOULD RECORD AT ROOM LEVEL ********************");
		log.info("******************** ADD MOULD RECORD AT ROOM LEVEL ********************");

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

			// wait for the element
			Thread.sleep(5000);

			// click on the Primary Hazardous Substance
			click("envrecords_primaryhazardoussubstance_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the Primary Hazardous Substance option");

			// wait for the element
			Thread.sleep(5000);

			// click on the mould
			click("envreports_mould_XPATH");
			System.out.println("Clicked on the mould option.");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Navigate to the mould Records Screen.");

			// select the building from the drop down
			select("propertyinfo_propertydd_XPATH", data.get("buildingName_dd"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Selected the building from the drop down.");

			// select the floor from the drop down
			select("propertyinfo_buildingdd_XPATH", data.get("floor_name"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Selected the floor from the drop down.");

			// select the room from the drop down
			select("propertyinfo_roomdd_XPATH", data.get("room_name"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Selected the room from the drop down.");

			// click on the add button
			click("envreports_asbestosmaterials_addbtn_CSS");
			System.out.println("Clicked on the Add button.");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Navigate to the Add Asbestos Material Screen");

			// select the status
			select("envreports_asbestosmaterials_statusdd_CSS", data.get("status"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("The option is selected from the Status dropdown.");

			// select the causes by
			select("propertyinfo_causesbydd_XPATH", data.get("caused_by"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("The option is selected from the causes by dropdown.");

			// select the responsible party
			select("propertyinfo_responsiblepartydd_XPATH", data.get("responsible_party"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("The option is selected from the responsible party dropdown.");

			// scroll till bottom of the page
			WebElement savebtn = driver
					.findElement(By.cssSelector(OR.getProperty("envreports_asbestosmaterials_savebtn_CSS")));
			JavascriptExecutor js = (JavascriptExecutor) driver;
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

			// VIEW NEWLY CREATED RECORD IS DISPLAYED WITH CORRECT DETAILS OR NOT - Asbestos
			// Material

			// enter the newly created environmental record in the search field
			clear("task_listofchecklist_filterfield_CSS");
			type("task_listofchecklist_filterfield_CSS", data.get("location"));
			System.out.println("Entered the newly created environmental record in the search field.");
			ngDriver.waitForAngularRequestsToFinish();

			// verify added detailed location of the Mould record in room level
			// level is correct or not
			switchVerification("propertyinfo_locationlbl_XPATH",
					"Test Building Name > Test Floor Name > Test Room Name",
					"The Test Building Name > Test Floor Name > Test Room Name is not displayed successfully.");

			// select the property option from the drop down
			select("propertyinfo_propertydd_XPATH", data.get("property"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Selected the property from the drop down.");

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
		System.out.println("Clicked on the home icon from the top of the screen.");
		ngDriver.waitForAngularRequestsToFinish();

		// synchronization
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// DELETE NEWLY CREATED ASBESTOS MATERIAL RECORD

		System.out.println("******************** DELETE NEWLY CREATED ASBESTOS MATERIAL RECORD ********************");
		test.log(LogStatus.INFO,
				"******************** DELETE NEWLY CREATED ASBESTOS MATERIAL RECORD ********************");
		Reporter.log("******************** DELETE NEWLY CREATED ASBESTOS MATERIAL RECORD ********************");
		log.info("******************** DELETE NEWLY CREATED ASBESTOS MATERIAL RECORD ********************");

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

			// wait for the element
			Thread.sleep(5000);

			// click on the Primary Hazardous Substance
			click("envrecords_primaryhazardoussubstance_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the Primary Hazardous Substance option");

			// wait for the element
			Thread.sleep(5000);

			// click on the asbestos materials
			click("envreports_asbestosmaterials_XPATH");
			System.out.println("Clicked on the Asbestos Materials option.");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Navigate to the Asbestos Meteria Records Screen.");

			// select the building from the drop down
			select("propertyinfo_propertydd_XPATH", data.get("buildingName_dd"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Selected the building from the drop down.");

			// select the floor from the drop down
			select("propertyinfo_buildingdd_XPATH", data.get("floor_name"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Selected the floor from the drop down.");

			// select the room from the drop down
			select("propertyinfo_roomdd_XPATH", data.get("room_name"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Selected the room from the drop down.");

			// click on the newly created asbestos material record
			click("propertyinfo_locationlbl_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the newly created asbestos material record.");

			// click on the delete button
			click("propertyinfo_asbestosmaterial_deletebtn_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the delete button.");

			// click on the delete button of confirmation
			click("propertyinfo_asbestosmaterial_confirmationdeletebtn_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the delete button of confirmation.");

			// wait for the element
			explicitWaitClickable("closetoastmsg_CSS");

			// click on the toaster close button
			click("closetoastmsg_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the toaster close button.");

			// enter the newly created environmental record in the search field
			clear("task_listofchecklist_filterfield_CSS");
			type("task_listofchecklist_filterfield_CSS", data.get("location"));
			System.out.println("Entered the newly created environmental record in the search field.");
			ngDriver.waitForAngularRequestsToFinish();

			// verify deleted record is displayed or not
			deleteVerification("propertyinfo_locationlbl_XPATH",
					"Test Building Name > Test Floor Name > Test Room Name");

			// select the property option from the drop down
			select("propertyinfo_propertydd_XPATH", data.get("property"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Selected the property from the drop down.");

			// verify deleted record is displayed or not
			deleteVerification("propertyinfo_locationlbl_XPATH",
					"Test Building Name > Test Floor Name > Test Room Name");

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

		// DELETE NEWLY CREATED MOULD RECORD

		System.out.println("******************** DELETE NEWLY CREATED MOULD RECORD ********************");
		test.log(LogStatus.INFO, "******************** DELETE NEWLY CREATED MOULD RECORD ********************");
		Reporter.log("******************** DELETE NEWLY CREATED MOULD RECORD ********************");
		log.info("******************** DELETE NEWLY CREATED MOULD RECORD ********************");

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

			// wait for the element
			Thread.sleep(5000);

			// click on the Primary Hazardous Substance
			click("envrecords_primaryhazardoussubstance_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the Primary Hazardous Substance option");

			// wait for the element
			Thread.sleep(5000);

			// click on the mould
			click("envreports_mould_XPATH");
			System.out.println("Clicked on the mould option.");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Navigate to the Asbestos Meteria Records Screen.");

			// select the building from the drop down
			select("propertyinfo_propertydd_XPATH", data.get("buildingName_dd"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Selected the building from the drop down.");

			// select the floor from the drop down
			select("propertyinfo_buildingdd_XPATH", data.get("floor_name"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Selected the floor from the drop down.");

			// select the room from the drop down
			select("propertyinfo_roomdd_XPATH", data.get("room_name"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Selected the room from the drop down.");

			// click on the newly created mould record
			click("propertyinfo_locationlbl_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the newly created mould record.");

			// click on the delete button
			click("propertyinfo_asbestosmaterial_deletebtn_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the delete button.");

			// click on the delete button of confirmation
			click("propertyinfo_asbestosmaterial_confirmationdeletebtn_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the delete button of confirmation.");

			// wait for the element
			explicitWaitClickable("closetoastmsg_CSS");

			// click on the toaster close button
			click("closetoastmsg_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the toaster close button.");

			// enter the newly created environmental record in the search field
			clear("task_listofchecklist_filterfield_CSS");
			System.out.println("Cleared the search field.");
			ngDriver.waitForAngularRequestsToFinish();
			type("task_listofchecklist_filterfield_CSS", data.get("location"));
			System.out.println("Entered the newly created environmental record in the search field.");
			ngDriver.waitForAngularRequestsToFinish();

			// verify deleted record is displayed or not
			deleteVerification("propertyinfo_locationlbl_XPATH",
					"Test Building Name > Test Floor Name > Test Room Name");

			// select the property option from the drop down
			select("propertyinfo_propertydd_XPATH", data.get("property"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Selected the property from the drop down.");

			// verify deleted record is displayed or not
			deleteVerification("propertyinfo_locationlbl_XPATH",
					"Test Building Name > Test Floor Name > Test Room Name");

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
			type("envreports_propertylist_filtertxt_CSS", data.get("property_1"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the property name in the search field.");

			// click on the property information
			click("propertyinformationicon_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the property information.");

			// verify name of the property
			switchVerification("propertyinfo_propertynamelbl_XPATH", "CAPREIT - White Frost",
					"The CAPREIT - White Frost property name is not displayed.");

			// click on the menu button
			click("propertyinfo_menubtn_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the menu button.");

			// click on the building option
			click("propertyinfo_menubtn_buildingoption_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the building option.");

			// click on the newly created building
			click("propertyinfo_newbuilding_createdbuilding_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the newly created building.");

			// click on the delete button
			click("propertyinfo_newbuilding_deletebtn_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the delete button.");

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

			deleteVerification("propertyinfo_newbuilding_createdbuilding_XPATH", "Test Building Name");

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

//		// CREATE NEW OWNER IN THE PROPERTY ONE
//
//		System.out.println("******************** CREATE NEW OWNER IN THE PROPERTY ONE ********************");
//		test.log(LogStatus.INFO, "******************** CREATE NEW OWNER IN THE PROPERTY ONE ********************");
//		Reporter.log("******************** CREATE NEW OWNER IN THE PROPERTY ONE ********************");
//		log.info("******************** CREATE NEW OWNER IN THE PROPERTY ONE ********************");
//
//		String s = RandomStringUtils.randomAlphabetic(8);
//
//		try {
//
//			// enter the property name in the search field
//			clear("envreports_propertylist_filtertxt_CSS");
//			type("envreports_propertylist_filtertxt_CSS", data.get("property_1"));
//			ngDriver.waitForAngularRequestsToFinish();
//			System.out.println("Entered the property name in the search field.");
//
//			// click on the property information
//			click("propertyinformationicon_CSS");
//			ngDriver.waitForAngularRequestsToFinish();
//			System.out.println("Clicked on the property information.");
//
//			// click on the menu button
//			click("propertyinfo_menubtn_XPATH");
//			ngDriver.waitForAngularRequestsToFinish();
//			System.out.println("Clicked on the menu button.");
//
//			// click on the Owners/Investors option
//			click("propertyinfo_menubtn_owneroption_XPATH");
//			ngDriver.waitForAngularRequestsToFinish();
//			System.out.println("Clicked on the Owners/Investors option.");
//
//			// click on the add owner button
//			click("propertyinfo_owner_addownerbtn_CSS");
//			ngDriver.waitForAngularRequestsToFinish();
//			System.out.println("Clicked on the add owner button.");
//
//			// enter the owner name
//			clear("propertyinfo_owner_ownernametxt_XPATH");
//			type("propertyinfo_owner_ownernametxt_XPATH", s);
//			ngDriver.waitForAngularRequestsToFinish();
//			System.out.println("Entered the owner name.");
//
//			// enter the owner percentage
//			clear("propertyinfo_owner_ownerpercentagetxt_XPATH");
//			type("propertyinfo_owner_ownerpercentagetxt_XPATH", "100");
//			ngDriver.waitForAngularRequestsToFinish();
//			System.out.println("Entered the owner percentage.");
//
//			// enter the investor
//			clear("propertyinfo_owner_investortxt_XPATH");
//			type("propertyinfo_owner_investortxt_XPATH", data.get("investor"));
//			ngDriver.waitForAngularRequestsToFinish();
//			System.out.println("Entered the investor.");
//
//			// wait for the element
//			Thread.sleep(10000);
//
//			// click on the save button
//			WebElement savebtn = driver.findElement(By.xpath(OR.getProperty("propertyinfo_owner_savebrn_XPATH")));
//			JavascriptExecutor js = (JavascriptExecutor) driver;
//			js.executeScript("arguments[0].click();", savebtn);
//			ngDriver.waitForAngularRequestsToFinish();
//			System.out.println("Clicked on the save button.");
//
//			// verify newly created owner is displayed in the owner list or not
//			String owner = "//td[text()='" + s + "']";
//			switchVerification(owner, s, "The " + s + " is not displayed.");
//
//			// click on the menu button
//			click("propertyinfo_menubtn_XPATH");
//			ngDriver.waitForAngularRequestsToFinish();
//			System.out.println("Clicked on the menu button.");
//
//			// click on the property details option
//			click("propertyinfo_menubtn_propertydetailsoption_XPATH");
//			ngDriver.waitForAngularRequestsToFinish();
//			System.out.println("Clicked on the property details option.");
//
//		} catch (Throwable t) {
//			verificationFailed();
//		}
//
//		// click on the home icon from the top of the screen
//		click("questionnaire_homeburgermenubtn_hide_CSS");
//		System.out.println("Clicked on the home icon from the top of the screen.");
//		ngDriver.waitForAngularRequestsToFinish();
//
//		// synchronization
//		explicitWait("propertylist_title_XPATH");
//
//		// verify the property list
//		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");
//
//		// VERIFY NEWLY CREATED OWNER IS DISPLAYED IN THE PROPERTY TWO
//
//		System.out.println(
//				"******************** VERIFY NEWLY CREATED OWNER IS DISPLAYED IN THE PROPERTY TWO ********************");
//		test.log(LogStatus.INFO,
//				"******************** VERIFY NEWLY CREATED OWNER IS DISPLAYED IN THE PROPERTY TWO ********************");
//		Reporter.log(
//				"******************** VERIFY NEWLY CREATED OWNER IS DISPLAYED IN THE PROPERTY TWO ********************");
//		log.info(
//				"******************** VERIFY NEWLY CREATED OWNER IS DISPLAYED IN THE PROPERTY TWO ********************");
//
//		try {
//
//			// enter the property name in the search field
//			clear("envreports_propertylist_filtertxt_CSS");
//			type("envreports_propertylist_filtertxt_CSS", data.get("property_3"));
//			ngDriver.waitForAngularRequestsToFinish();
//			System.out.println("Entered the property name in the search field.");
//
//			// click on the property information
//			click("propertyinformationicon_CSS");
//			ngDriver.waitForAngularRequestsToFinish();
//			System.out.println("Clicked on the property information.");
//
//			// click on the menu button
//			click("propertyinfo_menubtn_XPATH");
//			ngDriver.waitForAngularRequestsToFinish();
//			System.out.println("Clicked on the menu button.");
//
//			// click on the Owners/Investors option
//			click("propertyinfo_menubtn_owneroption_XPATH");
//			ngDriver.waitForAngularRequestsToFinish();
//			System.out.println("Clicked on the Owners/Investors option.");
//
//			// verify newly created owner is displayed in the owner list of the another
//			// property
//			String owner = "//td[text()='" + s + "']";
//			deleteVerification(owner, s);
//
//			// click on the menu button
//			click("propertyinfo_menubtn_XPATH");
//			ngDriver.waitForAngularRequestsToFinish();
//			System.out.println("Clicked on the menu button.");
//
//			// click on the property details option
//			click("propertyinfo_menubtn_propertydetailsoption_XPATH");
//			ngDriver.waitForAngularRequestsToFinish();
//			System.out.println("Clicked on the property details option.");
//
//		} catch (Throwable t) {
//			verificationFailed();
//		}
//
//		// click on the home icon from the top of the screen
//		click("questionnaire_homeburgermenubtn_hide_CSS");
//		System.out.println("Clicked on the home icon from the top of the screen.");
//		ngDriver.waitForAngularRequestsToFinish();
//
//		// synchronization
//		explicitWait("propertylist_title_XPATH");
//
//		// verify the property list
//		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");
//
//		// DELETE THE NEWLY CREATED OWNER
//
//		System.out.println("******************** DELETE THE NEWLY CREATED OWNER ********************");
//		test.log(LogStatus.INFO, "******************** DELETE THE NEWLY CREATED OWNER ********************");
//		Reporter.log("******************** DELETE THE NEWLY CREATED OWNER ********************");
//		log.info("******************** DELETE THE NEWLY CREATED OWNER ********************");
//
//		try {
//
//			// enter the property name in the search field
//			clear("envreports_propertylist_filtertxt_CSS");
//			type("envreports_propertylist_filtertxt_CSS", data.get("property_1"));
//			ngDriver.waitForAngularRequestsToFinish();
//			System.out.println("Entered the property name in the search field.");
//
//			// click on the property information
//			click("propertyinformationicon_CSS");
//			ngDriver.waitForAngularRequestsToFinish();
//			System.out.println("Clicked on the property information.");
//
//			// click on the menu button
//			click("propertyinfo_menubtn_XPATH");
//			ngDriver.waitForAngularRequestsToFinish();
//			System.out.println("Clicked on the menu button.");
//
//			// click on the Owners/Investors option
//			click("propertyinfo_menubtn_owneroption_XPATH");
//			ngDriver.waitForAngularRequestsToFinish();
//			System.out.println("Clicked on the Owners/Investors option.");
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
//			ngDriver.waitForAngularRequestsToFinish();
//			System.out.println("Clicked on the delete button of the respective owner.");
//
//			// click on the remove button
//			click("propertyinfo_owner_removebtn_XPATH");
//			ngDriver.waitForAngularRequestsToFinish();
//			System.out.println("Clicked on the remove button.");
//
//			// verify newly created owner is displayed in the owner list of the another
//			// property
//			owner = "//td[text()='" + s + "']";
//			deleteVerification(owner, s);
//
//			// click on the menu button
//			click("propertyinfo_menubtn_XPATH");
//			ngDriver.waitForAngularRequestsToFinish();
//			System.out.println("Clicked on the menu button.");
//
//			// click on the property details option
//			click("propertyinfo_menubtn_propertydetailsoption_XPATH");
//			ngDriver.waitForAngularRequestsToFinish();
//			System.out.println("Clicked on the property details option.");
//
//		} catch (Throwable t) {
//			verificationFailed();
//		}
//
//		// click on the home icon from the top of the screen
//		click("questionnaire_homeburgermenubtn_hide_CSS");
//		System.out.println("Clicked on the home icon from the top of the screen.");
//		ngDriver.waitForAngularRequestsToFinish();
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
