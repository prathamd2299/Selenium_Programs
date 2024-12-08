package keyboardOprations;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class KeyboardActionHandle {
	@Test(priority = 1)
	public void keyBoardHandleUsingMultipleKeys() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://text-compare.com/");
		Thread.sleep(3000);

		WebElement input1 = driver.findElement(By.xpath("//textarea[@id='inputText1']"));
		input1.sendKeys("prathamesh");
		WebElement input2 = driver.findElement(By.xpath("//textarea[@id='inputText2']"));

		Actions act = new Actions(driver);
		// Ctrl + A
		act.keyDown(Keys.CONTROL);
		act.sendKeys("a");
		act.keyUp(Keys.CONTROL);
		act.perform();
		Thread.sleep(2000);
		// Ctrl + C
		act.keyDown(Keys.CONTROL);
		act.sendKeys("c");
		act.keyUp(Keys.CONTROL);
		act.perform();
		Thread.sleep(2000);
		// TAB
		act.sendKeys(Keys.TAB);
		act.perform();
		Thread.sleep(2000);
		// Ctrl + V
		act.keyDown(Keys.CONTROL);
		act.sendKeys("v");
		act.keyUp(Keys.CONTROL);
		act.perform();

		if (input1.getDomProperty("value").equals(input2.getDomProperty("value"))) {
			System.out.println("Text Copied");
		} else {
			System.out.println("Text Not Copied");
		}

		Thread.sleep(2000);
		driver.quit();
	}

	@Test(priority = 2)
	public void keyBoardHandle() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/key_presses");
		Thread.sleep(3000);

		Actions act = new Actions(driver);
		act.sendKeys(Keys.ENTER, Keys.ARROW_DOWN).perform();

		System.out.println(driver.findElement(By.xpath("//p[@id='result']")).getText());

		Thread.sleep(2000);
		driver.quit();
	}
}
