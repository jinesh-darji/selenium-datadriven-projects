package testcases.E2Etestcasesuite.propertyprojectmodule;

import java.io.IOException;
import java.util.Hashtable;
import java.util.List;
import java.util.Random;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;
import org.testng.SkipException;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import base.TestBase;
import utilities.TestUtil;

public class RR5001PropertyProjectOneTest extends TestBase {

	@Test(dataProviderClass = TestUtil.class, dataProvider = "dp")
	public void rR5001PropertyProjectOneTest(Hashtable<String, String> data) throws IOException, InterruptedException {

		execution(data, "rR5001PropertyProjectOneTest");

		// MORTGAGE UNDERTAKING COUNTS ON A PROPERTY LEVEL.

		System.out.println("MORTGAGE UNDERTAKING COUNTS ON A PROPERTY LEVEL.");
		test.log(LogStatus.INFO, "MORTGAGE UNDERTAKING COUNTS ON A PROPERTY LEVEL.");
		Reporter.log("MORTGAGE UNDERTAKING COUNTS ON A PROPERTY LEVEL.");
		log.info("MORTGAGE UNDERTAKING COUNTS ON A PROPERTY LEVEL.");

		// refresh the page
		driver.navigate().refresh();
		Thread.sleep(5000);
		driver.navigate().refresh();

		System.out.println("Navigate to the Home Screen i.e. Property List Screen.");

		// DELETE MORTGAGE UNDERTAKINGS FROM THE PROPERTY ONE

		System.out.println("**************** DELETE MORTGAGE UNDERTAKINGS FROM THE PROPERTY ONE ****************");
		test.log(LogStatus.INFO,
				"**************** DELETE MORTGAGE UNDERTAKINGS FROM THE PROPERTY ONE ****************");
		Reporter.log("**************** DELETE MORTGAGE UNDERTAKINGS FROM THE PROPERTY ONE ****************");
		log.info("**************** DELETE MORTGAGE UNDERTAKINGS FROM THE PROPERTY ONE ****************");

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

			// CREATE THE RAMDOM MORTGAGE UNDERTAKING IN THE PROPERTY ONE

			System.out.println(
					"**************** CREATE THE RAMDOM MORTGAGE UNDERTAKING IN THE PROPERTY ONE ****************");
			test.log(LogStatus.INFO,
					"**************** CREATE THE RAMDOM MORTGAGE UNDERTAKING IN THE PROPERTY ONE ****************");
			Reporter.log(
					"**************** CREATE THE RAMDOM MORTGAGE UNDERTAKING IN THE PROPERTY ONE ****************");
			log.info("**************** CREATE THE RAMDOM MORTGAGE UNDERTAKING IN THE PROPERTY ONE ****************");

			// ADD RECORD - MORTGAGE UNDERTAKINGS

			Random random = new Random();
			int mucount1 = random.nextInt(5 - 1) + 1;
			System.out.println("Mortgage Undertaking Count in Property One: " + mucount1);
			test.log(LogStatus.INFO, "Mortgage Undertaking Count in Property One: " + mucount1);
			Reporter.log("Mortgage Undertaking Count in Property One: " + mucount1);
			log.info("Mortgage Undertaking Count in Property One: " + mucount1);

			for (int i = 1; i <= mucount1; i++) {

				// click on the add button
				click("propertyproject_mu_addbtn_CSS");
				System.out.println("Clicked on the Add button.");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Navigate to the Add Mortgage Undertakings Screen");

				String undertaking1 = RandomStringUtils.randomAlphabetic(8);

				// enter the undertaking number
				type("propertyproject_mu_undertakingnumbertxt_CSS", undertaking1);
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

				// wait for the element
				explicitWaitClickable("propertyproject_mu_newrepairbtn_BTNTEXT");

				// click on the cancel button
				click("propertyproject_mu_cancelbtn_CSS");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the cancel button.");

			}

			// click on the home icon from the top of the screen
			click("questionnaire_homeburgermenubtn_hide_CSS");
			System.out.println("Clicked on the home icon from the top of the screen.");
			ngDriver.waitForAngularRequestsToFinish();

			// synchronization
			explicitWait("propertylist_title_XPATH");

			// verify the property list
			switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

			// VERIFY MORTGAGE UNDERTAKING COUNT ON PROPERTY LEVEL FOR THE PROPERTY ONE

			System.out.println(
					"**************** VERIFY MORTGAGE UNDERTAKING COUNT ON PROPERTY LEVEL FOR THE PROPERTY ONE ****************");
			test.log(LogStatus.INFO,
					"**************** VERIFY MORTGAGE UNDERTAKING COUNT ON PROPERTY LEVEL FOR THE PROPERTY ONE ****************");
			Reporter.log(
					"**************** VERIFY MORTGAGE UNDERTAKING COUNT ON PROPERTY LEVEL FOR THE PROPERTY ONE ****************");
			log.info(
					"**************** VERIFY MORTGAGE UNDERTAKING COUNT ON PROPERTY LEVEL FOR THE PROPERTY ONE ****************");

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

			try {
				// wait for the element
				explicitWaitClickable("propertyproject_mu_countpropertylevel_XPATH");

				String actualCount = driver
						.findElement(By.xpath(OR.getProperty("propertyproject_mu_countpropertylevel_XPATH"))).getText();

				String expectedCount = Integer.toString(mucount1);

				System.out.println("The mortgage undertaking actual count is : " + actualCount
						+ " and expected count is : " + expectedCount);
				test.log(LogStatus.INFO, "The mortgage undertaking actual count is : " + actualCount
						+ " and expected count is : " + expectedCount);
				Reporter.log("The mortgage undertaking actual count is : " + actualCount + " and expected count is : "
						+ expectedCount);
				log.info("The mortgage undertaking actual count is : " + actualCount + " and expected count is : "
						+ expectedCount);

				if (actualCount.equals(expectedCount)) {
					System.out.println("The mortgage undertaking counts are displayed correct in the property one.");
					test.log(LogStatus.INFO,
							"The mortgage undertaking counts are displayed correct in the property one.");
					Reporter.log("The mortgage undertaking counts are displayed correct in the property one.");
					log.info("The mortgage undertaking counts are displayed correct in the property one.");
				} else {
					TestUtil.captureScreenshot();

					// ReportNG
					Reporter.log(
							"<br>" + "The mortgage undertaking counts are not displayed correct in the property one : "
									+ "<br>");
					Reporter.log("<a target=\"_blank\" href=" + TestUtil.screenshotName + "><img src="
							+ TestUtil.screenshotName + " height=200 width=200></img></a>");
					Reporter.log("<br>");
					Reporter.log("<br>");

					// Extent Report
					test.log(LogStatus.FAIL,
							" The mortgage undertaking counts are not displayed correct in the property one : ");
					test.log(LogStatus.FAIL, test.addScreenCapture(TestUtil.screenshotName));

					System.out
							.println("The mortgage undertaking counts are not displayed correct in the property one.");
					log.info("The mortgage undertaking counts are not displayed correct in the property one.");

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

		// DELETE MORTGAGE UNDERTAKINGS FROM THE PROPERTY TWO

		System.out.println("**************** DELETE MORTGAGE UNDERTAKINGS FROM THE PROPERTY TWO ****************");
		test.log(LogStatus.INFO,
				"**************** DELETE MORTGAGE UNDERTAKINGS FROM THE PROPERTY TWO ****************");
		Reporter.log("**************** DELETE MORTGAGE UNDERTAKINGS FROM THE PROPERTY TWO ****************");
		log.info("**************** DELETE MORTGAGE UNDERTAKINGS FROM THE PROPERTY TWO ****************");

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

			// CREATE THE RAMDOM MORTGAGE UNDERTAKING IN THE PROPERTY TWO

			System.out.println(
					"**************** CREATE THE RAMDOM MORTGAGE UNDERTAKING IN THE PROPERTY TWO ****************");
			test.log(LogStatus.INFO,
					"**************** CREATE THE RAMDOM MORTGAGE UNDERTAKING IN THE PROPERTY TWO ****************");
			Reporter.log(
					"**************** CREATE THE RAMDOM MORTGAGE UNDERTAKING IN THE PROPERTY TWO ****************");
			log.info("**************** CREATE THE RAMDOM MORTGAGE UNDERTAKING IN THE PROPERTY TWO ****************");

			// ADD RECORD - MORTGAGE UNDERTAKINGS

			Random random2 = new Random();
			int mucount2 = random2.nextInt(5 - 1) + 1;
			System.out.println("Mortgage Undertaking Count in Property Two: " + mucount2);
			test.log(LogStatus.INFO, "Mortgage Undertaking Count in Property Two: " + mucount2);
			Reporter.log("Mortgage Undertaking Count in Property Two: " + mucount2);
			log.info("Mortgage Undertaking Count in Property Two: " + mucount2);

			for (int i = 1; i <= mucount2; i++) {

				// click on the add button
				click("propertyproject_mu_addbtn_CSS");
				System.out.println("Clicked on the Add button.");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Navigate to the Add Mortgage Undertakings Screen");

				String undertaking2 = RandomStringUtils.randomAlphabetic(8);

				// enter the undertaking number
				type("propertyproject_mu_undertakingnumbertxt_CSS", undertaking2);
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

				// wait for the element
				explicitWaitClickable("propertyproject_mu_newrepairbtn_BTNTEXT");

				// click on the cancel button
				click("propertyproject_mu_cancelbtn_CSS");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the cancel button.");

			}

			// click on the home icon from the top of the screen
			click("questionnaire_homeburgermenubtn_hide_CSS");
			System.out.println("Clicked on the home icon from the top of the screen.");
			ngDriver.waitForAngularRequestsToFinish();

			// synchronization
			explicitWait("propertylist_title_XPATH");

			// verify the property list
			switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

			// VERIFY MORTGAGE UNDERTAKING COUNT ON PROPERTY LEVEL FOR THE PROPERTY TWO

			System.out.println(
					"**************** VERIFY MORTGAGE UNDERTAKING COUNT ON PROPERTY LEVEL FOR THE PROPERTY TWO ****************");
			test.log(LogStatus.INFO,
					"**************** VERIFY MORTGAGE UNDERTAKING COUNT ON PROPERTY LEVEL FOR THE PROPERTY TWO ****************");
			Reporter.log(
					"**************** VERIFY MORTGAGE UNDERTAKING COUNT ON PROPERTY LEVEL FOR THE PROPERTY TWO ****************");
			log.info(
					"**************** VERIFY MORTGAGE UNDERTAKING COUNT ON PROPERTY LEVEL FOR THE PROPERTY TWO ****************");

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

			try {
				// wait for the element
				explicitWaitClickable("propertyproject_mu_countpropertylevel_XPATH");

				String actualCount2 = driver
						.findElement(By.xpath(OR.getProperty("propertyproject_mu_countpropertylevel_XPATH"))).getText();

				String expectedCount2 = Integer.toString(mucount2);

				System.out.println("The mortgage undertaking actual count is : " + actualCount2
						+ " and expected count is : " + expectedCount2);
				test.log(LogStatus.INFO, "The mortgage undertaking actual count is : " + actualCount2
						+ " and expected count is : " + expectedCount2);
				Reporter.log("The mortgage undertaking actual count is : " + actualCount2 + " and expected count is : "
						+ expectedCount2);
				log.info("The mortgage undertaking actual count is : " + actualCount2 + " and expected count is : "
						+ expectedCount2);

				if (actualCount2.equals(expectedCount2)) {
					System.out.println("The mortgage undertaking counts are displayed correct in the property two.");
					test.log(LogStatus.INFO,
							"The mortgage undertaking counts are displayed correct in the property two.");
					Reporter.log("The mortgage undertaking counts are displayed correct in the property two.");
					log.info("The mortgage undertaking counts are displayed correct in the property two.");
				} else {
					TestUtil.captureScreenshot();

					// ReportNG
					Reporter.log(
							"<br>" + "The mortgage undertaking counts are not displayed correct in the property two : "
									+ "<br>");
					Reporter.log("<a target=\"_blank\" href=" + TestUtil.screenshotName + "><img src="
							+ TestUtil.screenshotName + " height=200 width=200></img></a>");
					Reporter.log("<br>");
					Reporter.log("<br>");

					// Extent Report
					test.log(LogStatus.FAIL,
							" The mortgage undertaking counts are not displayed correct in the property two : ");
					test.log(LogStatus.FAIL, test.addScreenCapture(TestUtil.screenshotName));

					System.out
							.println("The mortgage undertaking counts are not displayed correct in the property two.");
					log.info("The mortgage undertaking counts are not displayed correct in the property two.");

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

		// DELETE THE MORTGAGE UNDERTAKINGS

		System.out.println("**************** DELETE MORTGAGE UNDERTAKINGS OF PROPERTY ONE ****************");
		test.log(LogStatus.INFO, "**************** DELETE MORTGAGE UNDERTAKINGS OF PROPERTY ONE ****************");
		Reporter.log("**************** DELETE MORTGAGE UNDERTAKINGS OF PROPERTY ONE ****************");
		log.info("**************** DELETE MORTGAGE UNDERTAKINGS OF PROPERTY ONE ****************");

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

			// click on the delete button of the newly created Mortgage Undertakings
			List<WebElement> links3 = driver.findElements(By.xpath("//tr"));
			int count3 = links3.size();
			System.out.println("Number of links are:" + count3);

			for (int i = 0; i < count3 - 1; i++) {

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

		System.out.println("**************** DELETE MORTGAGE UNDERTAKINGS OF PROPERTY TWO ****************");
		test.log(LogStatus.INFO, "**************** DELETE MORTGAGE UNDERTAKINGS OF PROPERTY TWO ****************");
		Reporter.log("**************** DELETE MORTGAGE UNDERTAKINGS OF PROPERTY TWO ****************");
		log.info("**************** DELETE MORTGAGE UNDERTAKINGS OF PROPERTY TWO ****************");

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

			// click on the Mortgage Undertakings
			click("propertyproject_mortgageundertakingsoption_XPATH");
			System.out.println("Clicked on the Mortgage Undertakings option.");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the delete button of the newly created Mortgage Undertakings
			List<WebElement> links4 = driver.findElements(By.xpath("//tr"));
			int count4 = links4.size();
			System.out.println("Number of links are:" + count4);

			for (int i = 0; i < count4 - 1; i++) {

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