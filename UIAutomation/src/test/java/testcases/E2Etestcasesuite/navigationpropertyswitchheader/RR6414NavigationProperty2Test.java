package testcases.E2Etestcasesuite.navigationpropertyswitchheader;

import java.io.IOException;
import java.util.Hashtable;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

import base.TestBase;
import utilities.TestUtil;

public class RR6414NavigationProperty2Test extends TestBase {

	@Test(dataProviderClass = TestUtil.class, dataProvider = "dp")
	public void rR6414NavigationProperty2Test(Hashtable<String, String> data) throws InterruptedException, IOException {

		execution(data, "rR6414NavigationProperty2Test");

		// PROPERTY PROJECT MODULE - NAVIGATION SCENARIO OF THE
		title("PROPERTY PROJECT MODULE - NAVIGATION SCENARIO OF ");

		// refresh the page
		driver.navigate().refresh();
		Thread.sleep(5000);
		driver.navigate().refresh();

		// ADD MORTGAGE UNDERTAKINGS RECORD
		title("ADD MORTGAGE UNDERTAKINGS RECORD");

		String title1 = RandomStringUtils.randomAlphabetic(8);

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

			// click on the add button
			click("propertyproject_mu_addbtn_CSS");

			// enter the undertaking number
			type("propertyproject_mu_undertakingnumbertxt_CSS", title1);

			// select the lender
			select("propertyproject_mu_lenderdd_CSS", "CMHC");

			// click on the save button
			click("propertyproject_mu_savebtn_CSS");

		} catch (Throwable t) {
			verificationFailed();
		}

		// click on the home icon from the top of the screen
		click("questionnaire_homeburgermenubtn_hide_CSS");

		// wait for the element
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// ADD CAPEX PROJECTS RECORD
		title("ADD CAPEX PROJECTS RECORD");

		String title2 = RandomStringUtils.randomAlphabetic(8);

		try {
			// click on the property project icon from the property list page
			click("propertyproject_icon_CSS");

			// wait for the element
			explicitWaitClickable("menubtn_CSS");

			// click on the burger menu
			click("menubtn_CSS");

			// wait for the element
			Thread.sleep(5000);

			// click on the CAPEX Project
			click("propertyproject_capexprojectsoption_XPATH");

			// click on the add button
			click("propertyproject_mu_addbtn_CSS");

			// enter the project number
			type("propertyproject_cp_projectnumbertxt_CSS", title2);

			// select the engineering company
			select("propertyproject_cp_engineeringcompanydd_CSS", "MacIntosh Perry");

			// click on the save button
			click("propertyproject_cp_savebtn_CSS");

		} catch (Throwable t) {
			verificationFailed();
		}

		// click on the home icon from the top of the screen
		click("questionnaire_homeburgermenubtn_hide_CSS");

		// wait for the element
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// ADD MUNICIPAL ORDERS RECORD
		title("ADD MUNICIPAL ORDERS RECORD");

		String title3 = RandomStringUtils.randomAlphabetic(8);

		try {
			// click on the property project icon from the property list page
			click("propertyproject_icon_CSS");

			// wait for the element
			Thread.sleep(5000);

			// click on the burger menu
			click("menubtn_CSS");

			// wait for the element
			Thread.sleep(5000);

			// click on the Municipal Orders
			click("propertyproject_municipalordersoption_XPATH");

			// click on the add button
			click("propertyproject_mu_addbtn_CSS");

			// enter the project reference
			type("propertyproject_mo_projectnumbertxt_CSS", title3);

			// select the Municipality
			select("propertyproject_mo_municipalitydd_CSS", "City of Toronto");

			// click on the save button
			click("propertyproject_mo_savebtn_CSS");

		} catch (Throwable t) {
			verificationFailed();
		}

		// click on the home icon from the top of the screen
		click("questionnaire_homeburgermenubtn_hide_CSS");

		// wait for the element
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// ADD LENDERS RECORD
		title("ADD LENDERS RECORD");

		String title4 = RandomStringUtils.randomAlphabetic(8);

		try {
			// click on the property project icon from the property list page
			click("propertyproject_icon_CSS");

			// wait for the element
			explicitWaitClickable("menubtn_CSS");

			// click on the burger menu
			click("menubtn_CSS");

			// wait for the element
			Thread.sleep(5000);

			// click on the LENDERS
			click("propertyproject_lendersoption_XPATH");

			// click on the add button
			click("propertyproject_le_addlendersbtn_CSS");

			// enter the lender name
			type("propertyproject_le_lendersnametxt_CSS", title4);

			// click on the save button
			click("propertyproject_le_savebtn_CSS");

			// wait for the element
			explicitWait("propertyproject_le_filtertxt_CSS");

			// enter the lender name
			type("propertyproject_co_filtertxt_CSS", title4);

			// verification of the lender is added or not
			try {
				String record = "//td[text()='" + title4 + "']";
				String record_actual = (driver.findElement(By.xpath(record)).getText()).trim();

				if (record_actual.equals(title4)) {
					successMessage("The " + title4 + " is verified successfully.");

				} else {
					verificationFailedMessage("The " + title4 + " is not verified.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The " + title4 + " is not verified.");
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

		// ADD CONTRACTOR RECORD
		title("ADD CONTRACTOR RECORD");

		String title5 = RandomStringUtils.randomAlphabetic(8);

		try {

			// wait for the element
			explicitWaitClickable("propertyproject_icon_CSS");

			// click on the property project icon from the property list page
			click("propertyproject_icon_CSS");

			// wait for the element
			explicitWaitClickable("menubtn_CSS");

			// click on the burger menu
			click("menubtn_CSS");

			// wait for the element
			Thread.sleep(5000);

			// click on the CONTRACTOR
			click("propertyproject_contractorsoption_XPATH");

			// click on the add button
			click("propertyproject_co_addcontractorsbtn_CSS");

			// enter the contractor name
			type("propertyproject_co_contractornametxt_CSS", title5);

			// click on the save button
			click("propertyproject_co_savebtn_CSS");

			// wait for the element
			explicitWait("propertyproject_co_filtertxt_CSS");

			// enter the contractor name
			type("propertyproject_co_filtertxt_CSS", title5);

			// verification of the contractor is added or not
			try {
				String record = "//td[text()='" + title5 + "']";
				String record_actual = (driver.findElement(By.xpath(record)).getText()).trim();

				if (record_actual.equals(title5)) {
					successMessage("The " + title5 + " is verified successfully.");

				} else {
					verificationFailedMessage("The " + title5 + " is not verified.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The " + title5 + " is not verified.");
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

		// ADD ENGINEERING COMPANIES RECORD
		title("ADD ENGINEERING COMPANIES RECORD");

		String title6 = RandomStringUtils.randomAlphabetic(8);

		try {
			// click on the property project icon from the property list page
			click("propertyproject_icon_CSS");

			// wait for the element
			explicitWaitClickable("menubtn_CSS");

			// click on the burger menu
			click("menubtn_CSS");

			// wait for the element
			Thread.sleep(5000);

			// click on the ENGINEERING COMPANIES
			click("propertyproject_engineeringcompaniesoption_XPATH");

			// click on the add button
			click("propertyproject_ec_addengineeringcompaniesbtn_CSS");

			/// enter the company name
			type("propertyproject_ec_companynametxt_CSS", title6);

			// click on the save button
			click("propertyproject_ec_savebtn_CSS");

			// wait for the element
			explicitWait("propertyproject_ec_filtertxt_CSS");

			// enter the company name
			type("propertyproject_ec_filtertxt_CSS", title6);

			// verification of the is added or not
			try {
				String record = "//td[text()='" + title6 + "']";
				String record_actual = (driver.findElement(By.xpath(record)).getText()).trim();

				if (record_actual.equals(title6)) {
					successMessage("The " + title6 + " is verified successfully.");

				} else {
					verificationFailedMessage("The " + title6 + " is not verified.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The " + title6 + " is not verified.");
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

		// ADD MUNICIPALITY RECORD
		title("ADD MUNICIPALITY RECORD");

		String title7 = RandomStringUtils.randomAlphabetic(8);

		try {
			// click on the property project icon from the property list page
			click("propertyproject_icon_CSS");

			// wait for the element
			explicitWaitClickable("menubtn_CSS");

			// click on the burger menu
			click("menubtn_CSS");

			// wait for the element
			Thread.sleep(5000);

			// click on the municipality
			click("propertyproject_municipalityoption_XPATH");

			// click on the add button
			click("propertyproject_mn_addmunicipalitybtn_CSS");

			/// enter the municipality name
			type("propertyproject_mn_municipalitynametxt_CSS", title7);

			// click on the save button
			click("propertyproject_mn_savebtn_CSS");

			// wait for the element
			explicitWait("propertyproject_mn_filtertxt_CSS");

			// enter the municipality name
			type("propertyproject_mn_filtertxt_CSS", title7);

			// verification of the is added or not
			switchVerification("propertyproject_mn_addedmunicipality_XPATH", "Municipality Testing Name",
					"The Municipality Testing Name is not displayed successfully.");

			// verification of the is added or not
			try {
				String record = "//td[contains(text(),'" + title7 + "')]";
				String record_actual = (driver.findElement(By.xpath(record)).getText()).trim();

				if (record_actual.equals(title7)) {
					successMessage("The " + title7 + " is verified successfully.");

				} else {
					verificationFailedMessage("The " + title7 + " is not verified.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The " + title7 + " is not verified.");
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
		// THE MORTGAGE UNDERTAKINGS SCREENS
		title("VALIDATE THE NAVIGATION AFTER SWITCHING THE PROPERTY FROM THE HEADER OF THE MORTGAGE UNDERTAKINGS SCREENS");

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

			// click on the newly created mortgage undertakings record
			String record = "//td[text()='" + title1 + "']";
			driver.findElement(By.xpath(record)).click();
			consoleMessage("Clicked on the newly created mortgage undertakings record.");

			// VALIDATE FOR PROPERTY ONE
			title("VALIDATE FOR PROPERTY ONE");

			// validate the property name
			switchVerification("navigation_header_propertyname1_XPATH", "[DND] AAAA Risk Test Prop 01 - 01",
					"The property name is not displayed.");

			// validate the title of the Mortgage Undertakings record is displayed or not
			try {

				String title_actual = driver
						.findElement(By.cssSelector(OR.getProperty("propertyproject_mu_undertakingnumbertxt_CSS")))
						.getAttribute("value");

				if (title_actual.equals(title1)) {
					successMessage("The title of the Mortgage Undertakings is display successfully.");

				} else {
					verificationFailedMessage("The title of the Mortgage Undertakings is not display.");

				}
			} catch (Throwable t) {
				verificationFailedMessage("The title of the Mortgage Undertakings is not display.");
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

			// validate the title of the Mortgage Undertakings record is displayed or not
			try {

				String title_actual = driver
						.findElement(By.cssSelector(OR.getProperty("propertyproject_mu_undertakingnumbertxt_CSS")))
						.getAttribute("value");

				if (title_actual.equals(title1)) {
					verificationFailedMessage("The title of the Mortgage Undertakings is display.");

				} else {
					successMessage("The title of the Mortgage Undertakings is not display as expected.");

				}
			} catch (Throwable t) {
				successMessage("The title of the Mortgage Undertakings is not display as expected.");
			}

			// validate the title of the Mortgage Undertakings in the listing screen is
			// displayed or not
			try {
				String titlelist = "//td[text()='" + title1 + "']";
				boolean titlelist_actual = driver.findElement(By.xpath(titlelist)).isDisplayed();

				if (titlelist_actual == true) {
					verificationFailedMessage("The newly created Mortgage Undertakings is display.");

				} else {
					successMessage("The newly created Mortgage Undertakings is not display successfully.");

				}
			} catch (Throwable t) {
				successMessage("The newly created Mortgage Undertakings is not display successfully.");
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

			// validate the title of the Mortgage Undertakings record is displayed or not
			try {

				String title_actual = driver
						.findElement(By.cssSelector(OR.getProperty("propertyproject_mu_undertakingnumbertxt_CSS")))
						.getAttribute("value");

				if (title_actual.equals(title1)) {
					verificationFailedMessage("The title of the Mortgage Undertakings is display.");

				} else {
					successMessage("The title of the Mortgage Undertakings is not display as expected.");

				}
			} catch (Throwable t) {
				successMessage("The title of the Mortgage Undertakings is not display as expected.");
			}

			// validate the title of the Mortgage Undertakings in the listing screen is
			// displayed or not
			try {
				String titlelist = "//td[text()='" + title1 + "']";
				boolean titlelist_actual = driver.findElement(By.xpath(titlelist)).isDisplayed();

				if (titlelist_actual == true) {
					verificationFailedMessage("The newly created Mortgage Undertakings is display.");

				} else {
					successMessage("The newly created Mortgage Undertakings is not display successfully.");

				}
			} catch (Throwable t) {
				successMessage("The newly created Mortgage Undertakings is not display successfully.");
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

			// validate the title of the Mortgage Undertakings record is displayed or not
			try {

				String title_actual = driver
						.findElement(By.cssSelector(OR.getProperty("propertyproject_mu_undertakingnumbertxt_CSS")))
						.getAttribute("value");

				if (title_actual.equals(title1)) {
					verificationFailedMessage("The title of the Mortgage Undertakings is display.");

				} else {
					successMessage("The title of the Mortgage Undertakings is not display as expected.");

				}
			} catch (Throwable t) {
				successMessage("The title of the Mortgage Undertakings is not display as expected.");
			}

			// validate the title of the Mortgage Undertakings in the listing screen is
			// displayed or not
			try {
				String titlelist = "//td[text()='" + title1 + "']";
				boolean titlelist_actual = driver.findElement(By.xpath(titlelist)).isDisplayed();

				if (titlelist_actual == true) {
					successMessage("The newly created Mortgage Undertakings is display successfully.");

				} else {
					verificationFailedMessage("The newly created Mortgage Undertakings is not display.");

				}
			} catch (Throwable t) {
				verificationFailedMessage("The newly created Mortgage Undertakings is not display.");
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
		// THE CAPEX PROJECTS SCREENS
		title("VALIDATE THE NAVIGATION AFTER SWITCHING THE PROPERTY FROM THE HEADER OF THE CAPEX PROJECTS SCREENS");

		try {
			// click on the property project icon from the property list page
			click("propertyproject_icon_CSS");

			// wait for the element
			explicitWaitClickable("menubtn_CSS");

			// click on the burger menu
			click("menubtn_CSS");

			// wait for the element
			Thread.sleep(5000);

			// click on the capex projects
			click("propertyproject_capexprojectsoption_XPATH");

			// click on the newly created capex projects record
			String record = "//td[text()='" + title2 + "']";
			driver.findElement(By.xpath(record)).click();
			consoleMessage("Clicked on the newly created capex projects record.");

			// VALIDATE FOR PROPERTY ONE
			title("VALIDATE FOR PROPERTY ONE");

			// validate the property name
			switchVerification("navigation_header_propertyname1_XPATH", "[DND] AAAA Risk Test Prop 01 - 01",
					"The property name is not displayed.");

			// validate the title of the capex projects record is displayed or not
			try {

				String title_actual = driver
						.findElement(By.cssSelector(OR.getProperty("propertyproject_cp_projectnumbertxt_CSS")))
						.getAttribute("value");

				if (title_actual.equals(title2)) {
					successMessage("The title of the capex projects is display successfully.");

				} else {
					verificationFailedMessage("The title of the capex projects is not display.");

				}
			} catch (Throwable t) {
				verificationFailedMessage("The title of the capex projects is not display.");
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

			// validate the title of the capex projects record is displayed or not
			try {

				String title_actual = driver
						.findElement(By.cssSelector(OR.getProperty("propertyproject_cp_projectnumbertxt_CSS")))
						.getAttribute("value");

				if (title_actual.equals(title2)) {
					verificationFailedMessage("The title of the capex projects is display.");

				} else {
					successMessage("The title of the capex projects is not display as expected.");

				}
			} catch (Throwable t) {
				successMessage("The title of the capex projects is not display as expected.");
			}

			// validate the title of the capex projects in the listing screen is
			// displayed or not
			try {
				String titlelist = "//td[text()='" + title2 + "']";
				boolean titlelist_actual = driver.findElement(By.xpath(titlelist)).isDisplayed();

				if (titlelist_actual == true) {
					verificationFailedMessage("The newly created capex projects is display.");

				} else {
					successMessage("The newly created capex projects is not display successfully.");

				}
			} catch (Throwable t) {
				successMessage("The newly created capex projects is not display successfully.");
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

			// validate the title of the capex projects record is displayed or not
			try {

				String title_actual = driver
						.findElement(By.cssSelector(OR.getProperty("propertyproject_cp_projectnumbertxt_CSS")))
						.getAttribute("value");

				if (title_actual.equals(title2)) {
					verificationFailedMessage("The title of the capex projects is display.");

				} else {
					successMessage("The title of the capex projects is not display as expected.");

				}
			} catch (Throwable t) {
				successMessage("The title of the capex projects is not display as expected.");
			}

			// validate the title of the capex projects in the listing screen is
			// displayed or not
			try {
				String titlelist = "//td[text()='" + title2 + "']";
				boolean titlelist_actual = driver.findElement(By.xpath(titlelist)).isDisplayed();

				if (titlelist_actual == true) {
					verificationFailedMessage("The newly created capex projects is display.");

				} else {
					successMessage("The newly created capex projects is not display successfully.");

				}
			} catch (Throwable t) {
				successMessage("The newly created capex projects is not display successfully.");
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

			// validate the title of the capex projects record is displayed or not
			try {

				String title_actual = driver
						.findElement(By.cssSelector(OR.getProperty("propertyproject_cp_projectnumbertxt_CSS")))
						.getAttribute("value");

				if (title_actual.equals(title2)) {
					verificationFailedMessage("The title of the capex projects is display.");

				} else {
					successMessage("The title of the capex projects is not display as expected.");

				}
			} catch (Throwable t) {
				successMessage("The title of the capex projects is not display as expected.");
			}

			// validate the title of the capex projects in the listing screen is
			// displayed or not
			try {
				String titlelist = "//td[text()='" + title2 + "']";
				boolean titlelist_actual = driver.findElement(By.xpath(titlelist)).isDisplayed();

				if (titlelist_actual == true) {
					successMessage("The newly created capex projects is display successfully.");

				} else {
					verificationFailedMessage("The newly created capex projects is not display.");

				}
			} catch (Throwable t) {
				verificationFailedMessage("The newly created capex projects is not display.");
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
		// THE MUNICIPAL ORDERS SCREENS
		title("VALIDATE THE NAVIGATION AFTER SWITCHING THE PROPERTY FROM THE HEADER OF THE MUNICIPAL ORDERS SCREENS");

		try {
			// click on the property project icon from the property list page
			click("propertyproject_icon_CSS");

			// wait for the element
			explicitWaitClickable("menubtn_CSS");

			// click on the burger menu
			click("menubtn_CSS");

			// wait for the element
			Thread.sleep(5000);

			// click on the municipal orders
			click("propertyproject_municipalordersoption_XPATH");

			// click on the newly created municipal orders record
			String record = "//td[text()='" + title3 + "']";
			driver.findElement(By.xpath(record)).click();
			consoleMessage("Clicked on the newly created municipal orders record.");

			// VALIDATE FOR PROPERTY ONE
			title("VALIDATE FOR PROPERTY ONE");

			// validate the property name
			switchVerification("navigation_header_propertyname1_XPATH", "[DND] AAAA Risk Test Prop 01 - 01",
					"The property name is not displayed.");

			// validate the title of the municipal orders record is displayed or not
			try {

				String title_actual = driver
						.findElement(By.cssSelector(OR.getProperty("propertyproject_mo_projectnumbertxt_CSS")))
						.getAttribute("value");

				if (title_actual.equals(title3)) {
					successMessage("The title of the municipal orders is display successfully.");

				} else {
					verificationFailedMessage("The title of the municipal orders is not display.");

				}
			} catch (Throwable t) {
				verificationFailedMessage("The title of the municipal orders is not display.");
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

			// validate the title of the municipal orders record is displayed or not
			try {

				String title_actual = driver
						.findElement(By.cssSelector(OR.getProperty("propertyproject_mo_projectnumbertxt_CSS")))
						.getAttribute("value");

				if (title_actual.equals(title3)) {
					verificationFailedMessage("The title of the municipal orders is display.");

				} else {
					successMessage("The title of the municipal orders is not display as expected.");

				}
			} catch (Throwable t) {
				successMessage("The title of the municipal orders is not display as expected.");
			}

			// validate the title of the municipal orders in the listing screen is
			// displayed or not
			try {
				String titlelist = "//td[text()='" + title3 + "']";
				boolean titlelist_actual = driver.findElement(By.xpath(titlelist)).isDisplayed();

				if (titlelist_actual == true) {
					verificationFailedMessage("The newly created municipal orders is display.");

				} else {
					successMessage("The newly created municipal orders is not display successfully.");

				}
			} catch (Throwable t) {
				successMessage("The newly created municipal orders is not display successfully.");
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

			// validate the title of the municipal orders record is displayed or not
			try {

				String title_actual = driver
						.findElement(By.cssSelector(OR.getProperty("propertyproject_mo_projectnumbertxt_CSS")))
						.getAttribute("value");

				if (title_actual.equals(title3)) {
					verificationFailedMessage("The title of the municipal orders is display.");

				} else {
					successMessage("The title of the municipal orders is not display as expected.");

				}
			} catch (Throwable t) {
				successMessage("The title of the municipal orders is not display as expected.");
			}

			// validate the title of the municipal orders in the listing screen is
			// displayed or not
			try {
				String titlelist = "//td[text()='" + title3 + "']";
				boolean titlelist_actual = driver.findElement(By.xpath(titlelist)).isDisplayed();

				if (titlelist_actual == true) {
					verificationFailedMessage("The newly created municipal orders is display.");

				} else {
					successMessage("The newly created municipal orders is not display successfully.");

				}
			} catch (Throwable t) {
				successMessage("The newly created municipal orders is not display successfully.");
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

			// validate the title of the municipal orders record is displayed or not
			try {

				String title_actual = driver
						.findElement(By.cssSelector(OR.getProperty("propertyproject_mo_projectnumbertxt_CSS")))
						.getAttribute("value");

				if (title_actual.equals(title3)) {
					verificationFailedMessage("The title of the municipal orders is display.");

				} else {
					successMessage("The title of the municipal orders is not display as expected.");

				}
			} catch (Throwable t) {
				successMessage("The title of the municipal orders is not display as expected.");
			}

			// validate the title of the municipal orders in the listing screen is
			// displayed or not
			try {
				String titlelist = "//td[text()='" + title3 + "']";
				boolean titlelist_actual = driver.findElement(By.xpath(titlelist)).isDisplayed();

				if (titlelist_actual == true) {
					successMessage("The newly created municipal orders is display successfully.");

				} else {
					verificationFailedMessage("The newly created municipal orders is not display.");

				}
			} catch (Throwable t) {
				verificationFailedMessage("The newly created municipal orders is not display.");
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
		// THE LENDERS SCREENS
		title("VALIDATE THE NAVIGATION AFTER SWITCHING THE PROPERTY FROM THE HEADER OF THE LENDERS SCREENS");

		try {
			// click on the property project icon from the property list page
			click("propertyproject_icon_CSS");

			// wait for the element
			explicitWaitClickable("menubtn_CSS");

			// click on the burger menu
			click("menubtn_CSS");

			// wait for the element
			Thread.sleep(5000);

			// click on the lenders
			click("propertyproject_lendersoption_XPATH");

			// click on the newly created lenders record
			String record = "//td[text()='" + title4 + "']";
			driver.findElement(By.xpath(record)).click();
			consoleMessage("Clicked on the newly created lenders record.");

			// VALIDATE FOR PROPERTY ONE
			title("VALIDATE FOR PROPERTY ONE");

			// validate the property name
			switchVerification("navigation_header_propertyname1_XPATH", "[DND] AAAA Risk Test Prop 01 - 01",
					"The property name is not displayed.");

			// validate the title of the lenders record is displayed or not
			try {

				String title_actual = driver
						.findElement(By.cssSelector(OR.getProperty("propertyproject_le_lendersnametxt_CSS")))
						.getAttribute("value");

				if (title_actual.equals(title4)) {
					successMessage("The title of the lenders is display successfully.");

				} else {
					verificationFailedMessage("The title of the lenders is not display.");

				}
			} catch (Throwable t) {
				verificationFailedMessage("The title of the lenders is not display.");
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

			// validate the title of the lenders record is displayed or not
			try {

				String title_actual = driver
						.findElement(By.cssSelector(OR.getProperty("propertyproject_le_lendersnametxt_CSS")))
						.getAttribute("value");

				if (title_actual.equals(title4)) {
					verificationFailedMessage("The title of the lenders is display.");

				} else {
					successMessage("The title of the lenders is not display as expected.");

				}
			} catch (Throwable t) {
				successMessage("The title of the lenders is not display as expected.");
			}

			// validate the title of the lenders in the listing screen is
			// displayed or not
			try {
				String titlelist = "//td[text()='" + title4 + "']";
				boolean titlelist_actual = driver.findElement(By.xpath(titlelist)).isDisplayed();

				if (titlelist_actual == true) {
					verificationFailedMessage("The newly created lenders is display.");

				} else {
					successMessage("The newly created lenders is not display successfully.");

				}
			} catch (Throwable t) {
				successMessage("The newly created lenders is not display successfully.");
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

			// validate the title of the lenders record is displayed or not
			try {

				String title_actual = driver
						.findElement(By.cssSelector(OR.getProperty("propertyproject_le_lendersnametxt_CSS")))
						.getAttribute("value");

				if (title_actual.equals(title4)) {
					verificationFailedMessage("The title of the lenders is display.");

				} else {
					successMessage("The title of the lenders is not display as expected.");

				}
			} catch (Throwable t) {
				successMessage("The title of the lenders is not display as expected.");
			}

			// validate the title of the lenders in the listing screen is
			// displayed or not
			try {
				String titlelist = "//td[text()='" + title4 + "']";
				boolean titlelist_actual = driver.findElement(By.xpath(titlelist)).isDisplayed();

				if (titlelist_actual == true) {
					verificationFailedMessage("The newly created lenders is display.");

				} else {
					successMessage("The newly created lenders is not display successfully.");

				}
			} catch (Throwable t) {
				successMessage("The newly created lenders is not display successfully.");
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

			// validate the title of the lenders record is displayed or not
			try {

				String title_actual = driver
						.findElement(By.cssSelector(OR.getProperty("propertyproject_le_lendersnametxt_CSS")))
						.getAttribute("value");

				if (title_actual.equals(title4)) {
					verificationFailedMessage("The title of the lenders is display.");

				} else {
					successMessage("The title of the lenders is not display as expected.");

				}
			} catch (Throwable t) {
				successMessage("The title of the lenders is not display as expected.");
			}

			// validate the title of the lenders in the listing screen is
			// displayed or not
			try {
				String titlelist = "//td[text()='" + title4 + "']";
				boolean titlelist_actual = driver.findElement(By.xpath(titlelist)).isDisplayed();

				if (titlelist_actual == true) {
					successMessage("The newly created lenders is display successfully.");

				} else {
					verificationFailedMessage("The newly created lenders is not display.");

				}
			} catch (Throwable t) {
				verificationFailedMessage("The newly created lenders is not display.");
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
		// THE CONTRACTORS SCREENS
		title("VALIDATE THE NAVIGATION AFTER SWITCHING THE PROPERTY FROM THE HEADER OF THE CONTRACTORS SCREENS");

		try {
			// click on the property project icon from the property list page
			click("propertyproject_icon_CSS");

			// wait for the element
			explicitWaitClickable("menubtn_CSS");

			// click on the burger menu
			click("menubtn_CSS");

			// wait for the element
			Thread.sleep(5000);

			// click on the contractors
			click("propertyproject_contractorsoption_XPATH");

			// click on the newly created contractors record
			String record = "//td[text()='" + title5 + "']";
			driver.findElement(By.xpath(record)).click();
			consoleMessage("Clicked on the newly created contractors record.");

			// VALIDATE FOR PROPERTY ONE
			title("VALIDATE FOR PROPERTY ONE");

			// validate the property name
			switchVerification("navigation_header_propertyname1_XPATH", "[DND] AAAA Risk Test Prop 01 - 01",
					"The property name is not displayed.");

			// validate the title of the contractors record is displayed or not
			try {

				String title_actual = driver
						.findElement(By.cssSelector(OR.getProperty("propertyproject_co_contractornametxt_CSS")))
						.getAttribute("value");

				if (title_actual.equals(title5)) {
					successMessage("The title of the contractors is display successfully.");

				} else {
					verificationFailedMessage("The title of the contractors is not display.");

				}
			} catch (Throwable t) {
				verificationFailedMessage("The title of the contractors is not display.");
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

			// validate the title of the contractors record is displayed or not
			try {

				String title_actual = driver
						.findElement(By.cssSelector(OR.getProperty("propertyproject_co_contractornametxt_CSS")))
						.getAttribute("value");

				if (title_actual.equals(title5)) {
					successMessage("The title of the contractors is display successfully.");

				} else {
					verificationFailedMessage("The title of the contractors is not display.");

				}
			} catch (Throwable t) {
				verificationFailedMessage("The title of the contractors is not display.");
			}

			// validate the title of the contractors in the listing screen is
			// displayed or not
			try {
				String titlelist = "//td[text()='" + title5 + "']";
				boolean titlelist_actual = driver.findElement(By.xpath(titlelist)).isDisplayed();

				if (titlelist_actual == true) {
					verificationFailedMessage("The newly created contractors is display.");

				} else {
					successMessage("The newly created contractors is not display successfully.");

				}
			} catch (Throwable t) {
				successMessage("The newly created contractors is not display successfully.");
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

			// validate the title of the contractors record is displayed or not
			try {

				String title_actual = driver
						.findElement(By.cssSelector(OR.getProperty("propertyproject_co_contractornametxt_CSS")))
						.getAttribute("value");

				if (title_actual.equals(title5)) {
					successMessage("The title of the contractors is display successfully.");

				} else {
					verificationFailedMessage("The title of the contractors is not display.");

				}
			} catch (Throwable t) {
				verificationFailedMessage("The title of the contractors is not display.");
			}

			// validate the title of the contractors in the listing screen is
			// displayed or not
			try {
				String titlelist = "//td[text()='" + title5 + "']";
				boolean titlelist_actual = driver.findElement(By.xpath(titlelist)).isDisplayed();

				if (titlelist_actual == true) {
					verificationFailedMessage("The newly created contractors is display.");

				} else {
					successMessage("The newly created contractors is not display successfully.");

				}
			} catch (Throwable t) {
				successMessage("The newly created contractors is not display successfully.");
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

			// validate the title of the contractors record is displayed or not
			try {

				String title_actual = driver
						.findElement(By.cssSelector(OR.getProperty("propertyproject_co_contractornametxt_CSS")))
						.getAttribute("value");

				if (title_actual.equals(title5)) {
					successMessage("The title of the contractors is display successfully.");

				} else {
					verificationFailedMessage("The title of the contractors is not display.");

				}
			} catch (Throwable t) {
				verificationFailedMessage("The title of the contractors is not display.");
			}

			// validate the title of the contractors in the listing screen is
			// displayed or not
			try {
				String titlelist = "//td[text()='" + title5 + "']";
				boolean titlelist_actual = driver.findElement(By.xpath(titlelist)).isDisplayed();

				if (titlelist_actual == true) {
					successMessage("The newly created contractors is display successfully.");

				} else {
					verificationFailedMessage("The newly created contractors is not display.");

				}
			} catch (Throwable t) {
				verificationFailedMessage("The newly created contractors is not display.");
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
		// THE ENGINEERING COMPANIES SCREENS
		title("VALIDATE THE NAVIGATION AFTER SWITCHING THE PROPERTY FROM THE HEADER OF THE ENGINEERING COMPANIES SCREENS");

		try {
			// click on the property project icon from the property list page
			click("propertyproject_icon_CSS");

			// wait for the element
			explicitWaitClickable("menubtn_CSS");

			// click on the burger menu
			click("menubtn_CSS");

			// wait for the element
			Thread.sleep(5000);

			// click on the engineering companies
			click("propertyproject_engineeringcompaniesoption_XPATH");

			// click on the newly created engineering companies record
			String record = "//td[text()='" + title6 + "']";
			driver.findElement(By.xpath(record)).click();
			consoleMessage("Clicked on the newly created engineering companies record.");

			// VALIDATE FOR PROPERTY ONE
			title("VALIDATE FOR PROPERTY ONE");

			// validate the property name
			switchVerification("navigation_header_propertyname1_XPATH", "[DND] AAAA Risk Test Prop 01 - 01",
					"The property name is not displayed.");

			// validate the title of the engineering companies record is displayed or not
			try {

				String title_actual = driver
						.findElement(By.cssSelector(OR.getProperty("propertyproject_ec_companynametxt_CSS")))
						.getAttribute("value");

				if (title_actual.equals(title6)) {
					successMessage("The title of the engineering companies is display successfully.");

				} else {
					verificationFailedMessage("The title of the engineering companies is not display.");

				}
			} catch (Throwable t) {
				verificationFailedMessage("The title of the engineering companies is not display.");
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

			// validate the title of the engineering companies record is displayed or not
			try {

				String title_actual = driver
						.findElement(By.cssSelector(OR.getProperty("propertyproject_ec_companynametxt_CSS")))
						.getAttribute("value");

				if (title_actual.equals(title6)) {
					verificationFailedMessage("The title of the engineering companies is display.");

				} else {
					successMessage("The title of the engineering companies is not display as expected.");

				}
			} catch (Throwable t) {
				successMessage("The title of the engineering companies is not display as expected.");
			}

			// validate the title of the engineering companies in the listing screen is
			// displayed or not
			try {
				String titlelist = "//td[text()='" + title6 + "']";
				boolean titlelist_actual = driver.findElement(By.xpath(titlelist)).isDisplayed();

				if (titlelist_actual == true) {
					verificationFailedMessage("The newly created engineering companies is display.");

				} else {
					successMessage("The newly created engineering companies is not display successfully.");

				}
			} catch (Throwable t) {
				successMessage("The newly created engineering companies is not display successfully.");
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

			// validate the title of the engineering companies record is displayed or not
			try {

				String title_actual = driver
						.findElement(By.cssSelector(OR.getProperty("propertyproject_ec_companynametxt_CSS")))
						.getAttribute("value");

				if (title_actual.equals(title6)) {
					verificationFailedMessage("The title of the engineering companies is display.");

				} else {
					successMessage("The title of the engineering companies is not display as expected.");

				}
			} catch (Throwable t) {
				successMessage("The title of the engineering companies is not display as expected.");
			}

			// validate the title of the engineering companies in the listing screen is
			// displayed or not
			try {
				String titlelist = "//td[text()='" + title6 + "']";
				boolean titlelist_actual = driver.findElement(By.xpath(titlelist)).isDisplayed();

				if (titlelist_actual == true) {
					verificationFailedMessage("The newly created engineering companies is display.");

				} else {
					successMessage("The newly created engineering companies is not display successfully.");

				}
			} catch (Throwable t) {
				successMessage("The newly created engineering companies is not display successfully.");
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

			// validate the title of the engineering companies record is displayed or not
			try {

				String title_actual = driver
						.findElement(By.cssSelector(OR.getProperty("propertyproject_ec_companynametxt_CSS")))
						.getAttribute("value");

				if (title_actual.equals(title6)) {
					verificationFailedMessage("The title of the engineering companies is display.");

				} else {
					successMessage("The title of the engineering companies is not display as expected.");

				}
			} catch (Throwable t) {
				successMessage("The title of the engineering companies is not display as expected.");
			}

			// validate the title of the engineering companies in the listing screen is
			// displayed or not
			try {
				String titlelist = "//td[text()='" + title6 + "']";
				boolean titlelist_actual = driver.findElement(By.xpath(titlelist)).isDisplayed();

				if (titlelist_actual == true) {
					successMessage("The newly created engineering companies is display successfully.");

				} else {
					verificationFailedMessage("The newly created engineering companies is not display.");

				}
			} catch (Throwable t) {
				verificationFailedMessage("The newly created engineering companies is not display.");
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
		// THE MUNICIPALITY SCREENS
		title("VALIDATE THE NAVIGATION AFTER SWITCHING THE PROPERTY FROM THE HEADER OF THE MUNICIPALITY SCREENS");

		try {
			// click on the property project icon from the property list page
			click("propertyproject_icon_CSS");

			// wait for the element
			explicitWaitClickable("menubtn_CSS");

			// click on the burger menu
			click("menubtn_CSS");

			// wait for the element
			Thread.sleep(5000);

			// click on the municipality
			click("propertyproject_municipalityoption_XPATH");

			// click on the newly created municipality record
			String record = "//td[contains(text(),'" + title7 + "')]";
			driver.findElement(By.xpath(record)).click();
			consoleMessage("Clicked on the newly created municipality record.");

			// VALIDATE FOR PROPERTY ONE
			title("VALIDATE FOR PROPERTY ONE");

			// validate the property name
			switchVerification("navigation_header_propertyname1_XPATH", "[DND] AAAA Risk Test Prop 01 - 01",
					"The property name is not displayed.");

			// validate the title of the municipality record is displayed or not
			try {

				String title_actual = driver
						.findElement(By.cssSelector(OR.getProperty("propertyproject_mn_municipalitynametxt_CSS")))
						.getAttribute("value");

				if (title_actual.equals(title6)) {
					successMessage("The title of the municipality is display successfully.");

				} else {
					verificationFailedMessage("The title of the municipality is not display.");

				}
			} catch (Throwable t) {
				verificationFailedMessage("The title of the municipality is not display.");
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

			// validate the title of the municipality record is displayed or not
			try {

				String title_actual = driver
						.findElement(By.cssSelector(OR.getProperty("propertyproject_mn_municipalitynametxt_CSS")))
						.getAttribute("value");

				if (title_actual.equals(title7)) {
					verificationFailedMessage("The title of the municipality is display.");

				} else {
					successMessage("The title of the municipality is not display as expected.");

				}
			} catch (Throwable t) {
				successMessage("The title of the municipality is not display as expected.");
			}

			// validate the title of the municipality in the listing screen is
			// displayed or not
			try {
				String titlelist = "//td[contains(text(),'" + title7 + "')]";
				boolean titlelist_actual = driver.findElement(By.xpath(titlelist)).isDisplayed();

				if (titlelist_actual == true) {
					verificationFailedMessage("The newly created municipality is display.");

				} else {
					successMessage("The newly created municipality is not display successfully.");

				}
			} catch (Throwable t) {
				successMessage("The newly created municipality is not display successfully.");
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

			// validate the title of the municipality record is displayed or not
			try {

				String title_actual = driver
						.findElement(By.cssSelector(OR.getProperty("propertyproject_mn_municipalitynametxt_CSS")))
						.getAttribute("value");

				if (title_actual.equals(title7)) {
					verificationFailedMessage("The title of the municipality is display.");

				} else {
					successMessage("The title of the municipality is not display as expected.");

				}
			} catch (Throwable t) {
				successMessage("The title of the municipality is not display as expected.");
			}

			// validate the title of the municipality in the listing screen is
			// displayed or not
			try {
				String titlelist = "//td[contains(text(),'" + title7 + "')]";
				boolean titlelist_actual = driver.findElement(By.xpath(titlelist)).isDisplayed();

				if (titlelist_actual == true) {
					verificationFailedMessage("The newly created municipality is display.");

				} else {
					successMessage("The newly created municipality is not display successfully.");

				}
			} catch (Throwable t) {
				successMessage("The newly created municipality is not display successfully.");
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

			// validate the title of the municipality record is displayed or not
			try {

				String title_actual = driver
						.findElement(By.cssSelector(OR.getProperty("propertyproject_mn_municipalitynametxt_CSS")))
						.getAttribute("value");

				if (title_actual.equals(title7)) {
					verificationFailedMessage("The title of the municipality is display.");

				} else {
					successMessage("The title of the municipality is not display as expected.");

				}
			} catch (Throwable t) {
				successMessage("The title of the municipality is not display as expected.");
			}

			// validate the title of the municipality in the listing screen is
			// displayed or not
			try {
				String titlelist = "//td[contains(text(),'" + title7 + "')]";
				boolean titlelist_actual = driver.findElement(By.xpath(titlelist)).isDisplayed();

				if (titlelist_actual == true) {
					successMessage("The newly created municipality is display successfully.");

				} else {
					verificationFailedMessage("The newly created municipality is not display.");

				}
			} catch (Throwable t) {
				verificationFailedMessage("The newly created municipality is not display.");
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
			String murecord = "//td[text()='" + title1
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

			// enter the newly created document name in the search field
			type("propertyproject_documentreport_searchtxt_XPATH", title1);

			// validate the newly created document report record
			try {
				String record1 = "//td[text()='" + title1 + "']";
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

		// DELETE THE NEWLY CREATED CAPEX PROJECTS RECORD
		title("DELETE THE NEWLY CREATED CAPEX PROJECTS RECORD");

		try {
			// click on the property project icon from the property list page
			click("propertyproject_icon_CSS");

			// wait for the element
			explicitWaitClickable("menubtn_CSS");

			// click on the burger menu
			click("menubtn_CSS");

			// wait for the element
			Thread.sleep(5000);

			// click on the capex projects
			click("propertyproject_capexprojectsoption_XPATH");

			// click on the delete icon of the respective record
			String deleterecord = "//td[text()='" + title2
					+ "']//following-sibling::td[@ng-show='isCapexProjectsDeleters']//i[@data-target='#removeConfirmationModal']";
			driver.findElement(By.xpath(deleterecord)).click();
			consoleMessage("Clicked on the delete icon of the respective record.");

			// wait for the element
			explicitWaitClickable("propertyproject_cp_confirmationdeletebtn_CSS");

			// click on the delete button of the confirmation model
			click("propertyproject_cp_confirmationdeletebtn_CSS");

			// wait for the element
			explicitWaitClickable("closetoastmsg_CSS");

			// click on the toaster close button
			click("closetoastmsg_CSS");

			// validate the newly created document report record
			try {
				String record1 = "//td[text()='" + title2 + "']";
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

		// DELETE THE NEWLY CREATED MUNICIPAL ORDERS RECORD
		title("DELETE THE NEWLY CREATED MUNICIPAL ORDERS RECORD");

		try {
			// click on the property project icon from the property list page
			click("propertyproject_icon_CSS");

			// wait for the element
			explicitWaitClickable("menubtn_CSS");

			// click on the burger menu
			click("menubtn_CSS");

			// wait for the element
			Thread.sleep(5000);

			// click on the municipal orders
			click("propertyproject_municipalordersoption_XPATH");

			// click on the delete icon of the respective record
			String deleterecord = "//td[text()='" + title3
					+ "']//following-sibling::td[@ng-show='isMunicipalOrdersDeleters']//i[@data-target='#removeConfirmationModal']";
			driver.findElement(By.xpath(deleterecord)).click();
			consoleMessage("Clicked on the delete icon of the respective record.");

			// wait for the element
			explicitWaitClickable("propertyproject_mo_confirmationdeletebtn_CSS");

			// click on the delete button of the confirmation model
			click("propertyproject_mo_confirmationdeletebtn_CSS");

			// wait for the element
			explicitWaitClickable("closetoastmsg_CSS");

			// click on the toaster close button
			click("closetoastmsg_CSS");

			// validate the newly created document report record
			try {
				String record1 = "//td[text()='" + title3 + "']";
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

		// DELETE THE NEWLY CREATED LENDERS RECORD
		title("DELETE THE NEWLY CREATED LENDERS RECORD");

		try {
			// click on the property project icon from the property list page
			click("propertyproject_icon_CSS");

			// wait for the element
			explicitWaitClickable("menubtn_CSS");

			// click on the burger menu
			click("menubtn_CSS");

			// wait for the element
			Thread.sleep(5000);

			// click on the Lenders
			click("propertyproject_lendersoption_XPATH");

			// click on the delete icon of the respective record
			String deleterecord = "//td[text()='" + title4
					+ "']//following-sibling::td[@ng-show='isLendersDeleters']//i[@data-target='#removeConfirmationModal']";
			driver.findElement(By.xpath(deleterecord)).click();
			consoleMessage("Clicked on the delete icon of the respective record.");

			// wait for the element
			explicitWaitClickable("propertyproject_le_confirmationdeletebtn_CSS");

			// click on the delete button of the confirmation model
			click("propertyproject_le_confirmationdeletebtn_CSS");

			// wait for the element
			explicitWaitClickable("closetoastmsg_CSS");

			// click on the toaster close button
			click("closetoastmsg_CSS");

			// validate the newly created document report record
			try {
				String record1 = "//td[text()='" + title4 + "']";
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

		// DELETE THE NEWLY CREATED CONTRACTORS RECORD
		title("DELETE THE NEWLY CREATED CONTRACTORS RECORD");

		try {
			// click on the property project icon from the property list page
			click("propertyproject_icon_CSS");

			// wait for the element
			explicitWaitClickable("menubtn_CSS");

			// click on the burger menu
			click("menubtn_CSS");

			// wait for the element
			Thread.sleep(5000);

			// click on the contractors
			click("propertyproject_contractorsoption_XPATH");

			// enter the newly created document name in the search field
			type("ohs_incidentreport_searchtxt_XPATH", title5);

			// click on the delete icon of the respective record
			String deleterecord = "//td[text()='" + title5
					+ "']//following-sibling::td[@ng-show='isContractorsDeleters']//i[@data-target='#removeConfirmationModal']";
			driver.findElement(By.xpath(deleterecord)).click();
			consoleMessage("Clicked on the delete icon of the respective record.");

			// wait for the element
			explicitWaitClickable("propertyproject_co_confirmationdeletebtn_CSS");

			// click on the delete button of the confirmation model
			click("propertyproject_co_confirmationdeletebtn_CSS");

			// wait for the element
			explicitWaitClickable("closetoastmsg_CSS");

			// click on the toaster close button
			click("closetoastmsg_CSS");

			// validate the deleted record
			try {
				String record1 = "//td[text()='" + title5 + "']";
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

		// DELETE THE NEWLY CREATED ENGINEERING COMPANIES RECORD
		title("DELETE THE NEWLY CREATED ENGINEERING COMPANIES RECORD");

		try {
			// click on the property project icon from the property list page
			click("propertyproject_icon_CSS");

			// wait for the element
			explicitWaitClickable("menubtn_CSS");

			// click on the burger menu
			click("menubtn_CSS");

			// wait for the element
			Thread.sleep(5000);

			// click on the engineering companies
			click("propertyproject_engineeringcompaniesoption_XPATH");

			// click on the delete icon of the respective record
			String deleterecord = "//td[text()='" + title6
					+ "']//following-sibling::td[@ng-show='isEngineeringCompaniesDeleters']//i[@data-target='#removeConfirmationModal']";
			driver.findElement(By.xpath(deleterecord)).click();
			consoleMessage("Clicked on the delete icon of the respective record.");

			// wait for the element
			explicitWaitClickable("propertyproject_ec_confirmationdeletebtn_CSS");

			// click on the delete button of the confirmation model
			click("propertyproject_ec_confirmationdeletebtn_CSS");

			// wait for the element
			explicitWaitClickable("closetoastmsg_CSS");

			// click on the toaster close button
			click("closetoastmsg_CSS");

			// validate the deleted record
			try {
				String record1 = "//td[text()='" + title6 + "']";
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

		// DELETE THE NEWLY CREATED MUNICIPALITY RECORD
		title("DELETE THE NEWLY CREATED MUNICIPALITY RECORD");

		try {
			// click on the property project icon from the property list page
			click("propertyproject_icon_CSS");

			// wait for the element
			explicitWaitClickable("menubtn_CSS");

			// click on the burger menu
			click("menubtn_CSS");

			// wait for the element
			Thread.sleep(5000);

			// click on the municipality
			click("propertyproject_municipalityoption_XPATH");

			// click on the delete icon of the respective record
			String deleterecord = "//td[text()='" + title7
					+ "']//following-sibling::td[@ng-show='isMunicipalitiesDeleters']//i[@data-target='#removeConfirmationModal']";
			driver.findElement(By.xpath(deleterecord)).click();
			consoleMessage("Clicked on the delete icon of the respective record.");

			// wait for the element
			explicitWaitClickable("propertyproject_mn_confirmationdeletebtn_CSS");

			// click on the delete button of the confirmation model
			click("propertyproject_mn_confirmationdeletebtn_CSS");

			// wait for the element
			explicitWaitClickable("closetoastmsg_CSS");

			// click on the toaster close button
			click("closetoastmsg_CSS");

			// validate the deleted record
			try {
				String record1 = "//td[text()='" + title7 + "']";
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

	}

}
