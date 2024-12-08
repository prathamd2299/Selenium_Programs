package windows;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class WindowHandle {
	@Test(priority = 1)
	public void multipleWindowIDsUsingList() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

		Thread.sleep(3000);

//		Opens another browser window - child window		
		driver.findElement(By.xpath("//a[text()='OrangeHRM, Inc']")).click();

		Set<String> windowIDs = driver.getWindowHandles(); // return IDs of multiple browser windows

//		Second approach to print multiple window IDs --> Using List/ArrayList
		List<String> windowIDsList = new ArrayList<>(windowIDs); // Converting Set to List
		String parentWindowID = windowIDsList.get(0);
		String childWindowID = windowIDsList.get(1);

		System.out.println("Parent window ID: " + parentWindowID);
		System.out.println("Child window ID: " + childWindowID);

		// How to use window IDs for swtching
		driver.switchTo().window(parentWindowID);
		System.out.println("Parent window title: " + driver.getTitle());
		System.out.println("Parent window url: " + driver.getCurrentUrl());

		driver.switchTo().window(childWindowID);
		System.out.println("Child window title: " + driver.getTitle());
		System.out.println("Child window url: " + driver.getCurrentUrl());

//		For loop
		for (String winID : windowIDsList) {
			System.out.println(winID);
			String title = driver.switchTo().window(winID).getTitle();
			String url = driver.switchTo().window(winID).getCurrentUrl();
			System.out.println(title);
			System.out.println(url);
		}

		Thread.sleep(5000);
		driver.close(); // closes single browser window which is driver pointing
		driver.quit(); // closes all browser window
	}

	@Test(priority = 2)
	public void multipleWindowHandle() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

		Thread.sleep(3000);

//		Opens another browser window - child window		
		driver.findElement(By.xpath("//a[text()='OrangeHRM, Inc']")).click();

//		getWindowHandles()
		Set<String> windowIDs = driver.getWindowHandles(); // return IDs of multiple browser windows
//		Second approach to print multiple window IDs --> Using List/ArrayList
		List<String> windowIDsList = new ArrayList<>(windowIDs); // Converting Set to List
		String parentWindowID = windowIDsList.get(0);
		String childWindowID = windowIDsList.get(1);

		System.out.println("Parent window ID: " + parentWindowID);
		System.out.println("Child window ID: " + childWindowID);

		// How to use window IDs for swtching
		driver.switchTo().window(parentWindowID);
		System.out.println("Parent window title: " + driver.getTitle());
		System.out.println("Parent window url: " + driver.getCurrentUrl());

		driver.switchTo().window(childWindowID);
		System.out.println("Child window title: " + driver.getTitle());
		System.out.println("Child window url: " + driver.getCurrentUrl());

		for (String winID : windowIDsList) {
			// System.out.println(winID);
			String title = driver.switchTo().window(winID).getTitle();
			String url = driver.switchTo().window(winID).getCurrentUrl();
			if (title.equalsIgnoreCase(
					"OrangeHRM HR Software | Free & Open Source HR Software | HRMS | HRIS | OrangeHRM")) {
				driver.close();
			}
			System.out.println(title);
			System.out.println(url);
		}

		driver.quit();
	}

	@Test(priority = 3)
	public void windowHandle() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

		Thread.sleep(3000);
//		driver.manage().window().maximize();

		String windowID = driver.getWindowHandle();
		System.out.println(windowID); // Printing ID of single browser window

		driver.quit();
	}
}
