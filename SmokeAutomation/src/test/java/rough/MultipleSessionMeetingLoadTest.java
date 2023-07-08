package rough;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.paulhammant.ngwebdriver.NgWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MultipleSessionMeetingLoadTest {

	public static WebDriver driver;
	public static NgWebDriver ngDriver;
	public static JavascriptExecutor jsDriver;

	public void executSessionOne() {
		int count1 = 5;

		for (int i = 1; i <= count1; i++) {
			System.out.println("The thread ID for Chrome is " + Thread.currentThread().getId());
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			jsDriver = (JavascriptExecutor) driver;
			ngDriver = new NgWebDriver(jsDriver);
			String baseUrl = "https://rds.adobeconnect.com/_a205667947/r0ee546qvdrb/?proto=true&html-view=true";

			driver.get(baseUrl);
			driver.manage().window().maximize();
			String s = RandomStringUtils.randomAlphabetic(8);
			driver.findElement(By.cssSelector("input[id='guestName']")).sendKeys(s);
			driver.findElement(By.cssSelector("input[id='login-guest']")).click();

		}
	}

//	@Test
//	public void executSessionTwo() {
//		int count2 = 5;
//
//		for (int i = 1; i <= count2; i++) {
//			System.out.println("The thread ID for Firefox is " + Thread.currentThread().getId());
//			WebDriverManager.firefoxdriver().setup();
//			System.setProperty("webdriver.gecko.driver",
//					System.getProperty("user.dir") + "/src/test/resources/executables/geckodriver.exe");
//			jsDriver = (JavascriptExecutor) driver;
//			ngDriver = new NgWebDriver(jsDriver);
//			System.out.println("FireFox launched successfully!!!");
//			String baseUrl = "https://rds.adobeconnect.com/_a205667947/r0ee546qvdrb/?proto=true&html-view=true";
//
//			driver.get(baseUrl);
//			driver.manage().window().maximize();
//			String s = RandomStringUtils.randomAlphabetic(8);
//			driver.findElement(By.cssSelector("input[id='guestName']")).sendKeys(s);
//			driver.findElement(By.cssSelector("input[id='login-guest']")).click();
//
//		}
//	}

}
