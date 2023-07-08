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

public class RR6447NavigationProperty1Test extends TestBase {

	@Test(dataProviderClass = TestUtil.class, dataProvider = "dp")
	public void rR6447NavigationProperty1Test(Hashtable<String, String> data) throws InterruptedException, IOException {

		execution(data, "rR6447NavigationProperty1Test");

		// SUSTAINABILITY DASHBOARD - NAVIGATION SCENARIO OF THE ENERGY, WATER, WASTE,
		// GHG EMISSIONS, CARBON PERFORMANCE, BUILDING CERTIFICATIONS, UTILITY BILLS,
		// UTILITY BILL IMPORT LOGS
		title("SUSTAINABILITY DASHBOARD - NAVIGATION SCENARIO OF THE ENERGY, WATER, WASTE, GHG EMISSIONS, CARBON PERFORMANCE, BUILDING CERTIFICATIONS, UTILITY BILLS, UTILITY BILL IMPORT LOGS");

		// refresh the page
		driver.navigate().refresh();
		Thread.sleep(5000);
		driver.navigate().refresh();

		// VALIDATE THE NAVIGATION AFTER SWITCHING THE PROPERTY FROM THE HEADER OF
		// THE ENERGY DASHBOARD SCREEN
		title("VALIDATE THE NAVIGATION AFTER SWITCHING THE PROPERTY FROM THE HEADER OF THE ENERGY DASHBOARD SCREEN");

		try {

			// wait for the element
			Thread.sleep(5000);

			// click on the side menu
			click("menubtn_CSS");

			// wait for the element
			Thread.sleep(5000);

			// click on the sustainability side menu
			click("sidemenu_sustainability_XPATH");

			// select the option from the dashboard dropdown
			select("dashboard_CSS", "Energy");

			// VALIDATE FOR PROPERTY ONE
			title("VALIDATE FOR PROPERTY ONE");

			// validate the utility label
			switchVerification("sustainabilitydashboard_utilitylbl_XPATH", "Utility:",
					"The Utility label is not displayed.");

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
				// scroll down till Performance Summary Report card
				scrollTillElement("sustainabilitydashboard_performancesummarycard_XPATH");

				// validate the Performance Summary Report card
				boolean performancesummaryCard = driver
						.findElement(By.xpath(OR.getProperty("sustainabilitydashboard_performancesummarycard_XPATH")))
						.isDisplayed();

				if (performancesummaryCard == true) {
					successMessage("The Performance Summary Report card is displayed correctly.");
				} else {
					verificationFailedMessage("The Performance Summary Report card is not displayed correctly.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The Performance Summary Report card is not displayed correctly.");
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
				// scroll down till Performance Summary Report card
				scrollTillElement("sustainabilitydashboard_performancesummarycard_XPATH");

				// validate the Performance Summary Report card
				boolean performancesummaryCard = driver
						.findElement(By.xpath(OR.getProperty("sustainabilitydashboard_performancesummarycard_XPATH")))
						.isDisplayed();

				if (performancesummaryCard == true) {
					successMessage("The Performance Summary Report card is displayed correctly.");
				} else {
					verificationFailedMessage("The Performance Summary Report card is not displayed correctly.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The Performance Summary Report card is not displayed correctly.");
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
				// scroll down till Performance Summary Report card
				scrollTillElement("sustainabilitydashboard_performancesummarycard_XPATH");

				// validate the Performance Summary Report card
				boolean performancesummaryCard = driver
						.findElement(By.xpath(OR.getProperty("sustainabilitydashboard_performancesummarycard_XPATH")))
						.isDisplayed();

				if (performancesummaryCard == true) {
					successMessage("The Performance Summary Report card is displayed correctly.");
				} else {
					verificationFailedMessage("The Performance Summary Report card is not displayed correctly.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The Performance Summary Report card is not displayed correctly.");
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
		// THE WATER DASHBOARD SCREEN
		title("VALIDATE THE NAVIGATION AFTER SWITCHING THE PROPERTY FROM THE HEADER OF THE WATER DASHBOARD SCREEN");

		try {

			// wait for the element
			Thread.sleep(5000);

			// click on the side menu
			click("menubtn_CSS");

			// wait for the element
			Thread.sleep(5000);

			// click on the sustainability side menu
			click("sidemenu_sustainability_XPATH");

			// select the option from the dashboard dropdown
			select("dashboard_CSS", "Water");

			// VALIDATE FOR PROPERTY ONE
			title("VALIDATE FOR PROPERTY ONE");

			// validate the Years label
			switchVerification("sustainabilitydashboard_yearlbl_XPATH", "Years:", "The Years label is not displayed.");

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
				// scroll down till Performance Summary Report card
				scrollTillElement("sustainabilitydashboard_performancesummarycard_XPATH");
				scrollByPixel(-200);

				// validate the Performance Summary Report card
				boolean performancesummaryCard = driver
						.findElement(By.xpath(OR.getProperty("sustainabilitydashboard_performancesummarycard_XPATH")))
						.isDisplayed();

				if (performancesummaryCard == true) {
					successMessage("The Performance Summary Report card is displayed correctly.");
				} else {
					verificationFailedMessage("The Performance Summary Report card is not displayed correctly.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The Performance Summary Report card is not displayed correctly.");
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
				// scroll down till Performance Summary Report card
				scrollTillElement("sustainabilitydashboard_performancesummarycard_XPATH");
				scrollByPixel(-200);

				// validate the Performance Summary Report card
				boolean performancesummaryCard = driver
						.findElement(By.xpath(OR.getProperty("sustainabilitydashboard_performancesummarycard_XPATH")))
						.isDisplayed();

				if (performancesummaryCard == true) {
					successMessage("The Performance Summary Report card is displayed correctly.");
				} else {
					verificationFailedMessage("The Performance Summary Report card is not displayed correctly.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The Performance Summary Report card is not displayed correctly.");
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
				// scroll down till Performance Summary Report card
				scrollTillElement("sustainabilitydashboard_performancesummarycard_XPATH");
				scrollByPixel(-200);

				// validate the Performance Summary Report card
				boolean performancesummaryCard = driver
						.findElement(By.xpath(OR.getProperty("sustainabilitydashboard_performancesummarycard_XPATH")))
						.isDisplayed();

				if (performancesummaryCard == true) {
					successMessage("The Performance Summary Report card is displayed correctly.");
				} else {
					verificationFailedMessage("The Performance Summary Report card is not displayed correctly.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The Performance Summary Report card is not displayed correctly.");
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
		// THE WASTE DASHBOARD SCREEN
		title("VALIDATE THE NAVIGATION AFTER SWITCHING THE PROPERTY FROM THE HEADER OF THE WASTE DASHBOARD SCREEN");

		try {

			// wait for the element
			Thread.sleep(5000);

			// click on the side menu
			click("menubtn_CSS");

			// wait for the element
			Thread.sleep(5000);

			// click on the sustainability side menu
			click("sidemenu_sustainability_XPATH");

			// select the option from the dashboard dropdown
			select("dashboard_CSS", "Waste");

			// VALIDATE FOR PROPERTY ONE
			title("VALIDATE FOR PROPERTY ONE");

			// validate the Years label
			switchVerification("sustainabilitydashboard_steamlbl_XPATH", "Stream:",
					"The Stream label is not displayed.");

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
				// scroll down till Performance Summary Report card
				scrollTillElement("sustainabilitydashboard_performancesummarycard_XPATH");
				scrollByPixel(-200);

				// validate the Performance Summary Report card
				boolean performancesummaryCard = driver
						.findElement(By.xpath(OR.getProperty("sustainabilitydashboard_performancesummarycard_XPATH")))
						.isDisplayed();

				if (performancesummaryCard == true) {
					successMessage("The Performance Summary Report card is displayed correctly.");
				} else {
					verificationFailedMessage("The Performance Summary Report card is not displayed correctly.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The Performance Summary Report card is not displayed correctly.");
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
				// scroll down till Performance Summary Report card
				scrollTillElement("sustainabilitydashboard_performancesummarycard_XPATH");
				scrollByPixel(-200);

				// validate the Performance Summary Report card
				boolean performancesummaryCard = driver
						.findElement(By.xpath(OR.getProperty("sustainabilitydashboard_performancesummarycard_XPATH")))
						.isDisplayed();

				if (performancesummaryCard == true) {
					successMessage("The Performance Summary Report card is displayed correctly.");
				} else {
					verificationFailedMessage("The Performance Summary Report card is not displayed correctly.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The Performance Summary Report card is not displayed correctly.");
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
				// scroll down till Performance Summary Report card
				scrollTillElement("sustainabilitydashboard_performancesummarycard_XPATH");
				scrollByPixel(-200);

				// validate the Performance Summary Report card
				boolean performancesummaryCard = driver
						.findElement(By.xpath(OR.getProperty("sustainabilitydashboard_performancesummarycard_XPATH")))
						.isDisplayed();

				if (performancesummaryCard == true) {
					successMessage("The Performance Summary Report card is displayed correctly.");
				} else {
					verificationFailedMessage("The Performance Summary Report card is not displayed correctly.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The Performance Summary Report card is not displayed correctly.");
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
		// THE GHG EMISSION DASHBOARD SCREEN
		title("VALIDATE THE NAVIGATION AFTER SWITCHING THE PROPERTY FROM THE HEADER OF THE GHG EMISSION DASHBOARD SCREEN");

		try {

			// wait for the element
			Thread.sleep(5000);

			// click on the side menu
			click("menubtn_CSS");

			// wait for the element
			Thread.sleep(5000);

			// click on the sustainability side menu
			click("sidemenu_sustainability_XPATH");

			// select the option from the dashboard dropdown
			select("dashboard_CSS", "GHG Emissions");

			// VALIDATE FOR PROPERTY ONE
			title("VALIDATE FOR PROPERTY ONE");

			// validate the utility label
			switchVerification("sustainabilitydashboard_utilitylbl_XPATH", "Utility:",
					"The Utility label is not displayed.");

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
				// scroll down till Performance Summary Report card
				scrollTillElement("sustainabilitydashboard_performancesummarycard_XPATH");
				scrollByPixel(-200);

				// validate the Performance Summary Report card
				boolean performancesummaryCard = driver
						.findElement(By.xpath(OR.getProperty("sustainabilitydashboard_performancesummarycard_XPATH")))
						.isDisplayed();

				if (performancesummaryCard == true) {
					successMessage("The Performance Summary Report card is displayed correctly.");
				} else {
					verificationFailedMessage("The Performance Summary Report card is not displayed correctly.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The Performance Summary Report card is not displayed correctly.");
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
				// scroll down till Performance Summary Report card
				scrollTillElement("sustainabilitydashboard_performancesummarycard_XPATH");
				scrollByPixel(-200);

				// validate the Performance Summary Report card
				boolean performancesummaryCard = driver
						.findElement(By.xpath(OR.getProperty("sustainabilitydashboard_performancesummarycard_XPATH")))
						.isDisplayed();

				if (performancesummaryCard == true) {
					successMessage("The Performance Summary Report card is displayed correctly.");
				} else {
					verificationFailedMessage("The Performance Summary Report card is not displayed correctly.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The Performance Summary Report card is not displayed correctly.");
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
				// scroll down till Performance Summary Report card
				scrollTillElement("sustainabilitydashboard_performancesummarycard_XPATH");
				scrollByPixel(-200);

				// validate the Performance Summary Report card
				boolean performancesummaryCard = driver
						.findElement(By.xpath(OR.getProperty("sustainabilitydashboard_performancesummarycard_XPATH")))
						.isDisplayed();

				if (performancesummaryCard == true) {
					successMessage("The Performance Summary Report card is displayed correctly.");
				} else {
					verificationFailedMessage("The Performance Summary Report card is not displayed correctly.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The Performance Summary Report card is not displayed correctly.");
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
		// THE CARBON PERFORMANCE DASHBOARD SCREEN
		title("VALIDATE THE NAVIGATION AFTER SWITCHING THE PROPERTY FROM THE HEADER OF THE CARBON PERFORMANCE DASHBOARD SCREEN");

		try {

			// wait for the element
			Thread.sleep(5000);

			// click on the side menu
			click("menubtn_CSS");

			// wait for the element
			Thread.sleep(5000);

			// click on the sustainability side menu
			click("sidemenu_sustainability_XPATH");

			// select the option from the dashboard dropdown
			select("dashboard_CSS", "Carbon Performance");

			// VALIDATE FOR PROPERTY ONE
			title("VALIDATE FOR PROPERTY ONE");

			// validate the Base Year Emission label
			switchVerification("sustainabilitydashboard_baseyearemissionlbl_XPATH", "Base Year Emission",
					"The Base Year Emission label is not displayed.");

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
				// scroll down till Performance Summary Report card
				scrollTillElement("sustainabilitydashboard_performancesummarycard_XPATH");
				scrollByPixel(-200);

				// validate the Performance Summary Report card
				boolean performancesummaryCard = driver
						.findElement(By.xpath(OR.getProperty("sustainabilitydashboard_performancesummarycard_XPATH")))
						.isDisplayed();

				if (performancesummaryCard == true) {
					successMessage("The Performance Summary Report card is displayed correctly.");
				} else {
					verificationFailedMessage("The Performance Summary Report card is not displayed correctly.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The Performance Summary Report card is not displayed correctly.");
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
				// scroll down till Performance Summary Report card
				scrollTillElement("sustainabilitydashboard_performancesummarycard_XPATH");
				scrollByPixel(-200);

				// validate the Performance Summary Report card
				boolean performancesummaryCard = driver
						.findElement(By.xpath(OR.getProperty("sustainabilitydashboard_performancesummarycard_XPATH")))
						.isDisplayed();

				if (performancesummaryCard == true) {
					successMessage("The Performance Summary Report card is displayed correctly.");
				} else {
					verificationFailedMessage("The Performance Summary Report card is not displayed correctly.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The Performance Summary Report card is not displayed correctly.");
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
				// scroll down till Performance Summary Report card
				scrollTillElement("sustainabilitydashboard_performancesummarycard_XPATH");
				scrollByPixel(-200);

				// validate the Performance Summary Report card
				boolean performancesummaryCard = driver
						.findElement(By.xpath(OR.getProperty("sustainabilitydashboard_performancesummarycard_XPATH")))
						.isDisplayed();

				if (performancesummaryCard == true) {
					successMessage("The Performance Summary Report card is displayed correctly.");
				} else {
					verificationFailedMessage("The Performance Summary Report card is not displayed correctly.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The Performance Summary Report card is not displayed correctly.");
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
		// THE BUILDING CERTIFICATIONS DASHBOARD SCREEN
		title("VALIDATE THE NAVIGATION AFTER SWITCHING THE PROPERTY FROM THE HEADER OF THE BUILDING CERTIFICATIONS DASHBOARD SCREEN");

		try {

			// wait for the element
			Thread.sleep(5000);

			// click on the side menu
			click("menubtn_CSS");

			// wait for the element
			Thread.sleep(5000);

			// click on the sustainability side menu
			click("sidemenu_sustainability_XPATH");

			// select the option from the dashboard dropdown
			select("dashboard_CSS", "Building Certifications");

			// VALIDATE FOR PROPERTY ONE
			title("VALIDATE FOR PROPERTY ONE");

			// validate the Active Certifications label
			switchVerification("sustainabilitydashboard_activecertificationlbl_XPATH", "Active Certifications",
					"The Active Certifications label is not displayed.");

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
				// scroll down till Performance Summary Report card
				scrollTillElement("sustainabilitydashboard_performancesummarycard_XPATH");
				scrollByPixel(-200);

				// validate the Performance Summary Report card
				boolean performancesummaryCard = driver
						.findElement(By.xpath(OR.getProperty("sustainabilitydashboard_performancesummarycard_XPATH")))
						.isDisplayed();

				if (performancesummaryCard == true) {
					successMessage("The Performance Summary Report card is displayed correctly.");
				} else {
					verificationFailedMessage("The Performance Summary Report card is not displayed correctly.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The Performance Summary Report card is not displayed correctly.");
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
				// scroll down till Performance Summary Report card
				scrollTillElement("sustainabilitydashboard_performancesummarycard_XPATH");
				scrollByPixel(-200);

				// validate the Performance Summary Report card
				boolean performancesummaryCard = driver
						.findElement(By.xpath(OR.getProperty("sustainabilitydashboard_performancesummarycard_XPATH")))
						.isDisplayed();

				if (performancesummaryCard == true) {
					successMessage("The Performance Summary Report card is displayed correctly.");
				} else {
					verificationFailedMessage("The Performance Summary Report card is not displayed correctly.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The Performance Summary Report card is not displayed correctly.");
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
				// scroll down till Performance Summary Report card
				scrollTillElement("sustainabilitydashboard_performancesummarycard_XPATH");
				scrollByPixel(-200);

				// validate the Performance Summary Report card
				boolean performancesummaryCard = driver
						.findElement(By.xpath(OR.getProperty("sustainabilitydashboard_performancesummarycard_XPATH")))
						.isDisplayed();

				if (performancesummaryCard == true) {
					successMessage("The Performance Summary Report card is displayed correctly.");
				} else {
					verificationFailedMessage("The Performance Summary Report card is not displayed correctly.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The Performance Summary Report card is not displayed correctly.");
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
		// THE UTILITY BILLS DASHBOARD SCREEN
		title("VALIDATE THE NAVIGATION AFTER SWITCHING THE PROPERTY FROM THE HEADER OF THE UTILITY BILLS DASHBOARD SCREEN");

		try {

			// wait for the element
			Thread.sleep(5000);

			// click on the side menu
			click("menubtn_CSS");

			// wait for the element
			Thread.sleep(5000);

			// click on the sustainability side menu
			click("sidemenu_sustainability_XPATH");

			// select the option from the dashboard dropdown
			select("dashboard_CSS", "Utility Bills");

			// VALIDATE FOR PROPERTY ONE
			title("VALIDATE FOR PROPERTY ONE");

			// validate the Active Certifications label
			switchVerification("sustainabilitydashboard_utilitybillstitle_XPATH", "Utility Bills",
					"The Utility Bills label is not displayed.");

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
				// scroll down till Performance Summary Report card
				scrollTillElement("sustainabilitydashboard_performancesummarycard_XPATH");
				scrollByPixel(-200);

				// validate the Performance Summary Report card
				boolean performancesummaryCard = driver
						.findElement(By.xpath(OR.getProperty("sustainabilitydashboard_performancesummarycard_XPATH")))
						.isDisplayed();

				if (performancesummaryCard == true) {
					successMessage("The Performance Summary Report card is displayed correctly.");
				} else {
					verificationFailedMessage("The Performance Summary Report card is not displayed correctly.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The Performance Summary Report card is not displayed correctly.");
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
				// scroll down till Performance Summary Report card
				scrollTillElement("sustainabilitydashboard_performancesummarycard_XPATH");
				scrollByPixel(-200);

				// validate the Performance Summary Report card
				boolean performancesummaryCard = driver
						.findElement(By.xpath(OR.getProperty("sustainabilitydashboard_performancesummarycard_XPATH")))
						.isDisplayed();

				if (performancesummaryCard == true) {
					successMessage("The Performance Summary Report card is displayed correctly.");
				} else {
					verificationFailedMessage("The Performance Summary Report card is not displayed correctly.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The Performance Summary Report card is not displayed correctly.");
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
				// scroll down till Performance Summary Report card
				scrollTillElement("sustainabilitydashboard_performancesummarycard_XPATH");
				scrollByPixel(-200);

				// validate the Performance Summary Report card
				boolean performancesummaryCard = driver
						.findElement(By.xpath(OR.getProperty("sustainabilitydashboard_performancesummarycard_XPATH")))
						.isDisplayed();

				if (performancesummaryCard == true) {
					successMessage("The Performance Summary Report card is displayed correctly.");
				} else {
					verificationFailedMessage("The Performance Summary Report card is not displayed correctly.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The Performance Summary Report card is not displayed correctly.");
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
		// THE UTILITY BILL IMPORT LOGS DASHBOARD SCREEN
		title("VALIDATE THE NAVIGATION AFTER SWITCHING THE PROPERTY FROM THE HEADER OF THE UTILITY BILL IMPORT LOGS DASHBOARD SCREEN");

		try {

			// wait for the element
			Thread.sleep(5000);

			// click on the side menu
			click("menubtn_CSS");

			// wait for the element
			Thread.sleep(5000);

			// click on the sustainability side menu
			click("sidemenu_sustainability_XPATH");

			// select the option from the dashboard dropdown
			select("dashboard_CSS", "Utility Bill Import Logs");

			// VALIDATE FOR PROPERTY ONE
			title("VALIDATE FOR PROPERTY ONE");

			// validate the Active Certifications label
			switchVerification("sustainabilitydashboard_utilitybillimportlogstitle_XPATH", "Utility Bill Import Logs",
					"The Utility Bill Import Logs label is not displayed.");

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
				// scroll down till Performance Summary Report card
				scrollTillElement("sustainabilitydashboard_performancesummarycard_XPATH");
				scrollByPixel(-200);

				// validate the Performance Summary Report card
				boolean performancesummaryCard = driver
						.findElement(By.xpath(OR.getProperty("sustainabilitydashboard_performancesummarycard_XPATH")))
						.isDisplayed();

				if (performancesummaryCard == true) {
					successMessage("The Performance Summary Report card is displayed correctly.");
				} else {
					verificationFailedMessage("The Performance Summary Report card is not displayed correctly.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The Performance Summary Report card is not displayed correctly.");
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
				// scroll down till Performance Summary Report card
				scrollTillElement("sustainabilitydashboard_performancesummarycard_XPATH");
				scrollByPixel(-200);

				// validate the Performance Summary Report card
				boolean performancesummaryCard = driver
						.findElement(By.xpath(OR.getProperty("sustainabilitydashboard_performancesummarycard_XPATH")))
						.isDisplayed();

				if (performancesummaryCard == true) {
					successMessage("The Performance Summary Report card is displayed correctly.");
				} else {
					verificationFailedMessage("The Performance Summary Report card is not displayed correctly.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The Performance Summary Report card is not displayed correctly.");
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
				// scroll down till Performance Summary Report card
				scrollTillElement("sustainabilitydashboard_performancesummarycard_XPATH");
				scrollByPixel(-200);

				// validate the Performance Summary Report card
				boolean performancesummaryCard = driver
						.findElement(By.xpath(OR.getProperty("sustainabilitydashboard_performancesummarycard_XPATH")))
						.isDisplayed();

				if (performancesummaryCard == true) {
					successMessage("The Performance Summary Report card is displayed correctly.");
				} else {
					verificationFailedMessage("The Performance Summary Report card is not displayed correctly.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The Performance Summary Report card is not displayed correctly.");
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
