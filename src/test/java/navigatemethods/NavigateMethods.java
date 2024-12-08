package navigatemethods;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class NavigateMethods {
	@Test
	public void navigateMethods() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.in/");
//		driver.get("https://www.snapdeal.com/");

		driver.manage().window().maximize(); // maximizing window
		Thread.sleep(2000); // sleep for 2 sec

		String url = driver.getCurrentUrl(); // getting current url of current webpage
		System.out.println(url); // printing current webpage url

		String title = driver.getTitle(); // getting current webpage title
		System.out.println(title); // Printitng current webpage title

		System.out.println("\n"); // new line

		// navigate to snapdeal webpage
		driver.navigate().to("https://www.snapdeal.com/");
		String urls = driver.getCurrentUrl(); // getting current url of current webpage
		System.out.println(urls); // printing current webpage url

		String titles = driver.getTitle(); // getting current webpage title
		System.out.println(titles); // Printitng current webpage title

		Thread.sleep(2000); // sleep for 2 sec

		// navigate to previous url webpage
		driver.navigate().back();

		// get the current page url on console window
		String str = driver.getCurrentUrl();
		System.out.println(str);

		// get the title of webapage on console window
		String str1 = driver.getTitle();
		System.out.println(str1);

		System.out.println("\n"); // new line

		Thread.sleep(2000); // sleep for 2 sec

		// navigate to next url webpage
		driver.navigate().forward();

		// get the current page url on console window
		String url1 = driver.getCurrentUrl();
		System.out.println(url1);

		// get the title of webapage on console window
		String title1 = driver.getTitle();
		System.out.println(title1);

		System.out.println("\n"); // new line

		Thread.sleep(2000); // sleep for 2 sec

		// refresh the current webpage
		driver.navigate().refresh();

		// get the current page url on console window
		String url2 = driver.getCurrentUrl();
		System.out.println(url2);

		// get the title of webapage on console window
		String title2 = driver.getTitle();
		System.out.println(title2);

		Thread.sleep(2000);
		// closing current window
		driver.close();
	}

}
