package alerts;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class AlertHandle {

	@Test(priority = 1)
	public void alertHandle() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://testpages.herokuapp.com/styled/alerts/alert-test.html");
		Thread.sleep(2000);

		// Alert window with OK button
		driver.findElement(By.xpath("//input[@id='alertexamples']")).click();
		Thread.sleep(2000);
		driver.switchTo().alert().accept(); // close alert by using OK button

		Thread.sleep(3000);

		// Alert window with OK and Cancel buttons
		WebElement confirm_alert = driver.findElement(By.xpath("//input[@id='confirmexample']"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", confirm_alert);
		confirm_alert.click();
		Thread.sleep(2000);
		driver.switchTo().alert().accept(); // close alert by using OK button
		System.out.println(driver.findElement(By.xpath("//p[@id='confirmreturn']")).getText());
		System.out.println(driver.findElement(By.xpath("//p[@id='confirmexplanation']")).getText());
		Thread.sleep(2000);
		confirm_alert.click();
		Thread.sleep(2000);
		driver.switchTo().alert().dismiss(); // close alert by using Cancel button
		System.out.println(driver.findElement(By.xpath("//p[@id='confirmreturn']")).getText());
		System.out.println(driver.findElement(By.xpath("//p[@id='confirmexplanation']")).getText());

		Thread.sleep(3000);

		// Alert window with input box, capture text from alert
		WebElement prompt_alert = driver.findElement(By.xpath("//input[@id='promptexample']"));
		js.executeScript("arguments[0].scrollIntoView();", prompt_alert);
		prompt_alert.click();
		Thread.sleep(2000);
		Alert alertWin = driver.switchTo().alert();
		System.out.println("The message displayed on alert: " + alertWin.getText());
		alertWin.sendKeys("Welcome");
		alertWin.accept();
		System.out.println(driver.findElement(By.xpath("//p[@id='promptreturn']")).getText());
		System.out.println(driver.findElement(By.xpath("//p[@id='promptexplanation']")).getText());

		Thread.sleep(2000);
		driver.quit();
	}

	@Test(priority = 2)
	public void authenticatePopupHandle() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
//		driver.get("https://the-internet.herokuapp.com/basic_auth");

		// Syntax
		// https://admin:admin@the-internet.herokuapp.com/basic_auth
		// https://username:password@URL

		driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");
		Thread.sleep(2000);
		driver.close();
	}

	@Test(priority = 3)
	public void permissionPopupHandle() throws InterruptedException {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");

		WebDriver driver = new ChromeDriver(options);
		driver.get("https://www.redbus.in/");

		driver.close();
	}
}
