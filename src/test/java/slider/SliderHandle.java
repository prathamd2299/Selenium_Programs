package slider;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class SliderHandle {
	@Test
	public void sliderHandle() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://jqueryui.com/slider/#range");
		Thread.sleep(2000);

		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='demo-frame']")));

		WebElement min_slider = driver
				.findElement(By.xpath("(//span[@class='ui-slider-handle ui-corner-all ui-state-default'])[1]"));
		WebElement max_slider = driver
				.findElement(By.xpath("(//span[@class='ui-slider-handle ui-corner-all ui-state-default'])[2]"));
		System.out.println("Location of the min_slider: " + min_slider.getLocation());
		System.out.println("Height and width of the element min_slider: " + min_slider.getSize());

		Actions action = new Actions(driver);
		action.dragAndDropBy(min_slider, 50, 0).build().perform();
		Thread.sleep(2000);

		System.out.println("Location of the max_slider: " + max_slider.getLocation());
		System.out.println("Height and width of the element max_slider: " + max_slider.getSize());
		action.dragAndDropBy(max_slider, 100, 0).build().perform();

		Thread.sleep(3000);
		driver.quit();
	}
}
