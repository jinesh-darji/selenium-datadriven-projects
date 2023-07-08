package testcases.smokesuite;

import java.io.IOException;
import java.util.Hashtable;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Reporter;
import org.testng.SkipException;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import base.TestBase;
import utilities.TestUtil;

public class RR5595Morguard4Test extends TestBase {

	@Test(dataProviderClass = TestUtil.class, dataProvider = "dp")
	public void rR5595Morguard4Test(Hashtable<String, String> data) throws IOException, InterruptedException {

		execution(data, "rR5595Morguard4Test");

		// refresh the page
		driver.navigate().refresh();
		Thread.sleep(5000);
		driver.navigate().refresh();

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

		// VERIFY RESPECTIVE TASK IS CREATED SUCCESSFULLY OR NOT FOR WORKFLOW AND
		// SECURITY
		title("VERIFY RESPECTIVE TASK IS CREATED SUCCESSFULLY OR NOT FOR WORKFLOW AND SECURITY");

		try {

			// enter the property name in the search field

			type("envreports_propertylist_filtertxt_CSS", data.get("property_2"));

			// click on the environmental icon from the property list page
			click("environmentalicon_CSS");

			// wait for the element
			Thread.sleep(5000);

			// click on the burger menu
			click("menubtn_CSS");

			// wait for the element
			Thread.sleep(5000);

			// click on the survey option from side menu
			click("surveyoption_XPATH");

			// select the respective questionnaire from the dropdown
			select("survey_questionnairedd_CSS", data.get("questionnaire_title"));

			// verify respective category type displayed or not
			switchVerification("survey_categorytxt_XPATH", "PCB - Containing Equipment",
					"The PCB - Containing Equipment is not displayed.");

			// click on the workflow and security button
			click("workflowsecurity_workflowsecuritybtn_CSS");

			// click on the select user field of the editor tasks section
			click("workflowsecurity_allowtoedit_editortasks_CSS");

			// click on the none button
			click("workflowsecurity_sendnotification_nonebtn_CSS");

			// Enter data in the find user field
			type("questionnaire_createtask_findusertxt_CSS", data.get("user_name_1"));

			// select the user name from the user list
			click("workflowsecurity_editortask_selectusertxt_XPATH");

			// click on the assign to field
			click("workflowsecurity_allowtoedit_editortasks_CSS");

			// click on the due date field of editor tasks section
			click("workflowsecurity_editortask_duedate_CSS");

			// click on the today's button
			click("workflowsecurity_editortask_duedate_todaybtn_BTNTEXT");

			// scroll till the priority field
			scrollTillElement("workflowsecurity_allowtoapprove_editortasks_CSS");

			// click on the select user field of the approve tasks section
			click("workflowsecurity_allowtoapprove_editortasks_CSS");

			// click on the none button
			click("workflowsecurity_sendnotification_nonebtn_CSS");

			// enter data in the find user field
			type("questionnaire_createtask_findusertxt_CSS", data.get("user_name_1"));

			// select the user name from the user list
			click("workflowsecurity_editortask_selectusertxt_XPATH");

			// click on the assign to field
			click("workflowsecurity_allowtoapprove_editortasks_CSS");

			// click on the due date field of editor tasks section
			click("workflowsecurity_allowtoapprove_duedate_CSS");

			// click on the today's button
			click("workflowsecurity_editortask_duedate_todaybtn_BTNTEXT");

			// click on the save button
			click("workflowsecurity_editortask_savebtn_CSS");

			// wait for the element
			explicitWaitClickable("closetoastmsg_CSS");

			// click on the toaster close button
			click("closetoastmsg_CSS");

			// verify the newly created record

			switchVerification("workflowsecurity_editortask_morguard13_XPATH", "High", "The task is not created.");

			switchVerification("workflowsecurity_approvaltask_morguard13_XPATH", "High", "The task is not created.");

			// VERIFY REPECTIVE TASK IS DISPLAYED IN THE TASK LIST OR NOT
			title("VERIFY REPECTIVE TASK IS DISPLAYED IN THE TASK LIST OR NOT");

			// wait for the element
			explicitWaitClickable("workflowsecurity_editortask_morguard13_XPATH");

			// click on the editor task record
			click("workflowsecurity_editortask_morguard13_XPATH");

			// wait for the element
			Thread.sleep(5000);

			// get the data from the title field

			try {
				String str1 = driver
						.findElement(By.cssSelector(OR.getProperty("workflowsecurity_editortask_titlefield_CSS")))
						.getAttribute("value");

				if (str1.equals("Complete questionnaire Morguard - 2021 Summer - Environmental Compliance Audit")) {
					successMessage("THE EDITOR TASK IS CREATED SUCCESSFULLY.");
				} else {
					verificationFailedMessage("THE EDITOR TASK IS NOT CREATED.");
				}
			} catch (Throwable t) {
				verificationFailed();

			}

			// wait for the element
			explicitWaitClickable("task_tasktag_taskscreen_deletebtn_CSS");

			// click on the delete button
			click("task_tasktag_taskscreen_deletebtn_CSS");

			// click on the delete button of the confirmation popup
			click("task_deletedtaskbtn_confirmaiton_CSS");

			// wait for the element
			explicitWaitClickable("closetoastmsg_CSS");

			// click on the toaster close button
			click("closetoastmsg_CSS");

			// verify deleted task is displayed or not
			deleteVerification("workflowsecurity_editortask_morguard13_XPATH", "High");

			// scrolldown the screen
			scrollByPixel(200);

			// wait for the element
			explicitWaitClickable("workflowsecurity_approvaltask_morguard13_XPATH");

			// click on the approval task record
			click("workflowsecurity_approvaltask_morguard13_XPATH");

			// wait for the element
			Thread.sleep(5000);

			// get the data from the title field

			try {
				String str2 = driver
						.findElement(By.cssSelector(OR.getProperty("workflowsecurity_editortask_titlefield_CSS")))
						.getAttribute("value");

				if (str2.equals("Approve/Lock questionnaire Morguard - 2021 Summer - Environmental Compliance Audit")) {
					successMessage("THE APPROVAL TASK IS CREATED SUCCESSFULLY.");
				} else {
					verificationFailedMessage("THE APPROVAL TASK IS NOT CREATED.");
				}
			} catch (Throwable t) {
				verificationFailed();
			}

			// wait for the element
			explicitWaitClickable("task_tasktag_taskscreen_deletebtn_CSS");

			// click on the delete button
			click("task_tasktag_taskscreen_deletebtn_CSS");

			// click on the delete button of the confirmation popup
			click("task_deletedtaskbtn_confirmaiton_CSS");

			// wait for the element
			explicitWaitClickable("closetoastmsg_CSS");

			// click on the toaster close button
			click("closetoastmsg_CSS");

			// verify deleted task is displayed or not
			deleteVerification("workflowsecurity_approvaltask_morguard13_XPATH", "High");

			// click on the save button
			click("workflowsecurity_editortask_savebtn_CSS");

			// wait for the element
			explicitWaitClickable("closetoastmsg_CSS");

			// click on the toaster close button
			click("closetoastmsg_CSS");

		} catch (Throwable t) {

			verificationFailed();
		}

		// click on the home option from the side menu
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