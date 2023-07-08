package rough;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestHostAdd {

	public static void main(String[] args) throws InterruptedException {

		// Setting chrome driver path
		System.setProperty("webdriver.chrome.driver", "./exefiles/chromedriver.exe");

		// Launching browser
		WebDriver driver = new ChromeDriver();

		// Maximize window
		driver.manage().window().maximize();

		// Load the URL
		driver.get("https://semantic-ui.com/modules/dropdown.html");

		// Locating drop down
		WebElement dropdown = driver.findElement(By.xpath("//div[text()='Select Friend']"));

		// Putting in a loop to select different values every time
		for (int i = 0; i < 3; i++) {

			// Click on drop down
			dropdown.click();

			// Waiting till options in drop down are visible
			WebDriverWait wait = new WebDriverWait(driver, 15);
			wait.until(ExpectedConditions
					.visibilityOf(driver.findElement(By.xpath("//div[@class='menu transition visible']"))));

			// Getting list of options
			List<WebElement> itemsInDropdown = driver
					.findElements(By.xpath("//div[@class='menu transition visible']//div[@class='item']"));

			// Getting size of options available
			int size = itemsInDropdown.size();

			// Generate a random number with in range
			int randnMumber = ThreadLocalRandom.current().nextInt(0, size);

			// Selecting random value
			itemsInDropdown.get(randnMumber).click();

			Thread.sleep(2000);

		}

	}
}
