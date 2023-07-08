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

public class RR6446NavigationProperty1Test extends TestBase {

	@Test(dataProviderClass = TestUtil.class, dataProvider = "dp")
	public void rR6446NavigationProperty1Test(Hashtable<String, String> data) throws InterruptedException, IOException {

		execution(data, "rR6446NavigationProperty1Test");

		// RISK MANAGEMENT DASHBOARD - NAVIGATION SCENARIO OF THE INSURANCE POLICIES,
		// COVERAGE SUMMARY, POLICIES SUMMARY, CLAIMS SUMMARY, RECOMMENDATIONS,
		// INSURANCE CLAIMS.
		title("RISK MANAGEMENT DASHBOARD - NAVIGATION SCENARIO OF THE INSURANCE POLICIES, COVERAGE SUMMARY, POLICIES SUMMARY, CLAIMS SUMMARY, RECOMMENDATIONS, INSURANCE CLAIMS.");

		// refresh the page
		driver.navigate().refresh();
		Thread.sleep(5000);
		driver.navigate().refresh();

		// VALIDATE THE NAVIGATION AFTER SWITCHING THE PROPERTY FROM THE HEADER OF
		// THE INSURANCE POLICIES DASHBOARD SCREEN
		title("VALIDATE THE NAVIGATION AFTER SWITCHING THE PROPERTY FROM THE HEADER OF THE INSURANCE POLICIES DASHBOARD SCREEN");

		try {

			// wait for the element
			Thread.sleep(5000);

			// click on the side menu
			click("menubtn_CSS");

			// wait for the element
			Thread.sleep(5000);

			// click on the risk management side menu
			click("sidemenu_riskmanagement_XPATH");

			// select the option from the dashboard dropdown
			select("dashboard_CSS", "Insurance Policies");

			// VALIDATE FOR PROPERTY ONE
			title("VALIDATE FOR PROPERTY ONE");

			// validate the Insurance Policies title
			switchVerification("riskmanagementdashboard_insurancepoliciestitle_XPATH", "Insurance Policies",
					"The Insurance Policies title is not displayed.");

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
				// scroll down till Insurance Policy card
				scrollTillElement("riskmanagementdashboard_insurancepoliciescard_XPATH");

				// validate the Insurance Policy card
				boolean insurancePolicyCard = driver
						.findElement(By.xpath(OR.getProperty("riskmanagementdashboard_insurancepoliciescard_XPATH")))
						.isDisplayed();

				if (insurancePolicyCard == true) {
					successMessage("The Insurance Policy card is displayed correctly.");
				} else {
					verificationFailedMessage("The Insurance Policy card is not displayed correctly.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The Insurance Policy card is not displayed correctly.");
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
				// scroll down till Insurance Policy card
				scrollTillElement("riskmanagementdashboard_insurancepoliciescard_XPATH");

				// validate the Insurance Policy card
				boolean insurancePolicyCard = driver
						.findElement(By.xpath(OR.getProperty("riskmanagementdashboard_insurancepoliciescard_XPATH")))
						.isDisplayed();

				if (insurancePolicyCard == true) {
					successMessage("The Insurance Policy card is displayed correctly.");
				} else {
					verificationFailedMessage("The Insurance Policy card is not displayed correctly.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The Insurance Policy card is not displayed correctly.");
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
				// scroll down till Insurance Policy card
				scrollTillElement("riskmanagementdashboard_insurancepoliciescard_XPATH");

				// validate the Insurance Policy card
				boolean insurancePolicyCard = driver
						.findElement(By.xpath(OR.getProperty("riskmanagementdashboard_insurancepoliciescard_XPATH")))
						.isDisplayed();

				if (insurancePolicyCard == true) {
					successMessage("The Insurance Policy card is displayed correctly.");
				} else {
					verificationFailedMessage("The Insurance Policy card is not displayed correctly.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The Insurance Policy card is not displayed correctly.");
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
		// THE COVERAGE SUMMARY DASHBOARD SCREEN
		title("VALIDATE THE NAVIGATION AFTER SWITCHING THE PROPERTY FROM THE HEADER OF THE COVERAGE SUMMARY DASHBOARD SCREEN");

		try {

			// wait for the element
			Thread.sleep(5000);

			// click on the side menu
			click("menubtn_CSS");

			// wait for the element
			Thread.sleep(5000);

			// click on the risk management side menu
			click("sidemenu_riskmanagement_XPATH");

			// select the option from the dashboard dropdown
			select("dashboard_CSS", "Coverage Summary");

			// VALIDATE FOR PROPERTY ONE
			title("VALIDATE FOR PROPERTY ONE");

			// validate the Insurance Coverage Summary title
			switchVerification("riskmanagementdashboard_coveragesummarytitle_XPATH", "Insurance Coverage Summary",
					"The Insurance Coverage Summary title is not displayed.");

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
				// scroll down till Insurance Policy card
				scrollTillElement("riskmanagementdashboard_insurancepoliciescard_XPATH");

				// validate the Insurance Policy card
				boolean insurancePolicyCard = driver
						.findElement(By.xpath(OR.getProperty("riskmanagementdashboard_insurancepoliciescard_XPATH")))
						.isDisplayed();

				if (insurancePolicyCard == true) {
					successMessage("The Insurance Policy card is displayed correctly.");
				} else {
					verificationFailedMessage("The Insurance Policy card is not displayed correctly.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The Insurance Policy card is not displayed correctly.");
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
				// scroll down till Insurance Policy card
				scrollTillElement("riskmanagementdashboard_insurancepoliciescard_XPATH");

				// validate the Insurance Policy card
				boolean insurancePolicyCard = driver
						.findElement(By.xpath(OR.getProperty("riskmanagementdashboard_insurancepoliciescard_XPATH")))
						.isDisplayed();

				if (insurancePolicyCard == true) {
					successMessage("The Insurance Policy card is displayed correctly.");
				} else {
					verificationFailedMessage("The Insurance Policy card is not displayed correctly.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The Insurance Policy card is not displayed correctly.");
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
				// scroll down till Insurance Policy card
				scrollTillElement("riskmanagementdashboard_insurancepoliciescard_XPATH");

				// validate the Insurance Policy card
				boolean insurancePolicyCard = driver
						.findElement(By.xpath(OR.getProperty("riskmanagementdashboard_insurancepoliciescard_XPATH")))
						.isDisplayed();

				if (insurancePolicyCard == true) {
					successMessage("The Insurance Policy card is displayed correctly.");
				} else {
					verificationFailedMessage("The Insurance Policy card is not displayed correctly.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The Insurance Policy card is not displayed correctly.");
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
		// THE POLICIES SUMMARY DASHBOARD SCREEN
		title("VALIDATE THE NAVIGATION AFTER SWITCHING THE PROPERTY FROM THE HEADER OF THE POLICIES SUMMARY DASHBOARD SCREEN");

		try {

			// wait for the element
			Thread.sleep(5000);

			// click on the side menu
			click("menubtn_CSS");

			// wait for the element
			Thread.sleep(5000);

			// click on the risk management side menu
			click("sidemenu_riskmanagement_XPATH");

			// select the option from the dashboard dropdown
			select("dashboard_CSS", "Policies Summary");

			// VALIDATE FOR PROPERTY ONE
			title("VALIDATE FOR PROPERTY ONE");

			// validate the Policy Type label
			switchVerification("riskmanagementdashboard_policiessummarytitle_XPATH", "Policy Type:",
					"The Policy Type label is not displayed.");

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
				// scroll down till Insurance Policy card
				scrollTillElement("riskmanagementdashboard_insurancepoliciescard_XPATH");

				// validate the Insurance Policy card
				boolean insurancePolicyCard = driver
						.findElement(By.xpath(OR.getProperty("riskmanagementdashboard_insurancepoliciescard_XPATH")))
						.isDisplayed();

				if (insurancePolicyCard == true) {
					successMessage("The Insurance Policy card is displayed correctly.");
				} else {
					verificationFailedMessage("The Insurance Policy card is not displayed correctly.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The Insurance Policy card is not displayed correctly.");
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
				// scroll down till Insurance Policy card
				scrollTillElement("riskmanagementdashboard_insurancepoliciescard_XPATH");

				// validate the Insurance Policy card
				boolean insurancePolicyCard = driver
						.findElement(By.xpath(OR.getProperty("riskmanagementdashboard_insurancepoliciescard_XPATH")))
						.isDisplayed();

				if (insurancePolicyCard == true) {
					successMessage("The Insurance Policy card is displayed correctly.");
				} else {
					verificationFailedMessage("The Insurance Policy card is not displayed correctly.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The Insurance Policy card is not displayed correctly.");
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
				// scroll down till Insurance Policy card
				scrollTillElement("riskmanagementdashboard_insurancepoliciescard_XPATH");

				// validate the Insurance Policy card
				boolean insurancePolicyCard = driver
						.findElement(By.xpath(OR.getProperty("riskmanagementdashboard_insurancepoliciescard_XPATH")))
						.isDisplayed();

				if (insurancePolicyCard == true) {
					successMessage("The Insurance Policy card is displayed correctly.");
				} else {
					verificationFailedMessage("The Insurance Policy card is not displayed correctly.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The Insurance Policy card is not displayed correctly.");
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
		// THE CLAIMS SUMMARY DASHBOARD SCREEN
		title("VALIDATE THE NAVIGATION AFTER SWITCHING THE PROPERTY FROM THE HEADER OF THE CLAIMS SUMMARY DASHBOARD SCREEN");

		try {

			// wait for the element
			Thread.sleep(5000);

			// click on the side menu
			click("menubtn_CSS");

			// wait for the element
			Thread.sleep(5000);

			// click on the risk management side menu
			click("sidemenu_riskmanagement_XPATH");

			// select the option from the dashboard dropdown
			select("dashboard_CSS", "Claims Summary");

			// VALIDATE FOR PROPERTY ONE
			title("VALIDATE FOR PROPERTY ONE");

			// validate the Claim Type label
			switchVerification("riskmanagementdashboard_cliamssummarytitle_XPATH", "Claim Type:",
					"The Claim Type label is not displayed.");

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
				// scroll down till Insurance Policy card
				scrollTillElement("riskmanagementdashboard_insurancepoliciescard_XPATH");

				// validate the Insurance Policy card
				boolean insurancePolicyCard = driver
						.findElement(By.xpath(OR.getProperty("riskmanagementdashboard_insurancepoliciescard_XPATH")))
						.isDisplayed();

				if (insurancePolicyCard == true) {
					successMessage("The Insurance Policy card is displayed correctly.");
				} else {
					verificationFailedMessage("The Insurance Policy card is not displayed correctly.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The Insurance Policy card is not displayed correctly.");
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
				// scroll down till Insurance Policy card
				scrollTillElement("riskmanagementdashboard_insurancepoliciescard_XPATH");

				// validate the Insurance Policy card
				boolean insurancePolicyCard = driver
						.findElement(By.xpath(OR.getProperty("riskmanagementdashboard_insurancepoliciescard_XPATH")))
						.isDisplayed();

				if (insurancePolicyCard == true) {
					successMessage("The Insurance Policy card is displayed correctly.");
				} else {
					verificationFailedMessage("The Insurance Policy card is not displayed correctly.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The Insurance Policy card is not displayed correctly.");
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
				// scroll down till Insurance Policy card
				scrollTillElement("riskmanagementdashboard_insurancepoliciescard_XPATH");

				// validate the Insurance Policy card
				boolean insurancePolicyCard = driver
						.findElement(By.xpath(OR.getProperty("riskmanagementdashboard_insurancepoliciescard_XPATH")))
						.isDisplayed();

				if (insurancePolicyCard == true) {
					successMessage("The Insurance Policy card is displayed correctly.");
				} else {
					verificationFailedMessage("The Insurance Policy card is not displayed correctly.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The Insurance Policy card is not displayed correctly.");
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
		// THE RECOMMENDATIONS DASHBOARD SCREEN
		title("VALIDATE THE NAVIGATION AFTER SWITCHING THE PROPERTY FROM THE HEADER OF THE RECOMMENDATIONS DASHBOARD SCREEN");

		try {

			// wait for the element
			Thread.sleep(5000);

			// click on the side menu
			click("menubtn_CSS");

			// wait for the element
			Thread.sleep(5000);

			// click on the risk management side menu
			click("sidemenu_riskmanagement_XPATH");

			// select the option from the dashboard dropdown
			select("dashboard_CSS", "Recommendations");

			// VALIDATE FOR PROPERTY ONE
			title("VALIDATE FOR PROPERTY ONE");

			// validate the Recommendations title
			switchVerification("riskmanagementdashboard_recommendationstitle_XPATH", "Recommendations",
					"The Recommendations title is not displayed.");

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
				// scroll down till Insurance Policy card
				scrollTillElement("riskmanagementdashboard_insurancepoliciescard_XPATH");

				// validate the Insurance Policy card
				boolean insurancePolicyCard = driver
						.findElement(By.xpath(OR.getProperty("riskmanagementdashboard_insurancepoliciescard_XPATH")))
						.isDisplayed();

				if (insurancePolicyCard == true) {
					successMessage("The Insurance Policy card is displayed correctly.");
				} else {
					verificationFailedMessage("The Insurance Policy card is not displayed correctly.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The Insurance Policy card is not displayed correctly.");
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
				// scroll down till Insurance Policy card
				scrollTillElement("riskmanagementdashboard_insurancepoliciescard_XPATH");

				// validate the Insurance Policy card
				boolean insurancePolicyCard = driver
						.findElement(By.xpath(OR.getProperty("riskmanagementdashboard_insurancepoliciescard_XPATH")))
						.isDisplayed();

				if (insurancePolicyCard == true) {
					successMessage("The Insurance Policy card is displayed correctly.");
				} else {
					verificationFailedMessage("The Insurance Policy card is not displayed correctly.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The Insurance Policy card is not displayed correctly.");
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
				// scroll down till Insurance Policy card
				scrollTillElement("riskmanagementdashboard_insurancepoliciescard_XPATH");

				// validate the Insurance Policy card
				boolean insurancePolicyCard = driver
						.findElement(By.xpath(OR.getProperty("riskmanagementdashboard_insurancepoliciescard_XPATH")))
						.isDisplayed();

				if (insurancePolicyCard == true) {
					successMessage("The Insurance Policy card is displayed correctly.");
				} else {
					verificationFailedMessage("The Insurance Policy card is not displayed correctly.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The Insurance Policy card is not displayed correctly.");
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
		// THE INSURANCE CLAIMS DASHBOARD SCREEN
		title("VALIDATE THE NAVIGATION AFTER SWITCHING THE PROPERTY FROM THE HEADER OF THE INSURANCE CLAIMS DASHBOARD SCREEN");

		try {

			// wait for the element
			Thread.sleep(5000);

			// click on the side menu
			click("menubtn_CSS");

			// wait for the element
			Thread.sleep(5000);

			// click on the risk management side menu
			click("sidemenu_riskmanagement_XPATH");

			// select the option from the dashboard dropdown
			select("dashboard_CSS", "Insurance Claims");

			// VALIDATE FOR PROPERTY ONE
			title("VALIDATE FOR PROPERTY ONE");

			// validate the Insurance Claims title
			switchVerification("riskmanagementdashboard_insuranceclaimstitle_XPATH", "Insurance Claims",
					"The Insurance Claims title is not displayed.");

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
				// scroll down till Insurance Policy card
				scrollTillElement("riskmanagementdashboard_insurancepoliciescard_XPATH");

				// validate the Insurance Policy card
				boolean insurancePolicyCard = driver
						.findElement(By.xpath(OR.getProperty("riskmanagementdashboard_insurancepoliciescard_XPATH")))
						.isDisplayed();

				if (insurancePolicyCard == true) {
					successMessage("The Insurance Policy card is displayed correctly.");
				} else {
					verificationFailedMessage("The Insurance Policy card is not displayed correctly.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The Insurance Policy card is not displayed correctly.");
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
				// scroll down till Insurance Policy card
				scrollTillElement("riskmanagementdashboard_insurancepoliciescard_XPATH");

				// validate the Insurance Policy card
				boolean insurancePolicyCard = driver
						.findElement(By.xpath(OR.getProperty("riskmanagementdashboard_insurancepoliciescard_XPATH")))
						.isDisplayed();

				if (insurancePolicyCard == true) {
					successMessage("The Insurance Policy card is displayed correctly.");
				} else {
					verificationFailedMessage("The Insurance Policy card is not displayed correctly.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The Insurance Policy card is not displayed correctly.");
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
				// scroll down till Insurance Policy card
				scrollTillElement("riskmanagementdashboard_insurancepoliciescard_XPATH");

				// validate the Insurance Policy card
				boolean insurancePolicyCard = driver
						.findElement(By.xpath(OR.getProperty("riskmanagementdashboard_insurancepoliciescard_XPATH")))
						.isDisplayed();

				if (insurancePolicyCard == true) {
					successMessage("The Insurance Policy card is displayed correctly.");
				} else {
					verificationFailedMessage("The Insurance Policy card is not displayed correctly.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The Insurance Policy card is not displayed correctly.");
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
