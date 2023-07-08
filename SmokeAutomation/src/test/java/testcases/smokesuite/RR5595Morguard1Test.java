package testcases.smokesuite;

import java.io.IOException;
import java.util.Hashtable;
import java.util.List;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Reporter;
import org.testng.SkipException;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import base.Helper;
import base.TestBase;
import utilities.TestUtil;

public class RR5595Morguard1Test extends TestBase {

	@Test(dataProviderClass = TestUtil.class, dataProvider = "dp")
	public void rR5595Morguard1Test(Hashtable<String, String> data) throws IOException, InterruptedException {

		if (!(TestUtil.isTestRunnable("rR5595Morguard1Test", excel))) {

			throw new SkipException(
					"Skipping the test " + "rR5595Morguard1Test".toUpperCase() + "as the Run mode is NO");
		}

		if (!data.get("runmode").equals("Y")) {

			throw new SkipException("Skipping the test case as the Run Mode for data set is NO");
		}

		Helper helper = new Helper();

		// refresh the page
		driver.navigate().refresh();
		Thread.sleep(5000);
		driver.navigate().refresh();

		// LOGIN WITH ADMIN USER

		System.out.println("******************** LOGIN WITH ADMIN USER ********************");
		test.log(LogStatus.INFO, "******************** LOGIN WITH ADMIN USER ********************");
		Reporter.log("******************** LOGIN WITH ADMIN USER ********************");
		log.info("******************** LOGIN WITH ADMIN USER ********************");

		try {
			// wait for the element
			explicitWaitClickable("signinbtn_BTNTEXT");

			// Enter the username
			type("usernametxt_CSS", data.get("username_1"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the username.");

			// Enter the password
			type("passwordtxt_CSS", data.get("password_1"));
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

		} catch (Throwable t) {
			verificationFailed();
		}

		// MORGUARD INTERNAL AND EXTERNAL USERS SHOULD BE LISTED IN THE USER
		// ADMINISTRATION SECTION

		System.out.println(
				"******************** MORGUARD INTERNAL AND EXTERNAL USERS SHOULD BE LISTED IN THE USER ADMINISTRATION SECTION ********************");
		test.log(LogStatus.INFO,
				"******************** MORGUARD INTERNAL AND EXTERNAL USERS SHOULD BE LISTED IN THE USER ADMINISTRATION SECTION ********************");
		Reporter.log(
				"******************** MORGUARD INTERNAL AND EXTERNAL USERS SHOULD BE LISTED IN THE USER ADMINISTRATION SECTION ********************");
		log.info(
				"******************** MORGUARD INTERNAL AND EXTERNAL USERS SHOULD BE LISTED IN THE USER ADMINISTRATION SECTION ********************");
		try {

			// wait for 3 seconds
			Thread.sleep(5000);

			// click on the settings icon from the top of the screen
			click("questionnaire_settingicon_CSS");
			System.out.println("Clicked on the settings icon.");
			ngDriver.waitForAngularRequestsToFinish();

			// wait for 3 seconds
			Thread.sleep(3000);

			// click on the Administration option from the side menu
			click("questionnaire_administrationoption_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the Administration option from the side menu.");

			// click on the security tab
			click("questionnaire_securitytab_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the security tab.");

			// click on the users tab
			click("questionnaire_usersoption_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the users tab.");

			// enter the name of the external user
			clear("users_filtertxt_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Cleared the search field.");
			type("users_filtertxt_CSS", data.get("external_user"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the name of the external user.");

			// verify the external user is display or not
			switchVerification("users_username_externaluser_XPATH", "jineshexternal",
					"The jineshexternal is not displayed.");

			// enter the name of the internal user
			clear("users_filtertxt_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Cleared the search field.");
			type("users_filtertxt_CSS", data.get("internal_user"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the name of the internal user.");

			// verify the internal user is display or not
			switchVerification("users_username_internaluser_XPATH", "jineshinternal",
					"The jineshinternal is not displayed.");

		} catch (Throwable t) {
			verificationFailed();
		}

		// click on the home icon from the top of the screen
		click("questionnaire_homeburgermenubtn_CSS");
		System.out.println("Clicked on the home icon from the top of the screen.");
		ngDriver.waitForAngularRequestsToFinish();

		// wait for the element
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// VERIFY ROLES THAT TAKE PRECEDENCE SHOULD HAVE A LOWER RANK THAN THE OTHERS

		System.out.println(
				"******************** VERIFY ROLES THAT TAKE PRECEDENCE SHOULD HAVE A LOWER RANK THAN THE OTHERS ********************");
		test.log(LogStatus.INFO,
				"******************** VERIFY ROLES THAT TAKE PRECEDENCE SHOULD HAVE A LOWER RANK THAN THE OTHERS ********************");
		Reporter.log(
				"******************** VERIFY ROLES THAT TAKE PRECEDENCE SHOULD HAVE A LOWER RANK THAN THE OTHERS ********************");
		log.info(
				"******************** VERIFY ROLES THAT TAKE PRECEDENCE SHOULD HAVE A LOWER RANK THAN THE OTHERS ********************");

		try {

			// wait for 3 seconds
			Thread.sleep(5000);

			// click on the settings icon from the top of the screen
			click("questionnaire_settingicon_CSS");
			System.out.println("Clicked on the settings icon.");
			ngDriver.waitForAngularRequestsToFinish();

			// wait for 3 seconds
			Thread.sleep(3000);

			// click on the Administration option from the side menu
			click("questionnaire_administrationoption_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the Administration option from the side menu.");

			// click on the security tab
			click("questionnaire_securitytab_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the security tab.");

			// click on the role tab
			click("questionnaire_rolesoption_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the roles tab.");

			// VERIFY RANK OF THE ENVIRO-ADMIN ROLE

			System.out.println("VERIFY RANK OF THE ENVIRO-ADMIN ROLE.");
			test.log(LogStatus.INFO, "VERIFY RANK OF THE ENVIRO-ADMIN ROLE.");
			Reporter.log("VERIFY RANK OF THE ENVIRO-ADMIN ROLE.");
			log.info("VERIFY RANK OF THE ENVIRO-ADMIN ROLE.");

			// scroll down the screen
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,200)");

			try {
				String pages = driver.findElement(By.cssSelector("strong")).getText();
				String[] arrOfStr = pages.split(" ");
				String pageno = arrOfStr[3];
				int pagecount = Integer.parseInt(pageno);

				outerloop: for (int i = 0; i < pagecount; i++) {

					List<WebElement> roles = driver.findElements(By.xpath("//tr//div"));
					int rolesnum = roles.size();

					for (int j = 0; j < rolesnum; j++) {

						WebElement rolestext = roles.get(j);
						String getrole = rolestext.getText();

						if (getrole.equalsIgnoreCase("Enviro-Admins")) {

							// verify rank of the enviro-admins role is displayed correct or not
							String enviro_admin = (driver
									.findElement(
											By.xpath(OR.getProperty("task_permission_role_enviroadmin_rank_XPATH")))
									.getText()).trim();

							if (enviro_admin.equals("1")) {
								System.out.println("THE RANK OF THE ENVIRO-ADMIN ROLE IS DISPLAYED CORRECTLY.");
								test.log(LogStatus.INFO, "THE RANK OF THE ENVIRO-ADMIN ROLE IS DISPLAYED CORRECTLY.");
								Reporter.log("THE RANK OF THE ENVIRO-ADMIN ROLE IS DISPLAYED CORRECTLY.");
								log.info("THE RANK OF THE ENVIRO-ADMIN ROLE IS DISPLAYED CORRECTLY.");

							} else {
								verificationFailed();
							}

							// VERIFY PERMISSION OF THE ADMINISTRATION TO THE ENVIRO-ADMIN ROLE
							helper.rolePermissionValidation("Enviro-Admins", "ADMINISTRATION", "2", "green",
									"checkmark");

							// VERIFY PERMISSION OF THE PROPERTY EDIT TO THE ENVIRO-ADMIN ROLE
							helper.rolePermissionValidation("Enviro-Admins", "PROPERTY EDIT", "3", "green",
									"checkmark");

							// VERIFY PERMISSION OF THE SEES ALL PROPERTIES TO THE ENVIRO-ADMIN ROLE
							helper.rolePermissionValidation("Enviro-Admins", "SEES ALL PROPERTIES", "4", "green",
									"checkmark");

							// VERIFY PERMISSION OF THE SEES ALL TASKS TO THE ENVIRO-ADMIN ROLE
							helper.rolePermissionValidation("Enviro-Admins", "SEES ALL TASKS", "5", "red", "close");

							// VERIFY PERMISSION OF THE WEEKLY TASK EMAILS TO THE ENVIRO-ADMIN ROLE
							helper.rolePermissionValidation("Enviro-Admins", "WEEKLY TASK EMAILS", "6", "red", "close");

							// VERIFY PERMISSION OF THE DEFAULT ROLE TO THE ENVIRO-ADMIN ROLE
							helper.rolePermissionValidation("Enviro-Admins", "DEFAULT ROLE", "7", "red", "close");

							break outerloop;
						}

					}

					// click on the next button
					click("task_permission_roles_nextbtn_CSS");
					ngDriver.waitForAngularRequestsToFinish();
					System.out.println("Clicked on the next button.");

				}
			} catch (Throwable t) {
				verificationFailed();
			}

			// VERIFY RANK OF THE ENVIRO-MANAGERS ROLE

			System.out.println("VERIFY RANK OF THE ENVIRO-MANAGERS ROLE.");
			test.log(LogStatus.INFO, "VERIFY RANK OF THE ENVIRO-MANAGERS ROLE.");
			Reporter.log("VERIFY RANK OF THE ENVIRO-MANAGERS ROLE.");
			log.info("VERIFY RANK OF THE ENVIRO-MANAGERS ROLE.");

			// scroll up the screen
			js.executeScript("window.scrollBy(0,-200)");

			// click on the administration option
			click("administration_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the administration option.");

			// click on the security tab
			click("questionnaire_securitytab_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the security tab.");

			// click on the role tab
			click("questionnaire_rolesoption_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the roles tab.");

			// scroll down the screen
			js.executeScript("window.scrollBy(0,200)");

			try {
				String pages = driver.findElement(By.cssSelector("strong")).getText();
				String[] arrOfStr = pages.split(" ");
				String pageno = arrOfStr[3];
				int pagecount = Integer.parseInt(pageno);

				outerloop: for (int i = 0; i < pagecount; i++) {

					List<WebElement> roles = driver.findElements(By.xpath("//tr//div"));
					int rolesnum = roles.size();

					for (int j = 0; j < rolesnum; j++) {

						WebElement rolestext = roles.get(j);
						String getrole = rolestext.getText();

						if (getrole.equalsIgnoreCase("Enviro-Managers")) {

							// verify rank of the Enviro-Managers role is displayed correct or not
							String enviro_manager = (driver
									.findElement(
											By.xpath(OR.getProperty("task_permission_role_enviromanager_rank_XPATH")))
									.getText()).trim();

							if (enviro_manager.equals("25")) {
								System.out.println("THE RANK OF THE ENVIRO-MANAGERS ROLE IS DISPLAYED CORRECTLY.");
								test.log(LogStatus.INFO,
										"THE RANK OF THE ENVIRO-MANAGERS ROLE IS DISPLAYED CORRECTLY.");
								Reporter.log("THE RANK OF THE ENVIRO-MANAGERS ROLE IS DISPLAYED CORRECTLY.");
								log.info("THE RANK OF THE ENVIRO-MANAGERS ROLE IS DISPLAYED CORRECTLY.");

							} else {
								verificationFailed();
							}

							// VERIFY PERMISSION OF THE ADMINISTRATION TO THE ENVIRO-MANAGERS ROLE
							helper.rolePermissionValidation("Enviro-Managers", "ADMINISTRATION", "2", "red", "close");

							// VERIFY PERMISSION OF THE PROPERTY EDIT TO THE ENVIRO-MANAGERS ROLE
							helper.rolePermissionValidation("Enviro-Managers", "PROPERTY EDIT", "3", "red", "close");

							// VERIFY PERMISSION OF THE SEES ALL PROPERTIES TO THE ENVIRO-MANAGERS ROLE
							helper.rolePermissionValidation("Enviro-Managers", "SEES ALL PROPERTIES", "4", "green",
									"checkmark");

							// VERIFY PERMISSION OF THE SEES ALL TASKS TO THE ENVIRO-MANAGERS ROLE
							helper.rolePermissionValidation("Enviro-Managers", "SEES ALL TASKS", "5", "red", "close");

							// VERIFY PERMISSION OF THE WEEKLY TASK EMAILS TO THE ENVIRO-MANAGERS ROLE
							helper.rolePermissionValidation("Enviro-Managers", "WEEKLY TASK EMAILS", "6", "red",
									"close");

							// VERIFY PERMISSION OF THE DEFAULT ROLE TO THE ENVIRO-MANAGERS ROLE
							helper.rolePermissionValidation("Enviro-Managers", "DEFAULT ROLE", "7", "red", "close");

							break outerloop;
						}
					}

					// click on the next button
					click("task_permission_roles_nextbtn_CSS");
					ngDriver.waitForAngularRequestsToFinish();
					System.out.println("Clicked on the next button.");

				}
			} catch (Throwable t) {
				verificationFailed();
			}

			// VERIFY RANK OF THE ENVIRO-CONSULTANTS ROLE

			System.out.println("VERIFY RANK OF THE ENVIRO-CONSULTANTS ROLE.");
			test.log(LogStatus.INFO, "VERIFY RANK OF THE ENVIRO-CONSULTANTS ROLE.");
			Reporter.log("VERIFY RANK OF THE ENVIRO-CONSULTANTS ROLE.");
			log.info("VERIFY RANK OF THE ENVIRO-CONSULTANTS ROLE.");

			// scroll up the screen
			js.executeScript("window.scrollBy(0,-200)");

			// click on the administration option
			click("administration_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the administration option.");

			// click on the security tab
			click("questionnaire_securitytab_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the security tab.");

			// click on the role tab
			click("questionnaire_rolesoption_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the roles tab.");

			// scroll down the screen
			js.executeScript("window.scrollBy(0,200)");

			try {
				String pages = driver.findElement(By.cssSelector("strong")).getText();
				String[] arrOfStr = pages.split(" ");
				String pageno = arrOfStr[3];
				int pagecount = Integer.parseInt(pageno);

				outerloop: for (int i = 0; i < pagecount; i++) {

					List<WebElement> roles = driver.findElements(By.xpath("//tr//div"));
					int rolesnum = roles.size();

					for (int j = 0; j < rolesnum; j++) {

						WebElement rolestext = roles.get(j);
						String getrole = rolestext.getText();

						if (getrole.equalsIgnoreCase("Enviro-Consultants")) {

							// verify rank of the Enviro-Consultants role is displayed correct or not
							String enviro_consultants = (driver
									.findElement(By
											.xpath(OR.getProperty("task_permission_role_enviroconsultants_rank_XPATH")))
									.getText()).trim();

							if (enviro_consultants.equals("50")) {
								System.out.println("THE RANK OF THE ENVIRO-CONSULTANTS ROLE IS DISPLAYED CORRECTLY.");
								test.log(LogStatus.INFO,
										"THE RANK OF THE ENVIRO-CONSULTANTS ROLE IS DISPLAYED CORRECTLY.");
								Reporter.log("THE RANK OF THE ENVIRO-CONSULTANTS ROLE IS DISPLAYED CORRECTLY.");
								log.info("THE RANK OF THE ENVIRO-CONSULTANTS ROLE IS DISPLAYED CORRECTLY.");

							} else {
								verificationFailed();
							}

							// VERIFY PERMISSION OF THE ADMINISTRATION TO THE ENVIRO-CONSULTANTS ROLE
							helper.rolePermissionValidation("Enviro-Consultants", "ADMINISTRATION", "2", "red",
									"close");

							// VERIFY PERMISSION OF THE PROPERTY EDIT TO THE ENVIRO-CONSULTANTS ROLE
							helper.rolePermissionValidation("Enviro-Consultants", "PROPERTY EDIT", "3", "green",
									"checkmark");

							// VERIFY PERMISSION OF THE SEES ALL PROPERTIES TO THE ENVIRO-CONSULTANTS ROLE
							helper.rolePermissionValidation("Enviro-Consultants", "SEES ALL PROPERTIES", "4", "red",
									"close");

							// VERIFY PERMISSION OF THE SEES ALL TASKS TO THE ENVIRO-CONSULTANTS ROLE
							helper.rolePermissionValidation("Enviro-Consultants", "SEES ALL TASKS", "5", "red",
									"close");

							// VERIFY PERMISSION OF THE WEEKLY TASK EMAILS TO THE ENVIRO-CONSULTANTS ROLE
							helper.rolePermissionValidation("Enviro-Consultants", "WEEKLY TASK EMAILS", "6", "red",
									"close");

							// VERIFY PERMISSION OF THE DEFAULT ROLE TO THE ENVIRO-CONSULTANTS ROLE
							helper.rolePermissionValidation("Enviro-Consultants", "DEFAULT ROLE", "7", "red", "close");

							break outerloop;
						}
					}

					// click on the next button
					click("task_permission_roles_nextbtn_CSS");
					ngDriver.waitForAngularRequestsToFinish();
					System.out.println("Clicked on the next button.");

				}
			} catch (Throwable t) {
				verificationFailed();
			}

			// VERIFY RANK OF THE ENVIRO-USERS ROLE

			System.out.println("VERIFY RANK OF THE ENVIRO-USERS ROLE.");
			test.log(LogStatus.INFO, "VERIFY RANK OF THE ENVIRO-USERS ROLE.");
			Reporter.log("VERIFY RANK OF THE ENVIRO-USERS ROLE.");
			log.info("VERIFY RANK OF THE ENVIRO-USERS ROLE.");

			// scroll up the screen
			js.executeScript("window.scrollBy(0,-200)");

			// click on the administration option
			click("administration_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the administration option.");

			// click on the security tab
			click("questionnaire_securitytab_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the security tab.");

			// click on the role tab
			click("questionnaire_rolesoption_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the roles tab.");

			// scroll down the screen
			js.executeScript("window.scrollBy(0,200)");

			try {
				String pages = driver.findElement(By.cssSelector("strong")).getText();
				String[] arrOfStr = pages.split(" ");
				String pageno = arrOfStr[3];
				int pagecount = Integer.parseInt(pageno);

				outerloop: for (int i = 0; i < pagecount; i++) {

					List<WebElement> roles = driver.findElements(By.xpath("//tr//div"));
					int rolesnum = roles.size();

					for (int j = 0; j < rolesnum; j++) {

						WebElement rolestext = roles.get(j);
						String getrole = rolestext.getText();

						if (getrole.equalsIgnoreCase("Enviro-Users")) {

							// verify rank of the Enviro-Users role is displayed correct or not
							String enviro_users = (driver
									.findElement(
											By.xpath(OR.getProperty("task_permission_role_envirousers_rank_XPATH")))
									.getText()).trim();

							if (enviro_users.equals("75")) {
								System.out.println("THE RANK OF THE ENVIRO-USERS ROLE IS DISPLAYED CORRECTLY.");
								test.log(LogStatus.INFO, "THE RANK OF THE ENVIRO-USERS ROLE IS DISPLAYED CORRECTLY.");
								Reporter.log("THE RANK OF THE ENVIRO-USERS ROLE IS DISPLAYED CORRECTLY.");
								log.info("THE RANK OF THE ENVIRO-USERS ROLE IS DISPLAYED CORRECTLY.");

							} else {
								verificationFailed();
							}

							// VERIFY PERMISSION OF THE ADMINISTRATION TO THE ENVIRO-USERS ROLE
							helper.rolePermissionValidation("Enviro-Users", "ADMINISTRATION", "2", "red", "close");

							// VERIFY PERMISSION OF THE PROPERTY EDIT TO THE ENVIRO-USERS ROLE
							helper.rolePermissionValidation("Enviro-Users", "PROPERTY EDIT", "3", "red", "close");

							// VERIFY PERMISSION OF THE SEES ALL PROPERTIES TO THE ENVIRO-USERS ROLE
							helper.rolePermissionValidation("Enviro-Users", "SEES ALL PROPERTIES", "4", "green",
									"checkmark");

							// VERIFY PERMISSION OF THE SEES ALL TASKS TO THE ENVIRO-USERS ROLE
							helper.rolePermissionValidation("Enviro-Users", "SEES ALL TASKS", "5", "red", "close");

							// VERIFY PERMISSION OF THE WEEKLY TASK EMAILS TO THE ENVIRO-USERS ROLE
							helper.rolePermissionValidation("Enviro-Users", "WEEKLY TASK EMAILS", "6", "red", "close");

							// VERIFY PERMISSION OF THE DEFAULT ROLE TO THE ENVIRO-USERS ROLE
							helper.rolePermissionValidation("Enviro-Users", "DEFAULT ROLE", "7", "red", "close");

							break outerloop;
						}
					}

					// click on the next button
					click("task_permission_roles_nextbtn_CSS");
					ngDriver.waitForAngularRequestsToFinish();
					System.out.println("Clicked on the next button.");

				}
			} catch (Throwable t) {
				verificationFailed();
			}

			// VERIFY RANK OF THE ENVIRO-MIL-R-G ROLE

			System.out.println("VERIFY RANK OF THE ENVIRO-MIL-R-G ROLE.");
			test.log(LogStatus.INFO, "VERIFY RANK OF THE ENVIRO-MIL-R-G ROLE.");
			Reporter.log("VERIFY RANK OF THE ENVIRO-MIL-R-G ROLE.");
			log.info("VERIFY RANK OF THE ENVIRO-MIL-R-G ROLE.");

			// scroll up the screen
			js.executeScript("window.scrollBy(0,-200)");

			// click on the administration option
			click("administration_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the administration option.");

			// click on the security tab
			click("questionnaire_securitytab_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the security tab.");

			// click on the role tab
			click("questionnaire_rolesoption_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the roles tab.");

			// scroll down the screen
			js.executeScript("window.scrollBy(0,200)");

			try {
				String pages = driver.findElement(By.cssSelector("strong")).getText();
				String[] arrOfStr = pages.split(" ");
				String pageno = arrOfStr[3];
				int pagecount = Integer.parseInt(pageno);

				outerloop: for (int i = 0; i < pagecount; i++) {

					List<WebElement> roles = driver.findElements(By.xpath("//tr//div"));
					int rolesnum = roles.size();

					for (int j = 0; j < rolesnum; j++) {

						WebElement rolestext = roles.get(j);
						String getrole = rolestext.getText();

						if (getrole.equalsIgnoreCase("Enviro-MIL-R-G")) {

							// verify rank of the Enviro-MIL-R-G role is displayed correct or not
							String enviro_mil = (driver
									.findElement(
											By.xpath(OR.getProperty("task_permission_role_enviromilrg_rank_XPATH")))
									.getText()).trim();

							if (enviro_mil.equals("100")) {
								System.out.println("THE RANK OF THE ENVIRO-MIL-R-G ROLE IS DISPLAYED CORRECTLY.");
								test.log(LogStatus.INFO, "THE RANK OF THE ENVIRO-MIL-R-G ROLE IS DISPLAYED CORRECTLY.");
								Reporter.log("THE RANK OF THE ENVIRO-MIL-R-G ROLE IS DISPLAYED CORRECTLY.");
								log.info("THE RANK OF THE ENVIRO-MIL-R-G ROLE IS DISPLAYED CORRECTLY.");

							} else {
								verificationFailed();
							}

							// VERIFY PERMISSION OF THE ADMINISTRATION TO THE ENVIRO-MIL-R-G ROLE
							helper.rolePermissionValidation("Enviro-MIL-R-G", "ADMINISTRATION", "2", "red", "close");

							// VERIFY PERMISSION OF THE PROPERTY EDIT TO THE ENVIRO-MIL-R-G ROLE
							helper.rolePermissionValidation("Enviro-MIL-R-G", "PROPERTY EDIT", "3", "red", "close");

							// VERIFY PERMISSION OF THE SEES ALL PROPERTIES TO THE ENVIRO-MIL-R-G ROLE
							helper.rolePermissionValidation("Enviro-MIL-R-G", "SEES ALL PROPERTIES", "4", "green",
									"checkmark");

							// VERIFY PERMISSION OF THE SEES ALL TASKS TO THE ENVIRO-MIL-R-G ROLE
							helper.rolePermissionValidation("Enviro-MIL-R-G", "SEES ALL TASKS", "5", "red", "close");

							// VERIFY PERMISSION OF THE WEEKLY TASK EMAILS TO THE ENVIRO-MIL-R-G ROLE
							helper.rolePermissionValidation("Enviro-MIL-R-G", "WEEKLY TASK EMAILS", "6", "red",
									"close");

							// VERIFY PERMISSION OF THE DEFAULT ROLE TO THE ENVIRO-MIL-R-G ROLE
							helper.rolePermissionValidation("Enviro-MIL-R-G", "DEFAULT ROLE", "7", "red", "close");

							break outerloop;
						}
					}

					// click on the next button
					click("task_permission_roles_nextbtn_CSS");
					ngDriver.waitForAngularRequestsToFinish();
					System.out.println("Clicked on the next button.");

				}
			} catch (Throwable t) {
				verificationFailed();
			}

			// VERIFY RANK OF THE ENVIRO-MRC-R-G ROLE

			System.out.println("VERIFY RANK OF THE ENVIRO-MRC-R-G ROLE.");
			test.log(LogStatus.INFO, "VERIFY RANK OF THE ENVIRO-MRC-R-G ROLE.");
			Reporter.log("VERIFY RANK OF THE ENVIRO-MRC-R-G ROLE.");
			log.info("VERIFY RANK OF THE ENVIRO-MRC-R-G ROLE.");

			// scroll up the screen
			js.executeScript("window.scrollBy(0,-200)");

			// click on the administration option
			click("administration_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the administration option.");

			// click on the security tab
			click("questionnaire_securitytab_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the security tab.");

			// click on the role tab
			click("questionnaire_rolesoption_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the roles tab.");

			// scroll down the screen
			js.executeScript("window.scrollBy(0,200)");

			try {
				String pages = driver.findElement(By.cssSelector("strong")).getText();
				String[] arrOfStr = pages.split(" ");
				String pageno = arrOfStr[3];
				int pagecount = Integer.parseInt(pageno);

				outerloop: for (int i = 0; i < pagecount; i++) {

					List<WebElement> roles = driver.findElements(By.xpath("//tr//div"));
					int rolesnum = roles.size();

					for (int j = 0; j < rolesnum; j++) {

						WebElement rolestext = roles.get(j);
						String getrole = rolestext.getText();

						if (getrole.equalsIgnoreCase("Enviro-MRC-R-G")) {

							// verify rank of the Enviro-MRC-R-G role is displayed correct or not
							String enviro_mrc = (driver
									.findElement(
											By.xpath(OR.getProperty("task_permission_role_enviromrcrg_rank_XPATH")))
									.getText()).trim();

							if (enviro_mrc.equals("100")) {
								System.out.println("THE RANK OF THE ENVIRO-MRC-R-G ROLE IS DISPLAYED CORRECTLY.");
								test.log(LogStatus.INFO, "THE RANK OF THE ENVIRO-MRC-R-G ROLE IS DISPLAYED CORRECTLY.");
								Reporter.log("THE RANK OF THE ENVIRO-MRC-R-G ROLE IS DISPLAYED CORRECTLY.");
								log.info("THE RANK OF THE ENVIRO-MRC-R-G ROLE IS DISPLAYED CORRECTLY.");

							} else {
								verificationFailed();
							}

							// VERIFY PERMISSION OF THE ADMINISTRATION TO THE ENVIRO-MRC-R-G ROLE
							helper.rolePermissionValidation("Enviro-MRC-R-G", "ADMINISTRATION", "2", "red", "close");

							// VERIFY PERMISSION OF THE PROPERTY EDIT TO THE ENVIRO-MRC-R-G ROLE
							helper.rolePermissionValidation("Enviro-MRC-R-G", "PROPERTY EDIT", "3", "red", "close");

							// VERIFY PERMISSION OF THE SEES ALL PROPERTIES TO THE ENVIRO-MRC-R-G ROLE
							helper.rolePermissionValidation("Enviro-MRC-R-G", "SEES ALL PROPERTIES", "4", "green",
									"checkmark");

							// VERIFY PERMISSION OF THE SEES ALL TASKS TO THE ENVIRO-MRC-R-G ROLE
							helper.rolePermissionValidation("Enviro-MRC-R-G", "SEES ALL TASKS", "5", "red", "close");

							// VERIFY PERMISSION OF THE WEEKLY TASK EMAILS TO THE ENVIRO-MRC-R-G ROLE
							helper.rolePermissionValidation("Enviro-MRC-R-G", "WEEKLY TASK EMAILS", "6", "red",
									"close");

							// VERIFY PERMISSION OF THE DEFAULT ROLE TO THE ENVIRO-MRC-R-G ROLE
							helper.rolePermissionValidation("Enviro-MRC-R-G", "DEFAULT ROLE", "7", "red", "close");

							break outerloop;
						}
					}

					// click on the next button
					click("task_permission_roles_nextbtn_CSS");
					ngDriver.waitForAngularRequestsToFinish();
					System.out.println("Clicked on the next button.");

				}
			} catch (Throwable t) {
				verificationFailed();
			}

			// VERIFY RANK OF THE ENVIRO-MREIT-R-G ROLE

			System.out.println("VERIFY RANK OF THE ENVIRO-MREIT-R-G ROLE.");
			test.log(LogStatus.INFO, "VERIFY RANK OF THE ENVIRO-MREIT-R-G ROLE.");
			Reporter.log("VERIFY RANK OF THE ENVIRO-MREIT-R-G ROLE.");
			log.info("VERIFY RANK OF THE ENVIRO-MREIT-R-G ROLE.");

			// scroll up the screen
			js.executeScript("window.scrollBy(0,-200)");

			// click on the administration option
			click("administration_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the administration option.");

			// click on the security tab
			click("questionnaire_securitytab_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the security tab.");

			// click on the role tab
			click("questionnaire_rolesoption_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the roles tab.");

			// scroll down the screen
			js.executeScript("window.scrollBy(0,200)");

			try {
				String pages = driver.findElement(By.cssSelector("strong")).getText();
				String[] arrOfStr = pages.split(" ");
				String pageno = arrOfStr[3];
				int pagecount = Integer.parseInt(pageno);

				outerloop: for (int i = 0; i < pagecount; i++) {

					List<WebElement> roles = driver.findElements(By.xpath("//tr//div"));
					int rolesnum = roles.size();

					for (int j = 0; j < rolesnum; j++) {

						WebElement rolestext = roles.get(j);
						String getrole = rolestext.getText();

						if (getrole.equalsIgnoreCase("Enviro-MREIT-R-G")) {

							// verify rank of the Enviro-MREIT-R-G role is displayed correct or not
							String enviro_mreit = (driver
									.findElement(
											By.xpath(OR.getProperty("task_permission_role_enviromreitrg_rank_XPATH")))
									.getText()).trim();

							if (enviro_mreit.equals("100")) {
								System.out.println("THE RANK OF THE ENVIRO-MREIT-R-G ROLE IS DISPLAYED CORRECTLY.");
								test.log(LogStatus.INFO,
										"THE RANK OF THE ENVIRO-MREIT-R-G ROLE IS DISPLAYED CORRECTLY.");
								Reporter.log("THE RANK OF THE ENVIRO-MREIT-R-G ROLE IS DISPLAYED CORRECTLY.");
								log.info("THE RANK OF THE ENVIRO-MREIT-R-G ROLE IS DISPLAYED CORRECTLY.");

							} else {
								verificationFailed();
							}

							// VERIFY PERMISSION OF THE ADMINISTRATION TO THE ENVIRO-MREIT-R-G ROLE
							helper.rolePermissionValidation("Enviro-MREIT-R-G", "ADMINISTRATION", "2", "red", "close");

							// VERIFY PERMISSION OF THE PROPERTY EDIT TO THE ENVIRO-MREIT-R-G ROLE
							helper.rolePermissionValidation("Enviro-MREIT-R-G", "PROPERTY EDIT", "3", "red", "close");

							// VERIFY PERMISSION OF THE SEES ALL PROPERTIES TO THE ENVIRO-MREIT-R-G ROLE
							helper.rolePermissionValidation("Enviro-MREIT-R-G", "SEES ALL PROPERTIES", "4", "green",
									"checkmark");

							// VERIFY PERMISSION OF THE SEES ALL TASKS TO THE ENVIRO-MREIT-R-G ROLE
							helper.rolePermissionValidation("Enviro-MREIT-R-G", "SEES ALL TASKS", "5", "red", "close");

							// VERIFY PERMISSION OF THE WEEKLY TASK EMAILS TO THE ENVIRO-MREIT-R-G ROLE
							helper.rolePermissionValidation("Enviro-MREIT-R-G", "WEEKLY TASK EMAILS", "6", "red",
									"close");

							// VERIFY PERMISSION OF THE DEFAULT ROLE TO THE ENVIRO-MREIT-R-G ROLE
							helper.rolePermissionValidation("Enviro-MREIT-R-G", "DEFAULT ROLE", "7", "red", "close");

							break outerloop;
						}
					}

					// click on the next button
					click("task_permission_roles_nextbtn_CSS");
					ngDriver.waitForAngularRequestsToFinish();
					System.out.println("Clicked on the next button.");

				}
			} catch (Throwable t) {
				verificationFailed();
			}

			// VERIFY RANK OF THE ENVIRO-MRI-R-G ROLE

			System.out.println("VERIFY RANK OF THE ENVIRO-MRI-R-G ROLE.");
			test.log(LogStatus.INFO, "VERIFY RANK OF THE ENVIRO-MRI-R-G ROLE.");
			Reporter.log("VERIFY RANK OF THE ENVIRO-MRI-R-G ROLE.");
			log.info("VERIFY RANK OF THE ENVIRO-MRI-R-G ROLE.");

			// scroll up the screen
			js.executeScript("window.scrollBy(0,-200)");

			// click on the administration option
			click("administration_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the administration option.");

			// click on the security tab
			click("questionnaire_securitytab_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the security tab.");

			// click on the role tab
			click("questionnaire_rolesoption_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the roles tab.");

			// scroll down the screen
			js.executeScript("window.scrollBy(0,200)");

			try {
				String pages = driver.findElement(By.cssSelector("strong")).getText();
				String[] arrOfStr = pages.split(" ");
				String pageno = arrOfStr[3];
				int pagecount = Integer.parseInt(pageno);

				outerloop: for (int i = 0; i < pagecount; i++) {

					List<WebElement> roles = driver.findElements(By.xpath("//tr//div"));
					int rolesnum = roles.size();

					for (int j = 0; j < rolesnum; j++) {

						WebElement rolestext = roles.get(j);
						String getrole = rolestext.getText();

						if (getrole.equalsIgnoreCase("Enviro-MRI-R-G")) {

							// verify rank of the Enviro-MRI-R-G role is displayed correct or not
							String enviro_mri = (driver
									.findElement(
											By.xpath(OR.getProperty("task_permission_role_enviromrirg_rank_XPATH")))
									.getText()).trim();

							if (enviro_mri.equals("100")) {
								System.out.println("THE RANK OF THE ENVIRO-MRI-R-G ROLE IS DISPLAYED CORRECTLY.");
								test.log(LogStatus.INFO, "THE RANK OF THE ENVIRO-MRI-R-G ROLE IS DISPLAYED CORRECTLY.");
								Reporter.log("THE RANK OF THE ENVIRO-MRI-R-G ROLE IS DISPLAYED CORRECTLY.");
								log.info("THE RANK OF THE ENVIRO-MRI-R-G ROLE IS DISPLAYED CORRECTLY.");

							} else {
								verificationFailed();
							}

							// VERIFY PERMISSION OF THE ADMINISTRATION TO THE ENVIRO-MRI-R-G ROLE
							helper.rolePermissionValidation("Enviro-MRI-R-G", "ADMINISTRATION", "2", "red", "close");

							// VERIFY PERMISSION OF THE PROPERTY EDIT TO THE ENVIRO-MRI-R-G ROLE
							helper.rolePermissionValidation("Enviro-MRI-R-G", "PROPERTY EDIT", "3", "red", "close");

							// VERIFY PERMISSION OF THE SEES ALL PROPERTIES TO THE ENVIRO-MRI-R-G ROLE
							helper.rolePermissionValidation("Enviro-MRI-R-G", "SEES ALL PROPERTIES", "4", "green",
									"checkmark");

							// VERIFY PERMISSION OF THE SEES ALL TASKS TO THE ENVIRO-MRI-R-G ROLE
							helper.rolePermissionValidation("Enviro-MRI-R-G", "SEES ALL TASKS", "5", "red", "close");

							// VERIFY PERMISSION OF THE WEEKLY TASK EMAILS TO THE ENVIRO-MRI-R-G ROLE
							helper.rolePermissionValidation("Enviro-MRI-R-G", "WEEKLY TASK EMAILS", "6", "red",
									"close");

							// VERIFY PERMISSION OF THE DEFAULT ROLE TO THE ENVIRO-MRI-R-G ROLE
							helper.rolePermissionValidation("Enviro-MRI-R-G", "DEFAULT ROLE", "7", "red", "close");

							break outerloop;
						}
					}

					// click on the next button
					click("task_permission_roles_nextbtn_CSS");
					ngDriver.waitForAngularRequestsToFinish();
					System.out.println("Clicked on the next button.");

				}
			} catch (Throwable t) {
				verificationFailed();
			}

		} catch (Throwable t) {
			verificationFailed();
		}

		// click on the home icon from the top of the screen
		click("questionnaire_homeburgermenubtn_CSS");
		System.out.println("Clicked on the home icon from the top of the screen.");
		ngDriver.waitForAngularRequestsToFinish();

		// wait for the element
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// VERIFY DEFULT DASHBOARD FOR ROLES SHOULD BE EXECUTIVE

		System.out.println(
				"******************** VERIFY DEFULT DASHBOARD FOR ROLES SHOULD BE EXECUTIVE ********************");
		test.log(LogStatus.INFO,
				"******************** VERIFY DEFULT DASHBOARD FOR ROLES SHOULD BE EXECUTIVE ********************");
		Reporter.log("******************** VERIFY DEFULT DASHBOARD FOR ROLES SHOULD BE EXECUTIVE ********************");
		log.info("******************** VERIFY DEFULT DASHBOARD FOR ROLES SHOULD BE EXECUTIVE ********************");

		// VERIFY DEFAULT DASHBOARD OF THE ENVIRO-ADMIN ROLE

		System.out.println("VERIFY DEFAULT DASHBOARD OF THE ENVIRO-ADMIN ROLE.");
		test.log(LogStatus.INFO, "VERIFY DEFAULT DASHBOARD OF THE ENVIRO-ADMIN ROLE.");
		Reporter.log("VERIFY DEFAULT DASHBOARD OF THE ENVIRO-ADMIN ROLE.");
		log.info("VERIFY DEFAULT DASHBOARD OF THE ENVIRO-ADMIN ROLE.");

		try {

			try {

				// wait for 3 seconds
				Thread.sleep(5000);

				// click on the settings icon from the top of the screen
				click("questionnaire_settingicon_CSS");
				System.out.println("Clicked on the settings icon.");
				ngDriver.waitForAngularRequestsToFinish();

				// wait for 3 seconds
				Thread.sleep(3000);

				// click on the Administration option from the side menu
				click("questionnaire_administrationoption_XPATH");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the Administration option from the side menu.");

				// click on the security tab
				click("questionnaire_securitytab_XPATH");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the security tab.");

				// click on the role tab
				click("questionnaire_rolesoption_XPATH");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the roles tab.");

				helper.defaultExecutiveOptionValidation("Enviro-Admins", "task_permission_role_enviroadmin_rank_XPATH");

				// scroll up the screen
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("window.scrollTo(0,0)");

				// click on the administration option
				click("administration_XPATH");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the administration option.");

			} catch (Throwable t) {

				verificationFailed();

				// scroll up the screen
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("window.scrollTo(0,0)");

				// click on the administration option
				click("administration_XPATH");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the administration option.");

			}

			// VERIFY DEFAULT DASHBOARD OF THE ENVIRO-MANAGER ROLE

			System.out.println("VERIFY DEFAULT DASHBOARD OF THE ENVIRO-MANAGER ROLE.");
			test.log(LogStatus.INFO, "VERIFY DEFAULT DASHBOARD OF THE ENVIRO-MANAGER ROLE.");
			Reporter.log("VERIFY DEFAULT DASHBOARD OF THE ENVIRO-MANAGER ROLE.");
			log.info("VERIFY DEFAULT DASHBOARD OF THE ENVIRO-MANAGER ROLE.");

			try {

				// click on the security tab
				click("questionnaire_securitytab_XPATH");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the security tab.");

				// click on the role tab
				click("questionnaire_rolesoption_XPATH");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the roles tab.");

				helper.defaultExecutiveOptionValidation("Enviro-Managers",
						"task_permission_role_enviromanager_rank_XPATH");

				// scroll up the screen
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("window.scrollTo(0,0)");

				// click on the administration option
				click("administration_XPATH");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the administration option.");

			} catch (Throwable t) {
				verificationFailed();

				// scroll up the screen
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("window.scrollTo(0,0)");

				// click on the administration option
				click("administration_XPATH");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the administration option.");

			}

			// VERIFY DEFAULT DASHBOARD OF THE ENVIRO-CONSULTANTS ROLE

			System.out.println("VERIFY DEFAULT DASHBOARD OF THE ENVIRO-CONSULTANTS ROLE.");
			test.log(LogStatus.INFO, "VERIFY DEFAULT DASHBOARD OF THE ENVIRO-CONSULTANTS ROLE.");
			Reporter.log("VERIFY DEFAULT DASHBOARD OF THE ENVIRO-CONSULTANTS ROLE.");
			log.info("VERIFY DEFAULT DASHBOARD OF THE ENVIRO-CONSULTANTS ROLE.");

			try {

				// click on the security tab
				click("questionnaire_securitytab_XPATH");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the security tab.");

				// click on the role tab
				click("questionnaire_rolesoption_XPATH");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the roles tab.");

				helper.defaultExecutiveOptionValidation("Enviro-Consultants",
						"task_permission_role_enviroconsultants_rank_XPATH");

				// scroll up the screen
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("window.scrollTo(0,0)");

				// click on the administration option
				click("administration_XPATH");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the administration option.");

			} catch (Throwable t) {

				verificationFailed();

				// scroll up the screen
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("window.scrollTo(0,0)");

				// click on the administration option
				click("administration_XPATH");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the administration option.");

			}

			// VERIFY DEFAULT DASHBOARD OF THE ENVIRO-USERS ROLE

			System.out.println("VERIFY DEFAULT DASHBOARD OF THE ENVIRO-USERS ROLE.");
			test.log(LogStatus.INFO, "VERIFY DEFAULT DASHBOARD OF THE ENVIRO-USERS ROLE.");
			Reporter.log("VERIFY DEFAULT DASHBOARD OF THE ENVIRO-USERS ROLE.");
			log.info("VERIFY DEFAULT DASHBOARD OF THE ENVIRO-USERS ROLE.");

			try {

				// click on the security tab
				click("questionnaire_securitytab_XPATH");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the security tab.");

				// click on the role tab
				click("questionnaire_rolesoption_XPATH");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the roles tab.");

				helper.defaultExecutiveOptionValidation("Enviro-Users", "task_permission_role_envirousers_rank_XPATH");

				// scroll up the screen
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("window.scrollTo(0,0)");

				// click on the administration option
				click("administration_XPATH");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the administration option.");

			} catch (Throwable t) {

				verificationFailed();

				// scroll up the screen
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("window.scrollTo(0,0)");

				// click on the administration option
				click("administration_XPATH");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the administration option.");

			}

			// VERIFY DEFAULT DASHBOARD OF THE ENVIRO-MIL-R-G ROLE

			System.out.println("VERIFY DEFAULT DASHBOARD OF THE ENVIRO-MIL-R-G ROLE.");
			test.log(LogStatus.INFO, "VERIFY DEFAULT DASHBOARD OF THE ENVIRO-MIL-R-G ROLE.");
			Reporter.log("VERIFY DEFAULT DASHBOARD OF THE ENVIRO-MIL-R-G ROLE.");
			log.info("VERIFY DEFAULT DASHBOARD OF THE ENVIRO-MIL-R-G ROLE.");

			try {

				// click on the security tab
				click("questionnaire_securitytab_XPATH");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the security tab.");

				// click on the role tab
				click("questionnaire_rolesoption_XPATH");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the roles tab.");

				helper.defaultExecutiveOptionValidation("Enviro-MIL-R-G",
						"task_permission_role_enviromilrg_rank_XPATH");

				// scroll up the screen
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("window.scrollTo(0,0)");

				// click on the administration option
				click("administration_XPATH");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the administration option.");

			} catch (Throwable t) {
				verificationFailed();

				// scroll up the screen
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("window.scrollTo(0,0)");

				// click on the administration option
				click("administration_XPATH");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the administration option.");

			}

			// VERIFY DEFAULT DASHBOARD OF THE ENVIRO-MRC-R-G ROLE

			System.out.println("VERIFY DEFAULT DASHBOARD OF THE ENVIRO-MRC-R-G ROLE.");
			test.log(LogStatus.INFO, "VERIFY DEFAULT DASHBOARD OF THE ENVIRO-MRC-R-G ROLE.");
			Reporter.log("VERIFY DEFAULT DASHBOARD OF THE ENVIRO-MRC-R-G ROLE.");
			log.info("VERIFY DEFAULT DASHBOARD OF THE ENVIRO-MRC-R-G ROLE.");

			try {

				// click on the security tab
				click("questionnaire_securitytab_XPATH");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the security tab.");

				// click on the role tab
				click("questionnaire_rolesoption_XPATH");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the roles tab.");

				helper.defaultExecutiveOptionValidation("Enviro-MRC-R-G",
						"task_permission_role_enviromrcrg_rank_XPATH");

				// scroll up the screen
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("window.scrollTo(0,0)");

				// click on the administration option
				click("administration_XPATH");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the administration option.");

			} catch (Throwable t) {
				verificationFailed();

				// scroll up the screen
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("window.scrollTo(0,0)");

				// click on the administration option
				click("administration_XPATH");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the administration option.");

			}

			// VERIFY DEFAULT DASHBOARD OF THE ENVIRO-MRC-R-G ROLE

			System.out.println("VERIFY DEFAULT DASHBOARD OF THE ENVIRO-MRC-R-G ROLE.");
			test.log(LogStatus.INFO, "VERIFY DEFAULT DASHBOARD OF THE ENVIRO-MRC-R-G ROLE.");
			Reporter.log("VERIFY DEFAULT DASHBOARD OF THE ENVIRO-MRC-R-G ROLE.");
			log.info("VERIFY DEFAULT DASHBOARD OF THE ENVIRO-MRC-R-G ROLE.");

			try {

				// click on the security tab
				click("questionnaire_securitytab_XPATH");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the security tab.");

				// click on the role tab
				click("questionnaire_rolesoption_XPATH");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the roles tab.");

				helper.defaultExecutiveOptionValidation("Enviro-MRC-R-G",
						"task_permission_role_enviromrcrg_rank_XPATH");

				// scroll up the screen
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("window.scrollTo(0,0)");

				// click on the administration option
				click("administration_XPATH");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the administration option.");

			} catch (Throwable t) {
				verificationFailed();

				// scroll up the screen
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("window.scrollTo(0,0)");

				// click on the administration option
				click("administration_XPATH");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the administration option.");

			}

			// VERIFY DEFAULT DASHBOARD OF THE ENVIRO-MREIT-R-G ROLE

			System.out.println("VERIFY DEFAULT DASHBOARD OF THE ENVIRO-MREIT-R-G ROLE.");
			test.log(LogStatus.INFO, "VERIFY DEFAULT DASHBOARD OF THE ENVIRO-MREIT-R-G ROLE.");
			Reporter.log("VERIFY DEFAULT DASHBOARD OF THE ENVIRO-MREIT-R-G ROLE.");
			log.info("VERIFY DEFAULT DASHBOARD OF THE ENVIRO-MREIT-R-G ROLE.");

			try {

				// click on the security tab
				click("questionnaire_securitytab_XPATH");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the security tab.");

				// click on the role tab
				click("questionnaire_rolesoption_XPATH");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the roles tab.");

				helper.defaultExecutiveOptionValidation("Enviro-MREIT-R-G",
						"task_permission_role_enviromreitrg_rank_XPATH");

				// scroll up the screen
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("window.scrollTo(0,0)");

				// click on the administration option
				click("administration_XPATH");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the administration option.");

			} catch (Throwable t) {
				verificationFailed();

				// scroll up the screen
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("window.scrollTo(0,0)");

				// click on the administration option
				click("administration_XPATH");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the administration option.");

			}

			// VERIFY DEFAULT DASHBOARD OF THE ENVIRO-MRI-R-G ROLE

			System.out.println("VERIFY DEFAULT DASHBOARD OF THE ENVIRO-MRI-R-G ROLE.");
			test.log(LogStatus.INFO, "VERIFY DEFAULT DASHBOARD OF THE ENVIRO-MRI-R-G ROLE.");
			Reporter.log("VERIFY DEFAULT DASHBOARD OF THE ENVIRO-MRI-R-G ROLE.");
			log.info("VERIFY DEFAULT DASHBOARD OF THE ENVIRO-MRI-R-G ROLE.");

			try {

				// click on the security tab
				click("questionnaire_securitytab_XPATH");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the security tab.");

				// click on the role tab
				click("questionnaire_rolesoption_XPATH");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the roles tab.");

				helper.defaultExecutiveOptionValidation("Enviro-MRI-R-G",
						"task_permission_role_enviromrirg_rank_XPATH");

				// scroll up the screen
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("window.scrollTo(0,0)");

				// click on the administration option
				click("administration_XPATH");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the administration option.");

			} catch (Throwable t) {
				verificationFailed();

				// scroll up the screen
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("window.scrollTo(0,0)");

				// click on the administration option
				click("administration_XPATH");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the administration option.");

			}
		} catch (Throwable t) {
			verificationFailed();
		}

		// click on the home icon from the top of the screen
		click("questionnaire_homeburgermenubtn_CSS");
		System.out.println("Clicked on the home icon from the top of the screen.");
		ngDriver.waitForAngularRequestsToFinish();

		// wait for the element
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// ADMINISTRATION ASSIGN SELECTED PROPERTIES FOR CONSULTANT TO VIEW/EDIT

		System.out.println(
				"******************** ADMINISTRATION ASSIGN SELECTED PROPERTIES FOR CONSULTANT TO VIEW/EDIT ********************");
		test.log(LogStatus.INFO,
				"******************** ADMINISTRATION ASSIGN SELECTED PROPERTIES FOR CONSULTANT TO VIEW/EDIT ********************");
		Reporter.log(
				"******************** ADMINISTRATION ASSIGN SELECTED PROPERTIES FOR CONSULTANT TO VIEW/EDIT ********************");
		log.info(
				"******************** ADMINISTRATION ASSIGN SELECTED PROPERTIES FOR CONSULTANT TO VIEW/EDIT ********************");

		String groupName = RandomStringUtils.randomAlphabetic(8);

		try {

			// wait for 3 seconds
			Thread.sleep(5000);

			// click on the settings icon from the top of the screen
			click("questionnaire_settingicon_CSS");
			System.out.println("Clicked on the settings icon.");
			ngDriver.waitForAngularRequestsToFinish();

			// wait for 3 seconds
			Thread.sleep(3000);

			// click on the Administration option from the side menu
			click("questionnaire_administrationoption_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the Administration option from the side menu.");

			// click on the security tab
			click("questionnaire_securitytab_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the security tab.");

			// click on the property groups tab
			click("questionnaire_propertygroupoption_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the property groups tab.");

			// ADD NEW PROPERTY GROUP

			System.out.println("********** ADD NEW PROPERTY GROUP **********");
			test.log(LogStatus.INFO, "********** ADD NEW PROPERTY GROUP **********");
			Reporter.log("********** ADD NEW PROPERTY GROUP **********");
			log.info("********** ADD NEW PROPERTY GROUP **********");

			// scroll down the screen
			JavascriptExecutor js = (JavascriptExecutor) driver;
			WebElement addBtn = driver
					.findElement(By.cssSelector(OR.getProperty("administration_security_groupproperty_addbtn_CSS")));
			js.executeScript("arguments[0].scrollIntoView(true);", addBtn);

			// click on the add button
			click("administration_security_groupproperty_addbtn_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the add button.");

			// enter the group name
			type("administration_security_groupproperty_groupnametxt_XPATH", groupName);
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the group name.");

			// click on the add of the add property group
			click("administration_security_groupproperty_groupname_addbtn_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the add of the add property group.");

			// scroll up the screen
			js.executeScript("window.scrollBy(0,0)");

			try {

				// verify newly created group is displayed or not
				String addedGroup = driver.findElement(
						By.cssSelector(OR.getProperty("administration_security_groupproperty_addedgroupname_CSS")))
						.getText();

				System.out.println("Added Group:::::::::::::" + addedGroup);

				if (addedGroup.equals("0 Properties in '" + groupName + "'")) {

					System.out.println("THE NEWLY CREATED GROUP IS DISPLAYED SUCCESSFULLY.");
					test.log(LogStatus.INFO, "THE NEWLY CREATED GROUP IS DISPLAYED SUCCESSFULLY.");
					Reporter.log("THE NEWLY CREATED GROUP IS DISPLAYED SUCCESSFULLY.");
					log.info("THE NEWLY CREATED GROUP IS DISPLAYED SUCCESSFULLY.");
				} else {
					verificationFailedMessage("THE NEWLY CREATED GROUP IS NOT DISPLAYED");
				}
			} catch (Throwable t) {

				verificationFailedMessage("THE NEWLY CREATED GROUP IS NOT DISPLAYED");

			}

			// ADD PROPERTY IN THE NEWLY CREATED PROPERTY GROUP

			System.out.println("********** ADD PROPERTY IN THE NEWLY CREATED PROPERTY GROUP **********");
			test.log(LogStatus.INFO, "********** ADD PROPERTY IN THE NEWLY CREATED PROPERTY GROUP **********");
			Reporter.log("********** ADD PROPERTY IN THE NEWLY CREATED PROPERTY GROUP **********");
			log.info("********** ADD PROPERTY IN THE NEWLY CREATED PROPERTY GROUP **********");

			// click on the edit button
			click("administration_security_groupproperty_editbtn_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the edit button.");

			// enter property name in the search field
			type("administration_security_groupproperty_searchfield_CSS", data.get("property_1"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered property name in the search field.");

			// click on the checkbox of the property
			click("administration_security_groupproperty_searchedpropertyckbx_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the checkbox of the property.");

			// click on the update button
			click("administration_security_groupproperty_addproperty_updatebtn_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the update button.");

			try {

				// verify the added property is displayed or not
				String propertyName = (driver
						.findElement(
								By.xpath(OR.getProperty("administration_security_groupproperty_addedproperty_XPATH")))
						.getText()).trim();

				if (propertyName.equals("CAPREIT - White Frost")) {

					System.out.println("THE ADDED PROPERTY IS DISPLAYED SUCCESSFULLY.");
					test.log(LogStatus.INFO, "THE ADDED PROPERTY IS DISPLAYED SUCCESSFULLY.");
					Reporter.log("THE ADDED PROPERTY IS DISPLAYED SUCCESSFULLY.");
					log.info("THE ADDED PROPERTY IS DISPLAYED SUCCESSFULLY.");

				} else {
					verificationFailedMessage("THE ADDED PROPERTY IS NOT DISPLAYED");
				}

			} catch (Throwable t) {

				verificationFailedMessage("THE ADDED PROPERTY IS NOT DISPLAYED");

			}

			// VERIFY RESEPCTIVE PROPERTY DISPLAYED IN THE CONSULTANT USER ACCOUNT

			System.out.println(
					"********** VERIFY RESEPCTIVE PROPERTY DISPLAYED IN THE CONSULTANT USER ACCOUNT **********");
			test.log(LogStatus.INFO,
					"********** VERIFY RESEPCTIVE PROPERTY DISPLAYED IN THE CONSULTANT USER ACCOUNT **********");
			Reporter.log("********** VERIFY RESEPCTIVE PROPERTY DISPLAYED IN THE CONSULTANT USER ACCOUNT **********");
			log.info("********** VERIFY RESEPCTIVE PROPERTY DISPLAYED IN THE CONSULTANT USER ACCOUNT **********");

			// scroll up to top
			js.executeScript("window.scrollTo(0,0)");

			// click on the administration option
			click("administration_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the administration option.");

			// click on the security tab
			click("questionnaire_securitytab_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the security tab.");

			// click on the users tab
			click("questionnaire_usersoption_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the users groups tab.");

			// enter the user name in the search field
			clear("users_filtertxt_CSS");
			type("users_filtertxt_CSS", data.get("consultant_user"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the user name in the search field.");

			// click on the assign property icon of the searched user
			click("administration_security_searcheduser_assignproperty_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the assign property icon of the searched user.");

			// click on the property group radio button
			click("administration_security_searcheduser_propertygroupradio_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the property group radio button.");

			// enter group name in the search field
			clear("administration_security_searcheduser_searchgrouptxt1_XPATH");
			type("administration_security_searcheduser_searchgrouptxt1_XPATH", groupName);
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered group name in the search field.");

			// click on the assign icon of the searched group
			String assignIcon = "//div[text()='" + groupName
					+ "']//parent::td//following-sibling::td[@ng-click='assignPropertyGroup(group);']";
			driver.findElement(By.xpath(assignIcon)).click();
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the assign icon of the searched group.");

			// enter group name in the search field
			clear("administration_security_searcheduser_searchgrouptxt2_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Cleared the search field.");
			type("administration_security_searcheduser_searchgrouptxt2_XPATH", groupName);
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered group name in the search field.");

			try {
				// validate group assigned successfully to respective user
				String assignedGroup = "//td[@ng-click='unassignPropertyGroup(assignedGroup);']//preceding-sibling::td[text()='"
						+ groupName + "']";

				String assignedGroupText = driver.findElement(By.xpath(assignedGroup)).getText();

				if (assignedGroupText.equals(groupName)) {
					System.out.println("THE GROUP ASSIGNED TO THE RESPECTIVE USER SUCCESSFULLY.");
					test.log(LogStatus.INFO, "THE GROUP ASSIGNED TO THE RESPECTIVE USER SUCCESSFULLY.");
					Reporter.log("THE GROUP ASSIGNED TO THE RESPECTIVE USER SUCCESSFULLY.");
					log.info("THE GROUP ASSIGNED TO THE RESPECTIVE USER SUCCESSFULLY.");
				} else {

					verificationFailedMessage("THE GROUP NOT ASSIGNED TO THE RESPECTIVE USER");

				}

			} catch (Throwable t) {
				verificationFailedMessage("THE GROUP NOT ASSIGNED TO THE RESPECTIVE USER");
			}

			// click on the administration option
			click("administration_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the administration option.");

			// click on the security tab
			click("questionnaire_securitytab_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the security tab.");

			// click on the users tab
			click("questionnaire_usersoption_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the users groups tab.");

			// enter the user name in the search field
			clear("users_filtertxt_CSS");
			type("users_filtertxt_CSS", data.get("consultant_user"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the user name in the search field.");

			// click on the switch to icon of the searched user
			click("administration_security_searcheduser_switchto_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the switch to icon of the searched user.");

			// wait for the element
			Thread.sleep(5000);

			// click on the switch button
			click("administration_security_searcheduser_switchbtn_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the switch button.");

			// LOGIN WITH CONSULTANT USER

			System.out.println("********** LOGIN WITH CONSULTANT USER **********");
			test.log(LogStatus.INFO, "********** LOGIN WITH CONSULTANT USER **********");
			Reporter.log("********** LOGIN WITH CONSULTANT USER **********");
			log.info("********** LOGIN WITH CONSULTANT USER **********");

			try {
				// wait for the element
				explicitWait("propertylist_title_XPATH");

				// verify the property list
				switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

				// enter the property name in the search field
				type("envreports_propertylist_filtertxt_CSS", data.get("property_1"));
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Entered the property name in the search field.");

				// verify searched property displayed or not
				switchVerification("morguard_searchedproperty1_XPATH", "CAPREIT - White Frost",
						"The CAPREIT - White Frost property is not displayed.");

				// wait for the element
				explicitWaitClickable("questionnaire_settingicon_CSS");

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

				// LOGIN WITH ADMIN USER

				System.out.println("********** LOGIN WITH ADMIN USER **********");
				test.log(LogStatus.INFO, "********** LOGIN WITH ADMIN USER **********");
				Reporter.log("********** LOGIN WITH ADMIN USER **********");
				log.info("********** LOGIN WITH ADMIN USER **********");

				// wait for the element
				explicitWaitClickable("signinbtn_BTNTEXT");

				// Enter the username
				type("usernametxt_CSS", data.get("username_1"));
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Entered the username.");

				// Enter the password
				type("passwordtxt_CSS", data.get("password_1"));
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

			} catch (Throwable t) {
				System.out.println("AN EXEPTIONS ARE OCCURED IN THIS USER, SO LOGOUT FROM THIS USER.");
				test.log(LogStatus.INFO, "AN EXEPTIONS ARE OCCURED IN THIS USER, SO LOGOUT FROM THIS USER.");
				Reporter.log("AN EXEPTIONS ARE OCCURED IN THIS USER, SO LOGOUT FROM THIS USER.");
				log.info("AN EXEPTIONS ARE OCCURED IN THIS USER, SO LOGOUT FROM THIS USER.");

				verificationFailed();

				driver.navigate().refresh();
				Thread.sleep(3000);
				driver.navigate().refresh();

				// wait for the element
				explicitWaitClickable("questionnaire_settingicon_userupdate_CSS");

				// click on the settings icon from the top of the screen
				click("questionnaire_settingicon_userupdate_CSS");
				System.out.println("Clicked on the settings icon.");
				ngDriver.waitForAngularRequestsToFinish();

				// wait for the element
				explicitWaitClickable("sidemenu_logout_CSS");

				// click on the logout option from the side menu
				click("sidemenu_logout_CSS");
				System.out.println("Clicked on the logout option from the side menu.");
				ngDriver.waitForAngularRequestsToFinish();

				// LOGIN WITH ADMIN USER

				System.out.println("********** LOGIN WITH ADMIN USER **********");
				test.log(LogStatus.INFO, "********** LOGIN WITH ADMIN USER **********");
				Reporter.log("********** LOGIN WITH ADMIN USER **********");
				log.info("********** LOGIN WITH ADMIN USER **********");

				// wait for the element
				explicitWaitClickable("signinbtn_BTNTEXT");

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
			}

			// EDIT THE PROPERTY GROUP

			System.out.println("********** EDIT THE PROPERTY GROUP **********");
			test.log(LogStatus.INFO, "********** EDIT THE PROPERTY GROUP **********");
			Reporter.log("********** EDIT THE PROPERTY GROUP **********");
			log.info("********** EDIT THE PROPERTY GROUP **********");

			// wait for 3 seconds
			Thread.sleep(5000);

			// click on the settings icon from the top of the screen
			click("questionnaire_settingicon_CSS");
			System.out.println("Clicked on the settings icon.");
			ngDriver.waitForAngularRequestsToFinish();

			// wait for 3 seconds
			Thread.sleep(3000);

			// click on the Administration option from the side menu
			click("questionnaire_administrationoption_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the Administration option from the side menu.");

			// click on the security tab
			click("questionnaire_securitytab_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the security tab.");

			// click on the property groups tab
			click("questionnaire_propertygroupoption_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the property groups tab.");

			// enter the group name in the search field
			type("administration_security_createdgroup_searchtxt_CSS", groupName);
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the group name in the search field.");

			// click on the searched group
			String group = "//td[text()='" + groupName + "']";
			driver.findElement(By.xpath(group)).click();
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the searched group.");

			// wait for the element
			Thread.sleep(3000);

			try {

				// verify newly created group is displayed or not
				String addedGroup = driver.findElement(
						By.cssSelector(OR.getProperty("administration_security_groupproperty_addedgroupname_CSS")))
						.getText();

				System.out.println("Added Group:::::::::::::" + addedGroup);

				if (addedGroup.equals("1 Properties in '" + groupName + "'")) {

					System.out.println("THE NEWLY CREATED GROUP IS DISPLAYED SUCCESSFULLY.");
					test.log(LogStatus.INFO, "THE NEWLY CREATED GROUP IS DISPLAYED SUCCESSFULLY.");
					Reporter.log("THE NEWLY CREATED GROUP IS DISPLAYED SUCCESSFULLY.");
					log.info("THE NEWLY CREATED GROUP IS DISPLAYED SUCCESSFULLY.");
				} else {
					verificationFailedMessage("THE NEWLY CREATED GROUP IS NOT DISPLAYED");
				}
			} catch (Throwable t) {

				verificationFailedMessage("THE NEWLY CREATED GROUP IS NOT DISPLAYED");

			}

			// UPDATE THE PROPERTY IN THE NEWLY CREATED PROPERTY GROUP

			System.out.println("********** UPDATE THE PROPERTY IN THE NEWLY CREATED PROPERTY GROUP **********");
			test.log(LogStatus.INFO, "********** UPDATE THE PROPERTY IN THE NEWLY CREATED PROPERTY GROUP **********");
			Reporter.log("********** UPDATE THE PROPERTY IN THE NEWLY CREATED PROPERTY GROUP **********");
			log.info("********** UPDATE THE PROPERTY IN THE NEWLY CREATED PROPERTY GROUP **********");

			// click on the edit button
			click("administration_security_groupproperty_editbtn_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the edit button.");

			// enter property name in the search field
			clear("administration_security_groupproperty_searchfield_CSS");
			type("administration_security_groupproperty_searchfield_CSS", data.get("property_1"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered property name in the search field.");

			// click on the checkbox of the property
			click("administration_security_groupproperty_searchedpropertyckbx_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the checkbox of the property.");

			// enter property name in the search field
			clear("administration_security_groupproperty_searchfield_CSS");
			type("administration_security_groupproperty_searchfield_CSS", data.get("property_2"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered property name in the search field.");

			// click on the checkbox of the property
			click("administration_security_groupproperty_searchedpropertyckbx2_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the checkbox of the property.");

			// enter property name in the search field
			clear("administration_security_groupproperty_searchfield_CSS");
			type("administration_security_groupproperty_searchfield_CSS", data.get("property_3"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered property name in the search field.");

			// click on the checkbox of the property
			click("administration_security_groupproperty_searchedpropertyckbx3_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the checkbox of the property.");

			// click on the update button
			click("administration_security_groupproperty_addproperty_updatebtn_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the update button.");

			// verify the added property is displayed or not
			switchVerification("administration_security_groupproperty_addedproperty2_XPATH",
					"Capreit - *Off-Site Incident Report", "The Capreit - *Off-Site Incident Report is not displayed.");

			switchVerification("administration_security_groupproperty_addedproperty3_XPATH", "SmartCentres Brockville",
					"The SmartCentres Brockville is not displayed.");

			deleteVerification("administration_security_groupproperty_addedproperty_XPATH", "CAPREIT - White Frost");

			// VERIFY RESEPCTIVE UPDATED PROPERTY DISPLAYED IN THE CONSULTANT USER ACCOUNT

			System.out.println(
					"********** VERIFY RESEPCTIVE UPDATED PROPERTY DISPLAYED IN THE CONSULTANT USER ACCOUNT **********");
			test.log(LogStatus.INFO,
					"********** VERIFY RESEPCTIVE UPDATED PROPERTY DISPLAYED IN THE CONSULTANT USER ACCOUNT **********");
			Reporter.log(
					"********** VERIFY RESEPCTIVE UPDATED PROPERTY DISPLAYED IN THE CONSULTANT USER ACCOUNT **********");
			log.info(
					"********** VERIFY RESEPCTIVE UPDATED PROPERTY DISPLAYED IN THE CONSULTANT USER ACCOUNT **********");

			// scroll up to top
			js.executeScript("window.scrollBy(0,0)");

			// click on the administration option
			click("administration_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the administration option.");

			// click on the security tab
			click("questionnaire_securitytab_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the security tab.");

			// click on the users tab
			click("questionnaire_usersoption_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the users groups tab.");

			// enter the user name in the search field
			clear("users_filtertxt_CSS");
			type("users_filtertxt_CSS", data.get("consultant_user"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the user name in the search field.");

			// click on the switch to icon of the searched user
			click("administration_security_searcheduser_switchto_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the switch to icon of the searched user.");

			// click on the switch button
			click("administration_security_searcheduser_switchbtn_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the switch button.");

			// LOGIN WITH CONSULTANT USER

			System.out.println("********** LOGIN WITH CONSULTANT USER **********");
			test.log(LogStatus.INFO, "********** LOGIN WITH CONSULTANT USER **********");
			Reporter.log("********** LOGIN WITH CONSULTANT USER **********");
			log.info("********** LOGIN WITH CONSULTANT USER **********");

			try {
				// wait for the element
				explicitWait("propertylist_title_XPATH");

				// verify the property list
				switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

				// enter the property name in the search field
				clear("envreports_propertylist_filtertxt_CSS");
				type("envreports_propertylist_filtertxt_CSS", data.get("property_1"));
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Entered the property name in the search field.");

				// verify searched property displayed or not
				deleteVerification("morguard_searchedproperty1_XPATH", "CAPREIT - White Frost");

				// enter the property name in the search field
				clear("envreports_propertylist_filtertxt_CSS");
				type("envreports_propertylist_filtertxt_CSS", data.get("property_2"));
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Entered the property name in the search field.");

				switchVerification("morguard_searchedproperty2_XPATH", "Capreit - *Off-Site Incident Report",
						"The Capreit - *Off-Site Incident Report property is not displayed.");

				// enter the property name in the search field
				clear("envreports_propertylist_filtertxt_CSS");
				type("envreports_propertylist_filtertxt_CSS", data.get("property_3"));
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Entered the property name in the search field.");

				switchVerification("morguard_searchedproperty3_XPATH", "SmartCentres Brockville",
						"The SmartCentres Brockville property is not displayed.");

				// wait for the element
				explicitWaitClickable("questionnaire_settingicon_CSS");

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

				// LOGIN WITH ADMIN USER

				System.out.println("********** LOGIN WITH ADMIN USER **********");
				test.log(LogStatus.INFO, "********** LOGIN WITH ADMIN USER **********");
				Reporter.log("********** LOGIN WITH ADMIN USER **********");
				log.info("********** LOGIN WITH ADMIN USER **********");

				// wait for the element
				explicitWaitClickable("signinbtn_BTNTEXT");

				// Enter the username
				type("usernametxt_CSS", data.get("username_1"));
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Entered the username.");

				// Enter the password
				type("passwordtxt_CSS", data.get("password_1"));
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

			} catch (Throwable t) {
				System.out.println("AN EXEPTIONS ARE OCCURED IN THIS USER, SO LOGOUT FROM THIS USER.");
				test.log(LogStatus.INFO, "AN EXEPTIONS ARE OCCURED IN THIS USER, SO LOGOUT FROM THIS USER.");
				Reporter.log("AN EXEPTIONS ARE OCCURED IN THIS USER, SO LOGOUT FROM THIS USER.");
				log.info("AN EXEPTIONS ARE OCCURED IN THIS USER, SO LOGOUT FROM THIS USER.");

				verificationFailed();

				driver.navigate().refresh();
				Thread.sleep(3000);
				driver.navigate().refresh();

				// wait for the element
				explicitWaitClickable("questionnaire_settingicon_userupdate_CSS");

				// click on the settings icon from the top of the screen
				click("questionnaire_settingicon_userupdate_CSS");
				System.out.println("Clicked on the settings icon.");
				ngDriver.waitForAngularRequestsToFinish();

				// wait for the element
				explicitWaitClickable("sidemenu_logout_CSS");

				// click on the logout option from the side menu
				click("sidemenu_logout_CSS");
				System.out.println("Clicked on the logout option from the side menu.");
				ngDriver.waitForAngularRequestsToFinish();

				// LOGIN WITH ADMIN USER

				System.out.println("********** LOGIN WITH ADMIN USER **********");
				test.log(LogStatus.INFO, "********** LOGIN WITH ADMIN USER **********");
				Reporter.log("********** LOGIN WITH ADMIN USER **********");
				log.info("********** LOGIN WITH ADMIN USER **********");

				// wait for the element
				explicitWaitClickable("signinbtn_BTNTEXT");

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
			}

		} catch (Throwable t) {
			verificationFailed();
		}

		try {

			// DELETE THE NEWLY CREATED PROPERTY GROUP

			System.out.println("********** DELETE THE NEWLY CREATED PROPERTY GROUP **********");
			test.log(LogStatus.INFO, "********** DELETE THE NEWLY CREATED PROPERTY GROUP **********");
			Reporter.log("********** DELETE THE NEWLY CREATED PROPERTY GROUP **********");
			log.info("********** DELETE THE NEWLY CREATED PROPERTY GROUP **********");

			// wait for 3 seconds
			Thread.sleep(5000);

			// click on the settings icon from the top of the screen
			click("questionnaire_settingicon_CSS");
			System.out.println("Clicked on the settings icon.");
			ngDriver.waitForAngularRequestsToFinish();

			// wait for 3 seconds
			Thread.sleep(3000);

			// click on the Administration option from the side menu
			click("questionnaire_administrationoption_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the Administration option from the side menu.");

			// click on the security tab
			click("questionnaire_securitytab_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the security tab.");

			// click on the property groups tab
			click("questionnaire_propertygroupoption_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the property groups tab.");

			// enter the group name in the search field
			clear("administration_security_createdgroup_searchtxt_CSS");
			type("administration_security_createdgroup_searchtxt_CSS", groupName);
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the group name in the search field.");

			// click on the delete button of the property group
			String groupDeleteXPATH = "//td[text()='" + groupName
					+ "']//following-sibling::td[@data-target='#deleteGroupModal']";
			driver.findElement(By.xpath(groupDeleteXPATH)).click();
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the delete button of the property group.");

			// click on the delete button of the confirmation popup
			click("administration_security_groupproperty_confirmationdeletebtn_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the delete button of the confirmation popup.");

			// verify deleted property group is displayed or not

			deleteVerification(groupDeleteXPATH, groupName);

		} catch (Throwable t) {
			verificationFailed();
		}

		// click on the home icon from the top of the screen
		click("questionnaire_homeburgermenubtn_CSS");
		System.out.println("Clicked on the home icon from the top of the screen.");
		ngDriver.waitForAngularRequestsToFinish();

		// synchronization
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		try {
			// wait for the element
			Thread.sleep(7000);

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
