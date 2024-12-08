package iframes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class IframeHandle {
	@Test(priority = 1)
	public void handleInnerIframe() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.w3schools.com/html/tryit.asp?filename=tryhtml_iframe_height_width");
		Thread.sleep(2000);

		driver.switchTo().frame("iframeResult"); // outer iframe
		driver.switchTo().frame(0); // inner iframe

		System.out.println("Text inside the inner frame is: " + driver.findElement(By.xpath("//h1")).getText());

		driver.switchTo().parentFrame(); // switch to outer frame i.e. parent frame

		String text = driver
				.findElement(By.xpath("//p[contains(text(),'You can use the height and width attributes to spe')]"))
				.getText();
		System.out.println("Text present in outer iframe is: " + text);

		Thread.sleep(2000);
		driver.close();
	}

	@Test(priority = 2)
	public void switchIntoDifferrentIFrameUsingDifferentMethod() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.selenium.dev/selenium/docs/api/java/index.html?overview-summary.html");
		driver.manage().window().maximize();
		Thread.sleep(2000);

		// Switch into frame 1 by using name of frame
		driver.switchTo().frame("packageListFrame");
		WebElement e = driver.findElement(By.xpath("//a[@href='org/openqa/selenium/chrome/package-frame.html']"));
		e.click();
		Thread.sleep(2000);

		// referesh the webpage
		driver.navigate().refresh();
		Thread.sleep(2000);
		// Switch to main frame
		driver.switchTo().defaultContent();
		Thread.sleep(2000);

		// Switch into frame 2 by using index
		driver.switchTo().frame(1);
		WebElement e1 = driver.findElement(By.xpath("//a[@href='org/openqa/selenium/interactions/Actions.html']"));
		e1.click();
		Thread.sleep(2000);

		// referesh the webpage
		driver.navigate().refresh();
		Thread.sleep(2000);
		// Switch to main frame
		driver.switchTo().defaultContent();
		Thread.sleep(2000);

		// Switch into frame 3 by using xpath of frame
		driver.switchTo()
				.frame(driver.findElement(By.xpath("//iframe[@title='Package, class and interface descriptions']")));
		WebElement e2 = driver.findElement(By.xpath("//a[@href='org/openqa/selenium/devtools/package-summary.html']"));
		e2.click();

		// referesh the webpage
		driver.navigate().refresh();
		Thread.sleep(2000);
		// Switch to main frame
		driver.switchTo().defaultContent();

		Thread.sleep(2000);
		driver.close();
	}

	@Test(priority = 3)
	public void switchIntoDifferrentIFrame() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://demo.automationtesting.in/Frames.html");
		driver.manage().window().maximize();
		Thread.sleep(2000);

		driver.findElement(By.xpath("//a[text()='Iframe with in an Iframe']")).click();

		WebElement outer_frame = driver.findElement(By.xpath("//iframe[@src='MultipleFrames.html']"));
		driver.switchTo().frame(outer_frame);

		WebElement inner_frame = driver.findElement(By.cssSelector("iframe[src='SingleFrame.html']"));
		driver.switchTo().frame(inner_frame);

		driver.findElement(By.xpath("//input[@type='text']")).sendKeys("Welcome");

		Thread.sleep(2000);
		driver.close();
	}
}
