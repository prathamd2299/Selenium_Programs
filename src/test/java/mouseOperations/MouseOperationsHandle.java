package mouseOperations;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class MouseOperationsHandle {
	@Test(priority = 1)
	public void doubleClickActionHandle() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml5_ev_ondblclick3");
		Thread.sleep(3000);

		// First go in frame of name "iframeResult"
		driver.switchTo().frame("iframeResult");

		// Locating first input box
		WebElement firstField = driver.findElement(By.xpath("//input[@id='field1']"));
		Thread.sleep(2000);
		// Clicking on first inputbox
		firstField.click();

		Thread.sleep(2000);
		// Clearing existing value
		firstField.clear();

		Thread.sleep(2000);
		// Sending new value
		firstField.sendKeys("Prathamesh");
		System.out.println("First inputbox value is: " + firstField.getDomProperty("value"));

		// Locating Copy Text button
		WebElement doubleClickBtn = driver.findElement(By.xpath("//button[text()='Copy Text']"));
		Thread.sleep(2000);
		// Creating Actions class object to perform mouse actions
		// and passing driver to it
		Actions action = new Actions(driver);

		// Double click action perform on button
		action.doubleClick(doubleClickBtn).build().perform();
		System.out.println("Double click action performed...");

		WebElement secondField = driver.findElement(By.xpath("//input[@id='field1']"));
		System.out.println("Second inputbox value is: " + secondField.getDomProperty("value"));

		Thread.sleep(2000);
		driver.quit();
	}

	@Test(priority = 2)
	public void dragAndDropActionHandle() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.dhtmlgoodies.com/scripts/drag-drop-custom/demo-drag-drop-3.html");
		Thread.sleep(3000);

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,400)", "");

		// Source WebElements
		WebElement oslo = driver.findElement(By.id("box1"));
		WebElement stockholm = driver.findElement(By.id("box2"));
		WebElement washington = driver.findElement(By.id("box3"));
		WebElement copenhagen = driver.findElement(By.id("box4"));
		WebElement seoul = driver.findElement(By.id("box5"));
		WebElement rome = driver.findElement(By.id("box6"));
		WebElement madrid = driver.findElement(By.id("box7"));

		// Target WebElements
		WebElement norway = driver.findElement(By.id("box101"));
		WebElement sweden = driver.findElement(By.id("box102"));
		WebElement unitedStates = driver.findElement(By.id("box103"));
		WebElement denmark = driver.findElement(By.id("box104"));
		WebElement southKorea = driver.findElement(By.id("box105"));
		WebElement italy = driver.findElement(By.id("box106"));
		WebElement spain = driver.findElement(By.id("box107"));

		Thread.sleep(3000);
		// Creating Actions class object to perform mouse actions
		// and passing driver to it
		Actions action = new Actions(driver);

		// Drag and Drop Actions perform on boxes
		// Dragging Oslo and dropping in Norway
		action.dragAndDrop(oslo, norway).build().perform();
		System.out.println("1. Oslo dragged and dropped in Norway.");
		Thread.sleep(3000);

		// Dragging Stockholm and dropping in Sweden
		action.dragAndDrop(stockholm, sweden).build().perform();
		System.out.println("2. Stockholm dragged and dropped in Sweden.");
		Thread.sleep(3000);

		// Dragging Washington and dropping in United States
		action.dragAndDrop(washington, unitedStates).build().perform();
		System.out.println("3. Washington dragged and dropped in United States.");
		Thread.sleep(3000);

		// Dragging Copenhagen and dropping in Denmark
		action.dragAndDrop(copenhagen, denmark).build().perform();
		System.out.println("4. Copenhagen dragged and dropped in Denmark.");
		Thread.sleep(3000);

		// Dragging Seoul and dropping in South Korea
		action.dragAndDrop(seoul, southKorea).build().perform();
		System.out.println("5. Seoul dragged and dropped in South Korea.");
		Thread.sleep(3000);

		// Dragging Rome and dropping in Italy
		action.dragAndDrop(rome, italy).build().perform();
		System.out.println("6. Rome dragged and dropped in Italy.");
		Thread.sleep(3000);

		// Dragging Madrid and dropping in Spain
		action.dragAndDrop(madrid, spain).build().perform();
		System.out.println("7. Madrid dragged and dropped in Spain.");
		Thread.sleep(3000);

		Thread.sleep(3000);
		driver.quit();
	}

	@Test(priority = 3)
	public void dragAndDropImagesHandle() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.globalsqa.com/demo-site/draganddrop/");
		Thread.sleep(3000);

		// Switching in frame which have class of "demo-frame lazyload"
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='demo-frame lazyloaded']")));

		WebElement highTatras = driver.findElement(By.xpath("//li[1]"));
		WebElement highTatras2 = driver.findElement(By.xpath("//li[2]"));
		WebElement highTatras3 = driver.findElement(By.xpath("//li[3]"));
		WebElement highTatras4 = driver.findElement(By.xpath("//li[4]"));

		WebElement trash = driver.findElement(By.xpath("//div[@id='trash']"));

		Thread.sleep(3000);
		// Creating Actions class object to perform mouse actions
		// and passing driver to it
		Actions action = new Actions(driver);

		// Drag and Drop Actions perform on boxes
		// Dragging High Tatras and dropping in Trash
		action.dragAndDrop(highTatras, trash).build().perform();
		System.out.println("1. High Tatras dragged and dropped in Trash.");
		Thread.sleep(3000);

		// Dragging High Tatras2 and dropping in Trash
		action.dragAndDrop(highTatras2, trash).build().perform();
		System.out.println("1. High Tatras2 dragged and dropped in Trash.");
		Thread.sleep(3000);

		// Dragging High Tatras3 and dropping in Trash
		action.dragAndDrop(highTatras3, trash).build().perform();
		System.out.println("1. High Tatras3 dragged and dropped in Trash.");
		Thread.sleep(3000);

		// Dragging High Tatras4 and dropping in Trash
		action.dragAndDrop(highTatras4, trash).build().perform();
		System.out.println("1. High Tatras4 dragged and dropped in Trash.");
		Thread.sleep(3000);

		Thread.sleep(2000);
		driver.quit();
	}

	@Test(priority = 4)
	public void mouseHoverActionHandle() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://demo.opencart.com/");
		Thread.sleep(3000);

		// Locating desktop menu elelment
		WebElement desktopMenu = driver.findElement(By.xpath("//a[normalize-space()='Desktops']"));

		// Locating mac item element
		WebElement macMenuItem = driver.findElement(By.xpath("//a[normalize-space()='Mac (1)']"));

		// Creating Actions class object to perform mouse actions
		// and passing driver to it
		Actions action = new Actions(driver);

		// Mouse hover operation performing
		action.moveToElement(desktopMenu).build().perform();
		action.moveToElement(macMenuItem).click().build().perform();
		System.out.println("clicked on mac.");
		Thread.sleep(3000);
		driver.quit();
	}

	@Test(priority = 5)
	public void rightClickActionHandle() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://swisnl.github.io/jQuery-contextMenu/demo.html");
		Thread.sleep(3000);

		// Locating right click button
		WebElement rightClickBtn = driver.findElement(By.xpath("//span[@class='context-menu-one btn btn-neutral']"));

		// Creating Actions class object to perform mouse actions
		// and passing driver to it
		Actions action = new Actions(driver);

		// Right click action perform on button
		action.contextClick(rightClickBtn).build().perform();
		System.out.println("Right click action performed..");

		WebElement boxAfterRightClick = driver
				.findElement(By.xpath("//li[@class='context-menu-item context-menu-icon context-menu-icon-edit']"));
		boxAfterRightClick.sendKeys(Keys.ARROW_DOWN);
		Thread.sleep(2000);

		boxAfterRightClick.sendKeys(Keys.ARROW_DOWN);
		Thread.sleep(2000);

		boxAfterRightClick.sendKeys(Keys.ENTER);

		Thread.sleep(2000);
		driver.quit();
	}
}
