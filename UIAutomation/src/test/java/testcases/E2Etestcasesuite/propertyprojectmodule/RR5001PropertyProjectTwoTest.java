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

public class RR5001PropertyProjectTwoTest extends TestBase {

	@Test(dataProviderClass = TestUtil.class, dataProvider = "dp")
	public void rR5001PropertyProjectTwoTest(Hashtable<String, String> data) throws IOException, InterruptedException {

		execution(data, "rR5001PropertyProjectTwoTest");

		// CAPEX PROJECTS COUNTS ON A PROPERTY LEVEL.

		System.out.println("CAPEX PROJECTS COUNTS ON A PROPERTY LEVEL.");
		test.log(LogStatus.INFO, "CAPEX PROJECTS COUNTS ON A PROPERTY LEVEL.");
		Reporter.log("CAPEX PROJECTS COUNTS ON A PROPERTY LEVEL.");
		log.info("CAPEX PROJECTS COUNTS ON A PROPERTY LEVEL.");

		// refresh the page
		driver.navigate().refresh();
		Thread.sleep(5000);
		driver.navigate().refresh();

		System.out.println("Navigate to the Home Screen i.e. Property List Screen.");

		// DELETE CAPEX PROJECTSS FROM THE PROPERTY ONE

		System.out.println("**************** DELETE CAPEX PROJECTSS FROM THE PROPERTY ONE ****************");
		test.log(LogStatus.INFO, "**************** DELETE CAPEX PROJECTSS FROM THE PROPERTY ONE ****************");
		Reporter.log("**************** DELETE CAPEX PROJECTSS FROM THE PROPERTY ONE ****************");
		log.info("**************** DELETE CAPEX PROJECTSS FROM THE PROPERTY ONE ****************");

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

			// CREATE THE RAMDOM CAPEX PROJECTS IN THE PROPERTY ONE

			System.out
					.println("**************** CREATE THE RAMDOM CAPEX PROJECTS IN THE PROPERTY ONE ****************");
			test.log(LogStatus.INFO,
					"**************** CREATE THE RAMDOM CAPEX PROJECTS IN THE PROPERTY ONE ****************");
			Reporter.log("**************** CREATE THE RAMDOM CAPEX PROJECTS IN THE PROPERTY ONE ****************");
			log.info("**************** CREATE THE RAMDOM CAPEX PROJECTS IN THE PROPERTY ONE ****************");

			// ADD RECORD - CAPEX PROJECTSS

			Random random = new Random();
			int cpcount1 = random.nextInt(5 - 1) + 1;
			System.out.println("CAPEX Projects Count in Property One: " + cpcount1);
			test.log(LogStatus.INFO, "CAPEX Projects Count in Property One: " + cpcount1);
			Reporter.log("CAPEX Projects Count in Property One: " + cpcount1);
			log.info("CAPEX Projects Count in Property One: " + cpcount1);

			for (int i = 1; i <= cpcount1; i++) {

				// click on the add button
				click("propertyproject_mu_addbtn_CSS");
				System.out.println("Clicked on the Add button.");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Navigate to the Add CAPEX Projects Screen");

				String projectnumber1 = RandomStringUtils.randomAlphabetic(8);

				// enter the project number
				type("propertyproject_cp_projectnumbertxt_CSS", projectnumber1);
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

				// wait for the element
				explicitWaitClickable("propertyproject_mu_newrepairbtn_BTNTEXT");

				// click on the cancel button
				click("propertyproject_cp_cancelbtn_CSS");
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

			// VERIFY CAPEX PROJECTS COUNT ON PROPERTY LEVEL FOR THE PROPERTY ONE

			System.out.println(
					"**************** VERIFY CAPEX PROJECTS COUNT ON PROPERTY LEVEL FOR THE PROPERTY ONE ****************");
			test.log(LogStatus.INFO,
					"**************** VERIFY CAPEX PROJECTS COUNT ON PROPERTY LEVEL FOR THE PROPERTY ONE ****************");
			Reporter.log(
					"**************** VERIFY CAPEX PROJECTS COUNT ON PROPERTY LEVEL FOR THE PROPERTY ONE ****************");
			log.info(
					"**************** VERIFY CAPEX PROJECTS COUNT ON PROPERTY LEVEL FOR THE PROPERTY ONE ****************");

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
				explicitWaitClickable("propertyproject_cp_countpropertylevel_XPATH");

				String actualCount = driver
						.findElement(By.xpath(OR.getProperty("propertyproject_cp_countpropertylevel_XPATH"))).getText();

				String expectedCount = Integer.toString(cpcount1);

				System.out.println("The capex projects actual count is : " + actualCount + " and expected count is : "
						+ expectedCount);
				test.log(LogStatus.INFO, "The capex projects actual count is : " + actualCount
						+ " and expected count is : " + expectedCount);
				Reporter.log("The capex projects actual count is : " + actualCount + " and expected count is : "
						+ expectedCount);
				log.info("The capex projects actual count is : " + actualCount + " and expected count is : "
						+ expectedCount);

				if (actualCount.equals(expectedCount)) {
					System.out.println("The capex projects counts are displayed correct in the property one.");
					test.log(LogStatus.INFO, "The capex projects counts are displayed correct in the property one.");
					Reporter.log("The capex projects counts are displayed correct in the property one.");
					log.info("The capex projects counts are displayed correct in the property one.");
				} else {
					TestUtil.captureScreenshot();

					// ReportNG
					Reporter.log("<br>" + "The capex projects counts are not displayed correct in the property one : "
							+ "<br>");
					Reporter.log("<a target=\"_blank\" href=" + TestUtil.screenshotName + "><img src="
							+ TestUtil.screenshotName + " height=200 width=200></img></a>");
					Reporter.log("<br>");
					Reporter.log("<br>");

					// Extent Report
					test.log(LogStatus.FAIL,
							" The capex projects counts are not displayed correct in the property one : ");
					test.log(LogStatus.FAIL, test.addScreenCapture(TestUtil.screenshotName));

					System.out.println("The capex projects counts are not displayed correct in the property one.");
					log.info("The capex projects counts are not displayed correct in the property one.");

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

		// DELETE CAPEX PROJECTSS FROM THE PROPERTY TWO

		System.out.println("**************** DELETE CAPEX PROJECTSS FROM THE PROPERTY TWO ****************");
		test.log(LogStatus.INFO, "**************** DELETE CAPEX PROJECTSS FROM THE PROPERTY TWO ****************");
		Reporter.log("**************** DELETE CAPEX PROJECTSS FROM THE PROPERTY TWO ****************");
		log.info("**************** DELETE CAPEX PROJECTSS FROM THE PROPERTY TWO ****************");

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

			// CREATE THE RAMDOM CAPEX PROJECTS IN THE PROPERTY TWO

			System.out
					.println("**************** CREATE THE RAMDOM CAPEX PROJECTS IN THE PROPERTY TWO ****************");
			test.log(LogStatus.INFO,
					"**************** CREATE THE RAMDOM CAPEX PROJECTS IN THE PROPERTY TWO ****************");
			Reporter.log("**************** CREATE THE RAMDOM CAPEX PROJECTS IN THE PROPERTY TWO ****************");
			log.info("**************** CREATE THE RAMDOM CAPEX PROJECTS IN THE PROPERTY TWO ****************");

			// ADD RECORD - CAPEX PROJECTSS

			Random random2 = new Random();
			int cpcount2 = random2.nextInt(5 - 1) + 1;
			System.out.println("CAPEX Projects Count in Property Two: " + cpcount2);
			test.log(LogStatus.INFO, "CAPEX Projects Count in Property Two: " + cpcount2);
			Reporter.log("CAPEX Projects Count in Property Two: " + cpcount2);
			log.info("CAPEX Projects Count in Property Two: " + cpcount2);

			for (int i = 1; i <= cpcount2; i++) {

				// click on the add button
				click("propertyproject_mu_addbtn_CSS");
				System.out.println("Clicked on the Add button.");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Navigate to the Add CAPEX Projects Screen");

				String projectnumber2 = RandomStringUtils.randomAlphabetic(8);

				// enter the project number
				type("propertyproject_cp_projectnumbertxt_CSS", projectnumber2);
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

				// wait for the element
				explicitWaitClickable("propertyproject_mu_newrepairbtn_BTNTEXT");

				// click on the cancel button
				click("propertyproject_cp_cancelbtn_CSS");
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

			// VERIFY CAPEX PROJECTS COUNT ON PROPERTY LEVEL FOR THE PROPERTY TWO

			System.out.println(
					"**************** VERIFY CAPEX PROJECTS COUNT ON PROPERTY LEVEL FOR THE PROPERTY TWO ****************");
			test.log(LogStatus.INFO,
					"**************** VERIFY CAPEX PROJECTS COUNT ON PROPERTY LEVEL FOR THE PROPERTY TWO ****************");
			Reporter.log(
					"**************** VERIFY CAPEX PROJECTS COUNT ON PROPERTY LEVEL FOR THE PROPERTY TWO ****************");
			log.info(
					"**************** VERIFY CAPEX PROJECTS COUNT ON PROPERTY LEVEL FOR THE PROPERTY TWO ****************");

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
				explicitWaitClickable("propertyproject_cp_countpropertylevel_XPATH");

				String actualCount2 = driver
						.findElement(By.xpath(OR.getProperty("propertyproject_cp_countpropertylevel_XPATH"))).getText();

				String expectedCount2 = Integer.toString(cpcount2);

				System.out.println("The capex projects actual count is : " + actualCount2 + " and expected count is : "
						+ expectedCount2);
				test.log(LogStatus.INFO, "The capex projects actual count is : " + actualCount2
						+ " and expected count is : " + expectedCount2);
				Reporter.log("The capex projects actual count is : " + actualCount2 + " and expected count is : "
						+ expectedCount2);
				log.info("The capex projects actual count is : " + actualCount2 + " and expected count is : "
						+ expectedCount2);

				if (actualCount2.equals(expectedCount2)) {
					System.out.println("The capex projects counts are displayed correct in the property two.");
					test.log(LogStatus.INFO, "The capex projects counts are displayed correct in the property two.");
					Reporter.log("The capex projects counts are displayed correct in the property two.");
					log.info("The capex projects counts are displayed correct in the property two.");
				} else {
					TestUtil.captureScreenshot();

					// ReportNG
					Reporter.log("<br>" + "The capex projects counts are not displayed correct in the property two : "
							+ "<br>");
					Reporter.log("<a target=\"_blank\" href=" + TestUtil.screenshotName + "><img src="
							+ TestUtil.screenshotName + " height=200 width=200></img></a>");
					Reporter.log("<br>");
					Reporter.log("<br>");

					// Extent Report
					test.log(LogStatus.FAIL,
							" The capex projects counts are not displayed correct in the property two : ");
					test.log(LogStatus.FAIL, test.addScreenCapture(TestUtil.screenshotName));

					System.out.println("The capex projects counts are not displayed correct in the property two.");
					log.info("The capex projects counts are not displayed correct in the property two.");

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

		// DELETE THE CAPEX PROJECTSS

		System.out.println("**************** DELETE CAPEX PROJECTSS OF PROPERTY ONE ****************");
		test.log(LogStatus.INFO, "**************** DELETE CAPEX PROJECTSS OF PROPERTY ONE ****************");
		Reporter.log("**************** DELETE CAPEX PROJECTSS OF PROPERTY ONE ****************");
		log.info("**************** DELETE CAPEX PROJECTSS OF PROPERTY ONE ****************");

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
			List<WebElement> links3 = driver.findElements(By.xpath("//tr"));
			int count3 = links3.size();
			System.out.println("Number of links are:" + count3);

			for (int i = 0; i < count3 - 1; i++) {

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

		// click on the home icon from the top of the screen
		click("questionnaire_homeburgermenubtn_hide_CSS");
		System.out.println("Clicked on the home icon from the top of the screen.");
		ngDriver.waitForAngularRequestsToFinish();

		// wait for the element
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		System.out.println("**************** DELETE CAPEX PROJECTSS OF PROPERTY TWO ****************");
		test.log(LogStatus.INFO, "**************** DELETE CAPEX PROJECTSS OF PROPERTY TWO ****************");
		Reporter.log("**************** DELETE CAPEX PROJECTSS OF PROPERTY TWO ****************");
		log.info("**************** DELETE CAPEX PROJECTSS OF PROPERTY TWO ****************");

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
			List<WebElement> links4 = driver.findElements(By.xpath("//tr"));
			int count4 = links4.size();
			System.out.println("Number of links are:" + count4);

			for (int i = 0; i < count4 - 1; i++) {

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