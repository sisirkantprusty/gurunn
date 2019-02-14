package base;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class TestBase {
	public static WebDriver dr;
	Properties configFile = new Properties();
	InputStream inputFile = null;

	protected static ExtentReports extent;
	protected static ExtentTest logger;
	protected static ExtentHtmlReporter reporter;

	@BeforeSuite(alwaysRun = true)
	public void setUpForTestSuite() {
		reporter = new ExtentHtmlReporter(System.getProperty("user.dir") + "\\Reports\\learnauto.html");
		extent = new ExtentReports();
		extent.attachReporter(reporter);

		// logger= extent.createTest("SAMPLE TEST REPORT");
	}

	@Parameters({ "browser" })
	@BeforeTest(alwaysRun = true)
	public void setUpForTest(String browser) {
		extent.setSystemInfo("Browser", browser);
	}

	@AfterSuite(alwaysRun = true)
	public void tearDownForTest() {
		extent.flush();
	}

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
			dr.manage().window().maximize();
			System.out.println("Chrome driver initialized");
		} else if (browser.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver",
					System.getProperty("user.dir") + "\\src\\test\\resources\\geckodriver\\geckodriver.exe");
			dr = new FirefoxDriver();
			dr.manage().window().maximize();
			System.out.println("Firefox driver initialized");
		} else if (browser.equalsIgnoreCase("mobileWeb")) {
			System.setProperty("webdriver.chrome.driver",
					System.getProperty("user.dir") + "\\src\\test\\resources\\chromedriver\\chromedriver.exe");
			Map<String, String> mobileEmulation = new HashMap<String, String>();
			mobileEmulation.put("deviceName", "iPhone X");
			Map<String, Object> chromeOptions = new HashMap<String, Object>();
			chromeOptions.put("mobileEmulation", mobileEmulation);
			DesiredCapabilities capabilities = DesiredCapabilities.chrome();
			capabilities.setCapability(ChromeOptions.CAPABILITY, chromeOptions);
			dr = new ChromeDriver(capabilities);
		}
		dr.get(testUrl);
		Thread.sleep(3000);
		

	}

	@AfterMethod(alwaysRun = true)
	public void tearDownTestMethods(ITestResult result) throws IOException {

		inputFile.close();
		if (result.getStatus() == ITestResult.SUCCESS) {
			logger.log(Status.PASS, "Testcase is PASSED");
		}
		if (result.getStatus() == ITestResult.FAILURE) {
			logger.log(Status.FAIL, "Testcase is failed");
		}
		dr.close();
		System.out.println("Driver is closed");

	}

}
