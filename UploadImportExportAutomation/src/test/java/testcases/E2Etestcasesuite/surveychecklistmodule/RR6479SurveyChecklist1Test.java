package testcases.E2Etestcasesuite.surveychecklistmodule;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.TestBase;
import utilities.TestUtil;

public class RR6479SurveyChecklist1Test extends TestBase {

	@Test(dataProviderClass = TestUtil.class, dataProvider = "dp")
	public void rR6479SurveyChecklist1Test(Hashtable<String, String> data) throws IOException, InterruptedException {

		execution(data, "rR6479SurveyChecklist1Test");

		// VALIDATE THE DOWNLOADED PDF REPORT OF THE INSPECTION WITH AUTO GENERATED TASK
		// AND ATTACHMENTS

		title("VALIDATE THE DOWNLOADED PDF REPORT OF THE INSPECTION WITH AUTO GENERATED TASK AND ATTACHMENTS");

		// refresh the page
		driver.navigate().refresh();
		Thread.sleep(5000);
		driver.navigate().refresh();

		// ADD NEW QUESTIONNIRE FOR INSPECTION
		title("ADD NEW QUESTIONNIRE FOR INSPECTION");

		String questionnaireTitle = RandomStringUtils.randomAlphabetic(8);
		String inspectionTitle = RandomStringUtils.randomAlphabetic(8);
		LocalDate today = LocalDate.now();
		String today_string = today.toString();

		try {
			// wait for the element
			explicitWaitClickable("questionnaire_settingicon_CSS");

			// click on the settings icon from the top of the screen
			click("questionnaire_settingicon_CSS");

			// wait for the element
			explicitWaitClickable("questionnaire_administrationoption_XPATH");

			// click on the Administration option from the side menu
			click("questionnaire_administrationoption_XPATH");

			// click on the Questionnaires tab
			click("questionnaire_questionnairestab_XPATH");

			// click on the Questionnaires option
			click("questionnaire_questionnairesoption_XPATH");

			// click on the new questionnaire
			click("questionnaire_newquestionnairebtn_CSS");

			// Select the Inspection / Checklist of the questionnaire
			click("questionnaire_type_inspectionbtn_CSS");

			// Select the level of the questionnaire
			click("questionnaire_level_propertybtn_CSS");

			// enter the group title
			type("questionnaire_grouptitletxt_CSS", data.get("group_title"));

			// enter the questionnaire title
			type("questionnaire_languagetitle_CSS", questionnaireTitle);

			// select the model
			select("questionnaire_modeldd_CSS", data.get("model"));

			// select the frequency
			select("questionnaire_frequencydd_CSS", data.get("frequency"));

			// enter frequency interval
			type("questionnaire_frequencyintervaltxt_CSS", "1");

			// select the month
			select("questionnaire_monthtxt_CSS", data.get("month"));

			// enter the description
			type("questionnaire_descriptiontxt_CSS", data.get("description"));

			// select the classic option from the default view drop down
			select("questionnaire_checklist_defaultview_CSS", data.get("default_view"));

			// scroll down to the save button
			scrollBottom();

			// click on the save button
			click("questionnaire_savebtn_BTNTEXT");

			// enter newly created questionnaire in the filter field
			type("ssc_company2_questionnairelist_filtertxt_CSS", questionnaireTitle);

			// verify newly created questionnaire for checklist
			try {
				String str2 = "//td[contains(text(),'" + questionnaireTitle + "')]";
				String str2_actual = (driver.findElement(By.xpath(str2)).getText()).trim();

				if (str2_actual.equals(questionnaireTitle)) {

					successMessage("The newly created inspection is verified successfully.");

				} else {
					verificationFailedMessage("The newly created inspection is not verified.");
				}

			} catch (Throwable t) {
				verificationFailedMessage("The newly created inspection is not verified.");
			}

			// CONFIGRATION OF QUESTION
			title("CONFIGRATION OF QUESTION");

			// click on the created questionnaire
			String str2 = "//td[contains(text(),'" + questionnaireTitle + "')]";
			driver.findElement(By.xpath(str2)).click();
			consoleMessage("Clicked on the newly created questionnaire for checklist.");

			// scroll till the more button
			scrollTillElement("questionnaire_type_propertybtn_CSS");

			// click on the more button
			click("questionnaire_morebtn_CSS");

			// click on the configure questions option
			click("questionnaire_configurebtn_CSS");

			// ADD CATEGORY 1 INTO THE QUESTIONNAIRE
			title("ADD CATEGORY 1 INTO THE QUESTIONNAIRE");

			// click on the new category button
			click("questionnaire_newcategorybtn_BTNTEXT");

			// select the language
			select("questionnaire_newcategory_languagedd_XPATH", data.get("category_language"));

			// enter the title
			type("questionnaire_newcategory_titletxt_MODEL", data.get("category_title_1"));

			// click on the save button
			click("questionnaire_newcategory_savebtn_CSS");

			// verify newly created category is displayed or not
			switchVerification("questionnaire_newcategory_1_XPATH", "Test Category Title One",
					"The Test Category Title One is not displayed.");

			// ADD CATEGORY 2 INTO THE QUESTIONNAIRE
			title("ADD CATEGORY 2 INTO THE QUESTIONNAIRE");

			// click on the new category button
			click("questionnaire_newcategorybtn_BTNTEXT");

			// select the language
			select("questionnaire_newcategory_languagedd_XPATH", data.get("category_language"));

			// enter the title
			type("questionnaire_newcategory_titletxt_MODEL", data.get("category_title_2"));

			// click on the save button
			click("questionnaire_newcategory_savebtn_CSS");

			// verify newly created category is displayed or not
			switchVerification("questionnaire_newcategory_2_XPATH", "Test Category Title Two Two",
					"The Test Category Title Two Two is not displayed.");

			// ADD QUESTION 1 INTO THE CATEGORY 1
			title("ADD QUESTION 1 INTO THE CATEGORY 1");

			// click on the save button for save all categories
			click("questionnaire_category_savebtn_CSS");

			// wait for the element
			explicitWaitClickable("closetoastmsg_CSS");

			// click on the toaster close button
			click("closetoastmsg_CSS");

			// click on the edit button of category one
			click("questionnaire_category_editbtn_CSS");

			// click on the edit question button
			click("questionnaire_category_editquestionbtn_BTNTEXT");

			// click on the new question button
			click("questionnaire_newquestionbtn_CSS");

			// select the English language from the language dropdown
			select("questionnaire_newquestion_languagedd_CSS", data.get("question_language"));

			// enter the label
			type("questionnaire_newquestion_labeltxt_CSS", data.get("question_label_1"));

			// enter the title
			type("questionnaire_newquestion_titletxt_CSS", data.get("question_title_1"));

			// click on the save button
			click("questionnaire_newquestion_savebtn_CSS");

			// verify question one created or not
			switchVerification("questionnaire_newquestion_1_XPATH", "Test Question Title One",
					"The Test Question Title One is not displayed.");

			// click on the new question button
			click("questionnaire_newquestionbtn_CSS");

			// select the English language from the language dropdown
			select("questionnaire_newquestion_languagedd_CSS", data.get("question_language"));

			// enter the label
			type("questionnaire_newquestion_labeltxt_CSS", data.get("question_label_2"));

			// enter the title
			type("questionnaire_newquestion_titletxt_CSS", data.get("question_title_2"));

			// click on the save button
			click("questionnaire_newquestion_savebtn_CSS");

			// verify question one created or not
			switchVerification("questionnaire_newquestion_2_XPATH", "Test Question Title Two Two",
					"The Test Question Title Two Two is not displayed.");

			// click on the save button of the questions
			click("questionnaire_saveallquestionbtn_CSS");

			// click on the edit question 1 button
			click("questionnaire_question_1_editbtn_CSS");

			// CREATE THE AUTO GENERATE TASK
			title("CREATE THE AUTO GENERATE TASK");

			// wait for the element
			Thread.sleep(3000);

			// click on the task icon of the no option
			click("questionnaire_question_1_yestaskicon_CSS");

			// click on the non-compliant checkbox
			click("questionnaire_createtask_noncompliantbtn_CSS");

			// click on the create a task checkbox
			click("questionnaire_createtask_createataskbtn_CSS");

			// enter data in the task title field
			type("questionnaire_createtask_tasktitletxt_CSS", data.get("task_title"));

			// enter data in the due date field
			type("questionnaire_createtask_duedatetxt_CSS", "30");

			// click on the assign to field
			click("questionnaire_createtask_assigntotxt_CSS");

			// scroll till the find user field
			scrollByPixel(400);

			// Enter data in the find user field
			type("questionnaire_createtask_findusertxt_CSS", data.get("task_find_user"));

			// select the user name from the user list
			click("questionnaire_createtask_selectusertxt_XPATH");

			// click on the assign to field
			click("questionnaire_createtask_assigntotxt_CSS");

			// click on the allow task edit checkbox
			click("questionnaire_createtask_allowtaskeditbtn_CSS");

			// click on the task tag field
			click("questionnaire_createtask_tasktagtxt_CSS");

			// Enter data in the find task field
			type("questionnaire_createtask_findtasktagtxt_CSS", data.get("task_find_task"));

			// select the user name from the user list
			click("questionnaire_createtask_selecttasktagtxt_XPATH");

			// click on the task tag field
			click("questionnaire_createtask_tasktagtxt_CSS");

			// click on the save button
			click("questionnaire_createtask_savebtn_CSS");

			// click on the save button for save all questions
			click("questionnaire_saveallquestionbtn_CSS");

			// wait for the element
			explicitWaitClickable("closetoastmsg_CSS");

			// click on the toaster close button
			click("closetoastmsg_CSS");

			// wait for the element
			Thread.sleep(3000);

			// click on the edit question 1 button
			click("questionnaire_question_1_editbtn_CSS");

			// scroll till the Comments and Instructions field
			scrollTillElement("questionnaire_question_1_commentandinstructiontxt_CSS");

			// enter the data in the Comments and Instructions field
			type("questionnaire_question_1_commentandinstructiontxt_CSS", data.get("comment_instruction_1"));

			// click on the option button
			click("questionnaire_question_1_optionbtn_CSS");

			// ADD OPTION ONE IN THE QUESTION
			title("ADD OPTION ONE IN THE QUESTION");

			// click on the save button for all options
			click("questionnaire_question_1_savealloptionbtn_CSS");

			// wait for the element
			Thread.sleep(3000);

			// click on the new option button
			click("questionnaire_question_1_newoptionbtn_CSS");

			// wait for the element
			explicitWait("questionnaire_question_1_newoption_1_titletext_CSS");

			// enter data in title of the option of the question 1
			type("questionnaire_question_1_newoption_1_titletext_CSS", data.get("title_option_1_question_1"));

			// select data in type of the option of the question 1
			select("questionnaire_question_1_newoption_1_typetext_CSS", data.get("type_option_1_question_1"));

			// enter data in extra of the option of the question 1
			type("questionnaire_question_1_newoption_1_extratext_CSS", data.get("extra_option_1_question_1"));

			// wait for the element
			Thread.sleep(3000);

			// click on the save button
			click("questionnaire_question_1_newoption_1_savebtn_CSS");

			// click on the save button for all options
			click("questionnaire_question_1_savealloptionbtn_CSS");

			// click on the back to questions button
			click("questionnaire_question_1_option_backtoquestionsbtn_CSS");

			// click on the save button for save all question
			click("questionnaire_saveallquestionbtn_CSS");

			// wait for the element
			explicitWaitClickable("closetoastmsg_CSS");

			// click on the toaster close button
			click("closetoastmsg_CSS");

			// click on the back to category button
			click("questionnaire_question_1_backtocategorybtn_CSS");

			// click on the save button for save all categories
			click("questionnaire_category_savebtn_CSS");

			// wait for the element
			explicitWaitClickable("closetoastmsg_CSS");

			// click on the toaster close button
			click("closetoastmsg_CSS");

			// click on the back to questionnaire button
			click("questionnaire_category_backtoquestionnairesbtn_CSS");

			// enter newly created questionnaire in the filter field
			type("ssc_company2_questionnairelist_filtertxt_CSS", questionnaireTitle);

			// verify newly created questionnaire for checklist
			try {
				str2 = "//td[contains(text(),'" + questionnaireTitle + "')]";
				String str2_actual = (driver.findElement(By.xpath(str2)).getText()).trim();

				if (str2_actual.equals(questionnaireTitle)) {

					successMessage("The newly created inspection is verified successfully.");

				} else {
					verificationFailedMessage("The newly created inspection is not verified.");
				}

			} catch (Throwable t) {
				verificationFailedMessage("The newly created inspection is not verified.");
			}

		} catch (Throwable t) {
			verificationFailed();
		}

		// click on the Home Icon from the top of the screen
		click("questionnaire_homeburgermenubtn_CSS");

		// wait for the element
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// CREATE INSPECTION AT PROPERTY LEVEL
		title("CREATE INSPECTION AT PROPERTY LEVEL");

		try {
			// click on the environmental icon from the property list page
			click("environmentalicon_CSS");

			// wait for the element
			explicitWaitClickable("menubtn_CSS");

			// click on the burger menu
			click("menubtn_CSS");

			// wait for the element
			Thread.sleep(5000);

			// click on the checklist/inspection option from side menu
			click("checklist_sidemenu_XPATH");

			// click on the new checklist button
			click("checklist_newchecklistbtn_CSS");

			try {
				// wait for the element
				explicitWait("checklist_addchecklist_checklisttypedd_CSS");

				// collect all options of the dropdown
				Select dropdown = new Select(driver
						.findElement(By.cssSelector(OR.getProperty("checklist_addchecklist_checklisttypedd_CSS"))));

				// Get all options
				List<WebElement> dd = dropdown.getOptions();

				// Loop to print one by one
				for (int j = 0; j < dd.size(); j++) {
					String checklist = dd.get(j).getText();
					try {
						if (checklist.equals(questionnaireTitle)) {

							successMessage("The checklist is displayed successfully.");

							// select the questionnaire option from the checklist type dropdown
							select("checklist_addchecklist_checklisttypedd_CSS", questionnaireTitle);

							// enter data in the checklist title field
							type("checklist_addchecklist_titletxt_CSS", inspectionTitle);

							// click on the save button
							click("checklist_addchecklist_savebtn_CSS");

							// verify questionnaire is selected correctly or not
							switchVerification("questionnaire_questiontitle_XPATH", "Test Category Title One",
									"The Test Category Title One is not displayed.");

						}
					} catch (Throwable t) {

						verificationFailedMessage(" The " + questionnaireTitle + " is not displayed in the dropdown.");

						// click on the close button of the add checklist popup
						click("checklist_addchecklist_dltbtn_XPATH");

					}
				}
			} catch (Throwable t) {
				verificationFailed();
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

		// GENERATE THE AUTO TASK AND CREATE THE NEW TASK IN CATEGORY
		title("GENERATE THE AUTO TASK AND CREATE THE NEW TASK IN CATEGORY");

		try {
			// click on the environmental icon from the property list page
			click("environmentalicon_CSS");

			// wait for the element
			explicitWaitClickable("menubtn_CSS");

			// click on the burger menu
			click("menubtn_CSS");

			// wait for the element
			Thread.sleep(5000);

			// click on the checklist/inspection option from side menu
			click("checklist_sidemenu_XPATH");

			// enter the inspection name in the search field
			type("sustainability_searchtxt_XPATH", questionnaireTitle);

			// click on the newly searched inspection
			String inspection = "//td[text()='" + questionnaireTitle + "']";
			driver.findElement(By.xpath(inspection)).click();
			consoleMessage("Clicked on the newly searched inspection.");

			// verify questionnaire is selected correctly or not
			switchVerification("questionnaire_questiontitle_XPATH", "Test Category Title One",
					"The Test Category Title One is not displayed.");

			// click on the yes checkbox
			click("survey_yesanswerbtn_1_CSS");

			// click on the no checkbox
			click("survey_noanswerbtn_2_CSS");

			// enter the text in the option field
			type("survey_option_q1o1_CSS", data.get("question1_option"));

			// click on the category 1 question 1 label
			click("checklist_category_1_question_1_XPATH");

			// click on the action button
			click("questionnaire_createtask_actionbtn_XPATH");

			// click on the add task option
			click("questionnaire_createtask_addtaskoption_XPATH");

			// enter the data in the task title field
			type("task_addtask_titletxt_CSS", data.get("task_title2"));

			// enter the data in the task location field
			type("task_addtask_locationtxt_CSS", data.get("task_location"));

			// click on the assign to field
			click("task_inspection_assignuser1_XPATH");

			// click on the none button
			click("task_tasktag_nonebtn_CSS");

			// enter the user name in the search field
			type("checklist_wizard_task_assignedtosearchtxt_XPATH", data.get("task_find_user"));

			// click on the searched result
			click("questionnaire_createtask_selectusertxt_XPATH");

			// click on the assign to field
			click("task_inspection_assignuser1_XPATH");

			// scroll dwon the screen
			scrollByPixel(300);

			// click on the upload file button
			click("inspection_task_uploadbtn_XPATH");

			// wait for the element
			Thread.sleep(5000);

			// upload the first document
			uploadFile(System.getProperty("user.dir") + "\\src\\test\\resources\\logs\\Image_3.jpg");

			// wait for the element
			Thread.sleep(5000);

			// scroll down
			scrollBottom();

			// validate the uploaded document
			try {
				String documentTitle = "//span[text()='Image_3.jpg' and @class='ng-binding ng-scope']";
				String documentTitle_actual = (driver.findElement(By.xpath(documentTitle)).getText()).trim();

				if (documentTitle_actual.equals("Image_3.jpg")) {
					successMessage("The uploaded document is displayed successfully.");
				} else {
					verificationFailedMessage("The uploaded document is not displayed.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The uploaded document is not displayed.");
			}

			// enter the comment in the uploaded document
			String documentTaskComment = "//span[text()='Image_3.jpg' and @class='ng-binding ng-scope']//parent::td[@class='pointer-underline']//following-sibling::td//div[@class='ng-scope']//textarea[@ng-model='attachment.shortDescription']";
			driver.findElement(By.xpath(documentTaskComment)).sendKeys(data.get("newtask_documentcomment"));
			consoleMessage("Entered the comment in the uploaded document.");

			// click on the save button
			click("questionnaire_inspection_addtask_savebtn_XPATH");

		} catch (Throwable t) {
			verificationFailed();
		}

		// click on the home icon from the top of the screen
		click("questionnaire_homeburgermenubtn_hide_CSS");

		// wait for the element
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// VERIFY AUTO GENERATED TASK IS DISPLAYED OR NOT IN TASK MODULE AND UPLOAD THE
		// DOCUMENT IN THE TASK
		title("VERIFY AUTO GENERATED TASK IS DISPLAYED OR NOT IN TASK MODULE AND UPLOAD THE DOCUMENT IN THE TASK");

		try {
			// click on the task icon of the respective property
			click("taskicon_CSS");

			// click on the clear button
			click("task_createdtask_clearbtn_XPATH");

			// enter the data in the search field
			type("task_filter_CSS", data.get("task_title"));

			// click on the search button
			click("task_createdtask_searchbtn_XPATH");

			// verify the auto generated task is displayed or not
			switchVerification("task_createdtask_pdfinspection1_XPATH", "PDF Verification Auto Task Title 1",
					"The PDF Verification Auto Task Title 1 is not displayed.");

			// click on the auto task record
			click("task_createdtask_pdfinspection1_XPATH");

			// click on the attachement tab
			click("inspection_task_attachementtab_XPATH");

			// scroll dwon the screen
			scrollByPixel(300);

			// click on the upload file button
			click("inspection_task_uploadbtn_XPATH");

			// wait for the element
			Thread.sleep(5000);

			// upload the first document
			uploadFile(System.getProperty("user.dir") + "\\src\\test\\resources\\logs\\Image_2.jpg");

			// wait for the element
			Thread.sleep(5000);

			// scroll down
			scrollBottom();

			// validate the uploaded document
			try {
				String documentTitle = "//span[text()='Image_2.jpg' and @class='ng-binding ng-scope']";
				String documentTitle_actual = (driver.findElement(By.xpath(documentTitle)).getText()).trim();

				if (documentTitle_actual.equals("Image_2.jpg")) {
					successMessage("The uploaded document is displayed successfully.");
				} else {
					verificationFailedMessage("The uploaded document is not displayed.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The uploaded document is not displayed.");
			}

			// enter the comment in the uploaded document
			String documentTaskComment = "//span[text()='Image_2.jpg' and @class='ng-binding ng-scope']//parent::td[@class='pointer-underline']//following-sibling::td//div[@class='ng-scope']//textarea[@ng-model='attachment.shortDescription']";
			driver.findElement(By.xpath(documentTaskComment)).sendKeys(data.get("autotask_documentcomment"));
			consoleMessage("Entered the comment in the uploaded document.");

			// click on the update icon of the uploaded file in the task
			String updateTaskComment = "//span[text()='Image_2.jpg' and @class='ng-binding ng-scope']//parent::td[@class='pointer-underline']//following-sibling::td//li[@title='Update']//i[@ng-click='updateAttachment(attachment)']";
			driver.findElement(By.xpath(updateTaskComment)).click();
			consoleMessage("Clicked on the update icon of the uploaded file in the task.");

			// click on the update button
			click("checklist_wizard_task_savebtn_XPATH");

		} catch (Throwable t) {
			verificationFailed();
		}

		// click on the Home button
		click("questionnaire_homeburgermenubtn_hide_CSS");

		// wait for the element
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// UPLOAD THE DOCUMENT IN THE INSPECTION
		title("UPLOAD THE DOCUMENT IN THE INSPECTION");

		try {
			// click on the environmental icon from the property list page
			click("environmentalicon_CSS");

			// wait for the element
			explicitWaitClickable("menubtn_CSS");

			// click on the burger menu
			click("menubtn_CSS");

			// wait for the element
			Thread.sleep(5000);

			// click on the checklist/inspection option from side menu
			click("checklist_sidemenu_XPATH");

			// enter the inspection name in the search field
			type("sustainability_searchtxt_XPATH", questionnaireTitle);

			// click on the newly searched inspection
			String inspection = "//td[text()='" + questionnaireTitle + "']";
			driver.findElement(By.xpath(inspection)).click();
			consoleMessage("Clicked on the newly searched inspection.");

			// verify questionnaire is selected correctly or not
			switchVerification("questionnaire_questiontitle_XPATH", "Test Category Title One",
					"The Test Category Title One is not displayed.");

			// click on the switch to wizard mode icon
			click("checklist_switchtowizardmodeicon_XPATH");

			// click on the attachment tab
			click("checklist_attachmenttab_XPATH");

			// scroll down
			scrollBottom();

			// click on the upload file button
			click("inspection_task_uploadbtn_XPATH");

			// wait for the element
			Thread.sleep(5000);

			// upload the first document
			uploadFile(System.getProperty("user.dir") + "\\src\\test\\resources\\logs\\Image_1.jpg");

			// wait for the element
			Thread.sleep(5000);

			// scroll down
			scrollBottom();

			// validate the uploaded document
			try {
				String documentTitle = "//span[text()='Image_1.jpg' and @class='ng-binding ng-scope']";
				String documentTitle_actual = (driver.findElement(By.xpath(documentTitle)).getText()).trim();

				if (documentTitle_actual.equals("Image_1.jpg")) {
					successMessage("The uploaded document is displayed successfully.");
				} else {
					verificationFailedMessage("The uploaded document is not displayed.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The uploaded document is not displayed.");
			}

			// enter the comment in the uploaded document
			String documentTaskComment = "//span[text()='Image_1.jpg' and @class='ng-binding ng-scope']//parent::td[@class='pointer-underline']//following-sibling::td//div[@class='ng-scope']//textarea[@ng-model='attachment.shortDescription']";
			driver.findElement(By.xpath(documentTaskComment)).sendKeys(data.get("documentcomment"));
			consoleMessage("Entered the comment in the uploaded document.");

			// click on the save button
			click("inspection_attachment_savebtn_XPATH");

		} catch (Throwable t) {
			verificationFailed();
		}

		// click on the Home button
		click("questionnaire_homeburgermenubtn_hide_CSS");

		// wait for the element
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// VALIDATE THE PDF FILE OF THE NEWLY CREATED INSPECTION FROM THE INSPECTION
		// LIST SCREEN
		title("VALIDATE THE PDF FILE OF THE NEWLY CREATED INSPECTION FROM THE INSPECTION LIST SCREEN");

		try {
			// click on the environmental icon from the property list page
			click("environmentalicon_CSS");

			// wait for the element
			explicitWaitClickable("menubtn_CSS");

			// click on the burger menu
			click("menubtn_CSS");

			// wait for the element
			Thread.sleep(5000);

			// click on the checklist/inspection option from side menu
			click("checklist_sidemenu_XPATH");

			// enter the inspection name in the search field
			type("sustainability_searchtxt_XPATH", questionnaireTitle);

			// click on the action icon
			String actionIcon = "//td[text()='" + questionnaireTitle
					+ "']//following-sibling::td[@class='text-center pointer']//div[@class='dropdown']//i[@id='action']";
			driver.findElement(By.xpath(actionIcon)).click();
			consoleMessage("Clicked on the action icon.");

			// click on the print option
			String printOption = "//td[text()='" + questionnaireTitle
					+ "']//following-sibling::td[@class='text-center pointer']//div[@class='dropdown open']//li[@id='print-checklist']";
			driver.findElement(By.xpath(printOption)).click();
			consoleMessage("Clicked on the print option.");

			// ********** ADD THE LATEST FILE FETCH CODE **********

			// wait for the element
			Thread.sleep(15000);

			File downloaded = getLastModified("C:\\Users\\Jinesh\\Downloads");
			String path_string = downloaded.toString();
			System.out.println(path_string);
			String final_path = "file:///" + path_string;
			consoleMessage("Final path of the downloaded file: " + final_path);

			try {
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("window.open('about:blank','_blank');");
				consoleMessage("New tab is opened successfully.");

				ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
				driver.switchTo().window(tabs2.get(1));
				consoleMessage("Move to newly opened tab successfully.");

				// wait for the element
				Thread.sleep(3000);

				driver.get(final_path);
				consoleMessage("Entered the final path in the newly opened tab.");

				String pdfContent = readPdfContent(final_path);
				Thread.sleep(10000);

				// validate the inspection title
				try {
					Assert.assertTrue(pdfContent.contains(inspectionTitle));
					consoleMessage("The inspection title is displayed successfully.");
				} catch (Throwable t) {
					verificationFailedMessage("The inspection title is not displayed.");
				}

				// validate the today's date
				try {
					Assert.assertTrue(pdfContent.contains(today_string));
					consoleMessage("The Date of Inspection is displayed correctly.");
				} catch (Throwable t) {
					verificationFailedMessage("The Date of Inspection is not displayed.");
				}

				// Validate the property name
				try {
					Assert.assertTrue(pdfContent.contains(data.get("propertyname")));
					consoleMessage("The property name is displayed successfully.");
				} catch (Throwable t) {
					verificationFailedMessage("The property name is not displayed.");
				}

				// scroll down
				scrollByPixel(300);

				// Validate the category one name
				try {
					Assert.assertTrue(pdfContent.contains(data.get("category_title_1")));
					consoleMessage("The category one name i.e. " + data.get("category_title_1")
							+ " is displayed successfully.");
				} catch (Throwable t) {
					verificationFailedMessage(
							"The category one name i.e. " + data.get("category_title_1") + " is not displayed.");
				}

				// Validate the question one label of category one
				try {
					Assert.assertTrue(pdfContent.contains(data.get("question_label_1")));
					consoleMessage("The question one label of category one i.e " + data.get("question_label_1")
							+ " is displayed successfully.");
				} catch (Throwable t) {
					verificationFailedMessage("The question one label of category one i.e "
							+ data.get("question_label_1") + " is not displayed.");
				}

				// Validate the question one title of category one
				try {
					Assert.assertTrue(pdfContent.contains(data.get("question_title_1")));
					consoleMessage("The question one title of category one i.e " + data.get("question_title_1")
							+ " is displayed successfully.");
				} catch (Throwable t) {
					verificationFailedMessage("The question one title of category one i.e "
							+ data.get("question_title_1") + " is not displayed.");
				}

				// Validate the question one answer
				try {
					Assert.assertTrue(pdfContent.contains("Yes"));
					consoleMessage("The question one answer is displayed correctly.");
				} catch (Throwable t) {
					verificationFailedMessage("The question one answer is not displayed.");
				}

				// Validate the document comment
				try {
					Assert.assertTrue(pdfContent.contains(data.get("documentcomment")));
					consoleMessage(
							"The document comment i.e " + data.get("documentcomment") + " is displayed successfully.");
				} catch (Throwable t) {
					verificationFailedMessage(
							"The document comment i.e " + data.get("documentcomment") + " is not displayed.");
				}

				// scroll down
				scrollByPixel(300);

				// Validate the title of the auto task
				try {
					Assert.assertTrue(pdfContent.contains("Title: " + data.get("task_title")));
					consoleMessage("The title of the auto task i.e. " + data.get("task_title")
							+ " is displayed successfully.");
				} catch (Throwable t) {
					verificationFailedMessage(
							"The title of the auto task i.e. " + data.get("task_title") + " is not displayed.");
				}

				// Validate the due date of the auto task
				try {
					Assert.assertTrue(pdfContent.contains("Due Date: " + today_string));
					consoleMessage("The due date of the auto task i.e " + today_string + " is displayed successfully.");
				} catch (Throwable t) {
					verificationFailedMessage(
							"The due date of the auto task i.e " + today_string + " is not displayed.");
				}

				// Validate the document comment of the auto task
				try {
					Assert.assertTrue(pdfContent.contains(data.get("autotask_documentcomment")));
					consoleMessage("The document comment of the auto task i.e " + data.get("autotask_documentcomment")
							+ " is displayed successfully.");
				} catch (Throwable t) {
					verificationFailedMessage("The document comment of the auto task i.e "
							+ data.get("autotask_documentcomment") + " is not displayed.");
				}

				// validate the option title of the question one
				try {
					Assert.assertTrue(pdfContent.contains(data.get("title_option_1_question_1")));
					consoleMessage("The option title of the question one i.e. " + data.get("title_option_1_question_1")
							+ " is displayed successfully.");
				} catch (Throwable t) {
					verificationFailedMessage("The option title of the question one i.e. "
							+ data.get("title_option_1_question_1") + " is not displayed.");
				}

				// validate the option text of the question one
				try {
					Assert.assertTrue(pdfContent.contains(data.get("question1_option")));
					consoleMessage("The option text of the question one i.e. " + data.get("question1_option")
							+ " is displayed successfully.");
				} catch (Throwable t) {
					verificationFailedMessage("The option text of the question one i.e. " + data.get("question1_option")
							+ " is not displayed.");
				}

				// scroll down
				scrollByPixel(300);

				// Validate the question two label of category one
				try {
					Assert.assertTrue(pdfContent.contains(data.get("question_label_2")));
					consoleMessage("The question two label of category one i.e. " + ": " + data.get("question_label_2")
							+ " is displayed successfully.");
				} catch (Throwable t) {
					verificationFailedMessage("The question two label of category one i.e. " + ": "
							+ data.get("question_label_2") + " is not displayed.");
				}

				// Validate the question two title of category one
				try {
					Assert.assertTrue(pdfContent.contains(data.get("question_title_2")));
					consoleMessage("The question two title of category one i.e. " + data.get("question_title_2")
							+ " is displayed successfully.");
				} catch (Throwable t) {
					verificationFailedMessage("The question two title of category one i.e. "
							+ data.get("question_title_2") + " is not displayed.");
				}

				// Validate the question two answer
				try {
					Assert.assertTrue(pdfContent.contains("No"));
					consoleMessage("The question two answer is displayed correctly.");
				} catch (Throwable t) {
					verificationFailedMessage("The question two answer is not displayed.");
				}

				// scroll down
				scrollByPixel(300);

				// Validate the title of the new task
				try {
					Assert.assertTrue(pdfContent.contains("Title: " + data.get("task_title2")));
					consoleMessage("The title of the new task i.e. " + data.get("task_title2")
							+ " is displayed successfully.");
				} catch (Throwable t) {
					verificationFailedMessage(
							"The title of the new task i.e. " + data.get("task_title2") + " is not displayed.");
				}

				// Validate the location of the new task
				try {
					Assert.assertTrue(pdfContent.contains("Location: " + data.get("task_location")));
					consoleMessage("The location of the new task i.e. " + data.get("task_location")
							+ " is displayed successfully.");
				} catch (Throwable t) {
					verificationFailedMessage(
							"The location of the new task i.e. " + data.get("task_location") + " is not displayed.");
				}

				// Validate the document comment of the new task
				try {
					Assert.assertTrue(pdfContent.contains(data.get("newtask_documentcomment")));
					consoleMessage("The document comment of the new task i.e. " + data.get("newtask_documentcomment")
							+ " is displayed successfully.");
				} catch (Throwable t) {
					verificationFailedMessage("The document comment of the new task i.e. "
							+ data.get("newtask_documentcomment") + " is not displayed.");
				}

				driver.close();

				driver.switchTo().window(tabs2.get(0));

				// wait for the element
				Thread.sleep(3000);

			} catch (IOException e) {
				e.printStackTrace();
				ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
				driver.close();
				driver.switchTo().window(tabs2.get(0));

				// wait for the element
				Thread.sleep(3000);

			}

		} catch (Throwable t) {
			verificationFailed();
		}

		// click on the home option from the side menu
		click("questionnaire_homeburgermenubtn_hide_CSS");

		// wait for the element
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// VALIDATE THE PDF REPORT OF NEWLY CREATED INSPECTION ON INDIVIDUAL INSPECTION
		// DETAILS SCREEN WITH FULL REPORT
		title("VALIDATE THE PDF REPORT OF NEWLY CREATED INSPECTION ON INDIVIDUAL INSPECTION DETAILS SCREEN WITH FULL REPORT");

		try {
			// click on the environmental icon from the property list page
			click("environmentalicon_CSS");

			// wait for the element
			explicitWaitClickable("menubtn_CSS");

			// click on the burger menu
			click("menubtn_CSS");

			// wait for the element
			Thread.sleep(5000);

			// click on the checklist/inspection option from side menu
			click("checklist_sidemenu_XPATH");

			// enter the inspection name in the search field
			type("sustainability_searchtxt_XPATH", questionnaireTitle);

			// click on the searched inspection
			String inspectionRecord = "//td[text()='" + questionnaireTitle + "']";
			driver.findElement(By.xpath(inspectionRecord)).click();
			consoleMessage("Clicked on the searched inspection.");

			// click on the print button
			click("checklist_printicon_XPATH");

			// click on the full report radio button
			click("checklist_printicon_fullreportbtn_XPATH");

			// validate the hide empty category checkbox
			boolean hidecategory = driver
					.findElement(By.xpath(OR.getProperty("checklist_printicon_hideemptycategoriesckbx_XPATH")))
					.isSelected();

			if (hidecategory == true) {
				successMessage("The Hide empty categories checkboc is displayed selected.");
			} else {
				consoleMessage("The Hide empty categories checkboc is not displayed selected.");

				// click on the hide empty category checkbox
				click("checklist_printicon_hideemptycategoriesckbx_XPATH");

			}

			// click on the print button of the confirmation popup
			click("checklist_printicon_printbtn_confirmationbtn_XPATH");

			// ********** ADD THE LATEST FILE FETCH CODE **********

			// wait for the element
			Thread.sleep(15000);

			File downloaded = getLastModified("C:\\Users\\Jinesh\\Downloads");
			String path_string = downloaded.toString();
			System.out.println(path_string);
			String final_path = "file:///" + path_string;
			consoleMessage("Final path of the downloaded file: " + final_path);

			try {
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("window.open('about:blank','_blank');");
				consoleMessage("New tab is opened successfully.");

				ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
				driver.switchTo().window(tabs2.get(1));
				consoleMessage("Move to newly opened tab successfully.");

				// wait for the element
				Thread.sleep(3000);

				driver.get(final_path);
				consoleMessage("Entered the final path in the newly opened tab.");

				String pdfContent = readPdfContent(final_path);
				Thread.sleep(10000);

				// validate the inspection title
				try {
					Assert.assertTrue(pdfContent.contains(inspectionTitle));
					consoleMessage("The inspection title is displayed successfully.");
				} catch (Throwable t) {
					verificationFailedMessage("The inspection title is not displayed.");
				}

				// validate the today's date
				try {
					Assert.assertTrue(pdfContent.contains(today_string));
					consoleMessage("The Date of Inspection is displayed correctly.");
				} catch (Throwable t) {
					verificationFailedMessage("The Date of Inspection is not displayed.");
				}

				// Validate the property name
				try {
					Assert.assertTrue(pdfContent.contains(data.get("propertyname")));
					consoleMessage("The property name is displayed successfully.");
				} catch (Throwable t) {
					verificationFailedMessage("The property name is not displayed.");
				}

				// scroll down
				scrollByPixel(300);

				// Validate the category one name
				try {
					Assert.assertTrue(pdfContent.contains(data.get("category_title_1")));
					consoleMessage("The category one name i.e. " + data.get("category_title_1")
							+ " is displayed successfully.");
				} catch (Throwable t) {
					verificationFailedMessage(
							"The category one name i.e. " + data.get("category_title_1") + " is not displayed.");
				}

				// Validate the question one label of category one
				try {
					Assert.assertTrue(pdfContent.contains(data.get("question_label_1")));
					consoleMessage("The question one label of category one i.e " + data.get("question_label_1")
							+ " is displayed successfully.");
				} catch (Throwable t) {
					verificationFailedMessage("The question one label of category one i.e "
							+ data.get("question_label_1") + " is not displayed.");
				}

				// Validate the question one title of category one
				try {
					Assert.assertTrue(pdfContent.contains(data.get("question_title_1")));
					consoleMessage("The question one title of category one i.e " + data.get("question_title_1")
							+ " is displayed successfully.");
				} catch (Throwable t) {
					verificationFailedMessage("The question one title of category one i.e "
							+ data.get("question_title_1") + " is not displayed.");
				}

				// Validate the question one answer
				try {
					Assert.assertTrue(pdfContent.contains("Yes"));
					consoleMessage("The question one answer is displayed correctly.");
				} catch (Throwable t) {
					verificationFailedMessage("The question one answer is not displayed.");
				}

				// Validate the document comment
				try {
					Assert.assertTrue(pdfContent.contains(data.get("documentcomment")));
					consoleMessage(
							"The document comment i.e " + data.get("documentcomment") + " is displayed successfully.");
				} catch (Throwable t) {
					verificationFailedMessage(
							"The document comment i.e " + data.get("documentcomment") + " is not displayed.");
				}

				// scroll down
				scrollByPixel(300);

				// Validate the title of the auto task
				try {
					Assert.assertTrue(pdfContent.contains("Title: " + data.get("task_title")));
					consoleMessage("The title of the auto task i.e. " + data.get("task_title")
							+ " is displayed successfully.");
				} catch (Throwable t) {
					verificationFailedMessage(
							"The title of the auto task i.e. " + data.get("task_title") + " is not displayed.");
				}

				// Validate the due date of the auto task
				try {
					Assert.assertTrue(pdfContent.contains("Due Date: " + today_string));
					consoleMessage("The due date of the auto task i.e " + today_string + " is displayed successfully.");
				} catch (Throwable t) {
					verificationFailedMessage(
							"The due date of the auto task i.e " + today_string + " is not displayed.");
				}

				// Validate the document comment of the auto task
				try {
					Assert.assertTrue(pdfContent.contains(data.get("autotask_documentcomment")));
					consoleMessage("The document comment of the auto task i.e " + data.get("autotask_documentcomment")
							+ " is displayed successfully.");
				} catch (Throwable t) {
					verificationFailedMessage("The document comment of the auto task i.e "
							+ data.get("autotask_documentcomment") + " is not displayed.");
				}

				// validate the option title of the question one
				try {
					Assert.assertTrue(pdfContent.contains(data.get("title_option_1_question_1")));
					consoleMessage("The option title of the question one i.e. " + data.get("title_option_1_question_1")
							+ " is displayed successfully.");
				} catch (Throwable t) {
					verificationFailedMessage("The option title of the question one i.e. "
							+ data.get("title_option_1_question_1") + " is displayed successfully.");
				}

				// validate the option text of the question one
				try {
					Assert.assertTrue(pdfContent.contains(data.get("question1_option")));
					consoleMessage("The option text of the question one i.e. " + data.get("question1_option")
							+ " is displayed successfully.");
				} catch (Throwable t) {
					verificationFailedMessage("The option text of the question one i.e. " + data.get("question1_option")
							+ " is not displayed.");
				}

				// scroll down
				scrollByPixel(300);

				// Validate the question two label of category one
				try {
					Assert.assertTrue(pdfContent.contains(data.get("question_label_2")));
					consoleMessage("The question two label of category one i.e. " + ": " + data.get("question_label_2")
							+ " is displayed successfully.");
				} catch (Throwable t) {
					verificationFailedMessage("The question two label of category one i.e. " + ": "
							+ data.get("question_label_2") + " is not displayed.");
				}

				// Validate the question two title of category one
				try {
					Assert.assertTrue(pdfContent.contains(data.get("question_title_2")));
					consoleMessage("The question two title of category one i.e. " + data.get("question_title_2")
							+ " is displayed successfully.");
				} catch (Throwable t) {
					verificationFailedMessage("The question two title of category one i.e. "
							+ data.get("question_title_2") + " is not displayed.");
				}

				// Validate the question two answer
				try {
					Assert.assertTrue(pdfContent.contains("No"));
					consoleMessage("The question two answer is displayed correctly.");
				} catch (Throwable t) {
					verificationFailedMessage("The question two answer is not displayed.");
				}

				// scroll down
				scrollByPixel(300);

				// Validate the title of the new task
				try {
					Assert.assertTrue(pdfContent.contains("Title: " + data.get("task_title2")));
					consoleMessage("The title of the new task i.e. " + data.get("task_title2")
							+ " is displayed successfully.");
				} catch (Throwable t) {
					verificationFailedMessage(
							"The title of the new task i.e. " + data.get("task_title2") + " is not displayed.");
				}

				// Validate the location of the new task
				try {
					Assert.assertTrue(pdfContent.contains("Location: " + data.get("task_location")));
					consoleMessage("The location of the new task i.e. " + data.get("task_location")
							+ " is displayed successfully.");
				} catch (Throwable t) {
					verificationFailedMessage(
							"The location of the new task i.e. " + data.get("task_location") + " is not displayed.");
				}

				// Validate the document comment of the new task
				try {
					Assert.assertTrue(pdfContent.contains(data.get("newtask_documentcomment")));
					consoleMessage("The document comment of the new task i.e. " + data.get("newtask_documentcomment")
							+ " is displayed successfully.");
				} catch (Throwable t) {
					verificationFailedMessage("The document comment of the new task i.e. "
							+ data.get("newtask_documentcomment") + " is not displayed.");
				}

				driver.close();

				driver.switchTo().window(tabs2.get(0));

				// wait for the element
				Thread.sleep(3000);

			} catch (IOException e) {
				e.printStackTrace();
				ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
				driver.close();
				driver.switchTo().window(tabs2.get(0));

				// wait for the element
				Thread.sleep(3000);

			}

		} catch (Throwable t) {
			verificationFailed();
		}

		// click on the home option from the side menu
		click("questionnaire_homeburgermenubtn_hide_CSS");

		// wait for the element
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// VALIDATE THE PDF REPORT OF NEWLY CREATED INSPECTION ON INDIVIDUAL INSPECTION
		// DETAILS SCREEN WITH CATEGORY WISE REPORT AND CATEGORY ONE
		title("VALIDATE THE PDF REPORT OF NEWLY CREATED INSPECTION ON INDIVIDUAL INSPECTION DETAILS SCREEN WITH CATEGORY WISE REPORT AND CATEGORY ONE");

		try {
			// click on the environmental icon from the property list page
			click("environmentalicon_CSS");

			// wait for the element
			explicitWaitClickable("menubtn_CSS");

			// click on the burger menu
			click("menubtn_CSS");

			// wait for the element
			Thread.sleep(5000);

			// click on the checklist/inspection option from side menu
			click("checklist_sidemenu_XPATH");

			// enter the inspection name in the search field
			type("sustainability_searchtxt_XPATH", questionnaireTitle);

			// click on the searched inspection
			String inspectionRecord = "//td[text()='" + questionnaireTitle + "']";
			driver.findElement(By.xpath(inspectionRecord)).click();
			consoleMessage("Clicked on the searched inspection.");

			// click on the print button
			click("checklist_printicon_XPATH");

			// click on the category wise report radio button
			click("checklist_printicon_categorywisereportbtn_XPATH");

			// click on the category list field
			click("checklist_printicon_printbtn_categorytxt_XPATH");

			// click on the none button
			click("checklist_printicon_printbtn_nonebtn_XPATH");

			// click on the category one
			click("checklist_printicon_printbtn_category1_XPATH");

			// click on the category list field
			click("checklist_printicon_printbtn_categorytxt_XPATH");

			// validate the hide empty category checkbox
			boolean hidecategory = driver
					.findElement(By.xpath(OR.getProperty("checklist_printicon_hideemptycategoriesckbx_XPATH")))
					.isSelected();

			if (hidecategory == true) {
				successMessage("The Hide empty categories checkboc is displayed selected.");
			} else {
				consoleMessage("The Hide empty categories checkboc is not displayed selected.");

				// click on the hide empty category checkbox
				click("checklist_printicon_hideemptycategoriesckbx_XPATH");

			}

			// click on the print button of the confirmation popup
			click("checklist_printicon_printbtn_confirmationbtn_XPATH");

			// ********** ADD THE LATEST FILE FETCH CODE **********

			// wait for the element
			Thread.sleep(15000);

			File downloaded = getLastModified("C:\\Users\\Jinesh\\Downloads");
			String path_string = downloaded.toString();
			System.out.println(path_string);
			String final_path = "file:///" + path_string;
			consoleMessage("Final path of the downloaded file: " + final_path);

			try {
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("window.open('about:blank','_blank');");
				consoleMessage("New tab is opened successfully.");

				ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
				driver.switchTo().window(tabs2.get(1));
				consoleMessage("Move to newly opened tab successfully.");

				// wait for the element
				Thread.sleep(3000);

				driver.get(final_path);
				consoleMessage("Entered the final path in the newly opened tab.");

				String pdfContent = readPdfContent(final_path);
				Thread.sleep(10000);

				// validate the inspection title
				try {
					Assert.assertTrue(pdfContent.contains(inspectionTitle));
					consoleMessage("The inspection title is displayed successfully.");
				} catch (Throwable t) {
					verificationFailedMessage("The inspection title is not displayed.");
				}

				// validate the today's date
				try {
					Assert.assertTrue(pdfContent.contains(today_string));
					consoleMessage("The Date of Inspection is displayed correctly.");
				} catch (Throwable t) {
					verificationFailedMessage("The Date of Inspection is not displayed.");
				}

				// Validate the property name
				try {
					Assert.assertTrue(pdfContent.contains(data.get("propertyname")));
					consoleMessage("The property name is displayed successfully.");
				} catch (Throwable t) {
					verificationFailedMessage("The property name is not displayed.");
				}

				// scroll down
				scrollByPixel(300);

				// Validate the category one name
				try {
					Assert.assertTrue(pdfContent.contains(data.get("category_title_1")));
					consoleMessage("The category one name i.e. " + data.get("category_title_1")
							+ " is displayed successfully.");
				} catch (Throwable t) {
					verificationFailedMessage(
							"The category one name i.e. " + data.get("category_title_1") + " is not displayed.");
				}

				// Validate the question one label of category one
				try {
					Assert.assertTrue(pdfContent.contains(data.get("question_label_1")));
					consoleMessage("The question one label of category one i.e " + data.get("question_label_1")
							+ " is displayed successfully.");
				} catch (Throwable t) {
					verificationFailedMessage("The question one label of category one i.e "
							+ data.get("question_label_1") + " is not displayed.");
				}

				// Validate the question one title of category one
				try {
					Assert.assertTrue(pdfContent.contains(data.get("question_title_1")));
					consoleMessage("The question one title of category one i.e " + data.get("question_title_1")
							+ " is displayed successfully.");
				} catch (Throwable t) {
					verificationFailedMessage("The question one title of category one i.e "
							+ data.get("question_title_1") + " is not displayed.");
				}

				// Validate the question one answer
				try {
					Assert.assertTrue(pdfContent.contains("Yes"));
					consoleMessage("The question one answer is displayed correctly.");
				} catch (Throwable t) {
					verificationFailedMessage("The question one answer is not displayed.");
				}

				// Validate the document comment
				try {
					Assert.assertTrue(pdfContent.contains(data.get("documentcomment")));
					consoleMessage(
							"The document comment i.e " + data.get("documentcomment") + " is displayed successfully.");
				} catch (Throwable t) {
					verificationFailedMessage(
							"The document comment i.e " + data.get("documentcomment") + " is not displayed.");
				}

				// scroll down
				scrollByPixel(300);

				// Validate the title of the auto task
				try {
					Assert.assertTrue(pdfContent.contains("Title: " + data.get("task_title")));
					consoleMessage("The title of the auto task i.e. " + data.get("task_title")
							+ " is displayed successfully.");
				} catch (Throwable t) {
					verificationFailedMessage(
							"The title of the auto task i.e. " + data.get("task_title") + " is not displayed.");
				}

				// Validate the due date of the auto task
				try {
					Assert.assertTrue(pdfContent.contains("Due Date: " + today_string));
					consoleMessage("The due date of the auto task i.e " + today_string + " is displayed successfully.");
				} catch (Throwable t) {
					verificationFailedMessage(
							"The due date of the auto task i.e " + today_string + " is not displayed.");
				}

				// Validate the document comment of the auto task
				try {
					Assert.assertTrue(pdfContent.contains(data.get("autotask_documentcomment")));
					consoleMessage("The document comment of the auto task i.e " + data.get("autotask_documentcomment")
							+ " is displayed successfully.");
				} catch (Throwable t) {
					verificationFailedMessage("The document comment of the auto task i.e "
							+ data.get("autotask_documentcomment") + " is not displayed.");
				}

				// validate the option title of the question one
				try {
					Assert.assertTrue(pdfContent.contains(data.get("title_option_1_question_1")));
					consoleMessage("The option title of the question one i.e. " + data.get("title_option_1_question_1")
							+ " is displayed successfully.");
				} catch (Throwable t) {
					verificationFailedMessage("The option title of the question one i.e. "
							+ data.get("title_option_1_question_1") + " is displayed successfully.");
				}

				// validate the option text of the question one
				try {
					Assert.assertTrue(pdfContent.contains(data.get("question1_option")));
					consoleMessage("The option text of the question one i.e. " + data.get("question1_option")
							+ " is displayed successfully.");
				} catch (Throwable t) {
					verificationFailedMessage("The option text of the question one i.e. " + data.get("question1_option")
							+ " is not displayed.");
				}

				// scroll down
				scrollByPixel(300);

				// Validate the question two label of category one
				try {
					Assert.assertTrue(pdfContent.contains(data.get("question_label_2")));
					consoleMessage("The question two label of category one i.e. " + ": " + data.get("question_label_2")
							+ " is displayed successfully.");
				} catch (Throwable t) {
					verificationFailedMessage("The question two label of category one i.e. " + ": "
							+ data.get("question_label_2") + " is not displayed.");
				}

				// Validate the question two title of category one
				try {
					Assert.assertTrue(pdfContent.contains(data.get("question_title_2")));
					consoleMessage("The question two title of category one i.e. " + data.get("question_title_2")
							+ " is displayed successfully.");
				} catch (Throwable t) {
					verificationFailedMessage("The question two title of category one i.e. "
							+ data.get("question_title_2") + " is not displayed.");
				}

				// Validate the question two answer
				try {
					Assert.assertTrue(pdfContent.contains("No"));
					consoleMessage("The question two answer is displayed correctly.");
				} catch (Throwable t) {
					verificationFailedMessage("The question two answer is not displayed.");
				}

				// scroll down
				scrollByPixel(300);

				// Validate the title of the new task
				try {
					Assert.assertTrue(pdfContent.contains("Title: " + data.get("task_title2")));
					consoleMessage("The title of the new task i.e. " + data.get("task_title2")
							+ " is displayed successfully.");
				} catch (Throwable t) {
					verificationFailedMessage(
							"The title of the new task i.e. " + data.get("task_title2") + " is not displayed.");
				}

				// Validate the location of the new task
				try {
					Assert.assertTrue(pdfContent.contains("Location: " + data.get("task_location")));
					consoleMessage("The location of the new task i.e. " + data.get("task_location")
							+ " is displayed successfully.");
				} catch (Throwable t) {
					verificationFailedMessage(
							"The location of the new task i.e. " + data.get("task_location") + " is not displayed.");
				}

				// Validate the document comment of the new task
				try {
					Assert.assertTrue(pdfContent.contains(data.get("newtask_documentcomment")));
					consoleMessage("The document comment of the new task i.e. " + data.get("newtask_documentcomment")
							+ " is displayed successfully.");
				} catch (Throwable t) {
					verificationFailedMessage("The document comment of the new task i.e. "
							+ data.get("newtask_documentcomment") + " is not displayed.");
				}

				driver.close();

				driver.switchTo().window(tabs2.get(0));

				// wait for the element
				Thread.sleep(3000);

			} catch (IOException e) {
				e.printStackTrace();
				ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
				driver.close();
				driver.switchTo().window(tabs2.get(0));

				// wait for the element
				Thread.sleep(3000);

			}

		} catch (Throwable t) {
			verificationFailed();
		}

		// click on the home option from the side menu
		click("questionnaire_homeburgermenubtn_hide_CSS");

		// wait for the element
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// VALIDATE THE PDF REPORT OF NEWLY CREATED INSPECTION ON INDIVIDUAL INSPECTION
		// DETAILS SCREEN WITH CATEGORY WISE REPORT AND CATEGORY TWO
		title("VALIDATE THE PDF REPORT OF NEWLY CREATED INSPECTION ON INDIVIDUAL INSPECTION DETAILS SCREEN WITH CATEGORY WISE REPORT AND CATEGORY TWO");

		try {
			// click on the environmental icon from the property list page
			click("environmentalicon_CSS");

			// wait for the element
			explicitWaitClickable("menubtn_CSS");

			// click on the burger menu
			click("menubtn_CSS");

			// wait for the element
			Thread.sleep(5000);

			// click on the checklist/inspection option from side menu
			click("checklist_sidemenu_XPATH");

			// enter the inspection name in the search field
			type("sustainability_searchtxt_XPATH", questionnaireTitle);

			// click on the searched inspection
			String inspectionRecord = "//td[text()='" + questionnaireTitle + "']";
			driver.findElement(By.xpath(inspectionRecord)).click();
			consoleMessage("Clicked on the searched inspection.");

			// click on the print button
			click("checklist_printicon_XPATH");

			// click on the category wise report radio button
			click("checklist_printicon_categorywisereportbtn_XPATH");

			// click on the category list field
			click("checklist_printicon_printbtn_categorytxt_XPATH");

			// click on the none button
			click("checklist_printicon_printbtn_nonebtn_XPATH");

			// click on the category two
			click("checklist_printicon_printbtn_category2_XPATH");

			// click on the category list field
			click("checklist_printicon_printbtn_categorytxt_XPATH");

			// validate the hide empty category checkbox
			boolean hidecategory = driver
					.findElement(By.xpath(OR.getProperty("checklist_printicon_hideemptycategoriesckbx_XPATH")))
					.isSelected();

			if (hidecategory == true) {
				successMessage("The Hide empty categories checkboc is displayed selected.");
			} else {
				consoleMessage("The Hide empty categories checkboc is not displayed selected.");

				// click on the hide empty category checkbox
				click("checklist_printicon_hideemptycategoriesckbx_XPATH");

			}

			// click on the print button of the confirmation popup
			click("checklist_printicon_printbtn_confirmationbtn_XPATH");

			// ********** ADD THE LATEST FILE FETCH CODE **********

			// wait for the element
			Thread.sleep(15000);

			File downloaded = getLastModified("C:\\Users\\Jinesh\\Downloads");
			String path_string = downloaded.toString();
			System.out.println(path_string);
			String final_path = "file:///" + path_string;
			consoleMessage("Final path of the downloaded file: " + final_path);

			try {
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("window.open('about:blank','_blank');");
				consoleMessage("New tab is opened successfully.");

				ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
				driver.switchTo().window(tabs2.get(1));
				consoleMessage("Move to newly opened tab successfully.");

				// wait for the element
				Thread.sleep(3000);

				driver.get(final_path);
				consoleMessage("Entered the final path in the newly opened tab.");

				String pdfContent = readPdfContent(final_path);
				Thread.sleep(10000);

				// validate the inspection title
				try {
					Assert.assertTrue(pdfContent.contains(inspectionTitle));
					consoleMessage("The inspection title is displayed successfully.");
				} catch (Throwable t) {
					verificationFailedMessage("The inspection title is not displayed.");
				}

				// validate the today's date
				try {
					Assert.assertTrue(pdfContent.contains(today_string));
					consoleMessage("The Date of Inspection is displayed correctly.");
				} catch (Throwable t) {
					verificationFailedMessage("The Date of Inspection is not displayed.");
				}

				// Validate the property name
				try {
					Assert.assertTrue(pdfContent.contains(data.get("propertyname")));
					consoleMessage("The property name is displayed successfully.");
				} catch (Throwable t) {
					verificationFailedMessage("The property name is not displayed.");
				}

				// scroll down
				scrollByPixel(300);

				// Validate the category one name
				try {
					Assert.assertTrue(pdfContent.contains(data.get("category_title_1")));
					verificationFailedMessage(
							"The category one name i.e. " + data.get("category_title_1") + " is displayed.");
				} catch (Throwable t) {
					consoleMessage("The category one name i.e. " + data.get("category_title_1")
							+ " is not displayed as expected.");
				}

				// Validate the question one label of category one
				try {
					Assert.assertTrue(pdfContent.contains(data.get("question_label_1")));
					verificationFailedMessage("The question one label of category one i.e "
							+ data.get("question_label_1") + " is displayed.");
				} catch (Throwable t) {
					consoleMessage("The question one label of category one i.e " + data.get("question_label_1")
							+ " is not displayed as expected.");
				}

				// Validate the question one title of category one
				try {
					Assert.assertTrue(pdfContent.contains(data.get("question_title_1")));
					verificationFailedMessage("The question one title of category one i.e "
							+ data.get("question_title_1") + " is displayed.");
				} catch (Throwable t) {
					consoleMessage("The question one title of category one i.e " + data.get("question_title_1")
							+ " is not displayed as expected.");
				}

				// Validate the question one answer
				try {
					Assert.assertTrue(pdfContent.contains("Yes"));
					verificationFailedMessage("The question one answer is displayed.");
				} catch (Throwable t) {
					consoleMessage("The question one answer is not displayed as expected.");
				}

				// Validate the document comment
				try {
					Assert.assertTrue(pdfContent.contains(data.get("documentcomment")));
					verificationFailedMessage(
							"The document comment i.e " + data.get("documentcomment") + " is displayed.");
				} catch (Throwable t) {
					consoleMessage("The document comment i.e " + data.get("documentcomment")
							+ " is not displayed as expected.");
				}

				// scroll down
				scrollByPixel(300);

				// Validate the title of the auto task
				try {
					Assert.assertTrue(pdfContent.contains("Title: " + data.get("task_title")));
					verificationFailedMessage(
							"The title of the auto task i.e. " + data.get("task_title") + " is displayed.");
				} catch (Throwable t) {
					consoleMessage("The title of the auto task i.e. " + data.get("task_title")
							+ " is not displayed as expected.");
				}

				// Validate the due date of the auto task
				try {
					Assert.assertTrue(pdfContent.contains("Due Date: " + today_string));
					verificationFailedMessage("The due date of the auto task i.e " + today_string + " is displayed.");
				} catch (Throwable t) {
					consoleMessage(
							"The due date of the auto task i.e " + today_string + " is not displayed as expected.");
				}

				// Validate the document comment of the auto task
				try {
					Assert.assertTrue(pdfContent.contains(data.get("autotask_documentcomment")));
					verificationFailedMessage("The document comment of the auto task i.e "
							+ data.get("autotask_documentcomment") + " is displayed.");
				} catch (Throwable t) {
					consoleMessage("The document comment of the auto task i.e " + data.get("autotask_documentcomment")
							+ " is not displayed as expected.");
				}

				// validate the option title of the question one
				try {
					Assert.assertTrue(pdfContent.contains(data.get("title_option_1_question_1")));
					verificationFailedMessage("The option title of the question one i.e. "
							+ data.get("title_option_1_question_1") + " is displayed.");
				} catch (Throwable t) {
					consoleMessage("The option title of the question one i.e. " + data.get("title_option_1_question_1")
							+ " is not displayed as epected.");
				}

				// validate the option text of the question one
				try {
					Assert.assertTrue(pdfContent.contains(data.get("question1_option")));
					verificationFailedMessage("The option text of the question one i.e. " + data.get("question1_option")
							+ " is displayed successfully.");
				} catch (Throwable t) {
					consoleMessage("The option text of the question one i.e. " + data.get("question1_option")
							+ " is not displayed as expected.");
				}

				// scroll down
				scrollByPixel(300);

				// Validate the question two label of category one
				try {
					Assert.assertTrue(pdfContent.contains(data.get("question_label_2")));
					verificationFailedMessage("The question two label of category one i.e. " + ": "
							+ data.get("question_label_2") + " is displayed.");
				} catch (Throwable t) {
					consoleMessage("The question two label of category one i.e. " + ": " + data.get("question_label_2")
							+ " is not displayed as expected.");
				}

				// Validate the question two title of category one
				try {
					Assert.assertTrue(pdfContent.contains(data.get("question_title_2")));
					verificationFailedMessage("The question two title of category one i.e. "
							+ data.get("question_title_2") + " is displayed.");
				} catch (Throwable t) {
					consoleMessage("The question two title of category one i.e. " + data.get("question_title_2")
							+ " is not displayed as expected.");
				}

				// Validate the question two answer
				try {
					Assert.assertTrue(pdfContent.contains("No"));
					verificationFailedMessage("The question two answer is displayed.");
				} catch (Throwable t) {
					consoleMessage("The question two answer is not displayed as expected.");
				}

				// scroll down
				scrollByPixel(300);

				// Validate the title of the new task
				try {
					Assert.assertTrue(pdfContent.contains("Title: " + data.get("task_title2")));
					verificationFailedMessage(
							"The title of the new task i.e. " + data.get("task_title2") + " is displayed.");
				} catch (Throwable t) {
					consoleMessage("The title of the new task i.e. " + data.get("task_title2")
							+ " is not displayed as expected.");
				}

				// Validate the location of the new task
				try {
					Assert.assertTrue(pdfContent.contains("Location: " + data.get("task_location")));
					verificationFailedMessage(
							"The location of the new task i.e. " + data.get("task_location") + " is displayed.");
				} catch (Throwable t) {
					consoleMessage("The location of the new task i.e. " + data.get("task_location")
							+ " is not displayed as expected.");
				}

				// Validate the document comment of the new task
				try {
					Assert.assertTrue(pdfContent.contains(data.get("newtask_documentcomment")));
					verificationFailedMessage("The document comment of the new task i.e. "
							+ data.get("newtask_documentcomment") + " is displayed.");
				} catch (Throwable t) {
					consoleMessage("The document comment of the new task i.e. " + data.get("newtask_documentcomment")
							+ " is not displayed as expected.");
				}

				driver.close();

				driver.switchTo().window(tabs2.get(0));

				// wait for the element
				Thread.sleep(3000);

			} catch (IOException e) {
				e.printStackTrace();
				ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
				driver.close();
				driver.switchTo().window(tabs2.get(0));

				// wait for the element
				Thread.sleep(3000);
			}

		} catch (Throwable t) {
			verificationFailed();
		}

		// click on the home option from the side menu
		click("questionnaire_homeburgermenubtn_hide_CSS");

		// wait for the element
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// VALIDATE THE PDF REPORT OF NEWLY CREATED INSPECTION ON INDIVIDUAL INSPECTION
		// DETAILS SCREEN WITH CATEGORY WISE REPORT WITH CATEGORY ONE - WITH EMPTY
		// CATEGORIES
		title("VALIDATE THE PDF REPORT OF NEWLY CREATED INSPECTION ON INDIVIDUAL INSPECTION DETAILS SCREEN WITH CATEGORY WISE REPORT AND CATEGORY ONE - WITH EMPTY CATEGORIES");

		try {
			// click on the environmental icon from the property list page
			click("environmentalicon_CSS");

			// wait for the element
			explicitWaitClickable("menubtn_CSS");

			// click on the burger menu
			click("menubtn_CSS");

			// wait for the element
			Thread.sleep(5000);

			// click on the checklist/inspection option from side menu
			click("checklist_sidemenu_XPATH");

			// enter the inspection name in the search field
			type("sustainability_searchtxt_XPATH", questionnaireTitle);

			// click on the searched inspection
			String inspectionRecord = "//td[text()='" + questionnaireTitle + "']";
			driver.findElement(By.xpath(inspectionRecord)).click();
			consoleMessage("Clicked on the searched inspection.");

			// click on the print button
			click("checklist_printicon_XPATH");

			// click on the category wise report radio button
			click("checklist_printicon_categorywisereportbtn_XPATH");

			// click on the category list field
			click("checklist_printicon_printbtn_categorytxt_XPATH");

			// click on the none button
			click("checklist_printicon_printbtn_nonebtn_XPATH");

			// click on the category one
			click("checklist_printicon_printbtn_category1_XPATH");

			// click on the category list field
			click("checklist_printicon_printbtn_categorytxt_XPATH");

			// validate the hide empty category checkbox
			boolean hidecategory = driver
					.findElement(By.xpath(OR.getProperty("checklist_printicon_hideemptycategoriesckbx_XPATH")))
					.isSelected();

			if (hidecategory == true) {

				consoleMessage("The Hide empty categories checkboc is displayed selected.");

				// click on the hide empty category checkbox
				click("checklist_printicon_hideemptycategoriesckbx_XPATH");

			} else {
				successMessage("The Hide empty categories checkboc is not displayed selected.");
			}

			// click on the print button of the confirmation popup
			click("checklist_printicon_printbtn_confirmationbtn_XPATH");

			// ********** ADD THE LATEST FILE FETCH CODE **********

			// wait for the element
			Thread.sleep(15000);

			File downloaded = getLastModified("C:\\Users\\Jinesh\\Downloads");
			String path_string = downloaded.toString();
			System.out.println(path_string);
			String final_path = "file:///" + path_string;
			consoleMessage("Final path of the downloaded file: " + final_path);

			try {
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("window.open('about:blank','_blank');");
				consoleMessage("New tab is opened successfully.");

				ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
				driver.switchTo().window(tabs2.get(1));
				consoleMessage("Move to newly opened tab successfully.");

				// wait for the element
				Thread.sleep(3000);

				driver.get(final_path);
				consoleMessage("Entered the final path in the newly opened tab.");

				String pdfContent = readPdfContent(final_path);
				Thread.sleep(10000);

				// validate the inspection title
				try {
					Assert.assertTrue(pdfContent.contains(inspectionTitle));
					consoleMessage("The inspection title is displayed successfully.");
				} catch (Throwable t) {
					verificationFailedMessage("The inspection title is not displayed.");
				}

				// validate the today's date
				try {
					Assert.assertTrue(pdfContent.contains(today_string));
					consoleMessage("The Date of Inspection is displayed correctly.");
				} catch (Throwable t) {
					verificationFailedMessage("The Date of Inspection is not displayed.");
				}

				// Validate the property name
				try {
					Assert.assertTrue(pdfContent.contains(data.get("propertyname")));
					consoleMessage("The property name is displayed successfully.");
				} catch (Throwable t) {
					verificationFailedMessage("The property name is not displayed.");
				}

				// scroll down
				scrollByPixel(300);

				// Validate the category one name
				try {
					Assert.assertTrue(pdfContent.contains(data.get("category_title_1")));
					consoleMessage("The category one name i.e. " + data.get("category_title_1")
							+ " is displayed successfully.");
				} catch (Throwable t) {
					verificationFailedMessage(
							"The category one name i.e. " + data.get("category_title_1") + " is not displayed.");
				}

				// Validate the question one label of category one
				try {
					Assert.assertTrue(pdfContent.contains(data.get("question_label_1")));
					consoleMessage("The question one label of category one i.e " + data.get("question_label_1")
							+ " is displayed successfully.");
				} catch (Throwable t) {
					verificationFailedMessage("The question one label of category one i.e "
							+ data.get("question_label_1") + " is not displayed.");
				}

				// Validate the question one title of category one
				try {
					Assert.assertTrue(pdfContent.contains(data.get("question_title_1")));
					consoleMessage("The question one title of category one i.e " + data.get("question_title_1")
							+ " is displayed successfully.");
				} catch (Throwable t) {
					verificationFailedMessage("The question one title of category one i.e "
							+ data.get("question_title_1") + " is not displayed.");
				}

				// Validate the question one answer
				try {
					Assert.assertTrue(pdfContent.contains("Yes"));
					consoleMessage("The question one answer is displayed correctly.");
				} catch (Throwable t) {
					verificationFailedMessage("The question one answer is not displayed.");
				}

				// Validate the document comment
				try {
					Assert.assertTrue(pdfContent.contains(data.get("documentcomment")));
					consoleMessage(
							"The document comment i.e " + data.get("documentcomment") + " is displayed successfully.");
				} catch (Throwable t) {
					verificationFailedMessage(
							"The document comment i.e " + data.get("documentcomment") + " is not displayed.");
				}

				// scroll down
				scrollByPixel(300);

				// Validate the title of the auto task
				try {
					Assert.assertTrue(pdfContent.contains("Title: " + data.get("task_title")));
					consoleMessage("The title of the auto task i.e. " + data.get("task_title")
							+ " is displayed successfully.");
				} catch (Throwable t) {
					verificationFailedMessage(
							"The title of the auto task i.e. " + data.get("task_title") + " is not displayed.");
				}

				// Validate the due date of the auto task
				try {
					Assert.assertTrue(pdfContent.contains("Due Date: " + today_string));
					consoleMessage("The due date of the auto task i.e " + today_string + " is displayed successfully.");
				} catch (Throwable t) {
					verificationFailedMessage(
							"The due date of the auto task i.e " + today_string + " is not displayed.");
				}

				// Validate the document comment of the auto task
				try {
					Assert.assertTrue(pdfContent.contains(data.get("autotask_documentcomment")));
					consoleMessage("The document comment of the auto task i.e " + data.get("autotask_documentcomment")
							+ " is displayed successfully.");
				} catch (Throwable t) {
					verificationFailedMessage("The document comment of the auto task i.e "
							+ data.get("autotask_documentcomment") + " is not displayed.");
				}

				// validate the option title of the question one
				try {
					Assert.assertTrue(pdfContent.contains(data.get("title_option_1_question_1")));
					consoleMessage("The option title of the question one i.e. " + data.get("title_option_1_question_1")
							+ " is displayed successfully.");
				} catch (Throwable t) {
					verificationFailedMessage("The option title of the question one i.e. "
							+ data.get("title_option_1_question_1") + " is displayed successfully.");
				}

				// validate the option text of the question one
				try {
					Assert.assertTrue(pdfContent.contains(data.get("question1_option")));
					consoleMessage("The option text of the question one i.e. " + data.get("question1_option")
							+ " is displayed successfully.");
				} catch (Throwable t) {
					verificationFailedMessage("The option text of the question one i.e. " + data.get("question1_option")
							+ " is not displayed.");
				}

				// scroll down
				scrollByPixel(300);

				// Validate the question two label of category one
				try {
					Assert.assertTrue(pdfContent.contains(data.get("question_label_2")));
					consoleMessage("The question two label of category one i.e. " + ": " + data.get("question_label_2")
							+ " is displayed successfully.");
				} catch (Throwable t) {
					verificationFailedMessage("The question two label of category one i.e. " + ": "
							+ data.get("question_label_2") + " is not displayed.");
				}

				// Validate the question two title of category one
				try {
					Assert.assertTrue(pdfContent.contains(data.get("question_title_2")));
					consoleMessage("The question two title of category one i.e. " + data.get("question_title_2")
							+ " is displayed successfully.");
				} catch (Throwable t) {
					verificationFailedMessage("The question two title of category one i.e. "
							+ data.get("question_title_2") + " is not displayed.");
				}

				// Validate the question two answer
				try {
					Assert.assertTrue(pdfContent.contains("No"));
					consoleMessage("The question two answer is displayed correctly.");
				} catch (Throwable t) {
					verificationFailedMessage("The question two answer is not displayed.");
				}

				// scroll down
				scrollByPixel(300);

				// Validate the title of the new task
				try {
					Assert.assertTrue(pdfContent.contains("Title: " + data.get("task_title2")));
					consoleMessage("The title of the new task i.e. " + data.get("task_title2")
							+ " is displayed successfully.");
				} catch (Throwable t) {
					verificationFailedMessage(
							"The title of the new task i.e. " + data.get("task_title2") + " is not displayed.");
				}

				// Validate the location of the new task
				try {
					Assert.assertTrue(pdfContent.contains("Location: " + data.get("task_location")));
					consoleMessage("The location of the new task i.e. " + data.get("task_location")
							+ " is displayed successfully.");
				} catch (Throwable t) {
					verificationFailedMessage(
							"The location of the new task i.e. " + data.get("task_location") + " is not displayed.");
				}

				// Validate the document comment of the new task
				try {
					Assert.assertTrue(pdfContent.contains(data.get("newtask_documentcomment")));
					consoleMessage("The document comment of the new task i.e. " + data.get("newtask_documentcomment")
							+ " is displayed successfully.");
				} catch (Throwable t) {
					verificationFailedMessage("The document comment of the new task i.e. "
							+ data.get("newtask_documentcomment") + " is not displayed.");
				}

				// scroll down
				scrollByPixel(300);

				// Validate the category two name
				try {
					Assert.assertTrue(pdfContent.contains(data.get("category_title_2")));
					consoleMessage("The category one name i.e. " + data.get("category_title_2")
							+ " is displayed successfully.");
				} catch (Throwable t) {
					verificationFailedMessage(
							"The category one name i.e. " + data.get("category_title_2") + " is not displayed.");
				}

				driver.close();

				driver.switchTo().window(tabs2.get(0));

				// wait for the element
				Thread.sleep(3000);

			} catch (IOException e) {
				e.printStackTrace();
				ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
				driver.close();
				driver.switchTo().window(tabs2.get(0));

				// wait for the element
				Thread.sleep(3000);

			}

		} catch (Throwable t) {
			verificationFailed();
		}

		// click on the home option from the side menu
		click("questionnaire_homeburgermenubtn_hide_CSS");

		// wait for the element
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// DELETE THE NEWLY CREATED INSPECTION
		title("DELETE THE NEWLY CREATED INSPECTION");

		try {

			// click on the environmental icon from the property list page
			click("environmentalicon_CSS");

			// wait for the element
			Thread.sleep(5000);

			// click on the burger menu
			click("menubtn_CSS");

			// wait for the element
			Thread.sleep(5000);

			// click on the checklist/inspection option from side menu
			click("checklist_sidemenu_XPATH");

			// enter the inspection name in the search field
			type("sustainability_searchtxt_XPATH", questionnaireTitle);

			// click on the newly created inspection
			String inspection = "//td[text()='" + questionnaireTitle
					+ "']//following-sibling::td[@class='text-center pointer']//i[@id='action']";
			driver.findElement(By.xpath(inspection)).click();
			consoleMessage("Clicked on the newly created inspection.");

			// click on the delete option
			String deleteOption = "//td[text()='" + questionnaireTitle
					+ "']//following-sibling::td[@class='text-center pointer']//div[@class='dropdown open']//li[@id='delete']";
			driver.findElement(By.xpath(deleteOption)).click();
			consoleMessage("Clicked on the delete button.");

			// wait for the element
			explicitWaitClickable("checklist_deletebtn_XPATH");

			// click on the delete button
			click("checklist_deletebtn_XPATH");

		} catch (Throwable t) {
			verificationFailed();
		}

		// click on the home option from the side menu
		click("questionnaire_homeburgermenubtn_hide_CSS");

		// wait for the element
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

	}

}
