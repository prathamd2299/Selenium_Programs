package javascriptexecutor;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class JavascriptExecutorHandle {
	@Test
	public void javascriptHandle() throws InterruptedException {
		// JavascriptExecutor is an interface that helps to execute javascript through
		// selenium web driver
		// Script = this is the javascript that need to be execute
		// Arguments = this is the argument to the script and this is optional
		// It will return anything like Boolean, Long, String, WebElement, null, List
		WebDriver driver = new ChromeDriver();
		driver.get("https://testautomationpractice.blogspot.com/");
		Thread.sleep(3000);
		WebElement button = driver.findElement(By.className("wikipedia-search-button"));

		JavascriptExecutor js = (JavascriptExecutor) driver;
		// Usage of JavasciptExecutor:
		// 1. To click on button
		js.executeScript("arguments[0].click();", button);
		js.executeScript("document.getElementById('email').click();");

		Thread.sleep(3000);
		// 2. To type text in texbox
		js.executeScript("document.getElementById('email').value='test@gmail.com';");
		// 3. To generate alert popup window
		js.executeScript("alert('Alert Message.');");
		driver.switchTo().alert().accept();
		Thread.sleep(2000);
		// 4. To refresh browser window
		js.executeScript("history.go(0)");
		// 5. To get the domain name
		String domainName = js.executeScript("return document.domain;").toString();
		System.out.println("Domain: " + domainName);
		// 6. To get the title of webpage
		String title = js.executeScript("return document.title;").toString();
		System.out.println("Title: " + title);
		// 7. To get the url of webpage
		String url = js.executeScript("return document.URL;").toString();
		System.out.println("URL: " + url);
		// 8. To get the height and width of webpage
		String height = js.executeScript("return window.innerHeight;").toString();
		System.out.println("Height: " + height);

		String width = js.executeScript("return window.innerWidth;").toString();
		System.out.println("Width: " + width);
		// 9. To navigate to different page
		js.executeScript("window.location = 'https://www.google.com/'");
		// 10. To perform scroll on webpage
		// 11. To zoom webpage
		js.executeScript("document.body.style.zoom='50%'");
		// 12. To flash a web element

		Thread.sleep(2000);
		driver.quit();
	}
}
