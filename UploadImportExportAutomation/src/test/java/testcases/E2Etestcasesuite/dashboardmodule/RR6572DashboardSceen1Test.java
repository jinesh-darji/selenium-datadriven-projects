package testcases.E2Etestcasesuite.dashboardmodule;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.Hashtable;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import base.TestBase;
import utilities.ExcelReader;
import utilities.TestUtil;

public class RR6572DashboardSceen1Test extends TestBase {

	@Test(dataProviderClass = TestUtil.class, dataProvider = "dp")
	public void rR6572DashboardSceen1Test(Hashtable<String, String> data) throws IOException, InterruptedException {

		execution(data, "rR6572DashboardSceen1Test");

		// VALIDATE THE EXPORT/IMPORT FEATURE FOR THE PROPERTIES FROM THE PROPERTY
		// LISTING DASHBOARD.
		title("VALIDATE THE EXPORT/IMPORT FEATURE FOR THE PROPERTIES FROM THE PROPERTY LISTING DASHBOARD.");

		// refresh the page
		driver.navigate().refresh();
		Thread.sleep(5000);
		driver.navigate().refresh();

		String propertyNumber = RandomStringUtils.randomNumeric(2);
		String propertyName = RandomStringUtils.randomAlphabetic(8);

		// PERFORM THE EXPORT FUNCTIONALITY FOR THE PROPERTIES FROM THE PROPERTY LISTING
		// DASHBOARD
		title("PERFORM THE EXPORT FUNCTIONALITY FOR THE PROPERTIES FROM THE PROPERTY LISTING DASHBOARD");

		try {

			// wait for the element
			explicitWaitClickable("dashboard_propertylist_actionicon_XPATH");

			// click on the action icon
			click("dashboard_propertylist_actionicon_XPATH");

			// wait for the element
			Thread.sleep(2000);

			// click on the export option
			click("dashboard_propertylist_actionicon_exportoption_XPATH");

			// wait for the element
			Thread.sleep(15000);

			// fetch the record from the download file
			File downloaded = getLastModified("C:\\Users\\Jinesh\\Downloads");
			String path_string = downloaded.toString();
			System.out.println(path_string);
			ExcelReader file = new ExcelReader(path_string);

			// validate the details of the property one
			String detail11 = file.getCellData("Properties", "Property Number", 2);
			String detail12 = file.getCellData("Properties", "Property Name", 2);
			String detail13 = file.getCellData("Properties", "Status (Active, Inactive, Deleted)", 2);

			try {
				if (detail11.equals("01")) {
					successMessage("The property number of property one is displayed correctly.");
				} else {
					verificationFailedMessage("The property number of property one is not displayed.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The property number of property one is not displayed.");
			}

			try {
				if (detail12.equals("[DND] AAAA Risk Test Prop 01")) {
					successMessage("The property name of property one is displayed correctly.");
				} else {
					verificationFailedMessage("The property name of property one is not displayed.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The property name of property one is not displayed.");
			}

			try {
				if (detail13.equals("ACTIVE")) {
					successMessage("The status of property one is displayed correctly.");
				} else {
					verificationFailedMessage("The status of property one is not displayed.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The status of property one is not displayed.");
			}

			// validate the details of the property two
			String detail21 = file.getCellData("Properties", "Property Number", 3);
			String detail22 = file.getCellData("Properties", "Property Name", 3);
			String detail23 = file.getCellData("Properties", "Status (Active, Inactive, Deleted)", 3);

			try {
				if (detail21.equals("02")) {
					successMessage("The property number of property two is displayed correctly.");
				} else {
					verificationFailedMessage("The property number of property two is not displayed.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The property number of property two is not displayed.");
			}

			try {
				if (detail22.equals("[DND] AAAA Risk Test Prop 02")) {
					successMessage("The property name of property two is displayed correctly.");
				} else {
					verificationFailedMessage("The property name of property two is not displayed.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The property name of property two is not displayed.");
			}

			try {
				if (detail23.equals("ACTIVE")) {
					successMessage("The status of property two is displayed correctly.");
				} else {
					verificationFailedMessage("The status of property two is not displayed.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The status of property two is not displayed.");
			}

			// validate the details of the property three
			String detail31 = file.getCellData("Properties", "Property Number", 4);
			String detail32 = file.getCellData("Properties", "Property Name", 4);
			String detail33 = file.getCellData("Properties", "Status (Active, Inactive, Deleted)", 4);

			try {
				if (detail31.equals("03")) {
					successMessage("The property number of property three is displayed correctly.");
				} else {
					verificationFailedMessage("The property number of property three is not displayed.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The property number of property three is not displayed.");
			}

			try {
				if (detail32.equals("[DND] AAAA Risk Test Prop 03")) {
					successMessage("The property name of property three is displayed correctly.");
				} else {
					verificationFailedMessage("The property name of property three is not displayed.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The property name of property three is not displayed.");
			}

			try {
				if (detail33.equals("ACTIVE")) {
					successMessage("The status of property three is displayed correctly.");
				} else {
					verificationFailedMessage("The status of property three is not displayed.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The status of property three is not displayed.");
			}

			// validate the details of the property four
			String detail42 = file.getCellData("Properties", "Property Name", 5);
			String detail43 = file.getCellData("Properties", "Status (Active, Inactive, Deleted)", 5);

			try {
				if (detail42.equals("[DND] AAAA Risk Test Prop 04")) {
					successMessage("The property name of property four is displayed correctly.");
				} else {
					verificationFailedMessage("The property name of property four is not displayed.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The property name of property four is not displayed.");
			}

			try {
				if (detail43.equals("ACTIVE")) {
					successMessage("The status of property four is displayed correctly.");
				} else {
					verificationFailedMessage("The status of property four is not displayed.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The status of property four is not displayed.");
			}

			// update the details of the Property Number of the property four
			file.setCellData("Properties", "Property Number", 5, propertyNumber);

			// update the details of the Property Name of the property four
			file.setCellData("Properties", "Property Name", 5, propertyName);

			// update the details of the status of the property four
			file.setCellData("Properties", "Status (Active, Inactive, Deleted)", 5, "INACTIVE");

			// wait for the element
			Thread.sleep(5000);

			// PERFORM THE IMPORT FUNCTIONALITY FOR THE PROPERTIES FROM THE PROPERTY LISTING
			// DASHBOARD
			title("PERFORM THE IMPORT FUNCTIONALITY FOR THE PROPERTIES FROM THE PROPERTY LISTING DASHBOARD");

			// click on the action icon
			click("dashboard_propertylist_actionicon_XPATH");

			// wait for the element
			Thread.sleep(2000);

			// click on the import option
			click("dashboard_propertylist_actionicon_importoption_XPATH");

			// put path to your file in a clipboard
			StringSelection ss = new StringSelection(path_string);
			Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);

			// imitate mouse events like ENTER, CTRL+C, CTRL+V
			Robot robot = new Robot();
			robot.delay(250);
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
			robot.delay(250);
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_V);
			robot.delay(250);
			robot.keyRelease(KeyEvent.VK_V);
			robot.keyRelease(KeyEvent.VK_CONTROL);
			robot.delay(250);
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.delay(250);
			robot.keyRelease(KeyEvent.VK_ENTER);

			// wait for the element
			Thread.sleep(10000);

			// VALIDATE THE IMPORTED DETAILS OF THE PROPERTY ONE
			title("VALIDATE THE IMPORTED DETAILS OF THE PROPERTY ONE");

			try {
				String propertyNumber1 = (driver
						.findElement(By.xpath(OR.getProperty("dashboard_propertylist_propertynumber1_XPATH")))
						.getText()).trim();

				if (propertyNumber1.equals("01")) {
					successMessage("The imported property number of property one is displayed correctly.");
				} else {
					verificationFailedMessage("The imported property number of property one is not displayed.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The imported property number of property one is not displayed.");
			}

			try {
				String propertyStatus1 = (driver
						.findElement(By.xpath(OR.getProperty("dashboard_propertylist_propertystatus1_XPATH")))
						.getText()).trim();

				if (propertyStatus1.equals("ACTIVE")) {
					successMessage("The status of imported property one is displayed correctly.");
				} else {
					verificationFailedMessage("The status of imported property one is not displayed.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The status of imported property one is not displayed.");
			}

			try {
				String propertyName1 = (driver
						.findElement(By.xpath(OR.getProperty("dashboard_propertylist_propertyName1_XPATH"))).getText())
								.trim();

				if (propertyName1.equals("[DND] AAAA Risk Test Prop 01")) {
					successMessage("The property name of property one is displayed correctly.");
				} else {
					verificationFailedMessage("The property name of property one is not displayed.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The property name of property one is not displayed.");
			}

			// VALIDATE THE IMPORTED DETAILS OF THE PROPERTY TWO
			title("VALIDATE THE IMPORTED DETAILS OF THE PROPERTY TWO");

			try {
				String propertyNumber2 = (driver
						.findElement(By.xpath(OR.getProperty("dashboard_propertylist_propertynumber2_XPATH")))
						.getText()).trim();

				if (propertyNumber2.equals("02")) {
					successMessage("The imported property number of property two is displayed correctly.");
				} else {
					verificationFailedMessage("The imported property number of property two is not displayed.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The imported property number of property two is not displayed.");
			}

			try {
				String propertyStatus2 = (driver
						.findElement(By.xpath(OR.getProperty("dashboard_propertylist_propertystatus2_XPATH")))
						.getText()).trim();

				if (propertyStatus2.equals("ACTIVE")) {
					successMessage("The status of imported property two is displayed correctly.");
				} else {
					verificationFailedMessage("The status of imported property two is not displayed.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The status of imported property two is not displayed.");
			}

			try {
				String propertyName2 = (driver
						.findElement(By.xpath(OR.getProperty("dashboard_propertylist_propertyName2_XPATH"))).getText())
								.trim();

				if (propertyName2.equals("[DND] AAAA Risk Test Prop 02")) {
					successMessage("The property name of property two is displayed correctly.");
				} else {
					verificationFailedMessage("The property name of property two is not displayed.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The property name of property two is not displayed.");
			}

			// VALIDATE THE IMPORTED DETAILS OF THE PROPERTY THREE
			title("VALIDATE THE IMPORTED DETAILS OF THE PROPERTY THREE");

			try {
				String propertyNumber3 = (driver
						.findElement(By.xpath(OR.getProperty("dashboard_propertylist_propertynumber3_XPATH")))
						.getText()).trim();

				if (propertyNumber3.equals("03")) {
					successMessage("The imported property number of property three is displayed correctly.");
				} else {
					verificationFailedMessage("The imported property number of property three is not displayed.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The imported property number of property three is not displayed.");
			}

			try {
				String propertyStatus3 = (driver
						.findElement(By.xpath(OR.getProperty("dashboard_propertylist_propertystatus3_XPATH")))
						.getText()).trim();

				if (propertyStatus3.equals("ACTIVE")) {
					successMessage("The status of imported property three is displayed correctly.");
				} else {
					verificationFailedMessage("The status of imported property three is not displayed.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The status of imported property three is not displayed.");
			}

			try {
				String propertyName3 = (driver
						.findElement(By.xpath(OR.getProperty("dashboard_propertylist_propertyName3_XPATH"))).getText())
								.trim();

				if (propertyName3.equals("[DND] AAAA Risk Test Prop 03")) {
					successMessage("The property name of property three is displayed correctly.");
				} else {
					verificationFailedMessage("The property name of property three is not displayed.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The property name of property three is not displayed.");
			}

			// VALIDATE THE IMPORTED DETAILS OF THE PROPERTY FOUR
			title("VALIDATE THE IMPORTED DETAILS OF THE PROPERTY FOUR");

			try {
				String propertyNumber4 = (driver
						.findElement(By.xpath(OR.getProperty("dashboard_propertylist_propertynumber4_XPATH")))
						.getText()).trim();

				if (propertyNumber4.equals(propertyNumber)) {
					successMessage("The imported property number of property four is displayed correctly.");
				} else {
					verificationFailedMessage("The imported property number of property four is not displayed.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The imported property number of property four is not displayed.");
			}

			try {
				String propertyStatus3 = (driver
						.findElement(By.xpath(OR.getProperty("dashboard_propertylist_propertystatus4_XPATH")))
						.getText()).trim();

				if (propertyStatus3.equals("INACTIVE")) {
					successMessage("The status of imported property four is displayed correctly.");
				} else {
					verificationFailedMessage("The status of imported property four is not displayed.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The status of imported property four is not displayed.");
			}

			try {
				String propertyName3 = (driver
						.findElement(By.xpath(OR.getProperty("dashboard_propertylist_propertyName4_XPATH"))).getText())
								.trim();

				if (propertyName3.equals(propertyName)) {
					successMessage("The property name of property four is displayed correctly.");
				} else {
					verificationFailedMessage("The property name of property four is not displayed.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The property name of property four is not displayed.");
			}

		} catch (Throwable t) {
			verificationFailed();

			driver.navigate().refresh();
			Thread.sleep(5000);
			driver.navigate().refresh();

		}

		// click on the home icon from the top of the screen
		click("questionnaire_homeburgermenubtn_hide_CSS");

		// wait for the element
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// VALIDATE THE UPDATED DETAILS OF THE IMPORTED FILE IN THE PROPERTY DETAILS
		// SCREEN
		title("VALIDATE THE UPDATED DETAILS OF THE IMPORTED FILE IN THE PROPERTY DETAILS SCREEN");

		try {

			// enter the property name in the search field
			type("ohs_incidentreport_searchtxt_XPATH", propertyName);

			// click on the environmental icon from the property list page
			click("environmentalicon_CSS");

			// wait for the element
			Thread.sleep(3000);

			// click on the burger menu
			click("menubtn_CSS");

			// wait for the element
			Thread.sleep(3000);

			// click on the property details sub menu
			click("navigation_sidemenu_propertydetailslbl_XPATH");

			// click on the action button
			click("navigation_propertydetails_actionicon_XPATH");

			// click on the property details option
			click("navigation_propertydetails_propertydetailsoption_XPATH");

			// wait for the element
			Thread.sleep(3000);

			// validate the updated imported property number
			try {

				String propertynumber = (driver
						.findElement(By.xpath(OR.getProperty("navigation_propertydetails_propertynumber_XPATH")))
						.getText()).trim();

				if (propertynumber.equals(propertyNumber)) {
					successMessage("The updated imported property number is displayed correctly.");
				} else {
					verificationFailedMessage("The updated imported property number is not displayed correctly.");
				}

			} catch (Throwable t) {
				verificationFailedMessage("The updated imported property number is not displayed correctly.");
			}

			// validate the updated imported property name
			try {

				String propertyname = (driver
						.findElement(By.xpath(OR.getProperty("navigation_propertydetails_propertyname_XPATH")))
						.getText()).trim();

				if (propertyname.equals(propertyName)) {
					successMessage("The updated imported property name is displayed correctly.");
				} else {
					verificationFailedMessage("The updated imported property name is not displayed correctly.");
				}

			} catch (Throwable t) {
				verificationFailedMessage("The updated imported property name is not displayed correctly.");
			}

			// validate the updated imported property status
			try {

				String propertystatus = (driver
						.findElement(
								By.xpath(OR.getProperty("navigation_propertydetails_propertyinactivestatus_XPATH")))
						.getText()).trim();

				if (propertystatus.equals("Inactive")) {
					successMessage("The updated imported property status is displayed correctly.");
				} else {
					verificationFailedMessage("The updated imported property status is not displayed correctly.");
				}

			} catch (Throwable t) {
				verificationFailedMessage("The updated imported property status is not displayed correctly.");
			}

		} catch (Throwable t) {
			verificationFailed();

			driver.navigate().refresh();
			Thread.sleep(5000);
			driver.navigate().refresh();

		}

		// click on the home icon from the top of the screen
		click("questionnaire_homeburgermenubtn_hide_CSS");

		// wait for the element
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// RESET THE DETAILS OF THE UPDATED PROPERTY
		title("RESET THE DETAILS OF THE UPDATED PROPERTY");

		try {

			// enter the property name in the search field
			type("ohs_incidentreport_searchtxt_XPATH", propertyName);

			// click on the environmental icon from the property list page
			click("environmentalicon_CSS");

			// wait for the element
			Thread.sleep(3000);

			// click on the burger menu
			click("menubtn_CSS");

			// wait for the element
			Thread.sleep(3000);

			// click on the property details sub menu
			click("navigation_sidemenu_propertydetailslbl_XPATH");

			// click on the action button
			click("navigation_propertydetails_actionicon_XPATH");

			// click on the property details option
			click("navigation_propertydetails_propertydetailsoption_XPATH");

			// wait for the element
			Thread.sleep(3000);

			// click on the edit button of property details screen
			click("navigation_propertydetails_editbtn_XPATH");

			// enter the property name
			type("navigation_propertydetails_propertynametxt_XPATH", data.get("property_4"));

			// select the property status
			select("navigation_propertydetails_propertystatusdd_XPATH", "Active");

			// scroll down to bottom
			scrollBottom();

			// click on the save button
			click("propertydetails_savebutton_XPATH");

			// scroll up to top
			scrollTop();

			// validate the updated property name
			try {

				String propertyname = (driver
						.findElement(By.xpath(OR.getProperty("navigation_propertydetails_propertyname_XPATH")))
						.getText()).trim();

				if (propertyname.equals(data.get("property_4"))) {
					successMessage("The updated property name is displayed correctly.");
				} else {
					verificationFailedMessage("The updated property name is not displayed correctly.");
				}

			} catch (Throwable t) {
				verificationFailedMessage("The updated property name is not displayed correctly.");
			}

			// validate the updated imported property status
			try {

				String propertystatus = (driver
						.findElement(
								By.xpath(OR.getProperty("navigation_propertydetails_propertyinactivestatus_XPATH")))
						.getText()).trim();

				if (propertystatus.equals("Active")) {
					successMessage("The updated property status is displayed correctly.");
				} else {
					verificationFailedMessage("The updated property status is not displayed correctly.");
				}

			} catch (Throwable t) {
				verificationFailedMessage("The updated property status is not displayed correctly.");
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

		// VALIDATE THE UPDATED DETAILS IN THE PROPERTY LISTING SCREEN
		title("VALIDATE THE UPDATED DETAILS IN THE PROPERTY LISTING SCREEN");

		try {
			try {
				String propertyNumber4 = (driver
						.findElement(By.xpath(OR.getProperty("dashboard_propertylist_propertynumber4_XPATH")))
						.getText()).trim();

				if (propertyNumber4.equals(propertyNumber)) {
					successMessage("The imported property number of property four is displayed correctly.");
				} else {
					verificationFailedMessage("The imported property number of property four is not displayed.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The imported property number of property four is not displayed.");
			}

			try {
				String propertyStatus4 = (driver
						.findElement(By.xpath(OR.getProperty("dashboard_propertylist_propertystatus4_XPATH")))
						.getText()).trim();

				if (propertyStatus4.equals("ACTIVE")) {
					successMessage("The status of imported property four is displayed correctly.");
				} else {
					verificationFailedMessage("The status of imported property four is not displayed.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The status of imported property four is not displayed.");
			}

			try {
				String propertyName4 = (driver
						.findElement(By.xpath(OR.getProperty("dashboard_propertylist_propertyName4_XPATH"))).getText())
								.trim();

				if (propertyName4.equals(data.get("property_4"))) {
					successMessage("The property name of property four is displayed correctly.");
				} else {
					verificationFailedMessage("The property name of property four is not displayed.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The property name of property four is not displayed.");
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

		// RESET DETAILS OF PROPERTY NUMBER BY EXPORT AND IMPORTING FUNCTIONALITY
		title("RESET DETAILS OF PROPERTY NUMBER BY EXPORT AND IMPORTING FUNCTIONALITY");

		try {

			// wait for the element
			explicitWaitClickable("dashboard_propertylist_actionicon_XPATH");

			// click on the action icon
			click("dashboard_propertylist_actionicon_XPATH");

			// wait for the element
			Thread.sleep(2000);

			// click on the export option
			click("dashboard_propertylist_actionicon_exportoption_XPATH");

			// wait for the element
			Thread.sleep(15000);

			// fetch the record from the download file
			File downloaded = getLastModified("C:\\Users\\Jinesh\\Downloads");
			String path_string = downloaded.toString();
			System.out.println(path_string);
			ExcelReader file = new ExcelReader(path_string);

			// update the details of the Property Number of the property four
			file.setCellData("Properties", "Property Number", 5, "04");

			// wait for the element
			Thread.sleep(5000);

			// PERFORM THE IMPORT FUNCTIONALITY FOR THE PROPERTIES FROM THE PROPERTY LISTING
			// DASHBOARD
			title("PERFORM THE IMPORT FUNCTIONALITY FOR THE PROPERTIES FROM THE PROPERTY LISTING DASHBOARD");

			// click on the action icon
			click("dashboard_propertylist_actionicon_XPATH");

			// wait for the element
			Thread.sleep(2000);

			// click on the import option
			click("dashboard_propertylist_actionicon_importoption_XPATH");

			// put path to your file in a clipboard
			StringSelection ss = new StringSelection(path_string);
			Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);

			// imitate mouse events like ENTER, CTRL+C, CTRL+V
			Robot robot = new Robot();
			robot.delay(250);
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
			robot.delay(250);
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_V);
			robot.delay(250);
			robot.keyRelease(KeyEvent.VK_V);
			robot.keyRelease(KeyEvent.VK_CONTROL);
			robot.delay(250);
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.delay(250);
			robot.keyRelease(KeyEvent.VK_ENTER);

			// wait for the element
			Thread.sleep(10000);

			// VALIDATE THE IMPORTED DETAILS OF THE PROPERTY FOUR
			title("VALIDATE THE IMPORTED DETAILS OF THE PROPERTY FOUR");

			try {
				String propertyNumber4 = (driver
						.findElement(By.xpath(OR.getProperty("dashboard_propertylist_propertynumber4_XPATH")))
						.getText()).trim();

				if (propertyNumber4.equals("04")) {
					successMessage("The imported property number of property four is displayed correctly.");
				} else {
					verificationFailedMessage("The imported property number of property four is not displayed.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The imported property number of property four is not displayed.");
			}

			try {
				String propertyStatus4 = (driver
						.findElement(By.xpath(OR.getProperty("dashboard_propertylist_propertystatus4_XPATH")))
						.getText()).trim();

				if (propertyStatus4.equals("ACTIVE")) {
					successMessage("The status of imported property four is displayed correctly.");
				} else {
					verificationFailedMessage("The status of imported property four is not displayed.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The status of imported property four is not displayed.");
			}

			try {
				String propertyName4 = (driver
						.findElement(By.xpath(OR.getProperty("dashboard_propertylist_propertyName4_XPATH"))).getText())
								.trim();

				if (propertyName4.equals(data.get("property_4"))) {
					successMessage("The property name of property four is displayed correctly.");
				} else {
					verificationFailedMessage("The property name of property four is not displayed.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The property name of property four is not displayed.");
			}

		} catch (Throwable t) {
			verificationFailed();

			driver.navigate().refresh();
			Thread.sleep(5000);
			driver.navigate().refresh();

		}

		// click on the home icon from the top of the screen
		click("questionnaire_homeburgermenubtn_hide_CSS");

		// wait for the element
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

	}
}
