package datepicker;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class DatePickerHandle {

	@Test
	public void datePickerHandle() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.dummyticket.com/dummy-ticket-for-visa-application/");
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,1000)", "");
		driver.findElement(By.xpath("//input[@id='dob']")).click();
		Thread.sleep(2000);

		// Month selection
		WebElement month_drp = driver.findElement(By.xpath("//select[@class='ui-datepicker-month']"));
		Select month_dr = new Select(month_drp);
		List<WebElement> months = month_dr.getOptions();
		System.out.println("Size of months list is: " + months.size());
		month_dr.selectByVisibleText("Sep");
		Thread.sleep(2000);

		// Year selection
		Select year_dr = new Select(driver.findElement(By.xpath("//select[@aria-label='Select year']")));
		List<WebElement> years = year_dr.getOptions();
		System.out.println("Size of years list is: " + years.size());
		year_dr.selectByValue("1990");

		// Date selection
		String date = "20";
		List<WebElement> all_dates = driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//td"));

		for (WebElement ele : all_dates) {
			String dt = ele.getText();
			if (dt.equalsIgnoreCase(date)) {
				ele.click();
				System.out.println(ele.getText());
				break;
			}
		}
		Thread.sleep(2000);
		driver.quit();
	}
}
