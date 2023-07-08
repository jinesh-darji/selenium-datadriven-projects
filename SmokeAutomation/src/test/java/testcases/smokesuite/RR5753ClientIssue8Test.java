package testcases.smokesuite;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.SkipException;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import base.TestBase;
import net.bytebuddy.asm.Advice.Local;
import utilities.TestUtil;

public class RR5753ClientIssue8Test extends TestBase {

	@Test(dataProviderClass = TestUtil.class, dataProvider = "dp")
	public void rR5753ClientIssue8Test(Hashtable<String, String> data) throws IOException, InterruptedException {

		execution(data, "rR5753ClientIssue8Test");

		// refresh the page
		driver.navigate().refresh();
		Thread.sleep(5000);
		driver.navigate().refresh();

		// AUTO-TASK DETAILS IS DISPLAYED IN SURVEY CLASSIC VIEW WHEN CONFIGURED FOR THE
		// COMMENT OPTION - RR-5906
		title("AUTO-TASK DETAILS IS DISPLAYED IN SURVEY CLASSIC VIEW WHEN CONFIGURED FOR THE COMMENT OPTION - RR-5906");

		// LOGIN WITH ADMIN USER
		title("LOGIN WITH ADMIN USER");

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

		// VERIFY AUTO TASK DETAILS AT SURVEY LEVEL
		title("VERIFY AUTO TASK DETAILS AT SURVEY LEVEL");

		try {

			// enter the property name in the search field
			type("envreports_propertylist_filtertxt_CSS", data.get("property_1"));

			// click on the environmental icon from the property list page
			click("environmentalicon_CSS");

			// wait for the element
			Thread.sleep(5000);

			// click on the burger menu
			click("menubtn_CSS");

			// wait for the element
			Thread.sleep(5000);

			// click on the surveys option from side menu
			click("surveyoption_XPATH");

			// wait for 3 seconds
			Thread.sleep(3000);

			// select the respective questionnaire
			select("survey_questionnairedd_CSS", data.get("questionnaire_title"));

			// wait for the element
			explicitWait("survey_categoryname_risk_XPATH");

			// clear respective the comment box

			scrollByPixel(300);

			scrollTop();

			// enter the details in the comment box 1 of the category 1 question 1

			type("survey_commentbox1_risk_XPATH", data.get("comment_1"));

			// enter the details in the comment box 2 of the category 1 question 1

			type("survey_commentbox2_risk_XPATH", data.get("comment_2"));

			// click on the Managing Agent Systems category label
			click("survey_categoryname_risk_XPATH");

			// wait for the element
			Thread.sleep(5000);

			// scroll down the screen
			scrollByPixel(600);

			// verify validation 1
			switchVerification("survey_autotask_validation1_risk_XPATH", "Task/Action",
					"The Task/Action text is not displayed.");

			// verify validation 2
			switchVerification("survey_autotask_validation2_risk_XPATH", "(1) Risk Control Management System",
					"The (1) Risk Control Management System text is not displayed.");

			// verify validation 3
			switchVerification("survey_autotask_validation3_risk_XPATH", "Assigned To: Property Manager",
					"The Assigned To: Property Manager text is not displayed.");

			// verify validation 4
			LocalDate currentDate = LocalDate.now();
			LocalDate futureDate = currentDate.plusYears(1);
			String futureDateString = futureDate.toString();

			try {
				String duedate = (driver.findElement(By.xpath(OR.getProperty("survey_autotask_validation5_risk_XPATH")))
						.getAttribute("value")).trim();

				if (duedate.equals(futureDateString)) {
					successMessage("The due date is verified successfully.");
				} else {
					verificationFailed();
				}
			} catch (Throwable t) {
				verificationFailedMessage("The due date is displayed incorrect.");
			}

			// scroll down the screen
			scrollByPixel(400);

			// enter the details in the comment box 1 of the category 1 question 2

			type("survey_commentbox3_risk_XPATH", data.get("comment_3"));

			// enter the details in the comment box 2 of the category 1 question 2

			type("survey_commentbox4_risk_XPATH", data.get("comment_4"));

			// click on the Hazardous Building Materials category label
			click("survey_categoryname2_risk_XPATH");

			// wait for the element
			Thread.sleep(5000);

			// scroll down the screen
			scrollByPixel(400);

			// verify validation 4
			switchVerification("survey_autotask_validation4_risk_XPATH", "(1) Contractor Management System",
					"The (1) Contractor Management System text is not displayed.");

		} catch (Throwable t) {
			verificationFailed();
		}

		// click on the home icon from the top of the screen
		click("questionnaire_homeburgermenubtn_hide_CSS");

		// synchronization
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// GENERATE THE AUTO TASKS IN THE TASK MODULE
		title("GENERATE THE AUTO TASKS IN THE TASK MODULE");

		try {
			// enter the property name in the search field
			type("envreports_propertylist_filtertxt_CSS", data.get("property_1"));

			// click on the task icon from the property list page
			click("taskicon_CSS");

			// wait for the clear button
			explicitWaitClickable("task_clearbtn_XPATH");

			// click on the clear button
			click("task_clearbtn_XPATH");

			// enter auto generated task in the search field
			type("survey_task_searchfield_CSS", data.get("autotask_1"));

			// click on the search button
			click("survey_task_searchfield_CSS");

			// verify the auto generated task 1
			switchVerification("survey_autotask1_risk_XPATH", "Risk Control Management System",
					"The Risk Control Management System task is not displayed.");

			// click on the clear button
			click("task_clearbtn_XPATH");

			// enter auto generated task in the search field
			type("survey_task_searchfield_CSS", data.get("autotask_2"));

			// click on the search button
			click("survey_task_searchfield_CSS");

			// verify the auto generated task 2
			switchVerification("survey_autotask2_risk_XPATH", "Contractor Management System",
					"The Contractor Management System task is not displayed.");

		} catch (Throwable t) {
			verificationFailed();
		}

		// click on the home icon from the top of the screen
		click("questionnaire_homeburgermenubtn_hide_CSS");

		// synchronization
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// REMOVE THE DETAILS FROM THE COMMENT BOXES
		title("REMOVE THE DETAILS FROM THE COMMENT BOXES");

		try {

			// enter the property name in the search field
			type("envreports_propertylist_filtertxt_CSS", data.get("property_1"));

			// click on the environmental icon from the property list page
			click("environmentalicon_CSS");

			// wait for the element
			Thread.sleep(5000);

			// click on the burger menu
			click("menubtn_CSS");

			// wait for the element
			Thread.sleep(5000);

			// click on the surveys option from side menu
			click("surveyoption_XPATH");

			// wait for 3 seconds
			Thread.sleep(3000);

			// select the respective questionnaire
			select("survey_questionnairedd_CSS", data.get("questionnaire_title"));

			// wait for the element
			explicitWait("survey_categoryname_risk_XPATH");

			// click on the Managing Agent Systems category label
			click("survey_categoryname_risk_XPATH");

			// wait for the element
			Thread.sleep(5000);

			// scroll down the screen

			scrollByPixel(400);

			// verify validation 2
			deleteVerification("survey_autotask_validation2_risk_XPATH", "(1) Risk Control Management System");

			// scroll down the screen
			scrollByPixel(300);

			// click on the Hazardous Building Materials category label
			click("survey_categoryname2_risk_XPATH");

			// wait for the element
			Thread.sleep(5000);

			// verify validation 4
			deleteVerification("survey_autotask_validation4_risk_XPATH", "(1) Contractor Management System");

		} catch (Throwable t) {
			verificationFailed();
		}

		// click on the home icon from the top of the screen
		click("questionnaire_homeburgermenubtn_hide_CSS");

		// synchronization
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// REMOVE THE AUTO GENERATED TASKS IN THE TASK MODULE
		title("REMOVE THE AUTO GENERATED TASKS IN THE TASK MODULE");

		try {
			// enter the property name in the search field
			type("envreports_propertylist_filtertxt_CSS", data.get("property_1"));

			// click on the task icon from the property list page
			click("taskicon_CSS");

			// wait for the clear button
			explicitWaitClickable("task_clearbtn_XPATH");

			// click on the clear button
			click("task_clearbtn_XPATH");

			// enter auto generated task in the search field
			type("survey_task_searchfield_CSS", data.get("autotask_1"));

			// click on the search button
			click("survey_task_searchfield_CSS");

			// verify the auto generated task 1
			deleteVerification("survey_autotask1_risk_XPATH", "Risk Control Management System");

			// click on the clear button
			click("task_clearbtn_XPATH");

			// enter auto generated task in the search field
			type("survey_task_searchfield_CSS", data.get("autotask_2"));

			// click on the search button
			click("survey_task_searchfield_CSS");

			// verify the auto generated task 2
			deleteVerification("survey_autotask2_risk_XPATH", "Contractor Management System");

		} catch (Throwable t) {
			verificationFailed();
		}

		// click on the home icon from the top of the screen
		click("questionnaire_homeburgermenubtn_hide_CSS");

		// synchronization
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		try {
			// wait for the 5 seconds
			Thread.sleep(5000);

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