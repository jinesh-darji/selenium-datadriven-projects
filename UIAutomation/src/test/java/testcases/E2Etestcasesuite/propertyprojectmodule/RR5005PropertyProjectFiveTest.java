package testcases.E2Etestcasesuite.propertyprojectmodule;

import java.io.IOException;
import java.util.Hashtable;
import java.util.List;
import java.util.Random;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;
import org.testng.SkipException;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import base.TestBase;
import utilities.TestUtil;

public class RR5005PropertyProjectFiveTest extends TestBase {

	@Test(dataProviderClass = TestUtil.class, dataProvider = "dp")
	public void rR5005PropertyProjectFiveTest(Hashtable<String, String> data) throws IOException, InterruptedException {

		execution(data, "rR5005PropertyProjectFiveTest");

		// CAPEX PROJECTS REPAIRS COUNTS ON A PROPERTY PROJECT DASHBOARD.

		System.out.println("CAPEX PROJECTS REPAIRS COUNTS ON A PROPERTY PROJECT DASHBOARD.");
		test.log(LogStatus.INFO, "CAPEX PROJECTS REPAIRS COUNTS ON A PROPERTY PROJECT DASHBOARD.");
		Reporter.log("CAPEX PROJECTS REPAIRS COUNTS ON A PROPERTY PROJECT DASHBOARD.");
		log.info("CAPEX PROJECTS REPAIRS COUNTS ON A PROPERTY PROJECT DASHBOARD.");

		// refresh the page
		driver.navigate().refresh();
		Thread.sleep(5000);
		driver.navigate().refresh();

		System.out.println("Navigate to the Home Screen i.e. Property List Screen.");

		// DELETE CAPEX PROJECTS REPAIRS FROM THE PROPERTY ONE

		System.out.println("**************** DELETE CAPEX PROJECTS FROM THE PROPERTY ONE ****************");
		test.log(LogStatus.INFO, "**************** DELETE CAPEX PROJECTS FROM THE PROPERTY ONE ****************");
		Reporter.log("**************** DELETE CAPEX PROJECTS FROM THE PROPERTY ONE ****************");
		log.info("**************** DELETE CAPEX PROJECTS FROM THE PROPERTY ONE ****************");

		try {
			// enter the property one name in the search field
			clear("envreports_propertylist_filtertxt_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Cleared the search field.");
			type("envreports_propertylist_filtertxt_CSS", data.get("property_1"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the property one name in the search field.");

			// click on the property project icon from the property list page
			click("propertyproject_icon_CSS");
			System.out.println("Clicked on the property project icon of the Property.");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Navigate to the property project screen of the perticular property.");

			// wait for the element
			explicitWaitClickable("menubtn_CSS");

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

			// CREATE THE RAMDOM CAPEX PROJECTS REPAIRS IN THE PROPERTY ONE

			System.out.println(
					"**************** CREATE THE RAMDOM CAPEX PROJECTS REPAIRS IN THE PROPERTY ONE ****************");
			test.log(LogStatus.INFO,
					"**************** CREATE THE RAMDOM CAPEX PROJECTS REPAIRS IN THE PROPERTY ONE ****************");
			Reporter.log(
					"**************** CREATE THE RAMDOM CAPEX PROJECTS REPAIRS IN THE PROPERTY ONE ****************");
			log.info("**************** CREATE THE RAMDOM CAPEX PROJECTS REPAIRS IN THE PROPERTY ONE ****************");

			// ADD RECORD - CAPEX PROJECTS REPAIRS

			Random random = new Random();
			int cpcount1 = random.nextInt(5 - 1) + 1;
			System.out.println("CAPEX Projects Count in Property One: " + cpcount1);
			test.log(LogStatus.INFO, "CAPEX Projects Count in Property One: " + cpcount1);
			Reporter.log("CAPEX Projects Count in Property One: " + cpcount1);
			log.info("CAPEX Projects Count in Property One: " + cpcount1);

			try {
				// click on the add button
				click("propertyproject_mu_addbtn_CSS");
				System.out.println("Clicked on the Add button.");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Navigate to the Add CAPEX Projects Screen");

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
				explicitWaitClickable("closetoastmsg_CSS");

				// click on the toaster close button
				click("closetoastmsg_CSS");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the toaster close button.");

				for (int i = 1; i <= cpcount1; i++) {

					String capexprojectsrepair1 = RandomStringUtils.randomAlphabetic(8);

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
					type("propertyproject_mu_repair_titletxt_CSS", capexprojectsrepair1);
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

					// click on the save button
					click("propertyproject_mu_repair_savebtn_BTNTEXT");
					ngDriver.waitForAngularRequestsToFinish();
					System.out.println("Clicked on the save button.");

					// wait for the element
					explicitWaitClickable("closetoastmsg_CSS");

					// click on the toaster close button
					click("closetoastmsg_CSS");
					ngDriver.waitForAngularRequestsToFinish();
					System.out.println("Clicked on the toaster close button.");

				}

				// click on the update button
				click("propertyproject_cp_updatebtn_CSS");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the update button.");

				// wait for the element
				explicitWaitClickable("closetoastmsg_CSS");

				// click on the toaster close button
				click("closetoastmsg_CSS");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the toaster close button.");

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

			// VERIFY CAPEX PROJECTS REPAIRS COUNT ON PROPERTY PROJECT DASHBOARD FOR
			// THE PROPERTY ONE

			System.out.println(
					"**************** VERIFY CAPEX PROJECTS REPAIRS COUNT ON PROPERTY PROJECT DASHBOARD FOR THE PROPERTY ONE ****************");
			test.log(LogStatus.INFO,
					"**************** VERIFY CAPEX PROJECTS REPAIRS COUNT ON PROPERTY PROJECT DASHBOARD FOR THE PROPERTY ONE ****************");
			Reporter.log(
					"**************** VERIFY CAPEX PROJECTS REPAIRS COUNT ON PROPERTY PROJECT DASHBOARD FOR THE PROPERTY ONE ****************");
			log.info(
					"**************** VERIFY CAPEX PROJECTS REPAIRS COUNT ON PROPERTY PROJECT DASHBOARD FOR THE PROPERTY ONE ****************");

			// wait for the element
			explicitWaitClickable("menubtn_CSS");

			// click on the burger menu
			click("menubtn_CSS");
			System.out.println("Clicked on the burger menu button successfully!!!");
			ngDriver.waitForAngularRequestsToFinish();

			// wait for the element
			Thread.sleep(5000);

			// click on the property project side menu
			click("sidemenu_propertyproject_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the property project side menu.");

			// wait for the element
			explicitWait("dashboard_CSS");

			// select the capex projects repairs option from the dashboard dropdown
			select("dashboard_CSS", data.get("search_6"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Selected the capex projects repairs option from the dashboard dropdown.");

			// wait for the element
			explicitWait("propertyproject_mu_capexprojectsrepairstitle_XPATH");

			// scroll down the screen
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,400)");

			try {

				// enter the property name in the search field
				clear("propertyproject_mu_propertyfiltertxt_CSS");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Entered the property name in the search field.");
				type("propertyproject_mu_propertyfiltertxt_CSS", data.get("property_1"));
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Entered the property name in the search field.");

				// hit enter key
				driver.findElement(By.cssSelector(OR.getProperty("propertyproject_mu_propertyfiltertxt_CSS")))
						.sendKeys(Keys.ENTER);

				// verify count of capex projects repairs is displayed correct or not
				List<WebElement> list1 = driver
						.findElements(By.xpath(OR.getProperty("propertyproject_mu_dashboardconts_XPATH")));
				int listcount1 = list1.size();

				System.out.println("The capex projects repairs actual count is : " + listcount1
						+ " and expected count is : " + cpcount1);
				test.log(LogStatus.INFO, "The capex projects repairs actual count is : " + listcount1
						+ " and expected count is : " + cpcount1);
				Reporter.log("The capex projects repairs actual count is : " + listcount1 + " and expected count is : "
						+ cpcount1);
				log.info("The capex projects repairs actual count is : " + listcount1 + " and expected count is : "
						+ cpcount1);

				if (listcount1 == cpcount1) {
					System.out.println("The capex projects repairs counts are displayed correct for the property one.");
					test.log(LogStatus.INFO,
							"The capex projects repairs counts are displayed correct for the property one.");
					Reporter.log("The capex projects repairs counts are displayed correct for the property one.");
					log.info("The capex projects repairs counts are displayed correct for the property one.");
				} else {
					TestUtil.captureScreenshot();

					// ReportNG
					Reporter.log("<br>"
							+ "The capex projects repairs counts are not displayed correct for the property one : "
							+ "<br>");
					Reporter.log("<a target=\"_blank\" href=" + TestUtil.screenshotName + "><img src="
							+ TestUtil.screenshotName + " height=200 width=200></img></a>");
					Reporter.log("<br>");
					Reporter.log("<br>");

					// Extent Report
					test.log(LogStatus.FAIL,
							" The capex projects repairs counts are not displayed correct for the property one : ");
					test.log(LogStatus.FAIL, test.addScreenCapture(TestUtil.screenshotName));

					System.out.println(
							"The capex projects repairs counts are not displayed correct for the property one.");
					log.info("The capex projects repairs counts are not displayed correct for the property one.");

				}
			} catch (Throwable t) {
				verificationFailed();
			}

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

		// DELETE CAPEX PROJECTS REPAIRS FROM THE PROPERTY TWO

		System.out.println("**************** DELETE CAPEX PROJECTS REPAIRS FROM THE PROPERTY TWO ****************");
		test.log(LogStatus.INFO,
				"**************** DELETE CAPEX PROJECTS REPAIRS FROM THE PROPERTY TWO ****************");
		Reporter.log("**************** DELETE CAPEX PROJECTS REPAIRS FROM THE PROPERTY TWO ****************");
		log.info("**************** DELETE CAPEX PROJECTS REPAIRS FROM THE PROPERTY TWO ****************");

		try {
			// enter the property two name in the search field
			clear("envreports_propertylist_filtertxt_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Cleared the search field.");
			type("envreports_propertylist_filtertxt_CSS", data.get("property_2"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the property one name in the search field.");

			// click on the property project icon from the property list page
			click("propertyproject_icon_CSS");
			System.out.println("Clicked on the property project icon of the Property.");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Navigate to the property project screen of the perticular property.");

			// wait for the element
			explicitWaitClickable("menubtn_CSS");

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

			// click on the delete button of the newly created CAPEX Projects
			List<WebElement> links2 = driver.findElements(By.xpath("//tr"));
			int count2 = links2.size();
			System.out.println("Number of links are:" + count2);

			for (int i = 0; i < count2 - 1; i++) {

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

		} catch (Throwable t) {
			verificationFailed();
		}

		// CREATE THE RAMDOM CAPEX PROJECTS REPAIRS IN THE PROPERTY TWO

		System.out.println(
				"**************** CREATE THE RAMDOM CAPEX PROJECTS REPAIRS IN THE PROPERTY TWO ****************");
		test.log(LogStatus.INFO,
				"**************** CREATE THE RAMDOM CAPEX PROJECTS REPAIRS IN THE PROPERTY TWO ****************");
		Reporter.log("**************** CREATE THE RAMDOM CAPEX PROJECTS REPAIRS IN THE PROPERTY TWO ****************");
		log.info("**************** CREATE THE RAMDOM CAPEX PROJECTS REPAIRS IN THE PROPERTY TWO ****************");

		// ADD RECORD - CAPEX PROJECTS REPAIRS

		Random random = new Random();
		int cpcount2 = random.nextInt(5 - 1) + 1;
		System.out.println("CAPEX Projects Count in Property One: " + cpcount2);
		test.log(LogStatus.INFO, "CAPEX Projects Count in Property One: " + cpcount2);
		Reporter.log("CAPEX Projects Count in Property One: " + cpcount2);
		log.info("CAPEX Projects Count in Property One: " + cpcount2);

		try {
			// click on the add button
			click("propertyproject_mu_addbtn_CSS");
			System.out.println("Clicked on the Add button.");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Navigate to the Add CAPEX Projects Screen");

			// enter the project number
			type("propertyproject_cp_projectnumbertxt_CSS", data.get("project_number2"));
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
			explicitWaitClickable("closetoastmsg_CSS");

			// click on the toaster close button
			click("closetoastmsg_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the toaster close button.");

			for (int i = 1; i <= cpcount2; i++) {

				String capexprojectsrepair2 = RandomStringUtils.randomAlphabetic(8);

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
				type("propertyproject_mu_repair_titletxt_CSS", capexprojectsrepair2);
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

				// click on the save button
				click("propertyproject_mu_repair_savebtn_BTNTEXT");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the save button.");

				// wait for the element
				explicitWaitClickable("closetoastmsg_CSS");

				// click on the toaster close button
				click("closetoastmsg_CSS");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the toaster close button.");

			}

			// click on the update button
			click("propertyproject_cp_updatebtn_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the update button.");

			// wait for the element
			explicitWaitClickable("closetoastmsg_CSS");

			// click on the toaster close button
			click("closetoastmsg_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the toaster close button.");

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

		// VERIFY CAPEX PROJECTS REPAIRS COUNT ON PROPERTY PROJECT DASHBOARD FOR
		// THE PROPERTY TWO

		System.out.println(
				"**************** VERIFY CAPEX PROJECTS REPAIRS COUNT ON PROPERTY PROJECT DASHBOARD FOR THE PROPERTY TWO ****************");
		test.log(LogStatus.INFO,
				"**************** VERIFY CAPEX PROJECTS REPAIRS COUNT ON PROPERTY PROJECT DASHBOARD FOR THE PROPERTY TWO ****************");
		Reporter.log(
				"**************** VERIFY CAPEX PROJECTS REPAIRS COUNT ON PROPERTY PROJECT DASHBOARD FOR THE PROPERTY TWO ****************");
		log.info(
				"**************** VERIFY CAPEX PROJECTS REPAIRS COUNT ON PROPERTY PROJECT DASHBOARD FOR THE PROPERTY TWO ****************");

		// wait for the element
		explicitWaitClickable("menubtn_CSS");

		// click on the burger menu
		click("menubtn_CSS");
		System.out.println("Clicked on the burger menu button successfully!!!");
		ngDriver.waitForAngularRequestsToFinish();

		// wait for the element
		Thread.sleep(5000);

		// click on the property project side menu
		click("sidemenu_propertyproject_CSS");
		ngDriver.waitForAngularRequestsToFinish();
		System.out.println("Clicked on the property project side menu.");

		try {

			// wait for the element
			explicitWait("dashboard_CSS");

			// select the capex projects repairs option from the dashboard dropdown
			select("dashboard_CSS", data.get("search_6"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Selected the capex projects repairs option from the dashboard dropdown.");

			// wait for the element
			explicitWait("propertyproject_mu_capexprojectsrepairstitle_XPATH");

			// scroll down the screen
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,400)");

			// enter the property name in the search field
			clear("propertyproject_mu_propertyfiltertxt_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the property name in the search field.");
			type("propertyproject_mu_propertyfiltertxt_CSS", data.get("property_2"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the property name in the search field.");

			// hit enter key
			driver.findElement(By.cssSelector(OR.getProperty("propertyproject_mu_propertyfiltertxt_CSS")))
					.sendKeys(Keys.ENTER);

			// verify count of capex projects repairs is displayed correct or not
			List<WebElement> list2 = driver
					.findElements(By.xpath(OR.getProperty("propertyproject_mu_dashboardconts_XPATH")));
			int listcount2 = list2.size();

			System.out.println("The capex projects repairs actual count is : " + listcount2
					+ " and expected count is : " + cpcount2);
			test.log(LogStatus.INFO, "The capex projects repairs actual count is : " + listcount2
					+ " and expected count is : " + cpcount2);
			Reporter.log("The capex projects repairs actual count is : " + listcount2 + " and expected count is : "
					+ cpcount2);
			log.info("The capex projects repairs actual count is : " + listcount2 + " and expected count is : "
					+ cpcount2);

			if (listcount2 == cpcount2) {
				System.out.println("The capex projects repairs counts are displayed correct for the property two.");
				test.log(LogStatus.INFO,
						"The capex projects repairs counts are displayed correct for the property two.");
				Reporter.log("The capex projects repairs counts are displayed correct for the property two.");
				log.info("The capex projects repairs counts are displayed correct for the property two.");
			} else {
				TestUtil.captureScreenshot();

				// ReportNG
				Reporter.log(
						"<br>" + "The capex projects repairs counts are not displayed correct for the property two : "
								+ "<br>");
				Reporter.log("<a target=\"_blank\" href=" + TestUtil.screenshotName + "><img src="
						+ TestUtil.screenshotName + " height=200 width=200></img></a>");
				Reporter.log("<br>");
				Reporter.log("<br>");

				// Extent Report
				test.log(LogStatus.FAIL,
						" The capex projects repairs counts are not displayed correct for the property two : ");
				test.log(LogStatus.FAIL, test.addScreenCapture(TestUtil.screenshotName));

				System.out.println("The capex projects repairs counts are not displayed correct for the property two.");
				log.info("The capex projects repairs counts are not displayed correct for the property two.");

			}
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

		// DELETE THE CAPEX PROJECTS REPAIRS

		System.out.println("**************** DELETE CAPEX PROJECTS REPAIRS OF PROPERTY ONE ****************");
		test.log(LogStatus.INFO, "**************** DELETE CAPEX PROJECTS REPAIRS OF PROPERTY ONE ****************");
		Reporter.log("**************** DELETE CAPEX PROJECTS REPAIRS OF PROPERTY ONE ****************");
		log.info("**************** DELETE CAPEX PROJECTS REPAIRS OF PROPERTY ONE ****************");

		try {
			// enter the property one name in the search field
			clear("envreports_propertylist_filtertxt_CSS");
			type("envreports_propertylist_filtertxt_CSS", data.get("property_1"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the property one name in the search field.");

			// click on the property project icon from the property list page
			click("propertyproject_icon_CSS");
			System.out.println("Clicked on the property project icon of the Property.");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Navigate to the property project screen of the perticular property.");

			// wait for the element
			explicitWaitClickable("menubtn_CSS");

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

			// click on the CAPEX Projects
			click("propertyproject_cp_addedcapexprojects_repairscount1_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the newly created CAPEX Projects.");

			// scroll down the screen
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,400)");

			// click on the delete button of the repairs of the CAPEX Projects
			List<WebElement> links3 = driver
					.findElements(By.xpath(OR.getProperty("propertyproject_mu_repairscount_XPATH")));
			int count3 = links3.size();
			System.out.println("Number of repair links are:" + count3);

			for (int i = 1; i <= count3; i++) {

				// scroll down the screen
				js.executeScript("window.scrollBy(0,400)");

				// click on repair randomly
				List<WebElement> links33 = driver
						.findElements(By.xpath(OR.getProperty("propertyproject_mu_repairscount_XPATH")));
				int count33 = links33.size();
				System.out.println("Remaining repair links after deleted the repair link: " + count33);

				Random r = new Random();
				links33.get(r.nextInt(count33)).click();

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

			}

			// click on the update button
			click("propertyproject_cp_updatebtn_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the update button.");

			// wait for the element
			explicitWaitClickable("closetoastmsg_CSS");

			// click on the toaster close button
			click("closetoastmsg_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the toaster close button.");

			// delete the CAPEX Projects
			click("propertyproject_cp_deletebtn_CSS");
			System.out.println("Deleted the all the CAPEX Projects");
			ngDriver.waitForAngularRequestsToFinish();

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

		System.out.println("**************** DELETE CAPEX PROJECTS REPAIRS OF PROPERTY TWO ****************");
		test.log(LogStatus.INFO, "**************** DELETE CAPEX PROJECTS REPAIRS OF PROPERTY TWO ****************");
		Reporter.log("**************** DELETE CAPEX PROJECTS REPAIRS OF PROPERTY TWO ****************");
		log.info("**************** DELETE CAPEX PROJECTS REPAIRS OF PROPERTY TWO ****************");

		try {
			// enter the property one name in the search field
			clear("envreports_propertylist_filtertxt_CSS");
			type("envreports_propertylist_filtertxt_CSS", data.get("property_2"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the property one name in the search field.");

			// click on the property project icon from the property list page
			click("propertyproject_icon_CSS");
			System.out.println("Clicked on the property project icon of the Property.");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Navigate to the property project screen of the perticular property.");

			// wait for the element
			explicitWaitClickable("menubtn_CSS");

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

			// click on the CAPEX Projects
			click("propertyproject_cp_addedcapexprojects_repairscount2_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the newly created CAPEX Projects.");

			// scroll down the screen
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,400)");

			// click on the delete button of the repairs of the CAPEX Projects
			List<WebElement> links4 = driver
					.findElements(By.xpath(OR.getProperty("propertyproject_mu_repairscount_XPATH")));
			int count4 = links4.size();
			System.out.println("Number of repair links are:" + count4);

			for (int i = 1; i <= count4; i++) {

				// scroll down the screen
				js.executeScript("window.scrollBy(0,400)");

				// click on repair randomly
				List<WebElement> links44 = driver
						.findElements(By.xpath(OR.getProperty("propertyproject_mu_repairscount_XPATH")));
				int count44 = links44.size();
				System.out.println("Remaining repair links after deleted the repair link: " + count44);

				Random r = new Random();
				links44.get(r.nextInt(count44)).click();

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

			}

			// click on the update button
			click("propertyproject_cp_updatebtn_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the update button.");

			// wait for the element
			explicitWaitClickable("closetoastmsg_CSS");

			// click on the toaster close button
			click("closetoastmsg_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the toaster close button.");

			// delete the CAPEX Projects
			click("propertyproject_cp_deletebtn_CSS");
			System.out.println("Deleted the all the CAPEX Projects");
			ngDriver.waitForAngularRequestsToFinish();

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
	}

}