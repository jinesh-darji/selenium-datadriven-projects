package testcases.smokesuite;

import java.io.IOException;
import java.util.Hashtable;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;
import org.testng.SkipException;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import base.TestBase;
import utilities.TestUtil;

public class RR5753ClientIssue3Test extends TestBase {

	@Test(dataProviderClass = TestUtil.class, dataProvider = "dp")
	public void rR5753ClientIssue3Test(Hashtable<String, String> data) throws IOException, InterruptedException {

		if (!(TestUtil.isTestRunnable("rR5753ClientIssue3Test", excel))) {

			throw new SkipException(
					"Skipping the test " + "rR5753ClientIssue3Test".toUpperCase() + "as the Run mode is NO");
		}

		if (!data.get("runmode").equals("Y")) {

			throw new SkipException("Skipping the test case as the Run Mode for data set is NO");
		}

		// refresh the page
		driver.navigate().refresh();
		Thread.sleep(5000);
		driver.navigate().refresh();

		// PROPERTY/BUILDING FILTER - ENVIRONMENTAL REPORTS SHOULD ABLE TO FILTER ON
		// SPECIFIC BUILDING SELECTION - RR-5618

		System.out.println(
				"******************** PROPERTY/BUILDING FILTER - ENVIRONMENTAL REPORTS SHOULD ABLE TO FILTER ON SPECIFIC BUILDING SELECTION - RR-5618 ********************");
		test.log(LogStatus.INFO,
				"******************** PROPERTY/BUILDING FILTER - ENVIRONMENTAL REPORTS SHOULD ABLE TO FILTER ON SPECIFIC BUILDING SELECTION - RR-5618 ********************");
		Reporter.log(
				"******************** PROPERTY/BUILDING FILTER - ENVIRONMENTAL REPORTS SHOULD ABLE TO FILTER ON SPECIFIC BUILDING SELECTION - RR-5618 ********************");
		log.info(
				"******************** PROPERTY/BUILDING FILTER - ENVIRONMENTAL REPORTS SHOULD ABLE TO FILTER ON SPECIFIC BUILDING SELECTION - RR-5618 ********************");

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

		// CREATE NEW BUILDING, FLOOR, ROOM IN THE RESPECTIVE PROPERTY

		System.out.println(
				"******************** CREATE NEW BUILDING, FLOOR, ROOM IN THE RESPECTIVE PROPERTY ********************");
		test.log(LogStatus.INFO,
				"******************** CREATE NEW BUILDING, FLOOR, ROOM IN THE RESPECTIVE PROPERTY ********************");
		Reporter.log(
				"******************** CREATE NEW BUILDING, FLOOR, ROOM IN THE RESPECTIVE PROPERTY ********************");
		log.info(
				"******************** CREATE NEW BUILDING, FLOOR, ROOM IN THE RESPECTIVE PROPERTY ********************");

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
			switchVerification("propertyinfo_newbuilding_createdbuilding_ci3_XPATH", "Test Building Name CI3",
					"The Test Building Name CI3 is not displayed.");

			// ADD THE NEW FLOOR IN THE BUILDING

			System.out.println("******************** ADD THE NEW FLOOR IN THE BUILDING ********************");
			test.log(LogStatus.INFO, "******************** ADD THE NEW FLOOR IN THE BUILDING ********************");
			Reporter.log("******************** ADD THE NEW FLOOR IN THE BUILDING ********************");
			log.info("******************** ADD THE NEW FLOOR IN THE BUILDING ********************");

			// click on the newly created building
			click("propertyinfo_newbuilding_createdbuilding_ci3_XPATH");
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
			switchVerification("propertyinfo_newfloor_createdfloor_ci3_XPATH", "Test Floor Name CI3",
					"The Test Floor Name CI3 is not displayed.");

			// ADD THE NEW ROOM IN THE FLOOR

			System.out.println("******************** ADD THE NEW ROOM IN THE FLOOR ********************");
			test.log(LogStatus.INFO, "******************** ADD THE NEW ROOM IN THE FLOOR ********************");
			Reporter.log("******************** ADD THE NEW ROOM IN THE FLOOR ********************");
			log.info("******************** ADD THE NEW ROOM IN THE FLOOR ********************");

			// click on the newly created floor
			click("propertyinfo_newfloor_createdfloor_ci3_XPATH");
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
			switchVerification("propertyinfo_newroom_createdroom_ci3_XPATH", "Test Room Name CI3",
					"The Test Room Name CI3 is not displayed.");

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

		// ADD ENVIRONMENTAL REPORT AT PROPERTY LEVEL

		System.out.println("******************** ADD ENVIRONMENTAL REPORT AT PROPERTY LEVEL ********************");
		test.log(LogStatus.INFO,
				"******************** ADD ENVIRONMENTAL REPORT AT PROPERTY LEVEL ********************");
		Reporter.log("******************** ADD ENVIRONMENTAL REPORT AT PROPERTY LEVEL ********************");
		log.info("******************** ADD ENVIRONMENTAL REPORT AT PROPERTY LEVEL ********************");

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

			// click on the environmental reports
			click("questionnaire_option_environmentalreports_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the Environmental Reports option.");

			// select the building from the drop down
			select("propertyinfo_propertydd_XPATH", data.get("property"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Selected the building from the drop down.");

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
			clear("envreporttitletxt_CSS");
			type("envreporttitletxt_CSS", data.get("title_property"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("The data entered in the Title field.");

			// enter the company
			clear("envreportcompanytxt_CSS");
			type("envreportcompanytxt_CSS", data.get("company"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("The data entered in the Company field.");

			// enter the author
			clear("envreportauthortxt_CSS");
			type("envreportauthortxt_CSS", data.get("author"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("The data entered in the Author field.");

			// scroll down the screen
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,400)");

			// enter the description
			clear("envreportdescriptiontxt_CSS");
			type("envreportdescriptiontxt_CSS", data.get("description"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("The data entered in the Description field.");

			// click on the Add report button
			click("envreportsavebtn_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the Save Button.");

			// wait for the element
			explicitWaitClickable("closetoastmsg_CSS");

			// click on the toaster close button
			click("closetoastmsg_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the toaster close button.");

			// enter the newly created environmental report in the search field
			clear("task_listofchecklist_filterfield_CSS");
			type("task_listofchecklist_filterfield_CSS", data.get("title_property"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the newly created environmental report in the search field.");

			try {

				String propertyLevel1_XPATH = "//td[@id='68003']//following-sibling::td//span[text()='"
						+ data.get("title_property") + "']";

				boolean propertyLevel = driver.findElement(By.xpath(propertyLevel1_XPATH)).isDisplayed();

				if (propertyLevel == true) {
					System.out.println("THE NEW ENVIRONMENTAL REPORT IS CREATED AT PROPERTY LEVEL SUCCESSFULLY.");
					test.log(LogStatus.INFO, "THE NEW ENVIRONMENTAL REPORT IS CREATED AT PROPERTY LEVEL SUCCESSFULLY");
					Reporter.log("THE NEW ENVIRONMENTAL REPORT IS CREATED AT PROPERTY LEVEL SUCCESSFULLY");
					log.info("THE NEW ENVIRONMENTAL REPORT IS CREATED AT PROPERTY LEVEL SUCCESSFULLY");
				} else {

					verificationFailed();

					System.out.println("THE NEW ENVIRONMENTAL REPORT IS NOT CREATED AT PROPERTY LEVEL.");
					test.log(LogStatus.INFO, "THE NEW ENVIRONMENTAL REPORT IS NOT CREATED AT PROPERTY LEVEL.");
					Reporter.log("THE NEW ENVIRONMENTAL REPORT IS NOT CREATED AT PROPERTY LEVEL.");
					log.info("THE NEW ENVIRONMENTAL REPORT IS NOT CREATED AT PROPERTY LEVEL.");
				}
			} catch (Throwable t) {
				verificationFailed();

				System.out.println("THE NEW ENVIRONMENTAL REPORT IS NOT CREATED AT PROPERTY LEVEL.");
				test.log(LogStatus.INFO, "THE NEW ENVIRONMENTAL REPORT IS NOT CREATED AT PROPERTY LEVEL.");
				Reporter.log("THE NEW ENVIRONMENTAL REPORT IS NOT CREATED AT PROPERTY LEVEL.");
				log.info("THE NEW ENVIRONMENTAL REPORT IS NOT CREATED AT PROPERTY LEVEL.");
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

		// ADD ENVIRONMENTAL REPORT AT BUILDING LEVEL

		System.out.println("******************** ADD ENVIRONMENTAL REPORT AT BUILDING LEVEL ********************");
		test.log(LogStatus.INFO,
				"******************** ADD ENVIRONMENTAL REPORT AT BUILDING LEVEL ********************");
		Reporter.log("******************** ADD ENVIRONMENTAL REPORT AT BUILDING LEVEL ********************");
		log.info("******************** ADD ENVIRONMENTAL REPORT AT BUILDING LEVEL ********************");

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

			// click on the environmental reports
			click("questionnaire_option_environmentalreports_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the Environmental Reports option.");

			// select the building from the drop down
			select("propertyinfo_propertydd_XPATH", data.get("buildingName_dd"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Selected the building from the drop down.");

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
			clear("envreporttitletxt_CSS");
			type("envreporttitletxt_CSS", data.get("title_building"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("The data entered in the Title field.");

			// enter the company
			clear("envreportcompanytxt_CSS");
			type("envreportcompanytxt_CSS", data.get("company"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("The data entered in the Company field.");

			// enter the author
			clear("envreportauthortxt_CSS");
			type("envreportauthortxt_CSS", data.get("author"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("The data entered in the Author field.");

			// scroll down the screen
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,400)");

			// enter the description
			clear("envreportdescriptiontxt_CSS");
			type("envreportdescriptiontxt_CSS", data.get("description"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("The data entered in the Description field.");

			// click on the Add report button
			click("envreportsavebtn_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the Save Button.");

			// wait for the element
			explicitWaitClickable("closetoastmsg_CSS");

			// click on the toaster close button
			click("closetoastmsg_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the toaster close button.");

			// enter the newly created environmental report in the search field
			clear("task_listofchecklist_filterfield_CSS");
			type("task_listofchecklist_filterfield_CSS", data.get("title_building"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the newly created environmental report in the search field.");

			try {

				String buildingLevel1_XPATH = "//td[@id='" + data.get("building_name")
						+ "']//following-sibling::td//span[text()='" + data.get("title_building") + "']";

				boolean buildingLevel1 = driver.findElement(By.xpath(buildingLevel1_XPATH)).isDisplayed();

				if (buildingLevel1 == true) {
					System.out.println("THE NEW ENVIRONMENTAL REPORT IS CREATED AT BUILDING LEVEL SUCCESSFULLY.");
					test.log(LogStatus.INFO, "THE NEW ENVIRONMENTAL REPORT IS CREATED AT BUILDING LEVEL SUCCESSFULLY");
					Reporter.log("THE NEW ENVIRONMENTAL REPORT IS CREATED AT BUILDING LEVEL SUCCESSFULLY");
					log.info("THE NEW ENVIRONMENTAL REPORT IS CREATED AT BUILDING LEVEL SUCCESSFULLY");
				} else {

					verificationFailed();

					System.out.println("THE NEW ENVIRONMENTAL REPORT IS NOT CREATED AT BUILDING LEVEL.");
					test.log(LogStatus.INFO, "THE NEW ENVIRONMENTAL REPORT IS NOT CREATED AT BUILDING LEVEL.");
					Reporter.log("THE NEW ENVIRONMENTAL REPORT IS NOT CREATED AT BUILDING LEVEL.");
					log.info("THE NEW ENVIRONMENTAL REPORT IS NOT CREATED AT BUILDING LEVEL.");
				}
			} catch (Throwable t) {
				verificationFailed();

				System.out.println("THE NEW ENVIRONMENTAL REPORT IS NOT CREATED AT BUILDING LEVEL.");
				test.log(LogStatus.INFO, "THE NEW ENVIRONMENTAL REPORT IS NOT CREATED AT BUILDING LEVEL.");
				Reporter.log("THE NEW ENVIRONMENTAL REPORT IS NOT CREATED AT BUILDING LEVEL.");
				log.info("THE NEW ENVIRONMENTAL REPORT IS NOT CREATED AT BUILDING LEVEL.");
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

		// ADD ENVIRONMENTAL REPORT AT FLOOR LEVEL

		System.out.println("******************** ADD ENVIRONMENTAL REPORT AT FLOOR LEVEL ********************");
		test.log(LogStatus.INFO, "******************** ADD ENVIRONMENTAL REPORT AT FLOOR LEVEL ********************");
		Reporter.log("******************** ADD ENVIRONMENTAL REPORT AT FLOOR LEVEL ********************");
		log.info("******************** ADD ENVIRONMENTAL REPORT AT FLOOR LEVEL ********************");

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

			// click on the environmental reports
			click("questionnaire_option_environmentalreports_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the Environmental Reports option.");

			// select the building from the drop down
			select("propertyinfo_propertydd_XPATH", data.get("buildingName_dd"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Selected the building from the drop down.");

			// select the floor from the drop down
			select("propertyinfo_buildingdd_XPATH", data.get("floor_name"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Selected the floor from the drop down.");

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
			clear("envreporttitletxt_CSS");
			type("envreporttitletxt_CSS", data.get("title_floor"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("The data entered in the Title field.");

			// enter the company
			clear("envreportcompanytxt_CSS");
			type("envreportcompanytxt_CSS", data.get("company"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("The data entered in the Company field.");

			// enter the author
			clear("envreportauthortxt_CSS");
			type("envreportauthortxt_CSS", data.get("author"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("The data entered in the Author field.");

			// scroll down the screen
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,400)");

			// enter the description
			clear("envreportdescriptiontxt_CSS");
			type("envreportdescriptiontxt_CSS", data.get("description"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("The data entered in the Description field.");

			// click on the Add report button
			click("envreportsavebtn_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the Save Button.");

			// wait for the element
			explicitWaitClickable("closetoastmsg_CSS");

			// click on the toaster close button
			click("closetoastmsg_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the toaster close button.");

			// enter the newly created environmental report in the search field
			clear("task_listofchecklist_filterfield_CSS");
			type("task_listofchecklist_filterfield_CSS", data.get("title_floor"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the newly created environmental report in the search field.");

			try {

				String floorLevel1_XPATH = "//td[@id='" + data.get("building_name") + " > " + data.get("floor_name")
						+ "']//following-sibling::td//span[text()='" + data.get("title_floor") + "']";

				boolean floorLevel1 = driver.findElement(By.xpath(floorLevel1_XPATH)).isDisplayed();

				if (floorLevel1 == true) {
					System.out.println("THE NEW ENVIRONMENTAL REPORT IS CREATED AT FLOOR LEVEL SUCCESSFULLY.");
					test.log(LogStatus.INFO, "THE NEW ENVIRONMENTAL REPORT IS CREATED AT FLOOR LEVEL SUCCESSFULLY");
					Reporter.log("THE NEW ENVIRONMENTAL REPORT IS CREATED AT FLOOR LEVEL SUCCESSFULLY");
					log.info("THE NEW ENVIRONMENTAL REPORT IS CREATED AT FLOOR LEVEL SUCCESSFULLY");
				} else {

					verificationFailed();

					System.out.println("THE NEW ENVIRONMENTAL REPORT IS NOT CREATED AT FLOOR LEVEL.");
					test.log(LogStatus.INFO, "THE NEW ENVIRONMENTAL REPORT IS NOT CREATED AT FLOOR LEVEL.");
					Reporter.log("THE NEW ENVIRONMENTAL REPORT IS NOT CREATED AT FLOOR LEVEL.");
					log.info("THE NEW ENVIRONMENTAL REPORT IS NOT CREATED AT FLOOR LEVEL.");
				}
			} catch (Throwable t) {
				verificationFailed();

				System.out.println("THE NEW ENVIRONMENTAL REPORT IS NOT CREATED AT FLOOR LEVEL.");
				test.log(LogStatus.INFO, "THE NEW ENVIRONMENTAL REPORT IS NOT CREATED AT FLOOR LEVEL.");
				Reporter.log("THE NEW ENVIRONMENTAL REPORT IS NOT CREATED AT FLOOR LEVEL.");
				log.info("THE NEW ENVIRONMENTAL REPORT IS NOT CREATED AT FLOOR LEVEL.");
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

		// ADD ENVIRONMENTAL REPORT AT ROOM LEVEL

		System.out.println("******************** ADD ENVIRONMENTAL REPORT AT ROOM LEVEL ********************");
		test.log(LogStatus.INFO, "******************** ADD ENVIRONMENTAL REPORT AT ROOM LEVEL ********************");
		Reporter.log("******************** ADD ENVIRONMENTAL REPORT AT ROOM LEVEL ********************");
		log.info("******************** ADD ENVIRONMENTAL REPORT AT ROOM LEVEL ********************");

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

			// click on the environmental reports
			click("questionnaire_option_environmentalreports_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the Environmental Reports option.");

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
			clear("envreporttitletxt_CSS");
			type("envreporttitletxt_CSS", data.get("title_room"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("The data entered in the Title field.");

			// enter the company
			clear("envreportcompanytxt_CSS");
			type("envreportcompanytxt_CSS", data.get("company"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("The data entered in the Company field.");

			// enter the author
			clear("envreportauthortxt_CSS");
			type("envreportauthortxt_CSS", data.get("author"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("The data entered in the Author field.");

			// scroll down the screen
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,400)");

			// enter the description
			clear("envreportdescriptiontxt_CSS");
			type("envreportdescriptiontxt_CSS", data.get("description"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("The data entered in the Description field.");

			// click on the Add report button
			click("envreportsavebtn_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the Save Button.");

			// wait for the element
			explicitWaitClickable("closetoastmsg_CSS");

			// click on the toaster close button
			click("closetoastmsg_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the toaster close button.");

			// enter the newly created environmental report in the search field
			clear("task_listofchecklist_filterfield_CSS");
			type("task_listofchecklist_filterfield_CSS", data.get("title_room"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the newly created environmental report in the search field.");

			try {

				String roomLevel1_XPATH = "//td[@id='" + data.get("building_name") + " > " + data.get("floor_name")
						+ " > " + data.get("room_name") + "']//following-sibling::td//span[text()='"
						+ data.get("title_room") + "']";

				boolean roomLevel1 = driver.findElement(By.xpath(roomLevel1_XPATH)).isDisplayed();

				if (roomLevel1 == true) {
					System.out.println("THE NEW ENVIRONMENTAL REPORT IS CREATED AT ROOM LEVEL SUCCESSFULLY.");
					test.log(LogStatus.INFO, "THE NEW ENVIRONMENTAL REPORT IS CREATED AT ROOM LEVEL SUCCESSFULLY");
					Reporter.log("THE NEW ENVIRONMENTAL REPORT IS CREATED AT ROOM LEVEL SUCCESSFULLY");
					log.info("THE NEW ENVIRONMENTAL REPORT IS CREATED AT ROOM LEVEL SUCCESSFULLY");
				} else {

					verificationFailed();

					System.out.println("THE NEW ENVIRONMENTAL REPORT IS NOT CREATED AT ROOM LEVEL.");
					test.log(LogStatus.INFO, "THE NEW ENVIRONMENTAL REPORT IS NOT CREATED AT ROOM LEVEL.");
					Reporter.log("THE NEW ENVIRONMENTAL REPORT IS NOT CREATED AT ROOM LEVEL.");
					log.info("THE NEW ENVIRONMENTAL REPORT IS NOT CREATED AT ROOM LEVEL.");
				}
			} catch (Throwable t) {
				verificationFailed();

				System.out.println("THE NEW ENVIRONMENTAL REPORT IS NOT CREATED AT ROOM LEVEL.");
				test.log(LogStatus.INFO, "THE NEW ENVIRONMENTAL REPORT IS NOT CREATED AT ROOM LEVEL.");
				Reporter.log("THE NEW ENVIRONMENTAL REPORT IS NOT CREATED AT ROOM LEVEL.");
				log.info("THE NEW ENVIRONMENTAL REPORT IS NOT CREATED AT ROOM LEVEL.");
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

		// VERIFY ALL THE NEWLY CREATED ENVIRONMENTAL REPORT AT PROPERTY LEVEL

		System.out.println(
				"******************** VERIFY ALL THE NEWLY CREATED ENVIRONMENTAL REPORT AT PROPERTY LEVEL ********************");
		test.log(LogStatus.INFO,
				"******************** VERIFY ALL THE NEWLY CREATED ENVIRONMENTAL REPORT AT PROPERTY LEVEL ********************");
		Reporter.log(
				"******************** VERIFY ALL THE NEWLY CREATED ENVIRONMENTAL REPORT AT PROPERTY LEVEL ********************");
		log.info(
				"******************** VERIFY ALL THE NEWLY CREATED ENVIRONMENTAL REPORT AT PROPERTY LEVEL ********************");

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

			// click on the environmental reports
			click("questionnaire_option_environmentalreports_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the Environmental Reports option.");

			// enter the newly created environmental report in the search field
			clear("task_listofchecklist_filterfield_CSS");
			type("task_listofchecklist_filterfield_CSS", data.get("title_property"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the newly created environmental report in the search field.");

			// verify environmental report which was created at property level
			try {

				String propertyLevel1_XPATH = "//td[@id='68003']//following-sibling::td//span[text()='"
						+ data.get("title_property") + "']";

				boolean propertyLevel = driver.findElement(By.xpath(propertyLevel1_XPATH)).isDisplayed();

				if (propertyLevel == true) {
					System.out.println(
							"THE NEW ENVIRONMENTAL REPORT IS DISPLAYED SUCCESSFULLY, WHICH WAS CREATED AT PROPERTY LEVEL.");
					test.log(LogStatus.INFO,
							"THE NEW ENVIRONMENTAL REPORT IS DISPLAYED SUCCESSFULLY, WHICH WAS CREATED AT PROPERTY LEVEL.");
					Reporter.log(
							"THE NEW ENVIRONMENTAL REPORT IS DISPLAYED SUCCESSFULLY, WHICH WAS CREATED AT PROPERTY LEVEL.");
					log.info(
							"THE NEW ENVIRONMENTAL REPORT IS DISPLAYED SUCCESSFULLY, WHICH WAS CREATED AT PROPERTY LEVEL.");
				} else {

					verificationFailed();

					System.out.println(
							"THE NEW ENVIRONMENTAL REPORT IS NOT DISPLAYED, WHICH WAS CREATED AT PROPERTY LEVEL.");
					test.log(LogStatus.INFO,
							"THE NEW ENVIRONMENTAL REPORT IS NOT DISPLAYED, WHICH WAS CREATED AT PROPERTY LEVEL.");
					Reporter.log("THE NEW ENVIRONMENTAL REPORT IS NOT DISPLAYED, WHICH WAS CREATED AT PROPERTY LEVEL.");
					log.info("THE NEW ENVIRONMENTAL REPORT IS NOT DISPLAYED, WHICH WAS CREATED AT PROPERTY LEVEL.");
				}
			} catch (Throwable t) {
				verificationFailed();

				System.out
						.println("THE NEW ENVIRONMENTAL REPORT IS NOT DISPLAYED, WHICH WAS CREATED AT PROPERTY LEVEL.");
				test.log(LogStatus.INFO,
						"THE NEW ENVIRONMENTAL REPORT IS NOT DISPLAYED, WHICH WAS CREATED AT PROPERTY LEVEL.");
				Reporter.log("THE NEW ENVIRONMENTAL REPORT IS NOT DISPLAYED, WHICH WAS CREATED AT PROPERTY LEVEL.");
				log.info("THE NEW ENVIRONMENTAL REPORT IS NOT DISPLAYED, WHICH WAS CREATED AT PROPERTY LEVEL.");
			}

			// enter the newly created environmental report in the search field
			clear("task_listofchecklist_filterfield_CSS");
			type("task_listofchecklist_filterfield_CSS", data.get("title_building"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the newly created environmental report in the search field.");

			// verify environmental report which was created at building level
			try {

				String buildingLevel1_XPATH = "//td[@id='" + data.get("building_name")
						+ "']//following-sibling::td//span[text()='" + data.get("title_building") + "']";

				boolean buildingLevel1 = driver.findElement(By.xpath(buildingLevel1_XPATH)).isDisplayed();

				if (buildingLevel1 == true) {
					System.out.println(
							"THE NEW ENVIRONMENTAL REPORT IS DISPLAYED SUCCESSFULLY, WHICH WAS CREATED AT BUILDING LEVEL.");
					test.log(LogStatus.INFO,
							"THE NEW ENVIRONMENTAL REPORT IS DISPLAYED SUCCESSFULLY, WHICH WAS CREATED AT BUILDING LEVEL.");
					Reporter.log(
							"THE NEW ENVIRONMENTAL REPORT IS DISPLAYED SUCCESSFULLY, WHICH WAS CREATED AT BUILDING LEVEL.");
					log.info(
							"THE NEW ENVIRONMENTAL REPORT IS DISPLAYED SUCCESSFULLY, WHICH WAS CREATED AT BUILDING LEVEL.");
				} else {

					verificationFailed();

					System.out.println(
							"THE NEW ENVIRONMENTAL REPORT IS NOT DISPLAYED, WHICH WAS CREATED AT BUILDING LEVEL.");
					test.log(LogStatus.INFO,
							"THE NEW ENVIRONMENTAL REPORT IS NOT DISPLAYED, WHICH WAS CREATED AT BUILDING LEVEL.");
					Reporter.log("THE NEW ENVIRONMENTAL REPORT IS NOT DISPLAYED, WHICH WAS CREATED AT BUILDING LEVEL.");
					log.info("THE NEW ENVIRONMENTAL REPORT IS NOT DISPLAYED, WHICH WAS CREATED AT BUILDING LEVEL.");
				}
			} catch (Throwable t) {
				verificationFailed();

				System.out
						.println("THE NEW ENVIRONMENTAL REPORT IS NOT DISPLAYED, WHICH WAS CREATED AT BUILDING LEVEL.");
				test.log(LogStatus.INFO,
						"THE NEW ENVIRONMENTAL REPORT IS NOT DISPLAYED, WHICH WAS CREATED AT BUILDING LEVEL.");
				Reporter.log("THE NEW ENVIRONMENTAL REPORT IS NOT DISPLAYED, WHICH WAS CREATED AT BUILDING LEVEL.");
				log.info("THE NEW ENVIRONMENTAL REPORT IS NOT DISPLAYED, WHICH WAS CREATED AT BUILDING LEVEL.");
			}

			// enter the newly created environmental report in the search field
			clear("task_listofchecklist_filterfield_CSS");
			type("task_listofchecklist_filterfield_CSS", data.get("title_floor"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the newly created environmental report in the search field.");

			try {

				String floorLevel1_XPATH = "//td[@id='" + data.get("building_name") + " > " + data.get("floor_name")
						+ "']//following-sibling::td//span[text()='" + data.get("title_floor") + "']";

				boolean floorLevel1 = driver.findElement(By.xpath(floorLevel1_XPATH)).isDisplayed();

				if (floorLevel1 == true) {
					System.out.println(
							"THE NEW ENVIRONMENTAL REPORT IS DISPLAYED SUCCESSFULLY, WHICH WAS CREATED AT FLOOR LEVEL.");
					test.log(LogStatus.INFO,
							"THE NEW ENVIRONMENTAL REPORT IS DISPLAYED SUCCESSFULLY, WHICH WAS CREATED AT FLOOR LEVEL.");
					Reporter.log(
							"THE NEW ENVIRONMENTAL REPORT IS DISPLAYED SUCCESSFULLY, WHICH WAS CREATED AT FLOOR LEVEL.");
					log.info(
							"THE NEW ENVIRONMENTAL REPORT IS DISPLAYED SUCCESSFULLY, WHICH WAS CREATED AT FLOOR LEVEL.");
				} else {

					verificationFailed();

					System.out.println(
							"THE NEW ENVIRONMENTAL REPORT IS NOT DISPLAYED, WHICH WAS CREATED AT FLOOR LEVEL.");
					test.log(LogStatus.INFO,
							"THE NEW ENVIRONMENTAL REPORT IS NOT DISPLAYED, WHICH WAS CREATED AT FLOOR LEVEL.");
					Reporter.log("THE NEW ENVIRONMENTAL REPORT IS NOT DISPLAYED, WHICH WAS CREATED AT FLOOR LEVEL.");
					log.info("THE NEW ENVIRONMENTAL REPORT IS NOT DISPLAYED, WHICH WAS CREATED AT FLOOR LEVEL.");
				}
			} catch (Throwable t) {
				verificationFailed();

				System.out.println("THE NEW ENVIRONMENTAL REPORT IS NOT DISPLAYED, WHICH WAS CREATED AT FLOOR LEVEL.");
				test.log(LogStatus.INFO,
						"THE NEW ENVIRONMENTAL REPORT IS NOT DISPLAYED, WHICH WAS CREATED AT FLOOR LEVEL.");
				Reporter.log("THE NEW ENVIRONMENTAL REPORT IS NOT DISPLAYED, WHICH WAS CREATED AT FLOOR LEVEL.");
				log.info("THE NEW ENVIRONMENTAL REPORT IS NOT DISPLAYED, WHICH WAS CREATED AT FLOOR LEVEL.");
			}

			// enter the newly created environmental report in the search field
			clear("task_listofchecklist_filterfield_CSS");
			type("task_listofchecklist_filterfield_CSS", data.get("title_room"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the newly created environmental report in the search field.");

			try {

				String roomLevel1_XPATH = "//td[@id='" + data.get("building_name") + " > " + data.get("floor_name")
						+ " > " + data.get("room_name") + "']//following-sibling::td//span[text()='"
						+ data.get("title_room") + "']";

				boolean roomLevel1 = driver.findElement(By.xpath(roomLevel1_XPATH)).isDisplayed();

				if (roomLevel1 == true) {
					System.out.println(
							"THE NEW ENVIRONMENTAL REPORT IS DISPLAYED SUCCESSFULLY, WHICH WAS CREATED AT ROOM LEVEL.");
					test.log(LogStatus.INFO,
							"THE NEW ENVIRONMENTAL REPORT IS DISPLAYED SUCCESSFULLY, WHICH WAS CREATED AT ROOM LEVEL.");
					Reporter.log(
							"THE NEW ENVIRONMENTAL REPORT IS DISPLAYED SUCCESSFULLY, WHICH WAS CREATED AT ROOM LEVEL.");
					log.info(
							"THE NEW ENVIRONMENTAL REPORT IS DISPLAYED SUCCESSFULLY, WHICH WAS CREATED AT ROOM LEVEL.");
				} else {

					verificationFailed();

					System.out
							.println("THE NEW ENVIRONMENTAL REPORT IS NOT DISPLAYED, WHICH WAS CREATED AT ROOM LEVEL.");
					test.log(LogStatus.INFO,
							"THE NEW ENVIRONMENTAL REPORT IS NOT DISPLAYED, WHICH WAS CREATED AT ROOM LEVEL.");
					Reporter.log("THE NEW ENVIRONMENTAL REPORT IS NOT DISPLAYED, WHICH WAS CREATED AT ROOM LEVEL.");
					log.info("THE NEW ENVIRONMENTAL REPORT IS NOT DISPLAYED, WHICH WAS CREATED AT ROOM LEVEL.");
				}
			} catch (Throwable t) {
				verificationFailed();

				System.out.println("THE NEW ENVIRONMENTAL REPORT IS NOT DISPLAYED, WHICH WAS CREATED AT ROOM LEVEL.");
				test.log(LogStatus.INFO,
						"THE NEW ENVIRONMENTAL REPORT IS NOT DISPLAYED, WHICH WAS CREATED AT ROOM LEVEL.");
				Reporter.log("THE NEW ENVIRONMENTAL REPORT IS NOT DISPLAYED, WHICH WAS CREATED AT ROOM LEVEL.");
				log.info("THE NEW ENVIRONMENTAL REPORT IS NOT DISPLAYED, WHICH WAS CREATED AT ROOM LEVEL.");
			}

		} catch (Throwable t) {
			verificationFailed();
		}

		// VERIFY ALL THE NEWLY CREATED ENVIRONMENTAL REPORT AT BUILDING LEVEL

		System.out.println(
				"******************** VERIFY ALL THE NEWLY CREATED ENVIRONMENTAL REPORT AT BUILDING LEVEL ********************");
		test.log(LogStatus.INFO,
				"******************** VERIFY ALL THE NEWLY CREATED ENVIRONMENTAL REPORT AT BUILDING LEVEL ********************");
		Reporter.log(
				"******************** VERIFY ALL THE NEWLY CREATED ENVIRONMENTAL REPORT AT BUILDING LEVEL ********************");
		log.info(
				"******************** VERIFY ALL THE NEWLY CREATED ENVIRONMENTAL REPORT AT BUILDING LEVEL ********************");

		try {

			// wait for the element
			Thread.sleep(5000);

			// select the building from the drop down
			select("propertyinfo_propertydd_XPATH", data.get("buildingName_dd"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Selected the building from the drop down.");

			// enter the newly created environmental report in the search field
			clear("task_listofchecklist_filterfield_CSS");
			type("task_listofchecklist_filterfield_CSS", data.get("title_property"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the newly created environmental report in the search field.");

			// verify environmental report which was created at property level
			try {

				String propertyLevel1_XPATH = "//td[@id='68003']//following-sibling::td//span[text()='"
						+ data.get("title_property") + "']";

				boolean propertyLevel = driver.findElement(By.xpath(propertyLevel1_XPATH)).isDisplayed();

				if (propertyLevel == true) {

					verificationFailed();

					System.out
							.println("THE NEW ENVIRONMENTAL REPORT IS DISPLAYED, WHICH WAS CREATED AT PROPERTY LEVEL.");
					test.log(LogStatus.INFO,
							"THE NEW ENVIRONMENTAL REPORT IS DISPLAYED, WHICH WAS CREATED AT PROPERTY LEVEL.");
					Reporter.log("THE NEW ENVIRONMENTAL REPORT IS DISPLAYED, WHICH WAS CREATED AT PROPERTY LEVEL.");
					log.info("THE NEW ENVIRONMENTAL REPORT IS DISPLAYED, WHICH WAS CREATED AT PROPERTY LEVEL.");
				} else {

					System.out.println(
							"THE NEW ENVIRONMENTAL REPORT IS NOT DISPLAYED AS EXPECTATION, WHICH WAS CREATED AT PROPERTY LEVEL.");
					test.log(LogStatus.INFO,
							"THE NEW ENVIRONMENTAL REPORT IS NOT DISPLAYED AS EXPECTATION, WHICH WAS CREATED AT PROPERTY LEVEL.");
					Reporter.log(
							"THE NEW ENVIRONMENTAL REPORT IS NOT DISPLAYED AS EXPECTATION, WHICH WAS CREATED AT PROPERTY LEVEL.");
					log.info(
							"THE NEW ENVIRONMENTAL REPORT IS NOT DISPLAYED AS EXPECTATION, WHICH WAS CREATED AT PROPERTY LEVEL.");
				}
			} catch (Throwable t) {
				System.out.println(
						"THE NEW ENVIRONMENTAL REPORT IS NOT DISPLAYED AS EXPECTATION, WHICH WAS CREATED AT PROPERTY LEVEL.");
				test.log(LogStatus.INFO,
						"THE NEW ENVIRONMENTAL REPORT IS NOT DISPLAYED AS EXPECTATION, WHICH WAS CREATED AT PROPERTY LEVEL.");
				Reporter.log(
						"THE NEW ENVIRONMENTAL REPORT IS NOT DISPLAYED AS EXPECTATION, WHICH WAS CREATED AT PROPERTY LEVEL.");
				log.info(
						"THE NEW ENVIRONMENTAL REPORT IS NOT DISPLAYED AS EXPECTATION, WHICH WAS CREATED AT PROPERTY LEVEL.");
			}

			// enter the newly created environmental report in the search field
			clear("task_listofchecklist_filterfield_CSS");
			type("task_listofchecklist_filterfield_CSS", data.get("title_building"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the newly created environmental report in the search field.");

			// verify environmental report which was created at building level
			try {

				String buildingLevel1_XPATH = "//td[@id='" + data.get("building_name")
						+ "']//following-sibling::td//span[text()='" + data.get("title_building") + "']";

				boolean buildingLevel1 = driver.findElement(By.xpath(buildingLevel1_XPATH)).isDisplayed();

				if (buildingLevel1 == true) {
					System.out.println(
							"THE NEW ENVIRONMENTAL REPORT IS DISPLAYED SUCCESSFULLY, WHICH WAS CREATED AT BUILDING LEVEL.");
					test.log(LogStatus.INFO,
							"THE NEW ENVIRONMENTAL REPORT IS DISPLAYED SUCCESSFULLY, WHICH WAS CREATED AT BUILDING LEVEL.");
					Reporter.log(
							"THE NEW ENVIRONMENTAL REPORT IS DISPLAYED SUCCESSFULLY, WHICH WAS CREATED AT BUILDING LEVEL.");
					log.info(
							"THE NEW ENVIRONMENTAL REPORT IS DISPLAYED SUCCESSFULLY, WHICH WAS CREATED AT BUILDING LEVEL.");
				} else {

					verificationFailed();

					System.out.println(
							"THE NEW ENVIRONMENTAL REPORT IS NOT DISPLAYED, WHICH WAS CREATED AT BUILDING LEVEL.");
					test.log(LogStatus.INFO,
							"THE NEW ENVIRONMENTAL REPORT IS NOT DISPLAYED, WHICH WAS CREATED AT BUILDING LEVEL.");
					Reporter.log("THE NEW ENVIRONMENTAL REPORT IS NOT DISPLAYED, WHICH WAS CREATED AT BUILDING LEVEL.");
					log.info("THE NEW ENVIRONMENTAL REPORT IS NOT DISPLAYED, WHICH WAS CREATED AT BUILDING LEVEL.");
				}
			} catch (Throwable t) {
				verificationFailed();

				System.out
						.println("THE NEW ENVIRONMENTAL REPORT IS NOT DISPLAYED, WHICH WAS CREATED AT BUILDING LEVEL.");
				test.log(LogStatus.INFO,
						"THE NEW ENVIRONMENTAL REPORT IS NOT DISPLAYED, WHICH WAS CREATED AT BUILDING LEVEL.");
				Reporter.log("THE NEW ENVIRONMENTAL REPORT IS NOT DISPLAYED, WHICH WAS CREATED AT BUILDING LEVEL.");
				log.info("THE NEW ENVIRONMENTAL REPORT IS NOT DISPLAYED, WHICH WAS CREATED AT BUILDING LEVEL.");
			}

			// enter the newly created environmental report in the search field
			clear("task_listofchecklist_filterfield_CSS");
			type("task_listofchecklist_filterfield_CSS", data.get("title_floor"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the newly created environmental report in the search field.");

			try {

				String floorLevel1_XPATH = "//td[@id='" + data.get("building_name") + " > " + data.get("floor_name")
						+ "']//following-sibling::td//span[text()='" + data.get("title_floor") + "']";

				boolean floorLevel1 = driver.findElement(By.xpath(floorLevel1_XPATH)).isDisplayed();

				if (floorLevel1 == true) {
					System.out.println(
							"THE NEW ENVIRONMENTAL REPORT IS DISPLAYED SUCCESSFULLY, WHICH WAS CREATED AT FLOOR LEVEL.");
					test.log(LogStatus.INFO,
							"THE NEW ENVIRONMENTAL REPORT IS DISPLAYED SUCCESSFULLY, WHICH WAS CREATED AT FLOOR LEVEL.");
					Reporter.log(
							"THE NEW ENVIRONMENTAL REPORT IS DISPLAYED SUCCESSFULLY, WHICH WAS CREATED AT FLOOR LEVEL.");
					log.info(
							"THE NEW ENVIRONMENTAL REPORT IS DISPLAYED SUCCESSFULLY, WHICH WAS CREATED AT FLOOR LEVEL.");
				} else {

					verificationFailed();

					System.out.println(
							"THE NEW ENVIRONMENTAL REPORT IS NOT DISPLAYED, WHICH WAS CREATED AT FLOOR LEVEL.");
					test.log(LogStatus.INFO,
							"THE NEW ENVIRONMENTAL REPORT IS NOT DISPLAYED, WHICH WAS CREATED AT FLOOR LEVEL.");
					Reporter.log("THE NEW ENVIRONMENTAL REPORT IS NOT DISPLAYED, WHICH WAS CREATED AT FLOOR LEVEL.");
					log.info("THE NEW ENVIRONMENTAL REPORT IS NOT DISPLAYED, WHICH WAS CREATED AT FLOOR LEVEL.");
				}
			} catch (Throwable t) {
				verificationFailed();

				System.out.println("THE NEW ENVIRONMENTAL REPORT IS NOT DISPLAYED, WHICH WAS CREATED AT FLOOR LEVEL.");
				test.log(LogStatus.INFO,
						"THE NEW ENVIRONMENTAL REPORT IS NOT DISPLAYED, WHICH WAS CREATED AT FLOOR LEVEL.");
				Reporter.log("THE NEW ENVIRONMENTAL REPORT IS NOT DISPLAYED, WHICH WAS CREATED AT FLOOR LEVEL.");
				log.info("THE NEW ENVIRONMENTAL REPORT IS NOT DISPLAYED, WHICH WAS CREATED AT FLOOR LEVEL.");
			}

			// enter the newly created environmental report in the search field
			clear("task_listofchecklist_filterfield_CSS");
			type("task_listofchecklist_filterfield_CSS", data.get("title_room"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the newly created environmental report in the search field.");

			try {

				String roomLevel1_XPATH = "//td[@id='" + data.get("building_name") + " > " + data.get("floor_name")
						+ " > " + data.get("room_name") + "']//following-sibling::td//span[text()='"
						+ data.get("title_room") + "']";

				boolean roomLevel1 = driver.findElement(By.xpath(roomLevel1_XPATH)).isDisplayed();

				if (roomLevel1 == true) {
					System.out.println(
							"THE NEW ENVIRONMENTAL REPORT IS DISPLAYED SUCCESSFULLY, WHICH WAS CREATED AT ROOM LEVEL.");
					test.log(LogStatus.INFO,
							"THE NEW ENVIRONMENTAL REPORT IS DISPLAYED SUCCESSFULLY, WHICH WAS CREATED AT ROOM LEVEL.");
					Reporter.log(
							"THE NEW ENVIRONMENTAL REPORT IS DISPLAYED SUCCESSFULLY, WHICH WAS CREATED AT ROOM LEVEL.");
					log.info(
							"THE NEW ENVIRONMENTAL REPORT IS DISPLAYED SUCCESSFULLY, WHICH WAS CREATED AT ROOM LEVEL.");
				} else {

					verificationFailed();

					System.out
							.println("THE NEW ENVIRONMENTAL REPORT IS NOT DISPLAYED, WHICH WAS CREATED AT ROOM LEVEL.");
					test.log(LogStatus.INFO,
							"THE NEW ENVIRONMENTAL REPORT IS NOT DISPLAYED, WHICH WAS CREATED AT ROOM LEVEL.");
					Reporter.log("THE NEW ENVIRONMENTAL REPORT IS NOT DISPLAYED, WHICH WAS CREATED AT ROOM LEVEL.");
					log.info("THE NEW ENVIRONMENTAL REPORT IS NOT DISPLAYED, WHICH WAS CREATED AT ROOM LEVEL.");
				}
			} catch (Throwable t) {
				verificationFailed();

				System.out.println("THE NEW ENVIRONMENTAL REPORT IS NOT DISPLAYED, WHICH WAS CREATED AT ROOM LEVEL.");
				test.log(LogStatus.INFO,
						"THE NEW ENVIRONMENTAL REPORT IS NOT DISPLAYED, WHICH WAS CREATED AT ROOM LEVEL.");
				Reporter.log("THE NEW ENVIRONMENTAL REPORT IS NOT DISPLAYED, WHICH WAS CREATED AT ROOM LEVEL.");
				log.info("THE NEW ENVIRONMENTAL REPORT IS NOT DISPLAYED, WHICH WAS CREATED AT ROOM LEVEL.");
			}

		} catch (Throwable t) {
			verificationFailed();
		}

		// VERIFY ALL THE NEWLY CREATED ENVIRONMENTAL REPORT AT FLOOR LEVEL

		System.out.println(
				"******************** VERIFY ALL THE NEWLY CREATED ENVIRONMENTAL REPORT AT FLOOR LEVEL ********************");
		test.log(LogStatus.INFO,
				"******************** VERIFY ALL THE NEWLY CREATED ENVIRONMENTAL REPORT AT FLOOR LEVEL ********************");
		Reporter.log(
				"******************** VERIFY ALL THE NEWLY CREATED ENVIRONMENTAL REPORT AT FLOOR LEVEL ********************");
		log.info(
				"******************** VERIFY ALL THE NEWLY CREATED ENVIRONMENTAL REPORT AT FLOOR LEVEL ********************");

		try {

			// select the floor from the drop down
			select("propertyinfo_buildingdd_XPATH", data.get("floor_name"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Selected the floor from the drop down.");

			// enter the newly created environmental report in the search field
			clear("task_listofchecklist_filterfield_CSS");
			type("task_listofchecklist_filterfield_CSS", data.get("title_property"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the newly created environmental report in the search field.");

			// verify environmental report which was created at property level
			try {

				String propertyLevel1_XPATH = "//td[@id='68003']//following-sibling::td//span[text()='"
						+ data.get("title_property") + "']";

				boolean propertyLevel = driver.findElement(By.xpath(propertyLevel1_XPATH)).isDisplayed();

				if (propertyLevel == true) {

					verificationFailed();

					System.out
							.println("THE NEW ENVIRONMENTAL REPORT IS DISPLAYED, WHICH WAS CREATED AT PROPERTY LEVEL.");
					test.log(LogStatus.INFO,
							"THE NEW ENVIRONMENTAL REPORT IS DISPLAYED, WHICH WAS CREATED AT PROPERTY LEVEL.");
					Reporter.log("THE NEW ENVIRONMENTAL REPORT IS DISPLAYED, WHICH WAS CREATED AT PROPERTY LEVEL.");
					log.info("THE NEW ENVIRONMENTAL REPORT IS DISPLAYED, WHICH WAS CREATED AT PROPERTY LEVEL.");
				} else {

					System.out.println(
							"THE NEW ENVIRONMENTAL REPORT IS NOT DISPLAYED AS EXPECTATION, WHICH WAS CREATED AT PROPERTY LEVEL.");
					test.log(LogStatus.INFO,
							"THE NEW ENVIRONMENTAL REPORT IS NOT DISPLAYED AS EXPECTATION, WHICH WAS CREATED AT PROPERTY LEVEL.");
					Reporter.log(
							"THE NEW ENVIRONMENTAL REPORT IS NOT DISPLAYED AS EXPECTATION, WHICH WAS CREATED AT PROPERTY LEVEL.");
					log.info(
							"THE NEW ENVIRONMENTAL REPORT IS NOT DISPLAYED AS EXPECTATION, WHICH WAS CREATED AT PROPERTY LEVEL.");
				}
			} catch (Throwable t) {
				System.out.println(
						"THE NEW ENVIRONMENTAL REPORT IS NOT DISPLAYED AS EXPECTATION, WHICH WAS CREATED AT PROPERTY LEVEL.");
				test.log(LogStatus.INFO,
						"THE NEW ENVIRONMENTAL REPORT IS NOT DISPLAYED AS EXPECTATION, WHICH WAS CREATED AT PROPERTY LEVEL.");
				Reporter.log(
						"THE NEW ENVIRONMENTAL REPORT IS NOT DISPLAYED AS EXPECTATION, WHICH WAS CREATED AT PROPERTY LEVEL.");
				log.info(
						"THE NEW ENVIRONMENTAL REPORT IS NOT DISPLAYED AS EXPECTATION, WHICH WAS CREATED AT PROPERTY LEVEL.");
			}

			// enter the newly created environmental report in the search field
			clear("task_listofchecklist_filterfield_CSS");
			type("task_listofchecklist_filterfield_CSS", data.get("title_building"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the newly created environmental report in the search field.");

			// verify environmental report which was created at building level
			try {

				String buildingLevel1_XPATH = "//td[@id='" + data.get("building_name")
						+ "']//following-sibling::td//span[text()='" + data.get("title_building") + "']";

				boolean buildingLevel1 = driver.findElement(By.xpath(buildingLevel1_XPATH)).isDisplayed();

				if (buildingLevel1 == true) {
					verificationFailed();

					System.out
							.println("THE NEW ENVIRONMENTAL REPORT IS DISPLAYED, WHICH WAS CREATED AT BUILDING LEVEL.");
					test.log(LogStatus.INFO,
							"THE NEW ENVIRONMENTAL REPORT IS DISPLAYED, WHICH WAS CREATED AT BUILDING LEVEL.");
					Reporter.log("THE NEW ENVIRONMENTAL REPORT IS DISPLAYED, WHICH WAS CREATED AT BUILDING LEVEL.");
					log.info("THE NEW ENVIRONMENTAL REPORT IS DISPLAYED, WHICH WAS CREATED AT BUILDING LEVEL.");
				} else {

					System.out.println(
							"THE NEW ENVIRONMENTAL REPORT IS NOT DISPLAYED AS EXPECTATION, WHICH WAS CREATED AT BUILDING LEVEL.");
					test.log(LogStatus.INFO,
							"THE NEW ENVIRONMENTAL REPORT IS NOT DISPLAYED AS EXPECTATION, WHICH WAS CREATED AT BUILDING LEVEL.");
					Reporter.log(
							"THE NEW ENVIRONMENTAL REPORT IS NOT DISPLAYED AS EXPECTATION, WHICH WAS CREATED AT BUILDING LEVEL.");
					log.info(
							"THE NEW ENVIRONMENTAL REPORT IS NOT DISPLAYED AS EXPECTATION, WHICH WAS CREATED AT BUILDING LEVEL.");
				}
			} catch (Throwable t) {
				System.out.println(
						"THE NEW ENVIRONMENTAL REPORT IS NOT DISPLAYED AS EXPECTATION, WHICH WAS CREATED AT BUILDING LEVEL.");
				test.log(LogStatus.INFO,
						"THE NEW ENVIRONMENTAL REPORT IS NOT DISPLAYED AS EXPECTATION, WHICH WAS CREATED AT BUILDING LEVEL.");
				Reporter.log(
						"THE NEW ENVIRONMENTAL REPORT IS NOT DISPLAYED AS EXPECTATION, WHICH WAS CREATED AT BUILDING LEVEL.");
				log.info(
						"THE NEW ENVIRONMENTAL REPORT IS NOT DISPLAYED AS EXPECTATION, WHICH WAS CREATED AT BUILDING LEVEL.");
			}

			// enter the newly created environmental report in the search field
			clear("task_listofchecklist_filterfield_CSS");
			type("task_listofchecklist_filterfield_CSS", data.get("title_floor"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the newly created environmental report in the search field.");

			try {

				String floorLevel1_XPATH = "//td[@id='" + data.get("building_name") + " > " + data.get("floor_name")
						+ "']//following-sibling::td//span[text()='" + data.get("title_floor") + "']";

				boolean floorLevel1 = driver.findElement(By.xpath(floorLevel1_XPATH)).isDisplayed();

				if (floorLevel1 == true) {

					System.out.println(
							"THE NEW ENVIRONMENTAL REPORT IS DISPLAYED SUCCESSFULLY, WHICH WAS CREATED AT FLOOR LEVEL.");
					test.log(LogStatus.INFO,
							"THE NEW ENVIRONMENTAL REPORT IS DISPLAYED SUCCESSFULLY, WHICH WAS CREATED AT FLOOR LEVEL.");
					Reporter.log(
							"THE NEW ENVIRONMENTAL REPORT IS DISPLAYED SUCCESSFULLY, WHICH WAS CREATED AT FLOOR LEVEL.");
					log.info(
							"THE NEW ENVIRONMENTAL REPORT IS DISPLAYED SUCCESSFULLY, WHICH WAS CREATED AT FLOOR LEVEL.");
				} else {

					verificationFailed();

					System.out.println(
							"THE NEW ENVIRONMENTAL REPORT IS NOT DISPLAYED, WHICH WAS CREATED AT FLOOR LEVEL.");
					test.log(LogStatus.INFO,
							"THE NEW ENVIRONMENTAL REPORT IS NOT DISPLAYED, WHICH WAS CREATED AT FLOOR LEVEL.");
					Reporter.log("THE NEW ENVIRONMENTAL REPORT IS NOT DISPLAYED, WHICH WAS CREATED AT FLOOR LEVEL.");
					log.info("THE NEW ENVIRONMENTAL REPORT IS NOT DISPLAYED, WHICH WAS CREATED AT FLOOR LEVEL.");
				}
			} catch (Throwable t) {
				verificationFailed();

				System.out.println("THE NEW ENVIRONMENTAL REPORT IS NOT DISPLAYED, WHICH WAS CREATED AT FLOOR LEVEL.");
				test.log(LogStatus.INFO,
						"THE NEW ENVIRONMENTAL REPORT IS NOT DISPLAYED, WHICH WAS CREATED AT FLOOR LEVEL.");
				Reporter.log("THE NEW ENVIRONMENTAL REPORT IS NOT DISPLAYED, WHICH WAS CREATED AT FLOOR LEVEL.");
				log.info("THE NEW ENVIRONMENTAL REPORT IS NOT DISPLAYED, WHICH WAS CREATED AT FLOOR LEVEL.");
			}

			// enter the newly created environmental report in the search field
			clear("task_listofchecklist_filterfield_CSS");
			type("task_listofchecklist_filterfield_CSS", data.get("title_room"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the newly created environmental report in the search field.");

			try {

				String roomLevel1_XPATH = "//td[@id='" + data.get("building_name") + " > " + data.get("floor_name")
						+ " > " + data.get("room_name") + "']//following-sibling::td//span[text()='"
						+ data.get("title_room") + "']";

				boolean roomLevel1 = driver.findElement(By.xpath(roomLevel1_XPATH)).isDisplayed();

				if (roomLevel1 == true) {
					System.out.println(
							"THE NEW ENVIRONMENTAL REPORT IS DISPLAYED SUCCESSFULLY, WHICH WAS CREATED AT ROOM LEVEL.");
					test.log(LogStatus.INFO,
							"THE NEW ENVIRONMENTAL REPORT IS DISPLAYED SUCCESSFULLY, WHICH WAS CREATED AT ROOM LEVEL.");
					Reporter.log(
							"THE NEW ENVIRONMENTAL REPORT IS DISPLAYED SUCCESSFULLY, WHICH WAS CREATED AT ROOM LEVEL.");
					log.info(
							"THE NEW ENVIRONMENTAL REPORT IS DISPLAYED SUCCESSFULLY, WHICH WAS CREATED AT ROOM LEVEL.");
				} else {

					verificationFailed();

					System.out
							.println("THE NEW ENVIRONMENTAL REPORT IS NOT DISPLAYED, WHICH WAS CREATED AT ROOM LEVEL.");
					test.log(LogStatus.INFO,
							"THE NEW ENVIRONMENTAL REPORT IS NOT DISPLAYED, WHICH WAS CREATED AT ROOM LEVEL.");
					Reporter.log("THE NEW ENVIRONMENTAL REPORT IS NOT DISPLAYED, WHICH WAS CREATED AT ROOM LEVEL.");
					log.info("THE NEW ENVIRONMENTAL REPORT IS NOT DISPLAYED, WHICH WAS CREATED AT ROOM LEVEL.");
				}
			} catch (Throwable t) {
				verificationFailed();

				System.out.println("THE NEW ENVIRONMENTAL REPORT IS NOT DISPLAYED, WHICH WAS CREATED AT ROOM LEVEL.");
				test.log(LogStatus.INFO,
						"THE NEW ENVIRONMENTAL REPORT IS NOT DISPLAYED, WHICH WAS CREATED AT ROOM LEVEL.");
				Reporter.log("THE NEW ENVIRONMENTAL REPORT IS NOT DISPLAYED, WHICH WAS CREATED AT ROOM LEVEL.");
				log.info("THE NEW ENVIRONMENTAL REPORT IS NOT DISPLAYED, WHICH WAS CREATED AT ROOM LEVEL.");
			}

		} catch (Throwable t) {
			verificationFailed();
		}

		// VERIFY ALL THE NEWLY CREATED ENVIRONMENTAL REPORT AT ROOM LEVEL

		System.out.println(
				"******************** VERIFY ALL THE NEWLY CREATED ENVIRONMENTAL REPORT AT ROOM LEVEL ********************");
		test.log(LogStatus.INFO,
				"******************** VERIFY ALL THE NEWLY CREATED ENVIRONMENTAL REPORT AT ROOM LEVEL ********************");
		Reporter.log(
				"******************** VERIFY ALL THE NEWLY CREATED ENVIRONMENTAL REPORT AT ROOM LEVEL ********************");
		log.info(
				"******************** VERIFY ALL THE NEWLY CREATED ENVIRONMENTAL REPORT AT ROOM LEVEL ********************");

		try {

			// wait for the element
			Thread.sleep(5000);

			// select the room from the drop down
			select("propertyinfo_roomdd_XPATH", data.get("room_name"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Selected the room from the drop down.");

			// enter the newly created environmental report in the search field
			clear("task_listofchecklist_filterfield_CSS");
			type("task_listofchecklist_filterfield_CSS", data.get("title_property"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the newly created environmental report in the search field.");

			// verify environmental report which was created at property level
			try {

				String propertyLevel1_XPATH = "//td[@id='68003']//following-sibling::td//span[text()='"
						+ data.get("title_property") + "']";

				boolean propertyLevel = driver.findElement(By.xpath(propertyLevel1_XPATH)).isDisplayed();

				if (propertyLevel == true) {

					verificationFailed();

					System.out
							.println("THE NEW ENVIRONMENTAL REPORT IS DISPLAYED, WHICH WAS CREATED AT PROPERTY LEVEL.");
					test.log(LogStatus.INFO,
							"THE NEW ENVIRONMENTAL REPORT IS DISPLAYED, WHICH WAS CREATED AT PROPERTY LEVEL.");
					Reporter.log("THE NEW ENVIRONMENTAL REPORT IS DISPLAYED, WHICH WAS CREATED AT PROPERTY LEVEL.");
					log.info("THE NEW ENVIRONMENTAL REPORT IS DISPLAYED, WHICH WAS CREATED AT PROPERTY LEVEL.");
				} else {

					System.out.println(
							"THE NEW ENVIRONMENTAL REPORT IS NOT DISPLAYED AS EXPECTATION, WHICH WAS CREATED AT PROPERTY LEVEL.");
					test.log(LogStatus.INFO,
							"THE NEW ENVIRONMENTAL REPORT IS NOT DISPLAYED AS EXPECTATION, WHICH WAS CREATED AT PROPERTY LEVEL.");
					Reporter.log(
							"THE NEW ENVIRONMENTAL REPORT IS NOT DISPLAYED AS EXPECTATION, WHICH WAS CREATED AT PROPERTY LEVEL.");
					log.info(
							"THE NEW ENVIRONMENTAL REPORT IS NOT DISPLAYED AS EXPECTATION, WHICH WAS CREATED AT PROPERTY LEVEL.");
				}
			} catch (Throwable t) {
				System.out.println(
						"THE NEW ENVIRONMENTAL REPORT IS NOT DISPLAYED AS EXPECTATION, WHICH WAS CREATED AT PROPERTY LEVEL.");
				test.log(LogStatus.INFO,
						"THE NEW ENVIRONMENTAL REPORT IS NOT DISPLAYED AS EXPECTATION, WHICH WAS CREATED AT PROPERTY LEVEL.");
				Reporter.log(
						"THE NEW ENVIRONMENTAL REPORT IS NOT DISPLAYED AS EXPECTATION, WHICH WAS CREATED AT PROPERTY LEVEL.");
				log.info(
						"THE NEW ENVIRONMENTAL REPORT IS NOT DISPLAYED AS EXPECTATION, WHICH WAS CREATED AT PROPERTY LEVEL.");
			}

			// enter the newly created environmental report in the search field
			clear("task_listofchecklist_filterfield_CSS");
			type("task_listofchecklist_filterfield_CSS", data.get("title_building"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the newly created environmental report in the search field.");

			// verify environmental report which was created at building level
			try {

				String buildingLevel1_XPATH = "//td[@id='" + data.get("building_name")
						+ "']//following-sibling::td//span[text()='" + data.get("title_building") + "']";

				boolean buildingLevel1 = driver.findElement(By.xpath(buildingLevel1_XPATH)).isDisplayed();

				if (buildingLevel1 == true) {
					verificationFailed();

					System.out
							.println("THE NEW ENVIRONMENTAL REPORT IS DISPLAYED, WHICH WAS CREATED AT BUILDING LEVEL.");
					test.log(LogStatus.INFO,
							"THE NEW ENVIRONMENTAL REPORT IS DISPLAYED, WHICH WAS CREATED AT BUILDING LEVEL.");
					Reporter.log("THE NEW ENVIRONMENTAL REPORT IS DISPLAYED, WHICH WAS CREATED AT BUILDING LEVEL.");
					log.info("THE NEW ENVIRONMENTAL REPORT IS DISPLAYED, WHICH WAS CREATED AT BUILDING LEVEL.");
				} else {

					System.out.println(
							"THE NEW ENVIRONMENTAL REPORT IS NOT DISPLAYED AS EXPECTATION, WHICH WAS CREATED AT BUILDING LEVEL.");
					test.log(LogStatus.INFO,
							"THE NEW ENVIRONMENTAL REPORT IS NOT DISPLAYED AS EXPECTATION, WHICH WAS CREATED AT BUILDING LEVEL.");
					Reporter.log(
							"THE NEW ENVIRONMENTAL REPORT IS NOT DISPLAYED AS EXPECTATION, WHICH WAS CREATED AT BUILDING LEVEL.");
					log.info(
							"THE NEW ENVIRONMENTAL REPORT IS NOT DISPLAYED AS EXPECTATION, WHICH WAS CREATED AT BUILDING LEVEL.");
				}
			} catch (Throwable t) {
				System.out.println(
						"THE NEW ENVIRONMENTAL REPORT IS NOT DISPLAYED AS EXPECTATION, WHICH WAS CREATED AT BUILDING LEVEL.");
				test.log(LogStatus.INFO,
						"THE NEW ENVIRONMENTAL REPORT IS NOT DISPLAYED AS EXPECTATION, WHICH WAS CREATED AT BUILDING LEVEL.");
				Reporter.log(
						"THE NEW ENVIRONMENTAL REPORT IS NOT DISPLAYED AS EXPECTATION, WHICH WAS CREATED AT BUILDING LEVEL.");
				log.info(
						"THE NEW ENVIRONMENTAL REPORT IS NOT DISPLAYED AS EXPECTATION, WHICH WAS CREATED AT BUILDING LEVEL.");
			}

			// enter the newly created environmental report in the search field
			clear("task_listofchecklist_filterfield_CSS");
			type("task_listofchecklist_filterfield_CSS", data.get("title_floor"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the newly created environmental report in the search field.");

			try {

				String floorLevel1_XPATH = "//td[@id='" + data.get("building_name") + " > " + data.get("floor_name")
						+ "']//following-sibling::td//span[text()='" + data.get("title_floor") + "']";

				boolean floorLevel1 = driver.findElement(By.xpath(floorLevel1_XPATH)).isDisplayed();

				if (floorLevel1 == true) {

					verificationFailed();

					System.out.println("THE NEW ENVIRONMENTAL REPORT IS DISPLAYED, WHICH WAS CREATED AT FLOOR LEVEL.");
					test.log(LogStatus.INFO,
							"THE NEW ENVIRONMENTAL REPORT IS DISPLAYED, WHICH WAS CREATED AT FLOOR LEVEL.");
					Reporter.log("THE NEW ENVIRONMENTAL REPORT IS DISPLAYED, WHICH WAS CREATED AT FLOOR LEVEL.");
					log.info("THE NEW ENVIRONMENTAL REPORT IS DISPLAYED, WHICH WAS CREATED AT FLOOR LEVEL.");
				} else {

					System.out.println(
							"THE NEW ENVIRONMENTAL REPORT IS NOT DISPLAYED AS EXPECTATION, WHICH WAS CREATED AT FLOOR LEVEL.");
					test.log(LogStatus.INFO,
							"THE NEW ENVIRONMENTAL REPORT IS NOT DISPLAYED AS EXPECTATION, WHICH WAS CREATED AT FLOOR LEVEL.");
					Reporter.log(
							"THE NEW ENVIRONMENTAL REPORT IS NOT DISPLAYED AS EXPECTATION, WHICH WAS CREATED AT FLOOR LEVEL.");
					log.info(
							"THE NEW ENVIRONMENTAL REPORT IS NOT DISPLAYED AS EXPECTATION, WHICH WAS CREATED AT FLOOR LEVEL.");
				}
			} catch (Throwable t) {
				System.out.println(
						"THE NEW ENVIRONMENTAL REPORT IS NOT DISPLAYED AS EXPECTATION, WHICH WAS CREATED AT FLOOR LEVEL.");
				test.log(LogStatus.INFO,
						"THE NEW ENVIRONMENTAL REPORT IS NOT DISPLAYED AS EXPECTATION, WHICH WAS CREATED AT FLOOR LEVEL.");
				Reporter.log(
						"THE NEW ENVIRONMENTAL REPORT IS NOT DISPLAYED AS EXPECTATION, WHICH WAS CREATED AT FLOOR LEVEL.");
				log.info(
						"THE NEW ENVIRONMENTAL REPORT IS NOT DISPLAYED AS EXPECTATION, WHICH WAS CREATED AT FLOOR LEVEL.");
			}

			// enter the newly created environmental report in the search field
			clear("task_listofchecklist_filterfield_CSS");
			type("task_listofchecklist_filterfield_CSS", data.get("title_room"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the newly created environmental report in the search field.");

			try {

				String roomLevel1_XPATH = "//td[@id='" + data.get("building_name") + " > " + data.get("floor_name")
						+ " > " + data.get("room_name") + "']//following-sibling::td//span[text()='"
						+ data.get("title_room") + "']";

				boolean roomLevel1 = driver.findElement(By.xpath(roomLevel1_XPATH)).isDisplayed();

				if (roomLevel1 == true) {
					System.out.println(
							"THE NEW ENVIRONMENTAL REPORT IS DISPLAYED SUCCESSFULLY, WHICH WAS CREATED AT ROOM LEVEL.");
					test.log(LogStatus.INFO,
							"THE NEW ENVIRONMENTAL REPORT IS DISPLAYED SUCCESSFULLY, WHICH WAS CREATED AT ROOM LEVEL.");
					Reporter.log(
							"THE NEW ENVIRONMENTAL REPORT IS DISPLAYED SUCCESSFULLY, WHICH WAS CREATED AT ROOM LEVEL.");
					log.info(
							"THE NEW ENVIRONMENTAL REPORT IS DISPLAYED SUCCESSFULLY, WHICH WAS CREATED AT ROOM LEVEL.");
				} else {

					verificationFailed();

					System.out
							.println("THE NEW ENVIRONMENTAL REPORT IS NOT DISPLAYED, WHICH WAS CREATED AT ROOM LEVEL.");
					test.log(LogStatus.INFO,
							"THE NEW ENVIRONMENTAL REPORT IS NOT DISPLAYED, WHICH WAS CREATED AT ROOM LEVEL.");
					Reporter.log("THE NEW ENVIRONMENTAL REPORT IS NOT DISPLAYED, WHICH WAS CREATED AT ROOM LEVEL.");
					log.info("THE NEW ENVIRONMENTAL REPORT IS NOT DISPLAYED, WHICH WAS CREATED AT ROOM LEVEL.");
				}
			} catch (Throwable t) {
				verificationFailed();

				System.out.println("THE NEW ENVIRONMENTAL REPORT IS NOT DISPLAYED, WHICH WAS CREATED AT ROOM LEVEL.");
				test.log(LogStatus.INFO,
						"THE NEW ENVIRONMENTAL REPORT IS NOT DISPLAYED, WHICH WAS CREATED AT ROOM LEVEL.");
				Reporter.log("THE NEW ENVIRONMENTAL REPORT IS NOT DISPLAYED, WHICH WAS CREATED AT ROOM LEVEL.");
				log.info("THE NEW ENVIRONMENTAL REPORT IS NOT DISPLAYED, WHICH WAS CREATED AT ROOM LEVEL.");
			}

		} catch (Throwable t) {
			verificationFailed();
		}

		// VERIFY ALL THE NEWLY CREATED ENVIRONMENTAL REPORT AT PROPERTY LEVEL AGAIN

		System.out.println(
				"******************** VERIFY ALL THE NEWLY CREATED ENVIRONMENTAL REPORT AT PROPERTY LEVEL AGAIN ********************");
		test.log(LogStatus.INFO,
				"******************** VERIFY ALL THE NEWLY CREATED ENVIRONMENTAL REPORT AT PROPERTY LEVEL AGAIN ********************");
		Reporter.log(
				"******************** VERIFY ALL THE NEWLY CREATED ENVIRONMENTAL REPORT AT PROPERTY LEVEL AGAIN ********************");
		log.info(
				"******************** VERIFY ALL THE NEWLY CREATED ENVIRONMENTAL REPORT AT PROPERTY LEVEL AGAIN ********************");

		try {

			// wait for the element
			Thread.sleep(5000);

			// select the property from the drop down
			select("propertyinfo_propertydd_XPATH", data.get("property"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Selected the property from the drop down.");

			// enter the newly created environmental report in the search field
			clear("task_listofchecklist_filterfield_CSS");
			type("task_listofchecklist_filterfield_CSS", data.get("title_property"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the newly created environmental report in the search field.");

			// verify environmental report which was created at property level
			try {

				String propertyLevel1_XPATH = "//td[@id='68003']//following-sibling::td//span[text()='"
						+ data.get("title_property") + "']";

				boolean propertyLevel = driver.findElement(By.xpath(propertyLevel1_XPATH)).isDisplayed();

				if (propertyLevel == true) {
					System.out.println(
							"THE NEW ENVIRONMENTAL REPORT IS DISPLAYED SUCCESSFULLY, WHICH WAS CREATED AT PROPERTY LEVEL.");
					test.log(LogStatus.INFO,
							"THE NEW ENVIRONMENTAL REPORT IS DISPLAYED SUCCESSFULLY, WHICH WAS CREATED AT PROPERTY LEVEL.");
					Reporter.log(
							"THE NEW ENVIRONMENTAL REPORT IS DISPLAYED SUCCESSFULLY, WHICH WAS CREATED AT PROPERTY LEVEL.");
					log.info(
							"THE NEW ENVIRONMENTAL REPORT IS DISPLAYED SUCCESSFULLY, WHICH WAS CREATED AT PROPERTY LEVEL.");
				} else {

					verificationFailed();

					System.out.println(
							"THE NEW ENVIRONMENTAL REPORT IS NOT DISPLAYED, WHICH WAS CREATED AT PROPERTY LEVEL.");
					test.log(LogStatus.INFO,
							"THE NEW ENVIRONMENTAL REPORT IS NOT DISPLAYED, WHICH WAS CREATED AT PROPERTY LEVEL.");
					Reporter.log("THE NEW ENVIRONMENTAL REPORT IS NOT DISPLAYED, WHICH WAS CREATED AT PROPERTY LEVEL.");
					log.info("THE NEW ENVIRONMENTAL REPORT IS NOT DISPLAYED, WHICH WAS CREATED AT PROPERTY LEVEL.");
				}
			} catch (Throwable t) {
				verificationFailed();

				System.out
						.println("THE NEW ENVIRONMENTAL REPORT IS NOT DISPLAYED, WHICH WAS CREATED AT PROPERTY LEVEL.");
				test.log(LogStatus.INFO,
						"THE NEW ENVIRONMENTAL REPORT IS NOT DISPLAYED, WHICH WAS CREATED AT PROPERTY LEVEL.");
				Reporter.log("THE NEW ENVIRONMENTAL REPORT IS NOT DISPLAYED, WHICH WAS CREATED AT PROPERTY LEVEL.");
				log.info("THE NEW ENVIRONMENTAL REPORT IS NOT DISPLAYED, WHICH WAS CREATED AT PROPERTY LEVEL.");
			}

			// enter the newly created environmental report in the search field
			clear("task_listofchecklist_filterfield_CSS");
			type("task_listofchecklist_filterfield_CSS", data.get("title_building"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the newly created environmental report in the search field.");

			// verify environmental report which was created at building level
			try {

				String buildingLevel1_XPATH = "//td[@id='" + data.get("building_name")
						+ "']//following-sibling::td//span[text()='" + data.get("title_building") + "']";

				boolean buildingLevel1 = driver.findElement(By.xpath(buildingLevel1_XPATH)).isDisplayed();

				if (buildingLevel1 == true) {
					System.out.println(
							"THE NEW ENVIRONMENTAL REPORT IS DISPLAYED SUCCESSFULLY, WHICH WAS CREATED AT BUILDING LEVEL.");
					test.log(LogStatus.INFO,
							"THE NEW ENVIRONMENTAL REPORT IS DISPLAYED SUCCESSFULLY, WHICH WAS CREATED AT BUILDING LEVEL.");
					Reporter.log(
							"THE NEW ENVIRONMENTAL REPORT IS DISPLAYED SUCCESSFULLY, WHICH WAS CREATED AT BUILDING LEVEL.");
					log.info(
							"THE NEW ENVIRONMENTAL REPORT IS DISPLAYED SUCCESSFULLY, WHICH WAS CREATED AT BUILDING LEVEL.");
				} else {

					verificationFailed();

					System.out.println(
							"THE NEW ENVIRONMENTAL REPORT IS NOT DISPLAYED, WHICH WAS CREATED AT BUILDING LEVEL.");
					test.log(LogStatus.INFO,
							"THE NEW ENVIRONMENTAL REPORT IS NOT DISPLAYED, WHICH WAS CREATED AT BUILDING LEVEL.");
					Reporter.log("THE NEW ENVIRONMENTAL REPORT IS NOT DISPLAYED, WHICH WAS CREATED AT BUILDING LEVEL.");
					log.info("THE NEW ENVIRONMENTAL REPORT IS NOT DISPLAYED, WHICH WAS CREATED AT BUILDING LEVEL.");
				}
			} catch (Throwable t) {
				verificationFailed();

				System.out
						.println("THE NEW ENVIRONMENTAL REPORT IS NOT DISPLAYED, WHICH WAS CREATED AT BUILDING LEVEL.");
				test.log(LogStatus.INFO,
						"THE NEW ENVIRONMENTAL REPORT IS NOT DISPLAYED, WHICH WAS CREATED AT BUILDING LEVEL.");
				Reporter.log("THE NEW ENVIRONMENTAL REPORT IS NOT DISPLAYED, WHICH WAS CREATED AT BUILDING LEVEL.");
				log.info("THE NEW ENVIRONMENTAL REPORT IS NOT DISPLAYED, WHICH WAS CREATED AT BUILDING LEVEL.");
			}

			// enter the newly created environmental report in the search field
			clear("task_listofchecklist_filterfield_CSS");
			type("task_listofchecklist_filterfield_CSS", data.get("title_floor"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the newly created environmental report in the search field.");

			try {

				String floorLevel1_XPATH = "//td[@id='" + data.get("building_name") + " > " + data.get("floor_name")
						+ "']//following-sibling::td//span[text()='" + data.get("title_floor") + "']";

				boolean floorLevel1 = driver.findElement(By.xpath(floorLevel1_XPATH)).isDisplayed();

				if (floorLevel1 == true) {
					System.out.println(
							"THE NEW ENVIRONMENTAL REPORT IS DISPLAYED SUCCESSFULLY, WHICH WAS CREATED AT FLOOR LEVEL.");
					test.log(LogStatus.INFO,
							"THE NEW ENVIRONMENTAL REPORT IS DISPLAYED SUCCESSFULLY, WHICH WAS CREATED AT FLOOR LEVEL.");
					Reporter.log(
							"THE NEW ENVIRONMENTAL REPORT IS DISPLAYED SUCCESSFULLY, WHICH WAS CREATED AT FLOOR LEVEL.");
					log.info(
							"THE NEW ENVIRONMENTAL REPORT IS DISPLAYED SUCCESSFULLY, WHICH WAS CREATED AT FLOOR LEVEL.");
				} else {

					verificationFailed();

					System.out.println(
							"THE NEW ENVIRONMENTAL REPORT IS NOT DISPLAYED, WHICH WAS CREATED AT FLOOR LEVEL.");
					test.log(LogStatus.INFO,
							"THE NEW ENVIRONMENTAL REPORT IS NOT DISPLAYED, WHICH WAS CREATED AT FLOOR LEVEL.");
					Reporter.log("THE NEW ENVIRONMENTAL REPORT IS NOT DISPLAYED, WHICH WAS CREATED AT FLOOR LEVEL.");
					log.info("THE NEW ENVIRONMENTAL REPORT IS NOT DISPLAYED, WHICH WAS CREATED AT FLOOR LEVEL.");
				}
			} catch (Throwable t) {
				verificationFailed();

				System.out.println("THE NEW ENVIRONMENTAL REPORT IS NOT DISPLAYED, WHICH WAS CREATED AT FLOOR LEVEL.");
				test.log(LogStatus.INFO,
						"THE NEW ENVIRONMENTAL REPORT IS NOT DISPLAYED, WHICH WAS CREATED AT FLOOR LEVEL.");
				Reporter.log("THE NEW ENVIRONMENTAL REPORT IS NOT DISPLAYED, WHICH WAS CREATED AT FLOOR LEVEL.");
				log.info("THE NEW ENVIRONMENTAL REPORT IS NOT DISPLAYED, WHICH WAS CREATED AT FLOOR LEVEL.");
			}

			// enter the newly created environmental report in the search field
			clear("task_listofchecklist_filterfield_CSS");
			type("task_listofchecklist_filterfield_CSS", data.get("title_room"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the newly created environmental report in the search field.");

			try {

				String roomLevel1_XPATH = "//td[@id='" + data.get("building_name") + " > " + data.get("floor_name")
						+ " > " + data.get("room_name") + "']//following-sibling::td//span[text()='"
						+ data.get("title_room") + "']";

				boolean roomLevel1 = driver.findElement(By.xpath(roomLevel1_XPATH)).isDisplayed();

				if (roomLevel1 == true) {
					System.out.println(
							"THE NEW ENVIRONMENTAL REPORT IS DISPLAYED SUCCESSFULLY, WHICH WAS CREATED AT ROOM LEVEL.");
					test.log(LogStatus.INFO,
							"THE NEW ENVIRONMENTAL REPORT IS DISPLAYED SUCCESSFULLY, WHICH WAS CREATED AT ROOM LEVEL.");
					Reporter.log(
							"THE NEW ENVIRONMENTAL REPORT IS DISPLAYED SUCCESSFULLY, WHICH WAS CREATED AT ROOM LEVEL.");
					log.info(
							"THE NEW ENVIRONMENTAL REPORT IS DISPLAYED SUCCESSFULLY, WHICH WAS CREATED AT ROOM LEVEL.");
				} else {

					verificationFailed();

					System.out
							.println("THE NEW ENVIRONMENTAL REPORT IS NOT DISPLAYED, WHICH WAS CREATED AT ROOM LEVEL.");
					test.log(LogStatus.INFO,
							"THE NEW ENVIRONMENTAL REPORT IS NOT DISPLAYED, WHICH WAS CREATED AT ROOM LEVEL.");
					Reporter.log("THE NEW ENVIRONMENTAL REPORT IS NOT DISPLAYED, WHICH WAS CREATED AT ROOM LEVEL.");
					log.info("THE NEW ENVIRONMENTAL REPORT IS NOT DISPLAYED, WHICH WAS CREATED AT ROOM LEVEL.");
				}
			} catch (Throwable t) {
				verificationFailed();

				System.out.println("THE NEW ENVIRONMENTAL REPORT IS NOT DISPLAYED, WHICH WAS CREATED AT ROOM LEVEL.");
				test.log(LogStatus.INFO,
						"THE NEW ENVIRONMENTAL REPORT IS NOT DISPLAYED, WHICH WAS CREATED AT ROOM LEVEL.");
				Reporter.log("THE NEW ENVIRONMENTAL REPORT IS NOT DISPLAYED, WHICH WAS CREATED AT ROOM LEVEL.");
				log.info("THE NEW ENVIRONMENTAL REPORT IS NOT DISPLAYED, WHICH WAS CREATED AT ROOM LEVEL.");
			}

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

			// click on the menu button
			click("propertyinfo_menubtn_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the menu button.");

			// click on the building option
			click("propertyinfo_menubtn_buildingoption_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the building option.");

			// click on the newly created building
			String buildingName_XPATH = "//td[text()='" + data.get("building_name") + "']";
			driver.findElement(By.xpath(buildingName_XPATH)).click();
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the newly created building.");

			// wait foe the element
			explicitWaitClickable("propertyinfo_newbuilding_deletebtn_XPATH");

			// click on the delete button
			click("propertyinfo_newbuilding_deletebtn_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the delete button.");

			// wait foe the element
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

			deleteVerification("propertyinfo_newbuilding_createdbuilding_ci3_XPATH", "Test Building Name CI3");

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

		// DELETE THE NEWLY CREATED ENVIRONMENTAL REPORT

		System.out.println("******************** DELETE THE NEWLY CREATED ENVIRONMENTAL REPORT ********************");
		test.log(LogStatus.INFO,
				"******************** DELETE THE NEWLY CREATED ENVIRONMENTAL REPORT ********************");
		Reporter.log("******************** DELETE THE NEWLY CREATED ENVIRONMENTAL REPORT ********************");
		log.info("******************** DELETE THE NEWLY CREATED ENVIRONMENTAL REPORT ********************");

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

			// click on the environmental reports
			click("questionnaire_option_environmentalreports_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the Environmental Reports option.");

			// enter the newly created environmental report in the search field
			clear("task_listofchecklist_filterfield_CSS");
			type("task_listofchecklist_filterfield_CSS", data.get("title_property"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the newly created environmental report in the search field.");

			// click on the environmental record
			String propertyLevel2_XPATH = "//td[@id='68003']//following-sibling::td//span[text()='"
					+ data.get("title_property") + "']";

			driver.findElement(By.xpath(propertyLevel2_XPATH)).click();
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the environmental record.");

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

			// verification of the environmental report is deleted or not

			// enter the newly created environmental report in the search field
			clear("task_listofchecklist_filterfield_CSS");
			type("task_listofchecklist_filterfield_CSS", data.get("title_property"));
			System.out.println("Entered the newly updated environmental report in the search field.");
			ngDriver.waitForAngularRequestsToFinish();

			try {

				String propertyLevel1_XPATH = "//td[@id='68003']//following-sibling::td//span[text()='"
						+ data.get("title_property") + "']";

				boolean propertyLevel = driver.findElement(By.xpath(propertyLevel1_XPATH)).isDisplayed();

				if (propertyLevel == true) {

					verificationFailed();

					System.out
							.println("THE NEW ENVIRONMENTAL REPORT IS DISPLAYED, WHICH WAS CREATED AT PROPERTY LEVEL.");
					test.log(LogStatus.INFO,
							"THE NEW ENVIRONMENTAL REPORT IS DISPLAYED, WHICH WAS CREATED AT PROPERTY LEVEL.");
					Reporter.log("THE NEW ENVIRONMENTAL REPORT IS DISPLAYED, WHICH WAS CREATED AT PROPERTY LEVEL.");
					log.info("THE NEW ENVIRONMENTAL REPORT IS DISPLAYED, WHICH WAS CREATED AT PROPERTY LEVEL.");
				} else {

					System.out.println(
							"THE NEW ENVIRONMENTAL REPORT IS NOT DISPLAYED AS EXPECTATION, WHICH WAS CREATED AT PROPERTY LEVEL.");
					test.log(LogStatus.INFO,
							"THE NEW ENVIRONMENTAL REPORT IS NOT DISPLAYED AS EXPECTATION, WHICH WAS CREATED AT PROPERTY LEVEL.");
					Reporter.log(
							"THE NEW ENVIRONMENTAL REPORT IS NOT DISPLAYED AS EXPECTATION, WHICH WAS CREATED AT PROPERTY LEVEL.");
					log.info(
							"THE NEW ENVIRONMENTAL REPORT IS NOT DISPLAYED AS EXPECTATION, WHICH WAS CREATED AT PROPERTY LEVEL.");
				}
			} catch (Throwable t) {
				System.out.println(
						"THE NEW ENVIRONMENTAL REPORT IS NOT DISPLAYED AS EXPECTATION, WHICH WAS CREATED AT PROPERTY LEVEL.");
				test.log(LogStatus.INFO,
						"THE NEW ENVIRONMENTAL REPORT IS NOT DISPLAYED AS EXPECTATION, WHICH WAS CREATED AT PROPERTY LEVEL.");
				Reporter.log(
						"THE NEW ENVIRONMENTAL REPORT IS NOT DISPLAYED AS EXPECTATION, WHICH WAS CREATED AT PROPERTY LEVEL.");
				log.info(
						"THE NEW ENVIRONMENTAL REPORT IS NOT DISPLAYED AS EXPECTATION, WHICH WAS CREATED AT PROPERTY LEVEL.");
			}

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
