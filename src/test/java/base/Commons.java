package base;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import pages.PageIndex;
import pages.PageItems;

public class Commons {
	protected WebDriver driver;
	protected PageIndex pIndex;
	protected PageItems pItems;
	
	@BeforeClass
	public void beforeAll() {
		System.out.println("Creando la base de datos...");
		System.out.println("Base de datos creada..");
	}
	
	@AfterClass
	public void afterAll() {
		System.out.println("Borrando base de datos");
		System.out.println("Base de datos eliminada");
	}
	
	@BeforeMethod
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		//options.addArguments("--headless");
		options.addArguments("--incognito");
		//options.addArguments("--disable-gpu");
		options.addArguments("--start-maximized");
		driver = new ChromeDriver(options);
		//driver.manage().window().maximize();
		//driver.manage().window().setSize(new Dimension(400,500));
		/*for(int i = 100;i<500;i++) {
			for(int j=100;j<500;j++) {
				driver.manage().window().setPosition(new Point(i,j));
			}
		}*/
		driver.navigate().to("http://automationpractice.com/index.php");
		pIndex = new PageIndex(driver);
		pItems = new PageItems(driver);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	
	@AfterMethod
	public void tearDown(ITestResult result) {
		System.out.println(result.getStatus());
		System.out.println("El Test "+result.getMethod().getDescription()+" resulta: ");
		if(result.getStatus()==1) {
			System.out.println("PASO EL TEST");
		}else {
			System.out.println("NO PASO EL TEST");
		}
		if(!result.isSuccess()) {
			//Tomar un screenshot
			File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			try {
				FileUtils.copyFile(srcFile,new File("target/surfire-reports/"+result.getMethod().getDescription()+".png"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		driver.close();
		driver.quit();
	}
}
