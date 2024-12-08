package scrollbar;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class scrollActionHandle {
	@Test(priority = 1)
	public void scrollTillBottomAndAgainUpOfPage() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.calculator.net/");
		Thread.sleep(3000);

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0,document.body.scrollHeight)", "");
		js.executeScript("window.scrollTo(0,-document.body.scrollHeight)", "");

		Thread.sleep(2000);
		driver.quit();
	}
	
	@Test(priority = 2)
	public void scrollTillVisibleElement() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.calculator.net/");
		Thread.sleep(3000);

		WebElement bmi = driver.findElement(By.linkText("BMI Calculator"));

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", bmi);

		Thread.sleep(2000);
		driver.quit();
	}
	
	@Test(priority = 3)
	public void verticalScroll() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.calculator.net/");
		Thread.sleep(3000);

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0, 200)", "");

		Thread.sleep(2000);
		driver.quit();
	}
}
