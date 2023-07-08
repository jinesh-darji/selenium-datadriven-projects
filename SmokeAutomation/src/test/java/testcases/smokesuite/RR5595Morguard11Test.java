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

		if (!(TestUtil.isTestRunnable("rR5595Morguard11Test", excel))) {

			throw new SkipException(
					"Skipping the test " + "rR5595Morguard11Test".toUpperCase() + "as the Run mode is NO");
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

			// click on the burger menu
			click("menubtn_CSS");
			System.out.println("Clicked on the burger menu button successfully!!!");
			ngDriver.waitForAngularRequestsToFinish();

			// wait for the element
			explicitWaitClickable("envreportoption_XPATH");

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
			switchVerification("propertyinfo_newbuilding_createdbuildinglevel_morguard11_XPATH",
					"Test Building Morguard 11", "The Test Building Morguard 11 is not displayed.");

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
			click("propertyinfo_newbuilding_createdbuildinglevel_morguard11_XPATH");
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
			switchVerification("propertyinfo_newfloor_createdfloorlevel_morguard11_XPATH", "Test Floor Morguard 11",
					"The Test Floor Morguard 11 is not displayed.");

			// ADD THE NEW ROOM IN THE FLOOR

			System.out.println("******************** ADD THE NEW ROOM IN THE FLOOR ********************");
			test.log(LogStatus.INFO, "******************** ADD THE NEW ROOM IN THE FLOOR ********************");
			Reporter.log("******************** ADD THE NEW ROOM IN THE FLOOR ********************");
			log.info("******************** ADD THE NEW ROOM IN THE FLOOR ********************");

			// click on the newly created floor
			click("propertyinfo_newfloor_createdfloorlevel_morguard11_XPATH");
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
			switchVerification("propertyinfo_newroom_createdroomlevel_morguard11_XPATH", "Test Room Morguard 11",
					"The Test Room Morguard 11 is not displayed.");

		} catch (Throwable t) {
			verificationFailed();
		}

		try {
			// click on the home icon from the top of the screen
			click("questionnaire_homeburgermenubtn_hide_CSS");
			System.out.println("Clicked on the home icon from the top of the screen.");
			ngDriver.waitForAngularRequestsToFinish();

			// synchronization
			explicitWait("propertylist_title_XPATH");

			// verify the property list
			switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

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

			// LOGIN WITH ENVIRO CONSULTANT USER

			System.out.println("**************** LOGIN IN WITH ENVIRO CONSULTANT USER ****************");
			test.log(LogStatus.INFO, "**************** LOGIN IN WITH ENVIRO CONSULTANT USER ****************");
			Reporter.log("**************** LOGIN IN WITH ENVIRO CONSULTANT USER ****************");
			log.info("**************** LOGIN IN WITH ENVIRO CONSULTANT USER ****************");

			// Enter the username
			ngDriver.waitForAngularRequestsToFinish();
			type("username_MODEL", data.get("username"));

			// Enter the password
			type("password_MODEL", data.get("password"));

			// Clicking on the "Sign In" button
			click("signinbtn_BTNTEXT");
			ngDriver.waitForAngularRequestsToFinish();

			// wait for the element
			explicitWait("propertylist_title_XPATH");

			// verify the property list
			switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

			// UPDATE THE SYSTEM COMPANY
			updateCompany(data);

//			// VERIFY PROPERTY, SEARCH PROPERTY, ADMINISTRATION, TASKS, PROFILE, HELP,
//			// LOGOUT ARE VISIBLE.
//
//			System.out.println(
//					"******************** VERIFY PROPERTY, SEARCH PROPERTY, ADMINISTRATION, TASKS, PROFILE, HELP, LOGOUT ARE VISIBLE ********************");
//			test.log(LogStatus.INFO,
//					"******************** VERIFY PROPERTY, SEARCH PROPERTY, ADMINISTRATION, TASKS, PROFILE, HELP, LOGOUT ARE VISIBLE ********************");
//			Reporter.log(
//					"******************** VERIFY PROPERTY, SEARCH PROPERTY, ADMINISTRATION, TASKS, PROFILE, HELP, LOGOUT ARE VISIBLE ********************");
//			log.info(
//					"******************** VERIFY PROPERTY, SEARCH PROPERTY, ADMINISTRATION, TASKS, PROFILE, HELP, LOGOUT ARE VISIBLE ********************");
//
//			// VERIFY THE PROPERTY IS VISIBLE OR NOT
//
//			System.out.println("******************** VERIFY THE PROPERTY IS VISIBLE OR NOT ********************");
//			test.log(LogStatus.INFO, "******************** VERIFY THE PROPERTY IS VISIBLE OR NOT ********************");
//			Reporter.log("******************** VERIFY THE PROPERTY IS VISIBLE OR NOT ********************");
//			log.info("******************** VERIFY THE PROPERTY IS VISIBLE OR NOT ********************");
//
//			try {
//
//				// enter the property name in the search field
//				clear("envreports_propertylist_filtertxt_CSS");
//				type("envreports_propertylist_filtertxt_CSS", data.get("property_2"));
//				ngDriver.waitForAngularRequestsToFinish();
//				System.out.println("Entered the property name in the search field.");
//
//				// verify the respective searched property is displayed or not
//				switchVerification("administration_security_groupproperty_addedproperty_XPATH", "CAPREIT - White Frost",
//						"The CAPREIT - White Frost property is not displayed.");
//
//				System.out.println("THE PROPERTY IS VISIBLE SUCCESSFULLY");
//				test.log(LogStatus.INFO, "THE PROPERTY IS VISIBLE SUCCESSFULLY");
//				Reporter.log("THE PROPERTY IS VISIBLE SUCCESSFULLY");
//				log.info("THE PROPERTY IS VISIBLE SUCCESSFULLY");
//
//			} catch (Throwable t) {
//				verificationFailed();
//
//				System.out.println("THE PROPERTY IS NOT VISIBLE");
//				test.log(LogStatus.INFO, "THE PROPERTY IS NOT VISIBLE");
//				Reporter.log("THE PROPERTY IS NOT VISIBLE");
//				log.info("THE PROPERTY IS NOT VISIBLE");
//
//			}
//
//			// VERIFY THE SEARCH PROPERTY ICON IS VISIBLE OR NOT
//
//			System.out.println(
//					"******************** VERIFY THE SEARCH PROPERTY ICON  IS VISIBLE OR NOT ********************");
//			test.log(LogStatus.INFO,
//					"******************** VERIFY THE SEARCH PROPERTY ICON  IS VISIBLE OR NOT ********************");
//			Reporter.log(
//					"******************** VERIFY THE SEARCH PROPERTY ICON  IS VISIBLE OR NOT ********************");
//			log.info("******************** VERIFY THE SEARCH PROPERTY ICON  IS VISIBLE OR NOT ********************");
//
//			try {
//
//				boolean searchIcon = driver.findElement(By.xpath(OR.getProperty("property_searchicon_XPATH")))
//						.isDisplayed();
//
//				if (searchIcon == true) {
//
//					System.out.println("THE SEARCH PROPERTY ICON IS VISIBLE SUCCESSFULLY");
//					test.log(LogStatus.INFO, "THE SEARCH PROPERTY ICON IS VISIBLE SUCCESSFULLY");
//					Reporter.log("THE SEARCH PROPERTY ICON IS VISIBLE SUCCESSFULLY");
//					log.info("THE SEARCH PROPERTY ICON IS VISIBLE SUCCESSFULLY");
//
//				} else {
//
//					verificationFailed();
//
//					System.out.println("THE SEARCH PROPERTY ICON IS NOT VISIBLE");
//					test.log(LogStatus.INFO, "THE SEARCH PROPERTY ICON IS NOT VISIBLE");
//					Reporter.log("THE SEARCH PROPERTY ICON IS NOT VISIBLE");
//					log.info("THE SEARCH PROPERTY ICON IS NOT VISIBLE");
//				}
//
//			} catch (Throwable t) {
//				verificationFailed();
//
//				System.out.println("THE SEARCH PROPERTY ICON IS NOT VISIBLE");
//				test.log(LogStatus.INFO, "THE SEARCH PROPERTY ICON IS NOT VISIBLE");
//				Reporter.log("THE SEARCH PROPERTY ICON IS NOT VISIBLE");
//				log.info("THE SEARCH PROPERTY ICON IS NOT VISIBLE");
//
//			}
//
//			// VERIFY THE ADMINISTRATION, TASKS, PROFILE, HELP, LOGOUT OPTIONS ARE VISIBLE
//			// IN SIDE MENU OR NOT
//
//			System.out.println(
//					"******************** VERIFY THE ADMINISTRATION, TASKS, PROFILE, HELP, LOGOUT OPTIONS ARE VISIBLE IN SIDE MENU OR NOT ********************");
//			test.log(LogStatus.INFO,
//					"******************** VERIFY THE ADMINISTRATION, TASKS, PROFILE, HELP, LOGOUT OPTIONS ARE VISIBLE IN SIDE MENU OR NOT ********************");
//			Reporter.log(
//					"******************** VERIFY THE ADMINISTRATION, TASKS, PROFILE, HELP, LOGOUT OPTIONS ARE VISIBLE IN SIDE MENU OR NOT ********************");
//			log.info(
//					"******************** VERIFY THE ADMINISTRATION, TASKS, PROFILE, HELP, LOGOUT OPTIONS ARE VISIBLE IN SIDE MENU OR NOT ********************");
//
//			try {
//
//				// wait for the element
//				explicitWaitClickable("questionnaire_settingicon_CSS");
//
//				// click on the settings icon from the top of the screen
//				click("questionnaire_settingicon_CSS");
//				System.out.println("Clicked on the settings icon.");
//				ngDriver.waitForAngularRequestsToFinish();
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
//				ngDriver.waitForAngularRequestsToFinish();
//				System.out.println("Clicked on the close side menu icon.");
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
//
//			System.out.println("******************** VERIFY ENVIRONMENTAL SUMMARY IS VISIBLE ********************");
//			test.log(LogStatus.INFO,
//					"******************** VERIFY ENVIRONMENTAL SUMMARY IS VISIBLE ********************");
//			Reporter.log("******************** VERIFY ENVIRONMENTAL SUMMARY IS VISIBLE ********************");
//			log.info("******************** VERIFY ENVIRONMENTAL SUMMARY IS VISIBLE ********************");
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
//				ngDriver.waitForAngularRequestsToFinish();
//				System.out.println("Clicked on the side menu.");
//
//				// wait for the element
//				explicitWaitClickable("sidemenu_environmental_CSS");
//
//				// click on the environmental option
//				click("sidemenu_environmental_CSS");
//				ngDriver.waitForAngularRequestsToFinish();
//				System.out.println("Clicked on the environmental option.");
//
//				// select the environmental summary option from the dashboard drop down
//				select("dashboard_CSS", data.get("dashboard_dd"));
//				ngDriver.waitForAngularRequestsToFinish();
//				System.out.println("Selected the environmental summary option from the dashboard drop down.");
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
//			System.out.println("Clicked on the home icon from the top of the screen.");
//			ngDriver.waitForAngularRequestsToFinish();
//
//			// synchronization
//			explicitWait("propertylist_title_XPATH");
//
//			// verify the property list
//			switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");
//
//			// COLOURED ICONS – ENVIRONMENTAL, PROPERTY REPORTS, COMPLIANCE, REPORTS ARE
//			// VISIBLE
//
//			System.out.println(
//					"******************** COLOURED ICONS – ENVIRONMENTAL, PROPERTY REPORTS, COMPLIANCE, REPORTS ARE VISIBLE ********************");
//			test.log(LogStatus.INFO,
//					"******************** COLOURED ICONS – ENVIRONMENTAL, PROPERTY REPORTS, COMPLIANCE, REPORTS ARE VISIBLE ********************");
//			Reporter.log(
//					"******************** COLOURED ICONS – ENVIRONMENTAL, PROPERTY REPORTS, COMPLIANCE, REPORTS ARE VISIBLE ********************");
//			log.info(
//					"******************** COLOURED ICONS – ENVIRONMENTAL, PROPERTY REPORTS, COMPLIANCE, REPORTS ARE VISIBLE ********************");
//
//			try {
//
//				// click on the side menu
//				click("ssc_leftsidemenubtn_CSS");
//				ngDriver.waitForAngularRequestsToFinish();
//				System.out.println("Clicked on the side menu.");
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
//			System.out.println("Clicked on the home icon from the top of the screen.");
//			ngDriver.waitForAngularRequestsToFinish();
//
//			// synchronization
//			explicitWait("propertylist_title_XPATH");
//
//			// verify the property list
//			switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");
//
//			// VERIFY ADVANCE SEARCH FEATURE FOR THE PROPERTY
//
//			System.out.println(
//					"******************** VERIFY ADVANCE SEARCH FEATURE FOR THE PROPERTY ********************");
//			test.log(LogStatus.INFO,
//					"******************** VERIFY ADVANCE SEARCH FEATURE FOR THE PROPERTY ********************");
//			Reporter.log("******************** VERIFY ADVANCE SEARCH FEATURE FOR THE PROPERTY ********************");
//			log.info("******************** VERIFY ADVANCE SEARCH FEATURE FOR THE PROPERTY ********************");
//
//			try {
//
//				// double click on the search icon from the top
//				Actions action = new Actions(driver);
//				WebElement searchIcon = driver.findElement(By.xpath(OR.getProperty("property_searchicon_XPATH")));
//				action.doubleClick(searchIcon);
//				ngDriver.waitForAngularRequestsToFinish();
//				System.out.println("Double clicked on the search icon from the top.");
//
//				// verify advance search screen is displayed
//				switchVerification("property_searchscreen_validation1_XPATH", "Advanced Property Search",
//						"The Advanced Property Search title is not displayed.");
//
//				// enter the property number in the search field
//				type("property_searchscreen_searchtxt_XPATH", data.get("property_number_2"));
//				ngDriver.waitForAngularRequestsToFinish();
//				System.out.println("Entered the property number in the search field.");
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
//						ngDriver.waitForAngularRequestsToFinish();
//						System.out.println("Clicked on the active checkbox.");
//
//						System.out.println("THE ACTIVE CHECKBOX IS SELECTED SUCCESSFULLY.");
//						test.log(LogStatus.INFO, "THE ACTIVE CHECKBOX IS SELECTED SUCCESSFULLY.");
//						Reporter.log("THE ACTIVE CHECKBOX IS SELECTED SUCCESSFULLY.");
//						log.info("THE ACTIVE CHECKBOX IS SELECTED SUCCESSFULLY.");
//					} else {
//						System.out.println("THE ACTIVE CHECKBOX IS SELECTED SUCCESSFULLY.");
//						test.log(LogStatus.INFO, "THE ACTIVE CHECKBOX IS SELECTED SUCCESSFULLY.");
//						Reporter.log("THE ACTIVE CHECKBOX IS SELECTED SUCCESSFULLY.");
//						log.info("THE ACTIVE CHECKBOX IS SELECTED SUCCESSFULLY.");
//					}
//
//				} catch (Throwable t) {
//					System.out.println("THE ACTIVE CHECKBOX IS SELECTED SUCCESSFULLY.");
//					test.log(LogStatus.INFO, "THE ACTIVE CHECKBOX IS SELECTED SUCCESSFULLY.");
//					Reporter.log("THE ACTIVE CHECKBOX IS SELECTED SUCCESSFULLY.");
//					log.info("THE ACTIVE CHECKBOX IS SELECTED SUCCESSFULLY.");
//				}
//
//				// scroll down the screen till find property button
//				WebElement findPropertyBTN = driver
//						.findElement(By.xpath(OR.getProperty("property_searchscreen_validation7_XPATH")));
//				JavascriptExecutor js = (JavascriptExecutor) driver;
//				js.executeScript("arguments[0].scrollIntoView(true);", findPropertyBTN);
//
//				// click on the find property button
//				click("property_searchscreen_validation7_XPATH");
//				ngDriver.waitForAngularRequestsToFinish();
//				System.out.println("Clicked on the find property button.");
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
//			System.out.println("Clicked on the home icon from the top of the screen.");
//			ngDriver.waitForAngularRequestsToFinish();
//
//			// synchronization
//			explicitWait("propertylist_title_XPATH");
//
//			// verify the property list
//			switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

			// CREATE THE ENVIRONMENTAL REPORT AT PROPERTY LEVEL

			System.out.println(
					"******************** CREATE THE ENVIRONMENTAL REPORT AT PROPERTY LEVEL ********************");
			test.log(LogStatus.INFO,
					"******************** CREATE THE ENVIRONMENTAL REPORT AT PROPERTY LEVEL ********************");
			Reporter.log("******************** CREATE THE ENVIRONMENTAL REPORT AT PROPERTY LEVEL ********************");
			log.info("******************** CREATE THE ENVIRONMENTAL REPORT AT PROPERTY LEVEL ********************");

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

				helper.createEnvironmentalReport(data, data.get("type"), data.get("title_property"));

				// enter the newly created environmental report in the search field
				clear("task_listofchecklist_filterfield_CSS");
				type("task_listofchecklist_filterfield_CSS", data.get("title_property"));
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Entered the newly created environmental report in the search field.");

				// verify the newly created environmental report is displayed or not
				switchVerification("environmental_searchedreport_morguard11_XPATH",
						"Test Environmental Report Morguard 11",
						"The Test Environmental Report Morguard 11 is not displayed.");

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

			// UPDATE THE ENVIRONMENTAL REPORT AT PROPERTY LEVEL

			System.out.println(
					"******************** UPDATE THE ENVIRONMENTAL REPORT AT PROPERTY LEVEL ********************");
			test.log(LogStatus.INFO,
					"******************** UPDATE THE ENVIRONMENTAL REPORT AT PROPERTY LEVEL ********************");
			Reporter.log("******************** UPDATE THE ENVIRONMENTAL REPORT AT PROPERTY LEVEL ********************");
			log.info("******************** UPDATE THE ENVIRONMENTAL REPORT AT PROPERTY LEVEL ********************");

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

				// click on the newly created environmental report
				click("environmental_searchedreport_morguard11_XPATH");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the newly created environmental report.");

				// enter the title
				clear("envreporttitletxt_CSS");
				type("envreporttitletxt_CSS", data.get("update_title_property"));
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("The data entered in the Title field.");

				// scroll down the screen
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("window.scrollBy(0,400)");

				// click on the update report button
				click("envreportupdatebtn_CSS");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the update Button.");

				// wait for the element
				explicitWaitClickable("closetoastmsg_CSS");

				// click on the toaster close button
				click("closetoastmsg_CSS");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the toaster close button.");

				// enter the newly created environmental report in the search field
				clear("task_listofchecklist_filterfield_CSS");
				type("task_listofchecklist_filterfield_CSS", data.get("update_title_property"));
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Entered the newly created environmental report in the search field.");

				// verify the newly created environmental report is displayed or not
				switchVerification("environmental_searchedupdatedreport_morguard11_XPATH",
						"Update Test Environmental Report Morguard 11",
						"The Update Test Environmental Report Morguard 11 is not displayed.");

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
				switchVerification("propertyinfo_locationlbl_morguard11_XPATH",
						"Test Building Morguard 11 > Test Floor Morguard 11 > Test Room Morguard 11",
						"The location is not displayed successfully.");

				// select the property option from the drop down
				select("propertyinfo_propertydd_XPATH", data.get("property"));
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Selected the property from the drop down.");

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
			System.out.println("Clicked on the home icon from the top of the screen.");
			ngDriver.waitForAngularRequestsToFinish();

			// synchronization
			explicitWait("propertylist_title_XPATH");

			// verify the property list
			switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

			// UPDATE MOULD RECORD AT ROOM LEVEL AND LINK WITH THE ENVIRONMENTAL REPORT

			System.out.println(
					"******************** UPDATE MOULD RECORD AT ROOM LEVEL AND LINK WITH THE ENVIRONMENTAL REPORT ********************");
			test.log(LogStatus.INFO,
					"******************** UPDATE MOULD RECORD AT ROOM LEVEL AND LINK WITH THE ENVIRONMENTAL REPORT ********************");
			Reporter.log(
					"******************** UPDATE MOULD RECORD AT ROOM LEVEL AND LINK WITH THE ENVIRONMENTAL REPORT ********************");
			log.info(
					"******************** UPDATE MOULD RECORD AT ROOM LEVEL AND LINK WITH THE ENVIRONMENTAL REPORT ********************");

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

				// wait for the element
				Thread.sleep(5000);

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

				// click on the newly added environmental record
				click("propertyinfo_locationlbl_morguard11_XPATH");
				System.out.println("Clicked on newly added environmental record.");
				ngDriver.waitForAngularRequestsToFinish();

				// select the status
				select("envreports_asbestosmaterials_statusdd_CSS", data.get("update_status"));
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("The option is selected from the Status dropdown.");

				// select the causes by
				select("propertyinfo_causesbydd_XPATH", data.get("update_caused_by"));
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("The option is selected from the causes by dropdown.");

				// select the responsible party
				select("propertyinfo_responsiblepartydd_XPATH", data.get("responsible_party"));
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("The option is selected from the responsible party dropdown.");

				// scroll till bottom of the page
				WebElement updatebtn = driver
						.findElement(By.cssSelector(OR.getProperty("envreports_asbestosmaterials_updatebtn_CSS")));
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("arguments[0].scrollIntoView(true);", updatebtn);

				// click on the update button
				click("envreports_asbestosmaterials_updatebtn_CSS");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("The update button clicked successfully");

				// wait for the element
				explicitWaitClickable("closetoastmsg_CSS");

				// click on the toaster close button
				click("closetoastmsg_CSS");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the toaster close button.");

				// VIEW UPDATED RECORD IS DISPLAYED WITH CORRECT DETAILS OR NOT - Asbestos
				// Material

				// enter the updated environmental record in the search field
				clear("task_listofchecklist_filterfield_CSS");
				type("task_listofchecklist_filterfield_CSS", data.get("update_status"));
				System.out.println("Entered the newly created environmental record in the search field.");
				ngDriver.waitForAngularRequestsToFinish();

				// verify added detailed of the Mould record in room level
				// level is correct or not
				switchVerification("propertyinfo_locationlbl_updatedstatus_morguard11_XPATH", "Removed",
						"The Removed is not displayed successfully.");

				// select the property option from the drop down
				select("propertyinfo_propertydd_XPATH", data.get("property"));
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Selected the property from the drop down.");

				// verify added detailed location of the Mould record in property
				// level is correct or not
				switchVerification("propertyinfo_locationlbl_updatedstatus_morguard11_XPATH", "Removed",
						"The Removed is not displayed successfully.");

				// click on the newly created Mould record
				click("propertyinfo_locationlbl_updatedstatus_morguard11_XPATH");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the newly created Mould record.");

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
				click("envreports_asbestosmaterials_roomlevel_linkbtn_morguard11_XPATH");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the link button.");

				// click on the update button
				click("envreportupdatebtn_CSS");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the update button.");

				// enter the newly created environmental record in the search field
				clear("task_listofchecklist_filterfield_CSS");
				type("task_listofchecklist_filterfield_CSS", data.get("update_status"));
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Entered the newly created environmental record in the search field.");

				// verify added detailed of the Mould record in room level
				// level is correct or not
				switchVerification("propertyinfo_locationlbl_updatedstatus_morguard11_XPATH", "Removed",
						"The Removed is not displayed successfully.");

				// select the property option from the drop down
				select("propertyinfo_propertydd_XPATH", data.get("property"));
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Selected the property from the drop down.");

				// verify added detailed location of the Mould record in property
				// level is correct or not
				switchVerification("propertyinfo_locationlbl_updatedstatus_morguard11_XPATH", "Removed",
						"The Removed is not displayed successfully.");

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

//			// MOVE THE MOULD RECORD FROM ROOM LEVEL TO PROPERTY LEVEL
//
//			System.out.println(
//					"******************** MOVE THE MOULD RECORD FROM ROOM LEVEL TO PROPERTY LEVEL ********************");
//			test.log(LogStatus.INFO,
//					"******************** MOVE THE MOULD RECORD FROM ROOM LEVEL TO PROPERTY LEVEL ********************");
//			Reporter.log(
//					"******************** MOVE THE MOULD RECORD FROM ROOM LEVEL TO PROPERTY LEVEL ********************");
//			log.info(
//					"******************** MOVE THE MOULD RECORD FROM ROOM LEVEL TO PROPERTY LEVEL ********************");
//
//			try {
//
//				// enter the property name in the search field
//				clear("envreports_propertylist_filtertxt_CSS");
//				type("envreports_propertylist_filtertxt_CSS", data.get("property_2"));
//				ngDriver.waitForAngularRequestsToFinish();
//				System.out.println("Entered the property name in the search field.");
//
//				// click on the environmental icon from the property list page
//				click("environmentalicon_CSS");
//				System.out.println("Clicked on the environmental icon of the Property.");
//				ngDriver.waitForAngularRequestsToFinish();
//				System.out.println("Navigate to the environmental screen of the perticular property.");
//
//				// click on the burger menu
//				click("menubtn_CSS");
//				ngDriver.waitForAngularRequestsToFinish();
//				System.out.println("Clicked on the burger menu button successfully!!!");
//
//				// wait for the element
//				explicitWaitClickable("envrecords_XPATH");
//
//				// click on the environmental records
//				click("envrecords_XPATH");
//				ngDriver.waitForAngularRequestsToFinish();
//				System.out.println("Clicked on the Environmental Records option.");
//
//				// click on the Primary Hazardous Substance
//				click("envrecords_primaryhazardoussubstance_XPATH");
//				ngDriver.waitForAngularRequestsToFinish();
//				System.out.println("Clicked on the Primary Hazardous Substance option");
//
//				// click on the mould
//				click("envreports_mould_XPATH");
//				System.out.println("Clicked on the mould option.");
//				ngDriver.waitForAngularRequestsToFinish();
//				System.out.println("Navigate to the mould Records Screen.");
//
//				// select the building from the drop down
//				select("propertyinfo_propertydd_XPATH", data.get("buildingName_dd"));
//				ngDriver.waitForAngularRequestsToFinish();
//				System.out.println("Selected the building from the drop down.");
//
//				// select the floor from the drop down
//				select("propertyinfo_buildingdd_XPATH", data.get("floor_name"));
//				ngDriver.waitForAngularRequestsToFinish();
//				System.out.println("Selected the floor from the drop down.");
//
//				// select the room from the drop down
//				select("propertyinfo_roomdd_XPATH", data.get("room_name"));
//				ngDriver.waitForAngularRequestsToFinish();
//				System.out.println("Selected the room from the drop down.");
//
//				// enter respective location in the search field
//				clear("sidemenu_reports_searchtxt_XPATH");
//				type("sidemenu_reports_searchtxt_XPATH", data.get("location"));
//				ngDriver.waitForAngularRequestsToFinish();
//				System.out.println("Entered respective location in the search field.");
//
//				// select the check box of the newly created environmental record
//				click("envreports_asbestosmaterials_roomlevel_moveckbx_morguard11_XPATH");
//				ngDriver.waitForAngularRequestsToFinish();
//				System.out.println("Selected the check box of the newly created environmental record.");
//
//				// click on the move button
//				click("envreports_asbestosmaterials_movebtn_CSS");
//				System.out.println("Clicked on the move button.");
//				ngDriver.waitForAngularRequestsToFinish();
//				System.out.println("Confirmation popup model is displayed for move the records.");
//
//				// click on the select to move button
//				click("envreports_movereports_selecttomovebtn_CSS");
//				System.out.println("Clicked on the select to move button.");
//				ngDriver.waitForAngularRequestsToFinish();
//
//				// select where to move option from the dropdown
//				select("survey_buildingleveldd_CSS", data.get("property"));
//				System.out.println("The option is selected where record wants to move.");
//				ngDriver.waitForAngularRequestsToFinish();
//
//				// click on the save moved records
//				click("envreports_movereports_savemovedrecordsbtn_CSS");
//				System.out.println("Clicked on the save moved records.");
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
//				// enter the newly created environmental record in the search field
//				clear("task_listofchecklist_filterfield_CSS");
//				System.out.println("Cleared the search field.");
//				ngDriver.waitForAngularRequestsToFinish();
//				type("task_listofchecklist_filterfield_CSS", data.get("detailed_location_property"));
//				System.out.println("Entered the newly created environmental record in the search field.");
//				ngDriver.waitForAngularRequestsToFinish();
//
//				// verify added mould record is correct or not
//				switchVerification("propertyinfo_locationlbl_updatedstatus_propertylevel_morguard11_XPATH", "Removed",
//						"The Removed status is not displayed successfully.");
//
//				// select the building from the drop down
//				select("propertyinfo_propertydd_XPATH", data.get("buildingName_dd"));
//				ngDriver.waitForAngularRequestsToFinish();
//				System.out.println("Selected the building from the drop down.");
//
//				// select the floor from the drop down
//				select("propertyinfo_buildingdd_XPATH", data.get("floor_name"));
//				ngDriver.waitForAngularRequestsToFinish();
//				System.out.println("Selected the floor from the drop down.");
//
//				// select the room from the drop down
//				select("propertyinfo_roomdd_XPATH", data.get("room_name"));
//				ngDriver.waitForAngularRequestsToFinish();
//				System.out.println("Selected the room from the drop down.");
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
//			System.out.println("Clicked on the home icon from the top of the screen.");
//			ngDriver.waitForAngularRequestsToFinish();
//
//			// synchronization
//			explicitWait("propertylist_title_XPATH");
//
//			// verify the property list
//			switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

			// DELETE MOULD RECORD

			System.out.println("******************** DELETE MOULD RECORD ********************");
			test.log(LogStatus.INFO, "******************** DELETE MOULD RECORD ********************");
			Reporter.log("******************** DELETE MOULD RECORD ********************");
			log.info("******************** DELETE MOULD RECORD ********************");

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

				// enter the newly created environmental record in the search field
				clear("task_listofchecklist_filterfield_CSS");
				type("task_listofchecklist_filterfield_CSS", data.get("update_status"));
				System.out.println("Entered the newly created environmental record in the search field.");
				ngDriver.waitForAngularRequestsToFinish();

				// verify added mould record is correct or not
				switchVerification("propertyinfo_locationlbl_updatedstatus_unitlevel_morguard11_XPATH", "Removed",
						"The Removed status is not displayed successfully.");

				// click on the newly added environmental record
				click("propertyinfo_locationlbl_updatedstatus_unitlevel_morguard11_XPATH");
				System.out.println("Clicked on newly added environmental record.");
				ngDriver.waitForAngularRequestsToFinish();

				// wait for the element
				explicitWaitClickable("propertyinfo_asbestosmaterial_deletebtn_XPATH");

				// click on the delete button
				click("propertyinfo_asbestosmaterial_deletebtn_XPATH");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the delete button.");

				// wait for the element
				explicitWaitClickable("propertyinfo_asbestosmaterial_confirmationdeletebtn_XPATH");

				// click on the delete button of the confirmation popup
				click("propertyinfo_asbestosmaterial_confirmationdeletebtn_XPATH");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the delete button of the confirmation popup.");

				// enter the newly created environmental record in the search field
				clear("task_listofchecklist_filterfield_CSS");
				type("task_listofchecklist_filterfield_CSS", data.get("update_status"));
				System.out.println("Entered the newly created environmental record in the search field.");
				ngDriver.waitForAngularRequestsToFinish();

				// verify added mould record is correct or not
				deleteVerification("propertyinfo_locationlbl_updatedstatus_propertylevel_morguard11_XPATH", "Removed");

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

			// DELETE THE ENVIRONMENTAL REPORT AT PROPERTY LEVEL

			System.out.println(
					"******************** DELETE THE ENVIRONMENTAL REPORT AT PROPERTY LEVEL ********************");
			test.log(LogStatus.INFO,
					"******************** DELETE THE ENVIRONMENTAL REPORT AT PROPERTY LEVEL ********************");
			Reporter.log("******************** DELETE THE ENVIRONMENTAL REPORT AT PROPERTY LEVEL ********************");
			log.info("******************** DELETE THE ENVIRONMENTAL REPORT AT PROPERTY LEVEL ********************");

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

				// click on the newly created environmental report
				click("environmental_searchedupdatedreport_morguard11_XPATH");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the newly created environmental report.");

				// click on the delete button
				click("propertyinfo_asbestosmaterial_deletebtn_XPATH");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the delete Button.");

				// click on the delete button of confirmation message
				click("propertyinfo_asbestosmaterial_confirmationdeletebtn_XPATH");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the delete Button of confirmation message.");

				// wait for the element
				explicitWaitClickable("closetoastmsg_CSS");

				// click on the toaster close button
				click("closetoastmsg_CSS");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the toaster close button.");

				// enter the newly created environmental report in the search field
				clear("task_listofchecklist_filterfield_CSS");
				type("task_listofchecklist_filterfield_CSS", data.get("update_title_property"));
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Entered the newly created environmental report in the search field.");

				// verify the deleted environmental report is displayed or not
				deleteVerification("environmental_searchedupdatedreport_morguard11_XPATH",
						"Update Test Environmental Report Morguard 11");

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

			// wait for the element
			explicitWaitClickable("questionnaire_settingicon_userupdate_CSS");

			// click on the settings icon from the top of the screen
			click("questionnaire_settingicon_userupdate_CSS");
			System.out.println("Clicked on the settings icon.");
			ngDriver.waitForAngularRequestsToFinish();

			// wait for the element
			explicitWaitClickable("sidemenu_logout_CSS");

			// click on the logout option from the side menu
			click("sidemenu_logout_CSS");
			System.out.println("Clicked on the logout option from the side menu.");
			ngDriver.waitForAngularRequestsToFinish();

			// LOGIN WITH ADMIN USER

			System.out.println("********** LOGIN WITH ADMIN USER **********");
			test.log(LogStatus.INFO, "********** LOGIN WITH ADMIN USER **********");
			Reporter.log("********** LOGIN WITH ADMIN USER **********");
			log.info("********** LOGIN WITH ADMIN USER **********");

			// wait for the element
			explicitWaitClickable("signinbtn_BTNTEXT");

			// Enter the username
			ngDriver.waitForAngularRequestsToFinish();
			type("username_MODEL", data.get("username_1"));

			// Enter the password
			type("password_MODEL", data.get("password_1"));

			// Clicking on the "Sign In" button
			click("signinbtn_BTNTEXT");
			ngDriver.waitForAngularRequestsToFinish();

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
			click("propertyinfo_newbuilding_createdbuildinglevel_morguard11_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the newly created building.");

			// scroll down the screen
			WebElement menubtn1 = driver.findElement(By.xpath(OR.getProperty("propertyinfo_menubtn_XPATH")));
			js.executeScript("arguments[0].scrollIntoView(true);", menubtn1);

			// click on the delete building button
			click("propertyinfo_newbuilding_deletebtn_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the delete building button.");

			// click on the delete building button of confirmation popup
			click("propertyinfo_newbuilding_confirmationdeletebtn_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the delete building button of confirmation popup.");

			// verify deleted building is displayed or not
			deleteVerification("propertyinfo_newbuilding_createdbuildinglevel_morguard11_XPATH",
					"Test Building Morguard 11");

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
