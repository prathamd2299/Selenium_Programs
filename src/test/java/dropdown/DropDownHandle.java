package dropdown;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class DropDownHandle {
	@Test(priority = 1)
	public void autoSuggestionDropDownHandle() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.navigate().to("https://www.twoplugs.com/"); // Launching the browser
		driver.manage().window().maximize(); // maximize the window
		Thread.sleep(2000); // sleep for 2 seconds

		// Locating Live Posting link
		WebElement link = driver.findElement(By.xpath("//a[text()='Live Posting']"));
		link.click(); // clicking on Live Posting link

		// Locating searchbox
		WebElement searchbox = driver.findElement(By.xpath("//input[@placeholder='Toronto,ON,Canada']"));
		Thread.sleep(2000); // sleep for 2 seconds
		searchbox.clear(); // clear existed value
		Thread.sleep(2000); // sleep for 2 seconds
		searchbox.sendKeys("Tor"); // passing new value
		String txt;

		do {
			searchbox.sendKeys(Keys.ARROW_DOWN);
			Thread.sleep(2000); // sleep for 2 seconds
			txt = searchbox.getDomProperty("value");
			if (txt.equals("Torremolinos, Spain")) {
				Thread.sleep(2000); // sleep for 2 seconds
				searchbox.sendKeys(Keys.ENTER);
				System.out.println(txt);
				break;
			}
			Thread.sleep(2000); // sleep for 2 seconds
		} while (!txt.isEmpty());

		Thread.sleep(2000);
		driver.close();
	}

	@Test(priority = 2)
	public void dropDownHandleUsingMethods() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.globalsqa.com/demo-site/select-dropdown-menu/");

		driver.manage().window().maximize();
		Thread.sleep(2000);

		WebElement countryEl = driver.findElement(By.xpath("//*[@id=\"post-2646\"]/div[2]/div/div/div/p/select"));
		countryEl.click();
		Thread.sleep(3000);
		Select country = new Select(countryEl);
		country.selectByVisibleText("Honduras");
		System.out.println("Selected option is: " + country.getFirstSelectedOption().getText());
		countryEl.click();
		Thread.sleep(3000);
		countryEl.click();
		country.selectByValue("AGO");
		System.out.println("Selected option is: " + country.getFirstSelectedOption().getText());
		countryEl.click();
		Thread.sleep(3000);
		countryEl.click();
		country.selectByIndex(12);
		System.out.println("Selected option is: " + country.getFirstSelectedOption().getText());
		countryEl.click();

		Thread.sleep(2000);
		driver.close();
	}

	@Test(priority = 3)
	public void dropDownHandleWithoutUsingMethods() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.globalsqa.com/demo-site/select-dropdown-menu/");

		driver.manage().window().maximize();
		Thread.sleep(2000);

		WebElement countryEl = driver.findElement(By.xpath("//*[@id=\"post-2646\"]/div[2]/div/div/div/p/select"));
		countryEl.click();
		Thread.sleep(2000);
		Select country = new Select(countryEl);

		List<WebElement> allOptions = country.getOptions();

		for (WebElement option : allOptions) {
			if (option.getText().equalsIgnoreCase("icELand")) {
				Thread.sleep(2000);
				option.click();
				System.out.println(option.getText());
				break;
			}
		}

		Thread.sleep(2000);
		driver.close();
	}
}
