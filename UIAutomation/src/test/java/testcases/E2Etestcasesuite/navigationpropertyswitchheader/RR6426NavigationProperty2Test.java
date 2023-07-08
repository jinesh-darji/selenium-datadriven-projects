package testcases.E2Etestcasesuite.navigationpropertyswitchheader;

import java.io.IOException;
import java.util.Hashtable;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import base.Helper;
import base.TestBase;
import utilities.TestUtil;

public class RR6426NavigationProperty2Test extends TestBase {

	@Test(dataProviderClass = TestUtil.class, dataProvider = "dp")
	public void rR6426NavigationProperty2Test(Hashtable<String, String> data) throws InterruptedException, IOException {

		execution(data, "rR6426NavigationProperty2Test");

		// RISK MANAGEMENT MODULE - NAVIGATION SCENARIO OF THE
		title("RISK MANAGEMENT MODULE - NAVIGATION SCENARIO OF THE ");

		Helper helper = new Helper();

		// refresh the page
		driver.navigate().refresh();
		Thread.sleep(5000);
		driver.navigate().refresh();

		// ADD TASK IN THE RISK MANAGEMENT MODULE
		title("ADD TASK IN THE RISK MANAGEMENT MODULE");

		try {
			// click on the risk management icon from the property list page
			click("riskmanagementicon_CSS");

			// wait for element
			explicitWaitClickable("menubtn_CSS");

			// click on the burger menu
			click("menubtn_CSS");

			// wait for element
			explicitWaitClickable("riskmanagement_taskoption_CSS");

			// click on the tasks
			click("riskmanagement_taskoption_CSS");

			// click on the add button
			click("riskmanagement_addtaskbtn_CSS");

			// click on the recommendation field
			click("riskmanagement_addtaskbtn_recommendationtxt_CSS");

			// click on the clear button
			click("riskmanagement_addtaskbtn_recommendationclearbtn_XPATH");

			// enter the recommendation name
			type("task_filter_findtask_CSS", data.get("recommendation_name"));

			// click on the searched result
			click("riskmanagement_addtaskbtn_recommendationnametxt_XPATH");

			// enter description for task
			type("riskmanagement_addtaskbtn_descriptiontxt_CSS", data.get("description"));

			// scroll down the screen
			scrollByPixel(250);

			// select the insurance owner from the dropdown
			select("riskmanagement_addtaskbtn_forwho_CSS", data.get("insuranceOwner"));

			// scroll down the screen
			scrollByPixel(250);

			// click on the due date field
			click("riskmanagement_addtaskbtn_duedatetxt_CSS");

			// click on the today button
			click("riskmanagement_addtaskbtn_todayduedatebtn_XPATH");

			// click on the roles assigned field
			click("riskmanagement_addtaskbtn_roleassigntxt_CSS");

			// click on the none button
			click("riskmanagement_addtaskbtn_nonbtn_CSS");

			// enter role in search field
			type("riskmanagement_addtaskbtn_roleassignsearchtxt_CSS", data.get("role_assigned"));

			// click on the searched result
			click("riskmanagement_addtaskbtn_roleassignsearchresult_XPATH");

			// click on the roles assigned field
			click("riskmanagement_addtaskbtn_roleassigntxt_CSS");

			// click on the save button
			click("riskmanagement_addtaskbtn_savebtn_CSS");

			// enter recommendation name into the search field
			type("riskmanagement_searchtxt_CSS", data.get("recommendation_name"));

			// verify newly created task is displayed or not
			switchVerification("riskmanagement_createdtask1_XPATH", "Automation Type Risk",
					"The automation type risk is not displayed.");

		} catch (Throwable t) {
			verificationFailed();
		}

		// click on the home icon from the top of the screen
		click("questionnaire_homeburgermenubtn_hide_CSS");

		// synchronization
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// ADD THE NEWLY INSURANCE CLAIM RECORD OF THE RISK MANAGEMENT MODULE
		title("ADD THE NEWLY INSURANCE CLAIM RECORD OF THE RISK MANAGEMENT MODULE");

		String incident = RandomStringUtils.randomAlphabetic(8);

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

		} catch (Throwable t) {
			verificationFailed();
		}

		// click on the home icon from the top of the screen
		click("questionnaire_homeburgermenubtn_hide_CSS");

		// synchronization
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// ADD THE NEWLY TENANT INSURANCE RECORD OF THE RISK MANAGEMENT MODULE
		title("ADD THE NEWLY TENANT INSURANCE RECORD OF THE RISK MANAGEMENT MODULE");

		String tenantName = RandomStringUtils.randomAlphabetic(8);
		String tenantID = RandomStringUtils.randomNumeric(8);
		String tenantLease = RandomStringUtils.randomAlphabetic(8);
		String certificateNumber = RandomStringUtils.randomNumeric(8);

		try {

			// click on the risk management icon from the property list page
			click("riskmanagementicon_CSS");

			// wait for element
			explicitWaitClickable("menubtn_CSS");

			// click on the burger menu
			click("menubtn_CSS");

			// wait for element
			explicitWaitClickable("riskmanagement_tenantinsuranceoption_XPATH");

			// click on the insurance claim
			click("riskmanagement_tenantinsuranceoption_XPATH");

			// click on the add button
			click("riskmanagement_addtenantinsurance_CSS");

			// click on the add tenant button
			click("riskmanagement_addtenantbtn_XPATH");

			// wait for the element
			Thread.sleep(2000);

			// enter tenant name in the field
			type("riskmanagement_tenantnametxt_XPATH", tenantName);

			// enter the tenant id in the field
			type("riskmanagement_tenantidtxt_XPATH", tenantID);

			// scroll to the element
			scrollTillElement("riskmanagement_savetenantbtn_XPATH");

			// click on the add button to add the newly tenant
			click("riskmanagement_savetenantbtn_XPATH");

			// click on the tenant field
			click("riskmanagement_tenanttxt_XPATH");

			// enter newly created tenant in the search field
			type("riskmanagement_tenant_searchtext_XPATH", tenantName);

			// click on the searched tenant
			String tenant = "(//span[text()='" + tenantName + "'])[2]";
			driver.findElement(By.xpath(tenant)).click();
			consoleMessage("Clicked on the searched tenant");

			// enter tenant name in the field
			type("riskmanagement_tenantnametxt_XPATH", tenantLease);

			// enter certificate number in the field
			type("riskmanagement_tenant_certificatenumbertxt_XPATH", certificateNumber);

			// click on the expiry date
			click("riskmanagement_tenant_expirydatetxt_XPATH");

			// click on the today button
			click("riskmanagement_tenant_expirydatetxt_todaybtn_XPATH");

			// click on the save button
			click("riskmanagement_tenantinsurance_savebtn_XPATH");

			// enter the newly created tanent insurance on search field
			type("riskmanagement_tenantinsurance_filtertxt_XPATH", certificateNumber);

			// validate the newly created tenant insurance
			try {
				String tanentInsurance = "//td[text()='" + certificateNumber + "']";
				boolean tanentInsurance_actual = driver.findElement(By.xpath(tanentInsurance)).isDisplayed();

				if (tanentInsurance_actual == true) {
					successMessage("The nely created tenant insurance is displayed successfully.");
				} else {
					verificationFailedMessage("The newly created tenant insuneance is not displayed.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The newly created tenant insuneance is not displayed.");
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

		// ADD THE NEWLY POLICY EXCLUSION RECORD OF THE RISK MANAGEMENT MODULE
		title("ADD THE NEWLY POLICY EXCLUSION RECORD OF THE RISK MANAGEMENT MODULE");

		String policyNumber = RandomStringUtils.randomNumeric(8);

		// *********** ADD THE IMPLEMENTATION OF THE POLICY EXCLUSION **********

		// VALIDATE THE NAVIGATION AFTER SWITCHING THE PROPERTY FROM THE HEADER OF
		// THE TASKS OF THE RISK MANAGEMENT MODULE
		title("VALIDATE THE NAVIGATION AFTER SWITCHING THE PROPERTY FROM THE HEADER OF THE TASK OF THE RISK MANAGEMENT MODULE");

		try {

			// click on the risk management icon from the property list page
			click("riskmanagementicon_CSS");

			// wait for element
			explicitWaitClickable("menubtn_CSS");

			// click on the burger menu
			click("menubtn_CSS");

			// wait for element
			explicitWaitClickable("riskmanagement_taskoption_CSS");

			// click on the tasks
			click("riskmanagement_taskoption_CSS");

			// click on the newly created task of the risk management
			click("riskmanagement_createdtask1_XPATH");

			// VALIDATE FOR PROPERTY ONE
			title("VALIDATE FOR PROPERTY ONE");

			// validate the property name
			switchVerification("navigation_header_propertyname1_XPATH", "[DND] AAAA Risk Test Prop 01 - 01",
					"The property name is not displayed.");

			// validate the description of the task
			try {
				String taskDescription = driver
						.findElement(By.cssSelector(OR.getProperty("riskmanagement_addtaskbtn_descriptiontxt_CSS")))
						.getAttribute("value");

				if (taskDescription.equals(data.get("description"))) {
					successMessage("The task description is displayed correctly.");
				} else {
					verificationFailedMessage("The task description is not displayed correctly.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The task description is not displayed correctly.");
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

			// validate the description of the task
			try {
				String taskDescription = driver
						.findElement(By.cssSelector(OR.getProperty("riskmanagement_addtaskbtn_descriptiontxt_CSS")))
						.getAttribute("value");

				if (taskDescription.equals(data.get("description"))) {
					verificationFailedMessage("The task description is displayed correctly.");

				} else {
					successMessage("The task description is not displayed.");
				}
			} catch (Throwable t) {
				successMessage("The task description is not displayed.");
			}

			// validate the newly created task on the task listing screen
			try {
				boolean record1_actual = driver
						.findElement(By.xpath(OR.getProperty("riskmanagement_createdtask1_XPATH"))).isDisplayed();

				if (record1_actual == true) {

					verificationFailedMessage("The newly created record is displayed.");

				} else {
					successMessage("The newly created record is not displayed as expected.");
				}
			} catch (Throwable t) {
				successMessage("The newly created record is not displayed as expected.");
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

			// validate the description of the task
			try {
				String taskDescription = driver
						.findElement(By.cssSelector(OR.getProperty("riskmanagement_addtaskbtn_descriptiontxt_CSS")))
						.getAttribute("value");

				if (taskDescription.equals(data.get("description"))) {
					verificationFailedMessage("The task description is displayed correctly.");

				} else {
					successMessage("The task description is not displayed.");
				}
			} catch (Throwable t) {
				successMessage("The task description is not displayed.");
			}

			// validate the newly created task on the task listing screen
			try {
				boolean record1_actual = driver
						.findElement(By.xpath(OR.getProperty("riskmanagement_createdtask1_XPATH"))).isDisplayed();

				if (record1_actual == true) {

					verificationFailedMessage("The newly created record is displayed.");

				} else {
					successMessage("The newly created record is not displayed as expected.");
				}
			} catch (Throwable t) {
				successMessage("The newly created record is not displayed as expected.");
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

			// validate the description of the task
			try {
				String taskDescription = driver
						.findElement(By.cssSelector(OR.getProperty("riskmanagement_addtaskbtn_descriptiontxt_CSS")))
						.getAttribute("value");

				if (taskDescription.equals(data.get("description"))) {
					verificationFailedMessage("The task description is displayed correctly.");

				} else {
					successMessage("The task description is not displayed.");
				}
			} catch (Throwable t) {
				successMessage("The task description is not displayed.");
			}

			// validate the newly created task on the task listing screen
			try {
				boolean record1_actual = driver
						.findElement(By.xpath(OR.getProperty("riskmanagement_createdtask1_XPATH"))).isDisplayed();

				if (record1_actual == true) {

					successMessage("The newly created record is displayed as expected.");

				} else {
					verificationFailedMessage("The newly created record is not displayed.");

				}
			} catch (Throwable t) {
				verificationFailedMessage("The newly created record is not displayed.");
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
		// THE INSURANCE CLAIM OF THE RISK MANAGEMENT MODULE
		title("VALIDATE THE NAVIGATION AFTER SWITCHING THE PROPERTY FROM THE HEADER OF THE INSURANCE CLAIM OF THE RISK MANAGEMENT MODULE");

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

			// click on the newly created insurance claim of the risk management
			String record3 = "//td[text()='" + incident + "']";
			driver.findElement(By.xpath(record3)).click();
			consoleMessage("Clicked on the newly created insurance claim of the risk management.");

			// VALIDATE FOR PROPERTY ONE
			title("VALIDATE FOR PROPERTY ONE");

			// validate the property name
			switchVerification("navigation_header_propertyname1_XPATH", "[DND] AAAA Risk Test Prop 01 - 01",
					"The property name is not displayed.");

			// validate the claim status of the incident claim
			try {
				String incident1 = "//select[@name='claimStatus']//option[@selected='selected' and text()='"
						+ data.get("claim_status") + "']";
				boolean incident1_actual = driver.findElement(By.xpath(incident1)).isDisplayed();

				if (incident1_actual == true) {
					successMessage("The claim status is displayed correctly.");
				} else {
					verificationFailedMessage("The claim status is not displayed correctly.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The claim status is not displayed correctly.");
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

			// validate the claim status of the incident claim
			try {
				String incident1 = "//select[@name='claimStatus']//option[@selected='selected' and text()='"
						+ data.get("claim_status") + "']";
				boolean incident1_actual = driver.findElement(By.xpath(incident1)).isDisplayed();

				if (incident1_actual == true) {
					verificationFailedMessage("The claim status is displayed correctly.");
				} else {
					successMessage("The claim status is not displayed as expected.");

				}
			} catch (Throwable t) {
				successMessage("The claim status is not displayed as expected.");
			}

			// validate the newly created insurance claim on the listing screen
			try {
				String record4 = "//td[text()='" + incident + "']";
				boolean record4_actual = driver.findElement(By.xpath(record4)).isDisplayed();

				if (record4_actual == true) {

					verificationFailedMessage("The insurance claim record is displayed.");

				} else {
					successMessage("The insurance claim is not displayed as expected.");
				}
			} catch (Throwable t) {
				successMessage("The insurance claim is not displayed as expected.");
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

			// validate the claim status of the incident claim
			try {
				String incident1 = "//select[@name='claimStatus']//option[@selected='selected' and text()='"
						+ data.get("claim_status") + "']";
				boolean incident1_actual = driver.findElement(By.xpath(incident1)).isDisplayed();

				if (incident1_actual == true) {
					verificationFailedMessage("The claim status is displayed correctly.");
				} else {
					successMessage("The claim status is not displayed as expected.");

				}
			} catch (Throwable t) {
				successMessage("The claim status is not displayed as expected.");
			}

			// validate the newly created insurance claim on the listing screen
			try {
				String record4 = "//td[text()='" + incident + "']";
				boolean record4_actual = driver.findElement(By.xpath(record4)).isDisplayed();

				if (record4_actual == true) {

					verificationFailedMessage("The insurance claim record is displayed.");

				} else {
					successMessage("The insurance claim is not displayed as expected.");
				}
			} catch (Throwable t) {
				successMessage("The insurance claim is not displayed as expected.");
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

			// validate the claim status of the incident claim
			try {
				String incident1 = "//select[@name='claimStatus']//option[@selected='selected' and text()='"
						+ data.get("claim_status") + "']";
				boolean incident1_actual = driver.findElement(By.xpath(incident1)).isDisplayed();

				if (incident1_actual == true) {
					verificationFailedMessage("The claim status is displayed correctly.");
				} else {
					successMessage("The claim status is not displayed as expected.");

				}
			} catch (Throwable t) {
				successMessage("The claim status is not displayed as expected.");
			}

			// validate the newly created insurance claim on the listing screen
			try {
				String record4 = "//td[text()='" + incident + "']";
				boolean record4_actual = driver.findElement(By.xpath(record4)).isDisplayed();

				if (record4_actual == true) {
					successMessage("The insurance claim is displayed as expected.");

				} else {
					verificationFailedMessage("The insurance claim record is not displayed.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The insurance claim record is not displayed.");
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
		// THE TENANT INSURANCE OF THE RISK MANAGEMENT MODULE
		title("VALIDATE THE NAVIGATION AFTER SWITCHING THE PROPERTY FROM THE HEADER OF THE TENANT INSURANCE OF THE RISK MANAGEMENT MODULE");

		try {

			// click on the risk management icon from the property list page
			click("riskmanagementicon_CSS");

			// wait for element
			explicitWaitClickable("menubtn_CSS");

			// click on the burger menu
			click("menubtn_CSS");

			// wait for element
			explicitWaitClickable("riskmanagement_tenantinsuranceoption_XPATH");

			// click on the insurance claim
			click("riskmanagement_tenantinsuranceoption_XPATH");

			// click on the newly created tenant insurance of the risk management
			String record5 = "//td[text()='" + certificateNumber + "']";
			driver.findElement(By.xpath(record5)).click();
			consoleMessage("Clicked on the newly created tenant insurance of the risk management.");

			// VALIDATE FOR PROPERTY ONE
			title("VALIDATE FOR PROPERTY ONE");

			// validate the property name
			switchVerification("navigation_header_propertyname1_XPATH", "[DND] AAAA Risk Test Prop 01 - 01",
					"The property name is not displayed.");

			// validate the newly created tenant insurance
			try {
				// scroll down the screen
				scrollTillElement("riskmanagement_tenant_certificatenumbertxt_XPATH");

				String incident1_actual = driver
						.findElement(By.xpath(OR.getProperty("riskmanagement_tenant_certificatenumbertxt_XPATH")))
						.getAttribute("value");

				if (incident1_actual.equals(certificateNumber)) {
					successMessage("The tenant insurance is displayed correctly.");
				} else {
					verificationFailedMessage("The tenant insurance is not displayed correctly.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The tenant insurance is not displayed correctly.");
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

			// validate the newly created tenant insurance
			try {
				// scroll down the screen
				scrollTillElement("riskmanagement_tenant_certificatenumbertxt_XPATH");

				String incident1_actual = driver
						.findElement(By.xpath(OR.getProperty("riskmanagement_tenant_certificatenumbertxt_XPATH")))
						.getAttribute("value");

				if (incident1_actual.equals(certificateNumber)) {
					verificationFailedMessage("The tenant insurance is displayed correctly.");

				} else {
					successMessage("The tenant insurance is not displayed.");
				}
			} catch (Throwable t) {
				successMessage("The tenant insurance is not displayed.");
			}

			// validate the newly created tenant insurance on the listing screen
			try {
				String record55 = "//td[text()='" + certificateNumber + "']";
				boolean record55_actual = driver.findElement(By.xpath(record55)).isDisplayed();

				if (record55_actual == true) {

					verificationFailedMessage("The tenant insurance record is displayed.");

				} else {
					successMessage("The tenant insurance is not displayed as expected.");
				}
			} catch (Throwable t) {
				successMessage("The tenant insurance is not displayed as expected.");
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

			// validate the newly created tenant insurance
			try {
				// scroll down the screen
				scrollTillElement("riskmanagement_tenant_certificatenumbertxt_XPATH");

				String incident1_actual = driver
						.findElement(By.xpath(OR.getProperty("riskmanagement_tenant_certificatenumbertxt_XPATH")))
						.getAttribute("value");

				if (incident1_actual.equals(certificateNumber)) {
					verificationFailedMessage("The tenant insurance is displayed correctly.");

				} else {
					successMessage("The tenant insurance is not displayed.");
				}
			} catch (Throwable t) {
				successMessage("The tenant insurance is not displayed.");
			}

			// validate the newly created tenant insurance on the listing screen
			try {
				String record55 = "//td[text()='" + certificateNumber + "']";
				boolean record55_actual = driver.findElement(By.xpath(record55)).isDisplayed();

				if (record55_actual == true) {

					verificationFailedMessage("The tenant insurance record is displayed.");

				} else {
					successMessage("The tenant insurance is not displayed as expected.");
				}
			} catch (Throwable t) {
				successMessage("The tenant insurance is not displayed as expected.");
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

			// validate the newly created tenant insurance
			try {
				// scroll down the screen
				scrollTillElement("riskmanagement_tenant_certificatenumbertxt_XPATH");

				String incident1_actual = driver
						.findElement(By.xpath(OR.getProperty("riskmanagement_tenant_certificatenumbertxt_XPATH")))
						.getAttribute("value");

				if (incident1_actual.equals(certificateNumber)) {
					verificationFailedMessage("The tenant insurance is displayed correctly.");

				} else {
					successMessage("The tenant insurance is not displayed.");
				}
			} catch (Throwable t) {
				successMessage("The tenant insurance is not displayed.");
			}

			// validate the newly created tenant insurance on the listing screen
			try {
				String record55 = "//td[text()='" + certificateNumber + "']";
				boolean record55_actual = driver.findElement(By.xpath(record55)).isDisplayed();

				if (record55_actual == true) {
					successMessage("The tenant insurance is displayed as expected.");

				} else {
					verificationFailedMessage("The tenant insurance record is not displayed.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The tenant insurance record is not displayed.");
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
		// THE POLICY EXCLUSION OF THE RISK MANAGEMENT MODULE
		title("VALIDATE THE NAVIGATION AFTER SWITCHING THE PROPERTY FROM THE HEADER OF THE POLICY EXCLUSION OF THE RISK MANAGEMENT MODULE");

		try {

			// click on the risk management icon from the property list page
			click("riskmanagementicon_CSS");

			// wait for element
			explicitWaitClickable("menubtn_CSS");

			// click on the burger menu
			click("menubtn_CSS");

			// wait for element
			explicitWaitClickable("riskmanagement_policyexclusionoption_XPATH");

			// click on the insurance claim
			click("riskmanagement_policyexclusionoption_XPATH");

			// click on the newly created policy exclusion of the risk management
			String record6 = "//td[text()='" + policyNumber + "']";
			driver.findElement(By.xpath(record6)).click();
			consoleMessage("Clicked on the newly created policy exclusion of the risk management.");

			// VALIDATE FOR PROPERTY ONE
			title("VALIDATE FOR PROPERTY ONE");

			// validate the property name
			switchVerification("navigation_header_propertyname1_XPATH", "[DND] AAAA Risk Test Prop 01 - 01",
					"The property name is not displayed.");

			// validate the newly created policy exclusion
			// ********** VALIDATE THE POLICY EXCLUSION RECORD **********

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

			// validate the newly created policy exclusion
			// ********** VALIDATE THE POLICY EXCLUSION RECORD **********

			// validate the newly created policy exclusion on the listing screen
			try {
				String record55 = "//td[text()='" + policyNumber + "']";
				boolean record55_actual = driver.findElement(By.xpath(record55)).isDisplayed();

				if (record55_actual == true) {

					verificationFailedMessage("The policy exclusion record is displayed.");

				} else {
					successMessage("The policy exclusion is not displayed as expected.");
				}
			} catch (Throwable t) {
				successMessage("The policy exclusion is not displayed as expected.");
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

			// validate the newly created policy exclusion
			// ********** VALIDATE THE POLICY EXCLUSION RECORD **********

			// validate the newly created policy exclusion on the listing screen
			try {
				String record55 = "//td[text()='" + policyNumber + "']";
				boolean record55_actual = driver.findElement(By.xpath(record55)).isDisplayed();

				if (record55_actual == true) {

					verificationFailedMessage("The policy exclusion record is displayed.");

				} else {
					successMessage("The policy exclusion is not displayed as expected.");
				}
			} catch (Throwable t) {
				successMessage("The policy exclusion is not displayed as expected.");
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

			// validate the newly created policy exclusion
			// ********** VALIDATE THE POLICY EXCLUSION RECORD **********

			// validate the newly created policy exclusion on the listing screen
			try {
				String record55 = "//td[text()='" + policyNumber + "']";
				boolean record55_actual = driver.findElement(By.xpath(record55)).isDisplayed();

				if (record55_actual == true) {
					successMessage("The policy exclusion is displayed as expected.");

				} else {
					verificationFailedMessage("The policy exclusion record is not displayed.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The policy exclusion record is not displayed.");
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

		// DELETE THE TASK IN THE RISK MANAGEMENT MODULE
		title("DELETE THE TASK IN THE RISK MANAGEMENT MODULE");

		try {
			// click on the risk management icon from the property list page
			click("riskmanagementicon_CSS");

			// wait for element
			explicitWaitClickable("menubtn_CSS");

			// click on the burger menu
			click("menubtn_CSS");

			// wait for element
			explicitWaitClickable("riskmanagement_taskoption_CSS");

			// click on the tasks
			click("riskmanagement_taskoption_CSS");

			// click on the newly created task of the risk management
			click("riskmanagement_createdtask1_XPATH");

			// wait for the element
			explicitWaitClickable("navigation_riskmanagement_task_deletebtn_XPATH");

			// click on the delete button
			click("navigation_riskmanagement_task_deletebtn_XPATH");

			// wait for the element
			explicitWaitClickable("navigation_riskmanagement_task_confirmationdeletebtn_XPATH");

			// click on the delete button of confirmation model
			click("navigation_riskmanagement_task_confirmationdeletebtn_XPATH");

			// validate the delete record
			helper.deleteVerification("riskmanagement_createdtask1_XPATH", "Automation Type Risk");

		} catch (Throwable t) {
			verificationFailed();
		}

		// click on the home icon from the top of the screen
		click("questionnaire_homeburgermenubtn_hide_CSS");

		// wait for the element
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// DELETE THE NEWLY INSURANCE CLAIM RECORD OF THE RISK MANAGEMENT MODULE
		title("DELETE THE NEWLY INSURANCE CLAIM RECORD OF THE RISK MANAGEMENT MODULE");

		try {

			// click on the risk management icon from the property list page
			click("riskmanagementicon_CSS");

			// wait for element
			explicitWaitClickable("menubtn_CSS");

			// click on the burger menu
			click("menubtn_CSS");

			// wait for element
			explicitWaitClickable("riskmanagement_tenantinsuranceoption_XPATH");

			// click on the tenant insurance
			click("riskmanagement_tenantinsuranceoption_XPATH");

			// click on the newly created insurance claim of the risk management
			String record3 = "//td[text()='" + incident + "']";
			driver.findElement(By.xpath(record3)).click();
			consoleMessage("Clicked on the newly created insurance claim of the risk management.");

			// wait for the element
			explicitWaitClickable("navigation_riskmanagement_insuranceclaim_deletebtn_XPATH");

			// click on the delete button
			click("navigation_riskmanagement_insuranceclaim_deletebtn_XPATH");

			// wait for the element
			explicitWaitClickable("navigation_riskmanagement_insuranceclaim_confirmationdeletebtn_XPATH");

			// click on the delete button of confirmation model
			click("navigation_riskmanagement_insuranceclaim_confirmationdeletebtn_XPATH");

			try {

				String record = "//td[text()='" + incident + "']";
				String deleteElement = (driver.findElement(By.xpath(record)).getText()).trim();

				if (deleteElement.equals(incident)) {

					verificationFailedMessage("The  " + incident + " is not deleted.");

				} else {
					successMessage("The " + incident + " is deleted successfully.");
				}
			} catch (Throwable t) {

				successMessage("The " + incident + " is deleted successfully.");

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

		// DELETE THE NEWLY INSURANCE CLAIM RECORD OF THE RISK MANAGEMENT MODULE
		title("DELETE THE NEWLY INSURANCE CLAIM RECORD OF THE RISK MANAGEMENT MODULE");

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

			// click on the newly created tenant insurance of the risk management
			String record5 = "//td[text()='" + certificateNumber + "']";
			driver.findElement(By.xpath(record5)).click();
			consoleMessage("Clicked on the newly created tenant insurance of the risk management.");

			// wait for the element
			explicitWaitClickable("navigation_riskmanagement_tenantinsurance_deletebtn_XPATH");

			// click on the delete button
			click("navigation_riskmanagement_tenantinsurance_deletebtn_XPATH");

			// wait for the element
			explicitWaitClickable("navigation_riskmanagement_tenantinsurance_confirmationdeletebtn_XPATH");

			// click on the delete button of confirmation model
			click("navigation_riskmanagement_tenantinsurance_confirmationdeletebtn_XPATH");

			try {

				String record = "//td[text()='" + certificateNumber + "']";
				String deleteElement = (driver.findElement(By.xpath(record)).getText()).trim();

				if (deleteElement.equals(certificateNumber)) {

					verificationFailedMessage("The  " + certificateNumber + " is not deleted.");

				} else {
					successMessage("The " + certificateNumber + " is deleted successfully.");
				}
			} catch (Throwable t) {

				successMessage("The " + certificateNumber + " is deleted successfully.");

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
