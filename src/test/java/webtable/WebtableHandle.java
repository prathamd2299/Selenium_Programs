package webtable;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class WebtableHandle {
	@Test
	public void webTableHandle() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		Thread.sleep(2000);

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,700)", "");

		// 1. How many rows are there in table
		// Locating table rows element and storing in list
		List<WebElement> tableRows = driver.findElements(By.xpath("//div[@class='tableFixHead']//tbody/tr"));
		int noOfRows = tableRows.size();
		System.out.println("Total no. of rows in table are: " + noOfRows);

		// 2. How many columns are there in table
		// Locating table columns element and storing in list
		List<WebElement> tableColumns = driver.findElements(By.xpath("//div[@class='tableFixHead']//thead/tr/th"));
		int noOfColumns = tableColumns.size();
		System.out.println("Total no. of columns in table are: " + noOfColumns);

		// 3. Retrieve the specific row/column data
		// Locating specific element
		WebElement secondRowSecondColumnData = driver
				.findElement(By.xpath("//div[@class='tableFixHead']//tbody/tr[2]/td[2]"));
		String value = secondRowSecondColumnData.getText();
		System.out.println("The value is: " + value);

		// 4. Retrieve all the data from table
		for (int r = 1; r <= noOfRows; r++) {
			for (int c = 1; c <= noOfColumns; c++) {
				WebElement allTableData = driver
						.findElement(By.xpath("//div[@class='tableFixHead']//tbody/tr[" + r + "]/td[" + c + "]"));
				String data = allTableData.getText();
				System.out.print(data + " | ");
			}
			System.out.println();
		}

		System.out.println("\n");

		// 5. Print position,city,amount
		for (int r = 1; r <= noOfRows; r++) {
			WebElement elscol = driver.findElement(By.xpath("//div[@class='tableFixHead']//tbody/tr[" + r + "]/td[1]"));
			String name = elscol.getText();

			if (name.equals("Ivory")) {
				String position = driver
						.findElement(By.xpath("//div[@class='tableFixHead']//tbody/tr[" + r + "]/td[2]")).getText();
				String city = driver.findElement(By.xpath("//div[@class='tableFixHead']//tbody/tr[" + r + "]/td[3]"))
						.getText();
				String amount = driver.findElement(By.xpath("//div[@class='tableFixHead']//tbody/tr[" + r + "]/td[4]"))
						.getText();
				System.out.println(position + " " + city + " " + amount);
			}
		}

		driver.close();
	}
}
