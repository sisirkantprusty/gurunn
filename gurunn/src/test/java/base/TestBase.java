package base;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class TestBase {
	public static WebDriver dr;
	Properties configFile = new Properties();
	InputStream inputFile = null;

	@BeforeMethod(alwaysRun = true)
	@Parameters("browser")
	public void initializeTest(String browser) throws InterruptedException, IOException {
		String testUrl = null;

		// Read Properties file

		inputFile = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\test\\resources\\configFiles\\config.properties");
		configFile.load(inputFile);
		ProjectConstants.filePath = configFile.getProperty("SCREENSHOT_FILEPATH").toString();
		System.out.println("FILE PATH " + ProjectConstants.filePath);
		testUrl = configFile.getProperty("URL").toString();
		System.out.println("Open the browser: " + "\n");
		if (browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver",
					System.getProperty("user.dir") + "\\src\\test\\resources\\chromedriver\\chromedriver.exe");
			dr = new ChromeDriver();
			System.out.println("Chrome driver initialized");
		}else if (browser.equalsIgnoreCase("firefox")){
			System.setProperty("webdriver.gecko.driver",
					System.getProperty("user.dir") + "\\src\\test\\resources\\geckodriver\\geckodriver.exe");
			dr = new FirefoxDriver();
			System.out.println("Firefox driver initialized");
		}
		dr.get(testUrl);
		Thread.sleep(3000);
		dr.manage().window().maximize();

	}

	@AfterMethod (alwaysRun=true)
	public void tearDownTest() throws IOException {
		dr.close();
		System.out.println("Driver is closed");
		inputFile.close();
	}

	
	

}
