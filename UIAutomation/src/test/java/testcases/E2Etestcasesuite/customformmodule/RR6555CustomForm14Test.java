package testcases.E2Etestcasesuite.customformmodule;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Random;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import base.Helper;
import base.TestBase;
import utilities.TestUtil;

public class RR6555CustomForm14Test extends TestBase {

	@Test(dataProviderClass = TestUtil.class, dataProvider = "dp")
	public void rR6555CustomForm14Test(Hashtable<String, String> data) throws IOException, InterruptedException {

		execution(data, "rR6555CustomForm14Test");

		// VERIFY THE COMMENT FIELD OF THE RISK SCORE SCREEN WITH DIFFERENT USERS.
		title("VERIFY THE COMMENT FIELD OF THE RISK SCORE SCREEN WITH DIFFERENT USERS.");

		// refresh the page
		driver.navigate().refresh();
		Thread.sleep(5000);
		driver.navigate().refresh();

		Helper helper = new Helper();

		Random random = new Random();
		int count_1 = random.nextInt(3 - 2) + 2;
		int count_2 = random.nextInt(3 - 2) + 2;
		int count_3 = random.nextInt(3 - 2) + 2;
		int count_4 = random.nextInt(3 - 2) + 2;

		String comment_1 = RandomStringUtils.randomAlphabetic(8);
		List<String> comment_list_1 = new ArrayList<String>();

		String comment_2 = RandomStringUtils.randomAlphabetic(8);
		List<String> comment_list_2 = new ArrayList<String>();

		String comment_3 = RandomStringUtils.randomAlphabetic(8);
		List<String> comment_list_3 = new ArrayList<String>();

		String comment_4 = RandomStringUtils.randomAlphabetic(8);
		List<String> comment_list_4 = new ArrayList<String>();

		String year = null;
		String month = null;

		// SET THE VIEW RISK SCORE SECURITY PERMISSION IN ADMINISTRATION
		title("SET THE VIEW RISK SCORE SECURITY PERMISSION IN ADMINISTRATION.");

		try {

			// wait for the element
			explicitWaitClickable("questionnaire_settingicon_CSS");

			// click on the settings icon from the top of the screen
			click("questionnaire_settingicon_CSS");

			// wait for the element
			explicitWaitClickable("questionnaire_administrationoption_XPATH");

			// click on the Administration option from the side menu
			click("questionnaire_administrationoption_XPATH");

			// click on the security tab
			click("questionnaire_securitytab_XPATH");

			// click on the security settings option
			click("questionnaire_securotysettingsoption_XPATH");

			// APPLY THE VIEW RISK SCORE PERMISSION
			helper.addPermissionOneUsersRole(data, "security_settings",
					"customform_securitysetting_viewriskscore_XPATH");

			// LOGOUT FROM THE ADMIN USER AND AGAIN LOGIN WITH THE SAME ADMIN USER
			title("LOGOUT FROM THE ADMIN USER AND AGAIN LOGIN WITH THE SAME ADMIN USER");

			// wait for the element
			explicitWaitClickable("questionnaire_settingicon_CSS");

			// click on the settings icon from the top of the screen
			click("questionnaire_settingicon_CSS");

			// wait for the element
			explicitWaitClickable("sidemenu_logout_CSS");

			// click on the logout option from the side menu
			click("sidemenu_logout_CSS");

			// LOGIN ON ADMIN USER
			title("LOGIN ON ADMIN USER");

			helper.loginAndUpdateSystemCompany(data, "username_1", "password_1", "system_company_1");

		} catch (Throwable t) {
			verificationFailed();
		}

		// click on the home icon
		click("questionnaire_homeburgermenubtn_CSS");

		// wait for the element
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// VALIDATE THE COMMENT FIELD AND MULTIPLE COMMENT RECORDS OF THE RISK SCORE IN
		// THE PORTFOLIO DASHBOARD FROM ADMIN USER
		title("VALIDATE THE COMMENT FIELD AND MULTIPLE COMMENT RECORDS OF THE RISK SCORE IN THE PORTFOLIO DASHBOARD FROM ADMIN USER");

		try {

			// wait for the element
			Thread.sleep(5000);

			// click on the side menu
			click("menubtn_CSS");

			// wait for the element
			Thread.sleep(5000);

			// click on the portfolio dashboard from side menu
			click("sidemenu_portfoliosummary_XPATH");

			// scrolldown till risk scoring card
			scrollTillElement("customform_portfoliodashboard_riskscoringcard_XPATH");

			// click on the graph of the risk card
			click("customform_portfoliodashboard_riskscoringcard_graph_XPATH");

			// select the random option from year dropdown
			selectRandom("customform_portfoliodashboard_riskscoringcard_yeardd_XPATH");

			// click on the year dropdown
			click("customform_portfoliodashboard_riskscoringcard_yeardd_XPATH");

			// Getting list of options
			List<WebElement> yearList = driver.findElements(By.xpath("//select[@ng-model='filters.year']//option"));

			// Getting size of options available
			int yearCount = yearList.size();

			// Generate a random number with in range
			int random_count = random.nextInt(yearCount);

			// Selecting random value
			year = yearList.get(random_count).getText();

			// click on the randomly selected option
			yearList.get(random_count).click();

			// click on the month dropdown
			click("customform_portfoliodashboard_riskscoringcard_monthdd_XPATH");

			// Getting list of options
			List<WebElement> monthList = driver.findElements(By.xpath("//select[@ng-model='filters.month']//option"));

			// Getting size of options available
			int monthCount = monthList.size();

			// Generate a random number with in range
			int random_monthcount = random.nextInt(monthCount);

			// Selecting random value
			month = monthList.get(random_monthcount).getText();

			// click on the randomly selected option
			monthList.get(random_monthcount).click();

			// scroll down to bottom
			scrollBottom();

			for (int i = 0; i < count_1; i++) {

				// enter the comment in the comment field
				type("portfolio_riskcard_commenttxt_XPATH", comment_1);

				// add the comments in the list
				comment_list_1.add(comment_1);

				// click on the save button
				click("portfolio_riskcard_savecommentbtn_XPATH");

				// wait for the element
				Thread.sleep(3000);

			}

			// click on the comment history button
			click("portfolio_riskcard_historycommentbtn_XPATH");

			// scroll down to bottom
			scrollBottom();

			for (int j = 0; j < count_1; j++) {

				try {
					// validate the entered comment from the admin account
					String addedComment = "//td[text()='" + data.get("admin_user")
							+ "']//following-sibling::td[text()='" + comment_list_1.get(j) + "']";
					boolean comment_actual = driver.findElement(By.xpath(addedComment)).isDisplayed();

					if (comment_actual == true) {
						successMessage("The respective added comment i.e. " + comment_list_1.get(j)
								+ "is displayed successfully.");
					} else {
						verificationFailedMessage(
								"The respective added comment i.e. " + comment_list_1.get(j) + "is not displayed.");
					}
				} catch (Throwable t) {
					verificationFailedMessage(
							"The respective added comment i.e. " + comment_list_1.get(j) + "is not displayed.");
				}
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

		// VALIDATE THE COMMENT FIELD AND MULTIPLE COMMENT RECORDS OF THE RISK SCORE IN
		// THE PROPERTY SUMMARY DASHBOARD
		title("VALIDATE THE COMMENT FIELD AND MULTIPLE COMMENT RECORDS OF THE RISK SCORE IN THE PROPERTY SUMMARY DASHBOARD");

		try {

			// wait for the element
			Thread.sleep(5000);

			// click on the property
			click("propertysummary_property1_XPATH");

			// scrolldown till risk scoring card
			scrollTillElement("customform_portfoliodashboard_riskscoringcard_XPATH");

			// click on the graph of the risk card
			click("customform_portfoliodashboard_riskscoringcard_graph_XPATH");

			// select the current year in the year dropdown
			select("customform_portfoliodashboard_riskscoringcard_yeardd_XPATH", year);

			// select the current year in the month dropdown
			select("customform_portfoliodashboard_riskscoringcard_monthdd_XPATH", month);

			// scroll down to bottom
			scrollBottom();

			for (int i = 0; i < count_2; i++) {

				// enter the comment in the comment field
				type("portfolio_riskcard_commenttxt_XPATH", comment_2);

				// add the comments in the list
				comment_list_2.add(comment_2);

				// click on the save button
				click("portfolio_riskcard_savecommentbtn_XPATH");

				// wait for the element
				Thread.sleep(3000);

			}

			// click on the comment history button
			click("portfolio_riskcard_historycommentbtn_XPATH");

			// scroll down to bottom
			scrollBottom();

			for (int j = 0; j < count_1; j++) {

				try {
					// validate the entered comment from the admin account
					String addedComment = "//td[text()='" + data.get("admin_user")
							+ "']//following-sibling::td[text()='" + comment_list_1.get(j) + "']";
					boolean comment_actual = driver.findElement(By.xpath(addedComment)).isDisplayed();

					if (comment_actual == true) {
						successMessage("The respective added comment i.e. " + comment_list_1.get(j)
								+ "is displayed successfully.");
					} else {
						verificationFailedMessage(
								"The respective added comment i.e. " + comment_list_1.get(j) + "is not displayed.");
					}
				} catch (Throwable t) {
					verificationFailedMessage(
							"The respective added comment i.e. " + comment_list_1.get(j) + "is not displayed.");
				}
			}

			for (int j = 0; j < count_2; j++) {

				try {
					// validate the entered comment from the admin account
					String addedComment = "//td[text()='" + data.get("admin_user")
							+ "']//following-sibling::td[text()='" + comment_list_2.get(j) + "']";
					boolean comment_actual = driver.findElement(By.xpath(addedComment)).isDisplayed();

					if (comment_actual == true) {
						successMessage("The respective added comment i.e. " + comment_list_2.get(j)
								+ "is displayed successfully.");
					} else {
						verificationFailedMessage(
								"The respective added comment i.e. " + comment_list_2.get(j) + "is not displayed.");
					}
				} catch (Throwable t) {
					verificationFailedMessage(
							"The respective added comment i.e. " + comment_list_2.get(j) + "is not displayed.");
				}
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

		// LOGOUT FROM THE ADMIN USER AND LOGIN IN THE PROPERTY MANAGER USER
		title("LOGOUT FROM THE ADMIN USER AND LOGIN IN THE PROPERTY MANAGER USER");

		try {
			// wait for the element
			explicitWaitClickable("questionnaire_settingicon_CSS");

			// click on the settings icon from the top of the screen
			click("questionnaire_settingicon_CSS");

			// wait for the element
			explicitWaitClickable("sidemenu_logout_CSS");

			// click on the logout option from the side menu
			click("sidemenu_logout_CSS");

			// LOGIN IN JINESH USER
			title("LOGIN IN JINESH USER");

			helper.loginAndUpdateSystemCompany(data, "username", "password", "system_company_1");

			// VALIDATE THE COMMENT FIELD AND MULTIPLE COMMENT RECORDS OF THE RISK SCORE IN
			// THE PORTFOLIO DASHBOARD FROM PROPERTY MANAGER USER
			title("VALIDATE THE COMMENT FIELD AND MULTIPLE COMMENT RECORDS OF THE RISK SCORE IN THE PORTFOLIO DASHBOARD FROM PROPERTY MANAGER USER");

			try {

				// wait for the element
				Thread.sleep(5000);

				// click on the side menu
				click("menubtn_CSS");

				// wait for the element
				Thread.sleep(5000);

				// click on the portfolio dashboard from side menu
				click("sidemenu_portfoliosummary_XPATH");

				// scrolldown till risk scoring card
				scrollTillElement("customform_portfoliodashboard_riskscoringcard_XPATH");

				// click on the graph of the risk card
				click("customform_portfoliodashboard_riskscoringcard_graph_XPATH");

				// select the current year in the year dropdown
				select("customform_portfoliodashboard_riskscoringcard_yeardd_XPATH", year);

				// select the current year in the month dropdown
				select("customform_portfoliodashboard_riskscoringcard_monthdd_XPATH", month);

				// scroll down to bottom
				scrollBottom();

				for (int i = 0; i < count_3; i++) {

					// enter the comment in the comment field
					type("portfolio_riskcard_commenttxt_XPATH", comment_3);

					// add the comments in the list
					comment_list_3.add(comment_3);

					// click on the save button
					click("portfolio_riskcard_savecommentbtn_XPATH");

					// wait for the element
					Thread.sleep(3000);

				}

				// click on the comment history button
				click("portfolio_riskcard_historycommentbtn_XPATH");

				// scroll down to bottom
				scrollBottom();

				for (int j = 0; j < count_1; j++) {

					try {
						// validate the entered comment from the admin account
						String addedComment = "//td[text()='" + data.get("admin_user")
								+ "']//following-sibling::td[text()='" + comment_list_1.get(j) + "']";
						boolean comment_actual = driver.findElement(By.xpath(addedComment)).isDisplayed();

						if (comment_actual == true) {
							successMessage("The respective added comment i.e. " + comment_list_1.get(j)
									+ "is displayed successfully.");
						} else {
							verificationFailedMessage(
									"The respective added comment i.e. " + comment_list_1.get(j) + "is not displayed.");
						}
					} catch (Throwable t) {
						verificationFailedMessage(
								"The respective added comment i.e. " + comment_list_1.get(j) + "is not displayed.");
					}
				}

				for (int j = 0; j < count_2; j++) {

					try {
						// validate the entered comment from the admin account
						String addedComment = "//td[text()='" + data.get("admin_user")
								+ "']//following-sibling::td[text()='" + comment_list_2.get(j) + "']";
						boolean comment_actual = driver.findElement(By.xpath(addedComment)).isDisplayed();

						if (comment_actual == true) {
							successMessage("The respective added comment i.e. " + comment_list_2.get(j)
									+ "is displayed successfully.");
						} else {
							verificationFailedMessage(
									"The respective added comment i.e. " + comment_list_2.get(j) + "is not displayed.");
						}
					} catch (Throwable t) {
						verificationFailedMessage(
								"The respective added comment i.e. " + comment_list_2.get(j) + "is not displayed.");
					}
				}

				for (int j = 0; j < count_3; j++) {

					try {
						// validate the entered comment from the property manager account
						String addedComment = "//td[text()='" + data.get("other_user")
								+ "']//following-sibling::td[text()='" + comment_list_3.get(j) + "']";
						boolean comment_actual = driver.findElement(By.xpath(addedComment)).isDisplayed();

						if (comment_actual == true) {
							successMessage("The respective added comment i.e. " + comment_list_3.get(j)
									+ "is displayed successfully.");
						} else {
							verificationFailedMessage(
									"The respective added comment i.e. " + comment_list_3.get(j) + "is not displayed.");
						}
					} catch (Throwable t) {
						verificationFailedMessage(
								"The respective added comment i.e. " + comment_list_3.get(j) + "is not displayed.");
					}
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

			// VALIDATE THE COMMENT FIELD AND MULTIPLE COMMENT RECORDS OF THE RISK SCORE IN
			// THE PROPERTY SUMMARY DASHBOARD FROM PROPERTY MANAGER USER
			title("VALIDATE THE COMMENT FIELD AND MULTIPLE COMMENT RECORDS OF THE RISK SCORE IN THE PROPERTY SUMMARY DASHBOARD FROM PROPERTY MANAGER USER");

			try {

				// wait for the element
				Thread.sleep(5000);

				// click on the property
				click("propertysummary_property1_XPATH");

				// scrolldown till risk scoring card
				scrollTillElement("customform_portfoliodashboard_riskscoringcard_XPATH");

				// click on the graph of the risk card
				click("customform_portfoliodashboard_riskscoringcard_graph_XPATH");

				// select the current year in the year dropdown
				select("customform_portfoliodashboard_riskscoringcard_yeardd_XPATH", year);

				// select the current year in the month dropdown
				select("customform_portfoliodashboard_riskscoringcard_monthdd_XPATH", month);

				// scroll down to bottom
				scrollBottom();

				for (int i = 0; i < count_4; i++) {

					// enter the comment in the comment field
					type("portfolio_riskcard_commenttxt_XPATH", comment_4);

					// add the comments in the list
					comment_list_4.add(comment_4);

					// click on the save button
					click("portfolio_riskcard_savecommentbtn_XPATH");

					// wait for the element
					Thread.sleep(3000);

				}

				// click on the comment history button
				click("portfolio_riskcard_historycommentbtn_XPATH");

				// scroll down to bottom
				scrollBottom();

				for (int j = 0; j < count_1; j++) {

					try {
						// validate the entered comment from the admin account
						String addedComment = "//td[text()='" + data.get("admin_user")
								+ "']//following-sibling::td[text()='" + comment_list_1.get(j) + "']";
						boolean comment_actual = driver.findElement(By.xpath(addedComment)).isDisplayed();

						if (comment_actual == true) {
							successMessage("The respective added comment i.e. " + comment_list_1.get(j)
									+ "is displayed successfully.");
						} else {
							verificationFailedMessage(
									"The respective added comment i.e. " + comment_list_1.get(j) + "is not displayed.");
						}
					} catch (Throwable t) {
						verificationFailedMessage(
								"The respective added comment i.e. " + comment_list_1.get(j) + "is not displayed.");
					}
				}

				for (int j = 0; j < count_2; j++) {

					try {
						// validate the entered comment from the admin account
						String addedComment = "//td[text()='" + data.get("admin_user")
								+ "']//following-sibling::td[text()='" + comment_list_2.get(j) + "']";
						boolean comment_actual = driver.findElement(By.xpath(addedComment)).isDisplayed();

						if (comment_actual == true) {
							successMessage("The respective added comment i.e. " + comment_list_2.get(j)
									+ "is displayed successfully.");
						} else {
							verificationFailedMessage(
									"The respective added comment i.e. " + comment_list_2.get(j) + "is not displayed.");
						}
					} catch (Throwable t) {
						verificationFailedMessage(
								"The respective added comment i.e. " + comment_list_2.get(j) + "is not displayed.");
					}
				}

				for (int j = 0; j < count_3; j++) {

					try {
						// validate the entered comment from the property manager account
						String addedComment = "//td[text()='" + data.get("other_user")
								+ "']//following-sibling::td[text()='" + comment_list_3.get(j) + "']";
						boolean comment_actual = driver.findElement(By.xpath(addedComment)).isDisplayed();

						if (comment_actual == true) {
							successMessage("The respective added comment i.e. " + comment_list_3.get(j)
									+ "is displayed successfully.");
						} else {
							verificationFailedMessage(
									"The respective added comment i.e. " + comment_list_3.get(j) + "is not displayed.");
						}
					} catch (Throwable t) {
						verificationFailedMessage(
								"The respective added comment i.e. " + comment_list_3.get(j) + "is not displayed.");
					}
				}

				for (int j = 0; j < count_4; j++) {

					try {
						// validate the entered comment from the property manager account
						String addedComment = "//td[text()='" + data.get("other_user")
								+ "']//following-sibling::td[text()='" + comment_list_4.get(j) + "']";
						boolean comment_actual = driver.findElement(By.xpath(addedComment)).isDisplayed();

						if (comment_actual == true) {
							successMessage("The respective added comment i.e. " + comment_list_4.get(j)
									+ "is displayed successfully.");
						} else {
							verificationFailedMessage(
									"The respective added comment i.e. " + comment_list_4.get(j) + "is not displayed.");
						}
					} catch (Throwable t) {
						verificationFailedMessage(
								"The respective added comment i.e. " + comment_list_4.get(j) + "is not displayed.");
					}
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

			// LOGOUT FROM THE PROPERTY MANAGER USER AND LOGIN IN THE ADMIN USER
			title("LOGOUT FROM THE PROPERTY MANAGER USER AND LOGIN IN THE ADMIN USER");

			// wait for the element
			explicitWaitClickable("questionnaire_settingicon_CSS");

			// click on the settings icon from the top of the screen
			click("questionnaire_settingicon_CSS");

			// wait for the element
			explicitWaitClickable("sidemenu_logout_CSS");

			// click on the logout option from the side menu
			click("sidemenu_logout_CSS");

			// LOGIN ON ADMIN USER
			title("LOGIN ON ADMIN USER");

			helper.loginAndUpdateSystemCompany(data, "username_1", "password_1", "system_company_1");

		} catch (Throwable t) {
			helper.questionnaireNotDisplayLogout(data);
		}

		// RESET THE SYSTEM SETTING PERMISSION FOR VIEW RISK SCORE
		title("RESET THE SYSTEM SETTING PERMISSION FOR VIEW RISK SCORE");

		try {
			// wait for the element
			explicitWaitClickable("questionnaire_settingicon_CSS");

			// click on the settings icon from the top of the screen
			click("questionnaire_settingicon_CSS");

			// wait for the element
			explicitWaitClickable("questionnaire_administrationoption_XPATH");

			// click on the Administration option from the side menu
			click("questionnaire_administrationoption_XPATH");

			// click on the security tab
			click("questionnaire_securitytab_XPATH");

			// click on the security settings option
			click("questionnaire_securotysettingsoption_XPATH");

			// enter security setting name in the search field
			type("propertyproject_le_filtertxt_CSS", data.get("security_settings"));

			// click on the searched result
			click("customform_securitysetting_viewriskscore_XPATH");

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

			// enter the name of the user in search field
			type("propertyproject_securitysettings1_searchtxt_CSS", data.get("username_1"));

			// click on the searched result
			click("propertyproject_securitysettings1_adminsearcheduser_XPATH");

			// click on the select user field
			click("propertyproject_securitysettings1_selectusers_CSS");

			// click on the save button
			click("propertyproject_securitysettings1_savebtn_CSS");

			// wait for the element
			explicitWaitClickable("closetoastmsg_CSS");

			// click on the toaster close button
			click("closetoastmsg_CSS");

			// LOGOUT FROM THE ADMIN USER AND AGAIN LOGIN WITH THE SAME ADMIN USER
			title("LOGOUT FROM THE ADMIN USER AND AGAIN LOGIN WITH THE SAME ADMIN USER");

			// wait for the element
			explicitWaitClickable("questionnaire_settingicon_CSS");

			// click on the settings icon from the top of the screen
			click("questionnaire_settingicon_CSS");

			// wait for the element
			explicitWaitClickable("sidemenu_logout_CSS");

			// click on the logout option from the side menu
			click("sidemenu_logout_CSS");

			// LOGIN ON ADMIN USER
			title("LOGIN ON ADMIN USER");

			helper.loginAndUpdateSystemCompany(data, "username_1", "password_1", "system_company_1");

		} catch (Throwable t) {
			verificationFailed();
		}

		// click on the home icon from the top of the screen
		click("questionnaire_homeburgermenubtn_CSS");

		// wait for the element
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

	}
}
