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

		if (!(TestUtil.isTestRunnable("rR5595Morguard7Test", excel))) {

			throw new SkipException(
					"Skipping the test " + "rR5595Morguard7Test".toUpperCase() + "as the Run mode is NO");
		}

		if (!data.get("runmode").equals("Y")) {

			throw new SkipException("Skipping the test case as the Run Mode for data set is NO");
		}

		Helper helper = new Helper();

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

		// DELETE PREVIOUSLY CREATED ENVIRONMENTAL REPORT

		System.out.println("******************** DELETE PREVIOUSLY CREATED ENVIRONMENTAL REPORT ********************");
		test.log(LogStatus.INFO,
				"******************** DELETE PREVIOUSLY CREATED ENVIRONMENTAL REPORT ********************");
		Reporter.log("******************** DELETE PREVIOUSLY CREATED ENVIRONMENTAL REPORT ********************");
		log.info("******************** DELETE PREVIOUSLY CREATED ENVIRONMENTAL REPORT ********************");

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

		// DELETE ALL THE NEWLY CREATED ASBESTOS MATERIAL RECORDS

		System.out.println(
				"******************** DELETE ALL THE NEWLY CREATED ASBESTOS MATERIAL RECORDS ********************");
		test.log(LogStatus.INFO,
				"******************** DELETE ALL THE NEWLY CREATED ASBESTOS MATERIAL RECORDS ********************");
		Reporter.log(
				"******************** DELETE ALL THE NEWLY CREATED ASBESTOS MATERIAL RECORDS ********************");
		log.info("******************** DELETE ALL THE NEWLY CREATED ASBESTOS MATERIAL RECORDS ********************");

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
			System.out.println("Clicked on the Environmental Records option.");
			ngDriver.waitForAngularRequestsToFinish();

			// wait for the element
			Thread.sleep(5000);

			// click on the Primary Hazardous Substance
			click("envrecords_primaryhazardoussubstance_XPATH");
			System.out.println("Clicked on the Primary Hazardous Substance option");
			ngDriver.waitForAngularRequestsToFinish();

			// wait for the element
			Thread.sleep(5000);

			// click on the asbestos materials
			click("envreports_asbestosmaterials_XPATH");
			System.out.println("Clicked on the Asbestos Materials option.");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Navigate to the Asbestos Meteria Records Screen.");

			// collect all the report

			List<WebElement> recordList11 = driver
					.findElements(By.xpath(OR.getProperty("envreport_totalreports_XPATH")));
			int recordCount11 = recordList11.size();

			System.out.println("reportCount11:::::::::::::::::::" + recordCount11);

			for (int i = 1; i <= recordCount11; i++) {

				List<WebElement> recordList1 = driver
						.findElements(By.xpath(OR.getProperty("envreport_totalreports_XPATH")));
				int maxProducts = recordList1.size();
				Random random = new Random();
				int randomProduct = random.nextInt(maxProducts);
				recordList1.get(randomProduct).click();
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the environmental report.");

				// wait for the element
				explicitWaitClickable("envreports_asbestosmaterials_deletebtn_CSS");

				// click on the delete button
				click("envreports_asbestosmaterials_deletebtn_CSS");
				System.out.println("Clicked on the Delete Button.");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("The confirmation pop up model is displayed.");

				// wait for the element
				explicitWaitClickable("envreports_asbestosmaterials_modeldeletebtn_CSS");

				// click on the delete button of the confirmation model
				click("envreports_asbestosmaterials_modeldeletebtn_CSS");
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

		// CREATE BUILDING, FLOOR, AND ROOM IN THE PROPERTY

		System.out
				.println("******************** CREATE BUILDING, FLOOR, AND ROOM IN THE PROPERTY ********************");
		test.log(LogStatus.INFO,
				"******************** CREATE BUILDING, FLOOR, AND ROOM IN THE PROPERTY ********************");
		Reporter.log("******************** CREATE BUILDING, FLOOR, AND ROOM IN THE PROPERTY ********************");
		log.info("******************** CREATE BUILDING, FLOOR, AND ROOM IN THE PROPERTY ********************");

		try {

			// enter the property name in the search field
			clear("envreports_propertylist_filtertxt_CSS");
			type("envreports_propertylist_filtertxt_CSS", data.get("property_2"));
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
			type("propertyinfo_newbuilding_buildingnumbertxt_XPATH", "001");
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
			switchVerification("propertyinfo_newbuilding_createdbuildinglevel_XPATH", "Test Building Level Name",
					"The Test Building Level Name is not displayed.");

			// click on the menu button
			click("propertyinfo_menubtn_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the menu button.");

			// click on the property details option
			click("propertyinfo_menubtn_propertydetailsoption_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the property details option.");

			// ADD THE NEW FLOOR IN THE BUILDING

			System.out.println("******************** ADD THE NEW FLOOR IN THE BUILDING ********************");
			test.log(LogStatus.INFO, "******************** ADD THE NEW FLOOR IN THE BUILDING ********************");
			Reporter.log("******************** ADD THE NEW FLOOR IN THE BUILDING ********************");
			log.info("******************** ADD THE NEW FLOOR IN THE BUILDING ********************");

			// click on the menu button
			click("propertyinfo_menubtn_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the menu button.");

			// click on the building option
			click("propertyinfo_menubtn_buildingoption_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the building option.");

			// click on the newly created building
			click("propertyinfo_newbuilding_createdbuildinglevel_XPATH");
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
			switchVerification("propertyinfo_newfloor_createdfloorlevel_XPATH", "Test Floor Level Name",
					"The Test Floor Level Name is not displayed.");

			// ADD THE NEW ROOM IN THE FLOOR

			System.out.println("******************** ADD THE NEW ROOM IN THE FLOOR ********************");
			test.log(LogStatus.INFO, "******************** ADD THE NEW ROOM IN THE FLOOR ********************");
			Reporter.log("******************** ADD THE NEW ROOM IN THE FLOOR ********************");
			log.info("******************** ADD THE NEW ROOM IN THE FLOOR ********************");

			// click on the newly created floor
			click("propertyinfo_newfloor_createdfloorlevel_XPATH");
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
			switchVerification("propertyinfo_newroom_createdroomlevel_XPATH", "Test Room Level Name",
					"The Test Room Level Name is not displayed.");

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

		// CREAT THE ENVIRONMENTAL REPORT AT PROPERTY LEVEL

		System.out
				.println("******************** CREAT THE ENVIRONMENTAL REPORT AT PROPERTY LEVEL ********************");
		test.log(LogStatus.INFO,
				"******************** CREAT THE ENVIRONMENTAL REPORT AT PROPERTY LEVEL ********************");
		Reporter.log("******************** CREAT THE ENVIRONMENTAL REPORT AT PROPERTY LEVEL ********************");
		log.info("******************** CREAT THE ENVIRONMENTAL REPORT AT PROPERTY LEVEL ********************");

		try {

			// enter the property name in the search field
			type("envreports_propertylist_filtertxt_CSS", data.get("property_2"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the property name in the search field.");

			// click on the environmental icon
			click("environmentalicon_CSS");
			System.out.println("Clicked on the environmental icon.");
			ngDriver.waitForAngularRequestsToFinish();

			// wait for the element
			Thread.sleep(5000);

			// click on the side menu
			click("ssc_leftsidemenubtn_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the side menu.");

			// wait for the element
			Thread.sleep(5000);

			// click on the environmental report
			click("envreportoption_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the environmental report.");

			// select property option from the drop down
			select("propertyinfo_propertydd_XPATH", data.get("property_level"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Selected property option from the drop down.");

			helper.createEnvironmentalReport(data, data.get("type"), data.get("title_property"));

			// enter the newly created environmental report in the search field
			clear("task_listofchecklist_filterfield_CSS");
			type("task_listofchecklist_filterfield_CSS", data.get("title_property"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the newly created environmental report in the search field.");

			// verify the newly created environmental report is displayed or not
			switchVerification("environmental_searchedreport_propertylevel_XPATH",
					"Test Environmental Report Property Level",
					"The Test Environmental Report Property Level is not displayed.");

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

		// CREAT THE ENVIRONMENTAL REPORT AT BUILDING LEVEL

		System.out
				.println("******************** CREAT THE ENVIRONMENTAL REPORT AT BUILDING LEVEL ********************");
		test.log(LogStatus.INFO,
				"******************** CREAT THE ENVIRONMENTAL REPORT AT BUILDING LEVEL ********************");
		Reporter.log("******************** CREAT THE ENVIRONMENTAL REPORT AT BUILDING LEVEL ********************");
		log.info("******************** CREAT THE ENVIRONMENTAL REPORT AT BUILDING LEVEL ********************");

		try {

			// enter the property name in the search field
			type("envreports_propertylist_filtertxt_CSS", data.get("property_2"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the property name in the search field.");

			// click on the environmental icon
			click("environmentalicon_CSS");
			System.out.println("Clicked on the environmental icon.");
			ngDriver.waitForAngularRequestsToFinish();

			// wait for the element
			Thread.sleep(5000);

			// click on the side menu
			click("ssc_leftsidemenubtn_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the side menu.");

			// wait for the element
			Thread.sleep(5000);

			// click on the environmental report
			click("envreportoption_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the environmental report.");

			// select building option from the drop down
			select("propertyinfo_propertydd_XPATH", data.get("buildingName_dd"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Selected building option from the drop down.");

			// wait for 3 seconds
			Thread.sleep(3000);

			helper.createEnvironmentalReport(data, data.get("type"), data.get("title_building"));

			// enter the newly created environmental report in the search field
			clear("task_listofchecklist_filterfield_CSS");
			type("task_listofchecklist_filterfield_CSS", data.get("title_building"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the newly created environmental report in the search field.");

			// verify the newly created environmental report is displayed or not
			switchVerification("environmental_searchedreport_buildinglevel_XPATH",
					"Test Environmental Report Building Level",
					"The Test Environmental Report Building Level is not displayed.");

			// select property option from the drop down
			select("propertyinfo_propertydd_XPATH", data.get("property_level"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Selected property option from the drop down.");

			// enter the newly created environmental report in the search field
			clear("task_listofchecklist_filterfield_CSS");
			type("task_listofchecklist_filterfield_CSS", data.get("title_building"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the newly created environmental report in the search field.");

			// verify the newly created environmental report is displayed or not
			switchVerification("environmental_searchedreport_buildinglevel_XPATH",
					"Test Environmental Report Building Level",
					"The Test Environmental Report Building Level is not displayed.");

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

		// CREAT THE ENVIRONMENTAL REPORT AT FLOOR LEVEL

		System.out.println("******************** CREAT THE ENVIRONMENTAL REPORT AT FLOOR LEVEL ********************");
		test.log(LogStatus.INFO,
				"******************** CREAT THE ENVIRONMENTAL REPORT AT FLOOR LEVEL ********************");
		Reporter.log("******************** CREAT THE ENVIRONMENTAL REPORT AT FLOOR LEVEL ********************");
		log.info("******************** CREAT THE ENVIRONMENTAL REPORT AT FLOOR LEVEL ********************");

		try {

			// enter the property name in the search field
			type("envreports_propertylist_filtertxt_CSS", data.get("property_2"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the property name in the search field.");

			// click on the environmental icon
			click("environmentalicon_CSS");
			System.out.println("Clicked on the environmental icon.");
			ngDriver.waitForAngularRequestsToFinish();

			// wait for the element
			Thread.sleep(5000);

			// click on the side menu
			click("ssc_leftsidemenubtn_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the side menu.");

			// wait for the element
			Thread.sleep(5000);

			// click on the environmental report
			click("envreportoption_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the environmental report.");

			// select building option from the drop down
			select("propertyinfo_propertydd_XPATH", data.get("buildingName_dd"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Selected building option from the drop down.");

			// select floor option from the drop down
			select("propertyinfo_buildingdd_XPATH", data.get("floor_name"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Selected floor option from the drop down.");

			// wait for 3 seconds
			Thread.sleep(3000);

			helper.createEnvironmentalReport(data, data.get("type"), data.get("title_floor"));

			// enter the newly created environmental report in the search field
			clear("task_listofchecklist_filterfield_CSS");
			type("task_listofchecklist_filterfield_CSS", data.get("title_floor"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the newly created environmental report in the search field.");

			// verify the newly created environmental report is displayed or not
			switchVerification("environmental_searchedreport_floorlevel_XPATH", "Test Environmental Report Floor Level",
					"The Test Environmental Report Floor Level is not displayed.");

			// select property option from the drop down
			select("propertyinfo_propertydd_XPATH", data.get("property_level"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Selected property option from the drop down.");

			// enter the newly created environmental report in the search field
			clear("task_listofchecklist_filterfield_CSS");
			type("task_listofchecklist_filterfield_CSS", data.get("title_floor"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the newly created environmental report in the search field.");

			// verify the newly created environmental report is displayed or not
			switchVerification("environmental_searchedreport_floorlevel_XPATH", "Test Environmental Report Floor Level",
					"The Test Environmental Report Floor Level is not displayed.");

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

		// CREAT THE ENVIRONMENTAL REPORT AT ROOM LEVEL

		System.out.println("******************** CREAT THE ENVIRONMENTAL REPORT AT ROOM LEVEL ********************");
		test.log(LogStatus.INFO,
				"******************** CREAT THE ENVIRONMENTAL REPORT AT ROOM LEVEL ********************");
		Reporter.log("******************** CREAT THE ENVIRONMENTAL REPORT AT ROOM LEVEL ********************");
		log.info("******************** CREAT THE ENVIRONMENTAL REPORT AT ROOM LEVEL ********************");

		try {

			// enter the property name in the search field
			type("envreports_propertylist_filtertxt_CSS", data.get("property_2"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the property name in the search field.");

			// click on the environmental icon
			click("environmentalicon_CSS");
			System.out.println("Clicked on the environmental icon.");
			ngDriver.waitForAngularRequestsToFinish();

			// wait for the element
			Thread.sleep(5000);

			// click on the side menu
			click("ssc_leftsidemenubtn_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the side menu.");

			// wait for the element
			Thread.sleep(5000);

			// click on the environmental report
			click("envreportoption_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the environmental report.");

			// select building option from the drop down
			select("propertyinfo_propertydd_XPATH", data.get("buildingName_dd"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Selected building option from the drop down.");

			// select floor option from the drop down
			select("propertyinfo_buildingdd_XPATH", data.get("floor_name"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Selected floor option from the drop down.");

			// select room option from the drop down
			select("propertyinfo_roomdd_XPATH", data.get("room_name"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Selected room option from the drop down.");

			// wait for 3 seconds
			Thread.sleep(3000);

			helper.createEnvironmentalReport(data, data.get("type"), data.get("title_room"));

			// enter the newly created environmental report in the search field
			clear("task_listofchecklist_filterfield_CSS");
			type("task_listofchecklist_filterfield_CSS", data.get("title_room"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the newly created environmental report in the search field.");

			// verify the newly created environmental report is displayed or not
			switchVerification("environmental_searchedreport_roomlevel_XPATH", "Test Environmental Report Room Level",
					"The Test Environmental Report Room Level is not displayed.");

			// select property option from the drop down
			select("propertyinfo_propertydd_XPATH", data.get("property_level"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Selected property option from the drop down.");

			// enter the newly created environmental report in the search field
			clear("task_listofchecklist_filterfield_CSS");
			type("task_listofchecklist_filterfield_CSS", data.get("title_room"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the newly created environmental report in the search field.");

			// verify the newly created environmental report is displayed or not
			switchVerification("environmental_searchedreport_roomlevel_XPATH", "Test Environmental Report Room Level",
					"The Test Environmental Report Room Level is not displayed.");

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

		// CREATE THE NEW ASBESTOS MATERIAL RECORD AT PROPERTY LEVEL AND LINK WITH
		// ENVIRONMENTAL REPORT

		System.out.println(
				"******************** CREATE THE NEW ASBESTOS MATERIAL RECORD AT PROPERTY LEVEL AND LINK WITH ENVIRONMENTAL REPORT ********************");
		test.log(LogStatus.INFO,
				"******************** CREATE THE NEW ASBESTOS MATERIAL RECORD AT PROPERTY LEVEL AND LINK WITH ENVIRONMENTAL REPORT ********************");
		Reporter.log(
				"******************** CREATE THE NEW ASBESTOS MATERIAL RECORD AT PROPERTY LEVEL AND LINK WITH ENVIRONMENTAL REPORT ********************");
		log.info(
				"******************** CREATE THE NEW ASBESTOS MATERIAL RECORD AT PROPERTY LEVEL AND LINK WITH ENVIRONMENTAL REPORT ********************");

		try {

			// enter the property name in the search field
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
			System.out.println("Clicked on the Environmental Records option.");
			ngDriver.waitForAngularRequestsToFinish();

			// wait for the element
			Thread.sleep(3000);

			// click on the Primary Hazardous Substance
			click("envrecords_primaryhazardoussubstance_XPATH");
			System.out.println("Clicked on the Primary Hazardous Substance option");
			ngDriver.waitForAngularRequestsToFinish();

			// wait for the element
			Thread.sleep(3000);

			// click on the asbestos materials
			click("envreports_asbestosmaterials_XPATH");
			System.out.println("Clicked on the Asbestos Materials option.");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Navigate to the Asbestos Meteria Records Screen.");

			// select property option from the drop down
			select("propertyinfo_propertydd_XPATH", data.get("property_level"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Selected property option from the drop down.");

			helper.createAsbestosMaterialRecord(data, data.get("material"), data.get("detailed_location_property"),
					data.get("is_material_asbestos_containing"), data.get("asbestos_type"), data.get("condition"),
					data.get("status"));

			// enter the newly created environmental record in the search field
			clear("task_listofchecklist_filterfield_CSS");
			type("task_listofchecklist_filterfield_CSS", data.get("detailed_location_property"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the newly created environmental record in the search field.");

			// verify added detailed location of the Asbestos Materials record
			switchVerification("envreports_asbestosmaterials_detailedlocationpropertylevel_XPATH",
					"Detailed Location Property Level",
					"The Detailed Location Property Level is not displayed successfully.");

			// click on the newly created asbestos material record
			click("envreports_asbestosmaterials_detailedlocationpropertylevel_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the newly created asbestos material record.");

			// click on the linked reports tab
			click("envreports_asbestosmaterials_linkedrecordtab_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the linked reports tab.");

			// click on the new link button
			click("envreports_asbestosmaterials_newlinkbtn_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the new link button.");

			// get the count of the reports

			try {
				List<WebElement> reportListPL = driver.findElements(
						By.xpath(OR.getProperty("envreports_asbestosmaterials_linkedreport_linklist_XPATH")));
				int reportCountPL = reportListPL.size();

				if (reportCountPL == 1) {
					System.out.println("THE COUNT OF THE ENVIRONMENTAL REPORT IS DISPLAYED CORRECT.");
					test.log(LogStatus.INFO, "THE COUNT OF THE ENVIRONMENTAL REPORT IS DISPLAYED CORRECT.");
					Reporter.log("THE COUNT OF THE ENVIRONMENTAL REPORT IS DISPLAYED CORRECT.");
					log.info("THE COUNT OF THE ENVIRONMENTAL REPORT IS DISPLAYED CORRECT.");
				} else {
					verificationFailed();

					System.out.println("THE COUNT OF THE ENVIRONMENTAL REPORT IS DISPLAYED INCORRECT.");
					test.log(LogStatus.INFO, "THE COUNT OF THE ENVIRONMENTAL REPORT IS DISPLAYED INCORRECT.");
					Reporter.log("THE COUNT OF THE ENVIRONMENTAL REPORT IS DISPLAYED INCORRECT.");
					log.info("THE COUNT OF THE ENVIRONMENTAL REPORT IS DISPLAYED INCORRECT.");

				}
			} catch (Throwable t) {
				verificationFailed();

				System.out.println("THE ENVIRONMENTAL REPORT IS NOT DISPLAYED.");
				test.log(LogStatus.INFO, "THE ENVIRONMENTAL REPORT IS NOT DISPLAYED.");
				Reporter.log("THE ENVIRONMENTAL REPORT IS NOT DISPLAYED.");
				log.info("THE ENVIRONMENTAL REPORT IS NOT DISPLAYED.");
			}

			// click on the link button
			click("envreports_asbestosmaterials_propertylevel_linkbtn_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the link button.");

			// click on the update button
			click("envreportupdatebtn_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the update button.");

			// enter the newly created environmental record in the search field
			clear("task_listofchecklist_filterfield_CSS");
			type("task_listofchecklist_filterfield_CSS", data.get("detailed_location_property"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the newly created environmental record in the search field.");

			// verify added detailed location of the Asbestos Materials record
			switchVerification("envreports_asbestosmaterials_detailedlocationpropertylevel_XPATH",
					"Detailed Location Property Level",
					"The Detailed Location Property Level is not displayed successfully.");

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

		// CREATE THE NEW ASBESTOS MATERIAL RECORD AT BUILDING LEVEL AND LINK WITH
		// ENVIRONMENTAL REPORT

		System.out.println(
				"******************** CREATE THE NEW ASBESTOS MATERIAL RECORD AT BUILDING LEVEL AND LINK WITH ENVIRONMENTAL REPORT ********************");
		test.log(LogStatus.INFO,
				"******************** CREATE THE NEW ASBESTOS MATERIAL RECORD AT BUILDING LEVEL AND LINK WITH ENVIRONMENTAL REPORT ********************");
		Reporter.log(
				"******************** CREATE THE NEW ASBESTOS MATERIAL RECORD AT BUILDING LEVEL AND LINK WITH ENVIRONMENTAL REPORT ********************");
		log.info(
				"******************** CREATE THE NEW ASBESTOS MATERIAL RECORD AT BUILDING LEVEL AND LINK WITH ENVIRONMENTAL REPORT ********************");

		try {

			// enter the property name in the search field
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
			System.out.println("Clicked on the Environmental Records option.");
			ngDriver.waitForAngularRequestsToFinish();

			// wait for the element
			Thread.sleep(5000);

			// click on the Primary Hazardous Substance
			click("envrecords_primaryhazardoussubstance_XPATH");
			System.out.println("Clicked on the Primary Hazardous Substance option");
			ngDriver.waitForAngularRequestsToFinish();

			// wait for the element
			Thread.sleep(5000);

			// click on the asbestos materials
			click("envreports_asbestosmaterials_XPATH");
			System.out.println("Clicked on the Asbestos Materials option.");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Navigate to the Asbestos Meteria Records Screen.");

			// select building option from the drop down
			select("propertyinfo_propertydd_XPATH", data.get("buildingName_dd"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Selected building option from the drop down.");

			helper.createAsbestosMaterialRecord(data, data.get("material"), data.get("detailed_location_building"),
					data.get("is_material_asbestos_containing"), data.get("asbestos_type"), data.get("condition"),
					data.get("status"));

			// enter the newly created environmental record in the search field
			clear("task_listofchecklist_filterfield_CSS");
			type("task_listofchecklist_filterfield_CSS", data.get("detailed_location_building"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the newly created environmental record in the search field.");

			// verify added detailed location of the Asbestos Materials record
			switchVerification("envreports_asbestosmaterials_detailedlocationbuildinglevel_XPATH",
					"Detailed Location Building Level",
					"The Detailed Location Building Level is not displayed successfully.");

			// click on the newly created asbestos material record
			click("envreports_asbestosmaterials_detailedlocationbuildinglevel_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the newly created asbestos material record.");

			// click on the linked reports tab
			click("envreports_asbestosmaterials_linkedrecordtab_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the linked reports tab.");

			// click on the new link button
			click("envreports_asbestosmaterials_newlinkbtn_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the new link button.");

			// get the count of the reports

			try {
				List<WebElement> reportListPL = driver.findElements(
						By.xpath(OR.getProperty("envreports_asbestosmaterials_linkedreport_linklist_XPATH")));
				int reportCountPL = reportListPL.size();

				if (reportCountPL == 2) {
					System.out.println("THE COUNT OF THE ENVIRONMENTAL REPORT IS DISPLAYED CORRECT.");
					test.log(LogStatus.INFO, "THE COUNT OF THE ENVIRONMENTAL REPORT IS DISPLAYED CORRECT.");
					Reporter.log("THE COUNT OF THE ENVIRONMENTAL REPORT IS DISPLAYED CORRECT.");
					log.info("THE COUNT OF THE ENVIRONMENTAL REPORT IS DISPLAYED CORRECT.");
				} else {
					verificationFailed();

					System.out.println("THE COUNT OF THE ENVIRONMENTAL REPORT IS DISPLAYED INCORRECT.");
					test.log(LogStatus.INFO, "THE COUNT OF THE ENVIRONMENTAL REPORT IS DISPLAYED INCORRECT.");
					Reporter.log("THE COUNT OF THE ENVIRONMENTAL REPORT IS DISPLAYED INCORRECT.");
					log.info("THE COUNT OF THE ENVIRONMENTAL REPORT IS DISPLAYED INCORRECT.");

				}
			} catch (Throwable t) {
				verificationFailed();

				System.out.println("THE ENVIRONMENTAL REPORT IS NOT DISPLAYED.");
				test.log(LogStatus.INFO, "THE ENVIRONMENTAL REPORT IS NOT DISPLAYED.");
				Reporter.log("THE ENVIRONMENTAL REPORT IS NOT DISPLAYED.");
				log.info("THE ENVIRONMENTAL REPORT IS NOT DISPLAYED.");
			}

			// click on the link button
			click("envreports_asbestosmaterials_buildinglevel_linkbtn_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the link button.");

			// click on the update button
			click("envreportupdatebtn_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the update button.");

			// enter the newly created environmental record in the search field
			clear("task_listofchecklist_filterfield_CSS");
			type("task_listofchecklist_filterfield_CSS", data.get("detailed_location_building"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the newly created environmental record in the search field.");

			// verify added detailed location of the Asbestos Materials record
			switchVerification("envreports_asbestosmaterials_detailedlocationbuildinglevel_XPATH",
					"Detailed Location Building Level",
					"The Detailed Location Building Level is not displayed successfully.");

			// select property option from the drop down
			select("propertyinfo_propertydd_XPATH", data.get("property_level"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Selected property option from the drop down.");

			// enter the newly created environmental record in the search field
			clear("task_listofchecklist_filterfield_CSS");
			type("task_listofchecklist_filterfield_CSS", data.get("detailed_location_building"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the newly created environmental record in the search field.");

			// verify added detailed location of the Asbestos Materials record
			switchVerification("envreports_asbestosmaterials_detailedlocationbuildinglevel_XPATH",
					"Detailed Location Building Level",
					"The Detailed Location Building Level is not displayed successfully.");

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

		// CREATE THE NEW ASBESTOS MATERIAL RECORD AT FLOOR LEVEL AND LINK WITH
		// ENVIRONMENTAL REPORT

		System.out.println(
				"******************** CREATE THE NEW ASBESTOS MATERIAL RECORD AT FLOOR LEVEL AND LINK WITH ENVIRONMENTAL REPORT ********************");
		test.log(LogStatus.INFO,
				"******************** CREATE THE NEW ASBESTOS MATERIAL RECORD AT FLOOR LEVEL AND LINK WITH ENVIRONMENTAL REPORT ********************");
		Reporter.log(
				"******************** CREATE THE NEW ASBESTOS MATERIAL RECORD AT FLOOR LEVEL AND LINK WITH ENVIRONMENTAL REPORT ********************");
		log.info(
				"******************** CREATE THE NEW ASBESTOS MATERIAL RECORD AT FLOOR LEVEL AND LINK WITH ENVIRONMENTAL REPORT ********************");

		try {

			// enter the property name in the search field
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
			System.out.println("Clicked on the Environmental Records option.");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the Primary Hazardous Substance
			click("envrecords_primaryhazardoussubstance_XPATH");
			System.out.println("Clicked on the Primary Hazardous Substance option");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the asbestos materials
			click("envreports_asbestosmaterials_XPATH");
			System.out.println("Clicked on the Asbestos Materials option.");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Navigate to the Asbestos Meteria Records Screen.");

			// select building option from the drop down
			select("propertyinfo_propertydd_XPATH", data.get("buildingName_dd"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Selected building option from the drop down.");

			// select floor option from the drop down
			select("propertyinfo_buildingdd_XPATH", data.get("floor_name"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Selected floor option from the drop down.");

			helper.createAsbestosMaterialRecord(data, data.get("material"), data.get("detailed_location_floor"),
					data.get("is_material_asbestos_containing"), data.get("asbestos_type"), data.get("condition"),
					data.get("status"));

			// enter the newly created environmental record in the search field
			clear("task_listofchecklist_filterfield_CSS");
			type("task_listofchecklist_filterfield_CSS", data.get("detailed_location_floor"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the newly created environmental record in the search field.");

			// verify added detailed location of the Asbestos Materials record
			switchVerification("envreports_asbestosmaterials_detailedlocationfloorlevel_XPATH",
					"Detailed Location Floor Level",
					"The Detailed Location Floor Level is not displayed successfully.");

			// click on the newly created asbestos material record
			click("envreports_asbestosmaterials_detailedlocationfloorlevel_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the newly created asbestos material record.");

			// click on the linked reports tab
			click("envreports_asbestosmaterials_linkedrecordtab_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the linked reports tab.");

			// click on the new link button
			click("envreports_asbestosmaterials_newlinkbtn_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the new link button.");

			// get the count of the reports

			try {
				List<WebElement> reportListPL = driver.findElements(
						By.xpath(OR.getProperty("envreports_asbestosmaterials_linkedreport_linklist_XPATH")));
				int reportCountPL = reportListPL.size();

				if (reportCountPL == 4) {
					System.out.println("THE COUNT OF THE ENVIRONMENTAL REPORT IS DISPLAYED CORRECT.");
					test.log(LogStatus.INFO, "THE COUNT OF THE ENVIRONMENTAL REPORT IS DISPLAYED CORRECT.");
					Reporter.log("THE COUNT OF THE ENVIRONMENTAL REPORT IS DISPLAYED CORRECT.");
					log.info("THE COUNT OF THE ENVIRONMENTAL REPORT IS DISPLAYED CORRECT.");
				} else {
					verificationFailed();

					System.out.println("THE COUNT OF THE ENVIRONMENTAL REPORT IS DISPLAYED INCORRECT.");
					test.log(LogStatus.INFO, "THE COUNT OF THE ENVIRONMENTAL REPORT IS DISPLAYED INCORRECT.");
					Reporter.log("THE COUNT OF THE ENVIRONMENTAL REPORT IS DISPLAYED INCORRECT.");
					log.info("THE COUNT OF THE ENVIRONMENTAL REPORT IS DISPLAYED INCORRECT.");

				}
			} catch (Throwable t) {
				verificationFailed();

				System.out.println("THE ENVIRONMENTAL REPORT IS NOT DISPLAYED.");
				test.log(LogStatus.INFO, "THE ENVIRONMENTAL REPORT IS NOT DISPLAYED.");
				Reporter.log("THE ENVIRONMENTAL REPORT IS NOT DISPLAYED.");
				log.info("THE ENVIRONMENTAL REPORT IS NOT DISPLAYED.");
			}

			// click on the link button
			click("envreports_asbestosmaterials_floorlevel_linkbtn_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the link button.");

			// click on the update button
			click("envreportupdatebtn_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the update button.");

			// enter the newly created environmental record in the search field
			clear("task_listofchecklist_filterfield_CSS");
			type("task_listofchecklist_filterfield_CSS", data.get("detailed_location_floor"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the newly created environmental record in the search field.");

			// verify added detailed location of the Asbestos Materials record
			switchVerification("envreports_asbestosmaterials_detailedlocationfloorlevel_XPATH",
					"Detailed Location Floor Level",
					"The Detailed Location Floor Level is not displayed successfully.");

			// select property option from the drop down
			select("propertyinfo_propertydd_XPATH", data.get("property_level"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Selected property option from the drop down.");

			// enter the newly created environmental record in the search field
			clear("task_listofchecklist_filterfield_CSS");
			type("task_listofchecklist_filterfield_CSS", data.get("detailed_location_floor"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the newly created environmental record in the search field.");

			// verify added detailed location of the Asbestos Materials record
			switchVerification("envreports_asbestosmaterials_detailedlocationfloorlevel_XPATH",
					"Detailed Location Floor Level",
					"The Detailed Location Floor Level is not displayed successfully.");

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

		// CREATE THE NEW ASBESTOS MATERIAL RECORD AT ROOM LEVEL AND LINK WITH
		// ENVIRONMENTAL REPORT

		System.out.println(
				"******************** CREATE THE NEW ASBESTOS MATERIAL RECORD AT ROOM LEVEL AND LINK WITH ENVIRONMENTAL REPORT ********************");
		test.log(LogStatus.INFO,
				"******************** CREATE THE NEW ASBESTOS MATERIAL RECORD AT ROOM LEVEL AND LINK WITH ENVIRONMENTAL REPORT ********************");
		Reporter.log(
				"******************** CREATE THE NEW ASBESTOS MATERIAL RECORD AT ROOM LEVEL AND LINK WITH ENVIRONMENTAL REPORT ********************");
		log.info(
				"******************** CREATE THE NEW ASBESTOS MATERIAL RECORD AT ROOM LEVEL AND LINK WITH ENVIRONMENTAL REPORT ********************");

		try {

			// enter the property name in the search field
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
			System.out.println("Clicked on the Environmental Records option.");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the Primary Hazardous Substance
			click("envrecords_primaryhazardoussubstance_XPATH");
			System.out.println("Clicked on the Primary Hazardous Substance option");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the asbestos materials
			click("envreports_asbestosmaterials_XPATH");
			System.out.println("Clicked on the Asbestos Materials option.");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Navigate to the Asbestos Meteria Records Screen.");

			// select building option from the drop down
			select("propertyinfo_propertydd_XPATH", data.get("buildingName_dd"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Selected building option from the drop down.");

			// select floor option from the drop down
			select("propertyinfo_buildingdd_XPATH", data.get("floor_name"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Selected floor option from the drop down.");

			// select room option from the drop down
			select("propertyinfo_roomdd_XPATH", data.get("room_name"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Selected room option from the drop down.");

			helper.createAsbestosMaterialRecord(data, data.get("material"), data.get("detailed_location_room"),
					data.get("is_material_asbestos_containing"), data.get("asbestos_type"), data.get("condition"),
					data.get("status"));

			// enter the newly created environmental record in the search field
			clear("task_listofchecklist_filterfield_CSS");
			type("task_listofchecklist_filterfield_CSS", data.get("detailed_location_room"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the newly created environmental record in the search field.");

			// verify added detailed location of the Asbestos Materials record
			switchVerification("envreports_asbestosmaterials_detailedlocationroomlevel_XPATH",
					"Detailed Location Room Level", "The Detailed Location Room Level is not displayed successfully.");

			// click on the newly created asbestos material record
			click("envreports_asbestosmaterials_detailedlocationroomlevel_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the newly created asbestos material record.");

			// click on the linked reports tab
			click("envreports_asbestosmaterials_linkedrecordtab_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the linked reports tab.");

			// click on the new link button
			click("envreports_asbestosmaterials_newlinkbtn_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the new link button.");

			// get the count of the reports

			try {
				List<WebElement> reportListPL = driver.findElements(
						By.xpath(OR.getProperty("envreports_asbestosmaterials_linkedreport_linklist_XPATH")));
				int reportCountPL = reportListPL.size();

				if (reportCountPL == 4) {
					System.out.println("THE COUNT OF THE ENVIRONMENTAL REPORT IS DISPLAYED CORRECT.");
					test.log(LogStatus.INFO, "THE COUNT OF THE ENVIRONMENTAL REPORT IS DISPLAYED CORRECT.");
					Reporter.log("THE COUNT OF THE ENVIRONMENTAL REPORT IS DISPLAYED CORRECT.");
					log.info("THE COUNT OF THE ENVIRONMENTAL REPORT IS DISPLAYED CORRECT.");
				} else {
					verificationFailed();

					System.out.println("THE COUNT OF THE ENVIRONMENTAL REPORT IS DISPLAYED INCORRECT.");
					test.log(LogStatus.INFO, "THE COUNT OF THE ENVIRONMENTAL REPORT IS DISPLAYED INCORRECT.");
					Reporter.log("THE COUNT OF THE ENVIRONMENTAL REPORT IS DISPLAYED INCORRECT.");
					log.info("THE COUNT OF THE ENVIRONMENTAL REPORT IS DISPLAYED INCORRECT.");

				}
			} catch (Throwable t) {
				verificationFailed();

				System.out.println("THE ENVIRONMENTAL REPORT IS NOT DISPLAYED.");
				test.log(LogStatus.INFO, "THE ENVIRONMENTAL REPORT IS NOT DISPLAYED.");
				Reporter.log("THE ENVIRONMENTAL REPORT IS NOT DISPLAYED.");
				log.info("THE ENVIRONMENTAL REPORT IS NOT DISPLAYED.");
			}

			// click on the link button
			click("envreports_asbestosmaterials_roomlevel_linkbtn_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the link button.");

			// click on the update button
			click("envreportupdatebtn_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the update button.");

			// enter the newly created environmental record in the search field
			clear("task_listofchecklist_filterfield_CSS");
			type("task_listofchecklist_filterfield_CSS", data.get("detailed_location_room"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the newly created environmental record in the search field.");

			// verify added detailed location of the Asbestos Materials record
			switchVerification("envreports_asbestosmaterials_detailedlocationroomlevel_XPATH",
					"Detailed Location Room Level", "The Detailed Location Room Level is not displayed successfully.");

			// select property option from the drop down
			select("propertyinfo_propertydd_XPATH", data.get("property_level"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Selected property option from the drop down.");

			// enter the newly created environmental record in the search field
			clear("task_listofchecklist_filterfield_CSS");
			type("task_listofchecklist_filterfield_CSS", data.get("detailed_location_room"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the newly created environmental record in the search field.");

			// verify added detailed location of the Asbestos Materials record
			switchVerification("envreports_asbestosmaterials_detailedlocationroomlevel_XPATH",
					"Detailed Location Room Level", "The Detailed Location Room Level is not displayed successfully.");

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

		// DELETE ALL THE NEWLY CREATED ENVIRONMENTAL REPORTS

		System.out.println(
				"******************** DELETE ALL THE NEWLY CREATED ENVIRONMENTAL REPORTS ********************");
		test.log(LogStatus.INFO,
				"******************** DELETE ALL THE NEWLY CREATED ENVIRONMENTAL REPORTS ********************");
		Reporter.log("******************** DELETE ALL THE NEWLY CREATED ENVIRONMENTAL REPORTS ********************");
		log.info("******************** DELETE ALL THE NEWLY CREATED ENVIRONMENTAL REPORTS ********************");

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

			List<WebElement> reportList33 = driver
					.findElements(By.xpath(OR.getProperty("envreport_totalreports_XPATH")));
			int reportCount33 = reportList33.size();

			if (reportCount33 == 4) {
				System.out.println("THE COUNT OF THE ENVIRONMENTAL REPORTS ARE CORRECT.");
				test.log(LogStatus.INFO, "THE COUNT OF THE ENVIRONMENTAL REPORTS ARE CORRECT.");
				Reporter.log("THE COUNT OF THE ENVIRONMENTAL REPORTS ARE CORRECT.");
				log.info("THE COUNT OF THE ENVIRONMENTAL REPORTS ARE CORRECT.");
			} else {

				verificationFailed();

				System.out.println("THE COUNT OF THE ENVIRONMENTAL REPORTS ARE INCORRECT.");
				test.log(LogStatus.INFO, "THE COUNT OF THE ENVIRONMENTAL REPORTS ARE INCORRECT.");
				Reporter.log("THE COUNT OF THE ENVIRONMENTAL REPORTS ARE INCORRECT.");
				log.info("THE COUNT OF THE ENVIRONMENTAL REPORTS ARE INCORRECT.");

			}

			System.out.println("reportCount33:::::::::::::::::::" + reportCount33);

			for (int i = 1; i <= reportCount33; i++) {

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

		// DELETE ALL THE NEWLY CREATED ASBESTOS MATERIAL RECORDS

		System.out.println(
				"******************** DELETE ALL THE NEWLY CREATED ASBESTOS MATERIAL RECORDS ********************");
		test.log(LogStatus.INFO,
				"******************** DELETE ALL THE NEWLY CREATED ASBESTOS MATERIAL RECORDS ********************");
		Reporter.log(
				"******************** DELETE ALL THE NEWLY CREATED ASBESTOS MATERIAL RECORDS ********************");
		log.info("******************** DELETE ALL THE NEWLY CREATED ASBESTOS MATERIAL RECORDS ********************");

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
			System.out.println("Clicked on the Environmental Records option.");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the Primary Hazardous Substance
			click("envrecords_primaryhazardoussubstance_XPATH");
			System.out.println("Clicked on the Primary Hazardous Substance option");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the asbestos materials
			click("envreports_asbestosmaterials_XPATH");
			System.out.println("Clicked on the Asbestos Materials option.");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Navigate to the Asbestos Meteria Records Screen.");

			// collect all the report

			List<WebElement> recordList11 = driver
					.findElements(By.xpath(OR.getProperty("envreport_totalreports_XPATH")));
			int recordCount11 = recordList11.size();

			if (recordCount11 == 4) {
				System.out.println("THE COUNT OF THE ENVIRONMENTAL RECORDS ARE CORRECT.");
				test.log(LogStatus.INFO, "THE COUNT OF THE ENVIRONMENTAL RECORDS ARE CORRECT.");
				Reporter.log("THE COUNT OF THE ENVIRONMENTAL RECORDS ARE CORRECT.");
				log.info("THE COUNT OF THE ENVIRONMENTAL RECORDS ARE CORRECT.");
			} else {

				verificationFailed();

				System.out.println("THE COUNT OF THE ENVIRONMENTAL RECORDS ARE INCORRECT.");
				test.log(LogStatus.INFO, "THE COUNT OF THE ENVIRONMENTAL RECORDS ARE INCORRECT.");
				Reporter.log("THE COUNT OF THE ENVIRONMENTAL RECORDS ARE INCORRECT.");
				log.info("THE COUNT OF THE ENVIRONMENTAL RECORDS ARE INCORRECT.");

			}

			System.out.println("reportCount11:::::::::::::::::::" + recordCount11);

			for (int i = 1; i <= recordCount11; i++) {

				List<WebElement> recordList1 = driver
						.findElements(By.xpath(OR.getProperty("envreport_totalreports_XPATH")));
				int maxProducts = recordList1.size();
				Random random = new Random();
				int randomProduct = random.nextInt(maxProducts);
				recordList1.get(randomProduct).click();
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the environmental report.");

				// wait for the element
				explicitWaitClickable("envreports_asbestosmaterials_deletebtn_CSS");

				// click on the delete button
				click("envreports_asbestosmaterials_deletebtn_CSS");
				System.out.println("Clicked on the Delete Button.");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("The confirmation pop up model is displayed.");

				// wait for the element
				explicitWaitClickable("envreports_asbestosmaterials_modeldeletebtn_CSS");

				// click on the delete button of the confirmation model
				click("envreports_asbestosmaterials_modeldeletebtn_CSS");
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

		// DELETE BUILDING, FLOOR, AND ROOM IN THE PROPERTY

		System.out
				.println("******************** DELETE BUILDING, FLOOR, AND ROOM IN THE PROPERTY ********************");
		test.log(LogStatus.INFO,
				"******************** DELETE BUILDING, FLOOR, AND ROOM IN THE PROPERTY ********************");
		Reporter.log("******************** DELETE BUILDING, FLOOR, AND ROOM IN THE PROPERTY ********************");
		log.info("******************** DELETE BUILDING, FLOOR, AND ROOM IN THE PROPERTY ********************");

		try {

			// enter the property name in the search field
			clear("envreports_propertylist_filtertxt_CSS");
			type("envreports_propertylist_filtertxt_CSS", data.get("property_2"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the property name in the search field.");

			// click on the property information
			click("propertyinformationicon_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the property information.");

			// DELETE THE NEW BUILDING IN THE PROPERTY

			System.out.println("******************** DELETE THE NEW BUILDING IN THE PROPERTY ********************");
			test.log(LogStatus.INFO,
					"******************** DELETE THE NEW BUILDING IN THE PROPERTY ********************");
			Reporter.log("******************** DELETE THE NEW BUILDING IN THE PROPERTY ********************");
			log.info("******************** DELETE THE NEW BUILDING IN THE PROPERTY ********************");

			// click on the menu button
			click("propertyinfo_menubtn_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the menu button.");

			// click on the building option
			click("propertyinfo_menubtn_buildingoption_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the building option.");

			// scroll down the screen
			WebElement menubtn = driver.findElement(By.xpath(OR.getProperty("propertyinfo_menubtn_XPATH")));
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView(true);", menubtn);

			// click on the newly created building
			click("propertyinfo_newbuilding_createdbuildinglevel_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the newly created building.");

			// scroll down the screen
			WebElement menubtn1 = driver.findElement(By.xpath(OR.getProperty("propertyinfo_menubtn_XPATH")));
			js.executeScript("arguments[0].scrollIntoView(true);", menubtn1);

			// click on the delete building button
			click("propertyinfo_newbuilding_deletebtn_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the delete building button.");

			// wait for the element
			Thread.sleep(3000);

			// click on the delete building button of confirmation popup
			click("propertyinfo_newbuilding_confirmationdeletebtn_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the delete building button of confirmation popup.");

			// verify deleted building is displayed or not
			deleteVerification("propertyinfo_newbuilding_createdbuildinglevel_XPATH", "Test Building Level Name");

		} catch (Throwable t) {
			verificationFailed();

			driver.navigate().refresh();
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
