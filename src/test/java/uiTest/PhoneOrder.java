package uiTest;

import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class PhoneOrder {

	String url;
	WebDriver driver;
	String prodName;
	String prodTotalPrice;
	String address;
	String email;

	@Before
	public void prepareTests() {
		url = "http://demo.cs-cart.com";
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Alexandra\\eclipse-workspace\\siteDemo\\drivers\\chrome\\86\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(64000, TimeUnit.MICROSECONDS);
		driver.manage().window().maximize();
		prodName = "Wildwood city classic";
		prodTotalPrice = "120.00";
		address = "address test";
		email = "alexandraada@gmail.com";
	}

	@After
	public void finalizeTests() {
		driver.quit();
	}

	@Test
	public void test() throws InterruptedException {
		driver.get(url);
		driver.findElement(By.name("hint_q")).clear();
		driver.findElement(By.name("hint_q")).sendKeys(Keys.chord(prodName));
		driver.findElement(By.className("ty-icon-search")).click();
		driver.findElement(By.xpath("//a[contains(@title,\"" + prodName + "\")]")).click();
		driver.findElement(By.id("button_cart_150")).click();
		Thread.sleep(7000);
		driver.findElement(By.id("sw_dropdown_8")).click();
		Thread.sleep(2000);
		WebElement a = driver.findElement(By.id("dropdown_8"));
		WebElement b = a.findElement(By.className("ty-float-left"));
		b.click();
		assertEquals(prodName, driver.findElement(By.className("ty-cart-content__product-title")).getText());
		assertEquals(prodTotalPrice, driver.findElement(By.id("sec_product_subtotal_1577100463")).getText());
		driver.findElement(By.xpath("//*[@name='checkout_form']"))
				.findElement(By.xpath("//*[text()='Proceed to checkout']")).click();
		Thread.sleep(3000);
		driver.findElement(By.id("litecheckout_s_address")).sendKeys(address);
		driver.findElement(By.id("litecheckout_email")).sendKeys(email);
		driver.findElement(By.id("payments_2")).click();
		Thread.sleep(5000);
		driver.findElement(By.cssSelector("label.cm-check-agreement")).sendKeys(Keys.SPACE);

		Thread.sleep(5000);
	}

}
