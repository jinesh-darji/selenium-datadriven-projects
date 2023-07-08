package testcases.smokesuite;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Date;
import java.util.Hashtable;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;
import org.testng.SkipException;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import base.TestBase;
import utilities.TestUtil;

public class RR5490Capreit1Test extends TestBase {

	@Test(dataProviderClass = TestUtil.class, dataProvider = "dp")
	public void rR5490Capreit1Test(Hashtable<String, String> data) throws IOException, InterruptedException {

		execution(data, "rR5490Capreit1Test");

		// refresh the page
		driver.navigate().refresh();
		Thread.sleep(5000);
		driver.navigate().refresh();

		String finalNotAvailableCount1 = null;
		String finalNotApplicableCount1 = null;
		String finalOverDueTaskCount1 = null;
		String finalNotAvailableCount2 = null;
		String finalNotApplicableCount2 = null;
		String finalOverDueTaskCount2 = null;

		// CAPREIT : TEST SCENARIOS RELATED TO THE ENVIRONMENTAL - DOCUMENT MANAGEMENT
		title("CAPREIT : TEST SCENARIOS RELATED TO THE ENVIRONMENTAL - DOCUMENT MANAGEMENT");

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

		// SET THE ENVIRONMENTAL REPORT FREQUENCY - SUPER ADMIN USER
		title("SET THE ENVIRONMENTAL REPORT FREQUENCY - SUPER ADMIN USER");

		try {

			// wait for the 5 seconds
			Thread.sleep(5000);

			// click on the settings icon from the top of the screen
			click("questionnaire_settingicon_CSS");

			// wait for the element
			explicitWaitClickable("questionnaire_administrationoption_XPATH");

			// click on the administration option from the side menu
			click("questionnaire_administrationoption_XPATH");

			// click on the environmental tab
			click("questionnaire_environmentaltab_XPATH");

			// click on the environmental reports option
			click("questionnaire_environmentalreportsoption_XPATH");

			// scroll down to the screen
			scrollTillElement("environmental_reportlist_environmentalactionreporttext_dropdown_XPATH");
			scrollByPixel(-400);

			// click on the drop down of the Environmental Action Report report
			click("environmental_reportlist_environmentalactionreporttext_dropdown_XPATH");

			// click on the other options option
			click("environmental_reportlist_environmentalactionreporttext_dropdown_otheroption_XPATH");

			// select the level of the environmental report
			select("envreport_leveldd_CSS", data.get("document_reference"));

			// enter the data in the report frequency field
			type("environmental_reportlist_environmentalactionreporttext_reportfrequencytxt_CSS", "1");

			// select the year option from the report period drop down
			select("environmental_reportlist_environmentalactionreporttext_reportPerioddd_CSS", "Year");

			// click on the save button
			click("environmental_reportlist_environmentalactionreporttext_savebtn_XPATH");

			// wait for the element
			explicitWaitClickable("closetoastmsg_CSS");

			// click on the toaster close button
			click("closetoastmsg_CSS");

		} catch (Throwable t) {
			verificationFailed();
		}

		// click on the home icon from the top of the screen
		click("questionnaire_homeburgermenubtn_CSS");

		// synchronization
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// RUN THE BATCH PROCESS FOR THE ENVIRONMENTAL REPORTS - SUPER ADMIN USER
		title("RUN THE BATCH PROCESS FOR THE ENVIRONMENTAL REPORTS - SUPER ADMIN USER");

		try {
			// wait for the 5 seconds
			Thread.sleep(5000);

			// click on the settings icon from the top of the screen
			click("questionnaire_settingicon_CSS");

			// wait for the element
			explicitWaitClickable("questionnaire_administrationoption_XPATH");

			// click on the administration option from the side menu
			click("questionnaire_administrationoption_XPATH");

			// click on the system tab
			click("questionnaire_systemtab_XPATH");

			// click on the batch process option
			click("questionnaire_batchprocessoption_XPATH");

			// enter batch process name in the search field

			type("ssc_company2_securitysettings_filtertxt_CSS", data.get("batch_process"));

			// click on the play button of searched batch process
			click("batchprocess_environmentalreport_playbtn_XPATH");

			// click on the run button
			click("batchprocess_environmentalreport_runbtn_XPATH");

			// wait for the element
			explicitWaitClickable("closetoastmsg_CSS");

			// click on the toaster close button
			click("closetoastmsg_CSS");

		} catch (Throwable t) {
			verificationFailed();
		}

		// click on the home icon from the top of the screen
		click("questionnaire_homeburgermenubtn_CSS");

		// synchronization
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// VERIFY ENVIRONMENTAL CARD ON THE PORTFOLIO SUMMARY DASHBOARD SCREEN AFTER
		// SETUP THE CONFIGURATION - SUPER ADMIN USER
		title("VERIFY ENVIRONMENTAL CARD ON THE PORTFOLIO SUMMARY DASHBOARD SCREEN AFTER SETUP THE CONFIGURATION - SUPER ADMIN USER");

		try {

			// wait for the element
			Thread.sleep(5000);

			// click on the side menu
			click("menubtn_CSS");

			// wait for the element
			Thread.sleep(5000);

			// click on the portfolio summary option
			click("sidemenu_portfoliosummary_XPATH");

			try {
				// scroll down the screen
				scrollTillElement("portfoliodashboard_environmentalactionreportcard_XPATH");
				scrollByPixel(-200);

				switchVerification("portfoliodashboard_environmentalactionreportcard_XPATH",
						"Environmental Action Report", "The Environmental Action Report is not displayed.");

				String notAvailableCount1 = driver
						.findElement(By.cssSelector(OR.getProperty("environmental_notavailablecount_CSS"))).getText();

				finalNotAvailableCount1 = notAvailableCount1.trim();

				String notApplicableCount1 = driver
						.findElement(By.cssSelector(OR.getProperty("environmental_notapplicablecount_CSS"))).getText();

				finalNotApplicableCount1 = notApplicableCount1.trim();

				String overDueTaskCount1 = driver
						.findElement(By.cssSelector(OR.getProperty("environmental_overduetaskcount_CSS"))).getText();

				finalOverDueTaskCount1 = overDueTaskCount1.trim();

			} catch (Throwable t) {

				verificationFailedMessage(
						"The Environmental Action Report environmental card is not displayed even if the setup the configuration");
			}

		} catch (Throwable t) {
			verificationFailed();
		}

		// click on the home icon from the top of the screen
		click("questionnaire_homeburgermenubtn_hide_CSS");

		// synchronization
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// VERIFY ENVIRONMENTAL CARD ON THE ASSESSMENTS/INSPECTIONS DASHBOARD OF THE
		// ENVIRONMENTAL MODULE AFTER SETUP THE CONFIGURATION - SUPER ADMIN USER
		title("VERIFY ENVIRONMENTAL CARD ON THE ASSESSMENTS/INSPECTIONS DASHBOARD OF THE ENVIRONMENTAL MODULE AFTER SETUP THE CONFIGURATION - SUPER ADMIN USER");

		try {

			// wait for the element
			Thread.sleep(5000);

			// click on the side menu
			click("menubtn_CSS");

			// wait for the element
			Thread.sleep(5000);

			// click on the environmental option
			click("sidemenu_environmental_XPATH");

			// select the Assessments/Inspections option from the dashbaord drop down
			select("dashboard_CSS", data.get("dashboard_2"));

			// wait for the 3 seconds
			Thread.sleep(3000);

			try {
				// scroll down the screen
				scrollTillElement("portfoliodashboard_environmentalactionreportcard_XPATH");
				scrollByPixel(-200);

				switchVerification("portfoliodashboard_environmentalactionreportcard_XPATH",
						"Environmental Action Report", "The Environmental Action Report is not displayed.");

				String notAvailableCount2 = driver
						.findElement(By.cssSelector(OR.getProperty("environmental_notavailablecount_CSS"))).getText();

				finalNotAvailableCount2 = notAvailableCount2.trim();

				String notApplicableCount2 = driver
						.findElement(By.cssSelector(OR.getProperty("environmental_notapplicablecount_CSS"))).getText();

				finalNotApplicableCount2 = notApplicableCount2.trim();

				String overDueTaskCount2 = driver
						.findElement(By.cssSelector(OR.getProperty("environmental_overduetaskcount_CSS"))).getText();

				finalOverDueTaskCount2 = overDueTaskCount2.trim();

			} catch (Throwable t) {

				verificationFailedMessage(
						"The Environmental Action Report environmental card is not displayed even if the setup the configuration.");
			}

		} catch (Throwable t) {
			verificationFailed();
		}

		// click on the home icon from the top of the screen
		click("questionnaire_homeburgermenubtn_hide_CSS");

		// synchronization
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// CREATE ENVIRONMENTAL REPORT - SUPER ADMIN USER
		title("CREATE ENVIRONMENTAL REPORT - SUPER ADMIN USER");

		try {

			// enter the property name in the search field
			type("envreports_propertylist_filtertxt_CSS", data.get("property_1"));

			// click on the environmental icon
			click("environmentalicon_CSS");

			// wait for the element
			Thread.sleep(5000);

			// click on the side menu
			click("ssc_leftsidemenubtn_CSS");

			// wait for the element
			Thread.sleep(5000);

			// click on the environmental report
			click("envreportoption_XPATH");

			// click on the add button
			click("envreportaddbtn_CSS");

			// select the checklist from the type dropdown
			select("envreporttypedd_CSS", data.get("type"));

			// enter unique reference number
			type("envreportuniquereferencedd_CSS", data.get("unique_reference"));

			// enter the title
			type("envreporttitletxt_CSS", data.get("title"));

			// scroll down the screen

			scrollByPixel(400);

			// click on the date field
			click("envreportdatetxt_CSS");

			// click on the today button
			click("envreporttodaydate_BTNTEXT");

			// click on the save report button
			click("envreportsavebtn_CSS");

			// wait for the element
			explicitWaitClickable("closetoastmsg_CSS");

			// click on the toaster close button
			click("closetoastmsg_CSS");

			// wait for the element
			Thread.sleep(5000);

			// enter the newly created environmental report in the search field

			type("task_listofchecklist_filterfield_CSS", data.get("title"));

			// verify the newly created environmental report is displayed or not
			switchVerification("environmental_searchedreport1_XPATH", "Test Environmental Report Count 1",
					"The Test Environmental Report Count 1 is not displayed.");

		} catch (Throwable t) {
			verificationFailed();
		}

		// click on the home icon from the top of the screen
		click("questionnaire_homeburgermenubtn_hide_CSS");

		// synchronization
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// VERIFY ENVIRONMENTAL CARD ON THE PORTFOLIO SUMMARY DASHBOARD SCREEN AFTER
		// CREATING THE NEW ENVIRONMENTAL REPORT - SUPER ADMIN USER
		title("VERIFY ENVIRONMENTAL CARD ON THE PORTFOLIO SUMMARY DASHBOARD SCREEN AFTER CREATING THE NEW ENVIRONMENTAL REPORT - SUPER ADMIN USER");

		try {

			// wait for the element
			Thread.sleep(5000);

			// click on the side menu
			click("menubtn_CSS");

			// wait for the element
			Thread.sleep(5000);

			// click on the portfolio summary option
			click("sidemenu_portfoliosummary_XPATH");

			try {
				// scroll down the screen

				scrollTillElement("portfoliodashboard_environmentalactionreportcard_XPATH");
				scrollByPixel(-200);

				switchVerification("portfoliodashboard_environmentalactionreportcard_XPATH",
						"Environmental Action Report", "The Environmental Action Report is not displayed.");

				try {
					String notAvailableCount11 = driver
							.findElement(By.cssSelector(OR.getProperty("environmental_notavailablecount_CSS")))
							.getText();

					String finalNotAvailableCount11 = notAvailableCount11.trim();

					int value1 = Integer.parseInt(finalNotAvailableCount1);
					int value2 = Integer.parseInt(finalNotAvailableCount11);

					if (value1 == (value2 + 1)) {
						successMessage("NOT AVAILABLE COUNT OF THE ENVIRONMENTAL ACTION REPORT IS DISPLAYED CORRECT.");
					} else {
						verificationFailedMessage(
								"NOT AVAILABLE COUNT OF THE ENVIRONMENTAL ACTION REPORT IS NOT DISPLAYED CORRECT.");
					}
				} catch (Throwable t) {
					verificationFailed();
				}

				try {
					String notApplicableCount11 = driver
							.findElement(By.cssSelector(OR.getProperty("environmental_notapplicablecount_CSS")))
							.getText();

					String finalNotApplicableCount11 = notApplicableCount11.trim();

					int value1_1 = Integer.parseInt(finalNotApplicableCount1);
					int value2_1 = Integer.parseInt(finalNotApplicableCount11);

					if (value1_1 == value2_1) {
						successMessage("NOT APPLICABLE COUNT OF THE ENVIRONMENTAL ACTION REPORT IS DISPLAYED CORRECT.");

					} else {
						verificationFailedMessage(
								"NOT APPLICABLE COUNT OF THE ENVIRONMENTAL ACTION REPORT IS NOT DISPLAYED CORRECT.");
					}
				} catch (Throwable t) {
					verificationFailed();
				}

				try {
					String overDueTaskCount11 = driver
							.findElement(By.cssSelector(OR.getProperty("environmental_overduetaskcount_CSS")))
							.getText();

					String finalOverDueTaskCount11 = overDueTaskCount11.trim();

					int value1_11 = Integer.parseInt(finalOverDueTaskCount1);
					int value2_11 = Integer.parseInt(finalOverDueTaskCount11);

					if (value1_11 == value2_11) {
						successMessage("OVERDUE TASK COUNT OF THE ENVIRONMENTAL ACTION REPORT IS DISPLAYED CORRECT.");

					} else {
						verificationFailedMessage(
								"OVERDUE TASK COUNT OF THE ENVIRONMENTAL ACTION REPORT IS NOT DISPLAYED CORRECT.");
					}
				} catch (Throwable t) {
					verificationFailed();
				}

				try {
					// click on the graph of the environmental action report
					click("portfolio_environmentalactionreport_graph_XPATH");

					// enter the property name in the search field
					type("users_filtertxt_CSS", data.get("property_1"));

					boolean greenDot1 = driver
							.findElement(By.xpath(OR.getProperty("portfolio_environmentalactionreport_greendot_XPATH")))
							.isDisplayed();

					if (greenDot1 == true) {
						successMessage("THE GREEN COLOR DOT INDICATION IS DISPLAYED CORRECTLY.");
					} else {
						verificationFailedMessage("THE GREEN COLOR DOT INDICATION IS NOT DISPLAYED.");
					}

				} catch (Throwable t) {
					verificationFailed();
				}

			} catch (Throwable t) {

				verificationFailedMessage("The Environmental Action Report environmental card is not displayed");
			}

		} catch (Throwable t) {
			verificationFailed();
		}

		// click on the home icon from the top of the screen
		click("questionnaire_homeburgermenubtn_hide_CSS");

		// synchronization
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// VERIFY ENVIRONMENTAL CARD ON THE ASSESSMENTS/INSPECTIONS DASHBOARD OF THE
		// ENVIRONMENTAL MODULE AFTER CREATING THE NEW ENVIRONMENTAL REPORT - SUPER
		// ADMIN USER
		title("VERIFY ENVIRONMENTAL CARD ON THE ASSESSMENTS/INSPECTIONS DASHBOARD OF THE ENVIRONMENTAL MODULE AFTER CREATING THE NEW ENVIRONMENTAL REPORT - SUPER ADMIN USER");

		try {

			// wait for the element
			Thread.sleep(5000);

			// click on the side menu
			click("menubtn_CSS");

			// wait for the element
			Thread.sleep(5000);

			// click on the environmental option
			click("sidemenu_environmental_XPATH");

			// select the Assessments/Inspections option from the dashbaord drop down
			select("dashboard_CSS", data.get("dashboard_2"));

			// wait for the 3 seconds
			Thread.sleep(3000);

			try {
				// scroll down the screen

				scrollTillElement("portfoliodashboard_environmentalactionreportcard_XPATH");
				scrollByPixel(-200);

				switchVerification("portfoliodashboard_environmentalactionreportcard_XPATH",
						"Environmental Action Report", "The Environmental Action Report is not displayed.");

				try {
					String notAvailableCount22 = driver
							.findElement(By.cssSelector(OR.getProperty("environmental_notavailablecount_CSS")))
							.getText();

					String finalNotAvailableCount22 = notAvailableCount22.trim();

					int value1_2 = Integer.parseInt(finalNotAvailableCount2);
					int value2_2 = Integer.parseInt(finalNotAvailableCount22);

					if (value1_2 == (value2_2 + 1)) {
						successMessage("NOT AVAILABLE COUNT OF THE ENVIRONMENTAL ACTION REPORT IS DISPLAYED CORRECT.");
					} else {
						verificationFailedMessage(
								"NOT AVAILABLE COUNT OF THE ENVIRONMENTAL ACTION REPORT IS NOT DISPLAYED CORRECT.");
					}
				} catch (Throwable t) {
					verificationFailed();
				}

				try {
					String notApplicableCount22 = driver
							.findElement(By.cssSelector(OR.getProperty("environmental_notapplicablecount_CSS")))
							.getText();

					String finalNotApplicableCount22 = notApplicableCount22.trim();

					int value1_22 = Integer.parseInt(finalNotApplicableCount2);
					int value2_22 = Integer.parseInt(finalNotApplicableCount22);

					if (value1_22 == value2_22) {
						successMessage("NOT APPLICABLE COUNT OF THE ENVIRONMENTAL ACTION REPORT IS DISPLAYED CORRECT.");
					} else {
						verificationFailedMessage(
								"NOT APPLICABLE COUNT OF THE ENVIRONMENTAL ACTION REPORT IS NOT DISPLAYED CORRECT.");
					}
				} catch (Throwable t) {
					verificationFailed();
				}

				try {
					String overDueTaskCount22 = driver
							.findElement(By.cssSelector(OR.getProperty("environmental_overduetaskcount_CSS")))
							.getText();

					String finalOverDueTaskCount22 = overDueTaskCount22.trim();

					int value1_222 = Integer.parseInt(finalOverDueTaskCount2);
					int value2_222 = Integer.parseInt(finalOverDueTaskCount22);

					if (value1_222 == value2_222) {
						successMessage("OVERDUE TASK COUNT OF THE ENVIRONMENTAL ACTION REPORT IS DISPLAYED CORRECT.");

					} else {
						verificationFailedMessage(
								"OVERDUE TASK COUNT OF THE ENVIRONMENTAL ACTION REPORT IS NOT DISPLAYED CORRECT.");
					}
				} catch (Throwable t) {
					verificationFailed();
				}

				try {
					// click on the graph of the environmental action report
					click("portfolio_environmentalactionreport_graph_XPATH");

					// enter the property name in the search field
					type("users_filtertxt_CSS", data.get("property_1"));

					boolean greenDot2 = driver
							.findElement(By.xpath(OR.getProperty("portfolio_environmentalactionreport_greendot_XPATH")))
							.isDisplayed();

					if (greenDot2 == true) {
						successMessage("THE GREEN COLOR DOT INDICATION IS DISPLAYED CORRECTLY.");

					} else {
						verificationFailedMessage("THE GREEN COLOR DOT INDICATION IS NOT DISPLAYED.");
					}

				} catch (Throwable t) {
					verificationFailed();
				}

			} catch (Throwable t) {

				verificationFailedMessage("The Environmental Action Report environmental card is not displayed");
			}

		} catch (Throwable t) {
			verificationFailed();
		}

		// click on the home icon from the top of the screen
		click("questionnaire_homeburgermenubtn_hide_CSS");

		// synchronization
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// UPDATE THE ENVIRONMENTAL REPORT DATE TO PAST DATE - SUPER ADMIN USER
		title("UPDATE THE ENVIRONMENTAL REPORT DATE TO PAST DATE - SUPER ADMIN USER");

		try {

			// enter the property name in the search field
			type("envreports_propertylist_filtertxt_CSS", data.get("property_1"));

			// click on the environmental icon
			click("environmentalicon_CSS");

			// wait for the element
			Thread.sleep(5000);

			// click on the side menu
			click("ssc_leftsidemenubtn_CSS");

			// wait for the element
			Thread.sleep(5000);

			// click on the environmental report
			click("envreportoption_XPATH");

			// enter environmental report in the search field

			type("task_listofchecklist_filterfield_CSS", data.get("title"));

			// click on the environmental report
			click("environmental_searchedreport1_XPATH");

			// scroll down the screen

			scrollByPixel(400);

			// update the date
			LocalDate pastDate = LocalDate.now().minusYears(1).minusDays(3);

			String expectedPastDate = pastDate.toString();

			// enter the updated date in the next assessment date field
			type("envreportnextassessmentdatetxt_CSS", expectedPastDate);

			// enter the updated date in the date field
			type("envreportdatetxt_CSS", expectedPastDate);

			// click on the update button
			click("envreportupdatebtn_CSS");

			// wait for the element
			explicitWaitClickable("closetoastmsg_CSS");

			// click on the toaster close button
			click("closetoastmsg_CSS");

			// enter the newly created environmental report in the search field

			type("task_listofchecklist_filterfield_CSS", data.get("title"));

			// verify the newly created environmental report is displayed or not
			switchVerification("environmental_searchedreport1_XPATH", "Test Environmental Report Count 1",
					"The Test Environmental Report Count 1 is not displayed.");

			// verify updated date is displayed correctly or not
			try {

				String pastDateXpath = "//span[text()='Test Environmental Report Count 1']//parent::td[@ng-click='editRecord(document)']//following-sibling::td//span[text()='"
						+ expectedPastDate + "']";

				String updatedPastDate = driver.findElement(By.xpath(pastDateXpath)).getText();

				if (expectedPastDate.equals(updatedPastDate)) {
					successMessage("THE UPDATED DATE IS DISPLAYED CORRECTLY.");
				} else {
					verificationFailedMessage("THE UPDATED DATE IS NOT DISPLAYED CORRECTLY.");
				}
			} catch (Throwable t) {
				verificationFailed();
			}

		} catch (Throwable t) {
			verificationFailed();
		}

		// click on the home icon from the top of the screen
		click("questionnaire_homeburgermenubtn_hide_CSS");

		// synchronization
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// VERIFY ENVIRONMENTAL CARD ON THE PORTFOLIO SUMMARY DASHBOARD SCREEN AFTER
		// UPDATING THE DATE TO PAST DATE OF THE ENVIRONMENTAL REPORT - SUPER ADMIN USER
		title("VERIFY ENVIRONMENTAL CARD ON THE PORTFOLIO SUMMARY DASHBOARD SCREEN AFTER UPDATING THE DATE TO PAST DATE OF THE ENVIRONMENTAL REPORT - SUPER ADMIN USER");

		try {

			// wait for the element
			Thread.sleep(5000);

			// click on the side menu
			click("menubtn_CSS");

			// wait for the element
			Thread.sleep(5000);

			// click on the portfolio summary option
			click("sidemenu_portfoliosummary_XPATH");

			try {
				// scroll down the screen

				scrollTillElement("portfoliodashboard_environmentalactionreportcard_XPATH");
				scrollByPixel(-200);

				switchVerification("portfoliodashboard_environmentalactionreportcard_XPATH",
						"Environmental Action Report", "The Environmental Action Report is not displayed.");

				try {
					String notAvailableCount11_past = driver
							.findElement(By.cssSelector(OR.getProperty("environmental_notavailablecount_CSS")))
							.getText();

					String finalNotAvailableCount11_past = notAvailableCount11_past.trim();

					int value1_past = Integer.parseInt(finalNotAvailableCount1);
					int value2_past = Integer.parseInt(finalNotAvailableCount11_past);

					if (value1_past == value2_past) {
						successMessage("NOT AVAILABLE COUNT OF THE ENVIRONMENTAL ACTION REPORT IS DISPLAYED CORRECT.");
					} else {
						verificationFailedMessage(
								"NOT AVAILABLE COUNT OF THE ENVIRONMENTAL ACTION REPORT IS NOT DISPLAYED CORRECT.");
					}
				} catch (Throwable t) {
					verificationFailed();
				}

				try {
					String notApplicableCount11_past = driver
							.findElement(By.cssSelector(OR.getProperty("environmental_notapplicablecount_CSS")))
							.getText();

					String finalNotApplicableCount11_past = notApplicableCount11_past.trim();

					int value1_1_past = Integer.parseInt(finalNotApplicableCount1);
					int value2_1_past = Integer.parseInt(finalNotApplicableCount11_past);

					if (value1_1_past == value2_1_past) {
						successMessage("NOT APPLICABLE COUNT OF THE ENVIRONMENTAL ACTION REPORT IS DISPLAYED CORRECT.");

					} else {
						verificationFailedMessage(
								"NOT APPLICABLE COUNT OF THE ENVIRONMENTAL ACTION REPORT IS NOT DISPLAYED CORRECT.");
					}
				} catch (Throwable t) {
					verificationFailed();
				}

				try {
					String overDueTaskCount11_past = driver
							.findElement(By.cssSelector(OR.getProperty("environmental_overduetaskcount_CSS")))
							.getText();

					String finalOverDueTaskCount11_past = overDueTaskCount11_past.trim();

					int value1_11_past = Integer.parseInt(finalOverDueTaskCount1);
					int value2_11_past = Integer.parseInt(finalOverDueTaskCount11_past);

					if (value1_11_past == value2_11_past) {
						successMessage("OVERDUE TASK COUNT OF THE ENVIRONMENTAL ACTION REPORT IS DISPLAYED CORRECT.");
					} else {
						verificationFailedMessage(
								"OVERDUE TASK COUNT OF THE ENVIRONMENTAL ACTION REPORT IS NOT DISPLAYED CORRECT.");
					}
				} catch (Throwable t) {
					verificationFailed();
				}

				try {
					// click on the graph of the environmental action report
					click("portfolio_environmentalactionreport_graph_XPATH");

					// enter the property name in the search field
					type("users_filtertxt_CSS", data.get("property_1"));

					boolean orangeDot1_past = driver
							.findElement(
									By.xpath(OR.getProperty("portfolio_environmentalactionreport_orangedot_XPATH")))
							.isDisplayed();

					if (orangeDot1_past == true) {
						successMessage("THE ORANGE COLOR DOT INDICATION IS DISPLAYED CORRECTLY.");
					} else {
						verificationFailedMessage("THE ORANGE COLOR DOT INDICATION IS NOT DISPLAYED.");
					}

				} catch (Throwable t) {
					verificationFailed();
				}

			} catch (Throwable t) {

				verificationFailedMessage("The Environmental Action Report environmental card is not displayed");
			}

		} catch (Throwable t) {
			verificationFailed();
		}

		// click on the home icon from the top of the screen
		click("questionnaire_homeburgermenubtn_hide_CSS");

		// synchronization
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// VERIFY ENVIRONMENTAL CARD ON THE ASSESSMENTS/INSPECTIONS DASHBOARD OF THE
		// ENVIRONMENTAL MODULE AFTER UPDATING THE DATE TO PAST DATE OF THE
		// ENVIRONMENTAL REPORT - SUPER ADMIN USER
		title("VERIFY ENVIRONMENTAL CARD ON THE ASSESSMENTS/INSPECTIONS DASHBOARD OF THE ENVIRONMENTAL MODULE AFTER UPDATING THE DATE TO PAST DATE OF THE ENVIRONMENTAL REPORT - SUPER ADMIN USER");

		try {

			// wait for the element
			Thread.sleep(5000);

			// click on the side menu
			click("menubtn_CSS");

			// wait for the element
			Thread.sleep(5000);

			// click on the environmental option
			click("sidemenu_environmental_XPATH");

			// select the Assessments/Inspections option from the dashbaord drop down
			select("dashboard_CSS", data.get("dashboard_2"));

			// wait for the 3 seconds
			Thread.sleep(3000);

			try {
				// scroll down the screen

				scrollTillElement("portfoliodashboard_environmentalactionreportcard_XPATH");
				scrollByPixel(-200);

				switchVerification("portfoliodashboard_environmentalactionreportcard_XPATH",
						"Environmental Action Report", "The Environmental Action Report is not displayed.");

				try {
					String notAvailableCount22_past = driver
							.findElement(By.cssSelector(OR.getProperty("environmental_notavailablecount_CSS")))
							.getText();

					String finalNotAvailableCount22_past = notAvailableCount22_past.trim();

					int value1_2_past = Integer.parseInt(finalNotAvailableCount2);
					int value2_2_past = Integer.parseInt(finalNotAvailableCount22_past);

					if (value1_2_past == value2_2_past) {
						successMessage("NOT AVAILABLE COUNT OF THE ENVIRONMENTAL ACTION REPORT IS DISPLAYED CORRECT.");
					} else {
						verificationFailedMessage(
								"NOT AVAILABLE COUNT OF THE ENVIRONMENTAL ACTION REPORT IS NOT DISPLAYED CORRECT.");
					}
				} catch (Throwable t) {
					verificationFailed();
				}

				try {
					String notApplicableCount22_past = driver
							.findElement(By.cssSelector(OR.getProperty("environmental_notapplicablecount_CSS")))
							.getText();

					String finalNotApplicableCount22_past = notApplicableCount22_past.trim();

					int value1_22_past = Integer.parseInt(finalNotApplicableCount2);
					int value2_22_past = Integer.parseInt(finalNotApplicableCount22_past);

					if (value1_22_past == value2_22_past) {
						successMessage("NOT APPLICABLE COUNT OF THE ENVIRONMENTAL ACTION REPORT IS DISPLAYED CORRECT.");
					} else {
						verificationFailedMessage(
								"NOT APPLICABLE COUNT OF THE ENVIRONMENTAL ACTION REPORT IS NOT DISPLAYED CORRECT.");
					}
				} catch (Throwable t) {
					verificationFailed();
				}

				try {
					String overDueTaskCount22_past = driver
							.findElement(By.cssSelector(OR.getProperty("environmental_overduetaskcount_CSS")))
							.getText();

					String finalOverDueTaskCount22_past = overDueTaskCount22_past.trim();

					int value1_222_past = Integer.parseInt(finalOverDueTaskCount2);
					int value2_222_past = Integer.parseInt(finalOverDueTaskCount22_past);

					if (value1_222_past == value2_222_past) {
						successMessage("OVERDUE TASK COUNT OF THE ENVIRONMENTAL ACTION REPORT IS DISPLAYED CORRECT.");
					} else {
						verificationFailedMessage(
								"OVERDUE TASK COUNT OF THE ENVIRONMENTAL ACTION REPORT IS NOT DISPLAYED CORRECT.");
					}
				} catch (Throwable t) {
					verificationFailed();
				}

				try {
					// click on the graph of the environmental action report
					click("portfolio_environmentalactionreport_graph_XPATH");

					// enter the property name in the search field
					type("users_filtertxt_CSS", data.get("property_1"));

					boolean orangeDot2_past = driver
							.findElement(
									By.xpath(OR.getProperty("portfolio_environmentalactionreport_orangedot_XPATH")))
							.isDisplayed();

					if (orangeDot2_past == true) {
						successMessage("THE ORANGE COLOR DOT INDICATION IS DISPLAYED CORRECTLY.");
					} else {
						verificationFailedMessage("THE ORANGE COLOR DOT INDICATION IS NOT DISPLAYED.");
					}

				} catch (Throwable t) {
					verificationFailed();
				}

			} catch (Throwable t) {

				verificationFailedMessage("The Environmental Action Report environmental card is not displayed");
			}

		} catch (Throwable t) {
			verificationFailed();
		}

		// click on the home icon from the top of the screen
		click("questionnaire_homeburgermenubtn_hide_CSS");

		// synchronization
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// UPDATE THE ENVIRONMENTAL REPORT DATE TO FUTURE DATE - SUPER ADMIN USER
		title("UPDATE THE ENVIRONMENTAL REPORT DATE TO FUTURE DATE - SUPER ADMIN USER");

		try {

			// enter the property name in the search field
			type("envreports_propertylist_filtertxt_CSS", data.get("property_1"));

			// click on the environmental icon
			click("environmentalicon_CSS");

			// wait for the element
			Thread.sleep(5000);

			// click on the side menu
			click("ssc_leftsidemenubtn_CSS");

			// wait for the element
			Thread.sleep(5000);

			// click on the environmental report
			click("envreportoption_XPATH");

			// enter environmental report in the search field

			type("task_listofchecklist_filterfield_CSS", data.get("title"));

			// click on the environmental report
			click("environmental_searchedreport1_XPATH");

			// scroll down the screen

			scrollByPixel(400);

			// update the date
			LocalDate futureDate = LocalDate.now().plusYears(1).plusDays(3);

			String expectedFutureDate = futureDate.toString();

			// enter the updated date in the next assessment date field
			type("envreportnextassessmentdatetxt_CSS", expectedFutureDate);

			// enter the updated date in the date field
			type("envreportdatetxt_CSS", expectedFutureDate);

			// click on the update button
			click("envreportupdatebtn_CSS");

			// wait for the element
			explicitWaitClickable("closetoastmsg_CSS");

			// click on the toaster close button
			click("closetoastmsg_CSS");

			// wait for the few seconds
			Thread.sleep(10000);

			// enter the newly created environmental report in the search field
			type("task_listofchecklist_filterfield_CSS", data.get("title"));

			// verify the newly created environmental report is displayed or not
			switchVerification("environmental_searchedreport1_XPATH", "Test Environmental Report Count 1",
					"The Test Environmental Report Count 1 is not displayed.");

			// verify updated date is displayed correctly or not
			try {

				String futureDateXpath = "//span[text()='Test Environmental Report Count 1']//parent::td[@ng-click='editRecord(document)']//following-sibling::td//span[text()='"
						+ expectedFutureDate + "']";

				String updatedFutureDate = driver.findElement(By.xpath(futureDateXpath)).getText();

				if (expectedFutureDate.equals(updatedFutureDate)) {
					successMessage("THE UPDATED DATE IS DISPLAYED CORRECTLY.");
				} else {
					verificationFailedMessage("THE UPDATED DATE IS NOT DISPLAYED CORRECTLY.");
				}
			} catch (Throwable t) {
				verificationFailed();
			}

		} catch (Throwable t) {
			verificationFailed();
		}

		// click on the home icon from the top of the screen
		click("questionnaire_homeburgermenubtn_hide_CSS");

		// synchronization
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// VERIFY ENVIRONMENTAL CARD ON THE PORTFOLIO SUMMARY DASHBOARD SCREEN AFTER
		// UPDATING THE DATE TO FUTURE DATE OF THE ENVIRONMENTAL REPORT - SUPER ADMIN
		// USER
		title("VERIFY ENVIRONMENTAL CARD ON THE PORTFOLIO SUMMARY DASHBOARD SCREEN AFTER UPDATING THE DATE TO FUTURE DATE OF THE ENVIRONMENTAL REPORT - SUPER ADMIN USER");

		try {

			// wait for the element
			Thread.sleep(5000);

			// click on the side menu
			click("menubtn_CSS");

			// wait for the element
			Thread.sleep(5000);

			// click on the portfolio summary option
			click("sidemenu_portfoliosummary_XPATH");

			try {
				// scroll down the screen

				scrollTillElement("portfoliodashboard_environmentalactionreportcard_XPATH");
				scrollByPixel(-200);

				switchVerification("portfoliodashboard_environmentalactionreportcard_XPATH",
						"Environmental Action Report", "The Environmental Action Report is not displayed.");

				try {
					String notAvailableCount11_future = driver
							.findElement(By.cssSelector(OR.getProperty("environmental_notavailablecount_CSS")))
							.getText();

					String finalNotAvailableCount11_future = notAvailableCount11_future.trim();

					int value1_future = Integer.parseInt(finalNotAvailableCount1);
					int value2_future = Integer.parseInt(finalNotAvailableCount11_future);

					if (value1_future == (value2_future + 1)) {
						successMessage("NOT AVAILABLE COUNT OF THE ENVIRONMENTAL ACTION REPORT IS DISPLAYED CORRECT.");

					} else {
						verificationFailedMessage(
								"NOT AVAILABLE COUNT OF THE ENVIRONMENTAL ACTION REPORT IS NOT DISPLAYED CORRECT.");
					}
				} catch (Throwable t) {
					verificationFailed();
				}

				try {
					String notApplicableCount11_future = driver
							.findElement(By.cssSelector(OR.getProperty("environmental_notapplicablecount_CSS")))
							.getText();

					String finalNotApplicableCount11_future = notApplicableCount11_future.trim();

					int value1_1_future = Integer.parseInt(finalNotApplicableCount1);
					int value2_1_future = Integer.parseInt(finalNotApplicableCount11_future);

					if (value1_1_future == value2_1_future) {
						successMessage("NOT APPLICABLE COUNT OF THE ENVIRONMENTAL ACTION REPORT IS DISPLAYED CORRECT.");

					} else {
						verificationFailedMessage(
								"NOT APPLICABLE COUNT OF THE ENVIRONMENTAL ACTION REPORT IS NOT DISPLAYED CORRECT.");
					}
				} catch (Throwable t) {
					verificationFailed();
				}

				try {
					String overDueTaskCount11_future = driver
							.findElement(By.cssSelector(OR.getProperty("environmental_overduetaskcount_CSS")))
							.getText();

					String finalOverDueTaskCount11_future = overDueTaskCount11_future.trim();

					int value1_11_future = Integer.parseInt(finalOverDueTaskCount1);
					int value2_11_future = Integer.parseInt(finalOverDueTaskCount11_future);

					if (value1_11_future == value2_11_future) {
						successMessage("OVERDUE TASK COUNT OF THE ENVIRONMENTAL ACTION REPORT IS DISPLAYED CORRECT.");
					} else {
						verificationFailedMessage(
								"OVERDUE TASK COUNT OF THE ENVIRONMENTAL ACTION REPORT IS NOT DISPLAYED CORRECT.");
					}
				} catch (Throwable t) {
					verificationFailed();
				}

				try {
					// click on the graph of the environmental action report
					click("portfolio_environmentalactionreport_graph_XPATH");

					// enter the property name in the search field
					type("users_filtertxt_CSS", data.get("property_1"));

					boolean greenDot1_future = driver
							.findElement(By.xpath(OR.getProperty("portfolio_environmentalactionreport_greendot_XPATH")))
							.isDisplayed();

					if (greenDot1_future == true) {
						successMessage("THE GREEN COLOR DOT INDICATION IS DISPLAYED CORRECTLY.");
					} else {
						verificationFailedMessage("THE GREEN COLOR DOT INDICATION IS NOT DISPLAYED.");
					}

				} catch (Throwable t) {
					verificationFailed();
				}

			} catch (Throwable t) {

				verificationFailedMessage("The Environmental Action Report environmental card is not displayed");
			}

		} catch (Throwable t) {
			verificationFailed();
		}

		// click on the home icon from the top of the screen
		click("questionnaire_homeburgermenubtn_hide_CSS");

		// synchronization
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// VERIFY ENVIRONMENTAL CARD ON THE ASSESSMENTS/INSPECTIONS DASHBOARD OF THE
		// ENVIRONMENTAL MODULE AFTER UPDATING THE DATE TO FUTURE DATE OF THE
		// ENVIRONMENTAL REPORT - SUPER ADMIN USER
		title("VERIFY ENVIRONMENTAL CARD ON THE ASSESSMENTS/INSPECTIONS DASHBOARD OF THE ENVIRONMENTAL MODULE AFTER UPDATING THE DATE TO FUTURE DATE OF THE ENVIRONMENTAL REPORT - SUPER ADMIN USER");

		try {

			// wait for the element
			Thread.sleep(5000);

			// click on the side menu
			click("menubtn_CSS");

			// wait for the element
			Thread.sleep(5000);

			// click on the environmental option
			click("sidemenu_environmental_XPATH");

			// select the Assessments/Inspections option from the dashbaord drop down
			select("dashboard_CSS", data.get("dashboard_2"));

			// wait for the 3 seconds
			Thread.sleep(3000);

			try {
				// scroll down the screen

				scrollTillElement("portfoliodashboard_environmentalactionreportcard_XPATH");
				scrollByPixel(-200);

				switchVerification("portfoliodashboard_environmentalactionreportcard_XPATH",
						"Environmental Action Report", "The Environmental Action Report is not displayed.");

				try {
					String notAvailableCount22_future = driver
							.findElement(By.cssSelector(OR.getProperty("environmental_notavailablecount_CSS")))
							.getText();

					String finalNotAvailableCount22_future = notAvailableCount22_future.trim();

					int value1_2_future = Integer.parseInt(finalNotAvailableCount2);
					int value2_2_future = Integer.parseInt(finalNotAvailableCount22_future);

					if (value1_2_future == (value2_2_future + 1)) {
						successMessage("NOT AVAILABLE COUNT OF THE ENVIRONMENTAL ACTION REPORT IS DISPLAYED CORRECT.");
					} else {
						verificationFailedMessage(
								"NOT AVAILABLE COUNT OF THE ENVIRONMENTAL ACTION REPORT IS NOT DISPLAYED CORRECT.");
					}
				} catch (Throwable t) {
					verificationFailed();
				}

				try {
					String notApplicableCount22_future = driver
							.findElement(By.cssSelector(OR.getProperty("environmental_notapplicablecount_CSS")))
							.getText();

					String finalNotApplicableCount22_future = notApplicableCount22_future.trim();

					int value1_22_future = Integer.parseInt(finalNotApplicableCount2);
					int value2_22_future = Integer.parseInt(finalNotApplicableCount22_future);

					if (value1_22_future == value2_22_future) {
						successMessage("NOT APPLICABLE COUNT OF THE ENVIRONMENTAL ACTION REPORT IS DISPLAYED CORRECT.");
					} else {
						verificationFailedMessage(
								"NOT APPLICABLE COUNT OF THE ENVIRONMENTAL ACTION REPORT IS NOT DISPLAYED CORRECT.");
					}
				} catch (Throwable t) {
					verificationFailed();
				}

				try {
					String overDueTaskCount22_future = driver
							.findElement(By.cssSelector(OR.getProperty("environmental_overduetaskcount_CSS")))
							.getText();

					String finalOverDueTaskCount22_future = overDueTaskCount22_future.trim();

					int value1_222_future = Integer.parseInt(finalOverDueTaskCount2);
					int value2_222_future = Integer.parseInt(finalOverDueTaskCount22_future);

					if (value1_222_future == value2_222_future) {

						successMessage("OVERDUE TASK COUNT OF THE ENVIRONMENTAL ACTION REPORT IS DISPLAYED CORRECT.");

					} else {
						verificationFailedMessage(
								"OVERDUE TASK COUNT OF THE ENVIRONMENTAL ACTION REPORT IS NOT DISPLAYED CORRECT.");
					}
				} catch (Throwable t) {
					verificationFailed();
				}

				try {
					// click on the graph of the environmental action report
					click("portfolio_environmentalactionreport_graph_XPATH");

					// enter the property name in the search field

					type("users_filtertxt_CSS", data.get("property_1"));

					boolean greenDot2_future = driver
							.findElement(By.xpath(OR.getProperty("portfolio_environmentalactionreport_greendot_XPATH")))
							.isDisplayed();

					if (greenDot2_future == true) {
						successMessage("THE GREEN COLOR DOT INDICATION IS DISPLAYED CORRECTLY.");
					} else {
						verificationFailedMessage("THE GREEN COLOR DOT INDICATION IS NOT DISPLAYED.");
					}

				} catch (Throwable t) {
					verificationFailed();
				}

			} catch (Throwable t) {

				verificationFailedMessage("The Environmental Action Report environmental card is not displayed");
			}

		} catch (Throwable t) {
			verificationFailed();
		}

		// click on the home icon from the top of the screen
		click("questionnaire_homeburgermenubtn_hide_CSS");

		// synchronization
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// DELETE THE ENVIRONMENTAL REPORT - SUPER ADMIN USER
		title("DELETE THE ENVIRONMENTAL REPORT - SUPER ADMIN USER");

		try {

			// enter the property name in the search field
			type("envreports_propertylist_filtertxt_CSS", data.get("property_1"));

			// click on the environmental icon
			click("environmentalicon_CSS");

			// wait for the element
			Thread.sleep(5000);

			// click on the side menu
			click("ssc_leftsidemenubtn_CSS");

			// wait for the element
			Thread.sleep(5000);

			// click on the environmental report
			click("envreportoption_XPATH");

			// enter environmental report in the search field

			type("task_listofchecklist_filterfield_CSS", data.get("title"));

			// click on the environmental report
			click("environmental_searchedreport1_XPATH");

			// wait for the element
			explicitWaitClickable("envreportdeletebtn_CSS");

			// click on the delete button
			click("envreportdeletebtn_CSS");

			// wait for the element
			explicitWaitClickable("envreportmodeldeletebtn_CSS");

			// click on the delete button of the confirmation model
			click("envreportmodeldeletebtn_CSS");

			// wait for the element
			explicitWaitClickable("closetoastmsg_CSS");

			// click on the toaster close button
			click("closetoastmsg_CSS");

			// verification of the environmental report is deleted or not

			// enter the newly created environmental report in the search field

			type("task_listofchecklist_filterfield_CSS", data.get("title"));

			deleteVerification("environmental_searchedreport1_XPATH", "Test Environmental Report Count 1");

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
			explicitWaitClickable("questionnaire_settingicon_CSS");

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