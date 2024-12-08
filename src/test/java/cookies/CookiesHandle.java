package cookies;

import java.util.Set;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class CookiesHandle {

	@Test
	public void cookiesHandle() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://demo.nopcommerce.com/");
		Thread.sleep(2000);

		// How to capture cookies from browser
		Set<Cookie> cookies = driver.manage().getCookies();
		System.out.println("Size of Cookies: " + cookies.size());

		// How to print each cookie name from browser
		for (Cookie cookie : cookies) {
			System.out.println(cookie.getName() + " : " + cookie.getValue());
		}

		// How to add cookies
		Cookie cookieObj = new Cookie("MyCookie1", "123456");
		driver.manage().addCookie(cookieObj);

		cookies = driver.manage().getCookies();
		System.out.println("\nSize of Cookies after adding: " + cookies.size());

		// How to delete the specific cookie from browser
		// driver.manage().deleteCookie(cookieObj);
		driver.manage().deleteCookieNamed("MyCookie1");

		cookies = driver.manage().getCookies();
		System.out.println("\nSize of Cookies after deleting: " + cookies.size());

		// How to delete all the cookies from browser
		driver.manage().deleteAllCookies();

		cookies = driver.manage().getCookies();
		System.out.println("\nSize of Cookies after deletion: " + cookies.size());

		Thread.sleep(2000);
		driver.close();
	}
}
