package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class TestBase {
	WebDriver dr = null;

	@BeforeClass
	public void initializeTest() {
		System.out.println("Open the browser: " + "\n");
		System.setProperty("webdriver.chrome.driver",
				System.getProperty("user.dir") + "\\src\\test\\resources\\chromedriver\\chromedriver.exe");
		System.out.println(System.getProperty("user.dir") + "\\src\\test\\resources\\chromedriver\\chromedriver.exe");
		dr = new ChromeDriver();
		System.out.println("Chrome driver initialized");
	}

	@AfterClass
	public void tearDownTest() {
		dr.close();
		System.out.println("Driver is closed");
	}

}
