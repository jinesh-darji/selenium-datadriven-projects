package testcases.E2Etestcasesuite.navigationpropertyswitchheader;

import java.io.IOException;
import java.util.Hashtable;
import java.util.List;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.Helper;
import base.TestBase;
import utilities.TestUtil;

public class RR6440NavigationProperty1Test extends TestBase {

	@Test(dataProviderClass = TestUtil.class, dataProvider = "dp")
	public void rR6440NavigationProperty1Test(Hashtable<String, String> data) throws InterruptedException, IOException {

		execution(data, "rR6440NavigationProperty1Test");

		// OHS DASHBOARD - NAVIGATION SCENARIO OF THE EHS INCIDENTS, HR INCIDENTS,
		// INSURANCE INCIDENTS, ASSESSMENTS/INSPECTIONS, INCIDENT SUMMARY, INJURY
		// SUMMARY.
		title("OHS DASHBOARD - NAVIGATION SCENARIO OF THE EHS INCIDENTS, HR INCIDENTS, INSURANCE INCIDENTS, ASSESSMENTS/INSPECTIONS, INCIDENT SUMMARY, INJURY SUMMARY.");

		// refresh the page
		driver.navigate().refresh();
		Thread.sleep(5000);
		driver.navigate().refresh();

		// VALIDATE THE NAVIGATION AFTER SWITCHING THE PROPERTY FROM THE HEADER OF
		// THE EHS INCIDENTS DASHBOARD SCREEN
		title("VALIDATE THE NAVIGATION AFTER SWITCHING THE PROPERTY FROM THE HEADER OF THE EHS INCIDENTS DASHBOARD SCREEN");

		try {

			// wait for the element
			Thread.sleep(5000);

			// click on the side menu
			click("menubtn_CSS");

			// wait for the element
			Thread.sleep(5000);

			// click on the ohs side menu
			click("sidemenu_ohs_XPATH");

			// select the option from the dashboard dropdown
			select("dashboard_CSS", "EHS Incidents");

			// VALIDATE FOR PROPERTY ONE
			title("VALIDATE FOR PROPERTY ONE");

			// validate the EHS Incidents title
			switchVerification("ohsdashboard_ehsincidentstitle_XPATH", "EHS Incidents",
					"The EHS Incidents title is not displayed.");

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
				// scroll down till Documents/Reports card
				scrollTillElement("ohsdashboard_documentsreportcard_XPATH");

				// validate the Documents/Reports card
				boolean documentCard = driver
						.findElement(By.xpath(OR.getProperty("ohsdashboard_documentsreportcard_XPATH"))).isDisplayed();

				if (documentCard == true) {
					successMessage("The Documents/Reports card is displayed correctly.");
				} else {
					verificationFailedMessage("The Documents/Reports card is not displayed correctly.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The Documents/Reports card is not displayed correctly.");
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

			try {
				// scroll down till Documents/Reports card
				scrollTillElement("ohsdashboard_documentsreportcard_XPATH");

				// validate the Documents/Reports card
				boolean documentCard = driver
						.findElement(By.xpath(OR.getProperty("ohsdashboard_documentsreportcard_XPATH"))).isDisplayed();

				if (documentCard == true) {
					successMessage("The Documents/Reports card is displayed correctly.");
				} else {
					verificationFailedMessage("The Documents/Reports card is not displayed correctly.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The Documents/Reports card is not displayed correctly.");
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

			try {
				// scroll down till Documents/Reports card
				scrollTillElement("ohsdashboard_documentsreportcard_XPATH");

				// validate the Documents/Reports card
				boolean documentCard = driver
						.findElement(By.xpath(OR.getProperty("ohsdashboard_documentsreportcard_XPATH"))).isDisplayed();

				if (documentCard == true) {
					successMessage("The Documents/Reports card is displayed correctly.");
				} else {
					verificationFailedMessage("The Documents/Reports card is not displayed correctly.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The Documents/Reports card is not displayed correctly.");
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
		// THE HR INCIDENTS DASHBOARD SCREEN
		title("VALIDATE THE NAVIGATION AFTER SWITCHING THE PROPERTY FROM THE HEADER OF THE HR INCIDENTS DASHBOARD SCREEN");

		try {

			// wait for the element
			Thread.sleep(5000);

			// click on the side menu
			click("menubtn_CSS");

			// wait for the element
			Thread.sleep(5000);

			// click on the ohs side menu
			click("sidemenu_ohs_XPATH");

			// select the option from the dashboard dropdown
			select("dashboard_CSS", "HR Incidents");

			// VALIDATE FOR PROPERTY ONE
			title("VALIDATE FOR PROPERTY ONE");

			// validate the HR Incidents title
			switchVerification("ohsdashboard_hrincidentstitle_XPATH", "HR Incidents",
					"The HR Incidents title is not displayed.");

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
				// scroll down till Documents/Reports card
				scrollTillElement("ohsdashboard_documentsreportcard_XPATH");

				// validate the Documents/Reports card
				boolean documentCard = driver
						.findElement(By.xpath(OR.getProperty("ohsdashboard_documentsreportcard_XPATH"))).isDisplayed();

				if (documentCard == true) {
					successMessage("The Documents/Reports card is displayed correctly.");
				} else {
					verificationFailedMessage("The Documents/Reports card is not displayed correctly.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The Documents/Reports card is not displayed correctly.");
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

			try {
				// scroll down till Documents/Reports card
				scrollTillElement("ohsdashboard_documentsreportcard_XPATH");

				// validate the Documents/Reports card
				boolean documentCard = driver
						.findElement(By.xpath(OR.getProperty("ohsdashboard_documentsreportcard_XPATH"))).isDisplayed();

				if (documentCard == true) {
					successMessage("The Documents/Reports card is displayed correctly.");
				} else {
					verificationFailedMessage("The Documents/Reports card is not displayed correctly.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The Documents/Reports card is not displayed correctly.");
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

			try {
				// scroll down till Documents/Reports card
				scrollTillElement("ohsdashboard_documentsreportcard_XPATH");

				// validate the Documents/Reports card
				boolean documentCard = driver
						.findElement(By.xpath(OR.getProperty("ohsdashboard_documentsreportcard_XPATH"))).isDisplayed();

				if (documentCard == true) {
					successMessage("The Documents/Reports card is displayed correctly.");
				} else {
					verificationFailedMessage("The Documents/Reports card is not displayed correctly.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The Documents/Reports card is not displayed correctly.");
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
		// THE INSURANCE INCIDENTS DASHBOARD SCREEN
		title("VALIDATE THE NAVIGATION AFTER SWITCHING THE PROPERTY FROM THE HEADER OF THE INSURANCE INCIDENTS DASHBOARD SCREEN");

		try {

			// wait for the element
			Thread.sleep(5000);

			// click on the side menu
			click("menubtn_CSS");

			// wait for the element
			Thread.sleep(5000);

			// click on the ohs side menu
			click("sidemenu_ohs_XPATH");

			// select the option from the dashboard dropdown
			select("dashboard_CSS", "Insurance Incidents");

			// VALIDATE FOR PROPERTY ONE
			title("VALIDATE FOR PROPERTY ONE");

			// validate the Insurance Incidents title
			switchVerification("ohsdashboard_insuranceincidentstitle_XPATH", "Insurance Incidents",
					"The Insurance Incidents title is not displayed.");

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
				// scroll down till Documents/Reports card
				scrollTillElement("ohsdashboard_documentsreportcard_XPATH");

				// validate the Documents/Reports card
				boolean documentCard = driver
						.findElement(By.xpath(OR.getProperty("ohsdashboard_documentsreportcard_XPATH"))).isDisplayed();

				if (documentCard == true) {
					successMessage("The Documents/Reports card is displayed correctly.");
				} else {
					verificationFailedMessage("The Documents/Reports card is not displayed correctly.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The Documents/Reports card is not displayed correctly.");
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

			try {
				// scroll down till Documents/Reports card
				scrollTillElement("ohsdashboard_documentsreportcard_XPATH");

				// validate the Documents/Reports card
				boolean documentCard = driver
						.findElement(By.xpath(OR.getProperty("ohsdashboard_documentsreportcard_XPATH"))).isDisplayed();

				if (documentCard == true) {
					successMessage("The Documents/Reports card is displayed correctly.");
				} else {
					verificationFailedMessage("The Documents/Reports card is not displayed correctly.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The Documents/Reports card is not displayed correctly.");
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

			try {
				// scroll down till Documents/Reports card
				scrollTillElement("ohsdashboard_documentsreportcard_XPATH");

				// validate the Documents/Reports card
				boolean documentCard = driver
						.findElement(By.xpath(OR.getProperty("ohsdashboard_documentsreportcard_XPATH"))).isDisplayed();

				if (documentCard == true) {
					successMessage("The Documents/Reports card is displayed correctly.");
				} else {
					verificationFailedMessage("The Documents/Reports card is not displayed correctly.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The Documents/Reports card is not displayed correctly.");
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
		// THE ASSESSMENTS/INSPECTIONS DASHBOARD SCREEN
		title("VALIDATE THE NAVIGATION AFTER SWITCHING THE PROPERTY FROM THE HEADER OF THE ASSESSMENTS/INSPECTIONS DASHBOARD SCREEN");

		try {

			// wait for the element
			Thread.sleep(5000);

			// click on the side menu
			click("menubtn_CSS");

			// wait for the element
			Thread.sleep(5000);

			// click on the ohs from side menu
			click("sidemenu_ohs_XPATH");

			// select the option from the dashboard dropdown
			select("dashboard_CSS", "Assessments/Inspections");

			// VALIDATE FOR PROPERTY ONE
			title("VALIDATE FOR PROPERTY ONE");

			// validate the Assessments/Inspections title
			switchVerification("ohsdashboard_assessmentsinspectionstitle_XPATH", "Assessments/Inspections",
					"The Assessments/Inspections title is not displayed.");

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
				// scroll down till Documents/Reports card
				scrollTillElement("ohsdashboard_documentsreportcard_XPATH");

				// validate the Documents/Reports card
				boolean documentCard = driver
						.findElement(By.xpath(OR.getProperty("ohsdashboard_documentsreportcard_XPATH"))).isDisplayed();

				if (documentCard == true) {
					successMessage("The Documents/Reports card is displayed correctly.");
				} else {
					verificationFailedMessage("The Documents/Reports card is not displayed correctly.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The Documents/Reports card is not displayed correctly.");
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

			try {
				// scroll down till Documents/Reports card
				scrollTillElement("ohsdashboard_documentsreportcard_XPATH");

				// validate the Documents/Reports card
				boolean documentCard = driver
						.findElement(By.xpath(OR.getProperty("ohsdashboard_documentsreportcard_XPATH"))).isDisplayed();

				if (documentCard == true) {
					successMessage("The Documents/Reports card is displayed correctly.");
				} else {
					verificationFailedMessage("The Documents/Reports card is not displayed correctly.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The Documents/Reports card is not displayed correctly.");
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

			try {
				// scroll down till Documents/Reports card
				scrollTillElement("ohsdashboard_documentsreportcard_XPATH");

				// validate the Documents/Reports card
				boolean documentCard = driver
						.findElement(By.xpath(OR.getProperty("ohsdashboard_documentsreportcard_XPATH"))).isDisplayed();

				if (documentCard == true) {
					successMessage("The Documents/Reports card is displayed correctly.");
				} else {
					verificationFailedMessage("The Documents/Reports card is not displayed correctly.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The Documents/Reports card is not displayed correctly.");
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
		// THE INCIDENTS SUMMARY DASHBOARD SCREEN
		title("VALIDATE THE NAVIGATION AFTER SWITCHING THE PROPERTY FROM THE HEADER OF THE INCIDENTS SUMMARY DASHBOARD SCREEN");

		try {

			// wait for the element
			Thread.sleep(5000);

			// click on the side menu
			click("menubtn_CSS");

			// wait for the element
			Thread.sleep(5000);

			// click on the ohs from side menu
			click("sidemenu_ohs_XPATH");

			// select the option from the dashboard dropdown
			select("dashboard_CSS", "Incident Summary");

			// VALIDATE FOR PROPERTY ONE
			title("VALIDATE FOR PROPERTY ONE");

			// validate the Incident Summary title
			switchVerification("ohsdashboard_incidenttypelbl_XPATH", "Incident Type:",
					"The Incident Type label is not displayed.");

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
				// scroll down till Documents/Reports card
				scrollTillElement("ohsdashboard_documentsreportcard_XPATH");

				// validate the Documents/Reports card
				boolean documentCard = driver
						.findElement(By.xpath(OR.getProperty("ohsdashboard_documentsreportcard_XPATH"))).isDisplayed();

				if (documentCard == true) {
					successMessage("The Documents/Reports card is displayed correctly.");
				} else {
					verificationFailedMessage("The Documents/Reports card is not displayed correctly.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The Documents/Reports card is not displayed correctly.");
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

			try {
				// scroll down till Documents/Reports card
				scrollTillElement("ohsdashboard_documentsreportcard_XPATH");

				// validate the Documents/Reports card
				boolean documentCard = driver
						.findElement(By.xpath(OR.getProperty("ohsdashboard_documentsreportcard_XPATH"))).isDisplayed();

				if (documentCard == true) {
					successMessage("The Documents/Reports card is displayed correctly.");
				} else {
					verificationFailedMessage("The Documents/Reports card is not displayed correctly.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The Documents/Reports card is not displayed correctly.");
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

			try {
				// scroll down till Documents/Reports card
				scrollTillElement("ohsdashboard_documentsreportcard_XPATH");

				// validate the Documents/Reports card
				boolean documentCard = driver
						.findElement(By.xpath(OR.getProperty("ohsdashboard_documentsreportcard_XPATH"))).isDisplayed();

				if (documentCard == true) {
					successMessage("The Documents/Reports card is displayed correctly.");
				} else {
					verificationFailedMessage("The Documents/Reports card is not displayed correctly.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The Documents/Reports card is not displayed correctly.");
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
		// THE INJURY SUMMARY DASHBOARD SCREEN
		title("VALIDATE THE NAVIGATION AFTER SWITCHING THE PROPERTY FROM THE HEADER OF THE INJURY SUMMARY DASHBOARD SCREEN");

		try {

			// wait for the element
			Thread.sleep(5000);

			// click on the side menu
			click("menubtn_CSS");

			// wait for the element
			Thread.sleep(5000);

			// click on the ohs from side menu
			click("sidemenu_ohs_XPATH");

			// select the option from the dashboard dropdown
			select("dashboard_CSS", "Injury Summary");

			// VALIDATE FOR PROPERTY ONE
			title("VALIDATE FOR PROPERTY ONE");

			// validate the Incident Summary title
			switchVerification("ohsdashboard_eventtypelbl_XPATH", "Event Type:",
					"The Event Type label is not displayed.");

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
				// scroll down till Documents/Reports card
				scrollTillElement("ohsdashboard_documentsreportcard_XPATH");

				// validate the Documents/Reports card
				boolean documentCard = driver
						.findElement(By.xpath(OR.getProperty("ohsdashboard_documentsreportcard_XPATH"))).isDisplayed();

				if (documentCard == true) {
					successMessage("The Documents/Reports card is displayed correctly.");
				} else {
					verificationFailedMessage("The Documents/Reports card is not displayed correctly.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The Documents/Reports card is not displayed correctly.");
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

			try {
				// scroll down till Documents/Reports card
				scrollTillElement("ohsdashboard_documentsreportcard_XPATH");

				// validate the Documents/Reports card
				boolean documentCard = driver
						.findElement(By.xpath(OR.getProperty("ohsdashboard_documentsreportcard_XPATH"))).isDisplayed();

				if (documentCard == true) {
					successMessage("The Documents/Reports card is displayed correctly.");
				} else {
					verificationFailedMessage("The Documents/Reports card is not displayed correctly.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The Documents/Reports card is not displayed correctly.");
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

			try {
				// scroll down till Documents/Reports card
				scrollTillElement("ohsdashboard_documentsreportcard_XPATH");

				// validate the Documents/Reports card
				boolean documentCard = driver
						.findElement(By.xpath(OR.getProperty("ohsdashboard_documentsreportcard_XPATH"))).isDisplayed();

				if (documentCard == true) {
					successMessage("The Documents/Reports card is displayed correctly.");
				} else {
					verificationFailedMessage("The Documents/Reports card is not displayed correctly.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The Documents/Reports card is not displayed correctly.");
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
