package links;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class LinksHandle {
	@Test(priority = 1)
	public void brokenLinksHandle() throws InterruptedException, IOException {
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.deadlinkcity.com/");
		Thread.sleep(3000);

		// Capture all links
		List<WebElement> links = driver.findElements(By.tagName("a"));
		System.out.println("Total links are: " + links.size());

		int brokenLinks = 0;

		// For each loop
		for (WebElement element : links) {
			String url = element.getDomProperty("href");

			if (url == null || url.isEmpty()) {
				System.out.println("Url is empty");
				continue;
			}

			URL link = new URL(url);

			try {
				HttpURLConnection httpconn = (HttpURLConnection) link.openConnection();
				httpconn.connect();

				if (httpconn.getResponseCode() >= 400) {
					System.out.println(httpconn.getResponseCode() + " is broken");
					brokenLinks++;
				} else {
					System.out.println(httpconn.getResponseCode() + " is valid link");
				}
			} catch (Exception e) {
				System.out.println("vhjhj");
			}

		}

		Thread.sleep(2000);
		System.out.println("No. of broken links are: " + brokenLinks);
		driver.quit();
	}

	@Test(priority = 2)
	public void linksHandle() throws InterruptedException, IOException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.in/");

		// Locate link by linkText locator
//		driver.findElement(By.linkText("Today's Deals")).click();
		// Locate link by partialLinkText locator
//		driver.findElement(By.partialLinkText("Deals")).click();

		// Capture all links
		List<WebElement> links = driver.findElements(By.tagName("a"));
		System.out.println("Total links are: " + links.size());

		// Normal for loop
		/*
		 * for(int i = 0; i <= links.size(); i++) {
		 * System.out.println(links.get(i).getText());
		 * System.out.println(links.get(i).getAttribute("href")); }
		 */

		// For each loop
		for (WebElement link : links) {
			System.out.println(link.getText());
			System.out.println(link.getDomProperty("href"));
		}

		Thread.sleep(2000);
		driver.close();
	}
}
