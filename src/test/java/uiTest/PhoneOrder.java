package uiTest;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class PhoneOrder {

	String url;
	WebDriver driver;

	@Before
	public void prepareTests() {
		url = "http://demo.cs-cart.com";
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Alexandra\\eclipse-workspace\\SiteOrder\\drivers\\chrome\\86\\chromedriver.exe");
		driver = new ChromeDriver();
	}

	@After
	public void finalizeTests() {
		driver.quit();
	}

	@Test
	public void test() {

	}

}
