package testcases.smokesuite;

import java.io.IOException;
import java.util.ArrayList;
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

public class RR5368Capreit3Test extends TestBase {

	@Test(dataProviderClass = TestUtil.class, dataProvider = "dp")
	public void rR5368Capreit3Test(Hashtable<String, String> data) throws IOException, InterruptedException {

		if (!(TestUtil.isTestRunnable("rR5368Capreit3Test", excel))) {

			throw new SkipException(
					"Skipping the test " + "rR5368Capreit3Test".toUpperCase() + "as the Run mode is NO");
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

		// PERFORM THE TEST CASES OF THE CAPREIT - OPERATION MANAGER

		System.out.println(
				"******************** PERFORM THE TEST CASES OF THE CAPREIT - OPERATION MANAGER ********************");
		test.log(LogStatus.INFO,
				"******************** PERFORM THE TEST CASES OF THE CAPREIT - OPERATION MANAGER ********************");
		Reporter.log(
				"******************** PERFORM THE TEST CASES OF THE CAPREIT - OPERATION MANAGER ********************");
		log.info("******************** PERFORM THE TEST CASES OF THE CAPREIT - OPERATION MANAGER ********************");

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

			// CREATE THE NEW INSPECTION AND CHECKLIST (PROPERTY WITH BUILDING) - OPERATION
			// MANAGER

			System.out.println(
					"******************** CREATE THE NEW INSPECTION AND CHECKLIST (PROPERTY WITH BUILDING) - OPERATION MANAGER ********************");
			test.log(LogStatus.INFO,
					"******************** CREATE THE NEW INSPECTION AND CHECKLIST (PROPERTY WITH BUILDING) - OPERATION MANAGER ********************");
			Reporter.log(
					"******************** CREATE THE NEW INSPECTION AND CHECKLIST (PROPERTY WITH BUILDING) - OPERATION MANAGER ********************");
			log.info(
					"******************** CREATE THE NEW INSPECTION AND CHECKLIST (PROPERTY WITH BUILDING) - OPERATION MANAGER ********************");

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
				select("envreports_movereports_propertydd_CSS", data.get("property_leveldropdown"));
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Selected property from the property drop down.");

				// BUTTON NOT AVAILABLE
				// verify the new checklist button is displayed or not
				try {

					boolean newChecklistBtn = driver
							.findElement(By.cssSelector(OR.getProperty("checklist_newchecklistbtn_CSS"))).isDisplayed();

					System.out.println("For Property List" + newChecklistBtn);

					if (newChecklistBtn == true) {

						// click on the new checklist button
						click("checklist_newchecklistbtn_CSS");
						ngDriver.waitForAngularRequestsToFinish();
						System.out.println("Selected property from the property drop down.");

						// collect all the option from the checklist type option and verify

						List<WebElement> checklists = driver
								.findElements(By.cssSelector(OR.getProperty("checklist_checklisttypedd_list_CSS")));

						List<String> checklistList = new ArrayList<String>();

						for (WebElement e : checklists) {
							String str = e.getText();
							checklistList.add(str);
						}

						System.out.println(
								"DISPLAY THE LIST OF OPTION IN STRING:::::::::::::::::::::::: " + checklistList);

						for (String s : checklistList) {
							if (s.equals("Capreit - Property Inspection (OM)")) {
								TestUtil.captureScreenshot();

								// ReportNG
								Reporter.log("<br>"
										+ "The checklist is displayed even if the questionnaire is not available in property level : "
										+ "<br>");
								Reporter.log("<a target=\"_blank\" href=" + TestUtil.screenshotName + "><img src="
										+ TestUtil.screenshotName + " height=200 width=200></img></a>");
								Reporter.log("<br>");
								Reporter.log("<br>");

								// Extent Report
								test.log(LogStatus.FAIL,
										" The checklist is displayed even if the questionnaire is not available in property level : ");
								test.log(LogStatus.FAIL, test.addScreenCapture(TestUtil.screenshotName));

								System.out.println(
										"The checklist is displayed even if the questionnaire is not available in property level.");
								log.info(
										"The checklist is displayed even if the questionnaire is not available in property level.");

							} else {
								System.out.println("THE EXPECTED CHECKLIST IS NOT DISPLAYED AS EXPECTED.");
								test.log(LogStatus.INFO, "THE EXPECTED CHECKLIST IS NOT DISPLAYED AS EXPECTED.");
								Reporter.log("THE EXPECTED CHECKLIST IS NOT DISPLAYED AS EXPECTED.");
								log.info("THE EXPECTED CHECKLIST IS NOT DISPLAYED AS EXPECTED.");
							}
						}
					} else {
						System.out.println("THE CHECKLIST BUTTON IS NOT DISPLAYED AS EXPECTED.");
						test.log(LogStatus.INFO, "THE CHECKLIST BUTTON IS NOT DISPLAYED AS EXPECTED.");
						Reporter.log("THE CHECKLIST BUTTON IS NOT DISPLAYED AS EXPECTED.");
						log.info("THE CHECKLIST BUTTON IS NOT DISPLAYED AS EXPECTED.");
					}
				} catch (Throwable t) {

					verificationFailed();
				}

				// wait for 3 seconds
				Thread.sleep(3000);

				// click on the close button
				click("checklist_addchecklist_cancelbtn_XPATH");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the close button.");

				// wait for 3 seconds
				Thread.sleep(3000);

				// select building from the property drop down
				select("envreports_movereports_propertydd_CSS", data.get("building_leveldropdown"));
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Selected building from the property drop down.");

				// wait for 5 seconds
				Thread.sleep(5000);

				// BUTTON AVAILABLE
				// verify the new checklist button is displayed or not
				try {

					boolean newChecklistBtn = driver
							.findElement(By.cssSelector(OR.getProperty("checklist_newchecklistbtn_CSS"))).isDisplayed();

					System.out.println("For Property List" + newChecklistBtn);

					if (newChecklistBtn == true) {

						// click on the new checklist button
						click("checklist_newchecklistbtn_CSS");
						ngDriver.waitForAngularRequestsToFinish();
						System.out.println("Selected property from the property drop down.");

						// collect all the option from the checklist type option and verify

						List<WebElement> checklists = driver
								.findElements(By.cssSelector(OR.getProperty("checklist_checklisttypedd_list_CSS")));

						List<String> checklistList = new ArrayList<String>();

						for (WebElement e : checklists) {
							String str = e.getText();
							checklistList.add(str);
						}

						System.out.println(
								"DISPLAY THE LIST OF OPTION IN STRING:::::::::::::::::::::::: " + checklistList);

						int count = 0;

						for (String s : checklistList) {
							if (s.equals("Capreit - Property Inspection (OM)")) {

								count = count + 1;

								System.out.println("THE CHECKLIST IS DISPLAYED AS EXPECTED.");
								test.log(LogStatus.INFO, "THE CHECKLIST IS DISPLAYED AS EXPECTED.");
								Reporter.log("THE CHECKLIST IS DISPLAYED AS EXPECTED.");
								log.info("THE CHECKLIST IS DISPLAYED AS EXPECTED.");

							}
						}
						if (count == 0) {
							TestUtil.captureScreenshot();

							// ReportNG
							Reporter.log("<br>"
									+ "The checklist is not displayed even if the questionnaire is available in building level : "
									+ "<br>");
							Reporter.log("<a target=\"_blank\" href=" + TestUtil.screenshotName + "><img src="
									+ TestUtil.screenshotName + " height=200 width=200></img></a>");
							Reporter.log("<br>");
							Reporter.log("<br>");

							// Extent Report
							test.log(LogStatus.FAIL,
									" The checklist is not displayed even if the questionnaire is available in building level : ");
							test.log(LogStatus.FAIL, test.addScreenCapture(TestUtil.screenshotName));

							System.out.println(
									"The checklist is not displayed even if the questionnaire is available in building level.");
							log.info(
									"The checklist is not displayed even if the questionnaire is available in building level.");

						}
					} else {
						TestUtil.captureScreenshot();

						// ReportNG
						Reporter.log("<br>"
								+ "The checklist is not displayed even if the questionnaire is available in building level : "
								+ "<br>");
						Reporter.log("<a target=\"_blank\" href=" + TestUtil.screenshotName + "><img src="
								+ TestUtil.screenshotName + " height=200 width=200></img></a>");
						Reporter.log("<br>");
						Reporter.log("<br>");

						// Extent Report
						test.log(LogStatus.FAIL,
								" The checklist is not displayed even if the questionnaire is available in building level : ");
						test.log(LogStatus.FAIL, test.addScreenCapture(TestUtil.screenshotName));

						System.out.println(
								"The checklist is not displayed even if the questionnaire is available in building level.");
						log.info(
								"The checklist is not displayed even if the questionnaire is available in building level.");
					}
				} catch (Throwable t) {

					verificationFailed();
				}

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
						.findElement(By.xpath(OR.getProperty("checklist_wizard_inspectiontitle3_XPATH"))).getText();
				System.out.println("COVID 19 INSTECTION TITLE : " + covidtxt);
				switchVerification("checklist_wizard_inspectiontitle3_XPATH",
						"Test Questionnaire Property Title Smoke Capreit Three",
						"The Test Questionnaire Property Title Smoke Capreit Three is not displayed.");

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

			// CREATE THE NEW INSPECTION AND CHECKLIST (PROPERTY WITHOUT BUILDING) -
			// OPERATION MANAGER

			System.out.println(
					"******************** CREATE THE NEW INSPECTION AND CHECKLIST (PROPERTY WITHOUT BUILDING) - OPERATION MANAGER ********************");
			test.log(LogStatus.INFO,
					"******************** CREATE THE NEW INSPECTION AND CHECKLIST (PROPERTY WITHOUT BUILDING) - OPERATION MANAGER ********************");
			Reporter.log(
					"******************** CREATE THE NEW INSPECTION AND CHECKLIST (PROPERTY WITHOUT BUILDING) - OPERATION MANAGER ********************");
			log.info(
					"******************** CREATE THE NEW INSPECTION AND CHECKLIST (PROPERTY WITHOUT BUILDING) - OPERATION MANAGER ********************");

			try {

				// enter the property name in the search field
				type("envreports_propertylist_filtertxt_CSS", data.get("property_2"));
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
				select("envreports_movereports_propertydd_CSS", data.get("property_leveldropdown"));
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Selected property from the property drop down.");

				// BUTTON AVAILABLE
				// verify the new checklist button is displayed or not
				try {

					boolean newChecklistBtn = driver
							.findElement(By.cssSelector(OR.getProperty("checklist_newchecklistbtn_CSS"))).isDisplayed();

					System.out.println("For Property List" + newChecklistBtn);

					if (newChecklistBtn == true) {

						// click on the new checklist button
						click("checklist_newchecklistbtn_CSS");
						ngDriver.waitForAngularRequestsToFinish();
						System.out.println("Selected property from the property drop down.");

						// collect all the option from the checklist type option and verify

						List<WebElement> checklists = driver
								.findElements(By.cssSelector(OR.getProperty("checklist_checklisttypedd_list_CSS")));

						List<String> checklistList = new ArrayList<String>();

						for (WebElement e : checklists) {
							String str = e.getText();
							checklistList.add(str);
						}

						System.out.println(
								"DISPLAY THE LIST OF OPTION IN STRING:::::::::::::::::::::::: " + checklistList);

						for (String s : checklistList) {
							if (s.equals("Capreit - Property Inspection (OM)")) {

								TestUtil.captureScreenshot();

								// ReportNG
								Reporter.log("<br>" + "The excluded checklist is displayed : " + "<br>");
								Reporter.log("<a target=\"_blank\" href=" + TestUtil.screenshotName + "><img src="
										+ TestUtil.screenshotName + " height=200 width=200></img></a>");
								Reporter.log("<br>");
								Reporter.log("<br>");

								// Extent Report
								test.log(LogStatus.FAIL, " The excluded checklist is displayed : ");
								test.log(LogStatus.FAIL, test.addScreenCapture(TestUtil.screenshotName));

								System.out.println("The excluded checklist is displayed.");
								log.info("The excluded checklist is displayed.");

							} else {
								System.out.println("THE EXCLUDED CHECKLIST IS NOT DISPLAYED AS EXPECTED.");
								test.log(LogStatus.INFO, "THE EXCLUDED CHECKLIST IS NOT DISPLAYED AS EXPECTED.");
								Reporter.log("THE EXCLUDED CHECKLIST IS NOT DISPLAYED AS EXPECTED.");
								log.info("THE EXCLUDED CHECKLIST IS NOT DISPLAYED AS EXPECTED.");

							}
						}
					} else {
						System.out.println("THE EXCLUDED CHECKLIST IS NOT DISPLAYED AS EXPECTED.");
						test.log(LogStatus.INFO, "THE EXCLUDED CHECKLIST IS NOT DISPLAYED AS EXPECTED.");
						Reporter.log("THE EXCLUDED CHECKLIST IS NOT DISPLAYED AS EXPECTED.");
						log.info("THE EXCLUDED CHECKLIST IS NOT DISPLAYED AS EXPECTED.");
					}
				} catch (Throwable t) {

					verificationFailed();
				}

			} catch (Throwable t) {
				verificationFailed();
			}

			// click on the close button
			click("checklist_addchecklist_cancelbtn_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the close button.");

			// wait for 3 seconds
			Thread.sleep(3000);

			// click on the home icon from the top of the screen
			click("questionnaire_homeburgermenubtn_hide_CSS");
			System.out.println("Clicked on the home icon from the top of the screen.");
			ngDriver.waitForAngularRequestsToFinish();

			// synchronization
			explicitWait("propertylist_title_XPATH");

			// verify the property list
			switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

			// SUBMIT THE COVID 19 INSPECTION - OPERATION MANAGER

			System.out.println(
					"******************** SUBMIT THE COVID 19 INSPECTION - OPERATION MANAGER ********************");
			test.log(LogStatus.INFO,
					"******************** SUBMIT THE COVID 19 INSPECTION - OPERATION MANAGER ********************");
			Reporter.log(
					"******************** SUBMIT THE COVID 19 INSPECTION - OPERATION MANAGER ********************");
			log.info("******************** SUBMIT THE COVID 19 INSPECTION - OPERATION MANAGER ********************");

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
				type("task_listofchecklist_filterfield_CSS", data.get("checklist_property_title"));
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Entered newly created inspection in the search field.");

				// click on the searched inspection
				click("questionnaire_checklist_createdinspectioncovid19om_XPATH");
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

				try {
					// verify inspection submitted or not
					String submittedText = driver
							.findElement(By.xpath(OR.getProperty("checklist_wizard_submittedtxt_XPATH"))).getText();

					if (submittedText.equals("The inspection has been submitted successfully")) {

						System.out.println("THE INSPECTION SUBMITTED SUCCESSFULLY.");
						test.log(LogStatus.INFO, "THE INSPECTION SUBMITTED SUCCESSFULLY.");
						Reporter.log("THE INSPECTION SUBMITTED SUCCESSFULLY.");
						log.info("THE INSPECTION SUBMITTED SUCCESSFULLY.");

					}
				} catch (Throwable t) {
					TestUtil.captureScreenshot();

					// ReportNG
					Reporter.log("<br>" + " The inspection is not submitted : " + "<br>");
					Reporter.log("<a target=\"_blank\" href=" + TestUtil.screenshotName + "><img src="
							+ TestUtil.screenshotName + " height=200 width=200></img></a>");
					Reporter.log("<br>");
					Reporter.log("<br>");

					// Extent Report
					test.log(LogStatus.FAIL, " The inspection is not submitted : ");
					test.log(LogStatus.FAIL, test.addScreenCapture(TestUtil.screenshotName));

					System.out.println("The inspection is not submitted.");
					log.info("The inspection is not submitted.");
				}

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
				type("task_listofchecklist_filterfield_CSS", data.get("checklist_property_title"));
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Entered newly created inspection in the search field.");

				// verify submitted inspection is displayed or not
				switchVerification("questionnaire_checklist_createdinspectioncovid19om_XPATH",
						"Test Questionnaire Property Title Smoke Capreit Three",
						"The Test Questionnaire Property Title Smoke Capreit Three is not displayed.");

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

			// VERIFY AUTO GENERATED TASK IS DISPLAYED WITH CORRECT DETAILS - OPERATION
			// MANAGER

			System.out.println(
					"******************** VERIFY AUTO GENERATED TASK IS DISPLAYED WITH CORRECT DETAILS - OPERATION MANAGER ********************");
			test.log(LogStatus.INFO,
					"******************** VERIFY AUTO GENERATED TASK IS DISPLAYED WITH CORRECT DETAILS - OPERATION MANAGER ********************");
			Reporter.log(
					"******************** VERIFY AUTO GENERATED TASK IS DISPLAYED WITH CORRECT DETAILS - OPERATION MANAGER ********************");
			log.info(
					"******************** VERIFY AUTO GENERATED TASK IS DISPLAYED WITH CORRECT DETAILS - OPERATION MANAGER ********************");

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

				// select property from the building drop down
				select("envreports_movereports_propertydd_CSS", data.get("building_leveldropdown"));
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Selected property from the building drop down.");

				// wait for 5 seconds
				Thread.sleep(5000);

				// select the approved option from the status dropdown
				select("checklist_statusdd_CSS", data.get("status_dd"));
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Selected the approved option from the status dropdown.");

				// enter newly created inspection in the search field
				clear("task_listofchecklist_filterfield_CSS");
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

				// wait for the element
				explicitWaitClickable("checklist_wizard_reopenbtn_CSS");

				// click on the reopen button
				click("checklist_wizard_reopenbtn_CSS");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the reopen button.");

				// select the open option from the status dropdown
				select("checklist_statusdd_CSS", data.get("status_dd_open"));
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Selected the open option from the status dropdown.");

				// enter newly created inspection in the search field
				clear("task_listofchecklist_filterfield_CSS");
				type("task_listofchecklist_filterfield_CSS", data.get("checklist_property_title"));
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Entered newly created inspection in the search field.");

				// click on the searched inspection
				click("questionnaire_checklist_createdinspectioncovid19om_XPATH");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the searched inspection.");

				// click on the no answer of the 1st question
				click("survey_noanswerbtn_1_CSS");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the no answer of the 1st question.");

				// wait for 3 seconds
				Thread.sleep(3000);

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

			// VERIFY AUTO GENERATED TASK IS DISPLAYED OR NOT - OPRATION MANAGER USER

			System.out.println(
					"******************** VERIFY AUTO GENERATED TASK IS DISPLAYED OR NOT - OPRATION MANAGER USER ********************");
			test.log(LogStatus.INFO,
					"******************** VERIFY AUTO GENERATED TASK IS DISPLAYED OR NOT - OPRATION MANAGER USER ********************");
			Reporter.log(
					"******************** VERIFY AUTO GENERATED TASK IS DISPLAYED OR NOT - OPRATION MANAGER USER ********************");
			log.info(
					"******************** VERIFY AUTO GENERATED TASK IS DISPLAYED OR NOT - OPRATION MANAGER USER ********************");

			try {
				// enter the property name in the search field
				type("envreports_propertylist_filtertxt_CSS", data.get("property_1"));
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Entered the property name in the search field.");

				// click on the task icon of the respective property
				click("taskicon_CSS");
				System.out.println("Clicked on the task icon of the respective property.");
				ngDriver.waitForAngularRequestsToFinish();

				// wait for 5 seconds
				Thread.sleep(5000);

				// select property from the building drop down
				select("task_addedtask_propertybuildingdd_CSS", data.get("building_leveldropdown"));
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Selected property from the building drop down.");

				// click on the clear button
				click("task_createdtask_clearbtn_XPATH");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the clear button.");

				// enter the data in the search field
				type("task_filter_CSS", data.get("task_title"));
				System.out.println("Entered the data in the search field.");
				ngDriver.waitForAngularRequestsToFinish();

				// click on the search button
				click("task_createdtask_searchbtn_XPATH");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the search button.");

				// verify the auto generated task is displayed or not
				switchVerification("task_createdtask_covid19autotask1_XPATH", "Get safety plan",
						"The Get safety plan is not displayed.");

				// click on the auto generated task
				click("task_createdtask_covid19autotask1_XPATH");
				System.out.println("Clicked on the auto generated task.");
				ngDriver.waitForAngularRequestsToFinish();

				// verify correct task title is displayed correct or not
				try {
					String taskTitle = driver.findElement(By.cssSelector(OR.getProperty("task_tasktitletxt_CSS")))
							.getAttribute("value");

					if (taskTitle.equals("Get safety plan")) {
						System.out.println("THE CORRECT TASK TITLE IS DISPLAYED.");
						test.log(LogStatus.INFO, "THE CORRECT TASK TITLE IS DISPLAYED.");
						Reporter.log("THE CORRECT TASK TITLE IS DISPLAYED.");
						log.info("THE CORRECT TASK TITLE IS DISPLAYED.");
					} else {
						TestUtil.captureScreenshot();

						// ReportNG
						Reporter.log("<br>" + " The task title is not displayed correctly : " + "<br>");
						Reporter.log("<a target=\"_blank\" href=" + TestUtil.screenshotName + "><img src="
								+ TestUtil.screenshotName + " height=200 width=200></img></a>");
						Reporter.log("<br>");
						Reporter.log("<br>");

						// Extent Report
						test.log(LogStatus.FAIL, " The task title is not displayed correctly : ");
						test.log(LogStatus.FAIL, test.addScreenCapture(TestUtil.screenshotName));

						System.out.println("The task title is not displayed correctly.");
						log.info("The task title is not displayed correctly.");
					}

				} catch (Throwable t) {
					TestUtil.captureScreenshot();

					// ReportNG
					Reporter.log("<br>" + " The task title is not displayed correctly : " + "<br>");
					Reporter.log("<a target=\"_blank\" href=" + TestUtil.screenshotName + "><img src="
							+ TestUtil.screenshotName + " height=200 width=200></img></a>");
					Reporter.log("<br>");
					Reporter.log("<br>");

					// Extent Report
					test.log(LogStatus.FAIL, " The task title is not displayed correctly : ");
					test.log(LogStatus.FAIL, test.addScreenCapture(TestUtil.screenshotName));

					System.out.println("The task title is not displayed correctly.");
					log.info("The task title is not displayed correctly.");

				}

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
				click("questionnaire_checklist_createdinspectioncovid19om_XPATH");
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

				// verify correct task title is displayed correct or not
				try {
					String taskTitle1 = driver.findElement(By.cssSelector(OR.getProperty("task_addtask_titletxt_CSS")))
							.getAttribute("value");

					if (taskTitle1.equals("Electrical (Light Fixture)")) {
						System.out.println("THE CORRECT TASK TITLE IS DISPLAYED.");
						test.log(LogStatus.INFO, "THE CORRECT TASK TITLE IS DISPLAYED.");
						Reporter.log("THE CORRECT TASK TITLE IS DISPLAYED.");
						log.info("THE CORRECT TASK TITLE IS DISPLAYED.");
					} else {
						TestUtil.captureScreenshot();

						// ReportNG
						Reporter.log("<br>" + " The task title is not displayed correctly : " + "<br>");
						Reporter.log("<a target=\"_blank\" href=" + TestUtil.screenshotName + "><img src="
								+ TestUtil.screenshotName + " height=200 width=200></img></a>");
						Reporter.log("<br>");
						Reporter.log("<br>");

						// Extent Report
						test.log(LogStatus.FAIL, " The task title is not displayed correctly : ");
						test.log(LogStatus.FAIL, test.addScreenCapture(TestUtil.screenshotName));

						System.out.println("The task title is not displayed correctly.");
						log.info("The task title is not displayed correctly.");
					}

				} catch (Throwable t) {
					TestUtil.captureScreenshot();

					// ReportNG
					Reporter.log("<br>" + " The task title is not displayed correctly : " + "<br>");
					Reporter.log("<a target=\"_blank\" href=" + TestUtil.screenshotName + "><img src="
							+ TestUtil.screenshotName + " height=200 width=200></img></a>");
					Reporter.log("<br>");
					Reporter.log("<br>");

					// Extent Report
					test.log(LogStatus.FAIL, " The task title is not displayed correctly : ");
					test.log(LogStatus.FAIL, test.addScreenCapture(TestUtil.screenshotName));

					System.out.println("The task title is not displayed correctly.");
					log.info("The task title is not displayed correctly.");

				}

				// scroll down the screen
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("window.scrollBy(0,500)");

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

			// click on the Home button
			click("questionnaire_homeburgermenubtn_hide_CSS");
			System.out.println("Clicked on the home button.");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Navigate to the Home Screen i.e. property listing screen.");

			// wait for the element
			explicitWait("propertylist_title_XPATH");

			// verify the property list
			switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

			// ADD COMMENT IN THE NEWLY CREATED TASK - OPERATION MANAGER

			System.out.println(
					"******************** ADD COMMENT IN THE NEWLY CREATED TASK - OPERATION MANAGER ********************");
			test.log(LogStatus.INFO,
					"******************** ADD COMMENT IN THE NEWLY CREATED TASK - OPERATION MANAGER ********************");
			Reporter.log(
					"******************** ADD COMMENT IN THE NEWLY CREATED TASK - OPERATION MANAGER ********************");
			log.info(
					"******************** ADD COMMENT IN THE NEWLY CREATED TASK - OPERATION MANAGER ********************");

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
				click("questionnaire_checklist_createdinspectioncovid19om_XPATH");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the searched inspection.");

				// click on the switch to wizard mode button
				click("checklist_classicviewbtn_CSS");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the switch to wizard mode button.");

				// click on the task tab
				click("inspectionchecklist_tasktab_XPATH");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the task tab.");

				// scroll down the screen
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("window.scrollBy(0,400)");

				// click on the newly created task
				click("inspectionchecklist_tasktagcreatedtask_XPATH");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the newly created task.");

				// scroll down the screen
				js.executeScript("window.scrollBy(0,400)");

				// click on the comment tab
				click("propertyproject_mu_addedrepair_taskcommenttab_CSS");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the comment tab.");

				// scroll down the screen
				js.executeScript("window.scrollBy(0,500)");

				// click on the add comment button
				click("task_addcommentbtn_CSS");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the add comment button.");

				// enter the text in the comment field
				type("task_addtask_commentstab_commenttxt_CSS", data.get("comment1"));
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Entered the text in the comment field.");

				// click on the add button for save the entered comment
				click("task_comment_addcommentbtn_CSS");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the add button for save the entered comment.");

				// wait for the element
				explicitWait("task_addtask_commentstab_savedcomment_capreitthree_XPATH");

				// verify the saved comment is displayed or not
				switchVerification("task_addtask_commentstab_savedcomment_capreitthree_XPATH",
						"Testing Purpose Comment Capreit Three",
						"The Testing Purpose Comment Capreit Three is not displayed.");

				// click on the update button
				click("survey_task_updatebtn_CSS");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the update button.");

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

			// LOGOUT FROM OPERATION MANAGER USER

			System.out.println("**************** LOGOUT FROM OPERATION MANAGER USER ****************");
			test.log(LogStatus.INFO, "**************** LOGOUT FROM OPERATION MANAGER USER ****************");
			Reporter.log("**************** LOGOUT FROM OPERATION MANAGER USER ****************");
			log.info("**************** LOGOUT FROM OPERATION MANAGER USER ****************");

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

			// LOGIN IN WITH RESPORTAL ENTRY USER

			System.out.println("**************** LOGIN IN WITH RESPORTAL ENTRY USER ****************");
			test.log(LogStatus.INFO, "**************** LOGIN IN WITH RESPORTAL ENTRY USER ****************");
			Reporter.log("**************** LOGIN IN WITH RESPORTAL ENTRY USER ****************");
			log.info("**************** LOGIN IN WITH RESPORTAL ENTRY USER ****************");

			// Enter the username
			ngDriver.waitForAngularRequestsToFinish();
			type("username_MODEL", data.get("username_2"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the username.");

			// Enter the password
			type("password_MODEL", data.get("password_2"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the password.");

			// Clicking on the "Sign In" button
			click("signinbtn_BTNTEXT");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the sign in button.");

			// wait for the element
			explicitWait("mytask_title_XPATH");

			// verify the property list
			switchVerification("mytask_title_XPATH", "Title", "The Title is not displayed.");

			// UPDATE THE SYSTEM COMPANY

			try {
				// wait for the 5 seconds
				Thread.sleep(5000);

				// click on the settings icon from the top of the screen
				click("questionnaire_settingicon_CSS");
				System.out.println("Clicked on the settings icon.");
				ngDriver.waitForAngularRequestsToFinish();

				// wait for the element
				Thread.sleep(5000);

				// click on the Switch System Company option from the side menu
				click("ssc_sidemenubtn_CSS");
				System.out.println("Clicked on the Switch System Company option from the side menu.");
				ngDriver.waitForAngularRequestsToFinish();

				// wait for the element
				Thread.sleep(5000);
				
				// click on the switch system company dropdown
				click("ssc_systemcompanydd_CSS");
				System.out.println("Clicked on the switch system company.");
				ngDriver.waitForAngularRequestsToFinish();

				// select the system company from the system company dropdown
				select("ssc_systemcompanydd_CSS", data.get("system_company_1"));
				System.out.println("The system company is selected successfully.");
				ngDriver.waitForAngularRequestsToFinish();

				// click on system company dropdown
				click("ssc_systemcompanydd_CSS");
				System.out.println("Clicked on the system company dropdown.");
				ngDriver.waitForAngularRequestsToFinish();

				// click on the select button
				click("ssc_selectbtn_BTNTEXT");
				System.out.println("Clicked on the select button.");
				ngDriver.waitForAngularRequestsToFinish();

				// wait for the element
				explicitWait("mytask_title_XPATH");

				// verify the property list
				switchVerification("mytask_title_XPATH", "Title", "The Title is not displayed.");

			} catch (Throwable t) {
				verificationFailed();
			}

			// ADD THE PO NUMBER IN THE NEWLY CREATED TASK - RESPORTAL ENTRY USER

			System.out.println(
					"**************** ADD THE PO NUMBER IN THE NEWLY CREATED TASK - RESPORTAL ENTRY USER ****************");
			test.log(LogStatus.INFO,
					"**************** ADD THE PO NUMBER IN THE NEWLY CREATED TASK - RESPORTAL ENTRY USER ****************");
			Reporter.log(
					"**************** ADD THE PO NUMBER IN THE NEWLY CREATED TASK - RESPORTAL ENTRY USER ****************");
			log.info(
					"**************** ADD THE PO NUMBER IN THE NEWLY CREATED TASK - RESPORTAL ENTRY USER ****************");

			try {

				// click on the clear button
				click("mytaskdashboard_createdtask_clearbtn_XPATH");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the clear button.");

				// enter newly created task in search field
				type("survey_task_searchfield_CSS", data.get("tasktag"));
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Entered newly created task in search field.");

				// click on the search button
				click("mytaskdashboard_createdtask_searchbtn_XPATH");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the search button.");

				// verify newly created task is displayed or not
				switchVerification("task_createdtask_rpecreatedtask_XPATH", "Electrical (Light Fixture)",
						"The Electrical (Light Fixture) is not displayed.");

				// click on the newly created task
				click("task_createdtask_rpecreatedtask_XPATH");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the newly created task.");

				// scroll down the screen
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("window.scrollBy(0,400)");

				// click on the po/warranty tab
				click("task_tasktag_powarrantytab_CSS");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the po/warranty tab.");

				// enter the po number
				type("task_tasktag_ponumber_CSS", data.get("task_ponumber"));
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Entered the po number.");

				// click on the update button
				click("survey_task_updatebtn_CSS");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the update button.");

			} catch (Throwable t) {
				verificationFailed();
			}

			// click on the home icon from the top of the screen
			click("questionnaire_homeburgermenubtn_hide_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the home icon from the top of the screen.");

			// wait for the element
			explicitWait("mytask_title_XPATH");

			// verify the property list
			switchVerification("mytask_title_XPATH", "Title", "The Title is not displayed.");

			// VERIFY NEWLY CREATED TASK IS DISPLAYED OR NOT - RESPORTAL ENTRY USER

			System.out.println(
					"**************** VERIFY NEWLY CREATED TASK IS DISPLAYED OR NOT - RESPORTAL ENTRY USER ****************");
			test.log(LogStatus.INFO,
					"**************** VERIFY NEWLY CREATED TASK IS DISPLAYED OR NOT - RESPORTAL ENTRY USER ****************");
			Reporter.log(
					"**************** VERIFY NEWLY CREATED TASK IS DISPLAYED OR NOT - RESPORTAL ENTRY USER ****************");
			log.info(
					"**************** VERIFY NEWLY CREATED TASK IS DISPLAYED OR NOT - RESPORTAL ENTRY USER ****************");

			try {

				// click on the clear button
				click("mytaskdashboard_createdtask_clearbtn_XPATH");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the clear button.");

				// enter newly created task in search field
				type("survey_task_searchfield_CSS", data.get("tasktag"));
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Entered newly created task in search field.");

				// click on the search button
				click("mytaskdashboard_createdtask_searchbtn_XPATH");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the search button.");

				// verify newly created task is displayed or not
				switchVerification("task_createdtask_rpecreatedtask_XPATH", "Electrical (Light Fixture)",
						"The Electrical (Light Fixture) is not displayed.");

				// VERIFY ADDED COMMENT IS DISPLAYED OR NOT

				System.out.println(
						"**************** VERIFY ADDED COMMENT IS DISPLAYED OR NOT - RESPORTAL ENTRY USER ****************");
				test.log(LogStatus.INFO,
						"**************** VERIFY ADDED COMMENT IS DISPLAYED OR NOT - RESPORTAL ENTRY USER ****************");
				Reporter.log(
						"**************** VERIFY ADDED COMMENT IS DISPLAYED OR NOT - RESPORTAL ENTRY USER ****************");
				log.info(
						"**************** VERIFY ADDED COMMENT IS DISPLAYED OR NOT - RESPORTAL ENTRY USER ****************");

				// click on the newly created task
				click("task_createdtask_rpecreatedtask_XPATH");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the newly created task.");

				// scroll down the screen
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("window.scrollBy(0,400)");

				// click on the comment tab
				click("propertyproject_mu_addedrepair_taskcommenttab_CSS");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the comment tab.");

				// scroll down the screen
				js.executeScript("window.scrollBy(0,500)");

				// verify the previously added task is displayed or not
				switchVerification("survey_task_createdtasktext3_XPATH", "Testing Purpose Comment Capreit Three",
						"The Testing Purpose Comment Capreit Three is not displayed.");

				// click on the add comment button
				click("task_addcommentbtn_CSS");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the add comment button.");

				// enter the text in the comment field
				type("task_addtask_commentstab_commenttxt_CSS", data.get("updated_comment1"));
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Entered the text in the comment field.");

				// click on the add button for save the entered comment
				click("task_comment_addcommentbtn_CSS");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the add button for save the entered comment.");

				// wait for the element
				explicitWait("task_addtask_savedcomment_capreitthree_rpe_XPATH");

				// verify the saved comment is displayed or not
				switchVerification("task_addtask_savedcomment_capreitthree_rpe_XPATH",
						"ResPortal Entry Testing Purpose Comment Capreit Three",
						"The ResPortal Entry Testing Purpose Comment Capreit Three is not displayed.");

				// click on the update button
				click("survey_task_updatebtn_CSS");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the update button.");

				// click on the back button
				click("task_backbtn2_CSS");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the back button.");

				// scroll up the screen
				js.executeScript("window.scrollBy(0,-500)");

				// click on the clear button
				click("mytaskdashboard_createdtask_clearbtn_XPATH");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the clear button.");

				// enter newly created task in search field
				type("survey_task_searchfield_CSS", data.get("tasktag"));
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Entered newly created task in search field.");

				// click on the search button
				click("mytaskdashboard_createdtask_searchbtn_XPATH");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the search button.");

				// verify newly created task is displayed or not
				switchVerification("task_createdtask_rpecreatedtask_XPATH", "Electrical (Light Fixture)",
						"The Electrical (Light Fixture) is not displayed.");

			} catch (Throwable t) {
				verificationFailed();
			}

			// COMPLETE THE NEWLY CREATED TASK - RESPORTAL ENTRY USER

			System.out.println(
					"**************** COMPLETE THE NEWLY CREATED TASK - RESPORTAL ENTRY USER ****************");
			test.log(LogStatus.INFO,
					"**************** COMPLETE THE NEWLY CREATED TASK - RESPORTAL ENTRY USER ***************");
			Reporter.log("**************** COMPLETE THE NEWLY CREATED TASK - RESPORTAL ENTRY USER ****************");
			log.info("**************** COMPLETE THE NEWLY CREATED TASK - RESPORTAL ENTRY USER ****************");

			try {
				// click on the newly created task
				click("task_createdtask_rpecreatedtask_XPATH");
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

				// scroll up the screen
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("window.scrollBy(0,-500)");

				// verify in progress status is display
				String inprogressStatus = driver
						.findElement(By.xpath(OR.getProperty("task_inprogress_statuslbl_XPATH"))).getText();
				String finalInprogressStatus = inprogressStatus.trim();
				switchVerification("task_inprogress_statuslbl_XPATH", finalInprogressStatus,
						"The " + finalInprogressStatus + " is not displayed.");

				// SET TASK AS A PENDING
				System.out.println("SET TASK AS A PENDING");
				test.log(LogStatus.INFO, "SET TASK AS A PENDING");
				Reporter.log("SET TASK AS A PENDING");
				log.info("SET TASK AS A PENDING");

				// click on the pending button
				click("task_pendingbtn_CSS");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the pending button.");

				// scroll up the screen
				js.executeScript("window.scrollBy(0,-500)");

				// verify in pending status is display
				String pendingStatus = driver.findElement(By.xpath(OR.getProperty("task_pendingstatus_XPATH")))
						.getText();
				String finalPendingStatus = pendingStatus.trim();
				switchVerification("task_pendingstatus_XPATH", finalPendingStatus,
						"The " + finalPendingStatus + " is not displayed.");

				// SET TASK AS A APPROVED
				System.out.println("SET TASK AS A APPROVED");
				test.log(LogStatus.INFO, "SET TASK AS A APPROVED");
				Reporter.log("SET TASK AS A APPROVED");
				log.info("SET TASK AS A APPROVED");

				// click on the start button
				click("propertyproject_mu_repair_startbtn_CSS");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the start button.");

				// click on the approve button
				click("task_approvebtn_CSS");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the approve button.");

				// scroll up the screen
				js.executeScript("window.scrollBy(0,-500)");

				// verify in approved status is display
				String approvedStatus = driver.findElement(By.xpath(OR.getProperty("task_approvedstatus_XPATH")))
						.getText();
				String finalApprovedStatus = approvedStatus.trim();
				switchVerification("task_approvedstatus_XPATH", finalApprovedStatus,
						"The " + finalApprovedStatus + " is not displayed.");

				// SET TASK AS A CLOSED
				System.out.println("SET TASK AS A CLOSED");
				test.log(LogStatus.INFO, "SET TASK AS A CLOSED");
				Reporter.log("SET TASK AS A CLOSED");
				log.info("SET TASK AS A CLOSED");

				// click on the close button
				click("task_closebtn_CSS");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the close button.");

				// wait for the element
				explicitWaitClickable("task_closebtn_yesbtn_CSS");

				// click on the yes button of the close task popup
				click("task_closebtn_yesbtn_CSS");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the yes button of the close task popup.");

				// scroll up the screen
				js.executeScript("window.scrollBy(0,-500)");

				// verify in approved status is display
				String closedStatus = driver.findElement(By.xpath(OR.getProperty("task_closedstatus_XPATH"))).getText();
				String finalClosedStatus = closedStatus.trim();
				switchVerification("task_closedstatus_XPATH", finalClosedStatus,
						"The " + finalClosedStatus + " is not displayed.");

				// click on the back button
				click("task_backbtn2_CSS");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the back button.");

			} catch (Throwable t) {
				verificationFailed();
			}

			// click on the home icon from the top of the screen
			click("questionnaire_homeburgermenubtn_hide_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the home icon from the top of the screen.");

			// wait for the element
			explicitWait("mytask_title_XPATH");

			// verify the property list
			switchVerification("mytask_title_XPATH", "Title", "The Title is not displayed.");

			// LOGOUT FROM THE RESPORTAL ENTRY USER

			System.out.println("**************** LOGOUT FROM THE RESPORTAL ENTRY USER ****************");
			test.log(LogStatus.INFO, "**************** LOGOUT FROM THE RESPORTAL ENTRY USER ****************");
			Reporter.log("**************** LOGOUT FROM THE RESPORTAL ENTRY USER ****************");
			log.info("**************** LOGOUT FROM THE RESPORTAL ENTRY USER ****************");

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

			// COMPLETE THE AUTO GENERATED TASK - OPERATION MANAGER USER

			System.out.println(
					"**************** COMPLETE THE AUTO GENERATED TASK - OPERATION MANAGER USER ****************");
			test.log(LogStatus.INFO,
					"**************** COMPLETE THE AUTO GENERATED TASK - OPERATION MANAGER USER ****************");
			Reporter.log("**************** COMPLETE THE AUTO GENERATED TASK - OPERATION MANAGER USER ****************");
			log.info("**************** COMPLETE THE AUTO GENERATED TASK - OPERATION MANAGER USER ****************");

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
				click("questionnaire_checklist_createdinspectioncovid19om_XPATH");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the searched inspection.");

				// click on the switch to wizard mode button
				click("checklist_classicviewbtn_CSS");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the switch to wizard mode button.");

				// click on the task tab
				click("inspectionchecklist_tasktab_XPATH");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the task tab.");

				// scroll down the screen
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("window.scrollBy(0,500)");

				// click on the auto generated task
				click("questionnaire_checklist_autogeneratedtask_capreit1om_XPATH");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the auto generated task.");

				// SET TASK AS A IN PROGRESS
				System.out.println("SET TASK AS A IN PROGRESS");
				test.log(LogStatus.INFO, "SET TASK AS A IN PROGRESS");
				Reporter.log("SET TASK AS A IN PROGRESS");
				log.info("SET TASK AS A IN PROGRESS");

				// wait for the element
				explicitWaitClickable("propertyproject_mu_repair_startbtn_CSS");

				// click on the start button
				click("propertyproject_mu_repair_startbtn_CSS");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the start button.");

				// SET TASK AS A PENDING
				System.out.println("SET TASK AS A PENDING");
				test.log(LogStatus.INFO, "SET TASK AS A PENDING");
				Reporter.log("SET TASK AS A PENDING");
				log.info("SET TASK AS A PENDING");

				// wait for the element
				explicitWaitClickable("task_pendingbtn_CSS");

				// click on the pending button
				click("task_pendingbtn_CSS");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the pending button.");

				// SET TASK AS A APPROVED
				System.out.println("SET TASK AS A APPROVED");
				test.log(LogStatus.INFO, "SET TASK AS A APPROVED");
				Reporter.log("SET TASK AS A APPROVED");
				log.info("SET TASK AS A APPROVED");

				// wait for the element
				explicitWaitClickable("propertyproject_mu_repair_startbtn_CSS");

				// click on the start button
				click("propertyproject_mu_repair_startbtn_CSS");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the start button.");

				// wait for the element
				explicitWaitClickable("task_approvebtn_CSS");

				// click on the approve button
				click("task_approvebtn_CSS");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the approve button.");

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
				click("task_autotask_approvedlbl_actionicon_report3_XPATH");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the action icon of the approved task.");

				// click on the complete task option
				click("task_autotask_approvedlbl_actionicon_closeoption_report3_XPATH");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the complete task option.");

				// verify in closed status is display
				switchVerification("task_autotask_closedlbl_report3_XPATH", "Closed",
						"The closed status is not displayed.");

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

			// DELETE THE LINKED TASKS - OPERATION MANAGER USER

			System.out.println("**************** DELETE THE LINKED TASKS - OPERATION MANAGER USER ****************");
			test.log(LogStatus.INFO,
					"**************** DELETE THE LINKED TASKS - OPERATION MANAGER USER ****************");
			Reporter.log("**************** DELETE THE LINKED TASKS - OPERATION MANAGER USER ****************");
			log.info("**************** DELETE THE LINKED TASKS - OPERATION MANAGER USER ****************");

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
				type("task_listofchecklist_filterfield_CSS", data.get("checklist_property_title"));
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Entered newly created inspection in the search field.");

				// click on the searched inspection
				click("questionnaire_checklist_createdinspectioncovid19om_XPATH");
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

				// click on the action icon of the task
				click("task_autotask1_actionicon_report3_XPATH");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the action icon of the approved task.");

				// click on the reopen option
				click("task_autotask_actionicon_reopenoption_report3_XPATH");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the reopen option.");

				// wait for the element
				explicitWaitClickable("closetoastmsg_CSS");

				// click on the toaster close button
				click("closetoastmsg_CSS");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the toaster close button.");

				// click on the action icon of the task
				click("task_autotask1_actionicon_report3_XPATH");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the action icon of the approved task.");

				// wait for the element
				Thread.sleep(5000);
				
				// click on the delete button
				click("task_autotask_actionicon_deleteoption_report3_XPATH");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the delete button.");

				// wait for the element
				explicitWaitClickable("closetoastmsg_CSS");

				// click on the toaster close button
				click("closetoastmsg_CSS");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the toaster close button.");

				// click on the action icon of the task
				click("task_addtask_actionicon_XPATH");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the action icon of the approved task.");

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

				// click on the action icon of the task
				click("task_addtask_actionicon_XPATH");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the action icon of the approved task.");

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
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the home icon from the top of the screen.");

			// wait for the element
			explicitWait("propertylist_title_XPATH");

			// verify the property list
			switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

			// DELETE THE INSTANCE

			System.out.println("**************** DELETE THE INSTANCE - OPERATION MANAGER USER ****************");
			test.log(LogStatus.INFO, "**************** DELETE THE INSTANCE - OPERATION MANAGER USER ****************");
			Reporter.log("**************** DELETE THE INSTANCE - OPERATION MANAGER USER ****************");
			log.info("**************** DELETE THE INSTANCE - OPERATION MANAGER USER ****************");

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

				// verify deleted inspection
				deleteVerification("questionnaire_checklist_createdinspectioncovid19om_XPATH",
						"Test Questionnaire Property Title Smoke Capreit Three");

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
