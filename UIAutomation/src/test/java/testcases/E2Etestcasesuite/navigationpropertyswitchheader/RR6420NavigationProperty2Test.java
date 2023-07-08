package testcases.E2Etestcasesuite.navigationpropertyswitchheader;

import java.io.IOException;
import java.util.Hashtable;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

import base.TestBase;
import utilities.TestUtil;

public class RR6420NavigationProperty2Test extends TestBase {

	@Test(dataProviderClass = TestUtil.class, dataProvider = "dp")
	public void rR6420NavigationProperty2Test(Hashtable<String, String> data) throws InterruptedException, IOException {

		execution(data, "rR6420NavigationProperty2Test");

		// TASK MODULE - NAVIGATION SCENARIO OF THE TASK OF THE ENVIRONMENTAL, OHS, RISK
		// MANAGEMENT, PROPERTY PROJECT MODULES
		title("TASK MODULE - NAVIGATION SCENARIO OF THE TASK OF THE ENVIRONMENTAL, OHS, RISK MANAGEMENT, PROPERTY PROJECT MODULES");

		// refresh the page
		driver.navigate().refresh();
		Thread.sleep(5000);
		driver.navigate().refresh();

		// ADD THE TASK IN THE NEWLY CREATED ENVIRONMENTAL REPORTS
		title("ADD THE TASK IN THE NEWLY CREATED ENVIRONMENTAL REPORTS");

		String title1 = RandomStringUtils.randomAlphabetic(8);
		String title11 = RandomStringUtils.randomAlphabetic(8);

		try {
			// click on the environmental icon from the property list page
			click("environmentalicon_CSS");

			// click on the burger menu
			click("menubtn_CSS");

			// wait for the element
			explicitWaitClickable("envreportoption_XPATH");

			// click on the Environmental Reports option
			click("envreportoption_XPATH");

			// click on the Add report button
			click("envreportaddbtn_CSS");

			// select the checklist from the type dropdown
			select("envreporttypedd_CSS", data.get("type"));

			// enter the title
			type("envreporttitletxt_CSS", title1);

			// click on the date field
			click("envreportdatetxt_CSS");

			// enter the company
			type("envreportcompanytxt_CSS", data.get("company"));

			// enter the author
			type("envreportauthortxt_CSS", data.get("author"));

			// enter the description
			type("envreportdescriptiontxt_CSS", data.get("description"));

			// click on the save button
			click("envreportsavebtn_BTNTEXT");

			// wait for the element
			explicitWaitClickable("closetoastmsg_CSS");

			// click on the toaster close button
			click("closetoastmsg_CSS");

			// enter the newly created environmental report in the search field
			type("task_listofchecklist_filterfield_CSS", title1);

			// verification of the environmental report is added or not
			try {
				String record = "//span[text()='" + title1 + "']";
				String record_actual = (driver.findElement(By.xpath(record)).getText()).trim();

				if (record_actual.equals(title1)) {

					successMessage("The " + title1 + " is verified successfully.");

				} else {
					verificationFailedMessage("The " + title1 + " is not verified.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The " + title1 + " is not verified.");
			}

			// click on the added environmental record
			String record = "//span[text()='" + title1 + "']";
			driver.findElement(By.xpath(record)).click();
			consoleMessage("Clicked on the added environmental record.");

			// click on the task tab
			click("envreportaddedrecord_tasktab_XPATH");

			// click on the new task button
			click("envreportaddedrecord_tasktab_newtaskbtn_XPATH");

			// enter the data in the task title field
			type("task_addtask_titletxt_CSS", title11);

			// enter the data in the task location field
			type("task_addtask_locationtxt_CSS", data.get("task_location"));

			// click on the assign to field
			click("task_assigntotxt_CSS");

			// click on the none button
			click("task_tasktag_nonebtn_CSS");

			// enter the user name in the search field
			type("workflowsecurity_editortask_taskdetails_searchtasktagtxt_CSS", data.get("search_user"));

			// click on the searched result
			click("questionnaire_createtask_selectusertxt_XPATH");

			// click on the assign to field
			click("task_assigntotxt_CSS");

			// click on the save button
			click("survey_task_savebtn_CSS");

			// verify newly created task is displayed or not
			try {
				String record11 = "//td[text()='" + title11 + "']";
				String record11_actual = (driver.findElement(By.xpath(record11)).getText()).trim();

				if (record11_actual.equals(title11)) {

					successMessage("The " + title11 + " is verified successfully.");

				} else {
					verificationFailedMessage("The " + title11 + " is not verified.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The " + title11 + " is not verified.");
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

		// ADD THE TASK IN THE NEWLY CREATED INCIDENT REPORT
		title("ADD THE TASK IN THE NEWLY CREATED INCIDENT REPORT");

		String description = RandomStringUtils.randomAlphabetic(8);
		String description1 = RandomStringUtils.randomAlphabetic(8);

		try {
			// click on the OHS icon from the property list page
			click("ohsicon_CSS");

			// click on the burger menu
			click("menubtn_CSS");

			// wait for 10 seconds
			Thread.sleep(5000);

			// click on the incident reports
			click("questionnaire_option_ohstab_incidentreports_XPATH");

			// click on the add button
			click("ohs_incident_addbtn_CSS");

			// wait for the element
			Thread.sleep(5000);

			// enter the incident time - hours
			type("ohs_incident_hourstxt_CSS", "11");

			// enter the incident time - minute
			type("ohs_incident_minutestxt_CSS", "20");

			// scroll down the screen
			scrollBottom();

			// enter the short description
			type("ohs_incident_shortdescriptiontxt_CSS", description);

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

			// click on the next button
			click("ohs_incident_nextbtn_CSS");

			// synchronization
			explicitWait("ohs_incident_nextbtn_CSS");

			// click on the next button
			click("ohs_incident_nextbtn_CSS");

			// synchronization
			explicitWait("ohs_incident_nextbtn_CSS");

			// click on the next button
			click("ohs_incident_nextbtn_CSS");

			// synchronization
			explicitWait("ohs_incident_nextbtn_CSS");

			// click on the next button
			click("ohs_incident_nextbtn_CSS");

			// synchronization
			explicitWait("ohs_incident_nextbtn_CSS");

			// click on the next button
			click("ohs_incident_nextbtn_CSS");

			// synchronization
			explicitWait("ohs_incident_nextbtn_CSS");

			// click on the next button
			click("ohs_incident_nextbtn_CSS");

			// synchronization
			explicitWait("ohs_incident_updaterecordbtn_CSS");

			// click on the update record button
			click("ohs_incident_updaterecordbtn_CSS");

			// wait for 3 seconds
			Thread.sleep(3000);

			// enter the newly created incident report in the search field
			type("ohs_incident_searchtxt_CSS", description);

			// verify newly created task is displayed or not
			try {
				String record2 = "//td[text()='" + description + "']";
				String record2_actual = (driver.findElement(By.xpath(record2)).getText()).trim();

				if (record2_actual.equals(description)) {

					successMessage("The " + description + " is verified successfully.");

				} else {
					verificationFailedMessage("The " + description + " is not verified.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The " + description + " is not verified.");
			}

			// click on the added incident report
			String record2 = "//td[text()='" + description + "']";
			driver.findElement(By.xpath(record2)).click();
			consoleMessage("Clicked on the added incident report.");

			// click on the task tab
			click("ohs_incident_tasktab_CSS");

			// click on the add task button
			click("ohs_incident_tasktab_addbtn_CSS");

			// scroll down the screen
			scrollByPixel(400);

			// enter the data in the task title field
			type("task_addtask_titletxt_CSS", description1);

			// enter the data in the task location field
			type("task_addtask_locationtxt_CSS", data.get("task_location"));

			// click on the assign to field
			click("task_assigntotxt_CSS");

			// click on the none button
			click("task_tasktag_nonebtn_CSS");

			// enter the user name in the search field
			type("workflowsecurity_editortask_taskdetails_searchtasktagtxt_CSS", data.get("search_user"));

			// click on the searched result
			click("questionnaire_createtask_selectusertxt_XPATH");

			// click on the assign to field
			click("task_assigntotxt_CSS");

			// click on the save button
			click("ohs_incident_tasktab_addtaskbtn_CSS");

			// enter the newly created task into the search field
			type("ohs_incident_tasktab_searchtasktxt_CSS", description1);

			// verify newly created task is displayed or not
			try {
				String record22 = "//td[text()='" + description1 + "']";
				String record22_actual = (driver.findElement(By.xpath(record22)).getText()).trim();

				if (record22_actual.equals(description1)) {

					successMessage("The " + description1 + " is verified successfully.");

				} else {
					verificationFailedMessage("The " + description1 + " is not verified.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The " + description1 + " is not verified.");
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

		// ADD THE TASK UNDER NEWLY CREATED INSURANCE CLAIM
		title("ADD THE TASK UNDER NEWLY CREATED INSURANCE CLAIM");

		String incident = RandomStringUtils.randomAlphabetic(8);
		String incident1 = RandomStringUtils.randomAlphabetic(8);

		try {

			// click on the risk management icon from the property list page
			click("riskmanagementicon_CSS");

			// wait for element
			explicitWaitClickable("menubtn_CSS");

			// click on the burger menu
			click("menubtn_CSS");

			// wait for element
			explicitWaitClickable("riskmanagement_insuranceclaimoption_XPATH");

			// click on the insurance claim
			click("riskmanagement_insuranceclaimoption_XPATH");

			// click on the add button
			click("riskmanagement_addinsuranceclaim_CSS");

			// enter the details in the incident
			type("riskmanagement_insuranceclaim_incidenttxt_CSS", incident);

			// select the claim status
			select("riskmanagement_insuranceclaim_claimstatusdd_CSS", data.get("claim_status"));

			// select the claim type
			select("riskmanagement_insuranceclaim_claimtypedd_CSS", data.get("claim_type"));

			// scroll down the screen
			scrollByPixel(400);

			// enter the loss summary statement
			type("riskmanagement_insuranceclaim_losssummarystatementtxt_CSS", data.get("loss_summary_statement"));

			// click on the save button
			click("riskmanagement_insuranceclaim_saveinsuranceclaim_CSS");

			// enter incident into the search field
			type("riskmanagement_insuranceclaim_searchtxt_CSS", incident);

			// verify newly created insurance claim is displayed or not
			try {
				String record3 = "//td[text()='" + incident + "']";
				String record3_actual = (driver.findElement(By.xpath(record3)).getText()).trim();

				if (record3_actual.equals(incident)) {

					successMessage("The " + incident + " is verified successfully.");

				} else {
					verificationFailedMessage("The " + incident + " is not verified.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The " + incident + " is not verified.");
			}

			// click on the newly created insurance claim
			String record3 = "//td[text()='" + incident + "']";
			driver.findElement(By.xpath(record3)).click();
			consoleMessage("Clicked on the newly created insurance claim.");

			// click on the task tab
			click("riskmanagement_insuranceclaim_tasktab_CSS");

			// click on the new task button
			click("checklist_newtaskbtn_CSS");

			// enter the data in the task title field
			type("task_addtask_titletxt_CSS", incident1);

			// enter the data in the task location field
			type("task_addtask_locationtxt_CSS", "USA");

			// click on the assign to field
			click("task_assigntotxt_CSS");

			// click on the none button
			click("task_tasktag_nonebtn_CSS");

			// enter the user name in the search field
			type("workflowsecurity_editortask_taskdetails_searchtasktagtxt_CSS", data.get("search_user"));

			// click on the searched result
			click("questionnaire_createtask_selectusertxt_XPATH");

			// click on the assign to field
			click("task_assigntotxt_CSS");

			// click on the save button
			click("riskmanagement_insuranceclaim_savetaskbtn_CSS");

			// synchronization
			explicitWait("riskmanagement_addedtask_XPATH");

			// verify newly created task is displayed or not
			try {
				String record33 = "//td[text()='" + incident1 + "']";
				String record33_actual = (driver.findElement(By.xpath(record33)).getText()).trim();

				if (record33_actual.equals(incident1)) {

					successMessage("The " + incident1 + " is verified successfully.");

				} else {
					verificationFailedMessage("The " + incident1 + " is not verified.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The " + incident1 + " is not verified.");
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

		// ADD TASK IN THE NEWLY CREATED MORTGAGE UNDERTAKINGS
		title("ADD TASK IN THE NEWLY CREATED MORTGAGE UNDERTAKINGS");

		String morgage = RandomStringUtils.randomAlphabetic(8);
		String morgage1 = RandomStringUtils.randomAlphabetic(8);

		try {

			// click on the property project icon from the property list page
			click("propertyproject_icon_CSS");

			// wait for element
			Thread.sleep(5000);

			// click on the burger menu
			click("menubtn_CSS");

			// wait for element
			Thread.sleep(5000);

			// click on the Mortgage Undertakings
			click("propertyproject_mortgageundertakingsoption_XPATH");

			// click on the add button
			click("propertyproject_mu_addbtn_CSS");

			// enter the undertaking number
			type("propertyproject_mu_undertakingnumbertxt_CSS", morgage);

			// select the lender
			select("propertyproject_mu_lenderdd_CSS", "CMHC");

			// click on the save button
			click("propertyproject_mu_savebtn_CSS");

			// click on the new repair button
			click("propertyproject_mu_newrepairbtn_BTNTEXT");

			// enter the title of the repair
			type("propertyproject_mu_repair_titletxt_CSS", morgage1);

			// scroll down the screen
			scrollByPixel(400);

			// click on assign to field
			click("propertyproject_mu_repair_assigntotxt_CSS");

			// click on the none button
			click("propertyproject_mu_repair_nonebtn_CSS");

			// enter username in search field
			type("propertyproject_mu_repair_searchusertxt_CSS", data.get("search_user"));

			// click on the searched username
			click("propertyproject_mu_repair_searcheduser_XPATH");

			// click on assign to field
			click("propertyproject_mu_repair_assigntotxt_CSS");

			// click on the save button
			click("propertyproject_mu_repair_savebtn_BTNTEXT");

			// wait for the element
			explicitWaitClickable("closetoastmsg_CSS");

			// click on the toaster close button
			click("closetoastmsg_CSS");

			// verify newly created repair is displayed or not
			try {
				String record44 = "//td[text()='" + morgage1 + "']";
				String record44_actual = (driver.findElement(By.xpath(record44)).getText()).trim();

				if (record44_actual.equals(morgage1)) {

					successMessage("The " + morgage1 + " is verified successfully.");

				} else {
					verificationFailedMessage("The " + morgage1 + " is not verified.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The " + morgage1 + " is not verified.");
			}

			// click on the update button
			click("propertyproject_mu_repair_updatebtn_CSS");

			// verification of the Mortgage Undertakings is added or not
			try {
				String record4 = "//td[text()='" + morgage + "']";
				String record4_actual = (driver.findElement(By.xpath(record4)).getText()).trim();

				if (record4_actual.equals(morgage)) {

					successMessage("The " + morgage + " is verified successfully.");

				} else {
					verificationFailedMessage("The " + morgage + " is not verified.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The " + morgage + " is not verified.");
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
		// THE TASK OF THE ENVIRONMENTAL MODULE
		title("VALIDATE THE NAVIGATION AFTER SWITCHING THE PROPERTY FROM THE HEADER OF THE TASK OF THE ENVIRONMENTAL MODULE");

		try {

			// wait for the element
			explicitWaitClickable("taskicon_CSS");

			// click on the task icon from the property list page
			click("taskicon_CSS");

			// click on the clear button
			click("task_createdtask_clearbtn_XPATH");

			// enter the data in the search field
			type("task_filter_CSS", title11);

			// click on the search button
			click("task_createdtask_searchbtn_XPATH");

			// click on the task of the added environmental record
			String record = "//p[text()='" + title11 + "']";
			driver.findElement(By.xpath(record)).click();
			consoleMessage("Clicked on the added environmental record.");

			// VALIDATE FOR PROPERTY ONE
			title("VALIDATE FOR PROPERTY ONE");

			// validate the property name
			switchVerification("navigation_header_propertyname1_XPATH", "[DND] AAAA Risk Test Prop 01 - 01",
					"The property name is not displayed.");

			// validate the task title
			try {
				String taskTitle = driver.findElement(By.cssSelector(OR.getProperty("task_addtask_titletxt_CSS")))
						.getAttribute("value");

				if (taskTitle.equals(title11)) {
					successMessage("The task title is displayed correctly.");
				} else {
					verificationFailedMessage("The task title is not displayed correctly.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The task title is not displayed correctly.");
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

			// validate the task title
			try {
				String taskTitle = driver.findElement(By.cssSelector(OR.getProperty("task_addtask_titletxt_CSS")))
						.getAttribute("value");

				if (taskTitle.equals(title11)) {
					verificationFailedMessage("The task title is displayed correctly.");

				} else {
					successMessage("The task title is not displayed correctly.");
				}
			} catch (Throwable t) {
				successMessage("The task title is not displayed correctly.");
			}

			// validate the newly created task on the task listing screen
			try {
				// click on the clear button
				click("task_createdtask_clearbtn_XPATH");

				// enter the data in the search field
				type("task_filter_CSS", title11);

				// click on the search button
				click("task_createdtask_searchbtn_XPATH");

				String record1 = "//p[text()='" + title11 + "']";
				boolean record1_actual = driver.findElement(By.xpath(record1)).isDisplayed();

				if (record1_actual == true) {

					verificationFailedMessage("The " + title11 + " is displayed.");

				} else {
					successMessage("The " + title11 + " is not displayed as expected.");
				}
			} catch (Throwable t) {
				successMessage("The " + title11 + " is not displayed as expected.");
			}

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

			// validate the task title
			try {
				String taskTitle = driver.findElement(By.cssSelector(OR.getProperty("task_addtask_titletxt_CSS")))
						.getAttribute("value");

				if (taskTitle.equals(title11)) {
					verificationFailedMessage("The task title is displayed correctly.");

				} else {
					successMessage("The task title is not displayed correctly.");
				}
			} catch (Throwable t) {
				successMessage("The task title is not displayed correctly.");
			}

			// validate the newly created task on the task listing screen
			try {
				// click on the clear button
				click("task_createdtask_clearbtn_XPATH");

				// enter the data in the search field
				type("task_filter_CSS", title11);

				// click on the search button
				click("task_createdtask_searchbtn_XPATH");

				String record1 = "//p[text()='" + title11 + "']";
				boolean record1_actual = driver.findElement(By.xpath(record1)).isDisplayed();

				if (record1_actual == true) {

					verificationFailedMessage("The " + title11 + " is displayed.");

				} else {
					successMessage("The " + title11 + " is not displayed as expected.");
				}
			} catch (Throwable t) {
				successMessage("The " + title11 + " is not displayed as expected.");
			}

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

			// validate the task title
			try {
				String taskTitle = driver.findElement(By.cssSelector(OR.getProperty("task_addtask_titletxt_CSS")))
						.getAttribute("value");

				if (taskTitle.equals(title11)) {
					verificationFailedMessage("The task title is displayed correctly.");

				} else {
					successMessage("The task title is not displayed correctly.");
				}
			} catch (Throwable t) {
				successMessage("The task title is not displayed correctly.");
			}

			// validate the newly created task on the task listing screen
			try {
				// click on the clear button
				click("task_createdtask_clearbtn_XPATH");

				// enter the data in the search field
				type("task_filter_CSS", title11);

				// click on the search button
				click("task_createdtask_searchbtn_XPATH");

				String record1 = "//p[text()='" + title11 + "']";
				boolean record1_actual = driver.findElement(By.xpath(record1)).isDisplayed();

				if (record1_actual == true) {
					successMessage("The " + title11 + " is displayed as expected.");

				} else {
					verificationFailedMessage("The " + title11 + " is not displayed.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The " + title11 + " is not displayed.");
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
		// THE TASK OF THE OHS MODULE
		title("VALIDATE THE NAVIGATION AFTER SWITCHING THE PROPERTY FROM THE HEADER OF THE TASK OF THE OHS MODULE");

		try {

			// wait for the element
			explicitWaitClickable("taskicon_CSS");

			// click on the task icon from the property list page
			click("taskicon_CSS");

			// click on the clear button
			click("task_createdtask_clearbtn_XPATH");

			// enter the data in the search field
			type("task_filter_CSS", description1);

			// click on the search button
			click("task_createdtask_searchbtn_XPATH");

			// click on the task of the added environmental record
			String record = "//p[text()='" + description1 + "']";
			driver.findElement(By.xpath(record)).click();
			consoleMessage("Clicked on the added environmental record.");

			// VALIDATE FOR PROPERTY ONE
			title("VALIDATE FOR PROPERTY ONE");

			// validate the property name
			switchVerification("navigation_header_propertyname1_XPATH", "[DND] AAAA Risk Test Prop 01 - 01",
					"The property name is not displayed.");

			// validate the task title
			try {
				String taskTitle = driver.findElement(By.cssSelector(OR.getProperty("task_addtask_titletxt_CSS")))
						.getAttribute("value");

				if (taskTitle.equals(description1)) {
					successMessage("The task title is displayed correctly.");
				} else {
					verificationFailedMessage("The task title is not displayed correctly.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The task title is not displayed correctly.");
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

			// validate the task title
			try {
				String taskTitle = driver.findElement(By.cssSelector(OR.getProperty("task_addtask_titletxt_CSS")))
						.getAttribute("value");

				if (taskTitle.equals(description1)) {
					verificationFailedMessage("The task title is displayed correctly.");

				} else {
					successMessage("The task title is not displayed correctly.");
				}
			} catch (Throwable t) {
				successMessage("The task title is not displayed correctly.");
			}

			// validate the newly created task on the task listing screen
			try {
				// click on the clear button
				click("task_createdtask_clearbtn_XPATH");

				// enter the data in the search field
				type("task_filter_CSS", description1);

				// click on the search button
				click("task_createdtask_searchbtn_XPATH");

				String record1 = "//p[text()='" + description1 + "']";
				boolean record1_actual = driver.findElement(By.xpath(record1)).isDisplayed();

				if (record1_actual == true) {

					verificationFailedMessage("The " + description1 + " is displayed.");

				} else {
					successMessage("The " + description1 + " is not displayed as expected.");
				}
			} catch (Throwable t) {
				successMessage("The " + description1 + " is not displayed as expected.");
			}

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

			// validate the task title
			try {
				String taskTitle = driver.findElement(By.cssSelector(OR.getProperty("task_addtask_titletxt_CSS")))
						.getAttribute("value");

				if (taskTitle.equals(description1)) {
					verificationFailedMessage("The task title is displayed correctly.");

				} else {
					successMessage("The task title is not displayed correctly.");
				}
			} catch (Throwable t) {
				successMessage("The task title is not displayed correctly.");
			}

			// validate the newly created task on the task listing screen
			try {
				// click on the clear button
				click("task_createdtask_clearbtn_XPATH");

				// enter the data in the search field
				type("task_filter_CSS", description1);

				// click on the search button
				click("task_createdtask_searchbtn_XPATH");

				String record1 = "//p[text()='" + description1 + "']";
				boolean record1_actual = driver.findElement(By.xpath(record1)).isDisplayed();

				if (record1_actual == true) {

					verificationFailedMessage("The " + description1 + " is displayed.");

				} else {
					successMessage("The " + description1 + " is not displayed as expected.");
				}
			} catch (Throwable t) {
				successMessage("The " + description1 + " is not displayed as expected.");
			}

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

			// validate the task title
			try {
				String taskTitle = driver.findElement(By.cssSelector(OR.getProperty("task_addtask_titletxt_CSS")))
						.getAttribute("value");

				if (taskTitle.equals(description1)) {
					verificationFailedMessage("The task title is displayed correctly.");

				} else {
					successMessage("The task title is not displayed correctly.");
				}
			} catch (Throwable t) {
				successMessage("The task title is not displayed correctly.");
			}

			// validate the newly created task on the task listing screen
			try {
				// click on the clear button
				click("task_createdtask_clearbtn_XPATH");

				// enter the data in the search field
				type("task_filter_CSS", description1);

				// click on the search button
				click("task_createdtask_searchbtn_XPATH");

				String record1 = "//p[text()='" + description1 + "']";
				boolean record1_actual = driver.findElement(By.xpath(record1)).isDisplayed();

				if (record1_actual == true) {
					successMessage("The " + description1 + " is displayed as expected.");

				} else {
					verificationFailedMessage("The " + description1 + " is not displayed.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The " + description1 + " is not displayed.");
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
		// THE TASK OF THE RISK MANAGEMENT MODULE
		title("VALIDATE THE NAVIGATION AFTER SWITCHING THE PROPERTY FROM THE HEADER OF THE TASK OF THE RISK MANAGEMENT MODULE");

		try {

			// wait for the element
			explicitWaitClickable("taskicon_CSS");

			// click on the task icon from the property list page
			click("taskicon_CSS");

			// click on the clear button
			click("task_createdtask_clearbtn_XPATH");

			// enter the data in the search field
			type("task_filter_CSS", incident1);

			// click on the search button
			click("task_createdtask_searchbtn_XPATH");

			// click on the task of the added incident claim record
			String record = "//p[text()='" + incident1 + "']";
			driver.findElement(By.xpath(record)).click();
			consoleMessage("Clicked on the added incident claim record.");

			// VALIDATE FOR PROPERTY ONE
			title("VALIDATE FOR PROPERTY ONE");

			// validate the property name
			switchVerification("navigation_header_propertyname1_XPATH", "[DND] AAAA Risk Test Prop 01 - 01",
					"The property name is not displayed.");

			// validate the task title
			try {
				String taskTitle = driver.findElement(By.cssSelector(OR.getProperty("task_addtask_titletxt_CSS")))
						.getAttribute("value");

				if (taskTitle.equals(incident1)) {
					successMessage("The task title is displayed correctly.");
				} else {
					verificationFailedMessage("The task title is not displayed correctly.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The task title is not displayed correctly.");
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

			// validate the task title
			try {
				String taskTitle = driver.findElement(By.cssSelector(OR.getProperty("task_addtask_titletxt_CSS")))
						.getAttribute("value");

				if (taskTitle.equals(incident1)) {
					verificationFailedMessage("The task title is displayed correctly.");

				} else {
					successMessage("The task title is not displayed correctly.");
				}
			} catch (Throwable t) {
				successMessage("The task title is not displayed correctly.");
			}

			// validate the newly created task on the task listing screen
			try {
				// click on the clear button
				click("task_createdtask_clearbtn_XPATH");

				// enter the data in the search field
				type("task_filter_CSS", incident1);

				// click on the search button
				click("task_createdtask_searchbtn_XPATH");

				String record1 = "//p[text()='" + incident1 + "']";
				boolean record1_actual = driver.findElement(By.xpath(record1)).isDisplayed();

				if (record1_actual == true) {

					verificationFailedMessage("The " + incident1 + " is displayed.");

				} else {
					successMessage("The " + incident1 + " is not displayed as expected.");
				}
			} catch (Throwable t) {
				successMessage("The " + incident1 + " is not displayed as expected.");
			}

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

			// validate the task title
			try {
				String taskTitle = driver.findElement(By.cssSelector(OR.getProperty("task_addtask_titletxt_CSS")))
						.getAttribute("value");

				if (taskTitle.equals(incident1)) {
					verificationFailedMessage("The task title is displayed correctly.");

				} else {
					successMessage("The task title is not displayed correctly.");
				}
			} catch (Throwable t) {
				successMessage("The task title is not displayed correctly.");
			}

			// validate the newly created task on the task listing screen
			try {
				// click on the clear button
				click("task_createdtask_clearbtn_XPATH");

				// enter the data in the search field
				type("task_filter_CSS", incident1);

				// click on the search button
				click("task_createdtask_searchbtn_XPATH");

				String record1 = "//p[text()='" + incident1 + "']";
				boolean record1_actual = driver.findElement(By.xpath(record1)).isDisplayed();

				if (record1_actual == true) {

					verificationFailedMessage("The " + incident1 + " is displayed.");

				} else {
					successMessage("The " + incident1 + " is not displayed as expected.");
				}
			} catch (Throwable t) {
				successMessage("The " + incident1 + " is not displayed as expected.");
			}

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

			// validate the task title
			try {
				String taskTitle = driver.findElement(By.cssSelector(OR.getProperty("task_addtask_titletxt_CSS")))
						.getAttribute("value");

				if (taskTitle.equals(incident1)) {
					verificationFailedMessage("The task title is displayed correctly.");

				} else {
					successMessage("The task title is not displayed correctly.");
				}
			} catch (Throwable t) {
				successMessage("The task title is not displayed correctly.");
			}

			// validate the newly created task on the task listing screen
			try {
				// click on the clear button
				click("task_createdtask_clearbtn_XPATH");

				// enter the data in the search field
				type("task_filter_CSS", incident1);

				// click on the search button
				click("task_createdtask_searchbtn_XPATH");

				String record1 = "//p[text()='" + incident1 + "']";
				boolean record1_actual = driver.findElement(By.xpath(record1)).isDisplayed();

				if (record1_actual == true) {
					successMessage("The " + incident1 + " is displayed as expected.");

				} else {
					verificationFailedMessage("The " + incident1 + " is not displayed.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The " + incident1 + " is not displayed.");
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
		// THE TASK OF THE PROPERTY PROJECT MODULE
		title("VALIDATE THE NAVIGATION AFTER SWITCHING THE PROPERTY FROM THE HEADER OF THE TASK OF THE PROPERTY PROJECT MODULE");

		try {

			// wait for the element
			explicitWaitClickable("taskicon_CSS");

			// click on the task icon from the property list page
			click("taskicon_CSS");

			// click on the clear button
			click("task_createdtask_clearbtn_XPATH");

			// enter the data in the search field
			type("task_filter_CSS", morgage1);

			// click on the search button
			click("task_createdtask_searchbtn_XPATH");

			// click on the task of the added morgage record
			String record = "//p[text()='" + morgage1 + "']";
			driver.findElement(By.xpath(record)).click();
			consoleMessage("Clicked on the added morgage record.");

			// VALIDATE FOR PROPERTY ONE
			title("VALIDATE FOR PROPERTY ONE");

			// validate the property name
			switchVerification("navigation_header_propertyname1_XPATH", "[DND] AAAA Risk Test Prop 01 - 01",
					"The property name is not displayed.");

			// validate the task title
			try {
				String taskTitle = driver.findElement(By.cssSelector(OR.getProperty("task_addtask_titletxt_CSS")))
						.getAttribute("value");

				if (taskTitle.equals(morgage1)) {
					successMessage("The task title is displayed correctly.");
				} else {
					verificationFailedMessage("The task title is not displayed correctly.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The task title is not displayed correctly.");
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

			// validate the task title
			try {
				String taskTitle = driver.findElement(By.cssSelector(OR.getProperty("task_addtask_titletxt_CSS")))
						.getAttribute("value");

				if (taskTitle.equals(morgage1)) {
					verificationFailedMessage("The task title is displayed correctly.");

				} else {
					successMessage("The task title is not displayed correctly.");
				}
			} catch (Throwable t) {
				successMessage("The task title is not displayed correctly.");
			}

			// validate the newly created task on the task listing screen
			try {
				// click on the clear button
				click("task_createdtask_clearbtn_XPATH");

				// enter the data in the search field
				type("task_filter_CSS", morgage1);

				// click on the search button
				click("task_createdtask_searchbtn_XPATH");

				String record1 = "//p[text()='" + morgage1 + "']";
				boolean record1_actual = driver.findElement(By.xpath(record1)).isDisplayed();

				if (record1_actual == true) {

					verificationFailedMessage("The " + morgage1 + " is displayed.");

				} else {
					successMessage("The " + morgage1 + " is not displayed as expected.");
				}
			} catch (Throwable t) {
				successMessage("The " + morgage1 + " is not displayed as expected.");
			}

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

			// validate the task title
			try {
				String taskTitle = driver.findElement(By.cssSelector(OR.getProperty("task_addtask_titletxt_CSS")))
						.getAttribute("value");

				if (taskTitle.equals(morgage1)) {
					verificationFailedMessage("The task title is displayed correctly.");

				} else {
					successMessage("The task title is not displayed correctly.");
				}
			} catch (Throwable t) {
				successMessage("The task title is not displayed correctly.");
			}

			// validate the newly created task on the task listing screen
			try {
				// click on the clear button
				click("task_createdtask_clearbtn_XPATH");

				// enter the data in the search field
				type("task_filter_CSS", incident1);

				// click on the search button
				click("task_createdtask_searchbtn_XPATH");

				String record1 = "//p[text()='" + morgage1 + "']";
				boolean record1_actual = driver.findElement(By.xpath(record1)).isDisplayed();

				if (record1_actual == true) {

					verificationFailedMessage("The " + morgage1 + " is displayed.");

				} else {
					successMessage("The " + morgage1 + " is not displayed as expected.");
				}
			} catch (Throwable t) {
				successMessage("The " + morgage1 + " is not displayed as expected.");
			}

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

			// validate the task title
			try {
				String taskTitle = driver.findElement(By.cssSelector(OR.getProperty("task_addtask_titletxt_CSS")))
						.getAttribute("value");

				if (taskTitle.equals(morgage1)) {
					verificationFailedMessage("The task title is displayed correctly.");

				} else {
					successMessage("The task title is not displayed correctly.");
				}
			} catch (Throwable t) {
				successMessage("The task title is not displayed correctly.");
			}

			// validate the newly created task on the task listing screen
			try {
				// click on the clear button
				click("task_createdtask_clearbtn_XPATH");

				// enter the data in the search field
				type("task_filter_CSS", morgage1);

				// click on the search button
				click("task_createdtask_searchbtn_XPATH");

				String record1 = "//p[text()='" + morgage1 + "']";
				boolean record1_actual = driver.findElement(By.xpath(record1)).isDisplayed();

				if (record1_actual == true) {
					successMessage("The " + morgage1 + " is displayed as expected.");

				} else {
					verificationFailedMessage("The " + morgage1 + " is not displayed.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The " + morgage1 + " is not displayed.");
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

		// DELETE THE NEWLY CREATED ENVIRONMENTAL REPORTS
		title("DELETE THE NEWLY CREATED ENVIRONMENTAL REPORTS");

		try {
			// click on the environmental icon from the property list page
			click("environmentalicon_CSS");

			// click on the burger menu
			click("menubtn_CSS");

			// wait for the element
			explicitWaitClickable("envreportoption_XPATH");

			// click on the Environmental Reports option
			click("envreportoption_XPATH");

			// click on the added environmental record
			String record = "//span[text()='" + title1 + "']";
			driver.findElement(By.xpath(record)).click();
			consoleMessage("Clicked on the added environmental record.");

			// wait for element
			explicitWaitClickable("envreportdeletebtn_CSS");

			// click on the delete button
			click("envreportdeletebtn_CSS");

			// wait for element
			explicitWaitClickable("envreportmodeldeletebtn_CSS");

			// click on the delete button of the confirmation model
			click("envreportmodeldeletebtn_CSS");

			// enter the environmental report in the search field
			type("task_listofchecklist_filterfield_CSS", title1);

			// verification of the environmental report is added or not
			try {
				String record1 = "//td[text()='" + title1 + "']";
				String record1_actual = (driver.findElement(By.xpath(record1)).getText()).trim();

				if (record1_actual.equals(title1)) {

					successMessage("The " + title1 + " is verified successfully.");

				} else {
					verificationFailedMessage("The " + title1 + " is not verified.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The " + title1 + " is not verified.");
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

		// DELETE THE NEWLY CREATED INCIDENT REPORT
		title("DELETE THE NEWLY CREATED INCIDENT REPORT");

		try {
			// click on the OHS icon from the property list page
			click("ohsicon_CSS");

			// click on the burger menu
			click("menubtn_CSS");

			// wait for 10 seconds
			Thread.sleep(5000);

			// click on the incident reports
			click("questionnaire_option_ohstab_incidentreports_XPATH");

			// click on the added incident report
			String record = "//td[text()='" + description + "']";
			driver.findElement(By.xpath(record)).click();
			consoleMessage("Clicked on the added incident report.");

			// wait for element
			explicitWaitClickable("ohs_incident_deletebtn_CSS");

			// click on the delete button for delete the incident report
			click("ohs_incident_deletebtn_CSS");

			// wait for element
			explicitWaitClickable("ohs_incident_confirmdeletebtn_CSS");

			// click on the delete button of confirmation model for delete the incident
			// report
			click("ohs_incident_confirmdeletebtn_CSS");

			// enter the newly created incident report in the search field
			type("ohs_incident_searchtxt_CSS", description);

			// verify newly created task is displayed or not
			try {
				String record2 = "//td[text()='" + description + "']";
				String record2_actual = (driver.findElement(By.xpath(record2)).getText()).trim();

				if (record2_actual.equals(description)) {
					verificationFailedMessage("The " + description + " is not deleted.");

				} else {
					successMessage("The " + description + " is deleted successfully.");
				}
			} catch (Throwable t) {
				successMessage("The " + description + " is deleted successfully.");
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

		// DELETE THE NEWLY CREATED INSURANCE CLAIM
		title("DELETE THE NEWLY CREATED INSURANCE CLAIM");

		try {

			// click on the risk management icon from the property list page
			click("riskmanagementicon_CSS");

			// wait for element
			explicitWaitClickable("menubtn_CSS");

			// click on the burger menu
			click("menubtn_CSS");

			// wait for element
			explicitWaitClickable("riskmanagement_insuranceclaimoption_XPATH");

			// click on the insurance claim
			click("riskmanagement_insuranceclaimoption_XPATH");

			// click on the added incident claim
			String record = "//td[text()='" + incident + "']";
			driver.findElement(By.xpath(record)).click();
			consoleMessage("Clicked on the added incident claim.");

			// wait for element
			explicitWaitClickable("riskmanagement_insurance_deletebtn_XPATH");

			// click on the delete button
			click("riskmanagement_insurance_deletebtn_XPATH");

			// wait for element
			explicitWaitClickable("riskmanagement_insurance_confirmationdeletebtn_XPATH");

			// click on the delete button of the confirmation model
			click("riskmanagement_insurance_confirmationdeletebtn_XPATH");

			// enter the insurance claim in the search field
			type("riskmanagement_insuranceclaim_searchtxt_CSS", incident);

			// wait for element
			explicitWaitClickable("riskmanagement_insurance_deletebtn_XPATH");

			// click on the delete button
			click("riskmanagement_insurance_deletebtn_XPATH");

			// wait for element
			explicitWaitClickable("riskmanagement_insurance_confirmationdeletebtn_XPATH");

			// click on the delete button of the confirmation model
			click("riskmanagement_insurance_confirmationdeletebtn_XPATH");

			// enter the insurance claim in the search field
			type("riskmanagement_insuranceclaim_searchtxt_CSS", incident);

			// verify newly created task is displayed or not
			try {
				String record2 = "//td[text()='" + incident + "']";
				String record2_actual = (driver.findElement(By.xpath(record2)).getText()).trim();

				if (record2_actual.equals(incident)) {
					verificationFailedMessage("The " + description + " is not deleted.");

				} else {
					successMessage("The " + description + " is deleted successfully.");
				}
			} catch (Throwable t) {
				successMessage("The " + description + " is deleted successfully.");
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

		// DELETE THE NEWLY CREATED MORTGAGE UNDERTAKINGS RECORD
		title("DELETE THE NEWLY CREATED MORTGAGE UNDERTAKINGS RECORD");

		try {
			// click on the property project icon from the property list page
			click("propertyproject_icon_CSS");

			// wait for the element
			explicitWaitClickable("menubtn_CSS");

			// click on the burger menu
			click("menubtn_CSS");

			// wait for the element
			Thread.sleep(5000);

			// click on the Mortgage Undertakings
			click("propertyproject_mortgageundertakingsoption_XPATH");

			// click on the delete icon of the respective record
			String murecord = "//td[text()='" + morgage
					+ "']//following-sibling::td[@ng-show='isMortgageUndertakingsDeleters']//i[@data-target='#removeConfirmationModal']";
			driver.findElement(By.xpath(murecord)).click();
			consoleMessage("Clicked on the delete icon of the respective record.");

			// wait for the element
			explicitWaitClickable("propertyproject_mu_confirmationdeletebtn_CSS");

			// click on the delete button of the confirmation model
			click("propertyproject_mu_confirmationdeletebtn_CSS");

			// wait for the element
			explicitWaitClickable("closetoastmsg_CSS");

			// click on the toaster close button
			click("closetoastmsg_CSS");

			// validate the newly created morgage record
			try {
				String record1 = "//td[text()='" + morgage + "']";
				boolean record1_actual = driver.findElement(By.xpath(record1)).isDisplayed();

				if (record1_actual == true) {
					verificationFailedMessage("The newly created record is displayed.");

				} else {
					successMessage("The newly created record is not displayed.");
				}
			} catch (Throwable t) {
				successMessage("The newly created record is not displayed.");
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

		// DELETE ALL THE NEWLY CREATED TASKS
		title("DELETE ALL THE NEWLY CREATED TASKS");

		try {

			// DELETE THE ENVIRONEMNTAL TASK
			title("DELETE THE ENVIRONMENTAL TASK");

			// click on the task icon
			click("taskicon_CSS");

			// click on the clear button
			click("task_createdtask_clearbtn_XPATH");

			// enter the data in the search field
			type("task_filter_CSS", title1);

			// click on the search button
			click("task_createdtask_searchbtn_XPATH");

			// click on the newly created task
			String record = "//p[text()='" + title1 + "']";
			driver.findElement(By.xpath(record)).click();
			consoleMessage("Clicked on the newly created task.");

			// click on the delete button
			click("task_deletedtaskbtn_CSS");

			// synchronization
			explicitWait("task_deletedtaskbtn_confirmaiton_CSS");

			// click on the delete button of the confirmation popup
			click("task_deletedtaskbtn_confirmaiton_CSS");

			// click on the clear button
			click("task_createdtask_clearbtn_XPATH");

			// enter the data in the search field
			type("task_filter_CSS", title1);

			// click on the search button
			click("task_createdtask_searchbtn_XPATH");

			// verify the delete task is displayed or not
			try {
				String record11 = "//p[text()='" + title11 + "']";
				String record11_actual = (driver.findElement(By.xpath(record11)).getText()).trim();

				if (record11_actual.equals(title11)) {
					verificationFailedMessage("The " + title11 + " is not deleted.");

				} else {
					successMessage("The " + title11 + " is deleted successfully.");
				}
			} catch (Throwable t) {
				successMessage("The " + title11 + " is deleted successfully.");
			}

			// DELETE THE OHS TASK
			title("DELETE THE OHS TASK");

			// click on the clear button
			click("task_createdtask_clearbtn_XPATH");

			// enter the data in the search field
			type("task_filter_CSS", description1);

			// click on the search button
			click("task_createdtask_searchbtn_XPATH");

			// click on the newly created task
			String record1 = "//p[text()='" + description1 + "']";
			driver.findElement(By.xpath(record1)).click();
			consoleMessage("Clicked on the newly created task.");

			// click on the delete button
			click("task_deletedtaskbtn_CSS");

			// synchronization
			explicitWait("task_deletedtaskbtn_confirmaiton_CSS");

			// click on the delete button of the confirmation popup
			click("task_deletedtaskbtn_confirmaiton_CSS");

			// click on the clear button
			click("task_createdtask_clearbtn_XPATH");

			// enter the data in the search field
			type("task_filter_CSS", description1);

			// click on the search button
			click("task_createdtask_searchbtn_XPATH");

			// verify the delete task is displayed or not
			try {
				String record11 = "//p[text()='" + description1 + "']";
				String record11_actual = (driver.findElement(By.xpath(record11)).getText()).trim();

				if (record11_actual.equals(description1)) {
					verificationFailedMessage("The " + description1 + " is not deleted.");

				} else {
					successMessage("The " + description1 + " is deleted successfully.");
				}
			} catch (Throwable t) {
				successMessage("The " + description1 + " is deleted successfully.");
			}

			// DELETE THE RISM MANAGEMENT TASK
			title("DELETE THE RISM MANAGEMENT TASK");

			// click on the clear button
			click("task_createdtask_clearbtn_XPATH");

			// enter the data in the search field
			type("task_filter_CSS", incident1);

			// click on the search button
			click("task_createdtask_searchbtn_XPATH");

			// click on the newly created task
			String record3 = "//p[text()='" + incident1 + "']";
			driver.findElement(By.xpath(record3)).click();
			consoleMessage("Clicked on the newly created task.");

			// click on the delete button
			click("task_deletedtaskbtn_CSS");

			// synchronization
			explicitWait("task_deletedtaskbtn_confirmaiton_CSS");

			// click on the delete button of the confirmation popup
			click("task_deletedtaskbtn_confirmaiton_CSS");

			// click on the clear button
			click("task_createdtask_clearbtn_XPATH");

			// enter the data in the search field
			type("task_filter_CSS", incident1);

			// click on the search button
			click("task_createdtask_searchbtn_XPATH");

			// verify the delete task is displayed or not
			try {
				String record11 = "//p[text()='" + incident1 + "']";
				String record11_actual = (driver.findElement(By.xpath(record11)).getText()).trim();

				if (record11_actual.equals(incident1)) {
					verificationFailedMessage("The " + incident1 + " is not deleted.");

				} else {
					successMessage("The " + incident1 + " is deleted successfully.");
				}
			} catch (Throwable t) {
				successMessage("The " + incident1 + " is deleted successfully.");
			}

			// DELETE THE PROPERTY PROJECT TASK
			title("DELETE THE PROPERTY PROJECT TASK");

			// click on the clear button
			click("task_createdtask_clearbtn_XPATH");

			// enter the data in the search field
			type("task_filter_CSS", morgage1);

			// click on the search button
			click("task_createdtask_searchbtn_XPATH");

			// click on the newly created task
			String record4 = "//p[text()='" + morgage1 + "']";
			driver.findElement(By.xpath(record4)).click();
			consoleMessage("Clicked on the newly created task.");

			// click on the delete button
			click("task_deletedtaskbtn_CSS");

			// synchronization
			explicitWait("task_deletedtaskbtn_confirmaiton_CSS");

			// click on the delete button of the confirmation popup
			click("task_deletedtaskbtn_confirmaiton_CSS");

			// click on the clear button
			click("task_createdtask_clearbtn_XPATH");

			// enter the data in the search field
			type("task_filter_CSS", morgage1);

			// click on the search button
			click("task_createdtask_searchbtn_XPATH");

			// verify the delete task is displayed or not
			try {
				String record11 = "//p[text()='" + morgage1 + "']";
				String record11_actual = (driver.findElement(By.xpath(record11)).getText()).trim();

				if (record11_actual.equals(morgage1)) {
					verificationFailedMessage("The " + morgage1 + " is not deleted.");

				} else {
					successMessage("The " + morgage1 + " is deleted successfully.");
				}
			} catch (Throwable t) {
				successMessage("The " + morgage1 + " is deleted successfully.");
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
