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

		if (!(TestUtil.isTestRunnable("rR5594Capreit1Test", excel))) {

			throw new SkipException(
					"Skipping the test " + "rR5594Capreit1Test".toUpperCase() + "as the Run mode is NO");
		}

		if (!data.get("runmode").equals("Y")) {

			throw new SkipException("Skipping the test case as the Run Mode for data set is NO");
		}

		// refresh the page
		driver.navigate().refresh();
		Thread.sleep(5000);
		driver.navigate().refresh();

		// VERIFY THE "NEW REPAIR" FEATURE IN THE "MORTGAGE UNDERTAKING", "CAPEX
		// PROJECT", AND "MUNICIPAL ORDER" MODULES.

		System.out.println(
				"********** VERIFY THE NEW REPAIR FEATURE IN THE MORTGAGE UNDERTAKING, CAPEX PROJECT, AND MUNICIPAL ORDER MODULES. **********");
		test.log(LogStatus.INFO,
				"********** VERIFY THE NEW REPAIR FEATURE IN THE MORTGAGE UNDERTAKING, CAPEX PROJECT, AND MUNICIPAL ORDER MODULES. **********");
		Reporter.log(
				"********** VERIFY THE NEW REPAIR FEATURE IN THE MORTGAGE UNDERTAKING, CAPEX PROJECT, AND MUNICIPAL ORDER MODULES. **********");
		log.info(
				"********** VERIFY THE NEW REPAIR FEATURE IN THE MORTGAGE UNDERTAKING, CAPEX PROJECT, AND MUNICIPAL ORDER MODULES. **********");

		// LOGIN WITH ADMIN USER

		System.out.println("******************** LOGIN WITH ADMIN USER ********************");
		test.log(LogStatus.INFO, "******************** LOGIN WITH ADMIN USER ********************");
		Reporter.log("******************** LOGIN WITH ADMIN USER ********************");
		log.info("******************** LOGIN WITH ADMIN USER ********************");

		try {
			// wait for the element
			explicitWaitClickable("signinbtn_BTNTEXT");

			// Enter the username
			type("usernametxt_CSS", data.get("username_1"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the username.");

			// Enter the password
			type("passwordtxt_CSS", data.get("password_1"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the password.");

			// Clicking on the "Sign In" button
			click("signinbtn_BTNTEXT");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the sign in button.");

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

		System.out.println(
				"******************** VERIFY THE NEW REPAIR FEATURE IN THE MORTGAGE UNDERTAKING MODULE ********************");
		test.log(LogStatus.INFO,
				"******************** VERIFY THE NEW REPAIR FEATURE IN THE MORTGAGE UNDERTAKING MODULE ********************");
		Reporter.log(
				"******************** VERIFY THE NEW REPAIR FEATURE IN THE MORTGAGE UNDERTAKING MODULE ********************");
		log.info(
				"******************** VERIFY THE NEW REPAIR FEATURE IN THE MORTGAGE UNDERTAKING MODULE ********************");

		try {

			// enter the property name in the search field
			type("envreports_propertylist_filtertxt_CSS", data.get("property_1"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the property name in the search field.");

			// click on the property project icon from the property list page
			click("propertyproject_icon_CSS");
			System.out.println("Clicked on the property project icon of the Property.");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Navigate to the property project screen of the perticular property.");

			// wait for the element
			Thread.sleep(5000);

			// click on the burger menu
			click("menubtn_CSS");
			System.out.println("Clicked on the burger menu button successfully!!!");
			ngDriver.waitForAngularRequestsToFinish();

			// wait for the element
			Thread.sleep(5000);

			// click on the Mortgage Undertakings
			click("propertyproject_mortgageundertakingsoption_XPATH");
			System.out.println("Clicked on the Mortgage Undertakings option.");
			ngDriver.waitForAngularRequestsToFinish();

			// ADD RECORD - MORTGAGE UNDERTAKINGS

			System.out.println("******************** ADD RECORD - MORTGAGE UNDERTAKINGS ********************");
			test.log(LogStatus.INFO, "******************** ADD RECORD - MORTGAGE UNDERTAKINGS ********************");
			Reporter.log("******************** ADD RECORD - MORTGAGE UNDERTAKINGS ********************");
			log.info("******************** ADD RECORD - MORTGAGE UNDERTAKINGS ********************");

			// click on the add button
			click("propertyproject_mu_addbtn_CSS");
			System.out.println("Clicked on the Add button.");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Navigate to the Add Mortgage Undertakings Screen");

			// enter the undertaking number
			type("propertyproject_mu_undertakingnumbertxt_CSS", data.get("undertaking_number"));
			System.out.println("Entered the undertaking number.");
			ngDriver.waitForAngularRequestsToFinish();

			// select the lender
			select("propertyproject_mu_lenderdd_CSS", data.get("lender"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Selected the lender.");

			// click on the save button
			click("propertyproject_mu_savebtn_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the save button.");

			// wait for the element
			explicitWaitClickable("propertyproject_mu_newrepairbtn_BTNTEXT");

			// click on the new repair button
			click("propertyproject_mu_newrepairbtn_BTNTEXT");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the new repair button.");

			// scroll down the screen
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,400)");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Scroll down the screen.");

			// enter the title of the repair
			type("propertyproject_mu_repair_titletxt_CSS", data.get("task_title"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the title of the repair.");

			// enter the description
			type("propertyproject_mu_descriptiontxt_CSS", data.get("short_description"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the description.");

			// enter the unit number
			type("propertyproject_mu_unitenotxt_CSS", data.get("unit_number"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the unit number.");

			// click on assign to field
			click("propertyproject_mu_repair_assigntotxt_CSS");
			System.out.println("Clicked on assign to field.");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the none button
			click("propertyproject_mu_repair_nonebtn_CSS");
			System.out.println("Clicked on the none button.");
			ngDriver.waitForAngularRequestsToFinish();

			// enter username in search field
			type("propertyproject_mu_repair_searchusertxt_CSS", data.get("search_user"));
			System.out.println("Entered username in search field.");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the searched username
			click("propertyproject_mu_repair_searcheduser_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the searched username.");

			// click on assign to field
			click("propertyproject_mu_repair_assigntotxt_CSS");
			System.out.println("Clicked on assign to field.");
			ngDriver.waitForAngularRequestsToFinish();

			// scroll up the screen
			js.executeScript("window.scrollBy(0,-400)");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Scroll up the screen.");

			// ADD DETAILS IN THE COST / BUDGET TAB

			System.out.println("******************** ADD DETAILS IN THE COST / BUDGET TAB ********************");
			test.log(LogStatus.INFO, "******************** ADD DETAILS IN THE COST / BUDGET TAB ********************");
			Reporter.log("******************** ADD DETAILS IN THE COST / BUDGET TAB ********************");
			log.info("******************** ADD DETAILS IN THE COST / BUDGET TAB ********************");

			// click on the cost/budget tab
			click("propertyproject_mu_costbudgettab_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the cost/budget tab.");

			// scroll down the screen
			js.executeScript("window.scrollBy(0,400)");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Scroll down the screen.");

			// ADD NEWLY CONTRACTOR

			System.out.println("******************** ADD NEWLY CONTRACTOR ********************");
			test.log(LogStatus.INFO, "******************** ADD NEWLY CONTRACTOR ********************");
			Reporter.log("******************** ADD NEWLY CONTRACTOR ********************");
			log.info("******************** ADD NEWLY CONTRACTOR ********************");

			// click on the add contractor icon
			click("propertyproject_mu_addcontractoricon_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the add contractor icon.");

			// scroll up the screen
			js.executeScript("window.scrollBy(0,-400)");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Scroll up the screen.");

			// generate the random contractor name
			String s = RandomStringUtils.randomAlphabetic(8);

			// enter the contractor name
			type("propertyproject_mu_contractornametxt_CSS", s);
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the contractor name.");

			// enter the telephone number
			type("propertyproject_mu_telephonetxt_CSS", "9876543210");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the telephone number.");

			// enter the city name
			type("propertyproject_mu_citytxt_CSS", data.get("city"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the city name.");

			// enter the province name
			type("propertyproject_mu_provincetxt_CSS", data.get("province"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the province name.");

			// enter the country name
			type("propertyproject_mu_countrytxt_CSS", data.get("country"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the country name.");

			// click on the save button
			click("propertyproject_mu_contrctorsavebtn_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the save button.");

			// CONTINUE ON DETAILS OF COST / BUDGET TAB

			System.out.println("******************** CONTINUE ON DETAILS OF COST / BUDGET TAB ********************");
			test.log(LogStatus.INFO,
					"******************** CONTINUE ON DETAILS OF COST / BUDGET TAB ********************");
			Reporter.log("******************** CONTINUE ON DETAILS OF COST / BUDGET TAB ********************");
			log.info("******************** CONTINUE ON DETAILS OF COST / BUDGET TAB ********************");

			// scroll down the screen
			js.executeScript("window.scrollBy(0,400)");

			// wait for the element
			explicitWait("propertyproject_mu_contrctortxt_CSS");

			// select on the contractor field
			select("propertyproject_mu_contrctortxt_CSS", s);
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the contractor field.");

			// enter the po number
			type("propertyproject_mu_ponumbertxt_CSS", data.get("task_ponumber"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the po number.");

			// enter the estimate amount
			type("propertyproject_mu_estimateamounttxt_CSS", "332211");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the estimate amount.");

			// enter the budget amount
			type("propertyproject_mu_budgetamounttxt_CSS", "665544");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the budget amount.");

			// enter the final cost
			type("propertyproject_mu_finalcosttxt_CSS", "998877");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the final cost.");

			// scroll up the screen
			js.executeScript("window.scrollBy(0,-400)");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Scroll up the screen.");

			// click on the update button
			click("propertyproject_mu_taskupdatebtn_BTNTEXT");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the update button.");

			// wait for the element
			explicitWait("propertyproject_mu_addedrepair1_capreit1_XPATH");

			// verify newly created repair is displayed or not
			switchVerification("propertyproject_mu_addedrepair1_capreit1_XPATH",
					"Test Mortgage Undertakings Title Capreit1",
					"The Test Mortgage Undertakings Title Capreit1 is not displayed.");

			// click on the update button
			click("propertyproject_mu_taskupdatebtn_BTNTEXT");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the update button.");

			// verification of the Mortgage Undertakings is added or not
			switchVerification("propertyproject_mu_addedmortgageundertakings1_capreit1_XPATH",
					"UNDERTAKINGCAPREIT12021", "Mortgage Undertakings is not displayed successfully.");

		} catch (Throwable t) {
			verificationFailed();
		}

		// click on the home icon from the top of the screen
		click("questionnaire_homeburgermenubtn_hide_CSS");
		System.out.println("Clicked on the home icon from the top of the screen.");
		ngDriver.waitForAngularRequestsToFinish();

		// synchronization
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// VERIFY THE "NEW REPAIR" FEATURE IN THE "CAPEX PROJECT" MODULE

		System.out.println(
				"******************** VERIFY THE NEW REPAIR FEATURE IN THE CAPEX PROJECT MODULE ********************");
		test.log(LogStatus.INFO,
				"******************** VERIFY THE NEW REPAIR FEATURE IN THE CAPEX PROJECT MODULE ********************");
		Reporter.log(
				"******************** VERIFY THE NEW REPAIR FEATURE IN THE CAPEX PROJECT MODULE ********************");
		log.info("******************** VERIFY THE NEW REPAIR FEATURE IN THE CAPEX PROJECT MODULE ********************");

		try {

			// enter the property name in the search field
			type("envreports_propertylist_filtertxt_CSS", data.get("property_1"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the property name in the search field.");

			// click on the property project icon from the property list page
			click("propertyproject_icon_CSS");
			System.out.println("Clicked on the property project icon of the Property.");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Navigate to the property project screen of the perticular property.");

			// wait for the element
			Thread.sleep(5000);

			// click on the burger menu
			click("menubtn_CSS");
			System.out.println("Clicked on the burger menu button successfully!!!");
			ngDriver.waitForAngularRequestsToFinish();

			// wait for the element
			Thread.sleep(5000);

			// click on the CAPEX Project
			click("propertyproject_capexprojectsoption_XPATH");
			System.out.println("Clicked on the CAPEX Project option.");
			ngDriver.waitForAngularRequestsToFinish();

			// ADD RECORD - CAPEX Project

			System.out.println("******************** ADD RECORD - CAPEX Project ********************");
			test.log(LogStatus.INFO, "******************** ADD RECORD - CAPEX Project ********************");
			Reporter.log("******************** ADD RECORD - CAPEX Project ********************");
			log.info("******************** ADD RECORD - CAPEX Project ********************");

			// click on the add button
			click("propertyproject_mu_addbtn_CSS");
			System.out.println("Clicked on the Add button.");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Navigate to the Add CAPEX Project Screen");

			// enter the project number
			type("propertyproject_cp_projectnumbertxt_CSS", data.get("project_number"));
			System.out.println("Entered the undertaking number.");
			ngDriver.waitForAngularRequestsToFinish();

			// select the engineering company
			select("propertyproject_cp_engineeringcompanydd_CSS", data.get("engineering_company"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Selected the engineering company.");

			// click on the data received field
			click("propertyproject_cp_datereceived_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the data received field.");

			// click on the today button
			click("propertyproject_cp_datereceived_todaybtn_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the today button.");

			// click on the save button
			click("propertyproject_cp_savebtn_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the save button.");

			// wait for the element
			explicitWaitClickable("propertyproject_mu_newrepairbtn_BTNTEXT");

			// click on the new repair button
			click("propertyproject_mu_newrepairbtn_BTNTEXT");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the new repair button.");

			// scroll down the screen
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,400)");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Scroll down the screen.");

			// enter the title of the repair
			type("propertyproject_mu_repair_titletxt_CSS", data.get("task_title1"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the title of the repair.");

			// enter the description
			type("propertyproject_mu_descriptiontxt_CSS", data.get("short_description"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the description.");

			// enter the unit number
			type("propertyproject_mu_unitenotxt_CSS", data.get("unit_number"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the unit number.");

			// click on assign to field
			click("propertyproject_mu_repair_assigntotxt_CSS");
			System.out.println("Clicked on assign to field.");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the none button
			click("propertyproject_mu_repair_nonebtn_CSS");
			System.out.println("Clicked on the none button.");
			ngDriver.waitForAngularRequestsToFinish();

			// enter username in search field
			type("propertyproject_mu_repair_searchusertxt_CSS", data.get("search_user"));
			System.out.println("Entered username in search field.");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the searched username
			click("propertyproject_mu_repair_searcheduser_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the searched username.");

			// click on assign to field
			click("propertyproject_mu_repair_assigntotxt_CSS");
			System.out.println("Clicked on assign to field.");
			ngDriver.waitForAngularRequestsToFinish();

			// scroll up the screen
			js.executeScript("window.scrollBy(0,-400)");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Scroll up the screen.");

			// ADD DETAILS IN THE COST / BUDGET TAB

			System.out.println("******************** ADD DETAILS IN THE COST / BUDGET TAB ********************");
			test.log(LogStatus.INFO, "******************** ADD DETAILS IN THE COST / BUDGET TAB ********************");
			Reporter.log("******************** ADD DETAILS IN THE COST / BUDGET TAB ********************");
			log.info("******************** ADD DETAILS IN THE COST / BUDGET TAB ********************");

			// click on the cost/budget tab
			click("propertyproject_mu_costbudgettab_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the cost/budget tab.");

			// scroll down the screen
			js.executeScript("window.scrollBy(0,400)");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Scroll down the screen.");

			// ADD NEWLY CONTRACTOR

			System.out.println("******************** ADD NEWLY CONTRACTOR ********************");
			test.log(LogStatus.INFO, "******************** ADD NEWLY CONTRACTOR ********************");
			Reporter.log("******************** ADD NEWLY CONTRACTOR ********************");
			log.info("******************** ADD NEWLY CONTRACTOR ********************");

			// click on the add contractor icon
			click("propertyproject_mu_addcontractoricon_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the add contractor icon.");

			// scroll up the screen
			js.executeScript("window.scrollBy(0,-400)");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Scroll up the screen.");

			// generate the random contractor name
			String s = RandomStringUtils.randomAlphabetic(8);

			// enter the contractor name
			type("propertyproject_mu_contractornametxt_CSS", s);
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the contractor name.");

			// enter the telephone number
			type("propertyproject_mu_telephonetxt_CSS", "9876543210");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the telephone number.");

			// enter the city name
			type("propertyproject_mu_citytxt_CSS", data.get("city"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the city name.");

			// enter the province name
			type("propertyproject_mu_provincetxt_CSS", data.get("province"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the province name.");

			// enter the country name
			type("propertyproject_mu_countrytxt_CSS", data.get("country"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the country name.");

			// click on the save button
			click("propertyproject_mu_contrctorsavebtn_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the save button.");

			// CONTINUE ON DETAILS OF COST / BUDGET TAB

			System.out.println("******************** CONTINUE ON DETAILS OF COST / BUDGET TAB ********************");
			test.log(LogStatus.INFO,
					"******************** CONTINUE ON DETAILS OF COST / BUDGET TAB ********************");
			Reporter.log("******************** CONTINUE ON DETAILS OF COST / BUDGET TAB ********************");
			log.info("******************** CONTINUE ON DETAILS OF COST / BUDGET TAB ********************");

			// scroll down the screen
			js.executeScript("window.scrollBy(0,400)");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Scroll down the screen.");

			// wait for the element
			explicitWait("propertyproject_mu_contrctortxt_CSS");

			// select on the contractor field
			select("propertyproject_mu_contrctortxt_CSS", s);
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the contractor field.");

			// enter the po number
			type("propertyproject_mu_ponumbertxt_CSS", data.get("task_ponumber"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the po number.");

			// enter the estimate amount
			type("propertyproject_mu_estimateamounttxt_CSS", "332211");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the estimate amount.");

			// enter the budget amount
			type("propertyproject_mu_budgetamounttxt_CSS", "665544");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the budget amount.");

			// enter the final cost
			type("propertyproject_mu_finalcosttxt_CSS", "998877");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the final cost.");

			// scroll up the screen
			js.executeScript("window.scrollBy(0,-400)");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Scroll up the screen.");

			// click on the update button
			click("propertyproject_mu_taskupdatebtn_BTNTEXT");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the update button.");

			// wait for the element
			explicitWait("propertyproject_cp_addedrepair_capreit1_XPATH");

			// verify newly created repair is displayed or not
			switchVerification("propertyproject_cp_addedrepair_capreit1_XPATH", "Test CAPEX Projects Title Capreit1",
					"The Test CAPEX Projects Title Capreit1 is not displayed.");

			// click on the update button
			click("propertyproject_mu_taskupdatebtn_BTNTEXT");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the update button.");

			// verification of the capex project is added or not
			switchVerification("propertyproject_cp_addedcapexprojects1_capreit1_XPATH", "PROJECTNAMECAPREIT12021",
					"capex project is not displayed successfully.");

		} catch (Throwable t) {
			verificationFailed();
		}

		// click on the home icon from the top of the screen
		click("questionnaire_homeburgermenubtn_hide_CSS");
		System.out.println("Clicked on the home icon from the top of the screen.");
		ngDriver.waitForAngularRequestsToFinish();

		// synchronization
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// VERIFY THE "NEW REPAIR" FEATURE IN THE "MUNICIPAL ORDER" MODULE

		System.out.println(
				"******************** VERIFY THE NEW REPAIR FEATURE IN THE MUNICIPAL ORDER MODULE ********************");
		test.log(LogStatus.INFO,
				"******************** VERIFY THE NEW REPAIR FEATURE IN THE MUNICIPAL ORDER MODULE ********************");
		Reporter.log(
				"******************** VERIFY THE NEW REPAIR FEATURE IN THE MUNICIPAL ORDER MODULE ********************");
		log.info(
				"******************** VERIFY THE NEW REPAIR FEATURE IN THE MUNICIPAL ORDER MODULE ********************");

		try {

			// enter the property name in the search field
			type("envreports_propertylist_filtertxt_CSS", data.get("property_1"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the property name in the search field.");

			// click on the property project icon from the property list page
			click("propertyproject_icon_CSS");
			System.out.println("Clicked on the property project icon of the Property.");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Navigate to the property project screen of the perticular property.");

			// wait for the element
			Thread.sleep(5000);

			// click on the burger menu
			click("menubtn_CSS");
			System.out.println("Clicked on the burger menu button successfully!!!");
			ngDriver.waitForAngularRequestsToFinish();

			// wait for the element
			Thread.sleep(5000);

			// click on the Municipal Orders
			click("propertyproject_municipalordersoption_XPATH");
			System.out.println("Clicked on the Municipal Orders option.");
			ngDriver.waitForAngularRequestsToFinish();

			// ADD RECORD - Municipal Orders

			System.out.println("******************** ADD RECORD - Municipal Orders ********************");
			test.log(LogStatus.INFO, "******************** ADD RECORD - Municipal Orders ********************");
			Reporter.log("******************** ADD RECORD - Municipal Orders ********************");
			log.info("******************** ADD RECORD - Municipal Orders ********************");

			// click on the add button
			click("propertyproject_mu_addbtn_CSS");
			System.out.println("Clicked on the Add button.");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Navigate to the Add Municipal Orders Screen");

			// enter the project reference
			type("propertyproject_mo_projectnumbertxt_CSS", data.get("project_reference"));
			System.out.println("Entered the undertaking number.");
			ngDriver.waitForAngularRequestsToFinish();

			// select the Municipality
			select("propertyproject_mo_municipalitydd_CSS", data.get("municipality"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Selected the Municipality.");

			// click on the save button
			click("propertyproject_mo_savebtn_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the save button.");

			// wait for the element
			explicitWaitClickable("propertyproject_mu_newrepairbtn_BTNTEXT");

			// click on the new repair button
			click("propertyproject_mu_newrepairbtn_BTNTEXT");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the new repair button.");

			// scroll down the screen
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,400)");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Scroll down the screen.");

			// enter the title of the repair
			type("propertyproject_mu_repair_titletxt_CSS", data.get("task_title2"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the title of the repair.");

			// enter the description
			type("propertyproject_mu_descriptiontxt_CSS", data.get("short_description"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the description.");

			// enter the unit number
			type("propertyproject_mu_unitenotxt_CSS", data.get("unit_number"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the unit number.");

			// click on assign to field
			click("propertyproject_mu_repair_assigntotxt_CSS");
			System.out.println("Clicked on assign to field.");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the none button
			click("propertyproject_mu_repair_nonebtn_CSS");
			System.out.println("Clicked on the none button.");
			ngDriver.waitForAngularRequestsToFinish();

			// enter username in search field
			type("propertyproject_mu_repair_searchusertxt_CSS", data.get("search_user"));
			System.out.println("Entered username in search field.");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the searched username
			click("propertyproject_mu_repair_searcheduser_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the searched username.");

			// click on assign to field
			click("propertyproject_mu_repair_assigntotxt_CSS");
			System.out.println("Clicked on assign to field.");
			ngDriver.waitForAngularRequestsToFinish();

			// scroll up the screen
			js.executeScript("window.scrollBy(0,-400)");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Scroll up the screen.");

			// ADD DETAILS IN THE COST / BUDGET TAB

			System.out.println("******************** ADD DETAILS IN THE COST / BUDGET TAB ********************");
			test.log(LogStatus.INFO, "******************** ADD DETAILS IN THE COST / BUDGET TAB ********************");
			Reporter.log("******************** ADD DETAILS IN THE COST / BUDGET TAB ********************");
			log.info("******************** ADD DETAILS IN THE COST / BUDGET TAB ********************");

			// click on the cost/budget tab
			click("propertyproject_mu_costbudgettab_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the cost/budget tab.");

			// scroll down the screen
			js.executeScript("window.scrollBy(0,400)");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Scroll down the screen.");

			// ADD NEWLY CONTRACTOR

			System.out.println("******************** ADD NEWLY CONTRACTOR ********************");
			test.log(LogStatus.INFO, "******************** ADD NEWLY CONTRACTOR ********************");
			Reporter.log("******************** ADD NEWLY CONTRACTOR ********************");
			log.info("******************** ADD NEWLY CONTRACTOR ********************");

			// click on the add contractor icon
			click("propertyproject_mu_addcontractoricon_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the add contractor icon.");

			// scroll up the screen
			js.executeScript("window.scrollBy(0,-400)");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Scroll up the screen.");

			// generate the random contractor name
			String s = RandomStringUtils.randomAlphabetic(8);

			// enter the contractor name
			type("propertyproject_mu_contractornametxt_CSS", s);
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the contractor name.");

			// enter the telephone number
			type("propertyproject_mu_telephonetxt_CSS", "9876543210");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the telephone number.");

			// enter the city name
			type("propertyproject_mu_citytxt_CSS", data.get("city"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the city name.");

			// enter the province name
			type("propertyproject_mu_provincetxt_CSS", data.get("province"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the province name.");

			// enter the country name
			type("propertyproject_mu_countrytxt_CSS", data.get("country"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the country name.");

			// click on the save button
			click("propertyproject_mu_contrctorsavebtn_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the save button.");

			// CONTINUE ON DETAILS OF COST / BUDGET TAB

			System.out.println("******************** CONTINUE ON DETAILS OF COST / BUDGET TAB ********************");
			test.log(LogStatus.INFO,
					"******************** CONTINUE ON DETAILS OF COST / BUDGET TAB ********************");
			Reporter.log("******************** CONTINUE ON DETAILS OF COST / BUDGET TAB ********************");
			log.info("******************** CONTINUE ON DETAILS OF COST / BUDGET TAB ********************");

			// scroll down the screen
			js.executeScript("window.scrollBy(0,400)");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Scroll down the screen.");

			// wait for the element
			explicitWait("propertyproject_mu_contrctortxt_CSS");

			// select on the contractor field
			select("propertyproject_mu_contrctortxt_CSS", s);
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the contractor field.");

			// enter the po number
			type("propertyproject_mu_ponumbertxt_CSS", data.get("task_ponumber"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the po number.");

			// enter the estimate amount
			type("propertyproject_mu_estimateamounttxt_CSS", "332211");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the estimate amount.");

			// enter the budget amount
			type("propertyproject_mu_budgetamounttxt_CSS", "665544");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the budget amount.");

			// enter the final cost
			type("propertyproject_mu_finalcosttxt_CSS", "998877");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the final cost.");

			// scroll up the screen
			js.executeScript("window.scrollBy(0,-400)");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Scroll up the screen.");

			// click on the update button
			click("propertyproject_mu_taskupdatebtn_BTNTEXT");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the update button.");

			// wait for the element
			explicitWait("propertyproject_mo_addedrepair1_capreit1_XPATH");

			// verify newly created repair is displayed or not
			switchVerification("propertyproject_mo_addedrepair1_capreit1_XPATH", "Test Municipal Orders Title Capreit1",
					"The Test Municipal Orders Title Capreit1 is not displayed.");

			// click on the update button
			click("propertyproject_mu_taskupdatebtn_BTNTEXT");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the update button.");

			// verification of the municipal orders is added or not
			switchVerification("propertyproject_mo_addedmunicipalorders1_capreit1_XPATH",
					"PROJECTREFERENCECAPREIT12021", "municipal orders is not displayed successfully.");

		} catch (Throwable t) {
			verificationFailed();
		}

		// click on the home icon from the top of the screen
		click("questionnaire_homeburgermenubtn_hide_CSS");
		System.out.println("Clicked on the home icon from the top of the screen.");
		ngDriver.waitForAngularRequestsToFinish();

		// synchronization
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// DELETE THE MORTGAGE UNDERTAKINGS

		System.out.println("**************** DELETE MORTGAGE UNDERTAKINGS ****************");
		test.log(LogStatus.INFO, "**************** DELETE MORTGAGE UNDERTAKINGS ****************");
		Reporter.log("**************** DELETE MORTGAGE UNDERTAKINGS ****************");
		log.info("**************** DELETE MORTGAGE UNDERTAKINGS ****************");

		try {
			// enter the property name in the search field
			type("envreports_propertylist_filtertxt_CSS", data.get("property_1"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the property name in the search field.");

			// click on the property project icon from the property list page
			click("propertyproject_icon_CSS");
			System.out.println("Clicked on the property project icon of the Property.");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Navigate to the property project screen of the perticular property.");

			// wait for the element
			Thread.sleep(5000);

			// click on the burger menu
			click("menubtn_CSS");
			System.out.println("Clicked on the burger menu button successfully!!!");
			ngDriver.waitForAngularRequestsToFinish();

			// wait for the element
			Thread.sleep(5000);

			// click on the Mortgage Undertakings
			click("propertyproject_mortgageundertakingsoption_XPATH");
			System.out.println("Clicked on the Mortgage Undertakings option.");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the created Mortgage Undertakings
			click("propertyproject_mu_addedmortgageundertakings1_capreit1_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the newly created Mortgage Undertakings.");

			// verify newly created repair is displayed or not
			switchVerification("propertyproject_mu_addedrepair1_capreit1_XPATH",
					"Test Mortgage Undertakings Title Capreit1",
					"The Test Mortgage Undertakings Title Capreit1 is not displayed.");

			// DELETE THE REPAIR

			// scroll down the screen
			JavascriptExecutor js = (JavascriptExecutor) driver;

			js.executeScript("window.scrollBy(0,400)");

			// click on the repair
			click("propertyproject_mu_addedrepair1_capreit1_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the repair.");

			// wait for the element
			explicitWaitClickable("task_deletedtaskbtn_CSS");

			// click on the delete button
			click("task_deletedtaskbtn_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the delete button.");

			// wait for the element
			explicitWaitClickable("task_deletedtaskbtn_confirmaiton_CSS");

			// click on the delete button of the confirmation
			click("task_deletedtaskbtn_confirmaiton_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the delete button of the confirmation.");

			// wait for the element
			explicitWaitClickable("closetoastmsg_CSS");

			// click on the toaster close button
			click("closetoastmsg_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the toaster close button.");

			// verify repair is deleted or not

			deleteVerification("propertyproject_mu_addedrepair1_capreit1_XPATH",
					"Test Mortgage Undertakings Title Capreit1");

			// click on the update button
			click("propertyproject_mu_taskupdatebtn_BTNTEXT");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the update button.");

			// click on the delete button of the newly created Mortgage Undertakings
			List<WebElement> links = driver.findElements(By.xpath("//tr"));
			int count = links.size();
			System.out.println("Number of links are:" + count);

			for (int i = 0; i < count - 1; i++) {

				// wait for the element
				explicitWaitClickable("propertyproject_mu_deletebtn_CSS");

				// delete the all the Mortgage Undertakings
				click("propertyproject_mu_deletebtn_CSS");
				System.out.println("Deleted the all the Mortgage Undertakings");
				ngDriver.waitForAngularRequestsToFinish();

				// wait for the element
				explicitWaitClickable("propertyproject_mu_deletebtn_CSS");

				// click on the delete button of confirmation
				click("propertyproject_mu_confirmationdeletebtn_CSS");
				System.out.println("Clicked on the delete button of confirmation.");
				ngDriver.waitForAngularRequestsToFinish();

				// wait for the element
				explicitWaitClickable("closetoastmsg_CSS");

				// click on the toaster close button
				click("closetoastmsg_CSS");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the toaster close button.");

			}

			// verify newly created MORTGAGE UNDERTAKINGS is deleted or not
			deleteVerification("propertyproject_mu_addedmortgageundertakings1_capreit1_XPATH",
					"UNDERTAKINGCAPREIT12021");

		} catch (Throwable t) {
			verificationFailed();
		}

		// click on the home icon from the top of the screen
		click("questionnaire_homeburgermenubtn_hide_CSS");
		System.out.println("Clicked on the home icon from the top of the screen.");
		ngDriver.waitForAngularRequestsToFinish();

		// wait for the element
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// DELETE THE CAPEX Projects

		System.out.println("**************** DELETE CAPEX Projects ****************");
		test.log(LogStatus.INFO, "**************** DELETE CAPEX Projects ****************");
		Reporter.log("**************** DELETE CAPEX Projects ****************");
		log.info("**************** DELETE CAPEX Projects ****************");

		try {

			// enter the property name in the search field
			type("envreports_propertylist_filtertxt_CSS", data.get("property_1"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the property name in the search field.");

			// click on the property project icon from the property list page
			click("propertyproject_icon_CSS");
			System.out.println("Clicked on the property project icon of the Property.");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Navigate to the property project screen of the perticular property.");

			// wait for the element
			Thread.sleep(5000);

			// click on the burger menu
			click("menubtn_CSS");
			System.out.println("Clicked on the burger menu button successfully!!!");
			ngDriver.waitForAngularRequestsToFinish();

			// wait for the element
			Thread.sleep(5000);

			// click on the CAPEX Projects
			click("propertyproject_capexprojectsoption_XPATH");
			System.out.println("Clicked on the CAPEX Projects option.");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the created CAPEX Projects
			click("propertyproject_cp_addedcapexprojects1_capreit1_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the newly created CAPEX Projects.");

			// verify newly created repair is displayed or not
			switchVerification("propertyproject_cp_addedrepair_capreit1_XPATH", "Test CAPEX Projects Title Capreit1",
					"The Test CAPEX Projects Title Capreit1 is not displayed.");

			// DELETE THE REPAIR

			// scroll down the screen
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,400)");

			// click on the repair
			click("propertyproject_cp_addedrepair_capreit1_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the repair.");

			// wait for the element
			explicitWaitClickable("task_deletedtaskbtn_CSS");

			// click on the delete button
			click("task_deletedtaskbtn_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the delete button.");

			// wait for the element
			explicitWaitClickable("task_deletedtaskbtn_confirmaiton_CSS");

			// click on the delete button of the confirmation
			click("task_deletedtaskbtn_confirmaiton_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the delete button of the confirmation.");

			// wait for the element
			explicitWaitClickable("closetoastmsg_CSS");

			// click on the toaster close button
			click("closetoastmsg_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the toaster close button.");

			// verify repair is deleted or not

			deleteVerification("propertyproject_cp_addedrepair_capreit1_XPATH", "Test CAPEX Projects Title Capreit1");

			// click on the update button
			click("propertyproject_mu_taskupdatebtn_BTNTEXT");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the update button.");

			// click on the delete button of the newly created CAPEX Projects
			List<WebElement> links = driver.findElements(By.xpath("//tr"));
			int count = links.size();
			System.out.println("Number of links are:" + count);

			for (int i = 0; i < count - 1; i++) {

				// wait for the element
				explicitWaitClickable("propertyproject_cp_deletebtn_CSS");

				// delete the all the CAPEX Projects
				click("propertyproject_cp_deletebtn_CSS");
				System.out.println("Deleted the all the CAPEX Projects");
				ngDriver.waitForAngularRequestsToFinish();

				// wait for the element
				explicitWaitClickable("propertyproject_cp_confirmationdeletebtn_CSS");

				// click on the delete button of confirmation
				click("propertyproject_cp_confirmationdeletebtn_CSS");
				System.out.println("Clicked on the delete button of confirmation.");
				ngDriver.waitForAngularRequestsToFinish();

				// wait for the element
				explicitWaitClickable("closetoastmsg_CSS");

				// click on the toaster close button
				click("closetoastmsg_CSS");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the toaster close button.");

			}

			// verify newly created CAPEX Projects is deleted or not

			deleteVerification("propertyproject_cp_addedcapexprojects1_capreit1_XPATH", "PROJECTNAMECAPREIT12021");

		} catch (Throwable t) {
			verificationFailed();
		}

		// click on the home icon from the top of the screen
		click("questionnaire_homeburgermenubtn_hide_CSS");
		System.out.println("Clicked on the home icon from the top of the screen.");
		ngDriver.waitForAngularRequestsToFinish();

		// wait for the element
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// DELETE THE Municipal Orders

		System.out.println("**************** DELETE Municipal Orders ****************");
		test.log(LogStatus.INFO, "**************** DELETE Municipal Orders ****************");
		Reporter.log("**************** DELETE Municipal Orders ****************");
		log.info("**************** DELETE Municipal Orders ****************");

		try {

			// enter the property name in the search field
			type("envreports_propertylist_filtertxt_CSS", data.get("property_1"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the property name in the search field.");

			// click on the property project icon from the property list page
			click("propertyproject_icon_CSS");
			System.out.println("Clicked on the property project icon of the Property.");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Navigate to the property project screen of the perticular property.");

			// wait for the element
			Thread.sleep(5000);

			// click on the burger menu
			click("menubtn_CSS");
			System.out.println("Clicked on the burger menu button successfully!!!");
			ngDriver.waitForAngularRequestsToFinish();

			// wait for the element
			Thread.sleep(5000);

			// click on the Municipal Orders
			click("propertyproject_municipalordersoption_XPATH");
			System.out.println("Clicked on the Municipal Orders option.");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the created Municipal Orders
			click("propertyproject_mo_addedmunicipalorders1_capreit1_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the newly created Municipal Orders.");

			// wait for the element
			explicitWait("propertyproject_mo_addedrepair1_capreit1_XPATH");

			// verify updated repair title is displayed or not
			switchVerification("propertyproject_mo_addedrepair1_capreit1_XPATH", "Test Municipal Orders Title Capreit1",
					"The Test Municipal Orders Title Capreit1 is not displayed.");

			// DELETE THE REPAIR

			// scroll down the screen
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,400)");

			// click on the repair
			click("propertyproject_mo_addedrepair1_capreit1_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the repair.");

			// wait for the element
			explicitWaitClickable("task_deletedtaskbtn_CSS");

			// click on the delete button
			click("task_deletedtaskbtn_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the delete button.");

			// wait for the element
			explicitWaitClickable("task_deletedtaskbtn_confirmaiton_CSS");

			// click on the delete button of the confirmation
			click("task_deletedtaskbtn_confirmaiton_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the delete button of the confirmation.");

			// wait for the element
			explicitWaitClickable("closetoastmsg_CSS");

			// click on the toaster close button
			click("closetoastmsg_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the toaster close button.");

			// verify repair is deleted or not

			deleteVerification("propertyproject_mo_addedrepair1_capreit1_XPATH",
					"Test Municipal Orders Title Capreit1");

			// click on the update button
			click("propertyproject_mu_taskupdatebtn_BTNTEXT");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the update button.");

			// click on the delete button of the newly created Municipal Orders
			List<WebElement> links = driver.findElements(By.xpath("//tr"));
			int count = links.size();
			System.out.println("Number of links are:" + count);

			for (int i = 0; i < count - 1; i++) {

				// wait for the element
				explicitWaitClickable("propertyproject_mo_deletebtn_CSS");

				// delete the all the Municipal Orders
				click("propertyproject_mo_deletebtn_CSS");
				System.out.println("Deleted the all the Municipal Orders");
				ngDriver.waitForAngularRequestsToFinish();

				// wait for the element
				explicitWaitClickable("propertyproject_mo_confirmationdeletebtn_CSS");

				// click on the delete button of confirmation
				click("propertyproject_mo_confirmationdeletebtn_CSS");
				System.out.println("Clicked on the delete button of confirmation.");
				ngDriver.waitForAngularRequestsToFinish();

				// wait for the element
				explicitWaitClickable("closetoastmsg_CSS");

				// click on the toaster close button
				click("closetoastmsg_CSS");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the toaster close button.");

			}

			// verify newly created Municipal Orders is deleted or not

			deleteVerification("propertyproject_mo_addedmunicipalorders1_capreit1_XPATH",
					"PROJECTREFERENCECAPREIT12021");

		} catch (Throwable t) {
			verificationFailed();
		}

		// click on the home icon from the top of the screen
		click("questionnaire_homeburgermenubtn_hide_CSS");
		System.out.println("Clicked on the home icon from the top of the screen.");
		ngDriver.waitForAngularRequestsToFinish();

		// wait for the element
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		try {
			// wait for the element
			Thread.sleep(10000);

			// click on the settings icon from the top of the screen
			click("questionnaire_settingicon_CSS");
			System.out.println("Clicked on the settings icon.");
			ngDriver.waitForAngularRequestsToFinish();

			// wait for the element
			explicitWaitClickable("sidemenu_logout_CSS");

			// click on the logout option from the side menu
			click("sidemenu_logout_CSS");
			System.out.println("Clicked on the logout option from the side menu.");
			ngDriver.waitForAngularRequestsToFinish();

			// wait for the element
			explicitWaitClickable("signinbtn_BTNTEXT");

		} catch (Throwable t) {
			verificationFailed();
		}

	}
}
