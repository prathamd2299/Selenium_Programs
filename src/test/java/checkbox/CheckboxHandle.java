package checkbox;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class CheckboxHandle {
	@Test(priority = 1)
	public void checkBoxHandle() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://testautomationpractice.blogspot.com/");
		Thread.sleep(3000);

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,300)", "");

		WebElement monday = driver.findElement(By.xpath("//input[@id='monday']"));
		Thread.sleep(3000);
		monday.click();
		System.out.println("clicked on: " + monday.getDomProperty("id") + " ->Selected: " + monday.isSelected());

		Thread.sleep(3000);
		driver.close();
	}

	@Test(priority = 2)
	public void checkboxHandleUsingForEachLoop() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://testautomationpractice.blogspot.com/");
		Thread.sleep(3000);

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,300)", "");

		List<WebElement> checkboxItems = driver
				.findElements(By.xpath("//input[@type='checkbox' and contains(@id,'day')]"));
		System.out.println("Checkbox size is: " + checkboxItems.size());

//		Using for each loop
		for (WebElement k : checkboxItems) {
			Thread.sleep(2000);
			k.click();
			System.out.println("clicked on: " + k.getDomProperty("id") + " " + k.isSelected());
		}
		Thread.sleep(2000);
		driver.quit();
	}

	@Test(priority = 3)
	public void checkboxHandleUsingForLoop() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://testautomationpractice.blogspot.com/");
		Thread.sleep(3000);

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,300)", "");

		List<WebElement> checkboxItems = driver
				.findElements(By.xpath("//input[@type='checkbox' and contains(@id,'day')]"));
		System.out.println("Checkbox size is: " + checkboxItems.size());

//		Using for loop		
		for (int i = 0; i < checkboxItems.size(); i++) {
			Thread.sleep(2000);
			checkboxItems.get(i).click();
			System.out.println("clicked on: " + checkboxItems.get(i).getDomProperty("id") + " ->Selected: "
					+ checkboxItems.get(i).isSelected());
		}
		Thread.sleep(2000);
		driver.quit();
	}

	@Test(priority = 4)
	public void selectFirstThreeCheckboxes() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://testautomationpractice.blogspot.com/");
		Thread.sleep(3000);

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,300)", "");

		List<WebElement> checkboxItems = driver
				.findElements(By.xpath("//input[@type='checkbox' and contains(@id,'day')]"));
		System.out.println("Checkbox size is: " + checkboxItems.size());

//		Selecting first 3 checkboxes
		int totalchboxes = checkboxItems.size();
		for (int i = 0; i < totalchboxes; i++) {
			if (i < 4) {
				Thread.sleep(2000);
				checkboxItems.get(i).click();
				System.out.println("Clicked on: " + checkboxItems.get(i).getDomProperty("id") + " ->Selected: "
						+ checkboxItems.get(i).isSelected());
			}
		}

		Thread.sleep(3000);
		driver.close();
	}

	@Test(priority = 5)
	public void selectLastTwoCheckboxes() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://testautomationpractice.blogspot.com/");
		Thread.sleep(3000);

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,300)", "");

		List<WebElement> checkboxItems = driver
				.findElements(By.xpath("//input[@type='checkbox' and contains(@id,'day')]"));
		System.out.println("Checkbox size is: " + checkboxItems.size());

//		Selecting last 2 checkboxes
//		Total no. of checkboxes - No. of checkboxes want to select = Starting index		
		int totalchboxes = checkboxItems.size();
		for (int i = totalchboxes - 2; i < totalchboxes; i++) {
			Thread.sleep(3000);
			checkboxItems.get(i).click();
			System.out.println("clicked on: " + checkboxItems.get(i).getDomProperty("id") + " ->Selected: "
					+ checkboxItems.get(i).isSelected());
		}
		Thread.sleep(2000);
		driver.quit();
	}

	@Test(priority = 6)
	public void selectMultipleCheckboxesByChoice() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://testautomationpractice.blogspot.com/");
		Thread.sleep(3000);

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,300)", "");

		List<WebElement> checkboxItems = driver
				.findElements(By.xpath("//input[@type='checkbox' and contains(@id,'day')]"));
		System.out.println("Checkbox size is: " + checkboxItems.size());

//		Selecting multiple checkboxes by choice		
		for (WebElement chbox : checkboxItems) {
			String chboxname = chbox.getDomProperty("id");
			if (chboxname.equals("thursday") || chboxname.equals("sunday")) {
				Thread.sleep(2000);
				chbox.click();
				System.out.println("clicked on: " + chbox.getDomProperty("id") + " " + chbox.isSelected());
			}
		}
		Thread.sleep(2000);
		driver.quit();
	}
}
