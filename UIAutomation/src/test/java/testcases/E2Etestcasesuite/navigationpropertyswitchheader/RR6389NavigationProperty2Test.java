package testcases.E2Etestcasesuite.navigationpropertyswitchheader;

import java.io.IOException;
import java.util.Hashtable;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import base.Helper;
import base.TestBase;
import utilities.TestUtil;

public class RR6389NavigationProperty2Test extends TestBase {

	@Test(dataProviderClass = TestUtil.class, dataProvider = "dp")
	public void rR6389NavigationProperty2Test(Hashtable<String, String> data) throws InterruptedException, IOException {

		execution(data, "rR6389NavigationProperty2Test");

		Helper helper = new Helper();

		// ENVIRONMENTAL MODULE - NAVIGATION SCENARIO OF THE ENVIRONMENTAL REPORTS AND
		// ENVIRONMENTAL RECORDS
		title("ENVIRONMENTAL MODULE - NAVIGATION SCENARIO OF THE ENVIRONMENTAL REPORTS AND ENVIRONMENTAL RECORDS");

		// refresh the page
		driver.navigate().refresh();
		Thread.sleep(5000);
		driver.navigate().refresh();

		// CREATE NEW RECORD OF THE ENVIRONMENTAL REPORT
		title("CREATE NEW RECORD OF THE ENVIRONMENTAL REPORT");

		try {
			// click on the environmental icon from the property list page
			click("environmentalicon_CSS");

			// click on the burger menu
			click("menubtn_CSS");

			// wait for the element
			explicitWaitClickable("envreportoption_XPATH");

			// click on the Environmental Reports option
			click("envreportoption_XPATH");

			// click on the Add report button
			click("envreportaddbtn_CSS");

			// select the checklist from the type dropdown
			select("envreporttypedd_CSS", data.get("type"));

			// enter the title
			type("envreporttitletxt_CSS", data.get("title"));

			// click on the date field
			click("envreportdatetxt_CSS");

			// click on the today button
			click("envreporttodaydate_BTNTEXT");

			// enter the company
			type("envreportcompanytxt_CSS", data.get("company"));

			// enter the author
			type("envreportauthortxt_CSS", data.get("author"));

			// scroll down the screen
			scrollByPixel(400);

			// enter the description
			type("envreportdescriptiontxt_CSS", data.get("description"));

			// click on the Add report button
			click("envreportsavebtn_CSS");

			// wait for the element
			explicitWaitClickable("closetoastmsg_CSS");

			// click on the toaster close button
			click("closetoastmsg_CSS");

			// enter the newly created environmental report in the search field
			type("task_listofchecklist_filterfield_CSS", data.get("title"));

			// verification of the environmental report is added or not
			switchVerification("navigation_environmentnavigation_environmentalreportrecord2_XPATH",
					"Test Environmental Navigation Report 2",
					"The Test Environmental Navigation Report 2 is not displayed successfully.");

		} catch (Throwable t) {
			verificationFailed();
		}

		// click on the home icon from the top of the screen
		click("questionnaire_homeburgermenubtn_hide_CSS");

		// wait for the element
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// CREATE NEW RECORD OF THE ENVIRONMENTAL RECORD - ASBESTOS MATERIALS
		title("CREATE NEW RECORD OF THE ENVIRONMENTAL RECORD - ASBESTOS MATERIALS");

		try {

			// wait for the element
			explicitWaitClickable("environmentalicon_CSS");

			// click on the environmental icon from the property list page
			click("environmentalicon_CSS");

			// click on the burger menu
			click("menubtn_CSS");

			// wait for the element
			explicitWaitClickable("envrecords_XPATH");

			// click on the environmental records
			click("envrecords_XPATH");

			// click on the Primary Hazardous Substance
			click("envrecords_primaryhazardoussubstance_XPATH");

			// click on the asbestos materials
			click("envreports_asbestosmaterials_XPATH");

			// click on the add button
			click("envreports_asbestosmaterials_addbtn_CSS");

			// select the material
			select("envreports_asbestosmaterials_materialdd_CSS", data.get("material"));

			// enter the detailed description
			type("envreports_asbestosmaterials_detaileddescriptiontxt_CSS", data.get("detailed_description"));

			// enter the detailed location
			type("envreports_asbestosmaterials_detailedlocationtxt_CSS", data.get("detailed_location"));

			// scroll down the screen
			scrollByPixel(400);

			// select the estimated risk
			select("envreports_asbestosmaterials_estimatedriskdd_CSS", data.get("estimated_risk"));

			// select the is material asbestos containing
			select("envreports_asbestosmaterials_ismaterialasbestoscontainingdd_CSS",
					data.get("is_material_asbestos_containing"));

			// select the asbestos type
			select("envreports_asbestosmaterials_asbestostypedd_CSS", data.get("asbestos_type"));

			// select the condition
			select("envreports_asbestosmaterials_conditiondd_CSS", data.get("condition"));

			// select the status
			select("envreports_asbestosmaterials_statusdd_CSS", data.get("status"));

			// scroll till bottom of the page
			scrollByPixel(1000);

			// enter the details
			type("envreports_asbestosmaterials_detailstxt_CSS", data.get("details"));

			// click on the save button
			click("envreports_asbestosmaterials_savebtn_CSS");

			// wait for the element
			explicitWaitClickable("closetoastmsg_CSS");

			// click on the toaster close button
			click("closetoastmsg_CSS");

			// enter the newly created environmental record in the search field
			type("task_listofchecklist_filterfield_CSS", data.get("detailed_location"));

			// verify added details of the Asbestos Materials record is correct or not
			switchVerification("navigation_environmentnavigation_environmentalrecordrecord2_XPATH",
					"Test Environmental Navigation Record 2",
					"The Test Environmental Navigation Record 2 is not displayed successfully.");

		} catch (Throwable t) {

			verificationFailed();
		}

		// click on the home icon from the top of the screen
		click("questionnaire_homeburgermenubtn_hide_CSS");

		// wait for the element
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// VALIDATE THE NAVIGATION AFTER SWITCHING THE PROPERTY FROM THE HEADER OF
		// THE ENVIRONMENTAL REPORT
		title("VALIDATE THE NAVIGATION AFTER SWITCHING THE PROPERTY FROM THE HEADER OF THE ENVIRONMENTAL REPORT");

		try {
			// click on the environmental icon from the property list page
			click("environmentalicon_CSS");

			// click on the burger menu
			click("menubtn_CSS");

			// wait for the element
			explicitWaitClickable("envreportoption_XPATH");

			// click on the Environmental Reports option
			click("envreportoption_XPATH");

			// click on the newly created environmental report
			click("navigation_environmentnavigation_environmentalreportrecord2_XPATH");

			// VALIDATE FOR PROPERTY ONE
			title("VALIDATE FOR PROPERTY ONE");

			// validate the property name
			switchVerification("navigation_header_propertyname1_XPATH", "[DND] AAAA Risk Test Prop 01 - 01",
					"The property name is not displayed.");

			// validate the title of the environmental report is displayed selected or not
			try {

				String title_actual = driver.findElement(By.cssSelector(OR.getProperty("envreporttitletxt_CSS")))
						.getAttribute("value");

				if (title_actual.equals(data.get("title"))) {
					successMessage("The title of the environmental report is display successfully.");

				} else {
					verificationFailedMessage("The title of the environmental report is not display.");

				}
			} catch (Throwable t) {
				verificationFailedMessage("The title of the environmental report is not display.");
			}

			// VALIDATE FOR PROPERTY TWO
			title("VALIDATE FOR PROPERTY TWO");

			// wait for the element
			explicitWaitClickable("navigation_header_searchicon_XPATH");

			// click on the search icon from the header
			click("navigation_header_searchicon_XPATH");

			// enter property 2 number in text field
			type("navigation_header_searchtxt_XPATH", "02");

			// hit enter key
			driver.findElement(By.xpath(OR.getProperty("navigation_header_searchtxt_XPATH"))).sendKeys(Keys.ENTER);
			consoleMessage("Hit enter key.");

			// wait for the element
			Thread.sleep(2000);

			// click on the settings icon from the top of the screen
			click("questionnaire_settingicon_CSS");

			// wait for the element
			Thread.sleep(1000);

			// click on the cancel icon
			click("questionnaire_setting_cancelicon_XPATH");

			// validate the property name
			switchVerification("navigation_header_propertyname2_XPATH", "[DND] AAAA Risk Test Prop 02 - 02",
					"The property name is not displayed.");

			// validate the title of the environmental report is displayed selected or not
			try {

				String title_actual = driver.findElement(By.cssSelector(OR.getProperty("envreporttitletxt_CSS")))
						.getAttribute("value");

				if (title_actual.equals(data.get("title"))) {
					verificationFailedMessage("The title of the environmental report is display.");

				} else {
					successMessage("The title of the environmental report is not display successfully.");

				}
			} catch (Throwable t) {
				successMessage("The title of the environmental report is not display successfully.");
			}

			// validate the title of the environmental report in the listing screen is
			// displayed selected or not
			try {
				String titlelist = "//span[text()='" + data.get("title") + "']";
				boolean titlelist_actual = driver.findElement(By.xpath(titlelist)).isDisplayed();

				if (titlelist_actual == true) {
					verificationFailedMessage("The newly created environmental report is display.");

				} else {
					successMessage("The newly created environmental report is not display successfully.");

				}
			} catch (Throwable t) {
				successMessage("The newly created environmental report is not display successfully.");
			}

			// VALIDATE FOR PROPERTY THREE
			title("VALIDATE FOR PROPERTY THREE");

			// wait for the element
			explicitWaitClickable("navigation_header_searchicon_XPATH");

			// click on the search icon from the header
			click("navigation_header_searchicon_XPATH");

			// enter property 3 number in text field
			type("navigation_header_searchtxt_XPATH", "03");

			// hit enter key
			driver.findElement(By.xpath(OR.getProperty("navigation_header_searchtxt_XPATH"))).sendKeys(Keys.ENTER);
			consoleMessage("Hit enter key.");

			// wait for the element
			Thread.sleep(2000);

			// click on the settings icon from the top of the screen
			click("questionnaire_settingicon_CSS");

			// wait for the element
			Thread.sleep(1000);

			// click on the cancel icon
			click("questionnaire_setting_cancelicon_XPATH");

			// validate the property name
			switchVerification("navigation_header_propertyname3_XPATH", "[DND] AAAA Risk Test Prop 03 - 03",
					"The property name is not displayed.");

			// validate the title of the environmental report is displayed selected or not
			try {

				String title_actual = driver.findElement(By.cssSelector(OR.getProperty("envreporttitletxt_CSS")))
						.getAttribute("value");

				if (title_actual.equals(data.get("title"))) {
					verificationFailedMessage("The title of the environmental report is display.");

				} else {
					successMessage("The title of the environmental report is not display successfully.");

				}
			} catch (Throwable t) {
				successMessage("The title of the environmental report is not display successfully.");
			}

			// validate the title of the environmental report in the listing screen is
			// displayed selected or not
			try {
				String titlelist = "//span[text()='" + data.get("title") + "']";
				boolean titlelist_actual = driver.findElement(By.xpath(titlelist)).isDisplayed();

				if (titlelist_actual == true) {
					verificationFailedMessage("The newly created environmental report is display.");

				} else {
					successMessage("The newly created environmental report is not display successfully.");

				}
			} catch (Throwable t) {
				successMessage("The newly created environmental report is not display successfully.");
			}

			// VALIDATE FOR PROPERTY ONE
			title("VALIDATE FOR PROPERTY ONE");

			// wait for the element
			explicitWaitClickable("navigation_header_searchicon_XPATH");

			// click on the search icon from the header
			click("navigation_header_searchicon_XPATH");

			// enter property number in text field
			type("navigation_header_searchtxt_XPATH", "01");

			// hit enter key
			driver.findElement(By.xpath(OR.getProperty("navigation_header_searchtxt_XPATH"))).sendKeys(Keys.ENTER);
			consoleMessage("Hit enter key.");

			// validate the property name
			switchVerification("navigation_header_propertyname1_XPATH", "[DND] AAAA Risk Test Prop 01 - 01",
					"The property name is not displayed.");

			// validate the title of the environmental report is displayed selected or not
			try {

				String title_actual = driver.findElement(By.cssSelector(OR.getProperty("envreporttitletxt_CSS")))
						.getAttribute("value");

				if (title_actual.equals(data.get("title"))) {
					verificationFailedMessage("The title of the environmental report is display.");

				} else {
					successMessage("The title of the environmental report is not display successfully.");

				}
			} catch (Throwable t) {
				successMessage("The title of the environmental report is not display successfully.");
			}

			// validate the title of the environmental report in the listing screen is
			// displayed selected or not
			try {
				String titlelist = "//span[text()='" + data.get("title") + "']";
				boolean titlelist_actual = driver.findElement(By.xpath(titlelist)).isDisplayed();

				if (titlelist_actual == true) {
					successMessage("The newly created environmental report is display successfully.");

				} else {
					verificationFailedMessage("The newly created environmental report is not display.");

				}
			} catch (Throwable t) {
				verificationFailedMessage("The newly created environmental report is not display.");
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

		// VALIDATE THE NAVIGATION AFTER SWITCHING THE PROPERTY FROM THE HEADER OF
		// THE ENVIRONMENTAL RECORD
		title("VALIDATE THE NAVIGATION AFTER SWITCHING THE PROPERTY FROM THE HEADER OF THE ENVIRONMENTAL RECORD");

		try {
			// wait for the element
			explicitWaitClickable("environmentalicon_CSS");

			// click on the environmental icon from the property list page
			click("environmentalicon_CSS");

			// click on the burger menu
			click("menubtn_CSS");

			// wait for the element
			explicitWaitClickable("envrecords_XPATH");

			// click on the environmental records
			click("envrecords_XPATH");

			// click on the Primary Hazardous Substance
			click("envrecords_primaryhazardoussubstance_XPATH");

			// click on the asbestos materials
			click("envreports_asbestosmaterials_XPATH");

			// click on the newly created environmental record
			click("navigation_environmentnavigation_environmentalrecordrecord2_XPATH");

			// VALIDATE FOR PROPERTY ONE
			title("VALIDATE FOR PROPERTY ONE");

			// validate the property name
			switchVerification("navigation_header_propertyname1_XPATH", "[DND] AAAA Risk Test Prop 01 - 01",
					"The property name is not displayed.");

			// validate the detailed location of the environmental record is displayed
			// selected or not
			try {

				String detailedlocation_actual = driver
						.findElement(
								By.cssSelector(OR.getProperty("envreports_asbestosmaterials_detailedlocationtxt_CSS")))
						.getAttribute("value");

				if (detailedlocation_actual.equals(data.get("detailed_location"))) {
					successMessage("The detailed location of the environmental record is display successfully.");

				} else {
					verificationFailedMessage("The detailed location of the environmental record is not display.");

				}
			} catch (Throwable t) {
				verificationFailedMessage("The detailed location of the environmental record is not display.");
			}

			// VALIDATE FOR PROPERTY TWO
			title("VALIDATE FOR PROPERTY TWO");

			// wait for the element
			explicitWaitClickable("navigation_header_searchicon_XPATH");

			// click on the search icon from the header
			click("navigation_header_searchicon_XPATH");

			// enter property 2 number in text field
			type("navigation_header_searchtxt_XPATH", "02");

			// hit enter key
			driver.findElement(By.xpath(OR.getProperty("navigation_header_searchtxt_XPATH"))).sendKeys(Keys.ENTER);
			consoleMessage("Hit enter key.");

			// wait for the element
			Thread.sleep(2000);

			// click on the settings icon from the top of the screen
			click("questionnaire_settingicon_CSS");

			// wait for the element
			Thread.sleep(1000);

			// click on the cancel icon
			click("questionnaire_setting_cancelicon_XPATH");

			// validate the property name
			switchVerification("navigation_header_propertyname2_XPATH", "[DND] AAAA Risk Test Prop 02 - 02",
					"The property name is not displayed.");

			// validate the detailed location of the environmental record is displayed
			// selected or not
			try {

				String detailedlocation_actual = driver
						.findElement(
								By.cssSelector(OR.getProperty("envreports_asbestosmaterials_detailedlocationtxt_CSS")))
						.getAttribute("value");

				if (detailedlocation_actual.equals(data.get("detailed_location"))) {
					verificationFailedMessage("The detailed location of the environmental record is display.");

				} else {
					successMessage("The detailed location of the environmental record is not display as expected.");

				}
			} catch (Throwable t) {
				successMessage("The detailed location of the environmental record is not display as expected.");
			}

			// validate the detailed location of the environmental record in the listing
			// screen is displayed selected or not
			try {
				String detailedlocationlist = "//span[text()='" + data.get("detailed_location") + "']";
				boolean detailedlocationlist_actual = driver.findElement(By.xpath(detailedlocationlist)).isDisplayed();

				if (detailedlocationlist_actual == true) {
					verificationFailedMessage("The newly created environmental record is display.");

				} else {
					successMessage("The newly created environmental record is not display as expected.");

				}
			} catch (Throwable t) {
				successMessage("The newly created environmental record is not display as expected.");
			}

			// VALIDATE FOR PROPERTY THREE
			title("VALIDATE FOR PROPERTY THREE");

			// wait for the element
			explicitWaitClickable("navigation_header_searchicon_XPATH");

			// click on the search icon from the header
			click("navigation_header_searchicon_XPATH");

			// enter property 2 number in text field
			type("navigation_header_searchtxt_XPATH", "03");

			// hit enter key
			driver.findElement(By.xpath(OR.getProperty("navigation_header_searchtxt_XPATH"))).sendKeys(Keys.ENTER);
			consoleMessage("Hit enter key.");

			// wait for the element
			Thread.sleep(2000);

			// click on the settings icon from the top of the screen
			click("questionnaire_settingicon_CSS");

			// wait for the element
			Thread.sleep(1000);

			// click on the cancel icon
			click("questionnaire_setting_cancelicon_XPATH");

			// validate the property name
			switchVerification("navigation_header_propertyname3_XPATH", "[DND] AAAA Risk Test Prop 03 - 03",
					"The property name is not displayed.");

			// validate the detailed location of the environmental record is displayed
			// selected or not
			try {

				String detailedlocation_actual = driver
						.findElement(
								By.cssSelector(OR.getProperty("envreports_asbestosmaterials_detailedlocationtxt_CSS")))
						.getAttribute("value");

				if (detailedlocation_actual.equals(data.get("detailed_location"))) {
					verificationFailedMessage("The detailed location of the environmental record is display.");

				} else {
					successMessage("The detailed location of the environmental record is not display as expected.");

				}
			} catch (Throwable t) {
				successMessage("The detailed location of the environmental record is not display as expected.");
			}

			// validate the detailed location of the environmental record in the listing
			// screen is displayed selected or not
			try {
				String detailedlocationlist = "//span[text()='" + data.get("detailed_location") + "']";
				boolean detailedlocationlist_actual = driver.findElement(By.xpath(detailedlocationlist)).isDisplayed();

				if (detailedlocationlist_actual == true) {
					verificationFailedMessage("The newly created environmental record is display.");

				} else {
					successMessage("The newly created environmental record is not display as expected.");

				}
			} catch (Throwable t) {
				successMessage("The newly created environmental record is not display as expected.");
			}

			// VALIDATE FOR PROPERTY ONE
			title("VALIDATE FOR PROPERTY ONE");

			// wait for the element
			explicitWaitClickable("navigation_header_searchicon_XPATH");

			// click on the search icon from the header
			click("navigation_header_searchicon_XPATH");

			// enter property number in text field
			type("navigation_header_searchtxt_XPATH", "01");

			// hit enter key
			driver.findElement(By.xpath(OR.getProperty("navigation_header_searchtxt_XPATH"))).sendKeys(Keys.ENTER);
			consoleMessage("Hit enter key.");

			// validate the property name
			switchVerification("navigation_header_propertyname1_XPATH", "[DND] AAAA Risk Test Prop 01 - 01",
					"The property name is not displayed.");

			// validate the detailed location of the environmental record is displayed
			// selected or not
			try {

				String detailedlocation_actual = driver
						.findElement(
								By.cssSelector(OR.getProperty("envreports_asbestosmaterials_detailedlocationtxt_CSS")))
						.getAttribute("value");

				if (detailedlocation_actual.equals(data.get("detailed_location"))) {
					verificationFailedMessage("The detailed location of the environmental record is display.");

				} else {
					successMessage("The detailed location of the environmental record is not display as expected.");

				}
			} catch (Throwable t) {
				successMessage("The detailed location of the environmental record is not display as expected.");
			}

			// validate the detailed location of the environmental record in the listing
			// screen is displayed selected or not
			try {
				String detailedlocationlist = "//span[text()='" + data.get("detailed_location") + "']";
				boolean detailedlocationlist_actual = driver.findElement(By.xpath(detailedlocationlist)).isDisplayed();

				if (detailedlocationlist_actual == true) {
					successMessage("The newly created environmental record is display as expected.");

				} else {
					verificationFailedMessage("The newly created environmental record is not display.");

				}
			} catch (Throwable t) {
				verificationFailedMessage("The newly created environmental record is not display.");
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

		// DELETE THE ENVIRONMENTAL REPORT
		title("DELETE THE ENVIRONMENTAL REPORT");

		try {
			// click on the environmental icon from the property list page
			click("environmentalicon_CSS");

			// click on the burger menu
			click("menubtn_CSS");

			// wait for the element
			explicitWaitClickable("envreportoption_XPATH");

			// click on the Environmental Reports option
			click("envreportoption_XPATH");

			// click on the environmental record
			click("navigation_environmentnavigation_environmentalreportrecord2_XPATH");

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

			helper.deleteVerification("navigation_environmentnavigation_environmentalreportrecord2_XPATH",
					"Test Environmental Navigation Report 2");

		} catch (Throwable t) {
			verificationFailed();
		}

		// click on the home icon from the top of the screen
		click("questionnaire_homeburgermenubtn_hide_CSS");

		// wait for the element
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// DELETE THE ENVIRONMENTAL RECORD
		title("DELETE THE ENVIRONMENTAL RECORD");

		try {
			// wait for the element
			explicitWaitClickable("environmentalicon_CSS");

			// click on the environmental icon from the property list page
			click("environmentalicon_CSS");

			// click on the burger menu
			click("menubtn_CSS");

			// wait for the element
			explicitWaitClickable("envrecords_XPATH");

			// click on the environmental records
			click("envrecords_XPATH");

			// click on the Primary Hazardous Substance
			click("envrecords_primaryhazardoussubstance_XPATH");

			// click on the asbestos materials
			click("envreports_asbestosmaterials_XPATH");

			// click on the asbestos material record
			click("navigation_environmentnavigation_environmentalrecordrecord2_XPATH");

			// wait for the element
			explicitWaitClickable("envreports_asbestosmaterials_deletebtn_CSS");

			// click on the delete button
			click("envreports_asbestosmaterials_deletebtn_CSS");

			// wait for the element
			explicitWaitClickable("envreports_asbestosmaterials_modeldeletebtn_CSS");

			// click on the delete button of the confirmation model
			click("envreports_asbestosmaterials_modeldeletebtn_CSS");

			// wait for the element
			explicitWaitClickable("closetoastmsg_CSS");

			// click on the toaster close button
			click("closetoastmsg_CSS");

			// enter the newly created environmental report in the search field
			type("task_listofchecklist_filterfield_CSS", data.get("detailed_location"));

			// verify added details of the Asbestos Materials record is displayed or not
			helper.deleteVerification("navigation_environmentnavigation_environmentalrecordrecord2_XPATH",
					"Test Environmental Navigation Record 2");

		} catch (Throwable t) {
			verificationFailed();
		}

		// click on the home icon from the top of the screen
		click("questionnaire_homeburgermenubtn_hide_CSS");

		// wait for the element
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

	}

}
