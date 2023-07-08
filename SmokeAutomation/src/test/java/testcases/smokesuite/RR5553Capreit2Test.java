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

public class RR5553Capreit2Test extends TestBase {

	@Test(dataProviderClass = TestUtil.class, dataProvider = "dp")
	public void rR5553Capreit2Test(Hashtable<String, String> data) throws IOException, InterruptedException {

		if (!(TestUtil.isTestRunnable("rR5553Capreit2Test", excel))) {

			throw new SkipException(
					"Skipping the test " + "rR5553Capreit2Test".toUpperCase() + "as the Run mode is NO");
		}

		if (!data.get("runmode").equals("Y")) {

			throw new SkipException("Skipping the test case as the Run Mode for data set is NO");
		}

		// refresh the page
		driver.navigate().refresh();
		Thread.sleep(5000);
		driver.navigate().refresh();

		// VERIFY THE INCIDENTS SUBSTANCE SPILL WORKFLOW - CAPREIT

		System.out.println("VERIFY THE INCIDENTS SUBSTANCE SPILL WORKFLOW - CAPREIT .");
		test.log(LogStatus.INFO, "VERIFY THE INCIDENTS SUBSTANCE SPILL WORKFLOW - CAPREIT .");
		Reporter.log("VERIFY THE INCIDENTS SUBSTANCE SPILL WORKFLOW - CAPREIT .");
		log.info("VERIFY THE INCIDENTS SUBSTANCE SPILL WORKFLOW - CAPREIT .");

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

		System.out.println("Navigate to the Home Screen i.e. Property List Screen.");

		// UPDATE THE INCIDENT EVENT TYPE FOR THE INCIDENTS SUBSTANCE SPILL WORKFLOW

		System.out.println(
				"******************** UPDATE THE INCIDENT EVENT TYPE FOR THE INCIDENTS SUBSTANCE SPILL WORKFLOW ********************");
		test.log(LogStatus.INFO,
				"******************** UPDATE THE INCIDENT EVENT TYPE FOR THE INCIDENTS SUBSTANCE SPILL WORKFLOW ********************");
		Reporter.log(
				"******************** UPDATE THE INCIDENT EVENT TYPE FOR THE INCIDENTS SUBSTANCE SPILL WORKFLOW ********************");
		log.info(
				"******************** UPDATE THE INCIDENT EVENT TYPE FOR THE INCIDENTS SUBSTANCE SPILL WORKFLOW ********************");

		try {
			// wait for the element
			explicitWaitClickable("questionnaire_settingicon_CSS");

			// click on the settings icon from the top of the screen
			click("questionnaire_settingicon_CSS");
			System.out.println("Clicked on the settings icon.");
			ngDriver.waitForAngularRequestsToFinish();

			// wait for the element
			explicitWaitClickable("questionnaire_administrationoption_XPATH");

			// click on the administration option from the side menu
			click("questionnaire_administrationoption_XPATH");
			System.out.println("Clicked on the administration option from the side menu.");
			ngDriver.waitForAngularRequestsToFinish();

			// scroll down the screen
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,400)");

			// click on the OHS tab
			click("questionnaire_ohstab_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the OHS tab.");

			// click on the Incident Event Types
			click("questionnaire_incidenteventtypeoption_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the Incident Event Types.");

			// scroll down the screen
			WebElement substancespilloption = driver
					.findElement(By.xpath(OR.getProperty("ohs_incident_substancespill_XPATH")));
			js.executeScript("arguments[0].scrollIntoView(true);", substancespilloption);
			js.executeScript("window.scrollBy(0,-400)");

			// click on the substance spill record
			click("ohs_incident_substancespill_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the substance spill record.");

			// scroll down the screen
			js.executeScript("window.scrollBy(0,400)");

			try {
				boolean isSpill = driver
						.findElement(By.cssSelector(OR.getProperty("ohs_incident_substancespill_checkbox_CSS")))
						.isSelected();

				System.out.println("//////////////////// isSpill " + isSpill);

				if (isSpill != true) {

					// click on the isSpill checkbox
					click("ohs_incident_substancespill_checkbox_CSS");
					ngDriver.waitForAngularRequestsToFinish();
					System.out.println("Clicked on the isSpill checkbox.");

					// click on update button
					click("ohs_incident_alertnotification_updatebtn_CSS");
					ngDriver.waitForAngularRequestsToFinish();
					System.out.println("Clicked on update button.");

				} else {
					// click on update button
					click("ohs_incident_alertnotification_updatebtn_CSS");
					ngDriver.waitForAngularRequestsToFinish();
					System.out.println("Clicked on update button.");
				}

			} catch (Throwable t) {
				verificationFailed();

				// click on update button
				click("ohs_incident_alertnotification_updatebtn_CSS");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on update button.");
			}

			// scroll down the screen
			WebElement employeeinjuryoption = driver
					.findElement(By.xpath(OR.getProperty("ohs_incident_employeeinjury_XPATH")));
			js.executeScript("arguments[0].scrollIntoView(true);", employeeinjuryoption);
			js.executeScript("window.scrollBy(0,-400)");

			// click on the Employee Injury record
			click("ohs_incident_employeeinjury_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the Employee Injury record.");

			// scroll down the screen
			js.executeScript("window.scrollBy(0,400)");

			try {
				boolean injuryRequired = driver
						.findElement(By.cssSelector(OR.getProperty("ohs_incident_employeeinjury_checkbox_CSS")))
						.isSelected();

				System.out.println("//////////////////// injuryRequired " + injuryRequired);

				if (injuryRequired != true) {

					// click on the isSpill checkbox
					click("ohs_incident_employeeinjury_checkbox_CSS");
					ngDriver.waitForAngularRequestsToFinish();
					System.out.println("Clicked on the isSpill checkbox.");

					// click on update button
					click("ohs_incident_alertnotification_updatebtn_CSS");
					ngDriver.waitForAngularRequestsToFinish();
					System.out.println("Clicked on update button.");

				} else {
					// click on update button
					click("ohs_incident_alertnotification_updatebtn_CSS");
					ngDriver.waitForAngularRequestsToFinish();
					System.out.println("Clicked on update button.");
				}

			} catch (Throwable t) {
				verificationFailed();

				// click on update button
				click("ohs_incident_alertnotification_updatebtn_CSS");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on update button.");
			}

		} catch (Throwable t) {
			verificationFailed();
		}

		// click on the home icon from the top of the screen
		click("questionnaire_homeburgermenubtn_CSS");
		System.out.println("Clicked on the home icon from the top of the screen.");
		ngDriver.waitForAngularRequestsToFinish();

		// synchronization
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// CREATE NEW INCIDENT REPORT

		System.out.println("********** CREATE NEW INCIDENT REPORT **********");
		test.log(LogStatus.INFO, "********** CREATE NEW INCIDENT REPORT **********");
		Reporter.log("********** CREATE NEW INCIDENT REPORT **********");
		log.info("********** CREATE NEW INCIDENT REPORT **********");

		try {

			// enter the property name in the search field
			type("envreports_propertylist_filtertxt_CSS", data.get("property_1"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the property name in the search field.");

			// click on the OHS icon from the property list page
			click("ohsicon_CSS");
			System.out.println("Clicked on the OHS icon of the Property.");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Navigate to the OHS screen of the perticular property.");

			// wait for the element
			Thread.sleep(5000);

			// click on the burger menu
			click("menubtn_CSS");
			System.out.println("Clicked on the burger menu button successfully!!!");
			ngDriver.waitForAngularRequestsToFinish();

			// wait for the element
			Thread.sleep(5000);

			// click on the incident reports
			click("questionnaire_option_ohstab_incidentreports_XPATH");
			System.out.println("Clicked on the incident reports option.");
			ngDriver.waitForAngularRequestsToFinish();

			// ADD DETAILS IN THE INCIDENT REPORT TAB

			System.out.println("********** ADD DETAILS IN THE INCIDENT REPORT TAB **********");
			test.log(LogStatus.INFO, "********** ADD DETAILS IN THE INCIDENT REPORT TAB **********");
			Reporter.log("********** ADD DETAILS IN THE INCIDENT REPORT TAB **********");
			log.info("********** ADD DETAILS IN THE INCIDENT REPORT TAB **********");

			// click on the add button
			click("ohs_incident_addbtn_CSS");
			System.out.println("Clicked on the Add button.");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Navigate to the Add incident report Screen");

			// wait for the element
			Thread.sleep(7000);

			// enter the incident time - hours
			clear("ohs_incident_hourstxt_CSS");
			System.out.println("Cleared the hours field of incident time.");
			ngDriver.waitForAngularRequestsToFinish();
			type("ohs_incident_hourstxt_CSS", "11");
			System.out.println("Entered the hours in the incident time.");
			ngDriver.waitForAngularRequestsToFinish();

			// enter the incident time - minute
			clear("ohs_incident_minutestxt_CSS");
			System.out.println("Cleared the minute field of incident time.");
			ngDriver.waitForAngularRequestsToFinish();
			type("ohs_incident_minutestxt_CSS", "20");
			System.out.println("Entered the minute in the incident time.");
			ngDriver.waitForAngularRequestsToFinish();

			// scroll down the screen
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,500)");

			// enter the short description
			type("ohs_incident_shortdescriptiontxt_CSS", data.get("describe_incident"));
			System.out.println("Entered the short description");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the add event type button
			click("ohs_incident_addeventtypebtn_CSS");
			System.out.println("Clicked on the add event type button.");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the event type dropdown
			select("ohs_incident_eventtypedd_CSS", data.get("substance_spill"));
			System.out.println("Clicked on the event type dropdown.");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the add button of the add event type record model
			click("ohs_incident_eventty_addbtn_CSS");
			System.out.println("Clicked on the add button of the add event type record model.");
			ngDriver.waitForAngularRequestsToFinish();

			// wait for the element
			Thread.sleep(5000);

			try {
				// verify the spill information tab is displayed or not
				String spillInformation = driver
						.findElement(By.cssSelector(OR.getProperty("ohs_incident_spillinformationtab_CSS"))).getText();
				String finalSpillInformation = spillInformation.trim();

				if (finalSpillInformation.equals("Spill Information")) {

					System.out.println("THE SPILL INFORMATION TAB IS DISPLAYED SUCCESSFULLY.");
					test.log(LogStatus.INFO, "THE SPILL INFORMATION TAB IS DISPLAYED SUCCESSFULLY.");
					Reporter.log("THE SPILL INFORMATION TAB IS DISPLAYED SUCCESSFULLY.");
					log.info("THE SPILL INFORMATION TAB IS DISPLAYED SUCCESSFULLY.");

				} else {
					verificationFailed();
				}
			} catch (Throwable t) {
				verificationFailed();
			}
		} catch (Throwable t) {
			verificationFailed();
		}

		try {

			// click on the next button
			click("ohs_incident_nextbtn_CSS");
			System.out.println("Clicked on the next button.");
			ngDriver.waitForAngularRequestsToFinish();

			// synchronization
			explicitWait("ohs_incident_nextbtn_CSS");
			System.out.println("Navigate to the Spill Information Tab.");
			test.log(LogStatus.INFO, "Navigate to the Spill Information Tab.");
			Reporter.log("Navigate to the Spill Information Tab.");
			log.info("Navigate to the Spill Information Tab.");

			// ADD DETAILS IN THE SPILL INFORMATION TAB

			System.out.println("********** ADD DETAILS IN THE SPILL INFORMATION TAB **********");
			test.log(LogStatus.INFO, "********** ADD DETAILS IN THE SPILL INFORMATION TAB **********");
			Reporter.log("********** ADD DETAILS IN THE SPILL INFORMATION TAB **********");
			log.info("********** ADD DETAILS IN THE SPILL INFORMATION TAB **********");

			// Enter the data in the location details field
			type("ohs_incident_spillinformationtab_locationdetailstxt_CSS", data.get("location_details"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the data in the location details field.");

		} catch (Throwable t) {
			verificationFailed();
		}

		try {

			// click on the previous button
			click("ohs_incident_previousbtn_XPATH");
			System.out.println("Clicked on the next button.");
			ngDriver.waitForAngularRequestsToFinish();

			// synchronization
			explicitWait("ohs_incident_nextbtn_CSS");
			System.out.println("Navigate to the Incident Summary Tab.");
			test.log(LogStatus.INFO, "Navigate to the Incident Summary Tab.");
			Reporter.log("Navigate to the Incident Summary Tab.");
			log.info("Navigate to the Incident Summary Tab.");

			// UPDATE THE EVENT TYPE

			System.out.println("********** UPDATE THE EVENT TYPE **********");
			test.log(LogStatus.INFO, "********** UPDATE THE EVENT TYPE **********");
			Reporter.log("********** UPDATE THE EVENT TYPE **********");
			log.info("********** UPDATE THE EVENT TYPE **********");

			// scroll down the screen
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,500)");

			// delete the previously added event type
			click("ohs_incident_deleteeventbtn_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Deleted the previously added event type.");

			// wait for the element
			Thread.sleep(5000);

			// click on the delete button of confirmation message
			click("ohs_incident_confirmation_deleteeventbtn_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the delete button of confirmation message.");

			// click on the add event type button
			click("ohs_incident_addeventtypebtn_CSS");
			System.out.println("Clicked on the add event type button.");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the event type dropdown
			select("ohs_incident_eventtypedd_CSS", data.get("employee_injury"));
			System.out.println("Clicked on the event type dropdown.");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the add button of the add event type record model
			click("ohs_incident_eventty_addbtn_CSS");
			System.out.println("Clicked on the add button of the add event type record model.");
			ngDriver.waitForAngularRequestsToFinish();

			// wait for the element
			Thread.sleep(5000);

			try {
				// verify the spill information tab is displayed or not
				String spillInformation = driver
						.findElement(By.cssSelector(OR.getProperty("ohs_incident_spillinformationtab_CSS"))).getText();
				String finalSpillInformation = spillInformation.trim();

				if (finalSpillInformation.equals("Spill Information")) {

					verificationFailed();

				}
			} catch (Throwable t) {
				System.out.println("THE SPILL INFORMATION TAB IS NOT DISPLAYED AS EXPECTED.");
				test.log(LogStatus.INFO, "THE SPILL INFORMATION TAB IS NOT DISPLAYED AS EXPECTED.");
				Reporter.log("THE SPILL INFORMATION TAB IS NOT DISPLAYED AS EXPECTED.");
				log.info("THE SPILL INFORMATION TAB IS NOT DISPLAYED AS EXPECTED.");
			}

		} catch (Throwable t) {
			verificationFailed();
		}

		try {

			// click on the next button
			click("ohs_incident_nextbtn_CSS");
			System.out.println("Clicked on the next button.");
			ngDriver.waitForAngularRequestsToFinish();

			// synchronization
			explicitWait("ohs_incident_nextbtn_CSS");
			System.out.println("Navigate to the Details, Cause Tab.");
			test.log(LogStatus.INFO, "Navigate to the Details, Cause Tab..");
			Reporter.log("Navigate to the Details, Cause Tab..");
			log.info("Navigate to the Details, Cause Tab..");

			// ADD DETAILS IN THE DETAILS, CAUSES TAB

			System.out.println("********** ADD DETAILS IN THE DETAILS, CAUSES TAB **********");
			test.log(LogStatus.INFO, "********** ADD DETAILS IN THE DETAILS, CAUSES TAB **********");
			Reporter.log("********** ADD DETAILS IN THE DETAILS, CAUSES TAB **********");
			log.info("********** ADD DETAILS IN THE DETAILS, CAUSES TAB **********");

			// Enter the data in the description incident field
			type("ohs_incident_descriptionincidenttxt_CSS", data.get("describe_incident"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the data in the description incident field.");

			// Enter the data in the Incident Cause field
			type("ohs_incident_incidentcausetxt_CSS", data.get("incident_cause"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the data in the Incident Cause field.");

			// scroll down the screen
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,400)");

			// Enter the data in the Actions Taken field
			type("ohs_incident_actionstakentxt_CSS", data.get("actions_taken"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the data in the Actions Taken field.");

		} catch (Throwable t) {
			verificationFailed();
		}

		// VERIFY USER ALLOW TO MOVE WITHOUT ENTERED DETAILS IN THE PERSONS INVOLVED TAB
		// AND SPECIFY THE NATURE OF INJURY AND CAUSE OF INJURY.

		System.out.println(
				"********** VERIFY USER ALLOW TO MOVE WITHOUT ENTERED DETAILS IN THE PERSONS INVOLVED TAB AND SPECIFY THE NATURE OF INJURY AND CAUSE OF INJURY. **********");
		test.log(LogStatus.INFO,
				"********** VERIFY USER ALLOW TO MOVE WITHOUT ENTERED DETAILS IN THE PERSONS INVOLVED TAB AND SPECIFY THE NATURE OF INJURY AND CAUSE OF INJURY. **********");
		Reporter.log(
				"********** VERIFY USER ALLOW TO MOVE WITHOUT ENTERED DETAILS IN THE PERSONS INVOLVED TAB AND SPECIFY THE NATURE OF INJURY AND CAUSE OF INJURY. **********");
		log.info(
				"********** VERIFY USER ALLOW TO MOVE WITHOUT ENTERED DETAILS IN THE PERSONS INVOLVED TAB AND SPECIFY THE NATURE OF INJURY AND CAUSE OF INJURY. **********");

		try {

			// click on the next button
			click("ohs_incident_nextbtn_CSS");
			System.out.println("Clicked on the next button.");
			ngDriver.waitForAngularRequestsToFinish();

			// synchronization
			explicitWait("ohs_incident_personsinvolved_addbtn_CSS");
			System.out.println("Navigate to the Persons Involved Tab.");
			test.log(LogStatus.INFO, "Navigate to the Persons Involved Tab.");
			Reporter.log("Navigate to the Persons Involved Tab.");
			log.info("Navigate to the Persons Involved Tab.");

			// click on the next button
			click("ohs_incident_nextbtn_CSS");
			System.out.println("Clicked on the next button.");
			ngDriver.waitForAngularRequestsToFinish();

			// synchronization
			explicitWait("ohs_incident_nextbtn_CSS");
			System.out.println("Navigate to the Witnesses Tab.");
			test.log(LogStatus.INFO, "Navigate to the Witnesses Tab.");
			Reporter.log("Navigate to the Witnesses Tab.");
			log.info("Navigate to the Witnesses Tab.");

			try {

				// wait for the element
				explicitWait("ohs_incident_mandatorytext_XPATH");

				// verify validation is work or not
				boolean validationmsg = driver.findElement(By.xpath(OR.getProperty("ohs_incident_mandatorytext_XPATH")))
						.isDisplayed();

				if (validationmsg == true) {

					System.out.println("THE VALIDATION IS DISPLAYED SUCCESSFULLY AS EXPECTED.");
					test.log(LogStatus.INFO, "THE VALIDATION IS DISPLAYED SUCCESSFULLY AS EXPECTED.");
					Reporter.log("THE VALIDATION IS DISPLAYED SUCCESSFULLY AS EXPECTED.");
					log.info("THE VALIDATION IS DISPLAYED SUCCESSFULLY AS EXPECTED.");

				} else {
					verificationFailed();
				}

			} catch (Throwable t) {
				verificationFailed();
			}

			// click on the previous button
			click("ohs_incident_previousbtn_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the previous button.");

		} catch (Throwable t) {
			verificationFailed();
		}

		try {

			// click on the next button
			click("ohs_incident_nextbtn_CSS");
			System.out.println("Clicked on the next button.");
			ngDriver.waitForAngularRequestsToFinish();

			// synchronization
			explicitWait("ohs_incident_personsinvolved_addbtn_CSS");
			System.out.println("Navigate to the Persons Involved Tab.");
			test.log(LogStatus.INFO, "Navigate to the Persons Involved Tab.");
			Reporter.log("Navigate to the Persons Involved Tab.");
			log.info("Navigate to the Persons Involved Tab.");

			// ADD DETAILS IN THE PERSONS INVOLVED TAB

			System.out.println("********** ADD DETAILS IN THE PERSONS INVOLVED TAB **********");
			test.log(LogStatus.INFO, "********** ADD DETAILS IN THE PERSONS INVOLVED TAB **********");
			Reporter.log("********** ADD DETAILS IN THE PERSONS INVOLVED TAB **********");
			log.info("********** ADD DETAILS IN THE PERSONS INVOLVED TAB **********");

			try {

				// wait for the element
				Thread.sleep(7000);

				// click on the add button
				click("ohs_incident_personsinvolved_addbtn_CSS");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the add button");

				// select an employee option from the type dropdown
				select("ohs_incident_typedd_CSS", data.get("person_type"));
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Selected an employee option from the type dropdown.");

				// enter data in the Insurance Company Name field
				type("ohs_incident_insurancecompanynametxt_CSS", data.get("insurance_company_name"));
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Entered data in the Insurance Company Name field.");

				// enter data in the Insurance Policy Number field
				type("ohs_incident_insurancepolicynumbertxt_CSS", data.get("insurance_policy_number"));
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Entered data in the Insurance Policy Number field.");

				try {
					boolean injuredcheckbox = driver
							.findElement(By.xpath(OR.getProperty("ohs_incident_isinjured_disabled_XPATH")))
							.isDisplayed();

					if (injuredcheckbox == true) {
						System.out.println("THE PERSON INJURED CHECKBOX DISPLAYED DISABLED SUCCESSFULLY AS EXPECTED.");
						test.log(LogStatus.INFO,
								"THE PERSON INJURED CHECKBOX DISPLAYED DISABLED SUCCESSFULLY AS EXPECTED.");
						Reporter.log("THE PERSON INJURED CHECKBOX DISPLAYED DISABLED SUCCESSFULLY AS EXPECTED.");
						log.info("THE PERSON INJURED CHECKBOX DISPLAYED DISABLED SUCCESSFULLY AS EXPECTED.");
					} else {
						verificationFailed();
					}
				} catch (Throwable t) {
					verificationFailed();
				}

				// scroll down the screen
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("window.scrollBy(0,600)");

				// enter data in the first name field
				type("ohs_incident_personfirstnametxt_CSS", data.get("person_first_name"));
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Entered data in the first name field.");

				// enter data in the last name field
				type("ohs_incident_personlastnametxt_CSS", data.get("person_last_name"));
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Entered data in the last name field.");

				// enter data in the job title
				type("ohs_incident_personjobtitletxt_CSS", data.get("job_title"));
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("enter data in the job title");

				// enter data in the email field
				type("ohs_incident_personemailtxt_CSS", data.get("person_email"));
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Entered data in the email field.");

				// enter data in the phone number field
				type("ohs_incident_personphonenumbertxt_CSS", "9876543210");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Entered data in the phone number field.");

				// enter data in the manager name field
				type("ohs_incident_managernametxt_CSS", data.get("manager_name"));
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Entered data in the manager name field.");

				// enter data in the manager email field
				type("ohs_incident_manageremailtxt_CSS", data.get("manager_email"));
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Entered data in the manager email field.");

			} catch (Throwable t) {
				verificationFailed();

			}

			// ADD DETAILS IN THE NATURE OF INJURY TAB

			System.out.println("********** ADD DETAILS IN THE NATURE OF INJURY TAB **********");
			test.log(LogStatus.INFO, "********** ADD DETAILS IN THE NATURE OF INJURY TAB **********");
			Reporter.log("********** ADD DETAILS IN THE NATURE OF INJURY TAB **********");
			log.info("********** ADD DETAILS IN THE NATURE OF INJURY TAB **********");

			try {
				// scroll up the screen
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("window.scrollBy(0,-600)");

				// click on the nature of injury tab
				click("ohs_incident_natureofinjurytab_CSS");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the nature of injury tab.");

				// wait for the element
				Thread.sleep(7000);

				// click on the abdomen checkbox
				click("ohs_incident_abdomenckbx_CSS");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the abdomen checkbox.");

				// click on the left hand checkbox
				click("ohs_incident_lefthandckbx_CSS");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the left hand checkbox.");

				// click on the psychological checkbox
				click("ohs_incident_psychologicalckbx_CSS");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the psychological checkbox.");

				// click on the right shoulder checkbox
				click("ohs_incident_rightshoulderckbx_CSS");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the right shoulder checkbox.");

			} catch (Throwable t) {
				verificationFailed();

			}

			// ADD DETAILS IN THE CAUSE OF INJURY TAB

			System.out.println("********** ADD DETAILS IN THE CAUSE OF INJURY TAB **********");
			test.log(LogStatus.INFO, "********** ADD DETAILS IN THE CAUSE OF INJURY TAB **********");
			Reporter.log("********** ADD DETAILS IN THE CAUSE OF INJURY TAB **********");
			log.info("********** ADD DETAILS IN THE CAUSE OF INJURY TAB **********");

			try {
				// click on the causes of injury tab
				click("ohs_incident_causeofinjurytab_CSS");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the causes of injury tab.");

				// wait for the element
				Thread.sleep(7000);

				try {

					// wait for the element
					explicitWaitClickable("ohs_incident_causeofinjury_animaloption_XPATH");

					// click on the first option of the causes of injury
					click("ohs_incident_causeofinjury_animaloption_XPATH");
					ngDriver.waitForAngularRequestsToFinish();
					System.out.println("Clicked on the first option of the causes of injury.");

					// scroll down the screen
					JavascriptExecutor js = (JavascriptExecutor) driver;
					js.executeScript("window.scrollBy(0,400)");

					// click on the save button
					click("ohs_incident_causesofinjurytab_savebtn_CSS");
					ngDriver.waitForAngularRequestsToFinish();
					System.out.println("Clicked on the save button.");

					// verify added person involved details are displayed or not
					switchVerification("ohs_incident_addedpersoninvolved_XPATH", "Employee",
							"The Employee is not displayed.");

				} catch (Throwable t) {

					TestUtil.captureScreenshot();

					// ReportNG
					Reporter.log("<br>" + "The checklists are not displayed in classic mode. : " + "<br>");
					Reporter.log("<a target=\"_blank\" href=" + TestUtil.screenshotName + "><img src="
							+ TestUtil.screenshotName + " height=200 width=200></img></a>");
					Reporter.log("<br>");
					Reporter.log("<br>");

					// Extent Report
					test.log(LogStatus.FAIL, " The checklists are not displayed in classic mode. : ");
					test.log(LogStatus.FAIL, test.addScreenCapture(TestUtil.screenshotName));

					System.out.println("The checklists are not displayed in classic mode.");
					log.info("The checklists are not displayed in classic mode.");

					// click on the cancel button
					click("ohs_incident_causesofinjurytab_cancelbtn_XPATH");
					ngDriver.waitForAngularRequestsToFinish();
					System.out.println("Clicked on the cancel button.");

				}

			} catch (Throwable t) {
				verificationFailed();
			}

		} catch (Throwable t) {
			verificationFailed();
		}

		try {

			// click on the next button
			click("ohs_incident_nextbtn_CSS");
			System.out.println("Clicked on the next button.");
			ngDriver.waitForAngularRequestsToFinish();

			// synchronization
			explicitWait("ohs_incident_nextbtn_CSS");
			System.out.println("Navigate to the Witnesses Tab.");
			test.log(LogStatus.INFO, "Navigate to the Witnesses Tab.");
			Reporter.log("Navigate to the Witnesses Tab.");
			log.info("Navigate to the Witnesses Tab.");

			// ADD DETAILS IN THE WITNESSES TAB

			System.out.println("********** ADD DETAILS IN THE WITNESSES TAB **********");
			test.log(LogStatus.INFO, "********** ADD DETAILS IN THE WITNESSES TAB **********");
			Reporter.log("********** ADD DETAILS IN THE WITNESSES TAB **********");
			log.info("********** ADD DETAILS IN THE WITNESSES TAB **********");

			// wait for the element
			Thread.sleep(7000);

		} catch (Throwable t) {

			verificationFailed();

			// click on the cancel button
			click("ohs_incident_updatebrn_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the cancel button.");

		}

		try {

			// click on the next button
			click("ohs_incident_nextbtn_CSS");
			System.out.println("Clicked on the next button.");
			ngDriver.waitForAngularRequestsToFinish();

			explicitWait("ohs_incident_nextbtn_CSS");
			System.out.println("Navigate to the emergency services Tab.");
			test.log(LogStatus.INFO, "Navigate to the emergency services Tab.");
			Reporter.log("Navigate to the emergency services Tab.");
			log.info("Navigate to the emergency services Tab.");

			// ADD DETAILS IN THE EMERGENCY SERVICES TAB

			System.out.println("********** ADD DETAILS IN THE EMERGENCY SERVICES TAB **********");
			test.log(LogStatus.INFO, "********** ADD DETAILS IN THE EMERGENCY SERVICES TAB **********");
			Reporter.log("********** ADD DETAILS IN THE EMERGENCY SERVICES TAB **********");
			log.info("********** ADD DETAILS IN THE EMERGENCY SERVICES TAB **********");

		} catch (Throwable t) {
			verificationFailed();

			// click on the cancel button
			click("ohs_incident_updatebrn_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the cancel button.");

		}

		try {

			// click on the next button
			click("ohs_incident_nextbtn_CSS");
			System.out.println("Clicked on the next button.");
			ngDriver.waitForAngularRequestsToFinish();

			// synchronization
			explicitWait("ohs_incident_nextbtn_CSS");
			System.out.println("Navigate to the property damage Tab.");
			test.log(LogStatus.INFO, "Navigate to the property damage Tab.");
			Reporter.log("Navigate to the property damage Tab.");
			log.info("Navigate to the property damage Tab.");

			// ADD DETAILS IN THE PROPERTY DAMAGE TAB

			System.out.println("********** ADD DETAILS IN THE PROPERTY DAMAGE TAB **********");
			test.log(LogStatus.INFO, "********** ADD DETAILS IN THE PROPERTY DAMAGE TAB **********");
			Reporter.log("********** ADD DETAILS IN THE PROPERTY DAMAGE TAB **********");
			log.info("********** ADD DETAILS IN THE PROPERTY DAMAGE TAB **********");

		} catch (Throwable t) {
			verificationFailed();

			// click on the cancel button
			click("ohs_incident_propertydamage_cancelbtn_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the cancel button.");

		}

		try {
			// click on the next button
			click("ohs_incident_nextbtn_CSS");
			System.out.println("Clicked on the next button.");
			ngDriver.waitForAngularRequestsToFinish();

			// synchronization
			explicitWait("ohs_incident_nextbtn_CSS");
			System.out.println("Navigate to the insurance Tab.");
			test.log(LogStatus.INFO, "Navigate to the insurance Tab.");
			Reporter.log("Navigate to the insurance Tab.");
			log.info("Navigate to the insurance Tab.");

			// ADD DETAILS IN THE INSURANCE TAB

			System.out.println("********** ADD DETAILS IN THE INSURANCE TAB **********");
			test.log(LogStatus.INFO, "********** ADD DETAILS IN THE INSURANCE TAB **********");
			Reporter.log("********** ADD DETAILS IN THE INSURANCE TAB **********");
			log.info("********** ADD DETAILS IN THE INSURANCE TAB **********");

		} catch (Throwable t) {
			verificationFailed();

			// click on the cancel button
			click("ohs_incident_insurancetab_cancelbtn_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the cancel button.");

		}

		try {

			// click on the next button
			click("ohs_incident_nextbtn_CSS");
			System.out.println("Clicked on the next button.");
			ngDriver.waitForAngularRequestsToFinish();

			// synchronization
			explicitWait("ohs_incident_updaterecordbtn_CSS");
			System.out.println("Navigate to the attachments Tab.");
			test.log(LogStatus.INFO, "Navigate to the attachments Tab.");
			Reporter.log("Navigate to the attachments Tab.");
			log.info("Navigate to the attachments Tab.");

			// wait for the element
			Thread.sleep(7000);

			// click on the update record button
			click("ohs_incident_updaterecordbtn_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("The update record button clicked successfully");

		} catch (Throwable t) {
			verificationFailed();
		}

		try {
			// wait for the element
			explicitWaitClickable("ohs_incident_search_clearbtn_XPATH");

			// click on the clear button
			click("ohs_incident_search_clearbtn_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the clear button.");

			// enter the newly created incident report in the search field
			type("ohs_incident_searchtxt_CSS", data.get("describe_incident"));
			System.out.println("Entered the newly created incident report in the search field.");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the search button
			click("ohs_incident_search_searchbtn_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the search button.");

			// verification of the incident report is added or not
			switchVerification("ohs_incident_addedincidentreport_capreit2_XPATH",
					"Capreit2 Describe Incident Text Testing Purpose",
					"The Capreit2 Describe Incident Text Testing Purpose is not displayed successfully.");

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

		// DELETE DETAILS IN THE INCIDENT REPORT

		System.out.println("********** DELETE DETAILS IN THE INCIDENT REPORT **********");
		test.log(LogStatus.INFO, "********** DELETE DETAILS IN THE INCIDENT REPORT **********");
		Reporter.log("********** DELETE DETAILS IN THE INCIDENT REPORT **********");
		log.info("********** DELETE DETAILS IN THE INCIDENT REPORT **********");

		try {

			// enter the property name in the search field
			type("envreports_propertylist_filtertxt_CSS", data.get("property_1"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the property name in the search field.");

			// click on the OHS icon from the property list page
			click("ohsicon_CSS");
			System.out.println("Clicked on the OHS icon of the Property.");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Navigate to the OHS screen of the perticular property.");

			// wait for the element
			Thread.sleep(5000);

			// click on the burger menu
			click("menubtn_CSS");
			System.out.println("Clicked on the burger menu button successfully!!!");
			ngDriver.waitForAngularRequestsToFinish();

			// wait for the element
			Thread.sleep(5000);

			// click on the incident reports
			click("questionnaire_option_ohstab_incidentreports_XPATH");
			System.out.println("Clicked on the incident reports option.");
			ngDriver.waitForAngularRequestsToFinish();

			// wait for the element
			explicitWaitClickable("ohs_incident_search_clearbtn_XPATH");

			// click on the clear button
			click("ohs_incident_search_clearbtn_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the clear button.");

			// enter the newly created incident report in the search field
			type("ohs_incident_searchtxt_CSS", data.get("describe_incident"));
			System.out.println("Entered the newly created incident report in the search field.");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the search button
			click("ohs_incident_search_searchbtn_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the search button.");

			// click on the incident report
			click("ohs_incident_addedincidentreport_capreit2_XPATH");
			System.out.println("Clicked on the updated incident report.");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Naviagte to the Update Incident record Screen.");

			// click on the delete button
			click("ohs_incident_deletebtn_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the delete button.");

			// click on the delete button of confirmation popup
			click("ohs_incident_confirmdeletebtn_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the delete button of confirmation popup.");

			// wait for the element
			explicitWaitClickable("ohs_incident_search_clearbtn_XPATH");

			// click on the clear button
			click("ohs_incident_search_clearbtn_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the clear button.");

			// enter the newly created incident report in the search field
			type("ohs_incident_searchtxt_CSS", data.get("describe_incident"));
			System.out.println("Entered the newly created incident report in the search field.");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the search button
			click("ohs_incident_search_searchbtn_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the search button.");

			// verify details are deleted or not
			deleteVerification("ohs_incident_addedincidentreport_capreit2_XPATH",
					"Capreit2 Describe Incident Text Testing Purpose");

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

		// RESET THE INCIDENT EVENT TYPE FOR THE INCIDENTS SUBSTANCE SPILL AND INJURY
		// CHECKLIST

		System.out.println(
				"******************** RESET THE INCIDENT EVENT TYPE FOR THE INCIDENTS SUBSTANCE SPILL AND INJURY CHECKLIST ********************");
		test.log(LogStatus.INFO,
				"******************** RESET THE INCIDENT EVENT TYPE FOR THE INCIDENTS SUBSTANCE SPILL AND INJURY CHECKLIST ********************");
		Reporter.log(
				"******************** RESET THE INCIDENT EVENT TYPE FOR THE INCIDENTS SUBSTANCE SPILL AND INJURY CHECKLIST ********************");
		log.info(
				"******************** RESET THE INCIDENT EVENT TYPE FOR THE INCIDENTS SUBSTANCE SPILL AND INJURY CHECKLIST ********************");

		try {
			// wait for the element
			Thread.sleep(10000);

			// click on the settings icon from the top of the screen
			click("questionnaire_settingicon_CSS");
			System.out.println("Clicked on the settings icon.");
			ngDriver.waitForAngularRequestsToFinish();

			// wait for the element
			explicitWaitClickable("questionnaire_administrationoption_XPATH");

			// click on the administration option from the side menu
			click("questionnaire_administrationoption_XPATH");
			System.out.println("Clicked on the administration option from the side menu.");
			ngDriver.waitForAngularRequestsToFinish();

			// scroll down the screen
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,400)");

			// click on the OHS tab
			click("questionnaire_ohstab_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the OHS tab.");

			// click on the Incident Event Types
			click("questionnaire_incidenteventtypeoption_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the Incident Event Types.");

			// scroll down the screen
			WebElement substancespilloption = driver
					.findElement(By.xpath(OR.getProperty("ohs_incident_substancespill_XPATH")));
			js.executeScript("arguments[0].scrollIntoView(true);", substancespilloption);
			js.executeScript("window.scrollBy(0,-400)");

			// click on the substance spill record
			click("ohs_incident_substancespill_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the substance spill record.");

			// scroll down the screen
			js.executeScript("window.scrollBy(0,400)");

			try {
				boolean isSpill = driver
						.findElement(By.cssSelector(OR.getProperty("ohs_incident_substancespill_checkbox_CSS")))
						.isSelected();

				System.out.println("//////////////////// isSpill " + isSpill);

				if (isSpill == true) {

					// click on the isSpill checkbox
					click("ohs_incident_substancespill_checkbox_CSS");
					ngDriver.waitForAngularRequestsToFinish();
					System.out.println("Clicked on the isSpill checkbox.");

					// click on update button
					click("ohs_incident_alertnotification_updatebtn_CSS");
					ngDriver.waitForAngularRequestsToFinish();
					System.out.println("Clicked on update button.");

				} else {
					// click on update button
					click("ohs_incident_alertnotification_updatebtn_CSS");
					ngDriver.waitForAngularRequestsToFinish();
					System.out.println("Clicked on update button.");
				}

			} catch (Throwable t) {
				verificationFailed();

				// click on update button
				click("ohs_incident_alertnotification_updatebtn_CSS");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on update button.");
			}

			// scroll down the screen
			WebElement employeeinjuryoption = driver
					.findElement(By.xpath(OR.getProperty("ohs_incident_employeeinjury_XPATH")));
			js.executeScript("arguments[0].scrollIntoView(true);", employeeinjuryoption);
			js.executeScript("window.scrollBy(0,-400)");

			// click on the Employee Injury record
			click("ohs_incident_employeeinjury_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the Employee Injury record.");

			// scroll down the screen
			js.executeScript("window.scrollBy(0,400)");

			try {
				boolean injuryRequired = driver
						.findElement(By.cssSelector(OR.getProperty("ohs_incident_employeeinjury_checkbox_CSS")))
						.isSelected();

				System.out.println("//////////////////// injuryRequired " + injuryRequired);

				if (injuryRequired == true) {

					// click on the isSpill checkbox
					click("ohs_incident_employeeinjury_checkbox_CSS");
					ngDriver.waitForAngularRequestsToFinish();
					System.out.println("Clicked on the isSpill checkbox.");

					// click on update button
					click("ohs_incident_alertnotification_updatebtn_CSS");
					ngDriver.waitForAngularRequestsToFinish();
					System.out.println("Clicked on update button.");

				} else {
					// click on update button
					click("ohs_incident_alertnotification_updatebtn_CSS");
					ngDriver.waitForAngularRequestsToFinish();
					System.out.println("Clicked on update button.");
				}

			} catch (Throwable t) {
				verificationFailed();

				// click on update button
				click("ohs_incident_alertnotification_updatebtn_CSS");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on update button.");
			}

		} catch (Throwable t) {
			verificationFailed();
		}

		// click on the home icon from the top of the screen
		click("questionnaire_homeburgermenubtn_CSS");
		System.out.println("Clicked on the home icon from the top of the screen.");
		ngDriver.waitForAngularRequestsToFinish();

		// synchronization
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		try {
			// wait for the element
			Thread.sleep(7000);

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
