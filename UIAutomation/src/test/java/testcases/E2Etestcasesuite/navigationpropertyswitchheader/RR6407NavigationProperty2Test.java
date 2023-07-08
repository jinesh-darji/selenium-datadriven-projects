package testcases.E2Etestcasesuite.navigationpropertyswitchheader;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Hashtable;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import base.Helper;
import base.TestBase;
import utilities.TestUtil;

public class RR6407NavigationProperty2Test extends TestBase {

	@Test(dataProviderClass = TestUtil.class, dataProvider = "dp")
	public void rR6407NavigationProperty2Test(Hashtable<String, String> data) throws InterruptedException, IOException {

		execution(data, "rR6407NavigationProperty2Test");

		Helper helper = new Helper();

		// OHS MODULE - NAVIGATION SCENARIO OF THE ENVIRONMENTAL REPORTS AND
		// ENVIRONMENTAL RECORDS
		title("OHS MODULE - NAVIGATION SCENARIO OF THE ENVIRONMENTAL REPORTS AND ENVIRONMENTAL RECORDS");

		// refresh the page
		driver.navigate().refresh();
		Thread.sleep(5000);
		driver.navigate().refresh();

		LocalDate date = LocalDate.now();
		String today = date.toString();

		// CREATE NEW RECORD OF THE INCIDENT REPORT
		title("CREATE NEW RECORD OF THE INCIDENT REPORT");

		try {

			// click on the OHS icon from the property list page
			click("ohsicon_CSS");

			// click on the burger menu
			click("menubtn_CSS");

			// wait for the element
			explicitWaitClickable("questionnaire_option_ohstab_incidentreports_XPATH");

			// click on the incident reports
			click("questionnaire_option_ohstab_incidentreports_XPATH");

			// click on the add button
			click("ohs_incident_addbtn_CSS");

			// enter the incident time - hours
			type("ohs_incident_hourstxt_CSS", "11");

			// enter the incident time - minute
			type("ohs_incident_minutestxt_CSS", "20");

			// scroll down the screen
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,500)");

			// enter the short description
			type("ohs_incident_shortdescriptiontxt_CSS", data.get("describe_incident"));

			// click on the add event type button
			click("ohs_incident_addeventtypebtn_CSS");

			// click on the event type dropdown
			select("ohs_incident_eventtypedd_CSS", data.get("event_type"));

			// click on the add button of the add event type record model
			click("ohs_incident_eventty_addbtn_CSS");

			// click on the next button
			click("ohs_incident_nextbtn_CSS");

			// synchronization
			explicitWait("ohs_incident_nextbtn_CSS");
			consoleMessage("Navigate to the Details, Cause Tab.");

			// click on the next button
			click("ohs_incident_nextbtn_CSS");

			// synchronization
			explicitWait("ohs_incident_personsinvolved_addbtn_CSS");
			consoleMessage("Navigate to the Persons Involved Tab.");

			// click on the next button
			click("ohs_incident_nextbtn_CSS");

			// synchronization
			explicitWait("ohs_incident_nextbtn_CSS");
			consoleMessage("Navigate to the Witnesses Tab.");

			// click on the next button
			click("ohs_incident_nextbtn_CSS");

			explicitWait("ohs_incident_nextbtn_CSS");
			consoleMessage("Navigate to the emergency services Tab.");

			// click on the next button
			click("ohs_incident_nextbtn_CSS");

			// synchronization
			explicitWait("ohs_incident_nextbtn_CSS");
			consoleMessage("Navigate to the property damage Tab.");

			// click on the next button
			click("ohs_incident_nextbtn_CSS");

			// synchronization
			explicitWait("ohs_incident_nextbtn_CSS");
			consoleMessage("Navigate to the insurance Tab.");

			// click on the next button
			click("ohs_incident_nextbtn_CSS");

			// synchronization
			explicitWait("ohs_incident_updaterecordbtn_CSS");
			consoleMessage("Navigate to the attachments Tab.");

			// click on the update record button
			click("ohs_incident_updaterecordbtn_CSS");

			// wait for the element
			explicitWaitClickable("ohs_incident_search_clearbtn_XPATH");

			// click on the clear button
			click("ohs_incident_search_clearbtn_XPATH");

			// enter the newly created incident report in the search field
			type("ohs_incident_searchtxt_CSS", data.get("describe_incident"));

			// click on the search button
			click("ohs_incident_search_searchbtn_CSS");

			// verification of the incident report is added or not
			switchVerification("ohs_navigation_addedincidentreport_XPATH", "Describe OHS Incident Report 2",
					"The Describe OHS Incident Report 2 is not displayed successfully.");

		} catch (Throwable t) {
			verificationFailed();
		}

		// click on the home icon from the top of the screen
		click("questionnaire_homeburgermenubtn_hide_CSS");

		// synchronization
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// CREATE NEW RECORD OF THE JHS COMMITTEE MEETING MINUTES
		title("CREATE NEW RECORD OF THE JHS COMMITTEE MEETING MINUTES");

		try {

			// click on the OHS icon from the property list page
			click("ohsicon_CSS");

			// click on the burger menu
			click("menubtn_CSS");

			// wait for the element
			explicitWaitClickable("ohs_sidemenu_jhsmeetingoption_XPATH");

			// click on the incident reports
			click("ohs_sidemenu_jhsmeetingoption_XPATH");

			// click on the add button
			click("ohs_jhsmeeting_addbtn_XPATH");

			// click on the meeting date field
			click("ohs_jhsmeeting_meetingdatetxt_XPATH");

			// click on the today button
			click("ohs_jhsmeeting_todaybtn_XPATH");

			// enter year in the field
			type("ohs_jhsmeeting_yeartxt_XPATH", "2020");

			// select the january option from the month dropdown
			select("ohs_jhsmeeting_monthtxt_XPATH", "January");

			// enter the comment in the field
			type("ohs_jhsmeeting_commenttxt_XPATH", data.get("comment"));

			// click on the save button
			click("ohs_jhsmeeting_savebtn_XPATH");

			// verify the newly created record
			try {
				String record = "//td[text()='" + today
						+ "']//following-sibling::td[text()='2020']//following-sibling::td[text()='January']";
				boolean record_actual = driver.findElement(By.xpath(record)).isDisplayed();

				if (record_actual == true) {
					successMessage("The newly created record is displayed successfully.");
				} else {
					verificationFailedMessage("The newly created record is not displayed");
				}

			} catch (Throwable t) {
				verificationFailedMessage("The newly created record is not displayed");
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

		// CREATE NEW RECORD OF THE GOVERNMENT LABOR INSPECTION
		title("CREATE NEW RECORD OF THE GOVERNMENT LABOR INSPECTION");

		try {

			// click on the OHS icon from the property list page
			click("ohsicon_CSS");

			// click on the burger menu
			click("menubtn_CSS");

			// wait for the element
			explicitWaitClickable("ohs_sidemenu_governmentlaborinspectionoption_XPATH");

			// click on the incident reports
			click("ohs_sidemenu_governmentlaborinspectionoption_XPATH");

			// click on the add button
			click("ohs_governmentinspections_addbtn_XPATH");

			// click on the meeting date field
			click("ohs_jhsmeeting_meetingdatetxt_XPATH");

			// click on the today button
			click("ohs_jhsmeeting_todaybtn_XPATH");

			// select status from the dropdown
			select("ohs_governmentinspections_statusdd_XPATH", "Open");

			// select the actionable items from the dropdown
			select("ohs_governmentinspections_actionableitemsdd_XPATH", "Yes");

			// enter the comment in the field
			type("ohs_jhsmeeting_commenttxt_XPATH", data.get("comment"));

			// click on the save button
			click("ohs_jhsmeeting_savebtn_XPATH");

			// verify the newly created record
			try {
				String record = "//td[text()='" + today
						+ "']//following-sibling::td[text()='Open']//following-sibling::td[text()='Yes']";
				boolean record_actual = driver.findElement(By.xpath(record)).isDisplayed();

				if (record_actual == true) {
					successMessage("The newly created record is displayed successfully.");
				} else {
					verificationFailedMessage("The newly created record is not displayed");
				}

			} catch (Throwable t) {
				verificationFailedMessage("The newly created record is not displayed");
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

		// CREATE NEW RECORD OF THE IDENTIFIED HAZARDS
		title("CREATE NEW RECORD OF THE IDENTIFIED HAZARDS");

		try {

			// click on the OHS icon from the property list page
			click("ohsicon_CSS");

			// click on the burger menu
			click("menubtn_CSS");

			// wait for the element
			explicitWaitClickable("ohs_sidemenu_hazardassessmentsinspectionsoption_XPATH");

			// click on the incident reports
			click("ohs_sidemenu_hazardassessmentsinspectionsoption_XPATH");

			// click on the add button
			click("ohs_identifiedhazards_addbtn_XPATH");

			// select the name from the dropdown
			select("ohs_identifiedhazards_namedd_XPATH", "Hazard Assessment");

			// click on the due date field
			click("ohs_identifiedhazards_duedate_XPATH");

			// click on the today button
			click("ohs_jhsmeeting_todaybtn_XPATH");

			// scroll down the screen
			scrollBottom();

			// enter the note in the field
			type("ohs_jhsmeeting_notetxt_XPATH", data.get("comment"));

			// click on the save button
			click("ohs_identifiedhazards_savebtn_XPATH");

			// verify the newly created record
			try {
				String record = "//td[text()='Hazard Assessment']//following-sibling::td[text()='" + today + "']";
				boolean record_actual = driver.findElement(By.xpath(record)).isDisplayed();

				if (record_actual == true) {
					successMessage("The newly created record is displayed successfully.");
				} else {
					verificationFailedMessage("The newly created record is not displayed");
				}

			} catch (Throwable t) {
				verificationFailedMessage("The newly created record is not displayed");
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

		// VALIDATE THE NAVIGATION AFTER SWITCHING THE PROPERTY FROM THE HEADER OF
		// THE INCIDENT REPORT SCREENS
		title("VALIDATE THE NAVIGATION AFTER SWITCHING THE PROPERTY FROM THE HEADER OF THE INCIDENT REPORT SCREENS");

		try {

			// click on the OHS icon from the property list page
			click("ohsicon_CSS");

			// click on the burger menu
			click("menubtn_CSS");

			// wait for the element
			explicitWaitClickable("questionnaire_option_ohstab_incidentreports_XPATH");

			// click on the incident reports
			click("questionnaire_option_ohstab_incidentreports_XPATH");

			// wait for the element
			explicitWaitClickable("ohs_incident_search_clearbtn_XPATH");

			// click on the clear button
			click("ohs_incident_search_clearbtn_XPATH");

			// enter the newly created incident report in the search field
			type("ohs_incident_searchtxt_CSS", data.get("describe_incident"));

			// click on the search button
			click("ohs_incident_search_searchbtn_CSS");

			// verification of the incident report is added or not
			switchVerification("ohs_navigation_addedincidentreport_XPATH", "Describe OHS Incident Report 2",
					"The Describe OHS Incident Report 2 is not displayed successfully.");

			// click on the newly created incident report
			click("ohs_navigation_addedincidentreport_XPATH");

			// VALIDATE FOR PROPERTY ONE
			title("VALIDATE FOR PROPERTY ONE");

			// validate the property name
			switchVerification("navigation_header_propertyname1_XPATH", "[DND] AAAA Risk Test Prop 01 - 01",
					"The property name is not displayed.");

			// scroll bottom
			scrollBottom();

			// validate the description of the incident report is displayed or not
			try {

				String description_actual = driver
						.findElement(By.cssSelector(OR.getProperty("ohs_incident_shortdescriptiontxt_CSS")))
						.getAttribute("value");

				if (description_actual.equals(data.get("describe_incident"))) {
					successMessage("The description of the incident report is display successfully.");

				} else {
					verificationFailedMessage("The description of the incident report is not display.");

				}
			} catch (Throwable t) {
				verificationFailedMessage("The description of the incident report is not display.");
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

			// scroll bottom
			scrollBottom();

			// validate the description of the incident report is displayed or not
			try {

				String description_actual = driver
						.findElement(By.cssSelector(OR.getProperty("ohs_incident_shortdescriptiontxt_CSS")))
						.getAttribute("value");

				if (description_actual.equals(data.get("describe_incident"))) {
					verificationFailedMessage("The description of the incident report is display.");

				} else {
					successMessage("The description of the incident report is not display as expected.");

				}
			} catch (Throwable t) {
				successMessage("The description of the incident report is not display as expected.");
			}

			// validate the incident report in the listing screen is
			// displayed selected or not
			try {
				String descriptionlist = "//td[text()='" + data.get("describe_incident") + "']";
				boolean descriptionlist_actual = driver.findElement(By.xpath(descriptionlist)).isDisplayed();

				if (descriptionlist_actual == true) {
					verificationFailedMessage("The newly created incident report is display.");

				} else {
					successMessage("The newly created incident report is not display successfully.");

				}
			} catch (Throwable t) {
				successMessage("The newly created incident report is not display successfully.");
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

			// validate the description of the incident report is displayed or not
			try {

				String description_actual = driver
						.findElement(By.cssSelector(OR.getProperty("ohs_incident_shortdescriptiontxt_CSS")))
						.getAttribute("value");

				if (description_actual.equals(data.get("describe_incident"))) {
					verificationFailedMessage("The description of the incident report is display.");

				} else {
					successMessage("The description of the incident report is not display as expected.");

				}
			} catch (Throwable t) {
				successMessage("The description of the incident report is not display as expected.");
			}

			// validate the incident report in the listing screen is
			// displayed selected or not
			try {
				String descriptionlist = "//td[text()='" + data.get("describe_incident") + "']";
				boolean descriptionlist_actual = driver.findElement(By.xpath(descriptionlist)).isDisplayed();

				if (descriptionlist_actual == true) {
					verificationFailedMessage("The newly created incident report is display.");

				} else {
					successMessage("The newly created incident report is not display successfully.");

				}
			} catch (Throwable t) {
				successMessage("The newly created incident report is not display successfully.");
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

			// validate the description of the incident report is displayed or not
			try {

				String description_actual = driver
						.findElement(By.cssSelector(OR.getProperty("ohs_incident_shortdescriptiontxt_CSS")))
						.getAttribute("value");

				if (description_actual.equals(data.get("describe_incident"))) {
					verificationFailedMessage("The description of the incident report is display.");

				} else {
					successMessage("The description of the incident report is not display as expected.");

				}
			} catch (Throwable t) {
				successMessage("The description of the incident report is not display as expected.");
			}

			// validate the incident report in the listing screen is
			// displayed selected or not
			try {
				String descriptionlist = "//td[text()='" + data.get("describe_incident") + "']";
				boolean descriptionlist_actual = driver.findElement(By.xpath(descriptionlist)).isDisplayed();

				if (descriptionlist_actual == true) {
					successMessage("The newly created incident report is display successfully.");

				} else {
					verificationFailedMessage("The newly created incident report is not display.");

				}
			} catch (Throwable t) {
				verificationFailedMessage("The newly created incident report is not display.");
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
		// THE JHS COMMITTEE MEETING MINUTES SCREENS
		title("VALIDATE THE NAVIGATION AFTER SWITCHING THE PROPERTY FROM THE HEADER OF THE JHS COMMITTEE MEETING MINUTES SCREENS");

		try {

			// click on the OHS icon from the property list page
			click("ohsicon_CSS");

			// click on the burger menu
			click("menubtn_CSS");

			// wait for the element
			explicitWaitClickable("ohs_sidemenu_jhsmeetingoption_XPATH");

			// click on the JHS Committee Meeting Minutes
			click("ohs_sidemenu_jhsmeetingoption_XPATH");

			// click on the newly created record
			String record = "//td[text()='" + today
					+ "']//following-sibling::td[text()='2020']//following-sibling::td[text()='January']";
			driver.findElement(By.xpath(record)).click();
			consoleMessage("Clicked on the newly created record.");

			// VALIDATE FOR PROPERTY ONE
			title("VALIDATE FOR PROPERTY ONE");

			// validate the property name
			switchVerification("navigation_header_propertyname1_XPATH", "[DND] AAAA Risk Test Prop 01 - 01",
					"The property name is not displayed.");

			// validate the comment of the JHS Committee Meeting Minutes is displayed or not
			try {

				String description_actual = driver
						.findElement(By.xpath(OR.getProperty("ohs_jhsmeeting_commenttxt_XPATH"))).getAttribute("value");

				if (description_actual.equals(data.get("comment"))) {
					successMessage("The comment of the JHS Committee Meeting Minutes is display successfully.");

				} else {
					verificationFailedMessage("The comment of the JHS Committee Meeting Minutes is not display.");

				}
			} catch (Throwable t) {
				verificationFailedMessage("The comment of the JHS Committee Meeting Minutes is not display.");
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

			// validate the comment of the JHS Committee Meeting Minutes is displayed or not
			try {

				String description_actual = driver
						.findElement(By.xpath(OR.getProperty("ohs_jhsmeeting_commenttxt_XPATH"))).getAttribute("value");

				if (description_actual.equals(data.get("comment"))) {
					verificationFailedMessage("The comment of the JHS Committee Meeting Minutes is display.");

				} else {
					successMessage("The comment of the JHS Committee Meeting Minutes is not display as expected.");

				}
			} catch (Throwable t) {
				successMessage("The comment of the JHS Committee Meeting Minutes is not display as expected.");
			}

			// validate the JHS Committee Meeting Minutes in the listing screen is
			// displayed selected or not
			try {
				String recordlist = "//td[text()='" + today
						+ "']//following-sibling::td[text()='2020']//following-sibling::td[text()='January']";
				boolean recordlist_actual = driver.findElement(By.xpath(recordlist)).isDisplayed();

				if (recordlist_actual == true) {
					verificationFailedMessage("The newly created JHS Committee Meeting Minutes is display.");

				} else {
					successMessage("The newly created JHS Committee Meeting Minutes is not display successfully.");

				}
			} catch (Throwable t) {
				successMessage("The newly created JHS Committee Meeting Minutes is not display successfully.");
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

			// validate the comment of the JHS Committee Meeting Minutes is displayed or not
			try {

				String description_actual = driver
						.findElement(By.xpath(OR.getProperty("ohs_jhsmeeting_commenttxt_XPATH"))).getAttribute("value");

				if (description_actual.equals(data.get("comment"))) {
					verificationFailedMessage("The comment of the JHS Committee Meeting Minutes is display.");

				} else {
					successMessage("The comment of the JHS Committee Meeting Minutes is not display as expected.");

				}
			} catch (Throwable t) {
				successMessage("The comment of the JHS Committee Meeting Minutes is not display as expected.");
			}

			// validate the JHS Committee Meeting Minutes in the listing screen is
			// displayed selected or not
			try {
				String recordlist = "//td[text()='" + today
						+ "']//following-sibling::td[text()='2020']//following-sibling::td[text()='January']";
				boolean recordlist_actual = driver.findElement(By.xpath(recordlist)).isDisplayed();

				if (recordlist_actual == true) {
					verificationFailedMessage("The newly created JHS Committee Meeting Minutes is display.");

				} else {
					successMessage("The newly created JHS Committee Meeting Minutes is not display successfully.");

				}
			} catch (Throwable t) {
				successMessage("The newly created JHS Committee Meeting Minutes is not display successfully.");
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

			// validate the comment of the JHS Committee Meeting Minutes is displayed or not
			try {

				String description_actual = driver
						.findElement(By.xpath(OR.getProperty("ohs_jhsmeeting_commenttxt_XPATH"))).getAttribute("value");

				if (description_actual.equals(data.get("comment"))) {
					verificationFailedMessage("The comment of the JHS Committee Meeting Minutes is display.");

				} else {
					successMessage("The comment of the JHS Committee Meeting Minutes is not display as expected.");

				}
			} catch (Throwable t) {
				successMessage("The comment of the JHS Committee Meeting Minutes is not display as expected.");
			}

			// validate the JHS Committee Meeting Minutes in the listing screen is
			// displayed selected or not
			try {
				String recordlist = "//td[text()='" + today
						+ "']//following-sibling::td[text()='2020']//following-sibling::td[text()='January']";
				boolean recordlist_actual = driver.findElement(By.xpath(recordlist)).isDisplayed();

				if (recordlist_actual == true) {
					successMessage("The newly created JHS Committee Meeting Minutes is display successfully.");

				} else {
					verificationFailedMessage("The newly created JHS Committee Meeting Minutes is not display.");

				}
			} catch (Throwable t) {
				verificationFailedMessage("The newly created JHS Committee Meeting Minutes is not display.");
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
		// THE TASK SCREEN OF THE JHS COMMITTEE MEETING MINUTES
		title("VALIDATE THE NAVIGATION AFTER SWITCHING THE PROPERTY FROM THE HEADER OF THE TASK SCREEN JHS COMMITTEE MEETING MINUTES");

		try {

			// click on the OHS icon from the property list page
			click("ohsicon_CSS");

			// click on the burger menu
			click("menubtn_CSS");

			// wait for the element
			explicitWaitClickable("ohs_sidemenu_jhsmeetingoption_XPATH");

			// click on the JHS Committee Meeting Minutes
			click("ohs_sidemenu_jhsmeetingoption_XPATH");

			// click on the newly created record
			String record = "//td[text()='" + today
					+ "']//following-sibling::td[text()='2020']//following-sibling::td[text()='January']";
			driver.findElement(By.xpath(record)).click();
			consoleMessage("Clicked on the newly created record.");

			// scroll down the screen
			scrollBottom();

			// click on the new task button
			click("ohs_jhsmeeting_addtask_XPATH");

			// VALIDATE FOR PROPERTY ONE
			title("VALIDATE FOR PROPERTY ONE");

			// validate the property name
			switchVerification("navigation_header_propertyname1_XPATH", "[DND] AAAA Risk Test Prop 01 - 01",
					"The property name is not displayed.");

			// validate the task screen of the JHS Committee Meeting Minutes is displayed or
			// not
			try {

				boolean description_actual = driver
						.findElement(By.xpath(OR.getProperty("ohs_jhsmeeting_taskdetailslbl_XPATH"))).isDisplayed();

				if (description_actual == true) {
					successMessage("The task screen of the JHS Committee Meeting Minutes is display successfully.");

				} else {
					verificationFailedMessage("The task screen of the JHS Committee Meeting Minutes is not display.");

				}
			} catch (Throwable t) {
				verificationFailedMessage("The task screen of the JHS Committee Meeting Minutes is not display.");
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

			// validate the task screen of the JHS Committee Meeting Minutes is displayed or
			// not
			try {

				boolean description_actual = driver
						.findElement(By.xpath(OR.getProperty("ohs_jhsmeeting_taskdetailslbl_XPATH"))).isDisplayed();

				if (description_actual == true) {
					verificationFailedMessage("The task screen of the JHS Committee Meeting Minutes is display.");

				} else {
					successMessage("The task screen of the JHS Committee Meeting Minutes is not display as expected.");

				}
			} catch (Throwable t) {
				successMessage("The task screen of the JHS Committee Meeting Minutes is not display as expected.");
			}

			// validate the JHS Committee Meeting Minutes in the listing screen is
			// displayed selected or not
			try {
				String recordlist = "//td[text()='" + today
						+ "']//following-sibling::td[text()='2020']//following-sibling::td[text()='January']";
				boolean recordlist_actual = driver.findElement(By.xpath(recordlist)).isDisplayed();

				if (recordlist_actual == true) {
					verificationFailedMessage("The newly created JHS Committee Meeting Minutes is display.");

				} else {
					successMessage("The newly created JHS Committee Meeting Minutes is not display successfully.");

				}
			} catch (Throwable t) {
				successMessage("The newly created JHS Committee Meeting Minutes is not display successfully.");
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

			// validate the task screen of the JHS Committee Meeting Minutes is displayed or
			// not
			try {

				boolean description_actual = driver
						.findElement(By.xpath(OR.getProperty("ohs_jhsmeeting_taskdetailslbl_XPATH"))).isDisplayed();

				if (description_actual == true) {
					verificationFailedMessage("The task screen of the JHS Committee Meeting Minutes is display.");

				} else {
					successMessage("The task screen of the JHS Committee Meeting Minutes is not display as expected.");

				}
			} catch (Throwable t) {
				successMessage("The task screen of the JHS Committee Meeting Minutes is not display as expected.");
			}

			// validate the JHS Committee Meeting Minutes in the listing screen is
			// displayed selected or not
			try {
				String recordlist = "//td[text()='" + today
						+ "']//following-sibling::td[text()='2020']//following-sibling::td[text()='January']";
				boolean recordlist_actual = driver.findElement(By.xpath(recordlist)).isDisplayed();

				if (recordlist_actual == true) {
					verificationFailedMessage("The newly created JHS Committee Meeting Minutes is display.");

				} else {
					successMessage("The newly created JHS Committee Meeting Minutes is not display successfully.");

				}
			} catch (Throwable t) {
				successMessage("The newly created JHS Committee Meeting Minutes is not display successfully.");
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

			// validate the task screen of the JHS Committee Meeting Minutes is displayed or
			// not
			try {

				boolean description_actual = driver
						.findElement(By.xpath(OR.getProperty("ohs_jhsmeeting_taskdetailslbl_XPATH"))).isDisplayed();

				if (description_actual == true) {
					verificationFailedMessage("The task screen of the JHS Committee Meeting Minutes is display.");

				} else {
					successMessage("The task screen of the JHS Committee Meeting Minutes is not display as expected.");

				}
			} catch (Throwable t) {
				successMessage("The task screen of the JHS Committee Meeting Minutes is not display as expected.");
			}

			// validate the JHS Committee Meeting Minutes in the listing screen is
			// displayed selected or not
			try {
				String recordlist = "//td[text()='" + today
						+ "']//following-sibling::td[text()='2020']//following-sibling::td[text()='January']";
				boolean recordlist_actual = driver.findElement(By.xpath(recordlist)).isDisplayed();

				if (recordlist_actual == true) {
					successMessage("The newly created JHS Committee Meeting Minutes is display successfully.");

				} else {
					verificationFailedMessage("The newly created JHS Committee Meeting Minutes is not display.");

				}
			} catch (Throwable t) {
				verificationFailedMessage("The newly created JHS Committee Meeting Minutes is not display.");
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
		// THE GOVERNMENT LABOR INSPECTION SCREENS
		title("VALIDATE THE NAVIGATION AFTER SWITCHING THE PROPERTY FROM THE HEADER OF THE GOVERNMENT LABOR INSPECTION SCREENS");

		try {

			// click on the OHS icon from the property list page
			click("ohsicon_CSS");

			// click on the burger menu
			click("menubtn_CSS");

			// wait for the element
			explicitWaitClickable("ohs_sidemenu_governmentlaborinspectionoption_XPATH");

			// click on the Government Labor Inspection
			click("ohs_sidemenu_governmentlaborinspectionoption_XPATH");

			// click on the newly created record
			String record = "//td[text()='" + today
					+ "']//following-sibling::td[text()='Open']//following-sibling::td[text()='Yes']";
			driver.findElement(By.xpath(record)).click();
			consoleMessage("Clicked on the newly created record.");

			// VALIDATE FOR PROPERTY ONE
			title("VALIDATE FOR PROPERTY ONE");

			// validate the property name
			switchVerification("navigation_header_propertyname1_XPATH", "[DND] AAAA Risk Test Prop 01 - 01",
					"The property name is not displayed.");

			// validate the comment of the Government Labor Inspection is displayed or not
			try {

				String description_actual = driver
						.findElement(By.xpath(OR.getProperty("ohs_jhsmeeting_commenttxt_XPATH"))).getAttribute("value");

				if (description_actual.equals(data.get("comment"))) {
					successMessage("The comment of the Government Labor Inspection is display successfully.");

				} else {
					verificationFailedMessage("The comment of the Government Labor Inspection is not display.");

				}
			} catch (Throwable t) {
				verificationFailedMessage("The comment of the Government Labor Inspection is not display.");
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

			// validate the comment of the Government Labor Inspection is displayed or not
			try {

				String description_actual = driver
						.findElement(By.xpath(OR.getProperty("ohs_jhsmeeting_commenttxt_XPATH"))).getAttribute("value");

				if (description_actual.equals(data.get("comment"))) {
					verificationFailedMessage("The comment of the Government Labor Inspection is display.");

				} else {
					successMessage("The comment of the Government Labor Inspection is not display as expected.");

				}
			} catch (Throwable t) {
				successMessage("The comment of the Government Labor Inspection is not display as expected.");
			}

			// validate the Government Labor Inspection in the listing screen is
			// displayed selected or not
			try {
				String recordlist = "//td[text()='" + today
						+ "']//following-sibling::td[text()='Open']//following-sibling::td[text()='Yes']";
				boolean recordlist_actual = driver.findElement(By.xpath(recordlist)).isDisplayed();

				if (recordlist_actual == true) {
					verificationFailedMessage("The newly created JHS Committee Meeting Minutes is display.");

				} else {
					successMessage("The newly created JHS Committee Meeting Minutes is not display successfully.");

				}
			} catch (Throwable t) {
				successMessage("The newly created JHS Committee Meeting Minutes is not display successfully.");
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

			// validate the comment of the Government Labor Inspection is displayed or not
			try {

				String description_actual = driver
						.findElement(By.xpath(OR.getProperty("ohs_jhsmeeting_commenttxt_XPATH"))).getAttribute("value");

				if (description_actual.equals(data.get("comment"))) {
					verificationFailedMessage("The comment of the Government Labor Inspection is display.");

				} else {
					successMessage("The comment of the Government Labor Inspection is not display as expected.");

				}
			} catch (Throwable t) {
				successMessage("The comment of the Government Labor Inspection is not display as expected.");
			}

			// validate the Government Labor Inspection in the listing screen is
			// displayed selected or not
			try {
				String recordlist = "//td[text()='" + today
						+ "']//following-sibling::td[text()='Open']//following-sibling::td[text()='Yes']";
				boolean recordlist_actual = driver.findElement(By.xpath(recordlist)).isDisplayed();

				if (recordlist_actual == true) {
					verificationFailedMessage("The newly created JHS Committee Meeting Minutes is display.");

				} else {
					successMessage("The newly created JHS Committee Meeting Minutes is not display successfully.");

				}
			} catch (Throwable t) {
				successMessage("The newly created JHS Committee Meeting Minutes is not display successfully.");
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

			// validate the comment of the Government Labor Inspection is displayed or not
			try {

				String description_actual = driver
						.findElement(By.xpath(OR.getProperty("ohs_jhsmeeting_commenttxt_XPATH"))).getAttribute("value");

				if (description_actual.equals(data.get("comment"))) {
					verificationFailedMessage("The comment of the Government Labor Inspection is display.");

				} else {
					successMessage("The comment of the Government Labor Inspection is not display as expected.");

				}
			} catch (Throwable t) {
				successMessage("The comment of the Government Labor Inspection is not display as expected.");
			}

			// validate the Government Labor Inspection in the listing screen is
			// displayed selected or not
			try {
				String recordlist = "//td[text()='" + today
						+ "']//following-sibling::td[text()='Open']//following-sibling::td[text()='Yes']";
				boolean recordlist_actual = driver.findElement(By.xpath(recordlist)).isDisplayed();

				if (recordlist_actual == true) {
					successMessage("The newly created Government Labor Inspection is display successfully.");

				} else {
					verificationFailedMessage("The newly created Government Labor Inspection is not display.");

				}
			} catch (Throwable t) {
				verificationFailedMessage("The newly created Government Labor Inspection is not display.");
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
		// THE REGULATORY COMPLIANCE SCREENS
		title("VALIDATE THE NAVIGATION AFTER SWITCHING THE PROPERTY FROM THE HEADER OF THE REGULATORY COMPLIANCE SCREENS");

		try {

			// click on the OHS icon from the property list page
			click("ohsicon_CSS");

			// click on the burger menu
			click("menubtn_CSS");

			// wait for the element
			explicitWaitClickable("ohs_sidemenu_regulatorycomplianceoption_XPATH");

			// click on the regulatory compliance
			click("ohs_sidemenu_regulatorycomplianceoption_XPATH");

			// VALIDATE FOR PROPERTY ONE
			title("VALIDATE FOR PROPERTY ONE");

			// validate the property name
			switchVerification("navigation_header_propertyname1_XPATH", "[DND] AAAA Risk Test Prop 01 - 01",
					"The property name is not displayed.");

			// validate the Regulatory Compliance title is displayed or not
			switchVerification("ohs_regulatorycompliancelbl_XPATH", "Regulatory Compliance",
					"The Regulatory Compliance title is not displayed.");

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

			// validate the Regulatory Compliance title is displayed or not
			switchVerification("ohs_regulatorycompliancelbl_XPATH", "Regulatory Compliance",
					"The Regulatory Compliance title is not displayed.");

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

			// validate the Regulatory Compliance title is displayed or not
			switchVerification("ohs_regulatorycompliancelbl_XPATH", "Regulatory Compliance",
					"The Regulatory Compliance title is not displayed.");

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

			// validate the Regulatory Compliance title is displayed or not
			switchVerification("ohs_regulatorycompliancelbl_XPATH", "Regulatory Compliance",
					"The Regulatory Compliance title is not displayed.");

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
		// THE HAZARD ASSESSMENTS/INSPECTIONS SCREENS
		title("VALIDATE THE NAVIGATION AFTER SWITCHING THE PROPERTY FROM THE HEADER OF THE HAZARD ASSESSMENTS/INSPECTIONS SCREENS");

		try {

			// click on the OHS icon from the property list page
			click("ohsicon_CSS");

			// click on the burger menu
			click("menubtn_CSS");

			// wait for the element
			explicitWaitClickable("ohs_sidemenu_hazardassessmentsinspectionsoption_XPATH");

			// click on the incident reports
			click("ohs_sidemenu_hazardassessmentsinspectionsoption_XPATH");

			// click on the newly created record
			String record = "//td[text()='Hazard Assessment']//following-sibling::td[text()='" + today + "']";
			driver.findElement(By.xpath(record)).click();
			consoleMessage("Clicked on the newly created record.");

			// VALIDATE FOR PROPERTY ONE
			title("VALIDATE FOR PROPERTY ONE");

			// validate the property name
			switchVerification("navigation_header_propertyname1_XPATH", "[DND] AAAA Risk Test Prop 01 - 01",
					"The property name is not displayed.");

			// scroll down the screen
			scrollBottom();

			// validate the note of the Hazard Assessment/Inspection is displayed or not
			try {

				String description_actual = driver.findElement(By.xpath(OR.getProperty("ohs_jhsmeeting_notetxt_XPATH")))
						.getAttribute("value");

				if (description_actual.equals(data.get("comment"))) {
					successMessage("The comment of the Hazard Assessment/Inspection is display successfully.");

				} else {
					verificationFailedMessage("The comment of the Hazard Assessment/Inspection is not display.");

				}
			} catch (Throwable t) {
				verificationFailedMessage("The comment of the Hazard Assessment/Inspection is not display.");
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

			// scroll down the screen
			scrollBottom();

			// validate the note of the Hazard Assessment/Inspection is displayed or not
			try {

				String description_actual = driver.findElement(By.xpath(OR.getProperty("ohs_jhsmeeting_notetxt_XPATH")))
						.getAttribute("value");

				if (description_actual.equals(data.get("comment"))) {
					verificationFailedMessage("The comment of the Hazard Assessment/Inspection is display.");

				} else {
					successMessage("The comment of the Hazard Assessment/Inspection is not display as expected.");

				}
			} catch (Throwable t) {
				successMessage("The comment of the Hazard Assessment/Inspection is not display as expected.");
			}

			// scroll top
			scrollTop();

			// validate the Hazard Assessment/Inspection in the listing screen is
			// displayed selected or not
			try {
				String recordlist = "//td[text()='Hazard Assessment']//following-sibling::td[text()='" + today + "']";
				boolean recordlist_actual = driver.findElement(By.xpath(recordlist)).isDisplayed();

				if (recordlist_actual == true) {
					verificationFailedMessage("The newly created Hazard Assessment/Inspection is display.");

				} else {
					successMessage("The newly created Hazard Assessment/Inspection is not display as expected.");

				}
			} catch (Throwable t) {
				successMessage("The newly created Hazard Assessment/Inspection is not display as expected.");
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

			// scroll down the screen
			scrollBottom();

			// validate the note of the Hazard Assessment/Inspection is displayed or not
			try {

				String description_actual = driver.findElement(By.xpath(OR.getProperty("ohs_jhsmeeting_notetxt_XPATH")))
						.getAttribute("value");

				if (description_actual.equals(data.get("comment"))) {
					verificationFailedMessage("The comment of the Hazard Assessment/Inspection is display.");

				} else {
					successMessage("The comment of the Hazard Assessment/Inspection is not display as expected.");

				}
			} catch (Throwable t) {
				successMessage("The comment of the Hazard Assessment/Inspection is not display as expected.");
			}

			// scroll top
			scrollTop();

			// validate the Hazard Assessment/Inspection in the listing screen is
			// displayed selected or not
			try {
				String recordlist = "//td[text()='Hazard Assessment']//following-sibling::td[text()='" + today + "']";
				boolean recordlist_actual = driver.findElement(By.xpath(recordlist)).isDisplayed();

				if (recordlist_actual == true) {
					verificationFailedMessage("The newly created Hazard Assessment/Inspection is display.");

				} else {
					successMessage("The newly created Hazard Assessment/Inspection is not display as expected.");

				}
			} catch (Throwable t) {
				successMessage("The newly created Hazard Assessment/Inspection is not display as expected.");
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

			// scroll down the screen
			scrollBottom();

			// validate the note of the Hazard Assessment/Inspection is displayed or not
			try {

				String description_actual = driver.findElement(By.xpath(OR.getProperty("ohs_jhsmeeting_notetxt_XPATH")))
						.getAttribute("value");

				if (description_actual.equals(data.get("comment"))) {
					verificationFailedMessage("The comment of the Hazard Assessment/Inspection is display.");

				} else {
					successMessage("The comment of the Hazard Assessment/Inspection is not display as expected.");

				}
			} catch (Throwable t) {
				successMessage("The comment of the Hazard Assessment/Inspection is not display as expected.");
			}

			// scroll top
			scrollTop();

			// validate the Hazard Assessment/Inspection in the listing screen is
			// displayed selected or not
			try {
				String recordlist = "//td[text()='Hazard Assessment']//following-sibling::td[text()='" + today + "']";
				boolean recordlist_actual = driver.findElement(By.xpath(recordlist)).isDisplayed();

				if (recordlist_actual == true) {
					successMessage("The newly created Hazard Assessment/Inspection is display successfully.");

				} else {
					verificationFailedMessage("The newly created Hazard Assessment/Inspection is not display.");

				}
			} catch (Throwable t) {
				verificationFailedMessage("The newly created Hazard Assessment/Inspection is not display.");
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
		// THE TASK SCREEN OF THE HAZARD ASSESSMENTS/INSPECTIONS
		title("VALIDATE THE NAVIGATION AFTER SWITCHING THE PROPERTY FROM THE HEADER OF THE TASK SCREEN OF THE HAZARD ASSESSMENTS/INSPECTIONS");

		try {

			// click on the OHS icon from the property list page
			click("ohsicon_CSS");

			// click on the burger menu
			click("menubtn_CSS");

			// wait for the element
			explicitWaitClickable("ohs_sidemenu_hazardassessmentsinspectionsoption_XPATH");

			// click on the incident reports
			click("ohs_sidemenu_hazardassessmentsinspectionsoption_XPATH");

			// click on the newly created record
			String record = "//td[text()='Hazard Assessment']//following-sibling::td[text()='" + today + "']";
			driver.findElement(By.xpath(record)).click();
			consoleMessage("Clicked on the newly created record.");

			// scroll down the screen
			scrollBottom();

			// click on the new hazard button
			click("ohs_hazardassessment_createhazardbtn_XPATH");

			// VALIDATE FOR PROPERTY ONE
			title("VALIDATE FOR PROPERTY ONE");

			// validate the property name
			switchVerification("navigation_header_propertyname1_XPATH", "[DND] AAAA Risk Test Prop 01 - 01",
					"The property name is not displayed.");

			// validate the create hazard screen of the hazard assessments/inspections is
			// displayed or not
			try {

				// scroll top
				scrollTop();

				boolean description_actual = driver
						.findElement(By.xpath(OR.getProperty("ohs_hazardassessment_createhazartitle_XPATH")))
						.isDisplayed();

				if (description_actual == true) {
					successMessage(
							"The create hazard screen of the hazard assessments/inspections is display successfully.");

				} else {
					verificationFailedMessage(
							"The create hazard screen of the hazard assessments/inspections is not display.");

				}
			} catch (Throwable t) {
				verificationFailedMessage(
						"The create hazard screen of the hazard assessments/inspections is not display.");
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

			// validate the create hazard screen of the hazard assessments/inspections is
			// displayed or not
			try {

				// scroll top
				scrollTop();

				boolean description_actual = driver
						.findElement(By.xpath(OR.getProperty("ohs_hazardassessment_createhazartitle_XPATH")))
						.isDisplayed();

				if (description_actual == true) {
					verificationFailedMessage(
							"The create hazard screen of the hazard assessments/inspections is display.");
				} else {
					successMessage(
							"The create hazard screen of the hazard assessments/inspections is not display as expected.");
				}
			} catch (Throwable t) {
				successMessage(
						"The create hazard screen of the hazard assessments/inspections is not display as expected.");
			}

			// validate the Hazard Assessment/Inspection in the listing screen is
			// displayed selected or not
			try {
				String recordlist = "//td[text()='Hazard Assessment']//following-sibling::td[text()='" + today + "']";
				boolean recordlist_actual = driver.findElement(By.xpath(recordlist)).isDisplayed();

				if (recordlist_actual == true) {
					verificationFailedMessage("The newly created Hazard Assessment/Inspection is display.");

				} else {
					successMessage("The newly created Hazard Assessment/Inspection is not display successfully.");

				}
			} catch (Throwable t) {
				successMessage("The newly created Hazard Assessment/Inspection is not display successfully.");
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

			// validate the create hazard screen of the hazard assessments/inspections is
			// displayed or not
			try {

				// scroll top
				scrollTop();

				boolean description_actual = driver
						.findElement(By.xpath(OR.getProperty("ohs_hazardassessment_createhazartitle_XPATH")))
						.isDisplayed();

				if (description_actual == true) {
					verificationFailedMessage(
							"The create hazard screen of the hazard assessments/inspections is display.");
				} else {
					successMessage(
							"The create hazard screen of the hazard assessments/inspections is not display as expected.");
				}
			} catch (Throwable t) {
				successMessage(
						"The create hazard screen of the hazard assessments/inspections is not display as expected.");
			}

			// validate the Hazard Assessment/Inspection in the listing screen is
			// displayed selected or not
			try {
				String recordlist = "//td[text()='Hazard Assessment']//following-sibling::td[text()='" + today + "']";
				boolean recordlist_actual = driver.findElement(By.xpath(recordlist)).isDisplayed();

				if (recordlist_actual == true) {
					verificationFailedMessage("The newly created Hazard Assessment/Inspection is display.");

				} else {
					successMessage("The newly created Hazard Assessment/Inspection is not display successfully.");

				}
			} catch (Throwable t) {
				successMessage("The newly created Hazard Assessment/Inspection is not display successfully.");
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

			// validate the create hazard screen of the hazard assessments/inspections is
			// displayed or not
			try {

				// scroll top
				scrollTop();

				boolean description_actual = driver
						.findElement(By.xpath(OR.getProperty("ohs_hazardassessment_createhazartitle_XPATH")))
						.isDisplayed();

				if (description_actual == true) {
					verificationFailedMessage(
							"The create hazard screen of the hazard assessments/inspections is display.");
				} else {
					successMessage(
							"The create hazard screen of the hazard assessments/inspections is not display as expected.");
				}
			} catch (Throwable t) {
				successMessage(
						"The create hazard screen of the hazard assessments/inspections is not display as expected.");
			}

			// validate the Hazard Assessment/Inspection in the listing screen is
			// displayed selected or not
			try {
				String recordlist = "//td[text()='Hazard Assessment']//following-sibling::td[text()='" + today + "']";
				boolean recordlist_actual = driver.findElement(By.xpath(recordlist)).isDisplayed();

				if (recordlist_actual == true) {
					successMessage("The newly created Hazard Assessment/Inspection is display successfully.");

				} else {
					verificationFailedMessage("The newly created Hazard Assessment/Inspection is not display.");

				}
			} catch (Throwable t) {
				verificationFailedMessage("The newly created Hazard Assessment/Inspection is not display.");
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

		// DELETE THE NEW RECORD OF THE INCIDENT REPORT
		title("DELETE THE CREATE NEW RECORD OF THE INCIDENT REPORT");

		try {

			// click on the OHS icon from the property list page
			click("ohsicon_CSS");

			// click on the burger menu
			click("menubtn_CSS");

			// wait for the element
			explicitWaitClickable("questionnaire_option_ohstab_incidentreports_XPATH");

			// click on the incident reports
			click("questionnaire_option_ohstab_incidentreports_XPATH");

			// click on the newly created incident report
			click("ohs_navigation_addedincidentreport_XPATH");

			// wait for the element
			explicitWaitClickable("ohs_incident_deletebtn_CSS");

			// click on the delete button
			click("ohs_incident_deletebtn_CSS");

			// wait for the element
			explicitWaitClickable("ohs_incident_confirmdeletebtn_CSS");

			// click on the delete button of confirmation popup
			click("ohs_incident_confirmdeletebtn_CSS");

			// verify details are deleted or not
			helper.deleteVerification("ohs_navigation_addedincidentreport_XPATH", "Describe OHS Incident Report 2");

		} catch (Throwable t) {
			verificationFailed();
		}

		// click on the home icon from the top of the screen
		click("questionnaire_homeburgermenubtn_hide_CSS");

		// wait for the element
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// DELETE NEW RECORD OF THE JHS COMMITTEE MEETING MINUTES
		title("DELETE NEW RECORD OF THE JHS COMMITTEE MEETING MINUTES");

		try {

			// click on the OHS icon from the property list page
			click("ohsicon_CSS");

			// click on the burger menu
			click("menubtn_CSS");

			// wait for the element
			explicitWaitClickable("ohs_sidemenu_jhsmeetingoption_XPATH");

			// click on the incident reports
			click("ohs_sidemenu_jhsmeetingoption_XPATH");

			// click on the newly created record
			String record = "//td[text()='" + today
					+ "']//following-sibling::td[text()='2020']//following-sibling::td[text()='January']";
			driver.findElement(By.xpath(record)).click();

			// wait for the element
			explicitWaitClickable("ohs_incident_deletebtn_CSS");

			// click on the delete button
			click("ohs_incident_deletebtn_CSS");

			// wait for the element
			explicitWaitClickable("ohs_incident_confirmdeletebtn_CSS");

			// click on the delete button of confirmation popup
			click("ohs_incident_confirmdeletebtn_CSS");

			try {
				String record1 = "//td[text()='" + today
						+ "']//following-sibling::td[text()='2020']//following-sibling::td[text()='January']";
				boolean record1_actual = driver.findElement(By.xpath(record1)).isDisplayed();

				if (record1_actual == true) {

					verificationFailedMessage("The  record is not deleted.");

				} else {
					successMessage("The record is deleted successfully.");
				}
			} catch (Throwable t) {
				successMessage("The record is deleted successfully.");
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

		// DELETE NEW RECORD OF THE GOVERNMENT LABOR INSPECTION
		title("DELETE NEW RECORD OF THE GOVERNMENT LABOR INSPECTION");

		try {

			// click on the OHS icon from the property list page
			click("ohsicon_CSS");

			// click on the burger menu
			click("menubtn_CSS");

			// wait for the element
			explicitWaitClickable("ohs_sidemenu_governmentlaborinspectionoption_XPATH");

			// click on the incident reports
			click("ohs_sidemenu_governmentlaborinspectionoption_XPATH");

			// click on the newly created record
			String record = "//td[text()='" + today
					+ "']//following-sibling::td[text()='Open']//following-sibling::td[text()='Yes']";
			driver.findElement(By.xpath(record)).click();
			consoleMessage("Clicked on the newly created record.");

			// wait for the element
			explicitWaitClickable("ohs_incident_deletebtn_CSS");

			// click on the delete button
			click("ohs_incident_deletebtn_CSS");

			// wait for the element
			explicitWaitClickable("ohs_incident_confirmdeletebtn_CSS");

			// click on the delete button of confirmation popup
			click("ohs_incident_confirmdeletebtn_CSS");

			try {
				String record1 = "//td[text()='" + today
						+ "']//following-sibling::td[text()='Open']//following-sibling::td[text()='Yes']";
				boolean record1_actual = driver.findElement(By.xpath(record1)).isDisplayed();

				if (record1_actual == true) {

					verificationFailedMessage("The  record is not deleted.");

				} else {
					successMessage("The record is deleted successfully.");
				}
			} catch (Throwable t) {
				successMessage("The record is deleted successfully.");
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

		// CREATE NEW RECORD OF THE IDENTIFIED HAZARDS
		title("CREATE NEW RECORD OF THE IDENTIFIED HAZARDS");

		try {

			// click on the OHS icon from the property list page
			click("ohsicon_CSS");

			// click on the burger menu
			click("menubtn_CSS");

			// wait for the element
			explicitWaitClickable("ohs_sidemenu_hazardassessmentsinspectionsoption_XPATH");

			// click on the incident reports
			click("ohs_sidemenu_hazardassessmentsinspectionsoption_XPATH");

			// click on the newly created record
			String record = "//td[text()='Hazard Assessment']//following-sibling::td[text()='" + today + "']";
			driver.findElement(By.xpath(record)).click();
			consoleMessage("Clicked on the newly created record.");

			// wait for the element
			explicitWaitClickable("ohs_hazardassessment_deletebtn_XPATH");

			// click on the delete button
			click("ohs_hazardassessment_deletebtn_XPATH");

			// wait for the element
			explicitWaitClickable("ohs_hazardassessment_confirmationdeletebtn_XPATH");

			// click on the delete button of confirmation popup
			click("ohs_hazardassessment_confirmationdeletebtn_XPATH");

			try {
				String record1 = "//td[text()='Hazard Assessment']//following-sibling::td[text()='" + today + "']";
				boolean record1_actual = driver.findElement(By.xpath(record1)).isDisplayed();

				if (record1_actual == true) {

					verificationFailedMessage("The  record is not deleted.");

				} else {
					successMessage("The record is deleted successfully.");
				}
			} catch (Throwable t) {
				successMessage("The record is deleted successfully.");
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
