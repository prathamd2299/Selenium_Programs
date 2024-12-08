package screenshot;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class ScreenshotHandle {
	@Test(priority = 1)
	public void fullPageScreenshotHandle() throws InterruptedException, IOException {
		WebDriver driver = new ChromeDriver(); // driver is an instance of webdriver interface
		// chromedriver is an class
		driver.get("https://www.nopcommerce.com/en/demo");
		Thread.sleep(3000);

		// 1. Full Page Screenshot
		// driver is an instance of webdriver interface and ts is an instance of
		// takesscreenshot interface
		// they both are different
		// so we have to typecast driver int takesscreenshot interface
		TakesScreenshot ts = (TakesScreenshot) driver;
		// This below statement capture the screenshot and store it in file
		// or somewhere in the hardware or memory
		// this method will return file instance
		File src = ts.getScreenshotAs(OutputType.FILE);
		// This will create one location to store the screenshots
		// we cannot see screenshot file if we do not copy into any particular location
		File target = new File("C:\\Users\\Lenovo\\Desktop\\selenium screenshot\\homepage.png");
		// below statement will copy src file into target file
		FileUtils.copyFile(src, target);
		System.out.println("Screenshot captured");

		driver.quit();
	}

	@Test(priority = 2)
	public void sectionOfPageScreenshotHandle() throws InterruptedException, IOException {
		WebDriver driver = new ChromeDriver(); // driver is an instance of webdriver interface
		// chromedriver is an class
		driver.get("https://www.nopcommerce.com/en/demo");
		Thread.sleep(3000);

		// 2. Screenshot of portion of any page
		WebElement footer_section = driver.findElement(By.xpath("//div[@class='footer-upper']"));
		File src1 = footer_section.getScreenshotAs(OutputType.FILE);
		File target1 = new File("C:\\Users\\Lenovo\\Desktop\\selenium screenshot\\footer_section.png");
		FileUtils.copyFile(src1, target1);
		System.out.println("Footer section screenshot captured");

		driver.quit();
	}

	@Test(priority = 3)
	public void webElementScreenshotHandle() throws InterruptedException, IOException {
		WebDriver driver = new ChromeDriver(); // driver is an instance of webdriver interface
		// chromedriver is an class
		driver.get("https://www.nopcommerce.com/en/demo");
		Thread.sleep(3000);

		// 3. Screenshot of any particular element
		WebElement logo = driver.findElement(By.xpath("//img[@title='nopCommerce']"));
		File src2 = logo.getScreenshotAs(OutputType.FILE);
		File target2 = new File("C:\\Users\\Lenovo\\Desktop\\selenium screenshot\\logo.png");
		FileUtils.copyFile(src2, target2);
		System.out.println("logo screenshot captured");

		driver.quit();
	}
}
