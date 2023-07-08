package testcases.E2Etestcasesuite.customformmodule;

import java.io.IOException;
import java.util.Hashtable;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import base.Helper;
import base.TestBase;
import utilities.TestUtil;

public class RR6340CustomForm7Test extends TestBase {

	@Test(dataProviderClass = TestUtil.class, dataProvider = "dp")
	public void rR6340CustomForm7Test(Hashtable<String, String> data) throws IOException, InterruptedException {

		execution(data, "rR6340CustomForm7Test");

		// VALIDATE THE 'USER TO VIEW FORM' AND 'ROLE TO VIEW FORM' PERMISSIONS OF THE
		// CUSTOM FORMS - MULTIPLE TYPE

		title("VALIDATE THE 'USER TO VIEW FORM' AND 'ROLE TO VIEW FORM' PERMISSIONS OF THE CUSTOM FORMS - MULTIPLE TYPE");

		Helper helper = new Helper();

		// refresh the page
		driver.navigate().refresh();
		Thread.sleep(5000);
		driver.navigate().refresh();

		System.out.println("Navigate to the Home Screen i.e. Property List Screen.");

		String fieldName1 = RandomStringUtils.randomAlphanumeric(8); // Normal Field 1
		String fieldName2 = RandomStringUtils.randomAlphanumeric(8); // Normal Field 2
		String pageName1 = RandomStringUtils.randomAlphanumeric(8); // Page Name 1
		String pageName2 = RandomStringUtils.randomAlphanumeric(8); // Page Name 2
		String pageFieldName1 = RandomStringUtils.randomAlphanumeric(8); // Page Name 1 - Field 1
		String pageFieldName2 = RandomStringUtils.randomAlphanumeric(8); // Page Name 1 - Field 2
		String pageFieldName3 = RandomStringUtils.randomAlphanumeric(8); // Page Name 2 - Field 1
		String pageFieldName4 = RandomStringUtils.randomAlphanumeric(8); // Page Name 2 - Field 2

		// CREATE NEW CUSTOM FORMS FOR MULTIPLE RECORD TYPE

		title("CREATE NEW CUSTOM FORMS FOR MULTIPLE RECORD TYPE");

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
			type("customform_nametxt_XPATH", data.get("name"));

			// select the single report type from the drop down
			select("customform_recordtypedd_XPATH", data.get("type_2"));

			// click on the date sensitive checkbox
			click("customform_datesensitiveckbx_XPATH");

			// click on the Is Verification Workflow Enabled? checkbox
			click("customform_verificationckbx_XPATH");

			// click on the save button
			click("customform_savebtn_XPATH");

			// wait for the element
			Thread.sleep(5000);

			// validate the Report Name details of the newly created report
			try {
				String Validation0 = "//td[text()='" + data.get("name") + "']";
				String Validation0_actual = (driver.findElement(By.xpath(Validation0)).getText()).trim();

				if (Validation0_actual.equals(data.get("name"))) {

					successMessage("The Report Name detail is displayed correctly.");

				} else {
					verificationFailedMessage("The Report Name detail is displayed correctly.");
				}

			} catch (Throwable t) {
				verificationFailedMessage("The Report Name detail is displayed correctly.");
			}

			// click on the newly created custom record record
			String nameTitle = "//td[text()='" + data.get("name") + "']";
			driver.findElement(By.xpath(nameTitle)).click();
			consoleMessage("Clicked on the newly created custom record record.");

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

			// click on the add button
			click("customform_addfield_addbtn_XPATH");

			// wait for the element
			explicitWaitClickable("closetoastmsg_CSS");

			// click on the toaster close button
			click("closetoastmsg_CSS");

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

			// click on the add field button
			click("customform_addfieldbtn_XPATH");

			// enter field name
			type("customform_addfield_nametxt_XPATH", fieldName2);

			// select the option from the type dropdown
			select("customform_addfield_typedd_XPATH", data.get("fieldtype_2"));

			// click on the display on list checkbox
			click("customform_addfield_displayonlistckbx_XPATH");

			// click on the unique identifier checkbox
			click("customform_addfield_uniqueidentifierckbx_XPATH");

			// click on the add button
			click("customform_addfield_addbtn_XPATH");

			// wait for the element
			explicitWaitClickable("closetoastmsg_CSS");

			// click on the toaster close button
			click("closetoastmsg_CSS");

			// validate the newly created field
			try {
				String field2 = "//span[text()='" + fieldName2 + "']";
				String field2_actual = (driver.findElement(By.xpath(field2)).getText()).trim();

				if (field2_actual.equals(fieldName2)) {
					successMessage("The newly created field is displayed successfully.");
				} else {
					verificationFailedMessage("The newly created field is not displayed.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The newly created field is not displayed.");
			}

			// click on the add new page icon
			click("customform_portfoliodashboard_addnewpagebtn_XPATH");

			// enter the first page name name in the page name field
			type("customform_portfoliodashboard_pagenametxt_XPATH", pageName1);

			// click on the add button
			click("customform_portfoliodashboard_pagename_addbtn_XPATH");

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

			// enter the second page name name in the page name field
			type("customform_portfoliodashboard_pagenametxt_XPATH", pageName2);

			// click on the add button
			click("customform_portfoliodashboard_pagename_addbtn_XPATH");

			// validate the newly added page
			try {
				String page2 = "//span[contains(text(),'" + pageName2 + "')]";
				String page2_actual = (driver.findElement(By.xpath(page2)).getText()).trim();

				if (page2_actual.equals(pageName2)) {
					successMessage("The newly created page is displayed successfully.");
				} else {
					verificationFailedMessage("The newly created page is not displayed.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The newly created page is not displayed.");
			}

			// click on the update button
			click("customform_updatebtn_XPATH");

			// wait for the element
			explicitWaitClickable("closetoastmsg_CSS");

			// click on the toaster close button
			click("closetoastmsg_CSS");

			// ADD FIELDS IN BOTH THE PAGES
			title("ADD FIELDS IN BOTH THE PAGES");

			// click on the first page name tab
			String page1 = "//span[contains(text(),'" + pageName1 + "')]";
			driver.findElement(By.xpath(page1)).click();
			consoleMessage("Clicked on the first page name tab.");

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

			// click on the add field button
			click("customform_addfieldbtn_XPATH");

			// enter field name
			type("customform_addfield_nametxt_XPATH", pageFieldName2);

			// select the option from the type dropdown
			select("customform_addfield_typedd_XPATH", data.get("fieldtype_2"));

			// click on the display on list checkbox
			click("customform_addfield_displayonlistckbx_XPATH");

			// click on the unique identifier checkbox
			click("customform_addfield_uniqueidentifierckbx_XPATH");

			// click on the add button
			click("customform_addfield_addbtn_XPATH");

			// wait for the element
			explicitWaitClickable("closetoastmsg_CSS");

			// click on the toaster close button
			click("closetoastmsg_CSS");

			// click on the first page name tab
			String page111 = "//span[contains(text(),'" + pageName1 + "')]";
			driver.findElement(By.xpath(page111)).click();
			consoleMessage("Clicked on the first page name tab.");

			// validate the newly created field
			try {
				String field2 = "//span[text()='" + pageFieldName2 + "']";
				String field2_actual = (driver.findElement(By.xpath(field2)).getText()).trim();

				if (field2_actual.equals(pageFieldName2)) {
					successMessage("The newly created field is displayed successfully.");
				} else {
					verificationFailedMessage("The newly created field is not displayed.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The newly created field is not displayed.");
			}

			// click on the second page name tab
			String page2 = "//span[contains(text(),'" + pageName2 + "')]";
			driver.findElement(By.xpath(page2)).click();
			consoleMessage("Clicked on the second page name tab.");

			// click on the add field button
			click("customform_addfieldbtn_XPATH");

			// enter field name
			type("customform_addfield_nametxt_XPATH", pageFieldName3);

			// select the option from the type dropdown
			select("customform_addfield_typedd_XPATH", data.get("fieldtype_1"));

			// click on the display on list checkbox
			click("customform_addfield_displayonlistckbx_XPATH");

			// click on the unique identifier checkbox
			click("customform_addfield_uniqueidentifierckbx_XPATH");

			// click on the add button
			click("customform_addfield_addbtn_XPATH");

			// wait for the element
			explicitWaitClickable("closetoastmsg_CSS");

			// click on the toaster close button
			click("closetoastmsg_CSS");

			// click on the second page name tab
			String page22 = "//span[contains(text(),'" + pageName2 + "')]";
			driver.findElement(By.xpath(page22)).click();
			consoleMessage("Clicked on the second page name tab.");

			// validate the newly created field
			try {
				String field1 = "//span[text()='" + pageFieldName3 + "']";
				String field1_actual = (driver.findElement(By.xpath(field1)).getText()).trim();

				if (field1_actual.equals(pageFieldName3)) {
					successMessage("The newly created field is displayed successfully.");
				} else {
					verificationFailedMessage("The newly created field is not displayed.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The newly created field is not displayed.");
			}

			// click on the add field button
			click("customform_addfieldbtn_XPATH");

			// enter field name
			type("customform_addfield_nametxt_XPATH", pageFieldName4);

			// select the option from the type dropdown
			select("customform_addfield_typedd_XPATH", data.get("fieldtype_2"));

			// click on the display on list checkbox
			click("customform_addfield_displayonlistckbx_XPATH");

			// click on the unique identifier checkbox
			click("customform_addfield_uniqueidentifierckbx_XPATH");

			// click on the add button
			click("customform_addfield_addbtn_XPATH");

			// wait for the element
			explicitWaitClickable("closetoastmsg_CSS");

			// click on the toaster close button
			click("closetoastmsg_CSS");

			// click on the second page name tab
			String page222 = "//span[contains(text(),'" + pageName2 + "')]";
			driver.findElement(By.xpath(page222)).click();
			consoleMessage("Clicked on the second page name tab.");

			// validate the newly created field
			try {
				String field2 = "//span[text()='" + pageFieldName4 + "']";
				String field2_actual = (driver.findElement(By.xpath(field2)).getText()).trim();

				if (field2_actual.equals(pageFieldName4)) {
					successMessage("The newly created field is displayed successfully.");
				} else {
					verificationFailedMessage("The newly created field is not displayed.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The newly created field is not displayed.");
			}

			// click on the update button
			click("customform_updatebtn_XPATH");

			// wait for the element
			explicitWaitClickable("closetoastmsg_CSS");

			// click on the toaster close button
			click("closetoastmsg_CSS");

			// ADD THE SECURITY PERMISSION OF THE VIEW CUSTOMER FORM FOR THE JINESH
			// (PROPERTY MANAGER)
			title("ADD THE SECURITY PERMISSION OF THE VIEW CUSTOMER FORM FOR THE JINESH (PROPERTY MANAGER)");

			// click on the security tab
			click("customform_securitytab_XPATH");

			// click on the User to View form field
			click("customform_securitytab_security1_XPATH");

			// click on the none button
			click("customform_securitytab_nonebtn_XPATH");

			// enter the user name in the search field
			type("customform_securitytab_searchtxt_XPATH", data.get("user1"));

			// click on the searched result
			click("customform_securitytab_searchedresult1_XPATH");

			// click on the User to View form field
			click("customform_securitytab_security1_XPATH");

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

		// VALIDATE THE FIELDS AND PAGES OF THE CUSTOM REPORT IN THE PROPERTY SUMMARY
		// DASHBOARD AND PORTFOLIO SUMMARY DASHBOARD - ADMIN USER

		title("VALIDATE THE FIELDS AND PAGES OF THE CUSTOM REPORT IN THE PROPERTY SUMMARY DASHBOARD AND PORTFOLIO SUMMARY DASHBOARD - ADMIN USER");

		try {

			// VALIDATE ON PROPERTY SUMMARY DASHBOARD
			consoleMessage("VALIDATE ON PROPERTY SUMMARY DASHBOARD");

			// wait for the element
			Thread.sleep(5000);

			// click on the property
			click("propertysummary_property1_XPATH");

			// validate the Property Information section and custom form is displayed or not
			try {

				// scrolldown till Property Information section
				scrollTillElement("customform_portfoliodashboard_propertyinformationtitle_XPATH");

				// validate the newly created custom form in the property summary dashboard
				// screen
				try {
					String customForm1 = "//td[text()='" + data.get("name") + "']";
					String customForm1_actual = (driver.findElement(By.xpath(customForm1)).getText()).trim();

					if (customForm1_actual.equals(data.get("name"))) {

						verificationFailedMessage("The newly created custom form is displayed.");

					} else {
						successMessage("The newly created custom form is not displayed as expected.");
					}

				} catch (Throwable t) {
					successMessage("The newly created custom form is not displayed as expected.");
				}

			} catch (Throwable t) {
				successMessage("The Property Information section is not displayed as expected.");
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

			try {
				// scrolldown till Property Information section
				scrollTillElement("customform_portfoliodashboard_propertyinformationtitle_XPATH");

				// validate the newly created custom form in the portfolio dashboard screen
				try {
					String customForm1 = "//td[text()='" + data.get("name") + "']";
					String customForm1_actual = (driver.findElement(By.xpath(customForm1)).getText()).trim();

					if (customForm1_actual.equals(data.get("name"))) {
						verificationFailedMessage("The newly created custom form is displayed.");

					} else {
						successMessage("The newly created custom form is not displayed as expected.");
					}

				} catch (Throwable t) {
					successMessage("The newly created custom form is not displayed as expected.");
				}

			} catch (Throwable t) {
				successMessage("The Property Information section is not displayed as expected.");
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

			// VALIDATE THE FIELDS AND PAGES OF THE CUSTOM REPORT IN THE PROPERTY SUMMARY
			// DASHBOARD AND PORTFOLIO SUMMARY DASHBOARD - PROPERTY MANAGER USER - JINESH

			title("VALIDATE THE FIELDS AND PAGES OF THE CUSTOM REPORT IN THE PROPERTY SUMMARY DASHBOARD AND PORTFOLIO SUMMARY DASHBOARD - PROPERTY MANAGER USER - JINESH");

			try {

				// VALIDATE ON PROPERTY SUMMARY DASHBOARD
				consoleMessage("VALIDATE ON PROPERTY SUMMARY DASHBOARD");

				// wait for the element
				Thread.sleep(5000);

				// click on the property
				click("propertysummary_property1_XPATH");

				// validate the Property Information section and custom form is displayed or not
				try {

					// scrolldown till Property Information section
					scrollTillElement("customform_portfoliodashboard_propertyinformationtitle_XPATH");

					// validate the newly created custom form in the property summary dashboard
					// screen
					try {
						String customForm1 = "//td[text()='" + data.get("name") + "']";
						String customForm1_actual = (driver.findElement(By.xpath(customForm1)).getText()).trim();

						if (customForm1_actual.equals(data.get("name"))) {

							successMessage("The newly created custom form is displayed as expected.");

							// click on the newly created custom form
							String customFormName = "//td[text()='" + data.get("name") + "']";
							driver.findElement(By.xpath(customFormName)).click();
							consoleMessage("Clicked on the newly created custom form.");

							// validate the custom form as a title
							try {
								String customName = "//h4[contains(text(),'" + data.get("name") + "')]";
								String customName_actual = (driver.findElement(By.xpath(customName)).getText()).trim();

								if (customName_actual.equals(data.get("name"))) {
									successMessage("The custom form name is displayed correctly.");
								} else {
									verificationFailedMessage("The custom form is not displayed.");
								}
							} catch (Throwable t) {
								verificationFailedMessage("The custom form is not displayed.");
							}

							// validate the first field label
							try {
								String fieldLabel1 = "//b[text()='" + fieldName1 + "']";
								String fieldLabel1_actual = (driver.findElement(By.xpath(fieldLabel1)).getText())
										.trim();

								if (fieldLabel1_actual.equals(fieldName1)) {
									successMessage("The first field label is displayed successfully.");
								} else {
									verificationFailedMessage("The first field label is not displayed.");
								}
							} catch (Throwable t) {
								verificationFailedMessage("The first field label is not displayed.");
							}

							// validate the second field label
							try {
								String fieldLabel2 = "//b[text()='" + fieldName2 + "']";
								String fieldLabel2_actual = (driver.findElement(By.xpath(fieldLabel2)).getText())
										.trim();

								if (fieldLabel2_actual.equals(fieldName2)) {
									successMessage("The second field label is displayed successfully.");
								} else {
									verificationFailedMessage("The second field label is not displayed.");
								}
							} catch (Throwable t) {
								verificationFailedMessage("The second field label is not displayed.");
							}

							// validate the third field label
							try {
								String fieldLabel3 = "//b[text()='" + pageFieldName1 + "']";
								String fieldLabel3_actual = (driver.findElement(By.xpath(fieldLabel3)).getText())
										.trim();

								if (fieldLabel3_actual.equals(pageFieldName1)) {
									successMessage("The third field label is displayed successfully.");
								} else {
									verificationFailedMessage("The third field label is not displayed.");
								}
							} catch (Throwable t) {
								verificationFailedMessage("The third field label is not displayed.");
							}

							// validate the forth field label
							try {
								String fieldLabel4 = "//b[text()='" + pageFieldName2 + "']";
								String fieldLabel4_actual = (driver.findElement(By.xpath(fieldLabel4)).getText())
										.trim();

								if (fieldLabel4_actual.equals(pageFieldName2)) {
									successMessage("The forth field label is displayed successfully.");
								} else {
									verificationFailedMessage("The forth field label is not displayed.");
								}
							} catch (Throwable t) {
								verificationFailedMessage("The forth field label is not displayed.");
							}

							// validate the fifth field label
							try {
								String fieldLabel5 = "//b[text()='" + pageFieldName3 + "']";
								String fieldLabel5_actual = (driver.findElement(By.xpath(fieldLabel5)).getText())
										.trim();

								if (fieldLabel5_actual.equals(pageFieldName3)) {
									successMessage("The fifth field label is displayed successfully.");
								} else {
									verificationFailedMessage("The fifth field label is not displayed.");
								}
							} catch (Throwable t) {
								verificationFailedMessage("The fifth field label is not displayed.");
							}

							// validate the sixth field label
							try {
								String fieldLabel6 = "//b[text()='" + pageFieldName4 + "']";
								String fieldLabel6_actual = (driver.findElement(By.xpath(fieldLabel6)).getText())
										.trim();

								if (fieldLabel6_actual.equals(pageFieldName4)) {
									successMessage("The sixth field label is displayed successfully.");
								} else {
									verificationFailedMessage("The sixth field label is not displayed.");
								}
							} catch (Throwable t) {
								verificationFailedMessage("The sixth field label is not displayed.");
							}

						} else {
							verificationFailedMessage("The newly created custom form is not displayed.");
						}

					} catch (Throwable t) {
						verificationFailedMessage("The newly created custom form is not displayed.");
					}

				} catch (Throwable t) {
					verificationFailedMessage("The Property Information section is not displayed.");
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

				try {
					// scrolldown till Property Information section
					scrollTillElement("customform_portfoliodashboard_propertyinformationtitle_XPATH");

					// validate the newly created custom form in the portfolio dashboard screen
					try {
						String customForm1 = "//td[text()='" + data.get("name") + "']";
						String customForm1_actual = (driver.findElement(By.xpath(customForm1)).getText()).trim();

						if (customForm1_actual.equals(data.get("name"))) {
							successMessage("The newly created custom form is displayed successfully.");

						} else {
							verificationFailedMessage("The newly created custom form is not displayed.");
						}

					} catch (Throwable t) {
						verificationFailedMessage("The newly created custom form is not displayed.");
					}

					// click on the custom form
					String customForm1 = "//td[text()='" + data.get("name") + "']";
					driver.findElement(By.xpath(customForm1)).click();
					consoleMessage("Clicked on the custom form.");

					// validate the field 1
					try {
						String field11 = "//th[text()='" + fieldName1 + "']";
						String field11_actual = (driver.findElement(By.xpath(field11)).getText()).trim();

						if (field11_actual.equals(fieldName1)) {
							successMessage("The respective field is displayed successfully.");
						} else {
							verificationFailedMessage("The repsective field is not displayed.");
						}
					} catch (Throwable t) {
						verificationFailedMessage("The repsective field is not displayed.");
					}

					// validate the field 2
					try {
						String field22 = "//th[text()='" + fieldName2 + "']";
						String field22_actual = (driver.findElement(By.xpath(field22)).getText()).trim();

						if (field22_actual.equals(fieldName2)) {
							successMessage("The respective field is displayed successfully.");
						} else {
							verificationFailedMessage("The repsective field is not displayed.");
						}
					} catch (Throwable t) {
						verificationFailedMessage("The repsective field is not displayed.");
					}

					// validate the field 1 of page 1
					try {
						String field33 = "//th[text()='" + pageFieldName1 + "']";
						String field33_actual = (driver.findElement(By.xpath(field33)).getText()).trim();

						if (field33_actual.equals(pageFieldName1)) {

							successMessage("The respective field is displayed successfully.");

						} else {
							verificationFailedMessage("The repsective field is not displayed.");
						}
					} catch (Throwable t) {
						verificationFailedMessage("The repsective field is not displayed.");
					}

					// validate the field 2 of page 1
					try {
						String field44 = "//th[text()='" + pageFieldName2 + "']";
						String field44_actual = (driver.findElement(By.xpath(field44)).getText()).trim();

						if (field44_actual.equals(pageFieldName2)) {

							successMessage("The respective field is displayed successfully.");

						} else {
							verificationFailedMessage("The repsective field is not displayed.");
						}
					} catch (Throwable t) {
						verificationFailedMessage("The repsective field is not displayed.");
					}

					// validate the field 1 of page 2
					try {
						String field55 = "//th[text()='" + pageFieldName3 + "']";
						String field55_actual = (driver.findElement(By.xpath(field55)).getText()).trim();

						if (field55_actual.equals(pageFieldName3)) {

							successMessage("The respective field is displayed successfully.");

						} else {
							verificationFailedMessage("The repsective field is not displayed.");
						}
					} catch (Throwable t) {
						verificationFailedMessage("The repsective field is not displayed.");
					}

					// validate the field 2 of page 2
					try {
						String field66 = "//th[text()='" + pageFieldName4 + "']";
						String field66_actual = (driver.findElement(By.xpath(field66)).getText()).trim();

						if (field66_actual.equals(pageFieldName4)) {

							successMessage("The respective field is displayed successfully.");

						} else {
							verificationFailedMessage("The repsective field is not displayed.");
						}
					} catch (Throwable t) {
						verificationFailedMessage("The repsective field is not displayed.");
					}

				} catch (Throwable t) {
					verificationFailedMessage("The Property Information section is not displayed.");
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

		// UPDATE THE SECURITY PERMISSION OF THE VIEW CUSTOMER FORM FOR THE CONTRACTOR

		title("UPDATE THE SECURITY PERMISSION OF THE VIEW CUSTOMER FORM FOR THE CONTRACTOR");

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
			String nameTitle = "//td[text()='" + data.get("name") + "']";
			driver.findElement(By.xpath(nameTitle)).click();
			consoleMessage("Clicked on the newly created custom record.");

			// click on the security tab
			click("customform_securitytab_XPATH");

			// click on the User to View form field
			click("customform_securitytab_security1_XPATH");

			// click on the none button
			click("customform_securitytab_nonebtn_XPATH");

			// click on the User to View form field
			click("customform_securitytab_security1_XPATH");

			// click on the Role to View form field
			click("customform_securitytab_security2_XPATH");

			// click on the none button
			click("customform_securitytab_nonebtn_XPATH");

			// enter the user name in the search field
			type("customform_securitytab_searchtxt_XPATH", data.get("role1"));

			// click on the searched result
			click("customform_securitytab_searchedresult2_XPATH");

			// click on the Role to View form field
			click("customform_securitytab_security2_XPATH");

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

		// VALIDATE THE FIELDS AND PAGES OF THE CUSTOM REPORT IN THE PROPERTY SUMMARY
		// DASHBOARD AND PORTFOLIO SUMMARY DASHBOARD - ADMIN USER
		title("VALIDATE THE FIELDS AND PAGES OF THE CUSTOM REPORT IN THE PROPERTY SUMMARY DASHBOARD AND PORTFOLIO SUMMARY DASHBOARD - ADMIN USER");

		try {

			// VALIDATE ON PROPERTY SUMMARY DASHBOARD
			consoleMessage("VALIDATE ON PROPERTY SUMMARY DASHBOARD");

			// wait for the element
			Thread.sleep(5000);

			// click on the property
			click("propertysummary_property1_XPATH");

			// validate the Property Information section and custom form is displayed or not
			try {

				// scrolldown till Property Information section
				scrollTillElement("customform_portfoliodashboard_propertyinformationtitle_XPATH");

				// validate the newly created custom form in the property summary dashboard
				// screen
				try {
					String customForm1 = "//td[text()='" + data.get("name") + "']";
					String customForm1_actual = (driver.findElement(By.xpath(customForm1)).getText()).trim();

					if (customForm1_actual.equals(data.get("name"))) {

						verificationFailedMessage("The newly created custom form is displayed.");

					} else {
						successMessage("The newly created custom form is not displayed as expected.");
					}

				} catch (Throwable t) {
					successMessage("The newly created custom form is not displayed as expected.");
				}

			} catch (Throwable t) {
				successMessage("The Property Information section is not displayed as expected.");
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

			try {
				// scrolldown till Property Information section
				scrollTillElement("customform_portfoliodashboard_propertyinformationtitle_XPATH");

				// validate the newly created custom form in the portfolio dashboard screen
				try {
					String customForm1 = "//td[text()='" + data.get("name") + "']";
					String customForm1_actual = (driver.findElement(By.xpath(customForm1)).getText()).trim();

					if (customForm1_actual.equals(data.get("name"))) {
						verificationFailedMessage("The newly created custom form is displayed.");

					} else {
						successMessage("The newly created custom form is not displayed as expected.");
					}

				} catch (Throwable t) {
					successMessage("The newly created custom form is not displayed as expected.");
				}

			} catch (Throwable t) {
				successMessage("The Property Information section is not displayed as expected.");
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

			// VALIDATE THE FIELDS AND PAGES OF THE CUSTOM REPORT IN THE PROPERTY SUMMARY
			// DASHBOARD AND PORTFOLIO SUMMARY DASHBOARD - PROPERTY MANAGER USER - JINESH

			title("VALIDATE THE FIELDS AND PAGES OF THE CUSTOM REPORT IN THE PROPERTY SUMMARY DASHBOARD AND PORTFOLIO SUMMARY DASHBOARD - PROPERTY MANAGER USER - JINESH");

			try {

				// VALIDATE TO PROPERTY SUMMARY DASHBOARD
				consoleMessage("VALIDATE TO PROPERTY SUMMARY DASHBOARD");

				// wait for the element
				Thread.sleep(5000);

				// click on the property
				click("propertysummary_property1_XPATH");

				// validate the Property Information section and custom form is displayed or not
				try {

					// scrolldown till Property Information section
					scrollTillElement("customform_portfoliodashboard_propertyinformationtitle_XPATH");

					// validate the newly created custom form in the property summary dashboard
					// screen
					try {
						String customForm1 = "//td[text()='" + data.get("name") + "']";
						String customForm1_actual = (driver.findElement(By.xpath(customForm1)).getText()).trim();

						if (customForm1_actual.equals(data.get("name"))) {

							verificationFailedMessage("The newly created custom form is displayed.");

						} else {
							successMessage("The newly created custom form is not displayed as expected.");
						}

					} catch (Throwable t) {
						successMessage("The newly created custom form is not displayed as expected.");
					}

				} catch (Throwable t) {
					successMessage("The Property Information section is not displayed as expected.");
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

				try {
					// scrolldown till Property Information section
					scrollTillElement("customform_portfoliodashboard_propertyinformationtitle_XPATH");

					// validate the newly created custom form in the portfolio dashboard screen
					try {
						String customForm1 = "//td[text()='" + data.get("name") + "']";
						String customForm1_actual = (driver.findElement(By.xpath(customForm1)).getText()).trim();

						if (customForm1_actual.equals(data.get("name"))) {
							verificationFailedMessage("The newly created custom form is displayed.");

						} else {
							successMessage("The newly created custom form is not displayed as expected.");
						}

					} catch (Throwable t) {
						successMessage("The newly created custom form is not displayed as expected.");
					}

				} catch (Throwable t) {
					successMessage("The Property Information section is not displayed as expected.");
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

			// VALIDATE THE FIELDS AND PAGES OF THE CUSTOM REPORT IN THE PROPERTY SUMMARY
			// DASHBOARD AND PORTFOLIO SUMMARY DASHBOARD - CONTRACTOR USER - JINESH
			// CONTRACTOR
			title("VALIDATE THE FIELDS AND PAGES OF THE CUSTOM REPORT IN THE PROPERTY SUMMARY DASHBOARD AND PORTFOLIO SUMMARY DASHBOARD - CONTRACTOR USER - JINESH CONTRACTOR");

			try {

				// VALIDATE ON PROPERTY SUMMARY DASHBOARD
				consoleMessage("VALIDATE ON PROPERTY SUMMARY DASHBOARD");

				// wait for the element
				Thread.sleep(5000);

				// click on the property
				click("propertysummary_property1_XPATH");

				// validate the Property Information section and custom form is displayed or not
				try {

					// scrolldown till Property Information section
					scrollTillElement("customform_portfoliodashboard_propertyinformationtitle_XPATH");

					// validate the newly created custom form in the property summary dashboard
					// screen
					try {
						String customForm1 = "//td[text()='" + data.get("name") + "']";
						String customForm1_actual = (driver.findElement(By.xpath(customForm1)).getText()).trim();

						if (customForm1_actual.equals(data.get("name"))) {

							successMessage("The newly created custom form is displayed as expected.");

							// click on the newly created custom form
							String customFormName = "//td[text()='" + data.get("name") + "']";
							driver.findElement(By.xpath(customFormName)).click();
							consoleMessage("Clicked on the newly created custom form.");

							// validate the custom form as a title
							try {
								String customName = "//h4[contains(text(),'" + data.get("name") + "')]";
								String customName_actual = (driver.findElement(By.xpath(customName)).getText()).trim();

								if (customName_actual.equals(data.get("name"))) {
									successMessage("The custom form name is displayed correctly.");
								} else {
									verificationFailedMessage("The custom form is not displayed.");
								}
							} catch (Throwable t) {
								verificationFailedMessage("The custom form is not displayed.");
							}

							// validate the first field label
							try {
								String fieldLabel1 = "//b[text()='" + fieldName1 + "']";
								String fieldLabel1_actual = (driver.findElement(By.xpath(fieldLabel1)).getText())
										.trim();

								if (fieldLabel1_actual.equals(fieldName1)) {
									successMessage("The first field label is displayed successfully.");
								} else {
									verificationFailedMessage("The first field label is not displayed.");
								}
							} catch (Throwable t) {
								verificationFailedMessage("The first field label is not displayed.");
							}

							// validate the second field label
							try {
								String fieldLabel2 = "//b[text()='" + fieldName2 + "']";
								String fieldLabel2_actual = (driver.findElement(By.xpath(fieldLabel2)).getText())
										.trim();

								if (fieldLabel2_actual.equals(fieldName2)) {
									successMessage("The second field label is displayed successfully.");
								} else {
									verificationFailedMessage("The second field label is not displayed.");
								}
							} catch (Throwable t) {
								verificationFailedMessage("The second field label is not displayed.");
							}

							// validate the third field label
							try {
								String fieldLabel3 = "//b[text()='" + pageFieldName1 + "']";
								String fieldLabel3_actual = (driver.findElement(By.xpath(fieldLabel3)).getText())
										.trim();

								if (fieldLabel3_actual.equals(pageFieldName1)) {
									successMessage("The third field label is displayed successfully.");
								} else {
									verificationFailedMessage("The third field label is not displayed.");
								}
							} catch (Throwable t) {
								verificationFailedMessage("The third field label is not displayed.");
							}

							// validate the forth field label
							try {
								String fieldLabel4 = "//b[text()='" + pageFieldName2 + "']";
								String fieldLabel4_actual = (driver.findElement(By.xpath(fieldLabel4)).getText())
										.trim();

								if (fieldLabel4_actual.equals(pageFieldName2)) {
									successMessage("The forth field label is displayed successfully.");
								} else {
									verificationFailedMessage("The forth field label is not displayed.");
								}
							} catch (Throwable t) {
								verificationFailedMessage("The forth field label is not displayed.");
							}

							// validate the fifth field label
							try {
								String fieldLabel5 = "//b[text()='" + pageFieldName3 + "']";
								String fieldLabel5_actual = (driver.findElement(By.xpath(fieldLabel5)).getText())
										.trim();

								if (fieldLabel5_actual.equals(pageFieldName3)) {
									successMessage("The fifth field label is displayed successfully.");
								} else {
									verificationFailedMessage("The fifth field label is not displayed.");
								}
							} catch (Throwable t) {
								verificationFailedMessage("The fifth field label is not displayed.");
							}

							// validate the sixth field label
							try {
								String fieldLabel6 = "//b[text()='" + pageFieldName4 + "']";
								String fieldLabel6_actual = (driver.findElement(By.xpath(fieldLabel6)).getText())
										.trim();

								if (fieldLabel6_actual.equals(pageFieldName4)) {
									successMessage("The sixth field label is displayed successfully.");
								} else {
									verificationFailedMessage("The sixth field label is not displayed.");
								}
							} catch (Throwable t) {
								verificationFailedMessage("The sixth field label is not displayed.");
							}

						} else {
							verificationFailedMessage("The newly created custom form is not displayed.");
						}

					} catch (Throwable t) {
						verificationFailedMessage("The newly created custom form is not displayed.");
					}

				} catch (Throwable t) {
					verificationFailedMessage("The Property Information section is not displayed.");
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

				try {
					// scrolldown till Property Information section
					scrollTillElement("customform_portfoliodashboard_propertyinformationtitle_XPATH");

					// validate the newly created custom form in the portfolio dashboard screen
					try {
						String customForm1 = "//td[text()='" + data.get("name") + "']";
						String customForm1_actual = (driver.findElement(By.xpath(customForm1)).getText()).trim();

						if (customForm1_actual.equals(data.get("name"))) {
							successMessage("The newly created custom form is displayed successfully.");

						} else {
							verificationFailedMessage("The newly created custom form is not displayed.");
						}

					} catch (Throwable t) {
						verificationFailedMessage("The newly created custom form is not displayed.");
					}

					// click on the custom form
					String customForm1 = "//td[text()='" + data.get("name") + "']";
					driver.findElement(By.xpath(customForm1)).click();
					consoleMessage("Clicked on the custom form.");

					// validate the field 1
					try {
						String field11 = "//th[text()='" + fieldName1 + "']";
						String field11_actual = (driver.findElement(By.xpath(field11)).getText()).trim();

						if (field11_actual.equals(fieldName1)) {
							successMessage("The respective field is displayed successfully.");
						} else {
							verificationFailedMessage("The repsective field is not displayed.");
						}
					} catch (Throwable t) {
						verificationFailedMessage("The repsective field is not displayed.");
					}

					// validate the field 2
					try {
						String field22 = "//th[text()='" + fieldName2 + "']";
						String field22_actual = (driver.findElement(By.xpath(field22)).getText()).trim();

						if (field22_actual.equals(fieldName2)) {
							successMessage("The respective field is displayed successfully.");
						} else {
							verificationFailedMessage("The repsective field is not displayed.");
						}
					} catch (Throwable t) {
						verificationFailedMessage("The repsective field is not displayed.");
					}

					// validate the field 1 of page 1
					try {
						String field33 = "//th[text()='" + pageFieldName1 + "']";
						String field33_actual = (driver.findElement(By.xpath(field33)).getText()).trim();

						if (field33_actual.equals(pageFieldName1)) {

							successMessage("The respective field is displayed successfully.");

						} else {
							verificationFailedMessage("The repsective field is not displayed.");
						}
					} catch (Throwable t) {
						verificationFailedMessage("The repsective field is not displayed.");
					}

					// validate the field 2 of page 1
					try {
						String field44 = "//th[text()='" + pageFieldName2 + "']";
						String field44_actual = (driver.findElement(By.xpath(field44)).getText()).trim();

						if (field44_actual.equals(pageFieldName2)) {

							successMessage("The respective field is displayed successfully.");

						} else {
							verificationFailedMessage("The repsective field is not displayed.");
						}
					} catch (Throwable t) {
						verificationFailedMessage("The repsective field is not displayed.");
					}

					// validate the field 1 of page 2
					try {
						String field55 = "//th[text()='" + pageFieldName3 + "']";
						String field55_actual = (driver.findElement(By.xpath(field55)).getText()).trim();

						if (field55_actual.equals(pageFieldName3)) {

							successMessage("The respective field is displayed successfully.");

						} else {
							verificationFailedMessage("The repsective field is not displayed.");
						}
					} catch (Throwable t) {
						verificationFailedMessage("The repsective field is not displayed.");
					}

					// validate the field 2 of page 2
					try {
						String field66 = "//th[text()='" + pageFieldName4 + "']";
						String field66_actual = (driver.findElement(By.xpath(field66)).getText()).trim();

						if (field66_actual.equals(pageFieldName4)) {

							successMessage("The respective field is displayed successfully.");

						} else {
							verificationFailedMessage("The repsective field is not displayed.");
						}
					} catch (Throwable t) {
						verificationFailedMessage("The repsective field is not displayed.");
					}

				} catch (Throwable t) {
					verificationFailedMessage("The Property Information section is not displayed.");
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

		// UPDATE THE SECURITY PERMISSION OF THE VIEW CUSTOMER FORM FOR THE JINESH
		// (PROPERTY MANAGER) AND CONTRACTOR

		title("UPDATE THE SECURITY PERMISSION OF THE VIEW CUSTOMER FORM FOR THE JINESH (PROPERTY MANAGER) AND CONTRACTOR");

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
			String nameTitle = "//td[text()='" + data.get("name") + "']";
			driver.findElement(By.xpath(nameTitle)).click();
			consoleMessage("Clicked on the newly created custom record record.");

			// click on the security tab
			click("customform_securitytab_XPATH");

			// click on the User to View form field
			click("customform_securitytab_security1_XPATH");

			// click on the none button
			click("customform_securitytab_nonebtn_XPATH");

			// enter the user name in the search field
			type("customform_securitytab_searchtxt_XPATH", data.get("user1"));

			// click on the searched result
			click("customform_securitytab_searchedresult1_XPATH");

			// click on the User to View form field
			click("customform_securitytab_security1_XPATH");

			// click on the Role to View form field
			click("customform_securitytab_security2_XPATH");

			// click on the none button
			click("customform_securitytab_nonebtn_XPATH");

			// enter the user name in the search field
			type("customform_securitytab_searchtxt_XPATH", data.get("role1"));

			// click on the searched result
			click("customform_securitytab_searchedresult2_XPATH");

			// click on the Role to View form field
			click("customform_securitytab_security2_XPATH");

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

		// VALIDATE THE FIELDS AND PAGES OF THE CUSTOM REPORT IN THE PROPERTY SUMMARY
		// DASHBOARD AND PORTFOLIO SUMMARY DASHBOARD - ADMIN USER

		title("VALIDATE THE FIELDS AND PAGES OF THE CUSTOM REPORT IN THE PROPERTY SUMMARY DASHBOARD AND PORTFOLIO SUMMARY DASHBOARD - ADMIN USER");

		try {

			// VALIDATE ON PROPERTY SUMMARY DASHBOARD
			consoleMessage("VALIDATE ON PROPERTY SUMMARY DASHBOARD");

			// wait for the element
			Thread.sleep(5000);

			// click on the property
			click("propertysummary_property1_XPATH");

			// validate the Property Information section and custom form is displayed or not
			try {

				// scrolldown till Property Information section
				scrollTillElement("customform_portfoliodashboard_propertyinformationtitle_XPATH");

				// validate the newly created custom form in the property summary dashboard
				// screen
				try {
					String customForm1 = "//td[text()='" + data.get("name") + "']";
					String customForm1_actual = (driver.findElement(By.xpath(customForm1)).getText()).trim();

					if (customForm1_actual.equals(data.get("name"))) {

						verificationFailedMessage("The newly created custom form is displayed.");

					} else {
						successMessage("The newly created custom form is not displayed as expected.");
					}

				} catch (Throwable t) {
					successMessage("The newly created custom form is not displayed as expected.");
				}

			} catch (Throwable t) {
				successMessage("The Property Information section is not displayed as expected.");
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

			try {
				// scrolldown till Property Information section
				scrollTillElement("customform_portfoliodashboard_propertyinformationtitle_XPATH");

				// validate the newly created custom form in the portfolio dashboard screen
				try {
					String customForm1 = "//td[text()='" + data.get("name") + "']";
					String customForm1_actual = (driver.findElement(By.xpath(customForm1)).getText()).trim();

					if (customForm1_actual.equals(data.get("name"))) {
						verificationFailedMessage("The newly created custom form is displayed.");

					} else {
						successMessage("The newly created custom form is not displayed as expected.");
					}

				} catch (Throwable t) {
					successMessage("The newly created custom form is not displayed as expected.");
				}

			} catch (Throwable t) {
				successMessage("The Property Information section is not displayed as expected.");
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

			// VALIDATE THE FIELDS AND PAGES OF THE CUSTOM REPORT IN THE PROPERTY SUMMARY
			// DASHBOARD AND PORTFOLIO SUMMARY DASHBOARD - PROPERTY MANAGER USER - JINESH
			title("VALIDATE THE FIELDS AND PAGES OF THE CUSTOM REPORT IN THE PROPERTY SUMMARY DASHBOARD PORTFOLIO SUMMARY DASHBOARD - PROPERTY MANAGER USER - JINESH");

			try {

				// VALIDATE ON PROPERTY SUMMARY DASHBOARD
				consoleMessage("VALIDATE ON PROPERTY SUMMARY DASHBOARD");

				// wait for the element
				Thread.sleep(5000);

				// click on the property
				click("propertysummary_property1_XPATH");

				// validate the Property Information section and custom form is displayed or not
				try {

					// scrolldown till Property Information section
					scrollTillElement("customform_portfoliodashboard_propertyinformationtitle_XPATH");

					// validate the newly created custom form in the property summary dashboard
					// screen
					try {
						String customForm1 = "//td[text()='" + data.get("name") + "']";
						String customForm1_actual = (driver.findElement(By.xpath(customForm1)).getText()).trim();

						if (customForm1_actual.equals(data.get("name"))) {

							successMessage("The newly created custom form is displayed as expected.");

							// click on the newly created custom form
							String customFormName = "//td[text()='" + data.get("name") + "']";
							driver.findElement(By.xpath(customFormName)).click();
							consoleMessage("Clicked on the newly created custom form.");

							// validate the custom form as a title
							try {
								String customName = "//h4[contains(text(),'" + data.get("name") + "')]";
								String customName_actual = (driver.findElement(By.xpath(customName)).getText()).trim();

								if (customName_actual.equals(data.get("name"))) {
									successMessage("The custom form name is displayed correctly.");
								} else {
									verificationFailedMessage("The custom form is not displayed.");
								}
							} catch (Throwable t) {
								verificationFailedMessage("The custom form is not displayed.");
							}

							// validate the first field label
							try {
								String fieldLabel1 = "//b[text()='" + fieldName1 + "']";
								String fieldLabel1_actual = (driver.findElement(By.xpath(fieldLabel1)).getText())
										.trim();

								if (fieldLabel1_actual.equals(fieldName1)) {
									successMessage("The first field label is displayed successfully.");
								} else {
									verificationFailedMessage("The first field label is not displayed.");
								}
							} catch (Throwable t) {
								verificationFailedMessage("The first field label is not displayed.");
							}

							// validate the second field label
							try {
								String fieldLabel2 = "//b[text()='" + fieldName2 + "']";
								String fieldLabel2_actual = (driver.findElement(By.xpath(fieldLabel2)).getText())
										.trim();

								if (fieldLabel2_actual.equals(fieldName2)) {
									successMessage("The second field label is displayed successfully.");
								} else {
									verificationFailedMessage("The second field label is not displayed.");
								}
							} catch (Throwable t) {
								verificationFailedMessage("The second field label is not displayed.");
							}

							// validate the third field label
							try {
								String fieldLabel3 = "//b[text()='" + pageFieldName1 + "']";
								String fieldLabel3_actual = (driver.findElement(By.xpath(fieldLabel3)).getText())
										.trim();

								if (fieldLabel3_actual.equals(pageFieldName1)) {
									successMessage("The third field label is displayed successfully.");
								} else {
									verificationFailedMessage("The third field label is not displayed.");
								}
							} catch (Throwable t) {
								verificationFailedMessage("The third field label is not displayed.");
							}

							// validate the forth field label
							try {
								String fieldLabel4 = "//b[text()='" + pageFieldName2 + "']";
								String fieldLabel4_actual = (driver.findElement(By.xpath(fieldLabel4)).getText())
										.trim();

								if (fieldLabel4_actual.equals(pageFieldName2)) {
									successMessage("The forth field label is displayed successfully.");
								} else {
									verificationFailedMessage("The forth field label is not displayed.");
								}
							} catch (Throwable t) {
								verificationFailedMessage("The forth field label is not displayed.");
							}

							// validate the fifth field label
							try {
								String fieldLabel5 = "//b[text()='" + pageFieldName3 + "']";
								String fieldLabel5_actual = (driver.findElement(By.xpath(fieldLabel5)).getText())
										.trim();

								if (fieldLabel5_actual.equals(pageFieldName3)) {
									successMessage("The fifth field label is displayed successfully.");
								} else {
									verificationFailedMessage("The fifth field label is not displayed.");
								}
							} catch (Throwable t) {
								verificationFailedMessage("The fifth field label is not displayed.");
							}

							// validate the sixth field label
							try {
								String fieldLabel6 = "//b[text()='" + pageFieldName4 + "']";
								String fieldLabel6_actual = (driver.findElement(By.xpath(fieldLabel6)).getText())
										.trim();

								if (fieldLabel6_actual.equals(pageFieldName4)) {
									successMessage("The sixth field label is displayed successfully.");
								} else {
									verificationFailedMessage("The sixth field label is not displayed.");
								}
							} catch (Throwable t) {
								verificationFailedMessage("The sixth field label is not displayed.");
							}

						} else {
							verificationFailedMessage("The newly created custom form is not displayed.");
						}

					} catch (Throwable t) {
						verificationFailedMessage("The newly created custom form is not displayed.");
					}

				} catch (Throwable t) {
					verificationFailedMessage("The Property Information section is not displayed.");
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

				try {
					// scrolldown till Property Information section
					scrollTillElement("customform_portfoliodashboard_propertyinformationtitle_XPATH");

					// validate the newly created custom form in the portfolio dashboard screen
					try {
						String customForm1 = "//td[text()='" + data.get("name") + "']";
						String customForm1_actual = (driver.findElement(By.xpath(customForm1)).getText()).trim();

						if (customForm1_actual.equals(data.get("name"))) {
							successMessage("The newly created custom form is displayed successfully.");

						} else {
							verificationFailedMessage("The newly created custom form is not displayed.");
						}

					} catch (Throwable t) {
						verificationFailedMessage("The newly created custom form is not displayed.");
					}

					// click on the custom form
					String customForm1 = "//td[text()='" + data.get("name") + "']";
					driver.findElement(By.xpath(customForm1)).click();
					consoleMessage("Clicked on the custom form.");

					// validate the field 1
					try {
						String field11 = "//th[text()='" + fieldName1 + "']";
						String field11_actual = (driver.findElement(By.xpath(field11)).getText()).trim();

						if (field11_actual.equals(fieldName1)) {
							successMessage("The respective field is displayed successfully.");
						} else {
							verificationFailedMessage("The repsective field is not displayed.");
						}
					} catch (Throwable t) {
						verificationFailedMessage("The repsective field is not displayed.");
					}

					// validate the field 2
					try {
						String field22 = "//th[text()='" + fieldName2 + "']";
						String field22_actual = (driver.findElement(By.xpath(field22)).getText()).trim();

						if (field22_actual.equals(fieldName2)) {
							successMessage("The respective field is displayed successfully.");
						} else {
							verificationFailedMessage("The repsective field is not displayed.");
						}
					} catch (Throwable t) {
						verificationFailedMessage("The repsective field is not displayed.");
					}

					// validate the field 1 of page 1
					try {
						String field33 = "//th[text()='" + pageFieldName1 + "']";
						String field33_actual = (driver.findElement(By.xpath(field33)).getText()).trim();

						if (field33_actual.equals(pageFieldName1)) {

							successMessage("The respective field is displayed successfully.");

						} else {
							verificationFailedMessage("The repsective field is not displayed.");
						}
					} catch (Throwable t) {
						verificationFailedMessage("The repsective field is not displayed.");
					}

					// validate the field 2 of page 1
					try {
						String field44 = "//th[text()='" + pageFieldName2 + "']";
						String field44_actual = (driver.findElement(By.xpath(field44)).getText()).trim();

						if (field44_actual.equals(pageFieldName2)) {

							successMessage("The respective field is displayed successfully.");

						} else {
							verificationFailedMessage("The repsective field is not displayed.");
						}
					} catch (Throwable t) {
						verificationFailedMessage("The repsective field is not displayed.");
					}

					// validate the field 1 of page 2
					try {
						String field55 = "//th[text()='" + pageFieldName3 + "']";
						String field55_actual = (driver.findElement(By.xpath(field55)).getText()).trim();

						if (field55_actual.equals(pageFieldName3)) {

							successMessage("The respective field is displayed successfully.");

						} else {
							verificationFailedMessage("The repsective field is not displayed.");
						}
					} catch (Throwable t) {
						verificationFailedMessage("The repsective field is not displayed.");
					}

					// validate the field 2 of page 2
					try {
						String field66 = "//th[text()='" + pageFieldName4 + "']";
						String field66_actual = (driver.findElement(By.xpath(field66)).getText()).trim();

						if (field66_actual.equals(pageFieldName4)) {

							successMessage("The respective field is displayed successfully.");

						} else {
							verificationFailedMessage("The repsective field is not displayed.");
						}
					} catch (Throwable t) {
						verificationFailedMessage("The repsective field is not displayed.");
					}

				} catch (Throwable t) {
					verificationFailedMessage("The Property Information section is not displayed.");
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

			// VALIDATE THE FIELDS AND PAGES OF THE CUSTOM REPORT IN THE PROPERTY SUMMARY
			// DASHBOARD AND PORTFOLIO SUMMARY DASHBOARD - CONTRACTOR USER - JINESH
			// CONTRACTOR
			title("VALIDATE THE FIELDS AND PAGES OF THE CUSTOM REPORT IN THE PROPERTY SUMMARY DASHBOARD AND PORTFOLIO SUMMARY DASHBOARD - CONTRACTOR USER - JINESH CONTRACTOR");

			try {

				// wait for the element
				Thread.sleep(5000);

				// click on the property
				click("propertysummary_property1_XPATH");

				// validate the Property Information section and custom form is displayed or not
				try {

					// scrolldown till Property Information section
					scrollTillElement("customform_portfoliodashboard_propertyinformationtitle_XPATH");

					// validate the newly created custom form in the property summary dashboard
					// screen
					try {
						String customForm1 = "//td[text()='" + data.get("name") + "']";
						String customForm1_actual = (driver.findElement(By.xpath(customForm1)).getText()).trim();

						if (customForm1_actual.equals(data.get("name"))) {

							successMessage("The newly created custom form is displayed as expected.");

							// click on the newly created custom form
							String customFormName = "//td[text()='" + data.get("name") + "']";
							driver.findElement(By.xpath(customFormName)).click();
							consoleMessage("Clicked on the newly created custom form.");

							// validate the custom form as a title
							try {
								String customName = "//h4[contains(text(),'" + data.get("name") + "')]";
								String customName_actual = (driver.findElement(By.xpath(customName)).getText()).trim();

								if (customName_actual.equals(data.get("name"))) {
									successMessage("The custom form name is displayed correctly.");
								} else {
									verificationFailedMessage("The custom form is not displayed.");
								}
							} catch (Throwable t) {
								verificationFailedMessage("The custom form is not displayed.");
							}

							// validate the first field label
							try {
								String fieldLabel1 = "//b[text()='" + fieldName1 + "']";
								String fieldLabel1_actual = (driver.findElement(By.xpath(fieldLabel1)).getText())
										.trim();

								if (fieldLabel1_actual.equals(fieldName1)) {
									successMessage("The first field label is displayed successfully.");
								} else {
									verificationFailedMessage("The first field label is not displayed.");
								}
							} catch (Throwable t) {
								verificationFailedMessage("The first field label is not displayed.");
							}

							// validate the second field label
							try {
								String fieldLabel2 = "//b[text()='" + fieldName2 + "']";
								String fieldLabel2_actual = (driver.findElement(By.xpath(fieldLabel2)).getText())
										.trim();

								if (fieldLabel2_actual.equals(fieldName2)) {
									successMessage("The second field label is displayed successfully.");
								} else {
									verificationFailedMessage("The second field label is not displayed.");
								}
							} catch (Throwable t) {
								verificationFailedMessage("The second field label is not displayed.");
							}

							// validate the third field label
							try {
								String fieldLabel3 = "//b[text()='" + pageFieldName1 + "']";
								String fieldLabel3_actual = (driver.findElement(By.xpath(fieldLabel3)).getText())
										.trim();

								if (fieldLabel3_actual.equals(pageFieldName1)) {
									successMessage("The third field label is displayed successfully.");
								} else {
									verificationFailedMessage("The third field label is not displayed.");
								}
							} catch (Throwable t) {
								verificationFailedMessage("The third field label is not displayed.");
							}

							// validate the forth field label
							try {
								String fieldLabel4 = "//b[text()='" + pageFieldName2 + "']";
								String fieldLabel4_actual = (driver.findElement(By.xpath(fieldLabel4)).getText())
										.trim();

								if (fieldLabel4_actual.equals(pageFieldName2)) {
									successMessage("The forth field label is displayed successfully.");
								} else {
									verificationFailedMessage("The forth field label is not displayed.");
								}
							} catch (Throwable t) {
								verificationFailedMessage("The forth field label is not displayed.");
							}

							// validate the fifth field label
							try {
								String fieldLabel5 = "//b[text()='" + pageFieldName3 + "']";
								String fieldLabel5_actual = (driver.findElement(By.xpath(fieldLabel5)).getText())
										.trim();

								if (fieldLabel5_actual.equals(pageFieldName3)) {
									successMessage("The fifth field label is displayed successfully.");
								} else {
									verificationFailedMessage("The fifth field label is not displayed.");
								}
							} catch (Throwable t) {
								verificationFailedMessage("The fifth field label is not displayed.");
							}

							// validate the sixth field label
							try {
								String fieldLabel6 = "//b[text()='" + pageFieldName4 + "']";
								String fieldLabel6_actual = (driver.findElement(By.xpath(fieldLabel6)).getText())
										.trim();

								if (fieldLabel6_actual.equals(pageFieldName4)) {
									successMessage("The sixth field label is displayed successfully.");
								} else {
									verificationFailedMessage("The sixth field label is not displayed.");
								}
							} catch (Throwable t) {
								verificationFailedMessage("The sixth field label is not displayed.");
							}

						} else {
							verificationFailedMessage("The newly created custom form is not displayed.");
						}

					} catch (Throwable t) {
						verificationFailedMessage("The newly created custom form is not displayed.");
					}

				} catch (Throwable t) {
					verificationFailedMessage("The Property Information section is not displayed.");
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

				try {
					// scrolldown till Property Information section
					scrollTillElement("customform_portfoliodashboard_propertyinformationtitle_XPATH");

					// validate the newly created custom form in the portfolio dashboard screen
					try {
						String customForm1 = "//td[text()='" + data.get("name") + "']";
						String customForm1_actual = (driver.findElement(By.xpath(customForm1)).getText()).trim();

						if (customForm1_actual.equals(data.get("name"))) {
							successMessage("The newly created custom form is displayed successfully.");

						} else {
							verificationFailedMessage("The newly created custom form is not displayed.");
						}

					} catch (Throwable t) {
						verificationFailedMessage("The newly created custom form is not displayed.");
					}

					// click on the custom form
					String customForm1 = "//td[text()='" + data.get("name") + "']";
					driver.findElement(By.xpath(customForm1)).click();
					consoleMessage("Clicked on the custom form.");

					// validate the field 1
					try {
						String field11 = "//th[text()='" + fieldName1 + "']";
						String field11_actual = (driver.findElement(By.xpath(field11)).getText()).trim();

						if (field11_actual.equals(fieldName1)) {
							successMessage("The respective field is displayed successfully.");
						} else {
							verificationFailedMessage("The repsective field is not displayed.");
						}
					} catch (Throwable t) {
						verificationFailedMessage("The repsective field is not displayed.");
					}

					// validate the field 2
					try {
						String field22 = "//th[text()='" + fieldName2 + "']";
						String field22_actual = (driver.findElement(By.xpath(field22)).getText()).trim();

						if (field22_actual.equals(fieldName2)) {
							successMessage("The respective field is displayed successfully.");
						} else {
							verificationFailedMessage("The repsective field is not displayed.");
						}
					} catch (Throwable t) {
						verificationFailedMessage("The repsective field is not displayed.");
					}

					// validate the field 1 of page 1
					try {
						String field33 = "//th[text()='" + pageFieldName1 + "']";
						String field33_actual = (driver.findElement(By.xpath(field33)).getText()).trim();

						if (field33_actual.equals(pageFieldName1)) {

							successMessage("The respective field is displayed successfully.");

						} else {
							verificationFailedMessage("The repsective field is not displayed.");
						}
					} catch (Throwable t) {
						verificationFailedMessage("The repsective field is not displayed.");
					}

					// validate the field 2 of page 1
					try {
						String field44 = "//th[text()='" + pageFieldName2 + "']";
						String field44_actual = (driver.findElement(By.xpath(field44)).getText()).trim();

						if (field44_actual.equals(pageFieldName2)) {

							successMessage("The respective field is displayed successfully.");

						} else {
							verificationFailedMessage("The repsective field is not displayed.");
						}
					} catch (Throwable t) {
						verificationFailedMessage("The repsective field is not displayed.");
					}

					// validate the field 1 of page 2
					try {
						String field55 = "//th[text()='" + pageFieldName3 + "']";
						String field55_actual = (driver.findElement(By.xpath(field55)).getText()).trim();

						if (field55_actual.equals(pageFieldName3)) {

							successMessage("The respective field is displayed successfully.");

						} else {
							verificationFailedMessage("The repsective field is not displayed.");
						}
					} catch (Throwable t) {
						verificationFailedMessage("The repsective field is not displayed.");
					}

					// validate the field 2 of page 2
					try {
						String field66 = "//th[text()='" + pageFieldName4 + "']";
						String field66_actual = (driver.findElement(By.xpath(field66)).getText()).trim();

						if (field66_actual.equals(pageFieldName4)) {

							successMessage("The respective field is displayed successfully.");

						} else {
							verificationFailedMessage("The repsective field is not displayed.");
						}
					} catch (Throwable t) {
						verificationFailedMessage("The repsective field is not displayed.");
					}

				} catch (Throwable t) {
					verificationFailedMessage("The Property Information section is not displayed.");
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

			// VALIDATE THE FIELDS AND PAGES OF THE CUSTOM REPORT IN THE PROPERTY SUMMARY
			// DASHBOARD AND PORTFOLIO DASHBOARD - HR USER - JINESH HR
			title("VALIDATE THE FIELDS AND PAGES OF THE CUSTOM REPORT IN THE PROPERTY SUMMARY DASHBOARD AND PORTFOLIO DASHBOARD - HR USER - JINESH HR");

			try {

				// VALIDATE ON PROPERTY SUMMARY DASHBOARD
				consoleMessage("VALIDATE ON PROPERTY SUMMARY DASHBOARD");

				// wait for the element
				Thread.sleep(5000);

				// click on the property
				click("propertysummary_property1_XPATH");

				// validate the Property Information section and custom form is displayed or not
				try {

					// scrolldown till Property Information section
					scrollTillElement("customform_portfoliodashboard_propertyinformationtitle_XPATH");

					// validate the newly created custom form in the property summary dashboard
					// screen
					try {
						String customForm1 = "//td[text()='" + data.get("name") + "']";
						String customForm1_actual = (driver.findElement(By.xpath(customForm1)).getText()).trim();

						if (customForm1_actual.equals(data.get("name"))) {

							verificationFailedMessage("The newly created custom form is displayed.");

						} else {
							successMessage("The newly created custom form is not displayed as expected.");
						}

					} catch (Throwable t) {
						successMessage("The newly created custom form is not displayed as expected.");
					}

				} catch (Throwable t) {
					successMessage("The Property Information section is not displayed as expected.");
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

				try {
					// scrolldown till Property Information section
					scrollTillElement("customform_portfoliodashboard_propertyinformationtitle_XPATH");

					// validate the newly created custom form in the portfolio dashboard screen
					try {
						String customForm1 = "//td[text()='" + data.get("name") + "']";
						String customForm1_actual = (driver.findElement(By.xpath(customForm1)).getText()).trim();

						if (customForm1_actual.equals(data.get("name"))) {
							verificationFailedMessage("The newly created custom form is displayed.");

						} else {
							successMessage("The newly created custom form is not displayed as expected.");
						}

					} catch (Throwable t) {
						successMessage("The newly created custom form is not displayed as expected.");
					}

				} catch (Throwable t) {
					successMessage("The Property Information section is not displayed as expected.");
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
			String deleteIcon = "//td[text()='" + data.get("name")
					+ "']//following-sibling::td[@class='pointer']//i[@data-target='#deleteCustomFormModal']";
			driver.findElement(By.xpath(deleteIcon)).click();
			consoleMessage("Clicked on the delete button of the newly created custom form.");

			// wait for the element
			Thread.sleep(5000);

			// click on the delete button
			click("customform_deletebtn_XPATH");

			// validate the respective record is deleted or not
			try {
				String deletedRecord = "//td[text()='" + data.get("name") + "']";
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
