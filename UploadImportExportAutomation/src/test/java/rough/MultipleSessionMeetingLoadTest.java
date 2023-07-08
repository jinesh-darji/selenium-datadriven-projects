package rough;

import java.time.LocalDate;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MultipleSessionMeetingLoadTest {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		LocalDate addDate3 = LocalDate.now();
		String addDate3_String = addDate3.toString();
		String[] arrayOfDate3 = addDate3_String.split("-");
		String year3 = arrayOfDate3[0];
		int y3 = Integer.parseInt(year3);
		String month3 = arrayOfDate3[1];
		int m3 = Integer.parseInt(month3);
		String day3 = arrayOfDate3[2];
		int d3 = Integer.parseInt(day3);

		System.out.println(year3 + "-" + month3 + "-" + day3);

		int m4 = m3 % 4;

		System.out.println(m4);

		LocalDate addDate5 = LocalDate.now().minusMonths(m4 + 1);

		System.out.println(addDate5);

	}

}