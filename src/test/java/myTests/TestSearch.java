package myTests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import helpers.Waiters;
import pages.PageIndex;
import pages.PageItems;

public class TestSearch {
	private WebDriver driver;
	private PageIndex pIndex;
	private PageItems pItems;
	
	@BeforeMethod
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to("http://automationpractice.com/index.php");
		pIndex = new PageIndex(driver);
		pItems = new PageItems(driver);
	}
	
	@AfterMethod
	public void tearDown() {
		driver.close();
		driver.quit();
	}
	
	@Test
	public void searchDresses() {
		pIndex.search("DRESSES");
		Waiters.waitForTime(5);
		Assert.assertEquals(pItems.getTitleText(),"\"DRESSES\"");
	}
	
	@Test
	public void searchTSHIRTS() {
		pIndex.search("T-SHIRTS");
		Waiters.waitForTime(2);
		Assert.assertEquals(pItems.getTitleText(),"\"T-SHIRTS\"" );
	}
	
	@Test
	public void searchNoResult() {
		pIndex.search("hello world");
		Waiters.waitForTime(2);
		Assert.assertEquals(pItems.getNotFoundText(),"No results were found for your search \"hello world\"");
	}
}