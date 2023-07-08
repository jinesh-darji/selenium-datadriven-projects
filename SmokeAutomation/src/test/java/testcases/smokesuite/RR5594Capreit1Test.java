package testcases.smokesuite;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Date;
import java.util.Hashtable;
import java.util.List;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;
import org.testng.SkipException;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import base.TestBase;
import utilities.TestUtil;

public class RR5594Capreit1Test extends TestBase {

	@Test(dataProviderClass = TestUtil.class, dataProvider = "dp")
	public void rR5594Capreit1Test(Hashtable<String, String> data) throws IOException, InterruptedException {

		execution(data, "rR5594Capreit1Test");

		// refresh the page
		driver.navigate().refresh();
		Thread.sleep(5000);
		driver.navigate().refresh();

		// VERIFY THE "NEW REPAIR" FEATURE IN THE "MORTGAGE UNDERTAKING", "CAPEX
		// PROJECT", AND "MUNICIPAL ORDER" MODULES.
		title("VERIFY THE NEW REPAIR FEATURE IN THE MORTGAGE UNDERTAKING, CAPEX PROJECT, AND MUNICIPAL ORDER MODULES.");

		// LOGIN WITH ADMIN USER
		title("LOGIN WITH ADMIN USER");

		try {
			// wait for the element
			explicitWaitClickable("signinbtn_BTNTEXT");

			// Enter the username
			type("usernametxt_CSS", data.get("username_1"));

			// Enter the password
			type("passwordtxt_CSS", data.get("password_1"));

			// Clicking on the "Sign In" button
			click("signinbtn_BTNTEXT");

			// wait for the element
			explicitWait("propertylist_title_XPATH");

			// verify the property list
			switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

			// UPDATE THE SYSTEM COMPANY
			updateCompany(data);

		} catch (Throwable t) {
			verificationFailed();
		}

		// VERIFY THE "NEW REPAIR" FEATURE IN THE "MORTGAGE UNDERTAKING" MODULE
		title("VERIFY THE \"NEW REPAIR\" FEATURE IN THE \"MORTGAGE UNDERTAKING\" MODULE");

		try {

			// enter the property name in the search field
			type("envreports_propertylist_filtertxt_CSS", data.get("property_1"));

			// click on the property project icon from the property list page
			click("propertyproject_icon_CSS");

			// wait for the element
			Thread.sleep(5000);

			// click on the burger menu
			click("menubtn_CSS");

			// wait for the element
			Thread.sleep(5000);

			// click on the Mortgage Undertakings
			click("propertyproject_mortgageundertakingsoption_XPATH");

			// ADD RECORD - MORTGAGE UNDERTAKINGS
			title("ADD RECORD - MORTGAGE UNDERTAKINGS");

			// click on the add button
			click("propertyproject_mu_addbtn_CSS");

			// enter the undertaking number
			type("propertyproject_mu_undertakingnumbertxt_CSS", data.get("undertaking_number"));

			// select the lender
			select("propertyproject_mu_lenderdd_CSS", data.get("lender"));

			// click on the save button
			click("propertyproject_mu_savebtn_CSS");

			// wait for the element
			explicitWaitClickable("propertyproject_mu_newrepairbtn_BTNTEXT");

			// click on the new repair button
			click("propertyproject_mu_newrepairbtn_BTNTEXT");

			// scroll down the screen

			scrollByPixel(400);

			// enter the title of the repair
			type("propertyproject_mu_repair_titletxt_CSS", data.get("task_title"));

			// enter the description
			type("propertyproject_mu_descriptiontxt_CSS", data.get("short_description"));

			// enter the unit number
			type("propertyproject_mu_unitenotxt_CSS", data.get("unit_number"));

			// click on assign to field
			click("propertyproject_mu_repair_assigntotxt_CSS");

			// click on the none button
			click("propertyproject_mu_repair_nonebtn_CSS");

			// enter username in search field
			type("propertyproject_mu_repair_searchusertxt_CSS", data.get("search_user"));

			// click on the searched username
			click("propertyproject_mu_repair_searcheduser_XPATH");

			// click on assign to field
			click("propertyproject_mu_repair_assigntotxt_CSS");

			// scroll up the screen
			scrollByPixel(-400);

			// ADD DETAILS IN THE COST / BUDGET TAB
			title("ADD DETAILS IN THE COST / BUDGET TAB");

			// click on the cost/budget tab
			click("propertyproject_mu_costbudgettab_CSS");

			// scroll down the screen
			scrollByPixel(400);

			// ADD NEWLY CONTRACTOR
			title("ADD NEWLY CONTRACTOR");

			// click on the add contractor icon
			click("propertyproject_mu_addcontractoricon_CSS");

			// scroll up the screen
			scrollByPixel(-400);

			// generate the random contractor name
			String s = RandomStringUtils.randomAlphabetic(8);

			// enter the contractor name
			type("propertyproject_mu_contractornametxt_CSS", s);

			// enter the telephone number
			type("propertyproject_mu_telephonetxt_CSS", "9876543210");

			// enter the city name
			type("propertyproject_mu_citytxt_CSS", data.get("city"));

			// enter the province name
			type("propertyproject_mu_provincetxt_CSS", data.get("province"));

			// enter the country name
			type("propertyproject_mu_countrytxt_CSS", data.get("country"));

			// click on the save button
			click("propertyproject_mu_contrctorsavebtn_CSS");

			// CONTINUE ON DETAILS OF COST / BUDGET TAB
			title("CONTINUE ON DETAILS OF COST / BUDGET TAB");

			// scroll down the screen
			scrollByPixel(400);

			// wait for the element
			explicitWait("propertyproject_mu_contrctortxt_CSS");

			// select on the contractor field
			select("propertyproject_mu_contrctortxt_CSS", s);

			// enter the po number
			type("propertyproject_mu_ponumbertxt_CSS", data.get("task_ponumber"));

			// enter the estimate amount
			type("propertyproject_mu_estimateamounttxt_CSS", "332211");

			// enter the budget amount
			type("propertyproject_mu_budgetamounttxt_CSS", "665544");

			// enter the final cost
			type("propertyproject_mu_finalcosttxt_CSS", "998877");

			// scroll up the screen
			scrollByPixel(-400);

			// click on the update button
			click("propertyproject_mu_taskupdatebtn_BTNTEXT");

			// wait for the element
			explicitWait("propertyproject_mu_addedrepair1_capreit1_XPATH");

			// verify newly created repair is displayed or not
			switchVerification("propertyproject_mu_addedrepair1_capreit1_XPATH",
					"Test Mortgage Undertakings Title Capreit1",
					"The Test Mortgage Undertakings Title Capreit1 is not displayed.");

			// click on the update button
			click("propertyproject_mu_taskupdatebtn_BTNTEXT");

			// verification of the Mortgage Undertakings is added or not
			switchVerification("propertyproject_mu_addedmortgageundertakings1_capreit1_XPATH",
					"UNDERTAKINGCAPREIT12021", "Mortgage Undertakings is not displayed successfully.");

		} catch (Throwable t) {
			verificationFailed();
		}

		// click on the home icon from the top of the screen
		click("questionnaire_homeburgermenubtn_hide_CSS");

		// synchronization
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// VERIFY THE "NEW REPAIR" FEATURE IN THE "CAPEX PROJECT" MODULE
		title("VERIFY THE \"NEW REPAIR\" FEATURE IN THE \"CAPEX PROJECT\" MODULE");

		try {

			// enter the property name in the search field
			type("envreports_propertylist_filtertxt_CSS", data.get("property_1"));

			// click on the property project icon from the property list page
			click("propertyproject_icon_CSS");

			// wait for the element
			Thread.sleep(5000);

			// click on the burger menu
			click("menubtn_CSS");

			// wait for the element
			Thread.sleep(5000);

			// click on the CAPEX Project
			click("propertyproject_capexprojectsoption_XPATH");

			// ADD RECORD - CAPEX Project
			title("ADD RECORD - CAPEX Project");

			// click on the add button
			click("propertyproject_mu_addbtn_CSS");

			// enter the project number
			type("propertyproject_cp_projectnumbertxt_CSS", data.get("project_number"));

			// select the engineering company
			select("propertyproject_cp_engineeringcompanydd_CSS", data.get("engineering_company"));

			// click on the data received field
			click("propertyproject_cp_datereceived_CSS");

			// click on the today button
			click("propertyproject_cp_datereceived_todaybtn_XPATH");

			// click on the save button
			click("propertyproject_cp_savebtn_CSS");

			// wait for the element
			explicitWaitClickable("propertyproject_mu_newrepairbtn_BTNTEXT");

			// click on the new repair button
			click("propertyproject_mu_newrepairbtn_BTNTEXT");

			// scroll down the screen

			scrollByPixel(400);

			// enter the title of the repair
			type("propertyproject_mu_repair_titletxt_CSS", data.get("task_title1"));

			// enter the description
			type("propertyproject_mu_descriptiontxt_CSS", data.get("short_description"));

			// enter the unit number
			type("propertyproject_mu_unitenotxt_CSS", data.get("unit_number"));

			// click on assign to field
			click("propertyproject_mu_repair_assigntotxt_CSS");

			// click on the none button
			click("propertyproject_mu_repair_nonebtn_CSS");

			// enter username in search field
			type("propertyproject_mu_repair_searchusertxt_CSS", data.get("search_user"));

			// click on the searched username
			click("propertyproject_mu_repair_searcheduser_XPATH");

			// click on assign to field
			click("propertyproject_mu_repair_assigntotxt_CSS");

			// scroll up the screen
			scrollByPixel(-400);

			// ADD DETAILS IN THE COST / BUDGET TAB
			title("ADD DETAILS IN THE COST / BUDGET TAB");

			// click on the cost/budget tab
			click("propertyproject_mu_costbudgettab_CSS");

			// scroll down the screen
			scrollByPixel(400);

			// ADD NEWLY CONTRACTOR
			title("ADD NEWLY CONTRACTOR");

			// click on the add contractor icon
			click("propertyproject_mu_addcontractoricon_CSS");

			// scroll up the screen
			scrollByPixel(-400);

			// generate the random contractor name
			String s = RandomStringUtils.randomAlphabetic(8);

			// enter the contractor name
			type("propertyproject_mu_contractornametxt_CSS", s);

			// enter the telephone number
			type("propertyproject_mu_telephonetxt_CSS", "9876543210");

			// enter the city name
			type("propertyproject_mu_citytxt_CSS", data.get("city"));

			// enter the province name
			type("propertyproject_mu_provincetxt_CSS", data.get("province"));

			// enter the country name
			type("propertyproject_mu_countrytxt_CSS", data.get("country"));

			// click on the save button
			click("propertyproject_mu_contrctorsavebtn_CSS");

			// CONTINUE ON DETAILS OF COST / BUDGET TAB
			title("CONTINUE ON DETAILS OF COST / BUDGET TAB");

			// scroll down the screen
			scrollByPixel(400);

			// wait for the element
			explicitWait("propertyproject_mu_contrctortxt_CSS");

			// select on the contractor field
			select("propertyproject_mu_contrctortxt_CSS", s);

			// enter the po number
			type("propertyproject_mu_ponumbertxt_CSS", data.get("task_ponumber"));

			// enter the estimate amount
			type("propertyproject_mu_estimateamounttxt_CSS", "332211");

			// enter the budget amount
			type("propertyproject_mu_budgetamounttxt_CSS", "665544");

			// enter the final cost
			type("propertyproject_mu_finalcosttxt_CSS", "998877");

			// scroll up the screen
			scrollByPixel(-400);

			// click on the update button
			click("propertyproject_mu_taskupdatebtn_BTNTEXT");

			// wait for the element
			explicitWait("propertyproject_cp_addedrepair_capreit1_XPATH");

			// verify newly created repair is displayed or not
			switchVerification("propertyproject_cp_addedrepair_capreit1_XPATH", "Test CAPEX Projects Title Capreit1",
					"The Test CAPEX Projects Title Capreit1 is not displayed.");

			// click on the update button
			click("propertyproject_mu_taskupdatebtn_BTNTEXT");

			// verification of the capex project is added or not
			switchVerification("propertyproject_cp_addedcapexprojects1_capreit1_XPATH", "PROJECTNAMECAPREIT12021",
					"capex project is not displayed successfully.");

		} catch (Throwable t) {
			verificationFailed();
		}

		// click on the home icon from the top of the screen
		click("questionnaire_homeburgermenubtn_hide_CSS");

		// synchronization
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// VERIFY THE "NEW REPAIR" FEATURE IN THE "MUNICIPAL ORDER" MODULE
		title("VERIFY THE \"NEW REPAIR\" FEATURE IN THE \"MUNICIPAL ORDER\" MODULE");

		try {

			// enter the property name in the search field
			type("envreports_propertylist_filtertxt_CSS", data.get("property_1"));

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

			// ADD RECORD - Municipal Orders
			title("ADD RECORD - Municipal Orders");

			// click on the add button
			click("propertyproject_mu_addbtn_CSS");

			// enter the project reference
			type("propertyproject_mo_projectnumbertxt_CSS", data.get("project_reference"));

			// select the Municipality
			select("propertyproject_mo_municipalitydd_CSS", data.get("municipality"));

			// click on the save button
			click("propertyproject_mo_savebtn_CSS");

			// wait for the element
			explicitWaitClickable("propertyproject_mu_newrepairbtn_BTNTEXT");

			// click on the new repair button
			click("propertyproject_mu_newrepairbtn_BTNTEXT");

			// scroll down the screen

			scrollByPixel(400);

			// enter the title of the repair
			type("propertyproject_mu_repair_titletxt_CSS", data.get("task_title2"));

			// enter the description
			type("propertyproject_mu_descriptiontxt_CSS", data.get("short_description"));

			// enter the unit number
			type("propertyproject_mu_unitenotxt_CSS", data.get("unit_number"));

			// click on assign to field
			click("propertyproject_mu_repair_assigntotxt_CSS");

			// click on the none button
			click("propertyproject_mu_repair_nonebtn_CSS");

			// enter username in search field
			type("propertyproject_mu_repair_searchusertxt_CSS", data.get("search_user"));

			// click on the searched username
			click("propertyproject_mu_repair_searcheduser_XPATH");

			// click on assign to field
			click("propertyproject_mu_repair_assigntotxt_CSS");

			// scroll up the screen
			scrollByPixel(-400);

			// ADD DETAILS IN THE COST / BUDGET TAB
			title("ADD DETAILS IN THE COST / BUDGET TAB");

			// click on the cost/budget tab
			click("propertyproject_mu_costbudgettab_CSS");

			// scroll down the screen
			scrollByPixel(400);

			// ADD NEWLY CONTRACTOR
			title("ADD NEWLY CONTRACTOR");

			// click on the add contractor icon
			click("propertyproject_mu_addcontractoricon_CSS");

			// scroll up the screen
			scrollByPixel(-400);

			// generate the random contractor name
			String s = RandomStringUtils.randomAlphabetic(8);

			// enter the contractor name
			type("propertyproject_mu_contractornametxt_CSS", s);

			// enter the telephone number
			type("propertyproject_mu_telephonetxt_CSS", "9876543210");

			// enter the city name
			type("propertyproject_mu_citytxt_CSS", data.get("city"));

			// enter the province name
			type("propertyproject_mu_provincetxt_CSS", data.get("province"));

			// enter the country name
			type("propertyproject_mu_countrytxt_CSS", data.get("country"));

			// click on the save button
			click("propertyproject_mu_contrctorsavebtn_CSS");

			// CONTINUE ON DETAILS OF COST / BUDGET TAB
			title("CONTINUE ON DETAILS OF COST / BUDGET TAB");

			// scroll down the screen
			scrollByPixel(400);

			// wait for the element
			explicitWait("propertyproject_mu_contrctortxt_CSS");

			// select on the contractor field
			select("propertyproject_mu_contrctortxt_CSS", s);

			// enter the po number
			type("propertyproject_mu_ponumbertxt_CSS", data.get("task_ponumber"));

			// enter the estimate amount
			type("propertyproject_mu_estimateamounttxt_CSS", "332211");

			// enter the budget amount
			type("propertyproject_mu_budgetamounttxt_CSS", "665544");

			// enter the final cost
			type("propertyproject_mu_finalcosttxt_CSS", "998877");

			// scroll up the screen
			scrollByPixel(-400);

			// click on the update button
			click("propertyproject_mu_taskupdatebtn_BTNTEXT");

			// wait for the element
			explicitWait("propertyproject_mo_addedrepair1_capreit1_XPATH");

			// verify newly created repair is displayed or not
			switchVerification("propertyproject_mo_addedrepair1_capreit1_XPATH", "Test Municipal Orders Title Capreit1",
					"The Test Municipal Orders Title Capreit1 is not displayed.");

			// click on the update button
			click("propertyproject_mu_taskupdatebtn_BTNTEXT");

			// verification of the municipal orders is added or not
			switchVerification("propertyproject_mo_addedmunicipalorders1_capreit1_XPATH",
					"PROJECTREFERENCECAPREIT12021", "municipal orders is not displayed successfully.");

		} catch (Throwable t) {
			verificationFailed();
		}

		// click on the home icon from the top of the screen
		click("questionnaire_homeburgermenubtn_hide_CSS");

		// synchronization
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// DELETE THE MORTGAGE UNDERTAKINGS
		title("DELETE THE MORTGAGE UNDERTAKINGS");

		try {
			// enter the property name in the search field
			type("envreports_propertylist_filtertxt_CSS", data.get("property_1"));

			// click on the property project icon from the property list page
			click("propertyproject_icon_CSS");

			// wait for the element
			Thread.sleep(5000);

			// click on the burger menu
			click("menubtn_CSS");

			// wait for the element
			Thread.sleep(5000);

			// click on the Mortgage Undertakings
			click("propertyproject_mortgageundertakingsoption_XPATH");

			// click on the created Mortgage Undertakings
			click("propertyproject_mu_addedmortgageundertakings1_capreit1_XPATH");

			// verify newly created repair is displayed or not
			switchVerification("propertyproject_mu_addedrepair1_capreit1_XPATH",
					"Test Mortgage Undertakings Title Capreit1",
					"The Test Mortgage Undertakings Title Capreit1 is not displayed.");

			// DELETE THE REPAIR

			// scroll down the screen

			scrollByPixel(400);

			// click on the repair
			click("propertyproject_mu_addedrepair1_capreit1_XPATH");

			// wait for the element
			explicitWaitClickable("task_deletedtaskbtn_CSS");

			// click on the delete button
			click("task_deletedtaskbtn_CSS");

			// wait for the element
			explicitWaitClickable("task_deletedtaskbtn_confirmaiton_CSS");

			// click on the delete button of the confirmation
			click("task_deletedtaskbtn_confirmaiton_CSS");

			// wait for the element
			explicitWaitClickable("closetoastmsg_CSS");

			// click on the toaster close button
			click("closetoastmsg_CSS");

			// verify repair is deleted or not

			deleteVerification("propertyproject_mu_addedrepair1_capreit1_XPATH",
					"Test Mortgage Undertakings Title Capreit1");

			// click on the update button
			click("propertyproject_mu_taskupdatebtn_BTNTEXT");

			// click on the delete button of the newly created Mortgage Undertakings
			List<WebElement> links = driver.findElements(By.xpath("//tr"));
			int count = links.size();
			consoleMessage("Number of links are:" + count);

			for (int i = 0; i < count - 1; i++) {

				// wait for the element
				explicitWaitClickable("propertyproject_mu_deletebtn_CSS");

				// delete the all the Mortgage Undertakings
				click("propertyproject_mu_deletebtn_CSS");

				// wait for the element
				explicitWaitClickable("propertyproject_mu_deletebtn_CSS");

				// click on the delete button of confirmation
				click("propertyproject_mu_confirmationdeletebtn_CSS");

				// wait for the element
				explicitWaitClickable("closetoastmsg_CSS");

				// click on the toaster close button
				click("closetoastmsg_CSS");

			}

			// verify newly created MORTGAGE UNDERTAKINGS is deleted or not
			deleteVerification("propertyproject_mu_addedmortgageundertakings1_capreit1_XPATH",
					"UNDERTAKINGCAPREIT12021");

		} catch (Throwable t) {
			verificationFailed();
		}

		// click on the home icon from the top of the screen
		click("questionnaire_homeburgermenubtn_hide_CSS");

		// wait for the element
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// DELETE THE CAPEX Projects
		title("DELETE THE CAPEX Projects");

		try {

			// enter the property name in the search field
			type("envreports_propertylist_filtertxt_CSS", data.get("property_1"));

			// click on the property project icon from the property list page
			click("propertyproject_icon_CSS");

			// wait for the element
			Thread.sleep(5000);

			// click on the burger menu
			click("menubtn_CSS");

			// wait for the element
			Thread.sleep(5000);

			// click on the CAPEX Projects
			click("propertyproject_capexprojectsoption_XPATH");

			// click on the created CAPEX Projects
			click("propertyproject_cp_addedcapexprojects1_capreit1_XPATH");

			// verify newly created repair is displayed or not
			switchVerification("propertyproject_cp_addedrepair_capreit1_XPATH", "Test CAPEX Projects Title Capreit1",
					"The Test CAPEX Projects Title Capreit1 is not displayed.");

			// DELETE THE REPAIR

			// scroll down the screen

			scrollByPixel(400);

			// click on the repair
			click("propertyproject_cp_addedrepair_capreit1_XPATH");

			// wait for the element
			explicitWaitClickable("task_deletedtaskbtn_CSS");

			// click on the delete button
			click("task_deletedtaskbtn_CSS");

			// wait for the element
			explicitWaitClickable("task_deletedtaskbtn_confirmaiton_CSS");

			// click on the delete button of the confirmation
			click("task_deletedtaskbtn_confirmaiton_CSS");

			// wait for the element
			explicitWaitClickable("closetoastmsg_CSS");

			// click on the toaster close button
			click("closetoastmsg_CSS");

			// verify repair is deleted or not

			deleteVerification("propertyproject_cp_addedrepair_capreit1_XPATH", "Test CAPEX Projects Title Capreit1");

			// click on the update button
			click("propertyproject_mu_taskupdatebtn_BTNTEXT");

			// click on the delete button of the newly created CAPEX Projects
			List<WebElement> links = driver.findElements(By.xpath("//tr"));
			int count = links.size();
			consoleMessage("Number of links are:" + count);

			for (int i = 0; i < count - 1; i++) {

				// wait for the element
				explicitWaitClickable("propertyproject_cp_deletebtn_CSS");

				// delete the all the CAPEX Projects
				click("propertyproject_cp_deletebtn_CSS");

				// wait for the element
				explicitWaitClickable("propertyproject_cp_confirmationdeletebtn_CSS");

				// click on the delete button of confirmation
				click("propertyproject_cp_confirmationdeletebtn_CSS");

				// wait for the element
				explicitWaitClickable("closetoastmsg_CSS");

				// click on the toaster close button
				click("closetoastmsg_CSS");

			}

			// verify newly created CAPEX Projects is deleted or not

			deleteVerification("propertyproject_cp_addedcapexprojects1_capreit1_XPATH", "PROJECTNAMECAPREIT12021");

		} catch (Throwable t) {
			verificationFailed();
		}

		// click on the home icon from the top of the screen
		click("questionnaire_homeburgermenubtn_hide_CSS");

		// wait for the element
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// DELETE THE Municipal Orders
		title("DELETE THE Municipal Orders");

		try {

			// enter the property name in the search field
			type("envreports_propertylist_filtertxt_CSS", data.get("property_1"));

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

			// click on the created Municipal Orders
			click("propertyproject_mo_addedmunicipalorders1_capreit1_XPATH");

			// wait for the element
			explicitWait("propertyproject_mo_addedrepair1_capreit1_XPATH");

			// verify updated repair title is displayed or not
			switchVerification("propertyproject_mo_addedrepair1_capreit1_XPATH", "Test Municipal Orders Title Capreit1",
					"The Test Municipal Orders Title Capreit1 is not displayed.");

			// DELETE THE REPAIR

			// scroll down the screen

			scrollByPixel(400);

			// click on the repair
			click("propertyproject_mo_addedrepair1_capreit1_XPATH");

			// wait for the element
			explicitWaitClickable("task_deletedtaskbtn_CSS");

			// click on the delete button
			click("task_deletedtaskbtn_CSS");

			// wait for the element
			explicitWaitClickable("task_deletedtaskbtn_confirmaiton_CSS");

			// click on the delete button of the confirmation
			click("task_deletedtaskbtn_confirmaiton_CSS");

			// wait for the element
			explicitWaitClickable("closetoastmsg_CSS");

			// click on the toaster close button
			click("closetoastmsg_CSS");

			// verify repair is deleted or not

			deleteVerification("propertyproject_mo_addedrepair1_capreit1_XPATH",
					"Test Municipal Orders Title Capreit1");

			// click on the update button
			click("propertyproject_mu_taskupdatebtn_BTNTEXT");

			// click on the delete button of the newly created Municipal Orders
			List<WebElement> links = driver.findElements(By.xpath("//tr"));
			int count = links.size();
			consoleMessage("Number of links are:" + count);

			for (int i = 0; i < count - 1; i++) {

				// wait for the element
				explicitWaitClickable("propertyproject_mo_deletebtn_CSS");

				// delete the all the Municipal Orders
				click("propertyproject_mo_deletebtn_CSS");

				// wait for the element
				explicitWaitClickable("propertyproject_mo_confirmationdeletebtn_CSS");

				// click on the delete button of confirmation
				click("propertyproject_mo_confirmationdeletebtn_CSS");

				// wait for the element
				explicitWaitClickable("closetoastmsg_CSS");

				// click on the toaster close button
				click("closetoastmsg_CSS");

			}

			// verify newly created Municipal Orders is deleted or not

			deleteVerification("propertyproject_mo_addedmunicipalorders1_capreit1_XPATH",
					"PROJECTREFERENCECAPREIT12021");

		} catch (Throwable t) {
			verificationFailed();
		}

		// click on the home icon from the top of the screen
		click("questionnaire_homeburgermenubtn_hide_CSS");

		// wait for the element
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		try {
			// wait for the element
			Thread.sleep(10000);

			// click on the settings icon from the top of the screen
			click("questionnaire_settingicon_CSS");

			// wait for the element
			explicitWaitClickable("sidemenu_logout_CSS");

			// click on the logout option from the side menu
			click("sidemenu_logout_CSS");

			// wait for the element
			explicitWaitClickable("signinbtn_BTNTEXT");

		} catch (Throwable t) {
			verificationFailed();
		}

	}
}