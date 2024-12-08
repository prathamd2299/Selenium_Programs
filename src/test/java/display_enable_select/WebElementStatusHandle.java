package display_enable_select;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class WebElementStatusHandle {

	@Test
	public void webElementStatusHandle() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://demo.nopcommerce.com/register?returnUrl=%2F");

		driver.manage().window().maximize(); // maximizing window
		Thread.sleep(2000); // sleep for 2 sec

		// Locating search store element
		WebElement searchStore = driver.findElement(By.xpath("//input[@id='small-searchterms']"));
		// checking element displayed on webpage or not--> gives true
		System.out.println("Display status: " + searchStore.isDisplayed());
		// checking element enabled i.e. ready to accept command or not --> gives true
		System.out.println("Enable status: " + searchStore.isEnabled());

		// Locating male radio button
		WebElement male = driver.findElement(By.xpath("//input[@id='gender-male']"));

		// Locating female radio button
		WebElement female = driver.findElement(By.xpath("//input[@id='gender-female']"));

		// Checking element is selected or not
		System.out.println("Male select status: " + male.isSelected()); // false
		System.err.println("Female select status: " + female.isSelected()); // false

		male.click();
		Thread.sleep(2000);
		// Checking element is selected or not
		System.out.println("Male select status: " + male.isSelected()); // true
		female.click();
		System.err.println("Female select status: " + female.isSelected()); // false

		Thread.sleep(2000);
		// closing current window
		driver.close();

	}

}
