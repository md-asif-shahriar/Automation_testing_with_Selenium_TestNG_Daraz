package selenium_testing_daraz;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SeleniumAutomationDaraz {
	WebDriver driver;
	
	@BeforeMethod
	public void pre_condition() {
		System.setProperty("webdriver.chrome.driver", "D:\\eclipse-workspace\\SeleniumProject1\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.google.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	}
	
	@Test
	public void verifyDarazFromGoogle() throws InterruptedException
	{
		//verify google title
		String actualTitle = driver.getTitle();
		String expectedTitle = "Google";
		Assert.assertEquals(actualTitle, expectedTitle);
		
		//verify google logo and translate to English
		boolean flag = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/img")).isDisplayed();
		Assert.assertTrue(flag);
		driver.findElement(By.linkText("English")).click();
		Thread.sleep(2000);
	}
	
	@Test
	public void verifyDarazWebsite() throws InterruptedException
	{
		//Go to daraz home
		driver.navigate().to("https://www.daraz.com.bd/");
		Thread.sleep(2000);
	}
	
	@Test
	public void verifyDarazHome() throws InterruptedException
	{
		//Go to daraz home
		
		driver.findElement(By.id("APjFqb")).sendKeys("daraz");
		driver.findElement(By.name("btnK")).click();
		driver.findElement(By.className("LC20lb")).click();
		Thread.sleep(2000);
	}
	
	@Test
	public void verifySearchProduct() throws InterruptedException
	{
		//Search product on daraz
		driver.navigate().to("https://www.daraz.com.bd/");
		driver.findElement(By.id("q")).sendKeys("jisulife fan");
		driver.findElement(By.cssSelector(".search-box__button--1oH7")).click();
		List<WebElement> fans = driver.findElements(By.className("box--ujueT"));
		//Click on the first search result
		fans.get(0).click();
		Thread.sleep(2000);
	}
	
	@Test
	public void verifyAddToCart() throws InterruptedException
	{
		//Add to cart
		driver.navigate().to("https://www.daraz.com.bd/products/jisulife-fa29a-4000mah-i318273598-s1450731064.html?spm=a2a0e.searchlist.list.3.291e4bc4Yd2T5O&search=1");
		driver.findElement(By.cssSelector(".add-to-cart-buy-now-btn")).click();
		Thread.sleep(2000);
	}
	
	@AfterMethod
	public void post_condition() {
		driver.quit();
	}
}
