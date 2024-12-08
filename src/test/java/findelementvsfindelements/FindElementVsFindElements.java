package findelementvsfindelements;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class FindElementVsFindElements {
	@Test
	public void findElementVsFindElements() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://demo.nopcommerce.com/");

		driver.manage().window().maximize();
		Thread.sleep(2000);

		// findElement --> Locating the single element
		WebElement searchbox = driver.findElement(By.xpath("//input[@id='small-searchterms']"));
		searchbox.sendKeys("Tshirt");

		// Multiple element xpath give only first element in findElement()
		WebElement footer = driver.findElement(By.xpath("//div[@class='footer']//a"));
		footer.getText();
		System.out.println(footer.getText());

		// findElements --> Locating the list of elements
		List<WebElement> footer_links = driver.findElements(By.xpath("//div[@class='footer-upper']//a"));
		System.out.println("Number of elements captured is: " + footer_links.size());

		for (WebElement el : footer_links) {
			System.out.println(el.getText());
		}

		// findElements --> Locating the one element
		List<WebElement> logo = driver.findElements(By.xpath("//img[@alt='nopCommerce demo store']"));
		System.out.println("Number of elements captured is: " + logo.size());

		// findElements --> Locating the not matching element
		List<WebElement> elec = driver.findElements(By.xpath("//img[contains(title,'Electronics')]"));
		System.out.println("Number of elements captured is: " + elec.size());

		Thread.sleep(2000);
		driver.close();
	}
}
