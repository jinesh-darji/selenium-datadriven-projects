package base;

import java.io.IOException;
import java.util.Hashtable;
import java.util.List;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Helper extends TestBase {

	public void preConditionForSustainabilityScenario(Hashtable<String, String> data)
			throws IOException, InterruptedException {

		// RUN THE BATCH FOR THE ELECRICITY UTILITY
		title("RUN THE BATCH FOR THE ELECRICITY UTILITY");

		try {

			// wait for the element
			explicitWaitClickable("questionnaire_settingicon_CSS");

			// click on the settings icon from the top of the screen
			click("questionnaire_settingicon_CSS");

			// wait for the element
			explicitWaitClickable("questionnaire_administrationoption_XPATH");

			// click on the Administration option from the side menu
			click("questionnaire_administrationoption_XPATH");

			// click on the system tab
			click("questionnaire_systemtab_XPATH");

			// click on the Batch Processes option
			click("questionnaire_batchprocesssoption_XPATH");

			// enter the batch name in the search name
			type("sustainability_searchtxt_XPATH", "Generate Electricity Consumption Snapshot");

			// wait for the element
			Thread.sleep(5000);

			// click on the play button of the searched batch process
			click("sustainability_utilitybills_batchprocess_playbtn_XPATH");

			// wait for the element
			Thread.sleep(5000);

			// click on the run button
			click("sustainability_utilitybills_batchprocess_runbtn_XPATH");

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

		// MAKE UTILITY BILL AS A UNVERIFIED FROM THE PERFORMANCE DATA VALIDATION MODULE

		title("MAKE UTILITY BILL AS A UNVERIFIED FROM THE PERFORMANCE DATA VALIDATION MODULE");

		try {
			// enter the property name in the search field
			type("envreports_propertylist_filtertxt_CSS", data.get("property_1"));

			// click on the Sustainability icon
			click("sustainabilityicon_CSS");

			// wait for the element
			Thread.sleep(5000);

			// click on the side menu
			click("ssc_leftsidemenubtn_CSS");

			// wait for the element
			Thread.sleep(5000);

			// click on the building performance data
			click("sustainability_utilitybills_buildingperformancedataoption_XPATH");

			// click on the performance data validation
			click("sustainability_utilitybills_performancedatavalidationoption_XPATH");

			try {
				// collect all the options from the drop down
				List<WebElement> yearList = driver
						.findElements(By.xpath("sustainability_utilitybills_datavalidation_yearsoption_XPATH"));
				int yearCount = yearList.size();

				for (int i = 0; i < yearCount; i++) {

					String year = yearList.get(i).getText();

					// select the option from the dropdown
					select("sustainability_utilitybills_datavalidation_yearsdd_XPATH", year);

					// wait for the element
					Thread.sleep(10000);

					// click on the clear all button
					click("sustainability_utilitybills_datavalidation_clearall_XPATH");

					// wait for the element
					Thread.sleep(5000);

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

	}

	public void deleteAllCertificates(String property) throws IOException, InterruptedException {

		try {
			// enter the property name in the search field
			type("envreports_propertylist_filtertxt_CSS", property);

			// click on the sustainability icon
			click("sustainabilityicon_CSS");

			// wait for the element
			Thread.sleep(5000);

			// click on the side menu
			click("ssc_leftsidemenubtn_CSS");

			// wait for the element
			Thread.sleep(5000);

			// click on the certifications option
			click("sustainability_sidemenu_certificationsoption_XPATH");

			try {
				List<WebElement> certificate = driver
						.findElements(By.xpath("//table[@class='table table-striped table-hover']//tbody//tr"));
				int certificatenum = certificate.size();

				for (int i = 0; i < certificatenum; i++) {

					// click on the first record of the utility bill
					click("sustainability_certification_firstrecord_XPATH");

					// wait for the element
					explicitWaitClickable("sustainability_certification_deletebtn_XPATH");

					// click on the delete button
					click("sustainability_certification_deletebtn_XPATH");

					// wait for the element
					explicitWaitClickable("sustainability_certification_deletebtn_confirmation_XPATH");

					// click on the delete button of the confirmation popup
					click("sustainability_certification_deletebtn_confirmation_XPATH");

					// wait for the element
					explicitWaitClickable("closetoastmsg_CSS");

					// click on the toaster close button
					click("closetoastmsg_CSS");

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

	}

	// add random name to questionnaire
	public void randomText() throws InterruptedException, IOException {

		try {
			// enter the random string in the questionnaire title field: clear, generate
			// string, enter

			String s = RandomStringUtils.randomAlphabetic(8);
			type("questionnaire_questionnairetitletxt_CSS", s);

			// click on the save button
			click("questionnaire_savebtn_BTNTEXT");

			// enter newly created questionnaire in the filter field
			type("ssc_company2_questionnairelist_filtertxt_CSS", s);

			// validate random questionnaire name is displayed or not
			try {
				String questionnaire_XPATH = "//td[text()='" + s + "']";
				String questionnaireName = (driver.findElement(By.xpath(questionnaire_XPATH)).getText()).trim();

				if (questionnaireName.equals(s)) {

					successMessage("The " + s + " questionnaire is verified successfully.");

				} else {
					verificationFailedMessage("The " + s + " questionnaire is not verified.");
				}

			} catch (Throwable t) {
				verificationFailedMessage("The " + s + " questionnaire is not verified.");
			}

		} catch (Throwable t) {
			verificationFailed();
		}
	}

	public void configureQuestions(Hashtable<String, String> data) throws IOException, InterruptedException {

		try {
			// click on the more button
			click("questionnaire_morebtn_CSS");

			// click on the configure questions option
			click("questionnaire_configurebtn_CSS");

			// wait for the element
			Thread.sleep(3000);

			// click on the new category button
			click("questionnaire_newcategorybtn_BTNTEXT");

			// select the language
			select("questionnaire_newcategory_languagedd_XPATH", data.get("category_language"));

			// wait for the element
			Thread.sleep(3000);

			// enter the title
			type("questionnaire_newcategory_titletxt_MODEL", data.get("category_title_1"));

			// click on the save button
			click("questionnaire_newcategory_savebtn_CSS");

			// verify newly created category is displayed or not
			switchVerification("questionnaire_newcategory_1_XPATH", "Test Category Title One",
					"The Test Category Title One is not displayed.");

			// ADD CATEGORY 2 INTO THE QUESTIONNAIRE

			title("ADD CATEGORY 2 INTO THE QUESTIONNAIRE");

			// wait for the element
			Thread.sleep(3000);

			// click on the new category button
			click("questionnaire_newcategorybtn_BTNTEXT");

			// select the language
			select("questionnaire_newcategory_languagedd_XPATH", data.get("category_language"));

			// wait for the element
			Thread.sleep(3000);

			// enter the title
			type("questionnaire_newcategory_titletxt_MODEL", data.get("category_title_2"));

			// click on the save button
			click("questionnaire_newcategory_savebtn_CSS");

			// verify newly created category is displayed or not
			switchVerification("questionnaire_newcategory_2_XPATH", "Test Category Title Two Two",
					"The Test Category Title Two Two is not displayed.");

			// ADD QUESTIONS INTO THE CATEGORY
			title("ADD QUESTIONS INTO THE CATEGORY");

			// wait for the element
			Thread.sleep(3000);

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

			// wait for the element
			Thread.sleep(3000);

			// click on the save button
			click("questionnaire_newquestion_savebtn_CSS");

			// verify question one created or not
			switchVerification("questionnaire_newquestion_1_XPATH", "Test Question Title One",
					"The Test Question Title One question is not displayed.");

			// wait for the element
			Thread.sleep(3000);

			// click on the new question button
			click("questionnaire_newquestionbtn_CSS");

			// select the English language from the language dropdown
			select("questionnaire_newquestion_languagedd_CSS", data.get("question_language"));

			// enter the label
			type("questionnaire_newquestion_labeltxt_CSS", data.get("question_label_2"));

			// enter the title
			type("questionnaire_newquestion_titletxt_CSS", data.get("question_title_2"));

			// wait for the element
			Thread.sleep(3000);

			// click on the save button
			click("questionnaire_newquestion_savebtn_CSS");

			// verify question two created or not
			switchVerification("questionnaire_newquestion_2_XPATH", "Test Question Title Two Two",
					"The Test Question Title Two Two question is not displayed.");

			// click on the save button of the questions
			click("questionnaire_saveallquestionbtn_CSS");

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

		} catch (Throwable t) {
			verificationFailed();
		}
	}

	public void configureQuestionsAutoTask(Hashtable<String, String> data) throws IOException, InterruptedException {

		try {
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
			click("questionnaire_question_1_notaskicon_CSS");

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

		} catch (Throwable t) {
			verificationFailed();
		}
	}

	public void configureQuestionAutoTaskDependancy(Hashtable<String, String> data)
			throws IOException, InterruptedException {

		try {
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
			verifyTrue("questionnaire_newcategory_1_XPATH",
					"The newly created category is not displayed in the category list.");

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
			verifyTrue("questionnaire_newcategory_2_XPATH",
					"The newly created category is not displayed in the category list.");

			// ADD QUESTIONS INTO THE CATEGORY
			title("ADD QUESTIONS INTO THE CATEGORY");

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
			verifyTrue("questionnaire_newquestion_1_XPATH", "The question is not created.");

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
			verifyTrue("questionnaire_newquestion_2_XPATH", "The question is not created.");

			// click on the save button of the questions
			click("questionnaire_saveallquestionbtn_CSS");

			// CREATE THE AUTO GENERATE TASK
			title("CREATE THE AUTO GENERATE TASK");

			// click on the edit question 2 button
			click("questionnaire_question_2_editbtn_CSS");

			// click on the task icon of the no option
			click("questionnaire_question_2_notaskicon_CSS");

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
			scrollTillElement("questionnaire_createtask_savebtn_CSS");

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

			// click on the edit button of the question 2
			click("questionnaire_question_2_editbtn_CSS");

			// scroll till the comment field
			scrollTillElement("questionnaire_question_1_commentandinstructiontxt_CSS");

			// click on the dependency button of the question 2
			click("questionnaire_question_2_dependencybtn_CSS");

			// click on the add icon of the depends on question
			click("questionnaire_question_dependancies_addbtn1_CSS");

			// enter the data in the filter field of the dependency
			type("questionnaire_question_dependancies_filter_CSS", data.get("question_title_1"));

			// click on the filtered result
			click("questionnaire_question_dependancies_filteredresult_CSS");

			// select the yes option from the dropdown
			select("questionnaire_yesselect_CSS", data.get("dependency_dd"));

			// click on the save button
			click("questionnaire_question_dependancies_savebtn_CSS");

			// click on the back to questions button
			click("questionnaire_question_1_option_backtoquestionsbtn_CSS");

			// click on the save button for save all the question
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

		} catch (Throwable t) {
			verificationFailed();
		}
	}

	public void createSurveyQuestionnaire(Hashtable<String, String> data) throws IOException, InterruptedException {

		try {
			// click on the new questionnaire
			click("questionnaire_newquestionnairebtn_CSS");

			// Select the type of the questionnaire
			click("questionnaire_type_propertybtn_CSS");

			// Select the level of the questionnaire
			click("questionnaire_level_propertybtn_CSS");

			// enter the group title
			type("questionnaire_grouptitletxt_CSS", data.get("group_title"));

			// enter the questionnaire title
			type("questionnaire_questionnairetitletxt_CSS", data.get("questionnaire_title"));

			// select the model
			select("questionnaire_modeldd_CSS", data.get("model"));

			// select the frequency
			select("questionnaire_frequencydd_CSS", data.get("frequency"));

			// enter the year
			type("questionnaire_yeartxt_CSS", "2020");

			// select the month
			select("questionnaire_monthtxt_CSS", data.get("month"));

			// enter the description
			type("questionnaire_descriptiontxt_CSS", data.get("description"));

			// click on the save button
			click("questionnaire_savebtn_BTNTEXT");

		} catch (Throwable t) {
			verificationFailed();
		}
	}

	public void createChecklistQuestionnaire(Hashtable<String, String> data) throws InterruptedException, IOException {

		try {
			// click on the new questionnaire
			click("questionnaire_newquestionnairebtn_CSS");

			// Select the Inspection / Checklist of the questionnaire
			click("questionnaire_type_inspectionbtn_CSS");

			// Select the level of the questionnaire
			click("questionnaire_level_propertybtn_CSS");

			// enter the group title
			type("questionnaire_grouptitletxt_CSS", data.get("group_title"));

			// enter the questionnaire title
			type("questionnaire_languagetitle_CSS", data.get("questionnaire_checklist_title"));

			// select the model
			select("questionnaire_modeldd_CSS", data.get("model"));

			// enter frequency interval
			type("questionnaire_frequencyintervaltxt_CSS", "1");

			// enter the description
			type("questionnaire_descriptiontxt_CSS", data.get("description"));

			// select the classic option from the default view drop down
			select("questionnaire_checklist_defaultview_CSS", data.get("default_view"));

			// scroll down the screen
			scrollByPixel(500);

			// click on the warranty checkbox
			click("questionnaire_warrantybtn_CSS");

			// click on the save button
			click("questionnaire_savebtn_BTNTEXT");

		} catch (Throwable t) {
			verificationFailed();
		}

	}

	public void deleteSurveyQuestionnaire(Hashtable<String, String> data) throws InterruptedException, IOException {

		try {
			// click on the more button
			click("questionnaire_morebtn_CSS");

			// click on the configure questions option
			click("questionnaire_configurebtn_CSS");

			// click on the edit button of category one
			click("questionnaire_category_editbtn_CSS");

			// click on the edit question button
			click("questionnaire_category_editquestionbtn_BTNTEXT");

			// click on the delete button of the question 1
			click("questionnaire_question_1_deletebtn_CSS");

			// wait for the element
			explicitWaitClickable("questionnaire_question_1_deletebtn_CSS");

			// click on the delete button of the question 2
			click("questionnaire_question_1_deletebtn_CSS");

			// click on the save button of the questions
			click("questionnaire_saveallquestionbtn_CSS");

			// click on the back to category button
			click("questionnaire_question_1_backtocategorybtn_CSS");

			// click on the delete button of the category 1
			click("questionnaire_category_1_deletebtn_CSS");

			// wait for the element
			explicitWaitClickable("questionnaire_category_1_deletebtn_CSS");

			// click on the delete button of the category 2
			click("questionnaire_category_1_deletebtn_CSS");

			// click on the save button for save all categories
			click("questionnaire_category_savebtn_CSS");

			// wait for the element
			explicitWaitClickable("closetoastmsg_CSS");

			// click on the toaster close button
			click("closetoastmsg_CSS");

			// click on the back to questionnaire button
			click("questionnaire_category_backtoquestionnairesbtn_CSS");

		} catch (Throwable t) {
			verificationFailed();
		}
	}

	public void questionnaireNotDisplayLogout(Hashtable<String, String> data) throws IOException, InterruptedException {

		try {

			verificationFailedMessage("An exeptions are occured in this user, So logout from this user.");

			driver.navigate().refresh();
			Thread.sleep(3000);
			driver.navigate().refresh();

			// wait for the element
			explicitWaitClickable("questionnaire_settingicon_userupdate_CSS");

			// click on the settings icon from the top of the screen
			click("questionnaire_settingicon_userupdate_CSS");

			// wait for the element
			explicitWaitClickable("sidemenu_logout_CSS");

			// click on the logout option from the side menu
			click("sidemenu_logout_CSS");

			// login with valid credentials
			loginAndUpdateSystemCompany(data, "username_1", "password_1", "system_company_1");

		} catch (Throwable t) {
			verificationFailed();
		}
	}

	public void switchSystemCompany(Hashtable<String, String> data) throws InterruptedException, IOException {

		try {
			// wait for the element
			explicitWaitClickable("questionnaire_settingicon_CSS");

			// click on the settings icon from the top of the screen
			click("questionnaire_settingicon_CSS");

			// wait for the element
			explicitWaitClickable("ssc_sidemenubtn_CSS");

			// click on the Switch System Company option from the side menu
			click("ssc_sidemenubtn_CSS");

			// click on the switch system company dropdown
			click("ssc_systemcompanydd_CSS");

			// select the company 2 from the system company dropdown
			select("ssc_systemcompanydd_CSS", data.get("system_company_1"));

			// click on system company dropdown
			click("ssc_systemcompanydd_CSS");

			// click on the select button
			click("ssc_selectbtn_BTNTEXT");

			// wait for the element
			explicitWait("propertylist_title_XPATH");

			// verify the property list
			switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		} catch (Throwable t) {
			verificationFailed();
		}
	}

	public void addPermissionTwoUsersRole(Hashtable<String, String> data, String search, String locator)
			throws InterruptedException, IOException {

		try {
			// enter security setting name in the search field
			type("propertyproject_le_filtertxt_CSS", data.get(search));

			// click on the searched result
			click(locator);

			// click on the select role field
			click("propertyproject_securitysettings1_selectroles_CSS");

			// click on the none button
			click("propertyproject_securitysettings1_nonebtn_CSS");

			// enter the name of the role in search field
			type("propertyproject_securitysettings1_searchtxt_CSS", data.get("role_1"));

			// click on the searched result
			click("propertyproject_securitysettings1_searchedcontractor_XPATH");

			// click on the select role field
			click("propertyproject_securitysettings1_selectroles_CSS");

			// click on the select user field
			click("propertyproject_securitysettings1_selectusers_CSS");

			// click on the none button
			click("propertyproject_securitysettings1_nonebtn_CSS");

			// enter the name of the user in search field
			type("propertyproject_securitysettings1_searchtxt_CSS", data.get("user_1"));

			// click on the searched result
			click("propertyproject_securitysettings1_searcheduser_XPATH");

			// enter the name of the user in search field
			type("propertyproject_securitysettings1_searchtxt_CSS", data.get("user1_1"));

			// click on the searched result
			click("propertyproject_securitysettings1_searchedhr1_XPATH");

			// click on the select user field
			click("propertyproject_securitysettings1_selectusers_CSS");

			// click on the save button
			click("propertyproject_securitysettings1_savebtn_CSS");

			// wait for the element
			explicitWaitClickable("closetoastmsg_CSS");

			// click on the toaster close button
			click("closetoastmsg_CSS");

		} catch (Throwable t) {
			verificationFailed();
		}
	}

	public void addPermissionOneUsersRoleTask(Hashtable<String, String> data, String search, String locator)
			throws InterruptedException, IOException {

		try {
			// enter security setting name in the search field
			type("propertyproject_le_filtertxt_CSS", data.get(search));

			// click on the searched result
			click(locator);

			// click on the select role field
			click("propertyproject_securitysettings1_selectroles_CSS");

			// click on the none button
			click("propertyproject_securitysettings1_nonebtn_CSS");

			// enter the name of the role in search field
			type("propertyproject_securitysettings1_searchtxt_CSS", data.get("role_1"));

			// click on the searched result
			click("task_permission_securitysettings_seachedrole_XPATH");

			// click on the select role field
			click("propertyproject_securitysettings1_selectroles_CSS");

			// click on the select user field
			click("propertyproject_securitysettings1_selectusers_CSS");

			// click on the none button
			click("propertyproject_securitysettings1_nonebtn_CSS");

			// enter the name of the user in search field
			type("propertyproject_securitysettings1_searchtxt_CSS", data.get("user_1"));

			// click on the searched result
			click("task_permission_securitysettings_seacheduser_XPATH");

			// click on the select user field
			click("propertyproject_securitysettings1_selectusers_CSS");

			// click on the save button
			click("propertyproject_securitysettings1_savebtn_CSS");

			// wait for the element
			explicitWaitClickable("closetoastmsg_CSS");

			// click on the toaster close button
			click("closetoastmsg_CSS");

		} catch (Throwable t) {
			verificationFailed();
		}
	}

	public void addPermissionOneUsersRole(Hashtable<String, String> data, String search, String locator)
			throws InterruptedException, IOException {

		try {
			// enter security setting name in the search field
			type("propertyproject_le_filtertxt_CSS", data.get(search));

			// click on the searched result
			click(locator);

			// click on the select role field
			click("propertyproject_securitysettings1_selectroles_CSS");

			// click on the none button
			click("propertyproject_securitysettings1_nonebtn_CSS");

			// enter the name of the role in search field
			type("propertyproject_securitysettings1_searchtxt_CSS", data.get("role_1"));

			// click on the searched result
			click("propertyproject_securitysettings1_searchedcontractor_XPATH");

			// click on the select role field
			click("propertyproject_securitysettings1_selectroles_CSS");

			// click on the select user field
			click("propertyproject_securitysettings1_selectusers_CSS");

			// click on the none button
			click("propertyproject_securitysettings1_nonebtn_CSS");

			// enter the name of the user in search field
			type("propertyproject_securitysettings1_searchtxt_CSS", data.get("user_1"));

			// click on the searched result
			click("propertyproject_securitysettings1_searcheduser_XPATH");

			// click on the select user field
			click("propertyproject_securitysettings1_selectusers_CSS");

			// click on the save button
			click("propertyproject_securitysettings1_savebtn_CSS");

			// wait for the element
			explicitWaitClickable("closetoastmsg_CSS");

			// click on the toaster close button
			click("closetoastmsg_CSS");

		} catch (Throwable t) {
			verificationFailed();
		}
	}

	public void resetPermission(Hashtable<String, String> data, String search, String locator)
			throws InterruptedException, IOException {

		try {
			// enter security setting name in the search field
			type("propertyproject_le_filtertxt_CSS", data.get(search));

			// click on the searched result
			click(locator);

			// click on the select role field
			click("propertyproject_securitysettings1_selectroles_CSS");

			// click on the none button
			click("propertyproject_securitysettings1_nonebtn_CSS");

			// click on the select role field
			click("propertyproject_securitysettings1_selectroles_CSS");

			// click on the select user field
			click("propertyproject_securitysettings1_selectusers_CSS");

			// click on the none button
			click("propertyproject_securitysettings1_nonebtn_CSS");

			// click on the select user field
			click("propertyproject_securitysettings1_selectusers_CSS");

			// click on the save button
			click("propertyproject_securitysettings1_savebtn_CSS");

			// wait for the element
			explicitWaitClickable("closetoastmsg_CSS");

			// click on the toaster close button
			click("closetoastmsg_CSS");

		} catch (Throwable t) {
			verificationFailed();
		}
	}

	public void deleteVerification(String locator, String expectedResult) {
		try {

			String deleteElement = (driver.findElement(By.xpath(OR.getProperty(locator))).getText()).trim();

			if (deleteElement.equals(expectedResult)) {

				verificationFailedMessage("The  " + expectedResult + " is not deleted.");

			} else {
				successMessage("The " + expectedResult + " is deleted successfully.");
			}
		} catch (Throwable t) {

			successMessage("The " + expectedResult + " is deleted successfully.");

		}

	}

	public void selectRoleForSecuritySetting(Hashtable<String, String> data, String permissionName,
			String searchedPermissionName, String roleName, String seachedRoleName)
			throws InterruptedException, IOException {

		try {
			// search the Access to PO section in tasks
			type("envreports_propertylist_filtertxt_CSS", data.get(permissionName));

			// click on the searched security setting
			click(searchedPermissionName);

			// click on the role field
			click("securitysettings_rolenametxt_CSS");

			// click on the none button
			click("riskmanagement_nonebtn_CSS");

			// enter the role in the search field
			type("task_tasktag_searchtxt_CSS", data.get(roleName));

			// click on the searched role
			click(seachedRoleName);

			// click on the role field
			click("securitysettings_rolenametxt_CSS");

			// click on the user field
			click("task_permission_securitysettings_usertxt_CSS");

			// click on the none button
			click("riskmanagement_nonebtn_CSS");

			// click on the user field
			click("task_permission_securitysettings_usertxt_CSS");

			// click on the save button
			click("securitysettings_accesssurveychecklist_CSS");

			// wait for the element
			explicitWaitClickable("closetoastmsg_CSS");

			// click on the toaster close button
			click("closetoastmsg_CSS");

		} catch (Throwable t) {
			verificationFailed();
		}
	}

	public void selectUserForSecuritySetting(Hashtable<String, String> data, String permissionName,
			String searchedPermissionName, String userName, String seachedUserName)
			throws InterruptedException, IOException {

		try {
			// search the permission in the search field
			type("envreports_propertylist_filtertxt_CSS", data.get(permissionName));

			// click on the searched security setting
			click(searchedPermissionName);

			// click on the role field
			click("securitysettings_rolenametxt_CSS");

			// click on the none button
			click("riskmanagement_nonebtn_CSS");

			// click on the role field
			click("securitysettings_rolenametxt_CSS");

			// click on the user field
			click("task_permission_securitysettings_usertxt_CSS");

			// click on the none button
			click("riskmanagement_nonebtn_CSS");

			// enter the user in the search field
			type("task_tasktag_searchtxt_CSS", data.get(userName));

			// click on the searched role
			click(seachedUserName);

			// click on the user field
			click("task_permission_securitysettings_usertxt_CSS");

			// click on the save button
			click("securitysettings_accesssurveychecklist_CSS");

			// wait for the element
			explicitWaitClickable("closetoastmsg_CSS");

			// click on the toaster close button
			click("closetoastmsg_CSS");

		} catch (Throwable t) {
			verificationFailed();
		}
	}

	// UPDATE THE SYSTEM COMPANY

	public void updateCompany(Hashtable<String, String> data) throws IOException, InterruptedException {
		try {
			// wait for the element
			explicitWaitClickable("questionnaire_settingicon_CSS");

			// click on the settings icon from the top of the screen
			click("questionnaire_settingicon_CSS");

			// wait for the element
			explicitWaitClickable("ssc_sidemenubtn_CSS");

			// click on the Switch System Company option from the side menu
			click("ssc_sidemenubtn_CSS");

			// click on the switch system company dropdown
			click("ssc_systemcompanydd_CSS");

			// select the system company from the system company dropdown
			select("ssc_systemcompanydd_CSS", data.get("system_company_1"));

			// click on system company dropdown
			click("ssc_systemcompanydd_CSS");

			// click on the select button
			click("ssc_selectbtn_BTNTEXT");

			// wait for the element
			explicitWait("propertylist_title_XPATH");

			// verify the property list
			switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		} catch (Throwable t) {
			verificationFailed();
		}

	}

	public void loginAndUpdateSystemCompany(Hashtable<String, String> data, String username, String password,
			String SystemCompany) throws IOException, InterruptedException {

		// LOGIN WITH VALID CREDENTIALS
		title("LOGIN WITH VALID CREDENTIALS");

		try {

			// wait for the element
			explicitWaitClickable("signinbtn_BTNTEXT");

			// Enter the username
			type("username_MODEL", data.get(username));

			// Enter the password
			type("password_MODEL", data.get(password));

			// Click on the Sign In button
			click("signinbtn_BTNTEXT");

			// wait for the element
			Thread.sleep(10000);

			// wait for the element
			explicitWait("propertylist_title_XPATH");

			// verify the property list
			switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		} catch (Throwable t) {
			verificationFailed();
		}

		// VALIDATE THE SYSTEM COMPANY
		title("VALIDATE THE SYSTEM COMPANY");

		try {

			// enter the property name in the search field
			type("ssc_company2_propertylist_filtertxt_CSS", "[DND] AAAA Risk Test Prop 01");

			String propertyName = (driver.findElement(By.cssSelector(OR.getProperty("task_navigation_property1_CSS")))
					.getText()).trim();

			System.out.println("///////////////// property name::::" + propertyName);

			if (propertyName.equals("[DND] AAAA Risk Test Prop 01")) {

				successMessage("CORRECT SYSTEM COMPANY SELECTED");

				// clear the search field
				clear("ssc_company2_propertylist_filtertxt_CSS");

				// wait for 5 seconds
				Thread.sleep(5000);

			} else {
				verificationFailed();
			}

		} catch (Throwable t) {
			// UPDATING THE SYSTEM COMPANY
			title("UPDATING THE SYSTEM COMPANY");

			// wait for 5 seconds
			Thread.sleep(5000);

			// click on the settings icon from the top of the screen
			click("questionnaire_settingicon_CSS");

			// wait for 5 seconds
			Thread.sleep(5000);

			// click on the Switch System Company option from the side menu
			click("ssc_sidemenubtn_CSS");

			// wait for 5 seconds
			explicitWaitClickable("ssc_systemcompanydd_CSS");

			// click on the switch system company dropdown
			click("ssc_systemcompanydd_CSS");

			// select the company 2 from the system company dropdown
			select("ssc_systemcompanydd_CSS", data.get(SystemCompany));

			// click on system company dropdown
			click("ssc_systemcompanydd_CSS");

			// wait for the element
			Thread.sleep(5000);

			// click on the select button
			click("companysystem_selectbtn_XPATH");

			// wait for the element
			explicitWait("propertylist_title_XPATH");

			// verify the property list
			switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");
		}
	}

}
