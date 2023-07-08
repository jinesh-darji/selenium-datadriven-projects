package testcases.E2Etestcasesuite.taskmodule;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Random;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import base.Helper;
import base.TestBase;
import utilities.TestUtil;

public class RR6633Task15Test extends TestBase {

	@Test(dataProviderClass = TestUtil.class, dataProvider = "dp")
	public void rR6633Task15Test(Hashtable<String, String> data) throws IOException, InterruptedException {

		execution(data, "rR6633Task15Test");

		// VALIDATE THE “JUMP TO CUSTOM FORM“ OPTION IN THE TASK (PROPERTY SUMMARY
		// DASHBOARD AND PORTFOLIO DASHBOARD) AND THE “JUMP SURVEY/INSPECTION/CUSTOM
		// FORM“ BUTTON OF THE CORPORATE LEVEL CUSTOM FORM, AFTER APPLYING THE 'USER TO
		// VIEW FORM' AND 'ROLE TO VIEW FORM' PERMISSIONS TO THE CORPORATE LEVEL CUSTOM
		// FORM.
		title("VALIDATE THE “JUMP TO CUSTOM FORM“ OPTION IN THE TASK (PROPERTY SUMMARY DASHBOARD "
				+ "AND PORTFOLIO DASHBOARD) AND THE “JUMP SURVEY/INSPECTION/CUSTOM FORM“ BUTTON OF "
				+ "THE CORPORATE LEVEL CUSTOM FORM, AFTER APPLYING THE 'USER TO VIEW FORM' AND 'ROLE "
				+ "TO VIEW FORM' PERMISSIONS TO THE CORPORATE LEVEL CUSTOM FORM.");

		Helper helper = new Helper();

		// refresh the page
		driver.navigate().refresh();
		Thread.sleep(5000);
		driver.navigate().refresh();

		String name = RandomStringUtils.randomAlphabetic(8); // Custom Form Name
		String fieldName1 = RandomStringUtils.randomAlphabetic(8); // Normal Field 1
		String field1Detail = RandomStringUtils.randomAlphabetic(8); // Normal Field Detail 1
		List<String> field1Detail_list = new ArrayList<String>();
		String pageName1 = RandomStringUtils.randomAlphabetic(8); // Page Name 1
		String pageFieldName1 = RandomStringUtils.randomAlphabetic(8); // Page Name 1 - Field 1
		String pageField1Detail = RandomStringUtils.randomAlphabetic(8); // Page Detail 1 - Field 1
		List<String> pageField1Detail_list = new ArrayList<String>();
		String taskTitle1 = RandomStringUtils.randomAlphabetic(8); // Task Created by Admin User
		String taskTitle2 = RandomStringUtils.randomAlphabetic(8); // Task Created by Property Manager User from
																	// Property Summary Dashboard
		String taskTitle3 = RandomStringUtils.randomAlphabetic(8); // Task Created by Property Manager User from
																	// Portfolio Summary Dashboard

		Random random = new Random();
		int count = random.nextInt(5 - 3) + 3;

		// CREATE NEW CUSTOM FORMS FOR CORPORATE LEVEL RECORD
		title("CREATE NEW CUSTOM FORMS FOR CORPORATE LEVEL RECORD");

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

			// click on the update button
			click("customform_updatebtn_XPATH");

			// wait for the element
			explicitWaitClickable("closetoastmsg_CSS");

			// click on the toaster close button
			click("closetoastmsg_CSS");

			// ADD THE SECURITY PERMISSION OF VIEW CUSTOMER FORM FOR THE JINESH (PROPERTY
			// MANAGER)
			title("ADD THE SECURITY PERMISSION OF VIEW CUSTOMER FORM FOR THE JINESH (PROPERTY MANAGER)");

			// click on the security tab
			click("customform_securitytab_XPATH");

			// click on the User to view form field
			click("customform_securitytab_security1_XPATH");

			// click on the none button
			click("customform_securitytab_nonebtn_XPATH");

			// enter the user name in the search field
			type("customform_securitytab_searchtxt_XPATH", data.get("user1"));

			// click on the searched result
			click("customform_securitytab_searchedresult1_XPATH");

			// click on the User to view form field
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

		// ADD THE DETAILS IN THE FIELDS ON RANDOMLY FROM THE PROPERTY SUMMARY DASHBOARD
		title("ADD THE DETAILS IN THE FIELDS ON RANDOMLY FROM THE PROPERTY SUMMARY DASHBOARD");

		try {

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
					successMessage("The newly created custom form is displayed successfully.");

				} else {
					verificationFailedMessage("The newly created custom form is not displayed.");
				}

			} catch (Throwable t) {
				verificationFailedMessage("The newly created custom form is not displayed.");
			}

			// click on the custom form
			String customForm1 = "//td[text()='" + name + "']";
			driver.findElement(By.xpath(customForm1)).click();
			consoleMessage("Clicked on the custom form.");

			// wait for the element
			Thread.sleep(5000);

			consoleMessage("The details in fields will entered " + count + " times.");

			// enter details in the fields on random number
			for (int i = 0; i < count; i++) {

				// click on the add button
				click("customform_portfoliodashboard_addbtn_XPATH");

				// wait for the element
				Thread.sleep(5000);

				// scroll to bottom
				scrollBottom();

				// enter the details in the first field
				field1Detail = RandomStringUtils.randomAlphabetic(8);
				String firstField = "//input[@id='" + fieldName1 + "TEXT']";
				driver.findElement(By.xpath(firstField)).sendKeys(field1Detail);
				consoleMessage("Entered the details in the first field.");

				// collect the random details of the first field
				field1Detail_list.add(field1Detail);
				consoleMessage("New count of data of the field 1 : " + field1Detail_list.size());

				// click on the page one tab
				String page1 = "//span[text()='" + pageName1 + "']";
				driver.findElement(By.xpath(page1)).click();
				consoleMessage("Clicked on the page one tab.");

				// enter the details in the first field
				pageField1Detail = RandomStringUtils.randomAlphabetic(8);
				String pageFirstField = "//input[@id='" + pageFieldName1 + "TEXT']";
				driver.findElement(By.xpath(pageFirstField)).sendKeys(pageField1Detail);
				consoleMessage("Entered the details in the first field.");

				// collect the random details of the first field
				pageField1Detail_list.add(pageField1Detail);
				consoleMessage("New count of data of the field 1 of page one : " + pageField1Detail_list.size());

				// click on the save button
				click("customform_portfoliodashboard_fields_savebtn_XPATH");

				// scrolldown to bottom
				scrollBottom();

				// wait for the element
				Thread.sleep(5000);

				// validate the details of the first field
				try {
					String firstField1 = "//span[contains(text(),'" + field1Detail + "')]";
					String firstField1_actual = (driver.findElement(By.xpath(firstField1)).getText()).trim();

					if (firstField1_actual.equals(field1Detail)) {
						successMessage("The details of the first field is displayed successfully.");
					} else {
						verificationFailedMessage("The details of the first field is not displayed.");
					}
				} catch (Throwable t) {
					verificationFailedMessage("The details of the first field is not displayed.");
				}

				// validate the details of the first field of page one
				try {
					String thirdField1 = "//span[contains(text(),'" + pageField1Detail + "')]";
					String thirdField1_actual = (driver.findElement(By.xpath(thirdField1)).getText()).trim();

					if (thirdField1_actual.equals(pageField1Detail)) {
						successMessage("The details of the first field of page one is displayed successfully.");
					} else {
						verificationFailedMessage("The details of the first field of page one is not displayed.");
					}
				} catch (Throwable t) {
					verificationFailedMessage("The details of the first field of page one is not displayed.");
				}

			}

			consoleMessage("End of for loop and The total number of count is " + pageField1Detail_list.size());

		} catch (Throwable t) {
			verificationFailed();
		}

		// click on the home icon from the top of the screen
		click("questionnaire_homeburgermenubtn_hide_CSS");

		// wait for the element
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// CREATE THE NEW TASK (1) AND ASSOCIATE THE NEWLY CREATED CUSTOM FORM - ADMIN
		// USER
		title("CREATE THE NEW TASK (1) AND ASSOCIATE THE NEWLY CREATED CUSTOM FORM - ADMIN USER");

		try {
			// wait for the element
			Thread.sleep(3000);

			// click on the task icon of the respective property
			click("taskicon_CSS");

			// click on the add task button
			click("task_addtaskbtn_CSS");

			// enter the data in the task title field
			type("task_addtask_titletxt_CSS", taskTitle1);

			// enter the data in the task location field
			type("task_addtask_locationtxt_CSS", data.get("task_location"));

			// click on the assign to field
			click("task_assigntotxt_CSS");

			// click on the none button
			click("task_tasktag_nonebtn_CSS");

			// enter the user name in the search field
			type("workflowsecurity_editortask_taskdetails_searchtasktagtxt_CSS", data.get("user1"));

			// click on the searched result
			click("questionnaire_createtask_selectusertxt_XPATH");

			// enter the user name in the search field
			type("workflowsecurity_editortask_taskdetails_searchtasktagtxt_CSS", data.get("role1"));

			// click on the searched result
			click("questionnaire_createtask_selectroletxt1_XPATH");

			// enter the user name in the search field
			type("workflowsecurity_editortask_taskdetails_searchtasktagtxt_CSS", data.get("user2"));

			// click on the searched result
			click("questionnaire_createtask_selectroletxt2_XPATH");

			// click on the assign to field
			click("task_assigntotxt_CSS");

			// scroll down the screen
			scrollTop();

			// click on the task association tab
			click("task_taskassociationtab_XPATH");

			// scroll down the screen
			scrollBottom();

			// validate the jump to survey/inspection/custom form button
			try {
				boolean jumpbtn = driver.findElement(By.xpath(OR.getProperty("task_taskassociationtab_jumpbtn_XPATH")))
						.isDisplayed();

				if (jumpbtn == true) {
					verificationFailedMessage("The jump to survey/inspection/custom form button is displayed.");

				} else {
					successMessage("The jump to survey/inspection/custom form button is not displayed as expected.");
				}
			} catch (Throwable t) {
				successMessage("The jump to survey/inspection/custom form button is not displayed as expected.");
			}

			// click on the custom form button
			click("task_taskassociationtab_customformbtn_XPATH");

			// select the newly created custom form from the dropdown
			select("survey_task_questionnairedd_CSS", name);

			// click on the save button
			click("survey_task_savebtn_XPATH");

			// scroll up the screen
			scrollTop();

			// click on the clear button
			click("task_createdtask_clearbtn_XPATH");

			// enter the data in the search field
			type("task_filter_CSS", taskTitle1);

			// click on the search button
			click("task_createdtask_searchbtn_XPATH");

			// verify newly created task is displayed or not
			try {
				String task = "//p[contains(text(),'" + taskTitle1 + "')]";
				String task_actual = (driver.findElement(By.xpath(task)).getText()).trim();

				if (task_actual.equals(taskTitle1)) {
					successMessage("The newly created task is verified successfully.");
				} else {
					verificationFailedMessage("The newly created task is not verified.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The newly created task is not verified.");
			}

			// VERIFY JUMP SURVEY/INSPECTION/CUSTOM FORM BUTTON IS DISPLAYED OR NOT WITHOUT
			// PERMISSION - ADMIN USER
			title("VERIFY JUMP SURVEY/INSPECTION/CUSTOM FORM BUTTON IS DISPLAYED OR NOT WITHOUT PERMISSION - ADMIN USER");

			// click on the newly created task
			String task = "//p[contains(text(),'" + taskTitle1 + "')]";
			driver.findElement(By.xpath(task)).click();
			consoleMessage("click on the newly created task.");

			// wait for the element
			Thread.sleep(3000);

			// click on the task association tab
			click("task_taskassociationtab_XPATH");

			// scroll down the screen
			scrollBottom();

			// validate the survey radio button
			try {
				boolean surveybtn = driver.findElement(By.xpath(OR.getProperty("survey_task_surveybtn_XPATH")))
						.isEnabled();

				if (surveybtn == true) {
					successMessage("The radio button of survey is displayed enabled as expected.");
				} else {
					verificationFailedMessage("The radio button of survey is not displayed enabled.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The radio button of survey is not displayed enabled.");
			}

			// validate the inspection radio button
			try {
				boolean inspectionbtn = driver
						.findElement(By.xpath(OR.getProperty("task_taskassociationtab_inspectionbtn_XPATH")))
						.isEnabled();

				if (inspectionbtn == true) {
					successMessage("The radio button of inspection is displayed enabled as expected.");
				} else {
					verificationFailedMessage("The radio button of inspection is not displayed enabled.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The radio button of inspection is not displayed enabled.");
			}

			// validate the custom form radio button
			try {
				boolean customformbtn = driver
						.findElement(By.xpath(OR.getProperty("task_taskassociationtab_customformbtn_XPATH")))
						.isEnabled();

				if (customformbtn == true) {
					successMessage("The radio button of custom form is displayed enabled as expected.");
				} else {
					verificationFailedMessage("The radio button of custom form is not displayed enabled.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The radio button of custom form is not displayed enabled.");
			}

			// validate the dropdown of custom form
			try {
				boolean dropdown = driver
						.findElement(By.xpath(OR.getProperty("task_taskassociationtab_questionnerdd_XPATH")))
						.isEnabled();

				if (dropdown == true) {
					successMessage("The dropdown of survey enabled as expected.");
				} else {
					verificationFailedMessage("The dropdown of survey is not displayed enabled.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The dropdown of survey is not displayed enabled.");
			}

			// validate the selected custom form is displayed or not
			try {
				String selectedCustomForm = "//option[@label='" + name + "' and @selected='selected']";
				boolean dropdown = driver.findElement(By.xpath(selectedCustomForm)).isDisplayed();

				if (dropdown == true) {
					successMessage("The selected option in the custom form dropdown is displayed as expected.");
				} else {
					verificationFailedMessage("The selected option in the custom form dropdown is not displayed.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The selected option in the custom form dropdown is not displayed.");
			}

			// validate the jump to survey/inspection/custom form button
			try {
				boolean jumpbtn = driver.findElement(By.xpath(OR.getProperty("task_taskassociationtab_jumpbtn_XPATH")))
						.isDisplayed();

				if (jumpbtn == true) {
					verificationFailedMessage("The jump to survey/inspection/custom form button is displayed.");

				} else {
					successMessage("The jump to survey/inspection/custom form button is not displayed as expected.");
				}
			} catch (Throwable t) {
				successMessage("The jump to survey/inspection/custom form button is not displayed as expected.");
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

			// VALIDATE THE JUMP SURVEY/INSPECTION/CUSTOM FORM BUTTON OF THE TASK (1) IS
			// LAUNCHED ASSOCIATED CORPORATE LEVEL CUSTOM FORM WHICH WAS CREATED BY ADMIN
			// USER - PROPERTY MANAGER USER - JINESH
			title("VALIDATE THE JUMP SURVEY/INSPECTION/CUSTOM FORM BUTTON OF THE TASK (1) IS LAUNCHED ASSOCIATED CORPORATE LEVEL CUSTOM FORM WHICH WAS CREATED BY ADMIN USER - PROPERTY MANAGER USER - JINESH");

			try {

				// wait for the element
				Thread.sleep(3000);

				// click on the task icon of the respective property
				click("taskicon_CSS");

				// click on the clear button
				click("task_createdtask_clearbtn_XPATH");

				// enter the data in the search field
				type("task_filter_CSS", taskTitle1);

				// click on the search button
				click("task_createdtask_searchbtn_XPATH");

				// verify newly created task is displayed or not
				try {
					String task = "//p[contains(text(),'" + taskTitle1 + "')]";
					String task_actual = (driver.findElement(By.xpath(task)).getText()).trim();

					if (task_actual.equals(taskTitle1)) {
						successMessage("The newly created task is verified successfully.");
					} else {
						verificationFailedMessage("The newly created task is not verified.");
					}
				} catch (Throwable t) {
					verificationFailedMessage("The newly created task is not verified.");
				}

				// click on the newly created task
				String task = "//p[contains(text(),'" + taskTitle1 + "')]";
				driver.findElement(By.xpath(task)).click();
				consoleMessage("click on the newly created task.");

				// wait for the element
				Thread.sleep(3000);

				// click on the task association tab
				click("task_taskassociationtab_XPATH");

				// scroll down the screen
				scrollBottom();

				// validate the survey radio button
				try {
					boolean surveybtn = driver
							.findElement(By.xpath(OR.getProperty("survey_task_surveybtn_disabled_XPATH"))).isEnabled();

					if (surveybtn == false) {
						successMessage("The radio button of survey is displayed disabled as expected.");
					} else {
						verificationFailedMessage("The radio button of survey is not displayed disabled.");
					}
				} catch (Throwable t) {
					verificationFailedMessage("The radio button of survey is not displayed disabled.");
				}

				// validate the inspection radio button
				try {
					boolean inspectionbtn = driver
							.findElement(
									By.xpath(OR.getProperty("task_taskassociationtab_inspectionbtn_disabled_XPATH")))
							.isEnabled();

					if (inspectionbtn == false) {
						successMessage("The radio button of inspection is displayed disabled as expected.");
					} else {
						verificationFailedMessage("The radio button of inspection is not displayed disabled.");
					}
				} catch (Throwable t) {
					verificationFailedMessage("The radio button of inspection is not displayed disabled.");
				}

				// validate the custom form radio button
				try {
					boolean customformbtn = driver
							.findElement(
									By.xpath(OR.getProperty("task_taskassociationtab_customformbtn_disabled_XPATH")))
							.isEnabled();

					if (customformbtn == false) {
						successMessage("The radio button of custom form is displayed disabled as expected.");
					} else {
						verificationFailedMessage("The radio button of custom form is not displayed disabled.");
					}
				} catch (Throwable t) {
					verificationFailedMessage("The radio button of custom form is not displayed disabled.");
				}

				// validate the dropdown of custom form
				try {
					boolean dropdown = driver
							.findElement(
									By.xpath(OR.getProperty("task_taskassociationtab_questionnerdd_disabled_XPATH")))
							.isEnabled();

					if (dropdown == false) {
						successMessage("The dropdown of custom form disabled as expected.");
					} else {
						verificationFailedMessage("The dropdown of custom form is not displayed disabled.");
					}
				} catch (Throwable t) {
					verificationFailedMessage("The dropdown of custom form is not displayed disabled.");
				}

				// validate the selected custom form is displayed or not
				try {
					String selectedQuestionnaire = "//option[@label='" + name + "' and @selected='selected']";
					boolean dropdown = driver.findElement(By.xpath(selectedQuestionnaire)).isDisplayed();

					if (dropdown == true) {
						successMessage("The selected option in the custom form dropdown is displayed as expected.");
					} else {
						verificationFailedMessage("The selected option in the custom form dropdown is not displayed.");
					}
				} catch (Throwable t) {
					verificationFailedMessage("The selected option in the custom form dropdown is not displayed.");
				}

				// validate the jump to survey/inspection/custom form button
				try {
					boolean jumpbtn = driver
							.findElement(By.xpath(OR.getProperty("task_taskassociationtab_jumpbtn_XPATH")))
							.isDisplayed();

					if (jumpbtn == true) {
						successMessage("The jump to survey/inspection/custom form button is displayed as expected.");
					} else {
						verificationFailedMessage("The jump to survey/inspection/custom form button is not displayed.");
					}
				} catch (Throwable t) {
					verificationFailedMessage("The jump to survey/inspection/custom form button is not displayed.");
				}

				// click on the jump to survey/inspection/custom form button
				click("task_taskassociationtab_jumpbtn_XPATH");

				// wait for the element
				Thread.sleep(10000);

				// scrolldown to bottom
				scrollBottom();

				// validate the custom form as a title
				try {
					String customName = "//h4[contains(text(),'" + name + "')]";
					String customName_actual = (driver.findElement(By.xpath(customName)).getText()).trim();

					if (customName_actual.equals(name)) {
						successMessage("The custom form name is displayed correctly.");
					} else {
						verificationFailedMessage("The custom form is not displayed.");
					}
				} catch (Throwable t) {
					verificationFailedMessage("The custom form is not displayed.");
				}

				for (int m = 0; m < count; m++) {

					// validate the details of the first field
					try {
						consoleMessage(field1Detail_list.get(m));
						String firstField1 = "//span[contains(text(),'" + field1Detail_list.get(m) + "')]";
						String firstField1_actual = (driver.findElement(By.xpath(firstField1)).getText()).trim();

						if (firstField1_actual.equals(field1Detail_list.get(m))) {
							successMessage("The details of the first field is displayed successfully.");
						} else {
							verificationFailedMessage("The details of the first field is not displayed.");
						}
					} catch (Throwable t) {
						verificationFailedMessage("The details of the first field is not displayed.");
					}

					// validate the details of the first field of page one
					try {
						consoleMessage(pageField1Detail_list.get(m));
						String firstField1 = "//span[contains(text(),'" + pageField1Detail_list.get(m) + "')]";
						String firstField1_actual = (driver.findElement(By.xpath(firstField1)).getText()).trim();

						if (firstField1_actual.equals(pageField1Detail_list.get(m))) {
							successMessage("The details of the first field of page one is displayed successfully.");
						} else {
							verificationFailedMessage("The details of the first field of page one is not displayed.");
						}
					} catch (Throwable t) {
						verificationFailedMessage("The details of the first field of page one is not displayed.");
					}

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

			// CREATE THE NEW TASK (2) UNDER THE CORPORATE LEVEL CUSTOM FORM FROM PROPERTY
			// SUMMARY DASHBOARD - PROPERTY MANAGER USER - JINESH
			title("CREATE THE NEW TASK (2) UNDER THE CORPORATE LEVEL CUSTOM FORM FROM PROPERTY SUMMARY DASHBOARD - PROPERTY MANAGER USER - JINESH");

			try {
				// wait for the element
				Thread.sleep(3000);

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
						successMessage("The newly created custom form is displayed successfully.");

					} else {
						verificationFailedMessage("The newly created custom form is not displayed.");
					}

				} catch (Throwable t) {
					verificationFailedMessage("The newly created custom form is not displayed.");
				}

				// click on the custom form
				String customForm1 = "//td[text()='" + name + "']";
				driver.findElement(By.xpath(customForm1)).click();
				consoleMessage("Clicked on the custom form.");

				// scroll to bottom
				scrollBottom();

				// click on the action icon
				click("customform_propertydashboard_actionicon_XPATH");

				// click on the task option
				click("customform_propertydashboard_taskoption_XPATH");

				// scroll down to bottom
				scrollBottom();

				// click on the add task button
				click("customform_propertydashboard_newtaskbtn_XPATH");

				// enter the data in the task title field
				type("task_addtask_titletxt_CSS", taskTitle2);

				// enter the data in the task location field
				type("task_addtask_locationtxt_CSS", data.get("task_location"));

				// scroll down to bottom
				scrollBottom();

				// click on the assign to field
				click("task_assigntotxt_CSS");

				// click on the none button
				click("task_tasktag_nonebtn_CSS");

				// enter the user name in the search field
				type("workflowsecurity_editortask_taskdetails_searchtasktagtxt_CSS", data.get("user1"));

				// click on the searched result
				click("questionnaire_createtask_selectusertxt_XPATH");

				// enter the user name in the search field
				type("workflowsecurity_editortask_taskdetails_searchtasktagtxt_CSS", data.get("role1"));

				// click on the searched result
				click("questionnaire_createtask_selectroletxt1_XPATH");

				// enter the user name in the search field
				type("workflowsecurity_editortask_taskdetails_searchtasktagtxt_CSS", data.get("user2"));

				// click on the searched result
				click("questionnaire_createtask_selectroletxt2_XPATH");

				// click on the assign to field
				click("task_assigntotxt_CSS");

				// click on the save button
				click("customform_propertydashboard_savebtn_XPATH");

				// validate the newly created task in the custom form in the property summary
				// dashboard screen
				try {
					String task1 = "//td[text()='" + taskTitle2 + "']";
					String task1_actual = (driver.findElement(By.xpath(task1)).getText()).trim();

					if (task1_actual.equals(taskTitle2)) {
						successMessage("The newly created task in the custom form is displayed successfully.");

					} else {
						verificationFailedMessage("The newly created task in the custom form is not displayed.");
					}

				} catch (Throwable t) {
					verificationFailedMessage("The newly created task in the custom form is not displayed.");
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

			// VALIDATE THE NEWLY CREATED TASK (2) UNDER CORPORATE LEVEL CUSTOM FORM IN THE
			// TASK
			// MODULE AND ASSOCIATE THE SAME TASK (2) WITH THE NEWLY CREATED CORPORATE LEVEL
			// CUSTOM FORM (PROPERTY SUMMARY DASHBOARD) - PROPERTY MANAGER USER - JINESH
			title("VALIDATE THE NEWLY CREATED TASK (2) UNDER CORPORATE LEVEL CUSTOM FORM IN THE TASK MODULE AND ASSOCIATE THE SAME TASK (2) WITH THE NEWLY CREATED CORPORATE LEVEL CUSTOM FORM (PROPERTY SUMMARY DASHBOARD) - PROPERTY MANAGER USER - JINESH");

			try {

				// wait for the element
				Thread.sleep(3000);

				// click on the task icon of the respective property
				click("taskicon_CSS");

				// click on the clear button
				click("task_createdtask_clearbtn_XPATH");

				// enter the data in the search field
				type("task_filter_CSS", taskTitle2);

				// click on the search button
				click("task_createdtask_searchbtn_XPATH");

				// verify newly created task is displayed or not
				try {
					String task = "//p[contains(text(),'" + taskTitle2 + "')]";
					String task_actual = (driver.findElement(By.xpath(task)).getText()).trim();

					if (task_actual.equals(taskTitle2)) {
						successMessage("The newly created task is verified successfully.");
					} else {
						verificationFailedMessage("The newly created task is not verified.");
					}
				} catch (Throwable t) {
					verificationFailedMessage("The newly created task is not verified.");
				}

				// click on the newly created task
				String task = "//p[contains(text(),'" + taskTitle2 + "')]";
				driver.findElement(By.xpath(task)).click();
				consoleMessage("click on the newly created task.");

				// wait for the element
				Thread.sleep(3000);

				// click on the task association tab
				click("task_taskassociationtab_XPATH");

				// scroll down the screen
				scrollBottom();

				// scroll down the screen
				scrollBottom();

				// validate the jump to survey/inspection/custom form button
				try {
					boolean jumpbtn = driver
							.findElement(By.xpath(OR.getProperty("task_taskassociationtab_jumpbtn_XPATH")))
							.isDisplayed();

					if (jumpbtn == true) {
						verificationFailedMessage("The jump to survey/inspection/custom form button is displayed.");

					} else {
						successMessage(
								"The jump to survey/inspection/custom form button is not displayed as expected.");
					}
				} catch (Throwable t) {
					successMessage("The jump to survey/inspection/custom form button is not displayed as expected.");
				}

				// click on the custom form button
				click("task_taskassociationtab_customformbtn_XPATH");

				// select the newly created custom form from the dropdown
				select("survey_task_questionnairedd_CSS", name);

				// click on the save button
				click("survey_task_savebtn_XPATH");

				// scroll up the screen
				scrollTop();

				// click on the clear button
				click("task_createdtask_clearbtn_XPATH");

				// enter the data in the search field
				type("task_filter_CSS", taskTitle2);

				// click on the search button
				click("task_createdtask_searchbtn_XPATH");

				// verify newly created task is displayed or not
				try {
					task = "//p[contains(text(),'" + taskTitle2 + "')]";
					String task_actual = (driver.findElement(By.xpath(task)).getText()).trim();

					if (task_actual.equals(taskTitle2)) {
						successMessage("The newly created task is verified successfully.");
					} else {
						verificationFailedMessage("The newly created task is not verified.");
					}
				} catch (Throwable t) {
					verificationFailedMessage("The newly created task is not verified.");
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

			// VALIDATE THE JUMP SURVEY/INSPECTION/CUSTOM FORM BUTTON IS LAUNCHED ASSOCIATED
			// CORPORATE LEVEL CUSTOM FORM OF THE TASK (2) AND VALIDATE THE JUMP TO MULTIPLE
			// TYPE
			// CUSTOM FORM OPTION OF THE SAME TASK (2) (PROPERTY SUMMARY DASHBOARD) -
			// PROPERTY MANAGER USER - JINESH
			title("VALIDATE THE JUMP SURVEY/INSPECTION/CUSTOM FORM BUTTON IS LAUNCHED ASSOCIATED CORPORATE LEVEL CUSTOM FORM OF THE TASK (2) AND VALIDATE THE JUMP TO CORPORATE LEVEL CUSTOM FORM OPTION OF THE SAME TASK (2) (PROPERTY SUMMARY DASHBOARD) - PROPERTY MANAGER USER - JINESH");

			try {

				// wait for the element
				Thread.sleep(3000);

				// click on the task icon of the respective property
				click("taskicon_CSS");

				// click on the clear button
				click("task_createdtask_clearbtn_XPATH");

				// enter the data in the search field
				type("task_filter_CSS", taskTitle2);

				// click on the search button
				click("task_createdtask_searchbtn_XPATH");

				// verify newly created task is displayed or not
				try {
					String task = "//p[contains(text(),'" + taskTitle2 + "')]";
					String task_actual = (driver.findElement(By.xpath(task)).getText()).trim();

					if (task_actual.equals(taskTitle2)) {
						successMessage("The newly created task is verified successfully.");
					} else {
						verificationFailedMessage("The newly created task is not verified.");
					}
				} catch (Throwable t) {
					verificationFailedMessage("The newly created task is not verified.");
				}

				// click on the newly created task
				String task = "//p[contains(text(),'" + taskTitle2 + "')]";
				driver.findElement(By.xpath(task)).click();
				consoleMessage("click on the newly created task.");

				// wait for the element
				Thread.sleep(3000);

				// click on the task association tab
				click("task_taskassociationtab_XPATH");

				// scroll down the screen
				scrollBottom();

				// validate the survey radio button
				try {
					boolean surveybtn = driver.findElement(By.xpath(OR.getProperty("survey_task_surveybtn_XPATH")))
							.isEnabled();

					if (surveybtn == true) {
						successMessage("The radio button of survey is displayed enabled as expected.");
					} else {
						verificationFailedMessage("The radio button of survey is not displayed enabled.");
					}
				} catch (Throwable t) {
					verificationFailedMessage("The radio button of survey is not displayed enabled.");
				}

				// validate the inspection radio button
				try {
					boolean inspectionbtn = driver
							.findElement(By.xpath(OR.getProperty("task_taskassociationtab_inspectionbtn_XPATH")))
							.isEnabled();

					if (inspectionbtn == true) {
						successMessage("The radio button of inspection is displayed enabled as expected.");
					} else {
						verificationFailedMessage("The radio button of inspection is not displayed enabled.");
					}
				} catch (Throwable t) {
					verificationFailedMessage("The radio button of inspection is not displayed enabled.");
				}

				// validate the custom form radio button
				try {
					boolean customformbtn = driver
							.findElement(By.xpath(OR.getProperty("task_taskassociationtab_customformbtn_XPATH")))
							.isEnabled();

					if (customformbtn == true) {
						successMessage("The radio button of custom form is displayed enabled as expected.");
					} else {
						verificationFailedMessage("The radio button of custom form is not displayed enabled.");
					}
				} catch (Throwable t) {
					verificationFailedMessage("The radio button of custom form is not displayed enabled.");
				}

				// validate the dropdown of custom form
				try {
					boolean dropdown = driver
							.findElement(By.xpath(OR.getProperty("task_taskassociationtab_questionnerdd_XPATH")))
							.isEnabled();

					if (dropdown == true) {
						successMessage("The dropdown of survey enabled as expected.");
					} else {
						verificationFailedMessage("The dropdown of survey is not displayed enabled.");
					}
				} catch (Throwable t) {
					verificationFailedMessage("The dropdown of survey is not displayed enabled.");
				}

				// validate the selected custom form is displayed or not
				try {
					String selectedCustomForm = "//option[@label='" + name + "' and @selected='selected']";
					boolean dropdown = driver.findElement(By.xpath(selectedCustomForm)).isDisplayed();

					if (dropdown == true) {
						successMessage("The selected option in the custom form dropdown is displayed as expected.");
					} else {
						verificationFailedMessage("The selected option in the custom form dropdown is not displayed.");
					}
				} catch (Throwable t) {
					verificationFailedMessage("The selected option in the custom form dropdown is not displayed.");
				}

				// validate the jump to survey/inspection/custom form button
				try {
					boolean jumpbtn = driver
							.findElement(By.xpath(OR.getProperty("task_taskassociationtab_jumpbtn_XPATH")))
							.isDisplayed();

					if (jumpbtn == true) {
						successMessage("The jump to survey/inspection/custom form button is displayed as expected.");
					} else {
						verificationFailedMessage("The jump to survey/inspection/custom form button is not displayed.");
					}
				} catch (Throwable t) {
					verificationFailedMessage("The jump to survey/inspection/custom form button is not displayed.");
				}

				// click on the start button
				click("propertyproject_mu_repair_startbtn_CSS");

				// wait for the element
				Thread.sleep(3000);

				// validate the survey radio button
				try {
					boolean surveybtn = driver
							.findElement(By.xpath(OR.getProperty("survey_task_surveybtn_disabled_XPATH"))).isEnabled();

					if (surveybtn == false) {
						successMessage("The radio button of survey is displayed disabled as expected.");
					} else {
						verificationFailedMessage("The radio button of survey is not displayed disabled.");
					}
				} catch (Throwable t) {
					verificationFailedMessage("The radio button of survey is not displayed disabled.");
				}

				// validate the inspection radio button
				try {
					boolean inspectionbtn = driver
							.findElement(
									By.xpath(OR.getProperty("task_taskassociationtab_inspectionbtn_disabled_XPATH")))
							.isEnabled();

					if (inspectionbtn == false) {
						successMessage("The radio button of inspection is displayed disabled as expected.");
					} else {
						verificationFailedMessage("The radio button of inspection is not displayed disabled.");
					}
				} catch (Throwable t) {
					verificationFailedMessage("The radio button of inspection is not displayed disabled.");
				}

				// validate the custom form radio button
				try {
					boolean customformbtn = driver
							.findElement(
									By.xpath(OR.getProperty("task_taskassociationtab_customformbtn_disabled_XPATH")))
							.isEnabled();

					if (customformbtn == false) {
						successMessage("The radio button of custom form is displayed disabled as expected.");
					} else {
						verificationFailedMessage("The radio button of custom form is not displayed disabled.");
					}
				} catch (Throwable t) {
					verificationFailedMessage("The radio button of custom form is not displayed disabled.");
				}

				// validate the dropdown of custom form
				try {
					boolean dropdown = driver
							.findElement(
									By.xpath(OR.getProperty("task_taskassociationtab_questionnerdd_disabled_XPATH")))
							.isEnabled();

					if (dropdown == false) {
						successMessage("The dropdown of custom form disabled as expected.");
					} else {
						verificationFailedMessage("The dropdown of custom form is not displayed disabled.");
					}
				} catch (Throwable t) {
					verificationFailedMessage("The dropdown of custom form is not displayed disabled.");
				}

				// validate the selected custom form is displayed or not
				try {
					String selectedQuestionnaire = "//option[@label='" + name + "' and @selected='selected']";
					boolean dropdown = driver.findElement(By.xpath(selectedQuestionnaire)).isDisplayed();

					if (dropdown == true) {
						successMessage("The selected option in the custom form dropdown is displayed as expected.");
					} else {
						verificationFailedMessage("The selected option in the custom form dropdown is not displayed.");
					}
				} catch (Throwable t) {
					verificationFailedMessage("The selected option in the custom form dropdown is not displayed.");
				}

				// validate the jump to survey/inspection/custom form button
				try {
					boolean jumpbtn = driver
							.findElement(By.xpath(OR.getProperty("task_taskassociationtab_jumpbtn_XPATH")))
							.isDisplayed();

					if (jumpbtn == true) {
						successMessage("The jump to survey/inspection/custom form button is displayed as expected.");
					} else {
						verificationFailedMessage("The jump to survey/inspection/custom form button is not displayed.");
					}
				} catch (Throwable t) {
					verificationFailedMessage("The jump to survey/inspection/custom form button is not displayed.");
				}

				// click on the jump to survey/inspection/custom form button
				click("task_taskassociationtab_jumpbtn_XPATH");

				// wait for the element
				Thread.sleep(10000);

				// scroll up to top
				scrollTop();

				// validate the custom form as a title
				try {
					String customName = "//h4[contains(text(),'" + name + "')]";
					String customName_actual = (driver.findElement(By.xpath(customName)).getText()).trim();

					if (customName_actual.equals(name)) {
						successMessage("The custom form name is displayed correctly.");
					} else {
						verificationFailedMessage("The custom form is not displayed.");
					}
				} catch (Throwable t) {
					verificationFailedMessage("The custom form is not displayed.");
				}

				for (int m = 0; m < count; m++) {

					// validate the details of the first field
					try {
						consoleMessage(field1Detail_list.get(m));
						String firstField1 = "//span[contains(text(),'" + field1Detail_list.get(m) + "')]";
						String firstField1_actual = (driver.findElement(By.xpath(firstField1)).getText()).trim();

						if (firstField1_actual.equals(field1Detail_list.get(m))) {
							successMessage("The details of the first field is displayed successfully.");
						} else {
							verificationFailedMessage("The details of the first field is not displayed.");
						}
					} catch (Throwable t) {
						verificationFailedMessage("The details of the first field is not displayed.");
					}

					// validate the details of the first field of page one
					try {
						consoleMessage(pageField1Detail_list.get(m));
						String firstField1 = "//span[contains(text(),'" + pageField1Detail_list.get(m) + "')]";
						String firstField1_actual = (driver.findElement(By.xpath(firstField1)).getText()).trim();

						if (firstField1_actual.equals(pageField1Detail_list.get(m))) {
							successMessage("The details of the first field of page one is displayed successfully.");
						} else {
							verificationFailedMessage("The details of the first field of page one is not displayed.");
						}
					} catch (Throwable t) {
						verificationFailedMessage("The details of the first field of page one is not displayed.");
					}

				}

				// wait for the element
				Thread.sleep(3000);

				// click on the back button
				click("customform_propertydashboard_backbtn_XPATH");

				// wait for the element
				Thread.sleep(3000);

				// scroll upto top
				scrollTop();

				// click on the clear button
				click("task_createdtask_clearbtn_XPATH");

				// enter the data in the search field
				type("task_filter_CSS", taskTitle2);

				// click on the search button
				click("task_createdtask_searchbtn_XPATH");

				// click on the action icon
				String actionIcon = "//p[text()='" + taskTitle2
						+ "']//parent::td//following-sibling::td[@class='text-center pointer']//i[@data-toggle='dropdown']";
				driver.findElement(By.xpath(actionIcon)).click();
				consoleMessage("Clicked on the action icon.");

				// click on the jump to custom form option
				String jumptoOption = "//p[text()='" + taskTitle2
						+ "']//parent::td//following-sibling::td[@class='text-center pointer']//div[@class='dropdown open']//li[@ng-show='isDefined(task.customFormName)']";
				driver.findElement(By.xpath(jumptoOption)).click();
				consoleMessage("Clicked on the jump to custom form option.");

				// wait for the element
				Thread.sleep(10000);

				// scroll up to top
				scrollTop();

				// validate the custom form as a title
				try {
					String customName = "//h4[contains(text(),'" + name + "')]";
					String customName_actual = (driver.findElement(By.xpath(customName)).getText()).trim();

					if (customName_actual.equals(name)) {
						successMessage("The custom form name is displayed correctly.");
					} else {
						verificationFailedMessage("The custom form is not displayed.");
					}
				} catch (Throwable t) {
					verificationFailedMessage("The custom form is not displayed.");
				}

				// click on the details tab
				String details = "//span[text()='Details']";
				driver.findElement(By.xpath(details)).click();
				consoleMessage("Clicked on the details tab.");

				// scroll down to bottom
				scrollBottom();

				// validate the first field label
				try {
					String fieldLabel1 = "//label[contains(text(),'" + fieldName1 + "')]";
					String fieldLabel1_actual = (driver.findElement(By.xpath(fieldLabel1)).getText()).trim();

					if (fieldLabel1_actual.equals(fieldName1 + ":")) {
						successMessage("The first field label is displayed successfully.");
					} else {
						verificationFailedMessage("The first field label is not displayed.");
					}
				} catch (Throwable t) {
					verificationFailedMessage("The first field label is not displayed.");
				}

				// click on the first page name tab
				String pageTab1 = "//span[text()='" + pageName1 + "']";
				driver.findElement(By.xpath(pageTab1)).click();
				consoleMessage("Clicked on the first page name tab.");

				// scroll to bottom
				scrollBottom();

				// validate the third field label
				try {
					String fieldLabel3 = "//label[contains(text(),'" + pageFieldName1 + "')]";
					String fieldLabel3_actual = (driver.findElement(By.xpath(fieldLabel3)).getText()).trim();

					if (fieldLabel3_actual.equals(pageFieldName1 + ":")) {
						successMessage("The third field label is displayed successfully.");
					} else {
						verificationFailedMessage("The third field label is not displayed.");
					}
				} catch (Throwable t) {
					verificationFailedMessage("The third field label is not displayed.");
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

			// CREATE THE NEW TASK (3) UNDER THE CORPORATE LEVEL CUSTOM FORM FROM PORTFOLIO
			// SUMMARY DASHBOARD - PROPERTY MANAGER USER - JINESH
			title("CREATE THE NEW TASK (3) UNDER THE CORPORATE LEVEL CUSTOM FORM FROM PORTFOLIO SUMMARY DASHBOARD - PROPERTY MANAGER USER - JINESH");

			try {
				// wait for the element
				Thread.sleep(5000);

				// click on the side menu
				click("menubtn_CSS");

				// wait for the element
				Thread.sleep(5000);

				// click on the portfolio dashboard from side menu
				click("sidemenu_portfoliosummary_XPATH");

				// scrolldown till Property Information section
				scrollTillElement("customform_portfoliodashboard_propertyinformationtitle_XPATH");

				// validate the newly created custom form in the property summary dashboard
				// screen
				try {
					String customForm1 = "//td[text()='" + name + "']";
					String customForm1_actual = (driver.findElement(By.xpath(customForm1)).getText()).trim();

					if (customForm1_actual.equals(name)) {
						successMessage("The newly created custom form is displayed successfully.");

					} else {
						verificationFailedMessage("The newly created custom form is not displayed.");
					}

				} catch (Throwable t) {
					verificationFailedMessage("The newly created custom form is not displayed.");
				}

				// click on the custom form
				String customForm1 = "//td[text()='" + name + "']";
				driver.findElement(By.xpath(customForm1)).click();
				consoleMessage("Clicked on the custom form.");

				// scroll to bottom
				scrollBottom();

				// click on the property one
				click("customform_portfoliodashboard_propertyname_XPATH");

				// scroll to bottom
				scrollBottom();

				// click on the action icon
				click("customform_propertydashboard_actionicon_XPATH");

				// click on the task option
				click("customform_propertydashboard_taskoption_XPATH");

				// scroll down to bottom
				scrollBottom();

				// click on the add task button
				click("customform_propertydashboard_newtaskbtn_XPATH");

				// enter the data in the task title field
				type("task_addtask_titletxt_CSS", taskTitle3);

				// enter the data in the task location field
				type("task_addtask_locationtxt_CSS", data.get("task_location"));

				// scroll down to bottom
				scrollBottom();

				// click on the assign to field
				click("task_assigntotxt_CSS");

				// click on the none button
				click("task_tasktag_nonebtn_CSS");

				// enter the user name in the search field
				type("workflowsecurity_editortask_taskdetails_searchtasktagtxt_CSS", data.get("user1"));

				// click on the searched result
				click("questionnaire_createtask_selectusertxt_XPATH");

				// enter the user name in the search field
				type("workflowsecurity_editortask_taskdetails_searchtasktagtxt_CSS", data.get("role1"));

				// click on the searched result
				click("questionnaire_createtask_selectroletxt1_XPATH");

				// enter the user name in the search field
				type("workflowsecurity_editortask_taskdetails_searchtasktagtxt_CSS", data.get("user2"));

				// click on the searched result
				click("questionnaire_createtask_selectroletxt2_XPATH");

				// click on the assign to field
				click("task_assigntotxt_CSS");

				// click on the save button
				click("customform_propertydashboard_savebtn_XPATH");

				// validate the newly created task in the custom form in the property summary
				// dashboard screen
				try {
					String task1 = "//td[text()='" + taskTitle3 + "']";
					String task1_actual = (driver.findElement(By.xpath(task1)).getText()).trim();

					if (task1_actual.equals(taskTitle3)) {
						successMessage("The newly created task in the custom form is displayed successfully.");

					} else {
						verificationFailedMessage("The newly created task in the custom form is not displayed.");
					}

				} catch (Throwable t) {
					verificationFailedMessage("The newly created task in the custom form is not displayed.");
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

			// VALIDATE THE NEWLY CREATED TASK (3) UNDER CORPORATE LEVEL CUSTOM FORM IN THE
			// TASK MODULE AND ASSOCIATE THE SAME TASK (3) WITH THE NEWLY CREATED MULTIPLE
			// TYPE CUSTOM FORM (PORTFOLIO SUMMARY DASHBOARD) - PROPERTY MANAGER USER -
			// JINESH
			title("VALIDATE THE NEWLY CREATED TASK (3) UNDER CORPORATE LEVEL CUSTOM FORM IN THE TASK MODULE AND ASSOCIATE THE SAME TASK (3) WITH THE NEWLY CREATED CORPORATE LEVEL CUSTOM FORM (PORTFOLIO SUMMARY DASHBOARD) - PROPERTY MANAGER USER - JINESH");

			try {

				// wait for the element
				Thread.sleep(3000);

				// click on the task icon of the respective property
				click("taskicon_CSS");

				// click on the clear button
				click("task_createdtask_clearbtn_XPATH");

				// enter the data in the search field
				type("task_filter_CSS", taskTitle3);

				// click on the search button
				click("task_createdtask_searchbtn_XPATH");

				// verify newly created task is displayed or not
				try {
					String task = "//p[contains(text(),'" + taskTitle3 + "')]";
					String task_actual = (driver.findElement(By.xpath(task)).getText()).trim();

					if (task_actual.equals(taskTitle3)) {
						successMessage("The newly created task is verified successfully.");
					} else {
						verificationFailedMessage("The newly created task is not verified.");
					}
				} catch (Throwable t) {
					verificationFailedMessage("The newly created task is not verified.");
				}

				// click on the newly created task
				String task = "//p[contains(text(),'" + taskTitle3 + "')]";
				driver.findElement(By.xpath(task)).click();
				consoleMessage("click on the newly created task.");

				// wait for the element
				Thread.sleep(3000);

				// click on the task association tab
				click("task_taskassociationtab_XPATH");

				// scroll down the screen
				scrollBottom();

				// scroll down the screen
				scrollBottom();

				// validate the jump to survey/inspection/custom form button
				try {
					boolean jumpbtn = driver
							.findElement(By.xpath(OR.getProperty("task_taskassociationtab_jumpbtn_XPATH")))
							.isDisplayed();

					if (jumpbtn == true) {
						verificationFailedMessage("The jump to survey/inspection/custom form button is displayed.");

					} else {
						successMessage(
								"The jump to survey/inspection/custom form button is not displayed as expected.");
					}
				} catch (Throwable t) {
					successMessage("The jump to survey/inspection/custom form button is not displayed as expected.");
				}

				// click on the custom form button
				click("task_taskassociationtab_customformbtn_XPATH");

				// select the newly created custom form from the dropdown
				select("survey_task_questionnairedd_CSS", name);

				// click on the save button
				click("survey_task_savebtn_XPATH");

				// scroll up the screen
				scrollTop();

				// click on the clear button
				click("task_createdtask_clearbtn_XPATH");

				// enter the data in the search field
				type("task_filter_CSS", taskTitle3);

				// click on the search button
				click("task_createdtask_searchbtn_XPATH");

				// verify newly created task is displayed or not
				try {
					task = "//p[contains(text(),'" + taskTitle3 + "')]";
					String task_actual = (driver.findElement(By.xpath(task)).getText()).trim();

					if (task_actual.equals(taskTitle3)) {
						successMessage("The newly created task is verified successfully.");
					} else {
						verificationFailedMessage("The newly created task is not verified.");
					}
				} catch (Throwable t) {
					verificationFailedMessage("The newly created task is not verified.");
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

			// VALIDATE THE JUMP SURVEY/INSPECTION/CUSTOM FORM BUTTON IS LAUNCHED ASSOCIATED
			// CORPORATE LEVEL CUSTOM FORM OF THE TASK (3) AND VALIDATE THE JUMP TO MULTIPLE
			// TYPE CUSTOM FORM OPTION OF THE SAME TASK (3) (PORTFOLIO SUMMARY DASHBOARD) -
			// PROPERTY MANAGER USER - JINESH
			title("VALIDATE THE JUMP SURVEY/INSPECTION/CUSTOM FORM BUTTON IS LAUNCHED ASSOCIATED CORPORATE LEVEL CUSTOM FORM OF THE TASK (3) AND VALIDATE THE JUMP TO CORPORATE LEVEL CUSTOM FORM OPTION OF THE SAME TASK (3) (PORTFOLIO SUMMARY DASHBOARD) - PROPERTY MANAGER USER - JINESH");

			try {

				// wait for the element
				Thread.sleep(3000);

				// click on the task icon of the respective property
				click("taskicon_CSS");

				// click on the clear button
				click("task_createdtask_clearbtn_XPATH");

				// enter the data in the search field
				type("task_filter_CSS", taskTitle3);

				// click on the search button
				click("task_createdtask_searchbtn_XPATH");

				// verify newly created task is displayed or not
				try {
					String task = "//p[contains(text(),'" + taskTitle3 + "')]";
					String task_actual = (driver.findElement(By.xpath(task)).getText()).trim();

					if (task_actual.equals(taskTitle3)) {
						successMessage("The newly created task is verified successfully.");
					} else {
						verificationFailedMessage("The newly created task is not verified.");
					}
				} catch (Throwable t) {
					verificationFailedMessage("The newly created task is not verified.");
				}

				// click on the newly created task
				String task = "//p[contains(text(),'" + taskTitle3 + "')]";
				driver.findElement(By.xpath(task)).click();
				consoleMessage("click on the newly created task.");

				// wait for the element
				Thread.sleep(3000);

				// click on the task association tab
				click("task_taskassociationtab_XPATH");

				// scroll down the screen
				scrollBottom();

				// validate the survey radio button
				try {
					boolean surveybtn = driver.findElement(By.xpath(OR.getProperty("survey_task_surveybtn_XPATH")))
							.isEnabled();

					if (surveybtn == true) {
						successMessage("The radio button of survey is displayed enabled as expected.");
					} else {
						verificationFailedMessage("The radio button of survey is not displayed enabled.");
					}
				} catch (Throwable t) {
					verificationFailedMessage("The radio button of survey is not displayed enabled.");
				}

				// validate the inspection radio button
				try {
					boolean inspectionbtn = driver
							.findElement(By.xpath(OR.getProperty("task_taskassociationtab_inspectionbtn_XPATH")))
							.isEnabled();

					if (inspectionbtn == true) {
						successMessage("The radio button of inspection is displayed enabled as expected.");
					} else {
						verificationFailedMessage("The radio button of inspection is not displayed enabled.");
					}
				} catch (Throwable t) {
					verificationFailedMessage("The radio button of inspection is not displayed enabled.");
				}

				// validate the custom form radio button
				try {
					boolean customformbtn = driver
							.findElement(By.xpath(OR.getProperty("task_taskassociationtab_customformbtn_XPATH")))
							.isEnabled();

					if (customformbtn == true) {
						successMessage("The radio button of custom form is displayed enabled as expected.");
					} else {
						verificationFailedMessage("The radio button of custom form is not displayed enabled.");
					}
				} catch (Throwable t) {
					verificationFailedMessage("The radio button of custom form is not displayed enabled.");
				}

				// validate the dropdown of custom form
				try {
					boolean dropdown = driver
							.findElement(By.xpath(OR.getProperty("task_taskassociationtab_questionnerdd_XPATH")))
							.isEnabled();

					if (dropdown == true) {
						successMessage("The dropdown of survey enabled as expected.");
					} else {
						verificationFailedMessage("The dropdown of survey is not displayed enabled.");
					}
				} catch (Throwable t) {
					verificationFailedMessage("The dropdown of survey is not displayed enabled.");
				}

				// validate the selected custom form is displayed or not
				try {
					String selectedCustomForm = "//option[@label='" + name + "' and @selected='selected']";
					boolean dropdown = driver.findElement(By.xpath(selectedCustomForm)).isDisplayed();

					if (dropdown == true) {
						successMessage("The selected option in the custom form dropdown is displayed as expected.");
					} else {
						verificationFailedMessage("The selected option in the custom form dropdown is not displayed.");
					}
				} catch (Throwable t) {
					verificationFailedMessage("The selected option in the custom form dropdown is not displayed.");
				}

				// validate the jump to survey/inspection/custom form button
				try {
					boolean jumpbtn = driver
							.findElement(By.xpath(OR.getProperty("task_taskassociationtab_jumpbtn_XPATH")))
							.isDisplayed();

					if (jumpbtn == true) {
						successMessage("The jump to survey/inspection/custom form button is displayed as expected.");
					} else {
						verificationFailedMessage("The jump to survey/inspection/custom form button is not displayed.");
					}
				} catch (Throwable t) {
					verificationFailedMessage("The jump to survey/inspection/custom form button is not displayed.");
				}

				// click on the jump to survey/inspection/custom form button
				click("task_taskassociationtab_jumpbtn_XPATH");

				// wait for the element
				Thread.sleep(10000);

				// scrolldown to bottom
				scrollBottom();

				// validate the custom form as a title
				try {
					String customName = "//h4[contains(text(),'" + name + "')]";
					String customName_actual = (driver.findElement(By.xpath(customName)).getText()).trim();

					if (customName_actual.equals(name)) {
						successMessage("The custom form name is displayed correctly.");
					} else {
						verificationFailedMessage("The custom form is not displayed.");
					}
				} catch (Throwable t) {
					verificationFailedMessage("The custom form is not displayed.");
				}

				for (int m = 0; m < count; m++) {

					// validate the details of the first field
					try {
						consoleMessage(field1Detail_list.get(m));
						String firstField1 = "//span[contains(text(),'" + field1Detail_list.get(m) + "')]";
						String firstField1_actual = (driver.findElement(By.xpath(firstField1)).getText()).trim();

						if (firstField1_actual.equals(field1Detail_list.get(m))) {
							successMessage("The details of the first field is displayed successfully.");
						} else {
							verificationFailedMessage("The details of the first field is not displayed.");
						}
					} catch (Throwable t) {
						verificationFailedMessage("The details of the first field is not displayed.");
					}

					// validate the details of the first field of page one
					try {
						consoleMessage(pageField1Detail_list.get(m));
						String firstField1 = "//span[contains(text(),'" + pageField1Detail_list.get(m) + "')]";
						String firstField1_actual = (driver.findElement(By.xpath(firstField1)).getText()).trim();

						if (firstField1_actual.equals(pageField1Detail_list.get(m))) {
							successMessage("The details of the first field of page one is displayed successfully.");
						} else {
							verificationFailedMessage("The details of the first field of page one is not displayed.");
						}
					} catch (Throwable t) {
						verificationFailedMessage("The details of the first field of page one is not displayed.");
					}

				}

				// wait for the element
				Thread.sleep(3000);

				// click on the back button
				click("customform_propertydashboard_backbtn_XPATH");

				// wait for the element
				Thread.sleep(3000);

				// scroll upto top
				scrollTop();

				// click on the clear button
				click("task_createdtask_clearbtn_XPATH");

				// enter the data in the search field
				type("task_filter_CSS", taskTitle3);

				// click on the search button
				click("task_createdtask_searchbtn_XPATH");

				// click on the action icon
				String actionIcon = "//p[text()='" + taskTitle3
						+ "']//parent::td//following-sibling::td[@class='text-center pointer']//i[@data-toggle='dropdown']";
				driver.findElement(By.xpath(actionIcon)).click();
				consoleMessage("Clicked on the action icon.");

				// click on the jump to custom form option
				String jumptoOption = "//p[text()='" + taskTitle3
						+ "']//parent::td//following-sibling::td[@class='text-center pointer']//div[@class='dropdown open']//li[@ng-show='isDefined(task.customFormName)']";
				driver.findElement(By.xpath(jumptoOption)).click();
				consoleMessage("Clicked on the jump to custom form option.");

				// wait for the element
				Thread.sleep(10000);

				// scroll up to top
				scrollTop();

				// validate the custom form as a title
				try {
					String customName = "//h4[contains(text(),'" + name + "')]";
					String customName_actual = (driver.findElement(By.xpath(customName)).getText()).trim();

					if (customName_actual.equals(name)) {
						successMessage("The custom form name is displayed correctly.");
					} else {
						verificationFailedMessage("The custom form is not displayed.");
					}
				} catch (Throwable t) {
					verificationFailedMessage("The custom form is not displayed.");
				}

				// click on the details tab
				String details = "//span[text()='Details']";
				driver.findElement(By.xpath(details)).click();
				consoleMessage("Clicked on the details tab.");

				// scroll down to bottom
				scrollBottom();

				// validate the first field label
				try {
					String fieldLabel1 = "//label[contains(text(),'" + fieldName1 + "')]";
					String fieldLabel1_actual = (driver.findElement(By.xpath(fieldLabel1)).getText()).trim();

					if (fieldLabel1_actual.equals(fieldName1 + ":")) {
						successMessage("The first field label is displayed successfully.");
					} else {
						verificationFailedMessage("The first field label is not displayed.");
					}
				} catch (Throwable t) {
					verificationFailedMessage("The first field label is not displayed.");
				}

				// click on the first page name tab
				String pageTab1 = "//span[text()='" + pageName1 + "']";
				driver.findElement(By.xpath(pageTab1)).click();
				consoleMessage("Clicked on the first page name tab.");

				// scroll to bottom
				scrollBottom();

				// validate the third field label
				try {
					String fieldLabel3 = "//label[contains(text(),'" + pageFieldName1 + "')]";
					String fieldLabel3_actual = (driver.findElement(By.xpath(fieldLabel3)).getText()).trim();

					if (fieldLabel3_actual.equals(pageFieldName1 + ":")) {
						successMessage("The third field label is displayed successfully.");
					} else {
						verificationFailedMessage("The third field label is not displayed.");
					}
				} catch (Throwable t) {
					verificationFailedMessage("The third field label is not displayed.");
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

			// click on the User to view form field
			click("customform_securitytab_security1_XPATH");

			// click on the none button
			click("customform_securitytab_nonebtn_XPATH");

			// click on the User to view form field
			click("customform_securitytab_security1_XPATH");

			// click on the Role to view form field
			click("customform_securitytab_security2_XPATH");

			// click on the none button
			click("customform_securitytab_nonebtn_XPATH");

			// enter the user name in the search field
			type("customform_securitytab_searchtxt_XPATH", data.get("role1"));

			// click on the searched result
			click("customform_securitytab_searchedresult2_XPATH");

			// click on the Role to view form field
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

		// VERIFY JUMP SURVEY/INSPECTION/CUSTOM FORM BUTTON IS DISPLAYED OR NOT WITHOUT
		// PERMISSION - ADMIN USER
		title("VERIFY JUMP SURVEY/INSPECTION/CUSTOM FORM BUTTON IS DISPLAYED OR NOT WITHOUT PERMISSION - ADMIN USER");

		try {
			// wait for the element
			Thread.sleep(3000);

			// click on the task icon of the respective property
			click("taskicon_CSS");

			// click on the clear button
			click("task_createdtask_clearbtn_XPATH");

			// enter the data in the search field
			type("task_filter_CSS", taskTitle1);

			// click on the search button
			click("task_createdtask_searchbtn_XPATH");

			// verify newly created task is displayed or not
			try {
				String task = "//p[contains(text(),'" + taskTitle1 + "')]";
				String task_actual = (driver.findElement(By.xpath(task)).getText()).trim();

				if (task_actual.equals(taskTitle1)) {
					successMessage("The newly created task is verified successfully.");
				} else {
					verificationFailedMessage("The newly created task is not verified.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The newly created task is not verified.");
			}

			// click on the newly created task
			String task = "//p[contains(text(),'" + taskTitle1 + "')]";
			driver.findElement(By.xpath(task)).click();
			consoleMessage("click on the newly created task.");

			// wait for the element
			Thread.sleep(3000);

			// click on the task association tab
			click("task_taskassociationtab_XPATH");

			// scroll down the screen
			scrollBottom();

			// validate the survey radio button
			try {
				boolean surveybtn = driver.findElement(By.xpath(OR.getProperty("survey_task_surveybtn_XPATH")))
						.isEnabled();

				if (surveybtn == true) {
					successMessage("The radio button of survey is displayed enabled as expected.");
				} else {
					verificationFailedMessage("The radio button of survey is not displayed enabled.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The radio button of survey is not displayed enabled.");
			}

			// validate the inspection radio button
			try {
				boolean inspectionbtn = driver
						.findElement(By.xpath(OR.getProperty("task_taskassociationtab_inspectionbtn_XPATH")))
						.isEnabled();

				if (inspectionbtn == true) {
					successMessage("The radio button of inspection is displayed enabled as expected.");
				} else {
					verificationFailedMessage("The radio button of inspection is not displayed enabled.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The radio button of inspection is not displayed enabled.");
			}

			// validate the custom form radio button
			try {
				boolean customformbtn = driver
						.findElement(By.xpath(OR.getProperty("task_taskassociationtab_customformbtn_XPATH")))
						.isEnabled();

				if (customformbtn == true) {
					successMessage("The radio button of custom form is displayed enabled as expected.");
				} else {
					verificationFailedMessage("The radio button of custom form is not displayed enabled.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The radio button of custom form is not displayed enabled.");
			}

			// validate the dropdown of custom form
			try {
				boolean dropdown = driver
						.findElement(By.xpath(OR.getProperty("task_taskassociationtab_questionnerdd_XPATH")))
						.isEnabled();

				if (dropdown == true) {
					successMessage("The dropdown of survey enabled as expected.");
				} else {
					verificationFailedMessage("The dropdown of survey is not displayed enabled.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The dropdown of survey is not displayed enabled.");
			}

			// validate the selected custom form is displayed or not
			try {
				String selectedCustomForm = "//option[@label='" + name + "' and @selected='selected']";
				boolean dropdown = driver.findElement(By.xpath(selectedCustomForm)).isDisplayed();

				if (dropdown == true) {
					successMessage("The selected option in the custom form dropdown is displayed as expected.");
				} else {
					verificationFailedMessage("The selected option in the custom form dropdown is not displayed.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The selected option in the custom form dropdown is not displayed.");
			}

			// validate the jump to survey/inspection/custom form button
			try {
				boolean jumpbtn = driver.findElement(By.xpath(OR.getProperty("task_taskassociationtab_jumpbtn_XPATH")))
						.isDisplayed();

				if (jumpbtn == true) {
					verificationFailedMessage("The jump to survey/inspection/custom form button is displayed.");

				} else {
					successMessage("The jump to survey/inspection/custom form button is not displayed as expected.");
				}
			} catch (Throwable t) {
				successMessage("The jump to survey/inspection/custom form button is not displayed as expected.");
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

			// VALIDATE THE JUMP SURVEY/INSPECTION/CUSTOM FORM BUTTON IS LAUNCHED ASSOCIATED
			// CORPORATE LEVEL CUSTOM FORM OF THE TASK (1) WHICH WAS CREATED BY ADMIN USER -
			// PROPERTY MANAGER USER - JINESH
			title("VALIDATE THE JUMP SURVEY/INSPECTION/CUSTOM FORM BUTTON IS LAUNCHED ASSOCIATED CORPORATE LEVEL CUSTOM FORM OF THE TASK (1) WHICH WAS CREATED BY ADMIN USER - PROPERTY MANAGER USER - JINESH");

			try {
				// wait for the element
				Thread.sleep(3000);

				// click on the task icon of the respective property
				click("taskicon_CSS");

				// click on the clear button
				click("task_createdtask_clearbtn_XPATH");

				// enter the data in the search field
				type("task_filter_CSS", taskTitle1);

				// click on the search button
				click("task_createdtask_searchbtn_XPATH");

				// verify newly created task is displayed or not
				try {
					String task = "//p[contains(text(),'" + taskTitle1 + "')]";
					String task_actual = (driver.findElement(By.xpath(task)).getText()).trim();

					if (task_actual.equals(taskTitle1)) {
						successMessage("The newly created task is verified successfully.");
					} else {
						verificationFailedMessage("The newly created task is not verified.");
					}
				} catch (Throwable t) {
					verificationFailedMessage("The newly created task is not verified.");
				}

				// click on the newly created task
				String task = "//p[contains(text(),'" + taskTitle1 + "')]";
				driver.findElement(By.xpath(task)).click();
				consoleMessage("click on the newly created task.");

				// wait for the element
				Thread.sleep(3000);

				// click on the task association tab
				click("task_taskassociationtab_XPATH");

				// scroll down the screen
				scrollBottom();

				// validate the survey radio button
				try {
					boolean surveybtn = driver
							.findElement(By.xpath(OR.getProperty("survey_task_surveybtn_disabled_XPATH"))).isEnabled();

					if (surveybtn == false) {
						successMessage("The radio button of survey is displayed disabled as expected.");
					} else {
						verificationFailedMessage("The radio button of survey is not displayed disabled.");
					}
				} catch (Throwable t) {
					verificationFailedMessage("The radio button of survey is not displayed disabled.");
				}

				// validate the inspection radio button
				try {
					boolean inspectionbtn = driver
							.findElement(
									By.xpath(OR.getProperty("task_taskassociationtab_inspectionbtn_disabled_XPATH")))
							.isEnabled();

					if (inspectionbtn == false) {
						successMessage("The radio button of inspection is displayed disabled as expected.");
					} else {
						verificationFailedMessage("The radio button of inspection is not displayed disabled.");
					}
				} catch (Throwable t) {
					verificationFailedMessage("The radio button of inspection is not displayed disabled.");
				}

				// validate the custom form radio button
				try {
					boolean customformbtn = driver
							.findElement(
									By.xpath(OR.getProperty("task_taskassociationtab_customformbtn_disabled_XPATH")))
							.isEnabled();

					if (customformbtn == false) {
						successMessage("The radio button of custom form is displayed disabled as expected.");
					} else {
						verificationFailedMessage("The radio button of custom form is not displayed disabled.");
					}
				} catch (Throwable t) {
					verificationFailedMessage("The radio button of custom form is not displayed disabled.");
				}

				// validate the dropdown of custom form
				try {
					boolean dropdown = driver
							.findElement(
									By.xpath(OR.getProperty("task_taskassociationtab_questionnerdd_disabled_XPATH")))
							.isEnabled();

					if (dropdown == false) {
						successMessage("The dropdown of custom form disabled as expected.");
					} else {
						verificationFailedMessage("The dropdown of custom form is not displayed disabled.");
					}
				} catch (Throwable t) {
					verificationFailedMessage("The dropdown of custom form is not displayed disabled.");
				}

				// validate the selected custom form is displayed or not
				try {
					String selectedQuestionnaire = "//option[@label='" + name + "' and @selected='selected']";
					boolean dropdown = driver.findElement(By.xpath(selectedQuestionnaire)).isDisplayed();

					if (dropdown == true) {
						verificationFailedMessage(
								"The selected option in the custom form dropdown is displayed without permission.");
					} else {
						successMessage("The selected option in the custom form dropdown is not displayed as expected.");
					}
				} catch (Throwable t) {
					successMessage("The selected option in the custom form dropdown is not displayed as expected.");
				}

				// validate the jump to survey/inspection/custom form button
				try {
					boolean jumpbtn = driver
							.findElement(By.xpath(OR.getProperty("task_taskassociationtab_jumpbtn_XPATH")))
							.isDisplayed();

					if (jumpbtn == true) {
						verificationFailedMessage(
								"The jump to survey/inspection/custom form button is displayed without permission.");
					} else {
						successMessage(
								"The jump to survey/inspection/custom form button is not displayed as expected.");
					}
				} catch (Throwable t) {
					successMessage("The jump to survey/inspection/custom form button is not displayed as expected.");
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

			// VALIDATE THE JUMP SURVEY/INSPECTION/CUSTOM FORM BUTTON OF THE CORPORATE LEVEL
			// CUSTOM FORM OF THE TASK (2) WHICH WAS CREATED UNDER CORPORATE LEVEL CUSTOM
			// FORM
			// BY PROPERTY MANAGER USER - PROPERTY MANAGER USER - JINESH
			title("VALIDATE THE JUMP SURVEY/INSPECTION/CUSTOM FORM BUTTON OF THE CORPORATE LEVEL CUSTOM FORM OF THE TASK (2) WHICH WAS CREATED UNDER CORPORATE LEVEL CUSTOM FORM BY PROPERTY MANAGER USER - PROPERTY MANAGER USER - JINESH");

			try {
				// wait for the element
				Thread.sleep(3000);

				// click on the task icon of the respective property
				click("taskicon_CSS");

				// click on the clear button
				click("task_createdtask_clearbtn_XPATH");

				// enter the data in the search field
				type("task_filter_CSS", taskTitle2);

				// click on the search button
				click("task_createdtask_searchbtn_XPATH");

				// verify newly created task is displayed or not
				try {
					String task = "//p[contains(text(),'" + taskTitle2 + "')]";
					String task_actual = (driver.findElement(By.xpath(task)).getText()).trim();

					if (task_actual.equals(taskTitle2)) {
						successMessage("The newly created task is verified successfully.");
					} else {
						verificationFailedMessage("The newly created task is not verified.");
					}
				} catch (Throwable t) {
					verificationFailedMessage("The newly created task is not verified.");
				}

				// click on the newly created task
				String task = "//p[contains(text(),'" + taskTitle2 + "')]";
				driver.findElement(By.xpath(task)).click();
				consoleMessage("click on the newly created task.");

				// wait for the element
				Thread.sleep(3000);

				// click on the task association tab
				click("task_taskassociationtab_XPATH");

				// scroll down the screen
				scrollBottom();

				// validate the survey radio button
				try {
					boolean surveybtn = driver
							.findElement(By.xpath(OR.getProperty("survey_task_surveybtn_disabled_XPATH"))).isEnabled();

					if (surveybtn == false) {
						successMessage("The radio button of survey is displayed disabled as expected.");
					} else {
						verificationFailedMessage("The radio button of survey is not displayed disabled.");
					}
				} catch (Throwable t) {
					verificationFailedMessage("The radio button of survey is not displayed disabled.");
				}

				// validate the inspection radio button
				try {
					boolean inspectionbtn = driver
							.findElement(
									By.xpath(OR.getProperty("task_taskassociationtab_inspectionbtn_disabled_XPATH")))
							.isEnabled();

					if (inspectionbtn == false) {
						successMessage("The radio button of inspection is displayed disabled as expected.");
					} else {
						verificationFailedMessage("The radio button of inspection is not displayed disabled.");
					}
				} catch (Throwable t) {
					verificationFailedMessage("The radio button of inspection is not displayed disabled.");
				}

				// validate the custom form radio button
				try {
					boolean customformbtn = driver
							.findElement(
									By.xpath(OR.getProperty("task_taskassociationtab_customformbtn_disabled_XPATH")))
							.isEnabled();

					if (customformbtn == false) {
						successMessage("The radio button of custom form is displayed disabled as expected.");
					} else {
						verificationFailedMessage("The radio button of custom form is not displayed disabled.");
					}
				} catch (Throwable t) {
					verificationFailedMessage("The radio button of custom form is not displayed disabled.");
				}

				// validate the dropdown of custom form
				try {
					boolean dropdown = driver
							.findElement(
									By.xpath(OR.getProperty("task_taskassociationtab_questionnerdd_disabled_XPATH")))
							.isEnabled();

					if (dropdown == false) {
						successMessage("The dropdown of custom form disabled as expected.");
					} else {
						verificationFailedMessage("The dropdown of custom form is not displayed disabled.");
					}
				} catch (Throwable t) {
					verificationFailedMessage("The dropdown of custom form is not displayed disabled.");
				}

				// validate the selected custom form is displayed or not
				try {
					String selectedQuestionnaire = "//option[@label='" + name + "' and @selected='selected']";
					boolean dropdown = driver.findElement(By.xpath(selectedQuestionnaire)).isDisplayed();

					if (dropdown == true) {
						verificationFailedMessage(
								"The selected option in the custom form dropdown is displayed without permission.");
					} else {
						successMessage("The selected option in the custom form dropdown is not displayed as expected.");
					}
				} catch (Throwable t) {
					successMessage("The selected option in the custom form dropdown is not displayed as expected.");
				}

				// validate the jump to survey/inspection/custom form button
				try {
					boolean jumpbtn = driver
							.findElement(By.xpath(OR.getProperty("task_taskassociationtab_jumpbtn_XPATH")))
							.isDisplayed();

					if (jumpbtn == true) {
						verificationFailedMessage(
								"The jump to survey/inspection/custom form button is displayed without permission.");
					} else {
						successMessage(
								"The jump to survey/inspection/custom form button is not displayed as expected.");
					}
				} catch (Throwable t) {
					successMessage("The jump to survey/inspection/custom form button is not displayed as expected.");
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

			// VALIDATE THE JUMP TO CORPORATE LEVEL CUSTOM FORM OPTION OF THE TASK (2) WHICH
			// WAS CREATED BY PROPERTY MANAGER USER (PROPERTY SUMMARY DASHBOARD) - PROPERTY
			// MANAGER USER - JINESH
			title("VALIDATE THE JUMP TO CORPORATE LEVEL CUSTOM FORM OPTION OF THE TASK (2) WHICH WAS CREATED BY PROPERTY MANAGER USER (PROPERTY SUMMARY DASHBOARD) - PROPERTY MANAGER USER - JINESH");

			try {

				// wait for the element
				Thread.sleep(3000);

				// click on the task icon of the respective property
				click("taskicon_CSS");

				// click on the clear button
				click("task_createdtask_clearbtn_XPATH");

				// enter the data in the search field
				type("task_filter_CSS", taskTitle2);

				// click on the search button
				click("task_createdtask_searchbtn_XPATH");

				// verify newly created task is displayed or not
				try {
					String task = "//p[contains(text(),'" + taskTitle2 + "')]";
					String task_actual = (driver.findElement(By.xpath(task)).getText()).trim();

					if (task_actual.equals(taskTitle2)) {
						successMessage("The newly created task is verified successfully.");
					} else {
						verificationFailedMessage("The newly created task is not verified.");
					}
				} catch (Throwable t) {
					verificationFailedMessage("The newly created task is not verified.");
				}

				// click on the action icon
				String actionIcon = "//p[text()='" + taskTitle2
						+ "']//parent::td//following-sibling::td[@class='text-center pointer']//i[@data-toggle='dropdown']";
				driver.findElement(By.xpath(actionIcon)).click();
				consoleMessage("Clicked on the action icon.");

				// click on the jump to custom form option
				try {
					String jumptoOption = "//p[text()='" + taskTitle2
							+ "']//parent::td//following-sibling::td[@class='text-center pointer']//div[@class='dropdown open']//li[@ng-show='isDefined(task.customFormName)']";
					boolean jumptoOption_actual = driver.findElement(By.xpath(jumptoOption)).isDisplayed();

					if (jumptoOption_actual == true) {
						verificationFailedMessage("The jump to custom form option is displayed without permission.");
					} else {
						successMessage("The jump to custom form option is not displayed as expected.");
					}
				} catch (Throwable t) {
					successMessage("The jump to custom form option is not displayed as expected.");
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

			// VALIDATE THE JUMP SURVEY/INSPECTION/CUSTOM FORM BUTTON OF THE CORPORATE LEVEL
			// CUSTOM FORM OF THE TASK (3) WHICH WAS CREATED UNDER CORPORATE LEVEL CUSTOM
			// FORM
			// BY PROPERTY MANAGER USER (PORTFOLIO SUMMARY DASHBOARD) - PROPERTY MANAGER
			// USER - JINESH
			title("VALIDATE THE JUMP SURVEY/INSPECTION/CUSTOM FORM BUTTON OF THE CORPORATE LEVEL CUSTOM FORM OF THE TASK (3) WHICH WAS CREATED UNDER CORPORATE LEVEL CUSTOM FORM BY PROPERTY MANAGER USER (PORTFOLIO SUMMARY DASHBOARD) - PROPERTY MANAGER USER - JINESH");

			try {
				// wait for the element
				Thread.sleep(3000);

				// click on the task icon of the respective property
				click("taskicon_CSS");

				// click on the clear button
				click("task_createdtask_clearbtn_XPATH");

				// enter the data in the search field
				type("task_filter_CSS", taskTitle3);

				// click on the search button
				click("task_createdtask_searchbtn_XPATH");

				// verify newly created task is displayed or not
				try {
					String task = "//p[contains(text(),'" + taskTitle3 + "')]";
					String task_actual = (driver.findElement(By.xpath(task)).getText()).trim();

					if (task_actual.equals(taskTitle3)) {
						successMessage("The newly created task is verified successfully.");
					} else {
						verificationFailedMessage("The newly created task is not verified.");
					}
				} catch (Throwable t) {
					verificationFailedMessage("The newly created task is not verified.");
				}

				// click on the newly created task
				String task = "//p[contains(text(),'" + taskTitle3 + "')]";
				driver.findElement(By.xpath(task)).click();
				consoleMessage("click on the newly created task.");

				// wait for the element
				Thread.sleep(3000);

				// click on the task association tab
				click("task_taskassociationtab_XPATH");

				// scroll down the screen
				scrollBottom();

				// validate the survey radio button
				try {
					boolean surveybtn = driver.findElement(By.xpath(OR.getProperty("survey_task_surveybtn_XPATH")))
							.isEnabled();

					if (surveybtn == true) {
						successMessage("The radio button of survey is displayed enabled as expected.");
					} else {
						verificationFailedMessage("The radio button of survey is not displayed enabled.");
					}
				} catch (Throwable t) {
					verificationFailedMessage("The radio button of survey is not displayed enabled.");
				}

				// validate the inspection radio button
				try {
					boolean inspectionbtn = driver
							.findElement(By.xpath(OR.getProperty("task_taskassociationtab_inspectionbtn_XPATH")))
							.isEnabled();

					if (inspectionbtn == true) {
						successMessage("The radio button of inspection is displayed enabled as expected.");
					} else {
						verificationFailedMessage("The radio button of inspection is not displayed enabled.");
					}
				} catch (Throwable t) {
					verificationFailedMessage("The radio button of inspection is not displayed enabled.");
				}

				// validate the custom form radio button
				try {
					boolean customformbtn = driver
							.findElement(By.xpath(OR.getProperty("task_taskassociationtab_customformbtn_XPATH")))
							.isEnabled();

					if (customformbtn == true) {
						successMessage("The radio button of custom form is displayed enabled as expected.");
					} else {
						verificationFailedMessage("The radio button of custom form is not displayed enabled.");
					}
				} catch (Throwable t) {
					verificationFailedMessage("The radio button of custom form is not displayed enabled.");
				}

				// validate the dropdown of custom form
				try {
					boolean dropdown = driver
							.findElement(By.xpath(OR.getProperty("task_taskassociationtab_questionnerdd_XPATH")))
							.isEnabled();

					if (dropdown == true) {
						successMessage("The dropdown of survey enabled as expected.");
					} else {
						verificationFailedMessage("The dropdown of survey is not displayed enabled.");
					}
				} catch (Throwable t) {
					verificationFailedMessage("The dropdown of survey is not displayed enabled.");
				}

				// validate the selected custom form is displayed or not
				try {
					String selectedCustomForm = "//option[@label='" + name + "' and @selected='selected']";
					boolean dropdown = driver.findElement(By.xpath(selectedCustomForm)).isDisplayed();

					if (dropdown == true) {
						verificationFailedMessage(
								"The selected option in the custom form dropdown is displayed without permission.");

					} else {
						successMessage("The selected option in the custom form dropdown is not displayed as expected.");
					}
				} catch (Throwable t) {
					successMessage("The selected option in the custom form dropdown is not displayed as expected.");
				}

				// validate the jump to survey/inspection/custom form button
				try {
					boolean jumpbtn = driver
							.findElement(By.xpath(OR.getProperty("task_taskassociationtab_jumpbtn_XPATH")))
							.isDisplayed();

					if (jumpbtn == true) {
						verificationFailedMessage("The jump to survey/inspection/custom form button is displayed.");

					} else {
						successMessage(
								"The jump to survey/inspection/custom form button is not displayed as expected.");
					}
				} catch (Throwable t) {
					successMessage("The jump to survey/inspection/custom form button is not displayed as expected.");
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

			// VALIDATE THE JUMP TO CORPORATE LEVEL CUSTOM FORM OPTION OF THE TASK (3) WHICH
			// WAS CREATED BY PROPERTY MANAGER USER (PORTFOLIO SUMMARY DASHBOARD) - PROPERTY
			// MANAGER USER - JINESH
			title("VALIDATE THE JUMP TO CORPORATE LEVEL CUSTOM FORM OPTION OF THE TASK (3) WHICH WAS CREATED BY PROPERTY MANAGER USER (PORTFOLIO SUMMARY DASHBOARD) - PROPERTY MANAGER USER - JINESH");

			try {

				// wait for the element
				Thread.sleep(3000);

				// click on the task icon of the respective property
				click("taskicon_CSS");

				// click on the clear button
				click("task_createdtask_clearbtn_XPATH");

				// enter the data in the search field
				type("task_filter_CSS", taskTitle3);

				// click on the search button
				click("task_createdtask_searchbtn_XPATH");

				// verify newly created task is displayed or not
				try {
					String task = "//p[contains(text(),'" + taskTitle3 + "')]";
					String task_actual = (driver.findElement(By.xpath(task)).getText()).trim();

					if (task_actual.equals(taskTitle3)) {
						successMessage("The newly created task is verified successfully.");
					} else {
						verificationFailedMessage("The newly created task is not verified.");
					}
				} catch (Throwable t) {
					verificationFailedMessage("The newly created task is not verified.");
				}

				// click on the action icon
				String actionIcon = "//p[text()='" + taskTitle3
						+ "']//parent::td//following-sibling::td[@class='text-center pointer']//i[@data-toggle='dropdown']";
				driver.findElement(By.xpath(actionIcon)).click();
				consoleMessage("Clicked on the action icon.");

				// click on the jump to custom form option
				try {
					String jumptoOption = "//p[text()='" + taskTitle3
							+ "']//parent::td//following-sibling::td[@class='text-center pointer']//div[@class='dropdown open']//li[@ng-show='isDefined(task.customFormName)']";
					boolean jumptoOption_actual = driver.findElement(By.xpath(jumptoOption)).isDisplayed();

					if (jumptoOption_actual == true) {
						verificationFailedMessage("The jump to custom form option is displayed without permission.");
					} else {
						successMessage("The jump to custom form option is not displayed as expected.");
					}
				} catch (Throwable t) {
					successMessage("The jump to custom form option is not displayed as expected.");
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

			// VALIDATE THE JUMP SURVEY/INSPECTION/CUSTOM FORM BUTTON IS LAUNCHED ASSOCIATED
			// CORPORATE LEVEL CUSTOM FORM OF THE TASK (1) WHICH WAS CREATED BY ADMIN USER -
			// CONTRACTOR USER - JINESH CONTRACTOR")
			title("VALIDATE THE JUMP SURVEY/INSPECTION/CUSTOM FORM BUTTON IS LAUNCHED ASSOCIATED CORPORATE LEVEL CUSTOM FORM OF THE TASK (1) WHICH WAS CREATED BY ADMIN USER - CONTRACTOR USER - JINESH CONTRACTOR\")");

			try {

				// wait for the element
				Thread.sleep(3000);

				// click on the task icon of the respective property
				click("taskicon_CSS");

				// click on the clear button
				click("task_createdtask_clearbtn_XPATH");

				// enter the data in the search field
				type("task_filter_CSS", taskTitle1);

				// click on the search button
				click("task_createdtask_searchbtn_XPATH");

				// verify newly created task is displayed or not
				try {
					String task = "//p[contains(text(),'" + taskTitle1 + "')]";
					String task_actual = (driver.findElement(By.xpath(task)).getText()).trim();

					if (task_actual.equals(taskTitle1)) {
						successMessage("The newly created task is verified successfully.");
					} else {
						verificationFailedMessage("The newly created task is not verified.");
					}
				} catch (Throwable t) {
					verificationFailedMessage("The newly created task is not verified.");
				}

				// click on the newly created task
				String task = "//p[contains(text(),'" + taskTitle1 + "')]";
				driver.findElement(By.xpath(task)).click();
				consoleMessage("click on the newly created task.");

				// wait for the element
				Thread.sleep(3000);

				// click on the task association tab
				click("task_taskassociationtab_XPATH");

				// scroll down the screen
				scrollBottom();

				// validate the survey radio button
				try {
					boolean surveybtn = driver
							.findElement(By.xpath(OR.getProperty("survey_task_surveybtn_disabled_XPATH"))).isEnabled();

					if (surveybtn == false) {
						successMessage("The radio button of survey is displayed disabled as expected.");
					} else {
						verificationFailedMessage("The radio button of survey is not displayed disabled.");
					}
				} catch (Throwable t) {
					verificationFailedMessage("The radio button of survey is not displayed disabled.");
				}

				// validate the inspection radio button
				try {
					boolean inspectionbtn = driver
							.findElement(
									By.xpath(OR.getProperty("task_taskassociationtab_inspectionbtn_disabled_XPATH")))
							.isEnabled();

					if (inspectionbtn == false) {
						successMessage("The radio button of inspection is displayed disabled as expected.");
					} else {
						verificationFailedMessage("The radio button of inspection is not displayed disabled.");
					}
				} catch (Throwable t) {
					verificationFailedMessage("The radio button of inspection is not displayed disabled.");
				}

				// validate the custom form radio button
				try {
					boolean customformbtn = driver
							.findElement(
									By.xpath(OR.getProperty("task_taskassociationtab_customformbtn_disabled_XPATH")))
							.isEnabled();

					if (customformbtn == false) {
						successMessage("The radio button of custom form is displayed disabled as expected.");
					} else {
						verificationFailedMessage("The radio button of custom form is not displayed disabled.");
					}
				} catch (Throwable t) {
					verificationFailedMessage("The radio button of custom form is not displayed disabled.");
				}

				// validate the dropdown of custom form
				try {
					boolean dropdown = driver
							.findElement(
									By.xpath(OR.getProperty("task_taskassociationtab_questionnerdd_disabled_XPATH")))
							.isEnabled();

					if (dropdown == false) {
						successMessage("The dropdown of custom form disabled as expected.");
					} else {
						verificationFailedMessage("The dropdown of custom form is not displayed disabled.");
					}
				} catch (Throwable t) {
					verificationFailedMessage("The dropdown of custom form is not displayed disabled.");
				}

				// validate the selected custom form is displayed or not
				try {
					String selectedQuestionnaire = "//option[@label='" + name + "' and @selected='selected']";
					boolean dropdown = driver.findElement(By.xpath(selectedQuestionnaire)).isDisplayed();

					if (dropdown == true) {
						successMessage("The selected option in the custom form dropdown is displayed as expected.");
					} else {
						verificationFailedMessage("The selected option in the custom form dropdown is not displayed.");
					}
				} catch (Throwable t) {
					verificationFailedMessage("The selected option in the custom form dropdown is not displayed.");
				}

				// validate the jump to survey/inspection/custom form button
				try {
					boolean jumpbtn = driver
							.findElement(By.xpath(OR.getProperty("task_taskassociationtab_jumpbtn_XPATH")))
							.isDisplayed();

					if (jumpbtn == true) {
						successMessage("The jump to survey/inspection/custom form button is displayed as expected.");
					} else {
						verificationFailedMessage("The jump to survey/inspection/custom form button is not displayed.");
					}
				} catch (Throwable t) {
					verificationFailedMessage("The jump to survey/inspection/custom form button is not displayed.");
				}

				// click on the jump to survey/inspection/custom form button
				click("task_taskassociationtab_jumpbtn_XPATH");

				// wait for the element
				Thread.sleep(10000);

				// scrolldown to bottom
				scrollBottom();

				// validate the custom form as a title
				try {
					String customName = "//h4[contains(text(),'" + name + "')]";
					String customName_actual = (driver.findElement(By.xpath(customName)).getText()).trim();

					if (customName_actual.equals(name)) {
						successMessage("The custom form name is displayed correctly.");
					} else {
						verificationFailedMessage("The custom form is not displayed.");
					}
				} catch (Throwable t) {
					verificationFailedMessage("The custom form is not displayed.");
				}

				for (int m = 0; m < count; m++) {

					// validate the details of the first field
					try {
						consoleMessage(field1Detail_list.get(m));
						String firstField1 = "//span[contains(text(),'" + field1Detail_list.get(m) + "')]";
						String firstField1_actual = (driver.findElement(By.xpath(firstField1)).getText()).trim();

						if (firstField1_actual.equals(field1Detail_list.get(m))) {
							successMessage("The details of the first field is displayed successfully.");
						} else {
							verificationFailedMessage("The details of the first field is not displayed.");
						}
					} catch (Throwable t) {
						verificationFailedMessage("The details of the first field is not displayed.");
					}

					// validate the details of the first field of page one
					try {
						consoleMessage(pageField1Detail_list.get(m));
						String firstField1 = "//span[contains(text(),'" + pageField1Detail_list.get(m) + "')]";
						String firstField1_actual = (driver.findElement(By.xpath(firstField1)).getText()).trim();

						if (firstField1_actual.equals(pageField1Detail_list.get(m))) {
							successMessage("The details of the first field of page one is displayed successfully.");
						} else {
							verificationFailedMessage("The details of the first field of page one is not displayed.");
						}
					} catch (Throwable t) {
						verificationFailedMessage("The details of the first field of page one is not displayed.");
					}
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

			// VALIDATE THE NEWLY CREATED TASK (2) UNDER CORPORATE LEVEL CUSTOM FORM IN THE
			// TASK MODULE BY PROPERTY MANAGER USER AND ASSOCIATE THE SAME TASK (2) WITH THE
			// NEWLY CREATED CORPORATE LEVEL CUSTOM FORM (PROPERTY SUMMARY DASHBOARD) -
			// CONTRACTOR USER - JINESH CONTRACTOR
			title("VALIDATE THE NEWLY CREATED TASK (2) UNDER CORPORATE LEVEL CUSTOM FORM IN THE TASK MODULE BY PROPERTY MANAGER USER AND ASSOCIATE THE SAME TASK (2) WITH THE NEWLY CREATED CORPORATE LEVEL CUSTOM FORM (PROPERTY SUMMARY DASHBOARD) - CONTRACTOR USER - JINESH CONTRACTOR");

			try {

				// wait for the element
				Thread.sleep(3000);

				// click on the task icon of the respective property
				click("taskicon_CSS");

				// click on the clear button
				click("task_createdtask_clearbtn_XPATH");

				// enter the data in the search field
				type("task_filter_CSS", taskTitle2);

				// click on the search button
				click("task_createdtask_searchbtn_XPATH");

				// verify newly created task is displayed or not
				try {
					String task = "//p[contains(text(),'" + taskTitle2 + "')]";
					String task_actual = (driver.findElement(By.xpath(task)).getText()).trim();

					if (task_actual.equals(taskTitle2)) {
						successMessage("The newly created task is verified successfully.");
					} else {
						verificationFailedMessage("The newly created task is not verified.");
					}
				} catch (Throwable t) {
					verificationFailedMessage("The newly created task is not verified.");
				}

				// click on the newly created task
				String task = "//p[contains(text(),'" + taskTitle2 + "')]";
				driver.findElement(By.xpath(task)).click();
				consoleMessage("click on the newly created task.");

				// wait for the element
				Thread.sleep(3000);

				// click on the task association tab
				click("task_taskassociationtab_XPATH");

				// scroll down the screen
				scrollBottom();

				// scroll down the screen
				scrollBottom();

				// validate the jump to survey/inspection/custom form button
				try {
					boolean jumpbtn = driver
							.findElement(By.xpath(OR.getProperty("task_taskassociationtab_jumpbtn_XPATH")))
							.isDisplayed();

					if (jumpbtn == true) {
						successMessage("The jump to survey/inspection/custom form button is displayed as expected.");
					} else {
						verificationFailedMessage("The jump to survey/inspection/custom form button is not displayed.");
					}
				} catch (Throwable t) {
					verificationFailedMessage("The jump to survey/inspection/custom form button is not displayed.");
				}

				// click on the jump to survey/inspection/custom form button
				click("task_taskassociationtab_jumpbtn_XPATH");

				// wait for the element
				Thread.sleep(10000);

				// scrolldown to bottom
				scrollBottom();

				// validate the custom form as a title
				try {
					String customName = "//h4[contains(text(),'" + name + "')]";
					String customName_actual = (driver.findElement(By.xpath(customName)).getText()).trim();

					if (customName_actual.equals(name)) {
						successMessage("The custom form name is displayed correctly.");
					} else {
						verificationFailedMessage("The custom form is not displayed.");
					}
				} catch (Throwable t) {
					verificationFailedMessage("The custom form is not displayed.");
				}

				for (int m = 0; m < count; m++) {

					// validate the details of the first field
					try {
						consoleMessage(field1Detail_list.get(m));
						String firstField1 = "//span[contains(text(),'" + field1Detail_list.get(m) + "')]";
						String firstField1_actual = (driver.findElement(By.xpath(firstField1)).getText()).trim();

						if (firstField1_actual.equals(field1Detail_list.get(m))) {
							successMessage("The details of the first field is displayed successfully.");
						} else {
							verificationFailedMessage("The details of the first field is not displayed.");
						}
					} catch (Throwable t) {
						verificationFailedMessage("The details of the first field is not displayed.");
					}

					// validate the details of the first field of page one
					try {
						consoleMessage(pageField1Detail_list.get(m));
						String firstField1 = "//span[contains(text(),'" + pageField1Detail_list.get(m) + "')]";
						String firstField1_actual = (driver.findElement(By.xpath(firstField1)).getText()).trim();

						if (firstField1_actual.equals(pageField1Detail_list.get(m))) {
							successMessage("The details of the first field of page one is displayed successfully.");
						} else {
							verificationFailedMessage("The details of the first field of page one is not displayed.");
						}
					} catch (Throwable t) {
						verificationFailedMessage("The details of the first field of page one is not displayed.");
					}

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

			// VALIDATE THE JUMP SURVEY/INSPECTION/CUSTOM FORM BUTTON IS LAUNCHED ASSOCIATED
			// CORPORATE LEVEL CUSTOM FORM OF THE TASK (2) AND VALIDATE THE JUMP TO MULTIPLE
			// TYPE CUSTOM FORM OPTION OF THE SAME TASK (2) (PROPERTY SUMMARY DASHBOARD) -
			// CONTRACTOR USER - JINESH CONTRACTOR
			title("VALIDATE THE JUMP SURVEY/INSPECTION/CUSTOM FORM BUTTON IS LAUNCHED ASSOCIATED CORPORATE LEVEL CUSTOM FORM OF THE TASK (2) AND VALIDATE THE JUMP TO CORPORATE LEVEL CUSTOM FORM OPTION OF THE SAME TASK (2) (PROPERTY SUMMARY DASHBOARD) - CONTRACTOR USER - JINESH CONTRACTOR");

			try {

				// wait for the element
				Thread.sleep(3000);

				// click on the task icon of the respective property
				click("taskicon_CSS");

				// click on the clear button
				click("task_createdtask_clearbtn_XPATH");

				// enter the data in the search field
				type("task_filter_CSS", taskTitle2);

				// click on the search button
				click("task_createdtask_searchbtn_XPATH");

				// verify newly created task is displayed or not
				try {
					String task = "//p[contains(text(),'" + taskTitle2 + "')]";
					String task_actual = (driver.findElement(By.xpath(task)).getText()).trim();

					if (task_actual.equals(taskTitle2)) {
						successMessage("The newly created task is verified successfully.");
					} else {
						verificationFailedMessage("The newly created task is not verified.");
					}
				} catch (Throwable t) {
					verificationFailedMessage("The newly created task is not verified.");
				}

				// click on the newly created task
				String task = "//p[contains(text(),'" + taskTitle2 + "')]";
				driver.findElement(By.xpath(task)).click();
				consoleMessage("click on the newly created task.");

				// wait for the element
				Thread.sleep(3000);

				// click on the task association tab
				click("task_taskassociationtab_XPATH");

				// scroll down the screen
				scrollBottom();

				// validate the survey radio button
				try {
					boolean surveybtn = driver
							.findElement(By.xpath(OR.getProperty("survey_task_surveybtn_disabled_XPATH"))).isEnabled();

					if (surveybtn == false) {
						successMessage("The radio button of survey is displayed disabled as expected.");
					} else {
						verificationFailedMessage("The radio button of survey is not displayed disabled.");
					}
				} catch (Throwable t) {
					verificationFailedMessage("The radio button of survey is not displayed disabled.");
				}

				// validate the inspection radio button
				try {
					boolean inspectionbtn = driver
							.findElement(
									By.xpath(OR.getProperty("task_taskassociationtab_inspectionbtn_disabled_XPATH")))
							.isEnabled();

					if (inspectionbtn == false) {
						successMessage("The radio button of inspection is displayed disabled as expected.");
					} else {
						verificationFailedMessage("The radio button of inspection is not displayed disabled.");
					}
				} catch (Throwable t) {
					verificationFailedMessage("The radio button of inspection is not displayed disabled.");
				}

				// validate the custom form radio button
				try {
					boolean customformbtn = driver
							.findElement(
									By.xpath(OR.getProperty("task_taskassociationtab_customformbtn_disabled_XPATH")))
							.isEnabled();

					if (customformbtn == false) {
						successMessage("The radio button of custom form is displayed disabled as expected.");
					} else {
						verificationFailedMessage("The radio button of custom form is not displayed disabled.");
					}
				} catch (Throwable t) {
					verificationFailedMessage("The radio button of custom form is not displayed disabled.");
				}

				// validate the dropdown of custom form
				try {
					boolean dropdown = driver
							.findElement(
									By.xpath(OR.getProperty("task_taskassociationtab_questionnerdd_disabled_XPATH")))
							.isEnabled();

					if (dropdown == false) {
						successMessage("The dropdown of custom form disabled as expected.");
					} else {
						verificationFailedMessage("The dropdown of custom form is not displayed disabled.");
					}
				} catch (Throwable t) {
					verificationFailedMessage("The dropdown of custom form is not displayed disabled.");
				}

				// validate the selected custom form is displayed or not
				try {
					String selectedQuestionnaire = "//option[@label='" + name + "' and @selected='selected']";
					boolean dropdown = driver.findElement(By.xpath(selectedQuestionnaire)).isDisplayed();

					if (dropdown == true) {
						successMessage("The selected option in the custom form dropdown is displayed as expected.");
					} else {
						verificationFailedMessage("The selected option in the custom form dropdown is not displayed.");
					}
				} catch (Throwable t) {
					verificationFailedMessage("The selected option in the custom form dropdown is not displayed.");
				}

				// validate the jump to survey/inspection/custom form button
				try {
					boolean jumpbtn = driver
							.findElement(By.xpath(OR.getProperty("task_taskassociationtab_jumpbtn_XPATH")))
							.isDisplayed();

					if (jumpbtn == true) {
						successMessage("The jump to survey/inspection/custom form button is displayed as expected.");
					} else {
						verificationFailedMessage("The jump to survey/inspection/custom form button is not displayed.");
					}
				} catch (Throwable t) {
					verificationFailedMessage("The jump to survey/inspection/custom form button is not displayed.");
				}

				// click on the jump to survey/inspection/custom form button
				click("task_taskassociationtab_jumpbtn_XPATH");

				// wait for the element
				Thread.sleep(10000);

				// scrolldown to bottom
				scrollBottom();

				// validate the custom form as a title
				try {
					String customName = "//h4[contains(text(),'" + name + "')]";
					String customName_actual = (driver.findElement(By.xpath(customName)).getText()).trim();

					if (customName_actual.equals(name)) {
						successMessage("The custom form name is displayed correctly.");
					} else {
						verificationFailedMessage("The custom form is not displayed.");
					}
				} catch (Throwable t) {
					verificationFailedMessage("The custom form is not displayed.");
				}

				for (int m = 0; m < count; m++) {

					// validate the details of the first field
					try {
						consoleMessage(field1Detail_list.get(m));
						String firstField1 = "//span[contains(text(),'" + field1Detail_list.get(m) + "')]";
						String firstField1_actual = (driver.findElement(By.xpath(firstField1)).getText()).trim();

						if (firstField1_actual.equals(field1Detail_list.get(m))) {
							successMessage("The details of the first field is displayed successfully.");
						} else {
							verificationFailedMessage("The details of the first field is not displayed.");
						}
					} catch (Throwable t) {
						verificationFailedMessage("The details of the first field is not displayed.");
					}

					// validate the details of the first field of page one
					try {
						consoleMessage(pageField1Detail_list.get(m));
						String firstField1 = "//span[contains(text(),'" + pageField1Detail_list.get(m) + "')]";
						String firstField1_actual = (driver.findElement(By.xpath(firstField1)).getText()).trim();

						if (firstField1_actual.equals(pageField1Detail_list.get(m))) {
							successMessage("The details of the first field of page one is displayed successfully.");
						} else {
							verificationFailedMessage("The details of the first field of page one is not displayed.");
						}
					} catch (Throwable t) {
						verificationFailedMessage("The details of the first field of page one is not displayed.");
					}

				}

				// wait for the element
				Thread.sleep(3000);

				// click on the back button
				click("customform_propertydashboard_backbtn_XPATH");

				// wait for the element
				Thread.sleep(3000);

				// scroll upto top
				scrollTop();

				// click on the clear button
				click("task_createdtask_clearbtn_XPATH");

				// enter the data in the search field
				type("task_filter_CSS", taskTitle2);

				// click on the search button
				click("task_createdtask_searchbtn_XPATH");

				// click on the action icon
				String actionIcon = "//p[text()='" + taskTitle2
						+ "']//parent::td//following-sibling::td[@class='text-center pointer']//i[@data-toggle='dropdown']";
				driver.findElement(By.xpath(actionIcon)).click();
				consoleMessage("Clicked on the action icon.");

				// click on the jump to custom form option
				String jumptoOption = "//p[text()='" + taskTitle2
						+ "']//parent::td//following-sibling::td[@class='text-center pointer']//div[@class='dropdown open']//li[@ng-show='isDefined(task.customFormName)']";
				driver.findElement(By.xpath(jumptoOption)).click();
				consoleMessage("Clicked on the jump to custom form option.");

				// wait for the element
				Thread.sleep(10000);

				// scroll up to top
				scrollTop();

				// validate the custom form as a title
				try {
					String customName = "//h4[contains(text(),'" + name + "')]";
					String customName_actual = (driver.findElement(By.xpath(customName)).getText()).trim();

					if (customName_actual.equals(name)) {
						successMessage("The custom form name is displayed correctly.");
					} else {
						verificationFailedMessage("The custom form is not displayed.");
					}
				} catch (Throwable t) {
					verificationFailedMessage("The custom form is not displayed.");
				}

				// click on the details tab
				String details = "//span[text()='Details']";
				driver.findElement(By.xpath(details)).click();
				consoleMessage("Clicked on the details tab.");

				// scroll down to bottom
				scrollBottom();

				// validate the first field label
				try {
					String fieldLabel1 = "//label[contains(text(),'" + fieldName1 + "')]";
					String fieldLabel1_actual = (driver.findElement(By.xpath(fieldLabel1)).getText()).trim();

					if (fieldLabel1_actual.equals(fieldName1 + ":")) {
						successMessage("The first field label is displayed successfully.");
					} else {
						verificationFailedMessage("The first field label is not displayed.");
					}
				} catch (Throwable t) {
					verificationFailedMessage("The first field label is not displayed.");
				}

				// click on the first page name tab
				String pageTab1 = "//span[text()='" + pageName1 + "']";
				driver.findElement(By.xpath(pageTab1)).click();
				consoleMessage("Clicked on the first page name tab.");

				// scroll to bottom
				scrollBottom();

				// validate the third field label
				try {
					String fieldLabel3 = "//label[contains(text(),'" + pageFieldName1 + "')]";
					String fieldLabel3_actual = (driver.findElement(By.xpath(fieldLabel3)).getText()).trim();

					if (fieldLabel3_actual.equals(pageFieldName1 + ":")) {
						successMessage("The third field label is displayed successfully.");
					} else {
						verificationFailedMessage("The third field label is not displayed.");
					}
				} catch (Throwable t) {
					verificationFailedMessage("The third field label is not displayed.");
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

			// VALIDATE THE NEWLY CREATED TASK (3) UNDER CORPORATE LEVEL CUSTOM FORM IN THE
			// TASK MODULE BY PROPERTY MANAGER USER AND ASSOCIATE THE SAME TASK (3) WITH THE
			// NEWLY CREATED CORPORATE LEVEL CUSTOM FORM (PORTFOLIO SUMMARY DASHBOARD) -
			// CONTRACTOR USER - JINESH CONTRACTOR
			title("VALIDATE THE NEWLY CREATED TASK (3) UNDER CORPORATE LEVEL CUSTOM FORM IN THE TASK MODULE BY PROPERTY MANAGER USER AND ASSOCIATE THE SAME TASK (3) WITH THE NEWLY CREATED CORPORATE LEVEL CUSTOM FORM (PORTFOLIO SUMMARY DASHBOARD) - CONTRACTOR USER - JINESH CONTRACTOR");

			try {

				// wait for the element
				Thread.sleep(3000);

				// click on the task icon of the respective property
				click("taskicon_CSS");

				// click on the clear button
				click("task_createdtask_clearbtn_XPATH");

				// enter the data in the search field
				type("task_filter_CSS", taskTitle3);

				// click on the search button
				click("task_createdtask_searchbtn_XPATH");

				// verify newly created task is displayed or not
				try {
					String task = "//p[contains(text(),'" + taskTitle3 + "')]";
					String task_actual = (driver.findElement(By.xpath(task)).getText()).trim();

					if (task_actual.equals(taskTitle3)) {
						successMessage("The newly created task is verified successfully.");
					} else {
						verificationFailedMessage("The newly created task is not verified.");
					}
				} catch (Throwable t) {
					verificationFailedMessage("The newly created task is not verified.");
				}

				// click on the newly created task
				String task = "//p[contains(text(),'" + taskTitle3 + "')]";
				driver.findElement(By.xpath(task)).click();
				consoleMessage("click on the newly created task.");

				// wait for the element
				Thread.sleep(3000);

				// click on the task association tab
				click("task_taskassociationtab_XPATH");

				// scroll down the screen
				scrollBottom();

				// scroll down the screen
				scrollBottom();

				// validate the jump to survey/inspection/custom form button
				try {
					boolean jumpbtn = driver
							.findElement(By.xpath(OR.getProperty("task_taskassociationtab_jumpbtn_XPATH")))
							.isDisplayed();

					if (jumpbtn == true) {
						successMessage("The jump to survey/inspection/custom form button is displayed as expected.");
					} else {
						verificationFailedMessage("The jump to survey/inspection/custom form button is not displayed.");
					}
				} catch (Throwable t) {
					verificationFailedMessage("The jump to survey/inspection/custom form button is not displayed.");
				}

				// click on the jump to survey/inspection/custom form button
				click("task_taskassociationtab_jumpbtn_XPATH");

				// wait for the element
				Thread.sleep(10000);

				// scrolldown to bottom
				scrollBottom();

				// validate the custom form as a title
				try {
					String customName = "//h4[contains(text(),'" + name + "')]";
					String customName_actual = (driver.findElement(By.xpath(customName)).getText()).trim();

					if (customName_actual.equals(name)) {
						successMessage("The custom form name is displayed correctly.");
					} else {
						verificationFailedMessage("The custom form is not displayed.");
					}
				} catch (Throwable t) {
					verificationFailedMessage("The custom form is not displayed.");
				}

				for (int m = 0; m < count; m++) {

					// validate the details of the first field
					try {
						consoleMessage(field1Detail_list.get(m));
						String firstField1 = "//span[contains(text(),'" + field1Detail_list.get(m) + "')]";
						String firstField1_actual = (driver.findElement(By.xpath(firstField1)).getText()).trim();

						if (firstField1_actual.equals(field1Detail_list.get(m))) {
							successMessage("The details of the first field is displayed successfully.");
						} else {
							verificationFailedMessage("The details of the first field is not displayed.");
						}
					} catch (Throwable t) {
						verificationFailedMessage("The details of the first field is not displayed.");
					}

					// validate the details of the first field of page one
					try {
						consoleMessage(pageField1Detail_list.get(m));
						String firstField1 = "//span[contains(text(),'" + pageField1Detail_list.get(m) + "')]";
						String firstField1_actual = (driver.findElement(By.xpath(firstField1)).getText()).trim();

						if (firstField1_actual.equals(pageField1Detail_list.get(m))) {
							successMessage("The details of the first field of page one is displayed successfully.");
						} else {
							verificationFailedMessage("The details of the first field of page one is not displayed.");
						}
					} catch (Throwable t) {
						verificationFailedMessage("The details of the first field of page one is not displayed.");
					}

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

			// VALIDATE THE JUMP SURVEY/INSPECTION/CUSTOM FORM BUTTON IS LAUNCHED ASSOCIATED
			// CORPORATE LEVEL CUSTOM FORM OF THE TASK (3) AND VALIDATE THE JUMP TO MULTIPLE
			// TYPE CUSTOM FORM OPTION OF THE SAME TASK (3) (PORTFOLIO SUMMARY DASHBOARD) -
			// CONTRACTOR USER - JINESH CONTRACTOR
			title("VALIDATE THE JUMP SURVEY/INSPECTION/CUSTOM FORM BUTTON IS LAUNCHED ASSOCIATED CORPORATE LEVEL CUSTOM FORM OF THE TASK (3) AND VALIDATE THE JUMP TO CORPORATE LEVEL CUSTOM FORM OPTION OF THE SAME TASK (3) (PORTFOLIO SUMMARY DASHBOARD) - CONTRACTOR USER - JINESH CONTRACTOR");

			try {

				// wait for the element
				Thread.sleep(3000);

				// click on the task icon of the respective property
				click("taskicon_CSS");

				// click on the clear button
				click("task_createdtask_clearbtn_XPATH");

				// enter the data in the search field
				type("task_filter_CSS", taskTitle3);

				// click on the search button
				click("task_createdtask_searchbtn_XPATH");

				// verify newly created task is displayed or not
				try {
					String task = "//p[contains(text(),'" + taskTitle3 + "')]";
					String task_actual = (driver.findElement(By.xpath(task)).getText()).trim();

					if (task_actual.equals(taskTitle3)) {
						successMessage("The newly created task is verified successfully.");
					} else {
						verificationFailedMessage("The newly created task is not verified.");
					}
				} catch (Throwable t) {
					verificationFailedMessage("The newly created task is not verified.");
				}

				// click on the newly created task
				String task = "//p[contains(text(),'" + taskTitle3 + "')]";
				driver.findElement(By.xpath(task)).click();
				consoleMessage("click on the newly created task.");

				// wait for the element
				Thread.sleep(3000);

				// click on the task association tab
				click("task_taskassociationtab_XPATH");

				// scroll down the screen
				scrollBottom();

				// validate the survey radio button
				try {
					boolean surveybtn = driver
							.findElement(By.xpath(OR.getProperty("survey_task_surveybtn_disabled_XPATH"))).isEnabled();

					if (surveybtn == false) {
						successMessage("The radio button of survey is displayed disabled as expected.");
					} else {
						verificationFailedMessage("The radio button of survey is not displayed disabled.");
					}
				} catch (Throwable t) {
					verificationFailedMessage("The radio button of survey is not displayed disabled.");
				}

				// validate the inspection radio button
				try {
					boolean inspectionbtn = driver
							.findElement(
									By.xpath(OR.getProperty("task_taskassociationtab_inspectionbtn_disabled_XPATH")))
							.isEnabled();

					if (inspectionbtn == false) {
						successMessage("The radio button of inspection is displayed disabled as expected.");
					} else {
						verificationFailedMessage("The radio button of inspection is not displayed disabled.");
					}
				} catch (Throwable t) {
					verificationFailedMessage("The radio button of inspection is not displayed disabled.");
				}

				// validate the custom form radio button
				try {
					boolean customformbtn = driver
							.findElement(
									By.xpath(OR.getProperty("task_taskassociationtab_customformbtn_disabled_XPATH")))
							.isEnabled();

					if (customformbtn == false) {
						successMessage("The radio button of custom form is displayed disabled as expected.");
					} else {
						verificationFailedMessage("The radio button of custom form is not displayed disabled.");
					}
				} catch (Throwable t) {
					verificationFailedMessage("The radio button of custom form is not displayed disabled.");
				}

				// validate the dropdown of custom form
				try {
					boolean dropdown = driver
							.findElement(
									By.xpath(OR.getProperty("task_taskassociationtab_questionnerdd_disabled_XPATH")))
							.isEnabled();

					if (dropdown == false) {
						successMessage("The dropdown of custom form disabled as expected.");
					} else {
						verificationFailedMessage("The dropdown of custom form is not displayed disabled.");
					}
				} catch (Throwable t) {
					verificationFailedMessage("The dropdown of custom form is not displayed disabled.");
				}

				// validate the selected custom form is displayed or not
				try {
					String selectedQuestionnaire = "//option[@label='" + name + "' and @selected='selected']";
					boolean dropdown = driver.findElement(By.xpath(selectedQuestionnaire)).isDisplayed();

					if (dropdown == true) {
						successMessage("The selected option in the custom form dropdown is displayed as expected.");
					} else {
						verificationFailedMessage("The selected option in the custom form dropdown is not displayed.");
					}
				} catch (Throwable t) {
					verificationFailedMessage("The selected option in the custom form dropdown is not displayed.");
				}

				// validate the jump to survey/inspection/custom form button
				try {
					boolean jumpbtn = driver
							.findElement(By.xpath(OR.getProperty("task_taskassociationtab_jumpbtn_XPATH")))
							.isDisplayed();

					if (jumpbtn == true) {
						successMessage("The jump to survey/inspection/custom form button is displayed as expected.");
					} else {
						verificationFailedMessage("The jump to survey/inspection/custom form button is not displayed.");
					}
				} catch (Throwable t) {
					verificationFailedMessage("The jump to survey/inspection/custom form button is not displayed.");
				}

				// click on the jump to survey/inspection/custom form button
				click("task_taskassociationtab_jumpbtn_XPATH");

				// wait for the element
				Thread.sleep(10000);

				// scrolldown to bottom
				scrollBottom();

				// validate the custom form as a title
				try {
					String customName = "//h4[contains(text(),'" + name + "')]";
					String customName_actual = (driver.findElement(By.xpath(customName)).getText()).trim();

					if (customName_actual.equals(name)) {
						successMessage("The custom form name is displayed correctly.");
					} else {
						verificationFailedMessage("The custom form is not displayed.");
					}
				} catch (Throwable t) {
					verificationFailedMessage("The custom form is not displayed.");
				}

				for (int m = 0; m < count; m++) {

					// validate the details of the first field
					try {
						consoleMessage(field1Detail_list.get(m));
						String firstField1 = "//span[contains(text(),'" + field1Detail_list.get(m) + "')]";
						String firstField1_actual = (driver.findElement(By.xpath(firstField1)).getText()).trim();

						if (firstField1_actual.equals(field1Detail_list.get(m))) {
							successMessage("The details of the first field is displayed successfully.");
						} else {
							verificationFailedMessage("The details of the first field is not displayed.");
						}
					} catch (Throwable t) {
						verificationFailedMessage("The details of the first field is not displayed.");
					}

					// validate the details of the first field of page one
					try {
						consoleMessage(pageField1Detail_list.get(m));
						String firstField1 = "//span[contains(text(),'" + pageField1Detail_list.get(m) + "')]";
						String firstField1_actual = (driver.findElement(By.xpath(firstField1)).getText()).trim();

						if (firstField1_actual.equals(pageField1Detail_list.get(m))) {
							successMessage("The details of the first field of page one is displayed successfully.");
						} else {
							verificationFailedMessage("The details of the first field of page one is not displayed.");
						}
					} catch (Throwable t) {
						verificationFailedMessage("The details of the first field of page one is not displayed.");
					}

				}

				// wait for the element
				Thread.sleep(3000);

				// click on the back button
				click("customform_propertydashboard_backbtn_XPATH");

				// wait for the element
				Thread.sleep(3000);

				// scroll upto top
				scrollTop();

				// click on the clear button
				click("task_createdtask_clearbtn_XPATH");

				// enter the data in the search field
				type("task_filter_CSS", taskTitle3);

				// click on the search button
				click("task_createdtask_searchbtn_XPATH");

				// click on the action icon
				String actionIcon = "//p[text()='" + taskTitle3
						+ "']//parent::td//following-sibling::td[@class='text-center pointer']//i[@data-toggle='dropdown']";
				driver.findElement(By.xpath(actionIcon)).click();
				consoleMessage("Clicked on the action icon.");

				// click on the jump to custom form option
				String jumptoOption = "//p[text()='" + taskTitle3
						+ "']//parent::td//following-sibling::td[@class='text-center pointer']//div[@class='dropdown open']//li[@ng-show='isDefined(task.customFormName)']";
				driver.findElement(By.xpath(jumptoOption)).click();
				consoleMessage("Clicked on the jump to custom form option.");

				// wait for the element
				Thread.sleep(10000);

				// scroll up to top
				scrollTop();

				// validate the custom form as a title
				try {
					String customName = "//h4[contains(text(),'" + name + "')]";
					String customName_actual = (driver.findElement(By.xpath(customName)).getText()).trim();

					if (customName_actual.equals(name)) {
						successMessage("The custom form name is displayed correctly.");
					} else {
						verificationFailedMessage("The custom form is not displayed.");
					}
				} catch (Throwable t) {
					verificationFailedMessage("The custom form is not displayed.");
				}

				// click on the details tab
				String details = "//span[text()='Details']";
				driver.findElement(By.xpath(details)).click();
				consoleMessage("Clicked on the details tab.");

				// scroll down to bottom
				scrollBottom();

				// validate the first field label
				try {
					String fieldLabel1 = "//label[contains(text(),'" + fieldName1 + "')]";
					String fieldLabel1_actual = (driver.findElement(By.xpath(fieldLabel1)).getText()).trim();

					if (fieldLabel1_actual.equals(fieldName1 + ":")) {
						successMessage("The first field label is displayed successfully.");
					} else {
						verificationFailedMessage("The first field label is not displayed.");
					}
				} catch (Throwable t) {
					verificationFailedMessage("The first field label is not displayed.");
				}

				// click on the first page name tab
				String pageTab1 = "//span[text()='" + pageName1 + "']";
				driver.findElement(By.xpath(pageTab1)).click();
				consoleMessage("Clicked on the first page name tab.");

				// scroll to bottom
				scrollBottom();

				// validate the third field label
				try {
					String fieldLabel3 = "//label[contains(text(),'" + pageFieldName1 + "')]";
					String fieldLabel3_actual = (driver.findElement(By.xpath(fieldLabel3)).getText()).trim();

					if (fieldLabel3_actual.equals(pageFieldName1 + ":")) {
						successMessage("The third field label is displayed successfully.");
					} else {
						verificationFailedMessage("The third field label is not displayed.");
					}
				} catch (Throwable t) {
					verificationFailedMessage("The third field label is not displayed.");
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

			// LOGOUT THE SESSION FROM THE CONTRACTOR USER - JINESH CONTRACTOR AND LOGIN TO
			// ADMIN USER
			title("LOGOUT THE SESSION FROM THE CONTRACTOR USER - JINESH CONTRACTOR USER AND LOGIN TO ADMIN USER");

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

			// click on the User to Edit form field
			click("customform_securitytab_security1_XPATH");

			// click on the none button
			click("customform_securitytab_nonebtn_XPATH");

			// enter the user name in the search field
			type("customform_securitytab_searchtxt_XPATH", data.get("user1"));

			// click on the searched result
			click("customform_securitytab_searchedresult1_XPATH");

			// click on the User to Edit form field
			click("customform_securitytab_security1_XPATH");

			// click on the Role to Edit form field
			click("customform_securitytab_security2_XPATH");

			// click on the none button
			click("customform_securitytab_nonebtn_XPATH");

			// enter the user name in the search field
			type("customform_securitytab_searchtxt_XPATH", data.get("role1"));

			// click on the searched result
			click("customform_securitytab_searchedresult2_XPATH");

			// click on the Role to Edit form field
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

		// VERIFY JUMP SURVEY/INSPECTION/CUSTOM FORM BUTTON IS DISPLAYED OR NOT WITHOUT
		// PERMISSION - ADMIN USER
		title("VERIFY JUMP SURVEY/INSPECTION/CUSTOM FORM BUTTON IS DISPLAYED OR NOT WITHOUT PERMISSION - ADMIN USER");

		try {
			// wait for the element
			Thread.sleep(3000);

			// click on the task icon of the respective property
			click("taskicon_CSS");

			// click on the clear button
			click("task_createdtask_clearbtn_XPATH");

			// enter the data in the search field
			type("task_filter_CSS", taskTitle1);

			// click on the search button
			click("task_createdtask_searchbtn_XPATH");

			// verify newly created task is displayed or not
			try {
				String task = "//p[contains(text(),'" + taskTitle1 + "')]";
				String task_actual = (driver.findElement(By.xpath(task)).getText()).trim();

				if (task_actual.equals(taskTitle1)) {
					successMessage("The newly created task is verified successfully.");
				} else {
					verificationFailedMessage("The newly created task is not verified.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The newly created task is not verified.");
			}

			// click on the newly created task
			String task = "//p[contains(text(),'" + taskTitle1 + "')]";
			driver.findElement(By.xpath(task)).click();
			consoleMessage("click on the newly created task.");

			// wait for the element
			Thread.sleep(3000);

			// click on the task association tab
			click("task_taskassociationtab_XPATH");

			// scroll down the screen
			scrollBottom();

			// validate the survey radio button
			try {
				boolean surveybtn = driver.findElement(By.xpath(OR.getProperty("survey_task_surveybtn_XPATH")))
						.isEnabled();

				if (surveybtn == true) {
					successMessage("The radio button of survey is displayed enabled as expected.");
				} else {
					verificationFailedMessage("The radio button of survey is not displayed enabled.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The radio button of survey is not displayed enabled.");
			}

			// validate the inspection radio button
			try {
				boolean inspectionbtn = driver
						.findElement(By.xpath(OR.getProperty("task_taskassociationtab_inspectionbtn_XPATH")))
						.isEnabled();

				if (inspectionbtn == true) {
					successMessage("The radio button of inspection is displayed enabled as expected.");
				} else {
					verificationFailedMessage("The radio button of inspection is not displayed enabled.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The radio button of inspection is not displayed enabled.");
			}

			// validate the custom form radio button
			try {
				boolean customformbtn = driver
						.findElement(By.xpath(OR.getProperty("task_taskassociationtab_customformbtn_XPATH")))
						.isEnabled();

				if (customformbtn == true) {
					successMessage("The radio button of custom form is displayed enabled as expected.");
				} else {
					verificationFailedMessage("The radio button of custom form is not displayed enabled.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The radio button of custom form is not displayed enabled.");
			}

			// validate the dropdown of custom form
			try {
				boolean dropdown = driver
						.findElement(By.xpath(OR.getProperty("task_taskassociationtab_questionnerdd_XPATH")))
						.isEnabled();

				if (dropdown == true) {
					successMessage("The dropdown of survey enabled as expected.");
				} else {
					verificationFailedMessage("The dropdown of survey is not displayed enabled.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The dropdown of survey is not displayed enabled.");
			}

			// validate the selected custom form is displayed or not
			try {
				String selectedCustomForm = "//option[@label='" + name + "' and @selected='selected']";
				boolean dropdown = driver.findElement(By.xpath(selectedCustomForm)).isDisplayed();

				if (dropdown == true) {
					successMessage("The selected option in the custom form dropdown is displayed as expected.");
				} else {
					verificationFailedMessage("The selected option in the custom form dropdown is not displayed.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The selected option in the custom form dropdown is not displayed.");
			}

			// validate the jump to survey/inspection/custom form button
			try {
				boolean jumpbtn = driver.findElement(By.xpath(OR.getProperty("task_taskassociationtab_jumpbtn_XPATH")))
						.isDisplayed();

				if (jumpbtn == true) {
					verificationFailedMessage("The jump to survey/inspection/custom form button is displayed.");

				} else {
					successMessage("The jump to survey/inspection/custom form button is not displayed as expected.");
				}
			} catch (Throwable t) {
				successMessage("The jump to survey/inspection/custom form button is not displayed as expected.");
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

			// VALIDATE THE JUMP SURVEY/INSPECTION/CUSTOM FORM BUTTON IS LAUNCHED ASSOCIATED
			// CORPORATE LEVEL CUSTOM FORM OF THE TASK (1) WHICH WAS CREATED BY ADMIN USER -
			// PROPERTY MANAGER USER - JINESH
			title("VALIDATE THE JUMP SURVEY/INSPECTION/CUSTOM FORM BUTTON IS LAUNCHED ASSOCIATED CORPORATE LEVEL CUSTOM FORM OF THE TASK (1) WHICH WAS CREATED BY ADMIN USER - PROPERTY MANAGER USER - JINESH");

			try {

				// wait for the element
				Thread.sleep(3000);

				// click on the task icon of the respective property
				click("taskicon_CSS");

				// click on the clear button
				click("task_createdtask_clearbtn_XPATH");

				// enter the data in the search field
				type("task_filter_CSS", taskTitle1);

				// click on the search button
				click("task_createdtask_searchbtn_XPATH");

				// verify newly created task is displayed or not
				try {
					String task = "//p[contains(text(),'" + taskTitle1 + "')]";
					String task_actual = (driver.findElement(By.xpath(task)).getText()).trim();

					if (task_actual.equals(taskTitle1)) {
						successMessage("The newly created task is verified successfully.");
					} else {
						verificationFailedMessage("The newly created task is not verified.");
					}
				} catch (Throwable t) {
					verificationFailedMessage("The newly created task is not verified.");
				}

				// click on the newly created task
				String task = "//p[contains(text(),'" + taskTitle1 + "')]";
				driver.findElement(By.xpath(task)).click();
				consoleMessage("click on the newly created task.");

				// wait for the element
				Thread.sleep(3000);

				// click on the task association tab
				click("task_taskassociationtab_XPATH");

				// scroll down the screen
				scrollBottom();

				// validate the survey radio button
				try {
					boolean surveybtn = driver
							.findElement(By.xpath(OR.getProperty("survey_task_surveybtn_disabled_XPATH"))).isEnabled();

					if (surveybtn == false) {
						successMessage("The radio button of survey is displayed disabled as expected.");
					} else {
						verificationFailedMessage("The radio button of survey is not displayed disabled.");
					}
				} catch (Throwable t) {
					verificationFailedMessage("The radio button of survey is not displayed disabled.");
				}

				// validate the inspection radio button
				try {
					boolean inspectionbtn = driver
							.findElement(
									By.xpath(OR.getProperty("task_taskassociationtab_inspectionbtn_disabled_XPATH")))
							.isEnabled();

					if (inspectionbtn == false) {
						successMessage("The radio button of inspection is displayed disabled as expected.");
					} else {
						verificationFailedMessage("The radio button of inspection is not displayed disabled.");
					}
				} catch (Throwable t) {
					verificationFailedMessage("The radio button of inspection is not displayed disabled.");
				}

				// validate the custom form radio button
				try {
					boolean customformbtn = driver
							.findElement(
									By.xpath(OR.getProperty("task_taskassociationtab_customformbtn_disabled_XPATH")))
							.isEnabled();

					if (customformbtn == false) {
						successMessage("The radio button of custom form is displayed disabled as expected.");
					} else {
						verificationFailedMessage("The radio button of custom form is not displayed disabled.");
					}
				} catch (Throwable t) {
					verificationFailedMessage("The radio button of custom form is not displayed disabled.");
				}

				// validate the dropdown of custom form
				try {
					boolean dropdown = driver
							.findElement(
									By.xpath(OR.getProperty("task_taskassociationtab_questionnerdd_disabled_XPATH")))
							.isEnabled();

					if (dropdown == false) {
						successMessage("The dropdown of custom form disabled as expected.");
					} else {
						verificationFailedMessage("The dropdown of custom form is not displayed disabled.");
					}
				} catch (Throwable t) {
					verificationFailedMessage("The dropdown of custom form is not displayed disabled.");
				}

				// validate the selected custom form is displayed or not
				try {
					String selectedQuestionnaire = "//option[@label='" + name + "' and @selected='selected']";
					boolean dropdown = driver.findElement(By.xpath(selectedQuestionnaire)).isDisplayed();

					if (dropdown == true) {
						successMessage("The selected option in the custom form dropdown is displayed as expected.");
					} else {
						verificationFailedMessage("The selected option in the custom form dropdown is not displayed.");
					}
				} catch (Throwable t) {
					verificationFailedMessage("The selected option in the custom form dropdown is not displayed.");
				}

				// validate the jump to survey/inspection/custom form button
				try {
					boolean jumpbtn = driver
							.findElement(By.xpath(OR.getProperty("task_taskassociationtab_jumpbtn_XPATH")))
							.isDisplayed();

					if (jumpbtn == true) {
						successMessage("The jump to survey/inspection/custom form button is displayed as expected.");
					} else {
						verificationFailedMessage("The jump to survey/inspection/custom form button is not displayed.");
					}
				} catch (Throwable t) {
					verificationFailedMessage("The jump to survey/inspection/custom form button is not displayed.");
				}

				// click on the jump to survey/inspection/custom form button
				click("task_taskassociationtab_jumpbtn_XPATH");

				// wait for the element
				Thread.sleep(10000);

				// scrolldown to bottom
				scrollBottom();

				// validate the custom form as a title
				try {
					String customName = "//h4[contains(text(),'" + name + "')]";
					String customName_actual = (driver.findElement(By.xpath(customName)).getText()).trim();

					if (customName_actual.equals(name)) {
						successMessage("The custom form name is displayed correctly.");
					} else {
						verificationFailedMessage("The custom form is not displayed.");
					}
				} catch (Throwable t) {
					verificationFailedMessage("The custom form is not displayed.");
				}

				for (int m = 0; m < count; m++) {

					// validate the details of the first field
					try {
						consoleMessage(field1Detail_list.get(m));
						String firstField1 = "//span[contains(text(),'" + field1Detail_list.get(m) + "')]";
						String firstField1_actual = (driver.findElement(By.xpath(firstField1)).getText()).trim();

						if (firstField1_actual.equals(field1Detail_list.get(m))) {
							successMessage("The details of the first field is displayed successfully.");
						} else {
							verificationFailedMessage("The details of the first field is not displayed.");
						}
					} catch (Throwable t) {
						verificationFailedMessage("The details of the first field is not displayed.");
					}

					// validate the details of the first field of page one
					try {
						consoleMessage(pageField1Detail_list.get(m));
						String firstField1 = "//span[contains(text(),'" + pageField1Detail_list.get(m) + "')]";
						String firstField1_actual = (driver.findElement(By.xpath(firstField1)).getText()).trim();

						if (firstField1_actual.equals(pageField1Detail_list.get(m))) {
							successMessage("The details of the first field of page one is displayed successfully.");
						} else {
							verificationFailedMessage("The details of the first field of page one is not displayed.");
						}
					} catch (Throwable t) {
						verificationFailedMessage("The details of the first field of page one is not displayed.");
					}

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

			// VALIDATE THE JUMP SURVEY/INSPECTION/CUSTOM FORM BUTTON IS LAUNCHED ASSOCIATED
			// CORPORATE LEVEL CUSTOM FORM OF THE TASK (2) AND VALIDATE THE JUMP TO MULTIPLE
			// TYPE CUSTOM FORM OPTION OF THE SAME TASK (2) (PROPERTY SUMMARY DASHBOARD) -
			// PROPERTY MANAGER USER - JINESH
			title("VALIDATE THE JUMP SURVEY/INSPECTION/CUSTOM FORM BUTTON IS LAUNCHED ASSOCIATED CORPORATE LEVEL CUSTOM FORM OF THE TASK (2) AND VALIDATE THE JUMP TO CORPORATE LEVEL CUSTOM FORM OPTION OF THE SAME TASK (2) (PROPERTY SUMMARY DASHBOARD) - PROPERTY MANAGER USER - JINESH");

			try {

				// wait for the element
				Thread.sleep(3000);

				// click on the task icon of the respective property
				click("taskicon_CSS");

				// click on the clear button
				click("task_createdtask_clearbtn_XPATH");

				// enter the data in the search field
				type("task_filter_CSS", taskTitle2);

				// click on the search button
				click("task_createdtask_searchbtn_XPATH");

				// verify newly created task is displayed or not
				try {
					String task = "//p[contains(text(),'" + taskTitle2 + "')]";
					String task_actual = (driver.findElement(By.xpath(task)).getText()).trim();

					if (task_actual.equals(taskTitle2)) {
						successMessage("The newly created task is verified successfully.");
					} else {
						verificationFailedMessage("The newly created task is not verified.");
					}
				} catch (Throwable t) {
					verificationFailedMessage("The newly created task is not verified.");
				}

				// click on the newly created task
				String task = "//p[contains(text(),'" + taskTitle2 + "')]";
				driver.findElement(By.xpath(task)).click();
				consoleMessage("click on the newly created task.");

				// wait for the element
				Thread.sleep(3000);

				// click on the task association tab
				click("task_taskassociationtab_XPATH");

				// scroll down the screen
				scrollBottom();

				// validate the survey radio button
				try {
					boolean surveybtn = driver
							.findElement(By.xpath(OR.getProperty("survey_task_surveybtn_disabled_XPATH"))).isEnabled();

					if (surveybtn == false) {
						successMessage("The radio button of survey is displayed disabled as expected.");
					} else {
						verificationFailedMessage("The radio button of survey is not displayed disabled.");
					}
				} catch (Throwable t) {
					verificationFailedMessage("The radio button of survey is not displayed disabled.");
				}

				// validate the inspection radio button
				try {
					boolean inspectionbtn = driver
							.findElement(
									By.xpath(OR.getProperty("task_taskassociationtab_inspectionbtn_disabled_XPATH")))
							.isEnabled();

					if (inspectionbtn == false) {
						successMessage("The radio button of inspection is displayed disabled as expected.");
					} else {
						verificationFailedMessage("The radio button of inspection is not displayed disabled.");
					}
				} catch (Throwable t) {
					verificationFailedMessage("The radio button of inspection is not displayed disabled.");
				}

				// validate the custom form radio button
				try {
					boolean customformbtn = driver
							.findElement(
									By.xpath(OR.getProperty("task_taskassociationtab_customformbtn_disabled_XPATH")))
							.isEnabled();

					if (customformbtn == false) {
						successMessage("The radio button of custom form is displayed disabled as expected.");
					} else {
						verificationFailedMessage("The radio button of custom form is not displayed disabled.");
					}
				} catch (Throwable t) {
					verificationFailedMessage("The radio button of custom form is not displayed disabled.");
				}

				// validate the dropdown of custom form
				try {
					boolean dropdown = driver
							.findElement(
									By.xpath(OR.getProperty("task_taskassociationtab_questionnerdd_disabled_XPATH")))
							.isEnabled();

					if (dropdown == false) {
						successMessage("The dropdown of custom form disabled as expected.");
					} else {
						verificationFailedMessage("The dropdown of custom form is not displayed disabled.");
					}
				} catch (Throwable t) {
					verificationFailedMessage("The dropdown of custom form is not displayed disabled.");
				}

				// validate the selected custom form is displayed or not
				try {
					String selectedQuestionnaire = "//option[@label='" + name + "' and @selected='selected']";
					boolean dropdown = driver.findElement(By.xpath(selectedQuestionnaire)).isDisplayed();

					if (dropdown == true) {
						successMessage("The selected option in the custom form dropdown is displayed as expected.");
					} else {
						verificationFailedMessage("The selected option in the custom form dropdown is not displayed.");
					}
				} catch (Throwable t) {
					verificationFailedMessage("The selected option in the custom form dropdown is not displayed.");
				}

				// validate the jump to survey/inspection/custom form button
				try {
					boolean jumpbtn = driver
							.findElement(By.xpath(OR.getProperty("task_taskassociationtab_jumpbtn_XPATH")))
							.isDisplayed();

					if (jumpbtn == true) {
						successMessage("The jump to survey/inspection/custom form button is displayed as expected.");
					} else {
						verificationFailedMessage("The jump to survey/inspection/custom form button is not displayed.");
					}
				} catch (Throwable t) {
					verificationFailedMessage("The jump to survey/inspection/custom form button is not displayed.");
				}

				// click on the jump to survey/inspection/custom form button
				click("task_taskassociationtab_jumpbtn_XPATH");

				// wait for the element
				Thread.sleep(10000);

				// scrolldown to bottom
				scrollBottom();

				// validate the custom form as a title
				try {
					String customName = "//h4[contains(text(),'" + name + "')]";
					String customName_actual = (driver.findElement(By.xpath(customName)).getText()).trim();

					if (customName_actual.equals(name)) {
						successMessage("The custom form name is displayed correctly.");
					} else {
						verificationFailedMessage("The custom form is not displayed.");
					}
				} catch (Throwable t) {
					verificationFailedMessage("The custom form is not displayed.");
				}

				for (int m = 0; m < count; m++) {

					// validate the details of the first field
					try {
						consoleMessage(field1Detail_list.get(m));
						String firstField1 = "//span[contains(text(),'" + field1Detail_list.get(m) + "')]";
						String firstField1_actual = (driver.findElement(By.xpath(firstField1)).getText()).trim();

						if (firstField1_actual.equals(field1Detail_list.get(m))) {
							successMessage("The details of the first field is displayed successfully.");
						} else {
							verificationFailedMessage("The details of the first field is not displayed.");
						}
					} catch (Throwable t) {
						verificationFailedMessage("The details of the first field is not displayed.");
					}

					// validate the details of the first field of page one
					try {
						consoleMessage(pageField1Detail_list.get(m));
						String firstField1 = "//span[contains(text(),'" + pageField1Detail_list.get(m) + "')]";
						String firstField1_actual = (driver.findElement(By.xpath(firstField1)).getText()).trim();

						if (firstField1_actual.equals(pageField1Detail_list.get(m))) {
							successMessage("The details of the first field of page one is displayed successfully.");
						} else {
							verificationFailedMessage("The details of the first field of page one is not displayed.");
						}
					} catch (Throwable t) {
						verificationFailedMessage("The details of the first field of page one is not displayed.");
					}

				}

				// wait for the element
				Thread.sleep(3000);

				// click on the back button
				click("customform_propertydashboard_backbtn_XPATH");

				// wait for the element
				Thread.sleep(3000);

				// scroll upto top
				scrollTop();

				// click on the clear button
				click("task_createdtask_clearbtn_XPATH");

				// enter the data in the search field
				type("task_filter_CSS", taskTitle2);

				// click on the search button
				click("task_createdtask_searchbtn_XPATH");

				// click on the action icon
				String actionIcon = "//p[text()='" + taskTitle2
						+ "']//parent::td//following-sibling::td[@class='text-center pointer']//i[@data-toggle='dropdown']";
				driver.findElement(By.xpath(actionIcon)).click();
				consoleMessage("Clicked on the action icon.");

				// click on the jump to custom form option
				String jumptoOption = "//p[text()='" + taskTitle2
						+ "']//parent::td//following-sibling::td[@class='text-center pointer']//div[@class='dropdown open']//li[@ng-show='isDefined(task.customFormName)']";
				driver.findElement(By.xpath(jumptoOption)).click();
				consoleMessage("Clicked on the jump to custom form option.");

				// wait for the element
				Thread.sleep(10000);

				// scroll up to top
				scrollTop();

				// validate the custom form as a title
				try {
					String customName = "//h4[contains(text(),'" + name + "')]";
					String customName_actual = (driver.findElement(By.xpath(customName)).getText()).trim();

					if (customName_actual.equals(name)) {
						successMessage("The custom form name is displayed correctly.");
					} else {
						verificationFailedMessage("The custom form is not displayed.");
					}
				} catch (Throwable t) {
					verificationFailedMessage("The custom form is not displayed.");
				}

				// click on the details tab
				String details = "//span[text()='Details']";
				driver.findElement(By.xpath(details)).click();
				consoleMessage("Clicked on the details tab.");

				// scroll down to bottom
				scrollBottom();

				// validate the first field label
				try {
					String fieldLabel1 = "//label[contains(text(),'" + fieldName1 + "')]";
					String fieldLabel1_actual = (driver.findElement(By.xpath(fieldLabel1)).getText()).trim();

					if (fieldLabel1_actual.equals(fieldName1 + ":")) {
						successMessage("The first field label is displayed successfully.");
					} else {
						verificationFailedMessage("The first field label is not displayed.");
					}
				} catch (Throwable t) {
					verificationFailedMessage("The first field label is not displayed.");
				}

				// click on the first page name tab
				String pageTab1 = "//span[text()='" + pageName1 + "']";
				driver.findElement(By.xpath(pageTab1)).click();
				consoleMessage("Clicked on the first page name tab.");

				// scroll to bottom
				scrollBottom();

				// validate the third field label
				try {
					String fieldLabel3 = "//label[contains(text(),'" + pageFieldName1 + "')]";
					String fieldLabel3_actual = (driver.findElement(By.xpath(fieldLabel3)).getText()).trim();

					if (fieldLabel3_actual.equals(pageFieldName1 + ":")) {
						successMessage("The third field label is displayed successfully.");
					} else {
						verificationFailedMessage("The third field label is not displayed.");
					}
				} catch (Throwable t) {
					verificationFailedMessage("The third field label is not displayed.");
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

			// VALIDATE THE JUMP SURVEY/INSPECTION/CUSTOM FORM BUTTON IS LAUNCHED ASSOCIATED
			// CORPORATE LEVEL CUSTOM FORM OF THE TASK (3) AND VALIDATE THE JUMP TO MULTIPLE
			// TYPE CUSTOM FORM OPTION OF THE SAME TASK (3) (PORTFOLIO SUMMARY DASHBOARD) -
			// PROPERTY MANAGER USER - JINESH
			title("VALIDATE THE JUMP SURVEY/INSPECTION/CUSTOM FORM BUTTON IS LAUNCHED ASSOCIATED CORPORATE LEVEL CUSTOM FORM OF THE TASK (3) AND VALIDATE THE JUMP TO CORPORATE LEVEL CUSTOM FORM OPTION OF THE SAME TASK (3) (PORTFOLIO SUMMARY DASHBOARD) - PROPERTY MANAGER USER - JINESH");

			try {

				// wait for the element
				Thread.sleep(3000);

				// click on the task icon of the respective property
				click("taskicon_CSS");

				// click on the clear button
				click("task_createdtask_clearbtn_XPATH");

				// enter the data in the search field
				type("task_filter_CSS", taskTitle3);

				// click on the search button
				click("task_createdtask_searchbtn_XPATH");

				// verify newly created task is displayed or not
				try {
					String task = "//p[contains(text(),'" + taskTitle3 + "')]";
					String task_actual = (driver.findElement(By.xpath(task)).getText()).trim();

					if (task_actual.equals(taskTitle3)) {
						successMessage("The newly created task is verified successfully.");
					} else {
						verificationFailedMessage("The newly created task is not verified.");
					}
				} catch (Throwable t) {
					verificationFailedMessage("The newly created task is not verified.");
				}

				// click on the newly created task
				String task = "//p[contains(text(),'" + taskTitle3 + "')]";
				driver.findElement(By.xpath(task)).click();
				consoleMessage("click on the newly created task.");

				// wait for the element
				Thread.sleep(3000);

				// click on the task association tab
				click("task_taskassociationtab_XPATH");

				// scroll down the screen
				scrollBottom();

				// validate the survey radio button
				try {
					boolean surveybtn = driver.findElement(By.xpath(OR.getProperty("survey_task_surveybtn_XPATH")))
							.isEnabled();

					if (surveybtn == true) {
						successMessage("The radio button of survey is displayed enabled as expected.");
					} else {
						verificationFailedMessage("The radio button of survey is not displayed enabled.");
					}
				} catch (Throwable t) {
					verificationFailedMessage("The radio button of survey is not displayed enabled.");
				}

				// validate the inspection radio button
				try {
					boolean inspectionbtn = driver
							.findElement(By.xpath(OR.getProperty("task_taskassociationtab_inspectionbtn_XPATH")))
							.isEnabled();

					if (inspectionbtn == true) {
						successMessage("The radio button of inspection is displayed enabled as expected.");
					} else {
						verificationFailedMessage("The radio button of inspection is not displayed enabled.");
					}
				} catch (Throwable t) {
					verificationFailedMessage("The radio button of inspection is not displayed enabled.");
				}

				// validate the custom form radio button
				try {
					boolean customformbtn = driver
							.findElement(By.xpath(OR.getProperty("task_taskassociationtab_customformbtn_XPATH")))
							.isEnabled();

					if (customformbtn == true) {
						successMessage("The radio button of custom form is displayed enabled as expected.");
					} else {
						verificationFailedMessage("The radio button of custom form is not displayed enabled.");
					}
				} catch (Throwable t) {
					verificationFailedMessage("The radio button of custom form is not displayed enabled.");
				}

				// validate the dropdown of custom form
				try {
					boolean dropdown = driver
							.findElement(By.xpath(OR.getProperty("task_taskassociationtab_questionnerdd_XPATH")))
							.isEnabled();

					if (dropdown == true) {
						successMessage("The dropdown of survey enabled as expected.");
					} else {
						verificationFailedMessage("The dropdown of survey is not displayed enabled.");
					}
				} catch (Throwable t) {
					verificationFailedMessage("The dropdown of survey is not displayed enabled.");
				}

				// validate the selected custom form is displayed or not
				try {
					String selectedCustomForm = "//option[@label='" + name + "' and @selected='selected']";
					boolean dropdown = driver.findElement(By.xpath(selectedCustomForm)).isDisplayed();

					if (dropdown == true) {
						successMessage("The selected option in the custom form dropdown is displayed as expected.");
					} else {
						verificationFailedMessage("The selected option in the custom form dropdown is not displayed.");
					}
				} catch (Throwable t) {
					verificationFailedMessage("The selected option in the custom form dropdown is not displayed.");
				}

				// validate the jump to survey/inspection/custom form button
				try {
					boolean jumpbtn = driver
							.findElement(By.xpath(OR.getProperty("task_taskassociationtab_jumpbtn_XPATH")))
							.isDisplayed();

					if (jumpbtn == true) {
						successMessage("The jump to survey/inspection/custom form button is displayed as expected.");
					} else {
						verificationFailedMessage("The jump to survey/inspection/custom form button is not displayed.");
					}
				} catch (Throwable t) {
					verificationFailedMessage("The jump to survey/inspection/custom form button is not displayed.");
				}

				// click on the jump to survey/inspection/custom form button
				click("task_taskassociationtab_jumpbtn_XPATH");

				// wait for the element
				Thread.sleep(10000);

				// scrolldown to bottom
				scrollBottom();

				// validate the custom form as a title
				try {
					String customName = "//h4[contains(text(),'" + name + "')]";
					String customName_actual = (driver.findElement(By.xpath(customName)).getText()).trim();

					if (customName_actual.equals(name)) {
						successMessage("The custom form name is displayed correctly.");
					} else {
						verificationFailedMessage("The custom form is not displayed.");
					}
				} catch (Throwable t) {
					verificationFailedMessage("The custom form is not displayed.");
				}

				for (int m = 0; m < count; m++) {

					// validate the details of the first field
					try {
						consoleMessage(field1Detail_list.get(m));
						String firstField1 = "//span[contains(text(),'" + field1Detail_list.get(m) + "')]";
						String firstField1_actual = (driver.findElement(By.xpath(firstField1)).getText()).trim();

						if (firstField1_actual.equals(field1Detail_list.get(m))) {
							successMessage("The details of the first field is displayed successfully.");
						} else {
							verificationFailedMessage("The details of the first field is not displayed.");
						}
					} catch (Throwable t) {
						verificationFailedMessage("The details of the first field is not displayed.");
					}

					// validate the details of the first field of page one
					try {
						consoleMessage(pageField1Detail_list.get(m));
						String firstField1 = "//span[contains(text(),'" + pageField1Detail_list.get(m) + "')]";
						String firstField1_actual = (driver.findElement(By.xpath(firstField1)).getText()).trim();

						if (firstField1_actual.equals(pageField1Detail_list.get(m))) {
							successMessage("The details of the first field of page one is displayed successfully.");
						} else {
							verificationFailedMessage("The details of the first field of page one is not displayed.");
						}
					} catch (Throwable t) {
						verificationFailedMessage("The details of the first field of page one is not displayed.");
					}

				}

				// wait for the element
				Thread.sleep(3000);

				// click on the back button
				click("customform_propertydashboard_backbtn_XPATH");

				// wait for the element
				Thread.sleep(3000);

				// scroll upto top
				scrollTop();

				// click on the clear button
				click("task_createdtask_clearbtn_XPATH");

				// enter the data in the search field
				type("task_filter_CSS", taskTitle3);

				// click on the search button
				click("task_createdtask_searchbtn_XPATH");

				// click on the action icon
				String actionIcon = "//p[text()='" + taskTitle3
						+ "']//parent::td//following-sibling::td[@class='text-center pointer']//i[@data-toggle='dropdown']";
				driver.findElement(By.xpath(actionIcon)).click();
				consoleMessage("Clicked on the action icon.");

				// click on the jump to custom form option
				String jumptoOption = "//p[text()='" + taskTitle3
						+ "']//parent::td//following-sibling::td[@class='text-center pointer']//div[@class='dropdown open']//li[@ng-show='isDefined(task.customFormName)']";
				driver.findElement(By.xpath(jumptoOption)).click();
				consoleMessage("Clicked on the jump to custom form option.");

				// wait for the element
				Thread.sleep(10000);

				// scroll up to top
				scrollTop();

				// validate the custom form as a title
				try {
					String customName = "//h4[contains(text(),'" + name + "')]";
					String customName_actual = (driver.findElement(By.xpath(customName)).getText()).trim();

					if (customName_actual.equals(name)) {
						successMessage("The custom form name is displayed correctly.");
					} else {
						verificationFailedMessage("The custom form is not displayed.");
					}
				} catch (Throwable t) {
					verificationFailedMessage("The custom form is not displayed.");
				}

				// click on the details tab
				String details = "//span[text()='Details']";
				driver.findElement(By.xpath(details)).click();
				consoleMessage("Clicked on the details tab.");

				// scroll down to bottom
				scrollBottom();

				// validate the first field label
				try {
					String fieldLabel1 = "//label[contains(text(),'" + fieldName1 + "')]";
					String fieldLabel1_actual = (driver.findElement(By.xpath(fieldLabel1)).getText()).trim();

					if (fieldLabel1_actual.equals(fieldName1 + ":")) {
						successMessage("The first field label is displayed successfully.");
					} else {
						verificationFailedMessage("The first field label is not displayed.");
					}
				} catch (Throwable t) {
					verificationFailedMessage("The first field label is not displayed.");
				}

				// click on the first page name tab
				String pageTab1 = "//span[text()='" + pageName1 + "']";
				driver.findElement(By.xpath(pageTab1)).click();
				consoleMessage("Clicked on the first page name tab.");

				// scroll to bottom
				scrollBottom();

				// validate the third field label
				try {
					String fieldLabel3 = "//label[contains(text(),'" + pageFieldName1 + "')]";
					String fieldLabel3_actual = (driver.findElement(By.xpath(fieldLabel3)).getText()).trim();

					if (fieldLabel3_actual.equals(pageFieldName1 + ":")) {
						successMessage("The third field label is displayed successfully.");
					} else {
						verificationFailedMessage("The third field label is not displayed.");
					}
				} catch (Throwable t) {
					verificationFailedMessage("The third field label is not displayed.");
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

			// VALIDATE THE JUMP SURVEY/INSPECTION/CUSTOM FORM BUTTON IS LAUNCHED ASSOCIATED
			// CORPORATE LEVEL CUSTOM FORM OF THE TASK (1) WHICH WAS CREATED BY ADMIN USER -
			// CONTRACTOR USER - JINESH CONTRACTOR
			title("VALIDATE THE JUMP SURVEY/INSPECTION/CUSTOM FORM BUTTON IS LAUNCHED ASSOCIATED CORPORATE LEVEL CUSTOM FORM OF THE TASK (1) WHICH WAS CREATED BY ADMIN USER - CONTRACTOR USER - JINESH CONTRACTOR");

			try {

				// wait for the element
				Thread.sleep(3000);

				// click on the task icon of the respective property
				click("taskicon_CSS");

				// click on the clear button
				click("task_createdtask_clearbtn_XPATH");

				// enter the data in the search field
				type("task_filter_CSS", taskTitle1);

				// click on the search button
				click("task_createdtask_searchbtn_XPATH");

				// verify newly created task is displayed or not
				try {
					String task = "//p[contains(text(),'" + taskTitle1 + "')]";
					String task_actual = (driver.findElement(By.xpath(task)).getText()).trim();

					if (task_actual.equals(taskTitle1)) {
						successMessage("The newly created task is verified successfully.");
					} else {
						verificationFailedMessage("The newly created task is not verified.");
					}
				} catch (Throwable t) {
					verificationFailedMessage("The newly created task is not verified.");
				}

				// click on the newly created task
				String task = "//p[contains(text(),'" + taskTitle1 + "')]";
				driver.findElement(By.xpath(task)).click();
				consoleMessage("click on the newly created task.");

				// wait for the element
				Thread.sleep(3000);

				// click on the task association tab
				click("task_taskassociationtab_XPATH");

				// scroll down the screen
				scrollBottom();

				// validate the survey radio button
				try {
					boolean surveybtn = driver
							.findElement(By.xpath(OR.getProperty("survey_task_surveybtn_disabled_XPATH"))).isEnabled();

					if (surveybtn == false) {
						successMessage("The radio button of survey is displayed disabled as expected.");
					} else {
						verificationFailedMessage("The radio button of survey is not displayed disabled.");
					}
				} catch (Throwable t) {
					verificationFailedMessage("The radio button of survey is not displayed disabled.");
				}

				// validate the inspection radio button
				try {
					boolean inspectionbtn = driver
							.findElement(
									By.xpath(OR.getProperty("task_taskassociationtab_inspectionbtn_disabled_XPATH")))
							.isEnabled();

					if (inspectionbtn == false) {
						successMessage("The radio button of inspection is displayed disabled as expected.");
					} else {
						verificationFailedMessage("The radio button of inspection is not displayed disabled.");
					}
				} catch (Throwable t) {
					verificationFailedMessage("The radio button of inspection is not displayed disabled.");
				}

				// validate the custom form radio button
				try {
					boolean customformbtn = driver
							.findElement(
									By.xpath(OR.getProperty("task_taskassociationtab_customformbtn_disabled_XPATH")))
							.isEnabled();

					if (customformbtn == false) {
						successMessage("The radio button of custom form is displayed disabled as expected.");
					} else {
						verificationFailedMessage("The radio button of custom form is not displayed disabled.");
					}
				} catch (Throwable t) {
					verificationFailedMessage("The radio button of custom form is not displayed disabled.");
				}

				// validate the dropdown of custom form
				try {
					boolean dropdown = driver
							.findElement(
									By.xpath(OR.getProperty("task_taskassociationtab_questionnerdd_disabled_XPATH")))
							.isEnabled();

					if (dropdown == false) {
						successMessage("The dropdown of custom form disabled as expected.");
					} else {
						verificationFailedMessage("The dropdown of custom form is not displayed disabled.");
					}
				} catch (Throwable t) {
					verificationFailedMessage("The dropdown of custom form is not displayed disabled.");
				}

				// validate the selected custom form is displayed or not
				try {
					String selectedQuestionnaire = "//option[@label='" + name + "' and @selected='selected']";
					boolean dropdown = driver.findElement(By.xpath(selectedQuestionnaire)).isDisplayed();

					if (dropdown == true) {
						successMessage("The selected option in the custom form dropdown is displayed as expected.");
					} else {
						verificationFailedMessage("The selected option in the custom form dropdown is not displayed.");
					}
				} catch (Throwable t) {
					verificationFailedMessage("The selected option in the custom form dropdown is not displayed.");
				}

				// validate the jump to survey/inspection/custom form button
				try {
					boolean jumpbtn = driver
							.findElement(By.xpath(OR.getProperty("task_taskassociationtab_jumpbtn_XPATH")))
							.isDisplayed();

					if (jumpbtn == true) {
						successMessage("The jump to survey/inspection/custom form button is displayed as expected.");
					} else {
						verificationFailedMessage("The jump to survey/inspection/custom form button is not displayed.");
					}
				} catch (Throwable t) {
					verificationFailedMessage("The jump to survey/inspection/custom form button is not displayed.");
				}

				// click on the jump to survey/inspection/custom form button
				click("task_taskassociationtab_jumpbtn_XPATH");

				// wait for the element
				Thread.sleep(10000);

				// scrolldown to bottom
				scrollBottom();

				// validate the custom form as a title
				try {
					String customName = "//h4[contains(text(),'" + name + "')]";
					String customName_actual = (driver.findElement(By.xpath(customName)).getText()).trim();

					if (customName_actual.equals(name)) {
						successMessage("The custom form name is displayed correctly.");
					} else {
						verificationFailedMessage("The custom form is not displayed.");
					}
				} catch (Throwable t) {
					verificationFailedMessage("The custom form is not displayed.");
				}

				for (int m = 0; m < count; m++) {

					// validate the details of the first field
					try {
						consoleMessage(field1Detail_list.get(m));
						String firstField1 = "//span[contains(text(),'" + field1Detail_list.get(m) + "')]";
						String firstField1_actual = (driver.findElement(By.xpath(firstField1)).getText()).trim();

						if (firstField1_actual.equals(field1Detail_list.get(m))) {
							successMessage("The details of the first field is displayed successfully.");
						} else {
							verificationFailedMessage("The details of the first field is not displayed.");
						}
					} catch (Throwable t) {
						verificationFailedMessage("The details of the first field is not displayed.");
					}

					// validate the details of the first field of page one
					try {
						consoleMessage(pageField1Detail_list.get(m));
						String firstField1 = "//span[contains(text(),'" + pageField1Detail_list.get(m) + "')]";
						String firstField1_actual = (driver.findElement(By.xpath(firstField1)).getText()).trim();

						if (firstField1_actual.equals(pageField1Detail_list.get(m))) {
							successMessage("The details of the first field of page one is displayed successfully.");
						} else {
							verificationFailedMessage("The details of the first field of page one is not displayed.");
						}
					} catch (Throwable t) {
						verificationFailedMessage("The details of the first field of page one is not displayed.");
					}

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

			// VALIDATE THE NEWLY CREATED TASK UNDER CORPORATE LEVEL CUSTOM FORM IN THE TASK
			// MODULE BY PROPERTY MANAGER USER AND ASSOCIATE THE SAME TASK (2) WITH THE
			// NEWLY CREATED CORPORATE LEVEL CUSTOM FORM (PROPERTY SUMMARY DASHBOARD) -
			// CONTRACTOR USER - JINESH CONTRACTOR
			title("VALIDATE THE NEWLY CREATED TASK UNDER CORPORATE LEVEL CUSTOM FORM IN THE TASK MODULE BY PROPERTY MANAGER USER AND ASSOCIATE THE SAME TASK (2) WITH THE NEWLY CREATED CORPORATE LEVEL CUSTOM FORM (PROPERTY SUMMARY DASHBOARD) - CONTRACTOR USER - JINESH CONTRACTOR");

			try {

				// wait for the element
				Thread.sleep(3000);

				// click on the task icon of the respective property
				click("taskicon_CSS");

				// click on the clear button
				click("task_createdtask_clearbtn_XPATH");

				// enter the data in the search field
				type("task_filter_CSS", taskTitle2);

				// click on the search button
				click("task_createdtask_searchbtn_XPATH");

				// verify newly created task is displayed or not
				try {
					String task = "//p[contains(text(),'" + taskTitle2 + "')]";
					String task_actual = (driver.findElement(By.xpath(task)).getText()).trim();

					if (task_actual.equals(taskTitle2)) {
						successMessage("The newly created task is verified successfully.");
					} else {
						verificationFailedMessage("The newly created task is not verified.");
					}
				} catch (Throwable t) {
					verificationFailedMessage("The newly created task is not verified.");
				}

				// click on the newly created task
				String task = "//p[contains(text(),'" + taskTitle2 + "')]";
				driver.findElement(By.xpath(task)).click();
				consoleMessage("click on the newly created task.");

				// wait for the element
				Thread.sleep(3000);

				// click on the task association tab
				click("task_taskassociationtab_XPATH");

				// scroll down the screen
				scrollBottom();

				// scroll down the screen
				scrollBottom();

				// validate the jump to survey/inspection/custom form button
				try {
					boolean jumpbtn = driver
							.findElement(By.xpath(OR.getProperty("task_taskassociationtab_jumpbtn_XPATH")))
							.isDisplayed();

					if (jumpbtn == true) {
						successMessage("The jump to survey/inspection/custom form button is displayed as expected.");
					} else {
						verificationFailedMessage("The jump to survey/inspection/custom form button is not displayed.");
					}
				} catch (Throwable t) {
					verificationFailedMessage("The jump to survey/inspection/custom form button is not displayed.");
				}

				// click on the jump to survey/inspection/custom form button
				click("task_taskassociationtab_jumpbtn_XPATH");

				// wait for the element
				Thread.sleep(10000);

				// scrolldown to bottom
				scrollBottom();

				// validate the custom form as a title
				try {
					String customName = "//h4[contains(text(),'" + name + "')]";
					String customName_actual = (driver.findElement(By.xpath(customName)).getText()).trim();

					if (customName_actual.equals(name)) {
						successMessage("The custom form name is displayed correctly.");
					} else {
						verificationFailedMessage("The custom form is not displayed.");
					}
				} catch (Throwable t) {
					verificationFailedMessage("The custom form is not displayed.");
				}

				for (int m = 0; m < count; m++) {

					// validate the details of the first field
					try {
						consoleMessage(field1Detail_list.get(m));
						String firstField1 = "//span[contains(text(),'" + field1Detail_list.get(m) + "')]";
						String firstField1_actual = (driver.findElement(By.xpath(firstField1)).getText()).trim();

						if (firstField1_actual.equals(field1Detail_list.get(m))) {
							successMessage("The details of the first field is displayed successfully.");
						} else {
							verificationFailedMessage("The details of the first field is not displayed.");
						}
					} catch (Throwable t) {
						verificationFailedMessage("The details of the first field is not displayed.");
					}

					// validate the details of the first field of page one
					try {
						consoleMessage(pageField1Detail_list.get(m));
						String firstField1 = "//span[contains(text(),'" + pageField1Detail_list.get(m) + "')]";
						String firstField1_actual = (driver.findElement(By.xpath(firstField1)).getText()).trim();

						if (firstField1_actual.equals(pageField1Detail_list.get(m))) {
							successMessage("The details of the first field of page one is displayed successfully.");
						} else {
							verificationFailedMessage("The details of the first field of page one is not displayed.");
						}
					} catch (Throwable t) {
						verificationFailedMessage("The details of the first field of page one is not displayed.");
					}

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

			// VALIDATE THE JUMP SURVEY/INSPECTION/CUSTOM FORM BUTTON IS LAUNCHED ASSOCIATED
			// CORPORATE LEVEL CUSTOM FORM OF THE TASK (2) AND VALIDATE THE JUMP TO MULTIPLE
			// TYPE CUSTOM FORM OPTION OF THE SAME TASK (2) (PROPERTY SUMMARY DASHBOARD) -
			// CONTRACTOR USER - JINESH CONTRACTOR
			title("VALIDATE THE JUMP SURVEY/INSPECTION/CUSTOM FORM BUTTON IS LAUNCHED ASSOCIATED CORPORATE LEVEL CUSTOM FORM OF THE TASK (2) AND VALIDATE THE JUMP TO CORPORATE LEVEL CUSTOM FORM OPTION OF THE SAME TASK (2) (PROPERTY SUMMARY DASHBOARD) - CONTRACTOR USER - JINESH CONTRACTOR");

			try {

				// wait for the element
				Thread.sleep(3000);

				// click on the task icon of the respective property
				click("taskicon_CSS");

				// click on the clear button
				click("task_createdtask_clearbtn_XPATH");

				// enter the data in the search field
				type("task_filter_CSS", taskTitle2);

				// click on the search button
				click("task_createdtask_searchbtn_XPATH");

				// verify newly created task is displayed or not
				try {
					String task = "//p[contains(text(),'" + taskTitle2 + "')]";
					String task_actual = (driver.findElement(By.xpath(task)).getText()).trim();

					if (task_actual.equals(taskTitle2)) {
						successMessage("The newly created task is verified successfully.");
					} else {
						verificationFailedMessage("The newly created task is not verified.");
					}
				} catch (Throwable t) {
					verificationFailedMessage("The newly created task is not verified.");
				}

				// click on the newly created task
				String task = "//p[contains(text(),'" + taskTitle2 + "')]";
				driver.findElement(By.xpath(task)).click();
				consoleMessage("click on the newly created task.");

				// wait for the element
				Thread.sleep(3000);

				// click on the task association tab
				click("task_taskassociationtab_XPATH");

				// scroll down the screen
				scrollBottom();

				// validate the survey radio button
				try {
					boolean surveybtn = driver
							.findElement(By.xpath(OR.getProperty("survey_task_surveybtn_disabled_XPATH"))).isEnabled();

					if (surveybtn == false) {
						successMessage("The radio button of survey is displayed disabled as expected.");
					} else {
						verificationFailedMessage("The radio button of survey is not displayed disabled.");
					}
				} catch (Throwable t) {
					verificationFailedMessage("The radio button of survey is not displayed disabled.");
				}

				// validate the inspection radio button
				try {
					boolean inspectionbtn = driver
							.findElement(
									By.xpath(OR.getProperty("task_taskassociationtab_inspectionbtn_disabled_XPATH")))
							.isEnabled();

					if (inspectionbtn == false) {
						successMessage("The radio button of inspection is displayed disabled as expected.");
					} else {
						verificationFailedMessage("The radio button of inspection is not displayed disabled.");
					}
				} catch (Throwable t) {
					verificationFailedMessage("The radio button of inspection is not displayed disabled.");
				}

				// validate the custom form radio button
				try {
					boolean customformbtn = driver
							.findElement(
									By.xpath(OR.getProperty("task_taskassociationtab_customformbtn_disabled_XPATH")))
							.isEnabled();

					if (customformbtn == false) {
						successMessage("The radio button of custom form is displayed disabled as expected.");
					} else {
						verificationFailedMessage("The radio button of custom form is not displayed disabled.");
					}
				} catch (Throwable t) {
					verificationFailedMessage("The radio button of custom form is not displayed disabled.");
				}

				// validate the dropdown of custom form
				try {
					boolean dropdown = driver
							.findElement(
									By.xpath(OR.getProperty("task_taskassociationtab_questionnerdd_disabled_XPATH")))
							.isEnabled();

					if (dropdown == false) {
						successMessage("The dropdown of custom form disabled as expected.");
					} else {
						verificationFailedMessage("The dropdown of custom form is not displayed disabled.");
					}
				} catch (Throwable t) {
					verificationFailedMessage("The dropdown of custom form is not displayed disabled.");
				}

				// validate the selected custom form is displayed or not
				try {
					String selectedQuestionnaire = "//option[@label='" + name + "' and @selected='selected']";
					boolean dropdown = driver.findElement(By.xpath(selectedQuestionnaire)).isDisplayed();

					if (dropdown == true) {
						successMessage("The selected option in the custom form dropdown is displayed as expected.");
					} else {
						verificationFailedMessage("The selected option in the custom form dropdown is not displayed.");
					}
				} catch (Throwable t) {
					verificationFailedMessage("The selected option in the custom form dropdown is not displayed.");
				}

				// validate the jump to survey/inspection/custom form button
				try {
					boolean jumpbtn = driver
							.findElement(By.xpath(OR.getProperty("task_taskassociationtab_jumpbtn_XPATH")))
							.isDisplayed();

					if (jumpbtn == true) {
						successMessage("The jump to survey/inspection/custom form button is displayed as expected.");
					} else {
						verificationFailedMessage("The jump to survey/inspection/custom form button is not displayed.");
					}
				} catch (Throwable t) {
					verificationFailedMessage("The jump to survey/inspection/custom form button is not displayed.");
				}

				// click on the jump to survey/inspection/custom form button
				click("task_taskassociationtab_jumpbtn_XPATH");

				// wait for the element
				Thread.sleep(10000);

				// scrolldown to bottom
				scrollBottom();

				// validate the custom form as a title
				try {
					String customName = "//h4[contains(text(),'" + name + "')]";
					String customName_actual = (driver.findElement(By.xpath(customName)).getText()).trim();

					if (customName_actual.equals(name)) {
						successMessage("The custom form name is displayed correctly.");
					} else {
						verificationFailedMessage("The custom form is not displayed.");
					}
				} catch (Throwable t) {
					verificationFailedMessage("The custom form is not displayed.");
				}

				for (int m = 0; m < count; m++) {

					// validate the details of the first field
					try {
						consoleMessage(field1Detail_list.get(m));
						String firstField1 = "//span[contains(text(),'" + field1Detail_list.get(m) + "')]";
						String firstField1_actual = (driver.findElement(By.xpath(firstField1)).getText()).trim();

						if (firstField1_actual.equals(field1Detail_list.get(m))) {
							successMessage("The details of the first field is displayed successfully.");
						} else {
							verificationFailedMessage("The details of the first field is not displayed.");
						}
					} catch (Throwable t) {
						verificationFailedMessage("The details of the first field is not displayed.");
					}

					// validate the details of the first field of page one
					try {
						consoleMessage(pageField1Detail_list.get(m));
						String firstField1 = "//span[contains(text(),'" + pageField1Detail_list.get(m) + "')]";
						String firstField1_actual = (driver.findElement(By.xpath(firstField1)).getText()).trim();

						if (firstField1_actual.equals(pageField1Detail_list.get(m))) {
							successMessage("The details of the first field of page one is displayed successfully.");
						} else {
							verificationFailedMessage("The details of the first field of page one is not displayed.");
						}
					} catch (Throwable t) {
						verificationFailedMessage("The details of the first field of page one is not displayed.");
					}

				}

				// wait for the element
				Thread.sleep(3000);

				// click on the back button
				click("customform_propertydashboard_backbtn_XPATH");

				// wait for the element
				Thread.sleep(3000);

				// scroll upto top
				scrollTop();

				// click on the clear button
				click("task_createdtask_clearbtn_XPATH");

				// enter the data in the search field
				type("task_filter_CSS", taskTitle2);

				// click on the search button
				click("task_createdtask_searchbtn_XPATH");

				// click on the action icon
				String actionIcon = "//p[text()='" + taskTitle2
						+ "']//parent::td//following-sibling::td[@class='text-center pointer']//i[@data-toggle='dropdown']";
				driver.findElement(By.xpath(actionIcon)).click();
				consoleMessage("Clicked on the action icon.");

				// click on the jump to custom form option
				String jumptoOption = "//p[text()='" + taskTitle2
						+ "']//parent::td//following-sibling::td[@class='text-center pointer']//div[@class='dropdown open']//li[@ng-show='isDefined(task.customFormName)']";
				driver.findElement(By.xpath(jumptoOption)).click();
				consoleMessage("Clicked on the jump to custom form option.");

				// wait for the element
				Thread.sleep(10000);

				// scroll up to top
				scrollTop();

				// validate the custom form as a title
				try {
					String customName = "//h4[contains(text(),'" + name + "')]";
					String customName_actual = (driver.findElement(By.xpath(customName)).getText()).trim();

					if (customName_actual.equals(name)) {
						successMessage("The custom form name is displayed correctly.");
					} else {
						verificationFailedMessage("The custom form is not displayed.");
					}
				} catch (Throwable t) {
					verificationFailedMessage("The custom form is not displayed.");
				}

				// click on the details tab
				String details = "//span[text()='Details']";
				driver.findElement(By.xpath(details)).click();
				consoleMessage("Clicked on the details tab.");

				// scroll down to bottom
				scrollBottom();

				// validate the first field label
				try {
					String fieldLabel1 = "//label[contains(text(),'" + fieldName1 + "')]";
					String fieldLabel1_actual = (driver.findElement(By.xpath(fieldLabel1)).getText()).trim();

					if (fieldLabel1_actual.equals(fieldName1 + ":")) {
						successMessage("The first field label is displayed successfully.");
					} else {
						verificationFailedMessage("The first field label is not displayed.");
					}
				} catch (Throwable t) {
					verificationFailedMessage("The first field label is not displayed.");
				}

				// click on the first page name tab
				String pageTab1 = "//span[text()='" + pageName1 + "']";
				driver.findElement(By.xpath(pageTab1)).click();
				consoleMessage("Clicked on the first page name tab.");

				// scroll to bottom
				scrollBottom();

				// validate the third field label
				try {
					String fieldLabel3 = "//label[contains(text(),'" + pageFieldName1 + "')]";
					String fieldLabel3_actual = (driver.findElement(By.xpath(fieldLabel3)).getText()).trim();

					if (fieldLabel3_actual.equals(pageFieldName1 + ":")) {
						successMessage("The third field label is displayed successfully.");
					} else {
						verificationFailedMessage("The third field label is not displayed.");
					}
				} catch (Throwable t) {
					verificationFailedMessage("The third field label is not displayed.");
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

			// VALIDATE THE NEWLY CREATED TASK UNDER CORPORATE LEVEL CUSTOM FORM IN THE TASK
			// MODULE BY PROPERTY MANAGER USER AND ASSOCIATE THE SAME TASK (3) WITH THE
			// NEWLY CREATED CORPORATE LEVEL CUSTOM FORM (PORTFOLIO SUMMARY DASHBOARD) -
			// CONTRACTOR USER - JINESH CONTRACTOR
			title("VALIDATE THE NEWLY CREATED TASK UNDER CORPORATE LEVEL CUSTOM FORM IN THE TASK MODULE BY PROPERTY MANAGER USER AND ASSOCIATE THE SAME TASK (3) WITH THE NEWLY CREATED CORPORATE LEVEL CUSTOM FORM (PORTFOLIO SUMMARY DASHBOARD) - CONTRACTOR USER - JINESH CONTRACTOR");

			try {

				// wait for the element
				Thread.sleep(3000);

				// click on the task icon of the respective property
				click("taskicon_CSS");

				// click on the clear button
				click("task_createdtask_clearbtn_XPATH");

				// enter the data in the search field
				type("task_filter_CSS", taskTitle3);

				// click on the search button
				click("task_createdtask_searchbtn_XPATH");

				// verify newly created task is displayed or not
				try {
					String task = "//p[contains(text(),'" + taskTitle3 + "')]";
					String task_actual = (driver.findElement(By.xpath(task)).getText()).trim();

					if (task_actual.equals(taskTitle3)) {
						successMessage("The newly created task is verified successfully.");
					} else {
						verificationFailedMessage("The newly created task is not verified.");
					}
				} catch (Throwable t) {
					verificationFailedMessage("The newly created task is not verified.");
				}

				// click on the newly created task
				String task = "//p[contains(text(),'" + taskTitle3 + "')]";
				driver.findElement(By.xpath(task)).click();
				consoleMessage("click on the newly created task.");

				// wait for the element
				Thread.sleep(3000);

				// click on the task association tab
				click("task_taskassociationtab_XPATH");

				// scroll down the screen
				scrollBottom();

				// scroll down the screen
				scrollBottom();

				// validate the jump to survey/inspection/custom form button
				try {
					boolean jumpbtn = driver
							.findElement(By.xpath(OR.getProperty("task_taskassociationtab_jumpbtn_XPATH")))
							.isDisplayed();

					if (jumpbtn == true) {
						successMessage("The jump to survey/inspection/custom form button is displayed as expected.");
					} else {
						verificationFailedMessage("The jump to survey/inspection/custom form button is not displayed.");
					}
				} catch (Throwable t) {
					verificationFailedMessage("The jump to survey/inspection/custom form button is not displayed.");
				}

				// click on the jump to survey/inspection/custom form button
				click("task_taskassociationtab_jumpbtn_XPATH");

				// wait for the element
				Thread.sleep(10000);

				// scrolldown to bottom
				scrollBottom();

				// validate the custom form as a title
				try {
					String customName = "//h4[contains(text(),'" + name + "')]";
					String customName_actual = (driver.findElement(By.xpath(customName)).getText()).trim();

					if (customName_actual.equals(name)) {
						successMessage("The custom form name is displayed correctly.");
					} else {
						verificationFailedMessage("The custom form is not displayed.");
					}
				} catch (Throwable t) {
					verificationFailedMessage("The custom form is not displayed.");
				}

				for (int m = 0; m < count; m++) {

					// validate the details of the first field
					try {
						consoleMessage(field1Detail_list.get(m));
						String firstField1 = "//span[contains(text(),'" + field1Detail_list.get(m) + "')]";
						String firstField1_actual = (driver.findElement(By.xpath(firstField1)).getText()).trim();

						if (firstField1_actual.equals(field1Detail_list.get(m))) {
							successMessage("The details of the first field is displayed successfully.");
						} else {
							verificationFailedMessage("The details of the first field is not displayed.");
						}
					} catch (Throwable t) {
						verificationFailedMessage("The details of the first field is not displayed.");
					}

					// validate the details of the first field of page one
					try {
						consoleMessage(pageField1Detail_list.get(m));
						String firstField1 = "//span[contains(text(),'" + pageField1Detail_list.get(m) + "')]";
						String firstField1_actual = (driver.findElement(By.xpath(firstField1)).getText()).trim();

						if (firstField1_actual.equals(pageField1Detail_list.get(m))) {
							successMessage("The details of the first field of page one is displayed successfully.");
						} else {
							verificationFailedMessage("The details of the first field of page one is not displayed.");
						}
					} catch (Throwable t) {
						verificationFailedMessage("The details of the first field of page one is not displayed.");
					}

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

			// VALIDATE THE JUMP SURVEY/INSPECTION/CUSTOM FORM BUTTON IS LAUNCHED ASSOCIATED
			// CORPORATE LEVEL CUSTOM FORM OF THE TASK (3) AND VALIDATE THE JUMP TO MULTIPLE
			// TYPE CUSTOM FORM OPTION OF THE SAME TASK (3) (PORTFOLIO SUMMARY DASHBOARD) -
			// CONTRACTOR USER - JINESH CONTRACTOR
			title("VALIDATE THE JUMP SURVEY/INSPECTION/CUSTOM FORM BUTTON IS LAUNCHED ASSOCIATED CORPORATE LEVEL CUSTOM FORM OF THE TASK (3) AND VALIDATE THE JUMP TO CORPORATE LEVEL CUSTOM FORM OPTION OF THE SAME TASK (3) (PORTFOLIO SUMMARY DASHBOARD) - CONTRACTOR USER - JINESH CONTRACTOR");

			try {

				// wait for the element
				Thread.sleep(3000);

				// click on the task icon of the respective property
				click("taskicon_CSS");

				// click on the clear button
				click("task_createdtask_clearbtn_XPATH");

				// enter the data in the search field
				type("task_filter_CSS", taskTitle3);

				// click on the search button
				click("task_createdtask_searchbtn_XPATH");

				// verify newly created task is displayed or not
				try {
					String task = "//p[contains(text(),'" + taskTitle3 + "')]";
					String task_actual = (driver.findElement(By.xpath(task)).getText()).trim();

					if (task_actual.equals(taskTitle3)) {
						successMessage("The newly created task is verified successfully.");
					} else {
						verificationFailedMessage("The newly created task is not verified.");
					}
				} catch (Throwable t) {
					verificationFailedMessage("The newly created task is not verified.");
				}

				// click on the newly created task
				String task = "//p[contains(text(),'" + taskTitle3 + "')]";
				driver.findElement(By.xpath(task)).click();
				consoleMessage("click on the newly created task.");

				// wait for the element
				Thread.sleep(3000);

				// click on the task association tab
				click("task_taskassociationtab_XPATH");

				// scroll down the screen
				scrollBottom();

				// validate the survey radio button
				try {
					boolean surveybtn = driver
							.findElement(By.xpath(OR.getProperty("survey_task_surveybtn_disabled_XPATH"))).isEnabled();

					if (surveybtn == false) {
						successMessage("The radio button of survey is displayed disabled as expected.");
					} else {
						verificationFailedMessage("The radio button of survey is not displayed disabled.");
					}
				} catch (Throwable t) {
					verificationFailedMessage("The radio button of survey is not displayed disabled.");
				}

				// validate the inspection radio button
				try {
					boolean inspectionbtn = driver
							.findElement(
									By.xpath(OR.getProperty("task_taskassociationtab_inspectionbtn_disabled_XPATH")))
							.isEnabled();

					if (inspectionbtn == false) {
						successMessage("The radio button of inspection is displayed disabled as expected.");
					} else {
						verificationFailedMessage("The radio button of inspection is not displayed disabled.");
					}
				} catch (Throwable t) {
					verificationFailedMessage("The radio button of inspection is not displayed disabled.");
				}

				// validate the custom form radio button
				try {
					boolean customformbtn = driver
							.findElement(
									By.xpath(OR.getProperty("task_taskassociationtab_customformbtn_disabled_XPATH")))
							.isEnabled();

					if (customformbtn == false) {
						successMessage("The radio button of custom form is displayed disabled as expected.");
					} else {
						verificationFailedMessage("The radio button of custom form is not displayed disabled.");
					}
				} catch (Throwable t) {
					verificationFailedMessage("The radio button of custom form is not displayed disabled.");
				}

				// validate the dropdown of custom form
				try {
					boolean dropdown = driver
							.findElement(
									By.xpath(OR.getProperty("task_taskassociationtab_questionnerdd_disabled_XPATH")))
							.isEnabled();

					if (dropdown == false) {
						successMessage("The dropdown of custom form disabled as expected.");
					} else {
						verificationFailedMessage("The dropdown of custom form is not displayed disabled.");
					}
				} catch (Throwable t) {
					verificationFailedMessage("The dropdown of custom form is not displayed disabled.");
				}

				// validate the selected custom form is displayed or not
				try {
					String selectedQuestionnaire = "//option[@label='" + name + "' and @selected='selected']";
					boolean dropdown = driver.findElement(By.xpath(selectedQuestionnaire)).isDisplayed();

					if (dropdown == true) {
						successMessage("The selected option in the custom form dropdown is displayed as expected.");
					} else {
						verificationFailedMessage("The selected option in the custom form dropdown is not displayed.");
					}
				} catch (Throwable t) {
					verificationFailedMessage("The selected option in the custom form dropdown is not displayed.");
				}

				// validate the jump to survey/inspection/custom form button
				try {
					boolean jumpbtn = driver
							.findElement(By.xpath(OR.getProperty("task_taskassociationtab_jumpbtn_XPATH")))
							.isDisplayed();

					if (jumpbtn == true) {
						successMessage("The jump to survey/inspection/custom form button is displayed as expected.");
					} else {
						verificationFailedMessage("The jump to survey/inspection/custom form button is not displayed.");
					}
				} catch (Throwable t) {
					verificationFailedMessage("The jump to survey/inspection/custom form button is not displayed.");
				}

				// click on the jump to survey/inspection/custom form button
				click("task_taskassociationtab_jumpbtn_XPATH");

				// wait for the element
				Thread.sleep(10000);

				// scrolldown to bottom
				scrollBottom();

				// validate the custom form as a title
				try {
					String customName = "//h4[contains(text(),'" + name + "')]";
					String customName_actual = (driver.findElement(By.xpath(customName)).getText()).trim();

					if (customName_actual.equals(name)) {
						successMessage("The custom form name is displayed correctly.");
					} else {
						verificationFailedMessage("The custom form is not displayed.");
					}
				} catch (Throwable t) {
					verificationFailedMessage("The custom form is not displayed.");
				}

				for (int m = 0; m < count; m++) {

					// validate the details of the first field
					try {
						consoleMessage(field1Detail_list.get(m));
						String firstField1 = "//span[contains(text(),'" + field1Detail_list.get(m) + "')]";
						String firstField1_actual = (driver.findElement(By.xpath(firstField1)).getText()).trim();

						if (firstField1_actual.equals(field1Detail_list.get(m))) {
							successMessage("The details of the first field is displayed successfully.");
						} else {
							verificationFailedMessage("The details of the first field is not displayed.");
						}
					} catch (Throwable t) {
						verificationFailedMessage("The details of the first field is not displayed.");
					}

					// validate the details of the first field of page one
					try {
						consoleMessage(pageField1Detail_list.get(m));
						String firstField1 = "//span[contains(text(),'" + pageField1Detail_list.get(m) + "')]";
						String firstField1_actual = (driver.findElement(By.xpath(firstField1)).getText()).trim();

						if (firstField1_actual.equals(pageField1Detail_list.get(m))) {
							successMessage("The details of the first field of page one is displayed successfully.");
						} else {
							verificationFailedMessage("The details of the first field of page one is not displayed.");
						}
					} catch (Throwable t) {
						verificationFailedMessage("The details of the first field of page one is not displayed.");
					}

				}

				// wait for the element
				Thread.sleep(3000);

				// click on the back button
				click("customform_propertydashboard_backbtn_XPATH");

				// wait for the element
				Thread.sleep(3000);

				// scroll upto top
				scrollTop();

				// click on the clear button
				click("task_createdtask_clearbtn_XPATH");

				// enter the data in the search field
				type("task_filter_CSS", taskTitle3);

				// click on the search button
				click("task_createdtask_searchbtn_XPATH");

				// click on the action icon
				String actionIcon = "//p[text()='" + taskTitle3
						+ "']//parent::td//following-sibling::td[@class='text-center pointer']//i[@data-toggle='dropdown']";
				driver.findElement(By.xpath(actionIcon)).click();
				consoleMessage("Clicked on the action icon.");

				// click on the jump to custom form option
				String jumptoOption = "//p[text()='" + taskTitle3
						+ "']//parent::td//following-sibling::td[@class='text-center pointer']//div[@class='dropdown open']//li[@ng-show='isDefined(task.customFormName)']";
				driver.findElement(By.xpath(jumptoOption)).click();
				consoleMessage("Clicked on the jump to custom form option.");

				// wait for the element
				Thread.sleep(10000);

				// scroll up to top
				scrollTop();

				// validate the custom form as a title
				try {
					String customName = "//h4[contains(text(),'" + name + "')]";
					String customName_actual = (driver.findElement(By.xpath(customName)).getText()).trim();

					if (customName_actual.equals(name)) {
						successMessage("The custom form name is displayed correctly.");
					} else {
						verificationFailedMessage("The custom form is not displayed.");
					}
				} catch (Throwable t) {
					verificationFailedMessage("The custom form is not displayed.");
				}

				// click on the details tab
				String details = "//span[text()='Details']";
				driver.findElement(By.xpath(details)).click();
				consoleMessage("Clicked on the details tab.");

				// scroll down to bottom
				scrollBottom();

				// validate the first field label
				try {
					String fieldLabel1 = "//label[contains(text(),'" + fieldName1 + "')]";
					String fieldLabel1_actual = (driver.findElement(By.xpath(fieldLabel1)).getText()).trim();

					if (fieldLabel1_actual.equals(fieldName1 + ":")) {
						successMessage("The first field label is displayed successfully.");
					} else {
						verificationFailedMessage("The first field label is not displayed.");
					}
				} catch (Throwable t) {
					verificationFailedMessage("The first field label is not displayed.");
				}

				// click on the first page name tab
				String pageTab1 = "//span[text()='" + pageName1 + "']";
				driver.findElement(By.xpath(pageTab1)).click();
				consoleMessage("Clicked on the first page name tab.");

				// scroll to bottom
				scrollBottom();

				// validate the third field label
				try {
					String fieldLabel3 = "//label[contains(text(),'" + pageFieldName1 + "')]";
					String fieldLabel3_actual = (driver.findElement(By.xpath(fieldLabel3)).getText()).trim();

					if (fieldLabel3_actual.equals(pageFieldName1 + ":")) {
						successMessage("The third field label is displayed successfully.");
					} else {
						verificationFailedMessage("The third field label is not displayed.");
					}
				} catch (Throwable t) {
					verificationFailedMessage("The third field label is not displayed.");
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

			// LOGOUT THE SESSION FROM THE CONTRACTOR USER - JINESH CONTRACTOR AND LOGIN TO
			// ADMIN USER
			title("LOGOUT THE SESSION FROM THE CONTRACTOR USER - JINESH CONTRACTOR USER AND LOGIN TO ADMIN USER");

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
		title("LOGOUT THE SESSION FROM THE ADMIN USER AND LOGIN TO HR USER - JINESH HR");

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

			// VALIDATE THE JUMP SURVEY/INSPECTION/CUSTOM FORM BUTTON IS LAUNCHED ASSOCIATED
			// CORPORATE LEVEL CUSTOM FORM OF THE TASK (1) WHICH WAS CREATED BY ADMIN USER -
			// HR USER - JINESH HR
			title("VALIDATE THE JUMP SURVEY/INSPECTION/CUSTOM FORM BUTTON IS LAUNCHED ASSOCIATED CORPORATE LEVEL CUSTOM FORM OF THE TASK (1) WHICH WAS CREATED BY ADMIN USER - HR USER - JINESH HR");

			try {
				// wait for the element
				Thread.sleep(3000);

				// click on the task icon of the respective property
				click("taskicon_CSS");

				// click on the clear button
				click("task_createdtask_clearbtn_XPATH");

				// enter the data in the search field
				type("task_filter_CSS", taskTitle1);

				// click on the search button
				click("task_createdtask_searchbtn_XPATH");

				// verify newly created task is displayed or not
				try {
					String task = "//p[contains(text(),'" + taskTitle1 + "')]";
					String task_actual = (driver.findElement(By.xpath(task)).getText()).trim();

					if (task_actual.equals(taskTitle1)) {
						successMessage("The newly created task is verified successfully.");
					} else {
						verificationFailedMessage("The newly created task is not verified.");
					}
				} catch (Throwable t) {
					verificationFailedMessage("The newly created task is not verified.");
				}

				// click on the newly created task
				String task = "//p[contains(text(),'" + taskTitle1 + "')]";
				driver.findElement(By.xpath(task)).click();
				consoleMessage("click on the newly created task.");

				// wait for the element
				Thread.sleep(3000);

				// click on the task association tab
				click("task_taskassociationtab_XPATH");

				// scroll down the screen
				scrollBottom();

				// validate the survey radio button
				try {
					boolean surveybtn = driver
							.findElement(By.xpath(OR.getProperty("survey_task_surveybtn_disabled_XPATH"))).isEnabled();

					if (surveybtn == false) {
						successMessage("The radio button of survey is displayed disabled as expected.");
					} else {
						verificationFailedMessage("The radio button of survey is not displayed disabled.");
					}
				} catch (Throwable t) {
					verificationFailedMessage("The radio button of survey is not displayed disabled.");
				}

				// validate the inspection radio button
				try {
					boolean inspectionbtn = driver
							.findElement(
									By.xpath(OR.getProperty("task_taskassociationtab_inspectionbtn_disabled_XPATH")))
							.isEnabled();

					if (inspectionbtn == false) {
						successMessage("The radio button of inspection is displayed disabled as expected.");
					} else {
						verificationFailedMessage("The radio button of inspection is not displayed disabled.");
					}
				} catch (Throwable t) {
					verificationFailedMessage("The radio button of inspection is not displayed disabled.");
				}

				// validate the custom form radio button
				try {
					boolean customformbtn = driver
							.findElement(
									By.xpath(OR.getProperty("task_taskassociationtab_customformbtn_disabled_XPATH")))
							.isEnabled();

					if (customformbtn == false) {
						successMessage("The radio button of custom form is displayed disabled as expected.");
					} else {
						verificationFailedMessage("The radio button of custom form is not displayed disabled.");
					}
				} catch (Throwable t) {
					verificationFailedMessage("The radio button of custom form is not displayed disabled.");
				}

				// validate the dropdown of custom form
				try {
					boolean dropdown = driver
							.findElement(
									By.xpath(OR.getProperty("task_taskassociationtab_questionnerdd_disabled_XPATH")))
							.isEnabled();

					if (dropdown == false) {
						successMessage("The dropdown of custom form disabled as expected.");
					} else {
						verificationFailedMessage("The dropdown of custom form is not displayed disabled.");
					}
				} catch (Throwable t) {
					verificationFailedMessage("The dropdown of custom form is not displayed disabled.");
				}

				// validate the selected custom form is displayed or not
				try {
					String selectedQuestionnaire = "//option[@label='" + name + "' and @selected='selected']";
					boolean dropdown = driver.findElement(By.xpath(selectedQuestionnaire)).isDisplayed();

					if (dropdown == true) {
						successMessage("The selected option in the custom form dropdown is displayed as expected.");
					} else {
						verificationFailedMessage("The selected option in the custom form dropdown is not displayed.");
					}
				} catch (Throwable t) {
					verificationFailedMessage("The selected option in the custom form dropdown is not displayed.");
				}

				// validate the jump to survey/inspection/custom form button
				try {
					boolean jumpbtn = driver
							.findElement(By.xpath(OR.getProperty("task_taskassociationtab_jumpbtn_XPATH")))
							.isDisplayed();

					if (jumpbtn == true) {
						verificationFailedMessage("The jump to survey/inspection/custom form button is displayed.");

					} else {
						successMessage(
								"The jump to survey/inspection/custom form button is not displayed as expected.");
					}
				} catch (Throwable t) {
					successMessage("The jump to survey/inspection/custom form button is not displayed as expected.");
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

			// VALIDATE THE JUMP SURVEY/INSPECTION/CUSTOM FORM BUTTON OF THE CORPORATE LEVEL
			// CUSTOM FORM OF THE TASK (2) WHICH WAS CREATED UNDER CORPORATE LEVEL CUSTOM
			// FORM
			// BY PROPERTY MANAGER USER - HR USER - JINESH HR
			title("VALIDATE THE JUMP SURVEY/INSPECTION/CUSTOM FORM BUTTON OF THE CORPORATE LEVEL CUSTOM FORM OF THE TASK (2) WHICH WAS CREATED UNDER CORPORATE LEVEL CUSTOM FORM BY PROPERTY MANAGER USER - HR USER - JINESH HR");

			try {
				// wait for the element
				Thread.sleep(3000);

				// click on the task icon of the respective property
				click("taskicon_CSS");

				// click on the clear button
				click("task_createdtask_clearbtn_XPATH");

				// enter the data in the search field
				type("task_filter_CSS", taskTitle2);

				// click on the search button
				click("task_createdtask_searchbtn_XPATH");

				// verify newly created task is displayed or not
				try {
					String task = "//p[contains(text(),'" + taskTitle2 + "')]";
					String task_actual = (driver.findElement(By.xpath(task)).getText()).trim();

					if (task_actual.equals(taskTitle2)) {
						successMessage("The newly created task is verified successfully.");
					} else {
						verificationFailedMessage("The newly created task is not verified.");
					}
				} catch (Throwable t) {
					verificationFailedMessage("The newly created task is not verified.");
				}

				// click on the newly created task
				String task = "//p[contains(text(),'" + taskTitle2 + "')]";
				driver.findElement(By.xpath(task)).click();
				consoleMessage("click on the newly created task.");

				// wait for the element
				Thread.sleep(3000);

				// click on the task association tab
				click("task_taskassociationtab_XPATH");

				// scroll down the screen
				scrollBottom();

				// validate the survey radio button
				try {
					boolean surveybtn = driver
							.findElement(By.xpath(OR.getProperty("survey_task_surveybtn_disabled_XPATH"))).isEnabled();

					if (surveybtn == false) {
						successMessage("The radio button of survey is displayed disabled as expected.");
					} else {
						verificationFailedMessage("The radio button of survey is not displayed disabled.");
					}
				} catch (Throwable t) {
					verificationFailedMessage("The radio button of survey is not displayed disabled.");
				}

				// validate the inspection radio button
				try {
					boolean inspectionbtn = driver
							.findElement(
									By.xpath(OR.getProperty("task_taskassociationtab_inspectionbtn_disabled_XPATH")))
							.isEnabled();

					if (inspectionbtn == false) {
						successMessage("The radio button of inspection is displayed disabled as expected.");
					} else {
						verificationFailedMessage("The radio button of inspection is not displayed disabled.");
					}
				} catch (Throwable t) {
					verificationFailedMessage("The radio button of inspection is not displayed disabled.");
				}

				// validate the custom form radio button
				try {
					boolean customformbtn = driver
							.findElement(
									By.xpath(OR.getProperty("task_taskassociationtab_customformbtn_disabled_XPATH")))
							.isEnabled();

					if (customformbtn == false) {
						successMessage("The radio button of custom form is displayed disabled as expected.");
					} else {
						verificationFailedMessage("The radio button of custom form is not displayed disabled.");
					}
				} catch (Throwable t) {
					verificationFailedMessage("The radio button of custom form is not displayed disabled.");
				}

				// validate the dropdown of custom form
				try {
					boolean dropdown = driver
							.findElement(
									By.xpath(OR.getProperty("task_taskassociationtab_questionnerdd_disabled_XPATH")))
							.isEnabled();

					if (dropdown == false) {
						successMessage("The dropdown of custom form disabled as expected.");
					} else {
						verificationFailedMessage("The dropdown of custom form is not displayed disabled.");
					}
				} catch (Throwable t) {
					verificationFailedMessage("The dropdown of custom form is not displayed disabled.");
				}

				// validate the selected custom form is displayed or not
				try {
					String selectedQuestionnaire = "//option[@label='" + name + "' and @selected='selected']";
					boolean dropdown = driver.findElement(By.xpath(selectedQuestionnaire)).isDisplayed();

					if (dropdown == true) {
						successMessage("The selected option in the custom form dropdown is displayed as expected.");
					} else {
						verificationFailedMessage("The selected option in the custom form dropdown is not displayed.");
					}
				} catch (Throwable t) {
					verificationFailedMessage("The selected option in the custom form dropdown is not displayed.");
				}

				// validate the jump to survey/inspection/custom form button
				try {
					boolean jumpbtn = driver
							.findElement(By.xpath(OR.getProperty("task_taskassociationtab_jumpbtn_XPATH")))
							.isDisplayed();

					if (jumpbtn == true) {
						verificationFailedMessage("The jump to survey/inspection/custom form button is displayed.");

					} else {
						successMessage(
								"The jump to survey/inspection/custom form button is not displayed as expected.");
					}
				} catch (Throwable t) {
					successMessage("The jump to survey/inspection/custom form button is not displayed as expected.");
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

			// VALIDATE THE JUMP TO CORPORATE LEVEL CUSTOM FORM OPTION OF THE TASK (2) WHICH
			// WAS CREATED BY PROPERTY MANAGER USER (PROPERTY SUMMARY DASHBOARD) - HR USER -
			// JINESH HR
			title("VALIDATE THE JUMP TO CORPORATE LEVEL CUSTOM FORM OPTION OF THE TASK (2) WHICH WAS CREATED BY PROPERTY MANAGER USER (PROPERTY SUMMARY DASHBOARD) - HR USER - JINESH HR");

			try {

				// wait for the element
				Thread.sleep(3000);

				// click on the task icon of the respective property
				click("taskicon_CSS");

				// click on the clear button
				click("task_createdtask_clearbtn_XPATH");

				// enter the data in the search field
				type("task_filter_CSS", taskTitle2);

				// click on the search button
				click("task_createdtask_searchbtn_XPATH");

				// verify newly created task is displayed or not
				try {
					String task = "//p[contains(text(),'" + taskTitle2 + "')]";
					String task_actual = (driver.findElement(By.xpath(task)).getText()).trim();

					if (task_actual.equals(taskTitle2)) {
						successMessage("The newly created task is verified successfully.");
					} else {
						verificationFailedMessage("The newly created task is not verified.");
					}
				} catch (Throwable t) {
					verificationFailedMessage("The newly created task is not verified.");
				}

				// click on the action icon
				String actionIcon = "//p[text()='" + taskTitle2
						+ "']//parent::td//following-sibling::td[@class='text-center pointer']//i[@data-toggle='dropdown']";
				driver.findElement(By.xpath(actionIcon)).click();
				consoleMessage("Clicked on the action icon.");

				// click on the jump to custom form option
				try {
					String jumptoOption = "//p[text()='" + taskTitle2
							+ "']//parent::td//following-sibling::td[@class='text-center pointer']//div[@class='dropdown open']//li[@ng-show='isDefined(task.customFormName)']";
					boolean jumptoOption_actual = driver.findElement(By.xpath(jumptoOption)).isDisplayed();

					if (jumptoOption_actual == true) {
						verificationFailedMessage("The jump to custom form option is displayed without permission.");
					} else {
						successMessage("The jump to custom form option is not displayed as expected.");
					}
				} catch (Throwable t) {
					successMessage("The jump to custom form option is not displayed as expected.");
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

			// VALIDATE THE JUMP SURVEY/INSPECTION/CUSTOM FORM BUTTON OF THE CORPORATE LEVEL
			// CUSTOM FORM OF THE TASK (3) WHICH WAS CREATED UNDER CORPORATE LEVEL CUSTOM
			// FORM
			// BY PORTFOLIO MANAGER USER - HR USER - JINESH HR
			title("VALIDATE THE JUMP SURVEY/INSPECTION/CUSTOM FORM BUTTON OF THE CORPORATE LEVEL CUSTOM FORM OF THE TASK (3) WHICH WAS CREATED UNDER CORPORATE LEVEL CUSTOM FORM BY PORTFOLIO MANAGER USER - HR USER - JINESH HR");

			try {
				// wait for the element
				Thread.sleep(3000);

				// click on the task icon of the respective property
				click("taskicon_CSS");

				// click on the clear button
				click("task_createdtask_clearbtn_XPATH");

				// enter the data in the search field
				type("task_filter_CSS", taskTitle3);

				// click on the search button
				click("task_createdtask_searchbtn_XPATH");

				// verify newly created task is displayed or not
				try {
					String task = "//p[contains(text(),'" + taskTitle3 + "')]";
					String task_actual = (driver.findElement(By.xpath(task)).getText()).trim();

					if (task_actual.equals(taskTitle3)) {
						successMessage("The newly created task is verified successfully.");
					} else {
						verificationFailedMessage("The newly created task is not verified.");
					}
				} catch (Throwable t) {
					verificationFailedMessage("The newly created task is not verified.");
				}

				// click on the newly created task
				String task = "//p[contains(text(),'" + taskTitle3 + "')]";
				driver.findElement(By.xpath(task)).click();
				consoleMessage("click on the newly created task.");

				// wait for the element
				Thread.sleep(3000);

				// click on the task association tab
				click("task_taskassociationtab_XPATH");

				// scroll down the screen
				scrollBottom();

				// validate the survey radio button
				try {
					boolean surveybtn = driver
							.findElement(By.xpath(OR.getProperty("survey_task_surveybtn_disabled_XPATH"))).isEnabled();

					if (surveybtn == false) {
						successMessage("The radio button of survey is displayed disabled as expected.");
					} else {
						verificationFailedMessage("The radio button of survey is not displayed disabled.");
					}
				} catch (Throwable t) {
					verificationFailedMessage("The radio button of survey is not displayed disabled.");
				}

				// validate the inspection radio button
				try {
					boolean inspectionbtn = driver
							.findElement(
									By.xpath(OR.getProperty("task_taskassociationtab_inspectionbtn_disabled_XPATH")))
							.isEnabled();

					if (inspectionbtn == false) {
						successMessage("The radio button of inspection is displayed disabled as expected.");
					} else {
						verificationFailedMessage("The radio button of inspection is not displayed disabled.");
					}
				} catch (Throwable t) {
					verificationFailedMessage("The radio button of inspection is not displayed disabled.");
				}

				// validate the custom form radio button
				try {
					boolean customformbtn = driver
							.findElement(
									By.xpath(OR.getProperty("task_taskassociationtab_customformbtn_disabled_XPATH")))
							.isEnabled();

					if (customformbtn == false) {
						successMessage("The radio button of custom form is displayed disabled as expected.");
					} else {
						verificationFailedMessage("The radio button of custom form is not displayed disabled.");
					}
				} catch (Throwable t) {
					verificationFailedMessage("The radio button of custom form is not displayed disabled.");
				}

				// validate the dropdown of custom form
				try {
					boolean dropdown = driver
							.findElement(
									By.xpath(OR.getProperty("task_taskassociationtab_questionnerdd_disabled_XPATH")))
							.isEnabled();

					if (dropdown == false) {
						successMessage("The dropdown of custom form disabled as expected.");
					} else {
						verificationFailedMessage("The dropdown of custom form is not displayed disabled.");
					}
				} catch (Throwable t) {
					verificationFailedMessage("The dropdown of custom form is not displayed disabled.");
				}

				// validate the selected custom form is displayed or not
				try {
					String selectedQuestionnaire = "//option[@label='" + name + "' and @selected='selected']";
					boolean dropdown = driver.findElement(By.xpath(selectedQuestionnaire)).isDisplayed();

					if (dropdown == true) {
						successMessage("The selected option in the custom form dropdown is displayed as expected.");
					} else {
						verificationFailedMessage("The selected option in the custom form dropdown is not displayed.");
					}
				} catch (Throwable t) {
					verificationFailedMessage("The selected option in the custom form dropdown is not displayed.");
				}

				// validate the jump to survey/inspection/custom form button
				try {
					boolean jumpbtn = driver
							.findElement(By.xpath(OR.getProperty("task_taskassociationtab_jumpbtn_XPATH")))
							.isDisplayed();

					if (jumpbtn == true) {
						verificationFailedMessage("The jump to survey/inspection/custom form button is displayed.");

					} else {
						successMessage(
								"The jump to survey/inspection/custom form button is not displayed as expected.");
					}
				} catch (Throwable t) {
					successMessage("The jump to survey/inspection/custom form button is not displayed as expected.");
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

			// VALIDATE THE JUMP TO CORPORATE LEVEL CUSTOM FORM OPTION OF THE TASK (3) WHICH
			// WAS CREATED BY PROPERTY MANAGER USER (PORTFOLIO SUMMARY DASHBOARD) - HR USER
			// - JINESH HR
			title("VALIDATE THE JUMP TO CORPORATE LEVEL CUSTOM FORM OPTION OF THE TASK (3) WHICH WAS CREATED BY PROPERTY MANAGER USER (PORTFOLIO SUMMARY DASHBOARD) - HR USER - JINESH HR");

			try {

				// wait for the element
				Thread.sleep(3000);

				// click on the task icon of the respective property
				click("taskicon_CSS");

				// click on the clear button
				click("task_createdtask_clearbtn_XPATH");

				// enter the data in the search field
				type("task_filter_CSS", taskTitle3);

				// click on the search button
				click("task_createdtask_searchbtn_XPATH");

				// verify newly created task is displayed or not
				try {
					String task = "//p[contains(text(),'" + taskTitle3 + "')]";
					String task_actual = (driver.findElement(By.xpath(task)).getText()).trim();

					if (task_actual.equals(taskTitle3)) {
						successMessage("The newly created task is verified successfully.");
					} else {
						verificationFailedMessage("The newly created task is not verified.");
					}
				} catch (Throwable t) {
					verificationFailedMessage("The newly created task is not verified.");
				}

				// click on the action icon
				String actionIcon = "//p[text()='" + taskTitle3
						+ "']//parent::td//following-sibling::td[@class='text-center pointer']//i[@data-toggle='dropdown']";
				driver.findElement(By.xpath(actionIcon)).click();
				consoleMessage("Clicked on the action icon.");

				// click on the jump to custom form option
				try {
					String jumptoOption = "//p[text()='" + taskTitle3
							+ "']//parent::td//following-sibling::td[@class='text-center pointer']//div[@class='dropdown open']//li[@ng-show='isDefined(task.customFormName)']";
					boolean jumptoOption_actual = driver.findElement(By.xpath(jumptoOption)).isDisplayed();

					if (jumptoOption_actual == true) {
						verificationFailedMessage("The jump to custom form option is displayed without permission.");
					} else {
						successMessage("The jump to custom form option is not displayed as expected.");
					}
				} catch (Throwable t) {
					successMessage("The jump to custom form option is not displayed as expected.");
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

		// DELETE THE NEWLY CREATED TASKS FROM THE PROPERTY LEVEL
		title("DELETE THE NEWLY CREATED TASKS FROM THE PROPERTY LEVEL");

		try {
			// click on the task icon of the respective property
			click("taskicon_CSS");

			String[] taskTitle = { taskTitle1, taskTitle2, taskTitle3 };

			for (int i = 0; i < taskTitle.length; i++) {

				// click on the clear button
				click("task_createdtask_clearbtn_XPATH");

				// enter the data in the search field
				type("task_filter_CSS", taskTitle[i]);

				// click on the search button
				click("task_createdtask_searchbtn_XPATH");

				// verify newly created task is displayed or not
				try {
					String task = "//p[contains(text(),'" + taskTitle[i] + "')]";
					String task_actual = (driver.findElement(By.xpath(task)).getText()).trim();

					if (task_actual.equals(taskTitle[i])) {

						successMessage("The newly created task is verified successfully.");

					} else {
						verificationFailedMessage("The newly created task is not verified.");
					}
				} catch (Throwable t) {
					verificationFailedMessage("The newly created task is not verified.");
				}

				// click on the action icon
				String actionIcon = "//p[text()='" + taskTitle[i]
						+ "']//parent::td//following-sibling::td[@class='text-center pointer']//i[@data-toggle='dropdown']";
				driver.findElement(By.xpath(actionIcon)).click();
				consoleMessage("Clicked on the action icon.");

				// click on the delete option
				String deleteOption = "//p[text()='" + taskTitle[i]
						+ "']//parent::td//following-sibling::td[@class='text-center pointer']//div[@class='dropdown open']//li[@ng-click='deleteSelectedTask(task.id, false);']";
				driver.findElement(By.xpath(deleteOption)).click();
				consoleMessage("Clicked on the delete option.");

				// wait for the element
				explicitWaitClickable("closetoastmsg_CSS");

				// click on the toaster close button
				click("closetoastmsg_CSS");

				// click on the clear button
				click("task_createdtask_clearbtn_XPATH");

				// enter the data in the search field
				type("task_filter_CSS", taskTitle[i]);

				// click on the search button
				click("task_createdtask_searchbtn_XPATH");

				// validate the deleted task
				try {
					String task = "//p[contains(text(),'" + taskTitle[i] + "')]";
					String task_actual = (driver.findElement(By.xpath(task)).getText()).trim();

					if (task_actual.equals(taskTitle[i])) {
						verificationFailedMessage("The newly created task is not deleted.");
					} else {
						successMessage("The newly created task is deleted successfully.");
					}
				} catch (Throwable t) {
					successMessage("The newly created task is deleted successfully.");
				}

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
			consoleMessage("click on the delete button of the newly created custom form.");

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
