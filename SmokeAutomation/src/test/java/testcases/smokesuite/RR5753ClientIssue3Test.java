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

		execution(data, "rR5753ClientIssue3Test");

		// refresh the page
		driver.navigate().refresh();
		Thread.sleep(5000);
		driver.navigate().refresh();

		// PROPERTY/BUILDING FILTER - ENVIRONMENTAL REPORTS SHOULD ABLE TO FILTER ON
		// SPECIFIC BUILDING SELECTION - RR-5618
		title("PROPERTY/BUILDING FILTER - ENVIRONMENTAL REPORTS SHOULD ABLE TO FILTER ON SPECIFIC BUILDING SELECTION - RR-5618");

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
			verificationFailedMessage("");
		}

		// CREATE NEW BUILDING, FLOOR, ROOM IN THE RESPECTIVE PROPERTY
		title("CREATE NEW BUILDING, FLOOR, ROOM IN THE RESPECTIVE PROPERTY");

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
			switchVerification("propertyinfo_newbuilding_createdbuilding_ci3_XPATH", "Test Building Name CI3",
					"The Test Building Name CI3 is not displayed.");

			// ADD THE NEW FLOOR IN THE BUILDING
			title("ADD THE NEW FLOOR IN THE BUILDING");

			// click on the newly created building
			click("propertyinfo_newbuilding_createdbuilding_ci3_XPATH");

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
			switchVerification("propertyinfo_newfloor_createdfloor_ci3_XPATH", "Test Floor Name CI3",
					"The Test Floor Name CI3 is not displayed.");

			// ADD THE NEW ROOM IN THE FLOOR
			title("ADD THE NEW ROOM IN THE FLOOR");

			// click on the newly created floor
			click("propertyinfo_newfloor_createdfloor_ci3_XPATH");

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
			switchVerification("propertyinfo_newroom_createdroom_ci3_XPATH", "Test Room Name CI3",
					"The Test Room Name CI3 is not displayed.");

			// click on the menu button
			click("propertyinfo_menubtn_XPATH");

			// click on the property details option
			click("propertyinfo_menubtn_propertydetailsoption_XPATH");

		} catch (Throwable t) {
			verificationFailedMessage("");
		}

		// click on the home icon from the top of the screen
		click("questionnaire_homeburgermenubtn_hide_CSS");

		// synchronization
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// ADD ENVIRONMENTAL REPORT AT PROPERTY LEVEL
		title("ADD ENVIRONMENTAL REPORT AT PROPERTY LEVEL");

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

			// click on the environmental reports
			click("questionnaire_option_environmentalreports_XPATH");

			// select the building from the drop down
			select("propertyinfo_propertydd_XPATH", data.get("property"));

			// click on the Add report button
			click("envreportaddbtn_CSS");

			// select the checklist from the type dropdown
			select("envreporttypedd_CSS", data.get("type"));

			// enter the title

			type("envreporttitletxt_CSS", data.get("title_property"));

			// enter the company

			type("envreportcompanytxt_CSS", data.get("company"));

			// enter the author

			type("envreportauthortxt_CSS", data.get("author"));

			// scroll down the screen

			scrollByPixel(400);

			// enter the description

			type("envreportdescriptiontxt_CSS", data.get("description"));

			// click on the Add report button
			click("envreportsavebtn_CSS");

			// wait for the element
			explicitWaitClickable("closetoastmsg_CSS");

			// click on the toaster close button
			click("closetoastmsg_CSS");

			// enter the newly created environmental report in the search field

			type("task_listofchecklist_filterfield_CSS", data.get("title_property"));

			try {

				String propertyLevel1_XPATH = "//td[@id='68003']//following-sibling::td//span[text()='"
						+ data.get("title_property") + "']";

				boolean propertyLevel = driver.findElement(By.xpath(propertyLevel1_XPATH)).isDisplayed();

				if (propertyLevel == true) {
					successMessage("THE NEW ENVIRONMENTAL REPORT IS CREATED AT PROPERTY LEVEL SUCCESSFULLY");
				} else {

					verificationFailedMessage("THE NEW ENVIRONMENTAL REPORT IS NOT CREATED AT PROPERTY LEVEL.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("THE NEW ENVIRONMENTAL REPORT IS NOT CREATED AT PROPERTY LEVEL.");
			}

		} catch (Throwable t) {
			verificationFailedMessage("");
		}

		// click on the home icon from the top of the screen
		click("questionnaire_homeburgermenubtn_hide_CSS");

		// synchronization
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// ADD ENVIRONMENTAL REPORT AT BUILDING LEVEL
		title("ADD ENVIRONMENTAL REPORT AT BUILDING LEVEL");

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

			// click on the environmental reports
			click("questionnaire_option_environmentalreports_XPATH");

			// select the building from the drop down
			select("propertyinfo_propertydd_XPATH", data.get("buildingName_dd"));

			// click on the Add report button
			click("envreportaddbtn_CSS");

			// select the checklist from the type dropdown
			select("envreporttypedd_CSS", data.get("type"));

			// enter the title

			type("envreporttitletxt_CSS", data.get("title_building"));

			// enter the company

			type("envreportcompanytxt_CSS", data.get("company"));

			// enter the author

			type("envreportauthortxt_CSS", data.get("author"));

			// scroll down the screen

			scrollByPixel(400);

			// enter the description

			type("envreportdescriptiontxt_CSS", data.get("description"));

			// click on the Add report button
			click("envreportsavebtn_CSS");

			// wait for the element
			explicitWaitClickable("closetoastmsg_CSS");

			// click on the toaster close button
			click("closetoastmsg_CSS");

			// enter the newly created environmental report in the search field

			type("task_listofchecklist_filterfield_CSS", data.get("title_building"));

			try {

				String buildingLevel1_XPATH = "//td[@id='" + data.get("building_name")
						+ "']//following-sibling::td//span[text()='" + data.get("title_building") + "']";

				boolean buildingLevel1 = driver.findElement(By.xpath(buildingLevel1_XPATH)).isDisplayed();

				if (buildingLevel1 == true) {
					successMessage("THE NEW ENVIRONMENTAL REPORT IS CREATED AT BUILDING LEVEL SUCCESSFULLY");
				} else {

					verificationFailedMessage("THE NEW ENVIRONMENTAL REPORT IS NOT CREATED AT BUILDING LEVEL.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("THE NEW ENVIRONMENTAL REPORT IS NOT CREATED AT BUILDING LEVEL.");
			}

		} catch (Throwable t) {
			verificationFailedMessage("");
		}

		// click on the home icon from the top of the screen
		click("questionnaire_homeburgermenubtn_hide_CSS");

		// synchronization
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// ADD ENVIRONMENTAL REPORT AT FLOOR LEVEL
		title("ADD ENVIRONMENTAL REPORT AT FLOOR LEVEL");

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

			// click on the environmental reports
			click("questionnaire_option_environmentalreports_XPATH");

			// select the building from the drop down
			select("propertyinfo_propertydd_XPATH", data.get("buildingName_dd"));

			// select the floor from the drop down
			select("propertyinfo_buildingdd_XPATH", data.get("floor_name"));

			// click on the Add report button
			click("envreportaddbtn_CSS");

			// select the checklist from the type dropdown
			select("envreporttypedd_CSS", data.get("type"));

			// enter the title

			type("envreporttitletxt_CSS", data.get("title_floor"));

			// enter the company

			type("envreportcompanytxt_CSS", data.get("company"));

			// enter the author

			type("envreportauthortxt_CSS", data.get("author"));

			// scroll down the screen

			scrollByPixel(400);

			// enter the description

			type("envreportdescriptiontxt_CSS", data.get("description"));

			// click on the Add report button
			click("envreportsavebtn_CSS");

			// wait for the element
			explicitWaitClickable("closetoastmsg_CSS");

			// click on the toaster close button
			click("closetoastmsg_CSS");

			// enter the newly created environmental report in the search field

			type("task_listofchecklist_filterfield_CSS", data.get("title_floor"));

			try {

				String floorLevel1_XPATH = "//td[@id='" + data.get("building_name") + " > " + data.get("floor_name")
						+ "']//following-sibling::td//span[text()='" + data.get("title_floor") + "']";

				boolean floorLevel1 = driver.findElement(By.xpath(floorLevel1_XPATH)).isDisplayed();

				if (floorLevel1 == true) {
					successMessage("THE NEW ENVIRONMENTAL REPORT IS CREATED AT FLOOR LEVEL SUCCESSFULLY");
				} else {

					verificationFailedMessage("THE NEW ENVIRONMENTAL REPORT IS NOT CREATED AT FLOOR LEVEL.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("THE NEW ENVIRONMENTAL REPORT IS NOT CREATED AT FLOOR LEVEL.");
			}

		} catch (Throwable t) {
			verificationFailedMessage("");
		}

		// click on the home icon from the top of the screen
		click("questionnaire_homeburgermenubtn_hide_CSS");

		// synchronization
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// ADD ENVIRONMENTAL REPORT AT ROOM LEVEL
		title("ADD ENVIRONMENTAL REPORT AT ROOM LEVEL");

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

			// click on the environmental reports
			click("questionnaire_option_environmentalreports_XPATH");

			// select the building from the drop down
			select("propertyinfo_propertydd_XPATH", data.get("buildingName_dd"));

			// select the floor from the drop down
			select("propertyinfo_buildingdd_XPATH", data.get("floor_name"));

			// select the room from the drop down
			select("propertyinfo_roomdd_XPATH", data.get("room_name"));

			// click on the Add report button
			click("envreportaddbtn_CSS");

			// select the checklist from the type dropdown
			select("envreporttypedd_CSS", data.get("type"));

			// enter the title

			type("envreporttitletxt_CSS", data.get("title_room"));

			// enter the company

			type("envreportcompanytxt_CSS", data.get("company"));

			// enter the author

			type("envreportauthortxt_CSS", data.get("author"));

			// scroll down the screen

			scrollByPixel(400);

			// enter the description

			type("envreportdescriptiontxt_CSS", data.get("description"));

			// click on the Add report button
			click("envreportsavebtn_CSS");

			// wait for the element
			explicitWaitClickable("closetoastmsg_CSS");

			// click on the toaster close button
			click("closetoastmsg_CSS");

			// enter the newly created environmental report in the search field

			type("task_listofchecklist_filterfield_CSS", data.get("title_room"));

			try {

				String roomLevel1_XPATH = "//td[@id='" + data.get("building_name") + " > " + data.get("floor_name")
						+ " > " + data.get("room_name") + "']//following-sibling::td//span[text()='"
						+ data.get("title_room") + "']";

				boolean roomLevel1 = driver.findElement(By.xpath(roomLevel1_XPATH)).isDisplayed();

				if (roomLevel1 == true) {
					successMessage("THE NEW ENVIRONMENTAL REPORT IS CREATED AT ROOM LEVEL SUCCESSFULLY");
				} else {

					verificationFailedMessage("THE NEW ENVIRONMENTAL REPORT IS NOT CREATED AT ROOM LEVEL.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("THE NEW ENVIRONMENTAL REPORT IS NOT CREATED AT ROOM LEVEL.");
			}

		} catch (Throwable t) {
			verificationFailedMessage("");
		}

		// click on the home icon from the top of the screen
		click("questionnaire_homeburgermenubtn_hide_CSS");

		// synchronization
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// VERIFY ALL THE NEWLY CREATED ENVIRONMENTAL REPORT AT PROPERTY LEVEL
		title("VERIFY ALL THE NEWLY CREATED ENVIRONMENTAL REPORT AT PROPERTY LEVEL");

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

			// click on the environmental reports
			click("questionnaire_option_environmentalreports_XPATH");

			// enter the newly created environmental report in the search field

			type("task_listofchecklist_filterfield_CSS", data.get("title_property"));

			// verify environmental report which was created at property level
			try {

				String propertyLevel1_XPATH = "//td[@id='68003']//following-sibling::td//span[text()='"
						+ data.get("title_property") + "']";

				boolean propertyLevel = driver.findElement(By.xpath(propertyLevel1_XPATH)).isDisplayed();

				if (propertyLevel == true) {
					successMessage(
							"THE NEW ENVIRONMENTAL REPORT IS DISPLAYED SUCCESSFULLY, WHICH WAS CREATED AT PROPERTY LEVEL.");
				} else {

					verificationFailedMessage(
							"THE NEW ENVIRONMENTAL REPORT IS NOT DISPLAYED, WHICH WAS CREATED AT PROPERTY LEVEL.");
				}
			} catch (Throwable t) {
				verificationFailedMessage(
						"THE NEW ENVIRONMENTAL REPORT IS NOT DISPLAYED, WHICH WAS CREATED AT PROPERTY LEVEL.");
			}

			// enter the newly created environmental report in the search field

			type("task_listofchecklist_filterfield_CSS", data.get("title_building"));

			// verify environmental report which was created at building level
			try {

				String buildingLevel1_XPATH = "//td[@id='" + data.get("building_name")
						+ "']//following-sibling::td//span[text()='" + data.get("title_building") + "']";

				boolean buildingLevel1 = driver.findElement(By.xpath(buildingLevel1_XPATH)).isDisplayed();

				if (buildingLevel1 == true) {
					successMessage(
							"THE NEW ENVIRONMENTAL REPORT IS DISPLAYED SUCCESSFULLY, WHICH WAS CREATED AT BUILDING LEVEL.");
				} else {

					verificationFailedMessage(
							"THE NEW ENVIRONMENTAL REPORT IS NOT DISPLAYED, WHICH WAS CREATED AT BUILDING LEVEL.");
				}
			} catch (Throwable t) {
				verificationFailedMessage(
						"THE NEW ENVIRONMENTAL REPORT IS NOT DISPLAYED, WHICH WAS CREATED AT BUILDING LEVEL.");
			}

			// enter the newly created environmental report in the search field

			type("task_listofchecklist_filterfield_CSS", data.get("title_floor"));

			try {

				String floorLevel1_XPATH = "//td[@id='" + data.get("building_name") + " > " + data.get("floor_name")
						+ "']//following-sibling::td//span[text()='" + data.get("title_floor") + "']";

				boolean floorLevel1 = driver.findElement(By.xpath(floorLevel1_XPATH)).isDisplayed();

				if (floorLevel1 == true) {
					successMessage(
							"THE NEW ENVIRONMENTAL REPORT IS DISPLAYED SUCCESSFULLY, WHICH WAS CREATED AT FLOOR LEVEL.");
				} else {

					verificationFailedMessage(
							"THE NEW ENVIRONMENTAL REPORT IS NOT DISPLAYED, WHICH WAS CREATED AT FLOOR LEVEL.");
				}
			} catch (Throwable t) {
				verificationFailedMessage(
						"THE NEW ENVIRONMENTAL REPORT IS NOT DISPLAYED, WHICH WAS CREATED AT FLOOR LEVEL.");
			}

			// enter the newly created environmental report in the search field

			type("task_listofchecklist_filterfield_CSS", data.get("title_room"));

			try {

				String roomLevel1_XPATH = "//td[@id='" + data.get("building_name") + " > " + data.get("floor_name")
						+ " > " + data.get("room_name") + "']//following-sibling::td//span[text()='"
						+ data.get("title_room") + "']";

				boolean roomLevel1 = driver.findElement(By.xpath(roomLevel1_XPATH)).isDisplayed();

				if (roomLevel1 == true) {
					successMessage(
							"THE NEW ENVIRONMENTAL REPORT IS DISPLAYED SUCCESSFULLY, WHICH WAS CREATED AT ROOM LEVEL.");
				} else {

					verificationFailedMessage(
							"THE NEW ENVIRONMENTAL REPORT IS NOT DISPLAYED, WHICH WAS CREATED AT ROOM LEVEL.");
				}
			} catch (Throwable t) {
				verificationFailedMessage(
						"THE NEW ENVIRONMENTAL REPORT IS NOT DISPLAYED, WHICH WAS CREATED AT ROOM LEVEL.");
			}

		} catch (Throwable t) {
			verificationFailedMessage("");
		}

		// VERIFY ALL THE NEWLY CREATED ENVIRONMENTAL REPORT AT BUILDING LEVEL
		title("VERIFY ALL THE NEWLY CREATED ENVIRONMENTAL REPORT AT BUILDING LEVEL");

		try {

			// wait for the element
			Thread.sleep(5000);

			// select the building from the drop down
			select("propertyinfo_propertydd_XPATH", data.get("buildingName_dd"));

			// enter the newly created environmental report in the search field

			type("task_listofchecklist_filterfield_CSS", data.get("title_property"));

			// verify environmental report which was created at property level
			try {

				String propertyLevel1_XPATH = "//td[@id='68003']//following-sibling::td//span[text()='"
						+ data.get("title_property") + "']";

				boolean propertyLevel = driver.findElement(By.xpath(propertyLevel1_XPATH)).isDisplayed();

				if (propertyLevel == true) {

					verificationFailedMessage(
							"THE NEW ENVIRONMENTAL REPORT IS DISPLAYED, WHICH WAS CREATED AT PROPERTY LEVEL.");
				} else {
					successMessage(
							"THE NEW ENVIRONMENTAL REPORT IS NOT DISPLAYED AS EXPECTATION, WHICH WAS CREATED AT PROPERTY LEVEL.");
				}
			} catch (Throwable t) {
				successMessage(
						"THE NEW ENVIRONMENTAL REPORT IS NOT DISPLAYED AS EXPECTATION, WHICH WAS CREATED AT PROPERTY LEVEL.");
			}

			// enter the newly created environmental report in the search field

			type("task_listofchecklist_filterfield_CSS", data.get("title_building"));

			// verify environmental report which was created at building level
			try {

				String buildingLevel1_XPATH = "//td[@id='" + data.get("building_name")
						+ "']//following-sibling::td//span[text()='" + data.get("title_building") + "']";

				boolean buildingLevel1 = driver.findElement(By.xpath(buildingLevel1_XPATH)).isDisplayed();

				if (buildingLevel1 == true) {
					successMessage(
							"THE NEW ENVIRONMENTAL REPORT IS DISPLAYED SUCCESSFULLY, WHICH WAS CREATED AT BUILDING LEVEL.");
				} else {

					verificationFailedMessage(
							"THE NEW ENVIRONMENTAL REPORT IS NOT DISPLAYED, WHICH WAS CREATED AT BUILDING LEVEL.");
				}
			} catch (Throwable t) {
				verificationFailedMessage(
						"THE NEW ENVIRONMENTAL REPORT IS NOT DISPLAYED, WHICH WAS CREATED AT BUILDING LEVEL.");
			}

			// enter the newly created environmental report in the search field

			type("task_listofchecklist_filterfield_CSS", data.get("title_floor"));

			try {

				String floorLevel1_XPATH = "//td[@id='" + data.get("building_name") + " > " + data.get("floor_name")
						+ "']//following-sibling::td//span[text()='" + data.get("title_floor") + "']";

				boolean floorLevel1 = driver.findElement(By.xpath(floorLevel1_XPATH)).isDisplayed();

				if (floorLevel1 == true) {
					successMessage(
							"THE NEW ENVIRONMENTAL REPORT IS DISPLAYED SUCCESSFULLY, WHICH WAS CREATED AT FLOOR LEVEL.");
				} else {

					verificationFailedMessage(
							"THE NEW ENVIRONMENTAL REPORT IS NOT DISPLAYED, WHICH WAS CREATED AT FLOOR LEVEL.");
				}
			} catch (Throwable t) {
				verificationFailedMessage(
						"THE NEW ENVIRONMENTAL REPORT IS NOT DISPLAYED, WHICH WAS CREATED AT FLOOR LEVEL.");
			}

			// enter the newly created environmental report in the search field

			type("task_listofchecklist_filterfield_CSS", data.get("title_room"));

			try {

				String roomLevel1_XPATH = "//td[@id='" + data.get("building_name") + " > " + data.get("floor_name")
						+ " > " + data.get("room_name") + "']//following-sibling::td//span[text()='"
						+ data.get("title_room") + "']";

				boolean roomLevel1 = driver.findElement(By.xpath(roomLevel1_XPATH)).isDisplayed();

				if (roomLevel1 == true) {
					successMessage(
							"THE NEW ENVIRONMENTAL REPORT IS DISPLAYED SUCCESSFULLY, WHICH WAS CREATED AT ROOM LEVEL.");
				} else {

					verificationFailedMessage(
							"THE NEW ENVIRONMENTAL REPORT IS NOT DISPLAYED, WHICH WAS CREATED AT ROOM LEVEL.");
				}
			} catch (Throwable t) {
				verificationFailedMessage(
						"THE NEW ENVIRONMENTAL REPORT IS NOT DISPLAYED, WHICH WAS CREATED AT ROOM LEVEL.");
			}

		} catch (Throwable t) {
			verificationFailedMessage("");
		}

		// VERIFY ALL THE NEWLY CREATED ENVIRONMENTAL REPORT AT FLOOR LEVEL
		title("VERIFY ALL THE NEWLY CREATED ENVIRONMENTAL REPORT AT FLOOR LEVEL");

		try {

			// select the floor from the drop down
			select("propertyinfo_buildingdd_XPATH", data.get("floor_name"));

			// enter the newly created environmental report in the search field

			type("task_listofchecklist_filterfield_CSS", data.get("title_property"));

			// verify environmental report which was created at property level
			try {

				String propertyLevel1_XPATH = "//td[@id='68003']//following-sibling::td//span[text()='"
						+ data.get("title_property") + "']";

				boolean propertyLevel = driver.findElement(By.xpath(propertyLevel1_XPATH)).isDisplayed();

				if (propertyLevel == true) {

					verificationFailedMessage(
							"THE NEW ENVIRONMENTAL REPORT IS DISPLAYED, WHICH WAS CREATED AT PROPERTY LEVEL.");
				} else {
					successMessage(
							"THE NEW ENVIRONMENTAL REPORT IS NOT DISPLAYED AS EXPECTATION, WHICH WAS CREATED AT PROPERTY LEVEL.");
				}
			} catch (Throwable t) {
				successMessage(
						"THE NEW ENVIRONMENTAL REPORT IS NOT DISPLAYED AS EXPECTATION, WHICH WAS CREATED AT PROPERTY LEVEL.");
			}

			// enter the newly created environmental report in the search field

			type("task_listofchecklist_filterfield_CSS", data.get("title_building"));

			// verify environmental report which was created at building level
			try {

				String buildingLevel1_XPATH = "//td[@id='" + data.get("building_name")
						+ "']//following-sibling::td//span[text()='" + data.get("title_building") + "']";

				boolean buildingLevel1 = driver.findElement(By.xpath(buildingLevel1_XPATH)).isDisplayed();

				if (buildingLevel1 == true) {
					verificationFailedMessage(
							"THE NEW ENVIRONMENTAL REPORT IS DISPLAYED, WHICH WAS CREATED AT BUILDING LEVEL.");
				} else {
					successMessage(
							"THE NEW ENVIRONMENTAL REPORT IS NOT DISPLAYED AS EXPECTATION, WHICH WAS CREATED AT BUILDING LEVEL.");
				}
			} catch (Throwable t) {
				successMessage(
						"THE NEW ENVIRONMENTAL REPORT IS NOT DISPLAYED AS EXPECTATION, WHICH WAS CREATED AT BUILDING LEVEL.");
			}

			// enter the newly created environmental report in the search field

			type("task_listofchecklist_filterfield_CSS", data.get("title_floor"));

			try {

				String floorLevel1_XPATH = "//td[@id='" + data.get("building_name") + " > " + data.get("floor_name")
						+ "']//following-sibling::td//span[text()='" + data.get("title_floor") + "']";

				boolean floorLevel1 = driver.findElement(By.xpath(floorLevel1_XPATH)).isDisplayed();

				if (floorLevel1 == true) {
					successMessage(
							"THE NEW ENVIRONMENTAL REPORT IS DISPLAYED SUCCESSFULLY, WHICH WAS CREATED AT FLOOR LEVEL.");
				} else {

					verificationFailedMessage(
							"THE NEW ENVIRONMENTAL REPORT IS NOT DISPLAYED, WHICH WAS CREATED AT FLOOR LEVEL.");
				}
			} catch (Throwable t) {
				verificationFailedMessage(
						"THE NEW ENVIRONMENTAL REPORT IS NOT DISPLAYED, WHICH WAS CREATED AT FLOOR LEVEL.");
			}

			// enter the newly created environmental report in the search field

			type("task_listofchecklist_filterfield_CSS", data.get("title_room"));

			try {

				String roomLevel1_XPATH = "//td[@id='" + data.get("building_name") + " > " + data.get("floor_name")
						+ " > " + data.get("room_name") + "']//following-sibling::td//span[text()='"
						+ data.get("title_room") + "']";

				boolean roomLevel1 = driver.findElement(By.xpath(roomLevel1_XPATH)).isDisplayed();

				if (roomLevel1 == true) {
					successMessage(
							"THE NEW ENVIRONMENTAL REPORT IS DISPLAYED SUCCESSFULLY, WHICH WAS CREATED AT ROOM LEVEL.");
				} else {

					verificationFailedMessage(
							"THE NEW ENVIRONMENTAL REPORT IS NOT DISPLAYED, WHICH WAS CREATED AT ROOM LEVEL.");
				}
			} catch (Throwable t) {
				verificationFailedMessage(
						"THE NEW ENVIRONMENTAL REPORT IS NOT DISPLAYED, WHICH WAS CREATED AT ROOM LEVEL.");
			}

		} catch (Throwable t) {
			verificationFailedMessage("");
		}

		// VERIFY ALL THE NEWLY CREATED ENVIRONMENTAL REPORT AT ROOM LEVEL
		title("VERIFY ALL THE NEWLY CREATED ENVIRONMENTAL REPORT AT ROOM LEVEL");

		try {

			// wait for the element
			Thread.sleep(5000);

			// select the room from the drop down
			select("propertyinfo_roomdd_XPATH", data.get("room_name"));

			// enter the newly created environmental report in the search field

			type("task_listofchecklist_filterfield_CSS", data.get("title_property"));

			// verify environmental report which was created at property level
			try {

				String propertyLevel1_XPATH = "//td[@id='68003']//following-sibling::td//span[text()='"
						+ data.get("title_property") + "']";

				boolean propertyLevel = driver.findElement(By.xpath(propertyLevel1_XPATH)).isDisplayed();

				if (propertyLevel == true) {

					verificationFailedMessage(
							"THE NEW ENVIRONMENTAL REPORT IS DISPLAYED, WHICH WAS CREATED AT PROPERTY LEVEL.");
				} else {
					successMessage(
							"THE NEW ENVIRONMENTAL REPORT IS NOT DISPLAYED AS EXPECTATION, WHICH WAS CREATED AT PROPERTY LEVEL.");
				}
			} catch (Throwable t) {
				successMessage(
						"THE NEW ENVIRONMENTAL REPORT IS NOT DISPLAYED AS EXPECTATION, WHICH WAS CREATED AT PROPERTY LEVEL.");
			}

			// enter the newly created environmental report in the search field

			type("task_listofchecklist_filterfield_CSS", data.get("title_building"));

			// verify environmental report which was created at building level
			try {

				String buildingLevel1_XPATH = "//td[@id='" + data.get("building_name")
						+ "']//following-sibling::td//span[text()='" + data.get("title_building") + "']";

				boolean buildingLevel1 = driver.findElement(By.xpath(buildingLevel1_XPATH)).isDisplayed();

				if (buildingLevel1 == true) {
					verificationFailedMessage(
							"THE NEW ENVIRONMENTAL REPORT IS DISPLAYED, WHICH WAS CREATED AT BUILDING LEVEL.");
				} else {
					successMessage(
							"THE NEW ENVIRONMENTAL REPORT IS NOT DISPLAYED AS EXPECTATION, WHICH WAS CREATED AT BUILDING LEVEL.");
				}
			} catch (Throwable t) {
				successMessage(
						"THE NEW ENVIRONMENTAL REPORT IS NOT DISPLAYED AS EXPECTATION, WHICH WAS CREATED AT BUILDING LEVEL.");
			}

			// enter the newly created environmental report in the search field

			type("task_listofchecklist_filterfield_CSS", data.get("title_floor"));

			try {

				String floorLevel1_XPATH = "//td[@id='" + data.get("building_name") + " > " + data.get("floor_name")
						+ "']//following-sibling::td//span[text()='" + data.get("title_floor") + "']";

				boolean floorLevel1 = driver.findElement(By.xpath(floorLevel1_XPATH)).isDisplayed();

				if (floorLevel1 == true) {

					verificationFailedMessage(
							"THE NEW ENVIRONMENTAL REPORT IS DISPLAYED, WHICH WAS CREATED AT FLOOR LEVEL.");
				} else {
					successMessage(
							"THE NEW ENVIRONMENTAL REPORT IS NOT DISPLAYED AS EXPECTATION, WHICH WAS CREATED AT FLOOR LEVEL.");
				}
			} catch (Throwable t) {
				successMessage(
						"THE NEW ENVIRONMENTAL REPORT IS NOT DISPLAYED AS EXPECTATION, WHICH WAS CREATED AT FLOOR LEVEL.");
			}

			// enter the newly created environmental report in the search field

			type("task_listofchecklist_filterfield_CSS", data.get("title_room"));

			try {

				String roomLevel1_XPATH = "//td[@id='" + data.get("building_name") + " > " + data.get("floor_name")
						+ " > " + data.get("room_name") + "']//following-sibling::td//span[text()='"
						+ data.get("title_room") + "']";

				boolean roomLevel1 = driver.findElement(By.xpath(roomLevel1_XPATH)).isDisplayed();

				if (roomLevel1 == true) {
					successMessage(
							"THE NEW ENVIRONMENTAL REPORT IS DISPLAYED SUCCESSFULLY, WHICH WAS CREATED AT ROOM LEVEL.");
				} else {

					verificationFailedMessage(
							"THE NEW ENVIRONMENTAL REPORT IS NOT DISPLAYED, WHICH WAS CREATED AT ROOM LEVEL.");
				}
			} catch (Throwable t) {
				verificationFailedMessage(
						"THE NEW ENVIRONMENTAL REPORT IS NOT DISPLAYED, WHICH WAS CREATED AT ROOM LEVEL.");
			}

		} catch (Throwable t) {
			verificationFailedMessage("");
		}

		// VERIFY ALL THE NEWLY CREATED ENVIRONMENTAL REPORT AT PROPERTY LEVEL AGAIN
		title("VERIFY ALL THE NEWLY CREATED ENVIRONMENTAL REPORT AT PROPERTY LEVEL AGAIN");

		try {

			// wait for the element
			Thread.sleep(5000);

			// select the property from the drop down
			select("propertyinfo_propertydd_XPATH", data.get("property"));

			// enter the newly created environmental report in the search field

			type("task_listofchecklist_filterfield_CSS", data.get("title_property"));

			// verify environmental report which was created at property level
			try {

				String propertyLevel1_XPATH = "//td[@id='68003']//following-sibling::td//span[text()='"
						+ data.get("title_property") + "']";

				boolean propertyLevel = driver.findElement(By.xpath(propertyLevel1_XPATH)).isDisplayed();

				if (propertyLevel == true) {
					successMessage(
							"THE NEW ENVIRONMENTAL REPORT IS DISPLAYED SUCCESSFULLY, WHICH WAS CREATED AT PROPERTY LEVEL.");
				} else {

					verificationFailedMessage(
							"THE NEW ENVIRONMENTAL REPORT IS NOT DISPLAYED, WHICH WAS CREATED AT PROPERTY LEVEL.");
				}
			} catch (Throwable t) {
				verificationFailedMessage(
						"THE NEW ENVIRONMENTAL REPORT IS NOT DISPLAYED, WHICH WAS CREATED AT PROPERTY LEVEL.");
			}

			// enter the newly created environmental report in the search field

			type("task_listofchecklist_filterfield_CSS", data.get("title_building"));

			// verify environmental report which was created at building level
			try {

				String buildingLevel1_XPATH = "//td[@id='" + data.get("building_name")
						+ "']//following-sibling::td//span[text()='" + data.get("title_building") + "']";

				boolean buildingLevel1 = driver.findElement(By.xpath(buildingLevel1_XPATH)).isDisplayed();

				if (buildingLevel1 == true) {
					successMessage(
							"THE NEW ENVIRONMENTAL REPORT IS DISPLAYED SUCCESSFULLY, WHICH WAS CREATED AT BUILDING LEVEL.");
				} else {

					verificationFailedMessage(
							"THE NEW ENVIRONMENTAL REPORT IS NOT DISPLAYED, WHICH WAS CREATED AT BUILDING LEVEL.");
				}
			} catch (Throwable t) {
				verificationFailedMessage(
						"THE NEW ENVIRONMENTAL REPORT IS NOT DISPLAYED, WHICH WAS CREATED AT BUILDING LEVEL.");
			}

			// enter the newly created environmental report in the search field

			type("task_listofchecklist_filterfield_CSS", data.get("title_floor"));

			try {

				String floorLevel1_XPATH = "//td[@id='" + data.get("building_name") + " > " + data.get("floor_name")
						+ "']//following-sibling::td//span[text()='" + data.get("title_floor") + "']";

				boolean floorLevel1 = driver.findElement(By.xpath(floorLevel1_XPATH)).isDisplayed();

				if (floorLevel1 == true) {
					successMessage(
							"THE NEW ENVIRONMENTAL REPORT IS DISPLAYED SUCCESSFULLY, WHICH WAS CREATED AT FLOOR LEVEL.");
				} else {

					verificationFailedMessage(
							"THE NEW ENVIRONMENTAL REPORT IS NOT DISPLAYED, WHICH WAS CREATED AT FLOOR LEVEL.");
				}
			} catch (Throwable t) {
				verificationFailedMessage(
						"THE NEW ENVIRONMENTAL REPORT IS NOT DISPLAYED, WHICH WAS CREATED AT FLOOR LEVEL.");
			}

			// enter the newly created environmental report in the search field

			type("task_listofchecklist_filterfield_CSS", data.get("title_room"));

			try {

				String roomLevel1_XPATH = "//td[@id='" + data.get("building_name") + " > " + data.get("floor_name")
						+ " > " + data.get("room_name") + "']//following-sibling::td//span[text()='"
						+ data.get("title_room") + "']";

				boolean roomLevel1 = driver.findElement(By.xpath(roomLevel1_XPATH)).isDisplayed();

				if (roomLevel1 == true) {
					successMessage(
							"THE NEW ENVIRONMENTAL REPORT IS DISPLAYED SUCCESSFULLY, WHICH WAS CREATED AT ROOM LEVEL.");
				} else {

					verificationFailedMessage(
							"THE NEW ENVIRONMENTAL REPORT IS NOT DISPLAYED, WHICH WAS CREATED AT ROOM LEVEL.");
				}
			} catch (Throwable t) {
				verificationFailedMessage(
						"THE NEW ENVIRONMENTAL REPORT IS NOT DISPLAYED, WHICH WAS CREATED AT ROOM LEVEL.");
			}

		} catch (Throwable t) {
			verificationFailedMessage("");
		}

		// click on the home icon from the top of the screen
		click("questionnaire_homeburgermenubtn_hide_CSS");

		// wait for the element
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// DELETE THE NEWLY CREATED BUILDING FROM THE RESPECTIVE PROPERTY
		title("DELETE THE NEWLY CREATED BUILDING FROM THE RESPECTIVE PROPERTY");

		try {

			// enter the property name in the search field

			type("envreports_propertylist_filtertxt_CSS", data.get("property_2"));

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
			String buildingName_XPATH = "//td[text()='" + data.get("building_name") + "']";
			driver.findElement(By.xpath(buildingName_XPATH)).click();

			// wait foe the element
			explicitWaitClickable("propertyinfo_newbuilding_deletebtn_XPATH");

			// click on the delete button
			click("propertyinfo_newbuilding_deletebtn_XPATH");

			// wait foe the element
			explicitWaitClickable("propertyinfo_newbuilding_confirmationdeletebtn_XPATH");

			// click on the delete button of the confirmation
			click("propertyinfo_newbuilding_confirmationdeletebtn_XPATH");

			// wait for the element
			explicitWaitClickable("closetoastmsg_CSS");

			// click on the toaster close button
			click("closetoastmsg_CSS");

			// verify deleted building is displayed or not

			deleteVerification("propertyinfo_newbuilding_createdbuilding_ci3_XPATH", "Test Building Name CI3");

			// click on the menu button
			click("propertyinfo_menubtn_XPATH");

			// click on the property details option
			click("propertyinfo_menubtn_propertydetailsoption_XPATH");

		} catch (Throwable t) {
			verificationFailedMessage("");
		}

		// click on the home icon from the top of the screen
		click("questionnaire_homeburgermenubtn_hide_CSS");

		// synchronization
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// DELETE THE NEWLY CREATED ENVIRONMENTAL REPORT
		title("DELETE THE NEWLY CREATED ENVIRONMENTAL REPORT");

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

			// click on the environmental reports
			click("questionnaire_option_environmentalreports_XPATH");

			// enter the newly created environmental report in the search field

			type("task_listofchecklist_filterfield_CSS", data.get("title_property"));

			// click on the environmental record
			String propertyLevel2_XPATH = "//td[@id='68003']//following-sibling::td//span[text()='"
					+ data.get("title_property") + "']";

			driver.findElement(By.xpath(propertyLevel2_XPATH)).click();

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

			// verification of the environmental report is deleted or not

			// enter the newly created environmental report in the search field

			type("task_listofchecklist_filterfield_CSS", data.get("title_property"));

			try {

				String propertyLevel1_XPATH = "//td[@id='68003']//following-sibling::td//span[text()='"
						+ data.get("title_property") + "']";

				boolean propertyLevel = driver.findElement(By.xpath(propertyLevel1_XPATH)).isDisplayed();

				if (propertyLevel == true) {

					verificationFailedMessage(
							"THE NEW ENVIRONMENTAL REPORT IS DISPLAYED, WHICH WAS CREATED AT PROPERTY LEVEL.");
				} else {
					successMessage(
							"THE NEW ENVIRONMENTAL REPORT IS NOT DISPLAYED AS EXPECTATION, WHICH WAS CREATED AT PROPERTY LEVEL.");
				}
			} catch (Throwable t) {
				successMessage(
						"THE NEW ENVIRONMENTAL REPORT IS NOT DISPLAYED AS EXPECTATION, WHICH WAS CREATED AT PROPERTY LEVEL.");
			}

		} catch (Throwable t) {
			verificationFailedMessage("");
		}

		// click on the home icon from the top of the screen
		click("questionnaire_homeburgermenubtn_hide_CSS");

		// wait for the element
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
			verificationFailedMessage("");
		}

	}
}