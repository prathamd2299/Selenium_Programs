package waits;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.google.common.base.Function;

public class WaitHandle {
	@Test(priority = 1)
	public void explicitWaitHandle() {
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.google.com/");

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		WebElement search = driver.findElement(By.xpath("//textarea[@name='q']"));
		search.sendKeys("Selenium");
		search.sendKeys(Keys.ENTER);

		WebElement el = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h3[text()='Selenium']")));
		el.click();

		driver.close();
	}

	@Test(priority = 2)
	public void fluentWaitHandle() {
		WebDriver driver = new ChromeDriver();

		// Waiting 30 seconds for an element to be present on the page, checking
		// for its presence once every 5 seconds.
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(30))
				.pollingEvery(Duration.ofSeconds(5)).ignoring(NoSuchElementException.class);

		driver.get("https://www.google.com/");

		WebElement search = driver.findElement(By.xpath("//textarea[@name='q']"));
		search.sendKeys("Selenium");
		search.sendKeys(Keys.ENTER);

		WebElement element = wait.until(new Function<WebDriver, WebElement>() {
			public WebElement apply(WebDriver driver) {
				return driver.findElement(By.xpath("//h3[text='Selenium']"));
			}
		});

		element.click();

		driver.close();
	}

	@Test(priority = 3)
	public void implicitWaitHandle() {
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.google.com/");

		// Implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		WebElement search = driver.findElement(By.xpath("//textarea[@name='q']"));
		search.sendKeys("Selenium");
		search.sendKeys(Keys.ENTER);

		driver.findElement(By.xpath("//h3[text()='Selenium']")).click();

		driver.close();
	}
}
