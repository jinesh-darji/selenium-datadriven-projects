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

public class RR5005PropertyProjectFourTest extends TestBase {

	@Test(dataProviderClass = TestUtil.class, dataProvider = "dp")
	public void rR5005PropertyProjectFourTest(Hashtable<String, String> data) throws IOException, InterruptedException {

		execution(data, "rR5005PropertyProjectFourTest");

		// MORTGAGE UNDERTAKING REPAIRS COUNTS ON A PROPERTY PROJECT DASHBOARD.

		System.out.println("MORTGAGE UNDERTAKING REPAIRS COUNTS ON A PROPERTY PROJECT DASHBOARD.");
		test.log(LogStatus.INFO, "MORTGAGE UNDERTAKING REPAIRS COUNTS ON A PROPERTY PROJECT DASHBOARD.");
		Reporter.log("MORTGAGE UNDERTAKING REPAIRS COUNTS ON A PROPERTY PROJECT DASHBOARD.");
		log.info("MORTGAGE UNDERTAKING REPAIRS COUNTS ON A PROPERTY PROJECT DASHBOARD.");

		// refresh the page
		driver.navigate().refresh();
		Thread.sleep(5000);
		driver.navigate().refresh();

		System.out.println("Navigate to the Home Screen i.e. Property List Screen.");

		// DELETE MORTGAGE UNDERTAKING REPAIRS FROM THE PROPERTY ONE

		System.out.println("**************** DELETE MORTGAGE UNDERTAKING FROM THE PROPERTY ONE ****************");
		test.log(LogStatus.INFO, "**************** DELETE MORTGAGE UNDERTAKING FROM THE PROPERTY ONE ****************");
		Reporter.log("**************** DELETE MORTGAGE UNDERTAKING FROM THE PROPERTY ONE ****************");
		log.info("**************** DELETE MORTGAGE UNDERTAKING FROM THE PROPERTY ONE ****************");

		try {

			// wait for the element
			explicitWaitClickable("propertyproject_icon_CSS");

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

			// click on the Mortgage Undertakings
			click("propertyproject_mortgageundertakingsoption_XPATH");
			System.out.println("Clicked on the Mortgage Undertakings option.");
			ngDriver.waitForAngularRequestsToFinish();

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
				explicitWaitClickable("propertyproject_mu_confirmationdeletebtn_CSS");

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

			// CREATE THE RAMDOM MORTGAGE UNDERTAKING REPAIRS IN THE PROPERTY ONE

			System.out.println(
					"**************** CREATE THE RAMDOM MORTGAGE UNDERTAKING REPAIRS IN THE PROPERTY ONE ****************");
			test.log(LogStatus.INFO,
					"**************** CREATE THE RAMDOM MORTGAGE UNDERTAKING REPAIRS IN THE PROPERTY ONE ****************");
			Reporter.log(
					"**************** CREATE THE RAMDOM MORTGAGE UNDERTAKING REPAIRS IN THE PROPERTY ONE ****************");
			log.info(
					"**************** CREATE THE RAMDOM MORTGAGE UNDERTAKING REPAIRS IN THE PROPERTY ONE ****************");

			// ADD RECORD - MORTGAGE UNDERTAKING REPAIRS

			Random random = new Random();
			int mucount1 = random.nextInt(5 - 1) + 1;
			System.out.println("Mortgage Undertaking Count in Property One: " + mucount1);
			test.log(LogStatus.INFO, "Mortgage Undertaking Count in Property One: " + mucount1);
			Reporter.log("Mortgage Undertaking Count in Property One: " + mucount1);
			log.info("Mortgage Undertaking Count in Property One: " + mucount1);

			try {
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
				explicitWaitClickable("closetoastmsg_CSS");

				// click on the toaster close button
				click("closetoastmsg_CSS");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the toaster close button.");

				for (int i = 1; i <= mucount1; i++) {

					String mortgageundertakingrepair1 = RandomStringUtils.randomAlphabetic(8);

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
					type("propertyproject_mu_repair_titletxt_CSS", mortgageundertakingrepair1);
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
				click("propertyproject_mu_updatebtn_CSS");
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

			// VERIFY MORTGAGE UNDERTAKING REPAIRS COUNT ON PROPERTY PROJECT DASHBOARD FOR
			// THE PROPERTY ONE

			System.out.println(
					"**************** VERIFY MORTGAGE UNDERTAKING REPAIRS COUNT ON PROPERTY PROJECT DASHBOARD FOR THE PROPERTY ONE ****************");
			test.log(LogStatus.INFO,
					"**************** VERIFY MORTGAGE UNDERTAKING REPAIRS COUNT ON PROPERTY PROJECT DASHBOARD FOR THE PROPERTY ONE ****************");
			Reporter.log(
					"**************** VERIFY MORTGAGE UNDERTAKING REPAIRS COUNT ON PROPERTY PROJECT DASHBOARD FOR THE PROPERTY ONE ****************");
			log.info(
					"**************** VERIFY MORTGAGE UNDERTAKING REPAIRS COUNT ON PROPERTY PROJECT DASHBOARD FOR THE PROPERTY ONE ****************");

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

			// select the mortgage undertaking repairs option from the dashboard dropdown
			select("dashboard_CSS", data.get("search_4"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Selected the mortgage undertaking repairs option from the dashboard dropdown.");

			// wait for the element
			explicitWait("propertyproject_mu_mortgageundertakingrepairstitle_XPATH");

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

				// verify count of mortgage undertaking repairs is displayed correct or not
				List<WebElement> list1 = driver
						.findElements(By.xpath(OR.getProperty("propertyproject_mu_dashboardconts_XPATH")));
				int listcount1 = list1.size();

				System.out.println("The mortgage undertaking repairs actual count is : " + listcount1
						+ " and expected count is : " + mucount1);
				test.log(LogStatus.INFO, "The mortgage undertaking repairs actual count is : " + listcount1
						+ " and expected count is : " + mucount1);
				Reporter.log("The mortgage undertaking repairs actual count is : " + listcount1
						+ " and expected count is : " + mucount1);
				log.info("The mortgage undertaking repairs actual count is : " + listcount1
						+ " and expected count is : " + mucount1);

				if (listcount1 == mucount1) {
					System.out.println(
							"The mortgage undertaking repairs counts are displayed correct for the property one.");
					test.log(LogStatus.INFO,
							"The mortgage undertaking repairs counts are displayed correct for the property one.");
					Reporter.log("The mortgage undertaking repairs counts are displayed correct for the property one.");
					log.info("The mortgage undertaking repairs counts are displayed correct for the property one.");
				} else {
					TestUtil.captureScreenshot();

					// ReportNG
					Reporter.log("<br>"
							+ "The mortgage undertaking repairs counts are not displayed correct for the property one : "
							+ "<br>");
					Reporter.log("<a target=\"_blank\" href=" + TestUtil.screenshotName + "><img src="
							+ TestUtil.screenshotName + " height=200 width=200></img></a>");
					Reporter.log("<br>");
					Reporter.log("<br>");

					// Extent Report
					test.log(LogStatus.FAIL,
							" The mortgage undertaking repairs counts are not displayed correct for the property one : ");
					test.log(LogStatus.FAIL, test.addScreenCapture(TestUtil.screenshotName));

					System.out.println(
							"The mortgage undertaking repairs counts are not displayed correct for the property one.");
					log.info("The mortgage undertaking repairs counts are not displayed correct for the property one.");

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

		// DELETE MORTGAGE UNDERTAKING REPAIRS FROM THE PROPERTY TWO

		System.out
				.println("**************** DELETE MORTGAGE UNDERTAKING REPAIRS FROM THE PROPERTY TWO ****************");
		test.log(LogStatus.INFO,
				"**************** DELETE MORTGAGE UNDERTAKING REPAIRS FROM THE PROPERTY TWO ****************");
		Reporter.log("**************** DELETE MORTGAGE UNDERTAKING REPAIRS FROM THE PROPERTY TWO ****************");
		log.info("**************** DELETE MORTGAGE UNDERTAKING REPAIRS FROM THE PROPERTY TWO ****************");

		try {
			// enter the property one name in the search field
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

			// click on the Mortgage Undertakings
			click("propertyproject_mortgageundertakingsoption_XPATH");
			System.out.println("Clicked on the Mortgage Undertakings option.");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the delete button of the newly created Mortgage Undertakings
			List<WebElement> links2 = driver.findElements(By.xpath("//tr"));
			int count2 = links2.size();
			System.out.println("Number of links are:" + count2);

			for (int i = 0; i < count2 - 1; i++) {

				// wait for the element
				explicitWaitClickable("propertyproject_mu_deletebtn_CSS");

				// delete the all the Mortgage Undertakings
				click("propertyproject_mu_deletebtn_CSS");
				System.out.println("Deleted the all the Mortgage Undertakings");
				ngDriver.waitForAngularRequestsToFinish();

				// wait for the element
				explicitWaitClickable("propertyproject_mu_confirmationdeletebtn_CSS");

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

			// CREATE THE RAMDOM MORTGAGE UNDERTAKING REPAIRS IN THE PROPERTY TWO

			System.out.println(
					"**************** CREATE THE RAMDOM MORTGAGE UNDERTAKING REPAIRS IN THE PROPERTY TWO ****************");
			test.log(LogStatus.INFO,
					"**************** CREATE THE RAMDOM MORTGAGE UNDERTAKING REPAIRS IN THE PROPERTY TWO ****************");
			Reporter.log(
					"**************** CREATE THE RAMDOM MORTGAGE UNDERTAKING REPAIRS IN THE PROPERTY TWO ****************");
			log.info(
					"**************** CREATE THE RAMDOM MORTGAGE UNDERTAKING REPAIRS IN THE PROPERTY TWO ****************");

			// ADD RECORD - MORTGAGE UNDERTAKING REPAIRS

			Random random = new Random();
			int mucount2 = random.nextInt(5 - 1) + 1;
			System.out.println("Mortgage Undertaking Count in Property One: " + mucount2);
			test.log(LogStatus.INFO, "Mortgage Undertaking Count in Property One: " + mucount2);
			Reporter.log("Mortgage Undertaking Count in Property One: " + mucount2);
			log.info("Mortgage Undertaking Count in Property One: " + mucount2);

			try {
				// click on the add button
				click("propertyproject_mu_addbtn_CSS");
				System.out.println("Clicked on the Add button.");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Navigate to the Add Mortgage Undertakings Screen");

				// enter the undertaking number
				type("propertyproject_mu_undertakingnumbertxt_CSS", data.get("undertaking_number2"));
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
				explicitWaitClickable("closetoastmsg_CSS");

				// click on the toaster close button
				click("closetoastmsg_CSS");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the toaster close button.");

				for (int i = 1; i <= mucount2; i++) {

					String mortgageundertakingrepair2 = RandomStringUtils.randomAlphabetic(8);

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
					type("propertyproject_mu_repair_titletxt_CSS", mortgageundertakingrepair2);
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
				click("propertyproject_mu_updatebtn_CSS");
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

			// VERIFY MORTGAGE UNDERTAKING REPAIRS COUNT ON PROPERTY PROJECT DASHBOARD FOR
			// THE PROPERTY TWO

			System.out.println(
					"**************** VERIFY MORTGAGE UNDERTAKING REPAIRS COUNT ON PROPERTY PROJECT DASHBOARD FOR THE PROPERTY TWO ****************");
			test.log(LogStatus.INFO,
					"**************** VERIFY MORTGAGE UNDERTAKING REPAIRS COUNT ON PROPERTY PROJECT DASHBOARD FOR THE PROPERTY TWO ****************");
			Reporter.log(
					"**************** VERIFY MORTGAGE UNDERTAKING REPAIRS COUNT ON PROPERTY PROJECT DASHBOARD FOR THE PROPERTY TWO ****************");
			log.info(
					"**************** VERIFY MORTGAGE UNDERTAKING REPAIRS COUNT ON PROPERTY PROJECT DASHBOARD FOR THE PROPERTY TWO ****************");

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

			// select the mortgage undertaking repairs option from the dashboard dropdown
			select("dashboard_CSS", data.get("search_4"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Selected the mortgage undertaking repairs option from the dashboard dropdown.");

			// wait for the element
			explicitWait("propertyproject_mu_mortgageundertakingrepairstitle_XPATH");

			// scroll down the screen
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,400)");

			try {

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

				// verify count of mortgage undertaking repairs is displayed correct or not
				List<WebElement> list2 = driver
						.findElements(By.xpath(OR.getProperty("propertyproject_mu_dashboardconts_XPATH")));
				int listcount2 = list2.size();

				System.out.println("The mortgage undertaking repairs actual count is : " + listcount2
						+ " and expected count is : " + mucount2);
				test.log(LogStatus.INFO, "The mortgage undertaking repairs actual count is : " + listcount2
						+ " and expected count is : " + mucount2);
				Reporter.log("The mortgage undertaking repairs actual count is : " + listcount2
						+ " and expected count is : " + mucount2);
				log.info("The mortgage undertaking repairs actual count is : " + listcount2
						+ " and expected count is : " + mucount2);

				if (listcount2 == mucount2) {
					System.out.println(
							"The mortgage undertaking repairs counts are displayed correct for the property two.");
					test.log(LogStatus.INFO,
							"The mortgage undertaking repairs counts are displayed correct for the property two.");
					Reporter.log("The mortgage undertaking repairs counts are displayed correct for the property two.");
					log.info("The mortgage undertaking repairs counts are displayed correct for the property two.");
				} else {
					TestUtil.captureScreenshot();

					// ReportNG
					Reporter.log("<br>"
							+ "The mortgage undertaking repairs counts are not displayed correct for the property two : "
							+ "<br>");
					Reporter.log("<a target=\"_blank\" href=" + TestUtil.screenshotName + "><img src="
							+ TestUtil.screenshotName + " height=200 width=200></img></a>");
					Reporter.log("<br>");
					Reporter.log("<br>");

					// Extent Report
					test.log(LogStatus.FAIL,
							" The mortgage undertaking repairs counts are not displayed correct for the property two : ");
					test.log(LogStatus.FAIL, test.addScreenCapture(TestUtil.screenshotName));

					System.out.println(
							"The mortgage undertaking repairs counts are not displayed correct for the property two.");
					log.info("The mortgage undertaking repairs counts are not displayed correct for the property two.");

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

		// DELETE THE MORTGAGE UNDERTAKING REPAIRS

		System.out.println("**************** DELETE MORTGAGE UNDERTAKING REPAIRS OF PROPERTY ONE ****************");
		test.log(LogStatus.INFO,
				"**************** DELETE MORTGAGE UNDERTAKING REPAIRS OF PROPERTY ONE ****************");
		Reporter.log("**************** DELETE MORTGAGE UNDERTAKING REPAIRS OF PROPERTY ONE ****************");
		log.info("**************** DELETE MORTGAGE UNDERTAKING REPAIRS OF PROPERTY ONE ****************");

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

			// click on the Mortgage Undertakings
			click("propertyproject_mortgageundertakingsoption_XPATH");
			System.out.println("Clicked on the Mortgage Undertakings option.");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the Mortgage Undertakings
			click("propertyproject_mu_addedmortgageundertakings_repairscount1_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the newly created Mortgage Undertakings.");

			// scroll down the screen
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,400)");

			// click on the delete button of the repairs of the Mortgage Undertakings
			List<WebElement> links3 = driver
					.findElements(By.xpath(OR.getProperty("propertyproject_mu_repairscount_XPATH")));
			int count3 = links3.size();
			System.out.println("Number of repair links are:" + count3);

			for (int i = 1; i <= count3; i++) {

				// scroll down the screen
				scrollBottom();
				
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
			click("propertyproject_mu_updatebtn_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the update button.");

			// wait for the element
			explicitWaitClickable("closetoastmsg_CSS");

			// click on the toaster close button
			click("closetoastmsg_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the toaster close button.");

			// delete the Mortgage Undertakings
			click("propertyproject_mu_deletebtn_CSS");
			System.out.println("Deleted the all the Mortgage Undertakings");
			ngDriver.waitForAngularRequestsToFinish();

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

		System.out.println("**************** DELETE MORTGAGE UNDERTAKING REPAIRS OF PROPERTY TWO ****************");
		test.log(LogStatus.INFO,
				"**************** DELETE MORTGAGE UNDERTAKING REPAIRS OF PROPERTY TWO ****************");
		Reporter.log("**************** DELETE MORTGAGE UNDERTAKING REPAIRS OF PROPERTY TWO ****************");
		log.info("**************** DELETE MORTGAGE UNDERTAKING REPAIRS OF PROPERTY TWO ****************");

		try {
			// enter the property one name in the search field
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

			// click on the Mortgage Undertakings
			click("propertyproject_mortgageundertakingsoption_XPATH");
			System.out.println("Clicked on the Mortgage Undertakings option.");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the Mortgage Undertakings
			click("propertyproject_mu_addedmortgageundertakings_repairscount2_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the newly created Mortgage Undertakings.");

			// scroll down the screen
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,400)");

			// click on the delete button of the repairs of the Mortgage Undertakings
			List<WebElement> links4 = driver
					.findElements(By.xpath(OR.getProperty("propertyproject_mu_repairscount_XPATH")));
			int count4 = links4.size();
			System.out.println("Number of repair links are:" + count4);

			for (int i = 1; i <= count4; i++) {

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
			click("propertyproject_mu_updatebtn_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the update button.");

			// wait for the element
			explicitWaitClickable("closetoastmsg_CSS");

			// click on the toaster close button
			click("closetoastmsg_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the toaster close button.");

			// delete the Mortgage Undertakings
			click("propertyproject_mu_deletebtn_CSS");
			System.out.println("Deleted the all the Mortgage Undertakings");
			ngDriver.waitForAngularRequestsToFinish();

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