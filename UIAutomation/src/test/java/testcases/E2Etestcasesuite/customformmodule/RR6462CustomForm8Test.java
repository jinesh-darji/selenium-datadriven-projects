package testcases.E2Etestcasesuite.customformmodule;

import java.io.IOException;
import java.util.Hashtable;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import base.Helper;
import base.TestBase;
import utilities.TestUtil;

public class RR6462CustomForm8Test extends TestBase {

	@Test(dataProviderClass = TestUtil.class, dataProvider = "dp")
	public void rR6462CustomForm8Test(Hashtable<String, String> data) throws IOException, InterruptedException {

		execution(data, "rR6462CustomForm8Test");

		// VALIDATE THE 'USER TO ADD RECORD' AND 'ROLE TO ADD RECORD' PERMISSIONS OF THE
		// CUSTOM FORMS - CORPORATE LEVEL.

		title("VALIDATE THE 'USER TO ADD RECORD' AND 'ROLE TO ADD RECORD' PERMISSIONS OF THE CUSTOM FORMS - CORPORATE LEVEL.");

		Helper helper = new Helper();

		// refresh the page
		driver.navigate().refresh();
		Thread.sleep(5000);
		driver.navigate().refresh();

		String name = RandomStringUtils.randomAlphanumeric(8); // name of the custom form
		String fieldName1 = RandomStringUtils.randomAlphabetic(8); // Normal Field 1
		String pageName1 = RandomStringUtils.randomAlphabetic(8); // Page Name 1
		String pageFieldName1 = RandomStringUtils.randomAlphabetic(8); // Page Name 1 - Field 1

		// CREATE NEW CUSTOM FORMS FOR CORPORATE LEVEL
		title("CREATE NEW CUSTOM FORMS FOR CORPORATE LEVEL");

		try {

			// Wait for the element
			Thread.sleep(5000);

			// click on the settings icon from the top of the screen
			click("questionnaire_settingicon_CSS");

			// wait for the element
			explicitWaitClickable("questionnaire_administrationoption_XPATH");

			// click on the Administration option from the side menu
			click("questionnaire_administrationoption_XPATH");

			// click on the system tab
			click("questionnaire_systemtab_XPATH");

			// click on the custom form option
			click("customform_option_XPATH");

			// click on the add button
			click("customform_addbtn_XPATH");

			// enter name of the form in the name field
			type("customform_nametxt_XPATH", name);

			// click on the date sensitive checkbox
			click("customform_datesensitiveckbx_XPATH");

			// click on the Is Verification Workflow Enabled? checkbox
			click("customform_verificationckbx_XPATH");

			// click on the Is Corporate Form? checkbox
			click("customform_corporateformckbx_XPATH");

			// click on the save button
			click("customform_savebtn_XPATH");

			// wait for the element
			Thread.sleep(5000);

			// validate the Report Name details of the newly created report
			try {
				String Validation0 = "//td[text()='" + name + "']";
				String Validation0_actual = (driver.findElement(By.xpath(Validation0)).getText()).trim();

				if (Validation0_actual.equals(name)) {

					successMessage("The Report Name detail is displayed correctly.");

				} else {
					verificationFailedMessage("The Report Name detail is displayed correctly.");
				}

			} catch (Throwable t) {
				verificationFailedMessage("The Report Name detail is displayed correctly.");
			}

			// click on the newly created custom record record
			String nameTitle = "//td[text()='" + name + "']";
			driver.findElement(By.xpath(nameTitle)).click();
			consoleMessage("Clicked on the newly created custom record.");

			// click on the add field button
			click("customform_addfieldbtn_XPATH");

			// enter field name
			type("customform_addfield_nametxt_XPATH", fieldName1);

			// select the option from the type dropdown
			select("customform_addfield_typedd_XPATH", data.get("fieldtype_1"));

			// click on the display on list checkbox
			click("customform_addfield_displayonlistckbx_XPATH");

			// click on the unique identifier checkbox
			click("customform_addfield_uniqueidentifierckbx_XPATH");

			// wait for the element
			Thread.sleep(5000);

			// click on the add button
			click("customform_addfield_addbtn_XPATH");

			// wait for the element
			explicitWaitClickable("closetoastmsg_CSS");

			// click on the toaster close button
			click("closetoastmsg_CSS");

			// wait for the element
			Thread.sleep(5000);

			// validate the newly created field
			try {
				String field1 = "//span[text()='" + fieldName1 + "']";
				String field1_actual = (driver.findElement(By.xpath(field1)).getText()).trim();

				if (field1_actual.equals(fieldName1)) {
					successMessage("The newly created field is displayed successfully.");
				} else {
					verificationFailedMessage("The newly created field is not displayed.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The newly created field is not displayed.");
			}

			// wait for the element
			Thread.sleep(5000);

			// click on the add new page icon
			click("customform_portfoliodashboard_addnewpagebtn_XPATH");

			// enter the first page name name in the page name field
			type("customform_portfoliodashboard_pagenametxt_XPATH", pageName1);

			// wait for the element
			Thread.sleep(5000);

			// click on the add button
			click("customform_portfoliodashboard_pagename_addbtn_XPATH");

			// wait for the element
			Thread.sleep(5000);

			// validate the newly added page
			try {
				String page1 = "//span[contains(text(),'" + pageName1 + "')]";
				String page1_actual = (driver.findElement(By.xpath(page1)).getText()).trim();

				if (page1_actual.equals(pageName1)) {
					successMessage("The newly created page is displayed successfully.");
				} else {
					verificationFailedMessage("The newly created page is not displayed.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The newly created page is not displayed.");
			}

			// wait for the element
			Thread.sleep(5000);

			// click on the update button
			click("customform_updatebtn_XPATH");

			// wait for the element
			explicitWaitClickable("closetoastmsg_CSS");

			// click on the toaster close button
			click("closetoastmsg_CSS");

			// ADD FIELD IN THE PAGE
			title("ADD FIELD IN THE PAGE");

			// click on the first page name tab
			String page1 = "//span[contains(text(),'" + pageName1 + "')]";
			driver.findElement(By.xpath(page1)).click();
			consoleMessage("Clicked on the first page name tab.");

			// wait for the element
			Thread.sleep(5000);

			// click on the add field button
			click("customform_addfieldbtn_XPATH");

			// enter field name
			type("customform_addfield_nametxt_XPATH", pageFieldName1);

			// select the option from the type dropdown
			select("customform_addfield_typedd_XPATH", data.get("fieldtype_1"));

			// click on the display on list checkbox
			click("customform_addfield_displayonlistckbx_XPATH");

			// click on the unique identifier checkbox
			click("customform_addfield_uniqueidentifierckbx_XPATH");

			// wait for the element
			Thread.sleep(5000);

			// click on the add button
			click("customform_addfield_addbtn_XPATH");

			// wait for the element
			explicitWaitClickable("closetoastmsg_CSS");

			// click on the toaster close button
			click("closetoastmsg_CSS");

			// click on the first page name tab
			String page11 = "//span[contains(text(),'" + pageName1 + "')]";
			driver.findElement(By.xpath(page11)).click();
			consoleMessage("Clicked on the first page name tab.");

			// wait for the element
			Thread.sleep(5000);

			// validate the newly created field
			try {
				String field1 = "//span[text()='" + pageFieldName1 + "']";
				String field1_actual = (driver.findElement(By.xpath(field1)).getText()).trim();

				if (field1_actual.equals(pageFieldName1)) {
					successMessage("The newly created field is displayed successfully.");
				} else {
					verificationFailedMessage("The newly created field is not displayed.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The newly created field is not displayed.");
			}

			// wait for the element
			Thread.sleep(5000);

			// click on the update button
			click("customform_updatebtn_XPATH");

			// wait for the element
			explicitWaitClickable("closetoastmsg_CSS");

			// click on the toaster close button
			click("closetoastmsg_CSS");

			// ADD THE SECURITY PERMISSION OF ADD RECORD IN THE CUSTOMER FORM FOR THE JINESH
			// (PROPERTY MANAGER)
			title("ADD THE SECURITY PERMISSION OF ADD RECORD IN THE CUSTOMER FORM FOR THE JINESH (PROPERTY MANAGER)");

			// click on the security tab
			click("customform_securitytab_XPATH");

			// click on the User to Add record
			click("customform_securitytab_security7_XPATH");

			// click on the none button
			click("customform_securitytab_nonebtn_XPATH");

			// enter the user name in the search field
			type("customform_securitytab_searchtxt_XPATH", data.get("user1"));

			// click on the searched result
			click("customform_securitytab_searchedresult1_XPATH");

			// click on the User to Add record
			click("customform_securitytab_security7_XPATH");

			// click on the update button
			click("customform_updatebtn_XPATH");

			// wait for the element
			explicitWaitClickable("closetoastmsg_CSS");

			// click on the toaster close button
			click("closetoastmsg_CSS");

		} catch (Throwable t) {
			verificationFailed();
		}

		// click on the home icon from the top of the screen
		click("questionnaire_homeburgermenubtn_CSS");

		// wait for the element
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// VALIDATE THE ADD BUTTON OPTION OF THE CUSTOM REPORT IN THE
		// PROPERTY SUMMARY DASHBOARD - ADMIN USER
		title("VALIDATE THE ADD BUTTON OPTION OF THE CUSTOM REPORT IN THE PROPERTY SUMMARY DASHBOARD - ADMIN USER");

		try {

			// VALIDATE ON PROPERTY SUMMARY DASHBOARD
			consoleMessage("VALIDATE ON PROPERTY SUMMARY DASHBOARD");

			// wait for the element
			Thread.sleep(5000);

			// click on the property
			click("propertysummary_property1_XPATH");

			// scrolldown till Property Information section
			scrollTillElement("customform_portfoliodashboard_propertyinformationtitle_XPATH");

			// validate the add button is displayed in the newly created custom form from
			// the property summary dashboard screen
			try {
				String customForm1 = "//td[text()='" + name + "']";
				String customForm1_actual = (driver.findElement(By.xpath(customForm1)).getText()).trim();

				if (customForm1_actual.equals(name)) {

					// click on the newly created custom form
					String customFormName = "//td[text()='" + name + "']";
					driver.findElement(By.xpath(customFormName)).click();
					consoleMessage("Clicked on the newly created custom form.");

					// scroll down the screen
					scrollBottom();

					// validate the add button is displayed
					try {
						boolean addbtn1 = driver
								.findElement(By.xpath(OR.getProperty("customform_portfoliodashboard_addbtn_XPATH")))
								.isDisplayed();

						if (addbtn1 == true) {
							verificationFailedMessage("The add button is displayed without permission.");
						} else {
							successMessage("The add button is not displayed as expected.");
						}
					} catch (Throwable t) {
						successMessage("The add button is not displayed as expected.");
					}

				} else {
					verificationFailedMessage("The newly created custom form is not displayed");
				}

			} catch (Throwable t) {
				verificationFailedMessage("The newly created custom form is not displayed");
			}

			// click on the home icon from the top of the screen
			click("questionnaire_homeburgermenubtn_hide_CSS");

			// wait for the element
			explicitWait("propertylist_title_XPATH");

			// verify the property list
			switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

			// VALIDATE ON PORTFOLIO SUMMARY DASHBOARD
			consoleMessage("VALIDATE ON PORTFOLIO SUMMARY DASHBOARD");

			// wait for the element
			Thread.sleep(5000);

			// click on the side menu
			click("menubtn_CSS");

			// wait for the element
			Thread.sleep(5000);

			// click on the portfolio dashboard from side menu
			click("sidemenu_portfoliosummary_XPATH");

			// validate the add button is displayed in the newly created custom form from
			// the property summary dashboard screen
			try {

				// scrolldown till Property Information section
				scrollTillElement("customform_portfoliodashboard_propertyinformationtitle_XPATH");

				String customForm1 = "//td[text()='" + name + "']";
				String customForm1_actual = (driver.findElement(By.xpath(customForm1)).getText()).trim();

				if (customForm1_actual.equals(name)) {

					// click on the newly created custom form
					String customFormName = "//td[text()='" + name + "']";
					driver.findElement(By.xpath(customFormName)).click();
					consoleMessage("Clicked on the newly created custom form.");

					// scroll down the screen
					scrollBottom();

					// validate the add button is displayed
					try {
						boolean addbtn1 = driver
								.findElement(By.xpath(OR.getProperty("customform_portfoliodashboard_addbtn1_XPATH")))
								.isDisplayed();

						if (addbtn1 == true) {
							verificationFailedMessage("The add button is displayed without permission.");
						} else {
							successMessage("The add button is not displayed as expected.");
						}
					} catch (Throwable t) {
						successMessage("The add button is not displayed as expected.");
					}

				} else {
					verificationFailedMessage("The newly created custom form is not displayed");
				}

			} catch (Throwable t) {
				verificationFailedMessage("The newly created custom form is not displayed");
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

		// LOGOUT THE SESSION FROM THE ADMIN USER AND LOGIN TO PROPERTY MANAGER -
		// JINESH
		title("LOGOUT THE SESSION FROM THE ADMIN USER AND LOGIN TO PROPERTY MANAGER - JINESH");

		try {
			// wait for the element
			Thread.sleep(5000);

			// click on the settings icon from the top of the screen
			click("questionnaire_settingicon_userupdate_CSS");

			// wait for the element
			explicitWaitClickable("sidemenu_logout_CSS");

			// click on the logout option from the side menu
			click("sidemenu_logout_CSS");

			// login with valid credentials
			helper.loginAndUpdateSystemCompany(data, "username", "password", "system_company_1");

			// VALIDATE THE ADD BUTTON OF THE CUSTOM REPORT IN THE PROPERTY SUMMARY
			// DASHBOARD - PROPERTY MANAGER USER - JINESH

			title("VALIDATE THE ADD BUTTON OF THE CUSTOM REPORT IN THE PROPERTY SUMMARY DASHBOARD - PROPERTY MANAGER USER - JINESH");

			try {

				// VALIDATE ON PROPERTY SUMMARY DASHBOARD
				consoleMessage("VALIDATE ON PROPERTY SUMMARY DASHBOARD");

				// wait for the element
				Thread.sleep(5000);

				// click on the property
				click("propertysummary_property1_XPATH");

				// scrolldown till Property Information section
				scrollTillElement("customform_portfoliodashboard_propertyinformationtitle_XPATH");

				// validate the newly created custom form in the property summary dashboard
				// screen
				try {
					String customForm1 = "//td[text()='" + name + "']";
					String customForm1_actual = (driver.findElement(By.xpath(customForm1)).getText()).trim();

					if (customForm1_actual.equals(name)) {

						// click on the newly created custom form
						String customFormName = "//td[text()='" + name + "']";
						driver.findElement(By.xpath(customFormName)).click();
						consoleMessage("Clicked on the newly created custom form.");

						// scroll down the screen
						scrollBottom();

						// validate the add button is displayed in general tab
						try {
							boolean addbtn3 = driver
									.findElement(By.xpath(OR.getProperty("customform_portfoliodashboard_addbtn_XPATH")))
									.isDisplayed();

							if (addbtn3 == true) {
								successMessage("The add button is displayed as expected.");

							} else {
								verificationFailedMessage(
										"The add button is not displayed, However the permission is given.");
							}
						} catch (Throwable t) {
							verificationFailedMessage(
									"The add button is not displayed, However the permission is given.");
						}

					} else {
						verificationFailedMessage("The newly created custom form is not displayed");
					}

				} catch (Throwable t) {
					verificationFailedMessage("The newly created custom form is not displayed.");
				}

				// click on the home icon from the top of the screen
				click("questionnaire_homeburgermenubtn_hide_CSS");

				// wait for the element
				explicitWait("propertylist_title_XPATH");

				// verify the property list
				switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

				// VALIDATE ON PORTFOLIO SUMMARY DASHBOARD
				consoleMessage("VALIDATE ON PORTFOLIO SUMMARY DASHBOARD");

				// wait for the element
				Thread.sleep(5000);

				// click on the side menu
				click("menubtn_CSS");

				// wait for the element
				Thread.sleep(5000);

				// click on the portfolio dashboard from side menu
				click("sidemenu_portfoliosummary_XPATH");

				// validate the add button is displayed in the newly created custom form from
				// the property summary dashboard screen
				try {

					// scrolldown till Property Information section
					scrollTillElement("customform_portfoliodashboard_propertyinformationtitle_XPATH");

					String customForm1 = "//td[text()='" + name + "']";
					String customForm1_actual = (driver.findElement(By.xpath(customForm1)).getText()).trim();

					if (customForm1_actual.equals(name)) {

						// click on the newly created custom form
						String customFormName = "//td[text()='" + name + "']";
						driver.findElement(By.xpath(customFormName)).click();
						consoleMessage("Clicked on the newly created custom form.");

						// scroll down the screen
						scrollBottom();

						// validate the add button is displayed
						try {
							boolean addbtn1 = driver
									.findElement(
											By.xpath(OR.getProperty("customform_portfoliodashboard_addbtn1_XPATH")))
									.isDisplayed();

							if (addbtn1 == true) {
								successMessage("The add button is displayed as expected.");

							} else {
								verificationFailedMessage("The add button is not displayed.");
							}
						} catch (Throwable t) {
							verificationFailedMessage("The add button is not displayed.");
						}

					} else {
						verificationFailedMessage("The newly created custom form is not displayed");
					}

				} catch (Throwable t) {
					verificationFailedMessage("The newly created custom form is not displayed");
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

			// LOGOUT THE SESSION FROM THE PROPERTY MANAGER - JINESH USER AND LOGIN TO ADMIN
			// USER
			title("LOGOUT THE SESSION FROM THE PROPERTY MANAGER - JINESH USER AND LOGIN TO ADMIN USER");

			// wait for the element
			Thread.sleep(5000);

			// click on the settings icon from the top of the screen
			click("questionnaire_settingicon_CSS");

			// wait for the element
			Thread.sleep(5000);

			// click on the logout option from the side menu
			click("sidemenu_logout_CSS");

			// login with valid credentials
			helper.loginAndUpdateSystemCompany(data, "username_1", "password_1", "system_company_1");

		} catch (Throwable t) {
			helper.questionnaireNotDisplayLogout(data);
		}

		// UPDATE THE SECURITY PERMISSION OF CUSTOMER FORM FOR THE CONTRACTOR
		title("UPDATE THE SECURITY PERMISSION OF CUSTOMER FORM FOR THE CONTRACTOR");

		try {

			// Wait for the element
			Thread.sleep(5000);

			// click on the settings icon from the top of the screen
			click("questionnaire_settingicon_CSS");

			// wait for the element
			explicitWaitClickable("questionnaire_administrationoption_XPATH");

			// click on the Administration option from the side menu
			click("questionnaire_administrationoption_XPATH");

			// click on the system tab
			click("questionnaire_systemtab_XPATH");

			// click on the custom form option
			click("customform_option_XPATH");

			// wait for the element
			Thread.sleep(5000);

			// click on the newly created custom record record
			String nameTitle = "//td[text()='" + name + "']";
			driver.findElement(By.xpath(nameTitle)).click();
			consoleMessage("Clicked on the newly created custom record record.");

			// click on the security tab
			click("customform_securitytab_XPATH");

			// click on the User to Add record
			click("customform_securitytab_security7_XPATH");

			// click on the none button
			click("customform_securitytab_nonebtn_XPATH");

			// click on the User to Add record
			click("customform_securitytab_security7_XPATH");

			// click on the Role to Add record
			click("customform_securitytab_security8_XPATH");

			// click on the none button
			click("customform_securitytab_nonebtn_XPATH");

			// enter the user name in the search field
			type("customform_securitytab_searchtxt_XPATH", data.get("role1"));

			// click on the searched result
			click("customform_securitytab_searchedresult2_XPATH");

			// click on the Role to Add record
			click("customform_securitytab_security8_XPATH");

			// click on the update button
			click("customform_updatebtn_XPATH");

			// wait for the element
			explicitWaitClickable("closetoastmsg_CSS");

			// click on the toaster close button
			click("closetoastmsg_CSS");

		} catch (Throwable t) {
			verificationFailed();
		}

		// click on the home icon from the top of the screen
		click("questionnaire_homeburgermenubtn_CSS");

		// wait for the element
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// VALIDATE THE ADD BUTTON OF THE CUSTOM REPORT IN THE PROPERTY SUMMARY
		// DASHBOARD - ADMIN USER

		title("VALIDATE THE ADD BUTTON OF THE CUSTOM REPORT IN THE PROPERTY SUMMARY DASHBOARD - ADMIN USER");

		try {
			// VALIDATE ON PROPERTY SUMMARY DASHBOARD
			consoleMessage("VALIDATE ON PROPERTY SUMMARY DASHBOARD");

			// wait for the element
			Thread.sleep(5000);

			// click on the property
			click("propertysummary_property1_XPATH");

			// scrolldown till Property Information section
			scrollTillElement("customform_portfoliodashboard_propertyinformationtitle_XPATH");

			// validate the newly created custom form in the property summary dashboard
			// screen
			try {
				String customForm1 = "//td[text()='" + name + "']";
				String customForm1_actual = (driver.findElement(By.xpath(customForm1)).getText()).trim();

				if (customForm1_actual.equals(name)) {

					// click on the newly created custom form
					String customFormName = "//td[text()='" + name + "']";
					driver.findElement(By.xpath(customFormName)).click();
					consoleMessage("Clicked on the newly created custom form.");

					// scroll down the screen
					scrollBottom();

					// validate the add button is displayed in general tab
					try {
						boolean addbtn2 = driver
								.findElement(By.xpath(OR.getProperty("customform_portfoliodashboard_addbtn_XPATH")))
								.isDisplayed();
						if (addbtn2 == true) {
							verificationFailedMessage("The add button is displayed without permission.");
						} else {
							successMessage("The add button is not displayed as expected.");
						}
					} catch (Throwable t) {
						successMessage("The add button is not displayed as expected.");
					}

				} else {
					verificationFailedMessage("The newly created custom form is not displayed.");
				}

			} catch (Throwable t) {
				verificationFailedMessage("The newly created custom form is not displayed.");
			}

			// click on the home icon from the top of the screen
			click("questionnaire_homeburgermenubtn_hide_CSS");

			// wait for the element
			explicitWait("propertylist_title_XPATH");

			// verify the property list
			switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

			// VALIDATE ON PORTFOLIO SUMMARY DASHBOARD
			consoleMessage("VALIDATE ON PORTFOLIO SUMMARY DASHBOARD");

			// wait for the element
			Thread.sleep(5000);

			// click on the side menu
			click("menubtn_CSS");

			// wait for the element
			Thread.sleep(5000);

			// click on the portfolio dashboard from side menu
			click("sidemenu_portfoliosummary_XPATH");

			// validate the add button is displayed in the newly created custom form from
			// the property summary dashboard screen
			try {

				// scrolldown till Property Information section
				scrollTillElement("customform_portfoliodashboard_propertyinformationtitle_XPATH");

				String customForm1 = "//td[text()='" + name + "']";
				String customForm1_actual = (driver.findElement(By.xpath(customForm1)).getText()).trim();

				if (customForm1_actual.equals(name)) {

					// click on the newly created custom form
					String customFormName = "//td[text()='" + name + "']";
					driver.findElement(By.xpath(customFormName)).click();
					consoleMessage("Clicked on the newly created custom form.");

					// scroll down the screen
					scrollBottom();

					// validate the add button is displayed
					try {
						boolean addbtn1 = driver
								.findElement(By.xpath(OR.getProperty("customform_portfoliodashboard_addbtn1_XPATH")))
								.isDisplayed();

						if (addbtn1 == true) {
							verificationFailedMessage("The add button is displayed without permission.");
						} else {
							successMessage("The add button is not displayed as expected.");
						}
					} catch (Throwable t) {
						successMessage("The add button is not displayed as expected.");
					}

				} else {
					verificationFailedMessage("The newly created custom form is not displayed");
				}

			} catch (Throwable t) {
				verificationFailedMessage("The newly created custom form is not displayed");
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

		// LOGOUT THE SESSION FROM THE ADMIN USER AND LOGIN TO PROPERTY MANAGER -
		// JINESH
		title("LOGOUT THE SESSION FROM THE ADMIN USER AND LOGIN TO PROPERTY MANAGER - JINESH");

		try {
			// wait for the element
			Thread.sleep(5000);

			// click on the settings icon from the top of the screen
			click("questionnaire_settingicon_userupdate_CSS");

			// wait for the element
			explicitWaitClickable("sidemenu_logout_CSS");

			// click on the logout option from the side menu
			click("sidemenu_logout_CSS");

			// login with valid credentials
			helper.loginAndUpdateSystemCompany(data, "username", "password", "system_company_1");

			// VALIDATE THE ADD BUTTON OF THE CUSTOM REPORT IN THE PROPERTY SUMMARY
			// DASHBOARD - PROPERTY MANAGER USER - JINESH
			title("VALIDATE THE ADD BUTTON OF THE CUSTOM REPORT IN THE PROPERTY SUMMARY DASHBOARD - PROPERTY MANAGER USER - JINESH");

			try {

				// VALIDATE ON PROPERTY SUMMARY DASHBOARD
				consoleMessage("VALIDATE ON PROPERTY SUMMARY DASHBOARD");

				// wait for the element
				Thread.sleep(5000);

				// click on the property
				click("propertysummary_property1_XPATH");

				// scrolldown till Property Information section
				scrollTillElement("customform_portfoliodashboard_propertyinformationtitle_XPATH");

				// validate the newly created custom form in the property summary dashboard
				// screen
				try {
					String customForm1 = "//td[text()='" + name + "']";
					String customForm1_actual = (driver.findElement(By.xpath(customForm1)).getText()).trim();

					if (customForm1_actual.equals(name)) {

						// click on the newly created custom form
						String customFormName = "//td[text()='" + name + "']";
						driver.findElement(By.xpath(customFormName)).click();
						consoleMessage("Clicked on the newly created custom form.");

						// scroll down the screen
						scrollBottom();

						// validate the add button is displayed in general tab
						try {
							boolean addbtn2 = driver
									.findElement(By.xpath(OR.getProperty("customform_portfoliodashboard_addbtn_XPATH")))
									.isDisplayed();
							if (addbtn2 == true) {
								verificationFailedMessage("The add button is displayed without permission.");
							} else {
								successMessage("The add button is not displayed as expected.");
							}
						} catch (Throwable t) {
							successMessage("The add button is not displayed as expected.");
						}

					} else {
						verificationFailedMessage("The newly created custom form is not displayed.");
					}

					// click on the home icon from the top of the screen
					click("questionnaire_homeburgermenubtn_hide_CSS");

					// wait for the element
					explicitWait("propertylist_title_XPATH");

					// verify the property list
					switchVerification("propertylist_title_XPATH", "Property List",
							"The property list is not displayed.");

					// VALIDATE ON PORTFOLIO SUMMARY DASHBOARD
					consoleMessage("VALIDATE ON PORTFOLIO SUMMARY DASHBOARD");

					// wait for the element
					Thread.sleep(5000);

					// click on the side menu
					click("menubtn_CSS");

					// wait for the element
					Thread.sleep(5000);

					// click on the portfolio dashboard from side menu
					click("sidemenu_portfoliosummary_XPATH");

					// validate the add button is displayed in the newly created custom form from
					// the property summary dashboard screen
					try {

						// scrolldown till Property Information section
						scrollTillElement("customform_portfoliodashboard_propertyinformationtitle_XPATH");

						customForm1 = "//td[text()='" + name + "']";
						customForm1_actual = (driver.findElement(By.xpath(customForm1)).getText()).trim();

						if (customForm1_actual.equals(name)) {

							// click on the newly created custom form
							String customFormName = "//td[text()='" + name + "']";
							driver.findElement(By.xpath(customFormName)).click();
							consoleMessage("Clicked on the newly created custom form.");

							// scroll down the screen
							scrollBottom();

							// validate the add button is displayed
							try {
								boolean addbtn1 = driver
										.findElement(
												By.xpath(OR.getProperty("customform_portfoliodashboard_addbtn1_XPATH")))
										.isDisplayed();

								if (addbtn1 == true) {
									successMessage("The add button is displayed as expected.");

								} else {
									verificationFailedMessage("The add button is not displayed.");
								}
							} catch (Throwable t) {
								verificationFailedMessage("The add button is not displayed.");
							}

						} else {
							verificationFailedMessage("The newly created custom form is not displayed");
						}

					} catch (Throwable t) {
						verificationFailedMessage("The newly created custom form is not displayed");
					}

				} catch (Throwable t) {
					verificationFailedMessage("The newly created custom form is not displayed.");
				}

				// click on the home icon from the top of the screen
				click("questionnaire_homeburgermenubtn_hide_CSS");

				// wait for the element
				explicitWait("propertylist_title_XPATH");

				// verify the property list
				switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

				// VALIDATE ON PORTFOLIO SUMMARY DASHBOARD
				consoleMessage("VALIDATE ON PORTFOLIO SUMMARY DASHBOARD");

				// wait for the element
				Thread.sleep(5000);

				// click on the side menu
				click("menubtn_CSS");

				// wait for the element
				Thread.sleep(5000);

				// click on the portfolio dashboard from side menu
				click("sidemenu_portfoliosummary_XPATH");

				// validate the add button is displayed in the newly created custom form from
				// the property summary dashboard screen
				try {

					// scrolldown till Property Information section
					scrollTillElement("customform_portfoliodashboard_propertyinformationtitle_XPATH");

					String customForm1 = "//td[text()='" + name + "']";
					String customForm1_actual = (driver.findElement(By.xpath(customForm1)).getText()).trim();

					if (customForm1_actual.equals(name)) {

						// click on the newly created custom form
						String customFormName = "//td[text()='" + name + "']";
						driver.findElement(By.xpath(customFormName)).click();
						consoleMessage("Clicked on the newly created custom form.");

						// scroll down the screen
						scrollBottom();

						// validate the add button is displayed
						try {
							boolean addbtn1 = driver
									.findElement(
											By.xpath(OR.getProperty("customform_portfoliodashboard_addbtn1_XPATH")))
									.isDisplayed();

							if (addbtn1 == true) {
								verificationFailedMessage("The add button is displayed without permission.");
							} else {
								successMessage("The add button is not displayed as expected.");
							}
						} catch (Throwable t) {
							successMessage("The add button is not displayed as expected.");
						}

					} else {
						verificationFailedMessage("The newly created custom form is not displayed");
					}

				} catch (Throwable t) {
					verificationFailedMessage("The newly created custom form is not displayed");
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

			// LOGOUT THE SESSION FROM THE PROPERTY MANAGER - JINESH USER AND LOGIN TO ADMIN
			// USER
			title("LOGOUT THE SESSION FROM THE PROPERTY MANAGER - JINESH USER AND LOGIN TO ADMIN USER");

			// wait for the element
			Thread.sleep(5000);

			// click on the settings icon from the top of the screen
			click("questionnaire_settingicon_CSS");

			// wait for the element
			Thread.sleep(5000);

			// click on the logout option from the side menu
			click("sidemenu_logout_CSS");

			// login with valid credentials
			helper.loginAndUpdateSystemCompany(data, "username_1", "password_1", "system_company_1");

		} catch (Throwable t) {
			helper.questionnaireNotDisplayLogout(data);
		}

		// LOGOUT THE SESSION FROM THE ADMIN USER AND LOGIN TO CONTRACTOR -
		// JINESH CONTRACTOR
		title("LOGOUT THE SESSION FROM THE ADMIN USER AND LOGIN TO CONTRACTOR - JINESH CONTRACTOR");

		try {
			// wait for the element
			Thread.sleep(5000);

			// click on the settings icon from the top of the screen
			click("questionnaire_settingicon_userupdate_CSS");

			// wait for the element
			explicitWaitClickable("sidemenu_logout_CSS");

			// click on the logout option from the side menu
			click("sidemenu_logout_CSS");

			// login with valid credentials
			helper.loginAndUpdateSystemCompany(data, "username_2", "password_2", "system_company_1");

			// VALIDATE THE ADD BUTTON OF THE CUSTOM REPORT IN THE PROPERTY SUMMARY
			// DASHBOARD - CONTRACTOR USER - JINESH CONTRACTOR

			title("VALIDATE THE ADD BUTTON OF THE CUSTOM REPORT IN THE PROPERTY SUMMARY DASHBOARD - CONTRACTOR USER - JINESH CONTRACTOR");

			try {

				// VALIDATE ON PROPERTY SUMMARY DASHBOARD
				consoleMessage("VALIDATE ON PROPERTY SUMMARY DASHBOARD");

				// wait for the element
				Thread.sleep(5000);

				// click on the property
				click("propertysummary_property1_XPATH");

				// scrolldown till Property Information section
				scrollTillElement("customform_portfoliodashboard_propertyinformationtitle_XPATH");

				// validate the newly created custom form in the property summary dashboard
				// screen
				try {
					String customForm1 = "//td[text()='" + name + "']";
					String customForm1_actual = (driver.findElement(By.xpath(customForm1)).getText()).trim();

					if (customForm1_actual.equals(name)) {

						// click on the newly created custom form
						String customFormName = "//td[text()='" + name + "']";
						driver.findElement(By.xpath(customFormName)).click();

						// scroll down the screen
						scrollBottom();

						// validate the add button is displayed in general tab
						try {
							boolean addbtn3 = driver
									.findElement(By.xpath(OR.getProperty("customform_portfoliodashboard_addbtn_XPATH")))
									.isDisplayed();

							if (addbtn3 == true) {
								successMessage("The add button is displayed as expected.");
							} else {
								verificationFailedMessage(
										"The add button is not displayed, However the permission is given.");
							}
						} catch (Throwable t) {
							verificationFailedMessage(
									"The add button is not displayed, However the permission is given.");
						}

					} else {
						verificationFailedMessage("The newly created custom form is not displayed.");
					}

				} catch (Throwable t) {
					verificationFailedMessage("The newly created custom form is not displayed.");
				}

				// click on the home icon from the top of the screen
				click("questionnaire_homeburgermenubtn_hide_CSS");

				// wait for the element
				explicitWait("propertylist_title_XPATH");

				// verify the property list
				switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

				// VALIDATE ON PORTFOLIO SUMMARY DASHBOARD
				consoleMessage("VALIDATE ON PORTFOLIO SUMMARY DASHBOARD");

				// wait for the element
				Thread.sleep(5000);

				// click on the side menu
				click("menubtn_CSS");

				// wait for the element
				Thread.sleep(5000);

				// click on the portfolio dashboard from side menu
				click("sidemenu_portfoliosummary_XPATH");

				// validate the add button is displayed in the newly created custom form from
				// the property summary dashboard screen
				try {

					// scrolldown till Property Information section
					scrollTillElement("customform_portfoliodashboard_propertyinformationtitle_XPATH");

					String customForm1 = "//td[text()='" + name + "']";
					String customForm1_actual = (driver.findElement(By.xpath(customForm1)).getText()).trim();

					if (customForm1_actual.equals(name)) {

						// click on the newly created custom form
						String customFormName = "//td[text()='" + name + "']";
						driver.findElement(By.xpath(customFormName)).click();
						consoleMessage("Clicked on the newly created custom form.");

						// scroll down the screen
						scrollBottom();

						// validate the add button is displayed
						try {
							boolean addbtn1 = driver
									.findElement(
											By.xpath(OR.getProperty("customform_portfoliodashboard_addbtn1_XPATH")))
									.isDisplayed();

							if (addbtn1 == true) {
								verificationFailedMessage("The add button is displayed without permission.");
							} else {
								successMessage("The add button is not displayed as expected.");
							}
						} catch (Throwable t) {
							successMessage("The add button is not displayed as expected.");
						}

					} else {
						verificationFailedMessage("The newly created custom form is not displayed");
					}

				} catch (Throwable t) {
					verificationFailedMessage("The newly created custom form is not displayed");
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

			// LOGOUT THE SESSION FROM THE CONTRACTOR - JINESH CONTRACTOR USER AND LOGIN TO
			// ADMIN USER
			title("LOGOUT THE SESSION FROM THE CONTRACTOR - JINESH CONTRACTOR USER AND LOGIN TO ADMIN USER");

			// wait for the element
			Thread.sleep(5000);

			// click on the settings icon from the top of the screen
			click("questionnaire_settingicon_CSS");

			// wait for the element
			Thread.sleep(5000);

			// click on the logout option from the side menu
			click("sidemenu_logout_CSS");

			// login with valid credentials
			helper.loginAndUpdateSystemCompany(data, "username_1", "password_1", "system_company_1");

		} catch (Throwable t) {
			helper.questionnaireNotDisplayLogout(data);
		}

		// UPDATE THE SECURITY PERMISSION OF CUSTOMER FORM FOR THE JINESH (PROPERTY
		// MANAGER) AND CONTRACTOR
		title("UPDATE THE SECURITY PERMISSION OF CUSTOMER FORM FOR THE JINESH (PROPERTY MANAGER) AND CONTRACTOR");

		try {

			// Wait for the element
			Thread.sleep(5000);

			// click on the settings icon from the top of the screen
			click("questionnaire_settingicon_CSS");

			// wait for the element
			explicitWaitClickable("questionnaire_administrationoption_XPATH");

			// click on the Administration option from the side menu
			click("questionnaire_administrationoption_XPATH");

			// click on the system tab
			click("questionnaire_systemtab_XPATH");

			// click on the custom form option
			click("customform_option_XPATH");

			// wait for the element
			Thread.sleep(5000);

			// click on the newly created custom record record
			String nameTitle = "//td[text()='" + name + "']";
			driver.findElement(By.xpath(nameTitle)).click();
			consoleMessage("Clicked on the newly created custom record record.");

			// click on the security tab
			click("customform_securitytab_XPATH");

			// click on the User to Add record
			click("customform_securitytab_security7_XPATH");

			// click on the none button
			click("customform_securitytab_nonebtn_XPATH");

			// enter the user name in the search field
			type("customform_securitytab_searchtxt_XPATH", data.get("user1"));

			// click on the searched result
			click("customform_securitytab_searchedresult1_XPATH");

			// click on the User to Add record
			click("customform_securitytab_security7_XPATH");

			// click on the Role to Add record
			click("customform_securitytab_security8_XPATH");

			// click on the none button
			click("customform_securitytab_nonebtn_XPATH");

			// enter the user name in the search field
			type("customform_securitytab_searchtxt_XPATH", data.get("role1"));

			// click on the searched result
			click("customform_securitytab_searchedresult2_XPATH");

			// click on the Role to Add record
			click("customform_securitytab_security8_XPATH");

			// click on the update button
			click("customform_updatebtn_XPATH");

			// wait for the element
			explicitWaitClickable("closetoastmsg_CSS");

			// click on the toaster close button
			click("closetoastmsg_CSS");

		} catch (Throwable t) {
			verificationFailed();
		}

		// click on the home icon from the top of the screen
		click("questionnaire_homeburgermenubtn_CSS");

		// wait for the element
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// VALIDATE THE ADD BUTTON OF THE CUSTOM REPORT IN THE PROPERTY SUMMARY
		// DASHBOARD - ADMIN USER

		title("VALIDATE THE ADD BUTTON OF THE CUSTOM REPORT IN THE PROPERTY SUMMARY DASHBOARD - ADMIN USER");

		try {

			// VALIDATE ON PROPERTY SUMMARY DASHBOARD
			consoleMessage("VALIDATE ON PROPERTY SUMMARY DASHBOARD");

			// wait for the element
			Thread.sleep(5000);

			// click on the property
			click("propertysummary_property1_XPATH");

			// scrolldown till Property Information section
			scrollTillElement("customform_portfoliodashboard_propertyinformationtitle_XPATH");

			// validate the newly created custom form in the property summary dashboard
			// screen
			try {
				String customForm1 = "//td[text()='" + name + "']";
				String customForm1_actual = (driver.findElement(By.xpath(customForm1)).getText()).trim();

				if (customForm1_actual.equals(name)) {

					// click on the newly created custom form
					String customFormName = "//td[text()='" + name + "']";
					driver.findElement(By.xpath(customFormName)).click();
					consoleMessage("Clicked on the newly created custom form.");

					// scroll down the screen
					scrollBottom();

					// validate the add button is displayed in general tab
					try {
						boolean addbtn2 = driver
								.findElement(By.xpath(OR.getProperty("customform_portfoliodashboard_addbtn_XPATH")))
								.isDisplayed();
						if (addbtn2 == true) {
							verificationFailedMessage("The add button is displayed without permission.");
						} else {
							successMessage("The add button is not displayed as expected.");
						}
					} catch (Throwable t) {
						successMessage("The add button is not displayed as expected.");
					}

				} else {
					verificationFailedMessage("The newly created custom form is not displayed.");
				}

			} catch (Throwable t) {
				verificationFailedMessage("The newly created custom form is not displayed.");
			}

			// click on the home icon from the top of the screen
			click("questionnaire_homeburgermenubtn_hide_CSS");

			// wait for the element
			explicitWait("propertylist_title_XPATH");

			// verify the property list
			switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

			// VALIDATE ON PORTFOLIO SUMMARY DASHBOARD
			consoleMessage("VALIDATE ON PORTFOLIO SUMMARY DASHBOARD");

			// wait for the element
			Thread.sleep(5000);

			// click on the side menu
			click("menubtn_CSS");

			// wait for the element
			Thread.sleep(5000);

			// click on the portfolio dashboard from side menu
			click("sidemenu_portfoliosummary_XPATH");

			// validate the add button is displayed in the newly created custom form from
			// the property summary dashboard screen
			try {

				// scrolldown till Property Information section
				scrollTillElement("customform_portfoliodashboard_propertyinformationtitle_XPATH");

				String customForm1 = "//td[text()='" + name + "']";
				String customForm1_actual = (driver.findElement(By.xpath(customForm1)).getText()).trim();

				if (customForm1_actual.equals(name)) {

					// click on the newly created custom form
					String customFormName = "//td[text()='" + name + "']";
					driver.findElement(By.xpath(customFormName)).click();
					consoleMessage("Clicked on the newly created custom form.");

					// scroll down the screen
					scrollBottom();

					// validate the add button is displayed
					try {
						boolean addbtn1 = driver
								.findElement(By.xpath(OR.getProperty("customform_portfoliodashboard_addbtn1_XPATH")))
								.isDisplayed();

						if (addbtn1 == true) {
							verificationFailedMessage("The add button is displayed without permission.");
						} else {
							successMessage("The add button is not displayed as expected.");
						}
					} catch (Throwable t) {
						successMessage("The add button is not displayed as expected.");
					}

				} else {
					verificationFailedMessage("The newly created custom form is not displayed");
				}

			} catch (Throwable t) {
				verificationFailedMessage("The newly created custom form is not displayed");
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

		// LOGOUT THE SESSION FROM THE ADMIN USER AND LOGIN TO PROPERTY MANAGER -
		// JINESH
		title("LOGOUT THE SESSION FROM THE ADMIN USER AND LOGIN TO PROPERTY MANAGER - JINESH");

		try {
			// wait for the element
			Thread.sleep(5000);

			// click on the settings icon from the top of the screen
			click("questionnaire_settingicon_userupdate_CSS");

			// wait for the element
			explicitWaitClickable("sidemenu_logout_CSS");

			// click on the logout option from the side menu
			click("sidemenu_logout_CSS");

			// login with valid credentials
			helper.loginAndUpdateSystemCompany(data, "username", "password", "system_company_1");

			// VALIDATE THE ADD BUTTON OF THE CUSTOM REPORT IN THE PROPERTY SUMMARY
			// DASHBOARD - PROPERTY MANAGER USER - JINESH

			title("VALIDATE THE ADD BUTTON OF THE CUSTOM REPORT IN THE PROPERTY SUMMARY DASHBOARD - PROPERTY MANAGER USER - JINESH");

			try {
				// VALIDATE ON PROPERTY SUMMARY DASHBOARD
				consoleMessage("VALIDATE ON PROPERTY SUMMARY DASHBOARD");

				// wait for the element
				Thread.sleep(5000);

				// click on the property
				click("propertysummary_property1_XPATH");

				// scrolldown till Property Information section
				scrollTillElement("customform_portfoliodashboard_propertyinformationtitle_XPATH");

				// validate the newly created custom form in the property summary dashboard
				// screen
				try {
					String customForm1 = "//td[text()='" + name + "']";
					String customForm1_actual = (driver.findElement(By.xpath(customForm1)).getText()).trim();

					if (customForm1_actual.equals(name)) {

						// click on the newly created custom form
						String customFormName = "//td[text()='" + name + "']";
						driver.findElement(By.xpath(customFormName)).click();
						consoleMessage("Clicked on the newly created custom form.");

					} else {
						verificationFailedMessage("The newly created custom form is not displayed.");
					}

				} catch (Throwable t) {
					verificationFailedMessage("The newly created custom form is not displayed.");
				}

				// click on the home icon from the top of the screen
				click("questionnaire_homeburgermenubtn_hide_CSS");

				// wait for the element
				explicitWait("propertylist_title_XPATH");

				// verify the property list
				switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

				// VALIDATE ON PORTFOLIO SUMMARY DASHBOARD
				consoleMessage("VALIDATE ON PORTFOLIO SUMMARY DASHBOARD");

				// wait for the element
				Thread.sleep(5000);

				// click on the side menu
				click("menubtn_CSS");

				// wait for the element
				Thread.sleep(5000);

				// click on the portfolio dashboard from side menu
				click("sidemenu_portfoliosummary_XPATH");

				// validate the add button is displayed in the newly created custom form from
				// the property summary dashboard screen
				try {

					// scrolldown till Property Information section
					scrollTillElement("customform_portfoliodashboard_propertyinformationtitle_XPATH");

					String customForm1 = "//td[text()='" + name + "']";
					String customForm1_actual = (driver.findElement(By.xpath(customForm1)).getText()).trim();

					if (customForm1_actual.equals(name)) {

						// click on the newly created custom form
						String customFormName = "//td[text()='" + name + "']";
						driver.findElement(By.xpath(customFormName)).click();
						consoleMessage("Clicked on the newly created custom form.");

						// scroll down the screen
						scrollBottom();

						// validate the add button is displayed
						try {
							boolean addbtn1 = driver
									.findElement(
											By.xpath(OR.getProperty("customform_portfoliodashboard_addbtn1_XPATH")))
									.isDisplayed();

							if (addbtn1 == true) {
								verificationFailedMessage("The add button is displayed without permission.");
							} else {
								successMessage("The add button is not displayed as expected.");
							}
						} catch (Throwable t) {
							successMessage("The add button is not displayed as expected.");
						}

					} else {
						verificationFailedMessage("The newly created custom form is not displayed");
					}

				} catch (Throwable t) {
					verificationFailedMessage("The newly created custom form is not displayed");
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

			// LOGOUT THE SESSION FROM THE PROPERTY MANAGER - JINESH USER AND LOGIN TO ADMIN
			// USER
			title("LOGOUT THE SESSION FROM THE PROPERTY MANAGER - JINESH USER AND LOGIN TO ADMIN USER");

			// wait for the element
			Thread.sleep(5000);

			// click on the settings icon from the top of the screen
			click("questionnaire_settingicon_CSS");

			// wait for the element
			Thread.sleep(5000);

			// click on the logout option from the side menu
			click("sidemenu_logout_CSS");

			// login with valid credentials
			helper.loginAndUpdateSystemCompany(data, "username_1", "password_1", "system_company_1");

		} catch (Throwable t) {
			helper.questionnaireNotDisplayLogout(data);
		}

		// LOGOUT THE SESSION FROM THE ADMIN USER AND LOGIN TO CONTRACTOR -
		// JINESH CONTRACTOR
		title("LOGOUT THE SESSION FROM THE ADMIN USER AND LOGIN TO CONTRACTOR - JINESH CONTRACTOR");

		try {
			// wait for the element
			Thread.sleep(5000);

			// click on the settings icon from the top of the screen
			click("questionnaire_settingicon_userupdate_CSS");

			// wait for the element
			explicitWaitClickable("sidemenu_logout_CSS");

			// click on the logout option from the side menu
			click("sidemenu_logout_CSS");

			// login with valid credentials
			helper.loginAndUpdateSystemCompany(data, "username_2", "password_2", "system_company_1");

			// VALIDATE THE ADD BUTTON OF THE CUSTOM REPORT IN THE PROPERTY SUMMARY
			// DASHBOARD - CONTRACTOR USER - JINESH CONTRACTOR

			title("VALIDATE THE ADD BUTTON OF THE CUSTOM REPORT IN THE PROPERTY SUMMARY DASHBOARD - CONTRACTOR USER - JINESH CONTRACTOR");

			try {

				// VALIDATE ON PROPERTY SUMMARY DASHBOARD
				consoleMessage("VALIDATE ON PROPERTY SUMMARY DASHBOARD");

				// wait for the element
				Thread.sleep(5000);

				// click on the property
				click("propertysummary_property1_XPATH");

				// scrolldown till Property Information section
				scrollTillElement("customform_portfoliodashboard_propertyinformationtitle_XPATH");

				// validate the newly created custom form in the property summary dashboard
				// screen
				try {
					String customForm1 = "//td[text()='" + name + "']";
					String customForm1_actual = (driver.findElement(By.xpath(customForm1)).getText()).trim();

					if (customForm1_actual.equals(name)) {

						// click on the newly created custom form
						String customFormName = "//td[text()='" + name + "']";
						driver.findElement(By.xpath(customFormName)).click();
						consoleMessage("Clicked on the newly created custom form");

					} else {
						verificationFailedMessage("The newly created custom form is not displayed.");
					}

				} catch (Throwable t) {
					verificationFailedMessage("The newly created custom form is not displayed.");
				}

				// click on the home icon from the top of the screen
				click("questionnaire_homeburgermenubtn_hide_CSS");

				// wait for the element
				explicitWait("propertylist_title_XPATH");

				// verify the property list
				switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

				// VALIDATE ON PORTFOLIO SUMMARY DASHBOARD
				consoleMessage("VALIDATE ON PORTFOLIO SUMMARY DASHBOARD");

				// wait for the element
				Thread.sleep(5000);

				// click on the side menu
				click("menubtn_CSS");

				// wait for the element
				Thread.sleep(5000);

				// click on the portfolio dashboard from side menu
				click("sidemenu_portfoliosummary_XPATH");

				// validate the add button is displayed in the newly created custom form from
				// the property summary dashboard screen
				try {

					// scrolldown till Property Information section
					scrollTillElement("customform_portfoliodashboard_propertyinformationtitle_XPATH");

					String customForm1 = "//td[text()='" + name + "']";
					String customForm1_actual = (driver.findElement(By.xpath(customForm1)).getText()).trim();

					if (customForm1_actual.equals(name)) {

						// click on the newly created custom form
						String customFormName = "//td[text()='" + name + "']";
						driver.findElement(By.xpath(customFormName)).click();
						consoleMessage("Clicked on the newly created custom form.");

						// scroll down the screen
						scrollBottom();

						// validate the add button is displayed
						try {
							boolean addbtn1 = driver
									.findElement(
											By.xpath(OR.getProperty("customform_portfoliodashboard_addbtn1_XPATH")))
									.isDisplayed();

							if (addbtn1 == true) {
								verificationFailedMessage("The add button is displayed without permission.");
							} else {
								successMessage("The add button is not displayed as expected.");
							}
						} catch (Throwable t) {
							successMessage("The add button is not displayed as expected.");
						}

					} else {
						verificationFailedMessage("The newly created custom form is not displayed");
					}

				} catch (Throwable t) {
					verificationFailedMessage("The newly created custom form is not displayed");
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

			// LOGOUT THE SESSION FROM THE CONTRACTOR - JINESH CONTRACTOR USER AND LOGIN TO
			// ADMIN USER
			title("LOGOUT THE SESSION FROM THE CONTRACTOR - JINESH CONTRACTOR USER AND LOGIN TO ADMIN USER");

			// wait for the element
			Thread.sleep(5000);

			// click on the settings icon from the top of the screen
			click("questionnaire_settingicon_CSS");

			// wait for the element
			Thread.sleep(5000);

			// click on the logout option from the side menu
			click("sidemenu_logout_CSS");

			// login with valid credentials
			helper.loginAndUpdateSystemCompany(data, "username_1", "password_1", "system_company_1");

		} catch (Throwable t) {
			helper.questionnaireNotDisplayLogout(data);
		}

		// LOGOUT THE SESSION FROM THE ADMIN USER AND LOGIN TO HR - JINESH HR
		title("LOGOUT THE SESSION FROM THE ADMIN USER AND LOGIN TO HR - JINESH HR");

		try {
			// wait for the element
			Thread.sleep(5000);

			// click on the settings icon from the top of the screen
			click("questionnaire_settingicon_userupdate_CSS");

			// wait for the element
			explicitWaitClickable("sidemenu_logout_CSS");

			// click on the logout option from the side menu
			click("sidemenu_logout_CSS");

			// login with valid credentials
			helper.loginAndUpdateSystemCompany(data, "username_3", "password_3", "system_company_1");

			// VALIDATE THE ADD BUTTON OF THE CUSTOM REPORT IN THE PROPERTY SUMMARY
			// DASHBOARD - HR USER - JINESH HR
			title("VALIDATE THE ADD BUTTON OF THE CUSTOM REPORT IN THE PROPERTY SUMMARY DASHBOARD - HR USER - JINESH HR");

			try {

				// VALIDATE ON PROPERTY SUMMARY DASHBOARD
				consoleMessage("VALIDATE ON PROPERTY SUMMARY DASHBOARD");

				// wait for the element
				Thread.sleep(5000);

				// click on the property
				click("propertysummary_property1_XPATH");

				// scrolldown till Property Information section
				scrollTillElement("customform_portfoliodashboard_propertyinformationtitle_XPATH");

				// validate the add button is displayed in the newly created custom form from
				// the property summary dashboard screen
				try {
					String customForm1 = "//td[text()='" + name + "']";
					String customForm1_actual = (driver.findElement(By.xpath(customForm1)).getText()).trim();

					if (customForm1_actual.equals(name)) {

						// click on the newly created custom form
						String customFormName = "//td[text()='" + name + "']";
						driver.findElement(By.xpath(customFormName)).click();
						consoleMessage("Clicked on the newly created custom form.");

						// scroll down the screen
						scrollBottom();

						// validate the add button is displayed
						try {
							boolean addbtn1 = driver
									.findElement(By.xpath(OR.getProperty("customform_portfoliodashboard_addbtn_XPATH")))
									.isDisplayed();

							if (addbtn1 == true) {
								verificationFailedMessage("The add button is displayed without permission.");
							} else {
								successMessage("The add button is not displayed as expected.");
							}
						} catch (Throwable t) {
							successMessage("The add button is not displayed as expected.");
						}

					} else {
						verificationFailedMessage("The newly created custom form is not displayed");
					}

				} catch (Throwable t) {
					verificationFailedMessage("The newly created custom form is not displayed");
				}

				// click on the home icon from the top of the screen
				click("questionnaire_homeburgermenubtn_hide_CSS");

				// wait for the element
				explicitWait("propertylist_title_XPATH");

				// verify the property list
				switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

				// VALIDATE ON PORTFOLIO SUMMARY DASHBOARD
				consoleMessage("VALIDATE ON PORTFOLIO SUMMARY DASHBOARD");

				// wait for the element
				Thread.sleep(5000);

				// click on the side menu
				click("menubtn_CSS");

				// wait for the element
				Thread.sleep(5000);

				// click on the portfolio dashboard from side menu
				click("sidemenu_portfoliosummary_XPATH");

				// validate the add button is displayed in the newly created custom form from
				// the property summary dashboard screen
				try {

					// scrolldown till Property Information section
					scrollTillElement("customform_portfoliodashboard_propertyinformationtitle_XPATH");

					String customForm1 = "//td[text()='" + name + "']";
					String customForm1_actual = (driver.findElement(By.xpath(customForm1)).getText()).trim();

					if (customForm1_actual.equals(name)) {

						// click on the newly created custom form
						String customFormName = "//td[text()='" + name + "']";
						driver.findElement(By.xpath(customFormName)).click();
						consoleMessage("Clicked on the newly created custom form.");

						// scroll down the screen
						scrollBottom();

						// validate the add button is displayed
						try {
							boolean addbtn1 = driver
									.findElement(
											By.xpath(OR.getProperty("customform_portfoliodashboard_addbtn1_XPATH")))
									.isDisplayed();

							if (addbtn1 == true) {
								verificationFailedMessage("The add button is displayed without permission.");
							} else {
								successMessage("The add button is not displayed as expected.");
							}
						} catch (Throwable t) {
							successMessage("The add button is not displayed as expected.");
						}

					} else {
						verificationFailedMessage("The newly created custom form is not displayed");
					}

				} catch (Throwable t) {
					verificationFailedMessage("The newly created custom form is not displayed");
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

			// LOGOUT THE SESSION FROM THE HR USER - JINESH HR AND LOGIN TO
			// ADMIN USER
			title("LOGOUT THE SESSION FROM THE HR USER - JINESH HR AND LOGIN TO ADMIN USER");

			// wait for the element
			Thread.sleep(5000);

			// click on the settings icon from the top of the screen
			click("questionnaire_settingicon_CSS");

			// wait for the element
			Thread.sleep(5000);

			// click on the logout option from the side menu
			click("sidemenu_logout_CSS");

			// login with valid credentials
			helper.loginAndUpdateSystemCompany(data, "username_1", "password_1", "system_company_1");

		} catch (Throwable t) {
			helper.questionnaireNotDisplayLogout(data);
		}

		// DELETE THE NEWLY CREATED CUSTOMER FORM
		title("DELETE THE NEWLY CREATED CUSTOMER FORM");

		try {

			// Wait for the element
			Thread.sleep(5000);

			// click on the settings icon from the top of the screen
			click("questionnaire_settingicon_CSS");

			// wait for the element
			explicitWaitClickable("questionnaire_administrationoption_XPATH");

			// click on the Administration option from the side menu
			click("questionnaire_administrationoption_XPATH");

			// click on the system tab
			click("questionnaire_systemtab_XPATH");

			// click on the custom form option
			click("customform_option_XPATH");

			// wait for the element
			Thread.sleep(5000);

			// click on the delete button of the newly created custom form
			String deleteIcon = "//td[text()='" + name
					+ "']//following-sibling::td[@class='pointer']//i[@data-target='#deleteCustomFormModal']";
			driver.findElement(By.xpath(deleteIcon)).click();
			consoleMessage("Clicked on the delete button of the newly created custom form.");

			// wait for the element
			Thread.sleep(5000);

			// click on the delete button
			click("customform_deletebtn_XPATH");

			// validate the respective record is deleted or not
			try {
				String deletedRecord = "//td[text()='" + name + "']";
				boolean deletedRecord_actual = driver.findElement(By.xpath(deletedRecord)).isDisplayed();

				if (deletedRecord_actual == true) {
					verificationFailedMessage("The deleted record of the custom form is displayed.");
				} else {
					successMessage("The deleted record of the custom form is not displayed as expected.");
				}

			} catch (Throwable t) {
				successMessage("The deleted record of the custom form is not displayed as expected.");
			}

		} catch (Throwable t) {
			verificationFailed();
		}

		// click on the home icon from the top of the screen
		click("questionnaire_homeburgermenubtn_CSS");

		// wait for the element
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

	}
}
