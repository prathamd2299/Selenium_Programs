package tooltip;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class ToolTipHandle {
	@Test
	public void toolTipHandle() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://jqueryui.com/tooltip/");
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='demo-frame']")));
		Thread.sleep(2000);

		WebElement input_box = driver.findElement(By.xpath("//input[@id='age']"));
		String actual_tooltip_text = input_box.getDomProperty("title");
		String expected_tooltip_text = "We ask for your age only for statistical purposes.";

		if (actual_tooltip_text.equals(expected_tooltip_text)) {
			System.out.println("Test Pass");
		} else {
			System.out.println("Test Fail");
		}

		Thread.sleep(2000);
		driver.quit();
	}
}
