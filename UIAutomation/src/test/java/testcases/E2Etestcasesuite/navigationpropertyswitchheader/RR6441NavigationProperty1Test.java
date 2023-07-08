package testcases.E2Etestcasesuite.navigationpropertyswitchheader;

import java.io.IOException;
import java.util.Hashtable;
import java.util.List;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.Helper;
import base.TestBase;
import utilities.TestUtil;

public class RR6441NavigationProperty1Test extends TestBase {

	@Test(dataProviderClass = TestUtil.class, dataProvider = "dp")
	public void rR6441NavigationProperty1Test(Hashtable<String, String> data) throws InterruptedException, IOException {

		execution(data, "rR6441NavigationProperty1Test");

		// PROPERTY PROJECT DASHBOARD - NAVIGATION SCENARIO OF THE MORTGAGE
		// UNDERTAKINGS, MUNICIPAL ORDERS, CAPEX PROJECTS, MORTGAGE UNDERTAKING REPAIRS,
		// MUNICIPAL ORDER REPAIRS, CAPEX PROJECT REPAIRS.
		title("PROPERTY PROJECT DASHBOARD - NAVIGATION SCENARIO OF THE MORTGAGE UNDERTAKINGS, MUNICIPAL ORDERS, CAPEX PROJECTS, MORTGAGE UNDERTAKING REPAIRS, MUNICIPAL ORDER REPAIRS, CAPEX PROJECT REPAIRS.");

		// refresh the page
		driver.navigate().refresh();
		Thread.sleep(5000);
		driver.navigate().refresh();

		// ADD MORTGAGE UNDERTAKINGS RECORD
		title("ADD MORTGAGE UNDERTAKINGS RECORD");

		String title1 = RandomStringUtils.randomAlphabetic(8);
		String repairTitle1 = RandomStringUtils.randomAlphabetic(8);

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

			// wait for the element
			Thread.sleep(5000);

			// wait for the element
			explicitWaitClickable("propertyproject_mu_newrepairbtn_BTNTEXT");

			// click on the new repair button
			click("propertyproject_mu_newrepairbtn_BTNTEXT");

			// scroll down the screen
			scrollByPixel(400);

			// enter the title of the repair
			type("propertyproject_mu_repair_titletxt_CSS", repairTitle1);

			// click on assign to field
			click("propertyproject_mu_repair_assigntotxt_CSS");

			// click on the none button
			click("propertyproject_mu_repair_nonebtn_CSS");

			// enter username in search field
			type("propertyproject_mu_repair_searchusertxt_CSS", "Jinesh");

			// click on the searched username
			click("propertyproject_mu_repair_searcheduser_XPATH");

			// click on assign to field
			click("propertyproject_mu_repair_assigntotxt_CSS");

			// click on the save button
			click("propertyproject_mu_tasksavebtn_BTNTEXT");

			// verify newly created repair is displayed or not
			try {
				String repair1 = "//td[text()='" + repairTitle1 + "']";
				String repair1_actual = (driver.findElement(By.xpath(repair1)).getText()).trim();

				if (repair1_actual.equals(repairTitle1)) {

					successMessage("The " + repairTitle1 + " is verified successfully.");

				} else {
					verificationFailedMessage("The " + repairTitle1 + " is not verified.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The " + repairTitle1 + " is not verified.");
			}

			// click on the update button
			click("propertyproject_mu_taskupdatebtn_BTNTEXT");

			// verification of the Mortgage Undertakings is added or not
			try {
				String mu1 = "//td[text()='" + title1 + "']";
				String mu1_actual = (driver.findElement(By.xpath(mu1)).getText()).trim();

				if (mu1_actual.equals(title1)) {

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

		// ADD CAPEX PROJECTS RECORD
		title("ADD CAPEX PROJECTS RECORD");

		String title2 = RandomStringUtils.randomAlphabetic(8);
		String repairTitle2 = RandomStringUtils.randomAlphabetic(8);

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

			// wait for the element
			explicitWaitClickable("propertyproject_mu_newrepairbtn_BTNTEXT");

			// click on the new repair button
			click("propertyproject_mu_newrepairbtn_BTNTEXT");

			// scroll down the screen
			scrollByPixel(400);

			// enter the title of the repair
			type("propertyproject_mu_repair_titletxt_CSS", repairTitle2);

			// click on assign to field
			click("propertyproject_mu_repair_assigntotxt_CSS");

			// click on the none button
			click("propertyproject_mu_repair_nonebtn_CSS");

			// enter username in search field
			type("propertyproject_mu_repair_searchusertxt_CSS", "Jinesh");

			// click on the searched username
			click("propertyproject_mu_repair_searcheduser_XPATH");

			// click on assign to field
			click("propertyproject_mu_repair_assigntotxt_CSS");

			// click on the save button
			click("propertyproject_mu_tasksavebtn_BTNTEXT");

			// verify newly created repair is displayed or not
			try {
				String repair2 = "//td[text()='" + repairTitle2 + "']";
				String repair2_actual = (driver.findElement(By.xpath(repair2)).getText()).trim();

				if (repair2_actual.equals(repairTitle2)) {

					successMessage("The " + repairTitle2 + " is verified successfully.");

				} else {
					verificationFailedMessage("The " + repairTitle2 + " is not verified.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The " + repairTitle2 + " is not verified.");
			}

			// click on the update button
			click("propertyproject_mu_taskupdatebtn_BTNTEXT");

			// verification of the CAPEX Project is added or not
			try {
				String cp1 = "//td[text()='" + title2 + "']";
				String cp1_actual = (driver.findElement(By.xpath(cp1)).getText()).trim();

				if (cp1_actual.equals(title2)) {

					successMessage("The " + title2 + " is verified successfully.");

				} else {
					verificationFailedMessage("The " + title2 + " is not verified.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The " + title2 + " is not verified.");
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

		// ADD MUNICIPAL ORDERS RECORD
		title("ADD MUNICIPAL ORDERS RECORD");

		String title3 = RandomStringUtils.randomAlphabetic(8);
		String repairTitle3 = RandomStringUtils.randomAlphabetic(8);

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

			// wait for the element
			explicitWaitClickable("propertyproject_mu_newrepairbtn_BTNTEXT");

			// click on the new repair button
			click("propertyproject_mu_newrepairbtn_BTNTEXT");

			// scroll down the screen
			scrollByPixel(400);

			// enter the title of the repair
			type("propertyproject_mu_repair_titletxt_CSS", repairTitle3);

			// click on assign to field
			click("propertyproject_mu_repair_assigntotxt_CSS");

			// click on the none button
			click("propertyproject_mu_repair_nonebtn_CSS");

			// enter username in search field
			type("propertyproject_mu_repair_searchusertxt_CSS", "Jinesh");

			// click on the searched username
			click("propertyproject_mu_repair_searcheduser_XPATH");

			// click on assign to field
			click("propertyproject_mu_repair_assigntotxt_CSS");

			// click on the save button
			click("propertyproject_mu_tasksavebtn_BTNTEXT");

			// verify newly created repair is displayed or not
			try {
				String repair3 = "//td[text()='" + repairTitle3 + "']";
				String repair3_actual = (driver.findElement(By.xpath(repair3)).getText()).trim();

				if (repair3_actual.equals(repairTitle3)) {

					successMessage("The " + repairTitle3 + " is verified successfully.");

				} else {
					verificationFailedMessage("The " + repairTitle3 + " is not verified.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The " + repairTitle3 + " is not verified.");
			}

			// click on the update button
			click("propertyproject_mu_taskupdatebtn_BTNTEXT");

			// verification of the municipality order is added or not
			try {
				String mo1 = "//td[text()='" + title3 + "']";
				String mo1_actual = (driver.findElement(By.xpath(mo1)).getText()).trim();

				if (mo1_actual.equals(title3)) {

					successMessage("The " + title3 + " is verified successfully.");

				} else {
					verificationFailedMessage("The " + title3 + " is not verified.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The " + title3 + " is not verified.");
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
		// THE MORTGAGE UNDERTAKINGS DASHBOARD SCREEN
		title("VALIDATE THE NAVIGATION AFTER SWITCHING THE PROPERTY FROM THE HEADER OF THE MORTGAGE UNDERTAKINGS DASHBOARD SCREEN");

		try {

			// wait for the element
			Thread.sleep(5000);

			// click on the side menu
			click("menubtn_CSS");

			// wait for the element
			Thread.sleep(5000);

			// click on the property project side menu
			click("sidemenu_propertyprojects_XPATH");

			// select the option from the dashboard dropdown
			select("dashboard_CSS", "Mortgage Undertaking");

			// VALIDATE FOR PROPERTY ONE
			title("VALIDATE FOR PROPERTY ONE");

			// validate the Mortgage Undertaking title
			switchVerification("propertyprojectdashboard_mortgageundertakingtitle_XPATH", "Mortgage Undertaking",
					"The Mortgage Undertaking title is not displayed.");

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
				// scroll down till Projects Overview card
				scrollTillElement("propertyprojectdashboard_mortgageundertakingcard_XPATH");

				// validate the Projects Overview card
				boolean projectCard = driver
						.findElement(By.xpath(OR.getProperty("propertyprojectdashboard_mortgageundertakingcard_XPATH")))
						.isDisplayed();

				if (projectCard == true) {
					successMessage("The Projects Overview card is displayed correctly.");
				} else {
					verificationFailedMessage("The Projects Overview card is not displayed correctly.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The Projects Overview card is not displayed correctly.");
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
				// scroll down till Projects Overview card
				scrollTillElement("propertyprojectdashboard_mortgageundertakingcard_XPATH");

				// validate the Projects Overview card
				boolean projectCard = driver
						.findElement(By.xpath(OR.getProperty("propertyprojectdashboard_mortgageundertakingcard_XPATH")))
						.isDisplayed();

				if (projectCard == true) {
					successMessage("The Projects Overview card is displayed correctly.");
				} else {
					verificationFailedMessage("The Projects Overview card is not displayed correctly.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The Projects Overview card is not displayed correctly.");
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
				// scroll down till Projects Overview card
				scrollTillElement("propertyprojectdashboard_mortgageundertakingcard_XPATH");

				// validate the Projects Overview card
				boolean projectCard = driver
						.findElement(By.xpath(OR.getProperty("propertyprojectdashboard_mortgageundertakingcard_XPATH")))
						.isDisplayed();

				if (projectCard == true) {
					successMessage("The Projects Overview card is displayed correctly.");
				} else {
					verificationFailedMessage("The Projects Overview card is not displayed correctly.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The Projects Overview card is not displayed correctly.");
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
		// THE DETAILS SCREEN OF THE MORTGAGE UNDERTAKINGS
		title("VALIDATE THE NAVIGATION AFTER SWITCHING THE PROPERTY FROM THE HEADER OF THE DETAILS SCREEN OF THE MORTGAGE UNDERTAKINGS");

		try {

			// wait for the element
			Thread.sleep(5000);

			// click on the side menu
			click("menubtn_CSS");

			// wait for the element
			Thread.sleep(5000);

			// click on the property project side menu
			click("sidemenu_propertyprojects_XPATH");

			// select the option from the dashboard dropdown
			select("dashboard_CSS", "Mortgage Undertaking");

			// enter the newly created Mortgage Undertaking in the search field
			type("propertyprojectdashboard_searchtxt_XPATH", title1);

			// click on the searched result
			String mc = "//td[text()='" + title1 + "']";
			driver.findElement(By.xpath(mc)).click();
			consoleMessage("Clicked on the searched result.");

			// VALIDATE FOR PROPERTY ONE
			title("VALIDATE FOR PROPERTY ONE");

			// validate the property name
			switchVerification("navigation_header_propertyname1_XPATH", "[DND] AAAA Risk Test Prop 01 - 01",
					"The property name is not displayed.");

			// validate the Undertaking Number of the Mortgage Undertakings
			try {
				String title = driver
						.findElement(By.cssSelector(OR.getProperty("propertyproject_mu_undertakingnumbertxt_CSS")))
						.getAttribute("value");

				if (title.equals(title1)) {
					successMessage("The Undertaking Number of the Mortgage Undertakings is displayed correctly.");
				} else {
					verificationFailedMessage(
							"The Undertaking Number of the Mortgage Undertakings is not displayed correctly.");
				}
			} catch (Throwable t) {
				verificationFailedMessage(
						"The Undertaking Number of the Mortgage Undertakings is not displayed correctly.");
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
				// scroll down till Projects Overview card
				scrollTillElement("propertyprojectdashboard_mortgageundertakingcard_XPATH");

				// validate the Projects Overview card
				boolean projectCard = driver
						.findElement(By.xpath(OR.getProperty("propertyprojectdashboard_mortgageundertakingcard_XPATH")))
						.isDisplayed();

				if (projectCard == true) {
					successMessage("The Projects Overview card is displayed correctly.");
				} else {
					verificationFailedMessage("The Projects Overview card is not displayed correctly.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The Projects Overview card is not displayed correctly.");
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
				// scroll down till Projects Overview card
				scrollTillElement("propertyprojectdashboard_mortgageundertakingcard_XPATH");

				// validate the Projects Overview card
				boolean projectCard = driver
						.findElement(By.xpath(OR.getProperty("propertyprojectdashboard_mortgageundertakingcard_XPATH")))
						.isDisplayed();

				if (projectCard == true) {
					successMessage("The Projects Overview card is displayed correctly.");
				} else {
					verificationFailedMessage("The Projects Overview card is not displayed correctly.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The Projects Overview card is not displayed correctly.");
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
				// scroll down till Projects Overview card
				scrollTillElement("propertyprojectdashboard_mortgageundertakingcard_XPATH");

				// validate the Projects Overview card
				boolean projectCard = driver
						.findElement(By.xpath(OR.getProperty("propertyprojectdashboard_mortgageundertakingcard_XPATH")))
						.isDisplayed();

				if (projectCard == true) {
					successMessage("The Projects Overview card is displayed correctly.");
				} else {
					verificationFailedMessage("The Projects Overview card is not displayed correctly.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The Projects Overview card is not displayed correctly.");
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
		// THE CAPEX PROJECT DASHBOARD SCREEN
		title("VALIDATE THE NAVIGATION AFTER SWITCHING THE PROPERTY FROM THE HEADER OF THE CAPEX PROJECT DASHBOARD SCREEN");

		try {

			// wait for the element
			Thread.sleep(5000);

			// click on the side menu
			click("menubtn_CSS");

			// wait for the element
			Thread.sleep(5000);

			// click on the property project side menu
			click("sidemenu_propertyprojects_XPATH");

			// select the option from the dashboard dropdown
			select("dashboard_CSS", "CAPEX Projects");

			// VALIDATE FOR PROPERTY ONE
			title("VALIDATE FOR PROPERTY ONE");

			// validate the CAPEX Projects title
			switchVerification("propertyprojectdashboard_capexprojecttitle_XPATH", "CAPEX Projects",
					"The CAPEX Projects title is not displayed.");

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
				// scroll down till Projects Overview card
				scrollTillElement("propertyprojectdashboard_mortgageundertakingcard_XPATH");

				// validate the Projects Overview card
				boolean projectCard = driver
						.findElement(By.xpath(OR.getProperty("propertyprojectdashboard_mortgageundertakingcard_XPATH")))
						.isDisplayed();

				if (projectCard == true) {
					successMessage("The Projects Overview card is displayed correctly.");
				} else {
					verificationFailedMessage("The Projects Overview card is not displayed correctly.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The Projects Overview card is not displayed correctly.");
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
				// scroll down till Projects Overview card
				scrollTillElement("propertyprojectdashboard_mortgageundertakingcard_XPATH");

				// validate the Projects Overview card
				boolean projectCard = driver
						.findElement(By.xpath(OR.getProperty("propertyprojectdashboard_mortgageundertakingcard_XPATH")))
						.isDisplayed();

				if (projectCard == true) {
					successMessage("The Projects Overview card is displayed correctly.");
				} else {
					verificationFailedMessage("The Projects Overview card is not displayed correctly.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The Projects Overview card is not displayed correctly.");
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
				// scroll down till Projects Overview card
				scrollTillElement("propertyprojectdashboard_mortgageundertakingcard_XPATH");

				// validate the Projects Overview card
				boolean projectCard = driver
						.findElement(By.xpath(OR.getProperty("propertyprojectdashboard_mortgageundertakingcard_XPATH")))
						.isDisplayed();

				if (projectCard == true) {
					successMessage("The Projects Overview card is displayed correctly.");
				} else {
					verificationFailedMessage("The Projects Overview card is not displayed correctly.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The Projects Overview card is not displayed correctly.");
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
		// THE DETAILS SCREEN OF THE CAPEX PROJECT
		title("VALIDATE THE NAVIGATION AFTER SWITCHING THE PROPERTY FROM THE HEADER OF THE DETAILS SCREEN OF THE CAPEX PROJECT");

		try {

			// wait for the element
			Thread.sleep(5000);

			// click on the side menu
			click("menubtn_CSS");

			// wait for the element
			Thread.sleep(5000);

			// click on the property project side menu
			click("sidemenu_propertyprojects_XPATH");

			// select the option from the dashboard dropdown
			select("dashboard_CSS", "CAPEX Projects");

			// enter the newly created CAPEX Projects in the search field
			type("propertyprojectdashboard_searchtxt_XPATH", title2);

			// click on the searched result
			String cp = "//td[text()='" + title2 + "']";
			driver.findElement(By.xpath(cp)).click();
			consoleMessage("Clicked on the searched result.");

			// VALIDATE FOR PROPERTY ONE
			title("VALIDATE FOR PROPERTY ONE");

			// validate the property name
			switchVerification("navigation_header_propertyname1_XPATH", "[DND] AAAA Risk Test Prop 01 - 01",
					"The property name is not displayed.");

			// validate the CAPEX Projects of the Mortgage Undertakings
			try {
				String title = driver
						.findElement(By.cssSelector(OR.getProperty("propertyproject_cp_projectnumbertxt_CSS")))
						.getAttribute("value");

				if (title.equals(title2)) {
					successMessage("The CAPEX Projects is displayed correctly.");
				} else {
					verificationFailedMessage("The CAPEX Projects is not displayed correctly.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The CAPEX Projects is not displayed correctly.");
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
				// scroll down till Projects Overview card
				scrollTillElement("propertyprojectdashboard_mortgageundertakingcard_XPATH");

				// validate the Projects Overview card
				boolean projectCard = driver
						.findElement(By.xpath(OR.getProperty("propertyprojectdashboard_mortgageundertakingcard_XPATH")))
						.isDisplayed();

				if (projectCard == true) {
					successMessage("The Projects Overview card is displayed correctly.");
				} else {
					verificationFailedMessage("The Projects Overview card is not displayed correctly.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The Projects Overview card is not displayed correctly.");
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
				// scroll down till Projects Overview card
				scrollTillElement("propertyprojectdashboard_mortgageundertakingcard_XPATH");

				// validate the Projects Overview card
				boolean projectCard = driver
						.findElement(By.xpath(OR.getProperty("propertyprojectdashboard_mortgageundertakingcard_XPATH")))
						.isDisplayed();

				if (projectCard == true) {
					successMessage("The Projects Overview card is displayed correctly.");
				} else {
					verificationFailedMessage("The Projects Overview card is not displayed correctly.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The Projects Overview card is not displayed correctly.");
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
				// scroll down till Projects Overview card
				scrollTillElement("propertyprojectdashboard_mortgageundertakingcard_XPATH");

				// validate the Projects Overview card
				boolean projectCard = driver
						.findElement(By.xpath(OR.getProperty("propertyprojectdashboard_mortgageundertakingcard_XPATH")))
						.isDisplayed();

				if (projectCard == true) {
					successMessage("The Projects Overview card is displayed correctly.");
				} else {
					verificationFailedMessage("The Projects Overview card is not displayed correctly.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The Projects Overview card is not displayed correctly.");
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
		// THE MUNICIPAL ORDERS DASHBOARD SCREEN
		title("VALIDATE THE NAVIGATION AFTER SWITCHING THE PROPERTY FROM THE HEADER OF THE MUNICIPAL ORDERS DASHBOARD SCREEN");

		try {

			// wait for the element
			Thread.sleep(5000);

			// click on the side menu
			click("menubtn_CSS");

			// wait for the element
			Thread.sleep(5000);

			// click on the property project side menu
			click("sidemenu_propertyprojects_XPATH");

			// select the option from the dashboard dropdown
			select("dashboard_CSS", "Municipal Orders");

			// VALIDATE FOR PROPERTY ONE
			title("VALIDATE FOR PROPERTY ONE");

			// validate the Municipal Orders title
			switchVerification("propertyprojectdashboard_municipalorderstitle_XPATH", "Municipal Orders",
					"The Municipal Orders title is not displayed.");

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
				// scroll down till Projects Overview card
				scrollTillElement("propertyprojectdashboard_mortgageundertakingcard_XPATH");

				// validate the Projects Overview card
				boolean projectCard = driver
						.findElement(By.xpath(OR.getProperty("propertyprojectdashboard_mortgageundertakingcard_XPATH")))
						.isDisplayed();

				if (projectCard == true) {
					successMessage("The Projects Overview card is displayed correctly.");
				} else {
					verificationFailedMessage("The Projects Overview card is not displayed correctly.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The Projects Overview card is not displayed correctly.");
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
				// scroll down till Projects Overview card
				scrollTillElement("propertyprojectdashboard_mortgageundertakingcard_XPATH");

				// validate the Projects Overview card
				boolean projectCard = driver
						.findElement(By.xpath(OR.getProperty("propertyprojectdashboard_mortgageundertakingcard_XPATH")))
						.isDisplayed();

				if (projectCard == true) {
					successMessage("The Projects Overview card is displayed correctly.");
				} else {
					verificationFailedMessage("The Projects Overview card is not displayed correctly.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The Projects Overview card is not displayed correctly.");
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
				// scroll down till Projects Overview card
				scrollTillElement("propertyprojectdashboard_mortgageundertakingcard_XPATH");

				// validate the Projects Overview card
				boolean projectCard = driver
						.findElement(By.xpath(OR.getProperty("propertyprojectdashboard_mortgageundertakingcard_XPATH")))
						.isDisplayed();

				if (projectCard == true) {
					successMessage("The Projects Overview card is displayed correctly.");
				} else {
					verificationFailedMessage("The Projects Overview card is not displayed correctly.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The Projects Overview card is not displayed correctly.");
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
		// THE DETAILS SCREEN OF THE MUNICIPAL ORDERS
		title("VALIDATE THE NAVIGATION AFTER SWITCHING THE PROPERTY FROM THE HEADER OF THE DETAILS SCREEN OF THE MUNICIPAL ORDERS");

		try {

			// wait for the element
			Thread.sleep(5000);

			// click on the side menu
			click("menubtn_CSS");

			// wait for the element
			Thread.sleep(5000);

			// click on the property project side menu
			click("sidemenu_propertyprojects_XPATH");

			// select the option from the dashboard dropdown
			select("dashboard_CSS", "Municipal Orders");

			// enter the newly created Municipal Orders in the search field
			type("propertyprojectdashboard_searchtxt_XPATH", title3);

			// click on the searched result
			String mo = "//td[text()='" + title3 + "']";
			driver.findElement(By.xpath(mo)).click();
			consoleMessage("Clicked on the searched result.");

			// VALIDATE FOR PROPERTY ONE
			title("VALIDATE FOR PROPERTY ONE");

			// validate the property name
			switchVerification("navigation_header_propertyname1_XPATH", "[DND] AAAA Risk Test Prop 01 - 01",
					"The property name is not displayed.");

			// validate the Municipal Orders
			try {
				String title = driver
						.findElement(By.cssSelector(OR.getProperty("propertyproject_mo_projectnumbertxt_CSS")))
						.getAttribute("value");

				if (title.equals(title3)) {
					successMessage("The Municipal Orders is displayed correctly.");
				} else {
					verificationFailedMessage("The Municipal Orders is not displayed correctly.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The Municipal Orders is not displayed correctly.");
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
				// scroll down till Projects Overview card
				scrollTillElement("propertyprojectdashboard_mortgageundertakingcard_XPATH");

				// validate the Projects Overview card
				boolean projectCard = driver
						.findElement(By.xpath(OR.getProperty("propertyprojectdashboard_mortgageundertakingcard_XPATH")))
						.isDisplayed();

				if (projectCard == true) {
					successMessage("The Projects Overview card is displayed correctly.");
				} else {
					verificationFailedMessage("The Projects Overview card is not displayed correctly.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The Projects Overview card is not displayed correctly.");
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
				// scroll down till Projects Overview card
				scrollTillElement("propertyprojectdashboard_mortgageundertakingcard_XPATH");

				// validate the Projects Overview card
				boolean projectCard = driver
						.findElement(By.xpath(OR.getProperty("propertyprojectdashboard_mortgageundertakingcard_XPATH")))
						.isDisplayed();

				if (projectCard == true) {
					successMessage("The Projects Overview card is displayed correctly.");
				} else {
					verificationFailedMessage("The Projects Overview card is not displayed correctly.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The Projects Overview card is not displayed correctly.");
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
				// scroll down till Projects Overview card
				scrollTillElement("propertyprojectdashboard_mortgageundertakingcard_XPATH");

				// validate the Projects Overview card
				boolean projectCard = driver
						.findElement(By.xpath(OR.getProperty("propertyprojectdashboard_mortgageundertakingcard_XPATH")))
						.isDisplayed();

				if (projectCard == true) {
					successMessage("The Projects Overview card is displayed correctly.");
				} else {
					verificationFailedMessage("The Projects Overview card is not displayed correctly.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The Projects Overview card is not displayed correctly.");
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
		// THE MORTGAGE UNDERTAKINGS REPAIRS DASHBOARD SCREEN
		title("VALIDATE THE NAVIGATION AFTER SWITCHING THE PROPERTY FROM THE HEADER OF THE MORTGAGE UNDERTAKINGS REPAIRS DASHBOARD SCREEN");

		try {

			// wait for the element
			Thread.sleep(5000);

			// click on the side menu
			click("menubtn_CSS");

			// wait for the element
			Thread.sleep(5000);

			// click on the property project side menu
			click("sidemenu_propertyprojects_XPATH");

			// select the option from the dashboard dropdown
			select("dashboard_CSS", "Mortgage Undertaking Repairs");

			// VALIDATE FOR PROPERTY ONE
			title("VALIDATE FOR PROPERTY ONE");

			// validate the Mortgage Undertaking title
			switchVerification("propertyprojectdashboard_mortgageundertakingrepairstitle_XPATH",
					"Mortgage Undertaking Repairs", "The Mortgage Undertaking Repairs title is not displayed.");

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
				// scroll down till Projects Overview card
				scrollTillElement("propertyprojectdashboard_mortgageundertakingcard_XPATH");

				// validate the Projects Overview card
				boolean projectCard = driver
						.findElement(By.xpath(OR.getProperty("propertyprojectdashboard_mortgageundertakingcard_XPATH")))
						.isDisplayed();

				if (projectCard == true) {
					successMessage("The Projects Overview card is displayed correctly.");
				} else {
					verificationFailedMessage("The Projects Overview card is not displayed correctly.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The Projects Overview card is not displayed correctly.");
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
				// scroll down till Projects Overview card
				scrollTillElement("propertyprojectdashboard_mortgageundertakingcard_XPATH");

				// validate the Projects Overview card
				boolean projectCard = driver
						.findElement(By.xpath(OR.getProperty("propertyprojectdashboard_mortgageundertakingcard_XPATH")))
						.isDisplayed();

				if (projectCard == true) {
					successMessage("The Projects Overview card is displayed correctly.");
				} else {
					verificationFailedMessage("The Projects Overview card is not displayed correctly.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The Projects Overview card is not displayed correctly.");
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
				// scroll down till Projects Overview card
				scrollTillElement("propertyprojectdashboard_mortgageundertakingcard_XPATH");

				// validate the Projects Overview card
				boolean projectCard = driver
						.findElement(By.xpath(OR.getProperty("propertyprojectdashboard_mortgageundertakingcard_XPATH")))
						.isDisplayed();

				if (projectCard == true) {
					successMessage("The Projects Overview card is displayed correctly.");
				} else {
					verificationFailedMessage("The Projects Overview card is not displayed correctly.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The Projects Overview card is not displayed correctly.");
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
		// THE TASK SCREEN OF THE MORTGAGE UNDERTAKINGS DASHBOARD SCREEN
		title("VALIDATE THE NAVIGATION AFTER SWITCHING THE PROPERTY FROM THE HEADER OF THE TASK SCREEN OF THE MORTGAGE UNDERTAKINGS DASHBOARD SCREEN");

		try {

			// wait for the element
			Thread.sleep(5000);

			// click on the side menu
			click("menubtn_CSS");

			// wait for the element
			Thread.sleep(5000);

			// click on the property project side menu
			click("sidemenu_propertyprojects_XPATH");

			// select the option from the dashboard dropdown
			select("dashboard_CSS", "Mortgage Undertaking Repairs");

			// enter the newly created Mortgage Undertaking Repairs in the search field
			type("propertyprojectdashboard_searchtxt_XPATH", title1);

			// click on the searched result
			String mc = "//td[text()='" + title1 + "']";
			driver.findElement(By.xpath(mc)).click();
			consoleMessage("Clicked on the searched result.");

			// VALIDATE FOR PROPERTY ONE
			title("VALIDATE FOR PROPERTY ONE");

			// validate the property name
			switchVerification("navigation_header_propertyname1_XPATH", "[DND] AAAA Risk Test Prop 01 - 01",
					"The property name is not displayed.");

			// validate the task title of the Mortgage Undertakings
			try {
				String title = driver
						.findElement(By.cssSelector(OR.getProperty("propertyproject_mu_repair_titletxt_CSS")))
						.getAttribute("value");

				if (title.equals(repairTitle1)) {
					successMessage("The task title of the Mortgage Undertakings is displayed correctly.");
				} else {
					verificationFailedMessage(
							"The task title of the Mortgage Undertakings is not displayed correctly.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The task title of the Mortgage Undertakings is not displayed correctly.");
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
				// scroll down till Projects Overview card
				scrollTillElement("propertyprojectdashboard_mortgageundertakingcard_XPATH");

				// validate the Projects Overview card
				boolean projectCard = driver
						.findElement(By.xpath(OR.getProperty("propertyprojectdashboard_mortgageundertakingcard_XPATH")))
						.isDisplayed();

				if (projectCard == true) {
					successMessage("The Projects Overview card is displayed correctly.");
				} else {
					verificationFailedMessage("The Projects Overview card is not displayed correctly.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The Projects Overview card is not displayed correctly.");
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
				// scroll down till Projects Overview card
				scrollTillElement("propertyprojectdashboard_mortgageundertakingcard_XPATH");

				// validate the Projects Overview card
				boolean projectCard = driver
						.findElement(By.xpath(OR.getProperty("propertyprojectdashboard_mortgageundertakingcard_XPATH")))
						.isDisplayed();

				if (projectCard == true) {
					successMessage("The Projects Overview card is displayed correctly.");
				} else {
					verificationFailedMessage("The Projects Overview card is not displayed correctly.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The Projects Overview card is not displayed correctly.");
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
				// scroll down till Projects Overview card
				scrollTillElement("propertyprojectdashboard_mortgageundertakingcard_XPATH");

				// validate the Projects Overview card
				boolean projectCard = driver
						.findElement(By.xpath(OR.getProperty("propertyprojectdashboard_mortgageundertakingcard_XPATH")))
						.isDisplayed();

				if (projectCard == true) {
					successMessage("The Projects Overview card is displayed correctly.");
				} else {
					verificationFailedMessage("The Projects Overview card is not displayed correctly.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The Projects Overview card is not displayed correctly.");
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
		// THE CAPEX PROJECT REPAIRS DASHBOARD SCREEN
		title("VALIDATE THE NAVIGATION AFTER SWITCHING THE PROPERTY FROM THE HEADER OF THE CAPEX PROJECT REPAIRS DASHBOARD SCREEN");

		try {

			// wait for the element
			Thread.sleep(5000);

			// click on the side menu
			click("menubtn_CSS");

			// wait for the element
			Thread.sleep(5000);

			// click on the property project side menu
			click("sidemenu_propertyprojects_XPATH");

			// select the option from the dashboard dropdown
			select("dashboard_CSS", "CAPEX Project Repairs");

			// VALIDATE FOR PROPERTY ONE
			title("VALIDATE FOR PROPERTY ONE");

			// validate the CAPEX Project Repairs title
			switchVerification("propertyprojectdashboard_capexprojectrepairstitle_XPATH", "CAPEX Project Repairs",
					"The CAPEX Project Repairs title is not displayed.");

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
				// scroll down till Projects Overview card
				scrollTillElement("propertyprojectdashboard_mortgageundertakingcard_XPATH");

				// validate the Projects Overview card
				boolean projectCard = driver
						.findElement(By.xpath(OR.getProperty("propertyprojectdashboard_mortgageundertakingcard_XPATH")))
						.isDisplayed();

				if (projectCard == true) {
					successMessage("The Projects Overview card is displayed correctly.");
				} else {
					verificationFailedMessage("The Projects Overview card is not displayed correctly.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The Projects Overview card is not displayed correctly.");
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
				// scroll down till Projects Overview card
				scrollTillElement("propertyprojectdashboard_mortgageundertakingcard_XPATH");

				// validate the Projects Overview card
				boolean projectCard = driver
						.findElement(By.xpath(OR.getProperty("propertyprojectdashboard_mortgageundertakingcard_XPATH")))
						.isDisplayed();

				if (projectCard == true) {
					successMessage("The Projects Overview card is displayed correctly.");
				} else {
					verificationFailedMessage("The Projects Overview card is not displayed correctly.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The Projects Overview card is not displayed correctly.");
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
				// scroll down till Projects Overview card
				scrollTillElement("propertyprojectdashboard_mortgageundertakingcard_XPATH");

				// validate the Projects Overview card
				boolean projectCard = driver
						.findElement(By.xpath(OR.getProperty("propertyprojectdashboard_mortgageundertakingcard_XPATH")))
						.isDisplayed();

				if (projectCard == true) {
					successMessage("The Projects Overview card is displayed correctly.");
				} else {
					verificationFailedMessage("The Projects Overview card is not displayed correctly.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The Projects Overview card is not displayed correctly.");
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
		// THE TASK SCREEN OF THE CAPEX PROJECT DASHBOARD SCREEN
		title("VALIDATE THE NAVIGATION AFTER SWITCHING THE PROPERTY FROM THE HEADER OF THE TASK SCREEN OF THE CAPEX PROJECT DASHBOARD SCREEN");

		try {

			// wait for the element
			Thread.sleep(5000);

			// click on the side menu
			click("menubtn_CSS");

			// wait for the element
			Thread.sleep(5000);

			// click on the property project side menu
			click("sidemenu_propertyprojects_XPATH");

			// select the option from the dashboard dropdown
			select("dashboard_CSS", "CAPEX Project Repairs");

			// enter the newly created CAPEX Projects in the search field
			type("propertyprojectdashboard_searchtxt_XPATH", title2);

			// click on the searched result
			String cp = "//td[text()='" + title2 + "']";
			driver.findElement(By.xpath(cp)).click();
			consoleMessage("Clicked on the searched result.");

			// VALIDATE FOR PROPERTY ONE
			title("VALIDATE FOR PROPERTY ONE");

			// validate the property name
			switchVerification("navigation_header_propertyname1_XPATH", "[DND] AAAA Risk Test Prop 01 - 01",
					"The property name is not displayed.");

			// validate the task of the CAPEX Projects
			try {
				String title = driver
						.findElement(By.cssSelector(OR.getProperty("propertyproject_mu_repair_titletxt_CSS")))
						.getAttribute("value");

				if (title.equals(repairTitle2)) {
					successMessage("The task of the CAPEX Projects is displayed correctly.");
				} else {
					verificationFailedMessage("The task of the CAPEX Projects is not displayed correctly.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The task of the CAPEX Projects is not displayed correctly.");
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
				// scroll down till Projects Overview card
				scrollTillElement("propertyprojectdashboard_mortgageundertakingcard_XPATH");

				// validate the Projects Overview card
				boolean projectCard = driver
						.findElement(By.xpath(OR.getProperty("propertyprojectdashboard_mortgageundertakingcard_XPATH")))
						.isDisplayed();

				if (projectCard == true) {
					successMessage("The Projects Overview card is displayed correctly.");
				} else {
					verificationFailedMessage("The Projects Overview card is not displayed correctly.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The Projects Overview card is not displayed correctly.");
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
				// scroll down till Projects Overview card
				scrollTillElement("propertyprojectdashboard_mortgageundertakingcard_XPATH");

				// validate the Projects Overview card
				boolean projectCard = driver
						.findElement(By.xpath(OR.getProperty("propertyprojectdashboard_mortgageundertakingcard_XPATH")))
						.isDisplayed();

				if (projectCard == true) {
					successMessage("The Projects Overview card is displayed correctly.");
				} else {
					verificationFailedMessage("The Projects Overview card is not displayed correctly.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The Projects Overview card is not displayed correctly.");
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
				// scroll down till Projects Overview card
				scrollTillElement("propertyprojectdashboard_mortgageundertakingcard_XPATH");

				// validate the Projects Overview card
				boolean projectCard = driver
						.findElement(By.xpath(OR.getProperty("propertyprojectdashboard_mortgageundertakingcard_XPATH")))
						.isDisplayed();

				if (projectCard == true) {
					successMessage("The Projects Overview card is displayed correctly.");
				} else {
					verificationFailedMessage("The Projects Overview card is not displayed correctly.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The Projects Overview card is not displayed correctly.");
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
		// THE MUNICIPAL ORDERS DASHBOARD SCREEN
		title("VALIDATE THE NAVIGATION AFTER SWITCHING THE PROPERTY FROM THE HEADER OF THE MUNICIPAL ORDERS DASHBOARD SCREEN");

		try {

			// wait for the element
			Thread.sleep(5000);

			// click on the side menu
			click("menubtn_CSS");

			// wait for the element
			Thread.sleep(5000);

			// click on the property project side menu
			click("sidemenu_propertyprojects_XPATH");

			// select the option from the dashboard dropdown
			select("dashboard_CSS", "Municipal Order Repairs");

			// VALIDATE FOR PROPERTY ONE
			title("VALIDATE FOR PROPERTY ONE");

			// validate the Municipal Order Repairs title
			switchVerification("propertyprojectdashboard_municipalordersrepairstitle_XPATH", "Municipal Order Repairs",
					"The Municipal Order Repairs title is not displayed.");

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
				// scroll down till Projects Overview card
				scrollTillElement("propertyprojectdashboard_mortgageundertakingcard_XPATH");

				// validate the Projects Overview card
				boolean projectCard = driver
						.findElement(By.xpath(OR.getProperty("propertyprojectdashboard_mortgageundertakingcard_XPATH")))
						.isDisplayed();

				if (projectCard == true) {
					successMessage("The Projects Overview card is displayed correctly.");
				} else {
					verificationFailedMessage("The Projects Overview card is not displayed correctly.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The Projects Overview card is not displayed correctly.");
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
				// scroll down till Projects Overview card
				scrollTillElement("propertyprojectdashboard_mortgageundertakingcard_XPATH");

				// validate the Projects Overview card
				boolean projectCard = driver
						.findElement(By.xpath(OR.getProperty("propertyprojectdashboard_mortgageundertakingcard_XPATH")))
						.isDisplayed();

				if (projectCard == true) {
					successMessage("The Projects Overview card is displayed correctly.");
				} else {
					verificationFailedMessage("The Projects Overview card is not displayed correctly.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The Projects Overview card is not displayed correctly.");
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
				// scroll down till Projects Overview card
				scrollTillElement("propertyprojectdashboard_mortgageundertakingcard_XPATH");

				// validate the Projects Overview card
				boolean projectCard = driver
						.findElement(By.xpath(OR.getProperty("propertyprojectdashboard_mortgageundertakingcard_XPATH")))
						.isDisplayed();

				if (projectCard == true) {
					successMessage("The Projects Overview card is displayed correctly.");
				} else {
					verificationFailedMessage("The Projects Overview card is not displayed correctly.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The Projects Overview card is not displayed correctly.");
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
		// THE TASK SCREEN OF THE MUNICIPAL ORDERS DASHBOARD SCREEN
		title("VALIDATE THE NAVIGATION AFTER SWITCHING THE PROPERTY FROM THE HEADER OF THE TASK SCREEN OF THE MUNICIPAL ORDERS DASHBOARD SCREEN");

		try {

			// wait for the element
			Thread.sleep(5000);

			// click on the side menu
			click("menubtn_CSS");

			// wait for the element
			Thread.sleep(5000);

			// click on the property project side menu
			click("sidemenu_propertyprojects_XPATH");

			// select the option from the dashboard dropdown
			select("dashboard_CSS", "Municipal Order Repairs");

			// enter the newly created Municipal Orders in the search field
			type("propertyprojectdashboard_searchtxt_XPATH", title3);

			// click on the searched result
			String mo = "//td[text()='" + title3 + "']";
			driver.findElement(By.xpath(mo)).click();
			consoleMessage("Clicked on the searched result.");

			// VALIDATE FOR PROPERTY ONE
			title("VALIDATE FOR PROPERTY ONE");

			// validate the property name
			switchVerification("navigation_header_propertyname1_XPATH", "[DND] AAAA Risk Test Prop 01 - 01",
					"The property name is not displayed.");

			// validate the task of the Municipal Orders
			try {
				String title = driver
						.findElement(By.cssSelector(OR.getProperty("propertyproject_mu_repair_titletxt_CSS")))
						.getAttribute("value");

				if (title.equals(repairTitle3)) {
					successMessage("The task of the Municipal Orders is displayed correctly.");
				} else {
					verificationFailedMessage("The task of the Municipal Orders is not displayed correctly.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The task of the Municipal Orders is not displayed correctly.");
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
				// scroll down till Projects Overview card
				scrollTillElement("propertyprojectdashboard_mortgageundertakingcard_XPATH");

				// validate the Projects Overview card
				boolean projectCard = driver
						.findElement(By.xpath(OR.getProperty("propertyprojectdashboard_mortgageundertakingcard_XPATH")))
						.isDisplayed();

				if (projectCard == true) {
					successMessage("The Projects Overview card is displayed correctly.");
				} else {
					verificationFailedMessage("The Projects Overview card is not displayed correctly.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The Projects Overview card is not displayed correctly.");
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
				// scroll down till Projects Overview card
				scrollTillElement("propertyprojectdashboard_mortgageundertakingcard_XPATH");

				// validate the Projects Overview card
				boolean projectCard = driver
						.findElement(By.xpath(OR.getProperty("propertyprojectdashboard_mortgageundertakingcard_XPATH")))
						.isDisplayed();

				if (projectCard == true) {
					successMessage("The Projects Overview card is displayed correctly.");
				} else {
					verificationFailedMessage("The Projects Overview card is not displayed correctly.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The Projects Overview card is not displayed correctly.");
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
				// scroll down till Projects Overview card
				scrollTillElement("propertyprojectdashboard_mortgageundertakingcard_XPATH");

				// validate the Projects Overview card
				boolean projectCard = driver
						.findElement(By.xpath(OR.getProperty("propertyprojectdashboard_mortgageundertakingcard_XPATH")))
						.isDisplayed();

				if (projectCard == true) {
					successMessage("The Projects Overview card is displayed correctly.");
				} else {
					verificationFailedMessage("The Projects Overview card is not displayed correctly.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The Projects Overview card is not displayed correctly.");
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

	}

}
