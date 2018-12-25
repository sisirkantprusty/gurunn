package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

public class TestBase {
	public static WebDriver dr ;

	@BeforeMethod
	public void initializeTest() throws InterruptedException {
		System.out.println("Open the browser: " + "\n");
		System.setProperty("webdriver.chrome.driver",
				System.getProperty("user.dir") + "\\src\\test\\resources\\chromedriver\\chromedriver.exe");
		dr = new ChromeDriver();
		System.out.println("Chrome driver initialized");
		dr.get("http://live.guru99.com/");
		Thread.sleep(3000);
		dr.manage().window().maximize();

	}

	@AfterMethod
	public void tearDownTest() {
		dr.close();
		System.out.println("Driver is closed");
	}

}
