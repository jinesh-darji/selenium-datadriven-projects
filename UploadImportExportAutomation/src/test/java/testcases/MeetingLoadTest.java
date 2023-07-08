package testcases;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Hashtable;
import java.util.List;
import java.util.Random;
import java.util.Set;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.SkipException;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.paulhammant.ngwebdriver.NgWebDriver;

import base.TestBase;
import io.github.bonigarcia.wdm.WebDriverManager;
import utilities.TestUtil;

public class MeetingLoadTest extends TestBase {

	public static WebDriver driver;
	public static NgWebDriver ngDriver;
	public static JavascriptExecutor jsDriver;

	@Test(dataProviderClass = TestUtil.class, dataProvider = "dp")
	public void meetingLoadTest(Hashtable<String, String> data) throws IOException, InterruptedException {

		if (!(TestUtil.isTestRunnable("meetingLoadTest", excel))) {

			throw new SkipException("Skipping the test " + "meetingLoadTest".toUpperCase() + "as the Run mode is NO");
		}

		if (!data.get("runmode").equals("Y")) {

			throw new SkipException("Skipping the test case as the Run Mode for data set is NO");
		}

		// Initialize the Config and OR Properties file

		if (driver == null) {

			try {
				fis = new FileInputStream(
						System.getProperty("user.dir") + "/src/test/resources/properties/Config.properties");
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				config.load(fis);
				log.info("Config file is loaded successfully!!!");
				System.out.println("Config file is loaded successfully!!!");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			try {
				fis = new FileInputStream(
						System.getProperty("user.dir") + "/src/test/resources/properties/OR.properties");
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				OR.load(fis);
				log.info("OR file is loaded successfully!!!");
				System.out.println("OR file is loaded successfully!!!");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		int count = 500;

		for (int i = 1; i <= count; i++) {

			try {

//				WebDriverManager.chromedriver().setup();
//				driver = new ChromeDriver();
//				jsDriver = (JavascriptExecutor) driver;
//				ngDriver = new NgWebDriver(jsDriver);

				WebDriverManager.chromedriver().setup();
				ChromeOptions options = new ChromeOptions();
				options.addArguments("headless");
				options.addArguments("window-size=1200x600");
				options.addArguments("--no-sandbox");
				options.addArguments("--disable-dev-shm-usage");
				options.addArguments("--headless");
				driver = new ChromeDriver(options);
				jsDriver = (JavascriptExecutor) driver;
				ngDriver = new NgWebDriver(jsDriver);
				System.out.println("Chrome launched successfully!!!");

				String baseUrl = "https://rds.adobeconnect.com/_a205667947/r0ee546qvdrb/?proto=true&html-view=true";
				driver.get(baseUrl);
				driver.manage().window().maximize();
				String s = RandomStringUtils.randomAlphabetic(8);
				driver.findElement(By.cssSelector("input[id='guestName']")).sendKeys(s);
				driver.findElement(By.cssSelector("input[id='login-guest']")).click();
				ngDriver.waitForAngularRequestsToFinish();

				System.out.println("User: " + i + " Logged in successfully with " + s + " Username.");

				// wait for 25 second
				Thread.sleep(25000);
				System.out.println("Completed the 20 seconds of the wait.");

				// refresh the page
				driver.navigate().refresh();
				System.out.println("Refreshed the page successfully.");

				// wait for 30 second
				Thread.sleep(30000);
				System.out.println("Completed the 20 seconds of the wait.");

				// navigates to the page consisting an iframe
				driver.switchTo().frame(0);
				System.out.println("Switched to the frame 1.");

				// navigates to the second iframe
				driver.switchTo().frame("syncConnector192");
				System.out.println("Switched to the frame 2.");

				// click on the random gesture
				List<WebElement> links = driver.findElements(By.cssSelector("hands-up-button"));
				int count1 = links.size();
				Random r = new Random();
				int linkNo = r.nextInt(count1);
				WebElement link = links.get(linkNo);
				link.click();
				System.out.println("Clicked on the gesture successfully:" + link);

				// wait for 5 second
				Thread.sleep(5000);
				System.out.println("Completed the 5 seconds of the wait.");

				// switch from iframe to main content
				driver.switchTo().defaultContent();
				System.out.println("Switched from iframe to main content.");
			} catch (Throwable t) {
				System.out.println("Due to the page is not load successfully, We are moving to next user.");
			}

		}

		driver.quit();

	}
}
