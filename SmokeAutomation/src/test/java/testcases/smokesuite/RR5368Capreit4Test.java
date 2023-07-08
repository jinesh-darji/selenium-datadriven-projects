package testcases.smokesuite;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Hashtable;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;
import org.testng.SkipException;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import base.Helper;
import base.TestBase;
import utilities.TestUtil;

public class RR5368Capreit4Test extends TestBase {

	@Test(dataProviderClass = TestUtil.class, dataProvider = "dp")
	public void rR5368Capreit4Test(Hashtable<String, String> data) throws IOException, InterruptedException {

		if (!(TestUtil.isTestRunnable("rR5368Capreit4Test", excel))) {

			throw new SkipException(
					"Skipping the test " + "rR5368Capreit4Test".toUpperCase() + "as the Run mode is NO");
		}

		if (!data.get("runmode").equals("Y")) {

			throw new SkipException("Skipping the test case as the Run Mode for data set is NO");
		}

		Helper helper = new Helper();

		// refresh the page
		driver.navigate().refresh();
		Thread.sleep(5000);
		driver.navigate().refresh();

		System.out.println("Navigate to the Home Screen i.e. Property List Screen.");

		// PROPERTY SUMMARY DASHBOARDS - OPERATION MANAGER

		System.out.println("******************** PROPERTY SUMMARY DASHBOARDS - OPERATION MANAGER ********************");
		test.log(LogStatus.INFO,
				"******************** PROPERTY SUMMARY DASHBOARDS - OPERATION MANAGER ********************");
		Reporter.log("******************** PROPERTY SUMMARY DASHBOARDS - OPERATION MANAGER ********************");
		log.info("******************** PROPERTY SUMMARY DASHBOARDS - OPERATION MANAGER ********************");

		try {

			try {
				// LOGIN WITH OPERATION MANAGER USER

				System.out.println("******************** LOGIN WITH OPERATION MANAGER USER ********************");
				test.log(LogStatus.INFO, "******************** LOGIN WITH OPERATION MANAGER USER ********************");
				Reporter.log("******************** LOGIN WITH OPERATION MANAGER USER ********************");
				log.info("******************** LOGIN WITH OPERATION MANAGER USER ********************");

				// wait for the element
				explicitWaitClickable("signinbtn_BTNTEXT");

				// Enter the username
				type("usernametxt_CSS", data.get("username"));
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Entered the username.");

				// Enter the password
				type("passwordtxt_CSS", data.get("password"));
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

			// CREATE THE NEW INSPECTION AND CHECKLIST - OPERATION
			// MANAGER

			System.out.println(
					"******************** CREATE THE NEW INSPECTION AND CHECKLIST - OPERATION MANAGER ********************");
			test.log(LogStatus.INFO,
					"******************** CREATE THE NEW INSPECTION AND CHECKLIST - OPERATION MANAGER ********************");
			Reporter.log(
					"******************** CREATE THE NEW INSPECTION AND CHECKLIST - OPERATION MANAGER ********************");
			log.info(
					"******************** CREATE THE NEW INSPECTION AND CHECKLIST - OPERATION MANAGER ********************");

			try {

				// enter the property name in the search field
				type("envreports_propertylist_filtertxt_CSS", data.get("property_1"));
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Entered the property name in the search field.");

				// click on the environmental icon from the property list page
				click("environmentalicon_CSS");
				System.out.println("Clicked on the environmental icon of the Property.");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Navigate to the environmental screen of the perticular property.");

				// wait for the element
				Thread.sleep(5000);

				// click on the burger menu
				click("menubtn_CSS");
				System.out.println("Clicked on the burger menu button successfully!!!");
				ngDriver.waitForAngularRequestsToFinish();

				// wait for 5 seconds
				Thread.sleep(5000);

				// click on the checklist/inspection option from side menu
				click("checklist_sidemenu_XPATH");
				System.out.println("Clicked on the checklist/inspection option from side menu");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Navigate to the checklist/inspection screen");

				// select building from the property drop down
				select("envreports_movereports_propertydd_CSS", data.get("building_leveldropdown"));
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Selected building from the property drop down.");

				// wait for 5 seconds
				Thread.sleep(5000);

				// click on the new checklist button
				click("checklist_newchecklistbtn_CSS");
				System.out.println("Clicked on the new checklist button.");
				ngDriver.waitForAngularRequestsToFinish();

				// wait for the element
				explicitWait("checklist_addchecklist_checklisttypedd_CSS");

				// select the questionnaire option from the checklist type dropdown
				select("checklist_addchecklist_checklisttypedd_CSS", data.get("questionnaire_checklist_title"));
				System.out.println("The created questionaaire is selected from the checklist type dropdown.");
				ngDriver.waitForAngularRequestsToFinish();

				// enter data in the checklist title field
				type("checklist_addchecklist_titletxt_CSS", data.get("checklist_property_title"));
				System.out.println("Entered the data in the checklist title field.");
				ngDriver.waitForAngularRequestsToFinish();

				// click on the save button
				click("checklist_addchecklist_savebtn_CSS");
				System.out.println("Clicked on the save button.");
				ngDriver.waitForAngularRequestsToFinish();

				// verify questionnaire is selected correctly or not

				String covidtxt = driver
						.findElement(By.xpath(OR.getProperty("checklist_wizard_inspectiontitle4_XPATH"))).getText();

				System.out.println("COVID 19 INSTECTION TITLE : " + covidtxt);

				switchVerification("checklist_wizard_inspectiontitle4_XPATH",
						"Test Questionnaire Property Title Smoke Capreit Four",
						"The Test Questionnaire Property Title Smoke Capreit Four is not displayed.");

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

			// VERIFY THE NEWLY CREATED INSPECTION IN PROPERTY SUMMARY DASHBOARD

			System.out.println(
					"******************** VERIFY THE NEWLY CREATED INSPECTION COUNT IN PROPERTY SUMMARY DASHBOARD ********************");
			test.log(LogStatus.INFO,
					"******************** VERIFY THE NEWLY CREATED INSPECTION COUNT IN PROPERTY SUMMARY DASHBOARD ********************");
			Reporter.log(
					"******************** VERIFY THE NEWLY CREATED INSPECTION COUNT IN PROPERTY SUMMARY DASHBOARD ********************");
			log.info(
					"******************** VERIFY THE NEWLY CREATED INSPECTION COUNT IN PROPERTY SUMMARY DASHBOARD ********************");

			try {
				// enter the property name in the search field
				type("envreports_propertylist_filtertxt_CSS", data.get("property_1"));
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Entered the property name in the search field.");

				// click on the property
				click("task_navigation_property1_CSS");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the property.");

				// scroll down the screen
				JavascriptExecutor js = (JavascriptExecutor) driver;
				WebElement inspectionSection = driver
						.findElement(By.xpath(OR.getProperty("propertysummary_inspection_instectiontitle_XPATH")));
				js.executeScript("arguments[0].scrollIntoView(true);", inspectionSection);

				// VERIFY THE INSPECTION STATUS INDICATOR

				System.out.println("VERIFY THE INSPECTION STATUS INDICATOR");
				test.log(LogStatus.INFO, "VERIFY THE INSPECTION STATUS INDICATOR");
				Reporter.log("VERIFY THE INSPECTION STATUS INDICATOR");
				log.info("VERIFY THE INSPECTION STATUS INDICATOR");

				try {
					// verify red circle is displayed or not
					boolean redCircle = driver
							.findElement(By.xpath(OR.getProperty("propertysummary_inspectionred_redcircle_XPATH")))
							.isDisplayed();

					if (redCircle == true) {
						System.out.println("The red circle is displayed for the newly created checklist.");
						test.log(LogStatus.INFO, "The red circle is displayed for the newly created checklist.");
						Reporter.log("The red circle is displayed for the newly created checklist.");
						log.info("The red circle is displayed for the newly created checklist.");
					} else {
						TestUtil.captureScreenshot();

						// ReportNG
						Reporter.log("<br>" + " The red circle is not displayed for the newly created checklist. : "
								+ "<br>");
						Reporter.log("<a target=\"_blank\" href=" + TestUtil.screenshotName + "><img src="
								+ TestUtil.screenshotName + " height=200 width=200></img></a>");
						Reporter.log("<br>");
						Reporter.log("<br>");

						// Extent Report
						test.log(LogStatus.FAIL,
								" The red circle is not displayed for the newly created checklist. : ");
						test.log(LogStatus.FAIL, test.addScreenCapture(TestUtil.screenshotName));

						System.out.println("The red circle is not displayed for the newly created checklist.");
						log.info("The red circle is not displayed for the newly created checklist.");

					}
				} catch (Throwable t) {
					verificationFailed();
				}

				// VERIFY THE INSPECTION COMPLETED DATE

				System.out.println("VERIFY THE INSPECTION COMPLETED DATE");
				test.log(LogStatus.INFO, "VERIFY THE INSPECTION COMPLETED DATE");
				Reporter.log("VERIFY THE INSPECTION COMPLETED DATE");
				log.info("VERIFY THE INSPECTION COMPLETED DATE");

				try {

					String expiredDate = driver
							.findElement(By.xpath(OR.getProperty("propertysummary_inspectionred_expireddate_XPATH")))
							.getText();

					if (expiredDate.equals("-")) {
						System.out.println("The completed date is displayed for the newly created checklist.");
						test.log(LogStatus.INFO, "The completed date is displayed for the newly created checklist.");
						Reporter.log("The completed date is displayed for the newly created checklist.");
						log.info("The completed date is displayed for the newly created checklist.");
					} else {
						TestUtil.captureScreenshot();

						// ReportNG
						Reporter.log("<br>" + " The completed date is not displayed for the newly created checklist. : "
								+ "<br>");
						Reporter.log("<a target=\"_blank\" href=" + TestUtil.screenshotName + "><img src="
								+ TestUtil.screenshotName + " height=200 width=200></img></a>");
						Reporter.log("<br>");
						Reporter.log("<br>");

						// Extent Report
						test.log(LogStatus.FAIL,
								" The completed date is not displayed for the newly created checklist. : ");
						test.log(LogStatus.FAIL, test.addScreenCapture(TestUtil.screenshotName));

						System.out.println("The completed date is not displayed for the newly created checklist.");
						log.info("The completed date is not displayed for the newly created checklist.");

					}
				} catch (Throwable t) {
					verificationFailed();
				}

				// click on the newly created inspection
				driver.findElement(By.xpath("//td[text()='" + data.get("questionnaire_checklist_title") + "']"))
						.click();
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the newly created inspection.");

				// VERIFY NEWLY CREATED INSPECTION IS DISPLAYED CORRECTLY OR NOT IN THE
				// INSPECTION LIST

				System.out.println(
						"VERIFY NEWLY CREATED INSPECTION IS DISPLAYED CORRECTLY OR NOT IN THE INSPECTION LIST");
				test.log(LogStatus.INFO,
						"VERIFY NEWLY CREATED INSPECTION IS DISPLAYED CORRECTLY OR NOT IN THE INSPECTION LIST");
				Reporter.log("VERIFY NEWLY CREATED INSPECTION IS DISPLAYED CORRECTLY OR NOT IN THE INSPECTION LIST");
				log.info("VERIFY NEWLY CREATED INSPECTION IS DISPLAYED CORRECTLY OR NOT IN THE INSPECTION LIST");

				// select building from the property drop down
				select("envreports_movereports_propertydd_CSS", data.get("building_leveldropdown"));
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Selected building from the property drop down.");

				// enter the inspection name in the search field
				clear("task_listofchecklist_filterfield_CSS");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Cleared the search field.");
				type("task_listofchecklist_filterfield_CSS", data.get("checklist_property_title"));
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Entered the inspection name in the search field.");

				// verify newly created inspection is displayed or not
				switchVerification("inspection_createdinspection4_XPATH",
						"Test Questionnaire Property Title Smoke Capreit Four",
						"The Test Questionnaire Property Title Smoke Capreit Four is not displayed");

				// click on the back to dashboard button
				click("inspection_backtodashboardbtn_CSS");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the back to dashboard button.");

				// VERIFY CORRECT NAVIGATION IS OCCURED OR NOT
				switchVerification("inspection_tasksection_XPATH", "Tasks", "The Tasks is not displayed");

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

			// MAKE THE COVID 19 INSPECTION AS A INPROGRESS - OPERATION MANAGER

			System.out.println(
					"******************** MAKE THE COVID 19 INSPECTION AS A INPROGRESS - OPERATION MANAGER ********************");
			test.log(LogStatus.INFO,
					"******************** MAKE THE COVID 19 INSPECTION AS A INPROGRESS - OPERATION MANAGER ********************");
			Reporter.log(
					"******************** MAKE THE COVID 19 INSPECTION AS A INPROGRESS - OPERATION MANAGER ********************");
			log.info(
					"******************** MAKE THE COVID 19 INSPECTION AS A INPROGRESS - OPERATION MANAGER ********************");

			try {

				// enter the property name in the search field
				type("envreports_propertylist_filtertxt_CSS", data.get("property_1"));
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Entered the property name in the search field.");

				// click on the environmental icon from the property list page
				click("environmentalicon_CSS");
				System.out.println("Clicked on the environmental icon of the Property.");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Navigate to the environmental screen of the perticular property.");

				// wait for the element
				Thread.sleep(5000);

				// click on the burger menu
				click("menubtn_CSS");
				System.out.println("Clicked on the burger menu button successfully!!!");
				ngDriver.waitForAngularRequestsToFinish();

				// wait for 5 seconds
				Thread.sleep(5000);

				// click on the checklist/inspection option from side menu
				click("checklist_sidemenu_XPATH");
				System.out.println("Clicked on the checklist/inspection option from side menu");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Navigate to the checklist/inspection screen");

				// wait for 3 seconds
				Thread.sleep(3000);

				// select property from the property drop down
				select("envreports_movereports_propertydd_CSS", data.get("building_leveldropdown"));
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Selected property from the property drop down.");

				// wait for 5 seconds
				Thread.sleep(5000);

				// enter newly created inspection in the search field
				clear("task_listofchecklist_filterfield_CSS");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Cleared the search field.");
				type("task_listofchecklist_filterfield_CSS", data.get("checklist_property_title"));
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Entered newly created inspection in the search field.");

				// click on the searched inspection
				click("inspection_createdinspection4_XPATH");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the searched inspection.");

				// click on the switch to wizard mode button
				click("checklist_classicviewbtn_CSS");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the switch to wizard mode button.");

				// click on the yes option of the 1st question
				click("checklist_wizard_yesoption_CSS");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the yes option of the 1st question.");

				// click on the back button
				click("questionnaire_checklist_backbtn_CSS");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the back button.");

				// enter newly created inspection in the search field
				clear("task_listofchecklist_filterfield_CSS");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Cleared the searched field.");
				type("task_listofchecklist_filterfield_CSS", data.get("checklist_property_title"));
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Entered newly created inspection in the search field.");

				// verify submitted inspection is displayed or not
				switchVerification("inspection_createdinspection4_XPATH",
						"Test Questionnaire Property Title Smoke Capreit Four",
						"The Test Questionnaire Property Title Smoke Capreit Four is not displayed.");

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

			// VERIFY THE INPROGRESS INSPECTION IN PROPERTY SUMMARY DASHBOARD

			System.out.println(
					"******************** VERIFY THE INPROGRESS INSPECTION IN PROPERTY SUMMARY DASHBOARD ********************");
			test.log(LogStatus.INFO,
					"******************** VERIFY THE INPROGRESS INSPECTION IN PROPERTY SUMMARY DASHBOARD ********************");
			Reporter.log(
					"******************** VERIFY THE INPROGRESS INSPECTION IN PROPERTY SUMMARY DASHBOARD ********************");
			log.info(
					"******************** VERIFY THE INPROGRESS INSPECTION IN PROPERTY SUMMARY DASHBOARD ********************");

			try {
				// enter the property name in the search field
				type("envreports_propertylist_filtertxt_CSS", data.get("property_1"));
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Entered the property name in the search field.");

				// click on the property
				click("task_navigation_property1_CSS");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the property.");

				// scroll down the screen
				JavascriptExecutor js = (JavascriptExecutor) driver;
				WebElement inspectionSection = driver
						.findElement(By.xpath(OR.getProperty("propertysummary_inspection_instectiontitle_XPATH")));
				js.executeScript("arguments[0].scrollIntoView(true);", inspectionSection);

				// VERIFY THE INSPECTION STATUS INDICATOR

				System.out.println("VERIFY THE INSPECTION STATUS INDICATOR");
				test.log(LogStatus.INFO, "VERIFY THE INSPECTION STATUS INDICATOR");
				Reporter.log("VERIFY THE INSPECTION STATUS INDICATOR");
				log.info("VERIFY THE INSPECTION STATUS INDICATOR");

				try {
					// verify red circle is displayed or not
					boolean redCircle = driver
							.findElement(By.xpath(OR.getProperty("propertysummary_inspectionred_redcircle_XPATH")))
							.isDisplayed();

					if (redCircle == true) {
						System.out.println("The red circle is displayed for the newly created checklist.");
						test.log(LogStatus.INFO, "The red circle is displayed for the newly created checklist.");
						Reporter.log("The red circle is displayed for the newly created checklist.");
						log.info("The red circle is displayed for the newly created checklist.");
					} else {
						TestUtil.captureScreenshot();

						// ReportNG
						Reporter.log("<br>" + " The red circle is not displayed for the newly created checklist. : "
								+ "<br>");
						Reporter.log("<a target=\"_blank\" href=" + TestUtil.screenshotName + "><img src="
								+ TestUtil.screenshotName + " height=200 width=200></img></a>");
						Reporter.log("<br>");
						Reporter.log("<br>");

						// Extent Report
						test.log(LogStatus.FAIL,
								" The red circle is not displayed for the newly created checklist. : ");
						test.log(LogStatus.FAIL, test.addScreenCapture(TestUtil.screenshotName));

						System.out.println("The red circle is not displayed for the newly created checklist.");
						log.info("The red circle is not displayed for the newly created checklist.");

					}
				} catch (Throwable t) {
					verificationFailed();
				}

				// VERIFY THE INSPECTION COMPLETED DATE

				System.out.println("VERIFY THE INSPECTION COMPLETED DATE");
				test.log(LogStatus.INFO, "VERIFY THE INSPECTION COMPLETED DATE");
				Reporter.log("VERIFY THE INSPECTION COMPLETED DATE");
				log.info("VERIFY THE INSPECTION COMPLETED DATE");

				try {

					String expiredDate = driver
							.findElement(By.xpath(OR.getProperty("propertysummary_inspectionred_expireddate_XPATH")))
							.getText();

					if (expiredDate.equals("-")) {
						System.out.println("The completed date is displayed for the newly created checklist.");
						test.log(LogStatus.INFO, "The completed date is displayed for the newly created checklist.");
						Reporter.log("The completed date is displayed for the newly created checklist.");
						log.info("The completed date is displayed for the newly created checklist.");
					} else {
						TestUtil.captureScreenshot();

						// ReportNG
						Reporter.log("<br>" + " The completed date is not displayed for the newly created checklist. : "
								+ "<br>");
						Reporter.log("<a target=\"_blank\" href=" + TestUtil.screenshotName + "><img src="
								+ TestUtil.screenshotName + " height=200 width=200></img></a>");
						Reporter.log("<br>");
						Reporter.log("<br>");

						// Extent Report
						test.log(LogStatus.FAIL,
								" The completed date is not displayed for the newly created checklist. : ");
						test.log(LogStatus.FAIL, test.addScreenCapture(TestUtil.screenshotName));

						System.out.println("The completed date is not displayed for the newly created checklist.");
						log.info("The completed date is not displayed for the newly created checklist.");

					}
				} catch (Throwable t) {
					verificationFailed();
				}

				// click on the newly created inspection
				driver.findElement(By.xpath("//td[text()='" + data.get("questionnaire_checklist_title") + "']"))
						.click();
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the newly created inspection.");

				// VERIFY NEWLY CREATED INSPECTION IS DISPLAYED CORRECTLY OR NOT IN THE
				// INSPECTION LIST

				System.out.println(
						"VERIFY NEWLY CREATED INSPECTION IS DISPLAYED CORRECTLY OR NOT IN THE INSPECTION LIST");
				test.log(LogStatus.INFO,
						"VERIFY NEWLY CREATED INSPECTION IS DISPLAYED CORRECTLY OR NOT IN THE INSPECTION LIST");
				Reporter.log("VERIFY NEWLY CREATED INSPECTION IS DISPLAYED CORRECTLY OR NOT IN THE INSPECTION LIST");
				log.info("VERIFY NEWLY CREATED INSPECTION IS DISPLAYED CORRECTLY OR NOT IN THE INSPECTION LIST");

				// select building from the property drop down
				select("envreports_movereports_propertydd_CSS", data.get("building_leveldropdown"));
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Selected building from the property drop down.");

				// enter the inspection name in the search field
				clear("task_listofchecklist_filterfield_CSS");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Cleared the search field.");
				type("task_listofchecklist_filterfield_CSS", data.get("checklist_property_title"));
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Entered the inspection name in the search field.");

				// verify newly created inspection is displayed or not
				switchVerification("inspection_createdinspection4_XPATH",
						"Test Questionnaire Property Title Smoke Capreit Four",
						"The Test Questionnaire Property Title Smoke Capreit Four is not displayed");

				// click on the back to dashboard button
				click("inspection_backtodashboardbtn_CSS");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the back to dashboard button.");

				// VERIFY CORRECT NAVIGATION IS OCCURED OR NOT
				switchVerification("inspection_tasksection_XPATH", "Tasks", "The Tasks is not displayed");

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

			// COMPLETE THE COVID 19 INSPECTION - OPERATION MANAGER

			System.out.println(
					"******************** COMPLETE THE COVID 19 INSPECTION - OPERATION MANAGER ********************");
			test.log(LogStatus.INFO,
					"******************** COMPLETE THE COVID 19 INSPECTION - OPERATION MANAGER ********************");
			Reporter.log(
					"******************** COMPLETE THE COVID 19 INSPECTION - OPERATION MANAGER ********************");
			log.info("******************** COMPLETE THE COVID 19 INSPECTION - OPERATION MANAGER ********************");

			try {

				// enter the property name in the search field
				type("envreports_propertylist_filtertxt_CSS", data.get("property_1"));
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Entered the property name in the search field.");

				// click on the environmental icon from the property list page
				click("environmentalicon_CSS");
				System.out.println("Clicked on the environmental icon of the Property.");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Navigate to the environmental screen of the perticular property.");

				// wait for the element
				Thread.sleep(5000);

				// click on the burger menu
				click("menubtn_CSS");
				System.out.println("Clicked on the burger menu button successfully!!!");
				ngDriver.waitForAngularRequestsToFinish();

				// wait for 5 seconds
				Thread.sleep(5000);

				// click on the checklist/inspection option from side menu
				click("checklist_sidemenu_XPATH");
				System.out.println("Clicked on the checklist/inspection option from side menu");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Navigate to the checklist/inspection screen");

				// wait for 3 seconds
				Thread.sleep(3000);

				// select property from the property drop down
				select("envreports_movereports_propertydd_CSS", data.get("building_leveldropdown"));
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Selected property from the property drop down.");

				// wait for 5 seconds
				Thread.sleep(5000);

				// enter newly created inspection in the search field
				clear("task_listofchecklist_filterfield_CSS");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Cleared the search field.");
				type("task_listofchecklist_filterfield_CSS", data.get("checklist_property_title"));
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Entered newly created inspection in the search field.");

				// click on the searched inspection
				click("inspection_createdinspection4_XPATH");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the searched inspection.");

				// click on the switch to wizard mode button
				click("checklist_classicviewbtn_CSS");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the switch to wizard mode button.");

				// click on the next button from the 1st question
				click("checklist_wizard_nextbtn_CSS");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the next button from the 1st question.");

				// click on the yes option of the 2nd question
				click("checklist_wizard_yesoption_CSS");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the yes option of the 2nd question.");

				// click on the next button from the 2nd question
				click("checklist_wizard_nextbtn_CSS");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the next button from the 2nd question.");

				// click on the yes option of the 3rd question
				click("checklist_wizard_yesoption_CSS");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the yes option of the 3rd question.");

				// click on the next button from the 3rd question
				click("checklist_wizard_nextbtn_CSS");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the next button from the 3rd question.");

				// scroll down the screen
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("window.scrollBy(0,500)");

				// click on the yes option of the 4th question
				click("checklist_wizard_yesoption_CSS");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the yes option of the 4td question.");

				// click on the next button from the 4th question
				click("checklist_wizard_nextbtn_CSS");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the next button from the 4th question.");

				// click on the next button from the 5th question
				click("checklist_wizard_nextbtn_CSS");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the next button from the 5th question.");

				// click on the next button from the 6th question
				click("checklist_wizard_nextbtn_CSS");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the next button from the 6th question.");

				// click on the next button from the 7th question
				click("checklist_wizard_nextbtn_CSS");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the next button from the 7th question.");

				// click on the back button
				click("checklist_backbtn_CSS");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the back button.");

				// enter newly created inspection in the search field
				clear("task_listofchecklist_filterfield_CSS");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Cleared the searched field.");
				type("task_listofchecklist_filterfield_CSS", data.get("checklist_property_title"));
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Entered newly created inspection in the search field.");

				// verify submitted inspection is displayed or not
				switchVerification("inspection_createdinspection4_XPATH",
						"Test Questionnaire Property Title Smoke Capreit Four",
						"The Test Questionnaire Property Title Smoke Capreit Four is not displayed.");

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

			// VERIFY THE COMPLETED INSPECTION IN PROPERTY SUMMARY DASHBOARD

			System.out.println(
					"******************** VERIFY THE COMPLETED INSPECTION IN PROPERTY SUMMARY DASHBOARD ********************");
			test.log(LogStatus.INFO,
					"******************** VERIFY THE COMPLETED INSPECTION IN PROPERTY SUMMARY DASHBOARD ********************");
			Reporter.log(
					"******************** VERIFY THE COMPLETED INSPECTION IN PROPERTY SUMMARY DASHBOARD ********************");
			log.info(
					"******************** VERIFY THE COMPLETED INSPECTION IN PROPERTY SUMMARY DASHBOARD ********************");

			try {
				// enter the property name in the search field
				type("envreports_propertylist_filtertxt_CSS", data.get("property_1"));
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Entered the property name in the search field.");

				// click on the property
				click("task_navigation_property1_CSS");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the property.");

				// scroll down the screen
				JavascriptExecutor js = (JavascriptExecutor) driver;
				WebElement inspectionSection = driver
						.findElement(By.xpath(OR.getProperty("propertysummary_inspection_instectiontitle_XPATH")));
				js.executeScript("arguments[0].scrollIntoView(true);", inspectionSection);

				// VERIFY THE INSPECTION STATUS INDICATOR

				System.out.println("VERIFY THE INSPECTION STATUS INDICATOR");
				test.log(LogStatus.INFO, "VERIFY THE INSPECTION STATUS INDICATOR");
				Reporter.log("VERIFY THE INSPECTION STATUS INDICATOR");
				log.info("VERIFY THE INSPECTION STATUS INDICATOR");

				try {
					// verify red circle is displayed or not
					boolean redCircle = driver
							.findElement(By.xpath(OR.getProperty("propertysummary_inspectionred_redcircle_XPATH")))
							.isDisplayed();

					if (redCircle == true) {
						System.out.println("The red circle is displayed for the newly created checklist.");
						test.log(LogStatus.INFO, "The red circle is displayed for the newly created checklist.");
						Reporter.log("The red circle is displayed for the newly created checklist.");
						log.info("The red circle is displayed for the newly created checklist.");
					} else {
						TestUtil.captureScreenshot();

						// ReportNG
						Reporter.log("<br>" + " The red circle is not displayed for the newly created checklist. : "
								+ "<br>");
						Reporter.log("<a target=\"_blank\" href=" + TestUtil.screenshotName + "><img src="
								+ TestUtil.screenshotName + " height=200 width=200></img></a>");
						Reporter.log("<br>");
						Reporter.log("<br>");

						// Extent Report
						test.log(LogStatus.FAIL,
								" The red circle is not displayed for the newly created checklist. : ");
						test.log(LogStatus.FAIL, test.addScreenCapture(TestUtil.screenshotName));

						System.out.println("The red circle is not displayed for the newly created checklist.");
						log.info("The red circle is not displayed for the newly created checklist.");

					}
				} catch (Throwable t) {
					verificationFailed();
				}

				// VERIFY THE INSPECTION COMPLETED DATE

				System.out.println("VERIFY THE INSPECTION COMPLETED DATE");
				test.log(LogStatus.INFO, "VERIFY THE INSPECTION COMPLETED DATE");
				Reporter.log("VERIFY THE INSPECTION COMPLETED DATE");
				log.info("VERIFY THE INSPECTION COMPLETED DATE");

				try {

					String expiredDate = driver
							.findElement(By.xpath(OR.getProperty("propertysummary_inspectionred_expireddate_XPATH")))
							.getText();

					if (expiredDate.equals("-")) {
						System.out.println("The completed date is displayed for the newly created checklist.");
						test.log(LogStatus.INFO, "The completed date is displayed for the newly created checklist.");
						Reporter.log("The completed date is displayed for the newly created checklist.");
						log.info("The completed date is displayed for the newly created checklist.");
					} else {
						TestUtil.captureScreenshot();

						// ReportNG
						Reporter.log("<br>" + " The completed date is not displayed for the newly created checklist. : "
								+ "<br>");
						Reporter.log("<a target=\"_blank\" href=" + TestUtil.screenshotName + "><img src="
								+ TestUtil.screenshotName + " height=200 width=200></img></a>");
						Reporter.log("<br>");
						Reporter.log("<br>");

						// Extent Report
						test.log(LogStatus.FAIL,
								" The completed date is not displayed for the newly created checklist. : ");
						test.log(LogStatus.FAIL, test.addScreenCapture(TestUtil.screenshotName));

						System.out.println("The completed date is not displayed for the newly created checklist.");
						log.info("The completed date is not displayed for the newly created checklist.");

					}
				} catch (Throwable t) {
					verificationFailed();
				}

				// click on the newly created inspection
				driver.findElement(By.xpath("//td[text()='" + data.get("questionnaire_checklist_title") + "']"))
						.click();
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the newly created inspection.");

				// VERIFY NEWLY CREATED INSPECTION IS DISPLAYED CORRECTLY OR NOT IN THE
				// INSPECTION LIST

				System.out.println(
						"VERIFY NEWLY CREATED INSPECTION IS DISPLAYED CORRECTLY OR NOT IN THE INSPECTION LIST");
				test.log(LogStatus.INFO,
						"VERIFY NEWLY CREATED INSPECTION IS DISPLAYED CORRECTLY OR NOT IN THE INSPECTION LIST");
				Reporter.log("VERIFY NEWLY CREATED INSPECTION IS DISPLAYED CORRECTLY OR NOT IN THE INSPECTION LIST");
				log.info("VERIFY NEWLY CREATED INSPECTION IS DISPLAYED CORRECTLY OR NOT IN THE INSPECTION LIST");

				// select building from the property drop down
				select("envreports_movereports_propertydd_CSS", data.get("building_leveldropdown"));
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Selected building from the property drop down.");

				// enter the inspection name in the search field
				clear("task_listofchecklist_filterfield_CSS");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Cleared the search field.");
				type("task_listofchecklist_filterfield_CSS", data.get("checklist_property_title"));
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Entered the inspection name in the search field.");

				// verify newly created inspection is displayed or not
				switchVerification("inspection_createdinspection4_XPATH",
						"Test Questionnaire Property Title Smoke Capreit Four",
						"The Test Questionnaire Property Title Smoke Capreit Four is not displayed");

				// click on the back to dashboard button
				click("inspection_backtodashboardbtn_CSS");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the back to dashboard button.");

				// VERIFY CORRECT NAVIGATION IS OCCURED OR NOT
				switchVerification("inspection_tasksection_XPATH", "Tasks", "The Tasks is not displayed");

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

			// ADD THE TASK IN COVID 19 INSPECTION - OPERATION MANAGER

			System.out.println(
					"******************** ADD THE TASK IN COVID 19 INSPECTION - OPERATION MANAGER ********************");
			test.log(LogStatus.INFO,
					"******************** ADD THE TASK IN COVID 19 INSPECTION - OPERATION MANAGER ********************");
			Reporter.log(
					"******************** ADD THE TASK IN COVID 19 INSPECTION - OPERATION MANAGER ********************");
			log.info(
					"******************** ADD THE TASK IN COVID 19 INSPECTION - OPERATION MANAGER ********************");

			try {

				// enter the property name in the search field
				type("envreports_propertylist_filtertxt_CSS", data.get("property_1"));
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Entered the property name in the search field.");

				// click on the environmental icon from the property list page
				click("environmentalicon_CSS");
				System.out.println("Clicked on the environmental icon of the Property.");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Navigate to the environmental screen of the perticular property.");

				// wait for the element
				Thread.sleep(5000);

				// click on the burger menu
				click("menubtn_CSS");
				System.out.println("Clicked on the burger menu button successfully!!!");
				ngDriver.waitForAngularRequestsToFinish();

				// wait for 5 seconds
				Thread.sleep(5000);

				// click on the checklist/inspection option from side menu
				click("checklist_sidemenu_XPATH");
				System.out.println("Clicked on the checklist/inspection option from side menu");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Navigate to the checklist/inspection screen");

				// wait for the element
				explicitWaitClickable("envreports_movereports_propertydd_CSS");

				// select property from the property drop down
				select("envreports_movereports_propertydd_CSS", data.get("building_leveldropdown"));
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Selected property from the property drop down.");

				// wait for 3 seconds
				Thread.sleep(3000);

				// enter newly created inspection in the search field
				clear("task_listofchecklist_filterfield_CSS");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Cleared the search field.");
				type("task_listofchecklist_filterfield_CSS", data.get("checklist_property_title"));
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Entered newly created inspection in the search field.");

				// click on the searched inspection
				click("inspection_createdinspection4_XPATH");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the searched inspection.");

				// wait for 3 seconds
				Thread.sleep(3000);

				// click on the switch to wizard mode button
				click("checklist_classicviewbtn_CSS");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the switch to wizard mode button.");

				// wait for 3 seconds
				Thread.sleep(3000);

				// click on the task tab
				click("inspectionchecklist_tasktab_XPATH");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the task tab.");

				// click on the new task button
				click("inspectionchecklist_newtaskbtn_XPATH");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the new task button.");

				// click on the task type field
				click("task_permission_task_tasktypetxt_CSS");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the task type field.");

				// enter task type in the search field
				type("inspectionchecklist_tasktagsearchfield_CSS", data.get("tasktag"));
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Entered task type in the search field.");

				// click on the searched task tag
				click("inspectionchecklist_tasktagsearchedresult_XPATH");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the searched task tag.");

				// click on the save task button
				click("survey_task_savebtn_CSS");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the save task button.");

				// verify newly created task is displayed or not
				switchVerification("inspectionchecklist_tasktagcreatedtask_XPATH", "Electrical (Light Fixture)",
						"The Electrical (Light Fixture) is not displayed.");

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

			// COMPLETE THE NEWLY CREATED TASK

			System.out.println("**************** COMPLETE THE NEWLY CREATED TASK ****************");
			test.log(LogStatus.INFO, "**************** COMPLETE THE NEWLY CREATED TASK ****************");
			Reporter.log("**************** COMPLETE THE NEWLY CREATED TASK ****************");
			log.info("**************** COMPLETE THE NEWLY CREATED TASK ****************");

			try {
				// enter the property name in the search field
				type("envreports_propertylist_filtertxt_CSS", data.get("property_1"));
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Entered the property name in the search field.");

				// click on the environmental icon from the property list page
				click("environmentalicon_CSS");
				System.out.println("Clicked on the environmental icon of the Property.");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Navigate to the environmental screen of the perticular property.");

				// wait for the element
				Thread.sleep(5000);

				// click on the burger menu
				click("menubtn_CSS");
				System.out.println("Clicked on the burger menu button successfully!!!");
				ngDriver.waitForAngularRequestsToFinish();

				// wait for 5 seconds
				Thread.sleep(5000);

				// click on the checklist/inspection option from side menu
				click("checklist_sidemenu_XPATH");
				System.out.println("Clicked on the checklist/inspection option from side menu");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Navigate to the checklist/inspection screen");

				// wait for the element
				explicitWaitClickable("envreports_movereports_propertydd_CSS");

				// select property from the property drop down
				select("envreports_movereports_propertydd_CSS", data.get("building_leveldropdown"));
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Selected property from the property drop down.");

				// wait for 3 seconds
				Thread.sleep(3000);

				// enter newly created inspection in the search field
				clear("task_listofchecklist_filterfield_CSS");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Cleared the search field.");
				type("task_listofchecklist_filterfield_CSS", data.get("checklist_property_title"));
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Entered newly created inspection in the search field.");

				// click on the searched inspection
				click("inspection_createdinspection4_XPATH");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the searched inspection.");

				// wait for 3 seconds
				Thread.sleep(3000);

				// click on the switch to wizard mode button
				click("checklist_classicviewbtn_CSS");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the switch to wizard mode button.");

				// wait for 3 seconds
				Thread.sleep(3000);

				// click on the task tab
				click("inspectionchecklist_tasktab_XPATH");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the task tab.");

				// click on the newly created task
				click("inspectionchecklist_tasktagcreatedtask_XPATH");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the newly created task.");

				// SET TASK AS A IN PROGRESS
				System.out.println("SET TASK AS A IN PROGRESS");
				test.log(LogStatus.INFO, "SET TASK AS A IN PROGRESS");
				Reporter.log("SET TASK AS A IN PROGRESS");
				log.info("SET TASK AS A IN PROGRESS");

				// click on the start button
				click("propertyproject_mu_repair_startbtn_CSS");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the start button.");

				// SET TASK AS A CLOSED
				System.out.println("SET TASK AS A CLOSED");
				test.log(LogStatus.INFO, "SET TASK AS A CLOSED");
				Reporter.log("SET TASK AS A CLOSED");
				log.info("SET TASK AS A CLOSED");

				// wait for the element
				explicitWaitClickable("task_addtask_backbtn_inspectiontask_XPATH");

				// click on the back button
				click("task_addtask_backbtn_inspectiontask_XPATH");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the back button.");

				// click on the action icon of the approved task
				click("task_autotask_actionicon_XPATH");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the action icon of the approved task.");

				// click on the complete task option
				click("task_addtask_approvedlbl_actionicon_closeoption_XPATH");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the complete task option.");

				// wait for the element
				explicitWaitClickable("closetoastmsg_CSS");

				// click on the toaster close button
				click("closetoastmsg_CSS");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the toaster close button.");

				// verify in closed status is display
				switchVerification("checklist_tasktwo_closed_capreitone_XPATH", "Closed",
						"The closed status is not displayed.");

			} catch (Throwable t) {
				verificationFailed();
			}

			// click on the Home button
			click("questionnaire_homeburgermenubtn_hide_CSS");
			System.out.println("Clicked on the home button.");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Navigate to the Home Screen i.e. property listing screen.");

			// wait for the element
			explicitWait("propertylist_title_XPATH");

			// verify the property list
			switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

			// VERIFY THE INSPECTION WITH CLOSED TASK IN PROPERTY SUMMARY DASHBOARD

			System.out.println(
					"******************** VERIFY THE INSPECTION WITH CLOSED TASK IN PROPERTY SUMMARY DASHBOARD ********************");
			test.log(LogStatus.INFO,
					"******************** VERIFY THE INSPECTION WITH CLOSED TASK IN PROPERTY SUMMARY DASHBOARD ********************");
			Reporter.log(
					"******************** VERIFY THE INSPECTION WITH CLOSED TASK IN PROPERTY SUMMARY DASHBOARD ********************");
			log.info(
					"******************** VERIFY THE INSPECTION WITH CLOSED TASK IN PROPERTY SUMMARY DASHBOARD ********************");

			try {
				// enter the property name in the search field
				type("envreports_propertylist_filtertxt_CSS", data.get("property_1"));
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Entered the property name in the search field.");

				// click on the property
				click("task_navigation_property1_CSS");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the property.");

				// scroll down the screen
				JavascriptExecutor js = (JavascriptExecutor) driver;
				WebElement inspectionSection = driver
						.findElement(By.xpath(OR.getProperty("propertysummary_inspection_instectiontitle_XPATH")));
				js.executeScript("arguments[0].scrollIntoView(true);", inspectionSection);

				// VERIFY THE INSPECTION STATUS INDICATOR

				System.out.println("VERIFY THE INSPECTION STATUS INDICATOR");
				test.log(LogStatus.INFO, "VERIFY THE INSPECTION STATUS INDICATOR");
				Reporter.log("VERIFY THE INSPECTION STATUS INDICATOR");
				log.info("VERIFY THE INSPECTION STATUS INDICATOR");

				try {
					// verify red circle is displayed or not
					boolean redCircle = driver
							.findElement(By.xpath(OR.getProperty("propertysummary_inspectionred_redcircle_XPATH")))
							.isDisplayed();

					if (redCircle == true) {
						System.out.println("The red circle is displayed for the newly created checklist.");
						test.log(LogStatus.INFO, "The red circle is displayed for the newly created checklist.");
						Reporter.log("The red circle is displayed for the newly created checklist.");
						log.info("The red circle is displayed for the newly created checklist.");
					} else {
						TestUtil.captureScreenshot();

						// ReportNG
						Reporter.log("<br>" + " The red circle is not displayed for the newly created checklist. : "
								+ "<br>");
						Reporter.log("<a target=\"_blank\" href=" + TestUtil.screenshotName + "><img src="
								+ TestUtil.screenshotName + " height=200 width=200></img></a>");
						Reporter.log("<br>");
						Reporter.log("<br>");

						// Extent Report
						test.log(LogStatus.FAIL,
								" The red circle is not displayed for the newly created checklist. : ");
						test.log(LogStatus.FAIL, test.addScreenCapture(TestUtil.screenshotName));

						System.out.println("The red circle is not displayed for the newly created checklist.");
						log.info("The red circle is not displayed for the newly created checklist.");

					}
				} catch (Throwable t) {
					verificationFailed();
				}

				// VERIFY THE INSPECTION COMPLETED DATE

				System.out.println("VERIFY THE INSPECTION COMPLETED DATE");
				test.log(LogStatus.INFO, "VERIFY THE INSPECTION COMPLETED DATE");
				Reporter.log("VERIFY THE INSPECTION COMPLETED DATE");
				log.info("VERIFY THE INSPECTION COMPLETED DATE");

				try {

					String expiredDate = driver
							.findElement(By.xpath(OR.getProperty("propertysummary_inspectionred_expireddate_XPATH")))
							.getText();

					if (expiredDate.equals("-")) {
						System.out.println("The completed date is displayed for the newly created checklist.");
						test.log(LogStatus.INFO, "The completed date is displayed for the newly created checklist.");
						Reporter.log("The completed date is displayed for the newly created checklist.");
						log.info("The completed date is displayed for the newly created checklist.");
					} else {
						TestUtil.captureScreenshot();

						// ReportNG
						Reporter.log("<br>" + " The completed date is not displayed for the newly created checklist. : "
								+ "<br>");
						Reporter.log("<a target=\"_blank\" href=" + TestUtil.screenshotName + "><img src="
								+ TestUtil.screenshotName + " height=200 width=200></img></a>");
						Reporter.log("<br>");
						Reporter.log("<br>");

						// Extent Report
						test.log(LogStatus.FAIL,
								" The completed date is not displayed for the newly created checklist. : ");
						test.log(LogStatus.FAIL, test.addScreenCapture(TestUtil.screenshotName));

						System.out.println("The completed date is not displayed for the newly created checklist.");
						log.info("The completed date is not displayed for the newly created checklist.");

					}
				} catch (Throwable t) {
					verificationFailed();
				}

				// click on the newly created inspection
				driver.findElement(By.xpath("//td[text()='" + data.get("questionnaire_checklist_title") + "']"))
						.click();
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the newly created inspection.");

				// VERIFY NEWLY CREATED INSPECTION IS DISPLAYED CORRECTLY OR NOT IN THE
				// INSPECTION LIST

				System.out.println(
						"VERIFY NEWLY CREATED INSPECTION IS DISPLAYED CORRECTLY OR NOT IN THE INSPECTION LIST");
				test.log(LogStatus.INFO,
						"VERIFY NEWLY CREATED INSPECTION IS DISPLAYED CORRECTLY OR NOT IN THE INSPECTION LIST");
				Reporter.log("VERIFY NEWLY CREATED INSPECTION IS DISPLAYED CORRECTLY OR NOT IN THE INSPECTION LIST");
				log.info("VERIFY NEWLY CREATED INSPECTION IS DISPLAYED CORRECTLY OR NOT IN THE INSPECTION LIST");

				// select building from the property drop down
				select("envreports_movereports_propertydd_CSS", data.get("building_leveldropdown"));
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Selected building from the property drop down.");

				// enter the inspection name in the search field
				clear("task_listofchecklist_filterfield_CSS");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Cleared the search field.");
				type("task_listofchecklist_filterfield_CSS", data.get("checklist_property_title"));
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Entered the inspection name in the search field.");

				// verify newly created inspection is displayed or not
				switchVerification("inspection_createdinspection4_XPATH",
						"Test Questionnaire Property Title Smoke Capreit Four",
						"The Test Questionnaire Property Title Smoke Capreit Four is not displayed");

				// click on the back to dashboard button
				click("inspection_backtodashboardbtn_CSS");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the back to dashboard button.");

				// VERIFY CORRECT NAVIGATION IS OCCURED OR NOT
				switchVerification("inspection_tasksection_XPATH", "Tasks", "The Tasks is not displayed");

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

			// SUBMIT THE COVID 19 INSPECTION

			System.out.println("******************** SUBMIT THE COVID 19 INSPECTION ********************");
			test.log(LogStatus.INFO, "******************** SUBMIT THE COVID 19 INSPECTION ********************");
			Reporter.log("******************** SUBMIT THE COVID 19 INSPECTION ********************");
			log.info("******************** SUBMIT THE COVID 19 INSPECTION ********************");

			try {

				// enter the property name in the search field
				type("envreports_propertylist_filtertxt_CSS", data.get("property_1"));
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Entered the property name in the search field.");

				// click on the environmental icon from the property list page
				click("environmentalicon_CSS");
				System.out.println("Clicked on the environmental icon of the Property.");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Navigate to the environmental screen of the perticular property.");

				// wait for the element
				Thread.sleep(5000);

				// click on the burger menu
				click("menubtn_CSS");
				System.out.println("Clicked on the burger menu button successfully!!!");
				ngDriver.waitForAngularRequestsToFinish();

				// wait for 5 seconds
				Thread.sleep(5000);

				// click on the checklist/inspection option from side menu
				click("checklist_sidemenu_XPATH");
				System.out.println("Clicked on the checklist/inspection option from side menu");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Navigate to the checklist/inspection screen");

				// wait for 3 seconds
				Thread.sleep(3000);

				// select property from the property drop down
				select("envreports_movereports_propertydd_CSS", data.get("building_leveldropdown"));
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Selected property from the property drop down.");

				// wait for 5 seconds
				Thread.sleep(5000);

				// enter newly created inspection in the search field
				clear("task_listofchecklist_filterfield_CSS");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Cleared the search field.");
				type("task_listofchecklist_filterfield_CSS", data.get("checklist_property_title"));
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Entered newly created inspection in the search field.");

				// click on the searched inspection
				click("inspection_createdinspection4_XPATH");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the searched inspection.");

				// click on the switch to wizard mode button
				click("checklist_classicviewbtn_CSS");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the switch to wizard mode button.");

				// click on the next button from the 1st question
				click("checklist_wizard_nextbtn_CSS");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the next button from the 1st question.");

				// click on the next button from the 2nd question
				click("checklist_wizard_nextbtn_CSS");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the next button from the 2nd question.");

				// click on the next button from the 3rd question
				click("checklist_wizard_nextbtn_CSS");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the next button from the 3rd question.");

				// click on the next button from the 4th question
				click("checklist_wizard_nextbtn_CSS");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the next button from the 4th question.");

				// click on the next button from the 5th question
				click("checklist_wizard_nextbtn_CSS");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the next button from the 5th question.");

				// click on the next button from the 6th question
				click("checklist_wizard_nextbtn_CSS");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the next button from the 6th question.");

				// click on the next button from the 7th question
				click("checklist_wizard_nextbtn_CSS");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the next button from the 7th question.");

				// click on the submit button
				click("checklist_submitbtn_CSS");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the submit button.");

				// wait for the element
				explicitWaitClickable("closetoastmsg_CSS");

				// click on the toaster close button
				click("closetoastmsg_CSS");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the toaster close button.");

				// click on the back button
				click("questionnaire_checklist_backbtn_CSS");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the back button.");

				// select the approved option from the status dropdown
				select("checklist_statusdd_CSS", data.get("status_dd"));
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Selected the approved option from the status dropdown.");

				// enter newly created inspection in the search field
				clear("task_listofchecklist_filterfield_CSS");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Cleared the searched field.");
				type("task_listofchecklist_filterfield_CSS", data.get("checklist_property_title"));
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Entered newly created inspection in the search field.");

				// verify submitted inspection is displayed or not
				switchVerification("inspection_createdinspection4_XPATH",
						"Test Questionnaire Property Title Smoke Capreit Four",
						"The Test Questionnaire Property Title Smoke Capreit Four is not displayed.");

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

			// VERIFY THE SUBMITTED INSPECTION WITH CLOSED TASK IN PROPERTY SUMMARY
			// DASHBOARD

			System.out.println(
					"******************** VERIFY THE SUBMITTED INSPECTION WITH CLOSED TASK IN PROPERTY SUMMARY DASHBOARD ********************");
			test.log(LogStatus.INFO,
					"******************** VERIFY THE SUBMITTED INSPECTION WITH CLOSED TASK IN PROPERTY SUMMARY DASHBOARD ********************");
			Reporter.log(
					"******************** VERIFY THE SUBMITTED INSPECTION WITH CLOSED TASK IN PROPERTY SUMMARY DASHBOARD ********************");
			log.info(
					"******************** VERIFY THE SUBMITTED INSPECTION WITH CLOSED TASK IN PROPERTY SUMMARY DASHBOARD ********************");

			try {
				// enter the property name in the search field
				type("envreports_propertylist_filtertxt_CSS", data.get("property_1"));
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Entered the property name in the search field.");

				// click on the property
				click("task_navigation_property1_CSS");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the property.");

				// scroll down the screen
				JavascriptExecutor js = (JavascriptExecutor) driver;
				WebElement inspectionSection = driver
						.findElement(By.xpath(OR.getProperty("propertysummary_inspection_instectiontitle_XPATH")));
				js.executeScript("arguments[0].scrollIntoView(true);", inspectionSection);

				// VERIFY THE INSPECTION STATUS INDICATOR

				System.out.println("VERIFY THE INSPECTION STATUS INDICATOR");
				test.log(LogStatus.INFO, "VERIFY THE INSPECTION STATUS INDICATOR");
				Reporter.log("VERIFY THE INSPECTION STATUS INDICATOR");
				log.info("VERIFY THE INSPECTION STATUS INDICATOR");

				try {
					// verify green circle is displayed or not
					boolean greenCircle = driver
							.findElement(By.xpath(OR.getProperty("propertysummary_inspectionred_greencircle_XPATH")))
							.isDisplayed();

					if (greenCircle == true) {
						System.out.println("The green circle is displayed for the newly created checklist.");
						test.log(LogStatus.INFO, "The green circle is displayed for the newly created checklist.");
						Reporter.log("The green circle is displayed for the newly created checklist.");
						log.info("The green circle is displayed for the newly created checklist.");
					} else {
						TestUtil.captureScreenshot();

						// ReportNG
						Reporter.log("<br>" + " The green circle is not displayed for the newly created checklist. : "
								+ "<br>");
						Reporter.log("<a target=\"_blank\" href=" + TestUtil.screenshotName + "><img src="
								+ TestUtil.screenshotName + " height=200 width=200></img></a>");
						Reporter.log("<br>");
						Reporter.log("<br>");

						// Extent Report
						test.log(LogStatus.FAIL,
								" The green circle is not displayed for the newly created checklist. : ");
						test.log(LogStatus.FAIL, test.addScreenCapture(TestUtil.screenshotName));

						System.out.println("The green circle is not displayed for the newly created checklist.");
						log.info("The green circle is not displayed for the newly created checklist.");

					}
				} catch (Throwable t) {
					verificationFailed();
				}

				// VERIFY THE INSPECTION COMPLETED DATE

				System.out.println("VERIFY THE INSPECTION COMPLETED DATE");
				test.log(LogStatus.INFO, "VERIFY THE INSPECTION COMPLETED DATE");
				Reporter.log("VERIFY THE INSPECTION COMPLETED DATE");
				log.info("VERIFY THE INSPECTION COMPLETED DATE");

				try {

					LocalDate currentDate = LocalDate.now();
					String currentDateText = currentDate.toString();

					String expiredDate = driver
							.findElement(By.xpath(OR.getProperty("propertysummary_inspectionred_expireddate_XPATH")))
							.getText();

					if (expiredDate.equals(currentDateText)) {
						System.out.println("The completed date is displayed for the newly created checklist.");
						test.log(LogStatus.INFO, "The completed date is displayed for the newly created checklist.");
						Reporter.log("The completed date is displayed for the newly created checklist.");
						log.info("The completed date is displayed for the newly created checklist.");
					} else {
						TestUtil.captureScreenshot();

						// ReportNG
						Reporter.log("<br>" + " The completed date is not displayed for the newly created checklist. : "
								+ "<br>");
						Reporter.log("<a target=\"_blank\" href=" + TestUtil.screenshotName + "><img src="
								+ TestUtil.screenshotName + " height=200 width=200></img></a>");
						Reporter.log("<br>");
						Reporter.log("<br>");

						// Extent Report
						test.log(LogStatus.FAIL,
								" The completed date is not displayed for the newly created checklist. : ");
						test.log(LogStatus.FAIL, test.addScreenCapture(TestUtil.screenshotName));

						System.out.println("The completed date is not displayed for the newly created checklist.");
						log.info("The completed date is not displayed for the newly created checklist.");

					}
				} catch (Throwable t) {
					verificationFailed();
				}

				// click on the newly created inspection
				driver.findElement(By.xpath("//td[text()='" + data.get("questionnaire_checklist_title") + "']"))
						.click();
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the newly created inspection.");

				// VERIFY NEWLY CREATED INSPECTION IS DISPLAYED CORRECTLY OR NOT IN THE
				// INSPECTION LIST

				System.out.println(
						"VERIFY NEWLY CREATED INSPECTION IS DISPLAYED CORRECTLY OR NOT IN THE INSPECTION LIST");
				test.log(LogStatus.INFO,
						"VERIFY NEWLY CREATED INSPECTION IS DISPLAYED CORRECTLY OR NOT IN THE INSPECTION LIST");
				Reporter.log("VERIFY NEWLY CREATED INSPECTION IS DISPLAYED CORRECTLY OR NOT IN THE INSPECTION LIST");
				log.info("VERIFY NEWLY CREATED INSPECTION IS DISPLAYED CORRECTLY OR NOT IN THE INSPECTION LIST");

				// select building from the property drop down
				select("envreports_movereports_propertydd_CSS", data.get("building_leveldropdown"));
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Selected building from the property drop down.");

				// enter the inspection name in the search field
				clear("task_listofchecklist_filterfield_CSS");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Cleared the search field.");
				type("task_listofchecklist_filterfield_CSS", data.get("checklist_property_title"));
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Entered the inspection name in the search field.");

				// verify newly created inspection is displayed or not
				switchVerification("inspection_createdinspection4_XPATH",
						"Test Questionnaire Property Title Smoke Capreit Four",
						"The Test Questionnaire Property Title Smoke Capreit Four is not displayed");

				// click on the back to dashboard button
				click("inspection_backtodashboardbtn_CSS");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the back to dashboard button.");

				// VERIFY CORRECT NAVIGATION IS OCCURED OR NOT
				switchVerification("inspection_tasksection_XPATH", "Tasks", "The Tasks is not displayed");

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

			// DELETE THE CLOSED TASK

			System.out.println("**************** DELETE THE CLOSED TASK ****************");
			test.log(LogStatus.INFO, "**************** DELETE THE CLOSED TASK ****************");
			Reporter.log("**************** DELETE THE CLOSED TASK ****************");
			log.info("**************** DELETE THE CLOSED TASK ****************");

			try {
				// enter the property name in the search field
				type("envreports_propertylist_filtertxt_CSS", data.get("property_1"));
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Entered the property name in the search field.");

				// click on the environmental icon from the property list page
				click("environmentalicon_CSS");
				System.out.println("Clicked on the environmental icon of the Property.");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Navigate to the environmental screen of the perticular property.");

				// wait for the element
				Thread.sleep(5000);

				// click on the burger menu
				click("menubtn_CSS");
				System.out.println("Clicked on the burger menu button successfully!!!");
				ngDriver.waitForAngularRequestsToFinish();

				// wait for 5 seconds
				Thread.sleep(5000);

				// click on the checklist/inspection option from side menu
				click("checklist_sidemenu_XPATH");
				System.out.println("Clicked on the checklist/inspection option from side menu");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Navigate to the checklist/inspection screen");

				// wait for the element
				explicitWaitClickable("envreports_movereports_propertydd_CSS");

				// select property from the property drop down
				select("envreports_movereports_propertydd_CSS", data.get("building_leveldropdown"));
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Selected property from the property drop down.");

				// wait for 3 seconds
				Thread.sleep(3000);

				// select the approved option from the status dropdown
				select("checklist_statusdd_CSS", data.get("status_dd"));
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Selected the approved option from the status dropdown.");

				// enter newly created inspection in the search field
				clear("task_listofchecklist_filterfield_CSS");
				type("task_listofchecklist_filterfield_CSS", data.get("checklist_property_title"));
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Entered newly created inspection in the search field.");

				// click on the searched inspection
				click("inspection_createdinspection4_XPATH");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the searched inspection.");

				// wait for 3 seconds
				Thread.sleep(3000);

				// click on the switch to wizard mode button
				click("checklist_classicviewbtn_CSS");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the switch to wizard mode button.");

				// wait for 3 seconds
				Thread.sleep(3000);

				// click on the task tab
				click("inspectionchecklist_tasktab_XPATH");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the task tab.");

				// click on the action icon of the closed task
				click("task_addtask_actionicon_XPATH");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the action icon of the closed task.");

				// click on the reopen option
				click("task_addtask_approvedlbl_actionicon_reopenoption_XPATH");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the reopen option.");

				// wait for the element
				explicitWaitClickable("closetoastmsg_CSS");

				// click on the toaster close button
				click("closetoastmsg_CSS");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the toaster close button.");

				// click on the action icon of the closed task
				click("task_addtask_actionicon_XPATH");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the action icon of the closed task.");

				// click on the delete button
				click("task_addtask_approvedlbl_actionicon_deleteoption1_XPATH");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the delete button.");

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

			// DELETE THE INSTANCE

			System.out.println("**************** DELETE THE INSTANCE ****************");
			test.log(LogStatus.INFO, "**************** DELETE THE INSTANCE ****************");
			Reporter.log("**************** DELETE THE INSTANCE ****************");
			log.info("**************** DELETE THE INSTANCE ****************");

			try {
				// enter the property name in the search field
				type("envreports_propertylist_filtertxt_CSS", data.get("property_1"));
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Entered the property name in the search field.");

				// click on the environmental icon from the property list page
				click("environmentalicon_CSS");
				System.out.println("Clicked on the environmental icon of the Property.");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Navigate to the environmental screen of the perticular property.");

				// wait for the element
				Thread.sleep(5000);

				// click on the burger menu
				click("menubtn_CSS");
				System.out.println("Clicked on the burger menu button successfully!!!");
				ngDriver.waitForAngularRequestsToFinish();

				// wait for 5 seconds
				Thread.sleep(5000);

				// click on the checklist/inspection option from side menu
				click("checklist_sidemenu_XPATH");
				System.out.println("Clicked on the checklist/inspection option from side menu");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Navigate to the checklist/inspection screen");

				// wait for the element
				explicitWaitClickable("envreports_movereports_propertydd_CSS");

				// select property from the property drop down
				select("envreports_movereports_propertydd_CSS", data.get("building_leveldropdown"));
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Selected property from the property drop down.");

				// wait for 3 seconds
				Thread.sleep(3000);

				// select the approved option from the status dropdown
				select("checklist_statusdd_CSS", data.get("status_dd"));
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Selected the approved option from the status dropdown.");

				// enter newly created inspection in the search field
				clear("task_listofchecklist_filterfield_CSS");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Cleared the search field.");
				type("task_listofchecklist_filterfield_CSS", data.get("checklist_property_title"));
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Entered newly created inspection in the search field.");

				// click on the action icon
				click("checklist_actionicon_CSS");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the action icon.");

				// click on the reopen option
				click("checklist_wizard_reopenoption_CSS");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the reopen option.");

				// click on the reopen button
				click("checklist_wizard_reopenbtn_CSS");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the reopen button.");

				// wait for the element
				explicitWaitClickable("closetoastmsg_CSS");

				// click on the toaster close button
				click("closetoastmsg_CSS");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the toaster close button.");

				// wait for 3 seconds
				Thread.sleep(3000);

				// select the open option from the status dropdown
				select("checklist_statusdd_CSS", data.get("status_dd_open"));
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Selected the open option from the status dropdown.");

				// enter newly created inspection in the search field
				clear("task_listofchecklist_filterfield_CSS");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Cleared the search field.");
				type("task_listofchecklist_filterfield_CSS", data.get("checklist_property_title"));
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Entered newly created inspection in the search field.");

				// click on the action icon
				click("checklist_actionicon_CSS");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the action icon.");

				// click on the delete option
				click("checklist_deleteoption_CSS");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the delete option.");

				// click on the delete button
				click("checklist_deletebtn_CSS");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the delete button.");

				// enter newly created inspection in the search field
				clear("task_listofchecklist_filterfield_CSS");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Cleared the search field.");
				type("task_listofchecklist_filterfield_CSS", data.get("checklist_property_title"));
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Entered newly created inspection in the search field.");

				// verify deleted inspection is displayed or not
				deleteVerification("inspection_createdinspection4_XPATH",
						"Test Questionnaire Property Title Smoke Capreit Four");

			} catch (Throwable t) {
				verificationFailed();
			}

			// click on the Home button
			click("questionnaire_homeburgermenubtn_hide_CSS");
			System.out.println("Clicked on the home button.");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Navigate to the Home Screen i.e. property listing screen.");

			// wait for the element
			explicitWait("propertylist_title_XPATH");

			// verify the property list
			switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

			// VERIFY THE DELETED INSPECTION IN PROPERTY SUMMARY DASHBOARD

			System.out.println(
					"******************** VERIFY THE DELETED INSPECTION COUNT IN PROPERTY SUMMARY DASHBOARD ********************");
			test.log(LogStatus.INFO,
					"******************** VERIFY THE DELETED INSPECTION COUNT IN PROPERTY SUMMARY DASHBOARD ********************");
			Reporter.log(
					"******************** VERIFY THE DELETED INSPECTION COUNT IN PROPERTY SUMMARY DASHBOARD ********************");
			log.info(
					"******************** VERIFY THE DELETED INSPECTION COUNT IN PROPERTY SUMMARY DASHBOARD ********************");

			try {
				// enter the property name in the search field
				type("envreports_propertylist_filtertxt_CSS", data.get("property_1"));
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Entered the property name in the search field.");

				// click on the property
				click("task_navigation_property1_CSS");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the property.");

				// scroll down the screen
				JavascriptExecutor js = (JavascriptExecutor) driver;
				WebElement inspectionSection = driver
						.findElement(By.xpath(OR.getProperty("propertysummary_inspection_instectiontitle_XPATH")));
				js.executeScript("arguments[0].scrollIntoView(true);", inspectionSection);

				// VERIFY THE INSPECTION STATUS INDICATOR

				System.out.println("VERIFY THE INSPECTION STATUS INDICATOR");
				test.log(LogStatus.INFO, "VERIFY THE INSPECTION STATUS INDICATOR");
				Reporter.log("VERIFY THE INSPECTION STATUS INDICATOR");
				log.info("VERIFY THE INSPECTION STATUS INDICATOR");

				try {
					// verify red circle is displayed or not
					boolean redCircle = driver
							.findElement(By.xpath(OR.getProperty("propertysummary_inspectionred_redcircle_XPATH")))
							.isDisplayed();

					if (redCircle == true) {
						System.out.println("The red circle is displayed for the newly created checklist.");
						test.log(LogStatus.INFO, "The red circle is displayed for the newly created checklist.");
						Reporter.log("The red circle is displayed for the newly created checklist.");
						log.info("The red circle is displayed for the newly created checklist.");
					} else {
						TestUtil.captureScreenshot();

						// ReportNG
						Reporter.log("<br>" + " The red circle is not displayed for the newly created checklist. : "
								+ "<br>");
						Reporter.log("<a target=\"_blank\" href=" + TestUtil.screenshotName + "><img src="
								+ TestUtil.screenshotName + " height=200 width=200></img></a>");
						Reporter.log("<br>");
						Reporter.log("<br>");

						// Extent Report
						test.log(LogStatus.FAIL,
								" The red circle is not displayed for the newly created checklist. : ");
						test.log(LogStatus.FAIL, test.addScreenCapture(TestUtil.screenshotName));

						System.out.println("The red circle is not displayed for the newly created checklist.");
						log.info("The red circle is not displayed for the newly created checklist.");

					}
				} catch (Throwable t) {
					verificationFailed();
				}

				// VERIFY THE INSPECTION COMPLETED DATE

				System.out.println("VERIFY THE INSPECTION COMPLETED DATE");
				test.log(LogStatus.INFO, "VERIFY THE INSPECTION COMPLETED DATE");
				Reporter.log("VERIFY THE INSPECTION COMPLETED DATE");
				log.info("VERIFY THE INSPECTION COMPLETED DATE");

				try {

					String expiredDate = driver
							.findElement(By.xpath(OR.getProperty("propertysummary_inspectionred_expireddate_XPATH")))
							.getText();

					if (expiredDate.equals("-")) {
						System.out.println("The completed date is displayed for the newly created checklist.");
						test.log(LogStatus.INFO, "The completed date is displayed for the newly created checklist.");
						Reporter.log("The completed date is displayed for the newly created checklist.");
						log.info("The completed date is displayed for the newly created checklist.");
					} else {
						TestUtil.captureScreenshot();

						// ReportNG
						Reporter.log("<br>" + " The completed date is not displayed for the newly created checklist. : "
								+ "<br>");
						Reporter.log("<a target=\"_blank\" href=" + TestUtil.screenshotName + "><img src="
								+ TestUtil.screenshotName + " height=200 width=200></img></a>");
						Reporter.log("<br>");
						Reporter.log("<br>");

						// Extent Report
						test.log(LogStatus.FAIL,
								" The completed date is not displayed for the newly created checklist. : ");
						test.log(LogStatus.FAIL, test.addScreenCapture(TestUtil.screenshotName));

						System.out.println("The completed date is not displayed for the newly created checklist.");
						log.info("The completed date is not displayed for the newly created checklist.");

					}
				} catch (Throwable t) {
					verificationFailed();
				}
			} catch (Throwable t) {
				verificationFailed();
			}

			// click on the home icon from the top of the screen
			click("questionnaire_homeburgermenubtn_hide_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the home icon from the top of the screen.");

			// wait for the element
			explicitWait("propertylist_title_XPATH");

			// verify the property list
			switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

			// wait for the 5 seconds
			Thread.sleep(5000);

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

			System.out.println("**************** LOGIN IN ADMIN USER ****************");
			test.log(LogStatus.INFO, "**************** LOGIN IN ADMIN USER ****************");
			Reporter.log("**************** LOGIN IN ADMIN USER ****************");
			log.info("**************** LOGIN IN ADMIN USER ****************");

			// Enter the username
			ngDriver.waitForAngularRequestsToFinish();
			type("username_MODEL", data.get("username_1"));

			// Enter the password
			type("password_MODEL", data.get("password_1"));

			// Clicking on the "Sign In" button
			click("signinbtn_BTNTEXT");
			ngDriver.waitForAngularRequestsToFinish();

			// wait for the element
			explicitWait("propertylist_title_XPATH");

			// verify the property list
			switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		} catch (Throwable t) {
			helper.questionnaireNotDisplayLogout(data);
		}

		// click on the home icon from the top of the screen
		click("questionnaire_homeburgermenubtn_hide_CSS");
		System.out.println("Clicked on the home icon from the top of the screen.");
		ngDriver.waitForAngularRequestsToFinish();

		// synchronization
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		try {
			// wait for the 5 seconds
			Thread.sleep(5000);

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
