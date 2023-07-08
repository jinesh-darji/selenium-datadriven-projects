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

public class RR6439NavigationProperty1Test extends TestBase {

	@Test(dataProviderClass = TestUtil.class, dataProvider = "dp")
	public void rR6439NavigationProperty1Test(Hashtable<String, String> data) throws InterruptedException, IOException {

		execution(data, "rR6439NavigationProperty1Test");

		// ENVIRONMENTAL DASHBOARD - NAVIGATION SCENARIO OF THE ENVIRONMENTAL SUMMARY
		// DASHBOARD AND ASSESSMENTS/INSPECTIONS.
		title("ENVIRONMENTAL DASHBOARD - NAVIGATION SCENARIO OF THE ENVIRONMENTAL SUMMARY DASHBOARD AND ASSESSMENTS/INSPECTIONS.");

		// refresh the page
		driver.navigate().refresh();
		Thread.sleep(5000);
		driver.navigate().refresh();

		// VALIDATE THE NAVIGATION AFTER SWITCHING THE PROPERTY FROM THE HEADER OF
		// THE ENVIRONMENTAL SUMMARY DASHBOARD SCREEN
		title("VALIDATE THE NAVIGATION AFTER SWITCHING THE PROPERTY FROM THE HEADER OF THE ENVIRONMENTAL SUMMARY DASHBOARD SCREEN");

		try {

			// wait for the element
			Thread.sleep(5000);

			// click on the side menu
			click("menubtn_CSS");

			// wait for the element
			Thread.sleep(5000);

			// click on the environmental from side menu
			click("sidemenu_environemental_XPATH");

			// select the option from the dashboard dropdown
			select("dashboard_CSS", "Environmental Summary");

			// VALIDATE FOR PROPERTY ONE
			title("VALIDATE FOR PROPERTY ONE");

			// validate the environmental summary title
			switchVerification("environmentaldashboard_environmentalsummarytitle_XPATH", "Environmental Summary",
					"The Environmental Summary title is not displayed.");

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

				// validate the environmental summary card
				boolean envCard = driver
						.findElement(By.xpath(
								OR.getProperty("navigation_environmentalsummary_environmentalsummarycard_XPATH")))
						.isDisplayed();

				if (envCard == true) {
					successMessage("The environmental summary card is displayed correctly.");
				} else {
					verificationFailedMessage("The environmental summary card is not displayed correctly.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The environmental summary card is not displayed correctly.");
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
				// validate the environmental summary card
				boolean envCard = driver
						.findElement(By.xpath(
								OR.getProperty("navigation_environmentalsummary_environmentalsummarycard_XPATH")))
						.isDisplayed();

				if (envCard == true) {
					successMessage("The environmental summary card is displayed correctly.");
				} else {
					verificationFailedMessage("The environmental summary card is not displayed correctly.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The environmental summary card is not displayed correctly.");
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

			// wait for the element
			Thread.sleep(5000);

			// validate the property name
			switchVerification("navigation_header_propertyname1_XPATH", "[DND] AAAA Risk Test Prop 01 - 01",
					"The property name is not displayed.");

			try {
				// validate the environmental summary card
				boolean envCard = driver
						.findElement(By.xpath(
								OR.getProperty("navigation_environmentalsummary_environmentalsummarycard_XPATH")))
						.isDisplayed();

				if (envCard == true) {
					successMessage("The environmental summary card is displayed correctly.");
				} else {
					verificationFailedMessage("The environmental summary card is not displayed correctly.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The environmental summary card is not displayed correctly.");
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

			// click on the environmental from side menu
			click("sidemenu_environemental_XPATH");

			// select the option from the dashboard dropdown
			select("dashboard_CSS", "Assessments/Inspections");

			// VALIDATE FOR PROPERTY ONE
			title("VALIDATE FOR PROPERTY ONE");

			// validate the Assessments/Inspections title
			switchVerification("environmentaldashboard_assessmentsinspectionstitle_XPATH", "Assessments/Inspections",
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
				// validate the environmental summary card
				boolean envCard = driver
						.findElement(By.xpath(
								OR.getProperty("navigation_environmentalsummary_environmentalsummarycard_XPATH")))
						.isDisplayed();

				if (envCard == true) {
					successMessage("The environmental summary card is displayed correctly.");
				} else {
					verificationFailedMessage("The environmental summary card is not displayed correctly.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The environmental summary card is not displayed correctly.");
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
				// validate the environmental summary card
				boolean envCard = driver
						.findElement(By.xpath(
								OR.getProperty("navigation_environmentalsummary_environmentalsummarycard_XPATH")))
						.isDisplayed();

				if (envCard == true) {
					successMessage("The environmental summary card is displayed correctly.");
				} else {
					verificationFailedMessage("The environmental summary card is not displayed correctly.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The environmental summary card is not displayed correctly.");
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

			// wait for the element
			Thread.sleep(5000);

			// validate the property name
			switchVerification("navigation_header_propertyname1_XPATH", "[DND] AAAA Risk Test Prop 01 - 01",
					"The property name is not displayed.");

			try {
				// validate the environmental summary card
				boolean envCard = driver
						.findElement(By.xpath(
								OR.getProperty("navigation_environmentalsummary_environmentalsummarycard_XPATH")))
						.isDisplayed();

				if (envCard == true) {
					successMessage("The environmental summary card is displayed correctly.");
				} else {
					verificationFailedMessage("The environmental summary card is not displayed correctly.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The environmental summary card is not displayed correctly.");
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
