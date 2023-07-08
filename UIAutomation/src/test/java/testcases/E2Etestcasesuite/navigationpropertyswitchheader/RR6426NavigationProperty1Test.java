package testcases.E2Etestcasesuite.navigationpropertyswitchheader;

import java.io.IOException;
import java.util.Hashtable;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

import base.Helper;
import base.TestBase;
import utilities.TestUtil;

public class RR6426NavigationProperty1Test extends TestBase {

	@Test(dataProviderClass = TestUtil.class, dataProvider = "dp")
	public void rR6426NavigationProperty1Test(Hashtable<String, String> data) throws InterruptedException, IOException {

		execution(data, "rR6426NavigationProperty1Test");

		Helper helper = new Helper();

		// RISK MANAGEMENT MODULE - NAVIGATION SCENARIO OF THE RISK MANAGEMENT SUMMARY,
		// PROPERTY DETAILS, BUILDING DETAILS, OWNERS/INVESTORS, SITE TEAM, HISTORY,
		// SURVEYS, INSPECTIONS AND DOCUMENTS/REPORTS.
		title("RISK MANAGEMENT MODULE - NAVIGATION SCENARIO OF THE RISK MANAGEMENT SUMMARY, PROPERTY DETAILS, BUILDING DETAILS, "
				+ "OWNERS/INVESTORS, SITE TEAM, HISTORY, SURVEYS, INSPECTIONS AND DOCUMENTS/REPORTS.");

		// refresh the page
		driver.navigate().refresh();
		Thread.sleep(5000);
		driver.navigate().refresh();

		// CREATE THE NEWLY DOCUMENTS AND REPORT RECORD
		title("CREATE THE NEWLY DOCUMENTS AND REPORT RECORD");

		String title = RandomStringUtils.randomAlphabetic(8);

		try {

			// click on the risk management icon from the property list page
			click("riskmanagementicon_CSS");

			// wait for the element
			explicitWaitClickable("menubtn_CSS");

			// click on the burger menu
			click("menubtn_CSS");

			// wait for the element
			explicitWaitClickable("ohs_documentreportsidemenu_XPATH");

			// click on the document/report
			click("ohs_documentreportsidemenu_XPATH");

			// click on the add button
			click("ohs_documentreport_addbtn_XPATH");

			// enter the title of the document
			type("ohs_documentreport_titletxt_XPATH", title);

			// select the type of the document
			select("navigation_riskmanagement_documenttype_XPATH", "Insurance Document/Report");

			// click on the save button
			click("ohs_documentreport_savebtn_XPATH");

			// enter the newly created document name in the search field
			type("propertyproject_documentreport_searchtxt_XPATH", title);

			// validate the newly created document report record
			try {
				String record = "//td[text()='" + title + "']";
				boolean record_actual = driver.findElement(By.xpath(record)).isDisplayed();

				if (record_actual == true) {
					successMessage("The newly created document report record is displayed successfully.");
				} else {
					verificationFailedMessage("The newly created document report record is not displayed.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The newly created document report record is not displayed.");
			}

		} catch (Throwable t) {
			verificationFailed();
		}

		// click on the home icon from the top of the screen
		click("questionnaire_homeburgermenubtn_hide_CSS");

		// wait for the element
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// VALIDATE THE NAVIGATION AFTER SWITCHING THE PROPERTY FROM THE HEADER OF
		// THE RISK MANAGEMENT SUMMARY SCREEN
		title("VALIDATE THE NAVIGATION AFTER SWITCHING THE PROPERTY FROM THE HEADER OF THE RISK MANAGEMENT SUMMARY SCREEN");

		try {

			// wait for the element
			explicitWaitClickable("riskmanagementicon_CSS");

			// click on the risk management icon from the property list page
			click("riskmanagementicon_CSS");

			// VALIDATE FOR PROPERTY ONE
			title("VALIDATE FOR PROPERTY ONE");

			// validate the property name
			switchVerification("navigation_header_propertyname1_XPATH", "[DND] AAAA Risk Test Prop 01 - 01",
					"The property name is not displayed.");

			// validate the details of the risk management
			// ********** ADD THE VALIDATION OF RISK MANAGEMENT DETAILS **********

			// VALIDATE FOR PROPERTY TWO
			title("VALIDATE FOR PROPERTY TWO");

			// wait for the element
			explicitWaitClickable("navigation_header_searchicon_XPATH");

			// click on the search icon from the header
			click("navigation_header_searchicon_XPATH");

			// enter property 2 number in text field
			type("navigation_header_searchtxt_XPATH", "02");

			// hit enter key
			driver.findElement(By.xpath(OR.getProperty("navigation_header_searchtxt_XPATH"))).sendKeys(Keys.ENTER);
			consoleMessage("Hit enter key.");

			// wait for the element
			Thread.sleep(2000);

			// click on the settings icon from the top of the screen
			click("questionnaire_settingicon_CSS");

			// wait for the element
			Thread.sleep(1000);

			// click on the cancel icon
			click("questionnaire_setting_cancelicon_XPATH");

			// validate the property name
			switchVerification("navigation_header_propertyname2_XPATH", "[DND] AAAA Risk Test Prop 02 - 02",
					"The property name is not displayed.");

			// validate the details of the risk management
			// ********** ADD THE VALIDATION OF RISK MANAGEMENT DETAILS **********

			// VALIDATE FOR PROPERTY THREE
			title("VALIDATE FOR PROPERTY THREE");

			// wait for the element
			explicitWaitClickable("navigation_header_searchicon_XPATH");

			// click on the search icon from the header
			click("navigation_header_searchicon_XPATH");

			// enter property 2 number in text field
			type("navigation_header_searchtxt_XPATH", "03");

			// hit enter key
			driver.findElement(By.xpath(OR.getProperty("navigation_header_searchtxt_XPATH"))).sendKeys(Keys.ENTER);
			consoleMessage("Hit enter key.");

			// wait for the element
			Thread.sleep(2000);

			// click on the settings icon from the top of the screen
			click("questionnaire_settingicon_CSS");

			// wait for the element
			Thread.sleep(1000);

			// click on the cancel icon
			click("questionnaire_setting_cancelicon_XPATH");

			// validate the property name
			switchVerification("navigation_header_propertyname3_XPATH", "[DND] AAAA Risk Test Prop 03 - 03",
					"The property name is not displayed.");

			// validate the details of the risk management
			// ********** ADD THE VALIDATION OF RISK MANAGEMENT DETAILS **********

			// VALIDATE FOR PROPERTY ONE
			title("VALIDATE FOR PROPERTY ONE");

			// wait for the element
			explicitWaitClickable("navigation_header_searchicon_XPATH");

			// click on the search icon from the header
			click("navigation_header_searchicon_XPATH");

			// enter property 2 number in text field
			type("navigation_header_searchtxt_XPATH", "01");

			// hit enter key
			driver.findElement(By.xpath(OR.getProperty("navigation_header_searchtxt_XPATH"))).sendKeys(Keys.ENTER);
			consoleMessage("Hit enter key.");

			// validate the property name
			switchVerification("navigation_header_propertyname1_XPATH", "[DND] AAAA Risk Test Prop 01 - 01",
					"The property name is not displayed.");

			// validate the details of the risk management
			// ********** ADD THE VALIDATION OF RISK MANAGEMENT DETAILS **********

		} catch (Throwable t) {
			verificationFailed();
		}

		// click on the home icon from the top of the screen
		click("questionnaire_homeburgermenubtn_hide_CSS");

		// wait for the element
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// VALIDATE THE NAVIGATION AFTER SWITCHING THE PROPERTY FROM THE HEADER OF
		// THE PROPERTY DETAILS SCREEN
		title("VALIDATE THE NAVIGATION AFTER SWITCHING THE PROPERTY FROM THE HEADER OF THE PROPERTY DETAILS SCREEN");

		try {

			// wait for the element
			explicitWaitClickable("riskmanagementicon_CSS");

			// click on the risk management icon from the property list page
			click("riskmanagementicon_CSS");

			// wait for the element
			explicitWaitClickable("menubtn_CSS");

			// click on the burger menu
			click("menubtn_CSS");

			// wait for the element
			Thread.sleep(5000);

			// click on the property details from side menu
			click("navigation_sidemenu_propertydetailslbl_XPATH");

			// wait for the element
			explicitWaitClickable("navigation_propertydetails_actionicon_XPATH");

			// click on the action icon
			click("navigation_propertydetails_actionicon_XPATH");

			// click on the property details option
			click("navigation_propertydetails_propertydetailsoption_XPATH");

			// VALIDATE FOR PROPERTY ONE
			title("VALIDATE FOR PROPERTY ONE");

			// validate the property name
			switchVerification("navigation_header_propertyname1_XPATH", "[DND] AAAA Risk Test Prop 01 - 01",
					"The property name is not displayed.");

			// validate the property number
			switchVerification("navigation_propertydetails_propertynumber_XPATH", "01",
					"The respective property number is not displayed.");

			// validate the property name
			switchVerification("navigation_propertydetails_propertyname_XPATH", "[DND] AAAA Risk Test Prop 01",
					"The respective property number is not displayed.");

			// VALIDATE FOR PROPERTY TWO
			title("VALIDATE FOR PROPERTY TWO");

			// wait for the element
			explicitWaitClickable("navigation_header_searchicon_XPATH");

			// click on the search icon from the header
			click("navigation_header_searchicon_XPATH");

			// enter property 2 number in text field
			type("navigation_header_searchtxt_XPATH", "02");

			// hit enter key
			driver.findElement(By.xpath(OR.getProperty("navigation_header_searchtxt_XPATH"))).sendKeys(Keys.ENTER);
			consoleMessage("Hit enter key.");

			// wait for the element
			Thread.sleep(2000);

			// click on the settings icon from the top of the screen
			click("questionnaire_settingicon_CSS");

			// wait for the element
			Thread.sleep(1000);

			// click on the cancel icon
			click("questionnaire_setting_cancelicon_XPATH");

			// validate the property name
			switchVerification("navigation_header_propertyname2_XPATH", "[DND] AAAA Risk Test Prop 02 - 02",
					"The property name is not displayed.");

			// validate the property number
			switchVerification("navigation_propertydetails_propertynumber_XPATH", "02",
					"The respective property number is not displayed.");

			// validate the property name
			switchVerification("navigation_propertydetails_propertyname_XPATH", "[DND] AAAA Risk Test Prop 02",
					"The respective property number is not displayed.");

			// VALIDATE FOR PROPERTY THREE
			title("VALIDATE FOR PROPERTY THREE");

			// wait for the element
			explicitWaitClickable("navigation_header_searchicon_XPATH");

			// click on the search icon from the header
			click("navigation_header_searchicon_XPATH");

			// enter property number in text field
			type("navigation_header_searchtxt_XPATH", "03");

			// hit enter key
			driver.findElement(By.xpath(OR.getProperty("navigation_header_searchtxt_XPATH"))).sendKeys(Keys.ENTER);
			consoleMessage("Hit enter key.");

			// wait for the element
			Thread.sleep(2000);

			// click on the settings icon from the top of the screen
			click("questionnaire_settingicon_CSS");

			// wait for the element
			Thread.sleep(1000);

			// click on the cancel icon
			click("questionnaire_setting_cancelicon_XPATH");

			// validate the property name
			switchVerification("navigation_header_propertyname3_XPATH", "[DND] AAAA Risk Test Prop 03 - 03",
					"The property name is not displayed.");

			// validate the property number
			switchVerification("navigation_propertydetails_propertynumber_XPATH", "03",
					"The respective property number is not displayed.");

			// validate the property name
			switchVerification("navigation_propertydetails_propertyname_XPATH", "[DND] AAAA Risk Test Prop 03",
					"The respective property number is not displayed.");

			// VALIDATE FOR PROPERTY ONE
			title("VALIDATE FOR PROPERTY ONE");

			// wait for the element
			explicitWaitClickable("navigation_header_searchicon_XPATH");

			// click on the search icon from the header
			click("navigation_header_searchicon_XPATH");

			// enter property number in text field
			type("navigation_header_searchtxt_XPATH", "01");

			// hit enter key
			driver.findElement(By.xpath(OR.getProperty("navigation_header_searchtxt_XPATH"))).sendKeys(Keys.ENTER);
			consoleMessage("Hit enter key.");

			// validate the property name
			switchVerification("navigation_header_propertyname1_XPATH", "[DND] AAAA Risk Test Prop 01 - 01",
					"The property name is not displayed.");

			// validate the property number
			switchVerification("navigation_propertydetails_propertynumber_XPATH", "01",
					"The respective property number is not displayed.");

			// validate the property name
			switchVerification("navigation_propertydetails_propertyname_XPATH", "[DND] AAAA Risk Test Prop 01",
					"The respective property number is not displayed.");

		} catch (Throwable t) {
			verificationFailed();
		}

		// click on the home icon from the top of the screen
		click("questionnaire_homeburgermenubtn_hide_CSS");

		// wait for the element
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// VALIDATE THE NAVIGATION AFTER SWITCHING THE PROPERTY FROM THE HEADER OF
		// THE EDIT PROPERTY DETAILS SCREEN
		title("VALIDATE THE NAVIGATION AFTER SWITCHING THE PROPERTY FROM THE HEADER OF THE EDIT PROPERTY DETAILS SCREEN");

		try {

			// wait for the element
			explicitWaitClickable("riskmanagementicon_CSS");

			// click on the risk management icon from the property list page
			click("riskmanagementicon_CSS");

			// wait for the element
			explicitWaitClickable("menubtn_CSS");

			// click on the burger menu
			click("menubtn_CSS");

			// wait for the element
			Thread.sleep(5000);

			// click on the property details from side menu
			click("navigation_sidemenu_propertydetailslbl_XPATH");

			// VALIDATE FOR PROPERTY ONE
			title("VALIDATE FOR PROPERTY ONE");

			// wait for the element
			explicitWaitClickable("navigation_propertydetails_actionicon_XPATH");

			// click on the action icon
			click("navigation_propertydetails_actionicon_XPATH");

			// click on the property details option
			click("navigation_propertydetails_propertydetailsoption_XPATH");

			// click on the edit button of property details
			click("navigation_propertydetails_editbtn_XPATH");

			// validate the property name
			switchVerification("navigation_header_propertyname1_XPATH", "[DND] AAAA Risk Test Prop 01 - 01",
					"The property name is not displayed.");

			// validate the property name
			try {
				String propertyName = driver
						.findElement(By.xpath(OR.getProperty("navigation_propertydetails_propertynametxt_XPATH")))
						.getAttribute("value");

				if (propertyName.equals("[DND] AAAA Risk Test Prop 01")) {
					successMessage("The property name is displayed correctly.");
				} else {
					verificationFailedMessage("The property name is not displayed correctly.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The property name is not displayed correctly.");
			}

			// VALIDATE FOR PROPERTY TWO
			title("VALIDATE FOR PROPERTY TWO");

			// wait for the element
			explicitWaitClickable("navigation_header_searchicon_XPATH");

			// click on the search icon from the header
			click("navigation_header_searchicon_XPATH");

			// enter property 2 number in text field
			type("navigation_header_searchtxt_XPATH", "02");

			// hit enter key
			driver.findElement(By.xpath(OR.getProperty("navigation_header_searchtxt_XPATH"))).sendKeys(Keys.ENTER);
			consoleMessage("Hit enter key.");

			// wait for the element
			Thread.sleep(2000);

			// click on the settings icon from the top of the screen
			click("questionnaire_settingicon_CSS");

			// wait for the element
			Thread.sleep(1000);

			// click on the cancel icon
			click("questionnaire_setting_cancelicon_XPATH");

			// validate the property name
			switchVerification("navigation_header_propertyname2_XPATH", "[DND] AAAA Risk Test Prop 02 - 02",
					"The property name is not displayed.");

			// validate the property name
			try {
				String propertyName = driver
						.findElement(By.xpath(OR.getProperty("navigation_propertydetails_propertynametxt_XPATH")))
						.getAttribute("value");

				if (propertyName.equals("[DND] AAAA Risk Test Prop 02")) {
					successMessage("The property name is displayed correctly.");
				} else {
					verificationFailedMessage("The property name is not displayed correctly.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The property name is not displayed correctly.");
			}

			// VALIDATE FOR PROPERTY THREE
			title("VALIDATE FOR PROPERTY THREE");

			// wait for the element
			explicitWaitClickable("navigation_header_searchicon_XPATH");

			// click on the search icon from the header
			click("navigation_header_searchicon_XPATH");

			// enter property number in text field
			type("navigation_header_searchtxt_XPATH", "03");

			// hit enter key
			driver.findElement(By.xpath(OR.getProperty("navigation_header_searchtxt_XPATH"))).sendKeys(Keys.ENTER);
			consoleMessage("Hit enter key.");

			// wait for the element
			Thread.sleep(2000);

			// click on the settings icon from the top of the screen
			click("questionnaire_settingicon_CSS");

			// wait for the element
			Thread.sleep(1000);

			// click on the cancel icon
			click("questionnaire_setting_cancelicon_XPATH");

			// validate the property name
			switchVerification("navigation_header_propertyname3_XPATH", "[DND] AAAA Risk Test Prop 03 - 03",
					"The property name is not displayed.");

			// validate the property name
			try {
				String propertyName = driver
						.findElement(By.xpath(OR.getProperty("navigation_propertydetails_propertynametxt_XPATH")))
						.getAttribute("value");

				if (propertyName.equals("[DND] AAAA Risk Test Prop 03")) {
					successMessage("The property name is displayed correctly.");
				} else {
					verificationFailedMessage("The property name is not displayed correctly.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The property name is not displayed correctly.");
			}

			// VALIDATE FOR PROPERTY ONE
			title("VALIDATE FOR PROPERTY ONE");

			// wait for the element
			explicitWaitClickable("navigation_header_searchicon_XPATH");

			// click on the search icon from the header
			click("navigation_header_searchicon_XPATH");

			// enter property number in text field
			type("navigation_header_searchtxt_XPATH", "01");

			// hit enter key
			driver.findElement(By.xpath(OR.getProperty("navigation_header_searchtxt_XPATH"))).sendKeys(Keys.ENTER);
			consoleMessage("Hit enter key.");

			// validate the property name
			switchVerification("navigation_header_propertyname1_XPATH", "[DND] AAAA Risk Test Prop 01 - 01",
					"The property name is not displayed.");

			// validate the property name
			try {
				String propertyName = driver
						.findElement(By.xpath(OR.getProperty("navigation_propertydetails_propertynametxt_XPATH")))
						.getAttribute("value");

				if (propertyName.equals("[DND] AAAA Risk Test Prop 01")) {
					successMessage("The property name is displayed correctly.");
				} else {
					verificationFailedMessage("The property name is not displayed correctly.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The property name is not displayed correctly.");
			}

		} catch (Throwable t) {
			verificationFailed();
		}

		// click on the home icon from the top of the screen
		click("questionnaire_homeburgermenubtn_hide_CSS");

		// wait for the element
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// VALIDATE THE NAVIGATION AFTER SWITCHING THE PROPERTY FROM THE HEADER OF
		// THE BUILDING LISTING SCREEN
		title("VALIDATE THE NAVIGATION AFTER SWITCHING THE PROPERTY FROM THE HEADER OF THE BUILDING LISTING SCREEN");

		try {

			// wait for the element
			explicitWaitClickable("riskmanagementicon_CSS");

			// click on the risk management icon from the property list page
			click("riskmanagementicon_CSS");

			// wait for the element
			explicitWaitClickable("menubtn_CSS");

			// click on the burger menu
			click("menubtn_CSS");

			// wait for the element
			Thread.sleep(5000);

			// click on the property details from side menu
			click("navigation_sidemenu_propertydetailslbl_XPATH");

			// wait for the element
			explicitWaitClickable("navigation_propertydetails_actionicon_XPATH");

			// click on the action icon
			click("navigation_propertydetails_actionicon_XPATH");

			// click on the building option
			click("navigation_propertydetails_buildingoption_XPATH");

			// VALIDATE FOR PROPERTY ONE
			title("VALIDATE FOR PROPERTY ONE");

			// validate the property name
			switchVerification("navigation_header_propertyname1_XPATH", "[DND] AAAA Risk Test Prop 01 - 01",
					"The property name is not displayed.");

			// validate the property number
			switchVerification("navigation_propertydetails_buildingnamelist_XPATH", "[DND] Building one",
					"The respective building name is not displayed.");

			// VALIDATE FOR PROPERTY TWO
			title("VALIDATE FOR PROPERTY TWO");

			// wait for the element
			explicitWaitClickable("navigation_header_searchicon_XPATH");

			// click on the search icon from the header
			click("navigation_header_searchicon_XPATH");

			// enter property 2 number in text field
			type("navigation_header_searchtxt_XPATH", "02");

			// hit enter key
			driver.findElement(By.xpath(OR.getProperty("navigation_header_searchtxt_XPATH"))).sendKeys(Keys.ENTER);
			consoleMessage("Hit enter key.");

			// wait for the element
			Thread.sleep(2000);

			// click on the settings icon from the top of the screen
			click("questionnaire_settingicon_CSS");

			// wait for the element
			Thread.sleep(1000);

			// click on the cancel icon
			click("questionnaire_setting_cancelicon_XPATH");

			// validate the property name
			switchVerification("navigation_header_propertyname2_XPATH", "[DND] AAAA Risk Test Prop 02 - 02",
					"The property name is not displayed.");

			// validate the property number
			switchVerificationFailed("navigation_propertydetails_buildingnamelist_XPATH", "[DND] Building one",
					"The respective building name is not displayed.");

			// VALIDATE FOR PROPERTY THREE
			title("VALIDATE FOR PROPERTY THREE");

			// wait for the element
			explicitWaitClickable("navigation_header_searchicon_XPATH");

			// click on the search icon from the header
			click("navigation_header_searchicon_XPATH");

			// enter property number in text field
			type("navigation_header_searchtxt_XPATH", "03");

			// hit enter key
			driver.findElement(By.xpath(OR.getProperty("navigation_header_searchtxt_XPATH"))).sendKeys(Keys.ENTER);
			consoleMessage("Hit enter key.");

			// wait for the element
			Thread.sleep(2000);

			// click on the settings icon from the top of the screen
			click("questionnaire_settingicon_CSS");

			// wait for the element
			Thread.sleep(1000);

			// click on the cancel icon
			click("questionnaire_setting_cancelicon_XPATH");

			// validate the property name
			switchVerification("navigation_header_propertyname3_XPATH", "[DND] AAAA Risk Test Prop 03 - 03",
					"The property name is not displayed.");

			// validate the property number
			switchVerificationFailed("navigation_propertydetails_buildingnamelist_XPATH", "[DND] Building one",
					"The respective building name is not displayed.");

			// VALIDATE FOR PROPERTY ONE
			title("VALIDATE FOR PROPERTY ONE");

			// wait for the element
			explicitWaitClickable("navigation_header_searchicon_XPATH");

			// click on the search icon from the header
			click("navigation_header_searchicon_XPATH");

			// enter property number in text field
			type("navigation_header_searchtxt_XPATH", "01");

			// hit enter key
			driver.findElement(By.xpath(OR.getProperty("navigation_header_searchtxt_XPATH"))).sendKeys(Keys.ENTER);
			consoleMessage("Hit enter key.");

			// validate the property name
			switchVerification("navigation_header_propertyname1_XPATH", "[DND] AAAA Risk Test Prop 01 - 01",
					"The property name is not displayed.");

			// validate the property number
			switchVerification("navigation_propertydetails_buildingnamelist_XPATH", "[DND] Building one",
					"The respective building name is not displayed.");

		} catch (Throwable t) {
			verificationFailed();
		}

		// click on the home icon from the top of the screen
		click("questionnaire_homeburgermenubtn_hide_CSS");

		// wait for the element
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// VALIDATE THE NAVIGATION AFTER SWITCHING THE PROPERTY FROM THE HEADER OF
		// THE BUILDING DETAILS SCREEN
		title("VALIDATE THE NAVIGATION AFTER SWITCHING THE PROPERTY FROM THE HEADER OF THE BUILDING DETAILS SCREEN");

		try {

			// wait for the element
			explicitWaitClickable("riskmanagementicon_CSS");

			// click on the risk management icon from the property list page
			click("riskmanagementicon_CSS");

			// wait for the element
			explicitWaitClickable("menubtn_CSS");

			// click on the burger menu
			click("menubtn_CSS");

			// wait for the element
			Thread.sleep(5000);

			// click on the property details from side menu
			click("navigation_sidemenu_propertydetailslbl_XPATH");

			// wait for the element
			explicitWaitClickable("navigation_propertydetails_actionicon_XPATH");

			// click on the action icon
			click("navigation_propertydetails_actionicon_XPATH");

			// click on the building option
			click("navigation_propertydetails_buildingoption_XPATH");

			// click on the building record
			click("navigation_propertydetails_buildingnamelist_XPATH");

			// VALIDATE FOR PROPERTY ONE
			title("VALIDATE FOR PROPERTY ONE");

			// validate the property name
			switchVerification("navigation_header_propertyname1_XPATH", "[DND] AAAA Risk Test Prop 01 - 01",
					"The property name is not displayed.");

			// validate the building number
			switchVerification("navigation_propertydetails_buildingnumber_XPATH", "1",
					"The respective building number is not displayed.");

			// validate the building name
			switchVerification("navigation_propertydetails_buildingname_XPATH", "[DND] Building one",
					"The respective building number is not displayed.");

			// VALIDATE FOR PROPERTY TWO
			title("VALIDATE FOR PROPERTY TWO");

			// wait for the element
			explicitWaitClickable("navigation_header_searchicon_XPATH");

			// click on the search icon from the header
			click("navigation_header_searchicon_XPATH");

			// enter property 2 number in text field
			type("navigation_header_searchtxt_XPATH", "02");

			// hit enter key
			driver.findElement(By.xpath(OR.getProperty("navigation_header_searchtxt_XPATH"))).sendKeys(Keys.ENTER);
			consoleMessage("Hit enter key.");

			// wait for the element
			Thread.sleep(2000);

			// click on the settings icon from the top of the screen
			click("questionnaire_settingicon_CSS");

			// wait for the element
			Thread.sleep(1000);

			// click on the cancel icon
			click("questionnaire_setting_cancelicon_XPATH");

			// validate the property name
			switchVerification("navigation_header_propertyname2_XPATH", "[DND] AAAA Risk Test Prop 02 - 02",
					"The property name is not displayed.");

			// validate the property number
			switchVerificationFailed("navigation_propertydetails_buildingnamelist_XPATH", "[DND] Building one",
					"The respective building name is not displayed.");

			// VALIDATE FOR PROPERTY THREE
			title("VALIDATE FOR PROPERTY THREE");

			// wait for the element
			explicitWaitClickable("navigation_header_searchicon_XPATH");

			// click on the search icon from the header
			click("navigation_header_searchicon_XPATH");

			// enter property number in text field
			type("navigation_header_searchtxt_XPATH", "03");

			// hit enter key
			driver.findElement(By.xpath(OR.getProperty("navigation_header_searchtxt_XPATH"))).sendKeys(Keys.ENTER);
			consoleMessage("Hit enter key.");

			// wait for the element
			Thread.sleep(2000);

			// click on the settings icon from the top of the screen
			click("questionnaire_settingicon_CSS");

			// wait for the element
			Thread.sleep(1000);

			// click on the cancel icon
			click("questionnaire_setting_cancelicon_XPATH");

			// validate the property name
			switchVerification("navigation_header_propertyname3_XPATH", "[DND] AAAA Risk Test Prop 03 - 03",
					"The property name is not displayed.");

			// validate the property number
			switchVerificationFailed("navigation_propertydetails_buildingnamelist_XPATH", "[DND] Building one",
					"The respective building name is not displayed.");

			// VALIDATE FOR PROPERTY ONE
			title("VALIDATE FOR PROPERTY ONE");

			// wait for the element
			explicitWaitClickable("navigation_header_searchicon_XPATH");

			// click on the search icon from the header
			click("navigation_header_searchicon_XPATH");

			// enter property number in text field
			type("navigation_header_searchtxt_XPATH", "01");

			// hit enter key
			driver.findElement(By.xpath(OR.getProperty("navigation_header_searchtxt_XPATH"))).sendKeys(Keys.ENTER);
			consoleMessage("Hit enter key.");

			// validate the property name
			switchVerification("navigation_header_propertyname1_XPATH", "[DND] AAAA Risk Test Prop 01 - 01",
					"The property name is not displayed.");

			// validate the property number
			switchVerification("navigation_propertydetails_buildingnamelist_XPATH", "[DND] Building one",
					"The respective building name is not displayed.");

		} catch (Throwable t) {
			verificationFailed();
		}

		// click on the home icon from the top of the screen
		click("questionnaire_homeburgermenubtn_hide_CSS");

		// wait for the element
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// VALIDATE THE NAVIGATION AFTER SWITCHING THE PROPERTY FROM THE HEADER OF
		// THE EDIT BUILDING DETAILS SCREEN
		title("VALIDATE THE NAVIGATION AFTER SWITCHING THE PROPERTY FROM THE HEADER OF THE EDIT BUILDING DETAILS SCREEN");

		try {

			// wait for the element
			explicitWaitClickable("riskmanagementicon_CSS");

			// click on the risk management icon from the property list page
			click("riskmanagementicon_CSS");

			// wait for the element
			explicitWaitClickable("menubtn_CSS");

			// click on the burger menu
			click("menubtn_CSS");

			// wait for the element
			Thread.sleep(5000);

			// click on the property details from side menu
			click("navigation_sidemenu_propertydetailslbl_XPATH");

			// wait for the element
			explicitWaitClickable("navigation_propertydetails_actionicon_XPATH");

			// click on the action icon
			click("navigation_propertydetails_actionicon_XPATH");

			// click on the building option
			click("navigation_propertydetails_buildingoption_XPATH");

			// click on the building record
			click("navigation_propertydetails_buildingnamelist_XPATH");

			// click on the edit button of building details
			click("navigation_buildingdetails_editbtn_XPATH");

			// VALIDATE FOR PROPERTY ONE
			title("VALIDATE FOR PROPERTY ONE");

			// validate the property name
			switchVerification("navigation_header_propertyname1_XPATH", "[DND] AAAA Risk Test Prop 01 - 01",
					"The property name is not displayed.");

			// validate the building name
			try {
				String buildingName = driver
						.findElement(By.xpath(OR.getProperty("navigation_propertydetails_buildingnametxt_XPATH")))
						.getAttribute("value");

				if (buildingName.equals("[DND] Building one")) {
					successMessage("The building name is displayed correctly.");
				} else {
					verificationFailedMessage("The building name is not displayed correctly.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The building name is not displayed correctly.");
			}

			// VALIDATE FOR PROPERTY TWO
			title("VALIDATE FOR PROPERTY TWO");

			// wait for the element
			explicitWaitClickable("navigation_header_searchicon_XPATH");

			// click on the search icon from the header
			click("navigation_header_searchicon_XPATH");

			// enter property 2 number in text field
			type("navigation_header_searchtxt_XPATH", "02");

			// hit enter key
			driver.findElement(By.xpath(OR.getProperty("navigation_header_searchtxt_XPATH"))).sendKeys(Keys.ENTER);
			consoleMessage("Hit enter key.");

			// wait for the element
			Thread.sleep(2000);

			// click on the settings icon from the top of the screen
			click("questionnaire_settingicon_CSS");

			// wait for the element
			Thread.sleep(1000);

			// click on the cancel icon
			click("questionnaire_setting_cancelicon_XPATH");

			// validate the property name
			switchVerification("navigation_header_propertyname2_XPATH", "[DND] AAAA Risk Test Prop 02 - 02",
					"The property name is not displayed.");

			// validate the property number
			switchVerificationFailed("navigation_propertydetails_buildingnamelist_XPATH", "[DND] Building one",
					"The respective building name is not displayed.");

			// VALIDATE FOR PROPERTY THREE
			title("VALIDATE FOR PROPERTY THREE");

			// wait for the element
			explicitWaitClickable("navigation_header_searchicon_XPATH");

			// click on the search icon from the header
			click("navigation_header_searchicon_XPATH");

			// enter property number in text field
			type("navigation_header_searchtxt_XPATH", "03");

			// hit enter key
			driver.findElement(By.xpath(OR.getProperty("navigation_header_searchtxt_XPATH"))).sendKeys(Keys.ENTER);
			consoleMessage("Hit enter key.");

			// wait for the element
			Thread.sleep(2000);

			// click on the settings icon from the top of the screen
			click("questionnaire_settingicon_CSS");

			// wait for the element
			Thread.sleep(1000);

			// click on the cancel icon
			click("questionnaire_setting_cancelicon_XPATH");

			// validate the property name
			switchVerification("navigation_header_propertyname3_XPATH", "[DND] AAAA Risk Test Prop 03 - 03",
					"The property name is not displayed.");

			// validate the property number
			switchVerificationFailed("navigation_propertydetails_buildingnamelist_XPATH", "[DND] Building one",
					"The respective building name is not displayed.");

			// VALIDATE FOR PROPERTY ONE
			title("VALIDATE FOR PROPERTY ONE");

			// wait for the element
			explicitWaitClickable("navigation_header_searchicon_XPATH");

			// click on the search icon from the header
			click("navigation_header_searchicon_XPATH");

			// enter property number in text field
			type("navigation_header_searchtxt_XPATH", "01");

			// hit enter key
			driver.findElement(By.xpath(OR.getProperty("navigation_header_searchtxt_XPATH"))).sendKeys(Keys.ENTER);
			consoleMessage("Hit enter key.");

			// validate the property name
			switchVerification("navigation_header_propertyname1_XPATH", "[DND] AAAA Risk Test Prop 01 - 01",
					"The property name is not displayed.");

			// validate the property number
			switchVerification("navigation_propertydetails_buildingnamelist_XPATH", "[DND] Building one",
					"The respective building name is not displayed.");

		} catch (Throwable t) {
			verificationFailed();
		}

		// click on the home icon from the top of the screen
		click("questionnaire_homeburgermenubtn_hide_CSS");

		// wait for the element
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// VALIDATE THE NAVIGATION AFTER SWITCHING THE PROPERTY FROM THE HEADER OF
		// THE OWNERS/INVESTORS LISTING SCREEN
		title("VALIDATE THE NAVIGATION AFTER SWITCHING THE PROPERTY FROM THE HEADER OF THE OWNERS/INVESTORS LISTING SCREEN");

		try {

			// wait for the element
			explicitWaitClickable("riskmanagementicon_CSS");

			// click on the risk management icon from the property list page
			click("riskmanagementicon_CSS");

			// wait for the element
			explicitWaitClickable("menubtn_CSS");

			// click on the burger menu
			click("menubtn_CSS");

			// wait for the element
			Thread.sleep(5000);

			// click on the property details from side menu
			click("navigation_sidemenu_propertydetailslbl_XPATH");

			// wait for the element
			explicitWaitClickable("navigation_propertydetails_actionicon_XPATH");

			// click on the action icon
			click("navigation_propertydetails_actionicon_XPATH");

			// click on the owners/investors option
			click("navigation_propertydetails_ownersinvestorsoption_XPATH");

			// VALIDATE FOR PROPERTY ONE
			title("VALIDATE FOR PROPERTY ONE");

			// validate the property name
			switchVerification("navigation_header_propertyname1_XPATH", "[DND] AAAA Risk Test Prop 01 - 01",
					"The property name is not displayed.");

			// validate the add owners icon
			try {
				String ownerIcon = "//i[@ng-click='newContact()']";
				Boolean ownerIcon_actual = driver.findElement(By.xpath(ownerIcon)).isDisplayed();

				if (ownerIcon_actual == true) {
					successMessage("The add owners icon is displayed successfully.");

				} else {
					verificationFailedMessage("The add owners icon is not displayed.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The add owners icon is not displayed.");
			}

			// VALIDATE FOR PROPERTY TWO
			title("VALIDATE FOR PROPERTY TWO");

			// wait for the element
			explicitWaitClickable("navigation_header_searchicon_XPATH");

			// click on the search icon from the header
			click("navigation_header_searchicon_XPATH");

			// enter property 2 number in text field
			type("navigation_header_searchtxt_XPATH", "02");

			// hit enter key
			driver.findElement(By.xpath(OR.getProperty("navigation_header_searchtxt_XPATH"))).sendKeys(Keys.ENTER);
			consoleMessage("Hit enter key.");

			// wait for the element
			Thread.sleep(2000);

			// click on the settings icon from the top of the screen
			click("questionnaire_settingicon_CSS");

			// wait for the element
			Thread.sleep(1000);

			// click on the cancel icon
			click("questionnaire_setting_cancelicon_XPATH");

			// validate the property name
			switchVerification("navigation_header_propertyname2_XPATH", "[DND] AAAA Risk Test Prop 02 - 02",
					"The property name is not displayed.");

			// validate the add owners icon
			try {
				String ownerIcon = "//i[@ng-click='newContact()']";
				Boolean ownerIcon_actual = driver.findElement(By.xpath(ownerIcon)).isDisplayed();

				if (ownerIcon_actual == true) {
					successMessage("The add owners icon is displayed successfully.");

				} else {
					verificationFailedMessage("The add owners icon is not displayed.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The add owners icon is not displayed.");
			}

			// VALIDATE FOR PROPERTY THREE
			title("VALIDATE FOR PROPERTY THREE");

			// wait for the element
			explicitWaitClickable("navigation_header_searchicon_XPATH");

			// click on the search icon from the header
			click("navigation_header_searchicon_XPATH");

			// enter property number in text field
			type("navigation_header_searchtxt_XPATH", "03");

			// hit enter key
			driver.findElement(By.xpath(OR.getProperty("navigation_header_searchtxt_XPATH"))).sendKeys(Keys.ENTER);
			consoleMessage("Hit enter key.");

			// wait for the element
			Thread.sleep(2000);

			// click on the settings icon from the top of the screen
			click("questionnaire_settingicon_CSS");

			// wait for the element
			Thread.sleep(1000);

			// click on the cancel icon
			click("questionnaire_setting_cancelicon_XPATH");

			// validate the property name
			switchVerification("navigation_header_propertyname3_XPATH", "[DND] AAAA Risk Test Prop 03 - 03",
					"The property name is not displayed.");

			// validate the add owners icon
			try {
				String ownerIcon = "//i[@ng-click='newContact()']";
				Boolean ownerIcon_actual = driver.findElement(By.xpath(ownerIcon)).isDisplayed();

				if (ownerIcon_actual == true) {
					successMessage("The add owners icon is displayed successfully.");

				} else {
					verificationFailedMessage("The add owners icon is not displayed.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The add owners icon is not displayed.");
			}

			// VALIDATE FOR PROPERTY ONE
			title("VALIDATE FOR PROPERTY ONE");

			// wait for the element
			explicitWaitClickable("navigation_header_searchicon_XPATH");

			// click on the search icon from the header
			click("navigation_header_searchicon_XPATH");

			// enter property number in text field
			type("navigation_header_searchtxt_XPATH", "01");

			// hit enter key
			driver.findElement(By.xpath(OR.getProperty("navigation_header_searchtxt_XPATH"))).sendKeys(Keys.ENTER);
			consoleMessage("Hit enter key.");

			// validate the property name
			switchVerification("navigation_header_propertyname1_XPATH", "[DND] AAAA Risk Test Prop 01 - 01",
					"The property name is not displayed.");

			// validate the add owners icon
			try {
				String ownerIcon = "//i[@ng-click='newContact()']";
				Boolean ownerIcon_actual = driver.findElement(By.xpath(ownerIcon)).isDisplayed();

				if (ownerIcon_actual == true) {
					successMessage("The add owners icon is displayed successfully.");

				} else {
					verificationFailedMessage("The add owners icon is not displayed.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The add owners icon is not displayed.");
			}

		} catch (Throwable t) {
			verificationFailed();
		}

		// click on the home icon from the top of the screen
		click("questionnaire_homeburgermenubtn_hide_CSS");

		// wait for the element
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// VALIDATE THE NAVIGATION AFTER SWITCHING THE PROPERTY FROM THE HEADER OF
		// THE SITE TEAM LISTING SCREEN
		title("VALIDATE THE NAVIGATION AFTER SWITCHING THE PROPERTY FROM THE HEADER OF THE SITE TEAM LISTING SCREEN");

		try {

			// wait for the element
			explicitWaitClickable("riskmanagementicon_CSS");

			// click on the risk management icon from the property list page
			click("riskmanagementicon_CSS");

			// wait for the element
			explicitWaitClickable("menubtn_CSS");

			// click on the burger menu
			click("menubtn_CSS");

			// wait for the element
			Thread.sleep(5000);

			// click on the property details from side menu
			click("navigation_sidemenu_propertydetailslbl_XPATH");

			// wait for the element
			explicitWaitClickable("navigation_propertydetails_actionicon_XPATH");

			// click on the action icon
			click("navigation_propertydetails_actionicon_XPATH");

			// click on the site team option
			click("navigation_propertydetails_siteteamoption_XPATH");

			// VALIDATE FOR PROPERTY ONE
			title("VALIDATE FOR PROPERTY ONE");

			// validate the property name
			switchVerification("navigation_header_propertyname1_XPATH", "[DND] AAAA Risk Test Prop 01 - 01",
					"The property name is not displayed.");

			try {
				// validate to the respective user name
				scrollTillElement("navigation_propertydetails_siteteamoption_username_XPATH");

				// validate the respective user is displayed or not
				Boolean userName_actual = driver
						.findElement(
								By.xpath(OR.getProperty("navigation_propertydetails_siteteamoption_username_XPATH")))
						.isDisplayed();

				if (userName_actual == true) {
					verificationFailedMessage("The respective user is displayed.");

				} else {

					successMessage("The respective user is not displayed as expected.");
				}
			} catch (Throwable t) {
				successMessage("The respective user is not displayed as expected.");
			}

			// VALIDATE FOR PROPERTY TWO
			title("VALIDATE FOR PROPERTY TWO");

			// wait for the element
			explicitWaitClickable("navigation_header_searchicon_XPATH");

			// click on the search icon from the header
			click("navigation_header_searchicon_XPATH");

			// enter property 2 number in text field
			type("navigation_header_searchtxt_XPATH", "02");

			// hit enter key
			driver.findElement(By.xpath(OR.getProperty("navigation_header_searchtxt_XPATH"))).sendKeys(Keys.ENTER);
			consoleMessage("Hit enter key.");

			// wait for the element
			Thread.sleep(2000);

			// click on the settings icon from the top of the screen
			click("questionnaire_settingicon_CSS");

			// wait for the element
			Thread.sleep(1000);

			// click on the cancel icon
			click("questionnaire_setting_cancelicon_XPATH");

			// validate the property name
			switchVerification("navigation_header_propertyname2_XPATH", "[DND] AAAA Risk Test Prop 02 - 02",
					"The property name is not displayed.");

			try {
				// validate to the respective user name
				scrollTillElement("navigation_propertydetails_siteteamoption_username_XPATH");

				// validate the respective user is displayed or not
				Boolean userName_actual = driver
						.findElement(
								By.xpath(OR.getProperty("navigation_propertydetails_siteteamoption_username_XPATH")))
						.isDisplayed();

				if (userName_actual == true) {
					successMessage("The respective user is displayed successfully.");

				} else {

					verificationFailedMessage("The respective user is not displayed.");
				}
			} catch (Throwable t) {

				verificationFailedMessage("The respective user is not displayed.");
			}

			// VALIDATE FOR PROPERTY THREE
			title("VALIDATE FOR PROPERTY THREE");

			// wait for the element
			explicitWaitClickable("navigation_header_searchicon_XPATH");

			// click on the search icon from the header
			click("navigation_header_searchicon_XPATH");

			// enter property number in text field
			type("navigation_header_searchtxt_XPATH", "03");

			// hit enter key
			driver.findElement(By.xpath(OR.getProperty("navigation_header_searchtxt_XPATH"))).sendKeys(Keys.ENTER);
			consoleMessage("Hit enter key.");

			// wait for the element
			Thread.sleep(2000);

			// click on the settings icon from the top of the screen
			click("questionnaire_settingicon_CSS");

			// wait for the element
			Thread.sleep(1000);

			// click on the cancel icon
			click("questionnaire_setting_cancelicon_XPATH");

			// validate the property name
			switchVerification("navigation_header_propertyname3_XPATH", "[DND] AAAA Risk Test Prop 03 - 03",
					"The property name is not displayed.");

			try {
				// validate to the respective user name
				scrollTillElement("navigation_propertydetails_siteteamoption_username_XPATH");

				// validate the respective user is displayed or not
				Boolean userName_actual = driver
						.findElement(
								By.xpath(OR.getProperty("navigation_propertydetails_siteteamoption_username_XPATH")))
						.isDisplayed();

				if (userName_actual == true) {
					successMessage("The respective user is displayed successfully.");

				} else {

					verificationFailedMessage("The respective user is not displayed.");
				}
			} catch (Throwable t) {

				verificationFailedMessage("The respective user is not displayed.");
			}

			// VALIDATE FOR PROPERTY ONE
			title("VALIDATE FOR PROPERTY ONE");

			// wait for the element
			explicitWaitClickable("navigation_header_searchicon_XPATH");

			// click on the search icon from the header
			click("navigation_header_searchicon_XPATH");

			// enter property number in text field
			type("navigation_header_searchtxt_XPATH", "01");

			// hit enter key
			driver.findElement(By.xpath(OR.getProperty("navigation_header_searchtxt_XPATH"))).sendKeys(Keys.ENTER);
			consoleMessage("Hit enter key.");

			// validate the property name
			switchVerification("navigation_header_propertyname1_XPATH", "[DND] AAAA Risk Test Prop 01 - 01",
					"The property name is not displayed.");

			try {
				// validate to the respective user name
				scrollTillElement("navigation_propertydetails_siteteamoption_username_XPATH");

				// validate the respective user is displayed or not
				Boolean userName_actual = driver
						.findElement(
								By.xpath(OR.getProperty("navigation_propertydetails_siteteamoption_username_XPATH")))
						.isDisplayed();

				if (userName_actual == true) {
					verificationFailedMessage("The respective user is displayed.");

				} else {

					successMessage("The respective user is not displayed as expected.");
				}
			} catch (Throwable t) {
				successMessage("The respective user is not displayed as expected.");
			}

		} catch (Throwable t) {
			verificationFailed();
		}

		// click on the home icon from the top of the screen
		click("questionnaire_homeburgermenubtn_hide_CSS");

		// wait for the element
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// VALIDATE THE NAVIGATION AFTER SWITCHING THE PROPERTY FROM THE HEADER OF
		// THE HISTORY RECORDS LISTING SCREEN
		title("VALIDATE THE NAVIGATION AFTER SWITCHING THE PROPERTY FROM THE HEADER OF THE HISTORY RECORDS LISTING SCREEN");

		try {

			// wait for the element
			explicitWaitClickable("riskmanagementicon_CSS");

			// click on the risk management icon from the property list page
			click("riskmanagementicon_CSS");

			// wait for the element
			explicitWaitClickable("menubtn_CSS");

			// click on the burger menu
			click("menubtn_CSS");

			// wait for the element
			Thread.sleep(5000);

			// click on the property details from side menu
			click("navigation_sidemenu_propertydetailslbl_XPATH");

			// wait for the element
			explicitWaitClickable("navigation_propertydetails_actionicon_XPATH");

			// click on the action icon
			click("navigation_propertydetails_actionicon_XPATH");

			// click on the history option
			click("navigation_propertydetails_historyoption_XPATH");

			// VALIDATE FOR PROPERTY ONE
			title("VALIDATE FOR PROPERTY ONE");

			// validate the property name
			switchVerification("navigation_header_propertyname1_XPATH", "[DND] AAAA Risk Test Prop 01 - 01",
					"The property name is not displayed.");

			try {

				// validate the respective user is displayed or not
				Boolean record_actual = driver
						.findElement(By.xpath(OR.getProperty("navigation_propertydetails_historyoption_record_XPATH")))
						.isDisplayed();

				if (record_actual == true) {
					successMessage("The respective history record is displayed successfully.");

				} else {
					verificationFailedMessage("The respective history record is not displayed.");

				}
			} catch (Throwable t) {
				verificationFailedMessage("The respective history record is not displayed.");
			}

			// VALIDATE FOR PROPERTY TWO
			title("VALIDATE FOR PROPERTY TWO");

			// wait for the element
			explicitWaitClickable("navigation_header_searchicon_XPATH");

			// click on the search icon from the header
			click("navigation_header_searchicon_XPATH");

			// enter property 2 number in text field
			type("navigation_header_searchtxt_XPATH", "02");

			// hit enter key
			driver.findElement(By.xpath(OR.getProperty("navigation_header_searchtxt_XPATH"))).sendKeys(Keys.ENTER);
			consoleMessage("Hit enter key.");

			// wait for the element
			Thread.sleep(2000);

			// click on the settings icon from the top of the screen
			click("questionnaire_settingicon_CSS");

			// wait for the element
			Thread.sleep(1000);

			// click on the cancel icon
			click("questionnaire_setting_cancelicon_XPATH");

			// validate the property name
			switchVerification("navigation_header_propertyname2_XPATH", "[DND] AAAA Risk Test Prop 02 - 02",
					"The property name is not displayed.");

			try {

				// validate the respective user is displayed or not
				Boolean record_actual = driver
						.findElement(By.xpath(OR.getProperty("navigation_propertydetails_historyoption_record_XPATH")))
						.isDisplayed();

				if (record_actual == true) {
					verificationFailedMessage("The respective history record is displayed.");

				} else {
					successMessage("The respective history record is not displayed as expected.");

				}
			} catch (Throwable t) {
				successMessage("The respective history record is not displayed as expected.");
			}

			// VALIDATE FOR PROPERTY THREE
			title("VALIDATE FOR PROPERTY THREE");

			// wait for the element
			explicitWaitClickable("navigation_header_searchicon_XPATH");

			// click on the search icon from the header
			click("navigation_header_searchicon_XPATH");

			// enter property number in text field
			type("navigation_header_searchtxt_XPATH", "03");

			// hit enter key
			driver.findElement(By.xpath(OR.getProperty("navigation_header_searchtxt_XPATH"))).sendKeys(Keys.ENTER);
			consoleMessage("Hit enter key.");

			// wait for the element
			Thread.sleep(2000);

			// click on the settings icon from the top of the screen
			click("questionnaire_settingicon_CSS");

			// wait for the element
			Thread.sleep(1000);

			// click on the cancel icon
			click("questionnaire_setting_cancelicon_XPATH");

			// validate the property name
			switchVerification("navigation_header_propertyname3_XPATH", "[DND] AAAA Risk Test Prop 03 - 03",
					"The property name is not displayed.");

			try {

				// validate the respective user is displayed or not
				Boolean record_actual = driver
						.findElement(By.xpath(OR.getProperty("navigation_propertydetails_historyoption_record_XPATH")))
						.isDisplayed();

				if (record_actual == true) {
					verificationFailedMessage("The respective history record is displayed.");

				} else {
					successMessage("The respective history record is not displayed as expected.");

				}
			} catch (Throwable t) {
				successMessage("The respective history record is not displayed as expected.");
			}

			// VALIDATE FOR PROPERTY ONE
			title("VALIDATE FOR PROPERTY ONE");

			// wait for the element
			explicitWaitClickable("navigation_header_searchicon_XPATH");

			// click on the search icon from the header
			click("navigation_header_searchicon_XPATH");

			// enter property number in text field
			type("navigation_header_searchtxt_XPATH", "01");

			// hit enter key
			driver.findElement(By.xpath(OR.getProperty("navigation_header_searchtxt_XPATH"))).sendKeys(Keys.ENTER);
			consoleMessage("Hit enter key.");

			// validate the property name
			switchVerification("navigation_header_propertyname1_XPATH", "[DND] AAAA Risk Test Prop 01 - 01",
					"The property name is not displayed.");

			try {

				// validate the respective user is displayed or not
				Boolean record_actual = driver
						.findElement(By.xpath(OR.getProperty("navigation_propertydetails_historyoption_record_XPATH")))
						.isDisplayed();

				if (record_actual == true) {
					successMessage("The respective history record is displayed successfully.");

				} else {
					verificationFailedMessage("The respective history record is not displayed.");

				}
			} catch (Throwable t) {
				verificationFailedMessage("The respective history record is not displayed.");
			}

		} catch (Throwable t) {
			verificationFailed();
		}

		// click on the home icon from the top of the screen
		click("questionnaire_homeburgermenubtn_hide_CSS");

		// wait for the element
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// VALIDATE THE NAVIGATION AFTER SWITCHING THE PROPERTY FROM THE HEADER OF
		// THE DOCUMENT / REPORT SCREEN
		title("VALIDATE THE NAVIGATION AFTER SWITCHING THE PROPERTY FROM THE HEADER OF THE THE DOCUMENT / REPORT SCREEN");

		try {
			// click on the risk management icon from the property list page
			click("riskmanagementicon_CSS");

			// wait for the element
			explicitWaitClickable("menubtn_CSS");

			// click on the burger menu
			click("menubtn_CSS");

			// wait for the element
			explicitWaitClickable("ohs_documentreportsidemenu_XPATH");

			// click on the document/report
			click("ohs_documentreportsidemenu_XPATH");

			// enter the newly created document name in the search field
			type("propertyproject_documentreport_searchtxt_XPATH", title);

			// click on the newly created document/report
			String record = "//td[text()='" + title + "']";
			driver.findElement(By.xpath(record)).click();
			consoleMessage("Clicked on the newly created document/report.");

			// VALIDATE FOR PROPERTY ONE
			title("VALIDATE FOR PROPERTY ONE");

			// validate the property name
			switchVerification("navigation_header_propertyname1_XPATH", "[DND] AAAA Risk Test Prop 01 - 01",
					"The property name is not displayed.");

			// validate the title of the document/report is displayed selected or not
			try {

				String title_actual = driver.findElement(By.xpath(OR.getProperty("ohs_documentreport_titletxt_XPATH")))
						.getAttribute("value");

				if (title_actual.equals(title)) {
					successMessage("The title of the document/report is display successfully.");

				} else {
					verificationFailedMessage("The title of the document/report is not display.");

				}
			} catch (Throwable t) {
				verificationFailedMessage("The title of the document/report is not display.");
			}

			// VALIDATE FOR PROPERTY TWO
			title("VALIDATE FOR PROPERTY TWO");

			// wait for the element
			explicitWaitClickable("navigation_header_searchicon_XPATH");

			// click on the search icon from the header
			click("navigation_header_searchicon_XPATH");

			// enter property 2 number in text field
			type("navigation_header_searchtxt_XPATH", "02");

			// hit enter key
			driver.findElement(By.xpath(OR.getProperty("navigation_header_searchtxt_XPATH"))).sendKeys(Keys.ENTER);
			consoleMessage("Hit enter key.");

			// wait for the element
			Thread.sleep(2000);

			// click on the settings icon from the top of the screen
			click("questionnaire_settingicon_CSS");

			// wait for the element
			Thread.sleep(1000);

			// click on the cancel icon
			click("questionnaire_setting_cancelicon_XPATH");

			// validate the property name
			switchVerification("navigation_header_propertyname2_XPATH", "[DND] AAAA Risk Test Prop 02 - 02",
					"The property name is not displayed.");

			// validate the title of the document/report is displayed selected or not
			try {

				String title_actual = driver.findElement(By.xpath(OR.getProperty("ohs_documentreport_titletxt_XPATH")))
						.getAttribute("value");

				if (title_actual.equals(title)) {
					verificationFailedMessage("The title of the document/report is display.");

				} else {
					successMessage("The title of the document/report is not display as expected.");

				}
			} catch (Throwable t) {
				successMessage("The title of the document/report is not display as expected.");
			}

			// validate the title of the document/report in the listing screen is
			// displayed selected or not
			try {
				String titlelist = "//td[text()='" + title + "']";
				boolean titlelist_actual = driver.findElement(By.xpath(titlelist)).isDisplayed();

				if (titlelist_actual == true) {
					verificationFailedMessage("The newly created document/report is display.");

				} else {
					successMessage("The newly created document/report is not display successfully.");

				}
			} catch (Throwable t) {
				successMessage("The newly created document/report is not display successfully.");
			}

			// VALIDATE FOR PROPERTY THREE
			title("VALIDATE FOR PROPERTY THREE");

			// wait for the element
			explicitWaitClickable("navigation_header_searchicon_XPATH");

			// click on the search icon from the header
			click("navigation_header_searchicon_XPATH");

			// enter property 3 number in text field
			type("navigation_header_searchtxt_XPATH", "03");

			// hit enter key
			driver.findElement(By.xpath(OR.getProperty("navigation_header_searchtxt_XPATH"))).sendKeys(Keys.ENTER);
			consoleMessage("Hit enter key.");

			// wait for the element
			Thread.sleep(2000);

			// click on the settings icon from the top of the screen
			click("questionnaire_settingicon_CSS");

			// wait for the element
			Thread.sleep(1000);

			// click on the cancel icon
			click("questionnaire_setting_cancelicon_XPATH");

			// validate the property name
			switchVerification("navigation_header_propertyname3_XPATH", "[DND] AAAA Risk Test Prop 03 - 03",
					"The property name is not displayed.");

			// validate the title of the document/report is displayed selected or not
			try {

				String title_actual = driver.findElement(By.xpath(OR.getProperty("ohs_documentreport_titletxt_XPATH")))
						.getAttribute("value");

				if (title_actual.equals(title)) {
					verificationFailedMessage("The title of the document/report is display.");

				} else {
					successMessage("The title of the document/report is not display as expected.");

				}
			} catch (Throwable t) {
				successMessage("The title of the document/report is not display as expected.");
			}

			// validate the title of the document/report in the listing screen is
			// displayed selected or not
			try {
				String titlelist = "//td[text()='" + title + "']";
				boolean titlelist_actual = driver.findElement(By.xpath(titlelist)).isDisplayed();

				if (titlelist_actual == true) {
					verificationFailedMessage("The newly created document/report is display.");

				} else {
					successMessage("The newly created document/report is not display successfully.");

				}
			} catch (Throwable t) {
				successMessage("The newly created document/report is not display successfully.");
			}

			// VALIDATE FOR PROPERTY ONE
			title("VALIDATE FOR PROPERTY ONE");

			// wait for the element
			explicitWaitClickable("navigation_header_searchicon_XPATH");

			// click on the search icon from the header
			click("navigation_header_searchicon_XPATH");

			// enter property number in text field
			type("navigation_header_searchtxt_XPATH", "01");

			// hit enter key
			driver.findElement(By.xpath(OR.getProperty("navigation_header_searchtxt_XPATH"))).sendKeys(Keys.ENTER);
			consoleMessage("Hit enter key.");

			// validate the property name
			switchVerification("navigation_header_propertyname1_XPATH", "[DND] AAAA Risk Test Prop 01 - 01",
					"The property name is not displayed.");

			// validate the title of the document/report is displayed selected or not
			try {

				String title_actual = driver.findElement(By.xpath(OR.getProperty("ohs_documentreport_titletxt_XPATH")))
						.getAttribute("value");

				if (title_actual.equals(title)) {
					verificationFailedMessage("The title of the document/report is display.");

				} else {
					successMessage("The title of the document/report is not display as expected.");

				}
			} catch (Throwable t) {
				successMessage("The title of the document/report is not display as expected.");
			}

			// validate the title of the document/report in the listing screen is
			// displayed selected or not
			try {
				String titlelist = "//td[text()='" + title + "']";
				boolean titlelist_actual = driver.findElement(By.xpath(titlelist)).isDisplayed();

				if (titlelist_actual == true) {
					successMessage("The newly created document/report is display successfully.");

				} else {
					verificationFailedMessage("The newly created document/report is not display.");

				}
			} catch (Throwable t) {
				verificationFailedMessage("The newly created document/report is not display.");
			}

		} catch (Throwable t) {
			verificationFailed();
		}

		// click on the home icon from the top of the screen
		click("questionnaire_homeburgermenubtn_hide_CSS");

		// wait for the element
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// DELETE THE DOCUMENT/REPORT RECORD
		title("DELETE THE DOCUMENT/REPORT RECORD");

		try {
			// click on the risk management icon from the property list page
			click("riskmanagementicon_CSS");

			// wait for the element
			explicitWaitClickable("menubtn_CSS");

			// click on the burger menu
			click("menubtn_CSS");

			// wait for the element
			explicitWaitClickable("ohs_documentreportsidemenu_XPATH");

			// click on the document/report
			click("ohs_documentreportsidemenu_XPATH");

			// enter the newly created document name in the search field
			type("ohs_documentreport_searchtxt_XPATH", title);

			// click on the newly created document/report
			String record = "//td[text()='" + title + "']";
			driver.findElement(By.xpath(record)).click();
			consoleMessage("Clicked on the newly created document/report.");

			// wait for the element
			explicitWaitClickable("ohs_documentreport_deletebtn_XPATH");

			// click on the delete button
			click("ohs_documentreport_deletebtn_XPATH");

			// wait for the element
			explicitWaitClickable("ohs_documentreport_confirmationdeletebtn_XPATH");

			// click on the delete button of the confirmation model
			click("ohs_documentreport_confirmationdeletebtn_XPATH");

			// wait for the element
			explicitWaitClickable("closetoastmsg_CSS");

			// click on the toaster close button
			click("closetoastmsg_CSS");

			// enter the newly created document name in the search field
			type("propertyproject_documentreport_searchtxt_XPATH", title);

			// validate the newly created document report record
			try {
				String record1 = "//td[text()='" + title + "']";
				boolean record1_actual = driver.findElement(By.xpath(record1)).isDisplayed();

				if (record1_actual == true) {
					verificationFailedMessage("The newly created document report record is displayed.");

				} else {
					successMessage("The newly created document report record is not displayed.");
				}
			} catch (Throwable t) {
				successMessage("The newly created document report record is not displayed.");
			}

		} catch (Throwable t) {
			verificationFailed();
		}

		// click on the home icon from the top of the screen
		click("questionnaire_homeburgermenubtn_hide_CSS");

		// wait for the element
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

	}

}
